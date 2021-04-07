package com.nnk.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Required;

import com.nnk.springboot.Const;

@Entity
@Table(name = "rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String moodysRating;
	
	@NotBlank
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String sandPRating;
	
	@NotBlank
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String fitchRating;
	
	@NotNull
	private Integer orderNumber;

	
	
	public Rating() {}

	public Rating(String moodysRating, String sandPRating, String fitchRating, Integer orderNumber) {
		this.moodysRating = moodysRating;
		this.sandPRating = sandPRating;
		this.fitchRating = fitchRating;
		this.orderNumber = orderNumber;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMoodysRating() {
		return moodysRating;
	}
	
	@Required
	public void setMoodysRating(String moodysRating) {
		this.moodysRating = moodysRating;
	}
	public String getSandPRating() {
		return sandPRating;
	}
	
	@Required
	public void setSandPRating(String sandPRating) {
		this.sandPRating = sandPRating;
	}
	public String getFitchRating() {
		return fitchRating;
	}
	
	@Required
	public void setFitchRating(String fitchRating) {
		this.fitchRating = fitchRating;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	
	@Required
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

}
