package movie.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name = "theatre")
public class Theatre {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	private String name;
	private int row;
	private int col;
	
    @Override
    public String toString() {
    	return String.format("Book[id:%d, name:%s, row:%d, col:%d",id, name, row, col);
    }
	
}
