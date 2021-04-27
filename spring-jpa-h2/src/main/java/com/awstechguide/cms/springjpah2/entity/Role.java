package com.awstechguide.cms.springjpah2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	//@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String roleName;
	@Column(unique = true)
	private String roleCd;
	private String roleDesc;
	private boolean enabled;
}
