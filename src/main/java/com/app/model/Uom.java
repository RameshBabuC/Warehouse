package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="uomtab")
public class Uom {
@Id
@GeneratedValue(generator="uom_gen")
@GenericGenerator(name="uom_gen",strategy="increment")
@Column(name="uid")
private Integer umId;

@Column(name="utype")
private String umType;
@Column(name="umodel")
private String umModel;
@Column(name="udsc")
private String umDsc;
@Override
public String toString() {
	return "Uom [umId=" + umId + ", umType=" + umType + ", umModel=" + umModel + ", umDsc=" + umDsc + "]";
}
public Integer getUmId() {
	return umId;
}
public void setUmId(Integer umId) {
	this.umId = umId;
}
public String getUmType() {
	return umType;
}
public void setUmType(String umType) {
	this.umType = umType;
}
public String getUmModel() {
	return umModel;
}
public void setUmModel(String umModel) {
	this.umModel = umModel;
}
public String getUmDsc() {
	return umDsc;
}
public void setUmDsc(String umDsc) {
	this.umDsc = umDsc;
}
public Uom(Integer umId, String umType, String umModel, String umDsc) {
	super();
	this.umId = umId;
	this.umType = umType;
	this.umModel = umModel;
	this.umDsc = umDsc;
}
public Uom(Integer umId) {
	super();
	this.umId = umId;
}
public Uom() {
	super();
}

}
