package jogl_basics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Buttons {
	
	public Buttons(GLAutoDrawable gld) {
	}
	
	public void draw(GLAutoDrawable gld) {
		GL2 gl = gld.getGL().getGL2();
		
		gl.glColor3d(0,0,0); 
		gl.glBegin(GL2.GL_POLYGON);
			gl.glVertex2d(-0.95, 0.95); 
			gl.glVertex2d(-0.95, 0.85);  
			gl.glVertex2d(-0.65, 0.85);  
			gl.glVertex2d(-0.65, 0.95); 
		gl.glEnd();
		
		gl.glColor3d(0,0,0); 
		gl.glBegin(GL2.GL_POLYGON);
			gl.glVertex2d(-0.55, 0.95); 
			gl.glVertex2d(-0.55, 0.85);  
			gl.glVertex2d(-0.25, 0.85);  
			gl.glVertex2d(-0.25, 0.95); 
		gl.glEnd();
		
		gl.glColor3d(0,0,0); 
		gl.glBegin(GL2.GL_POLYGON);
			gl.glVertex2d(-0.15, 0.95); 
			gl.glVertex2d(-0.15, 0.85);  
			gl.glVertex2d(0.15, 0.85);  
			gl.glVertex2d(0.15, 0.95); 
		gl.glEnd();
		
		gl.glColor3d(0,0,0); 
		gl.glBegin(GL2.GL_POLYGON);
			gl.glVertex2d(0.25, 0.95); 
			gl.glVertex2d(0.25, 0.85);  
			gl.glVertex2d(0.55, 0.85);  
			gl.glVertex2d(0.55, 0.95); 
		gl.glEnd();
		
		gl.glColor3d(0,0,0); 
		gl.glBegin(GL2.GL_POLYGON);
			gl.glVertex2d(0.65, 0.95); 
			gl.glVertex2d(0.65, 0.85);  
			gl.glVertex2d(0.95, 0.85);  
			gl.glVertex2d(0.95, 0.95); 
		gl.glEnd();
	}
	
}
