package com.Test.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

@Document
@PropertySource("classpath:ValidationMessages.properties")
public class Order implements Serializable {

	@NotNull
	@Id
 	private String id;


	public void setId(String id) {
		this.id = id;
	}


	@Field("customer")
	private String customer;
	
	private String type;

	/*特殊作用使用时--作为spring-security用户名密码登录时*/
	public Order(String username, String password) {
		this.id = username;
		this.customer = password;
	}

	public Order() {
	}

	private Collection<Item> items = new LinkedHashSet<Item>();

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public Collection<Item> getItems() {
		return items;
	}

	public void setItems(Collection<Item> items) {
		this.items = items;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id='" + id + '\'' +
				", customer='" + customer + '\'' +
				", type='" + type + '\'' +
				", items=" + items +
				'}';
	}
}
