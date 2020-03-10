package security.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import entities.User;
import repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    UserRepository userRepository;
 
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
      
        User user = userRepository.findByEmail(email)
                  .orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + email)
        );
 
        return UserPrinciple.build(user);
    }
    
    /*public UserDetails loadUserByPhno(String phno){
    	User user = userRepository.findByPhno(phno)
    			.orElseThrow(() - >
    			new RecordNotFoundException("User not found with phone number : "+phno)
    			);
    }*/
}