package com.lifebank.lbfavoritessvc.pojo.request;

import org.springframework.http.RequestEntity;

public class UpdateFavoriteEmailOnly {
    private String id;
    private String email;

    public UpdateFavoriteEmailOnly() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
