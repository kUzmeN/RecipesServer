package com.kuzmen.recipes.restservice.entity;


import java.io.Serializable;

public enum UserRole implements Serializable {

    ADMIN,
    SUPER_USER,
    USER;

    UserRole() {
    }
}
