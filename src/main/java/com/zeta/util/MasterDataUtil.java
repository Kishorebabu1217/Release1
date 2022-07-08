package com.zeta.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zeta.model.MasterData;

@Component
public class MasterDataUtil {

	@Autowired
	private ExceptionMsgToExcel exceptionMsgToExcel;

	private static final Logger logger = LoggerFactory.getLogger(MasterDataUtil.class);

	String msg=null;


	public List<MasterData> readFromExcel(){

		List<MasterData> masterData=null;

		try {
			logger.info("Try block executed");
			masterData=new ArrayList<>();

			//Read Excel file as a workbook
			File file=new File("D:\\fileupload\\MasterData.xlsx");
			Workbook book=new XSSFWorkbook(file);

			// Read Sheet
			Sheet s=book.getSheet("MasterFile");

			// Read Rows
			Iterator<Row> itr=s.iterator();

			int i=0;
			double b_Tid=0;

			while (itr.hasNext()) {

				if (i==0) {

					i++;
					Row r=itr.next();
					continue;

				} 

				Row r=itr.next();


				/*
				 * break the loop for row
				 */
				if(r.getCell(0).getNumericCellValue()==0) {
					break;
				}
				if(b_Tid==r.getCell(0).getNumericCellValue()) {
					continue;
				}

				if(r.getCell(1).getNumericCellValue()==0) {
					msg="TENURE MISSING VAlues";
					exceptionMsgToExcel.setBody(r.getCell(0).getNumericCellValue(), r.getCell(1).getNumericCellValue(), r.getCell(2).getNumericCellValue(), msg);
					logger.info("Tennure missing");
					continue;

				}

				if(r.getCell(2).getNumericCellValue()==0) {
					msg="ROI MISSING VAlues";
					exceptionMsgToExcel.setBody(r.getCell(0).getNumericCellValue(), r.getCell(1).getNumericCellValue(), r.getCell(2).getNumericCellValue(), msg);
					logger.info("ROI missing");
					continue;
				}
				// Read one row data and add it into List
				masterData.add(new MasterData(
						(long)r.getCell(0).getNumericCellValue(),
						r.getCell(1).getNumericCellValue(),
						r.getCell(2).getNumericCellValue(),
						r.getCell(3).getStringCellValue(),
						r.getCell(4).getNumericCellValue(),
						r.getCell(5).getStringCellValue(),
						r.getCell(6).getStringCellValue(),
						r.getCell(7).getStringCellValue(),
						r.getCell(8).getStringCellValue(),
						r.getCell(9).getNumericCellValue(),
						r.getCell(10).getStringCellValue(),
						r.getCell(11).getNumericCellValue(),
						r.getCell(12).getStringCellValue(),
						r.getCell(13).getDateCellValue(),
						r.getCell(14).getNumericCellValue(),
						r.getCell(15).getNumericCellValue(),
						r.getCell(16).getNumericCellValue(),
						r.getCell(17).getNumericCellValue(),
						r.getCell(18).getStringCellValue(),
						r.getCell(19).getStringCellValue(),
						r.getCell(20).getNumericCellValue()

						));

				b_Tid=r.getCell(0).getNumericCellValue();

			}

			book.close();
		}catch (Exception e) {
			logger.error("Error occured in catch block");
			e.printStackTrace();

		}

		return masterData;

	}


}
