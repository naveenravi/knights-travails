package com.naveen.fun;

import java.util.Scanner;

/**
 * * @author naveen Main class of the application, this class represents the
 * player and co-ordinates the player's intentions with the board and the knight
 */
public class Player {

	public static void main(String args[]) {

		boolean EXIT = false;
		Knight black;
		System.out.println("Welcome!!!");
		Board chessBoard = new Board();
		chessBoard.intialiseBoard();
		do {
			System.out
					.println("Please enter the Starting and Destination Position"
							+ " of the knight. For eg: a5 g7");
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();			
			String[] positions = input.split(" ");
			if (chessBoard.validateInput(positions)) {				
				black = new Knight(positions);
				if (chessBoard.calculatePath(black)) {
					System.out.println("path calculated succesfully, "
							+ "all the best on your conquest!!!");
					black.printPath();
				} else
					System.out.println("failed to see a route, we are doomed!!!");
			} else {
				System.out
						.println("cannot calculate a path for those positions!!"
								+ " please try again.");
			}
			System.out.println("do you want to play again?");
			System.out.println("y/n");
			input = scan.nextLine();
			if (input.equalsIgnoreCase("n")) {
				EXIT = true;
				System.out.println("bye...");
			}

		} while (!EXIT);
	}
}
