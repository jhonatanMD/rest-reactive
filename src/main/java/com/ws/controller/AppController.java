package com.ws.controller;

import com.ws.model.CustomerEntity;
import com.ws.service.ICustomerService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1")
@RequiredArgsConstructor
@OpenAPIDefinition(
        info = @Info(
                title = "ESTE SERVICIO ES UN CRUD DE CLIENTES",
                version = "1.0.0",
                contact = @Contact(
                        name = "Jhonatan Mallqui",
                        url = "www.google.com",
                        email = "jmdi@gmail.com"
                )
        )
)
public class AppController {

    private final ICustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponse(responseCode = "200" )
    @APIResponseSchema(value = CustomerEntity.class, responseCode = "200",responseDescription = "este servicio nos trae todos los clientes")
    public Multi<CustomerEntity> getAll() {
        return customerService.findAll();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<CustomerEntity> getById(@PathParam("id") String id) {
        return customerService.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<CustomerEntity> save(CustomerEntity customer) {
        return customerService.save(customer);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<CustomerEntity> update(CustomerEntity customer , @PathParam("id") String id) {
        return customerService.update(customer,id);
    }
}