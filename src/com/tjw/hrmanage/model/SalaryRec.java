package com.tjw.hrmanage.model;
import java.util.Date;


/**
 *薪资发放记录表
 */
public class SalaryRec {
 
	/**
	 *薪水发放记录id
	 */
	private Integer salaryRecId;
	 
	/**
	 *员工编号
	 */
	private String emSerialNumber;
	
	/**
	 * 员工部门
	 */
	private String emDept;
	
	/**
	 * 员工名称
	 */
	private String emName;
	 
	/**
	 *支付月份
	 */
	private Date payMonth;
	 
	/**
	 *基本工资
	 */
	private double baseMoney;
	 
	/**
	 *加班费
	 */
	private double overtimeMoney;
	 
	/**
	 *工龄费
	 */
	private double ageMoney;
	 
	/**
	 *考勤费
	 */
	private double checkMoney;
	 
	/**
	 *旷工费
	 */
	private double absentMoney;
	 
	/**
	 *保险费
	 */
	private double safetyMoney;
	
	/**
	 * 实发工资 
	 */
	private double actualMoney;

	/**
	 *  是否支付，0:已支付，1:未支付
	 */
	private String isPay;

	public String getIsPay() {
		return isPay;
	}

	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}

	public Integer getSalaryRecId() {
		return salaryRecId;
	}

	public void setSalaryRecId(Integer salaryRecId) {
		this.salaryRecId = salaryRecId;
	}

	public String getEmSerialNumber() {
		return emSerialNumber;
	}

	public void setEmSerialNumber(String emSerialNumber) {
		this.emSerialNumber = emSerialNumber;
	}

	public String getEmDept() {
		return emDept;
	}

	public void setEmDept(String emDept) {
		this.emDept = emDept;
	}

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public Date getPayMonth() {
		return payMonth;
	}

	public void setPayMonth(Date payMonth) {
		this.payMonth = payMonth;
	}

	public double getBaseMoney() {
		return baseMoney;
	}

	public void setBaseMoney(double baseMoney) {
		this.baseMoney = baseMoney;
	}

	public double getOvertimeMoney() {
		return overtimeMoney;
	}

	public void setOvertimeMoney(double overtimeMoney) {
		this.overtimeMoney = overtimeMoney;
	}

	public double getAgeMoney() {
		return ageMoney;
	}

	public void setAgeMoney(double ageMoney) {
		this.ageMoney = ageMoney;
	}

	public double getCheckMoney() {
		return checkMoney;
	}

	public void setCheckMoney(double checkMoney) {
		this.checkMoney = checkMoney;
	}

	public double getAbsentMoney() {
		return absentMoney;
	}

	public void setAbsentMoney(double absentMoney) {
		this.absentMoney = absentMoney;
	}

	public double getSafetyMoney() {
		return safetyMoney;
	}

	public void setSafetyMoney(double safetyMoney) {
		this.safetyMoney = safetyMoney;
	}

	public double getActualMoney() {
		return actualMoney;
	}

	public void setActualMoney(double actualMoney) {
		this.actualMoney = actualMoney;
	}

	
	 
}
 
