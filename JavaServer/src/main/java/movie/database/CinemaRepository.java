package movie.database;


import org.springframework.data.repository.CrudRepository;

import movie.entity.Movie;

import java.util.List;

import javax.transaction.Transactional;

@Transactional
public interface CinemaRepository extends CrudRepository<Movie, Long>{
	public void deleteById(int id);
	public Movie findById(int id);
	//public List<Book> findByTitle(String title);
	//public List<Book> findAll();
}
