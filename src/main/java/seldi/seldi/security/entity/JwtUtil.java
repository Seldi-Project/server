package seldi.seldi.security.entity;

import io.jsonwebtoken.security.Keys;

import java.security.Key;

/**
 * JWT를 생성하고 검증하는 역할
 */
public class JwtUtil {

    private Key key;

    public JwtUtil(String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes())
    }
}
