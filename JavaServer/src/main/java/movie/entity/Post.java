package movie.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Post")
@Table(name = "post")
public class Post {
 
    @Id
    @GeneratedValue
    private Long id;
 
    private String title;
 
    @OneToMany(
        mappedBy = "post", 
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<PostComment> comments = new ArrayList<>();
 
    //Constructors, getters and setters removed for brevity
 
    public void addComment(PostComment comment) {
        //comments.add(comment);
        //comment.setPost(this);
    }
 
    public void removeComment(PostComment comment) {
        //comments.remove(comment);
        //comment.setPost(null);
    }
}