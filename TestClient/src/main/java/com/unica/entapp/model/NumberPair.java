package com.unica.entapp.model;

import java.io.Serializable;


public class NumberPair implements Serializable {
	
	int first;
	
	int second;
	
	public NumberPair(){
		super();
	}
	
	public  NumberPair(int first,int second){
		super();
		this.first = first;
		this.second = second;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
}
