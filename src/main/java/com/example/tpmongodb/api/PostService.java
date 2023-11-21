package com.example.tpmongodb.api;

import com.example.tpmongodb.dto.AuthorPostCount;
import com.example.tpmongodb.modelo.Post;

import java.util.List;

public interface PostService {

    Post insertPost(Post post);

    List<Post> findPost(String id);

    List<Post> findLatestPosts();

    List<Post> findPostsByAuthor(String author);

    List<Post> findPostsByText(String text);

    List<AuthorPostCount> countPostsByAuthor();


}
