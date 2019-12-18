package com.rest.application.entity;

import java.util.Objects;

public class Conference {
  private long id;
  private String subject;
  private String readerName;

  public Conference(long id, String subject, String readerName) {
    this.id = id;
    this.subject = subject;
    this.readerName = readerName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getReaderName() {
    return readerName;
  }

  public void setReaderName(String readerName) {
    this.readerName = readerName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Conference that = (Conference) o;
    return id == that.id &&
        Objects.equals(subject, that.subject) &&
        Objects.equals(readerName, that.readerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, subject, readerName);
  }
}
