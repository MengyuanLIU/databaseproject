package com.tjw.hrmanage.web.action;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;
import com.tjw.hrmanage.service.ICandidateService;
import com.tjw.hrmanage.util.ChangeTimeType;
import com.tjw.hrmanage.util.MyPagination;
import com.tjw.hrmanage.model.Candidate;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:27:55
 * 2016.4
 */

public class CandidateAction extends ActionSupport{
	private ICandidateService candidateService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	/**
	 *应聘者id
	 */
	private int cdtId;
	 
	/**
	 *应聘人姓名
	 */
	private String cdtName;
	 
	/**
	 *应聘人性别
	 */
	private String cdtSex;
	 
	/**
	 *应聘人年龄
	 */
	private int cdtAge;
	 
	/**
	 *应聘人出生日期
	 */
	private String cdtBorn;
	 
	/**
	 *应聘职位名称
	 */
	private String cdtPosition;
	 
	/**
	 *专业
	 */
	private String cdtSpeciality;
	 
	/**
	 *毕业院校
	 */
	private String cdtGraduateSchool;
	 
	/**
	 *学历
	 */
	private String cdtDegree;
	 
	/**
	 *工作经验
	 */
	private String cdtExperience;
	 
	/**
	 *联系电话
	 */
	private String cdtTel;
	 
	/**
	 *联系地址
	 */
	private String cdtAddress;
	 
	/**
	 *登记时间
	 */
	private String cdtRegTime;
	 
	/**
	 *个人简介
	 */
	private String cdtIntro;
	 
	/**
	 *是否被录用
	 */
	private String isHire;

	public int getCdtId() {
		return cdtId;
	}

	public void setCdtId(int cdtId) {
		this.cdtId = cdtId;
	}

	public String getCdtName() {
		return cdtName;
	}

	public void setCdtName(String cdtName) {
		this.cdtName = cdtName;
	}

	public String getCdtSex() {
		return cdtSex;
	}

	public void setCdtSex(String cdtSex) {
		this.cdtSex = cdtSex;
	}

	public int getCdtAge() {
		return cdtAge;
	}

	public void setCdtAge(int cdtAge) {
		this.cdtAge = cdtAge;
	}

	public String getCdtBorn() {
		return cdtBorn;
	}

	public void setCdtBorn(String cdtBorn) {
		this.cdtBorn = cdtBorn;
	}

	public String getCdtPosition() {
		return cdtPosition;
	}

	public void setCdtPosition(String cdtPosition) {
		this.cdtPosition = cdtPosition;
	}

	public String getCdtSpeciality() {
		return cdtSpeciality;
	}

	public void setCdtSpeciality(String cdtSpeciality) {
		this.cdtSpeciality = cdtSpeciality;
	}

	public String getCdtGraduateSchool() {
		return cdtGraduateSchool;
	}

	public void setCdtGraduateSchool(String cdtGraduateSchool) {
		this.cdtGraduateSchool = cdtGraduateSchool;
	}

	public String getCdtDegree() {
		return cdtDegree;
	}

	public void setCdtDegree(String cdtDegree) {
		this.cdtDegree = cdtDegree;
	}

	public String getCdtExperience() {
		return cdtExperience;
	}

	public void setCdtExperience(String cdtExperience) {
		this.cdtExperience = cdtExperience;
	}

	public String getCdtTel() {
		return cdtTel;
	}

	public void setCdtTel(String cdtTel) {
		this.cdtTel = cdtTel;
	}

	public String getCdtAddress() {
		return cdtAddress;
	}

	public void setCdtAddress(String cdtAddress) {
		this.cdtAddress = cdtAddress;
	}

	public String getCdtRegTime() {
		return cdtRegTime;
	}

	public void setCdtRegTime(String cdtRegTime) {
		this.cdtRegTime = cdtRegTime;
	}

	public String getCdtIntro() {
		return cdtIntro;
	}

