package com.inf1013.example1.backend.services.implementation;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class HashingService {
    
    public static String hashPassword(String password) {
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            BigInteger number = new BigInteger(1, hash);
            StringBuilder hexString = new StringBuilder(number.toString(16));

            while (hexString.length() < 32) {
                hexString.insert(0, '0');
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password));
    }
}