package com.itms.wikiapp.metric.controller;

import com.itms.wikiapp.metric.model.request.AddMetricRequest;
import com.itms.wikiapp.metric.model.request.UpdateMetricRequest;
import com.itms.wikiapp.metric.model.response.AddMetricResponse;
import com.itms.wikiapp.metric.model.response.MetricDetailResponse;
import com.itms.wikiapp.metric.model.response.MetricResponse;
import com.itms.wikiapp.metric.model.response.UpdateMetricResponse;
import com.itms.wikiapp.metric.service.MetricService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/metric")
public class MetricController {
  private MetricService metricService;

  public MetricController(MetricService metricService) {
    this.metricService = metricService;
  }

  @PostMapping
  public AddMetricResponse add(@RequestBody AddMetricRequest request) {
    return metricService.addMetric(request);
  }

  @GetMapping("/{id}")
  public MetricDetailResponse get(@PathVariable String id) {
    return metricService.getMetric(id);
  }

  @GetMapping
  public List<MetricResponse> list() {
    return metricService.getMetrics();
  }

  @PutMapping("/{id}")
  public UpdateMetricResponse edit(@PathVariable String id, @RequestBody UpdateMetricRequest request) {
    return metricService.updateMetric(id, request);
  }
}