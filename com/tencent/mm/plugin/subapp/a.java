package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.mm.ae.d;
import com.tencent.mm.e.a.fb;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.subapp.ui.voicetranstext.b;
import com.tencent.mm.pluginsdk.l.aa;
import com.tencent.mm.pluginsdk.l.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bf;
import com.tencent.mm.u.ag.f;
import com.tencent.mm.u.am;
import com.tencent.mm.u.an;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements am, an {
    public static bf qRT;
    private Map<String, am> hoc = new HashMap();
    private a qRU;

    public static class a extends c<fb> implements e {
        private com.tencent.mm.plugin.subapp.ui.voicetranstext.a qRW;
        private com.tencent.mm.plugin.subapp.ui.voicetranstext.c qRX;
        private b qRY;
        private com.tencent.mm.modelvoice.b qRZ;
        private p qSa;
        private volatile boolean qSb;
        public boolean qSc;
        private aj qSd;
        private fb qSe;
        private boolean qSf;
        private int qSg;
        private Map<String, String> qSh;

        private enum a {
            CHECK,
            UPLOAD,
            UPLOAD_MORE,
            GET,
            qSo,
            ERROR,
            CANCEL
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            fb fbVar = (fb) bVar;
            if (!(fbVar instanceof fb)) {
                w.f("MicroMsg.SubCoreSubapp", "mismatched event");
                return false;
            } else if (fbVar.fJx.fJA == 2) {
                a(a.CANCEL);
                this.qSh.clear();
                w.i("MicroMsg.SubCoreSubapp", "Have clear the cache of the translate voice results.");
                return true;
            } else if (fbVar.fJx.fJA == 1) {
                a(a.CANCEL);
                w.i("MicroMsg.SubCoreSubapp", "Have cancel translate voice action.");
                return true;
            } else if (fbVar.fJx.fJA != 0) {
                w.i("MicroMsg.SubCoreSubapp", "The opCode(%d) is out of range.", Integer.valueOf(this.qSe.fJx.fJA));
                return false;
            } else if (this.qSf) {
                w.w("MicroMsg.SubCoreSubapp", "The Event handler is busy.");
                return false;
            } else if (m.Ly() == null) {
                w.e("MicroMsg.SubCoreSubapp", "SubCoreVoice.getVoiceStg() == null" + bg.bJZ());
                return false;
            } else {
                this.qSe = fbVar;
                String str = this.qSe.fJx.fJz;
                String str2 = this.qSe.fJx.fyF;
                if (bg.mA(str) || bg.mA(str2)) {
                    w.e("MicroMsg.SubCoreSubapp", "The localId(%s) is null or fileName(%s) is null.", str, str2);
                    a(a.ERROR);
                    g.oUh.i(14220, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                    return false;
                }
                String str3 = (String) this.qSh.get(str2);
                if (bg.mA(str3)) {
                    bf Sb = m.Lz().Sb(str2);
                    a.qRT = Sb;
                    if (Sb == null || bg.mA(a.qRT.field_content)) {
                        this.qSa = m.Ly().mg(str2);
                        if (this.qSa == null) {
                            w.i("MicroMsg.SubCoreSubapp", "The VoiceInfo do not exist. (localId : %s, fileName : %s)", str, str2);
                            this.qSa = new p();
                            this.qSa.fyF = str2;
                            this.qSa.iam = System.currentTimeMillis() / 1000;
                            this.qSa.clientId = str2;
                            this.qSa.ian = System.currentTimeMillis() / 1000;
                            this.qSa.status = 1;
                            w.i("MicroMsg.SubCoreSubapp", "size : %d", Integer.valueOf(o.lx(str2)));
                            this.qSa.hrs = r0;
                        }
                        this.qRZ = q.lV(this.qSa.fyF);
                        this.qSf = true;
                        this.qSg = 20;
                        a(a.CHECK);
                        return true;
                    }
                    w.i("MicroMsg.SubCoreSubapp", "finish With DB localId:%s,fileName:%s", str, str2);
                    a(a.qRT.field_content, a.qSo);
                    return true;
                }
                w.i("MicroMsg.SubCoreSubapp", "finish With Cache localId:%s,fileName:%s", str, str2);
                a(str3, a.qSo);
                return true;
            }
        }

        public a() {
            this.qSb = false;
            this.qSc = false;
            this.qSh = new HashMap();
            this.usg = fb.class.getName().hashCode();
        }

        public final void a(a aVar) {
            switch (aVar) {
                case CHECK:
                    w.i("MicroMsg.SubCoreSubapp", "net check");
                    if (this.qSa.fTQ > 0) {
                        w.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", Long.valueOf(this.qSa.fTQ));
                        this.qRW = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.qSa.clientId, this.qSa.hrs, this.qRZ.getFormat(), this.qSa.fTQ, this.qSa.fyF);
                    } else {
                        w.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", Long.valueOf(this.qSa.fTQ));
                        this.qRW = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.qSa.clientId, this.qSa.hrs, this.qSa.fyF);
                    }
                    ap.vd().a(this.qRW, 0);
                    ap.vd().a(this.qRW.getType(), (e) this);
                    return;
                case UPLOAD:
                    w.i("MicroMsg.SubCoreSubapp", "net upload");
                    if (this.qRW == null) {
                        w.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
                        return;
                    }
                    this.qRX = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.qSa.clientId, this.qRW.qVM, this.qRZ.getFormat(), this.qSa.fyF);
                    ap.vd().a(this.qRX, 0);
                    ap.vd().a(this.qRX.getType(), (e) this);
                    return;
                case UPLOAD_MORE:
                    w.i("MicroMsg.SubCoreSubapp", "net upload more");
                    if (this.qRX == null) {
                        w.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
                        return;
                    }
                    this.qRX = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.qRX);
                    ap.vd().a(this.qRX, 0);
                    ap.vd().a(this.qRX.getType(), (e) this);
                    return;
                case GET:
                    if (this.qSb) {
                        w.i("MicroMsg.SubCoreSubapp", "pulling so pass");
                        return;
                    }
                    w.i("MicroMsg.SubCoreSubapp", "net get");
                    if (this.qRW == null) {
                        w.w("MicroMsg.SubCoreSubapp", "request get must after check!");
                        return;
                    }
                    this.qSb = true;
                    this.qRY = new b(this.qSa.clientId);
                    ap.vd().a(this.qRY, 0);
                    ap.vd().a(this.qRY.getType(), (e) this);
                    return;
                case qSo:
                    this.qSc = true;
                    return;
                case CANCEL:
                    ap.vd().c(this.qRW);
                    ap.vd().c(this.qRX);
                    ap.vd().c(this.qRY);
                    a(null, a.CANCEL);
                    return;
                case ERROR:
                    a(null, a.ERROR);
                    return;
                default:
                    return;
            }
        }

        private void a(String str, a aVar) {
            w.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", aVar);
            if (this.qSd != null) {
                this.qSd.KH();
            }
            ap.vd().b(546, (e) this);
            ap.vd().b(547, (e) this);
            ap.vd().b(548, (e) this);
            if (this.qSe != null) {
                if (!bg.mA(str)) {
                    this.qSh.put(this.qSe.fJx.fyF, str);
                    if ((a.qRT == null || bg.mA(a.qRT.field_content)) && this.qSe.fJx.fFr == 1) {
                        com.tencent.mm.storage.bg Lz = m.Lz();
                        w.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", this.qSe.fJx.fJz, this.qSe.fJx.fyF);
                        bf bfVar = new bf();
                        bfVar.field_msgId = Long.valueOf(this.qSe.fJx.fJz).longValue();
                        bfVar.Sa(this.qSe.fJx.fyF);
                        bfVar.field_content = str;
                        Lz.a(bfVar);
                        g.oUh.i(14220, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                    }
                } else if (aVar == a.qSo) {
                    w.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", this.qSe.fJx.fJz);
                    this.qSe.fJy.state = 2;
                }
                this.qSe.fJy.fHq = true;
                this.qSe.fJy.content = str;
                if (aVar == a.CANCEL) {
                    this.qSe.fJy.state = 1;
                } else if (aVar == a.ERROR) {
                    this.qSe.fJy.state = 2;
                }
                w.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", str);
                if (this.qSe.fJx.fJB != null) {
                    this.qSe.fJx.fJB.run();
                }
            }
            this.qRW = null;
            this.qRX = null;
            this.qRY = null;
            this.qSe = null;
            this.qSf = false;
            this.qSc = false;
            this.qSb = false;
            this.qSg = 20;
            a.qRT = null;
        }

        public final void a(int i, int i2, String str, k kVar) {
            w.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                int i3;
                switch (kVar.getType()) {
                    case 546:
                        if (this.qRW.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.qVK) {
                            w.i("MicroMsg.SubCoreSubapp", "check result: done");
                            a(a.qSo);
                            a(this.qRW.bnj() ? this.qRW.qVL.uji : null, a.qSo);
                            return;
                        } else if (this.qRW.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.qVJ) {
                            if (this.qRW.qVL != null) {
                                bg.mA(this.qRW.qVL.uji);
                            }
                            w.i("MicroMsg.SubCoreSubapp", "check result: processing");
                            a(a.GET);
                            return;
                        } else if (this.qRW.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.qVI) {
                            w.i("MicroMsg.SubCoreSubapp", "check result: not exist");
                            a(a.UPLOAD);
                            return;
                        } else if (this.qRW.qVN != null) {
                            i3 = this.qRW.qVN.tXl;
                            return;
                        } else {
                            return;
                        }
                    case 547:
                        if (this.qRX.bnl()) {
                            w.i("MicroMsg.SubCoreSubapp", "succeed upload");
                            a(a.GET);
                            return;
                        }
                        w.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", Integer.valueOf(this.qRX.qVM.tgK), Integer.valueOf(this.qRX.qVM.tgL));
                        a(a.UPLOAD_MORE);
                        return;
                    case 548:
                        i3 = this.qRY.qVP;
                        w.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", Integer.valueOf(i3));
                        this.qSb = false;
                        if (!this.qRY.isComplete() && this.qRY.bnj()) {
                            w.i("MicroMsg.SubCoreSubapp", "refreshResult result");
                            String str2 = this.qRY.qVL.uji;
                            if (this.qSe != null) {
                                this.qSe.fJy.fHq = false;
                                this.qSe.fJy.content = str2;
                                w.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", Boolean.valueOf(bg.mA(str2)));
                                if (this.qSe.fJx.fJB != null) {
                                    this.qSe.fJx.fJB.run();
                                }
                            }
                        } else if (!this.qRY.bnj()) {
                            w.d("MicroMsg.SubCoreSubapp", "result not valid");
                        }
                        if (this.qRY.isComplete()) {
                            w.i("MicroMsg.SubCoreSubapp", "succeed get");
                            String str3 = this.qRY.bnj() ? this.qRY.qVL.uji : null;
                            a(a.qSo);
                            a(str3, a.qSo);
                            return;
                        }
                        w.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", Integer.valueOf(i3));
                        if (!this.qSc) {
                            int i4 = this.qSg - 1;
                            this.qSg = i4;
                            if (i4 < 0) {
                                w.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", Integer.valueOf(20));
                                a(a.ERROR);
                                g.oUh.i(14220, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                                return;
                            }
                            if (this.qSd == null) {
                                this.qSd = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
                                    final /* synthetic */ a qSj;

                                    public final boolean oQ() {
                                        if (!this.qSj.qSc) {
                                            w.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", Integer.valueOf(i3));
                                            this.qSj.a(a.GET);
                                        }
                                        return false;
                                    }
                                }, false);
                            }
                            long j = (long) (i3 * 1000);
                            this.qSd.v(j, j);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            a(a.ERROR);
            g.oUh.i(14220, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
        }
    }

    public a() {
        w.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
        this.hoc = oI();
    }

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        w.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
        HashMap<Integer, com.tencent.mm.bj.g.c> hashMap = new HashMap();
        for (Entry entry : this.hoc.entrySet()) {
            if (((am) entry.getValue()).uh() != null) {
                hashMap.putAll(((am) entry.getValue()).uh());
            }
        }
        return hashMap;
    }

    public final void eD(int i) {
        w.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
        for (Entry value : this.hoc.entrySet()) {
            ((am) value.getValue()).eD(i);
        }
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
        for (Entry value : this.hoc.entrySet()) {
            ((am) value.getValue()).aM(z);
        }
        if (this.qRU == null) {
            this.qRU = new a();
        }
        com.tencent.mm.sdk.b.a.urY.b(this.qRU);
    }

    public final void aN(boolean z) {
        w.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
        for (Entry value : this.hoc.entrySet()) {
            ((am) value.getValue()).aN(z);
        }
    }

    public final void onAccountRelease() {
        w.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
        for (Entry value : this.hoc.entrySet()) {
            ((am) value.getValue()).onAccountRelease();
        }
        if (this.qRU != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.qRU);
        }
    }

    public final Map<String, am> oI() {
        w.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
        Map<String, am> hashMap = new HashMap();
        hashMap.put(d.class.getName(), new d());
        hashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
        hashMap.put(com.tencent.mm.plugin.subapp.a.c.class.getName(), new com.tencent.mm.plugin.subapp.a.c());
        f dVar = new com.tencent.mm.plugin.subapp.c.d();
        com.tencent.mm.u.ag.a.hlV = dVar;
        hashMap.put(com.tencent.mm.plugin.subapp.c.d.class.getName(), dVar);
        l cVar = new com.tencent.mm.plugin.subapp.jdbiz.c();
        hashMap.put(com.tencent.mm.plugin.subapp.jdbiz.c.class.getName(), cVar);
        aa.sBG = cVar;
        hashMap.put(com.tencent.mm.modelmulti.p.class.getName(), new com.tencent.mm.modelmulti.p());
        return hashMap;
    }

    public final am Hj(String str) {
        return (am) this.hoc.get(str);
    }

    public final void b(String str, am amVar) {
        this.hoc.put(str, amVar);
    }
}
