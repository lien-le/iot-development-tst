/*=======================================================
 * Copyright (c) 2021 CodeHQ
 * @FileName: Temperature.java
 * @author Lien Le
 * @LastModifyDate: 2021.11.14
 * @LastModifier: 
 * @version 1.0
 * @since 1.0
========================================================*/
package com.codehq.model;


public class Temperature {
	public String unit;
	
	public double ualue;

	public Temperature(String unit, double ualue) {
		this.unit = unit;
		this.ualue = ualue;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getUalue() {
		return ualue;
	}

	public void setUalue(double ualue) {
		this.ualue = ualue;
	}

	
}
