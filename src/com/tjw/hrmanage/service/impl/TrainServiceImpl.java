package com.tjw.hrmanage.service.impl;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.dao.ITrainDao;
import com.tjw.hrmanage.model.Train;
import com.tjw.hrmanage.service.ITrainService;

/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:26:27
 * 2016.4
 */

public class TrainServiceImpl implements ITrainService {
	private ITrainDao trainDao;
	

	public void setTrainDao(ITrainDao trainDao) {
		this.trainDao = trainDao;
	}


	public List<Train> findAllTrain() throws Exception {
		List<Train> list = trainDao.findAllTrain();
		return list;
	}


	public String addTrain(Train t) throws Exception {
		trainDao.addTrain(t);
		return "添加成功！";
	}

	public Train findTrainById(int trainId) throws Exception {
		Train t=trainDao.findTrainById(trainId);
		return t;
	}
	
	
	public String updateTrain(Train t) throws Exception {
		trainDao.updateTrain(t);
		return "修改成功！";
	}

	public String delTrain(int trainId) throws Exception {
		Train t = this.findTrainById(trainId);
		if(t==null){
			throw new Exception("要删除的记录不存在！");
		}
		trainDao.delTrain(t);
		return "删除成功！";
	}


	public List<Train> findTrainByCondition(Map m) throws Exception {
		List<Train> list = trainDao.findTrainByCondition(m);
		return list;
	}
	//批量删除
	public String delTrainBatch(Integer[] trainIdArr)throws Exception {
		trainDao.delTrainBatch(trainIdArr);
		return "删除成功！";
	}

}
