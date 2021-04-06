package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.nnk.springboot.Application;

import java.sql.Date;


@Entity
@Table(name = "trade")
public class Trade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Length(max = 30, message = Application.CONSTRAINT_MESSAGE_30CHAR)
	private String account;
	
	@NotBlank
	@Length(max = 30, message = Application.CONSTRAINT_MESSAGE_30CHAR)
	private String type;
	
	private Double buyQuantity;
	
	private Double sellQuantity;
	
	private Double buyPrice;
	
	private Double sellPrice;
	
	@Length(max = 125, message = Application.CONSTRAINT_MESSAGE_125CHAR)
	private String benchmark;
	
	private Date tradeDate;
	
	@Length(max = 125, message = Application.CONSTRAINT_MESSAGE_125CHAR)
	private String security;
	
	@Length(max = 10, message = Application.CONSTRAINT_MESSAGE_10CHAR)
	private String status;
	
	@Length(max = 125, message = Application.CONSTRAINT_MESSAGE_125CHAR)
	private String trader;
	
	@Length(max = 125, message = Application.CONSTRAINT_MESSAGE_125CHAR)
	private String book;
	
	@Length(max = 125, message = Application.CONSTRAINT_MESSAGE_125CHAR)
	private String creationName;
	
	private Date creationDate;
	
	@Length(max = 125, message = Application.CONSTRAINT_MESSAGE_125CHAR)
	private String revisionName;
	
	private Date revisionDate;
	
	@Length(max = 125, message = Application.CONSTRAINT_MESSAGE_125CHAR)
	private String dealName;
	
	@Length(max = 125, message = Application.CONSTRAINT_MESSAGE_125CHAR)
	private String dealType;
	
	@Length(max = 125, message = Application.CONSTRAINT_MESSAGE_125CHAR)
	private String sourceListId;
	
	@Length(max = 125, message = Application.CONSTRAINT_MESSAGE_125CHAR)
	private String side;
	
	
	
	public Trade() {
	}

	public Trade(String account, String type) {
		this.account = account;
		this.type = type;
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

	public void setAccount(String account) {
		this.account = account;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getBuyQuantity() {
		return buyQuantity;
	}

	public void setBuyQuantity(Double buyQuantity) {
		this.buyQuantity = buyQuantity;
	}

	public Double getSellQuantity() {
		return sellQuantity;
	}

	public void setSellQuantity(Double sellQuantity) {
		this.sellQuantity = sellQuantity;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getBenchmark() {
		return benchmark;
	}

	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
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
