package com.ourMenu.backend.global.util;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final SecretKey secretKey;

    public String createToken(long userId, int validHour) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + (validHour * 3600000L));

        return Jwts.builder()
                .setIssuedAt(now)
                .setExpiration(validity)
                .claim("userId", userId)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public long getUserId(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey).build()
                    .parseClaimsJws(token);
            Object userId = claims.getBody().get("userId");

            if(userId instanceof Integer) {
                return ((Integer) userId).longValue();
            } else if (userId instanceof Long) {
                return (Long) userId;
            } else {
                throw new JwtException("");
            }
        } catch(JwtException | IllegalArgumentException e) {
            throw new JwtException("");
        }
    }

    public boolean isValidToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);

            return !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

}
