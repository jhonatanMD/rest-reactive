package com.ws.service.impl;

import com.ws.model.CustomerEntity;
import com.ws.repository.CustomerRepository;
import com.ws.service.ICustomerService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {


    private final CustomerRepository customerRepository;

    @Override
    public Multi<CustomerEntity> findAll() {
        return customerRepository.listAll()
                .onItem()
                .transformToMulti(Multi.createFrom()::iterable);
    }

    @Override
    public Uni<CustomerEntity> findById(String id) {
        return customerRepository.findById(new ObjectId(id))
                .onItem()
                .ifNull()
                .fail();
        //.switchTo(() -> Uni.createFrom().item(new CustomerEntity()));
                //.continueWith(new CustomerEntity());
        //.failWith(new RuntimeException("No se encontro cliente con id => " + id));
    }

    @Override
    public Uni<CustomerEntity> save(CustomerEntity customer) {
        return customerRepository.persist(customer);
    }

    @Override
    public Uni<CustomerEntity> update(CustomerEntity customer, String id) {

        return customerRepository.findById(new ObjectId(id))
                .onItem()
                .ifNull()
                .failWith(new RuntimeException("no existe cliente"))
                .flatMap(c -> {
                    customer.id = c.id;
                    return customerRepository.update(customer);
                });
    }
}
