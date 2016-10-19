package toolbox;

import org.lwjgl.input.Keyboard;

import renderEngine.DisplayManager;

//class maybe useful in the future but not needed yet
public class KeyboardInput {
	
	public static void checkKeys(){
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
			DisplayManager.closeDisplay();
			System.out.println("Exiting Application");
			System.exit(0);
		}
	}
	
}
