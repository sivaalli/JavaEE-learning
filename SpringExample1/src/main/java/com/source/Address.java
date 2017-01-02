package com.source;

public class Address {
	
		private String address;
		private int zipCode;

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getZipCode() {
			return zipCode;
		}

		public void setZipCode(int zipCode) {
			this.zipCode = zipCode;
		}

		@Override
		public String toString() {
			return "Address [address=" + address + ", zipCode=" + zipCode + "]";
		}
		
		
		
		
	
}
