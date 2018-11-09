package domain;

import java.util.ArrayList;
import java.util.List;

import domain.square.Location;
import domain.square.Square;

public class Board {
	
	private static final int FIRST_LAYER = 56;
	private static final int SECOND_LAYER = 40;
	private static final int THIRD_LAYER = 24;
	private static final int[] BOARD_SIZE = { FIRST_LAYER, SECOND_LAYER, THIRD_LAYER };
	
	private List<Square>[] squares;
	private List<Token> tokens;
	
	public Board() {
		squares =  (ArrayList<Square>[]) new ArrayList[3];
		squares[0] = new ArrayList<>();
		squares[1] = new ArrayList<>();
		squares[2] = new ArrayList<>();
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
	
	public static int getLayerSize(int layer) {
		return BOARD_SIZE[layer];
	}
	
	/**
	 * @param layer layer of the wanted square, 0 is the outermost layer.
	 * @param location Location(index) of the wanted square on the board.
	 * @return Square at the given location.
	 */
	public Square getSquare(Location loc) {
		return squares[loc.getLayer()].get(loc.getIndex());
	}
	
	public Location getSquareLocationFromName(String name) {
		for (int i = 0 ; i < squares.length; i++) {
			for (int j = 0; j < squares[i].size(); j++) {
				if (squares[i].get(j).getName().equals(name)) {
					return new Location(i, j);
				}
			}
		}
		return null;
	}

}
