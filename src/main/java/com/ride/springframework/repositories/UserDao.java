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
public interface UserDao extends CrudRepository<User,Integer> {
    public User findByUsername(String username);

    User findByUsernameAndPassword(String username, String pasword);

    @Query("select u.address from User u where u.id = id")
    public Integer findaddressId(@Param("id") Integer id);

//    @Query("Select po from User u join u.posts po where u.id = ?0")
//    List<Post> findAllBycreatedByUser(int id);

//    @Query("Update User t SET t.posts=:post WHERE t.id=:id")
//    public User updateTitle(@Param("id") Integer id, @Param("post") List<Post> post);

}