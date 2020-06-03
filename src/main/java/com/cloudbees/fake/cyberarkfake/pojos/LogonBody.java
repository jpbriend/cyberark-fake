package com.cloudbees.fake.cyberarkfake.pojos;

public class LogonBody {
  private String username;
  private String password;
  private String newPassword;
  private String concurrentSession;

  public LogonBody() {}

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public String getConcurrentSession() {
    return concurrentSession;
  }

  public void setConcurrentSession(String concurrentSession) {
    this.concurrentSession = concurrentSession;
  }
}
