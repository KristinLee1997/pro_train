package com.kristin.java.mongodb;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/6/21 8:44
 * @desc
 **/
public class MongoDBDemo {
    public static void createCollection(String name) {    //  创建集合
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        mongoDatabase.createCollection(name);
//	    System.out.println("Collection "+name+" created.");
        mongoClient.close();
    }

    public static void insertMany(String name) {    //  插入文档集合
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = mongoDatabase.getCollection(name);

        for (int i = 1; i <= 5; i++) {
            Document document = new Document("x", 3).
                    append("j", i);
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
        }
        for (int i = 3; i <= 7; i++) {
            Document document = new Document("x", 4).
                    append("j", i);
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
        }
        for (int i = 6; i <= 10; i++) {
            Document document = new Document("x", 5).
                    append("j", i);
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);
        }

//	    System.out.println("Insert Successfully.");
        mongoClient.close();
    }

    public static void collectionFindAll(String name) {    //  检索所有文档
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = mongoDatabase.getCollection(name);
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
        mongoClient.close();
    }

    public static void collectionFind(String name) {    //  检索特定文档
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = mongoDatabase.getCollection(name);
        FindIterable<Document> findIterable = collection.find(new Document("x", 4));  //  相等
//        FindIterable<Document> findIterable = collection.find(new Document("x", new Document("$ne", 4)));  //  不相等
//        FindIterable<Document> findIterable = collection.find(Filters.gt("x", 4));  //  大于
//        FindIterable<Document> findIterable = collection.find(new Document("x", new Document("$gte", 4)));  //  大于等于
//        FindIterable<Document> findIterable = collection.find(Filters.lt("x", 4));  //  小于
//        FindIterable<Document> findIterable = collection.find(new Document("x", new Document("$lte", 4)));  //  小于等于
//        FindIterable<Document> findIterable = collection.find(new Document("x", 4).append("j", 5));  //  且
//        FindIterable<Document> findIterable = collection.find(Filters.or(Filters.eq("x", 4), Filters.eq("j", 5)));  //  或
//        FindIterable<Document> findIterable = collection.find(Filters.in("x", 3, 4));  //  存在
//        FindIterable<Document> findIterable = collection.find(Filters.nin("x", 3, 4));  //  不存在
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
        mongoClient.close();
    }

    public static int collectionCount(String name) {    //  检索所有文档
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = mongoDatabase.getCollection(name);
        int count = Integer.valueOf(String.valueOf(collection.count()));
        mongoClient.close();
        return count;
    }


    public static void insertOne(String name, String key, String value) {    //  插入单个文档
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = mongoDatabase.getCollection(name);
        Document document = new Document(key, value);
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        collection.insertMany(documents);
//	    System.out.println("Insert Successfully.");
        mongoClient.close();
    }

    public static void updateOne(String name, String key, String old_value, String new_value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = mongoDatabase.getCollection(name);
        //  更新
        collection.updateMany(Filters.eq(key, old_value), new Document("$set", new Document(key, new_value)));
//	    System.out.println("Update Successfully.");
        //  查看更新结果
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
        mongoClient.close();
    }

    public static void deleteDocument(String name, String key, String value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = mongoDatabase.getCollection(name);
        // 删除
        collection.deleteOne(Filters.eq(key, value));  //删除符合条件的第一个文档
//	    collection.deleteMany (Filters.eq(key, va1lue));  //删除所有符合条件的文档
        //  查看删除结果
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
        mongoClient.close();
    }

    public static void limitResults(String name, int limit) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("test");
        DBCollection dbCollection = db.getCollection(name);
        BasicDBObject query = new BasicDBObject("x", new BasicDBObject("$lt", 6));
        DBCursor dbCursor = dbCollection.find(query);
        dbCursor.limit(limit);
        while (dbCursor.hasNext()) {
            System.out.println(dbCursor.next());
        }
        mongoClient.close();
    }

    public static void projectionResults(String name) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("test");
        DBCollection dbCollection = db.getCollection(name);
        BasicDBObject query = new BasicDBObject("x", new BasicDBObject("$lte", 5));
        BasicDBObject fieldDoc = new BasicDBObject();
        fieldDoc.append("x", true);
        fieldDoc.append("j", true);
        fieldDoc.append("_id", false);
        DBCursor dbCursor = dbCollection.find(query, fieldDoc);
        while (dbCursor.hasNext()) {
            System.out.println(dbCursor.next());
        }
        mongoClient.close();
    }

    public static void pagingResults(String name, int skip) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("test");
        DBCollection dbCollection = db.getCollection(name);
        BasicDBObject query = new BasicDBObject("x", new BasicDBObject("$lte", 5));
        DBCursor dbCursor = dbCollection.find(query);
        //过滤条件
        dbCursor.sort(new BasicDBObject("x", 1));    //数据集按"x"字段进行正序排序.
        dbCursor.limit(6);     //限制返回条数.
        dbCursor.skip(skip);    //跳过前面指定数量的数据

        while (dbCursor.hasNext()) {
            DBObject dbObject = dbCursor.next();
            System.out.println(dbObject);
        }
        mongoClient.close();
    }

    public static void groupingResults(String name, int value) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("test");
        DBCollection dbCollection = db.getCollection(name);
        DBObject unwind = new BasicDBObject("$unwind", "$x");
        DBObject groupFields = new BasicDBObject("_id", new BasicDBObject("x", "$x"));
        groupFields.put("Average", new BasicDBObject("$avg", "$x"));
        DBObject group = new BasicDBObject("$group", groupFields);
        AggregationOutput output = dbCollection.aggregate(unwind, group);  // 执行 aggregation命令
        for (DBObject i : output.results()) {
            System.out.println(i);
        }
        mongoClient.close();
    }

    public static void Aggregation(String name) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("test");
        DBCollection dbCollection = db.getCollection(name);
        String reduce = "function(doc, aggr){"
                + "aggr.count += 1;"
                + "        }";
        DBObject result = dbCollection.group(new BasicDBObject("x", 1), new BasicDBObject(), new BasicDBObject("count", 0), reduce);
        System.out.println(result);
        mongoClient.close();
    }

    public static void main(String[] args) {
        createCollection("thing");
    }
}
