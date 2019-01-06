package domain.card;

import java.util.ArrayList;
import java.util.List;

import domain.GameController;
import domain.Player;
import domain.square.TitleDeedSquare;
import domain.square.TitleDeedSquareColor;

public class HurricaneMakesLandfall extends Card {

	protected HurricaneMakesLandfall(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard(Player player, String s) {
		// TODO Auto-generated method stub
		GameController g = GameController.getInstance();
		g.findHurricaneSquares();
		TitleDeedSquareColor color = g.promptHurricaneSquares();
		List<TitleDeedSquare> props = player.getTitleDeedsWithColor(color);
		for(int i = 0; i < props.size(); i++) {
			TitleDeedSquare propsI = props.get(i);
			if(propsI.getNumHouses()!=0) {
				propsI.setNumHouses(propsI.getNumHouses()-1);
			}
			else if(propsI.getNumHotels()!=0) {
				propsI.setNumHotels(propsI.getNumHotels()-1);
				propsI.setNumHouses(4);
			}
			else if(propsI.getNumSkyscrapers()!=0) {
				propsI.setNumSkyscrapers(propsI.getNumSkyscrapers()-1);
				propsI.setNumHotels(1);
			}
		}
	}
	

}
