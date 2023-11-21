package com.agm.poc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TicketDTO {
    private String deliveryService;
    private Long orderId;
    private Date createDate;
    private String owner;
    private String rootCardCode;
    private Date reservationDate;
    private String pickupTime;
    private String trayContent;
    private String storageNumber;
}
