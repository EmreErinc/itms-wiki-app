package com.itms.wikiapp.userAuth.service.impl;

import com.itms.wikiapp.common.exception.ErrorHandlerFactory;
import com.itms.wikiapp.common.security.JwtTokenUtil;
import com.itms.wikiapp.common.security.JwtUserDetailsService;
import com.itms.wikiapp.userAuth.model.UserErrorCode;
import com.itms.wikiapp.userAuth.model.entity.UserAuthEntity;
import com.itms.wikiapp.userAuth.model.req.LoginRequest;
import com.itms.wikiapp.userAuth.model.req.RegisterRequest;
import com.itms.wikiapp.userAuth.model.res.LoginResponse;
import com.itms.wikiapp.userAuth.model.res.RegisterResponse;
import com.itms.wikiapp.userAuth.repository.UserAuthRepository;
import com.itms.wikiapp.userAuth.service.UserAuthService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
public class UserAuthServiceImpl implements UserAuthService {

  private final UserAuthRepository userAuthRepository;
  private final AuthenticationManager authenticationManager;
  private final JwtTokenUtil jwtTokenUtil;
  private final JwtUserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;

  public UserAuthServiceImpl(UserAuthRepository userAuthRepository,
                             AuthenticationManager authenticationManager,
                             JwtTokenUtil jwtTokenUtil,
                             JwtUserDetailsService userDetailsService,
                             PasswordEncoder passwordEncoder) {
    this.userAuthRepository = userAuthRepository;
    this.authenticationManager = authenticationManager;
    this.jwtTokenUtil = jwtTokenUtil;
    this.userDetailsService = userDetailsService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public RegisterResponse register(RegisterRequest request) throws Exception {

    Optional<UserAuthEntity> optionalUserAuthEntity = userAuthRepository.findByEmail(request.getEmail());

    if (optionalUserAuthEntity.isPresent()) {
      throw new ErrorHandlerFactory().newException(UserErrorCode.ALREADY_EXISTS);
    }

    UserAuthEntity userAuthEntity = UserAuthEntity.builder()
        .name(request.getName())
        .surname(request.getSurname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .build();

    UserAuthEntity savedUserEntity = userAuthRepository.save(userAuthEntity);

    final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
    final String token = jwtTokenUtil.generateToken(userDetails);

    return RegisterResponse.builder()
        .name(savedUserEntity.getName())
        .surname(savedUserEntity.getSurname())
        .email(savedUserEntity.getEmail())
        .token(token)
        .build();
  }

  @Override
  public LoginResponse login(LoginRequest request) throws Exception {

    Optional<UserAuthEntity> foundUserEntity = userAuthRepository.findByEmail(request.getEmail());

    if (!foundUserEntity.isPresent()) {
      throw new ErrorHandlerFactory().newException(UserErrorCode.NOT_FOUND);
    }

    if (!passwordEncoder.matches(request.getPassword(), foundUserEntity.get().getPassword())) {
      throw new ErrorHandlerFactory().newException(UserErrorCode.NOT_FOUND);
    }

    final UserDetails userDetails = userDetailsService.loadUserByUsername(foundUserEntity.get().getEmail());
    final String token = jwtTokenUtil.generateToken(userDetails);

    return LoginResponse.builder()
        .name(foundUserEntity.get().getName())
        .surname(foundUserEntity.get().getSurname())
        .email(foundUserEntity.get().getEmail())
        .token(token)
        .build();
  }
}