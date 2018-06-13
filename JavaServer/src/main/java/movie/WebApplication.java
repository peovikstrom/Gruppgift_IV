package movie;

import movie.database.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WebApplication {
    @Autowired
    private CinemaRepository cinemaRepository;

    public static void main(String[] args) {
        //Movie movie = new Movie();
        SpringApplication.run(WebApplication.class, args);
    }
}