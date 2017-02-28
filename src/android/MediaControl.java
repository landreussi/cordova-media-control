package com.trinity.mediaControl;

import org.apache.cordova.PermissionHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import android.content.Context;
import android.content.Intent;
// import android.media.AudioManager;
import android.view.KeyEvent;
import android.Manifest;

public class MediaControl extends CordovaPlugin {
    private int currentVolume;
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        String value = data.getString(0);
        Context activeContext = cordova.getActivity().getBaseContext();
        int MODIFY_AUDIO_SETTINGS = 0;
        String [] permissions = { Manifest.permission.MODIFY_AUDIO_SETTINGS };
        if (action.equals("do")) {
          PermissionHelper.requestPermission(this, MODIFY_AUDIO_SETTINGS, permissions[MODIFY_AUDIO_SETTINGS]);
          if (value.equals("play")){
            Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
             synchronized (this) {
               i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY));
               activeContext.sendOrderedBroadcast(i, null);
             }
             return true;
           }
           else if (value.equals("pause")){
             Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
             synchronized (this) {
               i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PAUSE));
               activeContext.sendOrderedBroadcast(i, null);
             }
             return true;
           }
           else if (value.equals("next")){
             Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
             synchronized (this) {
               i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT));
               activeContext.sendOrderedBroadcast(i, null);
             }
             return true;
           }
           else if (value.equals("prev")){
             Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
             synchronized (this) {
               i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS));
               activeContext.sendOrderedBroadcast(i, null);
             }
             return true;
           }
           else if (value.equals("stop")){
             Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
             synchronized (this) {
               i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_STOP));
               activeContext.sendOrderedBroadcast(i, null);
             }
             return true;
           }
           return false;
    }
}
}
