package movie.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;

import movie.exception.ShowCheckException;


@Entity(name = "show")
@Table(name = "show")
public class Show {
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id", updatable = false, nullable = false)
    private int id;

    public LocalDateTime start;
    public LocalDateTime stop;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne()
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @OneToMany(mappedBy = "show")
//    @OneToMany()
//    @JoinColumn(name = "ticket_id")
    private List<Ticket> tickets = new ArrayList<>();
    
    public Show() {}
    
    public Show(String start, String stop, Movie movie, Theatre theatre) throws ShowCheckException, DateTimeParseException{
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    	    		
    	this.start = LocalDateTime.parse(start, formatter);
    	this.stop = LocalDateTime.parse(stop, formatter);
		this.movie = movie;
		this.theatre = theatre;
		
		if(start == null ||
				stop == null ||
				movie == null ||
				theatre == null )
			throw new ShowCheckException("Invalid input");
		
		
	}

    @Override
    public String toString() {
    	//{"id":2,"content":"Hello, User!"}
    	return String.format("{\"id\":%d\"start\":%s,\"stop\":%s,\"movieID\":%d,\"theatreID\":%d}",
    			id, start.toString(), stop.toString(), movie.getId(), theatre.getId() );
    }

    public int getTheatreId() {
    	return this.theatre.getId();
    }
    
    @JsonGetter("theatre")
    public Theatre getTheatre() {
		return theatre;
	}


	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	@JsonGetter("tickets")
	public List<Integer> getTicketIDs() {
		List<Integer> tmp = this.tickets.stream().map(Ticket::getId).collect(Collectors.toList());
		return tmp;
		
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@JsonGetter("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonGetter("start")
    public String getStart() {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return this.start.format(formatter);
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    @JsonGetter("stop")
    public String getStop() {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return this.stop.format(formatter);
    }
    

    public void setStop(LocalDateTime stop) {
        this.stop = stop;
    }

    @JsonGetter("movie")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

