package com.maxi.backapporder.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

 /*@Autowired
 //@Qualifier("authenticationManagerBean")
 private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationManager authenticationManagerBean;

    @Autowired
    private LoginRepository loginRepository;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthDTO authDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authDTO.username(), authDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();
    }

   @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody @Valid LoginDTO loginDTO){
        if(this.loginRepository.findByUsername(loginDTO.username()) != null) return ResponseEntity.badRequest().build();

        String encriptPassword = new BCryptPasswordEncoder().encode(loginDTO.password());
        Login login = new Login(null, loginDTO.username(), encriptPassword, loginDTO.role());
        loginRepository.save(login);

        return ResponseEntity.ok().body(login);
    }*/
    
}
