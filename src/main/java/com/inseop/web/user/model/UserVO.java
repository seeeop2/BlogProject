package com.inseop.web.user.model;


public class UserVO {
  
  private String uid;
  private String pwd;
  
  public String getUid() {
    return uid;
  }
  public void setUid(String uid) {
    this.uid = uid;
  }
  public String getPwd() {
    return pwd;
  }
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
  
  
  @Override
  public String toString() {
    return "UserVO [uid=" + uid + ", pwd=" + pwd + "]";
  }
  
  
  
  
}
