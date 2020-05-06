package com.itms.wikiapp.common.security;

import com.itms.wikiapp.common.exception.ErrorHandlerFactory;
import com.itms.wikiapp.userAuth.model.UserErrorCode;
import com.itms.wikiapp.userAuth.repository.UserAuthRepository;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  private final UserAuthRepository userAuthRepository;

  public JwtUserDetailsService(UserAuthRepository userAuthRepository) {
    this.userAuthRepository = userAuthRepository;
  }

  @SneakyThrows
  @Override
  public UserDetails loadUserByUsername(String email) {

    if (userAuthRepository.findByEmail(email).isPresent()) {
      return new User(email, "credential", new ArrayList<>());
    } else {
      throw new ErrorHandlerFactory().newException(UserErrorCode.NOT_FOUND);
    }
  }
}
