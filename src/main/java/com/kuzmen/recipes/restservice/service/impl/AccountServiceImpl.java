package com.kuzmen.recipes.restservice.service.impl;


import com.kuzmen.recipes.restservice.entity.User;
import com.kuzmen.recipes.restservice.entity.UserRole;
import com.kuzmen.recipes.restservice.repository.UserRepository;
import com.kuzmen.recipes.restservice.service.AccountService;
import com.kuzmen.recipes.restservice.service.UserManagementService;
import com.kuzmen.recipes.restservice.util.PasswordEncryption;
import com.kuzmen.recipes.restservice.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
@Transactional
@ComponentScan("com.kuzmen.recipes.restservice.util")
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserManagementService userManagementService;
    @Autowired
    PasswordEncryption encryption;

    public ResponseMessage registerUser(String name, String password, String email) {
        if (!name.isEmpty() && !password.isEmpty() && !email.isEmpty()) {
            ResponseMessage registerUserMessage = new ResponseMessage();
            //месаджи в логине
            if (checkUserExist(email)) {
                registerUserMessage.setResult(ResponseMessage.RESULT_FAILURE);
                registerUserMessage.setMessage(ResponseMessage.MSG_FAILURE_USER_EXIST);
                return registerUserMessage;
            } else {
                String token = addUser(name, password, email);
                registerUserMessage.setResult(ResponseMessage.RESULT_SUCCESS);
                registerUserMessage.setMessage(ResponseMessage.MSG_SUCCESS_REGISTRED);
                registerUserMessage.setToken(token);
                return registerUserMessage;
            }
        } else {
            return getMessageParamsEmpty();
        }
    }

    public ResponseMessage loginUser(String email, String password) {
        ResponseMessage loginResponseMessage = new ResponseMessage();
        if (!email.isEmpty() && !password.isEmpty()) {

            if (checkUserExist(email)) {
                String token = checkPassword(email, password);
                if (token != null) {
                    loginResponseMessage.setResult(ResponseMessage.RESULT_SUCCESS);
                    loginResponseMessage.setMessage(ResponseMessage.MSG_SUCCESS_LOGGED_IN);
                    loginResponseMessage.setToken(token);
                    return loginResponseMessage;
                } else {
                    loginResponseMessage.setResult(ResponseMessage.RESULT_FAILURE);
                    loginResponseMessage.setMessage(ResponseMessage.MSG_FAILURE_LOGIN);
                    return loginResponseMessage;
                }
            } else {
                loginResponseMessage.setResult(ResponseMessage.RESULT_FAILURE);
                loginResponseMessage.setMessage(ResponseMessage.MSG_FAILURE_LOGIN);
                return loginResponseMessage;
            }
        } else {
            return getMessageParamsEmpty();
        }
    }

    public ResponseMessage changePassword(String email, String oldPassword, String newPassword) {
        ResponseMessage changePasswordMessage = new ResponseMessage();

        User user = userManagementService.getByEmail(email);
        if (user != null) {
            String token = checkPassword(email, oldPassword);
            if (token != null) {
                String newToken = encryption.getHash(newPassword);
                user.setToken(newToken);
                userRepository.save(user);

                changePasswordMessage.setResult(ResponseMessage.RESULT_SUCCESS);
                changePasswordMessage.setMessage(ResponseMessage.MSG_SUCCESS_PASSWORD_CHANGED);
                changePasswordMessage.setToken(newToken);
                return changePasswordMessage;
            } else {
                changePasswordMessage.setResult(ResponseMessage.RESULT_FAILURE);
                changePasswordMessage.setMessage(ResponseMessage.MSG_FAILURE_LOGIN);
                return changePasswordMessage;
            }

        } else {
            changePasswordMessage.setResult(ResponseMessage.RESULT_FAILURE);
            changePasswordMessage.setMessage(ResponseMessage.MSG_FAILURE_LOGIN);
            return changePasswordMessage;
        }
    }


    private String addUser(String name, String password, String email) {
        User user = new User();
        String token = encryption.getHash(password);
        user.setToken(token);
        user.setEmail(email);
        user.setName(name);
        user.setRole(UserRole.USER);
        userRepository.save(user);
        return token;
    }

    private String checkPassword(String email, String password) {
        User user = userManagementService.getByEmail(email);
        if (encryption.verifyHash(password, user.getToken())) {
            return user.getToken();
        } else {
            return null;
        }

    }

    private boolean checkUserExist(String email) {
        User user = userManagementService.getByEmail(email);
        if (user != null) {
            return true;
        } else
            return false;
    }

    private ResponseMessage getMessageParamsEmpty() {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setResult(ResponseMessage.RESULT_FAILURE);
        responseMessage.setMessage(ResponseMessage.MSG_FAILURE_PARAMETRES_EMPTY);
        return responseMessage;
    }


}
