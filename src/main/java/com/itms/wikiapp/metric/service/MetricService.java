package com.itms.wikiapp.metric.service;


import com.itms.wikiapp.metric.model.request.AddMetricRequest;
import com.itms.wikiapp.metric.model.request.UpdateMetricRequest;
import com.itms.wikiapp.metric.model.response.AddMetricResponse;
import com.itms.wikiapp.metric.model.response.MetricDetailResponse;
import com.itms.wikiapp.metric.model.response.MetricResponse;
import com.itms.wikiapp.metric.model.response.UpdateMetricResponse;

import java.util.List;

public interface MetricService {
  AddMetricResponse addMetric(AddMetricRequest request);

  MetricDetailResponse getMetric(String metricId);

  List<MetricResponse> getMetrics();

  UpdateMetricResponse updateMetric(String metricId, UpdateMetricRequest request);
}
