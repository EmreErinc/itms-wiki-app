package com.itms.wikiapp.metric.service.impl;

import com.itms.wikiapp.metric.model.entity.MetricEntity;
import com.itms.wikiapp.metric.model.request.AddMetricRequest;
import com.itms.wikiapp.metric.model.request.UpdateMetricRequest;
import com.itms.wikiapp.metric.model.response.AddMetricResponse;
import com.itms.wikiapp.metric.model.response.MetricDetailResponse;
import com.itms.wikiapp.metric.model.response.MetricResponse;
import com.itms.wikiapp.metric.model.response.UpdateMetricResponse;
import com.itms.wikiapp.metric.repo.MetricRepository;
import com.itms.wikiapp.metric.service.MetricService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MetricServiceImpl implements MetricService {
  private MetricRepository metricRepository;

  public MetricServiceImpl(MetricRepository metricRepository) {
    this.metricRepository = metricRepository;
  }

  @Override
  public AddMetricResponse addMetric(AddMetricRequest request) {
    MetricEntity metricEntity = MetricEntity.builder()
        .name(request.getName())
        .uuid(UUID.randomUUID())
        .goal(request.getGoal())
        .measurementType(request.getMeasurementType())
        .measurementPeriod(request.getMeasurementPeriod())
        .createdAt(Instant.now().getEpochSecond())
        .updatedAt(Instant.now().getEpochSecond())
        .build();

    MetricEntity savedMetricEntity = metricRepository.save(metricEntity);

    return AddMetricResponse.builder()
        .id(savedMetricEntity.getUuid().toString())
        .name(savedMetricEntity.getName())
        .goal(savedMetricEntity.getGoal())
        .measurementType(savedMetricEntity.getMeasurementType())
        .measurementPeriod(savedMetricEntity.getMeasurementPeriod())
        .build();
  }

  @Override
  public MetricDetailResponse getMetric(String metricId) {
    MetricEntity foundMetricEntity = metricRepository.findByUuid(UUID.fromString(metricId));

    return MetricDetailResponse.builder()
        .id(foundMetricEntity.getUuid().toString())
        .name(foundMetricEntity.getName())
        .goal(foundMetricEntity.getGoal())
        .measurementType(foundMetricEntity.getMeasurementType())
        .measurementPeriod(foundMetricEntity.getMeasurementPeriod())
        .build();
  }

  @Override
  public List<MetricResponse> getMetrics() {
    return metricRepository.findAll()
        .stream()
        .map(metricEntity -> MetricResponse.builder()
            .id(metricEntity.getUuid().toString())
            .name(metricEntity.getName())
            .goal(metricEntity.getGoal())
            .build())
        .collect(Collectors.toList());
  }

  @Override
  public UpdateMetricResponse updateMetric(String metricId, UpdateMetricRequest request) {
    MetricEntity foundMetricEntity = metricRepository.findByUuid(UUID.fromString(metricId));

    return UpdateMetricResponse.builder()
        .id(foundMetricEntity.getUuid().toString())
        .name(request.getName())
        .goal(request.getGoal())
        .measurementType(request.getMeasurementType())
        .measurementPeriod(request.getMeasurementPeriod())
        .build();
  }
}