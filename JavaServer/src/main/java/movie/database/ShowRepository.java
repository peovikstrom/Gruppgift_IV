package movie.database;


import javax.transaction.Transactional;

import movie.entity.Show;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import movie.entity.Movie;


@Transactional
public interface ShowRepository extends CrudRepository<Show, Long>{
    public void deleteById(int id);
    public Show findById(int id);
    //public List<Book> findByTitle(String title);
    public List<Show> findAll();
}