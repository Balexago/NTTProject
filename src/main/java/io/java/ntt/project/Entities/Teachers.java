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
@Table(name="Teachers")
public class Teachers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Userid;
	
	@Column(nullable = false)
	private String Name;
	@Column(nullable = false)
	private Long NIF;
	@Column(nullable = false)
	private Date DataNasc;
	@Column(nullable = false)
	private String Email;
	@Column(nullable = false)
	private String Morada;
	@Column(nullable = false)
	private String Distrito;
	@Column(nullable = false)
	private String Concelho;
	@Column(nullable = false)
	private String CodigoPostal;
	@Column(nullable = false)
	private String Telemovel;
	@Column(nullable = false)
	private String Senha;
	
	

}
