package com.tjw.hrmanage.model;
import java.util.Date;


/**
 *员工
 */
public class Employee {
 
	/**
	 *员工id(数据库主键)
	 */
	private int emId;
	 
	/**
	 *员工编号(业务主键)
	 */
	private String emSerialNumber;
	 
	/**
	 *员工姓名
	 */
	private String emName;
	 
	/**
	 *员工性别
	 */
	private String emSex;
	 
	/**
	 *员工年龄
	 */
	private int emAge;
	 
	/**
	 *员工出生日期
	 */
	private Date emBorn;
	 
	/**
	 *员工身份证
	 */
	private String emIdCard;
	 
	/**
	 *民族
	 */
	private String emMz;
	 
	/**
	 *员工婚姻状况
	 */
	private String emMarriage;
	 
	/**
	 *政治面貌
	 */
	private String emZzmm;
	 
	/**
	 *籍贯
	 */
	private String emJg;
	 
	/**
	 *员工联系电话
	 */
	private String emTel;
	 
	/**
	 *家庭住址
	 */
	private String emAddress;
	 
	/**
	 *毕业院校
	 */
	private String emGraduateSchool;
	 
	/**
	 *所学专业
	 */
	private String emSpeciality;
	 
	/**
	 *文化程度
	 */
	private String emDegree;
	 
	/**
	 *上岗时间
	 */
	private Date emWorkTime;
	 
	/**
	 *所属部门
	 */
	private Department department;
	 
	/**
	 *部门工种
	 */
	private String deptGz;
	 
	/**
	 *登记人名(即公司操作员)
	 */
	private String registerName;
	 
	/**
	 *登记时间
	 */
	private Date registerTime;
	 
	/**
	 *备注信息
	 */
	private String emNote;
	
	/**工资基本信息*/
	private SalaryBase salaryBase;
	

	public SalaryBase getSalaryBase() {
		return salaryBase;
	}

	public void setSalaryBase(SalaryBase salaryBase) {
		this.salaryBase = salaryBase;
	}

	public int getEmId() {
		return emId;
	}

	public void setEmId(int emId) {
		this.emId = emId;
	}

	public String getEmSerialNumber() {
		return emSerialNumber;
	}

	public void setEmSerialNumber(String emSerialNumber) {
		this.emSerialNumber = emSerialNumber;
	}

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public String getEmSex() {
		return emSex;
	}

	public void setEmSex(String emSex) {
		this.emSex = emSex;
	}

	public int getEmAge() {
		return emAge;
	}

	public void setEmAge(int emAge) {
		this.emAge = emAge;
	}

	public Date getEmBorn() {
		return emBorn;
	}

	public void setEmBorn(Date emBorn) {
		this.emBorn = emBorn;
	}

	public String getEmIdCard() {
		return emIdCard;
	}

	public void setEmIdCard(String emIdCard) {
		this.emIdCard = emIdCard;
	}

	public String getEmMz() {
		return emMz;
	}

	public void setEmMz(String emMz) {
		this.emMz = emMz;
	}

	public String getEmMarriage() {
		return emMarriage;
	}

	public void setEmMarriage(String emMarriage) {
		this.emMarriage = emMarriage;
	}

	public String getEmZzmm() {
		return emZzmm;
	}

	public void setEmZzmm(String emZzmm) {
		this.emZzmm = emZzmm;
	}

	public String getEmJg() {
		return emJg;
	}

	public void setEmJg(String emJg) {
		this.emJg = emJg;
	}

	public String getEmTel() {
		return emTel;
	}

	public void setEmTel(String emTel) {
		this.emTel = emTel;
	}

	public String getEmAddress() {
		return emAddress;
	}

	public void setEmAddress(String emAddress) {
		this.emAddress = emAddress;
	}

	public String getEmGraduateSchool() {
		return emGraduateSchool;
	}

	public void setEmGraduateSchool(String emGraduateSchool) {
		this.emGraduateSchool = emGraduateSchool;
	}

	public String getEmSpeciality() {
		return emSpeciality;
	}

	public void setEmSpeciality(String emSpeciality) {
		this.emSpeciality = emSpeciality;
	}

	public String getEmDegree() {
		return emDegree;
	}

	public void setEmDegree(String emDegree) {
		this.emDegree = emDegree;
	}

	public Date getEmWorkTime() {
		return emWorkTime;
	}

	public void setEmWorkTime(Date emWorkTime) {
		this.emWorkTime = emWorkTime;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getDeptGz() {
		return deptGz;
	}

	public void setDeptGz(String deptGz) {
		this.deptGz = deptGz;
	}

	public String getRegisterName() {
		return registerName;
	}

	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getEmNote() {
		return emNote;
	}

	public void setEmNote(String emNote) {
		this.emNote = emNote;
	}
	 
	 

	 

	 

	 
}
 
