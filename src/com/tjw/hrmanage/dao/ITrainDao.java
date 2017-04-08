package com.tjw.hrmanage.dao;

import java.util.List;
import java.util.Map;

import com.tjw.hrmanage.model.Train;
/**
 * 
 * @author 刘梦源 张宇朋 辛增卫
 *下午5:22:44
 * 2016.4
 */

public interface ITrainDao {
	List<Train> findAllTrain();

	void addTrain(Train t) throws Exception;
	/**根据数据库主键查询*/
	Train findTrainById(int trainId);
	/**根据业务主键查询*/
	
	void updateTrain(Train t);
	
	void updateWithHql(String hql) throws Exception;
	
	void delTrain(Train t);

	/**根据条件查询，使用criteria接口，Expression操作*/
	List<Train> findTrainByCondition(Map m);

	void delTrainBatch(Integer[] trainIdArr) throws Exception;

}
