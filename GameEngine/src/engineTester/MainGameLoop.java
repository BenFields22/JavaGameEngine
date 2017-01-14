package engineTester;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.Entity;
import entities.Light;
import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import renderEngine.EntityRenderer;
import shaders.StaticShader;
import terrains.Terrain;
import textures.ModelTexture;
import toolbox.KeyboardInput; 

public class MainGameLoop {

	public static void main(String[] args) {
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		
		RawModel model = OBJLoader.loadObjModel("stall", loader);
		
		
		TexturedModel textureModel = new TexturedModel(model,new ModelTexture(loader.loadTexture("wood")));
		
		
		
		ModelTexture texture = textureModel.getTexture();
		texture.setShineDamper(20);
		texture.setReflectivity(10f);
		
		

		Entity entity = new Entity(textureModel, new Vector3f(100,0,100),0,0,0,1);
		Light light = new Light(new Vector3f(0,200,0),new Vector3f(1,1,1));
		
		Terrain terrain = new Terrain(0,0,loader,new ModelTexture(loader.loadTexture("grass")));
		Terrain terrain2 = new Terrain(1,0,loader,new ModelTexture(loader.loadTexture("grass")));

		
		Camera camera = new Camera();
		
		MasterRenderer renderer = new MasterRenderer();
		
		//main loop
		while(!Display.isCloseRequested()){
			entity.increaseRotation(0,0.5f,0);
			camera.move();
			
			renderer.processTerrain(terrain);
			renderer.processTerrain(terrain2);
			renderer.processEntity(entity);
			renderer.render(light, camera);
			DisplayManager.updateDisplay();
			if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
				break;
			}
		}
		
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
