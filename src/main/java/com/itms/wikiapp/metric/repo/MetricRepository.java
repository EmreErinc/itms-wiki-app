package com.itms.wikiapp.metric.repo;

import com.itms.wikiapp.metric.model.entity.MetricEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MetricRepository extends MongoRepository<MetricEntity, ObjectId> {

  MetricEntity findByUuid(UUID uuid);
}
