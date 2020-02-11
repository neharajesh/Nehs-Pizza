package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import http.request.Login;
import http.request.SignUp;
import http.response.JwtResponse;
import security.jwt.JwtProvider;
import service.UserService;

@RestController
public class LoginController {
	
	 @Autowired
	 private AuthenticationManager authenticationManager;
	 
	 @Autowired
	 private JwtProvider jwtProvider;
	 
	 @Autowired
	 private UserService userService;
	
	@PostMapping("/signin")
	    public ResponseEntity<?> authenticateUser(@Valid @RequestBody Login loginRequest) {
	 
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginRequest.getPhno(),
	                        loginRequest.getPassword()
	                )
	        );
	 
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	 
	        String jwt = jwtProvider.generateJwtToken(authentication);
	        return ResponseEntity.ok(new JwtResponse(jwt));
	    }
	
	
	@PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUp signUpRequest) {
        if(userService.checkByPhno(signUpRequest.getPhno())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        else{
        	userService.addNewUser(signUpRequest);
        	return new ResponseEntity<String>("User registered successfully!", HttpStatus.OK);
        }
	}
}
