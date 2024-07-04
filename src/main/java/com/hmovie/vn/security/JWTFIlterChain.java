package com.hmovie.vn.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hmovie.vn.exception.AuthenticationException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component

public class JWTFIlterChain extends OncePerRequestFilter{
	
	@Autowired
	public CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	public JWTGenerator jwtGenerator;
	
	 @Override
	 protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	         throws ServletException, IOException {
		 String requestUrl = request.getRequestURI();
		 if(requiresAuthentication(requestUrl)) {		 
			 try {
				 String token = getTokenFromHeader(request);
				 boolean check = jwtGenerator.checkValidToken(token);
				 if (StringUtils.hasText(token) && check) {
					 String username = jwtGenerator.getUserNameByJWTToken(token);
					 
					 UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
					 
					 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
							 new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
					 
					 usernamePasswordAuthenticationToken.setDetails(
							 new WebAuthenticationDetailsSource().buildDetails(request));
					 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				 }
			 } catch (AuthenticationException ex) {
				 response.setStatus(HttpStatus.UNAUTHORIZED.value());
				 response.getWriter().write(ex.getMessage());
				 return;
			 }
		 }

	     filterChain.doFilter(request, response);
	 }
	
	public String getTokenFromHeader(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if(StringUtils.hasText(header) && header.startsWith("Bearer ")) {
			return header.substring(7);
		}
		
		return "";
	}
	
	 private boolean requiresAuthentication(String requestURI) {
	        return requestURI.startsWith("/api/v1/watchlist/") || 
	        		requestURI.startsWith("/api/v1/watch-history/") || 
	        		requestURI.startsWith("/api/v1/user/");
	    }

}
