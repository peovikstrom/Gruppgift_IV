package movie.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "show")
@Table(name = "show")
public class Show {
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id", updatable = false, nullable = false)
    private int id;


    private LocalDateTime start;
    private LocalDateTime stop;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne()
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @OneToMany(mappedBy = "show")
    List<Ticket> tickets = new ArrayList<>();
/*
    @Override
    public String toString() {
    	return String.format("Book[id:%d, start:%s, stop:%s, movie_key:%d, theatre_key:%d",
    			id, start.toString(), stop.toString(), movie_id, theatre_id );
    }
    */

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getStop() {
        return stop;
    }

    public void setStop(LocalDateTime stop) {
        this.stop = stop;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

