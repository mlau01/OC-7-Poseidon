package com.nnk.springboot.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Required;


@Entity
@Table(name = "curvepoint")
public class CurvePoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
    private Integer curveId;
    
    private Date asOfDate;
    
	@Digits(integer = 10, fraction = 2)
	@Min(value = 1)
	@NotNull
    private Double term;
    
	@Digits(integer = 10, fraction = 2)
	@Min(value = 1)
	@NotNull
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
