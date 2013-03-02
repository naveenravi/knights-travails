/**
 * 
 */
package com.naveen.fun;

import java.util.ArrayList;

/**
 * @author naveen
 * this class represents the knight and will have the current position,destination
 * and the path to conquer the quest
 *   
 */
public class Knight {

	private Positions startingPosition;
	private Positions destination;
	private String currentPosition;
	private ArrayList<String>path = new ArrayList<String>();
	
	
	public Knight(String[] positions) {	
		this.currentPosition = positions[0].toLowerCase();
		this.setStartingPosition(positions[0].toLowerCase());		
		this.setDestination(positions[1].toLowerCase());		
	}
		
	public Positions getStartingPosition() {
		return startingPosition;
	}

	public void setStartingPosition(String startingPosition) {
		this.startingPosition = (new Positions(startingPosition,null));
	}

	public Positions getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = (new Positions(destination,null));
	}

	public String getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}

	public ArrayList<String> getPath() {
		return path;
	}

	public void setPath(ArrayList<String> path) {
		this.path = path;
	}	

	public void printPath(){
		System.out.println("printing path now...");
		String moves[] = path.toArray(new String[path.size()]);
		int i=1;
		for(String move : moves)
			System.out.println("Move"+i +" :"+ move);
		    i++;
	}
	/*public boolean goToDestination(){
	
	if(board.calculatePath(this))
	{		
	 if(board.validateMove(Position p1,position p2))
	 {
	  if(board.moveTo(Position p1))
	   {
	    return true;
	   } } } 
	return false;		
}*/

}
