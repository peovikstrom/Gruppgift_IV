package movie.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
//@Table(name = "theatre")
public class Theatre {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "theatre_id", updatable = false, nullable = false)
	private int id;
	
	private String name;
	private int row;
	private int col;
	
    @Override
    public String toString() {
    	return String.format("Theatre[id:%d, name:%s, row:%d, col:%d",id, name, row, col);
    }

	@JsonGetter("id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonGetter("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonGetter("row")
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@JsonGetter("col")
	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
}
