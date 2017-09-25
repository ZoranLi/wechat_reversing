package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.c;
import com.google.android.gms.analytics.d;
import com.google.android.gms.analytics.internal.i.a;
import com.google.android.gms.c.ae;
import com.google.android.gms.c.af;
import com.google.android.gms.c.ah;
import com.google.android.gms.c.ai;
import com.google.android.gms.c.aj;
import com.google.android.gms.c.ak;
import com.google.android.gms.c.g;
import com.google.android.gms.c.h;
import com.google.android.gms.common.internal.f;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

final class w extends o {
    private final u ajd;
    private final h aje;
    private final g ajf;
    private final t ajg;
    private long ajh = Long.MIN_VALUE;
    private final ae aji;
    private final ae ajj;
    private final j ajk;
    private long ajl;
    private boolean ajm;
    private boolean ny;

    protected w(q qVar, r rVar) {
        super(qVar);
        com.google.android.gms.common.internal.w.Z(rVar);
        this.ajf = new g(qVar);
        this.ajd = new u(qVar);
        this.aje = new h(qVar);
        this.ajg = r.d(qVar);
        this.ajk = new j(this.ahK.ahZ);
        this.aji = new ae(this, qVar) {
            final /* synthetic */ w ajn;

            public final void run() {
                w wVar = this.ajn;
                wVar.b(new ah(wVar) {
                    final /* synthetic */ w ajn;

                    {
                        this.ajn = r1;
                    }

                    public final void hr() {
                        this.ajn.iA();
                    }
                });
            }
        };
        this.ajj = new ae(this, qVar) {
            final /* synthetic */ w ajn;

            public final void run() {
                this.ajn.ix();
            }
        };
    }

    private boolean K(String str) {
        return this.ahK.mContext.checkCallingOrSelfPermission(str) == 0;
    }

