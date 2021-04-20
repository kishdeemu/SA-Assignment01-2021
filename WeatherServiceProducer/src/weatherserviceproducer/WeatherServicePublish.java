package weatherserviceproducer;

import java.io.IOException;

public interface WeatherServicePublish {
	public String getDesciption(String cityName) throws IOException;
	public double getTemperature(String cityName) throws IOException;
	public int getHumidity(String cityName) throws IOException;

}
