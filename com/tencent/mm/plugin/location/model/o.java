package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l.q;
import com.tencent.mm.protocal.c.auk;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.protocal.c.biq;
import com.tencent.mm.protocal.c.qb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o implements q, e {
    public boolean fOV = false;
    public boolean fyL = false;
    public com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ o ncq;

        {
            this.ncq = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            w.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d)});
            if (this.ncq.ncm) {
                this.ncq.ncm = false;
                this.ncq.nco = System.currentTimeMillis();
                long j = this.ncq.nco - this.ncq.ncn;
                w.d("MicorMsg.TrackRefreshManager", "locate time:%d", new Object[]{Long.valueOf(j)});
                g.oUh.i(10997, new Object[]{PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "", Integer.valueOf(0), Long.valueOf(j)});
            }
            if (!(this.ncq.ncd == null || this.ncq.ncd.uiu == null)) {
                this.ncq.ncd.uiu.tle = (double) f2;
                this.ncq.ncd.uiu.tld = (double) f;
            }
            return true;
        }
    };
    public c hvP;
    private int kBd;
    ae mHandler = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ o ncq;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                o oVar = this.ncq;
                switch (message.what) {
                    case 1:
                        oVar.aGo();
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private String naM;
    public double naO = -1000.0d;
    public double naP = -1000.0d;
    private int nbY = 0;
    private int nbZ = 1000;
    public i nca;
    public HashSet<WeakReference<b>> ncb = new HashSet();
    public int ncc = 1;
    public biq ncd;
    public LocationInfo nce = new LocationInfo((byte) 0);
    public boolean ncf = false;
    public boolean ncg = false;
    public int nch = this.ncc;
    public String nci = "";
    boolean ncj = false;
    public a nck = null;
    public int ncl = -1;
    public boolean ncm = true;
    public long ncn = 0;
    public long nco = 0;
    public com.tencent.mm.plugin.location.model.i.a ncp = new com.tencent.mm.plugin.location.model.i.a(this) {
        final /* synthetic */ o ncq;

        {
            this.ncq = r1;
        }

        public final void h(double d) {
            if (this.ncq.ncd != null) {
                this.ncq.ncd.uiu.tVp = d;
            }
        }
    };
    public int zoom = -1;

    public interface a {
        void aGq();
    }

    public interface b {
        void a(auk com_tencent_mm_protocal_c_auk);

        void aGr();

        void aGs();

        void onError(int i, String str);
    }

    public final void stop() {
        w.i("MicorMsg.TrackRefreshManager", "stop location");
        if (this.hvP != null) {
            this.hvP.c(this.gKp);
        }
        if (this.nca != null) {
            this.nca.b(this.ncp);
        }
        ap.vd().b(492, this);
        ap.vd().b(490, this);
        ap.vd().b(491, this);
        this.ncc = 1;
        this.fOV = false;
        this.ncl = -1;
        m aGh = l.aGh();
        w.d("MicroMsg.TrackAvatarCacheService", "clearCache");
        for (String str : aGh.nbX.snapshot().keySet()) {
            Bitmap bitmap = (Bitmap) aGh.nbX.get(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        }
        aGh.nbX.trimToSize(-1);
    }

    public final boolean aGj() {
        return aGp() && this.ncf;
    }

    public final void oD(int i) {
        w.i("MicorMsg.TrackRefreshManager", "track endTrack");
        if (aGp()) {
            String str = this.naM;
            w.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", new Object[]{Integer.valueOf(i)});
            k aVar = new com.tencent.mm.plugin.location.model.a.a(str);
            ((qb) aVar.gUA.hsj.hsr).tdM = i;
            ap.vd().a(aVar, 0);
            this.naM = "";
        }
        if (!bg.mA(this.nci)) {
            com.tencent.mm.plugin.location.a.a zr = l.aGf().zr(this.nci);
            if (zr != null) {
                zr.fPA.remove(m.xL());
                l.aGf().a(this.nci, zr.fPA, zr.latitude, zr.longitude, zr.naK, null, null);
            }
        }
        l.aGf().zt("");
        this.naM = "";
        this.nci = "";
        this.ncf = false;
        this.ncg = false;
        this.naO = -1000.0d;
        this.naP = -1000.0d;
        this.zoom = -1;
        this.ncl = -1;
    }

    public final void aGk() {
        w.d("MicorMsg.TrackRefreshManager", "resume refresh");
        this.ncj = false;
        w.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
        if (aGp()) {
            w.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
            this.hvP = c.Gk();
            this.hvP.b(this.gKp, true);
            if (this.nca == null) {
                this.nca = l.aGg();
            }
            this.nca.a(this.ncp);
            aGo();
        }
    }

    public final String aGl() {
        return this.nci;
    }

    public final List<String> aGm() {
        return l.aGf().zq(this.nci);
    }

    public final void aGn() {
        if (this.ncc == 1) {
            this.ncc = 3;
        } else if (this.ncc == 3) {
            this.ncc = 2;
        }
    }

    public final void aGo() {
        boolean z = true;
        String str;
        if (!this.fOV || !this.ncf || this.nce == null) {
            str = "MicorMsg.TrackRefreshManager";
            StringBuilder append = new StringBuilder("error to exit refresh isStart: ").append(this.fOV).append(" isShared: ").append(this.ncf).append(" ");
            if (this.nce != null) {
                z = false;
            }
            w.e(str, append.append(z).toString());
        } else if (this.ncd == null || this.ncd.uiu.tle == -1000.0d || this.ncd.uiu.tld == -1000.0d) {
            w.e("MicorMsg.TrackRefreshManager", "error to get my location ");
            this.mHandler.sendEmptyMessageDelayed(1, (long) this.nbZ);
        } else {
            String xL = m.xL();
            bfj com_tencent_mm_protocal_c_bfj = new bfj();
            com_tencent_mm_protocal_c_bfj.tTU = this.nce.naQ;
            com_tencent_mm_protocal_c_bfj.tle = this.nce.naO;
            com_tencent_mm_protocal_c_bfj.tld = this.nce.naP;
            com_tencent_mm_protocal_c_bfj.msj = xL;
            this.ncd.tgG = xL;
            this.ncd.uiu.tVp = l.aGg().aFX();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("refreshLoopImpl, [trackRoomId:" + this.naM + "]");
            switch (this.ncc) {
                case 0:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUpload ");
                    break;
                case 1:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomDownload ");
                    break;
                case 2:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
                    break;
                case 3:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomFirstUpload ");
                    stringBuffer.append("[ trackItem " + com_tencent_mm_protocal_c_bfj.tle + " " + com_tencent_mm_protocal_c_bfj.tld + " ]");
                    break;
            }
            stringBuffer.append("[ mMyPosiItem " + this.ncd.uiu.tle + " " + this.ncd.uiu.tld + " " + this.ncd.uiu.tVp + " ]");
            w.d("MicorMsg.TrackRefreshManager", stringBuffer.toString());
            str = this.naM;
            int i = this.ncc;
            biq com_tencent_mm_protocal_c_biq = this.ncd;
            int i2 = this.kBd + 1;
            this.kBd = i2;
            ap.vd().a(new com.tencent.mm.plugin.location.model.a.c(str, i, com_tencent_mm_protocal_c_biq, i2, com_tencent_mm_protocal_c_bfj), 0);
        }
    }

    public final boolean aGp() {
        return !bg.mA(this.naM);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        WeakReference weakReference;
        if (kVar.getType() == 490) {
            Iterator it;
            if (i2 == 0 || i2 >= 1000) {
                this.naM = ((com.tencent.mm.plugin.location.model.a.b) kVar).naM;
                l.aGf().zt(this.naM);
                if (aGp()) {
                    w.i("MicorMsg.TrackRefreshManager", "join sucess %s", new Object[]{this.naM});
                    LinkedList zq = com.tencent.mm.pluginsdk.l.a.sBy.zq(this.nci);
                    zq.add(m.xL());
                    if (this.nce != null) {
                        com.tencent.mm.pluginsdk.l.a.sBy.a(this.nci, zq, this.nce.naO, this.nce.naP, this.nce.naQ, "", "");
                    } else {
                        com.tencent.mm.pluginsdk.l.a.sBy.a(this.nci, zq, -1000.0d, -1000.0d, "", "", "");
                    }
                    if (this.ncb != null) {
                        it = this.ncb.iterator();
                        while (it.hasNext()) {
                            weakReference = (WeakReference) it.next();
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((b) weakReference.get()).aGr();
                            }
                        }
                    }
                    aGo();
                    return;
                }
                return;
            }
            if (i2 == 17 && this.ncb != null) {
                it = this.ncb.iterator();
                while (it.hasNext()) {
                    weakReference = (WeakReference) it.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((b) weakReference.get()).aGs();
                    }
                }
            }
            if (this.ncb != null) {
                Iterator it2 = this.ncb.iterator();
                while (it2.hasNext()) {
                    weakReference = (WeakReference) it2.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((b) weakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b) kVar).kAZ);
                    }
                }
            }
        } else if (i == 0 && i2 == 0) {
            if (kVar.getType() == 492) {
                r0 = ((com.tencent.mm.plugin.location.model.a.c) kVar).ncz;
                if (!(r0 == null || r0.tZe == null)) {
                    if (r0.tZe.thX == 12) {
                        this.fyL = true;
                        if (this.nck != null) {
                            this.nck.aGq();
                        }
                    } else {
                        this.fyL = false;
                    }
                    w.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", new Object[]{Boolean.valueOf(this.fyL), Integer.valueOf(r0.tZe.thX)});
                }
                if (this.nbY > 0) {
                    g.oUh.i(10997, new Object[]{"9", "", Integer.valueOf(this.nbY), Integer.valueOf(0)});
                }
                this.nbY = 0;
                this.nbZ = ((com.tencent.mm.plugin.location.model.a.c) kVar).ncw;
                int i3 = ((com.tencent.mm.plugin.location.model.a.c) kVar).ncA;
                if (this.ncb != null && (i3 == 2 || i3 == 1 || i3 == 3)) {
                    Iterator it3 = this.ncb.iterator();
                    while (it3.hasNext()) {
                        weakReference = (WeakReference) it3.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((b) weakReference.get()).a(((com.tencent.mm.plugin.location.model.a.c) kVar).ncz);
                        }
                    }
                }
                if (!(this.ncc == 1)) {
                    aGn();
                }
                this.mHandler.removeMessages(1);
                if (aGp() && !this.ncj && !this.fyL) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.nbZ);
                }
            } else if (kVar.getType() == 491) {
                l.aGf().zt("");
            }
        } else if (kVar.getType() == 492) {
            this.nbY++;
            this.mHandler.removeMessages(1);
            if (this.nbY >= 10) {
                this.mHandler.removeMessages(1);
                if (this.ncb != null) {
                    Iterator it4 = this.ncb.iterator();
                    while (it4.hasNext()) {
                        weakReference = (WeakReference) it4.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((b) weakReference.get()).onError(1, ((com.tencent.mm.plugin.location.model.a.c) kVar).kAZ);
                        }
                    }
                }
            } else if (aGp() && !this.ncj) {
                r0 = ((com.tencent.mm.plugin.location.model.a.c) kVar).ncz;
                if (!(r0 == null || r0.tZe == null)) {
                    if (r0.tZe.thX == 12) {
                        this.fyL = true;
                        if (this.nck != null) {
                            this.nck.aGq();
                        }
                    } else {
                        this.fyL = false;
                    }
                    w.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", new Object[]{Boolean.valueOf(this.fyL), Integer.valueOf(r0.tZe.thX)});
                }
                if (!this.fyL) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.nbZ);
                }
            }
        }
    }
}
