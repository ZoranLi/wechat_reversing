package com.tencent.mm.plugin.gcm.modelgcm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class a implements e {
    private static a mHC;
    public Context context;
    public int mHA = 3;
    private int mHB = 0;
    public com.google.android.gms.gcm.a mHD;

    class a extends AsyncTask<Void, Void, String> {
        final /* synthetic */ a mHE;

        a(a aVar) {
            this.mHE = aVar;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aCu();
        }

        protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        }

        private String aCu() {
            String str;
            Object obj = null;
            c.oTb.a(452, 5, 1, false);
            String b;
            try {
                w.i("GcmRegister", "RegisterAsyncTask doInBackground.");
                if (this.mHE.mHD == null) {
                    this.mHE.mHD = com.google.android.gms.gcm.a.D(this.mHE.context);
                }
                b = this.mHE.mHD.b("546136561403");
                str = "Device registered, registration ID=" + b;
                if (b == null || b.length() <= 0) {
                    g.oUh.A(11250, new StringBuilder("2,1").toString());
                    c.oTb.a(452, 7, 1, false);
                    b = str;
                    w.i("GcmRegister", b);
                    if (obj == null && this.mHE.mHA > 0) {
                        this.mHE.mHA--;
                        this.mHE.aCo();
                    }
                    return b;
                }
                this.mHE.ac(this.mHE.context, b);
                this.mHE.aCr();
                obj = 1;
                c.oTb.a(452, 6, 1, false);
                b = str;
                w.i("GcmRegister", b);
                this.mHE.mHA--;
                this.mHE.aCo();
                return b;
            } catch (Throwable e) {
                str = "Device register Error :" + e.getMessage();
                w.printErrStackTrace("GcmRegister", e, "", new Object[0]);
                g.oUh.A(11250, new StringBuilder("2,1").toString());
                c.oTb.a(452, 8, 1, false);
                b = str;
            } catch (Throwable e2) {
                this.mHE.mHA = 0;
                str = "Device register Error :" + e2.getMessage();
                w.printErrStackTrace("GcmRegister", e2, "", new Object[0]);
                g.oUh.A(11250, new StringBuilder("2,1").toString());
                c.oTb.a(452, 9, 1, false);
                b = str;
            } catch (Throwable e22) {
                str = "Device register Error :" + e22.getMessage();
                w.printErrStackTrace("GcmRegister", e22, "", new Object[0]);
                g.oUh.A(11250, new StringBuilder("2,1").toString());
                c.oTb.a(452, 10, 1, false);
                b = str;
            }
        }
    }

    private a(Context context) {
        this.context = context;
    }

    public static a aCn() {
        w.i("GcmRegister", "GCM getInstance");
        if (mHC != null) {
            return mHC;
        }
        Context context = ab.getContext();
        if (context == null) {
            w.e("GcmRegister", "GCM appcontext null");
            return null;
        }
        a aVar = new a(context);
        mHC = aVar;
        return aVar;
    }

    public final void aCo() {
        w.i("GcmRegister", "checkregister");
        z.MM().postDelayed(new Runnable(this) {
            final /* synthetic */ a mHE;

            {
                this.mHE = r1;
            }

            public final void run() {
                w.e("GcmRegister", "onCreate~~~threadID:" + Thread.currentThread());
                a aCn = a.aCn();
                if (aCn != null) {
                    w.i("GcmRegister", "doRegist~~~");
                    String aCp = aCn.aCp();
                    w.i("GcmRegister", "regid = " + aCp);
                    if (a.co(aCn.context)) {
                        aCn.mHD = com.google.android.gms.gcm.a.D(aCn.context);
                        if (aCp == null || aCp.length() == 0) {
                            new a(aCn).execute(new Void[]{null, null, null});
                            return;
                        }
                        aCn.aCr();
                        return;
                    }
                    w.i("GcmRegister", "Google Play Services Unavailable.");
                    g.oUh.A(11250, new StringBuilder("2,0").toString());
                    c.oTb.a(452, 0, 1, false);
                    if (aCn.aCt()) {
                        aCn.aCp();
                        aCn.aCs();
                    }
                }
            }
        }, 5000);
    }

    @SuppressLint({"NewApi"})
    public final String aCp() {
        SharedPreferences aCq = aCq();
        String string = aCq.getString("registration_id", "");
        if (string.length() == 0) {
            w.i("GcmRegister", "Registration not found.");
            c.oTb.a(452, 1, 1, false);
            return "";
        } else if (aCq.getInt("appVersion", Integer.MIN_VALUE) != cn(this.context)) {
            w.i("GcmRegister", "App version changed.");
            c.oTb.a(452, 2, 1, false);
            return "";
        } else if (bg.az(aCq.getLong("regtime", 0)) > 259200) {
            w.i("GcmRegister", "gcm regid timeout");
            c.oTb.a(452, 3, 1, false);
            return "";
        } else {
            c.oTb.a(452, 4, 1, false);
            return string;
        }
    }

    private SharedPreferences aCq() {
        return this.context.getSharedPreferences(a.class.getSimpleName(), 0);
    }

    private static int cn(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            w.e("GcmRegister", "Could not get package name.");
            return i;
        }
    }

    public final void aCr() {
        c.oTb.a(452, 11, 1, false);
        int uH = z.MO().ieq.uH();
        if (this.mHB == 0 || uH != this.mHB) {
            String aCp = aCp();
            if (aCp == null || aCp.length() == 0) {
                w.i("GcmRegister", "sendRegistrationIdToBackend regid is empty.");
                c.oTb.a(452, 13, 1, false);
                return;
            }
            w.i("GcmRegister", "regToWeixinServer.");
            try {
                new e(aCp, uH).a(z.MO(), this);
                c.oTb.a(452, 14, 1, false);
                return;
            } catch (Throwable th) {
                c.oTb.a(452, 15, 1, false);
                w.e("GcmRegister", "NetScenePushReg doScene error:" + th.toString());
                return;
            }
        }
        w.i("GcmRegister", "uin already reg to weixin svr:" + this.mHB);
        c.oTb.a(452, 12, 1, false);
    }

    public final void aCs() {
        w.i("GcmRegister", "unregToWeixinServer");
        c.oTb.a(452, 18, 1, false);
        String aCp = aCp();
        if (aCp == null || aCp.length() == 0) {
            w.e("GcmRegister", "unregToWeixinServer regid is empty.");
            c.oTb.a(452, 19, 1, false);
        } else if (aCt()) {
            eJ(false);
            try {
                new f(aCp, z.MO().ieq.uH()).a(z.MO(), this);
                c.oTb.a(452, 21, 1, false);
            } catch (Throwable th) {
                w.e("GcmRegister", "NetScenePushUnReg doScene error:" + th.toString());
                c.oTb.a(452, 22, 1, false);
            }
        } else {
            w.e("GcmRegister", "is not reg to Svr. no need unreg.");
            c.oTb.a(452, 20, 1, false);
        }
    }

    public final void ac(Context context, String str) {
        SharedPreferences aCq = aCq();
        int cn = cn(context);
        w.i("GcmRegister", "Saving regId on app version " + cn);
        Editor edit = aCq.edit();
        edit.putString("registration_id", str);
        edit.putInt("appVersion", cn);
        edit.putLong("regtime", bg.Ny());
        edit.commit();
    }

    private void eJ(boolean z) {
        SharedPreferences aCq = aCq();
        w.i("GcmRegister", "Saving regSvrResult: " + z);
        Editor edit = aCq.edit();
        edit.putBoolean("isRegToSvr", z);
        edit.commit();
        if (z) {
            this.mHB = z.MO().ieq.uH();
        } else {
            this.mHB = 0;
        }
    }

    public final boolean aCt() {
        return aCq().getBoolean("isRegToSvr", false);
    }

    static boolean co(Context context) {
        try {
            if (Integer.valueOf(VERSION.SDK_INT).intValue() < 8) {
                return false;
            }
            int w = com.google.android.gms.common.e.w(context);
            if (w == 0) {
                return true;
            }
            w.w("GcmRegister", "device not support GCM reason = " + w);
            return false;
        } catch (Throwable th) {
            w.e("GcmRegister", th.toString());
            return false;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = false;
        w.i("GcmRegister", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        kVar.hsJ = true;
        if (kVar != null) {
            if (kVar instanceof e) {
                if (i == 0 && i2 == 0) {
                    w.i("GcmRegister", "NetScenePushReg success.");
                    c.oTb.a(452, 16, 1, false);
                    z = true;
                } else {
                    w.i("GcmRegister", "NetScenePushReg faild.");
                    c.oTb.a(452, 17, 1, false);
                }
                eJ(z);
            } else if (kVar instanceof f) {
                if (i == 0 && i2 == 0) {
                    w.i("GcmRegister", "NetScenePushUnReg success.");
                    c.oTb.a(452, 23, 1, false);
                } else {
                    w.e("GcmRegister", "NetScenePushUnReg faild.");
                    c.oTb.a(452, 24, 1, false);
                }
                eJ(false);
            }
        }
    }
}
