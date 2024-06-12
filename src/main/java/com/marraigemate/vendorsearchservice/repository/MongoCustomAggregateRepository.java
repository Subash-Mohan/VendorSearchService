package com.marraigemate.vendorsearchservice.repository;

import com.marraigemate.vendorsearchservice.collection.SearchResult;

import java.util.List;

public interface MongoCustomAggregateRepository {
    public List<SearchResult> findFuzzyMatches(String search);
}
