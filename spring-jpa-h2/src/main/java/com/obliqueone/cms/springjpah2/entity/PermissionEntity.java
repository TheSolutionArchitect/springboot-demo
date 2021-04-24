package com.obliqueone.cms.springjpah2.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PERMISSION")
public class PermissionEntity {

    @Id
    @Column(name = "permission_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String desc;
	private String link;
	private String method;
	private boolean enabled;
	
    @ManyToMany(mappedBy = "permissions")
    private Collection<RoleEntity> roles;
}
