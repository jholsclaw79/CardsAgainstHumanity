package jholsclaw;

import java.util.HashMap;
import java.util.Map;

public class WhiteCard {

    private String text;

    public WhiteCard(){}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    static Map<String, String> getHashMap(){
        Map<String, String> map = new HashMap<>();
        map.put("Text","text");
        return map;
    }
}
