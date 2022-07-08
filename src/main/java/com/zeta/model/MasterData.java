package com.zeta.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "master_data")
public class MasterData {

	// Uniq value-should not be a duplicated
	@Id
	@GeneratedValue
	private Integer id;

	// manditory
	@Column(name = "TID")
	@NotNull
	private Long TID;

	// manditory
	@Column(name = "Tenure")
	@NotNull
	private Integer Tenure;

	// manditory
	@Column(name = "ROI")
	@NotNull
	private Double ROI;

	@Column(name = "DBA_NAME")
	private String DBA_NAME;

	@Column(name = "Old_MECODE")
	private Long Old_MECODE;

	@Column(name = "OLD_TID")
	private String OLD_TID;

	@Column(name = "TID_Type")
	private String TID_Type;

	@Column(name = "Address")
	private String Address;

	@Column(name = "City")
	private String City;

	@Column(name = "PIN")
	private Long PIN;

	@Column(name = "STATE_NAME")
	private String STATE_NAME;

	@Column(name = "New_EMI_TID_TID")
	private Long New_EMI_TID_TID;

	@Column(name = "New_ME_Code")
	private String New_ME_Code;

	@Column(name = "DoN_TID_setup")
	private Date DoN_TID_setup;

	@Column(name = "MDR")
	private Double MDR;

	@Column(name = "Merchant_Payback")
	private Integer Merchant_Payback;

	@Column(name = "Proc_Fee_New")
	private Integer Proc_Fee_New;

	@Column(name = "MCC")
	private Long MCC;

	@Column(name = "LG_CODE")
	private String LG_CODE;

	@Column(name = "LC_CLODE")
	private String LC_CLODE;
	
	@Column(name = "PRINCPAL_AMOUNT")
	private double principal_Amount;
	
	@Column(name="TOTAL_AMOUNT")
	private float totalAmount;

	
	
	public MasterData(long tID, double tenure, double rOI, String dBA_NAME, double old_MECODE, String oLD_TID,
			String tID_Type, String address, String city, double pIN, String sTATE_NAME, double new_EMI_TID_TID,
			String new_ME_Code, Date doN_TID_setup, double mDR, double merchant_Payback, double proc_Fee_New,
			double mCC, String lG_CODE, String lC_CLODE, double principal_Amount) {
		super();
		this.TID = tID;
		this.Tenure = (int) tenure;
		this.ROI = rOI;
		this.DBA_NAME = dBA_NAME;
		this.Old_MECODE = (long) old_MECODE;
		this.OLD_TID = oLD_TID;
		this.TID_Type = tID_Type;
		this.Address = address;
		this.City = city;
		this.PIN = (long) pIN;
		this.STATE_NAME = sTATE_NAME;
		this.New_EMI_TID_TID = (long) new_EMI_TID_TID;
		this.New_ME_Code = new_ME_Code;
		this.DoN_TID_setup = doN_TID_setup;
		this.MDR = mDR;
		this.Merchant_Payback = (int) merchant_Payback;
		this.Proc_Fee_New = (int) proc_Fee_New;
		this.MCC = (long) mCC;
		this.LG_CODE = lG_CODE;
		this.LC_CLODE = lC_CLODE;
		this.principal_Amount=(double)principal_Amount;
	}
 
}
