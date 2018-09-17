package com.codility.switchcase;

public enum PlayerTypes {
	TENNIS {
		@Override
		public Player createPlayer() {
			return new TennisPlayer();
		}
	},
	FOOTBALL {
		@Override
		public Player createPlayer() {
			return new FootballPlayer();
		}
	},
	SNOOKER {
		@Override
		public Player createPlayer() {
			return new SnookerPlayer();
		}
	};

	public abstract Player createPlayer();
}
