package com.anrowl.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * packageName : com.anrowl.server.model
 * fileName : UserGroup
 * author : wmsuser
 * date : 2021-12-24
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userGroupId;
    private String userGroupName;
}
