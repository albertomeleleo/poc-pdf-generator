package com.agm.poc.controller;

import com.agm.poc.dto.DishForCountDTO;
import com.agm.poc.service.GeneratePDFService;
import com.agm.poc.service.MockOrders;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@Log4j2
public class GeneratePDFController {

    public final GeneratePDFService generatePDFService;
    public final MockOrders mockOrders;
    @GetMapping("/generaPDF")
    public ResponseEntity<Resource> generaPDF(@RequestParam Long hubId,
                                              @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                              @RequestParam String hubName) throws IOException {

            String fileName =  StringUtils.concat("riepilogo_produzione_",hubName);
            //byte[] pdfContent = generatePDFService.generaPDFThymeleaf(mockOrders.generateMockCount(),date,hubName);
            byte[] pdfContent = generatePDFService.generaPDFThymeleaf(generatePDFService.createDataForProductionPdf(mockOrders.getMockOrders()),date,hubName);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, StringUtils.concat("attachment; filename=" ,fileName));

            ByteArrayResource resource = new ByteArrayResource(pdfContent);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(pdfContent.length)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(resource);
    }


}
