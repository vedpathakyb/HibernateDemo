package com;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@javax.persistence.Table(name="AV")
public class AV {
@Id
@Column(name="ID")
private int id;
public AV(int id, String name, int age) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
}
@Override
public String toString() {
	return "AV [id=" + id + ", name=" + name + ", age=" + age + "]";
}
public AV() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Column(name="NAME")
private String name;
@Column(name="AGE")
private int age;
}
