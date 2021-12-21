package com.ibm.bbsrv.utils.jwtutils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.bbsrv.controller.BbsApiController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class jwtUtil {

	private static final Logger logger = LoggerFactory.getLogger(jwtUtil.class);

	private static String SECRET_KEY = "secret";

	public static void main(String args[]) {

		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0NTY3ODkxMjM0NTMwIiwicm9sZSI6W3siYXV0aG9yaXR5IjoiSE9TUElUQUxfQURNSU4ifV0sImNpdHlOYW1lIjoic3RyaW5nIiwiaG9zcGl0YWxJZCI6InN0cmluZyIsInBpbkNvZGUiOiJzdHJpbmciLCJob3NwaXRhbEJyYW5jaElkIjoic3RyaW5nIiwiZXhwIjoxNjI4Njk1NjQ5LCJpYXQiOjE2Mjg2ODg0NDl9.x_5I129kY0FD4JteXZjbOVqUtTCiIg96iZ7Fjj-mAvE";

		//getFieldFromToken("pinCode", token);
		System.out.println(getGuardianIDFromToken(token));

	}

	public static void getRoleFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
		System.out.println(((Map<String, Object>) ((ArrayList) claims.get("role")).get(0)).get("authority"));
	}

	public static String getFieldFromToken(String field, String token) {
		Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();

		return claims.get(field).toString();
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	public Claims extractAllClaims(String token){
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

	public String extractUserName(String token){
		return extractClaim(token, Claims::getSubject);
	}

	public Set<String> extractRole(String token){
		Claims claims = extractAllClaims(token);
		List<LinkedHashMap<String, String>> grantedAuthorities = (List<LinkedHashMap<String, String>>) claims.get("role");
        return grantedAuthorities.stream().map(grantedAuthority -> grantedAuthority.getOrDefault("authority", ""))
				.collect(Collectors.toSet());
	}

	public Date extractExpiration(String token){
		return extractClaim(token, Claims::getExpiration);
	}

	public Boolean isTokenExpired(String token){
		return extractExpiration(token).before(new Date());
	}

	public Boolean validateRole(String role, String xTokenID){
		Boolean ret=false;
		try {
			Set<String> roles = extractRole(xTokenID);
			ret=roles.contains(role) && !isTokenExpired(xTokenID);
		}catch(ExpiredJwtException ejwt) {
			logger.error("Token Expired: "+ejwt);
			throw ejwt;
		}
		logger.info("validateRole: "+ret);
		return ret;
	}

	public static String getGuardianIDFromToken(String token) {
		Base64.Decoder decoder = Base64.getDecoder();
		String guardianId =null;
		if (token != null) {
			String[] Tokenchunks = token.split("\\.");
			String header = new String(decoder.decode(Tokenchunks[0]));
			String payload = new String(decoder.decode(Tokenchunks[1]));

			JSONObject jsonObject = new JSONObject(payload);
			guardianId=jsonObject.getString("sub");
		}
		return guardianId;
	}

}
