package com.tencent.mm.c.a;

import android.content.Context;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.modelvoice.j;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.g;
import com.tencent.mm.y.g.b;
import junit.framework.Assert;

public final class a implements com.tencent.mm.compatible.b.e.a, g {
    public static String fyY = null;
    public Context context;
    private d fyP;
    public boolean fyQ;
    private boolean fyR;
    public boolean fyS;
    private int fyT;
    private boolean fyU;
    public boolean fyV;
    public boolean fyW;
    public String fyX;
    private com.tencent.mm.compatible.util.b.a fyZ;
    public b fza;
    public com.tencent.mm.y.g.a fzb;

    public a(Context context) {
        this(context, 0);
    }

    public a(Context context, int i) {
        this.fyP = null;
        this.context = null;
        this.fyQ = false;
        this.fyR = false;
        this.fyS = false;
        this.fyT = 0;
        this.fyU = false;
        this.fyV = false;
        this.fyW = true;
        this.fyX = null;
        this.fyZ = new com.tencent.mm.compatible.util.b.a(this) {
            final /* synthetic */ a fzc;

            {
                this.fzc = r1;
            }

            public final void cX(int i) {
                w.i("MicroMsg.SceneVoicePlayer", "on audio focus chage: %s", Integer.valueOf(i));
                if (i == -2 || i == -3) {
                    if (this.fzc.isPlaying()) {
                        w.v("MicroMsg.SceneVoicePlayer", "alvinluo current fileName: %s, lastFileName: %s", this.fzc.fyX, a.fyY);
                        if (this.fzc.fyX == null || this.fzc.fyX.equals(a.fyY)) {
                            this.fzc.ao(false);
                        }
                    }
                } else if (i == 1 || i == 2 || i == 3) {
                    this.fzc.oR();
                } else if (i == -1) {
                    this.fzc.ap(false);
                }
            }
        };
        this.fza = null;
        this.context = context;
        this.fyT = i;
        com.tencent.mm.c.b.g.b bVar = new com.tencent.mm.c.b.g.b();
    }

    public final boolean isPlaying() {
        if (this.fyP == null) {
            return false;
        }
        return this.fyP.isPlaying();
    }

