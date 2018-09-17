package com.codility.switchcase;

public class PlayerCreatorStrategy {
	
	 public Player createPlayer(PlayerTypes playerType) {
		 return PlayerTypes.valueOf(playerType.name()).createPlayer();
	 }

}
