package com.awstechguide.cms.springjpah2.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
    @Size(min = 2, max = 20)
	@Column(unique = true)
	private String userName;
	
	@NotNull
	private String password;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	@NotNull
	private boolean active;
	
	@OneToMany(targetEntity = Role.class)
	private Set<Role> roles;
	// private String roles;//ROLE_USER,ROLE_ADMIN
	
}
