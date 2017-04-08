package com.tjw.hrmanage.web.action;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;
import com.tjw.hrmanage.service.ITrainService;
import com.tjw.hrmanage.util.MyPagination;
import com.tjw.hrmanage.model.Train;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:28:39
 * 2016.4
 */
 
public class TrainAction extends ActionSupport{
	private ITrainService trainService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	/**
	 *培训人，即培训师
	 */
	private String trainMan;
	 
	/**
	 *培训主题
	 */
	private String trainTitle;
	 
	/**
	 *培训宗旨
	 */
	private String trainZz;
	 
	/**
	 *培训时间
	 */
	private String trainTime;
	 
	/**
	 *培训地点
	 */
	private String trainAddress;
	 
	/**
	 *参加员工
	 */
	private String trainEmps;
	 
	/**
	 *培训备注
	 */
	private String trainNote;

	

	public String getTrainMan() {
		return trainMan;
	}

	public void setTrainMan(String trainMan) {
		this.trainMan = trainMan;
	}

	public String getTrainTitle() {
		return trainTitle;
	}

	public void setTrainTitle(String trainTitle) {
		this.trainTitle = trainTitle;
	}

	public String getTrainZz() {
		return trainZz;
	}

	public void setTrainZz(String trainZz) {
		this.trainZz = trainZz;
	}

	

	public String getTrainTime() {
		return trainTime;
	}

	public void setTrainTime(String trainTime) {
		this.trainTime = trainTime;
	}

	public String getTrainAddress() {
		return trainAddress;
	}

	public void setTrainAddress(String trainAddress) {
		this.trainAddress = trainAddress;
	}

	public String getTrainEmps() {
		return trainEmps;
	}

	public void setTrainEmps(String trainEmps) {
		this.trainEmps = trainEmps;
	}

	public String getTrainNote() {
		return trainNote;
	}

	public void setTrainNote(String trainNote) {
		this.trainNote = trainNote;
	}
	 
	public void setTrainService(ITrainService trainService) {
		this.trainService = trainService;
	}

