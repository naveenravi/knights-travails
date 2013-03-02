package com.naveen.fun;

public class Positions {

	private Positions prev_move;
	private String position_name;
	
	
	public Positions getPrev_move() {
		return prev_move;
	}


	public void setPrev_move(Positions prev_move) {
		this.prev_move = prev_move;
	}

	public String getPosition_name() {
		return position_name;
	}


	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}


	public Positions(String curr_move,Positions previous_move){
		this.position_name = curr_move;
		this.prev_move = previous_move;
	}
	
	
}

