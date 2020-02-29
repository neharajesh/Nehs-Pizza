package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import beans.UserDTO;
import enums.UserRoles;
import exceptions.RecordNotFoundException;
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
	 
	 @GetMapping("/")
	 public String index(Model model) {
		 return "index";
	 }
	 
	
	@PostMapping("/signin")
    public String authenticateUser(@Valid @RequestBody Login loginRequest) throws RecordNotFoundException {
 
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getPhno(),
                        loginRequest.getPassword()
                )
        );
 
        SecurityContextHolder.getContext().setAuthentication(authentication);
 
        String jwt = jwtProvider.generateJwtToken(authentication);
        ResponseEntity.ok(new JwtResponse(jwt));
        
        UserDTO user = userService.findUserByPhno(loginRequest.getPhno());
        UserRoles userType = user.getUserType();
        
        String view = "";
        switch (userType) {
        	case MANAGER :
        		view = "managerDashboard";
        	case GENERAL :
        		view = "generalDashboard";
        	case DELIVERY :
        		view = "deliveryDashboard";
        	case USER :
        		view = "userDashboard";
        }
        
        return view;
    }
	
	
	@PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUp signUpRequest) {
        if(userService.checkByPhno(signUpRequest.getPhno())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        else if(userService.checkByEmail(signUpRequest.getEmail())) {
        	return new ResponseEntity<String>("Fail -> Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        else{
        	userService.addNewUser(signUpRequest);
        	return new ResponseEntity<String>("User registered successfully!", HttpStatus.OK);
        }
	}
	
	//after login, go to user/usertype specific page
	/*@RequestMapping*/
}
