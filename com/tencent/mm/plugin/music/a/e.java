package com.tencent.mm.plugin.music.a;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.am.d;
import com.tencent.mm.plugin.music.a.e.a;
import com.tencent.mm.plugin.music.a.e.b;
import com.tencent.mm.plugin.music.a.e.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class e extends a {
    public b nSA;
    public com.tencent.mm.plugin.music.a.b.a nSB;
    boolean nSC;
    private boolean nSD = false;
    private boolean nSE = false;
    private boolean nSF = false;
    private boolean nSG = false;
    private boolean nSH = false;
    private boolean nSI = false;
    private boolean nSJ = false;
    private boolean nSK = false;
    private d nSL;
    public boolean nSM;
    public com.tencent.mm.plugin.music.a.b.a.b nSN = new com.tencent.mm.plugin.music.a.b.a.b(this) {
        final /* synthetic */ e nSQ;

        {
            this.nSQ = r1;
        }

        public final void pZ(final int i) {
            if (i == 1) {
                if (this.nSQ.nSB != null && !this.nSQ.nSM && this.nSQ.nSA != null) {
                    this.nSQ.nSA.BC(h.e(this.nSQ.nSB.fPd, this.nSQ.nSB.lFS));
                    e eVar = this.nSQ;
                    if (i.aNV().requestFocus()) {
                        w.i("MicroMsg.Music.MusicPlayer", "startPlay");
                        try {
                            if (eVar.nSA != null) {
                                eVar.nSA.play();
                            }
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "startPlay", new Object[0]);
                        }
                        eVar.nSM = true;
                        eVar.nSC = false;
                        return;
                    }
                    w.e("MicroMsg.Music.MusicPlayer", "request focus error");
                }
            } else if (i == -2 || i == 5) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 nSS;

                    public final void run() {
                        Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.eCD), 0).show();
                        this.nSS.nSQ.a(i.aNS().aNI(), i);
                    }
                });
            } else if (i == -1 || i == 6 || i == 4) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 nSS;

                    {
                        this.nSS = r1;
                    }

                    public final void run() {
                        Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.eCD), 1).show();
                    }
                });
                this.nSQ.a(i.aNS().aNI(), i);
            }
        }
    };
    public boolean nSO = false;

    public e() {
        aOb();
    }

    public final void b(com.tencent.mm.am.a aVar) {
        w.i("MicroMsg.Music.MusicPlayer", "init and start download");
        adL();
        g.d(aVar, false);
        w.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
        this.nSD = false;
        this.nSE = false;
        this.nSF = false;
        this.nSG = false;
        this.nSH = false;
        this.nSI = false;
        this.nSJ = false;
        this.nSK = false;
        a(aVar, false);
        if (aVar == null) {
            w.i("MicroMsg.Music.MusicPlayer", "music is null");
            return;
        }
        this.nSB = new com.tencent.mm.plugin.music.a.b.a(aVar);
        this.nSB.nTJ = this.nSN;
        this.nSB.start();
    }

    public final void a(com.tencent.mm.am.a aVar, boolean z) {
        if (this.nSA == null) {
            if (z || !com.tencent.mm.compatible.util.d.eq(15)) {
                w.i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
                this.nSA = new com.tencent.mm.plugin.music.a.e.d();
            } else {
                w.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
                this.nSA = new com.tencent.mm.plugin.music.a.e.e();
            }
            this.nSA.f(aVar);
            this.nSA.a(new h(this) {
                public long nSP;
                final /* synthetic */ e nSQ;

                {
                    this.nSQ = r1;
                }

                public final void c(com.tencent.mm.am.a aVar) {
                    w.i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
                    this.nSQ.l(aVar.HG());
                }

                public final void d(com.tencent.mm.am.a aVar) {
                    com.tencent.mm.am.a aNI = i.aNS().aNI();
                    if (aNI != null && aNI.a(aVar) && this.nSQ.nSA != null && this.nSQ.nSA.isPlaying()) {
                        int aOd = this.nSQ.nSA.aOd();
                        int duration = this.nSQ.nSA.getDuration();
                        if (aOd > 0 && duration > 0) {
                            float f = ((float) aOd) / ((float) duration);
                            if (this.nSQ.nSB != null) {
                                float f2;
                                com.tencent.mm.plugin.music.a.b.a aVar2 = this.nSQ.nSB;
                                aVar2.nTH = f;
                                boolean isNetworkConnected = am.isNetworkConnected(ab.getContext());
                                if (aVar2.isStop && isNetworkConnected) {
                                    if (aVar2.lFS) {
                                        if (aVar2.fPd.field_songWifiFileLength != 0) {
                                            f2 = ((float) aVar2.fPd.field_wifiDownloadedLength) / ((float) aVar2.fPd.field_songWifiFileLength);
                                        }
                                    } else if (aVar2.fPd.field_songFileLength != 0) {
                                        f2 = ((float) aVar2.fPd.field_downloadedLength) / ((float) aVar2.fPd.field_songFileLength);
                                    }
                                    if (f2 < 1.0f && f2 - f <= 0.15f && isNetworkConnected) {
                                        w.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(isNetworkConnected)});
                                        aVar2.start();
                                    }
                                }
                                if (this.nSQ.nSB != null && this.nSQ.nSB.isStop) {
                                    Object obj;
                                    com.tencent.mm.plugin.music.a.b.a aVar3 = this.nSQ.nSB;
                                    if (aVar3.lFS) {
                                        if (aVar3.fPd.field_songWifiFileLength != 0) {
                                            f2 = ((float) aVar3.fPd.field_wifiDownloadedLength) / ((float) aVar3.fPd.field_songWifiFileLength);
                                        }
                                        obj = null;
                                        if (obj == null) {
                                            w.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                                            this.nSQ.adL();
                                        }
                                    } else {
                                        if (aVar3.fPd.field_songFileLength != 0) {
                                            f2 = ((float) aVar3.fPd.field_downloadedLength) / ((float) aVar3.fPd.field_songFileLength);
                                        }
                                        obj = null;
                                        if (obj == null) {
                                            w.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                                            this.nSQ.adL();
                                        }
                                    }
                                    if (f2 >= 1.0f) {
                                        obj = 1;
                                    } else {
                                        if (f2 - f > 0.05f) {
                                            obj = 1;
                                        }
                                        obj = null;
                                    }
                                    if (obj == null) {
                                        w.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                                        this.nSQ.adL();
                                    }
                                }
                            }
                            if (this.nSQ.nTS != null) {
                                this.nSQ.nTS.cx(aOd, duration);
                            }
                        }
                    }
                }

                public final void b(com.tencent.mm.am.a aVar, boolean z) {
                    w.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
                    com.tencent.mm.am.a aNI = i.aNS().aNI();
                    if (aNI != null) {
                        if (aNI.a(aVar)) {
                            this.nSQ.adL();
                        }
                        anf HG = aVar.HG();
                        this.nSQ.o(HG);
                        if (z) {
                            this.nSQ.q(HG);
                        }
                    }
                }

                public final void c(com.tencent.mm.am.a aVar, boolean z) {
                    com.tencent.mm.am.a aNI = i.aNS().aNI();
                    if (aNI != null) {
                        w.i("MicroMsg.Music.MusicPlayer", "onError, needRetry:%b", new Object[]{Boolean.valueOf(z)});
                        if (z) {
                            this.nSQ.a(aVar, 20);
                        } else {
                            this.nSQ.a(aVar, 21);
                        }
                        anf HG = aVar.HG();
                        if (aNI.a(aVar)) {
                            w.i("MicroMsg.Music.MusicPlayer", "stop");
                            this.nSQ.adL();
                            if (z) {
                                w.i("MicroMsg.Music.MusicPlayer", "retry system media player again");
                                this.nSQ.a(aNI, true);
                                this.nSQ.nSB = new com.tencent.mm.plugin.music.a.b.a(aNI);
                                this.nSQ.nSB.nTJ = this.nSQ.nSN;
                                this.nSQ.nSB.start();
                                return;
                            }
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 nSR;

                                {
                                    this.nSR = r1;
                                }

                                public final void run() {
                                    if (System.currentTimeMillis() - this.nSR.nSP > 10000) {
                                        this.nSR.nSP = System.currentTimeMillis();
                                        Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.eCB), 0).show();
                                    }
                                }
                            });
                            this.nSQ.o(HG);
                            return;
                        }
                        w.i("MicroMsg.Music.MusicPlayer", "send stop event");
                        this.nSQ.o(HG);
                    }
                }
            });
        }
    }

    public final void a(com.tencent.mm.am.a aVar, int i) {
        if (aVar == null) {
            w.e("MicroMsg.Music.MusicPlayer", "currentMusic is null, don't idKeyReportMusicError");
            return;
        }
        w.i("MicroMsg.Music.MusicPlayer", "idKeyReportMusicError, action:%d", new Object[]{Integer.valueOf(i)});
        IDKey iDKey = new IDKey();
        iDKey.SetID(558);
        iDKey.SetKey(3);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(558);
        int i2 = aVar.field_musicType;
        w.i("MicroMsg.PlayerErrorHandler", "getMusicPlayerErrIdKeyByMusicType, musicType:" + i2);
        switch (i2) {
            case 0:
                i2 = 60;
                break;
            case 1:
                i2 = 61;
                break;
            case 4:
                i2 = 62;
                break;
            case 5:
                i2 = 63;
                break;
            case 6:
                i2 = 64;
                break;
            case 7:
                i2 = 5;
                break;
            case 8:
                i2 = 65;
                break;
            case 9:
                i2 = 66;
                break;
            default:
                i2 = 6;
                break;
        }
        iDKey2.SetKey(i2);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(558);
        if (i == -1) {
            iDKey3.SetKey(12);
        } else if (i == 6) {
            iDKey3.SetKey(46);
        } else if (i == -2) {
            iDKey3.SetKey(13);
        } else if (i == 5) {
            iDKey3.SetKey(16);
        } else if (i == 4) {
            iDKey3.SetKey(14);
        } else if (i == 20) {
            iDKey3.SetKey(11);
        } else if (i == 21) {
            iDKey3.SetKey(47);
        }
        iDKey3.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        w.i("MicroMsg.Music.MusicPlayer", "hasStatForHttpErr:%b, hasStatForUrlErr:%b, hasStatForNetworkErr:%b, hasStatForHttpRangeErr:%b, hasStatDownloadExceptionErr:%b", new Object[]{Boolean.valueOf(this.nSD), Boolean.valueOf(this.nSF), Boolean.valueOf(this.nSH), Boolean.valueOf(this.nSE), Boolean.valueOf(this.nSG)});
        if (i == -1 && !this.nSD) {
            this.nSD = true;
            g.oUh.b(arrayList, true);
        }
        if (i == 6 && !this.nSE) {
            this.nSE = true;
            g.oUh.b(arrayList, true);
        }
        if (i == -2 && !this.nSF) {
            this.nSF = true;
            g.oUh.b(arrayList, true);
        }
        if (i == 5 && !this.nSG) {
            this.nSG = true;
            g.oUh.b(arrayList, true);
        }
        if (i == 4 && !this.nSH) {
            this.nSH = true;
            g.oUh.b(arrayList, true);
        }
        if (i == 20 && !this.nSI) {
            this.nSI = true;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(iDKey3);
            g.oUh.b(arrayList2, true);
        }
        if (i == 21 && !this.nSJ && this.nSI) {
            this.nSJ = true;
            g.oUh.b(arrayList, true);
        }
    }

    public final void pause() {
        this.nSO = false;
        w.i("MicroMsg.Music.MusicPlayer", "pause");
        try {
            if (this.nSA != null && this.nSA.isPlaying()) {
                this.nSA.pause();
                this.nSC = true;
                n(i.aNS().aNJ());
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "pause", new Object[0]);
        }
    }

    public final void aNC() {
        w.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
        pause();
        i.aNV().aNB();
    }

    public final boolean aND() {
        return this.nSM && this.nSO;
    }

    public final void aNE() {
        this.nSO = true;
        w.i("MicroMsg.Music.MusicPlayer", "passivePause");
        try {
            if (this.nSA != null && this.nSA.isPlaying()) {
                this.nSA.pause();
                n(i.aNS().aNJ());
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "passivePause", new Object[0]);
        }
    }

    public final void resume() {
        try {
            if (this.nSA == null || this.nSA.isPlaying()) {
                w.i("MicroMsg.Music.MusicPlayer", "music is playing");
                return;
            }
            w.i("MicroMsg.Music.MusicPlayer", "resume");
            if (i.aNV().requestFocus()) {
                this.nSA.play();
                m(i.aNS().aNJ());
                return;
            }
            w.e("MicroMsg.Music.MusicPlayer", "request focus error");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "resume", new Object[0]);
        }
    }

    public final boolean HJ() {
        boolean z = false;
        if (this.nSA != null) {
            try {
                z = this.nSA.isPlaying();
            } catch (Throwable th) {
            }
        }
        return z;
    }

    public final boolean HK() {
        return this.nSM;
    }

    public final void adL() {
        w.i("MicroMsg.Music.MusicPlayer", "stopPlay");
        if (this.nSA != null && (this.nSA instanceof com.tencent.mm.plugin.music.a.e.e)) {
            String aOe = this.nSA.aOe();
            w.i("MicroMsg.Music.MusicPlayer", "idKeyReportMusicMimeType mineType:%s, hasStatForMimeType:%b", new Object[]{aOe, Boolean.valueOf(this.nSK)});
            if (!(TextUtils.isEmpty(aOe) || this.nSK)) {
                w.i("MicroMsg.Music.MusicPlayer", "idKeyReportMusicMimeType OK");
                this.nSK = true;
                IDKey iDKey = new IDKey();
                iDKey.SetID(558);
                int i = "audio/3gpp".equalsIgnoreCase(aOe) ? 70 : "audio/amr-wb".equalsIgnoreCase(aOe) ? 71 : ("audio/mpeg".equalsIgnoreCase(aOe) || aOe.equalsIgnoreCase("audio/mp3")) ? 72 : ("audio/mp4a-latm".equalsIgnoreCase(aOe) || aOe.startsWith("audio/mp4")) ? 73 : "audio/qcelp".equalsIgnoreCase(aOe) ? 74 : "audio/vorbis".equalsIgnoreCase(aOe) ? 75 : "audio/opus".equalsIgnoreCase(aOe) ? 76 : "audio/g711-alaw".equalsIgnoreCase(aOe) ? 77 : "audio/g711-mlaw".equalsIgnoreCase(aOe) ? 78 : "audio/raw".equalsIgnoreCase(aOe) ? 79 : "audio/flac".equalsIgnoreCase(aOe) ? 80 : "audio/gsm".equalsIgnoreCase(aOe) ? 81 : "audio/ac3".equalsIgnoreCase(aOe) ? 82 : "audio/eac3".equalsIgnoreCase(aOe) ? 83 : "audio/x-ms-wma".equalsIgnoreCase(aOe) ? 84 : "audio/x-wav".equalsIgnoreCase(aOe) ? 85 : ("audio/x-ape".equalsIgnoreCase(aOe) || "application/x-ape".equalsIgnoreCase(aOe)) ? 86 : 87;
                iDKey.SetKey(i);
                iDKey.SetValue(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDKey);
                g.oUh.b(arrayList, true);
                if (i.aNS().aNI() != null) {
                    int BD = com.tencent.mm.plugin.music.a.e.g.BD(aOe);
                    g.oUh.i(14486, new Object[]{Integer.valueOf(0), Integer.valueOf(r0.field_musicType), Integer.valueOf(BD), aOe});
                }
            }
        }
        try {
            if (this.nSB != null) {
                this.nSB.isStop = true;
                this.nSB = null;
            }
            if (this.nSA != null) {
                this.nSA.stop();
                this.nSA = null;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "stopPlay", new Object[0]);
        }
        i.aNV().aNB();
        this.nSM = false;
        this.nSO = false;
    }

    public final int getDuration() {
        if (this.nSA != null) {
            return this.nSA.getDuration();
        }
        return -1;
    }

    private int aNF() {
        if (this.nSB == null) {
            return 0;
        }
        int i;
        com.tencent.mm.plugin.music.a.b.a aVar = this.nSB;
        if (aVar.lFS) {
            w.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[]{Long.valueOf(aVar.fPd.field_songWifiFileLength), Long.valueOf(aVar.fPd.field_wifiDownloadedLength)});
            i = aVar.fPd.field_songWifiFileLength != 0 ? (int) ((aVar.fPd.field_wifiDownloadedLength * 100) / aVar.fPd.field_songWifiFileLength) : 0;
        } else {
            w.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[]{Long.valueOf(aVar.fPd.field_songFileLength), Long.valueOf(aVar.fPd.field_downloadedLength)});
            i = aVar.fPd.field_songFileLength != 0 ? (int) ((aVar.fPd.field_downloadedLength * 100) / aVar.fPd.field_songFileLength) : 0;
        }
        if (i > 0) {
            return i;
        }
        return 0;
    }

    public final boolean gi(int i) {
        w.i("MicroMsg.Music.MusicPlayer", "seekToMusic pos:%d", new Object[]{Integer.valueOf(i)});
        try {
            int duration = getDuration();
            int aNF = aNF();
            if (duration < 0 || i > duration) {
                w.e("MicroMsg.Music.MusicPlayer", "duration or position is illegal, stop");
                adL();
                return false;
            }
            duration = (int) ((((double) aNF) / 100.0d) * ((double) duration));
            if (aNF != 100 && i > duration) {
                i = duration - 2000;
                w.i("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", new Object[]{Integer.valueOf(i)});
            }
            if (this.nSA != null && i > 0) {
                this.nSA.seek((long) i);
                p(i.aNS().aNJ());
                return true;
            }
            return false;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "seekTo", new Object[0]);
        }
    }

    public final d aNG() {
        int i;
        int duration = getDuration();
        int aOd = this.nSA != null ? this.nSA.aOd() : -1;
        if (HJ()) {
            i = 1;
        } else {
            if (this.nSM && (this.nSC || this.nTR)) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i != 0) {
                i = 0;
            } else {
                i = 2;
            }
        }
        w.i("MicroMsg.Music.MusicPlayer", "get music status = %d", new Object[]{Integer.valueOf(i)});
        int aNF = aNF();
        if (duration <= 0) {
            aNF = 0;
        }
        if (this.nSL != null) {
            this.nSL.f(duration, aOd, i, aNF);
        } else {
            this.nSL = new d(duration, aOd, i, aNF);
        }
        this.nSL.fPe = false;
        return this.nSL;
    }

    public final boolean aNH() {
        return false;
    }
}
