var exec = require("cordova/exec");

var MediaControl = function() {
    this.success = null;
};

MediaControl.prototype.do = function(action) {
    var that = this;
    var successCallback = function(event) {
        if (event.type === "success" && typeof that.success === "function")
            that.success(event);
    };

    var errorCallback = function(err) {
        if (typeof that.error === "function") {
            that.error(err);
        }
    };

    exec(successCallback, errorCallback, "MediaControl", "do", [action]);
};

module.exports = MediaControl;
