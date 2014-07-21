
package net.works_for_me.it.deviceemails;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.accounts.AccountManager;
import android.accounts.Account;
import java.util.List;
import java.util.ArrayList;

public class DeviceEmails extends CordovaPlugin {
    public static final String TAG = "DeviceEmails";

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false if not.
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getDeviceEmails")) {
            List<String> emails = this.getEmails();

            JSONObject obj = new JSONObject();
            JSONArray jsonEmails = new JSONArray();
            for (String e : emails) {
                jsonEmails.put(e);
            }
            obj.put("emails", jsonEmails);
            callbackContext.success(obj);
        }
        else {
            return false;
        }
        return true;
    }

    //--------------------------------------------------------------------------
    // LOCAL METHODS
    //--------------------------------------------------------------------------

    public List<String> getEmails() {
        AccountManager manager = AccountManager.get(cordova.getActivity().getApplicationContext());
        Account[] accounts = manager.getAccountsByType('com.google');
        List<String> emails = new ArrayList<String>();
        for (Account account : accounts) {
            emails.add(account.name);
        }

        return emails;
    }
}
