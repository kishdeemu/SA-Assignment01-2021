package bmiserviceproducer;

public class BMIServicePublishImpl implements BMIServicePublish {
	private float bmi;
	private String result;

	@Override
	public float getBMI(float weight, float height) {
		this.bmi = weight / (height * height);
		return this.bmi;
	}

	@Override
	public String getResult(float bmi) {
		if(bmi < 18.5) {
			this.result = "You are underweight...Eat more...";
		}else if(bmi >= 18.5 && bmi < 24.9) {
			this.result = "You are in healthy range...Keep it up :)....";
		}else if(bmi >= 24.9) {
			this.result = "You are Overweight...Try eating less :(...";
		}else {
			this.result = "INVALID BMI!";
		}
		
		return this.result;
	}

}
