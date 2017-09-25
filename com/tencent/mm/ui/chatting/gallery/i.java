package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.kk;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.s.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.d;
import com.tencent.mm.u.j;
import com.tencent.mm.ui.chatting.eg;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.wcdb.FileUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class i extends a implements com.tencent.mm.modelvideo.s.a, com.tencent.mm.u.d.a {
    public static boolean vFM = false;
    public String filename;
    public d iXd;
    private aj kmT = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ i vSV;

        {
            this.vSV = r1;
        }

        public final boolean oQ() {
            j bWL = this.vSV.vPU.bWL();
            if (bWL == null) {
                return false;
            }
            if (bWL.vTi == null) {
                return false;
            }
            if (bWL.bXx().vTi.getVisibility() != 0) {
                return false;
            }
            int bXf = this.vSV.vPU.vPV.bXf();
            if (((r) this.vSV.vSF.get(bXf)) == null) {
                this.vSV.BH(bXf);
                return false;
            } else if (bWL.bXx().vTl.isPlaying()) {
                this.vSV.vSK = bWL.bXx().vTl.getCurrentPosition();
                this.vSV.BI(this.vSV.vSK / 1000);
                return true;
            } else {
                w.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
                return false;
            }
        }
    }, true);
    int lKr = 0;
    public long lastCheckTime = 0;
    private b nzx = new b(this) {
        final /* synthetic */ i vSV;

        {
            this.vSV = r1;
        }

        public final long aKm() {
            w.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", Integer.valueOf(this.vSV.hashCode()));
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.valueOf(true));
            try {
                if (this.vSV.qvD && this.vSV.vSG != null) {
                    return (long) this.vSV.vSG.hYm;
                }
            } catch (Exception e) {
            }
            return 0;
        }
    };
    public boolean qvD;
    long qvH = 0;
    long qvI = 0;
    public aj qvJ = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ i vSV;

        {
            this.vSV = r1;
        }

        public final boolean oQ() {
            if (!this.vSV.vSG.isStreaming()) {
                return false;
            }
            j bWL = this.vSV.vPU.bWL();
            if (bWL == null || bWL.vTi == null || bWL.bXx().vTi.getVisibility() != 0) {
                return false;
            }
            boolean z = true;
            if (bWL.bXx().vTl.isPlaying()) {
                z = this.vSV.b(bWL);
            }
            if (!z) {
                return false;
            }
            return this.vSV.vSG.gL(bWL.bXx().vTl.getCurrentPosition() / 1000);
        }
    }, true);
    private long qvN;
    int qvO;
    private e qvs = new e(this) {
        final /* synthetic */ i vSV;

        {
            this.vSV = r1;
        }

        public final void aMm() {
            w.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", Integer.valueOf(this.vSV.hashCode()));
            try {
                this.vSV.vPU.bWL().a(true, 1.0f);
            } catch (Exception e) {
                w.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + e.toString());
            }
        }
    };
    private com.tencent.mm.plugin.sight.decode.ui.b sHR = new com.tencent.mm.plugin.sight.decode.ui.b(this) {
        final /* synthetic */ i vSV;

        {
            this.vSV = r1;
        }

        public final void Uh() {
            if (this.vSV.vPU.bWL() != null) {
                this.vSV.a(this.vSV.vPU.bWL());
            }
            this.vSV.vPU.vPV.vSs.KH();
        }

        public final void hR(int i) {
            String str = null;
            try {
                str = this.vSV.vPU.bWL().bXx().vTl.Ls();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "", new Object[0]);
                w.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + e.toString());
            }
            w.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", Integer.valueOf(i), Boolean.valueOf(this.vSV.qvD), str);
            if (bg.mA(str)) {
                ce bWK = this.vSV.vPU.bWK();
                if (bWK != null && bWK.bMl()) {
                    t.d(bWK.field_imgPath, i * 1000, this.vSV.qvD);
                }
                this.vSV.vPU.Br(this.vSV.vPU.vPV.bXf());
            } else {
                boolean am;
                if (this.vSV.qvD) {
                    am = this.vSV.vSG.am(i, true);
                } else {
                    this.vSV.K(i, true);
                    am = true;
                }
                if (am) {
                    this.vSV.bs(false);
                }
            }
            this.vSV.vPU.vPV.bXc();
        }
    };
    public HashMap<String, a> vRK = new HashMap();
    private com.tencent.mm.sdk.b.c vSE;
    final SparseArray<r> vSF = new SparseArray();
    public l vSG = new l(this);
    public boolean vSH = false;
    public boolean vSI = false;
    public boolean vSJ = false;
    public int vSK = 0;
    public long vSL = 0;
    private int vSM = 0;
    private int vSN = 0;
    private boolean vSO = false;
    ae vSP = new ae(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ae.a(this) {
        final /* synthetic */ i vSV;

        {
            this.vSV = r1;
        }

        public final boolean handleMessage(Message message) {
            if (message.what == 1) {
                j bWL = this.vSV.vPU.bWL();
                if (!(bWL == null || bg.mA(this.vSV.filename))) {
                    w.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", Integer.valueOf(hashCode()), this.vSV.filename);
                    if (!this.vSV.vSI) {
                        t.d(this.vSV.filename, bWL.bXx().vTl.getCurrentPosition(), this.vSV.qvD);
                    }
                    this.vSV.a(bWL);
                    this.vSV.iXd.aS(false);
                    if (this.vSV.qvD) {
                        com.tencent.mm.sdk.b.a.urY.c(this.vSV.vSR);
                        this.vSV.vSG.bXz();
                        this.vSV.qvD = false;
                    }
                }
                this.vSV.vSH = false;
            }
            return false;
        }
    });
    private int vSQ = 0;
    public com.tencent.mm.sdk.b.c<kk> vSR = new com.tencent.mm.sdk.b.c<kk>(this) {
        final /* synthetic */ i vSV;

        {
            this.vSV = r2;
            this.usg = kk.class.getName().hashCode();
        }

        private boolean a(kk kkVar) {
            if (!this.vSV.vSG.GO(kkVar.fQO.mediaId)) {
                return false;
            }
            String str;
            if (kkVar.fQO.fEX == 0 || kkVar.fQO.fEX == -21006) {
                String lv;
                int i;
                l lVar;
                switch (kkVar.fQO.fJK) {
                    case 1:
                        l lVar2 = this.vSV.vSG;
                        long j = (long) kkVar.fQO.offset;
                        long j2 = kkVar.fQO.fQP;
                        boolean z = kkVar.fQO.fQQ;
                        w.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", Long.valueOf(j), Integer.valueOf(lVar2.hYj), Integer.valueOf(lVar2.hYi), Long.valueOf(j2), Long.valueOf(lVar2.hzq));
                        if (lVar2.hYi != 0) {
                            w.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
                        } else {
                            if (j2 <= lVar2.hzq) {
                                j2 = lVar2.hzq;
                            }
                            lVar2.hzq = j2;
                            g.oUh.a(354, 5, 1, false);
                            lVar2.qvZ = bg.Nz();
                            o.KV();
                            lv = s.lv(lVar2.filename);
                            try {
                                if (lVar2.hYh == null) {
                                    w.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
                                } else if (lVar2.hYh.m(lv, j)) {
                                    lVar2.hYi = lVar2.hYh.imd;
                                    w.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", Integer.valueOf(lVar2.hYi), lVar2.filename, Boolean.valueOf(z));
                                    if (!z) {
                                        af.v(new Runnable(lVar2) {
                                            final /* synthetic */ l vTU;

                                            {
                                                this.vTU = r1;
                                            }

                                            public final void run() {
                                                if (this.vTU.vTS != null) {
                                                    if (this.vTU.gL(t.u(this.vTU.hYi, this.vTU.filename))) {
                                                        if (this.vTU.qvY == 0 && this.vTU.qwa == 0) {
                                                            this.vTU.qwa = bg.Nz();
                                                        }
                                                        this.vTU.vTS.as(this.vTU.filename, true);
                                                        this.vTU.hYo = true;
                                                    }
                                                }
                                            }
                                        });
                                    }
                                    if (lVar2.hYj == -1) {
                                        lVar2.hYg = 1;
                                    } else {
                                        lVar2.hYg = 2;
                                    }
                                    g.oUh.a(354, 7, 1, false);
                                } else {
                                    w.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
                                    o.KW();
                                    f.e(lVar2.mediaId, 0, -1);
                                    t.I(lVar2.filename, 15);
                                    g.oUh.a(354, 8, 1, false);
                                    w.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", Integer.valueOf(lVar2.hashCode()), lVar2.filename);
                                    g.oUh.i(13836, Integer.valueOf(302), Long.valueOf(bg.Ny()), "");
                                }
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
                                w.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + e.toString());
                            }
                        }
                        this.vSV.qvD = true;
                        break;
                    case 2:
                        l lVar3 = this.vSV.vSG;
                        lv = kkVar.fQO.mediaId;
                        i = kkVar.fQO.offset;
                        int i2 = kkVar.fQO.length;
                        lVar3.hYp = false;
                        if (i < 0 || i2 < 0) {
                            w.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", Integer.valueOf(i), Integer.valueOf(i2));
                        } else if (lVar3.GO(lv)) {
                            Integer num = (Integer) lVar3.qvV.get(lVar3.mediaId + i + "_" + i2);
                            if (num == null || num.intValue() <= 0) {
                                try {
                                    lVar3.hYm = lVar3.hYh.bi(i, i2);
                                } catch (Throwable e2) {
                                    w.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e2, "", new Object[0]);
                                    w.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + e2.toString());
                                }
                            } else {
                                lVar3.hYm = num.intValue();
                            }
                            w.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(lVar3.hYm));
                        }
                        if (kkVar.fQO.length > 0) {
                            this.vSV.bs(true);
                            break;
                        }
                        break;
                    case 3:
                        this.vSV.bs(true);
                        break;
                    case 4:
                        lVar = this.vSV.vSG;
                        w.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", Integer.valueOf(lVar.hYg));
                        lVar.hYp = false;
                        lVar.hYf = 3;
                        if (lVar.hYg == 0) {
                            w.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
                            lVar.bjx();
                            g.oUh.a(354, 6, 1, false);
                        } else if (lVar.hYg == 5) {
                            w.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + lVar.mediaId);
                            lVar.bjx();
                        }
                        lVar.bXB();
                        g.oUh.a(354, 26, 1, false);
                        this.vSV.bs(true);
                        break;
                    case 5:
                        lVar = this.vSV.vSG;
                        str = kkVar.fQO.mediaId;
                        i = kkVar.fQO.offset;
                        if (lVar.GO(str)) {
                            lVar.qvX = (i * 100) / lVar.iyQ;
                            w.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + lVar.qvX);
                        }
                        if (lVar.qvX >= 100) {
                            lVar.hYf = 3;
                            break;
                        }
                        break;
                    case 6:
                        lVar = this.vSV.vSG;
                        w.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
                        lVar.bjx();
                        break;
                    default:
                        w.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + kkVar.fQO.fJK);
                        break;
                }
                return false;
            }
            w.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + kkVar.fQO.fEX);
            i iVar = this.vSV;
            str = kkVar.fQO.mediaId;
            int i3 = kkVar.fQO.fEX;
            w.i("MicroMsg.Imagegallery.handler.video", "download online video error. mediaId: " + str);
            iVar.bjq();
            l lVar4 = iVar.vSG;
            w.i("MicroMsg.OnlineVideoUIHelper", "deal stream error.");
            if (lVar4.GO(str)) {
                lVar4.hYf = 2;
                o.KW().b(lVar4.mediaId, lVar4.bXC());
            }
            g.oUh.a(354, 9, 1, false);
            if (i3 == -10012) {
                w.w("MicroMsg.Imagegallery.handler.video", "download online video time out, quit imageGalleryUI.");
                af.v(new Runnable(iVar) {
                    final /* synthetic */ i vSV;

                    {
                        this.vSV = r1;
                    }

                    public final void run() {
                        this.vSV.vPU.vPV.onBackPressed();
                    }
                });
            } else {
                af.v(new AnonymousClass2(iVar, i3));
            }
            return false;
        }
    };
    public boolean vSS = false;
    private int vST = 0;
    private int[] vSU = new int[]{DownloadResult.CODE_UNDEFINED, -2000, 3400};

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ i vSV;
        final /* synthetic */ int vSW;

        AnonymousClass2(i iVar, int i) {
            this.vSV = iVar;
            this.vSW = i;
        }

        public final void run() {
            w.w("MicroMsg.Imagegallery.handler.video", "show play video error.");
            t.lK(this.vSV.filename);
            if (this.vSV.vPU != null) {
                OnClickListener anonymousClass1;
                j bWL = this.vSV.vPU.bWL();
                bWL.bXx().vTl.stop();
                bWL.a(false, 0.0f);
                String string = this.vSV.vPU.vPV.getString(R.l.fak);
                if (this.vSW == -5103059 || this.vSW == -5103087) {
                    string = this.vSV.vPU.vPV.getString(R.l.faj);
                    anonymousClass1 = new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 vSX;

                        {
                            this.vSX = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (dialogInterface != null) {
                                dialogInterface.cancel();
                            }
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 vSY;

                                {
                                    this.vSY = r1;
                                }

                                public final void run() {
                                    if (this.vSY.vSX.vSV.vPU != null && this.vSY.vSX.vSV.vPU.vPV != null) {
                                        this.vSY.vSX.vSV.vPU.vPV.onBackPressed();
                                    }
                                }
                            });
                        }
                    };
                } else {
                    anonymousClass1 = new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 vSX;

                        {
                            this.vSX = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (dialogInterface != null) {
                                dialogInterface.cancel();
                            }
                        }
                    };
                }
                com.tencent.mm.ui.base.g.a(this.vSV.vPU.vPV, string, this.vSV.vPU.vPV.getString(R.l.dVf), anonymousClass1);
                this.vSV.vSF.clear();
            }
        }
    }

    public static class a {
        public au fCZ;
        public int pos;

        public a(au auVar, int i) {
            this.fCZ = auVar;
            this.pos = i;
        }
    }

    public i(b bVar) {
        super(bVar);
        com.tencent.mm.sdk.b.a aVar = com.tencent.mm.sdk.b.a.urY;
        com.tencent.mm.sdk.b.c egVar = new eg(com.tencent.mm.ui.chatting.eg.a.VIDEO_GALLERY, bVar.vPV);
        this.vSE = egVar;
        aVar.b(egVar);
        com.tencent.mm.sdk.b.a.urY.b(this.vSR);
        this.iXd = new d();
    }

    public final boolean a(j jVar, au auVar, int i) {
        super.a(jVar, auVar, i);
        r bl = bl(auVar);
        if (auVar == null) {
            w.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
            return false;
        }
        if (this.vRK != null) {
            this.vRK.put(auVar.field_imgPath, new a(auVar, i));
        } else {
            w.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
        }
        if (bl == null) {
            return false;
        }
        o.KV();
        jVar.bXx().vTj.setImageBitmap(BackwardSupportUtil.b.c(s.lw(auVar.field_imgPath), 1.0f));
        if (jVar.bXx().vTl.isPlaying()) {
            jVar.bXx().vTl.stop();
        }
        jVar.vTn.setVisibility(8);
        jVar.bXx().vTm.setVisibility(8);
        jVar.bXx().vTt.setVisibility(8);
        jVar.a(false, 0.0f);
        this.vSM = 0;
        this.qvH = bg.Nz();
        return true;
    }

    public static r bl(au auVar) {
        if (b.aS(auVar)) {
            return t.lH(auVar.field_imgPath);
        }
        return null;
    }

    public final void pause(int i) {
        a(Bk(i));
        this.iXd.aS(false);
        this.vPU.vPV.lu(true);
    }

    public final void i(au auVar, int i) {
        w.i("MicroMsg.Imagegallery.handler.video", "toggle video");
        if (auVar != null) {
            if (b.aS(auVar) || b.aT(auVar)) {
                r bl = bl(auVar);
                if (bl == null) {
                    return;
                }
                if (this.qvD && this.vSG != null && this.vSG.hYl) {
                    w.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", Integer.valueOf(hashCode()));
                } else if (this.vPU.vPV.bXg()) {
                    a(Bk(i));
                    this.vPU.vPV.lu(true);
                    this.vPU.vPV.vSs.KH();
                    this.iXd.aS(false);
                    w.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
                } else {
                    ap.yY();
                    if (c.isSDCardAvailable()) {
                        int currentPosition;
                        if (this.qvD) {
                            try {
                                if (this.vPU.bWL().vTl != null) {
                                    currentPosition = this.vPU.bWL().vTl.getCurrentPosition() / 1000;
                                    if (this.vSG.gM(currentPosition)) {
                                        w.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
                                        bs(false);
                                    } else {
                                        w.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
                                        a(auVar, bl, i, this.qvD);
                                    }
                                }
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "", new Object[0]);
                            }
                            currentPosition = 0;
                            if (this.vSG.gM(currentPosition)) {
                                w.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
                                bs(false);
                            } else {
                                w.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
                                a(auVar, bl, i, this.qvD);
                            }
                        } else {
                            if (auVar.field_isSend == 0) {
                                if (bl.status == 113 || bl.status == 198) {
                                    a(auVar, bl);
                                } else {
                                    if (bl.status == 199) {
                                        a(auVar, bl, i, false);
                                    }
                                    if (bl.status == 111) {
                                        a(auVar, bl);
                                    }
                                    if (bl.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                                        a(auVar, bl);
                                    }
                                    if (bl.status == 121 || bl.status == 122) {
                                        a(auVar, bl);
                                    }
                                }
                            }
                            if (auVar.field_isSend == 1) {
                                currentPosition = bl.status;
                                if (currentPosition == 111 || currentPosition == 113 || currentPosition == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || currentPosition == 121 || currentPosition == 122) {
                                    w.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", auVar.field_talker, Integer.valueOf(currentPosition));
                                    a(auVar, bl);
                                } else {
                                    a(auVar, bl, i, false);
                                }
                            }
                        }
                        if (this.vPU.vPV.vSr) {
                            this.vPU.vPV.bXc();
                        }
                        bXt();
                        return;
                    }
                    com.tencent.mm.ui.base.s.eP(this.vPU.vPV.uSU.uTo);
                }
            }
        }
    }

    public final void j(au auVar, int i) {
        w.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
        r lH = t.lH(auVar.field_imgPath);
        if (lH != null && !lH.Lk()) {
            a(Bk(i));
            this.vPU.vPV.lu(true);
            if (this.qvD) {
                this.vSG.bXz();
                this.vSG.reset();
            }
            a(auVar, lH);
            if (this.vPU.vPV.eS(auVar.field_msgId) == 2) {
                cP(auVar.field_imgPath, 8);
            } else {
                cP(auVar.field_imgPath, 5);
            }
        }
    }

    public final void a(au auVar, r rVar, int i, boolean z) {
        if (auVar != null && rVar != null) {
            if (auVar.bMt()) {
                Toast.makeText(this.vPU.vPV, R.l.fai, 0).show();
                return;
            }
            String lv;
            String Lg;
            if (rVar.iaw == -1) {
                Lg = rVar.Lg();
                if (!com.tencent.mm.a.e.aO(Lg)) {
                    o.KV();
                    lv = s.lv(auVar.field_imgPath);
                }
                lv = Lg;
            } else {
                o.KV();
                Lg = s.lv(auVar.field_imgPath);
                if (auVar.field_isSend == 1 && rVar.iaz != null && rVar.iaz.tOs) {
                    try {
                        String kk = FileOp.kk(Lg);
                        if (!kk.endsWith("/")) {
                            kk = kk + "/";
                        }
                        kk = kk + com.tencent.mm.a.e.aR(Lg) + "_hd.mp4";
                        w.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", kk, Boolean.valueOf(FileOp.aO(kk)));
                        if (!FileOp.aO(kk)) {
                            kk = Lg;
                        }
                        lv = kk;
                    } catch (Exception e) {
                        w.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", e.getMessage());
                    }
                }
                lv = Lg;
            }
            if (lv == null || !com.tencent.mm.a.e.aO(lv)) {
                Toast.makeText(this.vPU.vPV, R.l.fai, 0).show();
                return;
            }
            j Bk = Bk(i);
            if (Bk != null) {
                int eC;
                if (com.tencent.mm.u.o.dH(rVar.Le())) {
                    eC = j.eC(rVar.Le());
                } else {
                    eC = 0;
                }
                boolean lo = q.lo(lv);
                w.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(this.vPU.vPV.eS(auVar.field_msgId)), Boolean.valueOf(this.vSO));
                if (lo) {
                    g.oUh.i(12084, Integer.valueOf(rVar.hrs), Integer.valueOf(rVar.iap * 1000), Integer.valueOf(0), Integer.valueOf(3), rVar.Le(), Integer.valueOf(eC), r.lr(rVar.Lh()), Long.valueOf(rVar.iam));
                    if (!com.tencent.mm.pluginsdk.l.b.a.a.c(lv, this.vPU.vPV.uSU.uTo, lo)) {
                        Toast.makeText(this.vPU.vPV.uSU.uTo, this.vPU.vPV.getString(R.l.fao), 0).show();
                    }
                } else if (p.gRl.gQj != 1 || !com.tencent.mm.pluginsdk.l.b.a.a.b(rVar.getFileName(), this.vPU.vPV.uSU.uTo, lo)) {
                    ap.yY();
                    if (((Integer) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, Integer.valueOf(0))).intValue() == 1 && Bk.vTn != null) {
                        Bk.vTn.setVisibility(0);
                        Bk.vTn.setText(com.tencent.mm.plugin.sight.base.d.AN(lv));
                    }
                    int i2 = rVar.iap;
                    int i3 = rVar.hrs;
                    String Le = rVar.Le();
                    String lr = r.lr(rVar.Lh());
                    long j = rVar.iam;
                    Bk.qjA = i2;
                    Bk.vTy = i3;
                    Bk.vTz = eC;
                    Bk.fOu = Le;
                    Bk.fOx = lr;
                    Bk.iam = j;
                    this.qvD = z;
                    this.vSH = true;
                    this.filename = rVar.getFileName();
                    if (r4 == 3) {
                        Bk.bXx().vTl.bQ(true);
                    } else {
                        Bk.bXx().vTl.bQ(false);
                    }
                    if (Bk.bXx().vTl.Ls() == null || !Bk.bXx().vTl.Ls().equals(lv) || Bk.bXx().vTl.isPlaying() || this.vSO) {
                        this.vSJ = false;
                        this.vSO = false;
                        Bk.bXx().vTl.setVideoPath(lv);
                        if (Bk.bXx().vTl instanceof VideoPlayerTextureView) {
                            boolean c;
                            ((VideoPlayerTextureView) Bk.bXx().vTl).nzx = this.nzx;
                            VideoPlayerTextureView videoPlayerTextureView = (VideoPlayerTextureView) Bk.bXx().vTl;
                            if (this.qvD) {
                                ap.yY();
                                c = c.vr().c(com.tencent.mm.storage.w.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
                            } else {
                                c = false;
                            }
                            videoPlayerTextureView.fB(c);
                            ((VideoPlayerTextureView) Bk.bXx().vTl).fC(z);
                        }
                        Bk.a(true, 0.0f);
                    } else {
                        Bk.a(true, 1.0f);
                        Bk.bXx().vTl.start();
                        bjp();
                        if (!z) {
                            TK(this.filename);
                        }
                        BI(Bk.bXx().vTl.getCurrentPosition() / 1000);
                        bs(false);
                    }
                    this.vSF.put(i, rVar);
                    this.vPU.vPV.lu(false);
                    this.vPU.vPV.uSU.uTo.getWindow().addFlags(FileUtils.S_IWUSR);
                    if (com.tencent.mm.compatible.util.d.ep(18)) {
                        TK(this.filename);
                    }
                    this.iXd.a(this);
                } else {
                    return;
                }
                Bk.bXx().vTm.setVisibility(8);
            }
        }
    }

    private void a(final au auVar, final r rVar) {
        if (aa.bn(this.vPU.vPV.uSU.uTo) || vFM) {
            b(auVar, rVar);
        } else {
            com.tencent.mm.ui.base.g.a(this.vPU.vPV.uSU.uTo, R.l.fah, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ i vSV;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    i.vFM = true;
                    this.vSV.b(auVar, rVar);
                }
            }, null);
        }
    }

    public final void b(au auVar, r rVar) {
        w.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", Integer.valueOf(hashCode()));
        if (auVar != null && rVar != null) {
            j bWL = this.vPU.bWL();
            if (bWL != null) {
                Object obj;
                int eS = this.vPU.vPV.eS(auVar.field_msgId);
                w.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : " + eS);
                switch (eS) {
                    case 0:
                        break;
                    case 1:
                    case 2:
                        if (rVar.Lj()) {
                            w.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
                            t.lL(auVar.field_imgPath);
                        } else {
                            w.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
                            cP(auVar.field_imgPath, 10);
                            t.lD(auVar.field_imgPath);
                        }
                        o.KV().a(this, Looper.getMainLooper());
                        this.vPU.vPV.bXe();
                        this.vSS = false;
                        bWL.bXx().vTk.setVisibility(8);
                        bWL.bXx().vTm.setVisibility(0);
                        bWL.bXx().vTm.setProgress(t.f(rVar));
                        if (eS == 2) {
                            g.oUh.a(354, 14, 1, false);
                            return;
                        } else {
                            g.oUh.a(354, 11, 1, false);
                            return;
                        }
                    case 3:
                        w.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", Integer.valueOf(hashCode()), Integer.valueOf(eS));
                        break;
                    default:
                        w.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", Integer.valueOf(eS));
                        return;
                }
                l lVar = this.vSG;
                String str = auVar.field_imgPath;
                com.tencent.mm.modelcontrol.d.Eu();
                if (com.tencent.mm.modelcontrol.d.Ez()) {
                    lVar.reset();
                    r lH = t.lH(str);
                    if (lH == null || lH.hrs >= lVar.vTT.vTV) {
                        com.tencent.mm.modelcdntran.i iVar;
                        t.J(str, 1);
                        n.KT();
                        o.KW();
                        if (bg.mA(str)) {
                            iVar = null;
                        } else {
                            r lH2 = t.lH(str);
                            if (lH2 == null) {
                                iVar = null;
                            } else {
                                Map q = bh.q(lH2.Lh(), "msg");
                                if (q == null) {
                                    w.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
                                    iVar = null;
                                } else {
                                    String str2 = (String) q.get(".msg.videomsg.$cdnvideourl");
                                    if (bg.mA(str2)) {
                                        w.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
                                        iVar = null;
                                    } else {
                                        int intValue = Integer.valueOf((String) q.get(".msg.videomsg.$length")).intValue();
                                        String str3 = (String) q.get(".msg.videomsg.$md5");
                                        String str4 = (String) q.get(".msg.videomsg.$aeskey");
                                        String str5 = (String) q.get(".msg.videomsg.$fileparam");
                                        String a = com.tencent.mm.modelcdntran.d.a("downvideo", lH2.iam, lH2.Le(), lH2.getFileName());
                                        if (bg.mA(a)) {
                                            w.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", lH2.getFileName());
                                            iVar = null;
                                        } else {
                                            o.KV();
                                            String lv = s.lv(str);
                                            com.tencent.mm.modelcdntran.i iVar2 = new com.tencent.mm.modelcdntran.i();
                                            iVar2.filename = str;
                                            iVar2.hzr = str3;
                                            iVar2.hzs = intValue;
                                            iVar2.hzt = 1;
                                            iVar2.fOu = lH2.Lf();
                                            iVar2.hzu = lH2.Le();
                                            iVar2.fOw = com.tencent.mm.u.o.dH(lH2.Le()) ? j.eC(lH2.Le()) : 0;
                                            iVar2.field_mediaId = a;
                                            iVar2.field_fullpath = lv;
                                            iVar2.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
                                            iVar2.field_totalLen = intValue;
                                            iVar2.field_aesKey = str4;
                                            iVar2.field_fileId = str2;
                                            iVar2.field_priority = com.tencent.mm.modelcdntran.b.hxL;
                                            iVar2.field_wxmsgparam = str5;
                                            iVar2.field_chattype = com.tencent.mm.u.o.dH(lH2.Le()) ? 1 : 0;
                                            iVar2.hzv = lH2.hzv;
                                            ce x = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().x(lH2.Le(), lH2.fTQ);
                                            ay.b gm = ay.gm(x.gxF);
                                            iVar2.initialDownloadLength = gm != null ? gm.hmZ : 0;
                                            iVar2.initialDownloadOffset = 0;
                                            iVar2.hzx = x.field_createTime;
                                            iVar2.fTQ = x.field_msgSvrId;
                                            iVar2.hzy = gm != null ? gm.hna : 0;
                                            if (iVar2.initialDownloadLength > 0) {
                                                g.oUh.a(354, 36, 1, false);
                                            }
                                            iVar2.field_autostart = false;
                                            iVar2.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(1, lH2);
                                            iVar = iVar2;
                                        }
                                    }
                                }
                            }
                        }
                        if (iVar == null) {
                            obj = null;
                        } else {
                            lVar.mediaId = iVar.field_mediaId;
                            lVar.iyQ = iVar.hzs;
                            lVar.filename = str;
                            lVar.hYf = 1;
                            lVar.hYi = 0;
                            o.KW().a(iVar, o.La().Lt());
                            lVar.hzq = bg.Nz();
                            g.oUh.a(354, 1, 1, false);
                            w.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", lVar.mediaId, str, Long.valueOf(lVar.hzq));
                            obj = 1;
                        }
                    } else {
                        w.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", Integer.valueOf(lH.hrs), Integer.valueOf(lVar.vTT.vTV));
                        t.b(lH, 9);
                        g.oUh.a(354, 17, 1, false);
                        obj = null;
                    }
                } else {
                    obj = null;
                }
                if (obj != null) {
                    w.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
                    this.qvD = true;
                    o.KV().a((com.tencent.mm.modelvideo.s.a) this);
                    this.vPU.vPV.bXe();
                    this.vSS = false;
                    bWL.bXx().vTk.setVisibility(8);
                    bWL.bXx().vTm.setVisibility(8);
                    bWL.bXx().vTt.setVisibility(0);
                    return;
                }
                w.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
                this.qvD = false;
                o.KV().a(this, Looper.getMainLooper());
                t.lD(auVar.field_imgPath);
                this.vPU.vPV.bXe();
                this.vSS = false;
                bWL.bXx().vTk.setVisibility(8);
                bWL.bXx().vTm.setVisibility(0);
                bWL.bXx().vTm.setProgress(t.f(rVar));
            }
        }
    }

    private void cP(final String str, final int i) {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ i vSV;

            public final void run() {
                t.J(str, i);
            }
        });
    }

    private boolean b(a aVar) {
        if (aVar == null) {
            return false;
        }
        o.KV().a((com.tencent.mm.modelvideo.s.a) this);
        if (this.vPU.vPV.bXf() == aVar.pos) {
            j Bk = Bk(aVar.pos);
            if (Bk != null) {
                Bk.bXx().vTt.setVisibility(8);
                Bk.bXx().vTm.setVisibility(8);
                Bk.bXx().vTk.setVisibility(8);
            }
            this.vSS = true;
            this.vPU.vPV.bXd();
            return true;
        }
        this.vPU.Bt(aVar.pos);
        return false;
    }

    public final void bWS() {
        w.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
        this.qvI = bg.Nz();
        SparseArray sparseArray = this.vPU.vnM;
        int i = 0;
        boolean z = false;
        while (i < sparseArray.size()) {
            boolean z2;
            int keyAt = sparseArray.keyAt(i);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                j jVar = (j) ((View) sparseArray.get(keyAt)).getTag();
                if (jVar.vTi != null && jVar.bXx().vTi.getVisibility() == 0 && (((View) jVar.bXx().vTl).getVisibility() == 0 || !bg.mA(jVar.bXx().vTl.Ls()) || (this.qvD && this.vSG.isStreaming()))) {
                    w.i("MicroMsg.Imagegallery.handler.video", "stop");
                    bjn();
                    if (jVar != null) {
                        bjq();
                        if (this.qvD) {
                            this.vSG.bXz();
                        }
                        if (!this.vSI) {
                            t.d(this.filename, this.vSK + DownloadResult.CODE_UNDEFINED, this.qvD);
                        }
                        jVar.bXx().vTm.setVisibility(8);
                        jVar.bXx().vTt.setVisibility(8);
                        jVar.bXx().vTl.stop();
                        BI(0);
                        jVar.a(false, 0.0f);
                        this.qvD = false;
                        this.vSS = false;
                        this.vSO = false;
                        this.filename = null;
                        this.qvO = 0;
                        this.qvN = 0;
                        this.vST = 0;
                        this.vSQ = 0;
                        this.vSN = 0;
                        this.vSM = 0;
                        this.vSL = 0;
                        this.lastCheckTime = 0;
                    }
                    z2 = true;
                    i++;
                    z = z2;
                }
            }
            z2 = z;
            i++;
            z = z2;
        }
        this.iXd.aS(false);
        if (!z && this.qvD) {
            this.vSG.bXz();
            this.qvD = false;
        }
        bjn();
        this.vSF.clear();
    }

    public final void a(j jVar) {
        if (jVar != null) {
            bjn();
            w.d("MicroMsg.Imagegallery.handler.video", "pause video.");
            if (jVar.bXx().vTl.isPlaying()) {
                jVar.bXx().vTl.pause();
                bjq();
            }
        }
    }

    protected final void onResume() {
        w.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
        this.vSP.removeMessages(1);
        com.tencent.mm.sdk.b.a.urY.b(this.vSR);
        if (this.vPU != null && com.tencent.mm.compatible.util.d.eo(21)) {
            j bWL = this.vPU.bWL();
            if (bWL != null && bWL.vTl != null) {
                if (bWL.vTl instanceof VideoPlayerTextureView) {
                    ((VideoPlayerTextureView) bWL.vTl).aKC();
                } else if (bWL.vTl instanceof VideoTextureView) {
                    ((VideoTextureView) bWL.vTl).aKC();
                }
            }
        }
    }

    public final void detach() {
        w.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", Integer.valueOf(hashCode()));
        this.qvI = bg.Nz();
        this.vSP.removeMessages(1);
        bjn();
        com.tencent.mm.sdk.b.a.urY.c(this.vSE);
        com.tencent.mm.sdk.b.a.urY.c(this.vSR);
        bWS();
        this.vPU.vPV.uSU.uTo.getWindow().clearFlags(FileUtils.S_IWUSR);
        this.vPU.vPV.bWU().vSb.puM = null;
        super.detach();
        this.vRK.clear();
        this.vRK = null;
        o.KV().a((com.tencent.mm.modelvideo.s.a) this);
        this.vSF.clear();
        l lVar = this.vSG;
        lVar.reset();
        lVar.hYh = null;
        lVar.vTS = null;
        lVar.vTT = null;
        if (com.tencent.mm.plugin.s.e.aKp()) {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ i vSV;

                {
                    this.vSV = r1;
                }

                public final void run() {
                    String aKq = com.tencent.mm.plugin.s.e.aKq();
                    if (bg.mA(aKq)) {
                        g.oUh.A(14092, "0");
                    } else {
                        g.oUh.A(14092, aKq);
                    }
                }
            });
        }
        o.La().Lt();
        o.La().run();
    }

    public final void bXr() {
        this.vSI = false;
        this.lKr = 0;
        j bWL = this.vPU != null ? this.vPU.bWL() : null;
        if (bWL == null) {
            w.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
            return;
        }
        final int ex = bg.ex((long) bWL.bXx().vTl.getDuration());
        int i = this.vPU.vPV.bWU().vSb.puT;
        w.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", Integer.valueOf(hashCode()), Integer.valueOf(ex), Integer.valueOf(i));
        if (i <= 0 || Math.abs(i - ex) >= 2) {
            this.vPU.vPV.bWU().vSb.sH(ex);
        }
        bXt();
        if (ex == 0 || ex >= 1800) {
            w.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", Integer.valueOf(hashCode()), Integer.valueOf(ex), this.filename);
        } else {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ i vSV;

                public final void run() {
                    String str = this.vSV.filename;
                    int i = ex;
                    r lH = t.lH(str);
                    if (lH != null) {
                        int i2 = lH.iap;
                        if (i2 <= 0 || Math.abs(i2 - i) > 2) {
                            lH.iap = i;
                            lH.fRW = Downloads.RECV_BUFFER_SIZE;
                            w.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", Boolean.valueOf(t.e(lH)), Integer.valueOf(i2), Integer.valueOf(i));
                        }
                    }
                }
            });
        }
        ex = t.u(ex, this.filename);
        w.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", Boolean.valueOf(this.qvD), Integer.valueOf(ex), Boolean.valueOf(this.vSH), Boolean.valueOf(this.vSI));
        bWL.bXx().vTl.a(this.qvs);
        if (this.vSH) {
            if (this.qvD) {
                l lVar = this.vSG;
                if (ex > 0) {
                    w.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : " + ex);
                    lVar.hYj = ex;
                    lVar.hYl = true;
                    lVar.hYg = 2;
                }
                this.vSG.gL(0);
            } else {
                this.vSG.reset();
                bjp();
                K(ex, true);
            }
            bs(false);
            return;
        }
        if (this.qvD) {
            this.vSG.am(ex, false);
        } else {
            K(ex, false);
        }
        BI(ex);
        this.vPU.vPV.lu(true);
        bjn();
    }

    public final void bXs() {
        int i;
        a aVar;
        w.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.qvD);
        bjn();
        bjq();
        if (!(!this.qvD || this.vPU == null || this.vPU.bWL() == null)) {
            com.tencent.mm.pluginsdk.ui.tools.f fVar = this.vPU.bWL().bXx().vTl;
            if (fVar != null && fVar.getCurrentPosition() + MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN < fVar.getDuration()) {
                w.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", Integer.valueOf(fVar.getCurrentPosition()), Integer.valueOf(fVar.getDuration()));
                i = 0;
                if (i == 0) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ i vSV;

                        {
                            this.vSV = r1;
                        }

                        public final void run() {
                            this.vSV.vSJ = true;
                            i iVar = this.vSV;
                            this.vSV.vSL = 0;
                            iVar.lastCheckTime = 0;
                            this.vSV.iXd.aS(false);
                            this.vSV.bjq();
                            if (this.vSV.qvD) {
                                this.vSV.vSG.bXz();
                                this.vSV.vSG.reset();
                                this.vSV.qvD = false;
                                this.vSV.vSS = false;
                            }
                            t.d(this.vSV.filename, 0, this.vSV.qvD);
                            if (this.vSV.vRK != null) {
                                a aVar = (a) this.vSV.vRK.get(this.vSV.filename);
                                if (aVar != null) {
                                    j bWL = this.vSV.vPU.bWL();
                                    bWL.bXx().vTl.stop();
                                    this.vSV.vSK = 0;
                                    this.vSV.a(bWL, aVar.fCZ, aVar.pos);
                                    this.vSV.BI(0);
                                    if (bWL.bXx().vTt.getVisibility() != 8) {
                                        bWL.bXx().vTt.setVisibility(8);
                                    }
                                }
                            }
                        }
                    });
                }
                try {
                    t.d(this.filename, this.vPU.bWL().vTl.getCurrentPosition(), this.qvD);
                    this.vPU.bWL().vTl.stop();
                    this.vSG.bXA();
                    i = this.vSQ + 1;
                    this.vSQ = i;
                    if (i <= 3) {
                        aVar = (a) this.vRK.get(this.filename);
                        if (aVar != null && aVar.fCZ != null) {
                            a(aVar.fCZ, bl(aVar.fCZ), aVar.pos, this.qvD);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "notify video completion error[%s]", e.toString());
                    return;
                }
            }
        }
        i = 1;
        if (i == 0) {
            t.d(this.filename, this.vPU.bWL().vTl.getCurrentPosition(), this.qvD);
            this.vPU.bWL().vTl.stop();
            this.vSG.bXA();
            i = this.vSQ + 1;
            this.vSQ = i;
            if (i <= 3) {
                aVar = (a) this.vRK.get(this.filename);
                if (aVar != null) {
                    return;
                }
                return;
            }
            return;
        }
        af.v(/* anonymous class already generated */);
    }

    public final void ec(int i, int i2) {
        String str = "MicroMsg.Imagegallery.handler.video";
        String str2 = "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(this.qvD);
        l lVar = this.vSG;
        boolean z = !bg.mA(lVar.mediaId) && lVar.hYf == 1;
        objArr[3] = Boolean.valueOf(z);
        w.e(str, str2, objArr);
        this.vSI = true;
        this.lKr = i2;
        if (this.qvD) {
            if (i == -1) {
                bjn();
                this.vPU.bWL().vTl.stop();
                this.vSG.bXA();
            } else if (i == -2) {
                bjn();
                t.d(this.filename, this.vPU.bWL().vTl.getCurrentPosition(), this.qvD);
                this.vPU.bWL().vTl.stop();
                this.vSG.bXA();
            } else if (i == -3) {
                this.vSI = false;
                this.vSG.bXA();
                return;
            }
            this.vSS = false;
            this.vPU.vPV.lu(true);
            this.vPU.bWL().bXx().vTt.setVisibility(0);
            bjq();
            g.oUh.a(354, 18, 1, false);
            return;
        }
        String str3;
        t.lK(this.filename);
        bjq();
        if (this.vPU == null || this.vPU.bWL() == null || this.vPU.bWL().vTl == null) {
            str3 = "";
        } else {
            str3 = this.vPU.bWL().vTl.Ls();
            this.vPU.bWL().vTl.stop();
        }
        if (this.vSJ) {
            w.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", Integer.valueOf(hashCode()));
            return;
        }
        af.v(new Runnable(this) {
            final /* synthetic */ i vSV;

            public final void run() {
                if (this.vSV.vPU == null || this.vSV.vPU.bWL() == null || this.vSV.vRK == null) {
                    w.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
                    return;
                }
                this.vSV.vPU.bWL().a(false, 0.0f);
                if (!bg.mA(str3)) {
                    w.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", str3);
                    try {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setDataAndType(Uri.fromFile(new File(str3)), "video/*");
                        this.vSV.vPU.vPV.startActivity(intent);
                    } catch (Exception e) {
                        w.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
                        com.tencent.mm.ui.base.g.h(this.vSV.vPU.vPV, R.l.eiL, R.l.eiM);
                    }
                }
                a aVar = (a) this.vSV.vRK.get(this.vSV.filename);
                if (aVar != null && aVar.fCZ != null) {
                    this.vSV.BH(aVar.pos);
                }
            }
        });
        g.oUh.a(354, 25, 1, false);
    }

    private void bjn() {
        w.i("MicroMsg.Imagegallery.handler.video", "clear timer");
        this.qvJ.KH();
        this.kmT.KH();
    }

    protected final void bs(boolean z) {
        if (!this.vSI) {
            if (!this.qvD) {
                this.kmT.v(500, 500);
            } else if (z) {
                af.v(new Runnable(this) {
                    final /* synthetic */ i vSV;

                    {
                        this.vSV = r1;
                    }

                    public final void run() {
                        try {
                            int u;
                            if (bg.mA(this.vSV.vPU.bWL().bXx().vTl.Ls())) {
                                u = t.u(this.vSV.vSG.hYi, this.vSV.filename);
                            } else {
                                u = this.vSV.vPU.bWL().bXx().vTl.getCurrentPosition() / 1000;
                            }
                            this.vSV.vSG.gL(u);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "start timer error[%s]", e.toString());
                        }
                        this.vSV.qvJ.v(500, 500);
                    }
                });
            } else {
                this.qvJ.v(500, 500);
            }
        }
    }

    public final void BH(int i) {
        this.vSF.remove(i);
    }

    public final void a(com.tencent.mm.modelvideo.s.a.a aVar) {
        String str = aVar.fyF;
        if (!bg.mA(str) && this.vRK != null) {
            a aVar2 = (a) this.vRK.get(str);
            if (aVar2 != null) {
                au auVar = aVar2.fCZ;
                if (auVar != null && auVar.field_imgPath != null && auVar.field_imgPath.equals(str)) {
                    r bl = bl(auVar);
                    if (bl == null) {
                        return;
                    }
                    if (!auVar.bMt() && bl.status != 198) {
                        int f = t.f(bl);
                        j Bk = Bk(aVar2.pos);
                        if (this.vPU.vPV.bXf() == aVar2.pos && Bk != null) {
                            this.vPU.vPV.bXe();
                            this.vSS = false;
                            Bk.bXx().vTm.setVisibility(0);
                            Bk.bXx().vTm.setProgress(f);
                        } else if (Bk == null) {
                            return;
                        }
                        if (f >= Bk.bXx().vTm.wvs) {
                            w.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", Integer.valueOf(bl.status));
                            if ((bl.status == 199 || bl.status == 199) && b(aVar2)) {
                                this.vPU.vPV.ew(true);
                                switch (this.vPU.vPV.eS(auVar.field_msgId)) {
                                    case 0:
                                    case 3:
                                        a(auVar, bl, this.vPU.vPV.bXf(), false);
                                        return;
                                    case 1:
                                        w.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
                                        g.oUh.a(354, 15, 1, false);
                                        this.vPU.aZ(auVar);
                                        this.vPU.vPV.eT(-1);
                                        if (this.qvD) {
                                            t.d(this.filename, this.vPU.bWL().vTl.getCurrentPosition(), this.qvD);
                                            this.vSO = true;
                                        }
                                        this.qvD = false;
                                        return;
                                    case 2:
                                        g.oUh.a(354, 16, 1, false);
                                        b.a(this.vPU.vPV, auVar, true);
                                        this.vPU.vPV.eT(-1);
                                        if (this.qvD) {
                                            t.d(this.filename, this.vPU.bWL().vTl.getCurrentPosition(), this.qvD);
                                            this.vSO = true;
                                        }
                                        this.qvD = false;
                                        return;
                                    default:
                                        w.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", Integer.valueOf(this.vPU.vPV.eS(auVar.field_msgId)));
                                        return;
                                }
                            }
                        }
                    } else if (b(aVar2)) {
                        Toast.makeText(this.vPU.vPV, R.l.fai, 0).show();
                    }
                }
            }
        }
    }

    private void bXt() {
        try {
            this.vPU.vPV.bWU().vSb.puM = this.sHR;
        } catch (Exception e) {
        }
    }

    protected final void as(final String str, final boolean z) {
        af.v(new Runnable(this) {
            final /* synthetic */ i vSV;

            public final void run() {
                w.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", str, Boolean.valueOf(z));
                if (this.vSV.vRK == null) {
                    w.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
                    return;
                }
                a aVar = (a) this.vSV.vRK.get(str);
                if (aVar != null && aVar.fCZ != null) {
                    r bl = i.bl(aVar.fCZ);
                    if (this.vSV.vPU.vPV.bXf() == aVar.pos) {
                        this.vSV.a(aVar.fCZ, bl, aVar.pos, z);
                        this.vSV.TK(str);
                        return;
                    }
                    w.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", Integer.valueOf(this.vSV.vPU.vPV.bXf()), Integer.valueOf(aVar.pos));
                }
            }
        });
    }

    protected final void K(int i, boolean z) {
        j bWL = this.vPU.bWL();
        if (bWL != null) {
            bjp();
            bWL.bXx().vTt.setVisibility(8);
            bWL.bXx().vTl.c((double) (i * 1000), z);
            this.vPU.vPV.lu(false);
            bs(false);
        }
    }

    protected final void KG() {
        j bWL = this.vPU.bWL();
        if (bWL != null) {
            w.i("MicroMsg.Imagegallery.handler.video", "start to pause");
            this.vPU.vPV.lu(true);
            bWL.bXx().vTt.setVisibility(0);
            bWL.bXx().vTl.pause();
            bjq();
        }
    }

    protected final boolean bjo() {
        j bWL = this.vPU.bWL();
        if (bWL == null) {
            return false;
        }
        boolean z = true;
        if (!bWL.bXx().vTl.isPlaying()) {
            w.i("MicroMsg.Imagegallery.handler.video", "start to play");
            this.vPU.vPV.lu(false);
            bWL.bXx().vTt.setVisibility(8);
            z = bWL.bXx().vTl.start();
            bjp();
        }
        if (bWL.bXx().vTt.getVisibility() == 8) {
            return z;
        }
        bWL.bXx().vTt.setVisibility(8);
        return z;
    }

    protected final void BI(int i) {
        this.vPU.vPV.bWU().vSb.seek(Math.max(0, i));
    }

    protected final void TK(String str) {
        if (!this.vSS && !b((a) this.vRK.get(str))) {
            w.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
        }
    }

    private void bjp() {
        this.qvN = bg.Nz();
        w.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", this.filename, Long.valueOf(this.qvN));
    }

    public final void bjq() {
        if (this.qvN > 0) {
            this.qvO = (int) (((long) this.qvO) + ((bg.Nz() - this.qvN) / 1000));
        }
        w.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", this.filename, Integer.valueOf(this.qvO));
        this.qvN = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(com.tencent.mm.ui.chatting.gallery.j r13) {
        /*
        r12 = this;
        r6 = 0;
        r11 = 3;
        r10 = 2;
        r9 = 1;
        r8 = 0;
        r0 = r12.vSK;
        r1 = r13.bXx();
        r1 = r1.vTl;
        r1 = r1.getCurrentPosition();
        r12.vSK = r1;
        r1 = r12.vSK;
        if (r0 == r1) goto L_0x0186;
    L_0x0018:
        r0 = com.tencent.mm.sdk.platformtools.bg.Nz();
        r12.lastCheckTime = r0;
        r0 = r13.bXx();
        r0 = r0.vTl;
        r0 = r0.bcx();
        r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0096;
    L_0x002c:
        r2 = r12.vSL;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x0096;
    L_0x0032:
        r12.vSL = r0;
        r1 = r12.vSM;
        switch(r1) {
            case 2: goto L_0x003d;
            case 3: goto L_0x0090;
            case 4: goto L_0x0093;
            default: goto L_0x0039;
        };
    L_0x0039:
        r12.vSM = r8;
    L_0x003b:
        r8 = r9;
    L_0x003c:
        return r8;
    L_0x003d:
        r0 = 21;
    L_0x003f:
        r2 = "MicroMsg.Imagegallery.handler.video";
        r3 = "%d rpt rptRepairEffect idKey %d errorTime %d filename %s";
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r5 = r12.hashCode();
        r5 = java.lang.Integer.valueOf(r5);
        r4[r8] = r5;
        r5 = java.lang.Integer.valueOf(r0);
        r4[r9] = r5;
        r1 = java.lang.Integer.valueOf(r1);
        r4[r10] = r1;
        r1 = r12.filename;
        r4[r11] = r1;
        com.tencent.mm.sdk.platformtools.w.w(r2, r3, r4);
        r1 = com.tencent.mm.plugin.report.service.g.oUh;
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = (long) r0;
        r6 = 1;
        r1.a(r2, r4, r6, r8);
        r0 = com.tencent.mm.plugin.report.service.g.oUh;
        r1 = 13836; // 0x360c float:1.9388E-41 double:6.836E-320;
        r2 = new java.lang.Object[r11];
        r3 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        r4 = com.tencent.mm.sdk.platformtools.bg.Ny();
        r3 = java.lang.Long.valueOf(r4);
        r2[r9] = r3;
        r3 = "";
        r2[r10] = r3;
        r0.i(r1, r2);
        goto L_0x0039;
    L_0x0090:
        r0 = 22;
        goto L_0x003f;
    L_0x0093:
        r0 = 23;
        goto L_0x003f;
    L_0x0096:
        r0 = r12.vSM;
        r1 = -1;
        if (r0 == r1) goto L_0x003b;
    L_0x009b:
        r0 = r12.vSM;
        r0 = r0 + 1;
        r12.vSM = r0;
        r0 = "MicroMsg.Imagegallery.handler.video";
        r1 = "media play is playing[%d], but surface is not update!! repair time[%d]";
        r2 = new java.lang.Object[r10];
        r3 = r12.vSM;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        r3 = r12.vSN;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r9] = r3;
        com.tencent.mm.sdk.platformtools.w.w(r0, r1, r2);
        r0 = r12.vSN;
        if (r0 < r10) goto L_0x00c5;
    L_0x00c0:
        r0 = r12.vSG;
        r0.bXA();
    L_0x00c5:
        r0 = r12.vSM;
        switch(r0) {
            case 0: goto L_0x003b;
            case 1: goto L_0x003b;
            case 2: goto L_0x011c;
            case 3: goto L_0x013c;
            case 4: goto L_0x0161;
            default: goto L_0x00ca;
        };
    L_0x00ca:
        r0 = "MicroMsg.Imagegallery.handler.video";
        r1 = "rpt surface not update!!";
        com.tencent.mm.sdk.platformtools.w.w(r0, r1);
        r0 = "MicroMsg.Imagegallery.handler.video";
        r1 = "%d rpt rptSurfaceNotUpdate %s";
        r2 = new java.lang.Object[r10];
        r3 = r12.hashCode();
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        r3 = r12.filename;
        r2[r9] = r3;
        com.tencent.mm.sdk.platformtools.w.w(r0, r1, r2);
        r0 = com.tencent.mm.plugin.report.service.g.oUh;
        r1 = 13836; // 0x360c float:1.9388E-41 double:6.836E-320;
        r2 = new java.lang.Object[r11];
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        r4 = com.tencent.mm.sdk.platformtools.bg.Ny();
        r3 = java.lang.Long.valueOf(r4);
        r2[r9] = r3;
        r3 = "";
        r2[r10] = r3;
        r0.i(r1, r2);
        r1 = com.tencent.mm.plugin.report.service.g.oUh;
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = 20;
        r6 = 1;
        r1.a(r2, r4, r6, r8);
        r0 = -1;
        r12.vSM = r0;
        goto L_0x003b;
    L_0x011c:
        r0 = r12.vSK;
        r0 = r0 / 1000;
        r1 = "MicroMsg.Imagegallery.handler.video";
        r2 = "surface not update, it try seek time[%d] to repair.";
        r3 = new java.lang.Object[r9];
        r4 = java.lang.Integer.valueOf(r0);
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.w.w(r1, r2, r3);
        r12.K(r0, r9);
        r0 = r12.vSN;
        r0 = r0 + 1;
        r12.vSN = r0;
        goto L_0x003c;
    L_0x013c:
        r0 = r12.vSK;
        r0 = r0 + -2000;
        r0 = r0 / 1000;
        if (r0 >= 0) goto L_0x0145;
    L_0x0144:
        r0 = r8;
    L_0x0145:
        r1 = "MicroMsg.Imagegallery.handler.video";
        r2 = "surface not update, it try seek time[%d] to repair.";
        r3 = new java.lang.Object[r9];
        r4 = java.lang.Integer.valueOf(r0);
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.w.w(r1, r2, r3);
        r12.K(r0, r9);
        r0 = r12.vSN;
        r0 = r0 + 1;
        r12.vSN = r0;
        goto L_0x003c;
    L_0x0161:
        r0 = r12.vSK;
        r0 = r0 + -4000;
        r0 = r0 / 1000;
        if (r0 >= 0) goto L_0x016a;
    L_0x0169:
        r0 = r8;
    L_0x016a:
        r1 = "MicroMsg.Imagegallery.handler.video";
        r2 = "surface not update, it try seek time[%d] to repair.";
        r3 = new java.lang.Object[r9];
        r4 = java.lang.Integer.valueOf(r0);
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.w.w(r1, r2, r3);
        r12.K(r0, r9);
        r0 = r12.vSN;
        r0 = r0 + 1;
        r12.vSN = r0;
        goto L_0x003c;
    L_0x0186:
        r1 = "MicroMsg.Imagegallery.handler.video";
        r2 = "check time[%d, %d], play time[%d, %d]";
        r3 = 4;
        r3 = new java.lang.Object[r3];
        r4 = r12.lastCheckTime;
        r4 = java.lang.Long.valueOf(r4);
        r3[r8] = r4;
        r4 = com.tencent.mm.sdk.platformtools.bg.Nz();
        r4 = java.lang.Long.valueOf(r4);
        r3[r9] = r4;
        r0 = java.lang.Integer.valueOf(r0);
        r3[r10] = r0;
        r0 = r12.vSK;
        r0 = java.lang.Integer.valueOf(r0);
        r3[r11] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        r0 = r12.lastCheckTime;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x003b;
    L_0x01b8:
        r0 = r12.lastCheckTime;
        r0 = com.tencent.mm.sdk.platformtools.bg.aA(r0);
        r2 = 1500; // 0x5dc float:2.102E-42 double:7.41E-321;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x003b;
    L_0x01c4:
        r0 = "MicroMsg.Imagegallery.handler.video";
        r1 = "play time not update! request all video data to play. ";
        com.tencent.mm.sdk.platformtools.w.w(r0, r1);
        r0 = r12.vPU;
        r0 = r0.bWL();
        r0 = r0.vTl;
        r0 = r0.getCurrentPosition();
        r12.bjn();
        r1 = r12.filename;
        r2 = r12.qvD;
        com.tencent.mm.modelvideo.t.d(r1, r0, r2);
        r0 = r12.vPU;
        r0 = r0.bWL();
        r0 = r0.vTl;
        r0.stop();
        r0 = r12.vSG;
        r0.bXA();
        r0 = r12.vRK;
        r1 = r12.filename;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.ui.chatting.gallery.i.a) r0;
        if (r0 == 0) goto L_0x003c;
    L_0x01ff:
        r1 = r0.fCZ;
        if (r1 == 0) goto L_0x003c;
    L_0x0203:
        r1 = r0.fCZ;
        r1 = bl(r1);
        r2 = r0.fCZ;
        r0 = r0.pos;
        r3 = r12.qvD;
        r12.a(r2, r1, r0, r3);
        r12.lastCheckTime = r6;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.i.b(com.tencent.mm.ui.chatting.gallery.j):boolean");
    }
}
