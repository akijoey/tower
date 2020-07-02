package com.akijoey.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoUtil {

    public static MongoClient getClient() {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        return new MongoClient("193.112.128.94", 27017);
    }

    public static MongoCollection<Document> getCollection() {
        return getClient().getDatabase("tower").getCollection("archive");
    }

    public static void insert(String json) {
        getCollection().insertOne(Document.parse(json));
    }

    public static void update(String query, String json) {
        getCollection().replaceOne(Document.parse(query), Document.parse(json));
    }

    public static String find(String query) {
        return getCollection().find(Document.parse(query)).first().toJson();
    }

}
