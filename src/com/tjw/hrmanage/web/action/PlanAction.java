package com.tjw.hrmanage.web.action;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;
import com.tjw.hrmanage.service.IPlanService;
import com.tjw.hrmanage.util.ChangeTimeType;
import com.tjw.hrmanage.util.MyPagination;
import com.tjw.hrmanage.model.Plan;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:28:20
 * 2016.4
 */

public class PlanAction extends ActionSupport{
	private IPlanService planService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	/**
	 * 计划标题
	 */
	private String planTitle;
	/**
	 * 计划负责人
	 */
	private String planMan;
	/**
	 * 计划执行日期
	 */
	private String planTime;
	/**
	 * 计划内容
	 */
	private String planContent;
	
	public String getPlanTitle() {
		return planTitle;
	}
	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}
	public String getPlanMan() {
		return planMan;
	}
	
	public String getPlanTime() {
		return planTime;
	}
	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}
	public void setPlanMan(String planMan) {
		this.planMan = planMan;
	}
	public String getPlanContent() {
		return planContent;
	}
	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}
	public void setPlanService(IPlanService planService) {
		this.planService = planService;
	}

	/**查询所有培训信息*/
	public String findAllPlan()
			throws Exception {
		String PageStr = request.getParameter("Page");
		int Page=1;
		if(PageStr==null){
			Page=1;
		}else{
			Page = Integer.parseInt(PageStr);
		}
		try{
			
			List<Plan> list = planService.findAllPlan();
			//分页操作
			MyPagination pageination = new MyPagination();
			//页大小传递-1表示使用默认pagesize
			List pageList = pageination.getInitPage(list, Page, -1);
			String printCtrl = pageination.printCtrl(Page,"plan_findAllPlan?");
			request.setAttribute("planList", pageList);
			request.setAttribute("printCtrl", printCtrl);
			return "planFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
	/**添加页面*/
	public String addPlanPage()
			throws Exception {
		try{
			return "planAdd";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}
	/**添加培训信息*/
	public String addPlan()
			throws Exception {
		Plan p = new Plan();
		
		p.setPlanTitle(getPlanTitle());
		p.setPlanMan(getPlanMan());
		p.setPlanTime(ChangeTimeType.changeToDate(getPlanTime()));
		p.setPlanContent(getPlanContent());
		
		try{
			String str = planService.addPlan(p);
			//设置返回相应页面标识
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "planAdd";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}
	//修改页面跳转
	public String updatePlanPage()
			throws Exception {
			String planIdStr = request.getParameter("planId");
			Plan p=null;
		if(planIdStr!=null&&planIdStr!=""){
			int planId = Integer.parseInt(planIdStr);
			p = planService.findPlanById(planId);
			request.setAttribute("plan", p);
		}
		return "planUpdate";

	}
	//修改
	public String updatePlan()
		throws Exception {
	String planIdStr = request.getParameter("planId");
	int planId=0;
	if(planIdStr!=null&&planIdStr!=""){
		planId = Integer.parseInt(planIdStr);
	}else{
		request.setAttribute("errorInfo", "获取信息出错！");
		return "error";
	}
	Plan p = new Plan();
	p.setPlanId(planId);
	
	p.setPlanTitle(getPlanTitle());
	p.setPlanMan(getPlanMan());
	p.setPlanTime(ChangeTimeType.changeToDate(getPlanTime()));
	p.setPlanContent(getPlanContent());
	
	try{
		String str = planService.updatePlan(p);
		request.setAttribute("isBackFlag", "yes");
		request.setAttribute("returnInfo", str);
		return "planUpdate";
	}catch(Exception ex){
		request.setAttribute("errorInfo", ex.getMessage());
		return "error";
	}
	}

	/**删除*/
	public String delPlan()
			throws Exception {
			String planIdStr = request.getParameter("planId");
		try{
			int planId= 0;
			if(planIdStr!=null&&planIdStr!=""){
				planId = Integer.parseInt(planIdStr);
				
			}else{
				throw new Exception("获取信息出错！");
			}
			String str = planService.delPlan(planId);
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "planDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**批量删除*/
	public String delPlanBatch()
			throws Exception{
		String planIdStr = request.getParameter("planIds");
		try{
			Integer[] planIdArr=null;
			if(planIdStr!=null&&planIdStr!=""){
				String[] planIdStrArr = planIdStr.split(",");
				planIdArr= new Integer[planIdStrArr.length];
				for(int i=0;i<planIdStrArr.length;i++){
					planIdArr[i]=new Integer(planIdStrArr[i]);
				}
				
			}else{
				throw new Exception("获取信息出错！");
			}
			
			
			planService.delPlanBatch(planIdArr);
			
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", "删除成功！");
			return "planDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
		
	}
	/**查询一条信息*/
	public String findPlanById()
			throws Exception {
		String planIdStr = request.getParameter("planId");
		if(planIdStr==null){
			request.setAttribute("errorInfo", "获取信息出错");
			return "error";
		}
		int planId = Integer.parseInt(planIdStr);
		try{
			Plan p = planService.findPlanById(planId);
			request.setAttribute("plan", p);
			return "planDetail";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
	
	//根据查询条件查找
	public String findPlanByCondition()
			throws Exception {
		String planTitle_search = request.getParameter("planTitle_search");
		//get方式提交才进行转码
		if("GET".equals(request.getMethod())){
			planTitle_search = new String(planTitle_search.getBytes("iso-8859-1"),("utf-8"));
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("planTitle", planTitle_search);
		
		try{
			List<Plan> list = planService.findPlanByCondition(map);
			//分页数据
			String PageStr = request.getParameter("Page");
			int Page=1;
			if(PageStr==null){
				Page=1;
			}else{
				Page = Integer.parseInt(PageStr);
			}
			MyPagination pageination = new MyPagination();
			List<Plan> planList = pageination.getInitPage(list, Page, -1);
			//要分页，需要保存分页条件application/x-www-form-urlencoded 
			String pageStr = "&planTitle_search="+URLEncoder.encode(planTitle_search,"UTF-8");
			String printCtrl = pageination.printCtrl(Page,"plan_findPlanByCondition.action?"+pageStr);
			request.setAttribute("planList", planList);
			request.setAttribute("printCtrl", printCtrl);
			//保存页面查询条件
			request.setAttribute("planTitle_save", planTitle_search);
			
			return "planFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
}
