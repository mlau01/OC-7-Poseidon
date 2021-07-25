package com.nnk.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Required;

import com.nnk.springboot.Const;

@Entity
@Table(name = "rulename")
public class RuleName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String name;
	
	@NotBlank
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String description;
	
	@NotBlank
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String json;
	
	@NotBlank
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String template;
	
	@NotBlank
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String sqlStr;
	
	@NotBlank
	@Length(max = 125, message = Const.CONSTRAINT_MESSAGE_125CHAR)
	private String sqlPart;
	
	
	
	public RuleName() {}

	public RuleName(String name, String description, String json, String template, String sqlStr, String sqlPart) {
		this.name = name;
		this.description = description;
		this.json = json;
		this.template = template;
		this.sqlStr = sqlStr;
		this.sqlPart = sqlPart;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	@Required
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	
	@Required
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJson() {
		return json;
	}
	
	@Required
	public void setJson(String json) {
		this.json = json;
	}
	public String getTemplate() {
		return template;
	}
	
	@Required
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getSqlStr() {
		return sqlStr;
	}
	
	@Required
	public void setSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
	}
	public String getSqlPart() {
		return sqlPart;
	}
	
	@Required
	public void setSqlPart(String sqlPart) {
		this.sqlPart = sqlPart;
	}
	
	
}
