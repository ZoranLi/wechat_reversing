package com.tencent.mm.plugin.accountsync.model;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.plugin.accountsync.ui.ContactsSyncUI;
import com.tencent.mm.sdk.platformtools.w;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class AccountAuthenticatorService extends Service {
    private static a isb = null;

    private static class a extends AbstractAccountAuthenticator {
        private Context mContext;

        public a(Context context) {
            super(context);
            this.mContext = context;
        }

        public final Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            Parcelable intent = new Intent(this.mContext, ContactsSyncUI.class);
            intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
            intent.putExtra("contact_sync_scene", 1);
            bundle2.putParcelable("intent", intent);
            return bundle2;
        }

        public final Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
            w.i("MicroMsg.AccountAuthenticatorService", "confirmCredentials");
            return null;
        }

        public final Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
            w.i("MicroMsg.AccountAuthenticatorService", "editProperties");
            return null;
        }

        public final Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
            w.i("MicroMsg.AccountAuthenticatorService", "getAuthToken");
            return null;
        }

        public final String getAuthTokenLabel(String str) {
            w.i("MicroMsg.AccountAuthenticatorService", "getAuthTokenLabel");
            return null;
        }

        public final Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
            w.i("MicroMsg.AccountAuthenticatorService", "hasFeatures: " + strArr);
            return null;
        }

        public final Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
            w.i("MicroMsg.AccountAuthenticatorService", "updateCredentials");
            return null;
        }
    }

    public IBinder onBind(Intent intent) {
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.accounts.AccountAuthenticator")) {
            return null;
        }
        if (isb == null) {
            isb = new a(this);
        }
        return isb.getIBinder();
    }
}
