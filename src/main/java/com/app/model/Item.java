package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="itemtab")
public class Item {
	@Id
	@GeneratedValue(generator="item_gen")
	@GenericGenerator(name="item_gen",strategy="increment")
	@Column(name="id")
	private Integer itmId;
	@Column(name="code")
	private String itmCode;
	@Column(name="width")
    private double itmWidth;
	@Column(name="length")
    private double itmLength;
	@Column(name="height")
	private double itmHeight ;
	@Column(name="cost")
	private double itmCost;
	@Column(name="currency")
	private String itmCurrency;
	public Item() {
		super();
	}
	public Item(Integer itmId) {
		super();
		this.itmId = itmId;
	}
	//uom Multplicity
	@ManyToOne
	@JoinColumn(name="uidFk")
	private Uom uom;
	
	// ordermethod Multiplicity
	@ManyToOne
	@JoinColumn(name="omSaleId")
	private OrderMethod omSale;
	  
	@ManyToOne
	@JoinColumn(name="omPurchaseId")
	private OrderMethod omPurchase;
	
	//whusertype multiplicity
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="item_venuser_tab",
	joinColumns=@JoinColumn(name="itmIdFk"),
	inverseJoinColumns=@JoinColumn(name="venIdFk"))
	@Fetch(value=FetchMode.SUBSELECT)
	private List<WhUserType> venUsers=new ArrayList<WhUserType>(0);
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="item_custuser_tab",
	joinColumns=@JoinColumn(name="itmIdFk"),
	inverseJoinColumns=@JoinColumn(name="custIdFk"))
	@Fetch(value=FetchMode.SUBSELECT)
	private List<WhUserType> custUsers=new ArrayList<WhUserType>(0);
	
	public Item(Integer itmId, String itmCode, double itmWidth, double itmLength, double itmHeight, double itmCost,
			String itmCurrency, Uom uom, OrderMethod omSale, OrderMethod omPurchase, List<WhUserType> venUsers,
			List<WhUserType> custUsers) {
		super();
		this.itmId = itmId;
		this.itmCode = itmCode;
		this.itmWidth = itmWidth;
		this.itmLength = itmLength;
		this.itmHeight = itmHeight;
		this.itmCost = itmCost;
		this.itmCurrency = itmCurrency;
		this.uom = uom;
		this.omSale = omSale;
		this.omPurchase = omPurchase;
		this.venUsers = venUsers;
		this.custUsers = custUsers;
	}
	public Integer getItmId() {
		return itmId;
	}
	public void setItmId(Integer itmId) {
		this.itmId = itmId;
	}
	public String getItmCode() {
		return itmCode;
	}
	public void setItmCode(String itmCode) {
		this.itmCode = itmCode;
	}
	public double getItmWidth() {
		return itmWidth;
	}
	public void setItmWidth(double itmWidth) {
		this.itmWidth = itmWidth;
	}
	public double getItmLength() {
		return itmLength;
	}
	public void setItmLength(double itmLength) {
		this.itmLength = itmLength;
	}
	public double getItmHeight() {
		return itmHeight;
	}
	public void setItmHeight(double itmHeight) {
		this.itmHeight = itmHeight;
	}
	public double getItmCost() {
		return itmCost;
	}
	public void setItmCost(double itmCost) {
		this.itmCost = itmCost;
	}
	public String getItmCurrency() {
		return itmCurrency;
	}
	public void setItmCurrency(String itmCurrency) {
		this.itmCurrency = itmCurrency;
	}
	public Uom getUom() {
		return uom;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	public OrderMethod getOmSale() {
		return omSale;
	}
	public void setOmSale(OrderMethod omSale) {
		this.omSale = omSale;
	}
	public OrderMethod getOmPurchase() {
		return omPurchase;
	}
	public void setOmPurchase(OrderMethod omPurchase) {
		this.omPurchase = omPurchase;
	}
	public List<WhUserType> getVenUsers() {
		return venUsers;
	}
	public void setVenUsers(List<WhUserType> venUsers) {
		this.venUsers = venUsers;
	}
	public List<WhUserType> getCustUsers() {
		return custUsers;
	}
	public void setCustUsers(List<WhUserType> custUsers) {
		this.custUsers = custUsers;
	}
	@Override
	public String toString() {
		return "Item [itmId=" + itmId + ", itmCode=" + itmCode + ", itmWidth=" + itmWidth + ", itmLength=" + itmLength
				+ ", itmHeight=" + itmHeight + ", itmCost=" + itmCost + ", itmCurrency=" + itmCurrency + ", uom=" + uom
				+ ", omSale=" + omSale + ", omPurchase=" + omPurchase + ", venUsers=" + venUsers + ", custUsers="
				+ custUsers + "]";
	}
				
}
