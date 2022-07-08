package com.zeta.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.zeta.model.MasterData;

public interface MasterDataRepository extends JpaRepository<MasterData, Integer>,JpaSpecificationExecutor<String>{

	@Query(value= "SELECT COUNT(TID) FROM master_data WHERE TID=?1",nativeQuery=true)
	public Long checkTidExistOrNot(Long TID);
	
	@Query(value= "SELECT * FROM master_data WHERE TID=?1",nativeQuery=true)
	public MasterData getMasterData(Long tId);
}
