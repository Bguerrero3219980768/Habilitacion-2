package com.example.demo.entities;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="news")
@Data
public class News implements Serializable {
	
	@Id
	@SequenceGenerator(name="news_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="news_id_seq")
	private Integer id;
	
	private String nombre;
	
	private String descripcion;

	private String resumen;

	private String titulo;
	
	@ManyToOne
	@JoinColumn(name="news_id")
	private Categoria categoria;
	
	
}
