package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class d {
    private static d aEc;
    private final a aDX;
    private final c aDY;
    final ad aDZ;
    final ConcurrentMap<am, Boolean> aEa;
    private final an aEb;
    private final Context mContext;

    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] aEe = new int[a.mm().length];

        static {
            try {
                aEe[a.aEq - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                aEe[a.aEr - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                aEe[a.aEs - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public interface a {
    }

    private d(Context context, a aVar, c cVar, ad adVar) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.aDZ = adVar;
        this.aDX = aVar;
        this.aEa = new ConcurrentHashMap();
        this.aDY = cVar;
        this.aDY.a(new b(this) {
            final /* synthetic */ d aEd;

            {
                this.aEd = r1;
            }

            public final void g(Map<String, Object> map) {
                Object obj = map.get("event");
                if (obj != null) {
                    d dVar = this.aEd;
                    String obj2 = obj.toString();
                    for (am ao : dVar.aEa.keySet()) {
                        ao.ao(obj2);
                    }
                }
            }
        });
        this.aDY.a(new ag(this.mContext));
        this.aEb = new an();
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new ComponentCallbacks2(this) {
                final /* synthetic */ d aEd;

                {
                    this.aEd = r1;
                }

                public final void onConfigurationChanged(Configuration configuration) {
                }

                public final void onLowMemory() {
                }

                public final void onTrimMemory(int i) {
                    if (i == 20) {
                        this.aEd.aDZ.mo();
                    }
                }
            });
        }
    }

    public static d N(Context context) {
        d dVar;
        synchronized (d.class) {
            if (aEc == null) {
                if (context == null) {
                    m.lQ();
                    throw new NullPointerException();
                }
                aEc = new d(context, new a() {
                }, new c(new ap(context)), ae.mp());
            }
            dVar = aEc;
        }
        return dVar;
    }

    final synchronized boolean d(Uri uri) {
        boolean z;
        w ml = w.ml();
        if (ml.d(uri)) {
            String str = ml.aDJ;
            switch (AnonymousClass4.aEe[ml.aEn - 1]) {
                case 1:
                    for (am amVar : this.aEa.keySet()) {
                        if (amVar.mt().equals(str)) {
                            amVar.mu();
                            amVar.refresh();
                        }
                    }
                    break;
                case 2:
                case 3:
                    for (am amVar2 : this.aEa.keySet()) {
                        String str2;
                        if (amVar2.mt().equals(str)) {
                            str2 = ml.aEo;
                            amVar2.mu();
                            amVar2.refresh();
                        } else {
                            if (amVar2.aFt) {
                                m.lQ();
                                str2 = "";
                            } else {
                                str2 = amVar2.aFs.mv();
                            }
                            if (str2 != null) {
                                amVar2.mu();
                                amVar2.refresh();
                            }
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
