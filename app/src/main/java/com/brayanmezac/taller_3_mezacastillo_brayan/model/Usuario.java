package com.brayanmezac.taller_3_mezacastillo_brayan.model;
public class Usuario {
    String user, password;
    int id;

    public Usuario() {
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public boolean isNull(){
        if(user.equals("")&&password.equals("")){
            return false;
        }else {
            return true;
        }
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(final String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }
}
