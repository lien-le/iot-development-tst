/*=======================================================
 * Copyright (c) 2021 CodeHQ
 * @FileName: DeviceLocation.java
 * @author Lien Le
 * @LastModifyDate: 2021.11.14
 * @LastModifier: 
 * @version 1.0
 * @since 1.0
========================================================*/
package com.codehq.model;

public class DeviceLocation {
	
	public String deviceId;
	
	public double latitude;
	
	public double longitude;
	
	public Data data;

	public DeviceLocation(String deviceId)
	{
		this(deviceId, 0, 0, null);
	}

	public DeviceLocation(String deviceId, double latitude, double longitude, Data data) {
		this.deviceId = deviceId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.data = data != null ? data : new Data();
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}	
	
}