    public final boolean a(String str, boolean z, boolean z2, int i) {
        w.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(this.fyT));
        Assert.assertTrue(str.length() > 0);
        fyY = this.fyX;
        this.fyX = str;
        String str2;
        if (FileOp.aO(z2 ? str : q.js(str))) {
            if (i == -1) {
                i = o.e(str, this.fyT, z2);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.fyP = new s(this.context);
                } else {
                    this.fyP = new s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.fyP = new j(this.context);
                } else {
                    this.fyP = new j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.fyP = new i(this.context);
                } else {
                    this.fyP = new i();
                }
            }
            if (this.fyP != null) {
                this.fyP.b(this.fyZ);
            }
            this.fyQ = z;
            this.fyU = z;
            if (e.qE().qO() || e.qE().qI()) {
                w.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(e.qE().qO()), Boolean.valueOf(e.qE().qI()));
                this.fyQ = false;
            }
            e.qE().c(this.fyQ, false);
            oT();
            setError();
            str2 = null;
            if (z2) {
                str2 = str;
            } else if (this.fyT == 0) {
                str2 = q.js(str);
            }
            e.qE().a(this);
            if (!e.qE().qO()) {
                e.qE().qG();
                this.fyV = true;
            }
            if (this.fyP.C(str2, this.fyQ)) {
                return true;
            }
            w.i("MicroMsg.SceneVoicePlayer", "start play error fileName[" + str + "], [" + z + "]");
            e.qE().qH();
            this.fyV = false;
            return false;
        }
        str2 = "MicroMsg.SceneVoicePlayer";
        String str3 = "start, file %s not exist!, fullPath: %s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (!z2) {
            str = q.js(str);
        }
        objArr[1] = str;
        w.e(str2, str3, objArr);
        return false;
    }

    public final boolean a(String str, boolean z, int i, int i2) {
        w.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.valueOf(true), Integer.valueOf(i), Integer.valueOf(this.fyT));
        Assert.assertTrue(str.length() > 0);
        if (FileOp.aO(str)) {
            if (i == -1) {
                i = o.e(str, this.fyT, true);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.fyP = new s(this.context);
                } else {
                    this.fyP = new s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.fyP = new j(this.context);
                } else {
                    this.fyP = new j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.fyP = new i(this.context);
                } else {
                    this.fyP = new i();
                }
            }
            if (this.fyP != null) {
                this.fyP.b(this.fyZ);
            }
            this.fyQ = z;
            this.fyU = z;
            if (e.qE().qO() || e.qE().qI()) {
                w.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(e.qE().qO()), Boolean.valueOf(e.qE().qI()));
                this.fyQ = false;
            }
            e.qE().c(this.fyQ, false);
            oT();
            setError();
            e.qE().a(this);
            if (!e.qE().qO()) {
                e.qE().qG();
                this.fyV = true;
            }
            if (this.fyP.c(str, this.fyQ, i2)) {
                return true;
            }
            w.i("MicroMsg.SceneVoicePlayer", "start play fileName[" + str + "], [" + z + "]");
            e.qE().qH();
            this.fyV = false;
            return false;
        }
        w.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", str, str);
        return false;
    }

    public final boolean pause() {
        return ao(true);
    }

    public final boolean ao(boolean z) {
        if (this.fyP == null) {
            return false;
        }
        boolean ao;
        w.i("MicroMsg.SceneVoicePlayer", "pause");
        if (this.fyP.isPlaying()) {
            ao = this.fyP.ao(z);
        } else {
            ao = false;
        }
        if (ao && this.fyV) {
            e.qE().qH();
            this.fyV = false;
        }
        e.qE().setMode(0);
        return ao;
    }

    public final boolean oR() {
        if (this.fyP == null) {
            return false;
        }
        w.i("MicroMsg.SceneVoicePlayer", "resume");
        boolean oR = this.fyP.oR();
        if (oR) {
            e.qE().qG();
            this.fyV = true;
            if (e.qE().qI()) {
                this.fyQ = false;
            }
            e.qE().c(this.fyQ, false);
        }
        return oR;
    }

    public final boolean h(String str, boolean z) {
        return a(str, z, false, -1);
    }

    public final boolean oS() {
        return this.fyR;
    }

    public final void stop() {
        ap(false);
    }

    public final void ap(boolean z) {
        if (this.fyP != null) {
            w.i("MicroMsg.SceneVoicePlayer", "stop, isRequestStartBluetooth: %b, player.isPlaying: %b, fromStart: %b", Boolean.valueOf(this.fyV), Boolean.valueOf(this.fyP.isPlaying()), Boolean.valueOf(z));
            this.fyP.pd();
            e.qE().b(this);
            if (this.fyV && !z) {
                e.qE().qH();
                this.fyV = false;
            }
            e.qE().setMode(0);
        }
    }

    public final void aq(boolean z) {
        if (this.fyQ != z) {
            this.fyQ = z;
            if (this.fyP != null && this.fyP.isPlaying()) {
                this.fyP.aq(z);
            }
            e.qE().c(z, false);
        }
    }

    public final void a(b bVar) {
        this.fza = bVar;
    }

    private void setError() {
        d.b anonymousClass2 = new d.b(this) {
            final /* synthetic */ a fzc;

            {
                this.fzc = r1;
            }

            public final void onError() {
                e.qE().b(this.fzc);
                if (this.fzc.fyV) {
                    e.qE().qH();
                    this.fzc.fyV = false;
                }
                e.qE().setMode(0);
                if (this.fzc.fza != null) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 fzd;

                        {
                            this.fzd = r1;
                        }

                        public final void run() {
                            this.fzd.fzc.fza.onError();
                        }
                    });
                }
            }
        };
        if (this.fyP != null) {
            this.fyP.a(anonymousClass2);
        }
    }

    public final void a(com.tencent.mm.y.g.a aVar) {
        this.fzb = aVar;
    }

    private void oT() {
        com.tencent.mm.modelvoice.d.a anonymousClass3 = new com.tencent.mm.modelvoice.d.a(this) {
            final /* synthetic */ a fzc;

            {
                this.fzc = r1;
            }

            public final void oW() {
                com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 fze;

                    {
                        this.fze = r1;
                    }

                    public final void run() {
                        try {
                            if (p.gRd.gNW == 1) {
                                Thread.sleep(300);
                            }
                            w.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", this.fze.fzc.fzb, Boolean.valueOf(this.fze.fzc.fyW));
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 fzf;

                                {
                                    this.fzf = r1;
                                }

                                public final void run() {
                                    e.qE().c(this.fzf.fze.fzc.fyQ, false);
                                    if (this.fzf.fze.fzc.fyW) {
                                        b bVar;
                                        Context context = this.fzf.fze.fzc.context;
                                        int i = com.tencent.mm.plugin.f.a.a.jAG;
                                        boolean z = this.fzf.fze.fzc.fyQ;
                                        com.tencent.mm.sdk.platformtools.aq.a anonymousClass1 = new com.tencent.mm.sdk.platformtools.aq.a(this) {
                                            final /* synthetic */ AnonymousClass1 fzg;

                                            {
                                                this.fzg = r1;
                                            }

                                            public final void oW() {
                                                w.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                                                if (!this.fzg.fzf.fze.fzc.isPlaying()) {
                                                    e.qE().b(this.fzg.fzf.fze.fzc);
                                                    w.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", Boolean.valueOf(this.fzg.fzf.fze.fzc.fyS));
                                                    if (!this.fzg.fzf.fze.fzc.fyS) {
                                                        e.qE().qH();
                                                    }
                                                    this.fzg.fzf.fze.fzc.fyS = false;
                                                    this.fzg.fzf.fze.fzc.fyV = false;
                                                    e.qE().setMode(0);
                                                    w.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                                                }
                                            }
                                        };
                                        if (z) {
                                            bVar = b.ON;
                                        } else {
                                            bVar = b.OFF;
                                        }
                                        aq.a(context, i, bVar, false, anonymousClass1);
                                    } else {
                                        w.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                                        if (!this.fzf.fze.fzc.isPlaying()) {
                                            e.qE().b(this.fzf.fze.fzc);
                                            w.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", Boolean.valueOf(this.fzf.fze.fzc.fyS));
                                            if (!this.fzf.fze.fzc.fyS) {
                                                e.qE().qH();
                                            }
                                            this.fzf.fze.fzc.fyS = false;
                                            this.fzf.fze.fzc.fyV = false;
                                            e.qE().setMode(0);
                                            w.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                                        }
                                    }
                                    if (this.fzf.fze.fzc.fzb != null) {
                                        w.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                                        this.fzf.fze.fzc.fzb.oW();
                                        return;
                                    }
                                    w.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                                }
                            });
                        } catch (Throwable e) {
                            w.e("MicroMsg.SceneVoicePlayer", "exception:%s", bg.g(e));
                        }
                    }
                }, "SceneVoice_onCompletion");
            }
        };
        if (this.fyP != null) {
            this.fyP.a(anonymousClass3);
        }
    }

    public final double oU() {
        if (this.fyP == null) {
            return 0.0d;
        }
        return this.fyP.oU();
    }

    public final void ar(boolean z) {
        w.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", Boolean.valueOf(z));
        this.fyS = z;
    }

    public final boolean oV() {
        if (this.fyP != null && this.fyP.getStatus() == 2) {
            return true;
        }
        return false;
    }

    public final void cW(int i) {
        w.i("MicroMsg.SceneVoicePlayer", "onBluetoothHeadsetStateChange, status: %d, currentSpeaker: %b, bluetoothResumeSpeaker: %b, isRequestStartBluetooth: %b", Integer.valueOf(i), Boolean.valueOf(this.fyQ), Boolean.valueOf(this.fyU), Boolean.valueOf(this.fyV));
        switch (i) {
            case 1:
                aq(false);
                return;
            case 2:
            case 4:
                aq(this.fyU);
                if (this.fyV) {
                    e.qE().qH();
                    this.fyV = false;
                    return;
                }
                return;
            case 6:
                aq(this.fyU);
                if (this.fyP != null && this.fyP.isPlaying()) {
                    e.qE().qG();
                    this.fyV = true;
                    return;
                }
                return;
            case 7:
                if (this.fyP != null && this.fyP.isPlaying()) {
                    e.qE().qG();
                    this.fyV = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
