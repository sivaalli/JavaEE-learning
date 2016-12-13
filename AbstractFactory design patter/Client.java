package com.client;

import com.source.Car;
import com.source.CarFactory;
import com.source.CarFactoryGenerator;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarFactory cf=CarFactoryGenerator.getCarFactoryGenerator().getCarFactory();
		Car c=cf.getCar();
		c.start();
		c.accelerate();
		c.start();
	}

}
