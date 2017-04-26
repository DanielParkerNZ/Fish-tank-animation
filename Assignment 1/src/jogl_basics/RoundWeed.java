package jogl_basics;

import java.util.ArrayList;
import java.util.Random;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class RoundWeed {
	
	double posX, posY;
	float c1, c2, c3;
	Random ran = new Random();
	ArrayList<Point> points = new ArrayList<Point>();
	
	public RoundWeed(double x, double y, float r, float b, float g) {
		this.posX = x;
		this.posY = y;
		this.c1 = r;
		this.c2 = b;
		this.c3 = g;
	}
	
	public void draw(GLAutoDrawable gld) {
		GL2 gl = gld.getGL().getGL2();
		
		gl.glBegin(GL2.GL_TRIANGLE_FAN);
			
			gl.glColor3d(1, 1, 1);
			gl.glVertex2d(posX, posY);
			for(int i=0; i<points.size(); i++) {
				gl.glColor3d(c1, c2, c3);
				Point pt = points.get(i);
				gl.glVertex2d(pt.x, pt.y);
			}
		gl.glEnd();
	}
	
	public void create() {
		for (double i=0.0;i<360;i+=0.2)
		{
			
			float a = ran.nextFloat()/10;
			float b = ran.nextFloat()/10;
		    double x2 = posX+Math.sin(i)*0.2+a;
		    double y2 = posY+Math.cos(i)*0.2+b;
		    Point pt = new Point();
		    pt.x = x2;
		    pt.y = y2;
		    points.add(pt);
		   
		}
	}
	
}
