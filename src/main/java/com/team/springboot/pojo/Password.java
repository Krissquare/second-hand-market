package com.team.springboot.pojo;

public class Password {
    private String u_Password;
    private String newPassword;
    private String newPasswordAgain;
    private String u_Account;
    public String getU_Password() {
        return u_Password;
    }

    public String getU_Account() {
        return u_Account;
    }

    public void setU_Account(String u_Account) {
        this.u_Account = u_Account;
    }

    public void setU_Password(String u_Password) {
        this.u_Password = u_Password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordAgain() {
        return newPasswordAgain;
    }

    public void setNewPasswordAgain(String newPasswordAgain) {
        this.newPasswordAgain = newPasswordAgain;
    }

    public Password() {

    }

    public Password(String u_Password, String newPassword, String newPasswordAgain) {
        this.u_Password = u_Password;
        this.newPassword = newPassword;
        this.newPasswordAgain = newPasswordAgain;
    }
}
