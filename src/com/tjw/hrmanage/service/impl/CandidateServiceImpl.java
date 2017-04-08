package com.tjw.hrmanage.service.impl;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.dao.ICandidateDao;
import com.tjw.hrmanage.model.Candidate;
import com.tjw.hrmanage.service.ICandidateService;
/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:25:21
 * 2016.4
 */
 
public class CandidateServiceImpl implements ICandidateService {
	private ICandidateDao candidateDao;
	
	public void setCandidateDao(ICandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}

	public List<Candidate> findAllCdt() throws Exception {
		List<Candidate> list = candidateDao.findAllCdt();
		return list;
	}


	public String addCdt(Candidate c) throws Exception {
		candidateDao.addCdt(c);
		return "添加成功！";
	}

	public Candidate findCdtById(int cdtId) throws Exception {
		Candidate c=candidateDao.findCdtById(cdtId);
		return c;
	}
	
	
	public String updateCdt(Candidate c) throws Exception {
		candidateDao.updateCdt(c);
		return "修改成功！";
	}

	public String delCdt(int cdtId) throws Exception {
		Candidate c = this.findCdtById(cdtId);
		if(c==null){
			throw new Exception("要删除的记录不存在！");
		}
		candidateDao.delCdt(c);
		return "删除成功！";
	}


	public List<Candidate> findCdtByCondition(Map m) throws Exception {
		List<Candidate> list = candidateDao.findCdtByCondition(m);
		return list;
	}
	//批量删除
	public String delCdtBatch(Integer[] cdtIdArr)throws Exception {
		candidateDao.delCdtBatch(cdtIdArr);
		return "删除成功！";
	}

	public String listHire(int cdtId) throws Exception {
		Candidate c = candidateDao.findCdtById(cdtId);
		c.setIsHire("是");
		candidateDao.updateCdt(c);
		return "录用成功！";
	}


	

}
