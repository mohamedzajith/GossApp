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
            if (session.getValueByKey("category")=="cinema"){
                BasicDBObject ins = new BasicDBObject("Phone_no",moUssdReq.getSourceAddress())
                        .append("language",session.getValueByKey("language"))
                        .append("subscriptin","true")
                        .append("category", new BasicDBObject(session.getValueByKey("category"), session.getValueByKey("cinema")));
                WriteResult result = coll.insert(ins);
            }else if (session.getValueByKey("category")=="politics"){
                BasicDBObject ins = new BasicDBObject("Phone_no",moUssdReq.getSourceAddress())
                        .append("language",session.getValueByKey("language"))
                        .append("subscriptin","true")
                        .append("category", new BasicDBObject(session.getValueByKey("category"), session.getValueByKey("politics")));
                WriteResult result = coll.insert(ins);
            }else if (session.getValueByKey("category")=="sport"){
                BasicDBObject ins = new BasicDBObject("Phone_no",moUssdReq.getSourceAddress())
                        .append("language",session.getValueByKey("language"))
                        .append("subscriptin","true")
                        .append("category", new BasicDBObject(session.getValueByKey("category"), session.getValueByKey("sport")));
                WriteResult result = coll.insert(ins);
            }


            return "Finish";
        }else return "Subsciption";
    }

}
