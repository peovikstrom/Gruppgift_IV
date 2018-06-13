package movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	private int seat;
	
    @ManyToOne()
    @JoinColumn(name = "show_id")
	private Show show;


    @ManyToOne()
    @JoinColumn(name = "customer_id")
	private Customer customer;


	/*
    @Override
    public String toString() {
    	return String.format("Book[id:%d, title:%s, desc:%s",id, title, description);
    }
    */

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
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