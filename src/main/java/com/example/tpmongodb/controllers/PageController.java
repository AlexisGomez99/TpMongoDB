package com.example.tpmongodb.controllers;

import com.example.tpmongodb.api.PageService;
import com.example.tpmongodb.modelo.Page;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pages")
public class PageController {

    private PageService pageService ;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/{id}")
    @Operation(summary= "Pagina por id")
    public List<Page> getPageById(@PathVariable String id) {
        return this.pageService.findById(id);

    }

    @ExceptionHandler(Exception.class)
    public void handleException(Exception exception) {
        exception.printStackTrace();
    }

}
