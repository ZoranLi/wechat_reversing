package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.google.android.gms.analytics.internal.i.a;
import com.google.android.gms.common.internal.w;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class f extends o {
    private static String ahG = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
    private static String ahH = "01VDIWEA?";
    private static f ahI;

    public f(q qVar) {
        super(qVar);
    }

    private static String T(Object obj) {
        if (obj == null) {
            return null;
        }
        Object l = obj instanceof Integer ? new Long((long) ((Integer) obj).intValue()) : obj;
        if (!(l instanceof Long)) {
            return l instanceof Boolean ? String.valueOf(l) : l instanceof Throwable ? l.getClass().getCanonicalName() : "-";
        } else {
            if (Math.abs(((Long) l).longValue()) < 100) {
                return String.valueOf(l);
            }
            String str = String.valueOf(l).charAt(0) == '-' ? "-" : "";
            String valueOf = String.valueOf(Math.abs(((Long) l).longValue()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))));
            stringBuilder.append("...");
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d));
            return stringBuilder.toString();
        }
    }

    private synchronized void b(int i, String str, Object obj, Object obj2, Object obj3) {
        w.Z(str);
        int i2 = i < 0 ? 0 : i;
        int length = i2 >= ahH.length() ? ahH.length() - 1 : i2;
        char c = this.ahK.ais.iJ() ? com.google.android.gms.common.internal.f.apP ? 'P' : 'C' : com.google.android.gms.common.internal.f.apP ? 'p' : 'c';
        String str2 = ahG + ahH.charAt(length) + c + p.VERSION + ":" + n.a(str, T(obj), T(obj2), T(obj3));
        if (str2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            str2 = str2.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        q qVar = this.ahK;
        i iVar = (qVar.aiy == null || !qVar.aiy.isInitialized()) ? null : qVar.aiy;
        if (iVar != null) {
            a aVar = iVar.ahW;
            if (aVar.hM() == 0) {
                aVar.hL();
            }
            String str3 = str2 == null ? "" : str2;
            synchronized (aVar) {
                long j = aVar.ahY.ahT.getLong(aVar.hO(), 0);
                if (j <= 0) {
                    Editor edit = aVar.ahY.ahT.edit();
                    edit.putString(aVar.hP(), str3);
                    edit.putLong(aVar.hO(), 1);
                    edit.apply();
                } else {
                    Object obj4 = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (1 + j) ? 1 : null;
                    Editor edit2 = aVar.ahY.ahT.edit();
                    if (obj4 != null) {
                        edit2.putString(aVar.hP(), str3);
                    }
                    edit2.putLong(aVar.hO(), j + 1);
                    edit2.apply();
                }
            }
        }
    }

    public static f hC() {
        return ahI;
    }

    public final void a(int i, String str, Object obj, Object obj2, Object obj3) {
        String str2 = (String) aj.ajQ.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, n.a(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            b(i, str, obj, obj2, obj3);
        }
    }

    public final void a(c cVar, String str) {
        f("Discarding hit. " + str, cVar != null ? cVar.toString() : "no hit data");
    }

    public final void a(Map<String, String> map, String str) {
        Object stringBuilder;
        if (map != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : map.entrySet()) {
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append(',');
                }
                stringBuilder2.append((String) entry.getKey());
                stringBuilder2.append('=');
                stringBuilder2.append((String) entry.getValue());
            }
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "no hit data";
        }
        f("Discarding hit. " + str, stringBuilder);
    }

    protected final void hu() {
        synchronized (f.class) {
            ahI = this;
        }
    }
}
