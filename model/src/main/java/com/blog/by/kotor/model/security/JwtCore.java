package com.blog.by.kotor.model.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtCore {

    private final static Logger LOGGER = LoggerFactory.getLogger(JwtCore.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.lifetime}")
    private long lifetime;

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + lifetime))
                .signWith(getSigningKey())
                .compact();
    }

    public String getNameFromJwt(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().verifyWith(getSigningKey()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            LOGGER.error("Неверный формат jwt токена {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (ExpiredJwtException e) {
            LOGGER.error("Jwt токен истёк: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        } catch (UnsupportedJwtException e) {
            LOGGER.error("Неподдерживаемый jwt токен: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Пустой jwt токен: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
