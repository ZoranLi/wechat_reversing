package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.i.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public final class l {
    public String filename;
    int hYf = 0;
    int hYg = 0;
    f hYh;
    public int hYi;
    int hYj;
    boolean hYl;
    int hYm = 0;
    private int hYn;
    public boolean hYo = false;
    boolean hYp = false;
    long hzq;
    int iyQ;
    String mediaId;
    HashMap<String, Integer> qvV = new HashMap();
    int qvX;
    public int qvY = 0;
    long qvZ;
    public long qwa;
    private long qwb;
    private int qwc;
    public i vTS;
    a vTT;

    private static class a {
        int hYv;
        int hYw;
        int qwf;
        int vTV;
    }

    public l(i iVar) {
        int i;
        this.vTS = iVar;
        reset();
        this.hYh = new f();
        this.vTT = new a();
        String value = g.sV().getValue("AndroidOnlineVideoArgs");
        if (!bg.mA(value)) {
            w.i("MicroMsg.OnlineVideoUIHelper", "online video config : " + value);
            String[] split = value.split(";");
            if (split != null && split.length >= 4) {
                this.vTT.hYv = bg.getInt(split[0], 5);
                this.vTT.hYw = bg.getInt(split[1], 1);
                this.vTT.qwf = bg.getInt(split[2], 75);
                this.vTT.vTV = bg.getInt(split[3], 1) * 1048576;
                i = 1;
                if (i == 0) {
                    this.vTT.hYv = 5;
                    this.vTT.hYw = 1;
                    this.vTT.qwf = 75;
                    this.vTT.vTV = 1048576;
                }
                w.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", Integer.valueOf(this.vTT.hYv), Integer.valueOf(this.vTT.hYw), Integer.valueOf(this.vTT.qwf), Integer.valueOf(this.vTT.vTV));
                this.hYn = this.vTT.hYv;
            }
        }
        boolean z = false;
        if (i == 0) {
            this.vTT.hYv = 5;
            this.vTT.hYw = 1;
            this.vTT.qwf = 75;
            this.vTT.vTV = 1048576;
        }
        w.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", Integer.valueOf(this.vTT.hYv), Integer.valueOf(this.vTT.hYw), Integer.valueOf(this.vTT.qwf), Integer.valueOf(this.vTT.vTV));
        this.hYn = this.vTT.hYv;
    }

    public final void reset() {
        String str = "";
        this.mediaId = str;
        this.filename = str;
        this.hYj = -1;
        this.qvX = 0;
        this.iyQ = 0;
        this.hYm = 0;
        this.hYi = 0;
        this.qvY = 0;
        this.hYg = 0;
        this.hYf = 0;
        this.hYl = false;
        this.hYo = false;
        this.hYp = false;
        this.qvV.clear();
        if (this.vTT != null) {
            this.hYn = this.vTT.hYv;
        }
        this.qvZ = 0;
        this.hzq = 0;
        this.qwc = 0;
        this.qwb = 0;
        this.qwa = 0;
    }

    public final void bXz() {
        w.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
        if (this.hYf == 3) {
            int i = 1;
        } else {
            boolean z = false;
        }
        this.hYf = 0;
        if (!bg.mA(this.mediaId)) {
            if (i != 0) {
                bXB();
            } else if (this.qvX >= this.vTT.qwf) {
                w.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", Integer.valueOf(this.qvX), Integer.valueOf(this.vTT.qwf));
                t.I(this.filename, 2);
                com.tencent.mm.plugin.report.service.g.oUh.a(354, 10, 1, false);
            }
            o.KW().b(this.mediaId, bXC());
            com.tencent.mm.plugin.report.service.g.oUh.a(354, 2, 1, false);
        }
    }

    public final boolean isStreaming() {
        return !bg.mA(this.mediaId) && (this.hYf == 1 || this.hYf == 3);
    }

    public final boolean GO(String str) {
        return bg.eB(str, this.mediaId);
    }

    final void bjx() {
        w.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", this.filename);
        af.v(new Runnable(this) {
            final /* synthetic */ l vTU;

            {
                this.vTU = r1;
            }

            public final void run() {
                if (this.vTU.vTS != null) {
                    this.vTU.vTS.as(this.vTU.filename, false);
                }
            }
        });
    }

    public final boolean am(int i, boolean z) {
        boolean z2;
        switch (this.hYf) {
            case 1:
                this.hYg = 2;
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                a(i, pInt, pInt2);
                if (!g(pInt.value, pInt2.value, true)) {
                    this.hYj = i;
                    this.hYl = true;
                    this.vTS.KG();
                    z2 = false;
                    break;
                }
                this.hYj = -1;
                this.hYl = false;
                this.hYm = pInt2.value;
                this.hYg = 3;
                break;
            case 3:
                break;
        }
        this.vTS.K(i, z);
        z2 = true;
        w.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", Integer.valueOf(i), Integer.valueOf(this.hYf), Integer.valueOf(this.hYg));
        com.tencent.mm.plugin.report.service.g.oUh.a(354, 4, 1, false);
        return z2;
    }

    public final boolean gL(int i) {
        int i2;
        boolean z = false;
        if (this.hYj != -1) {
            i2 = this.hYj;
        } else {
            i2 = i;
        }
        w.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hYm), Integer.valueOf(this.hYi), Integer.valueOf(this.hYf), Long.valueOf(this.qwa - this.hzq), Boolean.valueOf(this.hYo));
        switch (this.hYf) {
            case 1:
                boolean z2;
                if (gM(i2)) {
                    if (this.qvY == 0 && this.qwa == 0) {
                        this.qwa = bg.Nz();
                    }
                    if (this.hYo) {
                        l lVar;
                        int i3;
                        this.vTS.TK(this.filename);
                        if (this.hYl) {
                            if (this.qvY == 0 && this.qwa == 0) {
                                this.qwa = bg.Nz();
                            } else if (this.qwb > 0) {
                                this.qwc = (int) (((long) this.qwc) + bg.aA(this.qwb));
                            }
                            w.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", Integer.valueOf(this.qvY), Integer.valueOf(this.qwc));
                            if (this.hYj != -1) {
                                this.vTS.K(this.hYj, true);
                                this.hYj = -1;
                                z2 = false;
                                lVar = this;
                            } else if (this.vTS.bjo()) {
                                z2 = false;
                                lVar = this;
                            } else {
                                z2 = true;
                                lVar = this;
                            }
                            lVar.hYl = z2;
                            i3 = 3;
                            lVar = this;
                        } else {
                            if (this.hYg != 3) {
                                w.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", Integer.valueOf(this.hYg));
                                if (this.vTS.bjo()) {
                                    i3 = 3;
                                    lVar = this;
                                } else {
                                    i3 = this.hYg;
                                    lVar = this;
                                }
                            }
                            z2 = true;
                        }
                        lVar.hYg = i3;
                        z2 = true;
                    } else {
                        w.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", this.filename);
                        this.vTS.as(this.filename, true);
                        this.hYo = true;
                        z2 = true;
                    }
                } else {
                    this.hYl = true;
                    if (this.hYm > 0) {
                        w.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.qvY + " playStatus : " + this.hYg);
                        this.qwb = bg.Nz();
                        if (!(this.hYg == 2 || this.hYg == 4)) {
                            this.hYn += this.vTT.hYv;
                            this.hYn = Math.min(this.hYn, 60);
                            this.qvY++;
                            this.hYg = 4;
                        }
                        this.vTS.KG();
                    } else if (this.hYj == -1) {
                        this.hYg = 1;
                    } else {
                        this.hYg = 2;
                    }
                    z2 = false;
                }
                this.vTS.BI(i2);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (!a(i2, pInt, pInt2)) {
                    w.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
                } else if (g(pInt.value, pInt2.value, false)) {
                    this.hYm = Math.max(this.hYm, pInt2.value);
                    return true;
                }
                return z2;
            case 3:
                if (this.hYo) {
                    if (this.hYl) {
                        l lVar2;
                        if (this.hYj != -1) {
                            this.vTS.K(this.hYj, true);
                            this.hYj = -1;
                            lVar2 = this;
                        } else if (this.vTS.bjo()) {
                            lVar2 = this;
                        } else {
                            z = true;
                            lVar2 = this;
                        }
                        lVar2.hYl = z;
                    }
                    this.vTS.BI(i2);
                    return true;
                }
                this.vTS.as(this.filename, false);
                this.hYo = true;
                return true;
            default:
                return true;
        }
    }

    public final boolean gM(int i) {
        boolean isVideoDataAvailable;
        Throwable e;
        if (this.hYf == 3) {
            return true;
        }
        if (this.hYm - i <= 2 && this.hYm < this.hYi) {
            return false;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.hYh.a(i, i + 2, pInt, pInt2)) {
                isVideoDataAvailable = o.KW().isVideoDataAvailable(this.mediaId, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    try {
                        this.hYm = i;
                    } catch (Exception e2) {
                        e = e2;
                        w.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
                        w.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
                        return isVideoDataAvailable;
                    }
                }
            }
            isVideoDataAvailable = false;
        } catch (Throwable e3) {
            e = e3;
            isVideoDataAvailable = false;
            w.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
            w.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
            return isVideoDataAvailable;
        }
        return isVideoDataAvailable;
    }

    private boolean a(int i, PInt pInt, PInt pInt2) {
        pInt.value = Math.max(i, this.hYm);
        if (this.hYg == 1) {
            pInt.value = i;
            pInt2.value = pInt.value + this.hYn;
        }
        if (this.hYg == 2) {
            pInt.value = i - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = (pInt.value + this.hYn) + 8;
        }
        if (this.hYg == 3 || this.hYg == 4) {
            pInt.value = this.hYm;
            pInt2.value = ((this.hYn + i) + 2) + this.vTT.hYw;
        }
        if (pInt2.value >= this.hYi + 1) {
            pInt2.value = this.hYi + 1;
        }
        if (pInt2.value <= pInt.value) {
            pInt2.value = pInt.value + this.vTT.hYw;
            return false;
        }
        w.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.hYg), Integer.valueOf(this.hYm), Integer.valueOf(this.hYn));
        return true;
    }

    private boolean g(int i, int i2, boolean z) {
        boolean isVideoDataAvailable;
        String str;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.hYh.a(i, i2, pInt, pInt2)) {
                isVideoDataAvailable = o.KW().isVideoDataAvailable(this.mediaId, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    w.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
                } else if (!this.qvV.containsKey(this.mediaId + 0 + "_-1")) {
                    str = this.mediaId + pInt.value + "_" + pInt2.value;
                    w.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.hYp), Boolean.valueOf(z));
                    if (!this.qvV.containsKey(str) || (this.hYp && !z)) {
                        w.i("MicroMsg.OnlineVideoUIHelper", "already request video : " + str);
                    } else {
                        this.hYp = true;
                        o.KW();
                        com.tencent.mm.modelcdntran.f.e(this.mediaId, pInt.value, pInt2.value);
                        this.qvV.put(str, Integer.valueOf(i2));
                    }
                }
                return isVideoDataAvailable;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
            w.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
        }
        isVideoDataAvailable = false;
        if (!isVideoDataAvailable) {
            w.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
        } else if (this.qvV.containsKey(this.mediaId + 0 + "_-1")) {
            str = this.mediaId + pInt.value + "_" + pInt2.value;
            w.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.hYp), Boolean.valueOf(z));
            if (this.qvV.containsKey(str)) {
            }
            w.i("MicroMsg.OnlineVideoUIHelper", "already request video : " + str);
        }
        return isVideoDataAvailable;
    }

    public final void bXA() {
        String str = this.mediaId + 0 + "_-1";
        if (!this.qvV.containsKey(str)) {
            w.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", this.mediaId);
            o.KW();
            com.tencent.mm.modelcdntran.f.e(this.mediaId, 0, -1);
            this.qvV.put(str, Integer.valueOf(0));
            com.tencent.mm.plugin.report.service.g.oUh.a(354, 24, 1, false);
            w.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", Integer.valueOf(hashCode()), this.filename);
            com.tencent.mm.plugin.report.service.g.oUh.i(13836, Integer.valueOf(303), Long.valueOf(bg.Ny()), "");
        }
        this.hYg = 5;
    }

    final void bXB() {
        o.KV();
        if (q.lp(s.lv(this.filename))) {
            boolean z;
            w.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete");
            r lH = t.lH(this.filename);
            if (lH == null || lH.videoFormat == 2) {
                z = false;
            } else {
                lH.videoFormat = 2;
                lH.iao = bg.Ny();
                lH.ian = bg.Ny();
                lH.hzv = 16;
                lH.fRW = 268438530;
                z = o.KV().b(lH);
                w.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + z + " status: " + lH.status);
            }
            if (z) {
                com.tencent.mm.plugin.report.service.g.oUh.a(354, 134, 1, false);
            }
        }
    }

    final Object[] bXC() {
        int i = 0;
        Object[] objArr = new Object[7];
        i iVar = this.vTS;
        if (iVar.qvO < 0) {
            iVar.qvO = 0;
        }
        w.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", iVar.filename, Integer.valueOf(iVar.qvO));
        objArr[0] = Integer.valueOf(iVar.qvO);
        if (this.qwa <= 0) {
            this.qwa = bg.Nz();
        }
        int i2 = (int) (this.qwa - this.hzq);
        if (i2 <= 0) {
            i2 = 0;
        }
        objArr[1] = Integer.valueOf(i2);
        if (this.qvZ <= 0) {
            this.qvZ = bg.Nz();
        }
        i2 = (int) (this.qvZ - this.hzq);
        if (i2 <= 0) {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(this.qvY);
        if (this.qvY > 0) {
            if (this.qwc == 0) {
                this.qwc = (int) (((long) this.qwc) + bg.aA(this.qwb));
            }
            objArr[4] = Integer.valueOf(this.qwc / this.qvY);
        } else {
            objArr[4] = Integer.valueOf(0);
        }
        iVar = this.vTS;
        if (iVar.qvI <= 0 || iVar.qvH <= 0) {
            i2 = 0;
        } else {
            i2 = (int) (iVar.qvI - iVar.qvH);
        }
        if (i2 >= 0) {
            i = i2;
        }
        objArr[5] = Integer.valueOf(i);
        objArr[6] = Integer.valueOf(this.vTS.lKr);
        return objArr;
    }
}
