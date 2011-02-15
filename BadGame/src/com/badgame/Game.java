package com.badgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Game implements ApplicationListener {

	SpriteBatch spriteBatch;
	Texture texture;
	BitmapFont font;
	Vector2 textPosition = new Vector2(100, 100);
	Vector2 textDirection = new Vector2(1, 1);

	@Override
	public void create() {
		font = new BitmapFont();
		font.setColor(Color.RED);
		texture = new Texture(Gdx.files.internal("data/badlogic.jpg"));
		spriteBatch = new SpriteBatch();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		int centerX = Gdx.graphics.getWidth() / 2;
		int centerY = Gdx.graphics.getHeight() / 2;

		Gdx.graphics.getGL10().glClear(GL10.GL_COLOR_BUFFER_BIT);

		if (textPosition.x < 0 || textPosition.x > Gdx.graphics.getWidth())
			textDirection.x = -textDirection.x;
		if (textPosition.y < 0 || textPosition.y > Gdx.graphics.getHeight())
			textDirection.y = -textDirection.y;

		textPosition.add(textDirection.tmp().mul(Gdx.graphics.getDeltaTime())
				.mul(60));

		spriteBatch.begin();
		spriteBatch.setColor(Color.WHITE);
		spriteBatch.draw(texture, centerX - texture.getWidth() / 2, centerY
				- texture.getHeight() / 2, 0, 0, texture.getWidth(),
				texture.getHeight());
		spriteBatch.setBlendFunction(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA);
		font.draw(spriteBatch, "Hello World!", (int) textPosition.x,
				(int) textPosition.y);
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
		spriteBatch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
		textPosition.set(0, 0);

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}
