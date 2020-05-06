package com.itms.wikiapp.common.exception;

public enum ErrorType {
  NOT_FOUND_EXCEPTION(404),
  ALREADY_EXISTS_EXCEPTION(409),
  DB_ERROR_EXCEPTION(500);

  private int statusCode;

  ErrorType(int statusCode) {
    this.statusCode = statusCode;
  }

  public int getStatusCode() {
    return statusCode;
  }
}
