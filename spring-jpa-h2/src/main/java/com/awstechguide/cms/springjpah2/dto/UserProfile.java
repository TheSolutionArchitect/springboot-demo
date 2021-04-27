package com.awstechguide.cms.springjpah2.dto;

import com.awstechguide.cms.springjpah2.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserProfile {

    private User user;
}
