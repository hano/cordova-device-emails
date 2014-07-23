cordova-device-emails
=====================

Cordova plugin to get the device e-mails on Android (of type 'com.google')

Requires the **android.permission.GET_ACCOUNTS** permission.

## Install
```
cordova plugin add https://github.com/sebastien-roch/cordova-device-emails.git
```

## Usage
```
DeviceEmails.get(onSuccess, onFail);
```
`onSuccess` receives an object as first and only argument containing one key, `emails`, having for value an array of e-mails.

`onFail` receives the reason of the failure as a string

### Example:
````
DeviceEmails.get(
	function(emails) {
		console.log('account registered on this device:', emails);
	},
    function(e) {
    	console.log('Fail to retrieve e-mail, details on exception:', e);
    }
);
```

## Compatibility
Tested with:
* Cordova 3.3
* Android 4.4

Should work with Android API level 5+ and Android >2.2, but not tested.
