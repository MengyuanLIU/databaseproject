package com.tjw.hrmanage.web.action;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tjw.hrmanage.model.Employee;
import com.tjw.hrmanage.model.SalaryBase;
import com.tjw.hrmanage.model.SalaryRec;
import com.tjw.hrmanage.service.IEmService;
import com.tjw.hrmanage.service.ISalaryRecService;
import com.tjw.hrmanage.util.ChangeTimeType;
import com.tjw.hrmanage.util.MyPagination;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:28:29
 * 2016.4
 */

public class SalaryRecAction extends ActionSupport{
	private ISalaryRecService salaryRecService;
	private IEmService emService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	
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
	private String payMonth;
	 
	/**
	 *基本工资
	 */
	private String baseMoney;
	 
	/**
	 *加班费
	 */
	private String overtimeMoney;
	 
	/**
	 *工龄费
	 */
	private String ageMoney;
	 
	/**
	 *考勤费
	 */
	private String checkMoney;
	 
	/**
	 *旷工费
	 */
	private String absentMoney;
	 
	/**
	 *保险费
	 */
	private String safetyMoney;
	
	/**
	 * 实发工资 
	 */
	private String actualMoney;

	/**
	 *  是否支付，0:已支付，1:未支付
	 */
	private String isPay;

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

	public String getPayMonth() {
		return payMonth;
	}

	public void setPayMonth(String payMonth) {
		this.payMonth = payMonth;
	}

	public String getBaseMoney() {
		return baseMoney;
	}

	public void setBaseMoney(String baseMoney) {
		this.baseMoney = baseMoney;
	}

	public String getOvertimeMoney() {
		return overtimeMoney;
	}

	public void setOvertimeMoney(String overtimeMoney) {
		this.overtimeMoney = overtimeMoney;
	}

	public String getAgeMoney() {
		return ageMoney;
	}

	public void setAgeMoney(String ageMoney) {
		this.ageMoney = ageMoney;
	}

	public String getCheckMoney() {
		return checkMoney;
	}

	public void setCheckMoney(String checkMoney) {
		this.checkMoney = checkMoney;
	}

	public String getAbsentMoney() {
		return absentMoney;
	}

	public void setAbsentMoney(String absentMoney) {
		this.absentMoney = absentMoney;
	}

	public String getSafetyMoney() {
		return safetyMoney;
	}

	public void setSafetyMoney(String safetyMoney) {
		this.safetyMoney = safetyMoney;
	}

	public String getActualMoney() {
		return actualMoney;
	}

	public void setActualMoney(String actualMoney) {
		this.actualMoney = actualMoney;
	}

