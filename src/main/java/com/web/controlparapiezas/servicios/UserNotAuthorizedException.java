/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.servicios;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author HP
 */
public class UserNotAuthorizedException extends RuntimeException{
    
    private String message;

    public UserNotAuthorizedException(String message) {
        super(message);
        this.message = message;
    }

    public UserNotAuthorizedException() {
        this.message = "User not authorized";
    }

    public List<String> getMessages() {
        return Collections.singletonList(message);
    }
}
