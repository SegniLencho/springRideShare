package com.ride.springframework.repositories;

import com.ride.springframework.domain.Comment;
import com.ride.springframework.domain.Post;
import com.ride.springframework.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional(Transactional.TxType.MANDATORY)
public interface CommentDao extends CrudRepository<Comment,Integer> {

    List<Comment>findByPostEquals(Post post);

    public Comment findByIdEquals(Integer id);


//    List<Post> findByPostTypeEquals(String Type);
//    List<Post>findAllByUser(User user);

//    @Modifying(clearAutomatically = true)
//    @Query("Update Post p SET p.postText = :postText WHERE p.id = :id")
//    public void updatePost(@Param("id") Integer id, @Param("postText") String postText);

//    @Modifying(clearAutomatically = true)
//    @Query("select c from Comment c where c.post =: id")
//    public List<Comment>commentList(@Param("id") Integer id);


}