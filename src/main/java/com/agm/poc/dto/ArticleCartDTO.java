package com.agm.poc.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper=true)
public class ArticleCartDTO extends ItemCartDTO {
	
	private String nomeCategoria;
	private Long idCategoria;
	private Boolean piattoTrue;
	private double rating;
}
