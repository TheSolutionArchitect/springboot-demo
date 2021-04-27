package com.awstechguide.cms.springjpah2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "ROLES")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
    @Size(min = 2, max = 20)
	private String roleName;
	
	@NotNull
	@Column(unique = true)
	private String roleCd;
	
	@NotNull
    @Size(min = 2, max = 50)
	private String roleDesc;
	
	@NotNull
	private boolean enabled;
}
