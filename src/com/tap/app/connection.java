package com.tap.app;

/**
 * Created by dba on 6/9/15.
 */

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;

public class connection {

    public static DB conn(){
        try {
//            MongoClient mongoClient = new MongoClient();
//            DB dbtest = mongoClient.getDB("gossip");
            String textUri = "mongodb://zajith:zajith@ds045632.mongolab.com:45632/gossip";
            MongoClientURI uri = new MongoClientURI(textUri);
            MongoClient mongoClient = new MongoClient(uri);
            DB dbtest = mongoClient.getDB("gossip");
            return dbtest;

        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}
