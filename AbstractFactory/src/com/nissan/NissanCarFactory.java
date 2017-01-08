package com.nissan;

import com.source.Car;
import com.source.CarFactory;

public class NissanCarFactory implements CarFactory{

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		Car c=new NissanCar();
		return c;
	}

}
