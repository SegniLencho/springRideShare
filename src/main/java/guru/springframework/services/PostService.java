package guru.springframework.services;

import guru.springframework.domain.Post;


/**
 * Created by OD on 6/18/2017.
 */

public interface PostService {

    Iterable<Post> listAllPost();

    Post getPostById(Integer id);

    Post savePost(Post post);

    public void deletePost(Integer postid);



}