package com.bwf.dao;

import com.bwf.entity.AllShift;
import com.bwf.entity.WorkInOut;

public interface WorkInOutMapper {

	void workIn(WorkInOut workInOut);

	void workOut(WorkInOut workInOut);

	void addShift(AllShift allShift);

}
