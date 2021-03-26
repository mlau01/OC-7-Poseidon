package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name = "rulename")
public class RuleName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String json;
	
	@NotBlank
	private String template;
	
	@NotBlank
	private String sqlStr;
	
	@NotBlank
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
