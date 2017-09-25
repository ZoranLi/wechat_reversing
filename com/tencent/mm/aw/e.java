package com.tencent.mm.aw;

import android.os.Message;
import com.tencent.mm.c.b.c;
import com.tencent.mm.c.c.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.k;
import java.io.File;

public final class e implements com.tencent.mm.y.e {
    public static int fBC = 100;
    private static final String icS = (w.hgq + "tmp_voiceaddr.spx");
    private static final String icT = (w.hgq + "tmp_voiceaddr.amr");
    public com.tencent.mm.c.b.c.a fAe = new com.tencent.mm.c.b.c.a(this) {
        final /* synthetic */ e idd;

        {
            this.idd = r1;
        }

        public final void d(byte[] bArr, int i) {
            int i2;
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", Integer.valueOf(i));
            com.tencent.qqpinyin.voicerecoapi.c.a aVar = new com.tencent.qqpinyin.voicerecoapi.c.a();
            short[] sArr = new short[(i / 2)];
            for (i2 = 0; i2 < i / 2; i2++) {
                sArr[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            }
            if (this.idd.idb != null) {
                this.idd.idb.a(sArr, i / 2, aVar);
            }
            e eVar = this.idd;
            int i3 = i / 2;
            for (i2 = 0; i2 < i3; i2++) {
                short s = sArr[i2];
                if (s > eVar.icU) {
                    eVar.icU = s;
                }
            }
            if (this.idd.ida != null) {
                i2 = this.idd.ida.a(new com.tencent.mm.c.b.g.a(bArr, i), 0);
            } else {
                i2 = -1;
            }
            if (-1 == i2) {
                this.idd.finish();
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SceneVoiceAddr", "write to file failed");
                return;
            }
            e eVar2 = this.idd;
            eVar2.icV = i2 + eVar2.icV;
            if (this.idd.icV > 3300 && !this.idd.icW) {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
                this.idd.handler.sendEmptyMessage(0);
                this.idd.icW = true;
            }
            if (aVar.wPH == 2 || aVar.wPH == 3) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + aVar.wPH);
                this.idd.finish();
            }
        }

        public final void ax(int i, int i2) {
        }
    };
    c fzv;
    ae handler = new ae(this) {
        final /* synthetic */ e idd;

        {
            this.idd = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what == 2) {
                if (this.idd.icZ != null) {
                    this.idd.icZ.LP();
                }
            } else if (message.what == 0) {
                if (this.idd.icN == 0) {
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
                    h.vd().a(349, this.idd);
                } else {
                    h.vd().a((int) v.CTRL_INDEX, this.idd);
                }
                if (this.idd.icN != 0) {
                    this.idd.idc = new c(this.idd.LN(), this.idd.icN);
                } else if (this.idd.icY) {
                    this.idd.idc = new d(this.idd.LN(), 1);
                } else {
                    this.idd.idc = new d(this.idd.LN(), 0);
                }
                h.vd().a(this.idd.idc, 0);
            } else if (message.what == 3 && this.idd.icZ != null) {
                this.idd.icZ.a(new String[0], -1);
            }
        }
    };
    public int icN = 1;
    public int icU = 0;
    int icV = 0;
    boolean icW = false;
    public int icX = 500000;
    public boolean icY = false;
    b icZ = null;
    com.tencent.mm.c.c.a ida;
    com.tencent.qqpinyin.voicerecoapi.c idb = null;
    public a idc = null;

    class a implements Runnable {
        final /* synthetic */ e idd;

        public a(e eVar) {
            this.idd = eVar;
        }

        public final void run() {
            synchronized (this.idd) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
                try {
                    new File(this.idd.LN()).delete();
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + this.idd.LN(), e);
                }
                this.idd.fzv = new c(this.idd.icY ? 8000 : 16000, 3);
                this.idd.fzv.fzT = -19;
                this.idd.fzv.as(false);
                if (!this.idd.icY) {
                    this.idd.ida = new d();
                    if (!this.idd.ida.bz(this.idd.LN())) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                        this.idd.ida.ps();
                        this.idd.ida = null;
                    }
                }
                if (this.idd.icY || p.gRl.gPY <= 0) {
                    this.idd.fzv.r(5, false);
                } else {
                    this.idd.fzv.r(p.gRl.gPY, true);
                }
                this.idd.fzv.at(false);
                this.idd.idb = new com.tencent.qqpinyin.voicerecoapi.c(this.idd.icX);
                int start = this.idd.idb.start();
                if (start != 0) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :" + start);
                    this.idd.reset();
                } else {
                    this.idd.fzv.fAe = this.idd.fAe;
                    if (!this.idd.fzv.pf()) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SceneVoiceAddr", "start record failed");
                        this.idd.reset();
                    }
                }
            }
        }
    }

    public interface b {
        void LO();

        void LP();

        void a(String[] strArr, long j);
    }

    public e(b bVar, int i) {
        int i2 = 500000;
        this.icZ = bVar;
        this.icN = i;
        if (this.icN != 1) {
            i2 = 1500000;
        }
        this.icX = i2;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.icN == 0) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
            h.vd().b(349, (com.tencent.mm.y.e) this);
        } else {
            h.vd().b((int) v.CTRL_INDEX, (com.tencent.mm.y.e) this);
        }
        String[] LH = ((a) kVar).LH();
        long LI = ((a) kVar).LI();
        String str2 = "MicroMsg.SceneVoiceAddr";
        String str3 = "onSceneEnd errType:%d errCode:%d list:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(LH == null ? -1 : LH.length);
        com.tencent.mm.sdk.platformtools.w.i(str2, str3, objArr);
        if (this.icZ == null) {
            return;
        }
        if (i2 == 0 && i == 0) {
            this.icZ.a(LH, LI);
            return;
        }
        this.icZ.LO();
        cancel();
    }

    public final void finish() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SceneVoiceAddr", "finish");
        com.tencent.mm.sdk.platformtools.w.j("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
        if (this.idc != null) {
            this.idc.LG();
        }
        this.handler.sendEmptyMessage(2);
        if (!this.icW) {
            this.handler.sendEmptyMessage(3);
        }
        reset();
    }

    public final void cancel() {
        this.icZ = null;
        finish();
    }

    public final String LN() {
        if (this.icY) {
            return icT;
        }
        return icS;
    }

    public final void reset() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SceneVoiceAddr", "reset");
        synchronized (this) {
            if (this.fzv != null) {
                this.fzv.oX();
                this.fzv = null;
            }
            if (this.ida != null) {
                this.ida.ps();
                this.ida = null;
            }
            if (this.idb != null) {
                this.idb.stop();
            }
            this.idb = null;
            if (this.idc != null) {
                this.idc.LG();
                this.idc = null;
            }
            this.icV = 0;
            this.icW = false;
        }
    }
}
