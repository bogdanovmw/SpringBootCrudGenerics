package com.example.Test.controller;

import com.example.Test.exception.ServiceException;
import com.example.Test.model.Clients;
import com.example.Test.service.impl.ClientsService;
import com.example.Test.utils.UtilFiles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {
    private final ClientsService clientsService;

    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping
    public ResponseEntity<?> update() throws ServiceException {
        List<Clients> clients = UtilFiles.getRandom20Elements();

        for (Clients client : clients) {
            System.out.println(client);
        }

        return ResponseEntity.ok().body("Success");
    }
}
