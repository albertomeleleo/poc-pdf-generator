package com.agm.poc.controller;

import com.agm.poc.dto.DishForCountDTO;
import com.agm.poc.service.GeneratePDFService;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@Log4j2
public class GeneratePDFController {

    public final GeneratePDFService generatePDFService;

    @GetMapping("/generaPDF")
    public ResponseEntity<Resource> generaPDF(@RequestParam Long hubId,
                                              @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                              @RequestParam String hubName) throws IOException {
        //try {
            String fileName = "test";
            //byte[] pdfContent = generatePDFService.generaPDF(generateMockCount(), fileName,date,hubName);
            byte[] pdfContent = generatePDFService.generaPDFThymeleaf(generateMockCount(), fileName,date,hubName);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

            ByteArrayResource resource = new ByteArrayResource(pdfContent);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(pdfContent.length)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(resource);

       /* } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }*/
    }

    private List<DishForCountDTO> generateMockCount(){
        List<DishForCountDTO> dishList = new ArrayList<>();
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al pomodoro").quantity(5).build() );
        dishList.add(DishForCountDTO.builder().name("petto di pollo").quantity(4).build() );
        dishList.add(DishForCountDTO.builder().name("Matriciana").quantity(2).build() );
        dishList.add(DishForCountDTO.builder().name("pane").quantity(3).build() );
        dishList.add(DishForCountDTO.builder().name("Scaloppine").quantity(11).build() );
        dishList.add(DishForCountDTO.builder().name("Pasta al Pesto con formaggio").quantity(5).build() );
        return dishList;
    }
}
