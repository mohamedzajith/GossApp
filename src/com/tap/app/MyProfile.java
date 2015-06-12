package com.tap.app;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import hms.tap.api.ussd.messages.MoUssdReq;
import hms.tap.ussd.manager.Session;
import hms.tap.ussd.manager.annotations.Config;
import hms.tap.ussd.manager.menu.Menu;

/**
 * Created by dba on 6/12/15.
 */

@Config(id="Myprofile")
public class MyProfile implements Menu {
    @Override
    public String getMessage(Session session, MoUssdReq moUssdReq) {
        DB dbconn = connection.conn();
        DBCollection coll = dbconn.getCollection("user");

        BasicDBObject query = new BasicDBObject();
        query.put("Phone_no",moUssdReq.getSourceAddress());
        DBCursor cursor = coll.find(query);
        while (cursor.hasNext()) {
            BasicDBObject obj = (BasicDBObject) cursor.next();
            String ci = obj.getString("cinema");
            String po = obj.getString("politics");
            String sp = obj.getString("sport");
            System.out.println(ci);
            return "Dear user you have chosen \n Cinema\n " +ci + " \nPolitics\n" +po + "\nSports\n" + sp + "\n1. Add more \n2. Remove";
        }
        return "Dear user there is no Subscriptions";
    }

    @Override
    public String getNextMenu(Session session, MoUssdReq moUssdReq) {
//        String category = moUssdReq.getMessage();
//        if(category.equals("1")){
//            session.getValueHolders().add(new ValueHolder("category", "cinema"));
//            return "Cinema";
//        } else if(category.equals("2")){
//            session.getValueHolders().add(new ValueHolder("category", "politics"));
//            return "Politics";
//        } else if (category.equals("3")){
//            session.getValueHolders().add(new ValueHolder("category", "sport"));
//            return "Sport";
//        }
//        else
        return null;
    }
}