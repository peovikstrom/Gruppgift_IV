package movie.controller;

import lombok.Data;

@Data
class TicketStub {
	public Integer seatcol;
	public Integer seatrow;
	public Integer showid;
	public Integer ticketid;
	
	public TicketStub() {
	}

}
