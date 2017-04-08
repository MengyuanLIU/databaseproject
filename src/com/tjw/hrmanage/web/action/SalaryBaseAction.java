package com.tjw.hrmanage.web.action;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tjw.hrmanage.model.Department;
import com.tjw.hrmanage.model.Employee;
import com.tjw.hrmanage.model.SalaryBase;
import com.tjw.hrmanage.service.IDeptService;
import com.tjw.hrmanage.service.IEmService;
import com.tjw.hrmanage.util.MyPagination;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:28:25
 * 2016.4
 */

public class SalaryBaseAction extends ActionSupport{
	private IEmService emService;
	private IDeptService deptService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	public void setEmService(IEmService emService) {
		this.emService = emService;
	}
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	/**查询所有员工*/
	public String findAllEmWithSalary()
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
			String printCtrl = pageination.printCtrl(Page,"salaryBase_findAllEmWithSalary.action?");
			request.setAttribute("emList", pageList);
			request.setAttribute("printCtrl", printCtrl);
			return "salaryBaseFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**列表添加薪资页面*/
	public String addSalaryBaseListPage()
			throws Exception {
		try{
			String emIdStr = request.getParameter("emId");
			Employee em=null;
			if(emIdStr!=null&&emIdStr!=""){
				int emId = Integer.parseInt(emIdStr);
				em = emService.findEmById(emId);
			}
			//判断薪资是否存在
			if(em.getSalaryBase()!=null){
				request.setAttribute("isBackFlag", "yes");
				request.setAttribute("returnInfo", "薪资信息已存在，只能做修改，无法新增！");
				return "salaryBaseAdd";
			}
			request.setAttribute("em", em);
			return "salaryBaseAdd";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}
	/**添加薪资*/
	public String addSalaryBase()
			throws Exception {
		String emIdStr = request.getParameter("emId");
		String baseMoneyStr = request.getParameter("baseMoney");
		String safetyMoneyStr = request.getParameter("safetyMoney");
		int emId = 0;
		if(null!=emIdStr&&(!"".equals(emIdStr))){
			emId = Integer.parseInt(emIdStr);
		}
		double baseMoney=0;
		if(null!=baseMoneyStr&&(!"".equals(baseMoneyStr))){
			baseMoney = Double.parseDouble(baseMoneyStr);
		}
		
		double safetyMoney=0;
		if(null!=safetyMoneyStr&&(!"".equals(safetyMoneyStr))){
			safetyMoney = Double.parseDouble(safetyMoneyStr);
		}
		try{
			//查询员工
			Employee em = emService.findEmById(emId);
			SalaryBase sa = new SalaryBase();
			sa.setBaseMoney(baseMoney);
			sa.setSafetyMoney(safetyMoney);
			em.setSalaryBase(sa);
			//更新员工，根据映射关系，当save-update员工表时候，同时salaryBase被更新（salary先被操作），当删除员工时，对应工资记录也被删除
			emService.updateEm(em);
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", "添加薪资信息成功！");
			return "salaryBaseAdd";										
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
	
	//修改薪资页面跳转
	public String updateSalaryBaseListPage()
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
		return "salaryBaseUpdate";
	}
	//修改薪资
	public String updateSalaryBase()
		throws Exception {
		String emIdStr = request.getParameter("emId");
		String baseMoneyStr = request.getParameter("baseMoney");
		String safetyMoneyStr = request.getParameter("safetyMoney");
		int emId = 0;
		if(null!=emIdStr&&(!"".equals(emIdStr))){
			emId = Integer.parseInt(emIdStr);
		}
		double baseMoney=0;
		if(null!=baseMoneyStr&&(!"".equals(baseMoneyStr))){
			baseMoney = Double.parseDouble(baseMoneyStr);
		}
		
		double safetyMoney=0;
		if(null!=safetyMoneyStr&&(!"".equals(safetyMoneyStr))){
			safetyMoney = Double.parseDouble(safetyMoneyStr);
		}
		try{
			//查询员工
			Employee em = emService.findEmById(emId);
			SalaryBase sa = em.getSalaryBase();
			if(sa==null){
				sa=new SalaryBase();
			}
			sa.setBaseMoney(baseMoney);
			sa.setSafetyMoney(safetyMoney);
			em.setSalaryBase(sa);
			//更新员工，根据映射关系，因为cascade为all，当save-update员工表时候，同时salaryBase被更新（salary先被操作），当删除员工时，
			//级联删除此员工的薪资记录
			String str = emService.updateEm(em);
			
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "salaryBaseAdd";	
	}catch(Exception ex){
		request.setAttribute("errorInfo", ex.getMessage());
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
	public String findSalaryBaseByCondition()
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
			String printCtrl = pageination.printCtrl(Page,"salaryBase_findSalaryBaseByCondition.action?"+pageStr);
			request.setAttribute("emList", emListByDept);
			request.setAttribute("printCtrl", printCtrl);
			//保存页面查询条件
			request.setAttribute("emSerialNumber_save", emSerialNumber_search);
			request.setAttribute("emName_save", emName_search);
			request.setAttribute("deptId_save", deptId_search);
			
			//查询部门下拉列表
			List<Department> listDep = deptService.findAllDept();
			request.setAttribute("emDeptList", listDep);
			return "salaryBaseFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
}
