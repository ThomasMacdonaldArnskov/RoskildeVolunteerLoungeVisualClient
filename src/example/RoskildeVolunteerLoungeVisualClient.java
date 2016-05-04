package example;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.*;

public class RoskildeVolunteerLoungeVisualClient extends BasicGame
{
	private Image wires, bg, toplayer;
	//Image[] flamstart = new Image[250];

    FlammableAnim flamAnim;
    FlammableAnim flamAnim2;




    public RoskildeVolunteerLoungeVisualClient(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		wires = new Image("assets/wires.png");
		bg = new Image("assets/bg.png");
		toplayer = new Image("assets/toplayer.png");
        flamAnim = new FlammableAnim();
        flamAnim2 = new FlammableAnim();

		/*for (int i = 1; i < flamstart.length; i++) {
            if (i < 10) {
                flamstart[i - 1] = new Image("/assets/flam/anim000" + i + ".png");
            } else if (i < 100){
                flamstart[i - 1] = new Image("/assets/flam/anim00" + i + ".png");
            } else {
                flamstart[i - 1] = new Image("/assets/flam/anim0" + i + ".png");
            }
		}*/

	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawImage(wires, 0, 0);
        if (gc.getInput().isKeyDown(Input.KEY_1)) {
            flamAnim.setRunning(true);
        }
        if (gc.getInput().isKeyDown(Input.KEY_2)) {
            flamAnim2.setRunning(true);
        }
        flamAnim.animation(g);
        flamAnim2.animation(g);

        g.drawImage(bg,0,0);

		//FOR TESTING
		//flamAnim.animation(gc,g);

		g.drawImage(toplayer,0,0);

	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new RoskildeVolunteerLoungeVisualClient("Simple Slick Game"));
			appgc.setDisplayMode(1920, 1080, true);
			appgc.setShowFPS(false);
			appgc.setTargetFrameRate(24);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(RoskildeVolunteerLoungeVisualClient.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}