package axolotl.spring.AxolotlDB.controller;


import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import axolotl.spring.AxolotlDB.config.JwtFilter;
import axolotl.spring.AxolotlDB.model.Token;
import axolotl.spring.AxolotlDB.model.Clientes;
import axolotl.spring.AxolotlDB.service.ClientesService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
@RequestMapping(path="/api/Login/")

public class LoginController {

	private final ClientesService clientesService;
	@Autowired
	public LoginController(ClientesService clientesService) {
		this.clientesService = clientesService;
	}//constructor

	@PostMapping
	public Token login (@RequestBody Clientes clientes) throws ServletException {
		if (clientesService.validaClientes(clientes)) {
			return new Token(generateToken(clientes.getEmail_cliente()));
		}//if
		throw new ServletException("Nombre de usuario o contraseña incorrectos");
	}//login
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 10);
		return Jwts.builder().setSubject(username).claim("role", "user")
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
	}// generateToken



}//class LoginController
