package com.obliqueone.cms.springjpah2.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String userName;
	private String password;
	 @Column(unique = true)
	private String email;
	private boolean active;
	@OneToMany(targetEntity = Role.class,cascade = CascadeType.PERSIST)
	private Set<Role> roles;
	// private String roles;//ROLE_USER,ROLE_ADMIN
	
}
