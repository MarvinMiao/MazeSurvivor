package com.series.survivor.survivorgames;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


public class MazeSurvivorActivity extends Activity {

    private MazeSurvivorView myGLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Receive the message from SurvivorGamesMenu Activity
        Intent intent = getIntent();
        String message = intent.getStringExtra(SurvivorGamesMenu.EXTRA_MESSAGE);
        //convert string to int
        int size = 0;
        char[] array = message.toCharArray();
        for(int index = 0; index < array.length; index++) {
            size += ((array[index] - '0') * Math.pow(10, array.length - 1));
        }
        //Create an instance of GLSurfaceView
        //and set it as the content view
        myGLView = new MazeSurvivorView(this, size, size);
        setContentView(myGLView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
