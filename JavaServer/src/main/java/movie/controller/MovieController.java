package movie.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import movie.database.MovieRepository;
import movie.database.ShowRepository;
import movie.database.TheatreRepository;
import movie.database.TicketRepository;
import movie.entity.Movie;
import movie.entity.Show;
import movie.entity.Theatre;
import movie.entity.Ticket;
import movie.exception.ShowCheckException;

@Controller
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ShowRepository showRepository;

	@Autowired
	private TheatreRepository theatreRepository;

	@Autowired
	private TicketRepository ticketRepository;

//	@GetMapping(value = "/index")
	@RequestMapping(value = "/index")
	public String indexPage(Map<String, Object> model) {
		List<Theatre> theatres = theatreRepository.findAll();
		List<Movie> movies = movieRepository.findAll();
		List<Show> shows = showRepository.findAll();

		model.put("movies", movies);
		// model.put("shows",shows);

		model.put("theatres", theatres);
		model.put("show", shows.get(0));

		return "index";
	}

	@GetMapping(value = "/index/{id}")
	public String indexPage(Map<String, Object> model, @PathVariable int id) {

		List<Movie> movies = movieRepository.findAll();
		List<Show> shows = showRepository.findAll();

		model.put("movies", movies);
		// model.put("shows",shows);

		// model.put("theatres",theatres);
		// model.put("show",shows.get(0));
		System.out.println("before" + shows);
		List<Show> showList = shows.stream().filter(b -> b.getTheatre().getId() == id).collect(Collectors.toList());
		System.out.println("after" + showList);
		model.put("shows", showList);
		System.out.println("Salong ID:" + id);
		System.out.println(shows.get(0).getMovie());
		return "index";
	}

	@GetMapping(value = "/addMovie")
	public String addMoviePage(Map<String, Object> model) {
		return "addMovie";
	}

	@PostMapping("/addMoviePost")
	public String foo(Map<String, Object> model, @RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("url") String uriPoster) {

		String result = "addMoviePost";
		model.put("message", result);

		Movie movie = new Movie();
		movie.setTitle(title);
		movie.setDescription(description);
		movie.setUriPoster(uriPoster);
		movieRepository.save(movie);

		System.out.println("Title: " + title);
		System.out.println("Desc:" + description);
		System.out.println("Url:" + uriPoster);

		return "redirect:index";
	}

	@GetMapping(value = "/addShow")
	public String addShowPage(Map<String, Object> model) {
		
		List<Theatre> theatres = theatreRepository.findAll();
		List<Movie> movies = movieRepository.findAll();
		List<Show> shows = showRepository.findAll();

		model.put("movies", movies);
		model.put("shows", shows);
		model.put("theatres", theatres);

		return "addShow";
	}

	@GetMapping(value = "/booking/{showId}")
	public String bookingPage(Map<String, Object> model, @PathVariable int showId) {

		List<Movie> movies = movieRepository.findAll();

		Show show = showRepository.findById(showId);

		Integer[][] seats = ticket2SeatMatrix(showId);

		model.put("seats", seats);
		model.put("movies", movies);
		model.put("show", show);

		model.put("multi", this.globalSeats);

		System.out.println(show);

		return "booking";
	}

	private Integer[][] ticket2SeatMatrix(int showId) {

		List<Ticket> tickets = ticketRepository.findAll();

		List<Ticket> showTickets = tickets.stream().filter(b -> b.getShow().getId() == showId)
				.collect(Collectors.toList());

		Integer[][] seats = new Integer[10][10];

		for (int col = 0; col < 10; col++) {
			for (int row = 0; row < 10; row++)
				seats[col][row] = 0;
		}

		for (Ticket t : showTickets) {
			seats[t.getSeatRow()][t.getSeatCol()] = new Integer(t.getId());
			System.out.println(t);
		}
		return seats;
	}

	@PostMapping(value = "/addShowPost")
	public String addShowPagePost(Map<String, Object> model, @RequestParam("movieId") String movieId,
			@RequestParam("TheatreID") String theatreId, @RequestParam("start") String start,
			@RequestParam("stop") String stop) {

		List<Movie> movies = movieRepository.findAll();
		List<Show> shows = showRepository.findAll();
		
		Show show;
		try {

			int movieIdInt = Integer.parseInt(movieId);
			Movie movie = movieRepository.findById(movieIdInt);
			if (movie == null) {
				System.out.println(movieIdInt);
			}
			int theatreIdInt = Integer.parseInt(theatreId);
			Theatre theatre = theatreRepository.findById(theatreIdInt);
			if (theatre == null) {
				System.out.println(theatreIdInt);
			}

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

			LocalDateTime startDateTime = LocalDateTime.parse(start, formatter);
			LocalDateTime stopDateTime = LocalDateTime.parse(stop, formatter);

			if (checkIfDatetimeOverlaps(startDateTime, stopDateTime, theatreIdInt)) {
				return "addShowError";
			}

			model.put("movies", movies);
			model.put("shows", shows);

			System.out.println(movieId);
			System.out.println(theatreId);

			show = new Show(start, stop, movie, theatre);

		} catch (ShowCheckException e) {
			System.err.println(e);
			return "addShowError";
		} catch (NumberFormatException e) {
			System.err.println(e);
			return "addShowError";
		}
		showRepository.save(show);
		return "redirect:addShow";
	}

	private int globalSeats = 1;

	@PostMapping(value = "/bookingBook/seats/{showId}")
	public String setSeats(Map<String, Object> model, @RequestParam("seatCount") String countStr,
			@PathVariable int showId) {

		int count = 0;

		try {
			count = Integer.parseInt(countStr);
			this.globalSeats = count;
		} catch (NumberFormatException e) {
			this.globalSeats = 1;
			System.err.println(e);
		}

		return "redirect:/booking/" + showId;
	}

	@GetMapping(value = "/bookingBook/{showId}/{seatRow}/{seatCol}")
	public String bookSeatPageMultiple(Map<String, Object> model, @PathVariable int showId, @PathVariable int seatRow,
			@PathVariable int seatCol) {

		int count = this.globalSeats;

		if (count <= 0) {
			return "redirect:/booking/" + showId;
		}

		if ((seatCol + count) > 10) {
			return "redirect:/booking/" + showId;
		}

		Integer[][] seatMat = ticket2SeatMatrix(showId);
		for (int i = 0; i < count; i++) {

			System.out.println("checking X" + (seatCol + i) + "Y" + seatRow);
			System.out.println("SeatMat " + (seatMat[seatCol + i][seatRow]));

			if (seatMat[seatRow][seatCol + i] != 0) {
				System.out.println("seat " + (seatCol + i) + " row " + seatRow + " is Taken.");
				return "redirect:/booking/" + showId;
			}
		}

		Show show = showRepository.findById(showId);

		System.out.println(count);

		Ticket[] ticket = new Ticket[count];

		for (int i = 0; i < count; i++) {
			ticket[i] = new Ticket();
			ticket[i].setSeatCol(seatCol + i);
			ticket[i].setSeatRow(seatRow);
			ticket[i].setShow(show);
			ticketRepository.save(ticket[i]);
		}

		return "redirect:/booking/" + showId;
	}

	@GetMapping(value = "/bookingRemove/{showId}/{seatRow}/{seatCol}")
	public String unBookSeatPage(Map<String, Object> model, @PathVariable int showId, @PathVariable int seatRow,
			@PathVariable int seatCol) {

		List<Ticket> tickets = ticketRepository.findAll();

		List<Ticket> showTickets = tickets.stream().filter(b -> b.getShow().getId() == showId)
				.filter(r -> r.getSeatRow() == seatRow).filter(c -> c.getSeatCol() == seatCol)
				.collect(Collectors.toList());
		if (showTickets.size() != 1) {
			System.err.println(showTickets);
		}
		ticketRepository.delete(showTickets.get(0));
		return "redirect:/booking/" + showId;
	}

	public boolean isBetween(LocalDateTime datetime, Show show) {
		return !datetime.isBefore(show.start) && !datetime.isAfter(show.stop);
	}

	public boolean ifOverlapping(LocalDateTime start, LocalDateTime end, Show show) {
		return start.isBefore(show.start) && end.isAfter(show.stop);
	}

	public boolean checkIfDatetimeOverlaps(LocalDateTime start, LocalDateTime end, int theatreId) {
		List<Show> shows = showRepository.findAll();

		List<Show> showOverlaps = shows.stream().filter(b -> b.getTheatre().getId() == theatreId)
				.collect(Collectors.toList());

		for (Show show : showOverlaps) {
			if (isBetween(start, show) || isBetween(end, show) || ifOverlapping(start, end, show)) {
				return true;
			}
		}
		return false;
	}

}