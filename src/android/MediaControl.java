package com.trinity.mediaControl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.cordova.*;
import android.content.Context;
import android.media.AudioManager;
import android.view.KeyEvent;

public class MediaControl extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        String value = data.getString(0);
        Context activeContext = cordova.getActivity().getApplicationContext();
        AudioManager am = (AudioManager) activeContext.getSystemService(Context.AUDIO_SERVICE);
        if (action.equals("do")) {
          if (value.equals("play")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY));
              // callbackContext.success("Tocando");
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
            }
          }
          else if (value.equals("pause")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PAUSE));
              // callbackContext.success("Pausado");
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
            }
          }
          else if (value.equals("next")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT));
              // callbackContext.success("Próxima Musica");
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
            }
          }
          else if (value.equals("prev")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS));
              // callbackContext.success("Musica Anterior");
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
            }
          }
          else if (value.equals("stop")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_STOP));
              // callbackContext.success("Parado");
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
            }
          }
          else if(value.equals("volume+")){
            int currentVolume = am.getStreamVolume(am.STREAM_MUSIC);
            int maxVolume = am.getStreamMaxVolume(am.STREAM_MUSIC);
            if (am.isMusicActive() && currentVolume <= maxVolume - 10){
              currentVolume += 10;
              am.setStreamVolume(am.STREAM_MUSIC, currentVolume, 1);
              // callbackContext.success("Volume +");
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
            }
          }
          else if(value.equals("volume-")){
            int currentVolume = am.getStreamVolume(am.STREAM_MUSIC);
            int maxVolume = am.getStreamMaxVolume(am.STREAM_MUSIC);
            if (am.isMusicActive() && currentVolume >= 10){
              currentVolume -= 10;
              am.setStreamVolume(am.STREAM_MUSIC, currentVolume, 1);
              // callbackContext.success("Volume -");
              callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
            }
          }
          else{
            // callbackContext.error("Método usado incorretamente");
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR));
          }
        }
        else {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR));
        }
        return true;
    }
}
