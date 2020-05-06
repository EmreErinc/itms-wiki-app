package com.itms.wikiapp.userAuth.delegate.impl;

import com.itms.wikiapp.userAuth.delegate.UserAuthDelegateService;
import com.itms.wikiapp.userAuth.repository.UserAuthRepository;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserAuthDelegateServiceImpl implements UserAuthDelegateService {

  private UserAuthRepository userAuthRepository;

  public UserAuthDelegateServiceImpl(UserAuthRepository userAuthRepository) {
    this.userAuthRepository = userAuthRepository;
  }

}