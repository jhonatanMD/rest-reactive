package com.ws.controller;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*


        Uni -> 0 - 1
        Multi -> 0 - N..

        */



        /*


        String v = value("Jhonatan");

        v = v + " mallqui".toUpper();

         soout(v);

        * */

        /*Uni.createFrom()
                .item(value("Jhonatan"))
                .onItem().transform(v -> v + " Mallqui")
                .onItem().transform(String::toUpperCase)
                .invoke(e -> {

                    System.out.println("entro aqui");
                    getService(e);
                })
                .subscribe().with(System.out::println);*/


                Uni.createFrom().nullItem()
                    .onItem()
                    .ifNull()
                    .failWith(new Exception("no me trae informacion"))
                        .subscribe();


        /*U Multi.createFrom()
                .items("1","2","3","4")

                .subscribe().with(System.out::println);

       ni.createFrom()
                .item(List.of("a","b"))
                .subscribe().with(System.out::println);*/

    }


    public static String value(String dato){
        return dato;
    }


    public static void getService(String e){
        System.out.println("llamando a otro servicio ===> " + e);
    }

}
