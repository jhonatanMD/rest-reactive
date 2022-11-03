package com.ws.service;

import com.ws.model.CustomerEntity;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface ICustomerService {


    Multi<CustomerEntity> findAll();
    Uni<CustomerEntity> findById(String id);
    Uni<CustomerEntity> save(CustomerEntity customer);
    Uni<CustomerEntity> update(CustomerEntity customer , String id);

}
