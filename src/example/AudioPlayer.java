package example;

public class AudioPlayer {
	String audioFileLocation = "C:/Users/Thomas Macdonald/Downloads/sound/";

	
	public void playSoundBio() {

    	new AePlayWave(audioFileLocation + "biological.wav").start();
    	new AePlayWave(audioFileLocation + "type1_small.wav").start();
    	System.out.println("[undefined size] BIO trash thrown out.");

    }
    public void playSoundCard() {
    	new AePlayWave(audioFileLocation + "cardboard.wav").start();
    	new AePlayWave(audioFileLocation + "type2_small.wav").start();
    	System.out.println("[undefined size] CARDBOARD trash thrown out.");

    }
    public void playSoundFlam() {
    	new AePlayWave(audioFileLocation + "flamable.wav").start();
    	new AePlayWave(audioFileLocation + "type3_small.wav").start();
    	System.out.println("[undefined size] FLAMABLE trash thrown out.");
    }
    
    public void playSoundBio(int size) {

    	if (size == 1) {
	    	new AePlayWave(audioFileLocation + "biological.wav").start();
	    	new AePlayWave(audioFileLocation + "type1_small.wav").start();
	    	System.out.println("[small size] BIO trash thrown out. ");
    	} else if (size == 2) {
    		new AePlayWave(audioFileLocation + "biological.wav").start();
        	new AePlayWave(audioFileLocation + "type1_medium.wav").start();
        	System.out.println("[medium size] BIO trash thrown out. ");
    	} else if (size == 3) {
    		new AePlayWave(audioFileLocation + "biological.wav").start();
        	new AePlayWave(audioFileLocation + "type1_large.wav").start();	
        	System.out.println("[large size] BIO trash thrown out. ");
    	} else {
	    	new AePlayWave(audioFileLocation + "biological.wav").start();
	    	new AePlayWave(audioFileLocation + "type1_small.wav").start();
	    	System.out.println("[invalid size] BIO trash thrown out. ");
    	}
    }
    public void playSoundCard(int size) {

    	if (size == 1) {
	    	new AePlayWave(audioFileLocation + "cardboard.wav").start();
	    	new AePlayWave(audioFileLocation + "type2_small.wav").start();
	    	System.out.println("[small size] CARD trash thrown out. ");
    	} else if (size == 2) {
    		new AePlayWave(audioFileLocation + "cardboard.wav").start();
        	new AePlayWave(audioFileLocation + "type2_medium.wav").start();
        	System.out.println("[medium size] CARD trash thrown out. ");
    	} else if (size == 3) {
    		new AePlayWave(audioFileLocation + "cardboard.wav").start();
        	new AePlayWave(audioFileLocation + "type2_large.wav").start();	
        	System.out.println("[large size] CARD trash thrown out. ");
    	} else {
	    	new AePlayWave(audioFileLocation + "cardboard.wav").start();
	    	new AePlayWave(audioFileLocation + "type2_small.wav").start();
	    	System.out.println("[invalid size] CARD trash thrown out. ");
    	}
    }
    public void playSoundFlam(int size) {

    	if (size == 1) {
	    	new AePlayWave(audioFileLocation + "flamable.wav").start();
	    	new AePlayWave(audioFileLocation + "type3_small.wav").start();
	    	System.out.println("[small size] CARD trash thrown out. ");
    	} else if (size == 2) {
    		new AePlayWave(audioFileLocation + "flamable.wav").start();
        	new AePlayWave(audioFileLocation + "type3_medium.wav").start();
        	System.out.println("[medium size] CARD trash thrown out. ");
    	} else if (size == 3) {
    		new AePlayWave(audioFileLocation + "flamable.wav").start();
        	new AePlayWave(audioFileLocation + "type3_large.wav").start();	
        	System.out.println("[large size] CARD trash thrown out. ");
    	} else {
	    	new AePlayWave(audioFileLocation + "flamable.wav").start();
	    	new AePlayWave(audioFileLocation + "type3_small.wav").start();
	    	System.out.println("[invalid size] CARD trash thrown out. ");
    	}
    }
}
