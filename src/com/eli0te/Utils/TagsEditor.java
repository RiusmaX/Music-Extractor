package com.eli0te.Utils;

import org.blinkenlights.jid3.ID3Exception;
import org.blinkenlights.jid3.MP3File;
import org.blinkenlights.jid3.MediaFile;
import org.blinkenlights.jid3.v2.ID3V2_3_0Tag;

import java.io.File;
import java.util.Calendar;


/**
 * Created by Marius on 20/01/2015.
 */
public class TagsEditor {
    public void editor(File folder) {
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            String[] tags = getTagsFromFileName(file);
            MediaFile mediaFile = new MP3File(file);
            ID3V2_3_0Tag oID3Tag = new ID3V2_3_0Tag();
            if(tags != null && tags.length >= 2) {
                try {
                    oID3Tag.setArtist(tags[0]);
                    oID3Tag.setTitle(tags[1]);
                    oID3Tag.setYear((Calendar.getInstance().get(Calendar.YEAR)));
                    mediaFile.setID3Tag(oID3Tag);
                    mediaFile.sync();
                } catch (ID3Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public String[] getTagsFromFileName(File f) {
        String title = f.getName();
        if(title.endsWith(".mp3")) {
            String s = title.substring(0,title.indexOf("."));
            String [] tags = s.split("-");
            return tags;
        }
        return null;
    }


}
