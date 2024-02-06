package com.sandun.web.model;

import java.awt.Font;
import java.io.File;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class FontManager {

    public static Font outfitLight;
    public static Font outfitMedium;
    public static Font outfitRegular;
    public static Font nacelleLight;
    public static Font nacelleRegular;

    static {
        try {
            File fontFile1 = new File("src//main//resources//font//Outfit-Light.ttf");
            outfitLight = Font.createFont(Font.TRUETYPE_FONT, fontFile1);
            File fontFile2 = new File("src//main//resources//font//Outfit-Medium.ttf");
            outfitMedium = Font.createFont(Font.TRUETYPE_FONT, fontFile2);
            File fontFile3 = new File("src//main//resources//font//Outfit-Regular.ttf");
            outfitRegular = Font.createFont(Font.TRUETYPE_FONT, fontFile3);
            File fontFile4 = new File("src//main//resources//font//Nacelle-Light.otf");
            nacelleLight = Font.createFont(Font.TRUETYPE_FONT, fontFile4);
            File fontFile5 = new File("src//main//resources//font//Nacelle-Regular.otf");
            nacelleRegular = Font.createFont(Font.TRUETYPE_FONT, fontFile5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Font getOutfitLight(float f) {
        return outfitRegular.deriveFont(f);
    }

    public static Font getOutfitMedium(float f) {
        return outfitRegular.deriveFont(f);
    }

    public static Font getOutfitRegular(float f) {
        return outfitRegular.deriveFont(f);
    }

    public static void setFontForLables(Font f, float size, JComponent... lables) {
        Font newF = f.deriveFont(size);
        for (JComponent l : lables) {
            l.setFont(newF);
        }
    }

    public static void setFontForLable(Font f, float size, JComponent lable) {
        Font newF = f.deriveFont(size);
        lable.setFont(newF);
    }
}
