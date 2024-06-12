package com.marraigemate.vendorsearchservice.repository;


import com.marraigemate.vendorsearchservice.collection.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, String>, MongoCustomAggregateRepository {
}
