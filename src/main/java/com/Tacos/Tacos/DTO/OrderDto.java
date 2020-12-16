package com.Tacos.Tacos.DTO;

import java.io.Serializable;
import java.util.Date;

public class OrderDto implements Serializable {

    private Long id;
    private Date placedAt;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

}
