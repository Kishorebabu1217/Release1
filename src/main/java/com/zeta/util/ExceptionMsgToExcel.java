package com.zeta.util;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExceptionMsgToExcel {

	Workbook book=new XSSFWorkbook();
	//2. create new Sheet
	public Sheet s=book.createSheet("STDS");
	Row r=null;
	static int count=1;
	int i=1;

	public void writeDataToExcel() {
		///boolean status=false;
		try {
			book.write(new FileOutputStream("D:\\Excel\\exceptionfile.xlsx"));
			//3. Create Head and Body
			//setHead();
			r=s.createRow(0);
			r.createCell(0).setCellValue("TID");
			r.createCell(1).setCellValue("TENURE");
			r.createCell(2).setCellValue("ROI");
			r.createCell(3).setCellValue("EXCEPTION_MESSAGE");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setHead() {
		r=s.createRow(0);
		r.createCell(0).setCellValue("TID");
		r.createCell(1).setCellValue("TENURE");
		r.createCell(2).setCellValue("ROI");
		r.createCell(3).setCellValue("MSG");


	}
	public void setBody(double tid,double tenure,double roi,String msg) {
		//Row r=null;


		r=s.createRow(count++);	
		r.createCell(0).setCellValue(tid);
		r.createCell(1).setCellValue(tenure);
		r.createCell(2).setCellValue(roi);
		r.createCell(3).setCellValue(msg);

	}



}
