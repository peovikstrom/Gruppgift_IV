package movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;


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
	
	private String uriPoster;
	
	@JsonGetter("uri")
    public String getUriPoster() {
		return uriPoster;
	}

	public void setUriPoster(String uriPoster) {
		this.uriPoster = uriPoster;
	}

	@Override
    public String toString() {
    	return String.format("Movie[id:%d, title:%s, desc:%s",id, title, description);
    }

	@JsonGetter("id")
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonGetter("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonGetter("desc")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}