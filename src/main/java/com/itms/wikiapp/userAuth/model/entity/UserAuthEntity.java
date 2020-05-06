package com.itms.wikiapp.userAuth.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Builder
@Value
@Entity
@Table(name = "user_auth")
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class UserAuthEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  UUID uuid = UUID.randomUUID();

  String name;
  String surname;
  String email;
  String password;

  LocalDate registeredAt;
}