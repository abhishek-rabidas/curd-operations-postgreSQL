package com.liveasy.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class ShippingData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shipperId;
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private Long weight;
    private Date date;
    private String comment;
}