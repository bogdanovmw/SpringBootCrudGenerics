package com.example.Test.controller;

import com.example.Test.exception.ServiceException;
import com.example.Test.utils.RandomGenerator;
import com.example.Test.utils.UtilFiles;
import com.example.Test.model.Clients;
import com.example.Test.service.impl.ClientsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients/file")
public class FileController {
    private final ClientsService clientsService;

    public FileController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping("/add")
    public ResponseEntity<?> addAll() throws ServiceException {
        List<Clients> clients = UtilFiles.readFile();

        for (Clients client : clients) {
            client.setPassword(RandomGenerator.getRandomString());
            clientsService.save(client);
        }

        return ResponseEntity.ok().body("Insert data in database success!");
    }

    @GetMapping("/remove")
    public ResponseEntity<?> remove() throws ServiceException {
        List<Clients> clients = clientsService.getAll();

        for (Clients client : clients) {
            clientsService.remove(client);
        }

        return ResponseEntity.ok().body("Insert data in database success!");
    }
}
