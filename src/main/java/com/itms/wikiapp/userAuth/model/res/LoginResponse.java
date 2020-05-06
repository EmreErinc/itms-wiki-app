package com.itms.wikiapp.userAuth.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Builder
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class LoginResponse {

  String name;
  String surname;
  String email;
  String token;
}
