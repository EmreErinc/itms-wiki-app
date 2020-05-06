package com.itms.wikiapp.metric.model.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateMetricRequest {
  String name;
  String goal;
  String measurementType;
  String measurementPeriod;
}
