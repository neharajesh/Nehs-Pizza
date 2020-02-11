/*package controller;

import java.util.HashSet;
import java.util.Set;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.User;
import enums.UserRoles;
import entities.Roles;
import http.request.Login;
import http.request.SignUp;
import http.response.JwtResponse;
import repositories.UserRepository;
import repositories.RoleRepository;
import security.jwt.JwtProvider;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
 
    @Autowired
    AuthenticationManager authenticationManager;
 
    @Autowired
    UserRepository userRepository;
 
    @Autowired
    RoleRepository roleRepository;
 
    @Autowired
    PasswordEncoder encoder;
 
    @Autowired
    JwtProvider jwtProvider;
 
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
        if(userRepository.existsByPhno(signUpRequest.getPhno())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
 
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }
 
        // Creating user's account
        User user = new User().new Builder()
                .setFirstName(signUpRequest.getFirstName())
                .setLastName(signUpRequest.getLastName())
                .setPhno(signUpRequest.getPhno())
                .setEmail(signUpRequest.getEmail())
                .setPassword(encoder.encode(signUpRequest.getPassword()))
                .build();
        
        User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(),
                signUpRequest.getPhno(),signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
 
        Set<UserRoles> strRoles = signUpRequest.getRole();
        Set<Roles> roles = new HashSet<>();
 
        strRoles.forEach(role -> {
          switch(role) {
          case MANAGER:
            Roles managerRole = roleRepository.findByName(UserRoles.MANAGER)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
            roles.add(managerRole);
            
            break;
          case GENERAL:
                Roles generalRole = roleRepository.findByName(UserRoles.GENERAL)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
                roles.add(generalRole);
                
            break;
          case DELIVERY:
              Roles deliveryRole = roleRepository.findByName(UserRoles.DELIVERY)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
              roles.add(deliveryRole);
              
          break;
          default:
        	  Roles userRole = roleRepository.findByName(UserRoles.USER)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
              roles.add(userRole);              
          }
        });
        
        user.setRoles(roles);
        userRepository.save(user);
 
        return ResponseEntity.ok().body("User registered successfully!");
    }
}*/