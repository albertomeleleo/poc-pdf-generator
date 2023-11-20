package com.agm.poc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DishForCountDTO {
    private Long id;
    private String category;
    private String name;
    private int quantity;
}
