package com.ws.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Getter
@Setter
@MongoEntity(collection = "Customer")
public class CustomerEntity extends ReactivePanacheMongoEntity {

    private String name;
    @BsonProperty("last_name")
    private String lastName;

}