    private void a(s sVar, ak akVar) {
        com.google.android.gms.common.internal.w.Z(sVar);
        com.google.android.gms.common.internal.w.Z(akVar);
        c cVar = new c(this.ahK);
        String str = sVar.aiJ;
        com.google.android.gms.common.internal.w.U(str);
        Uri O = d.O(str);
        ListIterator listIterator = cVar.ld().listIterator();
        while (listIterator.hasNext()) {
            if (O.equals(((ai) listIterator.next()).ja())) {
                listIterator.remove();
            }
        }
        cVar.ld().add(new d(cVar.ajB, str));
        cVar.akJ = sVar.aiK;
        ae iZ = cVar.iZ();
        h hVar = (h) iZ.b(h.class);
        hVar.ayN = SlookAirButtonFrequentContactAdapter.DATA;
        hVar.ayS = true;
        iZ.b((af) akVar);
        g gVar = (g) iZ.b(g.class);
        aj ajVar = (aj) iZ.b(aj.class);
        for (Entry entry : sVar.ahx.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if ("an".equals(str2)) {
                ajVar.ahs = str3;
            } else if ("av".equals(str2)) {
                ajVar.aht = str3;
            } else if ("aid".equals(str2)) {
                ajVar.aAU = str3;
            } else if ("aiid".equals(str2)) {
                ajVar.aAV = str3;
            } else if ("uid".equals(str2)) {
                hVar.ayO = str3;
            } else {
                gVar.ahx.put(g.af(str2), str3);
            }
        }
        b("Sending installation campaign to", sVar.aiJ, akVar);
        iZ.aAB = ic().hG();
        ah ahVar = iZ.aAy.aAI;
        if (iZ.aAF) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (iZ.aAz) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            ae lb = iZ.lb();
            lb.aAC = lb.ahZ.elapsedRealtime();
            if (lb.aAB != 0) {
                lb.aAA = lb.aAB;
            } else {
                lb.aAA = lb.ahZ.currentTimeMillis();
            }
            lb.aAz = true;
            ahVar.aAO.execute(new com.google.android.gms.c.ah.AnonymousClass1(ahVar, lb));
        }
    }

    private void iB() {
        ag ib = ib();
        if (ib.ajL && !ib.ajM) {
            long is = is();
            if (is != 0 && Math.abs(this.ahK.ahZ.currentTimeMillis() - is) <= ((Long) aj.akb.get()).longValue()) {
                d("Dispatch alarm scheduled (ms)", Long.valueOf(ac.iN()));
                ib.iX();
            }
        }
    }

    private void iC() {
        if (this.aji.iV()) {
            C("All hits dispatched or no network/service. Going to power save mode");
        }
        this.aji.cancel();
        ag ib = ib();
        if (ib.ajM) {
            ib.cancel();
        }
    }

    private long iD() {
        if (this.ajh != Long.MIN_VALUE) {
            return this.ajh;
        }
        return this.ahK.ik().hT() ? ((long) this.ahK.ik().hU()) * 1000 : ((Long) aj.ajW.get()).longValue();
    }

    private void iE() {
        ie();
        q.im();
        this.ajm = true;
        this.ajg.disconnect();
        iA();
    }

    private long is() {
        ah.im();
        ie();
        try {
            return this.ajd.is();
        } catch (SQLiteException e) {
            g("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    private void iy() {
        if (!this.ajm && ac.iK() && !this.ajg.isConnected()) {
            if (this.ajk.f(((Long) aj.akC.get()).longValue())) {
                this.ajk.start();
                C("Connecting to service");
                if (this.ajg.connect()) {
                    C("Connected to service");
                    this.ajk.aia = 0;
                    onServiceConnected();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean iz() {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        com.google.android.gms.c.ah.im();
        r12.ie();
        r0 = "Dispatching a batch of local hits";
        r12.C(r0);
        r0 = r12.ajg;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x002e;
    L_0x0016:
        r0 = com.google.android.gms.common.internal.f.apP;
        if (r0 != 0) goto L_0x002e;
    L_0x001a:
        r0 = r1;
    L_0x001b:
        r3 = r12.aje;
        r3 = r3.hE();
        if (r3 != 0) goto L_0x0030;
    L_0x0023:
        if (r0 == 0) goto L_0x0032;
    L_0x0025:
        if (r1 == 0) goto L_0x0032;
    L_0x0027:
        r0 = "No network or service available. Will retry later";
        r12.C(r0);
    L_0x002d:
        return r2;
    L_0x002e:
        r0 = r2;
        goto L_0x001b;
    L_0x0030:
        r1 = r2;
        goto L_0x0023;
    L_0x0032:
        r0 = com.google.android.gms.analytics.internal.ac.iO();
        r1 = com.google.android.gms.analytics.internal.ac.iP();
        r0 = java.lang.Math.max(r0, r1);
        r6 = (long) r0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r0 = 0;
        r4 = r0;
    L_0x0047:
        r0 = r12.ajd;	 Catch:{ all -> 0x01e4 }
        r0.beginTransaction();	 Catch:{ all -> 0x01e4 }
        r3.clear();	 Catch:{ all -> 0x01e4 }
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x00cb }
        r8 = r0.h(r6);	 Catch:{ SQLiteException -> 0x00cb }
        r0 = r8.isEmpty();	 Catch:{ SQLiteException -> 0x00cb }
        if (r0 == 0) goto L_0x007a;
    L_0x005b:
        r0 = "Store is empty, nothing to dispatch";
        r12.C(r0);	 Catch:{ SQLiteException -> 0x00cb }
        r12.iC();	 Catch:{ SQLiteException -> 0x00cb }
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x006f }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x006f }
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x006f }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x006f }
        goto L_0x002d;
    L_0x006f:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iC();
        goto L_0x002d;
    L_0x007a:
        r0 = "Hits loaded from store. count";
        r1 = r8.size();	 Catch:{ SQLiteException -> 0x00cb }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x00cb }
        r12.d(r0, r1);	 Catch:{ SQLiteException -> 0x00cb }
        r1 = r8.iterator();	 Catch:{ all -> 0x01e4 }
    L_0x008c:
        r0 = r1.hasNext();	 Catch:{ all -> 0x01e4 }
        if (r0 == 0) goto L_0x00ed;
    L_0x0092:
        r0 = r1.next();	 Catch:{ all -> 0x01e4 }
        r0 = (com.google.android.gms.analytics.internal.c) r0;	 Catch:{ all -> 0x01e4 }
        r10 = r0.ahz;	 Catch:{ all -> 0x01e4 }
        r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x008c;
    L_0x009e:
        r0 = "Database contains successfully uploaded hit";
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01e4 }
        r3 = r8.size();	 Catch:{ all -> 0x01e4 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x01e4 }
        r12.d(r0, r1, r3);	 Catch:{ all -> 0x01e4 }
        r12.iC();	 Catch:{ all -> 0x01e4 }
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x00bf }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00bf }
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x00bf }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00bf }
        goto L_0x002d;
    L_0x00bf:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iC();
        goto L_0x002d;
    L_0x00cb:
        r0 = move-exception;
        r1 = "Failed to read hits from persisted store";
        r12.f(r1, r0);	 Catch:{ all -> 0x01e4 }
        r12.iC();	 Catch:{ all -> 0x01e4 }
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x00e1 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00e1 }
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x00e1 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00e1 }
        goto L_0x002d;
    L_0x00e1:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iC();
        goto L_0x002d;
    L_0x00ed:
        r0 = r12.ajg;	 Catch:{ all -> 0x01e4 }
        r0 = r0.isConnected();	 Catch:{ all -> 0x01e4 }
        if (r0 == 0) goto L_0x0156;
    L_0x00f5:
        r0 = com.google.android.gms.common.internal.f.apP;	 Catch:{ all -> 0x01e4 }
        if (r0 != 0) goto L_0x0156;
    L_0x00f9:
        r0 = "Service connected, sending hits to the service";
        r12.C(r0);	 Catch:{ all -> 0x01e4 }
    L_0x00ff:
        r0 = r8.isEmpty();	 Catch:{ all -> 0x01e4 }
        if (r0 != 0) goto L_0x0156;
    L_0x0105:
        r0 = 0;
        r0 = r8.get(r0);	 Catch:{ all -> 0x01e4 }
        r0 = (com.google.android.gms.analytics.internal.c) r0;	 Catch:{ all -> 0x01e4 }
        r1 = r12.ajg;	 Catch:{ all -> 0x01e4 }
        r1 = r1.d(r0);	 Catch:{ all -> 0x01e4 }
        if (r1 == 0) goto L_0x0156;
    L_0x0114:
        r10 = r0.ahz;	 Catch:{ all -> 0x01e4 }
        r4 = java.lang.Math.max(r4, r10);	 Catch:{ all -> 0x01e4 }
        r8.remove(r0);	 Catch:{ all -> 0x01e4 }
        r1 = "Hit sent do device AnalyticsService for delivery";
        r12.e(r1, r0);	 Catch:{ all -> 0x01e4 }
        r1 = r12.ajd;	 Catch:{ SQLiteException -> 0x0134 }
        r10 = r0.ahz;	 Catch:{ SQLiteException -> 0x0134 }
        r1.i(r10);	 Catch:{ SQLiteException -> 0x0134 }
        r0 = r0.ahz;	 Catch:{ SQLiteException -> 0x0134 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ SQLiteException -> 0x0134 }
        r3.add(r0);	 Catch:{ SQLiteException -> 0x0134 }
        goto L_0x00ff;
    L_0x0134:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r12.g(r1, r0);	 Catch:{ all -> 0x01e4 }
        r12.iC();	 Catch:{ all -> 0x01e4 }
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x014a }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x014a }
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x014a }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x014a }
        goto L_0x002d;
    L_0x014a:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iC();
        goto L_0x002d;
    L_0x0156:
        r0 = r4;
        r4 = r12.aje;	 Catch:{ all -> 0x01e4 }
        r4 = r4.hE();	 Catch:{ all -> 0x01e4 }
        if (r4 == 0) goto L_0x018b;
    L_0x015f:
        r4 = r12.aje;	 Catch:{ all -> 0x01e4 }
        r9 = r4.i(r8);	 Catch:{ all -> 0x01e4 }
        r10 = r9.iterator();	 Catch:{ all -> 0x01e4 }
        r4 = r0;
    L_0x016a:
        r0 = r10.hasNext();	 Catch:{ all -> 0x01e4 }
        if (r0 == 0) goto L_0x017f;
    L_0x0170:
        r0 = r10.next();	 Catch:{ all -> 0x01e4 }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x01e4 }
        r0 = r0.longValue();	 Catch:{ all -> 0x01e4 }
        r4 = java.lang.Math.max(r4, r0);	 Catch:{ all -> 0x01e4 }
        goto L_0x016a;
    L_0x017f:
        r8.removeAll(r9);	 Catch:{ all -> 0x01e4 }
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x01a9 }
        r0.k(r9);	 Catch:{ SQLiteException -> 0x01a9 }
        r3.addAll(r9);	 Catch:{ SQLiteException -> 0x01a9 }
        r0 = r4;
    L_0x018b:
        r4 = r3.isEmpty();	 Catch:{ all -> 0x01e4 }
        if (r4 == 0) goto L_0x01cb;
    L_0x0191:
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x019d }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x019d }
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x019d }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x019d }
        goto L_0x002d;
    L_0x019d:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iC();
        goto L_0x002d;
    L_0x01a9:
        r0 = move-exception;
        r1 = "Failed to remove successfully uploaded hits";
        r12.g(r1, r0);	 Catch:{ all -> 0x01e4 }
        r12.iC();	 Catch:{ all -> 0x01e4 }
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x01bf }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01bf }
        r0 = r12.ajd;	 Catch:{ SQLiteException -> 0x01bf }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x01bf }
        goto L_0x002d;
    L_0x01bf:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iC();
        goto L_0x002d;
    L_0x01cb:
        r4 = r12.ajd;	 Catch:{ SQLiteException -> 0x01d8 }
        r4.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01d8 }
        r4 = r12.ajd;	 Catch:{ SQLiteException -> 0x01d8 }
        r4.endTransaction();	 Catch:{ SQLiteException -> 0x01d8 }
        r4 = r0;
        goto L_0x0047;
    L_0x01d8:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iC();
        goto L_0x002d;
    L_0x01e4:
        r0 = move-exception;
        r1 = r12.ajd;	 Catch:{ SQLiteException -> 0x01f0 }
        r1.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01f0 }
        r1 = r12.ajd;	 Catch:{ SQLiteException -> 0x01f0 }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x01f0 }
        throw r0;
    L_0x01f0:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.iC();
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.w.iz():boolean");
    }

    public final void L(String str) {
        com.google.android.gms.common.internal.w.U(str);
        q.im();
        n.ia();
        ak a = k.a(this.ahK.ig(), str);
        if (a == null) {
            f("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence hK = ic().hK();
        if (str.equals(hK)) {
            F("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(hK)) {
            ic().y(str);
            if (ic().hH().f(ac.iU())) {
                f("Campaign received too late, ignoring", a);
                return;
            }
            e("Received installation campaign", a);
            for (s a2 : this.ajd.it()) {
                a(a2, a);
            }
        } else {
            d("Ignoring multiple install campaigns. original, new", hK, str);
        }
    }

    public final void b(ah ahVar) {
        long j = this.ajl;
        ah.im();
        ie();
        long j2 = -1;
        long hI = ic().hI();
        if (hI != 0) {
            j2 = Math.abs(this.ahK.ahZ.currentTimeMillis() - hI);
        }
        e("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        if (!f.apP) {
            iy();
        }
        try {
            iz();
            ic().hJ();
            iA();
            if (ahVar != null) {
                ahVar.hr();
            }
            if (this.ajl != j) {
                g gVar = this.ajf;
                if (VERSION.SDK_INT > 10) {
                    Context context = gVar.ahK.mContext;
                    Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
                    intent.addCategory(context.getPackageName());
                    intent.putExtra(g.ahJ, true);
                    context.sendOrderedBroadcast(intent, null);
                }
            }
        } catch (Throwable th) {
            g("Local dispatch failed", th);
            ic().hJ();
            iA();
            if (ahVar != null) {
                ahVar.hr();
            }
        }
    }

    public final void c(c cVar) {
        com.google.android.gms.common.internal.w.Z(cVar);
        ah.im();
        ie();
        if (this.ajm) {
            D("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            d("Delivering hit", cVar);
        }
        if (TextUtils.isEmpty(cVar.c("_m", ""))) {
            Pair pair;
            a aVar = ic().ahW;
            long hM = aVar.hM();
            hM = hM == 0 ? 0 : Math.abs(hM - aVar.ahY.ahK.ahZ.currentTimeMillis());
            if (hM < aVar.ahX) {
                pair = null;
            } else if (hM > aVar.ahX * 2) {
                aVar.hL();
                pair = null;
            } else {
                String string = aVar.ahY.ahT.getString(aVar.hP(), null);
                long j = aVar.ahY.ahT.getLong(aVar.hO(), 0);
                aVar.hL();
                pair = (string == null || j <= 0) ? null : new Pair(string, Long.valueOf(j));
            }
            if (pair != null) {
                String str = ((Long) pair.second) + ":" + ((String) pair.first);
                Map hashMap = new HashMap(cVar.ahx);
                hashMap.put("_m", str);
                cVar = new c(this, hashMap, cVar.ahA, cVar.ahC, cVar.ahz, cVar.ahB, cVar.ahy);
            }
        }
        iy();
        if (this.ajg.d(cVar)) {
            D("Hit sent to the device AnalyticsService for delivery");
        } else if (f.apP) {
            this.ahK.ig().a(cVar, "Service unavailable on package side");
        } else {
            try {
                this.ajd.e(cVar);
                iA();
            } catch (SQLiteException e) {
                g("Delivery failed to save hit to a database", e);
                this.ahK.ig().a(cVar, "deliver: failed to insert hit to database");
            }
        }
    }

    protected final void c(s sVar) {
        q.im();
        e("Sending first hit to property", sVar.aiJ);
        if (!ic().hH().f(ac.iU())) {
            String hK = ic().hK();
            if (!TextUtils.isEmpty(hK)) {
                ak a = k.a(this.ahK.ig(), hK);
                e("Found relevant installation campaign", a);
                a(sVar, a);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long d(com.google.android.gms.analytics.internal.s r6) {
        /*
        r5 = this;
        com.google.android.gms.common.internal.w.Z(r6);
        r5.ie();
        com.google.android.gms.analytics.internal.q.im();
        r0 = r5.ajd;	 Catch:{ SQLiteException -> 0x0040 }
        r0.beginTransaction();	 Catch:{ SQLiteException -> 0x0040 }
        r0 = r5.ajd;	 Catch:{ SQLiteException -> 0x0040 }
        r2 = r6.aiH;	 Catch:{ SQLiteException -> 0x0040 }
        r1 = r6.aiI;	 Catch:{ SQLiteException -> 0x0040 }
        r0.a(r2, r1);	 Catch:{ SQLiteException -> 0x0040 }
        r0 = r5.ajd;	 Catch:{ SQLiteException -> 0x0040 }
        r2 = r6.aiH;	 Catch:{ SQLiteException -> 0x0040 }
        r1 = r6.aiI;	 Catch:{ SQLiteException -> 0x0040 }
        r4 = r6.aiJ;	 Catch:{ SQLiteException -> 0x0040 }
        r0 = r0.a(r2, r1, r4);	 Catch:{ SQLiteException -> 0x0040 }
        r2 = 1;
        r2 = r2 + r0;
        r6.aiL = r2;	 Catch:{ SQLiteException -> 0x0040 }
        r2 = r5.ajd;	 Catch:{ SQLiteException -> 0x0040 }
        r2.b(r6);	 Catch:{ SQLiteException -> 0x0040 }
        r2 = r5.ajd;	 Catch:{ SQLiteException -> 0x0040 }
        r2.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0040 }
        r2 = r5.ajd;	 Catch:{ SQLiteException -> 0x0038 }
        r2.endTransaction();	 Catch:{ SQLiteException -> 0x0038 }
    L_0x0037:
        return r0;
    L_0x0038:
        r2 = move-exception;
        r3 = "Failed to end transaction";
        r5.g(r3, r2);
        goto L_0x0037;
    L_0x0040:
        r0 = move-exception;
        r1 = "Failed to update Analytics property";
        r5.g(r1, r0);	 Catch:{ all -> 0x0057 }
        r0 = r5.ajd;	 Catch:{ SQLiteException -> 0x004f }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x004f }
    L_0x004c:
        r0 = -1;
        goto L_0x0037;
    L_0x004f:
        r0 = move-exception;
        r1 = "Failed to end transaction";
        r5.g(r1, r0);
        goto L_0x004c;
    L_0x0057:
        r0 = move-exception;
        r1 = r5.ajd;	 Catch:{ SQLiteException -> 0x005e }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x005e }
    L_0x005d:
        throw r0;
    L_0x005e:
        r1 = move-exception;
        r2 = "Failed to end transaction";
        r5.g(r2, r1);
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.w.d(com.google.android.gms.analytics.internal.s):long");
    }

    public final void hY() {
        ah.im();
        ie();
        C("Service disconnected");
    }

    final void hZ() {
        q.im();
        this.ajl = this.ahK.ahZ.currentTimeMillis();
    }

    protected final void hu() {
        this.ajd.if();
        this.aje.if();
        this.ajg.if();
    }

    public final void iA() {
        long j = 0;
        q.im();
        ie();
        boolean z = !this.ajm && ((!f.apP || this.ahK.ais.iJ()) && iD() > 0);
        if (!z) {
            this.ajf.unregister();
            iC();
        } else if (this.ajd.isEmpty()) {
            this.ajf.unregister();
            iC();
        } else {
            if (((Boolean) aj.akx.get()).booleanValue()) {
                z = true;
            } else {
                BroadcastReceiver broadcastReceiver = this.ajf;
                broadcastReceiver.hD();
                if (!broadcastReceiver.ahL) {
                    Context context = broadcastReceiver.ahK.mContext;
                    context.registerReceiver(broadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
                    intentFilter.addCategory(context.getPackageName());
                    context.registerReceiver(broadcastReceiver, intentFilter);
                    broadcastReceiver.ahM = broadcastReceiver.hE();
                    broadcastReceiver.ahK.ig().d("Registering connectivity change receiver. Network connected", Boolean.valueOf(broadcastReceiver.ahM));
                    broadcastReceiver.ahL = true;
                }
                g gVar = this.ajf;
                if (!gVar.ahL) {
                    gVar.ahK.ig().F("Connectivity unknown. Receiver not registered");
                }
                z = gVar.ahM;
            }
            if (z) {
                iB();
                long iD = iD();
                long hI = ic().hI();
                if (hI != 0) {
                    hI = iD - Math.abs(this.ahK.ahZ.currentTimeMillis() - hI);
                    if (hI <= 0) {
                        hI = Math.min(ac.iM(), iD);
                    }
                } else {
                    hI = Math.min(ac.iM(), iD);
                }
                d("Dispatch scheduled (ms)", Long.valueOf(hI));
                if (this.aji.iV()) {
                    ae aeVar = this.aji;
                    hI = Math.max(1, hI + (aeVar.ajI == 0 ? 0 : Math.abs(aeVar.ahK.ahZ.currentTimeMillis() - aeVar.ajI)));
                    aeVar = this.aji;
                    if (!aeVar.iV()) {
                        return;
                    }
                    if (hI < 0) {
                        aeVar.cancel();
                        return;
                    }
                    hI -= Math.abs(aeVar.ahK.ahZ.currentTimeMillis() - aeVar.ajI);
                    if (hI >= 0) {
                        j = hI;
                    }
                    aeVar.getHandler().removeCallbacks(aeVar.ajH);
                    if (!aeVar.getHandler().postDelayed(aeVar.ajH, j)) {
                        aeVar.ahK.ig().g("Failed to adjust delayed post. time", Long.valueOf(j));
                        return;
                    }
                    return;
                }
                this.aji.j(hI);
                return;
            }
            iC();
            iB();
        }
    }

    protected final void iw() {
        ie();
        ic().hG();
        if (!K("android.permission.ACCESS_NETWORK_STATE")) {
            G("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            iE();
        }
        if (!K("android.permission.INTERNET")) {
            G("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            iE();
        }
        if (AnalyticsService.t(this.ahK.mContext)) {
            C("AnalyticsService registered in the app manifest and enabled");
        } else if (f.apP) {
            G("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            F("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.ajm || f.apP || this.ajd.isEmpty())) {
            iy();
        }
        iA();
    }

    public final void ix() {
        try {
            this.ajd.ir();
            iA();
        } catch (SQLiteException e) {
            f("Failed to delete stale hits", e);
        }
        this.ajj.j(86400000);
    }

    protected final void onServiceConnected() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        com.google.android.gms.analytics.internal.q.im();
        r0 = com.google.android.gms.common.internal.f.apP;
        if (r0 != 0) goto L_0x002a;
    L_0x0007:
        com.google.android.gms.c.ah.im();
        r6.ie();
        com.google.android.gms.analytics.internal.n.ia();
        r0 = com.google.android.gms.analytics.internal.ac.iK();
        if (r0 != 0) goto L_0x001c;
    L_0x0016:
        r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService";
        r6.F(r0);
    L_0x001c:
        r0 = r6.ajg;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x002b;
    L_0x0024:
        r0 = "Service not connected";
        r6.C(r0);
    L_0x002a:
        return;
    L_0x002b:
        r0 = r6.ajd;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x002a;
    L_0x0033:
        r0 = "Dispatching local hits to device AnalyticsService";
        r6.C(r0);
    L_0x0039:
        r0 = r6.ajd;	 Catch:{ SQLiteException -> 0x004e }
        r1 = com.google.android.gms.analytics.internal.ac.iO();	 Catch:{ SQLiteException -> 0x004e }
        r2 = (long) r1;	 Catch:{ SQLiteException -> 0x004e }
        r1 = r0.h(r2);	 Catch:{ SQLiteException -> 0x004e }
        r0 = r1.isEmpty();	 Catch:{ SQLiteException -> 0x004e }
        if (r0 == 0) goto L_0x0063;	 Catch:{ SQLiteException -> 0x004e }
    L_0x004a:
        r6.iA();	 Catch:{ SQLiteException -> 0x004e }
        goto L_0x002a;
    L_0x004e:
        r0 = move-exception;
        r1 = "Failed to read hits from store";
        r6.g(r1, r0);
        r6.iC();
        goto L_0x002a;
    L_0x0059:
        r1.remove(r0);
        r2 = r6.ajd;	 Catch:{ SQLiteException -> 0x007c }
        r4 = r0.ahz;	 Catch:{ SQLiteException -> 0x007c }
        r2.i(r4);	 Catch:{ SQLiteException -> 0x007c }
    L_0x0063:
        r0 = r1.isEmpty();
        if (r0 != 0) goto L_0x0039;
    L_0x0069:
        r0 = 0;
        r0 = r1.get(r0);
        r0 = (com.google.android.gms.analytics.internal.c) r0;
        r2 = r6.ajg;
        r2 = r2.d(r0);
        if (r2 != 0) goto L_0x0059;
    L_0x0078:
        r6.iA();
        goto L_0x002a;
    L_0x007c:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r6.g(r1, r0);
        r6.iC();
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.w.onServiceConnected():void");
    }

    final void start() {
        ie();
        com.google.android.gms.common.internal.w.a(!this.ny, "Analytics backend already started");
        this.ny = true;
        if (!f.apP) {
            Context context = this.ahK.mContext;
            if (!AnalyticsReceiver.s(context)) {
                F("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
            } else if (!AnalyticsService.t(context)) {
                G("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
            }
            if (!CampaignTrackingReceiver.s(context)) {
                F("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
            } else if (!CampaignTrackingService.t(context)) {
                F("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
            }
        }
        this.ahK.ih().c(new Runnable(this) {
            final /* synthetic */ w ajn;

            {
                this.ajn = r1;
            }

            public final void run() {
                this.ajn.iw();
            }
        });
    }
}
