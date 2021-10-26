package com.liveasy.JSONResponse;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class LoadData {
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

    public LoadData(Long id, String shipperId, String loadingPoint, String unloadingPoint, String productType, String truckType, int noOfTrucks, Long weight, Date date, String comment) {
        this.id = id;
        this.shipperId = shipperId;
        this.loadingPoint = loadingPoint;
        this.unloadingPoint = unloadingPoint;
        this.productType = productType;
        this.truckType = truckType;
        this.noOfTrucks = noOfTrucks;
        this.weight = weight;
        this.date = date;
        this.comment = comment;
    }
}
