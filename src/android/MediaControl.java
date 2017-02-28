package com.trinity.mediaControl;

import org.apache.cordova.PermissionHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import android.content.Context;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.Manifest;

public class MediaControl extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        String value = data.getString(0);
        Context activeContext = cordova.getActivity().getApplicationContext();
        AudioManager am = (AudioManager) activeContext.getSystemService(Context.AUDIO_SERVICE);
        int RECORD_AUDIO = 0;
        String [] permissions = { Manifest.permission.RECORD_AUDIO };
        if (action.equals("do")) {
          PermissionHelper.requestPermission(this, RECORD_AUDIO, permissions[RECORD_AUDIO]);
          if (value.equals("play")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY));
              fireEvent("success");
              return true;
            }
          }
          else if (value.equals("pause")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PAUSE));
              fireEvent("success");
              return true;
            }
          }
          else if (value.equals("next")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT));
              fireEvent("success");
              return true;
            }
          }
          else if (value.equals("prev")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS));
              fireEvent("success");
              return true;
            }
          }
          else if (value.equals("stop")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_STOP));
              fireEvent("success");
              return true;
            }
          }
          else if(value.equals("volume+")){
            int currentVolume = am.getStreamVolume(am.STREAM_MUSIC);
            int maxVolume = am.getStreamMaxVolume(am.STREAM_MUSIC);
            if (am.isMusicActive() && currentVolume <= maxVolume - 10){
              currentVolume += 10;
              am.setStreamVolume(am.STREAM_MUSIC, currentVolume, 1);
              fireEvent("success");
              return true;
            }
          }
          else if(value.equals("volume-")){
            int currentVolume = am.getStreamVolume(am.STREAM_MUSIC);
            int maxVolume = am.getStreamMaxVolume(am.STREAM_MUSIC);
            if (am.isMusicActive() && currentVolume >= 10){
              currentVolume -= 10;
              am.setStreamVolume(am.STREAM_MUSIC, currentVolume, 1);
              fireEvent("success");
              return true;
            }
          }
          else{
            fireEvent("error");
          }
        }
        else {
            fireEvent("error");
        }
        return false;
    }

    public void fireEvent(String type) {
        JSONObject event = new JSONObject();
        try {
            event.put("type",type);
        } catch (JSONException e) {
            // this will never happen
        }
        PluginResult pr;
        if (type.equals("error")){
          pr = new PluginResult(PluginResult.Status.ERROR, event);
        }
        else{
          pr = new PluginResult(PluginResult.Status.OK, event);
        }
        pr.setKeepCallback(true);
        callbackContext.sendPluginResult(pr);
    }
}
