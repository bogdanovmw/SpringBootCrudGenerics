package com.example.Test.service.impl;

import com.example.Test.model.Clients;
import com.example.Test.repository.CrudRepository;
import com.example.Test.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService extends AbstractService<Clients> {

    @Autowired
    public ClientsService(CrudRepository<Clients> repository) {
        this.repository = repository;
    }
}
