package com.tjw.hrmanage.model;
import java.util.Date;


/**
 *培训信息
 */
public class Train {
 
	/**
	 *培训id
	 */
	private int trainId;
	 
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

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

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
	 
}
 
