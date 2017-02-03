package com.example.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class Main extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        String value = data.getString(0);
        if (action.equals("do")) {
          if (value.equals("play")){
            return true;
          }
          else if (value.equals("pause")){
            return true;
          }
          else if (value.equals("next")){
            return true;
          }
          else if (value.equals("prev")){
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
