package com.inatlas.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id; 
  
  @NotNull
  @Size(min = 2, max = 80)
  private String name;

  public Address() { }

  public Address(long id) { 
    this.id = id;
  }

  public Address(String name) {   
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }
  
} 
