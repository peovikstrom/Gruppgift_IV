package movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "movie")
public class Movie {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "movie_id", updatable = false, nullable = false)
	private int id;
	
	private String title;
	private String description;
	
    @Override
    public String toString() {
    	return String.format("Book[id:%d, title:%s, desc:%s",id, title, description);
    }
	
}