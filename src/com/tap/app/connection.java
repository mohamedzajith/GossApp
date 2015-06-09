package com.tap.app;

/**
 * Created by dba on 6/9/15.
 */
import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

public class connection {
    public static DB conn(){
        try {
            MongoClient mongoClient = new MongoClient();
            DB dbtest = mongoClient.getDB("gossip");
            return dbtest;

        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}
