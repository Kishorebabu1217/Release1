package com.zeta;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.zeta.model.MasterData;
import com.zeta.repo.MasterDataRepository;
import com.zeta.service.impl.MasterDataServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
class ExcelDataImportToDatabaseApplicationTests {

	@InjectMocks
	private MasterDataServiceImpl masterDataServiceImpl;

	@Mock
	private MasterDataRepository repo;

	@BeforeAll
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testContextLoads() {
		List<MasterData> masterDataList = new ArrayList<>();
		MasterData m = new MasterData();
		m.setId(10);
		m.setCity("Hyderabad");
		m.setTID(10l);
		m.setTenure(10);
		m.setROI(10.00);
		m.setMCC(1l);
		m.setTotalAmount(Mockito.anyFloat());
		masterDataList.add(m);
		Object[] objArrayy = masterDataList.toArray();
		objArrayy[0] = 10;
		Mockito.when(repo.checkTidExistOrNot(101l)).thenReturn(Mockito.anyLong());
		Mockito.when(repo.saveAll(masterDataList)).thenReturn(masterDataList);
		assertNotNull(masterDataServiceImpl.saveMasterDataAll(masterDataList));
	}
	
	@Test
	void testContextLoads1() {
		
		List<MasterData> masterDataList=new ArrayList<>();
		Mockito.when(repo.checkTidExistOrNot(101l)).thenReturn(10l);
		Mockito.when(repo.saveAll(masterDataList)).thenReturn(masterDataList);
		masterDataServiceImpl.saveMasterDataAll(masterDataList);
	}
	
	@Test
	void testGetOneMasterData() {
		
		assertNotNull(masterDataServiceImpl.getOneMasterData(1l));
	}

	@Test
	void testGetAllMasterData() {
		assertNotNull(masterDataServiceImpl.getAllMasterData());
	}
	
	@SuppressWarnings("deprecation")
	@AfterAll
	void after() {
		MockitoAnnotations.initMocks(this);
	}

}
