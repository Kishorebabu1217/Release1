package com.zeta.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.varia.ReloadingPropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeta.exception.TidNotFoundException;
import com.zeta.model.MasterData;
import com.zeta.repo.MasterDataRepository;
import com.zeta.service.IMasterDataService;
import com.zeta.util.ExceptionMsgToExcel;
import com.zeta.util.MasterDataUtil;

@RestController
@RequestMapping("/home")
public class MasterDataController {
	
	private static final Logger logger = LoggerFactory.getLogger(MasterDataController.class);
	
	
	@Autowired
	private MasterDataRepository repo;
	@Autowired
	private IMasterDataService service;
	@Autowired
	private MasterDataUtil util;
	
	@Autowired
	private ExceptionMsgToExcel exceptionMsgToExcel;

	@PostMapping("/save")
	public ResponseEntity<String> dataSave(){

		logger.info("MasterDataController dataSave");
		
		ResponseEntity<String> resp=null;
		Object[] saveMasterDataAll=null;
		List<MasterData> list=util.readFromExcel();
			saveMasterDataAll = service.saveMasterDataAll(list);
            logger.error("Records not saved into Database");
		
		if(null!=saveMasterDataAll) {
			logger.info("Records saved into database");
			resp=new ResponseEntity<String>("Excel data Stored in Database...", HttpStatus.OK);
		}else {
			logger.info("Excel data duplicated or fields are empty");
			resp=new ResponseEntity<String>("Excel data duplicated or fields are empty", HttpStatus.NOT_FOUND);
		}
		exceptionMsgToExcel.writeDataToExcel();
		return resp;
	
		
	}

	@GetMapping("/fetch")
	public ResponseEntity<?> getAll(){
		logger.info("MasterDataController getAll");
		ResponseEntity<?> resp=null;
		List<MasterData> masterDataList=service.getAllMasterData();
		if (masterDataList==null || masterDataList.isEmpty()) {
			String message="No Data Found...";
			resp=new ResponseEntity<String>(message,HttpStatus.OK);
		}else {
			resp=new ResponseEntity<List<MasterData>>(masterDataList,HttpStatus.OK);
		}
		return resp;
	}

	@GetMapping("/getOne/{tId}")
	public MasterData getOneTid1(@PathVariable Long tId) {
		
		logger.info("MasterDataController getOneTid1 ");
		
		Long id=repo.checkTidExistOrNot(tId);
		if(id==0)
		{
			logger.info("Record does not exist");
		    throw new TidNotFoundException();
		}
		else {
			logger.info("Record found "+tId);
			return repo.getMasterData(tId);
		}

	}



}
