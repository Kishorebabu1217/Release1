package com.zeta.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeta.model.MasterData;
import com.zeta.repo.MasterDataRepository;
import com.zeta.service.IMasterDataService;

@Service
public class MasterDataServiceImpl implements IMasterDataService {

	@Autowired
	private MasterDataRepository repo;

	@Override
	public Object[] saveMasterDataAll(List<MasterData> masterDataList) {

		Long ccount = null;
		Object[] objArray = null;
		objArray = masterDataList.toArray();

		for (MasterData m1 : masterDataList) {
			for (int i = 0; i < objArray.length; i++) {
				m1.setTotalAmount(getTotalAmount(m1));
			}
		}
		for (MasterData m : masterDataList) {
			ccount = repo.checkTidExistOrNot(m.getTID());
			if (ccount == 0) {

				objArray = masterDataList.toArray();
				for (int i = 0; i < objArray.length; i++) {
					repo.saveAll(masterDataList);
				}
				return objArray;
			}
		}
		return objArray;
	}

	private float getTotalAmount(MasterData m) {
		float totalAmount = 0.00f;
		Double interest; // principal amount, rate, time and simple interest respectively
		interest = m.getPrincipal_Amount() * m.getROI() * m.getTenure() / 100;
		totalAmount = (float) (interest + m.getPrincipal_Amount());
		return totalAmount;
	}

	
	@Override
	public Optional<MasterData> getOneMasterData(Long id) {

		Integer i = (int) (long) id;

		return repo.findById(i);
	}

	@Override
	public List<MasterData> getAllMasterData() {

		return repo.findAll();
	}

}
