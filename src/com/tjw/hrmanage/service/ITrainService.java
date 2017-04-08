package com.tjw.hrmanage.service;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Candidate;
import com.tjw.hrmanage.model.Train;

/** 
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:25:12
 * 2016.4
 */
 
public interface ITrainService {
	List<Train> findAllTrain() throws Exception;


	String addTrain(Train t) throws Exception;
	/**根据数据库主键查询*/
	Train findTrainById(int trainId)throws Exception;
	
	String updateTrain(Train t) throws Exception;

	String delTrain(int trainId) throws Exception;

	List<Train> findTrainByCondition(Map map) throws Exception;

	String delTrainBatch(Integer[] trainIdArr)throws Exception;
}
