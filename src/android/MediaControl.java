package com.trinity.mediaControl;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.view.*;
import android.content.*;

public class Main extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        String value = data.getString(0);
        Context context = new Context();
        if (action.equals("do")) {
          if (value.equals("play")){
            Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
            synchronized (this) {
              i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY));
              context.sendOrderedBroadcast(i, null);
            }
            return true;
          }
          else if (value.equals("pause")){
            Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
            synchronized (this) {
              i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PAUSE));
              context.sendOrderedBroadcast(i, null);
            }
            return true;
          }
          else if (value.equals("next")){
            Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
            synchronized (this) {
              i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT));
              context.sendOrderedBroadcast(i, null);
            }
            return true;
          }
          else if (value.equals("prev")){
            Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
            synchronized (this) {
              i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS));
              context.sendOrderedBroadcast(i, null);
            }
            return true;
          }
          else if (value.equals("stop")){
            return true;
          }
          else{
            return false;
          }
        }
        else {
            return false;
        }
    }
}
