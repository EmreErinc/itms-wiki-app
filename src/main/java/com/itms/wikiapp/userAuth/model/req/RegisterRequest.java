package com.itms.wikiapp.userAuth.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Builder
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class RegisterRequest {

  String name;
  String surname;
  String email;
  String password;
}
