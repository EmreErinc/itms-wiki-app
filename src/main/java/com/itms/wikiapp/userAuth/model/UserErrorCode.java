package com.itms.wikiapp.userAuth.model;

import com.itms.wikiapp.common.exception.ErrorCode;
import com.itms.wikiapp.common.exception.ErrorType;

public enum UserErrorCode implements ErrorCode {
  NOT_FOUND(ErrorType.NOT_FOUND_EXCEPTION, "Can not find given user information"),
  ALREADY_EXISTS(ErrorType.ALREADY_EXISTS_EXCEPTION, "Given user already exists");

  private String message;
  private ErrorType type;

  UserErrorCode(ErrorType type, String message) {
    this.type = type;
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }

  @Override
  public ErrorType getErrorType() {
    return type;
  }
}
