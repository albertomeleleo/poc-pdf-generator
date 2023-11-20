package com.agm.poc.service;

import com.agm.poc.dto.OrderingDTO;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class OrderingMapper {

    public OrderingDTO mapJsonOrderingToDTO(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, OrderingDTO.class);
    }
}
