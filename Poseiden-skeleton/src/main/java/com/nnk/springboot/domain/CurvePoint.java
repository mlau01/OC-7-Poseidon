package com.nnk.springboot.domain;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.sql.Date;
import java.sql.Timestamp;


@Entity
@Table(name = "curvepoint")
public class CurvePoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Digits(integer = 10, fraction = 0)
    private Integer curveId;
    
    private Date asOfDate;
    
	@Digits(integer = 10, fraction = 2)
	@Min(value = 1)
    private Double term;
    
	@Digits(integer = 10, fraction = 2)
	@Min(value = 1)
    private Double value;
    
    private Date creationDate;
    
    
	
    public CurvePoint() {}

	public CurvePoint(Integer curveId, Double term, Double value) {
		this.curveId = curveId;
		this.term = term;
		this.value = value;
	}
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCurveId() {
		return curveId;
	}
	
	@Required
	public void setCurveId(Integer curveId) {
		this.curveId = curveId;
	}
	public Date getAsOfDate() {
		return asOfDate;
	}
	public void setAsOfDate(Date asOfDate) {
		this.asOfDate = asOfDate;
	}
	
	
	public Double getTerm() {
		return term;
	}
	
	@Required
	public void setTerm(Double term) {
		this.term = term;
	}
	public Double getValue() {
		return value;
	}
	
	@Required
	public void setValue(Double value) {
		this.value = value;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
    
}
