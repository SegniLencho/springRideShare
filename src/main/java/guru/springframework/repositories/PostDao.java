package guru.springframework.repositories;

import guru.springframework.domain.Post;
import guru.springframework.domain.Product;
import org.springframework.data.repository.CrudRepository;


public interface PostDao extends CrudRepository<Post,Integer> {
}