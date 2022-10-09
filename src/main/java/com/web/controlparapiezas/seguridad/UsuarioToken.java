/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.seguridad;

/**
 *
 * @author HP
 */
public class UsuarioToken {
    private String username;

    private Token token;

    public Token generateToken() {
        Token token = Token.generate();
        if (token == null) {
            this.token = new Token("");
        }
        this.token = token;
        return token;
    }
}
