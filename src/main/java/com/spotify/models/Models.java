package com.spotify.models;

import com.spotify.utils.Excel;

import java.util.ArrayList;
import java.util.Map;

public class Models {
    private static String lblWelcome;

    static ArrayList<Map<String, String>> data = Excel.extractTo();

    public static String getLblWelcome() {
        return data.get(0).get("validate1");
    }

    public static void setLblWelcome(String lblWelcome) {
        Models.lblWelcome = lblWelcome;
    }
}
