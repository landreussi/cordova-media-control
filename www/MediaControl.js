var exec = require("cordova/exec");

var MediaControl = function() {
    this.success = false;
};

MediaControl.prototype.do = function(action) {
    exec(successCallback, errorCallback, "MediaControl", "do", [action]);
};

module.exports = MediaControl;
