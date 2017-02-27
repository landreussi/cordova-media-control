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
        AudioManager am = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        if (action.equals("do")) {
          if (value.equals("play")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY));
              return true;
            }
          }
          else if (value.equals("pause")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PAUSE));
              return true;
            }
          }
          else if (value.equals("next")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT));
              return true;
            }
          }
          else if (value.equals("prev")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS));
              return true;
            }
          }
          else if (value.equals("stop")){
            if (am.isMusicActive()){
              am.dispatchMediaKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_STOP));
              return true;
            }
          }
          else if(value.equals("volume+")){
            int currentVolume = am.getStreamVolume(am.STREAM_MUSIC);
            int maxVolume = am.getStreamMaxVolume(am.STREAM_MUSIC);
            if (am.isMusicActive() && currentVolume <= maxVolume - 10){
              currentVolume += 10;
              am.setStreamVolume(am.STREAM_MUSIC, currentVolume, 1);
              return true;
            }
          }
          else if(value.equals("volume-")){
            if (am.isMusicActive() && currentVolume >= 10){
              currentVolume -= 10;
              am.setStreamVolume(am.STREAM_MUSIC, currentVolume, 1);
              return true;
            }
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
