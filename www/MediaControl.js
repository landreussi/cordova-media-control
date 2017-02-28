var exec = require("cordova/exec");

var MediaControl = function() {
    this.onSuccess = null;
    this.onError   = null;

};

MediaControl.prototype.do = function(action) {
    var that = this;
    var successCallback = function(event) {
        if (event.type === "onSuccess" && typeof that.onSuccess === "function")
            that.onSuccess(event);
    };
    var errorCallback = function(err) {
        if (event.type === "onError" && typeof that.onError === "function")) {
            that.onError(err);
        }
    };

    exec(successCallback, errorCallback, "MediaControl", "do", [action]);
};

module.exports = MediaControl;
