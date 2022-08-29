package models_reiheAPicker;

public class DdcWhiteListModel {
	
	private double ddcNumber;
	private boolean covers0to100;
	
	public DdcWhiteListModel(double ddcNumber, boolean covers0to100)
	{
		this.ddcNumber = ddcNumber;
		this.covers0to100 = covers0to100;
	}
	
	public double getDdcNumber()
	{
		return this.ddcNumber;
	}
	
	public boolean getCovers0to100()
	{
		return this.covers0to100;
	}
	

}
