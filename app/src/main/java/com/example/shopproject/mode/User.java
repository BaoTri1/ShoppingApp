package com.example.shopproject.mode;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private String _id;
    private String name;
    private String email;
    private boolean isAdmin;
    private String token;
    private List<com.example.shopproject.mode.favorites> favorites;

    public User(String _id, String name, String email, boolean isAdmin, String token) {
        this._id = _id;
        this.name = name;
        this.email = email;
        this.isAdmin = isAdmin;
        this.token = token;
    }

    public User(String _id, String name, String email, boolean isAdmin, String token, List<com.example.shopproject.mode.favorites> favorites) {
        this._id = _id;
        this.name = name;
        this.email = email;
        this.isAdmin = isAdmin;
        this.token = token;
        this.favorites = favorites;
    }

    public List<com.example.shopproject.mode.favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<com.example.shopproject.mode.favorites> favorites) {
        this.favorites = favorites;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
