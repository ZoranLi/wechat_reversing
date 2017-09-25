package com.tencent.b.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import org.json.JSONObject;

public class i {
    private static i aQo = null;
    static f aQp = null;
    public static volatile long aQq = 0;
    static h aQr = null;
    public static Context mContext = null;
    public static Handler mHandler = null;
    public g aQs = null;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ i aQt;
        private final /* synthetic */ String aQu;

        public AnonymousClass1(i iVar, String str) {
            this.aQt = iVar;
            this.aQu = str;
        }

        public final void run() {
            try {
                new StringBuilder("receive data:").append(this.aQu);
                int i = 100;
                int i2 = 3;
                if (s.aJ(this.aQu)) {
                    JSONObject jSONObject = new JSONObject(this.aQu);
                    if (!jSONObject.isNull("mid")) {
                        String optString = jSONObject.optString("mid");
                        if (s.aK(optString) && !s.aK(this.aQt.nO())) {
                            this.aQt.aQs.aQm = optString;
                            this.aQt.aQs.aQl = s.W(i.mContext);
                            this.aQt.aQs.aMq = s.V(i.mContext);
                            if (jSONObject.isNull("ts")) {
                                this.aQt.aQs.aQn = System.currentTimeMillis();
                            } else {
                                long optLong = jSONObject.optLong("ts");
                                if (optLong > 0) {
                                    this.aQt.aQs.aQn = optLong;
                                }
                            }
                            new StringBuilder("new mid midEntity:").append(this.aQt.aQs.toString());
                            r.T(i.mContext).b(this.aQt.aQs);
                        }
                    }
                    if (!jSONObject.isNull(a.aPT)) {
                        i = jSONObject.getInt(a.aPT);
                    }
                    if (!jSONObject.isNull(a.aPU)) {
                        i2 = jSONObject.getInt(a.aPU);
                    }
                    j.aQv = jSONObject.optInt("disable", 0);
                    j.aQw = jSONObject.optInt("limit", 0);
                }
                r T = r.T(i.mContext);
                a nT = T.nT();
                if (i > 0) {
                    nT.aPP = i;
                }
                if (i2 > 0) {
                    nT.aPQ = i2;
                }
                nT.aPN = System.currentTimeMillis();
                nT.aPO = 0;
                T.b(nT);
            } catch (Throwable th) {
            }
        }
    }

    private i(Context context) {
        HandlerThread handlerThread = new HandlerThread(i.class.getSimpleName());
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper());
        Context applicationContext = context.getApplicationContext();
        mContext = applicationContext;
        aQq = PreferenceManager.getDefaultSharedPreferences(applicationContext).getLong("__MID_LAST_CHECK_TIME__", 0);
    }

    public static i R(Context context) {
        if (aQo == null) {
            synchronized (i.class) {
                if (aQo == null) {
                    aQo = new i(context);
                }
            }
        }
        return aQo;
    }

    public static void a(f fVar) {
        aQp = fVar;
    }

    public final String nO() {
        if (this.aQs == null || !s.aK(this.aQs.aQm)) {
            int i;
            this.aQs = r.T(mContext).nS();
            if (s.aK(this.aQs.aQm)) {
                i = 2;
            } else {
                i = 1;
            }
            if (mHandler != null) {
                mHandler.post(new n(mContext, i));
            }
            new StringBuilder("wx get mid:").append(this.aQs.aQm);
        }
        return this.aQs.aQm;
    }

    public final String nP() {
        if (this.aQs == null || !s.aK(this.aQs.aQm)) {
            this.aQs = r.T(mContext).nS();
        }
        return this.aQs.aQm;
    }
}
