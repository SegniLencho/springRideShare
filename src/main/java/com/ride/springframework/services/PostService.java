package com.ride.springframework.services;

import com.ride.springframework.domain.Comment;
import com.ride.springframework.domain.Post;
import com.ride.springframework.domain.User;

import java.util.List;


/**
 * Created by OD on 6/18/2017.
 */

public interface PostService  {

    Iterable<Post> listAllPost();

    Post getPostById(Integer id);

    Post savePost(Post post);

    public void deletePost(Integer postid);

    List<Post> findByPostType(String Type);

    public List<Post>listOfPost(User user);

    public void updatePost(Integer id,String post);

    Comment saveComment(Comment comment);








}