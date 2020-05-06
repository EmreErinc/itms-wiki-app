package com.itms.wikiapp.userAuth.controller;

import com.itms.wikiapp.userAuth.model.req.LoginRequest;
import com.itms.wikiapp.userAuth.model.req.RegisterRequest;
import com.itms.wikiapp.userAuth.model.res.LoginResponse;
import com.itms.wikiapp.userAuth.model.res.RegisterResponse;
import com.itms.wikiapp.userAuth.service.UserAuthService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAuthController {
  private final UserAuthService userAuthService;

  public UserAuthController(UserAuthService userAuthService) {
    this.userAuthService = userAuthService;
  }

  /**
   * <p>
   * system managers can view line information
   */

  @PostMapping("/register")
  public RegisterResponse register(@RequestHeader HttpHeaders headers, @RequestBody RegisterRequest request) throws Exception {
    return userAuthService.register(request);
  }

  @PostMapping("/login")
  public LoginResponse login(@RequestHeader HttpHeaders headers, @RequestBody LoginRequest request) throws Exception {
    return userAuthService.login(request);
  }
}