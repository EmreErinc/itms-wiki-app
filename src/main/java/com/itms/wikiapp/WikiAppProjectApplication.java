package com.itms.wikiapp;

import com.itms.wikiapp.metric.repo.MetricRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = MetricRepository.class)
public class WikiAppProjectApplication {
  public static void main(String[] args) {
    SpringApplication.run(WikiAppProjectApplication.class, args);
  }
}