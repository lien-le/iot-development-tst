/*=======================================================
 * Copyright (c) 2021 CodeHQ
 * @FileName: Data.java
 * @author Lien Le
 * @LastModifyDate: 2021.11.14
 * @LastModifier: 
 * @version 1.0
 * @since 1.0
========================================================*/
package com.codehq.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data {
	public double humidity;
	
	public Temperature temperature;
	
	// Using ISO8601 timestamp format, Ex:"2021-11-14T02:00:39.000Z" 
	public String timeStamp;

	public Data()
	{
		this(0, null, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
	}	

	public Data(double humidity, String timestamp)
	{
		this(humidity, null, timestamp);
	}

	public Data(double humidity, Temperature temperature, String timestamp) {
		this.humidity = humidity;
		this.temperature = temperature;
		this.timeStamp = timestamp;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
}
