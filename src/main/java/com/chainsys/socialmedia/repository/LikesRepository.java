package com.chainsys.socialmedia.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.chainsys.socialmedia.model.Like;
import java.util.List;

@Repository
public interface LikesRepository extends CrudRepository<Like,Integer> {
	Like findById(int id);
	@SuppressWarnings("unchecked")
	Like save(Like theUser);
	void deleteById(int id);
	List<Like> findAll();
	List<Like> findByPostId(int id);
}