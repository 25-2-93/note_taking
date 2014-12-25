package com.example.myapp;

import java.util.List;

import com.example.myapp.data.Noteitem;
import com.example.myapp.data.NotesDataSource;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private NotesDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        datasource= new NotesDataSource(MainActivity.this);
        
        
        List<Noteitem> notes=datasource.findAll();
        
		Noteitem  note=notes.get(0);
		note.setText("Updated");
        
        datasource.update(note);
        notes =datasource.findAll();
        note=notes.get(0);
        
        Log.d("Note",note.getKey()+":"+note.getText());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
