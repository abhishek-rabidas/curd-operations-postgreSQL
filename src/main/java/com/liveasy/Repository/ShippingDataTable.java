package com.liveasy.Repository;

import com.liveasy.Entity.ShippingData;
import com.liveasy.JSONResponse.LoadData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingDataTable extends JpaRepository<ShippingData, Long> {
    public List<ShippingData> findAllByShipperId(String shipperId);
    public ShippingData findOneById(Long id);
}
