package com.itms.wikiapp.common.model;

public enum TopicType {
  VEHICLE("vhc"),
  STATION("stt"),
  TEST("test");

  private String type;

  TopicType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
