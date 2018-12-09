package domain.gamestate;

import domain.Player;
import domain.Token;

public class GameStatePlayer {
	
	private String nickName;
	private int totalMoney;
	private boolean isReverseDirection;
	private boolean inJail;
	private int jailTime;
	private Token token;

	// Gson library requires empty constructor
	public GameStatePlayer() {
		
	}
	
	public GameStatePlayer(Player player) {
		this.nickName = player.getNickName();
		this.totalMoney = player.getTotalMoney();
		this.isReverseDirection = player.isReverseDirection();
		this.inJail = player.isInJail();
		this.jailTime = player.getJailTime();
		this.token = player.getToken();
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public boolean isReverseDirection() {
		return isReverseDirection;
	}

	public void setReverseDirection(boolean isReverseDirection) {
		this.isReverseDirection = isReverseDirection;
	}

	public boolean isInJail() {
		return inJail;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	public int getJailTime() {
		return jailTime;
	}

	public void setJailTime(int jailTime) {
		this.jailTime = jailTime;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}
	

}
