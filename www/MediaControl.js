var exec = require("cordova/exec");

var MediaControl = function() {
    this.success = null;
    this.error   = null;
    
    exec(function() {
        console.log("initialized");
    }, function(e) {
        console.log("error: " + e);
    }, "MediaControl", "init", []);
};

MediaControl.prototype.do = function(action) {
    var that = this;
    var successCallback = function(event) {
        if (event.type === "success")
            that.success(event);
        else
        var errorCallback = function(err) {
            if (event.type === "error") {
                that.error(err);
            }
        };

    };

    exec(successCallback, errorCallback, "MediaControl", "do", [action]);
};

module.exports = MediaControl;
