package movie.controller;

import lombok.Data;
import movie.entity.Show;

@Data
class GreyTicket {
	public Integer seatcol;
	public Integer seatrow;
	public Integer showid;
	
	public GreyTicket() {
	}

}
