package com.liveasy.Controller;

import com.liveasy.Entity.ShippingData;
import com.liveasy.JSONResponse.LoadData;
import com.liveasy.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private MainService mainService;

    @PostMapping("load")
    public String loadData(@RequestBody ShippingData shippingData){
        return mainService.saveShippingData(shippingData);
    }

    @PutMapping("load/{loadId}")
    public String updateData(@RequestBody ShippingData shippingData, @PathVariable("loadId") Long loadId){
        return mainService.updateShippingData(shippingData, loadId);
    }

    @GetMapping("load/{loadId}")
    public ShippingData getData(@PathVariable("loadId") Long loadId){
        return mainService.getShippingData(loadId);
    }

    @GetMapping("load")
    public List<LoadData> getAllByShipperID(@RequestParam String shipperId){
        return mainService.getAllByShipperID(shipperId);
    }

    @DeleteMapping("load/{loadId}")
    public void deleteData(@PathVariable("loadId") Long loadId){
        mainService.deleteShippingData(loadId);
    }
}