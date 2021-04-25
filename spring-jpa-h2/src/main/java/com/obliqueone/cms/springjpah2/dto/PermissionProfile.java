package com.obliqueone.cms.springjpah2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionProfile {

	private long id;
	private String name;
	private String desc;
	private String link;
	private String method;
	private boolean enabled;
}
