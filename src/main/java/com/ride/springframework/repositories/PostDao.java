package com.ride.springframework.repositories;

import com.ride.springframework.domain.Post;
import com.ride.springframework.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional(Transactional.TxType.MANDATORY)
public interface PostDao extends CrudRepository<Post,Integer> {
    List<Post> findByPostTypeEquals(String Type);
    List<Post>findAllByUser(User user);





}