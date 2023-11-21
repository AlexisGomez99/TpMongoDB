package com.example.tpmongodb.api;

import com.example.tpmongodb.modelo.Page;

import java.util.List;

public interface PageService {

    List<Page> findById(String id);


}
