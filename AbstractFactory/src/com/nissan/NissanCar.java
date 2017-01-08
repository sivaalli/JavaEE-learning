package com.nissan;

import com.source.Car;

public class NissanCar implements Car{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Nissan car started");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Nissan car stopped");
	}

	@Override
	public void accelerate() {
		// TODO Auto-generated method stub
		System.out.println("Nissan car is accelerating");
	}
	
}
