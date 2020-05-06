package com.itms.wikiapp.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CustomErrorResponse {
  LocalDateTime time = LocalDateTime.now();
  String message;
  int statusCode;
}
