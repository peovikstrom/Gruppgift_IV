package movie.database;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import movie.entity.Ticket;


@Transactional
public interface TicketRepository extends CrudRepository<Ticket, Long>{
    public void deleteById(int id);
    public Ticket findById(int id);
    //public List<Book> findByTitle(String title);
    public List<Ticket> findAll();
}