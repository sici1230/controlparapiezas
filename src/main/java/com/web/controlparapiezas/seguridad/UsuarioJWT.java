/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.controlparapiezas.seguridad;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.web.controlparapiezas.VariablesDeEntorno;
import com.web.controlparapiezas.entidades.Usuarios;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class UsuarioJWT {
    
    private static final VariablesDeEntorno variables = new VariablesDeEntorno();
    
    //Para crear el token
    private static final Logger LOGGER = Logger.getLogger(UsuarioJWT.class.getName());
    private static final String ISSUER = variables.getISSUER();
    private static final String ROLES = variables.getROLES();

    private String user;

    private String roles;

    private Date fechaExpiracion;


    public UsuarioJWT(String user, String roles, Date fechaExpiracion) {
        this.user = user;
        this.roles = roles;
        this.fechaExpiracion = fechaExpiracion;
    }

    public UsuarioJWT() {
    }
    
    public String crearToken(Usuarios usuario, Token token, Duration duration) {
        final LocalDateTime expire = LocalDateTime.now(ZoneOffset.UTC).plusMinutes(duration.toMinutes());
        Algorithm algorithm = Algorithm.HMAC256(token.getToken());
        return JWT.create()
                .withJWTId(usuario.getNombre())
                .withIssuer(ISSUER)
                .withExpiresAt(Date.from(expire.atZone(ZoneOffset.UTC).toInstant()))
                .withClaim(ROLES, usuario.getRol())
                .sign(algorithm);
    }

    public String actualizarToken(Usuarios usuario, Token token, Duration duration) {
        return crearToken(usuario, token, duration);
    }

    public Optional<UsuarioJWT> convertir(String jwtText, Token token) {
        Algorithm algorithm = Algorithm.HMAC256(token.getToken());
        try {
            //Revisar que pasa cuando no se manda correctamente el token
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
            final DecodedJWT jwt = verifier.verify(jwtText);
            final Claim roles = jwt.getClaim(ROLES);
            return Optional.of(new UsuarioJWT(jwt.getId(),
                    roles.asString(), jwt.getExpiresAt()));
        } catch (JWTVerificationException exp) {
            System.out.println("Error " + exp.getMessage());
//            LOGGER.log(Level.WARNING, "There is an error to load the JWT token");
            return Optional.empty();
        }
    }

    public String getUser() {
        return user;
    }

    public String getRoles() {
        return roles;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }
}
