package com.itms.wikiapp.common.config;

import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by emre on 19.03.2020
 */
@Configuration
public class MongoConfig {

  private final Environment env;

  public MongoConfig(Environment env) {
    this.env = env;
  }

  @Bean
  public MongoDbFactory mongoDbFactory() {
    return new SimpleMongoDbFactory(new MongoClientURI(env.getProperty("spring.data.mongodb.uri")));
  }

  @Bean
  public MongoTemplate mongoTemplate() {
    MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
    return mongoTemplate;
  }
}