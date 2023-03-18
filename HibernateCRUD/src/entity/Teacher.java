package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name="f_name")
	private String f_name;
	
	@Column(name="l_name")
	private String l_name;
	
	@Column(name="email")
	private String email;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(String f_name, String l_name, String email) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", f_name=" + f_name + ", l_name=" + l_name + ", email=" + email + "]";
	}
	
	

}
