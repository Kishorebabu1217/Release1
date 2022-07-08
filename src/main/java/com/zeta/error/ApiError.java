package com.zeta.error;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiError {

	private Integer errorCode;
	private String errorDesc;
	private Date date;
	
	
}
