package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.common.internal.w;

public final class i extends o {
    public SharedPreferences ahT;
    private long ahU;
    private long ahV = -1;
    final a ahW = new a(this, "monitoring", ((Long) aj.akD.get()).longValue());

    public final class a {
        final long ahX;
        final /* synthetic */ i ahY;
        private final String mName;

        public a(i iVar, String str, long j) {
            this.ahY = iVar;
            w.U(str);
            w.ad(j > 0);
            this.mName = str;
            this.ahX = j;
        }

        private String hN() {
            return this.mName + ":start";
        }

        void hL() {
            long currentTimeMillis = this.ahY.ahK.ahZ.currentTimeMillis();
            Editor edit = this.ahY.ahT.edit();
            edit.remove(hO());
            edit.remove(hP());
            edit.putLong(hN(), currentTimeMillis);
            edit.commit();
        }

        long hM() {
            return this.ahY.ahT.getLong(hN(), 0);
        }

        String hO() {
            return this.mName + ":count";
        }

        String hP() {
            return this.mName + ":value";
        }
    }

    protected i(q qVar) {
        super(qVar);
    }

    public final long hG() {
        q.im();
        ie();
        if (this.ahU == 0) {
            long j = this.ahT.getLong("first_run", 0);
            if (j != 0) {
                this.ahU = j;
            } else {
                j = this.ahK.ahZ.currentTimeMillis();
                Editor edit = this.ahT.edit();
                edit.putLong("first_run", j);
                if (!edit.commit()) {
                    F("Failed to commit first run time");
                }
                this.ahU = j;
            }
        }
        return this.ahU;
    }

    public final j hH() {
        return new j(this.ahK.ahZ, hG());
    }

    public final long hI() {
        q.im();
        ie();
        if (this.ahV == -1) {
            this.ahV = this.ahT.getLong("last_dispatch", 0);
        }
        return this.ahV;
    }

    public final void hJ() {
        q.im();
        ie();
        long currentTimeMillis = this.ahK.ahZ.currentTimeMillis();
        Editor edit = this.ahT.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.ahV = currentTimeMillis;
    }

    public final String hK() {
        q.im();
        ie();
        CharSequence string = this.ahT.getString("installation_campaign", null);
        return TextUtils.isEmpty(string) ? null : string;
    }

    protected final void hu() {
        this.ahT = this.ahK.mContext.getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final void y(String str) {
        q.im();
        ie();
        Editor edit = this.ahT.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            F("Failed to commit campaign data");
        }
    }
}
