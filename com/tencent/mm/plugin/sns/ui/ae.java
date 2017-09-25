package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.i.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.AnonymousClass5;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public final class ae {
    String fGN;
    alh fVV;
    int hFf;
    String hYc;
    public String hYd;
    int hYf = 0;
    int hYg = 0;
    f hYh;
    int hYi;
    int hYj;
    boolean hYl;
    int hYm = 0;
    private int hYn;
    public boolean hYo = false;
    boolean hYp = false;
    long hzq;
    int piG;
    int progress;
    HashMap<String, Integer> qvV = null;
    public a qvW;
    int qvX;
    private int qvY = 0;
    long qvZ;
    private long qwa;
    private long qwb;
    private int qwc;
    private b qwd;

    public interface a {
        void KG();

        void as(String str, boolean z);

        boolean bjo();

        int bjr();

        int bjs();

        int bjt();

        void pu(int i);
    }

    private static class b {
        int hYv;
        int hYw;
        int qwf;
    }

    public ae(a aVar) {
        this.qvW = aVar;
        this.hYh = new f();
        this.qvV = new HashMap();
        this.qwd = new b();
        this.qwd.hYv = g.sV().getInt("SnsVideoPreloadSec", 5);
        this.qwd.hYw = g.sV().getInt("SnsVideoDownloadSec", 1);
        this.qwd.qwf = g.sV().getInt("SnsVideoFullDownloadPercent", 101);
        w.i("MicroMsg.OnlineVideoViewHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[]{Integer.valueOf(this.qwd.hYv), Integer.valueOf(this.qwd.hYw), Integer.valueOf(this.qwd.qwf)});
        reset();
    }

    public final void clear() {
        w.i("MicroMsg.OnlineVideoViewHelper", "clear");
        reset();
        this.qvW = null;
        this.hYh = null;
    }

    private void reset() {
        this.hYc = "";
        this.hYj = -1;
        this.hYm = 0;
        this.hYi = 0;
        this.qvY = 0;
        this.hYg = 0;
        this.hYf = 0;
        this.hYl = false;
        this.hYo = false;
        this.hYp = false;
        this.qvV.clear();
        this.fVV = null;
        this.hFf = 0;
        this.fGN = null;
        if (this.qwd != null) {
            this.hYn = this.qwd.hYv;
        }
        this.qvZ = 0;
        this.hzq = 0;
        this.qwc = 0;
        this.qwb = 0;
        this.qwa = 0;
    }

    public final boolean bjw() {
        if (!bg.mA(this.hYc)) {
            w.i("MicroMsg.OnlineVideoViewHelper", "stop online download video %s isFinish %b percent %d", new Object[]{this.hYc, Boolean.valueOf(this.hYf == 3), Integer.valueOf(this.qvX)});
            aq beJ = com.tencent.mm.plugin.sns.model.ae.beJ();
            String str = this.hYc;
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(this.qvW.bjr());
            if (this.qwa <= 0) {
                this.qwa = bg.Nz();
            }
            int i = (int) (this.qwa - this.hzq);
            if (i <= 0) {
                i = 0;
            }
            objArr[1] = Integer.valueOf(i);
            if (this.qvZ <= 0) {
                this.qvZ = bg.Nz();
            }
            i = (int) (this.qvZ - this.hzq);
            if (i <= 0) {
                i = 0;
            }
            objArr[2] = Integer.valueOf(i);
            objArr[3] = Integer.valueOf(this.qvY);
            if (this.qvY > 0) {
                if (this.qwc == 0) {
                    this.qwc = (int) (((long) this.qwc) + bg.aA(this.qwb));
                }
                objArr[4] = Integer.valueOf(this.qwc / this.qvY);
            } else {
                objArr[4] = Integer.valueOf(0);
            }
            objArr[5] = Integer.valueOf(this.qvW.bjt());
            objArr[6] = Integer.valueOf(this.qvW.bjs());
            if (!bg.mA(str)) {
                h.vJ();
                h.vL().D(new AnonymousClass5(beJ, str, objArr));
            }
            if (this.qvX >= this.qwd.qwf && !r0) {
                com.tencent.mm.plugin.sns.model.ae.beJ().a(this.fVV, this.hFf, this.fGN, false, false, 36);
            }
            com.tencent.mm.plugin.report.service.g.oUh.a(354, 203, 1, false);
        }
        return true;
    }

    public final boolean GO(String str) {
        return bg.eB(this.hYc, str);
    }

    public final boolean gL(int i) {
        int i2;
        boolean z = false;
        if (this.hYj != -1) {
            i2 = this.hYj;
        } else {
            i2 = i;
        }
        w.i("MicroMsg.OnlineVideoViewHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hYm), Integer.valueOf(this.hYi), Integer.valueOf(this.hYg), Integer.valueOf(this.hYf), this.hYc, Long.valueOf(this.qwa - this.hzq), Boolean.valueOf(this.hYo)});
        switch (this.hYf) {
            case 1:
                boolean z2;
                boolean z3;
                if (gM(i2)) {
                    bjy();
                    if (!this.hYo) {
                        w.i("MicroMsg.OnlineVideoViewHelper", "prepare cdnMediaId [%s]", new Object[]{this.hYc});
                        if (this.hYg == 5) {
                            this.hYg = 1;
                        }
                        this.qvW.as(this.hYd, true);
                        this.hYo = true;
                        z2 = true;
                    } else if (this.hYl) {
                        if (this.qvY == 0 && this.qwa == 0) {
                            bjy();
                        } else if (this.qwb > 0) {
                            this.qwc = (int) (((long) this.qwc) + bg.aA(this.qwb));
                        }
                        w.i("MicroMsg.OnlineVideoViewHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", new Object[]{Integer.valueOf(this.qvY), Integer.valueOf(this.qwc), this.hYc});
                        this.hYg = 3;
                        if (this.hYj != -1) {
                            this.qvW.pu(this.hYj);
                            this.hYj = -1;
                            this.hYl = false;
                            z2 = true;
                        } else {
                            this.hYl = !this.qvW.bjo();
                            z2 = true;
                        }
                    } else {
                        if (this.hYg != 3) {
                            w.i("MicroMsg.OnlineVideoViewHelper", "start to play video playStatus[%d]", new Object[]{Integer.valueOf(this.hYg)});
                            this.hYg = this.qvW.bjo() ? 3 : this.hYg;
                        }
                        z2 = true;
                    }
                } else {
                    this.hYl = true;
                    if (this.hYm > 0) {
                        w.i("MicroMsg.OnlineVideoViewHelper", "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", new Object[]{this.hYc, Integer.valueOf(this.qvY), Integer.valueOf(this.hYg)});
                        this.qwb = bg.Nz();
                        if (!(this.hYg == 2 || this.hYg == 4)) {
                            this.hYn += this.qwd.hYv;
                            this.hYn = Math.min(this.hYn, 60);
                            this.qvY++;
                            this.hYg = 4;
                        }
                        this.qvW.KG();
                    } else if (this.hYj == -1) {
                        this.hYg = 1;
                    } else {
                        this.hYg = 2;
                    }
                    z2 = false;
                }
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                pInt.value = Math.max(i2, this.hYm);
                if (this.hYg == 1) {
                    pInt.value = i2;
                    pInt2.value = pInt.value + this.hYn;
                }
                if (this.hYg == 2) {
                    pInt.value = i2 - 8;
                    if (pInt.value < 0) {
                        pInt.value = 0;
                    }
                    pInt2.value = (pInt.value + this.hYn) + 8;
                }
                if (this.hYg == 3 || this.hYg == 4) {
                    pInt.value = this.hYm;
                    pInt2.value = ((this.hYn + i2) + 1) + this.qwd.hYw;
                }
                if (pInt2.value >= this.hYi + 1) {
                    pInt2.value = this.hYi + 1;
                }
                if (pInt2.value < pInt.value) {
                    pInt2.value = pInt.value + this.qwd.hYw;
                    z3 = false;
                } else {
                    w.i("MicroMsg.OnlineVideoViewHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i2), Integer.valueOf(this.hYg), Integer.valueOf(this.hYm), Integer.valueOf(this.hYn)});
                    z3 = true;
                }
                if (!z3) {
                    w.d("MicroMsg.OnlineVideoViewHelper", "can not calc download.");
                    o.KW();
                    com.tencent.mm.modelcdntran.f.e(this.hYc, 0, -1);
                } else if (cZ(pInt.value, pInt2.value)) {
                    this.hYm = Math.max(this.hYm, pInt2.value);
                    return true;
                }
                return z2;
            case 2:
                w.w("MicroMsg.OnlineVideoViewHelper", "download error.");
                return true;
            case 3:
                if (this.hYo) {
                    if (this.hYl) {
                        ae aeVar;
                        if (this.hYj != -1) {
                            this.qvW.pu(this.hYj);
                            this.hYj = -1;
                            aeVar = this;
                        } else if (this.qvW.bjo()) {
                            aeVar = this;
                        } else {
                            z = true;
                            aeVar = this;
                        }
                        aeVar.hYl = z;
                    }
                    this.hYg = 3;
                    return true;
                }
                if (this.hYg == 5) {
                    this.hYg = 1;
                }
                this.qvW.as(this.hYd, false);
                this.hYo = true;
                return true;
            default:
                w.w("MicroMsg.OnlineVideoViewHelper", "check time default.");
                return true;
        }
    }

    private boolean gM(int i) {
        if (this.hYf == 3) {
            return true;
        }
        if (this.hYm - i <= 1 && this.hYm < this.hYi) {
            return false;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (!this.hYh.a(i, i + 1, pInt, pInt2)) {
                return false;
            }
            boolean isVideoDataAvailable = o.KW().isVideoDataAvailable(this.hYc, pInt.value, pInt2.value);
            if (isVideoDataAvailable) {
                return isVideoDataAvailable;
            }
            this.hYm = i;
            return isVideoDataAvailable;
        } catch (Exception e) {
            w.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
            return false;
        }
    }

    private boolean cZ(int i, int i2) {
        boolean isVideoDataAvailable;
        String str;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.hYh.a(i, i2, pInt, pInt2)) {
                pInt2.value += 81920;
                isVideoDataAvailable = o.KW().isVideoDataAvailable(this.hYc, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    w.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
                } else if (!this.qvV.containsKey(this.hYc + 0 + "_-1")) {
                    str = this.hYc + pInt.value + "_" + pInt2.value;
                    w.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.hYp), Boolean.valueOf(false)});
                    if (!this.qvV.containsKey(str) || this.hYp) {
                        w.i("MicroMsg.OnlineVideoViewHelper", "already request video : " + str);
                    } else {
                        this.hYp = true;
                        o.KW();
                        com.tencent.mm.modelcdntran.f.e(this.hYc, pInt.value, pInt2.value);
                        this.qvV.put(str, Integer.valueOf(i2));
                    }
                }
                return isVideoDataAvailable;
            }
        } catch (Exception e) {
            w.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
        }
        isVideoDataAvailable = false;
        if (!isVideoDataAvailable) {
            w.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
        } else if (this.qvV.containsKey(this.hYc + 0 + "_-1")) {
            str = this.hYc + pInt.value + "_" + pInt2.value;
            w.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.hYp), Boolean.valueOf(false)});
            if (this.qvV.containsKey(str)) {
            }
            w.i("MicroMsg.OnlineVideoViewHelper", "already request video : " + str);
        }
        return isVideoDataAvailable;
    }

    final void bjx() {
        w.i("MicroMsg.OnlineVideoViewHelper", "play offline video %s ", new Object[]{this.hYc});
        af.v(new Runnable(this) {
            final /* synthetic */ ae qwe;

            {
                this.qwe = r1;
            }

            public final void run() {
                if (this.qwe.qvW != null) {
                    this.qwe.qvW.as(this.qwe.hYd, false);
                }
            }
        });
    }

    public final void bjy() {
        if (this.qwa == 0) {
            this.qwa = bg.Nz();
        }
    }
}
