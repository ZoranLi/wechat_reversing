package com.tencent.mm.plugin.s;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class j {
    public boolean kmK;
    public boolean nAa = false;
    public a nAb;
    private a nAc = new a(this) {
        final /* synthetic */ j nAf;

        {
            this.nAf = r1;
        }

        public final boolean handleMessage(Message message) {
            w.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", this.nAf.nzu.aKs(), Integer.valueOf(message.what), Integer.valueOf(this.nAf.state), Integer.valueOf(this.nAf.nzZ.state));
            boolean pm;
            switch (message.what) {
                case 0:
                    if (this.nAf.nzY && (this.nAf.kmK || this.nAf.nAa)) {
                        this.nAf.nzv.obtainMessage(6).sendToTarget();
                        break;
                    }
                case 2:
                    if (!d.pm(this.nAf.state)) {
                        pm = d.pm(this.nAf.nzZ.state);
                        if (this.nAf.nAb != null) {
                            pm &= d.pm(this.nAf.nAb.state);
                        }
                        if (pm) {
                            this.nAf.setState(2);
                            this.nAf.nzv.obtainMessage(1).sendToTarget();
                            break;
                        }
                    }
                    break;
                case 7:
                    this.nAf.aKD();
                    break;
                case 9:
                    if (!d.pp(this.nAf.state)) {
                        if (!d.pq(this.nAf.state) && !d.po(this.nAf.state)) {
                            pm = d.pp(this.nAf.nzZ.state);
                            if (this.nAf.nAb != null) {
                                pm &= d.pp(this.nAf.nAb.state);
                            }
                            if (pm) {
                                this.nAf.setState(9);
                                this.nAf.nzv.obtainMessage(2).sendToTarget();
                                break;
                            }
                        }
                        this.nAf.setState(9);
                        this.nAf.nzv.obtainMessage(2).sendToTarget();
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private a nAd = new a(this) {
        final /* synthetic */ j nAf;

        {
            this.nAf = r1;
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (!this.nAf.nzZ.aKz()) {
                        this.nAf.nzv.obtainMessage(5, -1, -1).sendToTarget();
                        break;
                    }
                    this.nAf.nzB = this.nAf.nzZ.nzB;
                    this.nAf.a(this.nAf.nzU, SystemClock.elapsedRealtime(), 0);
                    break;
                case 2:
                    g gVar = this.nAf.nzu;
                    long aB = bg.aB(gVar.nzk);
                    if (gVar.nzk > 0 && aB >= 30) {
                        w.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", gVar.aKs(), Long.valueOf(gVar.nzk), Long.valueOf(aB));
                        gVar.nzl = 0;
                    }
                    if (!d.pp(this.nAf.nzZ.state)) {
                        boolean z;
                        int l = this.nAf.nzZ.l(this.nAf.nzh, this.nAf.nzX);
                        if (d.pm(l)) {
                            this.nAf.nzW.obtainMessage(2).sendToTarget();
                        }
                        if (l == 7) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            if (!d.pr(l)) {
                                if (this.nAf.state == 3) {
                                    this.nAf.a(this.nAf.nzU, SystemClock.elapsedRealtime(), this.nAf.nzu.nzl);
                                } else if (this.nAf.state == 5) {
                                    this.nAf.a(this.nAf.nzU, SystemClock.elapsedRealtime(), 0);
                                } else if (this.nAf.state == 1) {
                                    this.nAf.a(this.nAf.nzU, SystemClock.elapsedRealtime(), 0);
                                } else if (this.nAf.state == 0) {
                                    this.nAf.a(this.nAf.nzU, SystemClock.elapsedRealtime(), 0);
                                } else if (this.nAf.state == 6) {
                                    this.nAf.a(this.nAf.nzU, SystemClock.elapsedRealtime(), 0);
                                } else {
                                    this.nAf.nzU.removeMessages(2);
                                }
                                this.nAf.nzu.nzk = bg.NA();
                                break;
                            }
                            this.nAf.a(this.nAf.nzU, SystemClock.elapsedRealtime(), 0);
                            this.nAf.nzu.nzk = bg.NA();
                            break;
                        }
                        this.nAf.nzW.obtainMessage(7).sendToTarget();
                        this.nAf.nzU.removeMessages(2);
                        break;
                    }
                    this.nAf.nzW.obtainMessage(9).sendToTarget();
                    this.nAf.nzU.removeMessages(2);
                    break;
                case 3:
                    this.nAf.pv(3);
                    this.nAf.nzZ.start();
                    this.nAf.a(this.nAf.nzU, SystemClock.elapsedRealtime(), 0);
                    break;
                case 4:
                    this.nAf.pv(4);
                    this.nAf.a(this.nAf.nzU, SystemClock.elapsedRealtime(), 0);
                    this.nAf.nzZ.pause();
                    break;
                case 7:
                    this.nAf.nzZ.release();
                    this.nAf.nzY = true;
                    this.nAf.nzW.obtainMessage(0).sendToTarget();
                    break;
            }
            return false;
        }
    };
    private a nAe = new a(this) {
        final /* synthetic */ j nAf;

        {
            this.nAf = r1;
        }

        public final boolean handleMessage(Message message) {
            if (this.nAf.nAb != null) {
                switch (message.what) {
                    case 1:
                        if (!this.nAf.nAb.aKz()) {
                            this.nAf.nAb = null;
                        }
                        this.nAf.a(this.nAf.nzV, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 2:
                        if (!d.pp(this.nAf.nAb.state)) {
                            if (d.pm(this.nAf.nAb.l(this.nAf.nzh, this.nAf.nzX))) {
                                this.nAf.nzW.obtainMessage(2).sendToTarget();
                            }
                            if (this.nAf.state != 3) {
                                if (this.nAf.state != 5) {
                                    if (this.nAf.state != 1) {
                                        if (this.nAf.state != 0) {
                                            this.nAf.nzV.removeMessages(2);
                                            break;
                                        }
                                        this.nAf.a(this.nAf.nzV, SystemClock.elapsedRealtime(), 0);
                                        break;
                                    }
                                    this.nAf.a(this.nAf.nzV, SystemClock.elapsedRealtime(), 0);
                                    break;
                                }
                                this.nAf.a(this.nAf.nzV, SystemClock.elapsedRealtime(), 0);
                                break;
                            }
                            this.nAf.a(this.nAf.nzV, SystemClock.elapsedRealtime(), this.nAf.nzu.nzl);
                            break;
                        }
                        this.nAf.nzW.obtainMessage(9).sendToTarget();
                        this.nAf.nzV.removeMessages(2);
                        break;
                    case 3:
                        this.nAf.nAb.start();
                        this.nAf.a(this.nAf.nzV, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 4:
                        this.nAf.a(this.nAf.nzV, SystemClock.elapsedRealtime(), 0);
                        this.nAf.nAb.pause();
                        break;
                    case 7:
                        this.nAf.nAb.release();
                        this.nAf.nAa = true;
                        this.nAf.nzW.obtainMessage(0).sendToTarget();
                        break;
                    default:
                        break;
                }
            }
            return false;
        }
    };
    public long nzB;
    public ae nzU;
    public ae nzV;
    public ae nzW;
    public long nzX;
    public boolean nzY = false;
    public k nzZ;
    public long nzh;
    public g nzu;
    public ae nzv;
    public int state;

    public j(ae aeVar, Looper looper, Looper looper2, Looper looper3, boolean z) {
        this.nzv = aeVar;
        this.kmK = false;
        this.nzu = new g(this.kmK);
        this.nzW = new ae(looper, this.nAc);
        this.nzZ = new k(this.nzu, this.nzv);
        this.nzU = new ae(looper2, this.nAd);
        if (looper3 != null) {
            this.nAb = new a(this.nzu, this.nzv);
            this.nzV = new ae(looper3, this.nAe);
        }
    }

    public final void aKB() {
        w.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", this.nzu.aKs(), Long.valueOf(this.nzu.nzi));
        if (this.nzZ != null) {
            this.nzZ.m(this.nzu.nzi, -1);
            this.nzZ.aKw();
            this.nzZ.nzy = 0;
        }
    }

    public final void aKC() {
        if (this.nzZ != null) {
            w.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", this.nzu.aKs());
            this.nzZ.setState(10);
            a(this.nzU, SystemClock.elapsedRealtime(), 0);
        }
    }

    public final void start() {
        setState(3);
        this.nzU.obtainMessage(3).sendToTarget();
        if (this.nAb != null) {
            this.nzV.obtainMessage(3).sendToTarget();
        }
    }

    public final void pause() {
        setState(4);
        this.nzU.obtainMessage(4).sendToTarget();
        if (this.nAb != null) {
            this.nzV.obtainMessage(4).sendToTarget();
        }
    }

    public final void K(int i, boolean z) {
        w.i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", this.nzu.aKs(), Integer.valueOf(i), Boolean.valueOf(true));
        this.nzZ.pause();
        if (this.nAb != null) {
            this.nAb.pause();
        }
        if (((long) i) >= this.nzB) {
            w.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", Integer.valueOf(i), Long.valueOf(this.nzB));
            setState(6);
            this.nzW.obtainMessage(9).sendToTarget();
            return;
        }
        long pt = this.nzZ.pt(i);
        boolean z2 = pt >= 0 && pt < ((long) i);
        w.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", this.nzu.aKs(), Boolean.valueOf(z2), Long.valueOf(pt), Integer.valueOf(i));
        this.nzZ.setState(6);
        setState(6);
        if (z2) {
            this.nzu.nzg = (long) i;
        } else {
            this.nzu.nzg = pt;
        }
        pv(6);
        a(this.nzU, SystemClock.elapsedRealtime(), 0);
    }

    public final void aKD() {
        w.i("MicroMsg.VideoPlayerImpl", "%s seek done", this.nzu.aKs());
        this.nzZ.setState(5);
        if (this.nAb != null) {
            this.nzu.nzj = this.nAb.pt((int) this.nzu.nzg);
            this.nAb.setState(5);
        }
        pv(7);
        setState(4);
        this.nzv.obtainMessage(3, 0, 0).sendToTarget();
        this.nzu.nzi = this.nzu.nzg * 1000;
        this.nzu.nzg = -1;
    }

    public final void stop() {
        setState(8);
    }

    public final void release() {
        setState(9);
        this.nzW.removeMessages(2);
        this.nzW.removeMessages(9);
        this.nzU.removeMessages(1);
        this.nzU.removeMessages(2);
        this.nzU.removeMessages(3);
        this.nzU.removeMessages(4);
        this.nzU.removeMessages(6);
        this.nzU.removeCallbacksAndMessages(null);
        try {
            this.nzZ.setState(9);
            w.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", r0.aKs(), Boolean.valueOf(this.nzZ.nAh));
            if (this.nzZ.nAh && d.eq(19)) {
                this.nzZ.aKx();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.VideoPlayerImpl", e, "release error %s", e.toString());
        }
        this.nzU.obtainMessage(7).sendToTarget();
        if (this.nzV != null) {
            this.nzV.removeMessages(1);
            this.nzV.removeMessages(2);
            this.nzV.removeMessages(3);
            this.nzV.removeMessages(4);
            this.nzV.removeMessages(6);
            this.nzV.obtainMessage(7).sendToTarget();
        }
        g gVar = this.nzu;
        gVar.nze = 0;
        gVar.nzf = 0;
        gVar.nzg = -1;
        gVar.nzh = 0;
        gVar.nzi = 0;
        gVar.nzj = 0;
    }

    protected final void setState(int i) {
        w.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d stack %s", this.nzu.aKs(), Integer.valueOf(this.state), Integer.valueOf(i), bg.bJZ());
        this.state = i;
        this.nzu.nzk = 0;
    }

    public final void pv(int i) {
        w.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", this.nzu.aKs(), Integer.valueOf(i), Long.valueOf(this.nzu.nze), Long.valueOf(this.nzu.nzf), Long.valueOf(this.nzu.nzh));
        g gVar;
        switch (i) {
            case 3:
                if (this.nzu.nzf > 0) {
                    gVar = this.nzu;
                    gVar.nzh += this.nzu.nzf - this.nzu.nze;
                    this.nzu.nzf = 0;
                }
                this.nzu.nze = SystemClock.elapsedRealtime();
                break;
            case 4:
                if (this.nzu.nze > 0) {
                    this.nzu.nzf = SystemClock.elapsedRealtime();
                    break;
                }
                this.nzu.nzf = 0;
                break;
            case 5:
                this.nzu.nzh = this.nzu.nzg;
                this.nzu.nze = SystemClock.elapsedRealtime();
                this.nzu.nzf = 0;
                gVar = this.nzu;
                this.nzu.nzj = 0;
                gVar.nzi = 0;
                break;
            case 6:
                this.nzu.nzh = this.nzu.nzg;
                gVar = this.nzu;
                this.nzu.nzf = 0;
                gVar.nze = 0;
                gVar = this.nzu;
                this.nzu.nzj = 0;
                gVar.nzi = 0;
                break;
            case 7:
                this.nzu.nzh = this.nzu.nzg;
                gVar = this.nzu;
                this.nzu.nzf = 0;
                gVar.nze = 0;
                break;
        }
        this.nzX = this.nzu.nze;
        this.nzh = this.nzu.nzh;
        w.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", this.nzu.aKs(), Integer.valueOf(i), Long.valueOf(this.nzX), Long.valueOf(this.nzh));
    }

    public final void a(ae aeVar, long j, long j2) {
        if (!d.pp(this.state)) {
            try {
                Thread thread = aeVar.getLooper().getThread();
                if (!(thread == null || thread.isAlive())) {
                    return;
                }
            } catch (Exception e) {
            }
            aeVar.removeMessages(2);
            long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
            if (elapsedRealtime <= 0) {
                aeVar.sendEmptyMessage(2);
            } else {
                aeVar.sendEmptyMessageDelayed(2, elapsedRealtime);
            }
        }
    }
}
