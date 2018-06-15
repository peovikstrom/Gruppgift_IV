package movie.database;

import javax.transaction.Transactional;


import org.springframework.data.repository.CrudRepository;
import java.util.List;

import movie.entity.Movie;

@Transactional
public interface MovieRepository extends CrudRepository<Movie, Long>{
	public void deleteById(int id);
	public Movie findById(int id);
	//public List<Book> findByTitle(String title);
	public List<Movie> findAll();
}
