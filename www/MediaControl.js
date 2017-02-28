var exec = require("cordova/exec");

var MediaControl = function() {
    this.onSuccess = null;
    this.onError   = null;

};

MediaControl.prototype.do = function(action) {
    var that = this;
    var successCallback = function(event) {
        if (event.type === "onSuccess")
            that.onSuccess(event);
        else
        var errorCallback = function(err) {
            if (event.type === "onError") {
                that.onError(err);
            }
        };

    };

    exec(successCallback, errorCallback, "MediaControl", "do", [action]);
};

module.exports = MediaControl;
