package com.agm.poc.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true)
public class MenuCarrelloResponseDTO {

    private List<MenuCartDTO> menu;
    private List<ArticleCartDTO> singoli;
    private Double totale;
    private Integer totalePunti;
    private Boolean ispromo;
}
