package axolotl.spring.AxolotlDB.config;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;


public class JwtFilter extends GenericFilter{

	public static final String secret = "CH21-dramaticos-unid0s-inf13l3s#RBDvsBTS";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authHeader =  httpServletRequest.getHeader("authorization");
		if (  ("POST".equals(httpServletRequest.getMethod())) ||
				( ("GET".equals(httpServletRequest.getMethod())) && 
						(! httpServletRequest.getRequestURI().contains("/api/actividades/") )  ) ||
			  ("PUT".equals(httpServletRequest.getMethod())) ||
			  ("DELETE".equals(httpServletRequest.getMethod()))
			) {
				if  ( authHeader ==null || !authHeader.startsWith("Bearer: ") ) {
					throw new ServletException("1. Invalid Token");
				}// if authHedaer

				String token = authHeader.substring(7);
				try {
				Claims claims = Jwts.parser().setSigningKey(secret)
						.parseClaimsJws(token).getBody();
				claims.forEach((key, value)->{
					System.out.println("key: " + key + " value: " + value);
				});
			}catch (SignatureException | MalformedJwtException | ExpiredJwtException  e) {
					throw new ServletException("2. Invalid Token.");
				}//catch 
		}// if methods

		chain.doFilter(request, response);


}
		
	

}//class JwtFilter