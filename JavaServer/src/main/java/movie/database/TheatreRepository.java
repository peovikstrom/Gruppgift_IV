package movie.database;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import movie.entity.Theatre;


@Transactional
public interface TheatreRepository extends CrudRepository<Theatre, Long>{
    public void deleteById(int id);
    public Theatre findById(int id);
    //public List<Book> findByTitle(String title);
    public List<Theatre> findAll();
}
