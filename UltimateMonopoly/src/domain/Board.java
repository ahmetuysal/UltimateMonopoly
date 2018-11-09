package domain;

import java.util.ArrayList;
import java.util.List;

import domain.square.Square;

public class Board {
	
	private List<Square> squares;
	private List<Token> tokens;
	
	public Board() {
		squares = new ArrayList<>();
		tokens = new ArrayList<>();
		addSquares();
	}
	
	/**
	 * 
	 * @param token Token to add the board.
	 */
	public void addToken(Token token) {
		tokens.add(token);
	}
	
	
	private void addSquares() {
		
	}
	
	/**
	 * 
	 * @param location Location(index) of the wanted square on the board.
	 * @return Square at the given location.
	 */
	public Square getSquare(int location) {
		return squares.get(location);
	}
	
	public int getSquareIndexFromName(String name) {
		for (int i = 0 ; i < squares.size(); i++) {
			if (squares.get(i).getName().equals(name))
				return i;
		}
		return -1;
	}

}
