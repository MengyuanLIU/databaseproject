package com.tjw.hrmanage.model;


/**
 *薪资
 */
public class SalaryBase {
 
	/**
	 *薪水id
	 */
	private Integer salaryBaseId;
	 
	/**
	 * 基本工资
	 */
	private double baseMoney;
	
	/**
	 * 保险费
	 */
	private double safetyMoney;
	
	/**
	 * 所属员工
	 */
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getSalaryBaseId() {
		return salaryBaseId;
	}

	public void setSalaryBaseId(Integer salaryBaseId) {
		this.salaryBaseId = salaryBaseId;
	}

	public double getBaseMoney() {
		return baseMoney;
	}

	public void setBaseMoney(double baseMoney) {
		this.baseMoney = baseMoney;
	}

	public double getSafetyMoney() {
		return safetyMoney;
	}

	public void setSafetyMoney(double safetyMoney) {
		this.safetyMoney = safetyMoney;
	}
	

	 
}
 
