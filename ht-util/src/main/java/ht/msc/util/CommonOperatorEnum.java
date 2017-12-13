package ht.msc.util;

public enum CommonOperatorEnum {
	DELETED("deleted"),
	UPDATED("updated"),
	INSERTED("inserted");
	
	private String operator;
	
	CommonOperatorEnum(String operator){
		this.operator=operator;
	}

	public String getOperator() {
		return operator;
	}
}
