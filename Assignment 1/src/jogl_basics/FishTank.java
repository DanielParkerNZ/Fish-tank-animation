package jogl_basics;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.gl2.GLUT;


public class FishTank implements GLEventListener {

	private RoundWeed rw1, rw2;
	private Fish fish;
	private Fins fins;
	private Eyes eyes;
	private Buttons buttons;
	private TimeMask tm;
	private Plankton plk;
	private SunAndMoon sun, moon;
	private Quadrilateral buttonArea, sand;
	private Wave wave;
	private Fish2 lilFish;
	private GLUT glut;
	private int font;
	double deg1 = 0.0;
	double deg2 = 360.0;
	double deg3 = 270.0;
	double deg4 = 90.0;
	double alpha = 0.25;
	double fish2x = 0.0;
	double fish2y = 0.0;
	double dx = -0.005;
	boolean day = false;
	boolean finDirectionUp = true;
	
	@Override
	public void display(GLAutoDrawable gld) {
		GL2 gl = gld.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		buttonArea.draw(gld, 0.627, 0.627, 0.627, 1, -1, +0.7, -1, +1, +1, +1, +1, +0.7);
		wave.draw(gld);
		sand.draw(gld, 1.0, 0.91, 0.47, 1, -1, -1, -1, -0.8, 1, -0.8, 1, -1);
		
		//Sun	
		sun.draw(gld, deg3, 1.0, 0.91, 0.47);
		deg3+=0.18;
		if(deg3>=360) {
			deg3=0.0;
		}

		//Moon
		moon.draw(gld, deg4, 1, 1, 1);
		deg4+=0.18;
		if(deg4>=360) {
			deg4=0.0;
		}
		
		//Plankton
		if(alpha >= 0.3) {
			plk.draw(gld);
		}
		
		//Weeds
		rw1.draw(gld);
		rw2.draw(gld);
		
		//Background fish
		lilFish.draw(gld, fish2x, fish2y);
		fish2x+=dx;
		if(fish2x<=-3.0) {
			fish2x = 0.0;
		}
		if(fish2y <= 0.12 && finDirectionUp) {
			fish2y += 0.005;
		} else {
			finDirectionUp = false;
		}
		if(fish2y >= 0.0 && !finDirectionUp) {
			fish2y -= 0.005;
		} else {
			finDirectionUp = true;
		}
		
		//Fish
		fish.draw(gld);
		
		//Buttons
		buttons.draw(gld);
		gl.glColor3d(1,1,1);
		gl.glRasterPos2d(-0.84, 0.89);
		glut.glutBitmapString(font, "Time");
		gl.glColor3d(1,1,1);
		gl.glRasterPos2d(-0.48, 0.89);
		glut.glutBitmapString(font, "Sun & Moon");
		gl.glColor3d(1,1,1);
		gl.glRasterPos2d(-0.06, 0.89);
		glut.glutBitmapString(font, "Plankton");
		gl.glColor3d(1,1,1);
		gl.glRasterPos2d(0.31, 0.89);
		glut.glutBitmapString(font, "Second Fish");
		gl.glColor3d(1,1,1);
		gl.glRasterPos2d(0.74, 0.89);
		glut.glutBitmapString(font, "Bubbles");
		
		//Fins animation
		fins.draw(gld, deg1, deg2);
		deg1+=10;
		if(deg1>=360) {
			deg1=0.0;
		}
		deg2-=10;
		if(deg2<=0.0) {
			deg2=360.0;
		}

		//Mask
		tm.draw(gld, alpha);
		if(day && alpha <= 0.5) {
			alpha+=0.0005;
		} else {
			day = false;
		}
		if(!day && alpha >= 0.0) {
			alpha-=0.0005;
		} else {
			day = true;
		}
		
		//Glow in the dark eyes
		if(alpha >= 0.3) {
			eyes.draw(gld);
		}
		
		gl.glFlush();
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
	
	}

	@Override
	public void init(GLAutoDrawable gld) {
		GL2 gl = gld.getGL().getGL2();
		gl.setSwapInterval(1);
		rw1 = new RoundWeed(-0.7, -1.0, 1.0f, 0.65882f, 0.772549f);
		rw2 = new RoundWeed(-0.4, -1.0, 0.444f, 0.988f, 0.796f);
		fish = new Fish(gld);
		fins = new Fins(gld);
		eyes = new Eyes(gld);
		buttons = new Buttons(gld);
		rw1.create();
		rw2.create();
		tm = new TimeMask(gld);
		plk = new Plankton(gld);
		plk.create();
		sun = new SunAndMoon(gld);
		moon = new SunAndMoon(gld);
		buttonArea = new Quadrilateral(gld);
		sand = new Quadrilateral(gld);
		wave = new Wave(gld);
		wave.create();
		lilFish = new Fish2(gld);
		glut = new GLUT();
		font = GLUT.BITMAP_HELVETICA_18;
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {

	}

	public static void main(String[] args) {
		Frame frame = new Frame("Fish Tank");
		GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas canvas = new GLCanvas(capabilities);
        FishTank ft = new FishTank();
        canvas.addGLEventListener(ft);
        frame.add(canvas);
        frame.setSize(600, 600);
        
        final Animator animator = new Animator(canvas);
        
        frame.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent e) {
                new Thread(new Runnable() {
                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
       
        canvas.requestFocusInWindow();
        
        animator.start();
	}

}