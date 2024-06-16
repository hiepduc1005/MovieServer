package com.hmovie.vn.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Service
public class JWTGenerator {
	public static final Long ONE_HOUR =  3600000L;
	
	private static final SecretKey KEY = Jwts.SIG.HS512.key().build();
	
	public String gennerateToken(Authentication authentication) {
		String username = authentication.getName();
		
		String token = Jwts.builder()
				.subject(username)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + ONE_HOUR))
				.signWith(KEY)
				.compact();
		System.out.println(token);
		
		return token;
	}
	
	public String getUserNameByJWTToken(String token) {
		String username = Jwts.parser()
				.verifyWith(KEY)
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
		
		System.out.println(username);
		
		return username;
	}
	
	public boolean checkValidToken(String token) {
		try {
			Jwts.parser()
			.verifyWith(KEY)
			.build()
			.parseSignedClaims(token);
			return true;
		} catch (Exception e) {
			System.out.println("Invalid jwt token " + e.getMessage()  );
			return false;
		}
		
	}
	
	
	
}
