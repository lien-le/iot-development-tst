package com.codehq.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codehq.model.DeviceLocation;
import com.codehq.service.DeviceLocationService;

@RestController
@RequestMapping("/api/devices")
public class DeviceLocationController {
	@Autowired
	private DeviceLocationService deviceLocationService;
	
	@GetMapping("/error")
	public String showErrorPage() {
  	  	return String.format("Sorry! There is some problem on your device. System can't receive the information");
    }
	
	@GetMapping("/{deviceId}")
	public List<DeviceLocation> getDeviceData(@PathVariable String deviceId) {
  	  return deviceLocationService.getDeviceLocations(deviceId, "", "");
    }

	@GetMapping("/{deviceId}")
	public List<DeviceLocation> getDeviceDataFromTimeStamp(@PathVariable String deviceId, @RequestParam(name = "from", defaultValue = "") String from) {
  	  return deviceLocationService.getDeviceLocations(deviceId, from, "");
    }

	@GetMapping("/{deviceId}")
	public List<DeviceLocation> getDeviceDataToTimeStamp(@PathVariable String deviceId, @RequestParam(name = "to", defaultValue = "") String to) {
  	  return deviceLocationService.getDeviceLocations(deviceId, "", to);
    }

	@GetMapping("/{deviceId}")
	public List<DeviceLocation> getDeviceDataWithRange(@PathVariable String deviceId, @RequestParam(name = "from", defaultValue = "") String from, @RequestParam(name = "to", defaultValue = "") String to) {
  	  return deviceLocationService.getDeviceLocations(deviceId, from, to);
    }
  
	@PostMapping("")
	public ResponseEntity<Object> saveDeviceData(@RequestBody DeviceLocation deviceData) {

		boolean result =  deviceLocationService.addDeviceLocation(deviceData);
		// Return result to indicate true/false
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/error").buildAndExpand().toUri();
		if(result) {
			location = ServletUriComponentsBuilder.fromCurrentRequest().path(
					"/{deviceId}").buildAndExpand(deviceData.getDeviceId()).toUri();
		} 
		return ResponseEntity.created(location).build();
	}
}
