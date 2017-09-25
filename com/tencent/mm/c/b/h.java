package com.tencent.mm.c.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Message;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.t;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class h implements com.tencent.mm.compatible.b.e.a, com.tencent.mm.y.h {
    public a fAO = null;
    public b fAP;
    private a fAQ = null;
    private String fAR;
    private boolean fAS = false;
    private boolean fAT = false;
    public long fAU;
    public long fAV = 0;
    public int fAW = 0;
    public boolean fAX = false;
    public boolean fAY = false;
    public int fAZ = 0;
    private com.tencent.mm.compatible.b.b.a fBa = com.tencent.mm.compatible.b.b.a.UNKNOWN;
    protected com.tencent.mm.y.h.b fBb;
    protected com.tencent.mm.y.h.a fBc = null;
    private boolean fBd = false;
    private aj fBe = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ h fBf;

        {
            this.fBf = r1;
        }

        public final boolean oQ() {
            q.a(this.fBf.mFileName, this.fBf);
            m.LA().run();
            w.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + this.fBf.mFileName);
            return false;
        }
    }, true);
    public String mFileName = "";

    private final class a implements Runnable {
        final /* synthetic */ h fBf;
        ae handler;

        public a(final h hVar) {
            this.fBf = hVar;
            this.handler = new ae(this) {
                final /* synthetic */ a fBh;

                public final void handleMessage(Message message) {
                    if (this.fBh.fBf.fAZ > 0) {
                        w.d("MicroMsg.SceneVoice.Recorder", "On Part :" + (this.fBh.fBf.fBb == null));
                        this.fBh.fBf.fAZ = 2;
                        if (this.fBh.fBf.fBb != null) {
                            this.fBh.fBf.fBb.BF();
                        }
                    }
                }
            };
        }

        public final void run() {
            boolean z = true;
            synchronized (this.fBf) {
                if (this.fBf.fAO == null) {
                    w.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
                    return;
                }
                String str = this.fBf.mFileName;
                if (this.fBf.fAY) {
                    z = false;
                }
                w.d("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", q.E(str, z), Boolean.valueOf(this.fBf.fAY));
                if (this.fBf.fAO.bw(q.E(str, z))) {
                    this.fBf.fAP.requestFocus();
                } else {
                    q.ma(this.fBf.mFileName);
                    this.fBf.mFileName = null;
                    this.fBf.fAO = null;
                    w.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + this.fBf.mFileName + "]");
                }
                this.fBf.fAV = bg.NA();
                w.d("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + this.fBf.mFileName + "] time:" + bg.aB(this.fBf.fAU));
                this.handler.sendEmptyMessageDelayed(0, 1);
            }
        }
    }

    public h(Context context, boolean z) {
        this.fAP = new b(context);
        this.fAY = z;
        w.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", Boolean.valueOf(z));
    }

    public final void reset() {
        if (this.fAO != null) {
            this.fAO.oX();
            this.fAP.rY();
            w.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
        }
        this.mFileName = "";
        this.fAU = 0;
        this.fAQ = null;
        this.fBa = com.tencent.mm.compatible.b.b.a.UNKNOWN;
        this.fAZ = 0;
        this.fAV = 0;
    }

    public final int pl() {
        return this.fAW;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public final boolean pm() {
        if (this.fAO != null && this.fAO.getStatus() == 1) {
            return true;
        }
        return false;
    }

    public final int getMaxAmplitude() {
        if (this.fAO == null) {
            return 0;
        }
        return this.fAO.getMaxAmplitude();
    }

    public final boolean bx(String str) {
        w.i("MicroMsg.SceneVoice.Recorder", "Start Record to  " + str);
        reset();
        this.fAR = str;
        this.fAU = bg.NA();
        if (str == null) {
            w.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
            return false;
        }
        this.fAS = str.equals("_USER_FOR_THROWBOTTLE_");
        if (str.equals("medianote")) {
            if ((com.tencent.mm.u.m.xP() & 16384) == 0) {
                this.fAT = true;
            } else {
                this.fAT = false;
            }
        }
        if (!this.fAY) {
            if (this.fAS) {
                this.mFileName = u.mf(com.tencent.mm.u.m.xL());
            } else if (this.fAT) {
                this.mFileName = u.mf("medianote");
            }
            if (this.mFileName != null || this.mFileName.length() <= 0) {
                w.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
                return false;
            }
            e.qE().a(this);
            this.fAX = false;
            this.fBd = false;
            if (!e.qL() || e.qE().qI()) {
                po();
            } else {
                this.fBd = true;
                e.qE().qG();
                af.f(new Runnable(this) {
                    final /* synthetic */ h fBf;

                    {
                        this.fBf = r1;
                    }

                    public final void run() {
                        if (!this.fBf.fAX) {
                            w.d("MicroMsg.SceneVoice.Recorder", "after start bluetooth, timeout to directly start record");
                            this.fBf.po();
                        }
                    }
                }, 1000);
            }
            return true;
        }
        this.mFileName = q.lX(str);
        if (this.mFileName != null) {
        }
        w.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
        return false;
    }

    public final boolean cancel() {
        w.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
        synchronized (this) {
            w.d("MicroMsg.SceneVoice.Recorder", "stop synchronized Record :" + this.mFileName);
            if (this.fAO != null) {
                this.fAO.oX();
                this.fAP.rY();
            }
        }
        e.qE().b(this);
        if (this.fBd) {
            e.qE().qH();
            this.fBd = false;
        }
        q.lY(this.mFileName);
        m.LA().run();
        if (!(this.fAO == null || bg.mA(this.mFileName) || this.fAY)) {
            com.tencent.mm.compatible.g.a aVar = new com.tencent.mm.compatible.g.a();
            aVar.gSl = this.mFileName;
            aVar.gSm = pn();
            aVar.gSn = 1;
            aVar.fFG = this.fAO.oY();
            g.oUh.A(10513, aVar.rW());
        }
        this.mFileName = "";
        return true;
    }

    public boolean pd() {
        boolean z = true;
        boolean z2 = false;
        if (this.fBe != null) {
            this.fBe.KH();
            this.fBe.removeCallbacksAndMessages(null);
        }
        e.qE().b(this);
        if (this.fBd) {
            e.qE().qH();
            this.fBd = false;
        }
        this.fAW = (int) pn();
        w.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", this.mFileName, Integer.valueOf(this.fAW));
        if (!(this.fAO == null || bg.mA(this.mFileName) || this.fAY)) {
            com.tencent.mm.compatible.g.a aVar = new com.tencent.mm.compatible.g.a();
            aVar.gSl = this.mFileName;
            aVar.gSm = (long) this.fAW;
            aVar.gSn = 2;
            aVar.fFG = this.fAO.oY();
            g.oUh.A(10513, aVar.rW());
        }
        synchronized (this) {
            w.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s", this.mFileName, this.fAO);
            if (this.fAO != null) {
                this.fAO.oX();
                this.fAP.rY();
            }
        }
        if (this.fAZ != 2) {
            q.ma(this.mFileName);
            this.mFileName = null;
            w.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + bg.aB(this.fAU));
        } else {
            if (((long) this.fAW) < 800 || (this.fAS && ((long) this.fAW) < 1000)) {
                w.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.fAW);
                q.ma(this.mFileName);
                this.mFileName = "";
                z = false;
            } else {
                q.K(this.mFileName, this.fAW);
                m.LA().run();
                w.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
            }
            this.mFileName = "";
            z2 = z;
        }
        this.fAZ = -1;
        return z2;
    }

    public final long pn() {
        if (this.fAV == 0) {
            return 0;
        }
        return bg.aB(this.fAV);
    }

    public final void cW(int i) {
        w.d("MicroMsg.SceneVoice.Recorder", "dkbt Recorder onBluetoothHeadsetStateChange :" + i);
        if (i == 1) {
            po();
        }
    }

    public final void po() {
        if (!this.fAX) {
            this.fAX = true;
            if (this.fAY) {
                this.fBa = com.tencent.mm.compatible.b.b.a.SPEEX;
                this.fAO = new k();
            } else {
                boolean z;
                SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences(ab.bIX(), 0);
                if (p.gRd.gNV == 1) {
                    z = false;
                } else {
                    z = true;
                }
                if (!sharedPreferences.contains("settings_voicerecorder_mode")) {
                    sharedPreferences.edit().putBoolean("settings_voicerecorder_mode", z).commit();
                }
                w.i("AudioConfig", "getModeByConfig mVoiceRecordMode:%d defValue:%b settings_voicerecorder_mode:%b", Integer.valueOf(p.gRd.gNV), Boolean.valueOf(z), Boolean.valueOf(sharedPreferences.getBoolean("settings_voicerecorder_mode", z)));
                this.fBa = sharedPreferences.getBoolean("settings_voicerecorder_mode", z) ? com.tencent.mm.compatible.b.b.a.PCM : com.tencent.mm.compatible.b.b.a.AMR;
                String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("VoiceFormat");
                String value2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("VoiceFormatToQQ");
                if (this.fBa == com.tencent.mm.compatible.b.b.a.PCM) {
                    if (4 == bg.getInt(value, 4) && g.b.pk()) {
                        this.fBa = com.tencent.mm.compatible.b.b.a.SILK;
                    }
                    if (this.fAR != null && this.fAR.endsWith("@qqim")) {
                        this.fBa = com.tencent.mm.compatible.b.b.a.AMR;
                    }
                }
                if (this.fBa == com.tencent.mm.compatible.b.b.a.PCM) {
                    w.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode, still in pcm mode, force to amr mode");
                    this.fBa = com.tencent.mm.compatible.b.b.a.AMR;
                }
                w.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode dynamicFormat:%s dynamicFormatQQ:%s recdMode:%s isSilkSoLoadSuccess:%b", value, value2, this.fBa, Boolean.valueOf(g.b.pk()));
                this.fAO = new t(this.fBa);
            }
            com.tencent.mm.y.h.a anonymousClass3 = new com.tencent.mm.y.h.a(this) {
                final /* synthetic */ h fBf;

                {
                    this.fBf = r1;
                }

                public final void onError() {
                    this.fBf.fAP.rY();
                    w.e("MicroMsg.SceneVoice.Recorder", "Record Failed file:" + this.fBf.mFileName);
                    q.ma(this.fBf.mFileName);
                    if (this.fBf.fBc != null) {
                        this.fBf.fBc.onError();
                    }
                }
            };
            if (this.fAO != null) {
                this.fAO.a(anonymousClass3);
            }
            this.fAQ = new a(this);
            com.tencent.mm.sdk.f.e.post(this.fAQ, "SceneVoiceRecorder_record");
            this.fAZ = 1;
            this.fBe.v(3000, 3000);
            w.d("MicroMsg.SceneVoice.Recorder", "start end time:" + bg.aB(this.fAU));
        }
    }

    public final void a(com.tencent.mm.y.h.a aVar) {
        this.fBc = aVar;
    }

    public final void a(com.tencent.mm.y.h.b bVar) {
        this.fBb = bVar;
    }

    public final int pp() {
        if (this.fAY) {
            return 1;
        }
        if (this.fBa == com.tencent.mm.compatible.b.b.a.PCM || this.fBa == com.tencent.mm.compatible.b.b.a.AMR) {
            return 0;
        }
        if (this.fBa == com.tencent.mm.compatible.b.b.a.SILK) {
            return 2;
        }
        return -1;
    }
}
