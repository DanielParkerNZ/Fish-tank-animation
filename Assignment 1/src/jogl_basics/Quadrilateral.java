package jogl_basics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Quadrilateral {

	public Quadrilateral(GLAutoDrawable gld) {
	}
	
	public void draw(GLAutoDrawable gld, double c1, double c2, double c3, double a, double v1, double v2, double v3, double v4, double v5, double v6, double v7, double v8) {
		GL2 gl = gld.getGL().getGL2();
		
		gl.glColor4d(c1, c2, c3, a); 
		
		gl.glBegin(GL2.GL_POLYGON);
			gl.glVertex2d(v1, v2); 
			gl.glVertex2d(v3, v4);  
			gl.glVertex2d(v5, v6);  
			gl.glVertex2d(v7, v8); 
		gl.glEnd();
	}
	
}
