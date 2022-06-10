package com.blogpessoal.microservice.user.repository;

import com.blogpessoal.microservice.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Search User by Email.
    // select * from tb_user where email = "searching@email.com"

    public Optional<User> findByEmail(String email);

    public List<User> findAllByNameContainingIgnoreCase(String name);


}
