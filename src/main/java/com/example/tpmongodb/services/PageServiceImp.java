package com.example.tpmongodb.services;

import com.example.tpmongodb.api.PageService;
import com.example.tpmongodb.modelo.Page;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PageServiceImp extends MongoGenericService implements PageService {

    public List<Page> findById(String id) {
        List<Page> pages;
        try {
            pages = inTx(collection -> {
                return collection.find(Filters.eq("_id", new ObjectId(id)))
                        .map(document -> Page.builder()
                                .id(String.valueOf(document.getObjectId("_id")))
                                .title(document.getString("title"))
                                .text(document.getString("text"))
                                .author(document.getString("author"))
                                .date(LocalDate.parse(document.getString("date"), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                                .build())
                        .into(new ArrayList<>());
            }, "pages");
        } catch (Exception e) {
            throw e;
        }
        return pages;
    }

}
