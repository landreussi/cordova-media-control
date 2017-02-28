var exec = require("cordova/exec");

var MediaControl = function() {
    this.success = null;

    exec(function() {
        console.log("initialized");
    }, function(e) {
        console.log("error: " + e);
    }, "MediaControl", "init", []);
};

MediaControl.prototype.do = function(action) {
    var that = this;
    var successCallback = function(event) {
        if (event.type === "success" && typeof that.onaudiostart === "function")
            that.success(event);
    };

    var errorCallback = function(err) {
        if (typeof that.error === "function") {
            that.onerror(err);
        }
    };


    exec(successCallback, errorCallback, "MediaControl", "do", [action]);
};

module.exports = MediaControl;
