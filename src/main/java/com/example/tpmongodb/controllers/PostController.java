package com.example.tpmongodb.controllers;

import com.example.tpmongodb.api.PostService;
import com.example.tpmongodb.dto.AuthorPostCount;
import com.example.tpmongodb.modelo.Post;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {


    private PostService postService ;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/byauthor")
    @Operation(summary= "Conteo de Autores")
    public List<AuthorPostCount> getPagesByAuthor() {
        return this.postService.countPostsByAuthor();
    }

    @GetMapping("/latest")
    @Operation(summary= "Ultimos cuatro Posteos")
    public List<Post> getLatest4Posts() {
        return this.postService.findLatestPosts();
    }

    @GetMapping("/author/{nombreautor}")
    @Operation(summary= "Posteos por Autor")
    public List<Post> getPostsByAuthor(@PathVariable String nombreautor) {
        return this.postService.findPostsByAuthor(nombreautor);
    }

    @GetMapping("/search/{text}")
    @Operation(summary= "Buscar Posteos")
    public List<Post> searchPosts(@PathVariable String text) {
        return this.postService.findPostsByText(text);
    }

    @ExceptionHandler(Exception.class)
    public void handleException(Exception exception) {
        exception.printStackTrace();
    }

}
