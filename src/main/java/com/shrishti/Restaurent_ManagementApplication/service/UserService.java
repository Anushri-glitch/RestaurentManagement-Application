package com.shrishti.Restaurent_ManagementApplication.service;

import com.shrishti.Restaurent_ManagementApplication.dto.SignInInputA;
import com.shrishti.Restaurent_ManagementApplication.dto.SignInInputN;
import com.shrishti.Restaurent_ManagementApplication.dto.SignUpN;
import com.shrishti.Restaurent_ManagementApplication.dto.SignUpOutput;
import com.shrishti.Restaurent_ManagementApplication.model.Admin;
import com.shrishti.Restaurent_ManagementApplication.model.AuthTokenAdmin;
import com.shrishti.Restaurent_ManagementApplication.model.AuthTokenNormal;
import com.shrishti.Restaurent_ManagementApplication.model.User;
import com.shrishti.Restaurent_ManagementApplication.repository.IAdminDao;
import com.shrishti.Restaurent_ManagementApplication.repository.IUserDao;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    IUserDao userDao;

    @Autowired
    IAdminDao adminDao;

    @Autowired
    AuthServiceNormal authServiceNormal;

    @Autowired
    AuthServiceAdmin authServiceAdmin;


    //SignUp For Normal User
    @Transactional
    public SignUpOutput saveNormalUser(SignUpN signUpDto) {

        //Check that this user is exists or not
        User nUser = userDao.findFirstByUserEmail(signUpDto.getUserEmail());

        if(nUser != null){
            throw new IllegalStateException("User Already Exists!!...Please Make New registration!!!");
        }

        //Encryption
        String encryptedPassword;
        try {
            encryptedPassword = encryptPassword(signUpDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //Save Normal user
        nUser = new User(signUpDto.getUserName(), signUpDto.getUserEmail(), encryptedPassword, signUpDto.getUserContact());
        userDao.save(nUser);

        //token creation and saving
        AuthTokenNormal token = new AuthTokenNormal(nUser);
        authServiceNormal.saveToken(token);

        return new SignUpOutput("Normal User Registered!!!", "User Created Successfully!!!");

    }


    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("md5");
        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }


    //SignUp For Admin user
    public SignUpOutput saveAdminUser(Admin user) {
        Admin aUser = adminDao.findFirstByAdminEmail(user.getAdminEmail());

        if(aUser != null){
            throw new IllegalStateException("Admin User Already Exists!!...Please Make New registration!!!");
        }

        //Encryption
        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(user.getAdminPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //Save Normal user
        aUser = new Admin(user.getAdminUserName(), user.getAdminEmail(), encryptedPassword, user.getAdminPhone());
        adminDao.save(aUser);

        //token creation and saving
        AuthTokenAdmin token = new AuthTokenAdmin(aUser);
        authServiceAdmin.saveToken(token);

        return new SignUpOutput("Admin User Registered!!!", "User Created Successfully!!!");

    }

    //SignIn Of Normal User
    public SignUpOutput signIn(SignInInputN signInDto) {
        //check Email
        User newUser = userDao.findFirstByUserEmail(signInDto.getUserEmail());
        if (newUser == null) {
            throw new IllegalStateException("User Invalid!!!.....Make new registration!!!");
        }

        //encrypt Password
        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signInDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //match it with database encrypted password
        boolean isPasswordValid = encryptedPassword.equals(newUser.getUserPassword());
        if(!isPasswordValid){
            throw new IllegalStateException("User Invalid!!....Signup Again!!");
        }

        //figure out the token
        AuthTokenNormal authToken = authServiceNormal.getToken(newUser);

        //setup output response
        return new SignUpOutput("Authentication Successful!!!", authToken.getToken());
    }

    //SignIn For Admin User
    public SignUpOutput signIn(SignInInputA signInDto) {
        //check Email
        Admin newUser = adminDao.findFirstByAdminEmail(signInDto.getAdminUserEmail());
        if (newUser == null) {
            throw new IllegalStateException("User Invalid!!!.....Make new registration!!!");
        }

        //encrypt Password
        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signInDto.getAdminUPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //match it with database encrypted password
        boolean isPasswordValid = encryptedPassword.equals(newUser.getAdminPassword());
        if(!isPasswordValid){
            throw new IllegalStateException("User Invalid!!....Signup Again!!");
        }

        //figure out the token
        AuthTokenAdmin authToken = authServiceAdmin.getToken(newUser);

        //setup output response
        return new SignUpOutput("Authentication Successful!!!", authToken.getToken());
    }
}
