package com.dev.resources;

import com.dev.domain.dto.JwtResponseDTO;
import com.dev.domain.dto.AlunoDTO;
import com.dev.security.JwtTokenUtil;
import com.dev.services.JwtUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthResource {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<JwtResponseDTO> createAuthenticationToken(@RequestBody AlunoDTO authenticationRequest) throws Exception {        
        final UserDetails userDetails = jwtService.loadUserByUsername(authenticationRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponseDTO(token));
    }
}