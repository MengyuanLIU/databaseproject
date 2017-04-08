package com.tjw.hrmanage.web.action;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Employee;
import com.tjw.hrmanage.service.IDeptService;
import com.tjw.hrmanage.service.IEmService;
import com.tjw.hrmanage.util.ChangeTimeType;
import com.tjw.hrmanage.util.MyPagination;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:28:06
 * 2016.4
 */
 
public class EmAction extends ActionSupport{
	private IEmService emService;
	private IDeptService deptService;
	private HttpServletRequest request = ServletActionContext.getRequest();
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
	private String emAge;
	 
	/**
	 *员工出生日期
	 */
	private String emBorn;
	 
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
	private String emWorkTime;
	 
	/**
	 *所属部门
	 */
	private String dept;
	

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
	private String registerTime;
	 
	/**
	 *备注信息
	 */
	private String emNote;

	
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

	
	public String getEmAge() {
		return emAge;
	}

	public void setEmAge(String emAge) {
		this.emAge = emAge;
	}

	public String getEmBorn() {
		return emBorn;
	}

	public void setEmBorn(String emBorn) {
		this.emBorn = emBorn;
	}

	public String getEmWorkTime() {
		return emWorkTime;
	}

	public void setEmWorkTime(String emWorkTime) {
		this.emWorkTime = emWorkTime;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getEmNote() {
		return emNote;
	}

	public void setEmNote(String emNote) {
		this.emNote = emNote;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void setEmService(IEmService emService) {
		this.emService = emService;
	}
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}


	/**查询所有员工*/
	public String findAllEm()
			throws Exception {
		String PageStr = request.getParameter("Page");
		int Page=1;
		if(PageStr==null){
			Page=1;
		}else{
			Page = Integer.parseInt(PageStr);
		}
		try{
			//查询部门下拉列表
			List<Department> listDep = deptService.findAllDept();
			request.setAttribute("emDeptList", listDep);
			
			List<Employee> list = emService.findAllEm();
			//分页操作
			MyPagination pageination = new MyPagination();
			//页大小传递-1表示使用默认pagesize
			List pageList = pageination.getInitPage(list, Page, -1);
			String printCtrl = pageination.printCtrl(Page,"em_findAllEm.action?");
			request.setAttribute("emList", pageList);
			request.setAttribute("printCtrl", printCtrl);
			return "emFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**添加员工展示页面*/
	public String addEmPage()
			throws Exception {
		
		
		try{
			//查询部门下拉列表
			List<Department> list = deptService.findAllDept();
			request.setAttribute("emDeptList", list);
			return "emAdd";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}
	/**添加员工*/
	public String addEm()
			throws Exception {
		try{
			//判断员工号(业务主键)是否已经存在
			Employee hasEm = emService.findEmBySerialNumber(getEmSerialNumber());
			if(hasEm!=null){
				request.setAttribute("isBackFlag", "yes");
				request.setAttribute("returnInfo", "添加失败，员工号已经存在！");
				return "emAdd";
			}
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
		Employee e = new Employee();
		e.setEmSerialNumber(getEmSerialNumber());
		e.setEmName(getEmName());
		String ageStr = getEmAge();
		int age = 0;
		if(ageStr!=null){
			age = Integer.parseInt(ageStr);
		}
		e.setEmAge(age);
		e.setEmSex(getEmSex());
		e.setEmIdCard(getEmIdCard());
		e.setEmMz(getEmMz());
		e.setEmMarriage(getEmMarriage());
		e.setEmJg(getEmJg());
		e.setEmZzmm(getEmZzmm());
		e.setEmTel(getEmTel());
		e.setEmGraduateSchool(getEmGraduateSchool());
		e.setEmSpeciality(getEmSpeciality());
		e.setEmAddress(getEmAddress());
		e.setEmDegree(getEmDegree());
		e.setDeptGz(getDeptGz());
		e.setRegisterName(getRegisterName());
		e.setEmNote(getEmNote());
		//部门处理
		String deptIdStr = getDept();
		
		int deptId=0;
		if(deptIdStr!=null){
			deptId = Integer.parseInt(deptIdStr);
		}
		Department dept = emService.findDeptById(deptId);
		e.setDepartment(dept);
		//日期转换
		String born = getEmBorn();
		String workTime = getEmWorkTime();
		String regTime = getRegisterTime();
		Date born2 =ChangeTimeType.changeToDate(born);
		Date workTime2 =ChangeTimeType.changeToDate(workTime);
		Date regTime2 =ChangeTimeType.changeToDate(regTime);
		e.setEmBorn(born2);
		e.setEmWorkTime(workTime2);
		e.setRegisterTime(regTime2);
		try{
			String str = emService.addEm(e);
			//设置返回相应页面标识
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "emAdd";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}
	//修改员工页面跳转
	public String updateEmPage()
			throws Exception {
			//查询部门下拉列表
			List<Department> list = deptService.findAllDept();
			request.setAttribute("emDeptList", list);
			String emIdStr = request.getParameter("emId");
			Employee em=null;
		if(emIdStr!=null&&emIdStr!=""){
			int emId = Integer.parseInt(emIdStr);
			em = emService.findEmById(emId);
			request.setAttribute("em", em);
		}
		return "emUpdate";

	}
	//修改员工
	public String updateEm()
		throws Exception {
	String emIdStr = request.getParameter("emId");
	int emId=0;
	if(emIdStr!=null&&emIdStr!=""){
		emId = Integer.parseInt(emIdStr);
	}else{
		request.setAttribute("errorInfo", "获取员工信息出错！");
		return "error";
	}
	Employee e = new Employee();
	e.setEmId(emId);
	e.setEmSerialNumber(getEmSerialNumber());
	e.setEmName(getEmName());
	String ageStr = getEmAge();
	int age = 0;
	if(ageStr!=null){
		age = Integer.parseInt(ageStr);
	}
	e.setEmAge(age);
	e.setEmSex(getEmSex());
	e.setEmIdCard(getEmIdCard());
	e.setEmMz(getEmMz());
	e.setEmMarriage(getEmMarriage());
	e.setEmJg(getEmJg());
	e.setEmZzmm(getEmZzmm());
	e.setEmTel(getEmTel());
	e.setEmGraduateSchool(getEmGraduateSchool());
	e.setEmSpeciality(getEmSpeciality());
	e.setEmAddress(getEmAddress());
	e.setEmDegree(getEmDegree());
	e.setDeptGz(getDeptGz());
	e.setRegisterName(getRegisterName());
	e.setEmNote(getEmNote());
	//部门处理
	String deptIdStr = getDept();
	
	int deptId=0;
	if(deptIdStr!=null){
		deptId = Integer.parseInt(deptIdStr);
	}
	Department dept = emService.findDeptById(deptId);
	e.setDepartment(dept);
	//日期转换
	String born = getEmBorn();
	String workTime = getEmWorkTime();
	String regTime = getRegisterTime();
	Date born2 =ChangeTimeType.changeToDate(born);
	Date workTime2 =ChangeTimeType.changeToDate(workTime);
	Date regTime2 =ChangeTimeType.changeToDate(regTime);
	e.setEmBorn(born2);
	e.setEmWorkTime(workTime2);
	e.setRegisterTime(regTime2);
	
	try{
		String str = emService.updateEm(e);
		request.setAttribute("isBackFlag", "yes");
		request.setAttribute("returnInfo", str);
		return "emUpdate";
	}catch(Exception ex){
		request.setAttribute("errorInfo", ex.getMessage());
		return "error";
	}
	}

	/**删除员工*/
	public String delEm()
			throws Exception {
			String emIdStr = request.getParameter("emId");
		try{
			int emId= 0;
			if(emIdStr!=null&&emIdStr!=""){
				 emId = Integer.parseInt(emIdStr);
				
			}else{
				throw new Exception("获取员工信息出错！");
			}
			String str = emService.delEm(emId);
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "emDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**批量删除员工信息*/
	public String delEmBatch()
			throws Exception{
		String emIdStr = request.getParameter("emIds");
		try{
			Integer[] emIdArr=null;
			if(emIdStr!=null&&emIdStr!=""){
				String[] emIdStrArr = emIdStr.split(",");
				emIdArr= new Integer[emIdStrArr.length];
				for(int i=0;i<emIdStrArr.length;i++){
					emIdArr[i]=new Integer(emIdStrArr[i]);
				}
				
			}else{
				throw new Exception("获取员工信息出错！");
			}
			
			/**批量删除方法之一：但是在这里需要加入事务控制
			for(int j=0;j<emIdArr.length;j++){
				emService.delEm(emIdArr[j]);
			}*/
			/**批量删除方法之二*/
			emService.delEmBatch(emIdArr);
			
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", "删除成功！");
			return "emDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
		
	}
	/**查询一条员工信息*/
	public String findEmById()
			throws Exception {
		String emIdStr = request.getParameter("emId");
		if(emIdStr==null){
			return null;
		}
		int emId = Integer.parseInt(emIdStr);
		try{
			Employee em = emService.findEmById(emId);
			request.setAttribute("em", em);
			return "emDetail";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	//根据部门查找员工
	public String findEmByDept()
			throws Exception {
		String deptIdStr = request.getParameter("deptId");
		if(deptIdStr==null){
			return null;
		}
		int deptId = Integer.parseInt(deptIdStr);
		
		String PageStr = request.getParameter("Page");
		int Page=1;
		if(PageStr==null){
			Page=1;
		}else{
			Page = Integer.parseInt(PageStr);
		}
		try{
			List<Employee> list = emService.findEmByDept(deptId);
			MyPagination pageination = new MyPagination();
			List<Employee> emListByDept = pageination.getInitPage(list, Page, -1);
			String printCtrl = pageination.printCtrl(Page,"em_findEmByDept.action?deptId="+deptId);
			request.setAttribute("emList", emListByDept);
			request.setAttribute("printCtrl", printCtrl);
			return "emFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	//根据查询条件查找员工
	public String findEmByCondition()
			throws Exception {
		String emSerialNumber_search = request.getParameter("emSerialNumber_search");
		String emName_search = request.getParameter("emName_search");
		String deptId_search = request.getParameter("deptId_search");
		//get方式提交才进行转码
		if("GET".equals(request.getMethod())){
			emSerialNumber_search = new String(emSerialNumber_search.getBytes("iso-8859-1"),("utf-8"));
			emName_search = new String(emName_search.getBytes("iso-8859-1"),"utf-8");
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("emSerialNumber", emSerialNumber_search);
		map.put("emName", emName_search);
		map.put("deptId", deptId_search);
		
		try{
			List<Employee> list = emService.findEmByCondition(map);
			//分页数据
			String PageStr = request.getParameter("Page");
			int Page=1;
			if(PageStr==null){
				Page=1;
			}else{
				Page = Integer.parseInt(PageStr);
			}
			MyPagination pageination = new MyPagination();
			List<Employee> emListByDept = pageination.getInitPage(list, Page, -1);
			//要分页，需要保存分页条件application/x-www-form-urlencoded 
			String pageStr = "&emSerialNumber_search="+URLEncoder.encode(emSerialNumber_search,"UTF-8")+"&emName_search="+URLEncoder.encode(emName_search,"UTF-8")+"&deptId_search="+deptId_search;
			String printCtrl = pageination.printCtrl(Page,"em_findEmByCondition.action?"+pageStr);
			request.setAttribute("emList", emListByDept);
			request.setAttribute("printCtrl", printCtrl);
			//保存页面查询条件
			request.setAttribute("emSerialNumber_save", emSerialNumber_search);
			request.setAttribute("emName_save", emName_search);
			request.setAttribute("deptId_save", deptId_search);
			
			//查询部门下拉列表
			List<Department> listDep = deptService.findAllDept();
			request.setAttribute("emDeptList", listDep);
			return "emFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
}
