/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.seguridad;

import com.web.controlparapiezas.VariablesDeEntorno;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/**
 *
 * @author HP
 */
public class Token implements Supplier<String>{
    
    //Es para poder generar el token

    private static final VariablesDeEntorno variables = new VariablesDeEntorno();
    
    private static final int LEFT_LIMIT = variables.getLEFT_LIMIT();
    private static final int RIGHT_LIMIT = variables.getRIGHT_LIMIT();
    static final int SIZE = variables.getSIZE();
    
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
