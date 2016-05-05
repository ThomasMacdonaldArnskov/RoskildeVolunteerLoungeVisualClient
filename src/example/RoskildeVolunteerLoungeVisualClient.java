package example;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.newdawn.slick.*;

public class RoskildeVolunteerLoungeVisualClient extends BasicGame
{
	private Image wires, bg, toplayer;

    private FlammableAnim flamAnim;
    private CardboardAnim cardboardAnim;
    private OrganicAnim organicAnim;




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
        cardboardAnim = new CardboardAnim();
        organicAnim = new OrganicAnim();

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
            cardboardAnim.setRunning(true);
        }
        if (gc.getInput().isKeyDown(Input.KEY_3)) {
            organicAnim.setRunning(true);
        }
        flamAnim.animation(g);
        cardboardAnim.animation(g);
        organicAnim.animation(g);

        g.drawImage(bg,0,0);

		//FOR TESTING
		//organicAnim.animation(g);
		//cardboardAnim.animation(g);

		g.drawImage(toplayer,0,0);

        //flamAnim.animationOverlay(g);
        //flamAnim2.animationOverlay(g);

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