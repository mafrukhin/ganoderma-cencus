package com.halo.profileui.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PASPC-02009 on 04/08/2016.
 */
public class User {

    private String UserName;
    @SerializedName("UserID")
    @Expose
    private String UserID;
    @SerializedName("UserFullName")
    @Expose
    private String UserFullName;
    private String UserStatus;
    private String ApprovalID;
    private String CurrentEstate;
    private String AndroidId;
    private String ExpirationDate;
    private List<Estate> Estates = new ArrayList<Estate>();
    //private List<UserModuleAccess> UserModuleAccess = new ArrayList<>();


    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        this.UserName = userName;
    }
    public String getUserID() {
        return UserID;
    }
    public String getUserFullName() {
        return UserFullName;
    }
    public void setUserFullName(String userFullName) {
        this.UserFullName = userFullName;
    }
    public String getUserStatus() {
        return UserStatus;
    }
    public void setUserStatus(String userStatus) {
        this.UserStatus = userStatus;
    }
    public String getApprovalID() {
        return ApprovalID;
    }
    public void setApprovalID(String approvalID) {
        this.ApprovalID = approvalID;
    }
    public String getCurrentEstate() {
        return CurrentEstate;
    }
    public void setCurrentEstate(String currentEstate) {
        this.CurrentEstate = currentEstate;
    }
    public String getAndroidId() {
        return AndroidId;
    }
    public void setAndroidId(String androidId) {
        this.AndroidId = androidId;
    }
    public String getExpirationDate() {
        return ExpirationDate;
    }
    public void setExpirationDate(String expirationDate) {
        this.ExpirationDate = expirationDate;
    }
    public List<Estate> getEstates() {
        return Estates;
    }
    public void setEstates(List<Estate> estates) {
        this.Estates = estates;
    }


}