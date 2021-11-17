/*=======================================================
 * Copyright (c) 2021 CodeHQ
 * @FileName: DeviceLocationApplication.java
 * @author Lien Le
 * @LastModifyDate: 2021.11.14
 * @LastModifier: 
 * @version 1.0
 * @since 1.0
========================================================*/
package com.codehq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DeviceLocationApplication {
	
	public static void main(String[] args) {
	  SpringApplication.run(DeviceLocationApplication.class, args);
   }
	
}
