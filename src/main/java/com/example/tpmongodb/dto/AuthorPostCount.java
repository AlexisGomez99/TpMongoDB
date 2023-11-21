package com.example.tpmongodb.dto;

import lombok.Data;

@Data
public class AuthorPostCount {

    private String id;
    private int count;

    public AuthorPostCount(String id, int count) {
        this.id = id;
        this.count = count;
    }

}
