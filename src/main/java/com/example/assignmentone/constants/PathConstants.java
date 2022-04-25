package com.example.assignmentone.constants;

public interface PathConstants {
    String BASE = "/api";
    String VERSION_0 = "/v0";
    String ID = "/{id}";
    String USERNAME = "/{username}";

    interface Customer{
        String RESOURSE = "/customers";
        String RESOURSE_BASE_V0 = BASE + VERSION_0 + RESOURSE;
    }

    interface Order{
        String RESOURSE = "/orders";
        String RESOURSE_BASE_V0 = BASE + VERSION_0 + RESOURSE;
    }

    interface Product{
        String RESOURSE = "/products";
        String RESOURSE_BASE_V0 = BASE + VERSION_0 + RESOURSE;
    }
}
