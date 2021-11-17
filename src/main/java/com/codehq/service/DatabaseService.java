package com.codehq.service;

import java.util.List;

import com.codehq.model.DeviceLocation;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


public class DatabaseService {
    private String connString = "mongodb+srv://lien-ltk:Kiwi2020@iot-development.htksl.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
    public DatabaseService()
    {
        ConnectionString connectionString = new ConnectionString(connString);
        MongoClient mongoClient = new MongoClient(connString);
        MongoDatabase database = mongoClient.getDatabase("Device");
    }

    public boolean writeDeviceLocation(DeviceLocation deviceData)
    {
        // Insert to database
    	return true;
    }

    public List<DeviceLocation> retrieveDeviceLocations(String deviceId, String fromTimestamp, String toTimestamp)
    {
        // Retrieve from database using deviceId
        if(fromTimestamp != "")
        {
            // Filter records with timestamp >= fromTimestamp
        }

        if(toTimestamp != "")
        {
            // Filter records with timestamp <= toTimestamp
        }
        return null;
        
    }
}
