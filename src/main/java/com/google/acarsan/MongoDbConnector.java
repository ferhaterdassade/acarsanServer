package com.google.acarsan;
import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created by ferhat on 4/2/2015.
 */
public class MongoDbConnector {

    private DB db;

    public MongoDbConnector(){
        try {

            /**** Connect to MongoDB ****/
            // Since 2.10.0, uses MongoClient
            MongoClient mongo = new MongoClient("localhost", 27017);

            /**** Get database ****/
            // if database doesn't exists, MongoDB will create it for you
            db = mongo.getDB("acarsan");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public DBCursor find(String tableName, String searchId, String searchString){
        DBCollection table = db.getCollection(tableName);

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put(searchId, searchString);


        DBCursor cursor = table.find(searchQuery);
        return cursor;
    }



}
