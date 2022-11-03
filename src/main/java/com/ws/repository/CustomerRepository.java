package com.ws.repository;

import com.ws.model.CustomerEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements ReactivePanacheMongoRepository<CustomerEntity> {
}
