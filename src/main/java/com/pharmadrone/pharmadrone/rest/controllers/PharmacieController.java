package com.pharmadrone.pharmadrone.rest.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.pharmadrone.pharmadrone.entities.Pharmacie;
import com.pharmadrone.pharmadrone.rest.exceptions.BadRequestException;
import com.pharmadrone.pharmadrone.services.PharmacieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class PharmacieController {
    private PharmacieService pharmacieService;

    @Autowired
    public PharmacieController(PharmacieService pharmacieService) {
        this.pharmacieService = pharmacieService;
    }

    @PostMapping("/pharmacy")
    public ResponseEntity<?> addPharmacie(@RequestBody Pharmacie pharmacie) {

        if (pharmacie == null)
            throw new BadRequestException("pharmacie required");

        if (pharmacie.getNom() == null || pharmacie.getNom().trim().equals(""))
            throw new BadRequestException("nom pharmacie required");

        if (pharmacie.getTelephone() == null || pharmacie.getTelephone().trim().equals(""))
            throw new BadRequestException("telephone pharmacie required");

        if (pharmacie.getLatitude() == null)
            throw new BadRequestException("latitude pharmacie required");

        if (pharmacie.getLongitude() == null)
            throw new BadRequestException("longitude pharmacie required");

        if (pharmacie.getRegion() == null || pharmacie.getRegion().getId() == null)
            throw new BadRequestException("region pharmacie required");

        return ResponseEntity.status(HttpStatus.CREATED).body(pharmacieService.addPharmacie(pharmacie));
    }

    @GetMapping("/pharmacy")
    public ResponseEntity<?> getAllPharmacy() {
        return ResponseEntity.ok(pharmacieService.getAllPharmacies());
    }

    @GetMapping("/regions")
    public ResponseEntity<?> getAllRegion() {
        return ResponseEntity.ok(pharmacieService.getListRegion());
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
    
}
