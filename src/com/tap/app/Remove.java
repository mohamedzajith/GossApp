package com.tap.app;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import hms.tap.api.ussd.messages.MoUssdReq;
import hms.tap.ussd.manager.Session;
import hms.tap.ussd.manager.ValueHolder;
import hms.tap.ussd.manager.annotations.Config;
import hms.tap.ussd.manager.menu.Menu;

/**
 * Created by dba on 6/12/15.
 */

@Config(id="Remove")
public class Remove implements Menu {
    @Override
    public String getMessage(Session session, MoUssdReq moUssdReq) {
        DB dbconn = connection.conn();
        DBCollection coll = dbconn.getCollection("user");

        BasicDBObject query = new BasicDBObject();
        query.put("Phone_no",moUssdReq.getSourceAddress());
        DBCursor cursor = coll.find(query);
        while (cursor.hasNext()) {
            BasicDBObject obj = (BasicDBObject) cursor.next();
            return "Dear user you have chosen \n1. Cinema\n2. Politics\n3. Sports\n";
        }
        return "Dear user there is no Subscriptions";
    }

    @Override
    public String getNextMenu(Session session, MoUssdReq moUssdReq) {
        String category = moUssdReq.getMessage();
        if(category.equals("1")){
            session.getValueHolders().add(new ValueHolder("Myprofile", "cinema"));
            return "Addmore";
        } else if(category.equals("2")){
            session.getValueHolders().add(new ValueHolder("Myprofile", "politics"));
            return "Remove";
        } else return "Myprofile";
    }
}