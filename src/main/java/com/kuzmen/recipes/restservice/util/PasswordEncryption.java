package com.kuzmen.recipes.restservice.util;

import org.springframework.context.annotation.Bean;


public interface PasswordEncryption {

    String getHash(String password);

    Boolean verifyHash(String password, String hash);
}
