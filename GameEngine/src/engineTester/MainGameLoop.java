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
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;
import toolbox.KeyboardInput; 

public class MainGameLoop {

	public static void main(String[] args) {
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		
		RawModel model = OBJLoader.loadObjModel("dragon", loader);
		
		
		TexturedModel textureModel = new TexturedModel(model,new ModelTexture(loader.loadTexture("wood")));
		
		
		
		ModelTexture texture = textureModel.getTexture();
		texture.setShineDamper(20);
		texture.setReflectivity(10f);
		
		
		
		Entity entity = new Entity(textureModel, new Vector3f(0,-5,-25),0,0,0,1);
		Light light = new Light(new Vector3f(0,0,-20),new Vector3f(.3f,0f,1f));
		
		Camera camera = new Camera();
		
		MasterRenderer renderer = new MasterRenderer();
		
		//main loop
		while(!Display.isCloseRequested()){
			entity.increaseRotation(0,0.5f,0);
			camera.move();
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
