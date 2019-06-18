package com.abcl.libmgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
public class User {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;

	 @NonNull
	 @Column(name = "username")
	 private String userName;

	 @NonNull
	 @Column(name = "password")
	 private String password;
}
