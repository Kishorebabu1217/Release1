package com.zeta.service;

import java.util.List;
import java.util.Optional;

import com.zeta.model.MasterData;

public interface IMasterDataService {


	//public MasterData saveMasterData(MasterData masterData);
	public Object[] saveMasterDataAll(List<MasterData> masterDataList);
	//public void updateMasterData(MasterData md);
  //  public void deleteMasterData(Integer id);
    public Optional<MasterData> getOneMasterData(Long id);
	public List<MasterData> getAllMasterData();
	//public boolean isPresent(Integer id);
	
}
