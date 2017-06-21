package com.ride.springframework.repositories;

import com.ride.springframework.domain.Post;
import com.ride.springframework.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao extends CrudRepository<Post,Integer> {
    List<Post> findByPostTypeEquals(String Type);
    List<Post>findAllByUser(User user);

    @Modifying(clearAutomatically = true)
    @Query("Update Post p SET p.postText = :postText WHERE p.id = :id")
    public void updatePost(@Param("id") Integer id, @Param("postText") String postText);



}