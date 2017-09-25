package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.e.a.ka;
import com.tencent.mm.plugin.wenote.model.a;
import com.tencent.mm.plugin.wenote.model.a.d;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.b.AnonymousClass3;
import com.tencent.mm.plugin.wenote.model.e;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONObject;

public final class b extends c<ka> {
    public b() {
        this.usg = ka.class.getName().hashCode();
    }

    private static boolean a(ka kaVar) {
        w.i("MicroMsg.NotifyWNNoteOperationListener", "on NotifyWNNoteWebviewOperationListener operation listener, %d", new Object[]{Integer.valueOf(kaVar.fQo.type)});
        com.tencent.mm.plugin.wenote.model.b fVar;
        Context context;
        switch (kaVar.fQo.type) {
            case 0:
                a.bAZ().stz.b(kaVar);
                break;
            case 2:
                w.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
                fVar = new f();
                a.bAZ().stz = fVar;
                long j = kaVar.fQo.field_localId;
                context = kaVar.fQo.context;
                String str = kaVar.fQo.fQq;
                Boolean valueOf = Boolean.valueOf(kaVar.fQo.fQy);
                fVar.fQF = j;
                fVar.fQy = valueOf.booleanValue();
                if (!com.tencent.mm.pluginsdk.model.c.sCd) {
                    fVar.stQ = str;
                    fVar.dh(context);
                    ap.vL().D(new Runnable(fVar) {
                        final /* synthetic */ f stT;

                        {
                            this.stT = r1;
                        }

                        public final void run() {
                            this.stT.jg(false);
                            if (f.stS.containsKey(this.stT.stR)) {
                                this.stT.stA = (i) f.stS.get(this.stT.stR);
                            } else {
                                this.stT.bBe();
                            }
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 stU;

                                {
                                    this.stU = r1;
                                }

                                public final void run() {
                                    this.stU.stT.bBa();
                                }
                            });
                        }

                        public final String toString() {
                            return super.toString() + "|dealWNoteInfo";
                        }
                    });
                    break;
                }
                fVar.di(context);
                ap.vL().D(new Runnable(fVar) {
                    final /* synthetic */ f stT;

                    {
                        this.stT = r1;
                    }

                    public final void run() {
                        this.stT.jg(true);
                        if (f.stS.containsKey(this.stT.stR)) {
                            this.stT.stA = (i) f.stS.get(this.stT.stR);
                        } else {
                            this.stT.bBe();
                        }
                        this.stT.g(this.stT.stA.oOQ, true);
                        if (k.bBS() != null) {
                            k.bBS().swt.jh(true);
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|dealWNoteInfo";
                    }
                });
                break;
            case 3:
                kaVar.fQp.path = com.tencent.mm.ay.a.Mg();
                break;
            case 4:
                if (a.bAZ().stz != null) {
                    fVar = a.bAZ().stz;
                    try {
                        JSONObject jSONObject = new JSONObject(kaVar.fQo.fQr);
                        switch (jSONObject.getInt(Columns.TYPE)) {
                            case 2:
                                l cVar = new com.tencent.mm.plugin.wenote.model.a.c();
                                cVar.suI = jSONObject.getString("localEditorId");
                                cVar.type = jSONObject.getInt(Columns.TYPE);
                                cVar.suK = jSONObject.getString("bigImagePath");
                                cVar.fQE = jSONObject.getString("localPath");
                                cVar.suJ = true;
                                fVar.stD.put(cVar.suI, cVar);
                                break;
                            case 3:
                                n dVar = new d();
                                dVar.suI = jSONObject.getString("localEditorId");
                                dVar.type = jSONObject.getInt(Columns.TYPE);
                                dVar.suJ = true;
                                dVar.ndv = jSONObject.getString("poiName");
                                dVar.hCE = jSONObject.getString("address");
                                dVar.lat = jSONObject.getDouble("lat");
                                dVar.lng = jSONObject.getDouble("lng");
                                dVar.suO = (double) jSONObject.getInt("scale");
                                dVar.fQE = jSONObject.getString("localPath");
                                fVar.stD.put(dVar.suI, dVar);
                                break;
                            case 4:
                                q hVar = new h();
                                hVar.suI = jSONObject.getString("localEditorId");
                                hVar.type = jSONObject.getInt(Columns.TYPE);
                                if (jSONObject.getBoolean("downloaded")) {
                                    hVar.suP = jSONObject.getString("lengthStr");
                                    hVar.fQE = jSONObject.getString("localPath");
                                    hVar.fQH = jSONObject.getString("iconPath");
                                    hVar.length = jSONObject.getInt("length");
                                    hVar.fKx = hVar.length;
                                }
                                fVar.stD.put(hVar.suI, hVar);
                                break;
                            case 5:
                                p bVar = new com.tencent.mm.plugin.wenote.model.a.b();
                                bVar.suI = jSONObject.getString("localEditorId");
                                bVar.type = jSONObject.getInt(Columns.TYPE);
                                bVar.title = jSONObject.getString("title");
                                bVar.content = jSONObject.getString("content");
                                bVar.fQH = jSONObject.getString("iconPath");
                                bVar.fQE = jSONObject.getString("localPath");
                                fVar.stD.put(bVar.suI, bVar);
                                break;
                        }
                        ap.vL().D(new AnonymousClass3(fVar, jSONObject.getString("localEditorId")));
                        break;
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.WNNoteBase", e, "", new Object[0]);
                        break;
                    }
                }
                break;
            case 5:
                if (a.bAZ().stz != null) {
                    a.bAZ().stz.aF(kaVar.fQo.fQs, kaVar.fQo.fQt);
                    break;
                }
                break;
            case 6:
                Bundle bundle = kaVar.fQo.fQu;
                m mVar = new m();
                mVar.fOb = (float) bundle.getDouble("latitude");
                mVar.hGU = (float) bundle.getDouble("longtitude");
                mVar.fOd = bundle.getInt("scale");
                mVar.suL = bundle.getString("loclabel");
                mVar.suM = bundle.getString("locpoiname");
                mVar.suN = bundle.getString("editorid");
                com.tencent.mm.plugin.wenote.b.b.a(mVar, true);
                break;
            case 7:
                switch (kaVar.fQo.fQv) {
                    case 2:
                        g.aa(kaVar.fQo.fQx);
                        break;
                    case 3:
                        try {
                            g.Ll(kaVar.fQo.fQr);
                            break;
                        } catch (Throwable e2) {
                            w.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", e2, "", new Object[0]);
                            break;
                        }
                    case 4:
                        g.i(kaVar.fQo.context, kaVar.fQo.path, kaVar.fQo.fQw);
                        break;
                    case 5:
                        g.Lk(kaVar.fQo.path);
                        break;
                    default:
                        break;
                }
            case 8:
                g.aL(kaVar.fQo.context, kaVar.fQo.path);
                break;
            case 9:
                w.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
                fVar = new f();
                fVar.fQF = kaVar.fQo.field_localId;
                a.bAZ().stz = fVar;
                context = kaVar.fQo.context;
                fVar.soD = true;
                if (!com.tencent.mm.pluginsdk.model.c.sCd) {
                    fVar.dh(context);
                    break;
                }
                fVar.di(context);
                break;
            case 10:
                e.r(kaVar.fQo.field_localId, kaVar.fQo.path);
                break;
            case 11:
                e.Z(kaVar.fQo.fQx);
                break;
            case 12:
                com.tencent.mm.plugin.wenote.model.nativenote.manager.f.QZ();
                ap.vL().e(new Runnable(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv()) {
                    final /* synthetic */ c svr;

                    {
                        this.svr = r1;
                    }

                    public final void run() {
                        this.svr.bBw();
                        this.svr.svl = null;
                        this.svr.svm = null;
                        this.svr.svn = 0;
                        c.svk = null;
                        this.svr.svl = null;
                    }
                }, 700);
                break;
        }
        return false;
    }
}
