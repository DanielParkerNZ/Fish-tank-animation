package jogl_basics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class SunAndMoon {
	
	public SunAndMoon(GLAutoDrawable gld) {
	}
	
	public void draw(GLAutoDrawable gld, double deg, double r, double g, double b) {
		GL2 gl = gld.getGL().getGL2();

		gl.glBegin(GL2.GL_TRIANGLE_FAN);
		
			gl.glColor3d(r, g, b);
	
			for (float angle=1.0f;angle<361.0f;angle+=0.2) {
				double x, y;
			    x = Math.sin(Math.toRadians(deg))*1.2+Math.sin(angle)*0.1;
			    y = -0.5+Math.cos(Math.toRadians(deg))*1.2+Math.cos(angle)*0.1;
			    gl.glColor3d(r, g, b);
			    gl.glVertex2d(x,y);
			}
	
		gl.glEnd();
		
		
		
	}
	
}
