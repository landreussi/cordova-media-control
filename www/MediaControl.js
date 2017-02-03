/*global cordova, module*/

module.exports = {
    do: function (action, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Main", "do", [action]);
};
