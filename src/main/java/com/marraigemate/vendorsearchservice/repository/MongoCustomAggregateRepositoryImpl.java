package com.marraigemate.vendorsearchservice.repository;

import com.marraigemate.vendorsearchservice.collection.SearchResult;
import com.marraigemate.vendorsearchservice.exception.MongoDBAggregateQueryException;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MongoCustomAggregateRepositoryImpl implements MongoCustomAggregateRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<SearchResult> findFuzzyMatches(String search) {
        Document autocomplete = new Document("query", search)
                .append("path", "name")
                .append("fuzzy", new Document("maxEdits", 2)
                        .append("prefixLength", 2)
                        .append("maxExpansions", 100));

        Document searchOperationDoc = new Document("index", "name_fuzzy_search")
                .append("autocomplete", autocomplete);
        Document searchQuery = new Document("$search", searchOperationDoc);
        try {
            MongoDatabase db = mongoTemplate.getDb();
            MongoCollection<Document> collection = db.getCollection("vendor");

            AggregateIterable<Document> result = collection.aggregate(Arrays.asList(searchQuery, new Document("$limit", 5), new Document("$project", new Document("id", 1).append("name", 1))));

            List<SearchResult> searchResults = new ArrayList<>();
            for(Document document : result) {
                SearchResult searchResult = new SearchResult();
                searchResult.setId(document.get("_id").toString());
                searchResult.setName(document.getString("name"));
                searchResults.add(searchResult);
            }
            return searchResults;
        } catch (Exception e) {
            throw new MongoDBAggregateQueryException("Error while executing fuzzy search :" + e.getMessage()+ Arrays.toString(e.getStackTrace()));
        }
    }
}
