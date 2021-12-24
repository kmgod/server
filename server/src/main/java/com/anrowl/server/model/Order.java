package com.anrowl.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * packageName : com.anrowl.server.model
 * fileName : Order
 * author : wmsuser
 * date : 2021-12-24
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Order Number cannot be empty or null")
    private String orderNumber;
    private String name;
}
