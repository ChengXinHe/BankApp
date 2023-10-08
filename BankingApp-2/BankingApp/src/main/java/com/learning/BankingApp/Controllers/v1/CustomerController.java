package com.learning.BankingApp.Controllers.v1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springjwt.models.ERole;
import com.demo.springjwt.models.Role;
import com.demo.springjwt.models.User;
import com.demo.springjwt.payload.request.SignupRequest;
import com.demo.springjwt.payload.response.MessageResponse;
import com.learning.BankingApp.Common.constants.Roles;
import com.learning.BankingApp.Repository.CustomerRepository;
//
//@RequestMapping("api/customer/")
//public class  {
//		
//	@PostMapping("/register")
//	private Optional<Customer> saveCustomer(@RequestBody @Validated )
//}
import com.learning.BankingApp.Utils.jwt.JwtUtils;
import com.learning.BankingApp.jwt.payload.LoginRequest;
import com.learning.BankingApp.service.CustomerServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/authenticate")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    System.out.println("JWT Token="+jwt);
    
    CustomerServiceImpl customerDetails = (CustomerServiceImpl) authentication.getPrincipal();    
    List<String> roles = customerDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         customerDetails.getId(), 
                         customerDetails.getUsername(), 
                         customerDetails.getEmail(), 
                         roles));
  }
  
  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (customerRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (customerRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new customer's account
    Customer cust = new Customer(signUpRequest.getUsername(), 
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role customerRole = roleRepository.findByName(Roles.ROLE_CUSTOMER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(customerRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(Roles.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "mod":
          Role staffRole = roleRepository.findByName(Roles.ROLE_STAFF)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(staffRole);

          break;
        default:
          Role customerRole = roleRepository.findByName(Roles.ROLE_CUSTOMER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(customerRole);
        }
      });
    }

    cust.setRoles(roles);
    customerRepository.save(cust);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}
