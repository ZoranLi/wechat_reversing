package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import com.tencent.mm.R;
import com.tencent.mm.bd.b;
import com.tencent.mm.e.a.bq;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class e extends c<bq> implements com.tencent.mm.y.e {
    private static final String kAm = (com.tencent.mm.compatible.util.e.hgu + "wallet/voice/");
    private static final b kAn = b.NG("元");
    public com.tencent.mm.c.a.a fyE;
    public MediaPlayer kAo;
    public ConcurrentLinkedQueue<a> kAp;
    public boolean kAq;
    private long kAr;

    private class a {
        int fKw;
        String fyF;
        final /* synthetic */ e kAs;
        int kAv;

        public a(e eVar) {
            this.kAs = eVar;
        }
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        bq bqVar = (bq) bVar;
        if (bqVar.fFc.fFf.equals("wx_f2f")) {
            com.tencent.mm.plugin.collect.a.a.ajY();
            w.i("MicroMsg.F2fRcvVoiceListener", "on recv, fee: %s, voice open: %B", new Object[]{Integer.valueOf(bqVar.fFc.bPo), Boolean.valueOf(com.tencent.mm.plugin.collect.a.a.aka())});
            if (com.tencent.mm.plugin.collect.a.a.aka()) {
                ap.vd().a(new g(bqVar.fFc.bPo, kAn, bqVar.fFc.fFe), 0);
            }
        } else if (bqVar.fFc.fFf.equals("wx_md")) {
            ap.vd().a(new k(bqVar.fFc.bPo, kAn, bqVar.fFc.fFe), 0);
        } else {
            w.w("MicroMsg.F2fRcvVoiceListener", "unknown type: %s", new Object[]{bqVar.fFc.fFf});
        }
        return false;
    }

    public e() {
        this.kAq = false;
        this.usg = bq.class.getName().hashCode();
    }

    private static boolean m(String str, byte[] bArr) {
        ap.yY();
        if (!com.tencent.mm.u.c.isSDCardAvailable()) {
            w.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
            return false;
        } else if (FileOp.k(str, bArr) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean akd() {
        w.i("MicroMsg.F2fRcvVoiceListener", "delete files");
        return com.tencent.mm.a.e.aP(kAm);
    }

    public final synchronized void ake() {
        int i = 0;
        synchronized (this) {
            if (System.currentTimeMillis() - this.kAr > 10000) {
                w.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", new Object[]{Long.valueOf(this.kAr)});
                this.kAq = false;
            }
            if (this.kAq) {
                w.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
            } else {
                this.kAr = System.currentTimeMillis();
                final a aVar = (a) this.kAp.poll();
                if (aVar != null) {
                    int i2 = R.l.dWY;
                    if (aVar.kAv == 2) {
                        i2 = R.l.eAI;
                    }
                    if (bg.mA(aVar.fyF)) {
                        aq.a(ab.getContext(), i2, new com.tencent.mm.sdk.platformtools.aq.a(this) {
                            final /* synthetic */ e kAs;

                            {
                                this.kAs = r1;
                            }

                            public final void oW() {
                                w.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
                                this.kAs.kAq = false;
                            }
                        });
                        g.oUh.a(699, 2, 1, false);
                    } else {
                        switch (aVar.fKw) {
                            case 0:
                            case 1:
                            case 2:
                                break;
                            case 3:
                                i = 1;
                                break;
                            case 4:
                                i = 2;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                        this.kAq = true;
                        String string = ab.getContext().getString(i2);
                        w.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d, path: %s", new Object[]{Integer.valueOf(r5), string});
                        this.kAo = aq.a(ab.getContext(), i2, aq.b.uuP, false, new com.tencent.mm.sdk.platformtools.aq.a(this) {
                            final /* synthetic */ e kAs;

                            public final void oW() {
                                w.d("MicroMsg.F2fRcvVoiceListener", "start play money");
                                if (this.kAs.kAo == null || !this.kAs.kAq || this.kAs.fyE.isPlaying()) {
                                    w.i("MicroMsg.F2fRcvVoiceListener", "has played");
                                    return;
                                }
                                this.kAs.fyE.a(aVar.fyF, true, true, i);
                                this.kAs.kAo = null;
                            }
                        });
                        w.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d, path: %s, dur: %s", new Object[]{Integer.valueOf(r5), string, Integer.valueOf(this.kAo.getDuration())});
                        af.f(new Runnable(this) {
                            final /* synthetic */ e kAs;

                            public final void run() {
                                if (this.kAs.kAo != null && this.kAs.kAq && !this.kAs.fyE.isPlaying()) {
                                    w.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
                                    this.kAs.fyE.a(aVar.fyF, true, true, i);
                                    this.kAs.kAo = null;
                                    g.oUh.a(699, 1, 1, false);
                                }
                            }
                        }, (long) (r3 + 1000));
                    }
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        File file;
        String str2;
        a aVar;
        if (kVar instanceof g) {
            g gVar = (g) kVar;
            a aVar2;
            if (i != 0 || i2 != 0) {
                w.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[]{gVar});
                aVar2 = new a(this);
                aVar2.kAv = 1;
                this.kAp.add(aVar2);
                ake();
            } else if (gVar.kAz.kAC == 0) {
                file = new File(kAm);
                if (file.exists() || file.mkdirs()) {
                    str2 = kAm + UUID.randomUUID().toString() + ".tmp";
                    w.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[]{str2});
                    if (m(str2, gVar.kAz.tpw.sYA)) {
                        aVar = new a(this);
                        aVar.fyF = str2;
                        aVar.fKw = gVar.kAz.tpv;
                        aVar.kAv = 1;
                        this.kAp.add(aVar);
                        ake();
                        return;
                    }
                    w.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
                    return;
                }
                w.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            } else if (gVar.kAz.kAC <= 100) {
                w.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
                aVar2 = new a(this);
                aVar2.kAv = 1;
                this.kAp.add(aVar2);
                ake();
            } else {
                w.w("MicroMsg.F2fRcvVoiceListener", "retcode > 100, don't play");
            }
        } else if (kVar instanceof k) {
            k kVar2 = (k) kVar;
            if (i != 0 || i2 != 0) {
                w.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[]{kVar2});
            } else if (kVar2.kAS.kAC == 0) {
                file = new File(kAm);
                if (file.exists() || file.mkdirs()) {
                    str2 = kAm + UUID.randomUUID().toString() + ".tmp";
                    w.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[]{str2});
                    if (m(str2, kVar2.kAS.tpw.sYA)) {
                        aVar = new a(this);
                        aVar.fyF = str2;
                        aVar.fKw = kVar2.kAS.tpv;
                        aVar.kAv = 2;
                        this.kAp.add(aVar);
                        ake();
                        return;
                    }
                    w.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
                    return;
                }
                w.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            }
        }
    }
}
