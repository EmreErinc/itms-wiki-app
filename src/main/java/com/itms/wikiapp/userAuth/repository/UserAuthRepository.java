package com.itms.wikiapp.userAuth.repository;

import com.itms.wikiapp.userAuth.model.entity.UserAuthEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthRepository extends CrudRepository<UserAuthEntity, Long> {

  Optional<UserAuthEntity> findByEmail(String email);

  Optional<UserAuthEntity> findByEmailAndPassword(String email, String password);
}