package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ordmethtab")
public class OrderMethod {
@Id
@GeneratedValue(generator="om_gen")
@GenericGenerator(name="om_gen",strategy="increment")
@Column(name="ordmethid")
private Integer ordMethId;
@Column(name="ordmethmode")
private String ordMethMode;
@Column(name="ordmethcode")
private String ordMethCode;
@Column(name="ordmethmethod")
private String ordMethMethod;
@ElementCollection(fetch=FetchType.EAGER)
@CollectionTable(name="ordmethaccept",
     joinColumns=@JoinColumn(name="ordMethId"))
@OrderColumn(name="pos")
@Column(name="data")
private List<String> ordMethAccept;
@Column(name="ordmethdsc")
private String ordMethDsc;

@Override
public String toString() {
	return "OrderMethod [ordMethId=" + ordMethId + ", ordMethMode=" + ordMethMode + ", ordMethCode=" + ordMethCode
			+ ", ordMethMethod=" + ordMethMethod + ", ordMethAccept=" + ordMethAccept + ", ordMethDsc=" + ordMethDsc
			+ "]";
}
public Integer getOrdMethId() {
	return ordMethId;
}
public void setOrdMethId(Integer ordMethId) {
	this.ordMethId = ordMethId;
}
public String getOrdMethMode() {
	return ordMethMode;
}
public void setOrdMethMode(String ordMethMode) {
	this.ordMethMode = ordMethMode;
}
public String getOrdMethCode() {
	return ordMethCode;
}
public void setOrdMethCode(String ordMethCode) {
	this.ordMethCode = ordMethCode;
}
public String getOrdMethMethod() {
	return ordMethMethod;
}
public void setOrdMethMethod(String ordMethMethod) {
	this.ordMethMethod = ordMethMethod;
}
public List<String> getOrdMethAccept() {
	return ordMethAccept;
}
public void setOrdMethAccept(List<String> ordMethAccept) {
	this.ordMethAccept = ordMethAccept;
}
public String getOrdMethDsc() {
	return ordMethDsc;
}
public void setOrdMethDsc(String ordMethDsc) {
	this.ordMethDsc = ordMethDsc;
}
public OrderMethod(Integer ordMethId, String ordMethMode, String ordMethCode, String ordMethMethod,
		List<String> ordMethAccept, String ordMethDsc) {
	super();
	this.ordMethId = ordMethId;
	this.ordMethMode = ordMethMode;
	this.ordMethCode = ordMethCode;
	this.ordMethMethod = ordMethMethod;
	this.ordMethAccept = ordMethAccept;
	this.ordMethDsc = ordMethDsc;
}
public OrderMethod(Integer ordMethId) {
	super();
	this.ordMethId = ordMethId;
}
public OrderMethod() {
	super();
}



}
