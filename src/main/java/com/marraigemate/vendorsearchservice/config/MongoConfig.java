package com.marraigemate.vendorsearchservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(
                new SimpleMongoClientDatabaseFactory(
                        "mongodb+srv://root:123@vendorsearchcluster.dfwudmj.mongodb.net/vendor_search?retryWrites=true&w=majority&appName=VendorSearchCluster"
                )
        );
    }
}
