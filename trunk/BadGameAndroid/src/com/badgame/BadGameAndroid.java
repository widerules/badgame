package com.badgame;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class BadGameAndroid extends AndroidApplication {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initialize(new Game(), false);
	}
}
