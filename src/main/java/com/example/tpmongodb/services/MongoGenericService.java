package com.example.tpmongodb.services;

import com.mongodb.Function;
import com.mongodb.client.*;
import org.bson.Document;

public class MongoGenericService {
    protected MongoDatabase database;
    protected MongoCollection<Document> collection;

    protected MongoClient getMongoClient() {
        return MongoClients.create("mongodb://root:test.123@localhost:27017/?authSource=admin");
    }

    protected  <T> T inTx(Function<MongoCollection<Document>, T> toExecute, String collectionName) {
        MongoClient mongoClient = this.getMongoClient();
        database = mongoClient.getDatabase("mongodbblogs");
        collection = database.getCollection(collectionName);
        try {
            T t = toExecute.apply(collection);
            return t;
        } catch (Exception e) {
            throw e;
        } finally {
            mongoClient.close();
        }
    }

}
