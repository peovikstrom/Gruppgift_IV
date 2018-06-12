package movie.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "show")
public class Show {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	private LocalDateTime start;
	private LocalDateTime stop;

	private int movie_id;
	private int theatre_id;
	

    @Override
    public String toString() {
    	return String.format("Book[id:%d, start:%s, stop:%s, movie_key:%d, theatre_key:%d",
    			id, start.toString(), stop.toString(), movie_id, theatre_id );
    }
}

