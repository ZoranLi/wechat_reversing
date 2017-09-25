package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.common.e;

public final class a extends com.google.android.gms.common.internal.p.a {
    private Account akV;
    int apM;
    private Context mContext;

    public static Account b(p pVar) {
        Account account = null;
        if (pVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = pVar.jS();
            } catch (RemoteException e) {
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public final boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof a) ? false : this.akV.equals(((a) obj).akV);
    }

    public final Account jS() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.apM) {
            return this.akV;
        }
        if (e.l(this.mContext, callingUid)) {
            this.apM = callingUid;
            return this.akV;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
