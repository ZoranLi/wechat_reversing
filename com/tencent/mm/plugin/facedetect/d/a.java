package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.c.b.c;
import com.tencent.mm.c.c.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    public static final String lwY = (o.arS() + File.separator + "fdv_v_");
    public static final String lxd = (h.getExternalStorageDirectory().getAbsolutePath() + "/temp_debug_raw.spx");
    public com.tencent.mm.c.b.c.a fAe = new com.tencent.mm.c.b.c.a(this) {
        short[] idi;
        final /* synthetic */ a lxf;

        {
            this.lxf = r1;
        }

        public final void d(byte[] bArr, int i) {
            int i2;
            w.d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", new Object[]{Integer.valueOf(i)});
            if (this.idi == null || this.idi.length < i / 2) {
                this.idi = new short[(i / 2)];
            }
            for (i2 = 0; i2 < i / 2; i2++) {
                this.idi[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            }
            a aVar = this.lxf;
            short[] sArr = this.idi;
            int i3 = i / 2;
            for (i2 = 0; i2 < i3; i2++) {
                short s = sArr[i2];
                if (s > aVar.icU) {
                    aVar.icU = s;
                }
            }
            if (this.lxf.idg != null) {
                this.lxf.idg.c(this.idi, i / 2);
                if (this.lxf.ida != null) {
                    i2 = this.lxf.ida.a(new com.tencent.mm.c.b.g.a(bArr, i), 0);
                } else {
                    i2 = -1;
                }
                if (-1 == i2 && this.lxf.lwZ != null) {
                    this.lxf.lwZ.onError(3);
                    this.lxf.arV();
                    w.e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
                    return;
                }
                return;
            }
            if (this.lxf.lwZ != null) {
                this.lxf.lwZ.onError(1);
                this.lxf.arV();
            }
            w.e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
        }

        public final void ax(int i, int i2) {
            w.e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + i + " detailState = " + i2);
            this.lxf.arV();
            if (this.lxf.lwZ != null) {
                this.lxf.lwZ.onError(2);
            }
        }
    };
    public c fzv;
    int icU = 0;
    int icV = 0;
    boolean idC = true;
    public com.tencent.mm.c.c.a ida;
    public com.tencent.mm.aw.a.c idg;
    public com.tencent.mm.aw.a.c.a idh = new com.tencent.mm.aw.a.c.a(this) {
        final /* synthetic */ a lxf;

        {
            this.lxf = r1;
        }

        public final void a(short[] sArr, int i) {
            w.d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", new Object[]{sArr, Integer.valueOf(i)});
        }

        public final void LR() {
            w.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
        }

        public final void LS() {
            w.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
            if (this.lxf.lwZ != null) {
                this.lxf.lwZ.arW();
            }
        }

        public final void LT() {
            w.d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
            if (this.lxf.lwZ != null) {
                this.lxf.lwZ.onError(11);
            }
        }
    };
    public b lwZ = null;
    public boolean lxa = false;
    public String lxb = "";
    public ArrayList<com.tencent.mm.c.b.c.a> lxc = new ArrayList(5);
    public com.tencent.mm.c.b.c.a lxe = new com.tencent.mm.c.b.c.a(this) {
        final /* synthetic */ a lxf;

        {
            this.lxf = r1;
        }

        public final void d(byte[] bArr, int i) {
            if (this.lxf.lxc != null) {
                Iterator it = this.lxf.lxc.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.c.b.c.a aVar = (com.tencent.mm.c.b.c.a) it.next();
                    if (aVar != null) {
                        aVar.d(bArr, i);
                    }
                }
            }
        }

        public final void ax(int i, int i2) {
            if (this.lxf.lxc != null) {
                Iterator it = this.lxf.lxc.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.c.b.c.a aVar = (com.tencent.mm.c.b.c.a) it.next();
                    if (aVar != null) {
                        aVar.ax(i, i2);
                    }
                }
            }
        }
    };

    private class a implements Runnable {
        final /* synthetic */ a lxf;
        private Runnable lxg = null;

        public a(a aVar, Runnable runnable) {
            this.lxf = aVar;
            this.lxg = runnable;
        }

        public final void run() {
            synchronized (this.lxf) {
                if (this.lxf.lxa) {
                    w.w("MicroMsg.FaceVoiceRecordLogic", "hy: already called stop. should not start record");
                } else {
                    w.i("MicroMsg.FaceVoiceRecordLogic", "hy: initDeviceInLock");
                    this.lxf.lxb = a.lwY + bg.NA() + ".spx";
                    try {
                        new File(this.lxf.lxb).delete();
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e, "hy: delete file failed", new Object[0]);
                    }
                    this.lxf.fzv = new c(16000, 3);
                    this.lxf.fzv.fzT = -19;
                    this.lxf.fzv.as(false);
                    this.lxf.ida = new d();
                    if (this.lxf.ida.bz(this.lxf.lxb)) {
                        if (p.gRl.gPY > 0) {
                            this.lxf.fzv.r(p.gRl.gPY, true);
                        } else {
                            this.lxf.fzv.r(5, false);
                        }
                        this.lxf.fzv.cY(50);
                        this.lxf.fzv.at(false);
                        try {
                            this.lxf.idg = new com.tencent.mm.aw.a.c(Downloads.MIN_RETYR_AFTER, 16000, com.tencent.mm.aw.a.c.hgx.getInt("sil_time", m.CTRL_INDEX), com.tencent.mm.aw.a.c.hgx.getFloat("s_n_ration", 2.5f), com.tencent.mm.aw.a.c.hgx.getInt("s_window", 50), com.tencent.mm.aw.a.c.hgx.getInt("s_length", 35), com.tencent.mm.aw.a.c.hgx.getInt("s_delay_time", 20), false, false);
                            this.lxf.idg.idL = this.lxf.idh;
                        } catch (Throwable e2) {
                            w.e("MicroMsg.FaceVoiceRecordLogic", "hy: init VoiceDetectAPI failed :" + e2.getMessage());
                            if (this.lxf.lwZ != null) {
                                this.lxf.lwZ.onError(6);
                            }
                        }
                        this.lxf.fzv.fAe = this.lxf.lxe;
                        this.lxf.a(this.lxf.fAe);
                        if (!this.lxf.fzv.pf()) {
                            w.e("MicroMsg.FaceVoiceRecordLogic", "hy: start record failed");
                            if (this.lxf.lwZ != null) {
                                this.lxf.lwZ.onError(7);
                            }
                        } else if (this.lxg != null) {
                            this.lxg.run();
                        }
                    } else {
                        w.e("MicroMsg.FaceVoiceRecordLogic", "hy: init speex writer failed");
                        this.lxf.ida.ps();
                        this.lxf.ida = null;
                        if (this.lxf.lwZ != null) {
                            this.lxf.lwZ.onError(5);
                        }
                    }
                }
            }
        }
    }

    public interface b {
        void arW();

        void onError(int i);
    }

    public final void arV() {
        com.tencent.mm.loader.stub.b.deleteFile(this.lxb);
    }

    public final void a(com.tencent.mm.c.b.c.a aVar) {
        this.lxc.add(aVar);
    }
}
