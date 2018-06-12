package movie.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "PostComment")
@Table(name = "post_comment")
public class PostComment {
 
    @Id
    @GeneratedValue
    private Long id;
 
    private String review;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
 
    //Constructors, getters and setters removed for brevity
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostComment )) return false;
        return id != null && id.equals(((PostComment) o).id);
    }
    @Override
    public int hashCode() {
        return 31;
    }
}