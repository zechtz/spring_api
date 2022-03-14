package com.watabelabs.api.exceptions;

/** SpringRedditException */
public class SpringApiException extends RuntimeException {
  public SpringApiException(String exMessage, Exception exception) {
    super(exMessage, exception);
  }

  public SpringApiException(String exMessage) {
    super(exMessage);
  }
}
