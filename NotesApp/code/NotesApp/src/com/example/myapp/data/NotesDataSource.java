package com.example.myapp.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.jar.Attributes.Name;

import android.content.Context;
import android.content.SharedPreferences;

public class NotesDataSource {
	private static final String PREFKEY="note";
	private static final String Name = null;
	private SharedPreferences notePrefs;
	public NotesDataSource(Context context)
	{
		
		notePrefs=context.getSharedPreferences(PREFKEY,Context.MODE_PRIVATE);
	}
	public List<Noteitem> findAll()
	{
		Map< String, ?>notesMap = notePrefs.getAll();
		SortedSet<String> keys = new TreeSet<String>(notesMap.keySet());
		
		List< Noteitem> noteList=new ArrayList<Noteitem>();
		
		for(String key : keys)
		{
			Noteitem note = new Noteitem();
			note.setKey(key);
			note.setText((String) notesMap.get(key));
			noteList.add(note);
		
		}
	
		return noteList;
		
	}
	public boolean update(Noteitem note)
	{
		SharedPreferences.Editor editor = notePrefs.edit();
		editor.putString(note.getKey(), note.getText());
		editor.commit();
		
		return true;
	}
	public boolean remove(Noteitem note)
	{
		
		if(notePrefs.contains(note.getKey()));
		{
		
			SharedPreferences.Editor editor = notePrefs.edit();
			editor.remove(note.getKey());
			editor.commit();
			
		}
		SharedPreferences.Editor editor = notePrefs.edit();
		editor.remove(note.getKey());
		editor.commit();
		
		return true;
	}

}
