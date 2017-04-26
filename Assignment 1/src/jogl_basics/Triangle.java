package jogl_basics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Triangle {

	public Triangle(GLAutoDrawable gld) {
	}
	
	public void draw(GLAutoDrawable gld, double c1, double c2, double c3, double v1, double v2, double v3, double v4, double v5, double v6) {
		GL2 gl = gld.getGL().getGL2();
		
		gl.glBegin(GL2.GL_TRIANGLES);
		
			gl.glColor3d(c1, c2, c3);
			gl.glVertex2d(v1, v2);
			gl.glVertex2d(v3, v4);
			gl.glVertex2d(v5, v6);
		
		gl.glEnd();	
		
	}
	
}
