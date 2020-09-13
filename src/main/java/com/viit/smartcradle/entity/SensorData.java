package com.viit.smartcradle.entity;

import java.io.Serializable;

public class SensorData implements Serializable {

	private static final long serialVersionUID = 1L;

	private double temperature;
	private boolean hasWetDiaper;
	private boolean isCrying;

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temp) {
		this.temperature = temp;
	}

	public boolean getHasWetDiaper() {
		return hasWetDiaper;
	}

	public void setHasWetDiaper(boolean hasWetDiaper) {
		this.hasWetDiaper = hasWetDiaper;
	}

	public boolean getIsCrying() {
		return isCrying;
	}

	public void setIsCrying(boolean isCrying) {
		this.isCrying = isCrying;
	}

	public SensorData() {
		this.temperature = -1;
	}

	public SensorData(double temp, boolean hasWetDiaper, boolean isCrying) {
		super();
		this.temperature = temp;
		this.hasWetDiaper = hasWetDiaper;
		this.isCrying = isCrying;
	}

	public SensorData(String temp, String hasWetDiaper, String isCrying) {
		super();
		this.temperature = Double.parseDouble(temp);
		this.hasWetDiaper = Boolean.parseBoolean(hasWetDiaper);
		this.isCrying = Boolean.parseBoolean(isCrying);
	}

	@Override
	public String toString() {
		return "DisplayData [temp=" + temperature + ", hasWetDiaper=" + hasWetDiaper
				+ ", isCrying=" + isCrying + "]";
	}

}
