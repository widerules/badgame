package com.badgame;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class DestopStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new JoglApplication(new Game(), "BadGame", 480, 320, false);
	}

}
