package com.code.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class Order {
    @Id
    private String orderId;
    @Field
    private String emailId;
    @Field
    private String pickupDate;
    @Field
    private String drugName;
    @Field
    private int quantity;

}
