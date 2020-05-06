package com.itms.wikiapp.metric.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "metrics")
public class MetricEntity {
  @Id
  private ObjectId id;
  private UUID uuid;
  private String name;
  private String goal;
  private String measurementType;
  private String measurementPeriod;
  private Long createdAt;
  private Long updatedAt;
}
