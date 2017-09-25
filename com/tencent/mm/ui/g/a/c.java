package com.tencent.mm.ui.g.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public final class c {
    protected static String wfZ = "https://m.facebook.com/dialog/";
    protected static String wga = "https://graph.facebook.com/";
    protected static String wgb = "https://api.facebook.com/restserver.php";
    private String ivH;
    public String vsE = null;
    private long wgc = 0;
    public long wgd = 0;
    public Activity wge;
    private String[] wgf;
    private int wgg;
    public a wgh;
    private final long wgi = 86400000;

    public interface a {
        void a(b bVar);

        void a(d dVar);

        void m(Bundle bundle);

        void onCancel();
    }

    public c(String str) {
        this.ivH = str;
    }

    public final void a(Activity activity, String[] strArr, a aVar) {
        this.wgh = aVar;
        a(activity, strArr);
        g.oUh.a(582, 0, 1, false);
    }

    private void a(Activity activity, String[] strArr) {
        Bundle bundle = new Bundle();
        if (strArr.length > 0) {
            bundle.putString("scope", TextUtils.join(",", strArr));
        }
        CookieSyncManager.createInstance(activity);
        a(activity, "oauth", bundle, new a(this) {
            final /* synthetic */ c wgj;

            {
                this.wgj = r1;
            }

            public final void m(Bundle bundle) {
                CookieSyncManager.getInstance().sync();
                this.wgj.TX(bundle.getString("access_token"));
                this.wgj.TY(bundle.getString("expires_in"));
                if (this.wgj.bYR()) {
                    w.d("Facebook-authorize", "Login Success! access_token=" + this.wgj.vsE + " expires=" + this.wgj.wgd);
                    this.wgj.wgh.m(bundle);
                    return;
                }
                this.wgj.wgh.a(new d("Failed to receive access token."));
            }

            public final void a(b bVar) {
                w.d("Facebook-authorize", "Login failed: " + bVar);
                this.wgj.wgh.a(bVar);
            }

            public final void a(d dVar) {
                w.d("Facebook-authorize", "Login failed: " + dVar);
                this.wgj.wgh.a(dVar);
            }

            public final void onCancel() {
                w.d("Facebook-authorize", "Login canceled");
                this.wgj.wgh.onCancel();
            }
        });
    }

    public final void e(int i, int i2, Intent intent) {
        if (i != this.wgg) {
            return;
        }
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("error_type");
            }
            if (stringExtra == null) {
                TX(intent.getStringExtra("access_token"));
                TY(intent.getStringExtra("expires_in"));
                if (bYR()) {
                    w.d("Facebook-authorize", "Login Success! access_token=" + this.vsE + " expires=" + this.wgd);
                    this.wgh.m(intent.getExtras());
                    return;
                }
                this.wgh.a(new d("Failed to receive access token."));
            } else if (stringExtra.equals("service_disabled") || stringExtra.equals("AndroidAuthKillSwitchException")) {
                w.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
                a(this.wge, this.wgf);
            } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                w.d("Facebook-authorize", "Login canceled by user.");
                this.wgh.onCancel();
            } else {
                String stringExtra2 = intent.getStringExtra("error_description");
                if (stringExtra2 != null) {
                    stringExtra = stringExtra + ":" + stringExtra2;
                }
                w.d("Facebook-authorize", "Login failed: " + stringExtra);
                this.wgh.a(new d(stringExtra));
            }
        } else if (i2 != 0) {
        } else {
            if (intent != null) {
                w.d("Facebook-authorize", "Login failed: " + intent.getStringExtra("error"));
                this.wgh.a(new b(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                return;
            }
            w.d("Facebook-authorize", "Login canceled by user.");
            this.wgh.onCancel();
        }
    }

    public final String fb(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        TX(null);
        this.wgd = 0;
        return null;
    }

    public final String a(String str, Bundle bundle, String str2) {
        bundle.putString("format", "json");
        if (bYR()) {
            bundle.putString("access_token", this.vsE);
        }
        return e.e(str != null ? wga + str : wgb, str2, bundle);
    }

    public final void a(Context context, String str, Bundle bundle, a aVar) {
        String str2 = wfZ + str;
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", "fbconnect://success");
        if (str.equals("oauth")) {
            bundle.putString(Columns.TYPE, "user_agent");
            bundle.putString("client_id", this.ivH);
        } else {
            bundle.putString("app_id", this.ivH);
        }
        if (bYR()) {
            bundle.putString("access_token", this.vsE);
        }
        str2 = str2 + "?" + e.ae(bundle);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            e.A(context, "Error", "Application requires permission to access the Internet");
        } else {
            new f(context, str2, aVar).show();
        }
    }

    public final boolean bYR() {
        return this.vsE != null && (this.wgd == 0 || System.currentTimeMillis() < this.wgd);
    }

    public final void TX(String str) {
        this.vsE = str;
        this.wgc = System.currentTimeMillis();
    }

    public final void TY(String str) {
        if (str != null) {
            long j;
            if (str.equals("0")) {
                j = 0;
            } else {
                j = System.currentTimeMillis() + (bg.PZ(str) * 1000);
            }
            this.wgd = j;
        }
    }
}
