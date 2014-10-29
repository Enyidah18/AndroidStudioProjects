package com.austin.helloworld.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by austin on 10/26/2014.
 */
public class NotesDataSource {

    private static final String PREFKEY = "notes";
    private SharedPreferences notePrefs;
    public NotesDataSource(Context context){
        notePrefs = context.getSharedPreferences(PREFKEY, Context.MODE_PRIVATE);
    }

    public List<DataItem> findAll(){
        List<DataItem> noteList = new ArrayList<DataItem>();
        DataItem note = DataItem.getNew();
        noteList.add(note);
        return noteList;
    }

    public boolean update(DataItem note){
        SharedPreferences.Editor editor = notePrefs.edit();
        editor.putString(note.getKey(), note.getText());
        editor.commit();
        return true;
    }

    public boolean remove(DataItem note){
        if(notePrefs.contains(note.getKey())){
            SharedPreferences.Editor editor = notePrefs.edit();
            editor.remove(note.getKey());
            editor.commit();
        }

        return true;
    }
}
