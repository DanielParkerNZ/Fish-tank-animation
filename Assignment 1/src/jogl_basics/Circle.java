package jogl_basics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Circle {

	public Circle(GLAutoDrawable gld) {
		
	}
	
	public void draw(GLAutoDrawable gld, double c1, double c2, double c3, double c4, double c5, double c6, double v1, double v2, double r1, double r2) {
		GL2 gl = gld.getGL().getGL2();
		
		gl.glBegin(GL2.GL_TRIANGLE_FAN);
		
			gl.glColor3d(c1,c2,c3);
			gl.glVertex2d(v1, v2);
			
			for (float angle=1.0f;angle<361.0f;angle+=0.2) {
				double x3, y3;
			    x3 = v1+Math.sin(angle)*r1;
			    y3 = v2+Math.cos(angle)*r2;
			    gl.glColor3d(c4,c5,c6);
			    gl.glVertex2d(x3,y3);
			}
	
		gl.glEnd();
		
	}
	
}
