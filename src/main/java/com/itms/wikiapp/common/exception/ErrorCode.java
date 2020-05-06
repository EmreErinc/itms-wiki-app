package com.itms.wikiapp.common.exception;

public interface ErrorCode {
  String getMessage();

  ErrorType getErrorType();
}
