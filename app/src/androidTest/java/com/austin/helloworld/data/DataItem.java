package com.austin.helloworld.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by austin on 10/26/2014.
 */
public class DataItem {
    private String key;
    private String text;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static DataItem getNew(){
        Locale locale = new Locale("en_US");
        Locale.setDefault(locale);
        String pattern = "yyyy-MM-dd HH:mm:ss Z";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String key = formatter.format(new Date());
        DataItem note = new DataItem();
        note.setKey(key);
        note.setText("");
        return note;

    }

}