	public String getIsPay() {
		return isPay;
	}

	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}

	
	public void setEmService(IEmService emService) {
		this.emService = emService;
	}
	public void setSalaryRecService(ISalaryRecService salaryRecService) {
		this.salaryRecService = salaryRecService;
	}
	/**查询所有工资发放记录*/
	public String findAllSalaryRec()
			throws Exception {
		String PageStr = request.getParameter("Page");
		int Page=1;
		if(PageStr==null){
			Page=1;
		}else{
			Page = Integer.parseInt(PageStr);
		}
		try{
			
			List<SalaryRec> list = salaryRecService.findAllSalaryRec();
			//分页操作
			MyPagination pageination = new MyPagination();
			//页大小传递-1表示使用默认pagesize
			List pageList = pageination.getInitPage(list, Page, -1);
			String printCtrl = pageination.printCtrl(Page,"salaryRec_findAllSalaryRec?");
			request.setAttribute("salaryRecList", pageList);
			request.setAttribute("printCtrl", printCtrl);
			return "salaryRecFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
	/**添加薪资展示页面*/
	public String addSalaryRecPage()
			throws Exception {
		
		
		try{
			//查询部门下拉列表
			
			return "salaryRecAdd";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}
	/**添加薪资记录*/
	public String addSalaryRec()
			throws Exception {
		SalaryRec sa = new SalaryRec();
		sa.setEmSerialNumber(getEmSerialNumber());
		sa.setEmName(getEmName());
		sa.setEmDept(getEmDept());
		sa.setPayMonth(ChangeTimeType.changeToDate(getPayMonth()));
		//
		String baseMoneyStr =getBaseMoney();
		double baseMoney=0;
		if(baseMoneyStr!=null){
			baseMoney = Double.parseDouble(baseMoneyStr);
		}
		sa.setBaseMoney(baseMoney);
		//
		String overtimeMoneyStr =getOvertimeMoney();
		double overtimeMoney=0;
		if(overtimeMoneyStr!=null){
			overtimeMoney = Double.parseDouble(overtimeMoneyStr);
		}
		sa.setOvertimeMoney(overtimeMoney);
		//
		String ageMoneyStr =getAgeMoney();
		double ageMoney=0;
		if(ageMoneyStr!=null){
			ageMoney = Double.parseDouble(ageMoneyStr);
		}
		sa.setAgeMoney(ageMoney);
		//
		String checkMoneyStr =getCheckMoney();
		double checkMoney=0;
		if(checkMoneyStr!=null){
			checkMoney = Double.parseDouble(checkMoneyStr);
		}
		sa.setCheckMoney(checkMoney);
		//
		String absentMoneyStr =getAbsentMoney();
		double absentMoney=0;
		if(absentMoneyStr!=null){
			absentMoney = Double.parseDouble(absentMoneyStr);
		}
		sa.setAbsentMoney(absentMoney);
		//
		String safetyMoneyStr =getSafetyMoney();
		double safetyMoney=0;
		if(safetyMoneyStr!=null){
			safetyMoney = Double.parseDouble(safetyMoneyStr);
		}
		sa.setSafetyMoney(safetyMoney);
		//
		String actualMoneyStr =getActualMoney();
		double actualMoney=0;
		if(actualMoneyStr!=null){
			actualMoney = Double.parseDouble(actualMoneyStr);
		}
		sa.setActualMoney(actualMoney);
		
		sa.setIsPay(getIsPay());
		
		
		try{
			String str = salaryRecService.addSalaryRec(sa);
			//设置返回相应页面标识
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "salaryRecAdd";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}
	//修改薪资记录页面跳转
	public String updateSalaryRecPage()
			throws Exception {
		String salaryRecIdStr = request.getParameter("salaryRecId");
		int salaryRecId = 0;
		if(salaryRecIdStr!=null&&salaryRecIdStr!=""){
			salaryRecId = Integer.parseInt(salaryRecIdStr);
		}
		SalaryRec sa = salaryRecService.findSalaryRecById(salaryRecId);
		request.setAttribute("salaryRec", sa);
		return "salaryRecUpdate";
	}
	//修改薪资记录
	public String updateSalaryRec()
		throws Exception {
		String salaryRecIdStr = request.getParameter("salaryRecId");
		int salaryRecId = 0;
		if(salaryRecIdStr!=null&&salaryRecIdStr!=""){
			salaryRecId = Integer.parseInt(salaryRecIdStr);
		}else{
			request.setAttribute("errorInfo", "获取薪资记录信息出错！");
			return "error";
		}
		
		SalaryRec sa = new SalaryRec();
		sa.setSalaryRecId(salaryRecId);
		sa.setEmSerialNumber(getEmSerialNumber());
		sa.setEmName(getEmName());
		sa.setEmDept(getEmDept());
		sa.setPayMonth(ChangeTimeType.changeToDate(getPayMonth()));
		//
		String baseMoneyStr =getBaseMoney();
		double baseMoney=0;
		if(baseMoneyStr!=null){
			baseMoney = Double.parseDouble(baseMoneyStr);
		}
		sa.setBaseMoney(baseMoney);
		//
		String overtimeMoneyStr =getOvertimeMoney();
		double overtimeMoney=0;
		if(overtimeMoneyStr!=null){
			overtimeMoney = Double.parseDouble(overtimeMoneyStr);
		}
		sa.setOvertimeMoney(overtimeMoney);
		//
		String ageMoneyStr =getAgeMoney();
		double ageMoney=0;
		if(ageMoneyStr!=null){
			ageMoney = Double.parseDouble(ageMoneyStr);
		}
		sa.setAgeMoney(ageMoney);
		//
		String checkMoneyStr =getCheckMoney();
		double checkMoney=0;
		if(checkMoneyStr!=null){
			checkMoney = Double.parseDouble(checkMoneyStr);
		}
		sa.setCheckMoney(checkMoney);
		//
		String absentMoneyStr =getAbsentMoney();
		double absentMoney=0;
		if(absentMoneyStr!=null){
			absentMoney = Double.parseDouble(absentMoneyStr);
		}
		sa.setAbsentMoney(absentMoney);
		//
		String safetyMoneyStr =getSafetyMoney();
		double safetyMoney=0;
		if(safetyMoneyStr!=null){
			safetyMoney = Double.parseDouble(safetyMoneyStr);
		}
		sa.setSafetyMoney(safetyMoney);
		//
		String actualMoneyStr =getActualMoney();
		double actualMoney=0;
		if(actualMoneyStr!=null){
			actualMoney = Double.parseDouble(actualMoneyStr);
		}
		sa.setActualMoney(actualMoney);
		
		sa.setIsPay(getIsPay());
		try{
			String str = salaryRecService.updateSalaryRec(sa);
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "salaryRecUpdate";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}

	/**删除薪资记录*/
	public String delSalaryRec()
			throws Exception {
			String salaryRecIdStr = request.getParameter("salaryRecId");
		try{
			int salaryRecId= 0;
			if(salaryRecIdStr!=null&&salaryRecIdStr!=""){
				salaryRecId = Integer.parseInt(salaryRecIdStr);
				
			}else{
				throw new Exception("获取薪资记录信息出错！");
			}
			String str = salaryRecService.delSalaryRec(salaryRecId);
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "salaryRecDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**批量删除薪资信息*/
	public String delSalaryRecBatch()
			throws Exception{
		String salaryRecIdStr = request.getParameter("salaryRecIds");
		try{
			Integer[]  salaryRecIdArr=null;
			if(salaryRecIdStr!=null&&salaryRecIdStr!=""){
				String[] salaryRecIdStrArr = salaryRecIdStr.split(",");
				salaryRecIdArr= new Integer[salaryRecIdStrArr.length];
				for(int i=0;i<salaryRecIdStrArr.length;i++){
					salaryRecIdArr[i]=new Integer(salaryRecIdStrArr[i]);
				}
				
			}else{
				throw new Exception("获取员工信息出错！");
			}
			
			/**批量删除方法之一：但是在这里需要加入事务控制
			for(int j=0;j<emIdArr.length;j++){
				emService.delEm(emIdArr[j]);
			}*/
			/**批量删除方法之二*/
			salaryRecService.delSalaryRecBatch(salaryRecIdArr);
			
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", "删除成功！");
			return "salaryRecDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
		
	}
	//点击检索按钮时进行检索
	public String checkEmBySerialNumber()
			throws Exception {
		String emSerialNumber = request.getParameter("emSerialNumber");
		emSerialNumber = new String(emSerialNumber.getBytes("iso-8859-1"),("utf-8"));
		try{
			Employee em = emService.findEmBySerialNumber(emSerialNumber);
			if(em==null){
				request.setAttribute("checkBySerialNumber", "back");
				request.setAttribute("emSerialNumber_back", emSerialNumber);
				return "salaryRecAdd";
			}
			request.setAttribute("checkBySerialNumber", "back");
			request.setAttribute("emSerialNumber_back", em.getEmSerialNumber());
			request.setAttribute("emName_back", em.getEmName() );
			request.setAttribute("emDept_back", em.getDepartment().getDeptName());
			SalaryBase sa =em.getSalaryBase();
			//sa==null表示该员工没有添加基本薪资信息
			if(sa!=null){
				request.setAttribute("baseMoney_back", (int)sa.getBaseMoney());
				request.setAttribute("safetyMoney_back",(int)sa.getSafetyMoney());
			}
			return "salaryRecAdd";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**查询一条薪资信息*/
	public String findSalaryRecById()
			throws Exception {
		String salaryRecIdStr = request.getParameter("salaryRecId");
		if(salaryRecIdStr==null&&salaryRecIdStr!=""){
			request.setAttribute("errorInfo", "获取薪资记录薪资出错");
			return "error";
		}
		int salaryRecId = Integer.parseInt(salaryRecIdStr);
		try{
			SalaryRec sa = salaryRecService.findSalaryRecById(salaryRecId);
			request.setAttribute("salaryRec", sa);
			return "salaryRecDetail";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
	//根据查询条件查找薪资记录
	public String findSalaryRecByCondition()
			throws Exception {
		String emSerialNumber_search = request.getParameter("emSerialNumber_search");
		String emName_search = request.getParameter("emName_search");
		String payMonth_search_b = request.getParameter("payMonth_search_b");
		String payMonth_search_e = request.getParameter("payMonth_search_e");
		
		String isPay_search = request.getParameter("isPay_search");
		//get方式提交才进行转码
		if("GET".equals(request.getMethod())){
			emSerialNumber_search = new String(emSerialNumber_search.getBytes("iso-8859-1"),("utf-8"));
			emName_search = new String(emName_search.getBytes("iso-8859-1"),"utf-8");
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("emSerialNumber", emSerialNumber_search);
		map.put("emName", emName_search);
		map.put("payMonth_b", payMonth_search_b);
		map.put("payMonth_e", payMonth_search_e);
		map.put("isPay", isPay_search);
		
		try{
			List<SalaryRec> list = salaryRecService.findSalaryRecByCondition(map);
			//分页数据
			String PageStr = request.getParameter("Page");
			int Page=1;
			if(PageStr==null){
				Page=1;
			}else{
				Page = Integer.parseInt(PageStr);
			}
			MyPagination pageination = new MyPagination();
			List<SalaryRec> salaryRecList = pageination.getInitPage(list, Page, -1);
			//要分页，需要保存分页条件application/x-www-form-urlencoded 
			String pageStr = "&emSerialNumber_search="+URLEncoder.encode(emSerialNumber_search,"UTF-8")+
			"&emName_search="+URLEncoder.encode(emName_search,"UTF-8")+"&isPay_search="+isPay_search+"&payMonth_search_b="+payMonth_search_b+"&payMonth_search_e="+payMonth_search_e;
			String printCtrl = pageination.printCtrl(Page,"salaryRec_findSalaryRecByCondition?"+pageStr);
			request.setAttribute("salaryRecList", salaryRecList);
			request.setAttribute("printCtrl", printCtrl);
			//保存页面查询条件
			request.setAttribute("emSerialNumber_save", emSerialNumber_search);
			request.setAttribute("emName_save", emName_search);
			request.setAttribute("isPay_save", isPay_search);
			request.setAttribute("payMonth_save_b", payMonth_search_b);
			request.setAttribute("payMonth_save_e", payMonth_search_e);
			
			return "salaryRecFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
}
