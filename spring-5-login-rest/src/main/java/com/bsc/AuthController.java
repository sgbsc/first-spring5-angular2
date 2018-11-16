package com.bsc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserRepositoryService userRepository;

	@Autowired
	TokenService tokenService;
	
	@GetMapping("/private")
	public ResponseEntity<?> privateEndPoint(@RequestParam(required=false, value="token") String token){
		if(tokenService.isValid(token)) {
			return new ResponseEntity<>("I'm a private endpoint", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user){
		if(userRepository.isAuthorized(user)) {
			return new ResponseEntity<>(tokenService.create(user), HttpStatus.OK);
		}
		return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logot(@RequestParam(required=false, value="token") String token){
		tokenService.delete(token);
		return new ResponseEntity<>("delete", HttpStatus.OK);
	}	
}
