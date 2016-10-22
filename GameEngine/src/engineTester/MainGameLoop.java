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
import renderEngine.OBJLoader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;
import toolbox.KeyboardInput; 

public class MainGameLoop {

	public static void main(String[] args) {
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);
		
		
		
		RawModel model = OBJLoader.loadObjModel("dragon", loader);
		ModelTexture texture = new ModelTexture(loader.loadTexture("wood"));
		TexturedModel textureModel = new TexturedModel(model,texture);
		ModelTexture texture1 = textureModel.getTexture();
		texture1.setShineDamper(20);
		texture1.setReflectivity(.6f);
		
		
		
		Entity entity = new Entity(textureModel, new Vector3f(0,-5,-25),0,0,0,1);
		Light light = new Light(new Vector3f(0,0,-20),new Vector3f(1,1,1));
		
		Camera camera = new Camera();
		
		//main loop
		while(!Display.isCloseRequested()){
			entity.increaseRotation(0,0.5f,0);
			camera.move();
			renderer.prepare();
			shader.start();
			shader.loadLight(light);
			shader.loadViewMatrix(camera);
			renderer.render(entity, shader);
			shader.stop();
			DisplayManager.updateDisplay();
			if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
				break;
			}
		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
