/**
 * 
 * For information on usage and redistribution, and for a DISCLAIMER OF ALL
 * WARRANTIES, see the file, "LICENSE.txt," in this distribution.
 * 
 */

package example;

import java.io.IOException;

import org.puredata.core.PdBase;

/**
 *
 * Minimal tutorial example of how to use libpd with JavaSound.
 *
 * @author Peter Brinkmann (peter.brinkmann@gmail.com)
 *
 */
public class JavaSoundSample {



	public static void main(String[] args) throws InterruptedException, IOException {
		JavaSoundThread audioThread = new JavaSoundThread(44100, 2, 16);
		int patch = PdBase.openPatch("src/remade2.pd");
		ThrowTrashSound soundPlayer = new ThrowTrashSound();
		audioThread.start();
	//	PdBase.sendFloat("setReverbSize", 100); // DONT DO MORE THAN 90!!
	//	PdBase.sendBang("bio");
	//	PdBase.sendFloat("setReverbSize", 10); // DONT DO MORE THAN 90!!
	//	Thread.sleep(160);
	//	PdBase.sendBang("card");
	//	PdBase.sendBang("flam");

		System.out.println("should play now");
		soundPlayer.triggerSound(0, 0);
		Thread.sleep(400);
		soundPlayer.triggerSound(1, 55);
		Thread.sleep(1200);
		soundPlayer.triggerSound(0, 100);
				//Thread.sleep(5000);  // Sleep for five seconds; this is where the main application code would go in a real program.
		//audioThread.interrupt();
		//audioThread.join();
		//PdBase.closePatch(patch);
	}

}