	/**查询所有培训信息*/
	public String findAllTrain()
			throws Exception {
		String PageStr = request.getParameter("Page");
		int Page=1;
		if(PageStr==null){
			Page=1;
		}else{
			Page = Integer.parseInt(PageStr);
		}
		try{
			
			List<Train> list = trainService.findAllTrain();
			//分页操作
			MyPagination pageination = new MyPagination();
			//页大小传递-1表示使用默认pagesize
			List pageList = pageination.getInitPage(list, Page, -1);
			String printCtrl = pageination.printCtrl(Page,"train_findAllTrain.action?");
			request.setAttribute("trainList", pageList);
			request.setAttribute("printCtrl", printCtrl);
			return "trainFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
	/**添加页面*/
	public String addTrainPage()
			throws Exception {
		try{
			return "trainAdd";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}
	/**添加培训信息*/
	public String addTrain()
			throws Exception {
		Train t = new Train();
		
		t.setTrainTitle(getTrainTitle());
		t.setTrainMan(getTrainMan());
		t.setTrainZz(getTrainZz());
		t.setTrainTime(getTrainTime());
		t.setTrainAddress(getTrainAddress());
		t.setTrainEmps(getTrainEmps());
		t.setTrainNote(getTrainNote());
		
		try{
			String str = trainService.addTrain(t);
			//设置返回相应页面标识
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "trainAdd";
		}catch(Exception ex){
			request.setAttribute("errorInfo", ex.getMessage());
			return "error";
		}
	}
	//修改页面跳转
	public String updateTrainPage()
			throws Exception {
			String trainIdStr = request.getParameter("trainId");
			Train t=null;
		if(trainIdStr!=null&&trainIdStr!=""){
			int trainId = Integer.parseInt(trainIdStr);
			t = trainService.findTrainById(trainId);
			request.setAttribute("train", t);
		}
		return "trainUpdate";

	}
	//修改
	public String updateTrain()
		throws Exception {
	String trainIdStr = request.getParameter("trainId");
	int trainId=0;
	if(trainIdStr!=null&&trainIdStr!=""){
		trainId = Integer.parseInt(trainIdStr);
	}else{
		request.setAttribute("errorInfo", "获取信息出错！");
		return "error";
	}
	Train t = new Train();
	t.setTrainId(trainId);
	
	t.setTrainTitle(getTrainTitle());
	t.setTrainMan(getTrainMan());
	t.setTrainZz(getTrainZz());
	t.setTrainTime(getTrainTime());
	t.setTrainAddress(getTrainAddress());
	t.setTrainEmps(getTrainEmps());
	t.setTrainNote(getTrainNote());
	
	try{
		String str = trainService.updateTrain(t);
		request.setAttribute("isBackFlag", "yes");
		request.setAttribute("returnInfo", str);
		return "trainUpdate";
	}catch(Exception ex){
		request.setAttribute("errorInfo", ex.getMessage());
		return "error";
	}
	}

	/**删除*/
	public String delTrain()
			throws Exception {
			String trainIdStr = request.getParameter("trainId");
		try{
			int trainId= 0;
			if(trainIdStr!=null&&trainIdStr!=""){
				trainId = Integer.parseInt(trainIdStr);
				
			}else{
				throw new Exception("获取信息出错！");
			}
			String str = trainService.delTrain(trainId);
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", str);
			return "trainDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	/**批量删除*/
	public String delTrainBatch()
			throws Exception{
		String trainIdStr = request.getParameter("trainIds");
		try{
			Integer[] trainIdArr=null;
			if(trainIdStr!=null&&trainIdStr!=""){
				String[] trainIdStrArr = trainIdStr.split(",");
				trainIdArr= new Integer[trainIdStrArr.length];
				for(int i=0;i<trainIdStrArr.length;i++){
					trainIdArr[i]=new Integer(trainIdStrArr[i]);
				}
				
			}else{
				throw new Exception("获取信息出错！");
			}
			
			
			trainService.delTrainBatch(trainIdArr);
			
			request.setAttribute("isBackFlag", "yes");
			request.setAttribute("returnInfo", "删除成功！");
			return "trainDelTip";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
		
	}
	/**查询一条信息*/
	public String findTrainById()
			throws Exception {
		String trainIdStr = request.getParameter("trainId");
		if(trainIdStr==null){
			request.setAttribute("errorInfo", "获取信息出错");
			return "error";
		}
		int trainId = Integer.parseInt(trainIdStr);
		try{
			Train t = trainService.findTrainById(trainId);
			request.setAttribute("train", t);
			return "trainDetail";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
	
	//根据查询条件查找
	public String findTrainByCondition()
			throws Exception {
		String trainTitle_search = request.getParameter("trainTitle_search");
		//get方式提交才进行转码
		if("GET".equals(request.getMethod())){
			trainTitle_search = new String(trainTitle_search.getBytes("iso-8859-1"),("utf-8"));
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("trainTitle", trainTitle_search);
		
		try{
			List<Train> list = trainService.findTrainByCondition(map);
			//分页数据
			String PageStr = request.getParameter("Page");
			int Page=1;
			if(PageStr==null){
				Page=1;
			}else{
				Page = Integer.parseInt(PageStr);
			}
			MyPagination pageination = new MyPagination();
			List<Train> trainList = pageination.getInitPage(list, Page, -1);
			//要分页，需要保存分页条件application/x-www-form-urlencoded 
			String pageStr = "&trainTitle_search="+URLEncoder.encode(trainTitle_search,"UTF-8");
			String printCtrl = pageination.printCtrl(Page,"train_findTrainByCondition.action?"+pageStr);
			request.setAttribute("trainList", trainList);
			request.setAttribute("printCtrl", printCtrl);
			//保存页面查询条件
			request.setAttribute("trainTitle_save", trainTitle_search);
			
			return "trainFind";
		}catch(Exception e){
			request.setAttribute("errorInfo", e.getMessage());
			return "error";
		}
	}
	
}
