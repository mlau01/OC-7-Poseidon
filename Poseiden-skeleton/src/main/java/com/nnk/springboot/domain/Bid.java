package com.nnk.springboot.domain;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Required;

import com.nnk.springboot.Const;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.sql.Date;

@Entity
@Table(name = "bidlist")
public class Bid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Length(max = 30, message = Const.CONSTRAINT_MESSAGE_30CHAR)
	@NotBlank(message = "Account is mandatory")
	private String account;
	
	@Length(max = 30, message = Const.CONSTRAINT_MESSAGE_30CHAR)
	@NotBlank(message = "Type is mandatory")
	private String type;

	@Digits(integer = 10, fraction = 2)
	@Min(value = 1)
	@NotNull
	private Double bidQuantity;
	
	private Double askQuantity;

	private Double bid;

	private Double ask;
	
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String benchmark;

	private Date bidListDate;
	
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String commentary;
	
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String security;
	
	@Length(max = 10, message = Const.CONSTRAINT_MESSAGE_10CHAR)
	private String status;
	
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String trader;
	
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String book;
	
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String creationName;

	private Date creationDate;
	
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String revisionName;
	
	private Date revisionDate;
	
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String dealName;
	
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String dealType;
	
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String sourceListId;
	
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String side;
	
	
	
	public Bid() {
	}

	public Bid(String account, String type, Double bidQuantity) {
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}
	
	@Required
	public void setAccount(String account) {
		this.account = account;
	}
	public String getType() {
		return type;
	}
	
	@Required
	public void setType(String type) {
		this.type = type;
	}
	public Double getBidQuantity() {
		return bidQuantity;
	}
	public void setBidQuantity(Double bidQuantity) {
		this.bidQuantity = bidQuantity;
	}
	public Double getAskQuantity() {
		return askQuantity;
	}
	public void setAskQuantity(Double askQuantity) {
		this.askQuantity = askQuantity;
	}
	public Double getBid() {
		return bid;
	}
	public void setBid(Double bid) {
		this.bid = bid;
	}
	public Double getAsk() {
		return ask;
	}
	public void setAsk(Double ask) {
		this.ask = ask;
	}
	public String getBenchmark() {
		return benchmark;
	}
	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}
	public Date getBidListDate() {
		return bidListDate;
	}
	public void setBidListDate(Date bidListDate) {
		this.bidListDate = bidListDate;
	}
	public String getCommentary() {
		return commentary;
	}
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTrader() {
		return trader;
	}
	public void setTrader(String trader) {
		this.trader = trader;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getCreationName() {
		return creationName;
	}
	public void setCreationName(String creationName) {
		this.creationName = creationName;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getRevisionName() {
		return revisionName;
	}
	public void setRevisionName(String revisionName) {
		this.revisionName = revisionName;
	}
	public Date getRevisionDate() {
		return revisionDate;
	}
	public void setRevisionDate(Date revisionDate) {
		this.revisionDate = revisionDate;
	}
	public String getDealName() {
		return dealName;
	}
	public void setDealName(String dealName) {
		this.dealName = dealName;
	}
	public String getDealType() {
		return dealType;
	}
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}
	public String getSourceListId() {
		return sourceListId;
	}
	public void setSourceListId(String sourceListId) {
		this.sourceListId = sourceListId;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}



}
