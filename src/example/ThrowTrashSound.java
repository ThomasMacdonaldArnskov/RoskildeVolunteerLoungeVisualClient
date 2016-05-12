package example;

import org.puredata.core.PdBase;

/**
 * Created by aaaxa on 5/12/2016.
 */
public class ThrowTrashSound {
    public void triggerSound (int trashType, int reverbSize) {
        // trashType
        // * 0 : BIOLOGICAL/ORGANIC
        // * 1 : FLAMABLE
        // * 2 : CARDBOARD
        // reverbSize
        // 0   - very small trash
        // 100 - very big trash
        if (reverbSize < 0 || reverbSize > 100) {
            reverbSize = 0;
        }
        PdBase.sendFloat("setReverbSize", reverbSize);

        if (trashType == 0) {
            PdBase.sendBang("bio");
        } else if (trashType == 1) {
            PdBase.sendBang("flam");
        } else if (trashType == 2) {
            PdBase.sendBang("card");
        } else {
            PdBase.sendBang("bio");
        }

    }
}
