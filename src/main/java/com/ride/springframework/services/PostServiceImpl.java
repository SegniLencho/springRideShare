package com.ride.springframework.services;

import com.ride.springframework.domain.Comment;
import com.ride.springframework.domain.Post;
import com.ride.springframework.domain.User;
import com.ride.springframework.repositories.CommentDao;
import com.ride.springframework.repositories.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by OD on 6/18/2017.
 */
@Service
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class PostServiceImpl implements PostService {

    @Resource
    private PostDao postDao;
@Resource
private CommentDao commentDao;
    @Override
    public Iterable<Post> listAllPost() {
        return postDao.findAll();
    }

    @Override
    public Post getPostById(Integer id) {
        return postDao.findOne(id);
    }

    @Override
    public Post savePost(Post post) {
        return postDao.save(post);
    }

    @Override
    public void deletePost(Integer post) {
        postDao.delete(post);
    }

    @Override
    public List<Post> findByPostType(String Type) {

        return postDao.findByPostTypeEquals(Type);
    }

    @Override
    public List<Post> listOfPost(User user) {
        return postDao.findAllByUser(user);
    }



    @Override
    public Comment saveComment(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public List<Comment> findcommentByPostId(Post post) {
        return commentDao.findByPostEquals(post);
    }

    @Override
    public Comment finduserBycommentId(Integer id) {
        return commentDao.findByIdEquals(id);
    }


}
