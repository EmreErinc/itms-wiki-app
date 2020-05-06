package com.itms.wikiapp.userAuth.service;

import com.itms.wikiapp.userAuth.model.req.LoginRequest;
import com.itms.wikiapp.userAuth.model.req.RegisterRequest;
import com.itms.wikiapp.userAuth.model.res.LoginResponse;
import com.itms.wikiapp.userAuth.model.res.RegisterResponse;

public interface UserAuthService {

  RegisterResponse register(RegisterRequest request) throws Exception;

  LoginResponse login(LoginRequest request) throws Exception;
}