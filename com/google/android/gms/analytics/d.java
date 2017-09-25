package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.a.a;
import com.google.android.gms.analytics.a.b;
import com.google.android.gms.analytics.a.c;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.p;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.analytics.internal.s;
import com.google.android.gms.c.ae;
import com.google.android.gms.c.ai;
import com.google.android.gms.c.aj;
import com.google.android.gms.c.ak;
import com.google.android.gms.c.al;
import com.google.android.gms.c.am;
import com.google.android.gms.c.an;
import com.google.android.gms.c.ao;
import com.google.android.gms.c.ap;
import com.google.android.gms.c.aq;
import com.google.android.gms.c.ar;
import com.google.android.gms.c.e;
import com.google.android.gms.c.f;
import com.google.android.gms.c.g;
import com.google.android.gms.c.h;
import com.google.android.gms.common.internal.w;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class d extends n implements ai {
    private static DecimalFormat akK;
    private final q ajB;
    private final String akL;
    private final Uri akM;
    private final boolean akN;
    private final boolean akO;

    public d(q qVar, String str) {
        this(qVar, str, (byte) 0);
    }

    private d(q qVar, String str, byte b) {
        super(qVar);
        w.U(str);
        this.ajB = qVar;
        this.akL = str;
        this.akN = true;
        this.akO = false;
        this.akM = O(this.akL);
    }

    public static Uri O(String str) {
        w.U(str);
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    private static void a(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, d(d));
        }
    }

    private static void a(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, i + "x" + i2);
        }
    }

    private static void a(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    private static void b(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static Map<String, String> c(ae aeVar) {
        CharSequence e;
        Map hashMap = new HashMap();
        g gVar = (g) aeVar.a(g.class);
        if (gVar != null) {
            for (Entry entry : Collections.unmodifiableMap(gVar.ahx).entrySet()) {
                Object obj;
                Boolean value = entry.getValue();
                if (value == null) {
                    obj = null;
                } else if (value instanceof String) {
                    String str = (String) value;
                    if (TextUtils.isEmpty(str)) {
                        obj = null;
                    }
                } else if (value instanceof Double) {
                    Double d = (Double) value;
                    obj = d.doubleValue() != 0.0d ? d(d.doubleValue()) : null;
                } else {
                    obj = value instanceof Boolean ? value != Boolean.FALSE ? "1" : null : String.valueOf(value);
                }
                if (obj != null) {
                    hashMap.put(entry.getKey(), obj);
                }
            }
        }
        h hVar = (h) aeVar.a(h.class);
        if (hVar != null) {
            b(hashMap, "t", hVar.ayN);
            b(hashMap, "cid", hVar.aiI);
            b(hashMap, "uid", hVar.ayO);
            b(hashMap, "sc", hVar.ayR);
            a(hashMap, "sf", hVar.ayT);
            a(hashMap, "ni", hVar.ayS);
            b(hashMap, "adid", hVar.ayP);
            a(hashMap, "ate", hVar.ayQ);
        }
        ap apVar = (ap) aeVar.a(ap.class);
        if (apVar != null) {
            b(hashMap, "cd", apVar.aBs);
            a(hashMap, "a", (double) apVar.aBt);
            b(hashMap, "dr", apVar.aBw);
        }
        an anVar = (an) aeVar.a(an.class);
        if (anVar != null) {
            b(hashMap, "ec", anVar.sk);
            b(hashMap, "ea", anVar.aqY);
            b(hashMap, "el", anVar.aBo);
            a(hashMap, "ev", (double) anVar.aBp);
        }
        ak akVar = (ak) aeVar.a(ak.class);
        if (akVar != null) {
            b(hashMap, "cn", akVar.mName);
            b(hashMap, "cs", akVar.aAW);
            b(hashMap, "cm", akVar.aAX);
            b(hashMap, "ck", akVar.aAY);
            b(hashMap, "cc", akVar.aAZ);
            b(hashMap, "ci", akVar.ahk);
            b(hashMap, "anid", akVar.aBa);
            b(hashMap, "gclid", akVar.aBb);
            b(hashMap, "dclid", akVar.aBc);
            b(hashMap, "aclid", akVar.aBd);
        }
        ao aoVar = (ao) aeVar.a(ao.class);
        if (aoVar != null) {
            b(hashMap, "exd", aoVar.aBq);
            a(hashMap, "exf", aoVar.aBr);
        }
        aq aqVar = (aq) aeVar.a(aq.class);
        if (aqVar != null) {
            b(hashMap, "sn", aqVar.aBA);
            b(hashMap, "sa", aqVar.aqY);
            b(hashMap, "st", aqVar.aBB);
        }
        ar arVar = (ar) aeVar.a(ar.class);
        if (arVar != null) {
            b(hashMap, "utv", arVar.aBC);
            a(hashMap, "utt", (double) arVar.aBD);
            b(hashMap, "utc", arVar.sk);
            b(hashMap, "utl", arVar.aBo);
        }
        e eVar = (e) aeVar.a(e.class);
        if (eVar != null) {
            for (Entry entry2 : Collections.unmodifiableMap(eVar.ayL).entrySet()) {
                e = e.e("cd", ((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(e)) {
                    hashMap.put(e, entry2.getValue());
                }
            }
        }
        f fVar = (f) aeVar.a(f.class);
        if (fVar != null) {
            for (Entry entry22 : Collections.unmodifiableMap(fVar.ayM).entrySet()) {
                e = e.e("cm", ((Integer) entry22.getKey()).intValue());
                if (!TextUtils.isEmpty(e)) {
                    hashMap.put(e, d(((Double) entry22.getValue()).doubleValue()));
                }
            }
        }
        am amVar = (am) aeVar.a(am.class);
        if (amVar != null) {
            b bVar = amVar.aBn;
            if (bVar != null) {
                for (Entry entry3 : new HashMap(bVar.ahj).entrySet()) {
                    if (((String) entry3.getKey()).startsWith("&")) {
                        hashMap.put(((String) entry3.getKey()).substring(1), entry3.getValue());
                    } else {
                        hashMap.put(entry3.getKey(), entry3.getValue());
                    }
                }
            }
            int i = 1;
            for (c u : Collections.unmodifiableList(amVar.aBl)) {
                hashMap.putAll(u.u(e.e("promo", i)));
                i++;
            }
            i = 1;
            for (a u2 : Collections.unmodifiableList(amVar.aBk)) {
                hashMap.putAll(u2.u(e.e("pr", i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry32 : amVar.aBm.entrySet()) {
                List<a> list = (List) entry32.getValue();
                String e2 = e.e("il", i2);
                i = 1;
                for (a u3 : list) {
                    hashMap.putAll(u3.u(e2 + e.e("pi", i)));
                    i++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry32.getKey())) {
                    hashMap.put(e2 + "nm", entry32.getKey());
                }
                i2++;
            }
        }
        al alVar = (al) aeVar.a(al.class);
        if (alVar != null) {
            b(hashMap, "ul", alVar.aBe);
            a(hashMap, "sd", (double) alVar.aBf);
            a(hashMap, "sr", alVar.aBg, alVar.aBh);
            a(hashMap, "vp", alVar.aBi, alVar.aBj);
        }
        aj ajVar = (aj) aeVar.a(aj.class);
        if (ajVar != null) {
            b(hashMap, "an", ajVar.ahs);
            b(hashMap, "aid", ajVar.aAU);
            b(hashMap, "aiid", ajVar.aAV);
            b(hashMap, "av", ajVar.aht);
        }
        return hashMap;
    }

    private static String d(double d) {
        if (akK == null) {
            akK = new DecimalFormat("0.######");
        }
        return akK.format(d);
    }

    public final void b(ae aeVar) {
        w.Z(aeVar);
        w.b(aeVar.aAz, "Can't deliver not submitted measurement");
        w.W("deliver should be called on worker thread");
        ae lb = aeVar.lb();
        h hVar = (h) lb.b(h.class);
        if (TextUtils.isEmpty(hVar.ayN)) {
            this.ahK.ig().a(c(lb), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(hVar.aiI)) {
            this.ahK.ig().a(c(lb), "Ignoring measurement without client id");
        } else if (!this.ajB.ij().ahi) {
            double d = hVar.ayT;
            if (k.a(d, hVar.aiI)) {
                e("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d));
                return;
            }
            Map c = c(lb);
            c.put("v", "1");
            c.put("_v", p.aip);
            c.put("tid", this.akL);
            if (this.ajB.ij().ahh) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Entry entry : c.entrySet()) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                }
                a(4, "Dry run is enabled. GoogleAnalytics would have sent", stringBuilder.toString(), null, null);
                return;
            }
            Map hashMap = new HashMap();
            k.a(hashMap, "uid", hVar.ayO);
            aj ajVar = (aj) aeVar.a(aj.class);
            if (ajVar != null) {
                k.a(hashMap, "an", ajVar.ahs);
                k.a(hashMap, "aid", ajVar.aAU);
                k.a(hashMap, "av", ajVar.aht);
                k.a(hashMap, "aiid", ajVar.aAV);
            }
            c.put("_s", String.valueOf(this.ahK.ii().a(new s(0, hVar.aiI, this.akL, !TextUtils.isEmpty(hVar.ayP), 0, hashMap))));
            this.ahK.ii().c(new com.google.android.gms.analytics.internal.c(this.ahK.ig(), c, aeVar.aAA));
        }
    }

    public final Uri ja() {
        return this.akM;
    }
}
