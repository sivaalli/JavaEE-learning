package com.toyota;

import com.source.Car;
import com.source.CarFactory;

public class ToyotaCarFactory implements CarFactory{

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new ToyotaCar();
	}
	
}
