package com.agm.poc.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class MenuCartDTO extends ItemCartDTO {

	 private List<ArticleCartDTO> componenti;

}
