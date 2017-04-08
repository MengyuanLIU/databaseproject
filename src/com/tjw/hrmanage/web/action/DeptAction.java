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
 *下午5:28:01
 * 2016.4
 */
 
public class DeptAction extends ActionSupport{
	private IDeptService deptService;
	private IEmService emService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	/**
	 *部门名称
	 */
	private String deptName;
	 
	/**
	 *创建时间(创建的系统时间)
	 */
	private String createTime;
	 
	/**
	 *部门人数
	 */
	private String peopleNum;
	 
	/**
	 *注备
	 */
	private String deptNote;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(String peopleNum) {
		this.peopleNum = peopleNum;
	}

	public String getDeptNote() {
		return deptNote;
	}

	public void setDeptNote(String deptNote) {
		this.deptNote = deptNote;
	}

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	public void setEmService(IEmService emService) {
		this.emService = emService;
	}
	/**查询所有部门*/
	public String findAllDept()
			throws Exception {
		String PageStr = request.getParameter("Page");
		int Page=1;
		if(PageStr==null){
			Page=1;
		}else{
			Page = Integer.parseInt(PageStr);
		}
		try{
			List<Department> list = deptService.findAllDept();
			//分页操作
			MyPagination pageination = new MyPagination();
			List pageList = pageination.getInitPage(list, Page, -1);
			String printCtrl = pageination.printCtrl(Page,"dept_findAllDept.action?");
			request.setAttribute("deptList", pageList);
			request.setAttribute("printCtrl", printCtrl);
			return "deptFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**添加部门展示页面*/
	public String addDeptPage()
			throws Exception {
		try{
			return "deptAdd";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}
	/**添加部门*/
	public String addDept()
			throws Exception {
		Department d = new Department();
		d.setDeptName(getDeptName());
		String peopleNumStr = getPeopleNum();
		int people = 0;
		if(peopleNumStr!=null){
			people = Integer.parseInt(peopleNumStr);
			
		}
		d.setPeopleNum(people);
		d.setDeptNote(getDeptNote());
		//日期转换
		String creatTimeStr = getCreateTime();
		Date date =ChangeTimeType.changeToDate(creatTimeStr);
		d.setCreateTime(date);
		try{
			String str = deptService.addDept(d);;
			//设置返回相应页面标识
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "deptAdd";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
	
	//修改部门页面跳转
	public String updateDeptPage()
			throws Exception {
			String deptIdStr = request.getParameter("deptId");
			Department dept=null;
		if(deptIdStr!=null&&deptIdStr!=""){
			int deptId = Integer.parseInt(deptIdStr);
			dept = deptService.findDeptById(deptId);
			request.setAttribute("dept", dept);
		}
		return "deptUpdate";

	}
	//修改员工
	public String updateDept()
		throws Exception {
	String deptIdStr = request.getParameter("deptId");
	int deptId=0;
	if(deptIdStr!=null&&deptIdStr!=""){
		deptId = Integer.parseInt(deptIdStr);
	}else{
		request.setAttribute("errorInfo", "获取部门信息出错！");
		return "error";
	}
	Department d = new Department();
	d.setDeptId(deptId);
	d.setDeptName(getDeptName());
	d.setDeptNote(getDeptNote());
	
	//日期转换
	String createTime = getCreateTime();
	Date createTime2 =ChangeTimeType.changeToDate(createTime);
	d.setCreateTime(createTime2);
	try{
		String str = deptService.updateDept(d);
		request.setAttribute("isBackFlag", "yes");
		request.setAttribute("returnInfo", str);
		return "deptUpdate";
	}catch(Exception ex){
		request.setAttribute("errorInfo", ex.getMessage());
		return "error";
	}
	}

	/**删除部门*/
	public String delDept()
			throws Exception {
			String deptIdStr = request.getParameter("deptId");
		try{
			int deptId= 0;
			if(deptIdStr!=null&&deptIdStr!=""){
				deptId = Integer.parseInt(deptIdStr);
				
			}else{
				throw new Exception("获取部门信息出错！");
			}
			//查询部门下是否存在员工，存在则无法删除
			List<Employee> emList= emService.findEmByDept(deptId);
			if(emList.size()>0){
				request.setAttribute("isBackFlag", "yes");
				request.setAttribute("returnInfo", "删除失败！原因：此部门存在员工，请先删除此部门下所有员工信息！");
				return "deptDelTip";
			}
			
			String str = deptService.delDept(deptId);
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "deptDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**批量删除部门信息*/
	public String delDeptBatch()
			throws Exception{
		String deptIdStr = request.getParameter("deptIds");
		try{
			Integer[] deptIdArr=null;
			if(deptIdStr!=null&deptIdStr!=""){
				String[] deptIdStrArr = deptIdStr.split(",");
				deptIdArr= new Integer[deptIdStrArr.length];
				for(int i=0;i<deptIdStrArr.length;i++){
					deptIdArr[i]=new Integer(deptIdStrArr[i]);
				}
				
			}else{
				throw new Exception("获取员工信息出错！");
			}
			//查询部门下是否存在员工，存在则无法删除
			List<Employee> emList= emService.findEmByDeptArr(deptIdArr);
			if(emList.size()>0){
				request.setAttribute("isBackFlag", "yes");
				request.setAttribute("returnInfo", "删除失败！原因：所选部门下存在员工，请先删除部门下所有员工信息！");
				return "deptDelTip";
			}
			
			/**批量删除方法之一：但是在这里需要加入事务控制
			for(int j=0;j<deptIdArr.length;j++){
				deptService.delDept(deptIdArr[j]);
			}*/
			/**批量删除方法之二*/
			deptService.delDeptBatch(deptIdArr);
			
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", "删除成功！");
			return "deptDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
		
	}
	/**查询一条部门信息*/
	public String findDeptById()
			throws Exception {
		String deptIdStr = request.getParameter("deptId");
		if(deptIdStr==null){
			return null;
		}
		int deptId = Integer.parseInt(deptIdStr);
		try{
			Department dept = deptService.findDeptById(deptId);
			request.setAttribute("dept", dept);
			return "deptDetail";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
	//根据查询条件查找部门
	public String findDeptByCondition()
			throws Exception {
		String deptId_search = request.getParameter("deptId_search");
		String deptName_search = request.getParameter("deptName_search");
		//get方式提交才进行转码
		if("GET".equals(request.getMethod())){
			deptId_search = new String(deptId_search.getBytes("iso-8859-1"),("utf-8"));
			deptName_search = new String(deptName_search.getBytes("iso-8859-1"),"utf-8");
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("deptId", deptId_search);
		map.put("deptName", deptName_search);
		
		try{
			List<Department> list = deptService.findDeptByCondition(map);
			//分页数据
			String PageStr = request.getParameter("Page");
			int Page=1;
			if(PageStr==null){
				Page=1;
			}else{
				Page = Integer.parseInt(PageStr);
			}
			MyPagination pageination = new MyPagination();
			List<Department> deptListByDept = pageination.getInitPage(list, Page, -1);
			//要分页，需要保存分页条件application/x-www-form-urlencoded 
			String pageStr = "&deptId_search="+URLEncoder.encode(deptId_search,"UTF-8")+"&deptName_search="+URLEncoder.encode(deptName_search,"UTF-8");
			String printCtrl = pageination.printCtrl(Page,"dept_findDeptByCondition.action?"+pageStr);
			request.setAttribute("deptList", deptListByDept);
			request.setAttribute("printCtrl", printCtrl);
			//保存页面查询条件
			request.setAttribute("deptId_save", deptId_search);
			request.setAttribute("deptName_save", deptName_search);
			
			return "deptFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
}
