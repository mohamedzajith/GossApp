package com.tap.app;

/**
 * Created by dba on 6/9/15.
 */

import com.mongodb.*;
import hms.tap.api.ussd.messages.MoUssdReq;
import hms.tap.ussd.manager.Session;
import hms.tap.ussd.manager.ValueHolder;
import hms.tap.ussd.manager.annotations.Config;
import hms.tap.ussd.manager.menu.Menu;

import java.util.Arrays;

@Config(id="Subsciption")
public class ConformationMenu implements Menu{
//    public DB dbconn = connection.conn();
//    public DBCollection coll = dbconn.getCollection("user");
    @Override
    public String getMessage(Session session, MoUssdReq moUssdReq) {
        return "Goss-App\nChoose Category\n 1. Conform\n";
    }

    @Override
    public String getNextMenu(Session session, MoUssdReq moUssdReq) {
        String category = moUssdReq.getMessage();
        session.getValueHolders().add(new ValueHolder("category", category));

        if(category.equals("1")){
            DB dbconn = connection.conn();
            DBCollection coll = dbconn.getCollection("user");

                String ls = null;String ci = null;String po = null;String sp = null;
                BasicDBObject query = new BasicDBObject();
                BasicDBObject select = new BasicDBObject();
                select.put("Phone_no",1);
                DBCursor cursor = coll.find(query,select);
                while (cursor.hasNext()){
                    BasicDBObject obj = (BasicDBObject)cursor.next();
                    ls=obj.getString("Phone_no");
                    ci="cinema";
                    po="politics";
                    sp="sport";
                    if (ls.equals(moUssdReq.getSourceAddress()) && ci.equals(session.getValueByKey("category"))){
                        WriteResult result = coll.update(new BasicDBObject("Phone_no",moUssdReq.getSourceAddress()),
                                new BasicDBObject("$addToSet",new BasicDBObject(session.getValueByKey("category"), session.getValueByKey("cinema"))));
                    }else if (ls.equals(moUssdReq.getSourceAddress()) && po.equals(session.getValueByKey("category"))){
                        WriteResult result = coll.update(new BasicDBObject("Phone_no",moUssdReq.getSourceAddress()),
                                new BasicDBObject("$addToSet",new BasicDBObject(session.getValueByKey("category"), session.getValueByKey("politics"))));
                    }else if (ls.equals(moUssdReq.getSourceAddress()) && sp.equals(session.getValueByKey("category"))){
                        WriteResult result = coll.update(new BasicDBObject("Phone_no",moUssdReq.getSourceAddress()),
                                new BasicDBObject("$addToSet",new BasicDBObject(session.getValueByKey("category"), session.getValueByKey("sport"))));
                    }/*else if (!ls.equals(moUssdReq.getSourceAddress())){
                        if (session.getValueByKey("category")=="cinema"){
                            BasicDBObject ins = new BasicDBObject("Phone_no",moUssdReq.getSourceAddress())
                                    .append("language",session.getValueByKey("language"))
                                    .append("subscriptin","true")
                                    .append(session.getValueByKey("category"), Arrays.asList(session.getValueByKey("cinema")));
                            WriteResult result = coll.insert(ins);
                        }else if (session.getValueByKey("category")=="politics"){
                            BasicDBObject ins = new BasicDBObject("Phone_no",moUssdReq.getSourceAddress())
                                    .append("language",session.getValueByKey("language"))
                                    .append("subscriptin","true")
                                    .append(session.getValueByKey("category"), Arrays.asList(session.getValueByKey("politics")));
                            WriteResult result = coll.insert(ins);
                        }else if (session.getValueByKey("category")=="sport"){
                            BasicDBObject ins = new BasicDBObject("Phone_no",moUssdReq.getSourceAddress())
                                    .append("language",session.getValueByKey("language"))
                                    .append("subscriptin","true")
                                    .append(session.getValueByKey("category"), Arrays.asList(session.getValueByKey("sport")));
                            WriteResult result = coll.insert(ins);
                        }
                    }*/
                }


            if (session.getValueByKey("category")=="cinema"){
                BasicDBObject ins = new BasicDBObject("Phone_no",moUssdReq.getSourceAddress())
                        .append("language",session.getValueByKey("language"))
                        .append("subscriptin","true")
                        .append(session.getValueByKey("category"), Arrays.asList(session.getValueByKey("cinema")));
                WriteResult result = coll.insert(ins);
            }else if (session.getValueByKey("category")=="politics"){
                BasicDBObject ins = new BasicDBObject("Phone_no",moUssdReq.getSourceAddress())
                        .append("language",session.getValueByKey("language"))
                        .append("subscriptin","true")
                        .append(session.getValueByKey("category"), Arrays.asList(session.getValueByKey("politics")));
                WriteResult result = coll.insert(ins);
            }else if (session.getValueByKey("category")=="sport"){
                BasicDBObject ins = new BasicDBObject("Phone_no",moUssdReq.getSourceAddress())
                        .append("language",session.getValueByKey("language"))
                        .append("subscriptin","true")
                        .append(session.getValueByKey("category"), Arrays.asList(session.getValueByKey("sport")));
                WriteResult result = coll.insert(ins);
            }
            return "Finish";
        }else return "Subsciption";
    }

}
