package com.blog.blogappapi.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenHelper {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    private String secret = "jwtTokenKey";

    public String getUserNameFromToken(String token) {

        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);

    }

    public <T> T getClaimFromToken(String token, Function<Claims,T> claimResolver){

        final Claims claims = getAllClaimsFromToken(token);
        return claimResolver.apply(claims);
    }

    public Claims getAllClaimsFromToken(String token){

        return Jwts
        		.parserBuilder()
        		.setSigningKey(getSignInKey())
        		.build()
        		.parseClaimsJws(token)
        		.getBody();
    }

    private Boolean isTokenExpired(String token){

        final Date expiration = getExpirationFromToken(token);

        return expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails){

        Map<String,Object> claims = new HashMap<>();
        return doGenerateToken(claims,userDetails);

    }

    public String doGenerateToken(Map<String,Object> claims, UserDetails userDetails){
    	return Jwts
    				.builder()
    				.setClaims(claims)
    				.setSubject(userDetails.getUsername())
    				.setIssuedAt(new Date(System.currentTimeMillis()))
    				.setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
    				.signWith(getSignInKey(),SignatureAlgorithm.HS256)
    				.compact();
       }

    public Boolean validateToken(String token, UserDetails userDetails)
    {
        final String username = getUserNameFromToken(token);

        return (username.equals(userDetails.getUsername()) && ! isTokenExpired(token));
        
    }
    private Key getSignInKey() {
    	byte[] keyBytes=Decoders.BASE64.decode(secret);
    	return Keys.hmacShaKeyFor(keyBytes);
		
	}
}
