package com.naveen.fun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * * * @author naveen this class represents the chess board and will have the
 * pieces and their positions
 */
public class Board {

	private static final int MAX_SIZE = 8;
	int chessBoard[][] = new int[MAX_SIZE][MAX_SIZE];
	String chess_columns[] = { "a", "b", "c", "d", "e", "f", "g", "h" };
	String chess_rows[] = { "1", "2", "3", "4", "5", "6", "7", "8" };
	String source_node;

	// intialising a hash map for storing a node and its adjacent nodes
	@SuppressWarnings("rawtypes")
	private static Map<String, ArrayList> adj_nodes = new HashMap<String, ArrayList>();

	/**
	 * finding the adjacent nodes of all the nodes in the board
	 */
	public void setdestinations() {
		for (int i = 0; i < chess_columns.length; i++) {
			for (int j = 0; j < chess_rows.length; j++) {
				source_node = chess_columns[i].concat(chess_rows[j]);
				ArrayList<String> temp = new ArrayList<String>();

				// Checking Boundary conditions and finding nodes accordingly
				if (chess_columns[i].contentEquals("a")) {
					if (chess_rows[j].contentEquals("1")) {
						temp.add(chess_columns[i + 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j + 1]));
						// then they also cannot have y-1 and y-2 nodes
						// alongwith x-1 and x-2
					} else if (chess_rows[j].contentEquals("8")) {
						temp.add(chess_columns[i + 1].concat(chess_rows[j - 2]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j - 1]));
						// then they also cannot have y+1 and y+2 nodes
						// alongwith x-1 and x-2
					} else if (chess_rows[j].contentEquals("2")) {
						temp.add(chess_columns[i + 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j - 1]));
						// then cannot have x+1 y-2 and x-1 y-2 nodes alongwith
						// x-1 and x-2
					} else if (chess_rows[j].contentEquals("7")) {
						temp.add(chess_columns[i + 1].concat(chess_rows[j - 2]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j - 1]));
						// then cannot have x+1 y+2 and x-1 y+2 nodes alongwith
						// x-1 and x-2
					} else {
						// then cannot have x-1 and x-2 nodes
						temp.add(chess_columns[i + 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i + 1].concat(chess_rows[j - 2]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j - 1]));
					}
				} else if (chess_columns[i].contentEquals("h")) {

					if (chess_rows[j].contentEquals("1")) {
						temp.add(chess_columns[i - 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j + 1]));
						// then they also cannot have y-1 and y-2 nodes
						// alongwith x+1 and x+2
					} else if (chess_rows[j].contentEquals("8")) {
						temp.add(chess_columns[i - 1].concat(chess_rows[j - 2]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j - 1]));
						// then they also cannot have y+1 and y+2 nodes
						// alongwith x+1 and x+2
					} else if (chess_rows[j].contentEquals("2")) {
						temp.add(chess_columns[i - 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j - 1]));
						// then cannot have x+1 y-2 and x-1 y-2 nodes alongwith
						// x+1 and x+2
					} else if (chess_rows[j].contentEquals("7")) {
						temp.add(chess_columns[i - 1].concat(chess_rows[j - 2]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j - 1]));
						// then cannot have x+1 y+2 and x-1 y+2 nodes alongwith
						// x+1 and x+2
					} else {
						temp.add(chess_columns[i - 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i - 1].concat(chess_rows[j - 2]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j - 1]));
						// then cannot have x+1 and x+2 nodes
					}
				} else if (chess_columns[i].contentEquals("b")) {

					if (chess_rows[j].contentEquals("1")) {
						temp.add(chess_columns[i + 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i - 1].concat(chess_rows[j + 2]));
						// then they also cannot have y-1 and y-2 nodes
						// alongwith x-2 nodes
					} else if (chess_rows[j].contentEquals("8")) {
						temp.add(chess_columns[i + 1].concat(chess_rows[j - 2]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j - 1]));
						temp.add(chess_columns[i - 1].concat(chess_rows[j - 2]));
						// then they also cannot have y+1 and y+2 nodes
						// alongwith x-2 nodes
					} else if (chess_rows[j].contentEquals("2")) {
						temp.add(chess_columns[i + 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j - 1]));
						temp.add(chess_columns[i - 1].concat(chess_rows[j + 2]));
						// then cannot have x+1 y-2 and x-1 y-2 nodes alongwith
						// x-2 nodes
					} else if (chess_rows[j].contentEquals("7")) {
						temp.add(chess_columns[i + 1].concat(chess_rows[j - 2]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j - 1]));
						temp.add(chess_columns[i - 1].concat(chess_rows[j - 2]));
						// then cannot have x+1 y+2 and x-1 y+2 nodes alongwith
						// x-2 nodes
					} else {
						temp.add(chess_columns[i + 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i + 1].concat(chess_rows[j - 2]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i + 2].concat(chess_rows[j - 1]));
						temp.add(chess_columns[i - 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i - 1].concat(chess_rows[j - 2]));
						// then cannot have x-2 nodes
					}
				} else if (chess_columns[i].contentEquals("g")) {

					if (chess_rows[j].contentEquals("1")) {
						temp.add(chess_columns[i - 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i + 1].concat(chess_rows[j + 2]));
						// then they also cannot have y-1 and y-2 nodes
						// alongwith x+2 nodes
					} else if (chess_rows[j].contentEquals("8")) {
						temp.add(chess_columns[i - 1].concat(chess_rows[j - 2]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j - 1]));
						temp.add(chess_columns[i + 1].concat(chess_rows[j - 2]));
						// then they also cannot have y+1 and y+2 nodes
						// alongwith x+2 nodes*/
					} else if (chess_rows[j].contentEquals("2")) {
						temp.add(chess_columns[i - 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j - 1]));
						temp.add(chess_columns[i + 1].concat(chess_rows[j + 2]));
						// then cannot have x+1 y-2 and x-1 y-2 nodes alongwith
						// x+2 nodes
					} else if (chess_rows[j].contentEquals("7")) {
						temp.add(chess_columns[i - 1].concat(chess_rows[j - 2]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j - 1]));
						temp.add(chess_columns[i + 1].concat(chess_rows[j - 2]));
						// then cannot have x+1 y+2 and x-1 y+2 nodes alongwith
						// x+2 nodes
					} else {
						temp.add(chess_columns[i - 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i - 1].concat(chess_rows[j - 2]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j + 1]));
						temp.add(chess_columns[i - 2].concat(chess_rows[j - 1]));
						temp.add(chess_columns[i + 1].concat(chess_rows[j + 2]));
						temp.add(chess_columns[i + 1].concat(chess_rows[j - 2]));
						// then cannot have x+2 nodes
					}
				} else if (chess_rows[j].contentEquals("1")) {
					temp.add(chess_columns[i + 1].concat(chess_rows[j + 2]));
					temp.add(chess_columns[i - 1].concat(chess_rows[j + 2]));
					temp.add(chess_columns[i + 2].concat(chess_rows[j + 1]));
					temp.add(chess_columns[i - 2].concat(chess_rows[j + 1]));
					// then cannot have y-1 and y-2 nodes
				} else if (chess_rows[j].contentEquals("8")) {
					temp.add(chess_columns[i + 1].concat(chess_rows[j - 2]));
					temp.add(chess_columns[i - 1].concat(chess_rows[j - 2]));
					temp.add(chess_columns[i + 2].concat(chess_rows[j - 1]));
					temp.add(chess_columns[i - 2].concat(chess_rows[j - 1]));
					// then cannot have y+1 and y+2 nodes
				} else if (chess_rows[j].contentEquals("2")) {
					temp.add(chess_columns[i + 1].concat(chess_rows[j + 2]));
					temp.add(chess_columns[i - 1].concat(chess_rows[j + 2]));
					temp.add(chess_columns[i + 2].concat(chess_rows[j + 1]));
					temp.add(chess_columns[i - 2].concat(chess_rows[j + 1]));
					temp.add(chess_columns[i + 2].concat(chess_rows[j - 1]));
					temp.add(chess_columns[i - 2].concat(chess_rows[j - 1]));
					// then cannot have x+1 y-2 and x-1 y-2 nodes
				} else if (chess_rows[j].contentEquals("7")) {
					temp.add(chess_columns[i + 1].concat(chess_rows[j - 2]));
					temp.add(chess_columns[i - 1].concat(chess_rows[j - 2]));
					temp.add(chess_columns[i + 2].concat(chess_rows[j + 1]));
					temp.add(chess_columns[i - 2].concat(chess_rows[j + 1]));
					temp.add(chess_columns[i + 2].concat(chess_rows[j - 1]));
					temp.add(chess_columns[i - 2].concat(chess_rows[j - 1]));
					// then cannot have x+1 y+2 and x-1 y+2 nodes
				} else {
					temp.add(chess_columns[i + 1].concat(chess_rows[j + 2]));
					temp.add(chess_columns[i + 1].concat(chess_rows[j - 2]));
					temp.add(chess_columns[i - 1].concat(chess_rows[j + 2]));
					temp.add(chess_columns[i - 1].concat(chess_rows[j - 2]));
					temp.add(chess_columns[i + 2].concat(chess_rows[j + 1]));
					temp.add(chess_columns[i + 2].concat(chess_rows[j - 1]));
					temp.add(chess_columns[i - 2].concat(chess_rows[j + 1]));
					temp.add(chess_columns[i - 2].concat(chess_rows[j - 1]));
					// can have all the eight nodes
				}
				// creating the list of possible moves for this position
				
				adj_nodes.put(source_node, temp);
			}
		}
	}

	public void intialiseBoard() {
		System.out.println("initialising Chess Board now...");
		setdestinations();
	}

	/**
	 * this method is used to calculate the path for the knight's quest
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public boolean calculatePath(Knight Black_Knight) {
		System.out.println("calculating path now....");
		
		// to record the path traversed so far
		Queue<Positions> current_path = new LinkedList<Positions>();
		// to record the moves tried so far
		ArrayList<String> past_moves= new ArrayList<String>();
		 // to get the possible moves of a position
		ArrayList<String> possible_moves = new ArrayList<String>();
		Positions current_move;
		
		current_path.add(Black_Knight.getStartingPosition());		
		while(!current_path.isEmpty()){
			
			current_move = current_path.remove();
			//checking if this position is the destination
		    if(current_move.getPosition_name().equalsIgnoreCase
		    		(Black_Knight.getDestination().getPosition_name())){
		    	ArrayList<String> final_path = new ArrayList<String>();		    	
		    	while(current_move.getPrev_move()!=null){
		    		final_path.add(current_move.getPosition_name());		    		
		    		current_move = current_move.getPrev_move();
		    	}
		    	Collections.reverse(final_path); // making it user friendly to print		    	
		    	Black_Knight.setPath(final_path);
		    	return true;
		    }
		    else{
		    	//marking the moves tried
		        past_moves.add(current_move.getPosition_name());
		        //getting the possible moves from this position
		    	possible_moves = adj_nodes.get(current_move.getPosition_name());				
				for(String move : possible_moves){
				    if(!past_moves.contains(move)){
				    	current_path.add(new Positions(move,current_move));
				    }
				}
		    }			
		}
		return false;		
	}

	
	public boolean validateInput(String[] positions){
		//if(positions[0].matches("[a-h][1-8]") && positions[1].matches("[a-h][1-8]")){
		if((positions[0].matches("[a-h][1-8]") || positions[0].matches("[A-H][1-8]")) 
				&& (positions[1].matches("[a-h][1-8]") || positions[1].matches("[A-H][1-8]"))){
			if(positions[0].equalsIgnoreCase(positions[1])){
				System.out.println("WOW!! You are already in the destination!!");
				return false;
			}
			return true;	
		}		
		return false;	
	}
	
	/**
	 * this method is used to check if a particular move is legal
	 */
	/*public boolean validateMove() {
		return false;

	}*/

	/**
	 * this method is used to finally move the knight
	 */
	/*public boolean moveTo() {
		return false;

	}*/

}
