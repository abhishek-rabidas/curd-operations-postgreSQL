package com.liveasy.Service;

import com.liveasy.Entity.ShippingData;
import com.liveasy.JSONResponse.LoadData;
import com.liveasy.Repository.ShippingDataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MainService {

    @Autowired
    private ShippingDataTable shippingDataTable;

    public String saveShippingData(ShippingData shippingData){
        //shippingData.setShipperId(String.format("shipper_%s", UUID.randomUUID().toString()));
        if(shippingData.getDate()==null)
            shippingData.setDate(new Date());
        shippingDataTable.save(shippingData);
        return "loads details added successfully";
    }

    public String updateShippingData(ShippingData shippingData, Long id){
        shippingDataTable.deleteById(id);
        shippingDataTable.save(shippingData);
        return "updated";
    }

    public ShippingData getShippingData(Long id){
        return shippingDataTable.findOneById(id);
    }

    public List<LoadData> getAllByShipperID(String shipperId){
        List<LoadData> loadDataList = new ArrayList<>();

        shippingDataTable.findAllByShipperId(shipperId).stream().filter(shippingData -> {
            return loadDataList.add(new LoadData(shippingData.getId(), shippingData.getShipperId(), shippingData.getLoadingPoint(), shippingData.getUnloadingPoint(),
                    shippingData.getProductType(), shippingData.getTruckType(), shippingData.getNoOfTrucks(), shippingData.getWeight(), shippingData.getDate(),
                    shippingData.getComment()));
        }).collect(Collectors.toList());

        return loadDataList;
    }

    public void deleteShippingData(Long id){
        shippingDataTable.deleteById(id);
    }
}
