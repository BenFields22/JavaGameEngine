package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
<<<<<<< HEAD
	
	private static final float CAMERA_MOTION = .3f;
	private Vector3f position = new Vector3f(0,0,0);
	private float pitch;
=======
	private Vector3f position = new Vector3f(100,10,150);
	private float pitch = 10;
>>>>>>> 6f78d3c7cf578ac844d5cfbb06d52eeb9a017f6f
	private float yaw;
	private float roll;
	
	public Camera(){
		
	}
	
	public void move(){
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
<<<<<<< HEAD
			position.z-=CAMERA_MOTION;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			position.x+=CAMERA_MOTION;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			position.x-=CAMERA_MOTION;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			position.z+=CAMERA_MOTION;
=======
			position.z-=0.1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			position.x+=0.1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			position.x-=0.1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			position.z+=0.1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_E)){
			position.y +=0.1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_R)){
			position.y -=0.1f;
>>>>>>> 6f78d3c7cf578ac844d5cfbb06d52eeb9a017f6f
		}
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}
	
	

}
