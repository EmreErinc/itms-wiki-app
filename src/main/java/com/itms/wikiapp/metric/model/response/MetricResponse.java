package com.itms.wikiapp.metric.model.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MetricResponse {
  String id;
  String name;
  String goal;
}