	public void setCdtIntro(String cdtIntro) {
		this.cdtIntro = cdtIntro;
	}

	public String getIsHire() {
		return isHire;
	}

	public void setIsHire(String isHire) {
		this.isHire = isHire;
	}
	
	public void setCandidateService(ICandidateService candidateService) {
		this.candidateService = candidateService;
	}
	/**查询所有应聘者*/
	public String findAllCdt()
			throws Exception {
		String PageStr = request.getParameter("Page");
		int Page=1;
		if(PageStr==null){
			Page=1;
		}else{
			Page = Integer.parseInt(PageStr);
		}
		try{
			
			List<Candidate> list = candidateService.findAllCdt();
			//分页操作
			MyPagination pageination = new MyPagination();
			//页大小传递-1表示使用默认pagesize
			List pageList = pageination.getInitPage(list, Page, -1);
			String printCtrl = pageination.printCtrl(Page,"cdt_findAllCdt.action?");
			request.setAttribute("cdtList", pageList);
			request.setAttribute("printCtrl", printCtrl);
			return "cdtFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
	/**添加应聘者展示页面*/
	public String addCdtPage()
			throws Exception {
		try{
			return "cdtAdd";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}
	/**添加应聘者*/
	public String addCdt()
			throws Exception {
		
		Candidate c = new Candidate();
		
		c.setCdtAddress(getCdtAddress());
		c.setCdtAge(getCdtAge());
		c.setCdtBorn(ChangeTimeType.changeToDate(getCdtBorn()));
		c.setCdtDegree(getCdtDegree());
		c.setCdtExperience(getCdtExperience());
		c.setCdtGraduateSchool(getCdtGraduateSchool());
		c.setCdtIntro(getCdtIntro());
		c.setCdtName(getCdtName());
		c.setCdtPosition(getCdtPosition());
		c.setCdtRegTime(ChangeTimeType.changeToDate(getCdtRegTime()));
		c.setCdtSex(getCdtSex());
		c.setCdtSpeciality(getCdtSpeciality());
		c.setCdtTel(getCdtTel());
		c.setIsHire(getIsHire());
		
		try{
			String str = candidateService.addCdt(c);
			//设置返回相应页面标识
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "cdtAdd";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}
	//修改应聘者页面跳转
	public String updateCdtPage()
			throws Exception {
			//查询部门下拉列表
			String cdtIdStr = request.getParameter("cdtId");
			Candidate c=null;
		if(cdtIdStr!=null&&cdtIdStr!=""){
			int cdtId = Integer.parseInt(cdtIdStr);
			c = candidateService.findCdtById(cdtId);
			request.setAttribute("cdt", c);
		}
		return "cdtUpdate";

	}
	//修改应聘者
	public String updateCdt()
		throws Exception {
	String cdtIdStr = request.getParameter("cdtId");
	int cdtId=0;
	if(cdtIdStr!=null&&cdtIdStr!=""){
		cdtId = Integer.parseInt(cdtIdStr);
	}else{
		request.setAttribute("errorInfo", "获取应聘者信息出错！");
		return "error";
	}
	Candidate c = new Candidate();
	c.setCdtId(cdtId);
	
	c.setCdtAddress(getCdtAddress());
	c.setCdtAge(getCdtAge());
	c.setCdtBorn(ChangeTimeType.changeToDate(getCdtBorn()));
	c.setCdtDegree(getCdtDegree());
	c.setCdtExperience(getCdtExperience());
	c.setCdtGraduateSchool(getCdtGraduateSchool());
	c.setCdtIntro(getCdtIntro());
	c.setCdtName(getCdtName());
	c.setCdtPosition(getCdtPosition());
	c.setCdtRegTime(ChangeTimeType.changeToDate(getCdtRegTime()));
	c.setCdtSex(getCdtSex());
	c.setCdtSpeciality(getCdtSpeciality());
	c.setCdtTel(getCdtTel());
	c.setIsHire(getIsHire());
	
	try{
		String str = candidateService.updateCdt(c);
		request.setAttribute("isBackFlag", "yes");
		request.setAttribute("returnInfo", str);
		return "cdtUpdate";
	}catch(Exception ex){
		request.setAttribute("errorInfo", ex.getMessage());
		return "error";
	}
	}

	/**删除应聘者*/
	public String delCdt()
			throws Exception {
			String cdtIdStr = request.getParameter("cdtId");
		try{
			int cdtId= 0;
			if(cdtIdStr!=null&&cdtIdStr!=""){
				 cdtId = Integer.parseInt(cdtIdStr);
				
			}else{
				throw new Exception("获取应聘者信息出错！");
			}
			String str = candidateService.delCdt(cdtId);
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "cdtDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**批量删除应聘者信息*/
	public String delCdtBatch()
			throws Exception{
		String cdtIdStr = request.getParameter("cdtIds");
		try{
			Integer[] cdtIdArr=null;
			if(cdtIdStr!=null&&cdtIdStr!=""){
				String[] cdtIdStrArr = cdtIdStr.split(",");
				cdtIdArr= new Integer[cdtIdStrArr.length];
				for(int i=0;i<cdtIdStrArr.length;i++){
					cdtIdArr[i]=new Integer(cdtIdStrArr[i]);
				}
				
			}else{
				throw new Exception("获取应聘者信息出错！");
			}
			
			
			candidateService.delCdtBatch(cdtIdArr);
			
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", "删除成功！");
			return "cdtDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
		
	}
	/**查询一条应聘者信息*/
	public String findCdtById()
			throws Exception {
		String cdtIdStr = request.getParameter("cdtId");
		if(cdtIdStr==null){
			return null;
		}
		int cdtId = Integer.parseInt(cdtIdStr);
		try{
			Candidate c = candidateService.findCdtById(cdtId);
			request.setAttribute("cdt", c);
			return "cdtDetail";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
	/**列表录用操作*/
	public String listHire()
			throws Exception {
		String cdtIdStr = request.getParameter("cdtId");
		if(cdtIdStr==null){
			request.setAttribute("errorInfo", "获取信息出错！");
			return "error";
		}
		int cdtId = Integer.parseInt(cdtIdStr);
		try{
			String str = candidateService.listHire(cdtId);
			request.setAttribute("returnInfo", str);
			return "listHireTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
	//根据查询条件查找应聘者
	public String findCdtByCondition()
			throws Exception {
		String cdtName_search = request.getParameter("cdtName_search");
		String isHire_search = request.getParameter("isHire_search");
		//get方式提交才进行转码
		if("GET".equals(request.getMethod())){
			cdtName_search = new String(cdtName_search.getBytes("iso-8859-1"),("utf-8"));
			isHire_search = new String(isHire_search.getBytes("iso-8859-1"),"utf-8");
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("cdtName", cdtName_search);
		map.put("isHire", isHire_search);
		
		try{
			List<Candidate> list = candidateService.findCdtByCondition(map);
			//分页数据
			String PageStr = request.getParameter("Page");
			int Page=1;
			if(PageStr==null){
				Page=1;
			}else{
				Page = Integer.parseInt(PageStr);
			}
			MyPagination pageination = new MyPagination();
			List<Candidate> cdtList = pageination.getInitPage(list, Page, -1);
			//要分页，需要保存分页条件application/x-www-form-urlencoded 
			String pageStr = "&cdtName_search="+URLEncoder.encode(cdtName_search,"UTF-8")+"&isHire_search="+URLEncoder.encode(isHire_search,"UTF-8");
			String printCtrl = pageination.printCtrl(Page,"cdt_findCdtByCondition.action?"+pageStr);
			request.setAttribute("cdtList", cdtList);
			request.setAttribute("printCtrl", printCtrl);
			//保存页面查询条件
			request.setAttribute("cdtName_save", cdtName_search);
			request.setAttribute("isHire_save", isHire_search);
			
			return "cdtFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
}
