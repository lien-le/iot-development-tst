/*=======================================================
 * Copyright (c) 2021 CodeHQ
 * @FileName: DeviceLocationService.java
 * @author Lien Le
 * @LastModifyDate: 2021.11.14
 * @LastModifier: 
 * @version 1.0
 * @since 1.0
========================================================*/
package com.codehq.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.codehq.model.Data;
import com.codehq.model.DeviceLocation;
import com.codehq.model.Temperature;

@Component
public class DeviceLocationService {
	
	private static final Logger logger = LogManager.getLogger(DeviceLocationService.class);
	private static List<DeviceLocation> deviceLocations = new ArrayList<DeviceLocation>();
	private DatabaseService dataService = new DatabaseService();

	static {
		//Initialise Data
		Temperature temp1 = new Temperature("C", 35.0);
		Temperature temp2 = new Temperature("F", 43.0);
		Temperature temp3 = new Temperature("K", 57.0);
		
		Calendar cal = Calendar.getInstance();
		int year  = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date  = cal.get(Calendar.DATE);
		cal.set(year, month, date);
		Timestamp ts1 = new Timestamp(cal.getTimeInMillis() - 86400000);
		Timestamp ts2 = new Timestamp(cal.getTimeInMillis() - 86400000/2);
		Timestamp ts3 = new Timestamp(cal.getTimeInMillis());
		
		String iso8601Str1 = ts1.toInstant().toString();
		String iso8601Str2 = ts2.toInstant().toString();
		String iso8601Str3 = ts3.toInstant().toString();
		
		Data data1 = new Data(69.0, temp1, iso8601Str1);
		Data data2 = new Data(51.0, temp2, iso8601Str2);
		Data data3 = new Data(83.0, temp3, iso8601Str3);
		
		DeviceLocation device1 = new DeviceLocation("xyz123", 41.25, -120.9762, data1);
		DeviceLocation device2 = new DeviceLocation("chq456", 10.854224, 106.629296, data2);
		DeviceLocation device3 = new DeviceLocation("lie789", 10.861165, 106.605310, data3);
		
		deviceLocations.add(device1);
		deviceLocations.add(device2);
		deviceLocations.add(device3);
	}
	
	public boolean addDeviceLocation(DeviceLocation device) {
		boolean result = false;
		logger.info("Start to save one device location!!!");
		try {
			String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
			if(device.getData() == null) {
				// Throw Exception 
				throw new Exception("Please check your body data!");
			} else {
				// Check timestamp
				if ((device.getData().getTimeStamp()) != "") {
					device.getData().setTimeStamp(timestamp);
					dataService.writeDeviceLocation(device);
					result =  true;
				}
			}
			
		} catch (Exception ex) {
			logger.error("Exception occur: " + ex.getMessage());
		}
		return result;
	}

	public List<DeviceLocation> getDeviceLocations(String deviceId, String fromTimestamp, String toTimestamp)
	{
		return dataService.retrieveDeviceLocations(deviceId, fromTimestamp, toTimestamp);
	}
}
