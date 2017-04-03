package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MyGdxGame extends ApplicationAdapter {

	private OrthographicCamera camera;

	private TiledMap tiledMap;
	private OrthogonalTiledMapRenderer tiledMapRenderer;

	private FPSLogger logger;

	public final int WIDTH = 320;
	public final int HEIGHT = 480;


	@Override
	public void create() {
		camera = new OrthographicCamera();
	//	camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // カメラを画面サイズに合わせる
		camera.setToOrtho(false, WIDTH, HEIGHT); // カメラをサイズに合わせる


		tiledMap = new TmxMapLoader().load("map_ori.tmx"); // マップファイル読込
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

		logger = new FPSLogger();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update(); // カメラを更新

		tiledMapRenderer.setView(camera); // カメラを設定
		tiledMapRenderer.render();

		// FPS 出力
		logger.log();
	}
}
