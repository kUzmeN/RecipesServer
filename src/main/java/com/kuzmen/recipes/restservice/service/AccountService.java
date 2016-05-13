package com.kuzmen.recipes.restservice.service;


import com.kuzmen.recipes.restservice.entity.User;
import com.kuzmen.recipes.restservice.util.ResponseMessage;

public interface AccountService {
    ResponseMessage registerUser(String name, String password , String email);
    ResponseMessage loginUser(String email,String password);
    ResponseMessage changePassword(String email , String oldPassword , String newPassword);

}
