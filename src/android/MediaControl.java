package com.trinity.mediaControl;

import org.apache.cordova.PermissionHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import android.content.pm.PackageManager;
import android.util.Log;
import android.content.Intent;
import android.content.Context;
import android.view.KeyEvent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.Manifest;


public class Main extends CordovaPlugin {
    public static final Context context;
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        String value = data.getString(0);
        if (action.equals("do")) {
          Intent i = new Intent(Intent.ACTION_MEDIA_BUTTON);
          if (value.equals("play")){
            synchronized (this) {
              i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY));
              context.sendOrderedBroadcast(i, null);
            }
            return true;
          }
          else if (value.equals("pause")){
            synchronized (this) {
              i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PAUSE));
              context.sendOrderedBroadcast(i, null);
            }
            return true;
          }
          else if (value.equals("next")){
            synchronized (this) {
              i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT));
              context.sendOrderedBroadcast(i, null);
            }
            return true;
          }
          else if (value.equals("prev")){
            synchronized (this) {
              i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS));
              context.sendOrderedBroadcast(i, null);
            }
            return true;
          }
          else if (value.equals("stop")){
            synchronized (this) {
              i.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_STOP));
              context.sendOrderedBroadcast(i, null);
            }
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
