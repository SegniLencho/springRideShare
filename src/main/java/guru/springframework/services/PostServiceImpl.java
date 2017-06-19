package guru.springframework.services;

import guru.springframework.domain.Post;
import guru.springframework.repositories.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by OD on 6/18/2017.
 */
@Service
public class PostServiceImpl implements PostService {

    private PostDao postDao;

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

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


}
