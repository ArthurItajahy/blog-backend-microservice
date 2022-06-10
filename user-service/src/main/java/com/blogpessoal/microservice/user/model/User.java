package com.blogpessoal.microservice.user.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "You do not have to be a void name.")
    private String name;

    @Schema(example = "email@email.com.br")
    @NotNull(message = "You do not have to be a void email.")
    private String email;

    @NotBlank(message = "Password is nescessary.")
    @Size(min = 8, message = "Password needs to have to 8 char.")
    private String password;

    private String photo;

}
