package com.viit.smartcradle.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.viit.smartcradle.entity.PostResponseBody;
import com.viit.smartcradle.entity.SensorData;
import com.viit.smartcradle.entity.Status;

@Repository
public class SensorDataDao {

	private String fileName = "data.csv";

	public PostResponseBody addNew(SensorData newSensorData) {
		PostResponseBody prb = new PostResponseBody();

		// first create file object for file placed at location
		// specified by filepath
		File file = new File(fileName);
		boolean exists = file.exists();

		try {
			if (!exists) {
				file.createNewFile();
			}
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file, true);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			// add data to csv
			String[] data = { "" + newSensorData.getTemperature(), "" + newSensorData.getHasWetDiaper(),
					"" + newSensorData.getIsCrying() };
			writer.writeNext(data);
			// closing writer connection
			writer.close();
			prb.setStatus(Status.SUCCESS);
		} catch (IOException e) {
			e.printStackTrace();
			prb.setStatus(Status.FAILURE);
		}
		return prb;
	}

	public SensorData get() throws Exception {
		SensorData d = new SensorData();
		// Create an object of file reader
		// class with CSV file as a parameter.
		FileReader filereader = new FileReader(fileName);

		// create csvReader object and skip first Line
		CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
		List<String[]> allData = csvReader.readAll();

		// print Data
		int size = allData.size();

		if (size >= 1) {
			String[] row = allData.get(allData.size() - 1);
			d = new SensorData(row[0], row[1], row[2]);

			System.out.println("\n\n\nFromdao\nNo. of rows in file: " + size + "\nLatest entry:");
			System.out.println(d);
		}
		return d;
	}

}
