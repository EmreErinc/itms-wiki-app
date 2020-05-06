package com.itms.wikiapp.userAuth.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Builder
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class LoginRequest {

  String email;
  String password;
}
