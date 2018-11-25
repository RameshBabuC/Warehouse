package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="shipmenttab")
public class ShipmentType {
@Id
@GeneratedValue(generator="ship_gen")
@GenericGenerator(name="ship_gen",strategy="increment")
@Column(name="sid")
private Integer shipTypId;
@Column(name="smode")
private String shipTypMode;
@Column(name="scode")
private String shipTypCode;
@Column(name="senabled")
private String shipTypEnabled;
@Column(name="sgrade")
private String shipTypGrade;
@Column(name="sdsc")
private String shipTypDsc;
public ShipmentType() {
	super();
}
public ShipmentType(Integer shipTypId) {
	super();
	this.shipTypId = shipTypId;
}
public ShipmentType(Integer shipTypId, String shipTypMode, String shipTypCode, String shipTypEnabled,
		String shipTypGrade, String shipTypDsc) {
	super();
	this.shipTypId = shipTypId;
	this.shipTypMode = shipTypMode;
	this.shipTypCode = shipTypCode;
	this.shipTypEnabled = shipTypEnabled;
	this.shipTypGrade = shipTypGrade;
	this.shipTypDsc = shipTypDsc;
}
public Integer getShipTypId() {
	return shipTypId;
}
public void setShipTypId(Integer shipTypId) {
	this.shipTypId = shipTypId;
}
public String getShipTypMode() {
	return shipTypMode;
}
public void setShipTypMode(String shipTypMode) {
	this.shipTypMode = shipTypMode;
}
public String getShipTypCode() {
	return shipTypCode;
}
public void setShipTypCode(String shipTypCode) {
	this.shipTypCode = shipTypCode;
}
public String getShipTypEnabled() {
	return shipTypEnabled;
}
public void setShipTypEnabled(String shipTypEnabled) {
	this.shipTypEnabled = shipTypEnabled;
}
public String getShipTypGrade() {
	return shipTypGrade;
}
public void setShipTypGrade(String shipTypGrade) {
	this.shipTypGrade = shipTypGrade;
}
public String getShipTypDsc() {
	return shipTypDsc;
}
public void setShipTypDsc(String shipTypDsc) {
	this.shipTypDsc = shipTypDsc;
}
@Override
public String toString() {
	return "ShipmentType [shipTypId=" + shipTypId + ", shipTypMode=" + shipTypMode + ", shipTypCode=" + shipTypCode
			+ ", shipTypEnabled=" + shipTypEnabled + ", shipTypGrade=" + shipTypGrade + ", shipTypDsc=" + shipTypDsc
			+ "]";
}

}




