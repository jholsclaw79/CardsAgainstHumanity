package jholsclaw;

import java.util.HashMap;
import java.util.Map;

public class BlackCard {

    private String text;
    private String points;

    public BlackCard(){}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    static Map<String, String> getHashMap(){
        Map<String, String> map = new HashMap<>();
        map.put("Text","text");
        map.put("Points","points");
        return map;
    }
}
