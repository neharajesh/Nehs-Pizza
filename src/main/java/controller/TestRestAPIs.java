package controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestAPIs {
  
  @GetMapping("/api/test/user")
  @PreAuthorize("hasRole('USER')")
  public String userAccess() {
    return ">>> User Contents!";
  }
  
  @GetMapping("/api/test/general")
  @PreAuthorize("hasRole('general') or hasRole('MANAGER')")
  public String generalAccess() {
    return ">>> Board Management Project";
  }
  
  @GetMapping("/api/test/manager")
  @PreAuthorize("hasRole('MANAGER')")
  public String managerAccess() {
    return ">>> Admin Contents";
  }
  
  @GetMapping("/api/test/delivery")
  @PreAuthorize("hasRole('DELIVERY') or hasRole('MANAGER')")
  public String deliveryAccess() {
    return ">>> Admin Contents";
  }
}