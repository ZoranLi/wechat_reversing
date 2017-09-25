package com.tencent.mm.plugin.sight.decode.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b {
    private static HashMap<String, WeakReference<Bitmap>> pul = new HashMap();
    public static Map<String, Integer> pup = new ConcurrentHashMap();
    public boolean hRa = false;
    public ae jsW;
    public boolean mNI = true;
    public Surface nIX;
    public int position;
    public int ptM = 0;
    public int ptN = 0;
    public String ptO = "";
    public String ptP = "";
    public int ptQ = -1;
    protected int ptR = 41;
    public Bitmap ptS;
    public Bitmap ptT;
    public Bitmap ptU;
    public WeakReference<View> ptV;
    public WeakReference<TextView> ptW;
    public long ptX;
    public WeakReference<View> ptY;
    public Animation ptZ;
    public Animation pua;
    private volatile h pub;
    public volatile b puc;
    public volatile i pud;
    public volatile c pue;
    private k puf;
    public j pug;
    private d puh;
    public boolean pui = true;
    public boolean puj = true;
    public boolean puk = false;
    public boolean pum = false;
    public double pun = -1.0d;
    boolean puo = false;
    public double puq = -1.0d;
    public boolean pur = false;
    public boolean pus = false;
    private a put;
    public e puu;
    public f puv;
    public g puw;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ b pux;
        final /* synthetic */ double puy;

        public AnonymousClass3(b bVar, double d) {
            this.pux = bVar;
            this.puy = d;
        }

        public final void run() {
            w.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", Double.valueOf(this.puy), bg.bJZ().toString());
            this.pux.puq = this.puy;
        }
    }

    private class b implements Runnable {
        volatile boolean nDu = false;
        c puC;
        final /* synthetic */ b pux;

        public b(b bVar) {
            this.pux = bVar;
        }

        public final void run() {
            if (!(this.pux.puw == null || this.pux.puw.bch() == null || this.pux.puw.bch().getVisibility() != 0)) {
                this.pux.jsW.post(new Runnable(this) {
                    final /* synthetic */ b puD;

                    {
                        this.puD = r1;
                    }

                    public final void run() {
                        this.puD.pux.puw.bch().setVisibility(8);
                    }
                });
            }
            if (this.pux.ptQ < 0) {
                w.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", Integer.valueOf(this.pux.hashCode()), Integer.valueOf(hashCode()), this.pux.ptO);
            } else if (this.nDu) {
                w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", Integer.valueOf(this.pux.hashCode()), Integer.valueOf(hashCode()));
            } else {
                float f;
                double bck;
                if (this.pux.ptX == 0) {
                    if (this.pux.pud != null) {
                        this.pux.pud.type = 1;
                        this.pux.pud.run();
                    }
                    this.pux.ptX = System.currentTimeMillis();
                }
                Object obj = null;
                if (this.pux.puq != -1.0d) {
                    if (this.pux.puk) {
                        if (this.pux.pud != null) {
                            this.pux.pud.type = 4;
                            this.pux.pud.puq = this.pux.puq;
                            this.pux.pud.run();
                            this.pux.jsW.postDelayed(new Runnable(this) {
                                final /* synthetic */ b puD;

                                {
                                    this.puD = r1;
                                }

                                public final void run() {
                                    this.puD.pux.pur = true;
                                }
                            }, 100);
                        } else if (SightVideoJNI.seekStream(this.pux.puq, this.pux.ptQ) > 0) {
                            if (this.pux.pud == null) {
                                this.pux.pud = new i(this.pux);
                            }
                            this.pux.pud.type = 4;
                            this.pux.pud.puq = this.pux.puq;
                            this.pux.pud.run();
                            obj = 1;
                        }
                    } else if (SightVideoJNI.seekStream(this.pux.puq, this.pux.ptQ) > 0) {
                        if (this.pux.pud == null) {
                            this.pux.pud = new i(this.pux);
                        }
                        this.pux.pud.type = 4;
                        this.pux.pud.puq = this.pux.puq;
                        this.pux.pud.run();
                        obj = 1;
                    }
                }
                float currentTimeMillis = (float) (System.currentTimeMillis() - this.pux.ptX);
                if (obj != null) {
                    f = 0.0f;
                } else {
                    f = (currentTimeMillis / ((float) this.pux.ptR)) + 0.5f;
                }
                if (this.pux.puk && this.pux.pur) {
                    this.pux.pur = false;
                    if (this.pux.pud != null) {
                        bck = this.pux.pud.bck() / 1000.0d;
                        if (SightVideoJNI.seekStream(bck, this.pux.ptQ) > 0) {
                            f = 0.0f;
                            w.i("MicroMsg.SightPlayController", "seek to " + bck + " modify time : 0.0");
                        }
                    }
                }
                float f2 = f;
                if (this.pux.hRa) {
                    w.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", Integer.valueOf(this.pux.hashCode()), Integer.valueOf(this.pux.ptQ), Float.valueOf(currentTimeMillis), Float.valueOf(f2));
                }
                this.pux.ptX = System.currentTimeMillis();
                if (f2 >= 2.0f) {
                    b bVar = this.pux;
                    bVar.ptM++;
                } else {
                    this.pux.ptM = Math.max(0, this.pux.ptM - 1);
                }
                if (this.pux.bca()) {
                    w.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", Integer.valueOf(this.pux.ptM));
                    this.pux.clear();
                    return;
                }
                int i;
                Object obj2 = null;
                int i2 = 0;
                if (1 == this.pux.ptN) {
                    Object obj3;
                    if (this.pux.nIX == null || this.pux.nIX.isValid()) {
                        i2 = SightVideoJNI.drawSurfaceFrame(this.pux.ptQ, this.pux.nIX, (int) f2, this.pux.ptT, this.pux.mNI);
                        if (this.pux.puv != null) {
                            bck = SightVideoJNI.getVideoPlayTime(this.pux.ptQ);
                            i = (int) bck;
                            if (i != ((int) this.pux.pun)) {
                                this.pux.puv.a(this.pux, (long) i);
                            }
                            this.pux.pun = bck;
                        }
                        if (i2 == 0) {
                            this.pux.puq = -1.0d;
                            obj3 = null;
                        } else if (1 == i2) {
                            this.pux.puq = -1.0d;
                            obj3 = 1;
                            this.pux.ptX = 0;
                            this.pux.bcc();
                        } else if (-7 == i2) {
                            w.w("MicroMsg.SightPlayController", "surface is null, continue");
                            obj3 = null;
                        } else {
                            w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", Integer.valueOf(this.pux.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                            this.nDu = true;
                            if (this.puC != null) {
                                this.puC.nDu = true;
                            }
                            this.pux.z(null);
                            if (this.pux.puu != null) {
                                this.pux.puu.a(this.pux, -1);
                            }
                            obj3 = null;
                        }
                    } else {
                        w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", Integer.valueOf(this.pux.hashCode()), Integer.valueOf(hashCode()));
                        this.nDu = true;
                        if (this.puC != null) {
                            this.puC.nDu = true;
                            obj3 = null;
                        }
                        obj3 = null;
                    }
                    if (this.pux.pud != null) {
                        w.d("MicroMsg.SightPlayController", "voice time is" + (this.pux.pud.bck() / 1000.0d));
                        obj2 = obj3;
                    } else {
                        obj2 = obj3;
                    }
                } else {
                    i2 = SightVideoJNI.drawFrame(this.pux.ptQ, this.pux.ptS, (int) f2, null, false, this.pux.mNI);
                    if (this.pux.puv != null) {
                        bck = SightVideoJNI.getVideoPlayTime(this.pux.ptQ);
                        i = (int) bck;
                        if (i != ((int) this.pux.pun)) {
                            this.pux.puv.a(this.pux, (long) i);
                        }
                        this.pux.pun = bck;
                        if (this.pux.hRa) {
                            w.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(this.pux.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(bck));
                        }
                    } else if (this.pux.hRa) {
                        bck = SightVideoJNI.getVideoPlayTime(this.pux.ptQ);
                        if (this.pux.hRa) {
                            w.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(this.pux.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(bck));
                        }
                    } else if (this.pux.hRa) {
                        w.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", Integer.valueOf(this.pux.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                    }
                    if (i2 == 0) {
                        this.pux.puq = -1.0d;
                    } else if (1 == i2) {
                        this.pux.puq = -1.0d;
                        obj2 = 1;
                        this.pux.ptX = 0;
                        this.pux.bcc();
                    } else {
                        this.pux.puq = -1.0d;
                        w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", Integer.valueOf(this.pux.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                        this.nDu = true;
                        if (this.puC != null) {
                            this.puC.nDu = true;
                        }
                        this.pux.jsW.post(new Runnable(this) {
                            final /* synthetic */ b puD;

                            {
                                this.puD = r1;
                            }

                            public final void run() {
                                this.puD.pux.A(null);
                            }
                        });
                        if (this.pux.puu != null) {
                            this.pux.puu.a(this.pux, -1);
                        }
                    }
                }
                if (1 == i2) {
                    this.pux.jsW.post(new Runnable(this) {
                        final /* synthetic */ b puD;

                        {
                            this.puD = r1;
                        }

                        public final void run() {
                            if (this.puD.pux.puu != null) {
                                this.puD.pux.puu.a(this.puD.pux, 0);
                            }
                        }
                    });
                }
                if (this.nDu) {
                    w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", Integer.valueOf(this.pux.hashCode()), Integer.valueOf(hashCode()));
                    if (this.pux.pud != null) {
                        this.pux.pud.type = 0;
                        this.pux.pud.run();
                        return;
                    }
                    return;
                }
                if (1 == this.pux.ptN) {
                    long currentTimeMillis2 = ((long) this.pux.ptR) - (System.currentTimeMillis() - this.pux.ptX);
                    if (this.pux.ptX == 0) {
                        o.b(this, (long) (this.pux.ptR * 5));
                    } else if (currentTimeMillis2 > 0) {
                        o.b(this, currentTimeMillis2);
                    } else {
                        o.b(this, 0);
                    }
                } else if (obj2 == null || this.pux.puw == null) {
                    this.puC.puE = i2;
                    this.pux.jsW.post(this.puC);
                } else {
                    i = this.pux.puw.bcg();
                    this.pux.jsW.post(new Runnable(this) {
                        final /* synthetic */ b puD;

                        {
                            this.puD = r1;
                        }

                        public final void run() {
                            if (this.puD.pux.puw != null) {
                                View bch = this.puD.pux.puw.bch();
                                if (bch != null) {
                                    if (!(this.puD.pux.pua != null || this.puD.pux.puw.bci() == -1 || this.puD.pux.ptY.get() == null)) {
                                        this.puD.pux.pua = AnimationUtils.loadAnimation(((View) this.puD.pux.ptY.get()).getContext(), this.puD.pux.puw.bci());
                                    }
                                    if (this.puD.pux.pua != null) {
                                        bch.startAnimation(this.puD.pux.pua);
                                    }
                                    bch.setVisibility(0);
                                }
                            }
                        }
                    });
                    this.puC.puE = i2;
                    this.pux.jsW.postDelayed(this.puC, (long) i);
                }
                if (this.pux.pud != null) {
                    w.d("MicroMsg.SightPlayController", "voice time is" + (this.pux.pud.bck() / 1000.0d));
                }
            }
        }
    }

    private class c implements Runnable {
        volatile boolean nDu = false;
        int puE;
        b puF;
        final /* synthetic */ b pux;

        public c(b bVar) {
            this.pux = bVar;
            w.i("MicroMsg.SightPlayController", "make sure drawJob alive");
        }

        public final void run() {
            if (this.nDu) {
                w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", Integer.valueOf(this.pux.hashCode()), Integer.valueOf(hashCode()));
                return;
            }
            this.pux.A(this.pux.ptS);
            if (this.pux.ptX == 0) {
                o.b(this.puF, 0);
                return;
            }
            long currentTimeMillis = ((long) this.pux.ptR) - (System.currentTimeMillis() - this.pux.ptX);
            if (currentTimeMillis > 0) {
                o.b(this.puF, currentTimeMillis);
            } else {
                o.b(this.puF, 0);
            }
        }
    }

    private class d implements Runnable {
        final /* synthetic */ b pux;

        public d(b bVar) {
            this.pux = bVar;
        }

        public final void run() {
            if (this.pux.ptY.get() != null) {
                ((View) this.pux.ptY.get()).startAnimation(this.pux.ptZ);
            }
        }
    }

    public interface e {
        void a(b bVar, int i);
    }

    public interface f {
        void a(b bVar, long j);
    }

    public interface g {
        int bcg();

        View bch();

        int bci();
    }

    private class h implements Runnable {
        volatile boolean nDu = false;
        final /* synthetic */ b pux;

        public h(b bVar) {
            this.pux = bVar;
        }

        public final void run() {
            if (this.pux.bca()) {
                w.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
                return;
            }
            this.pux.ptQ = SightVideoJNI.openFile(this.pux.ptO, 1 == this.pux.ptN ? 0 : 1, 1, false);
            if (this.pux.ptQ < 0) {
                w.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", Integer.valueOf(hashCode()), Integer.valueOf(this.pux.hashCode()), Integer.valueOf(this.pux.ptQ), this.pux.ptO);
                this.pux.z(null);
                if (this.pux.puu != null) {
                    this.pux.puu.a(this.pux, -1);
                    return;
                }
                return;
            }
            if (((Boolean) com.tencent.mm.kernel.h.vI().vr().get(344065, Boolean.valueOf(false))).booleanValue()) {
                if (this.pux.pug == null) {
                    this.pux.pug = new j(this.pux);
                }
                this.pux.jsW.removeCallbacks(this.pux.pug);
                this.pux.jsW.post(this.pux.pug);
            }
            int max = Math.max(1, SightVideoJNI.getVideoWidth(this.pux.ptQ));
            int max2 = Math.max(1, SightVideoJNI.getVideoHeight(this.pux.ptQ));
            if (this.pux.ptN == 0) {
                if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                    w.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", Integer.valueOf(max), Integer.valueOf(max2));
                    return;
                }
                b bVar = this.pux;
                w.d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", Integer.valueOf(bVar.hashCode()), Integer.valueOf(max), Integer.valueOf(max2));
                if (bVar.ptS == null) {
                    bVar.ptS = com.tencent.mm.memory.o.hgW.a(new com.tencent.mm.memory.o.b(max, max2));
                    w.h("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", bVar.ptO);
                } else if (!(bVar.ptS.getWidth() == max && bVar.ptS.getHeight() == max2)) {
                    boolean z;
                    w.w("MicroMsg.SightPlayController", "reset bmp, old value " + bVar.ptS.getWidth() + "*" + bVar.ptS.getHeight());
                    if (!com.tencent.mm.compatible.util.d.eo(19) || bVar.ptS.getAllocationByteCount() < (max2 * max) * 4) {
                        z = false;
                    } else {
                        try {
                            w.w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
                            bVar.ptS.reconfigure(max, max2, Config.ARGB_8888);
                            z = true;
                        } catch (Exception e) {
                            w.e("MicroMsg.SightPlayController", "reconfigure failed: %s" + e.getMessage());
                            z = false;
                        }
                    }
                    if (!z) {
                        com.tencent.mm.memory.o.hgW.e(bVar.ptS);
                        bVar.ptS = com.tencent.mm.memory.o.hgW.a(new com.tencent.mm.memory.o.b(max, max2));
                    }
                    w.h("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", bVar.ptO);
                }
            }
            this.pux.bcb();
            if (Float.compare(((float) max) / ((float) max2), 5.0f) > 0 || Float.compare(((float) max2) / ((float) max), 5.0f) > 0) {
                w.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", Integer.valueOf(max), Integer.valueOf(max2));
                if (!bg.mA(this.pux.ptO)) {
                    b.pup.put(this.pux.ptO, Integer.valueOf(2));
                }
                this.pux.ptX = 0;
                this.pux.sG(this.pux.ptQ);
                this.pux.ptQ = -1;
                this.pux.ptO = "";
                this.pux.ptP = "ERROR#PATH";
                this.pux.ptU = null;
                this.nDu = true;
                if (this.pux.puu != null) {
                    this.pux.puu.a(this.pux, -1);
                    return;
                }
                return;
            }
            this.pux.bp(max, max2);
            if (1 == this.pux.ptN) {
                this.pux.puc = new b(this.pux);
                this.pux.pue = null;
                if (!this.nDu) {
                    o.b(this.pux.puc, 0);
                }
            } else {
                this.pux.puc = new b(this.pux);
                this.pux.pue = new c(this.pux);
                this.pux.puc.puC = this.pux.pue;
                this.pux.pue.puF = this.pux.puc;
                if (!this.nDu) {
                    o.b(this.pux.puc, 0);
                }
            }
            if (this.nDu) {
                w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", Integer.valueOf(this.pux.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.nDu));
            }
        }
    }

    private class i implements Runnable {
        MediaPlayer puG;
        double puq = -1.0d;
        final /* synthetic */ b pux;
        public int type;

        public i(b bVar) {
            this.pux = bVar;
        }

        private void bcj() {
            w.i("MicroMsg.SightPlayController", "stopPlayer");
            try {
                if (this.puG != null) {
                    this.puG.stop();
                    this.puG.release();
                    this.puG = null;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SightPlayController", e, "stop play sound error: %s", e.getMessage());
                this.puG = null;
            }
        }

        public final double bck() {
            if (this.puG == null) {
                return 0.0d;
            }
            return (double) this.puG.getCurrentPosition();
        }

        public final void run() {
            String str;
            String str2 = "MicroMsg.SightPlayController";
            String str3 = "do play sound, operation %s";
            Object[] objArr = new Object[1];
            switch (this.type) {
                case 0:
                    str = "stop";
                    break;
                case 1:
                    str = "start";
                    break;
                case 2:
                    str = "pause";
                    break;
                case 3:
                    str = "resume";
                    break;
                case 4:
                    str = "seek";
                    break;
                default:
                    str = "unknown";
                    break;
            }
            objArr[0] = str;
            w.i(str2, str3, objArr);
            switch (this.type) {
                case 0:
                    bcj();
                    return;
                case 1:
                    bcj();
                    if (!bg.mA(this.pux.ptO)) {
                        try {
                            this.puG = new com.tencent.mm.compatible.b.i();
                            this.puG.setDisplay(null);
                            this.puG.reset();
                            this.puG.setDataSource(this.pux.ptO);
                            this.puG.setAudioStreamType(3);
                            this.puG.setOnErrorListener(new OnErrorListener(this) {
                                final /* synthetic */ i puH;

                                {
                                    this.puH = r1;
                                }

                                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                    w.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", this.puH.pux.ptO, Integer.valueOf(i), Integer.valueOf(i2));
                                    this.puH.pux.clear();
                                    if (this.puH.pux.puu != null) {
                                        this.puH.pux.puu.a(this.puH.pux, -1);
                                    }
                                    return true;
                                }
                            });
                            this.puG.prepare();
                            this.puG.start();
                            return;
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.SightPlayController", e, "play sound error: %s", e.getMessage());
                            w.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", this.pux.ptO);
                            this.pux.clear();
                            if (this.pux.puu != null) {
                                this.pux.puu.a(this.pux, -1);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case 2:
                    try {
                        if (this.puG != null && this.puG.isPlaying()) {
                            this.puG.pause();
                            return;
                        }
                        return;
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.SightPlayController", e2, "pause sound error: %s", e2.getMessage());
                        bcj();
                        return;
                    }
                case 3:
                    try {
                        if (this.puG != null) {
                            this.puG.start();
                            return;
                        }
                        return;
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.SightPlayController", e22, "pause sound error: %s", e22.getMessage());
                        bcj();
                        return;
                    }
                case 4:
                    try {
                        w.i("MicroMsg.SightPlayController", "soundplayer seek %f", Double.valueOf(this.puq));
                        this.puG.seekTo((int) (this.puq * 1000.0d));
                        return;
                    } catch (Throwable e222) {
                        w.printErrStackTrace("MicroMsg.SightPlayController", e222, "seek sound error: %s", e222.getMessage());
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private class j implements Runnable {
        final /* synthetic */ b pux;

        public j(b bVar) {
            this.pux = bVar;
        }

        public final void run() {
            if (this.pux.ptQ >= 0 && this.pux.ptW != null && this.pux.ptW.get() != null) {
                ((TextView) this.pux.ptW.get()).setText(SightVideoJNI.getVideoInfo(this.pux.ptQ));
            }
        }
    }

    private class k implements Runnable {
        WeakReference<Bitmap> puI = new WeakReference(null);
        final /* synthetic */ b pux;

        public k(b bVar) {
            this.pux = bVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r1 = 0;
            r2 = 1;
            r3 = 0;
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.nIX;	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x0013;
        L_0x0009:
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.nIX;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.isValid();	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x01db;
        L_0x0013:
            r4 = "MicroMsg.SightPlayController";
            r5 = "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B";
            r0 = 6;
            r6 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00ce }
            r0 = 0;
            r7 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r7 = r7.hashCode();	 Catch:{ Exception -> 0x00ce }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00ce }
            r6[r0] = r7;	 Catch:{ Exception -> 0x00ce }
            r0 = 1;
            r7 = r10.hashCode();	 Catch:{ Exception -> 0x00ce }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00ce }
            r6[r0] = r7;	 Catch:{ Exception -> 0x00ce }
            r7 = 2;
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.nIX;	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x00b9;
        L_0x003b:
            r0 = r2;
        L_0x003c:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00ce }
            r7 = 3;
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptV;	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x00bb;
        L_0x0049:
            r0 = r2;
        L_0x004a:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00ce }
            r7 = 4;
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x00bd;
        L_0x0059:
            r0 = r2;
        L_0x005a:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00ce }
            r7 = 5;
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptT;	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x00bf;
        L_0x0067:
            r0 = r2;
        L_0x0068:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.sdk.platformtools.w.w(r4, r5, r6);	 Catch:{ Exception -> 0x00ce }
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptT;	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x00db;
        L_0x0077:
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00ce }
            r4 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r4 = r4.ptV;	 Catch:{ Exception -> 0x00ce }
            if (r4 == 0) goto L_0x008f;
        L_0x0085:
            r1 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r1 = r1.ptV;	 Catch:{ Exception -> 0x00ce }
            r1 = r1.get();	 Catch:{ Exception -> 0x00ce }
            r1 = (android.view.View) r1;	 Catch:{ Exception -> 0x00ce }
        L_0x008f:
            if (r1 == 0) goto L_0x0099;
        L_0x0091:
            if (r0 == 0) goto L_0x0099;
        L_0x0093:
            r4 = r0.isRecycled();	 Catch:{ Exception -> 0x00ce }
            if (r4 == 0) goto L_0x00c5;
        L_0x0099:
            r4 = "MicroMsg.SightPlayController";
            r5 = "bgView:%B, thumb:%B";
            r6 = 2;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00ce }
            r7 = 0;
            if (r1 != 0) goto L_0x00c1;
        L_0x00a5:
            r1 = r2;
        L_0x00a6:
            r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r1;	 Catch:{ Exception -> 0x00ce }
            r1 = 1;
            if (r0 != 0) goto L_0x00c3;
        L_0x00af:
            r0 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00ce }
            r6[r1] = r0;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.sdk.platformtools.w.e(r4, r5, r6);	 Catch:{ Exception -> 0x00ce }
        L_0x00b8:
            return;
        L_0x00b9:
            r0 = r3;
            goto L_0x003c;
        L_0x00bb:
            r0 = r3;
            goto L_0x004a;
        L_0x00bd:
            r0 = r3;
            goto L_0x005a;
        L_0x00bf:
            r0 = r3;
            goto L_0x0068;
        L_0x00c1:
            r1 = r3;
            goto L_0x00a6;
        L_0x00c3:
            r2 = r3;
            goto L_0x00af;
        L_0x00c5:
            r2 = new com.tencent.mm.plugin.sight.decode.a.b$k$1;	 Catch:{ Exception -> 0x00ce }
            r2.<init>(r10, r1, r0);	 Catch:{ Exception -> 0x00ce }
            r1.post(r2);	 Catch:{ Exception -> 0x00ce }
            goto L_0x00b8;
        L_0x00ce:
            r0 = move-exception;
            r1 = "MicroMsg.SightPlayController";
            r2 = "";
            r3 = new java.lang.Object[r3];
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
            goto L_0x00b8;
        L_0x00db:
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptU;	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x0105;
        L_0x00e1:
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptU;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.getWidth();	 Catch:{ Exception -> 0x00ce }
            r4 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r4 = r4.ptT;	 Catch:{ Exception -> 0x00ce }
            r4 = r4.getWidth();	 Catch:{ Exception -> 0x00ce }
            if (r0 != r4) goto L_0x0105;
        L_0x00f3:
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptU;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.getHeight();	 Catch:{ Exception -> 0x00ce }
            r4 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r4 = r4.ptT;	 Catch:{ Exception -> 0x00ce }
            r4 = r4.getHeight();	 Catch:{ Exception -> 0x00ce }
            if (r0 == r4) goto L_0x011f;
        L_0x0105:
            r0 = r10.pux;	 Catch:{ Exception -> 0x0166 }
            r4 = r10.pux;	 Catch:{ Exception -> 0x0166 }
            r4 = r4.ptT;	 Catch:{ Exception -> 0x0166 }
            r4 = r4.getWidth();	 Catch:{ Exception -> 0x0166 }
            r5 = r10.pux;	 Catch:{ Exception -> 0x0166 }
            r5 = r5.ptT;	 Catch:{ Exception -> 0x0166 }
            r5 = r5.getHeight();	 Catch:{ Exception -> 0x0166 }
            r6 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Exception -> 0x0166 }
            r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6);	 Catch:{ Exception -> 0x0166 }
            r0.ptU = r4;	 Catch:{ Exception -> 0x0166 }
        L_0x011f:
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptU;	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x013b;
        L_0x0125:
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x013b;
        L_0x012d:
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.isRecycled();	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x0184;
        L_0x013b:
            r1 = "MicroMsg.SightPlayController";
            r4 = "mThubmBgBmp:%B, thumbRef:%B";
            r0 = 2;
            r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00ce }
            r6 = 0;
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptU;	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x0180;
        L_0x014b:
            r0 = r2;
        L_0x014c:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00ce }
            r5[r6] = r0;	 Catch:{ Exception -> 0x00ce }
            r0 = 1;
            r6 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r6 = r6.get();	 Catch:{ Exception -> 0x00ce }
            if (r6 != 0) goto L_0x0182;
        L_0x015b:
            r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00ce }
            r5[r0] = r2;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.sdk.platformtools.w.e(r1, r4, r5);	 Catch:{ Exception -> 0x00ce }
            goto L_0x00b8;
        L_0x0166:
            r0 = move-exception;
            r4 = "MicroMsg.SightPlayController";
            r5 = "try to create thumb bmp error:%s";
            r6 = 1;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00ce }
            r7 = 0;
            r8 = r0.getMessage();	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r8;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r4, r0, r5, r6);	 Catch:{ Exception -> 0x00ce }
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r4 = 0;
            r0.ptU = r4;	 Catch:{ Exception -> 0x00ce }
            goto L_0x011f;
        L_0x0180:
            r0 = r3;
            goto L_0x014c;
        L_0x0182:
            r2 = r3;
            goto L_0x015b;
        L_0x0184:
            r4 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00ce }
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00ce }
            r2 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r2 = r2.ptU;	 Catch:{ Exception -> 0x00ce }
            r6 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r6 = r6.ptT;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.plugin.sight.base.SightVideoJNI.handleThumb(r0, r2, r6);	 Catch:{ Exception -> 0x00ce }
            r0 = "MicroMsg.SightPlayController";
            r2 = "handle thumb use %d us";
            r6 = 1;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00ce }
            r7 = 0;
            r8 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00ce }
            r4 = r8 - r4;
            r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r4 = r4 / r8;
            r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r4;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.sdk.platformtools.w.i(r0, r2, r6);	 Catch:{ Exception -> 0x00ce }
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r2 = r0.ptU;	 Catch:{ Exception -> 0x00ce }
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptV;	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x01d9;
        L_0x01c1:
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptV;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00ce }
        L_0x01cb:
            if (r0 == 0) goto L_0x00b8;
        L_0x01cd:
            if (r2 == 0) goto L_0x00b8;
        L_0x01cf:
            r1 = new com.tencent.mm.plugin.sight.decode.a.b$k$2;	 Catch:{ Exception -> 0x00ce }
            r1.<init>(r10, r0, r2);	 Catch:{ Exception -> 0x00ce }
            r0.post(r1);	 Catch:{ Exception -> 0x00ce }
            goto L_0x00b8;
        L_0x01d9:
            r0 = r1;
            goto L_0x01cb;
        L_0x01db:
            r1 = "MicroMsg.SightPlayController";
            r4 = "#0x%x-#0x%x draw thumb, thumb empty ? %B";
            r0 = 3;
            r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00ce }
            r0 = 0;
            r6 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r6 = r6.hashCode();	 Catch:{ Exception -> 0x00ce }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00ce }
            r5[r0] = r6;	 Catch:{ Exception -> 0x00ce }
            r0 = 1;
            r6 = r10.hashCode();	 Catch:{ Exception -> 0x00ce }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00ce }
            r5[r0] = r6;	 Catch:{ Exception -> 0x00ce }
            r6 = 2;
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x023b;
        L_0x0205:
            r0 = r2;
        L_0x0206:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00ce }
            r5[r6] = r0;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.sdk.platformtools.w.d(r1, r4, r5);	 Catch:{ Exception -> 0x00ce }
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptV;	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x0229;
        L_0x0215:
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptV;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x0229;
        L_0x0221:
            r1 = new com.tencent.mm.plugin.sight.decode.a.b$k$3;	 Catch:{ Exception -> 0x00ce }
            r1.<init>(r10, r0);	 Catch:{ Exception -> 0x00ce }
            r0.post(r1);	 Catch:{ Exception -> 0x00ce }
        L_0x0229:
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x023d;
        L_0x0231:
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.nIX;	 Catch:{ Exception -> 0x00ce }
            r1 = 0;
            com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceColor(r0, r1);	 Catch:{ Exception -> 0x00ce }
            goto L_0x00b8;
        L_0x023b:
            r0 = r3;
            goto L_0x0206;
        L_0x023d:
            r0 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r1 = r0.nIX;	 Catch:{ Exception -> 0x00ce }
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00ce }
            r2 = r10.pux;	 Catch:{ Exception -> 0x00ce }
            r2 = r2.ptT;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceThumb(r1, r0, r2);	 Catch:{ Exception -> 0x00ce }
            goto L_0x00b8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sight.decode.a.b.k.run():void");
        }
    }

    private static class a extends com.tencent.mm.sdk.b.c<qv> {
        int lHi = 0;
        int puA = 0;
        WeakReference<b> puB;
        int puz = 0;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b r9) {
            /*
            r8 = this;
            r7 = 2;
            r6 = 1;
            r5 = 0;
            r9 = (com.tencent.mm.e.a.qv) r9;
            r0 = r8.puB;
            r0 = r0.get();
            if (r0 == 0) goto L_0x007e;
        L_0x000d:
            r1 = "MicroMsg.SightPlayController";
            r2 = "#0x%x on chatting status callback, type %d, selfPos %d, visiblePos[%d, %d], headerCount %d recording %B";
            r0 = 7;
            r3 = new java.lang.Object[r0];
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.hashCode();
            r0 = java.lang.Integer.valueOf(r0);
            r3[r5] = r0;
            r0 = r9.fXQ;
            r0 = r0.type;
            r0 = java.lang.Integer.valueOf(r0);
            r3[r6] = r0;
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.position;
            r0 = java.lang.Integer.valueOf(r0);
            r3[r7] = r0;
            r0 = 3;
            r4 = r9.fXQ;
            r4 = r4.fXR;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r0 = 4;
            r4 = r9.fXQ;
            r4 = r4.fXS;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r0 = 5;
            r4 = r9.fXQ;
            r4 = r4.fXT;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r4 = 6;
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.pus;
            r0 = java.lang.Boolean.valueOf(r0);
            r3[r4] = r0;
            com.tencent.mm.sdk.platformtools.w.d(r1, r2, r3);
            r0 = r9.fXQ;
            r0 = r0.type;
            switch(r0) {
                case 0: goto L_0x00b7;
                case 1: goto L_0x0095;
                case 2: goto L_0x007e;
                case 3: goto L_0x007f;
                case 4: goto L_0x007e;
                case 5: goto L_0x00d8;
                case 6: goto L_0x008b;
                case 7: goto L_0x00a1;
                default: goto L_0x007e;
            };
        L_0x007e:
            return r5;
        L_0x007f:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.clear();
            goto L_0x007e;
        L_0x008b:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.pus = r6;
        L_0x0095:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.ha(r5);
            goto L_0x007e;
        L_0x00a1:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.pus;
            if (r0 == 0) goto L_0x007e;
        L_0x00ad:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.pus = r5;
        L_0x00b7:
            r8.a(r9);
            r0 = r8.bcf();
            if (r0 == 0) goto L_0x007e;
        L_0x00c0:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.pus;
            if (r0 != 0) goto L_0x007e;
        L_0x00cc:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.restart();
            goto L_0x007e;
        L_0x00d8:
            r8.a(r9);
            r0 = r8.bcf();
            if (r0 == 0) goto L_0x0188;
        L_0x00e1:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.pus;
            if (r0 != 0) goto L_0x0188;
        L_0x00ed:
            r1 = "ERROR#PATH";
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.ptP;
            r0 = r1.equals(r0);
            if (r0 != 0) goto L_0x016f;
        L_0x0100:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r1 = r0.ptO;
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.ptP;
            r0 = r1.equals(r0);
            if (r0 != 0) goto L_0x016f;
        L_0x011a:
            r1 = "MicroMsg.SightPlayController";
            r2 = "match diff path, change %s to %s";
            r3 = new java.lang.Object[r7];
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.ptO;
            r3[r5] = r0;
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.ptP;
            r3[r6] = r0;
            com.tencent.mm.sdk.platformtools.w.d(r1, r2, r3);
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.ptP;
            if (r0 != 0) goto L_0x017c;
        L_0x0149:
            r0 = "";
            r1 = r0;
        L_0x014d:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.clear();
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.ptO = r1;
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r1 = "ERROR#PATH";
            r0.ptP = r1;
        L_0x016f:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.restart();
            goto L_0x007e;
        L_0x017c:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.ptP;
            r1 = r0;
            goto L_0x014d;
        L_0x0188:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.clear();
            goto L_0x007e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sight.decode.a.b.a.a(com.tencent.mm.sdk.b.b):boolean");
        }

        public a(b bVar) {
            super(0);
            this.puB = new WeakReference(bVar);
            this.usg = qv.class.getName().hashCode();
        }

        private void a(qv qvVar) {
            this.puz = qvVar.fXQ.fXT;
            this.puA = qvVar.fXQ.fXR;
            this.lHi = qvVar.fXQ.fXS;
        }

        private boolean bcf() {
            if (this.puB.get() == null) {
                return false;
            }
            int i = ((b) this.puB.get()).position + this.puz;
            if (i < this.puA || i > this.lHi) {
                return false;
            }
            return true;
        }
    }

    public abstract void A(Bitmap bitmap);

    public abstract void bp(int i, int i2);

    public static Bitmap a(Context context, int i, int i2, int i3, int i4) {
        String format = String.format("%s-%s-%s-%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        WeakReference weakReference = (WeakReference) pul.get(format);
        if (weakReference != null && weakReference.get() != null) {
            return (Bitmap) weakReference.get();
        }
        if (context == null) {
            w.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
            return null;
        } else if (i <= 0) {
            w.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
            return null;
        } else if (i2 <= 0 || i4 <= 0 || i3 <= 0) {
            w.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
            return null;
        } else {
            long NA = bg.NA();
            int i5 = (i2 * i4) / i3;
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) context.getResources().getDrawable(i);
            ninePatchDrawable.setBounds(0, 0, i2, i5);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i5, Config.ARGB_8888);
            ninePatchDrawable.draw(new Canvas(createBitmap));
            pul.put(format, new WeakReference(createBitmap));
            w.d("MicroMsg.SightPlayController", "create mask bmp use %dms", Long.valueOf(bg.aB(NA)));
            return createBitmap;
        }
    }

    public static void wl() {
        o.b(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    SightVideoJNI.freeAll();
                } catch (Throwable e) {
                    w.e("MicroMsg.SightPlayController", "free all sight error");
                    w.printErrStackTrace("MicroMsg.SightPlayController", e, "", new Object[0]);
                }
                w.i("MicroMsg.SightPlayController", "free all, use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }, 0);
    }

    public b(int i, View view) {
        this.ptN = i;
        this.jsW = new ae(Looper.getMainLooper());
        this.ptY = new WeakReference(view);
        w.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", Integer.valueOf(i));
    }

    public int bbY() {
        return -1;
    }

    public final void ha(boolean z) {
        if (this.pub != null) {
            o.h(this.pub);
            this.pub.nDu = true;
        }
        if (this.pue != null) {
            this.jsW.removeCallbacks(this.pue);
            this.pue.nDu = true;
        }
        if (this.puc != null) {
            o.h(this.puc);
            this.puc.nDu = true;
        }
        if (this.pud != null) {
            this.pud.type = z ? 0 : 2;
            o.b(this.pud, 0);
        }
    }

    public final boolean bbZ() {
        if (1 == this.ptN) {
            if (this.puc == null || this.puc.nDu) {
                return false;
            }
            return true;
        } else if (this.pue == null || this.pue.nDu || this.puc == null || this.puc.nDu) {
            return false;
        } else {
            return true;
        }
    }

    public final void restart() {
        w.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.puj), this.ptO, Integer.valueOf(this.ptQ));
        if (!this.puj) {
            clear();
        } else if (bbZ()) {
            w.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", Integer.valueOf(hashCode()), this.ptO);
        } else {
            boolean z;
            if (this.ptQ < 0) {
                z = true;
            } else {
                z = false;
            }
            ha(z);
            this.ptX = 0;
            if (bca()) {
                w.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", Integer.valueOf(hashCode()));
            } else if (this.ptQ < 0) {
                w.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", Integer.valueOf(hashCode()), this.ptO);
                if (!bg.mA(this.ptO)) {
                    if (Es(this.ptO)) {
                        this.pub = new h(this);
                        o.b(this.pub, 0);
                        return;
                    }
                    w.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                }
            } else if (1 == this.ptN) {
                this.puc = new b(this);
                this.pue = null;
                o.b(this.puc, 0);
            } else {
                this.puc = new b(this);
                this.pue = new c(this);
                this.puc.puC = this.pue;
                this.pue.puF = this.puc;
                o.b(this.puc, 0);
            }
        }
    }

    public final void clear() {
        w.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", Integer.valueOf(hashCode()), Integer.valueOf(this.ptQ), Boolean.valueOf(bbZ()));
        ha(true);
        this.ptX = 0;
        sG(this.ptQ);
        this.ptQ = -1;
        this.ptO = "";
        this.ptP = "ERROR#PATH";
        this.ptU = null;
        this.pun = 0.0d;
        this.puo = false;
        com.tencent.mm.memory.o.hgW.e(this.ptS);
        this.ptS = null;
    }

    public final void sG(final int i) {
        o.b(new Runnable(this) {
            final /* synthetic */ b pux;

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                SightVideoJNI.freeObj(i);
                w.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", Integer.valueOf(this.pux.hashCode()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }, 0);
    }

    public final void ak(String str, boolean z) {
        w.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", Integer.valueOf(hashCode()), str, this.ptO, Boolean.valueOf(z), Integer.valueOf(this.ptQ), Boolean.valueOf(this.pus), Boolean.valueOf(this.puj));
        if (this.pus) {
            ha(false);
        } else if (bca()) {
            w.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            clear();
        } else if (!this.puj) {
            clear();
        } else if (z) {
            this.ptP = str;
            ha(false);
        } else if (this.ptO.equals(str)) {
            this.ptP = "ERROR#PATH";
            ha(false);
            restart();
        } else {
            clear();
            if (str == null) {
                str = "";
            }
            this.ptO = str;
            if (bg.mA(this.ptO)) {
                w.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                z(null);
            } else if (Es(this.ptO)) {
                this.pub = new h(this);
                o.b(this.pub, 0);
            } else {
                w.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                clear();
            }
        }
    }

    public static boolean Es(String str) {
        if (bg.mA(str)) {
            return false;
        }
        Integer num = (Integer) pup.get(str);
        if (num == null || 2 != num.intValue()) {
            return true;
        }
        return false;
    }

    public final boolean bca() {
        if (this.pum) {
            return false;
        }
        if (VERSION.SDK_INT >= 11) {
            if (this.ptM < 3) {
                return false;
            }
            w.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
            this.ptM = 0;
            return false;
        } else if (this.ptM >= 3) {
            return true;
        } else {
            return false;
        }
    }

    protected final void bcb() {
        this.ptR = 1000 / Math.max(1, (int) SightVideoJNI.getVideoRate(this.ptQ));
        w.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", Integer.valueOf(hashCode()), Integer.valueOf(r0), Integer.valueOf(this.ptR));
    }

    public final void a(Surface surface) {
        w.v("MicroMsg.SightPlayController", "set play surface %s", surface);
        this.nIX = surface;
        o.b(this.puf, 0);
    }

    public final void h(TextView textView) {
        this.ptW = new WeakReference(textView);
    }

    public final void z(Bitmap bitmap) {
        boolean z = true;
        String str = "MicroMsg.SightPlayController";
        String str2 = "draw surface thumb, thumb is null ? %B";
        Object[] objArr = new Object[1];
        if (bitmap != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.v(str, str2, objArr);
        o.h(this.puf);
        if (this.puf == null) {
            this.puf = new k(this);
        }
        this.puf.puI = new WeakReference(bitmap);
        o.b(this.puf, 0);
    }

    public final void bcc() {
        if (this.ptY != null && -1 != bbY() && this.pui) {
            if (this.ptZ == null && this.ptY.get() != null) {
                this.ptZ = AnimationUtils.loadAnimation(((View) this.ptY.get()).getContext(), bbY());
            }
            if (this.puh == null) {
                this.puh = new d(this);
            }
            this.jsW.post(this.puh);
        }
    }

    public final com.tencent.mm.sdk.b.c bcd() {
        if (this.put == null) {
            this.put = new a(this);
        }
        return this.put;
    }

    public final double bce() {
        if (this.ptQ == -1) {
            return 0.0d;
        }
        return SightVideoJNI.getVideoDuration(this.ptQ);
    }
}
