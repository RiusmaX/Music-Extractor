package com.eli0te.helpers;

import com.eli0te.ihm.ApplicationLayout;

/**
 * Created by eLi0tE on 16/01/15.
 */
public interface HelperInterface {

    public void getVideo(String videoURL, String outputPath, ApplicationLayout al) throws Exception;
    public void getAudio(String videoURL, String outputPath, ApplicationLayout al) throws Exception;

}
