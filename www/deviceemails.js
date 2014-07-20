var DeviceEmails = {
    get: function(onSuccess, onFail) {

        function success(emails) {
            onSuccess(emails);
        }

        function fail(e) {
            onFail(e);
        }

        cordova.exec(success, fail, "DeviceEmails", "getDeviceEmails", []);
    }
}

module.exports = DeviceEmails;