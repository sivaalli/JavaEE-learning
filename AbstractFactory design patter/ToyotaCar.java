package com.toyota;

import com.source.Car;

public class ToyotaCar implements Car{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Toyota car started");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Toyota car stopped");
	}

	@Override
	public void accelerate() {
		// TODO Auto-generated method stub
		System.out.println("Toyota car is accelerating");
	}

}
