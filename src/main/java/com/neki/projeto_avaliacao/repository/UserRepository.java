package com.neki.projeto_avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.projeto_avaliacao.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
