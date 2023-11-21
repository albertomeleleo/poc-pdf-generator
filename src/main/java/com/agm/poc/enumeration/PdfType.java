package com.agm.poc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
public enum PdfType {
    PRODUCTION("PRODUCTION"),
    DISH("DISH"),
    TICKET("TICKET");

   @Getter
   private final String pdfTypeValue;
}
