package sgn.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "comments")
public class Comment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private Integer cid;
	
	private String post;
	private Timestamp time;
	
	@ManyToOne
	@JoinColumn(name="post_by")
	private User postedById;
	
	
	
	public Comment()
	{
		super();
	}
	
	public Comment(Integer id, String post, Timestamp time, User postedById){
		super();
		this.cid = id;
		this.post = post;
		this.time = time;
		this.postedById = postedById;
		
	}
	public Comment(Integer id, String post, User postedById){
		super();
		this.cid = id;
		this.post = post;
		this.time = new Timestamp(new Date().getTime());
		this.postedById = postedById;
		
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer id) {
		this.cid = id;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public User getPostedById() {
		return postedById;
	}

	public void setPostedById(User postedById) {
		this.postedById = postedById;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
