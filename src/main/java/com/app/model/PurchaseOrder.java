package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="purchase_order_tab")
public class PurchaseOrder {
@Id
@GeneratedValue(generator="purchase_gen")
@GenericGenerator(name="purchase_gen",strategy="increment")
@Column(name="p_id")
private Integer prchsId;
@Column(name="p_ordercode")
private String prchsOrderCode;

//shipment multiplicity
@ManyToOne
@JoinColumn(name="code_sidFk")
private ShipmentType shipment;

//whusertype multiplicity
@ManyToOne
@JoinColumn(name="ven_widFk")
private WhUserType userVendors;

@Column(name="p_refNumber")
private String prchsRefNum;
@Column(name="p_qualityCheck")
private String prchsQltyCheck;
@Column(name="p_defaultStatus")
private String prchsDfltStatus;
@Column(name="p_description")
private String prchsDsc;
public PurchaseOrder() {
	super();
}
public PurchaseOrder(Integer prchsId) {
	super();
	this.prchsId = prchsId;
}
public PurchaseOrder(Integer prchsId, String prchsOrderCode, ShipmentType shipment, WhUserType userVendors,
		String prchsRefNum, String prchsQltyCheck, String prchsDfltStatus, String prchsDsc) {
	super();
	this.prchsId = prchsId;
	this.prchsOrderCode = prchsOrderCode;
	this.shipment = shipment;
	this.userVendors = userVendors;
	this.prchsRefNum = prchsRefNum;
	this.prchsQltyCheck = prchsQltyCheck;
	this.prchsDfltStatus = prchsDfltStatus;
	this.prchsDsc = prchsDsc;
}
public Integer getPrchsId() {
	return prchsId;
}
public void setPrchsId(Integer prchsId) {
	this.prchsId = prchsId;
}
public String getPrchsOrderCode() {
	return prchsOrderCode;
}
public void setPrchsOrderCode(String prchsOrderCode) {
	this.prchsOrderCode = prchsOrderCode;
}
public ShipmentType getShipment() {
	return shipment;
}
public void setShipment(ShipmentType shipment) {
	this.shipment = shipment;
}
public WhUserType getUserVendors() {
	return userVendors;
}
public void setUserVendors(WhUserType userVendors) {
	this.userVendors = userVendors;
}
public String getPrchsRefNum() {
	return prchsRefNum;
}
public void setPrchsRefNum(String prchsRefNum) {
	this.prchsRefNum = prchsRefNum;
}
public String getPrchsQltyCheck() {
	return prchsQltyCheck;
}
public void setPrchsQltyCheck(String prchsQltyCheck) {
	this.prchsQltyCheck = prchsQltyCheck;
}
public String getPrchsDfltStatus() {
	return prchsDfltStatus;
}
public void setPrchsDfltStatus(String prchsDfltStatus) {
	this.prchsDfltStatus = prchsDfltStatus;
}
public String getPrchsDsc() {
	return prchsDsc;
}
public void setPrchsDsc(String prchsDsc) {
	this.prchsDsc = prchsDsc;
}
@Override
public String toString() {
	return "PurchaseOrder [prchsId=" + prchsId + ", prchsOrderCode=" + prchsOrderCode + ", shipment=" + shipment
			+ ", userVendors=" + userVendors + ", prchsRefNum=" + prchsRefNum + ", prchsQltyCheck=" + prchsQltyCheck
			+ ", prchsDfltStatus=" + prchsDfltStatus + ", prchsDsc=" + prchsDsc + "]";
}






}
