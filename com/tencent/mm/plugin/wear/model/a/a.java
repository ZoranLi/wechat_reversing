package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.t;
import android.util.Log;
import com.google.android.gms.c.au;
import com.google.android.gms.c.av;
import com.google.android.gms.c.be;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c.a.AnonymousClass1;
import com.google.android.gms.common.api.o;
import com.google.android.gms.common.api.u;
import com.google.android.gms.common.api.v;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c.d;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.i;
import com.google.android.gms.wearable.k;
import com.google.android.gms.wearable.m;
import com.google.android.gms.wearable.p;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class a implements b {
    private c rUk;

    public a() {
        boolean z;
        c cVar = null;
        boolean z2 = true;
        com.google.android.gms.common.api.c.a aVar = new com.google.android.gms.common.api.c.a(ab.getContext());
        com.google.android.gms.common.api.a aVar2 = p.aDy;
        aVar.amw.put(aVar2, null);
        aVar.amq.addAll(aVar2.jh().jj());
        if (aVar.amw.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        w.b(z, "must call addApi() to add at least one API");
        if (aVar.amy >= 0) {
            c oVar = new o(aVar.mContext.getApplicationContext(), aVar.amB, aVar.jr(), aVar.amC, aVar.amD, aVar.amw, aVar.amE, aVar.amF, aVar.amy, -1);
            u a = u.a(aVar.amx);
            if (a == null) {
                new Handler(aVar.mContext.getMainLooper()).post(new AnonymousClass1(aVar, oVar));
            } else {
                aVar.a(a, oVar);
            }
            cVar = oVar;
        } else if (aVar.amz >= 0) {
            android.support.v4.app.s.a c = v.c(aVar.amx);
            int i = aVar.amz;
            if (c.aG() != null) {
                a bU = c.bU(i);
                if (bU != null) {
                    cVar = bU.aoq;
                }
            }
            if (cVar == null) {
                cVar = new o(aVar.mContext.getApplicationContext(), aVar.amB, aVar.jr(), aVar.amC, aVar.amD, aVar.amw, aVar.amE, aVar.amF, -1, aVar.amz);
            }
            i = aVar.amz;
            c.c cVar2 = aVar.amA;
            w.h(cVar, "GoogleApiClient instance cannot be null");
            if (c.aoo.indexOfKey(i) >= 0) {
                z2 = false;
            }
            w.a(z2, "Already managing a GoogleApiClient with id " + i);
            c.aoo.put(i, new b(cVar, cVar2));
            if (c.aG() != null) {
                t.DEBUG = false;
                c.aI().a(i, c);
            }
        } else {
            cVar = new o(aVar.mContext, aVar.amB, aVar.jr(), aVar.amC, aVar.amD, aVar.amw, aVar.amE, aVar.amF, -1, -1);
        }
        this.rUk = cVar;
    }

    public final boolean isAvailable() {
        return h.bvP() || h.bvO();
    }

    public final void bvR() {
        this.rUk.disconnect();
        bvS();
    }

    public final c bvS() {
        if (!this.rUk.isConnected()) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Wear.GlobalConnection", "connect to google api client");
            if (!this.rUk.a(TimeUnit.SECONDS).isSuccess()) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.Wear.GlobalConnection", "google api client connect error, code=%d, ", Integer.valueOf(this.rUk.a(TimeUnit.SECONDS).alZ));
            }
        }
        return this.rUk;
    }

    public final byte[] a(Asset asset) {
        d dVar = (d) p.aFT.a(bvS(), asset).ju();
        if (dVar.jv().isSuccess()) {
            return b.c(dVar.getInputStream());
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.Wear.GlobalConnection", "read asset data not success errorCode=%d | errorMsg=%s", Integer.valueOf(dVar.jv().alZ), dVar.jv().amR);
        return null;
    }

    public final com.tencent.mm.plugin.wear.model.a.b.a t(String str, byte[] bArr) {
        HashSet bvT = bvT();
        com.tencent.mm.plugin.wear.model.a.b.a aVar = new com.tencent.mm.plugin.wear.model.a.b.a();
        Iterator it = bvT.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.wear.model.a.b.a aVar2;
            String str2 = (String) it.next();
            if (bvS().isConnected()) {
                com.tencent.mm.plugin.wear.model.a.b.a aVar3 = new com.tencent.mm.plugin.wear.model.a.b.a();
                Status jv = ((k.b) p.aFV.a(bvS(), str2, str, bArr).b(TimeUnit.SECONDS)).jv();
                if (!jv.isSuccess()) {
                    aVar3.code = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                    aVar3.fPf = jv.amR;
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.Wear.GlobalConnection", "send message not success errorCode=%d | errorMsg=%s", Integer.valueOf(jv.alZ), jv.amR);
                }
                String str3 = "MicroMsg.Wear.GlobalConnection";
                String str4 = "send Message %s %s %d";
                Object[] objArr = new Object[3];
                objArr[0] = str2;
                objArr[1] = str;
                objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                com.tencent.mm.sdk.platformtools.w.d(str3, str4, objArr);
                aVar2 = aVar3;
            } else {
                aVar2 = new com.tencent.mm.plugin.wear.model.a.b.a((byte) 0);
            }
            if (aVar2.code != 0) {
                return aVar2;
            }
        }
        return aVar;
    }

    public final HashSet<String> bvT() {
        HashSet<String> hashSet = new HashSet();
        com.google.android.gms.wearable.n.a aVar = (com.google.android.gms.wearable.n.a) p.aFW.b(bvS()).ju();
        if (aVar != null) {
            for (m id : aVar.mF()) {
                hashSet.add(id.getId());
            }
        }
        return hashSet;
    }

    public final com.tencent.mm.plugin.wear.model.a.b.a u(String str, byte[] bArr) {
        if (!bvS().isConnected()) {
            return new com.tencent.mm.plugin.wear.model.a.b.a((byte) 0);
        }
        com.google.android.gms.wearable.o oVar = new com.google.android.gms.wearable.o(PutDataRequest.at(str));
        oVar.aFP.putLong("key_timestamp", System.currentTimeMillis());
        oVar.aFP.a("key_data", Asset.i(bArr));
        i iVar = oVar.aFP;
        av avVar = new av();
        List arrayList = new ArrayList();
        avVar.aBV = au.a(iVar, arrayList);
        com.google.android.gms.c.au.a aVar = new com.google.android.gms.c.au.a(avVar, arrayList);
        oVar.aFQ.aFF = be.c(aVar.aBT);
        int size = aVar.aBU.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) aVar.aBU.get(i);
            if (num == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            } else if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + num);
            } else {
                if (Log.isLoggable("DataMap", 3)) {
                    new StringBuilder("asPutDataRequest: adding asset: ").append(num).append(" ").append(asset);
                }
                oVar.aFQ.b(num, asset);
                i++;
            }
        }
        p.aFT.a(bvS(), oVar.aFQ);
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.Wear.GlobalConnection", "send data request path=%s | length=%d", r0.apg.getPath(), Integer.valueOf(r0.aFF.length));
        return new com.tencent.mm.plugin.wear.model.a.b.a();
    }

    public final boolean g(Uri uri) {
        p.aFT.b(bvS(), uri);
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", uri);
        return true;
    }

    public final boolean bvU() {
        if (bvS().isConnected() && bvT().size() != 0) {
            return true;
        }
        return false;
    }

    public final void finish() {
        this.rUk.disconnect();
    }

    public final void bvV() {
        com.google.android.gms.wearable.h hVar = (com.google.android.gms.wearable.h) p.aFT.a(bvS()).ju();
        Iterator it = hVar.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.getUri().toString().startsWith("/wechat")) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", fVar.getUri().toString());
                p.aFT.b(bvS(), fVar.getUri());
            }
        }
        hVar.release();
    }
}
