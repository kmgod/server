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
 * fileName : Person
 * author : wmsuser
 * date : 2021-12-24
 * 2021-12-24 wmsuser 최초 생성
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
