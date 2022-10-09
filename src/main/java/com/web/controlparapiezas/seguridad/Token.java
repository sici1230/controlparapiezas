/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.seguridad;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/**
 *
 * @author HP
 */
public class Token implements Supplier<String>{
    
    //Es para poder generar el token

    private static final int LEFT_LIMIT = 48;
    private static final int RIGHT_LIMIT = 122;
    static final int SIZE = 32;
    
    private final String token;
    
    @Override
    public String get() {
        return token;
    }
    
    public Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
    
    public static Token generate() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        String token = random.ints(LEFT_LIMIT, RIGHT_LIMIT + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(SIZE)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return new Token(token);
    }
}
