package com.cloudbees.fake.cyberarkfake.pojos;

public class GetPasswordBody {
  private String reason;
  private String TicketingSystemName;
  private String TicketId;
  private String Version;
  private String ActionType;
  private String isUse;
  private String Machine;

  public GetPasswordBody() {}

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getTicketingSystemName() {
    return TicketingSystemName;
  }

  public void setTicketingSystemName(String ticketingSystemName) {
    TicketingSystemName = ticketingSystemName;
  }

  public String getTicketId() {
    return TicketId;
  }

  public void setTicketId(String ticketId) {
    TicketId = ticketId;
  }

  public String getVersion() {
    return Version;
  }

  public void setVersion(String version) {
    Version = version;
  }

  public String getActionType() {
    return ActionType;
  }

  public void setActionType(String actionType) {
    ActionType = actionType;
  }

  public String getIsUse() {
    return isUse;
  }

  public void setIsUse(String isUse) {
    this.isUse = isUse;
  }

  public String getMachine() {
    return Machine;
  }

  public void setMachine(String machine) {
    Machine = machine;
  }
}
