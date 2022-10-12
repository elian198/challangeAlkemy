package com.challangeAlkemy.controllers;

import com.challangeAlkemy.entities.User;
import com.challangeAlkemy.repository.UserRepositorio;
import com.challangeAlkemy.security.jwt.JwtTokenUtil;
import com.challangeAlkemy.security.payload.JwtResponse;
import com.challangeAlkemy.security.payload.LoginRequest;
import com.challangeAlkemy.security.payload.MessageResponse;
import com.challangeAlkemy.security.payload.RegisterRequest;
import com.challangeAlkemy.service.email.EmailService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Controlador para llevar a cabo la autenticación utilizando JWT
 *
 * Se utiliza AuthenticationManager para autenticar las credenciales que son el
 * usuario y password que llegan por POST en el cuerpo de la petición
 *
 * Si las credenciales son válidas se genera un token JWT como respuesta
 */
// @CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private EmailService  emailService;

    private final AuthenticationManager authManager;
    private final UserRepositorio userRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenUtil jwtTokenUtil;


    public AuthController(EmailService emailService, AuthenticationManager authManager, UserRepositorio userRepository
            , PasswordEncoder encoder, JwtTokenUtil jwtTokenUtil) {
        this.emailService = emailService;
        this.authManager = authManager;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping(value = "/login")
    @ApiOperation("Comprueba que el usuario y password enviados sea los correctos")
    @ApiParam("nombre,  passowrd")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getNombre(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(authentication);
        System.out.println(new JwtResponse(jwt));
         UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    /**
     * TODO falta terminar el register
     * @param signUpRequest
     * @return
     */
    @PostMapping(value = "/register")
    @ApiOperation("Permite crear nuevos usuarios, envian nombre , email, password, si esta todo ok envia un correo de bienvenida")
    @ApiParam("nombre , email, password")
    public ResponseEntity<MessageResponse> register(@RequestBody RegisterRequest signUpRequest) throws IOException {

        if(userRepository.existsByUsername(signUpRequest.getNombre()) !=null){
            return ResponseEntity.badRequest().body(new MessageResponse("El usuario ya existe!!! elija otro nombre"));
        }

        if(userRepository.existEmail(signUpRequest.getEmail()) !=null){
            return ResponseEntity.badRequest().body(new MessageResponse("El email ingresado ya existe!!! elija otro nombre"));
        }
        User user = new User(signUpRequest.getNombre(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);

        emailService.send("elianpareja5@gmail.com",signUpRequest.getEmail(),"Alta de usuario", emailService.mensaje(signUpRequest.getNombre()));

        return ResponseEntity.ok(new MessageResponse("Usuario creado exitosamente!"));
    }
}
