package movie.database;


import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import movie.entity.Movie;

@Transactional
public interface CinemaRepository extends CrudRepository<Movie, Long>{
	public void deleteById(int id);
	public Movie findById(int id);
	//public List<Book> findByTitle(String title);
	//public List<Book> findAll();
}
