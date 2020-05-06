package com.itms.wikiapp.common.exception;

import com.itms.wikiapp.common.exception.types.AlreadyExistsException;
import com.itms.wikiapp.common.exception.types.InternalServerException;
import com.itms.wikiapp.common.exception.types.NotFoundException;

public class ErrorHandlerFactory {
  public Exception newException(ErrorCode errorCode) {
    switch (errorCode.getErrorType()) {
      case NOT_FOUND_EXCEPTION:
        return new NotFoundException(errorCode.getMessage());
      case ALREADY_EXISTS_EXCEPTION:
        return new AlreadyExistsException(errorCode.getMessage());
      default:
        return new InternalServerException(errorCode.getMessage());
    }
  }
}