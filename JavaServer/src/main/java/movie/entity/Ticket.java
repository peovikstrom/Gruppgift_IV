package movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="ticket")
public class Ticket {



	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ticket_id", updatable = false, nullable = false)
	private int id;
	
	private int seatRow;
	private int seatCol;
	
	@ManyToOne()
    //@ManyToOne()
    @JoinColumn(name = "show_id")
	private Show show;


    @ManyToOne()
    @JoinColumn(name = "customer_id")
	private Customer customer;


    @Override
    public String toString() {
    	return String.format("Ticket[id:%d, col:%d, row:%d",id, seatCol, seatRow);
    }

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}

	public int getSeatCol() {
		return seatCol;
	}

	public void setSeatCol(int seatCol) {
		this.seatCol = seatCol;
	}
	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}