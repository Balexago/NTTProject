package io.java.ntt.project.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Courseid;
	
	@Column(nullable = false)
	private String Name;
	
	@Column(nullable = false)
	private String Dsc;
	
	@Column(nullable = false)
	private long SlotsOpen;
	
	@Column(nullable = false)
	private Date CourseStart;
	
	@Column(nullable = false)
	private Date CourseEnd;
	
	@Column(nullable = false)
	private String Status;
	
	@Column(nullable = false)
	private String District;
	
	@Column(nullable = false)
	private String Council;
	
}
