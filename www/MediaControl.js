var exec = require("cordova/exec");

var MediaControl = function() {
    exec(function() {
        console.log("initialized");
    }, function(e) {
        console.log("error: " + e);
    }, "MediaControl", "init", []);
};

MediaControl.prototype.do = function(action) {
  exec(successCallback, errorCallback, "MediaControl", "do", [action]);
};
