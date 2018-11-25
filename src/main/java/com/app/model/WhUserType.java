package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="whusertab")
public class WhUserType {
@Id
@GeneratedValue(generator="user_gen")
@GenericGenerator(name="user_gen",strategy="increment")
@Column(name="wid")
private Integer whUsrTypId;
@Column(name="wtype")
private String whUsrTypType;
@Column(name="wcode")
private String whUsrTypCode;
@Column(name="wfortype")
private String whUrsTypForType;
@Column(name="wemail")
private String whUsrTypEmail;
@Column(name="wcontact")
private String whUsrTypContact;
@Column(name="widtype")
private String whUsrTypIdType;
@Column(name="wifother")
private String whUsrTypIfOther;
@Column(name="widnum")
private String whUsrTypIdNum;
public WhUserType() {
	super();
}
public WhUserType(Integer whUsrTypId) {
	super();
	this.whUsrTypId = whUsrTypId;
}
public WhUserType(Integer whUsrTypId, String whUsrTypType, String whUsrTypCode, String whUrsTypForType,
		String whUsrTypEmail, String whUsrTypContact, String whUsrTypIdType, String whUsrTypIfOther,
		String whUsrTypIdNum) {
	super();
	this.whUsrTypId = whUsrTypId;
	this.whUsrTypType = whUsrTypType;
	this.whUsrTypCode = whUsrTypCode;
	this.whUrsTypForType = whUrsTypForType;
		this.whUsrTypEmail = whUsrTypEmail;
	this.whUsrTypContact = whUsrTypContact;
	this.whUsrTypIdType = whUsrTypIdType;
	this.whUsrTypIfOther = whUsrTypIfOther;
	this.whUsrTypIdNum = whUsrTypIdNum;
}
public Integer getWhUsrTypId() {
	return whUsrTypId;
}
public void setWhUsrTypId(Integer whUsrTypId) {
	this.whUsrTypId = whUsrTypId;
}
public String getWhUsrTypType() {
	return whUsrTypType;
}
public void setWhUsrTypType(String whUsrTypType) {
	this.whUsrTypType = whUsrTypType;
}
public String getWhUsrTypCode() {
	return whUsrTypCode;
}
public void setWhUsrTypCode(String whUsrTypCode) {
	this.whUsrTypCode = whUsrTypCode;
}
public String getWhUrsTypForType() {
	return whUrsTypForType;
}
public void setWhUrsTypForType(String whUrsTypForType) {
	this.whUrsTypForType = whUrsTypForType;
}
public String getWhUsrTypEmail() {
	return whUsrTypEmail;
}
public void setWhUsrTypEmail(String whUsrTypEmail) {
	this.whUsrTypEmail = whUsrTypEmail;
}
public String getWhUsrTypContact() {
	return whUsrTypContact;
}
public void setWhUsrTypContact(String whUsrTypContact) {
	this.whUsrTypContact = whUsrTypContact;
}
public String getWhUsrTypIdType() {
	return whUsrTypIdType;
}
public void setWhUsrTypIdType(String whUsrTypIdType) {
	this.whUsrTypIdType = whUsrTypIdType;
}
public String getWhUsrTypIfOther() {
	return whUsrTypIfOther;
}
public void setWhUsrTypIfOther(String whUsrTypIfOther) {
	this.whUsrTypIfOther = whUsrTypIfOther;
}
public String getWhUsrTypIdNum() {
	return whUsrTypIdNum;
}
public void setWhUsrTypIdNum(String whUsrTypIdNum) {
	this.whUsrTypIdNum = whUsrTypIdNum;
}
@Override
public String toString() {
	return "WhUserType [whUsrTypId=" + whUsrTypId + ", whUsrTypType=" + whUsrTypType + ", whUsrTypCode=" + whUsrTypCode
			+ ", whUrsTypForType=" + whUrsTypForType + ", whUsrTypEmail=" + whUsrTypEmail + ", whUsrTypContact="
			+ whUsrTypContact + ", whUsrTypIdType=" + whUsrTypIdType + ", whUsrTypIfOther=" + whUsrTypIfOther
			+ ", whUsrTypIdNum=" + whUsrTypIdNum + "]";
}






}
