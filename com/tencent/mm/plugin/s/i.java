package com.tencent.mm.plugin.s;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class i {
    Looper nzL;
    ae nzM;
    HandlerThread nzN;
    HandlerThread nzO;
    HandlerThread nzP;
    public j nzQ;
    public c nzR;
    private a nzS;

    public i(Looper looper) {
        this(looper, (byte) 0);
    }

    private i(Looper looper, byte b) {
        this.nzS = new a(this) {
            final /* synthetic */ i nzT;

            {
                this.nzT = r1;
            }

            public final boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        w.i("MicroMsg.VideoPlayer", "%s call prepared ", this.nzT.aKs());
                        if (this.nzT.nzR != null) {
                            this.nzT.nzR.Uc();
                            break;
                        }
                        break;
                    case 2:
                        w.i("MicroMsg.VideoPlayer", "%s call completion ", this.nzT.aKs());
                        if (this.nzT.nzR != null) {
                            this.nzT.nzR.oW();
                            break;
                        }
                        break;
                    case 3:
                        w.i("MicroMsg.VideoPlayer", "%s call seek completion ", this.nzT.aKs());
                        if (this.nzT.nzR != null) {
                            this.nzT.nzR.aKn();
                            break;
                        }
                        break;
                    case 4:
                        w.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", this.nzT.aKs(), Integer.valueOf(message.arg1), Integer.valueOf(message.arg2), Integer.valueOf(((Integer) message.obj).intValue()));
                        if (this.nzT.nzR != null) {
                            this.nzT.nzR.E(message.arg1, message.arg2, ((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 5:
                        w.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", this.nzT.aKs(), Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
                        if (this.nzT.nzR != null) {
                            this.nzT.nzR.onError(message.arg1, message.arg2);
                            break;
                        }
                        break;
                    case 6:
                        try {
                            i iVar = this.nzT;
                            w.i("MicroMsg.VideoPlayer", "%s clear now.", iVar.aKs());
                            iVar.nzN.quit();
                            iVar.nzO.quit();
                            if (iVar.nzP != null) {
                                iVar.nzP.quit();
                            }
                            iVar.nzM.removeMessages(1);
                            iVar.nzM.removeMessages(2);
                            iVar.nzM.removeMessages(3);
                            iVar.nzM.removeMessages(4);
                            iVar.nzM.removeMessages(5);
                            iVar.nzN = null;
                            iVar.nzO = null;
                            iVar.nzM = null;
                            iVar.nzL = null;
                            iVar.nzR = null;
                            iVar.nzQ = null;
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    default:
                        w.w("MicroMsg.VideoPlayer", "%s it has no idea for msg %d ", this.nzT.aKs(), Integer.valueOf(message.what));
                        break;
                }
                return false;
            }
        };
        this.nzN = e.cE("VideoPlayer:inner", -16);
        this.nzN.start();
        this.nzO = e.cE("VideoPlayer:video", -16);
        this.nzO.start();
        this.nzP = e.cE("VideoPlayer:audio", -16);
        this.nzP.start();
        this.nzL = looper;
        this.nzM = new ae(this.nzL, this.nzS);
        this.nzQ = new j(this.nzM, this.nzN.getLooper(), this.nzO.getLooper(), this.nzP != null ? this.nzP.getLooper() : null, false);
    }

    public final void setPath(String str) {
        w.i("MicroMsg.VideoPlayer", "%s video player set path %s", aKs(), str);
        j jVar = this.nzQ;
        w.i("MicroMsg.VideoPlayerImpl", "%s set path %s", jVar.nzu.aKs(), str);
        jVar.nzZ.setPath(str);
        if (jVar.nAb != null) {
            jVar.nAb.setPath(str);
        }
    }

    public final void fB(boolean z) {
        if (this.nzQ != null) {
            j jVar = this.nzQ;
            if (jVar.nzu != null) {
                jVar.nzu.nzn = z;
            }
        }
    }

    public final void fC(boolean z) {
        if (this.nzQ != null) {
            j jVar = this.nzQ;
            if (jVar.nzu != null) {
                w.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", jVar.nzu.aKs(), Boolean.valueOf(z));
                jVar.nzu.nzo = z;
            }
        }
    }

    public final void setSurface(Surface surface) {
        if (surface != null) {
            w.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", this.nzQ.nzu.aKs(), Integer.valueOf(surface.hashCode()));
            r0.nzZ.nAg = surface;
        }
    }

    public final boolean aKz() {
        j jVar = this.nzQ;
        w.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", jVar.nzu.aKs());
        jVar.nzU.obtainMessage(1).sendToTarget();
        if (jVar.nAb != null) {
            jVar.nzV.obtainMessage(1).sendToTarget();
        }
        return true;
    }

    public final void start() {
        w.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", aKs(), Integer.valueOf(this.nzQ.state), bg.bJZ());
        if (d.pq(this.nzQ.state) || d.po(this.nzQ.state)) {
            w.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", aKs());
            return;
        }
        this.nzQ.start();
    }

    public final void pause() {
        w.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", aKs(), Integer.valueOf(this.nzQ.state), bg.bJZ());
        if (d.pq(this.nzQ.state) || d.po(this.nzQ.state)) {
            w.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", aKs());
            return;
        }
        this.nzQ.pause();
    }

    public final void pu(int i) {
        this.nzQ.K(i, true);
    }

    public final void bQ(boolean z) {
        try {
            if (this.nzQ != null) {
                j jVar = this.nzQ;
                if (jVar.nAb != null) {
                    w.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", jVar.nzu.aKs(), Boolean.valueOf(z));
                    jVar.nAb.bQ(z);
                }
            }
        } catch (Exception e) {
        }
    }

    public final void release() {
        try {
            this.nzQ.release();
        } catch (Exception e) {
        }
    }

    public final int aKA() {
        j jVar = this.nzQ;
        if (jVar.nzu == null) {
            return 0;
        }
        int i = (int) (jVar.nzu.nzi / 1000);
        int i2 = (int) jVar.nzu.nzg;
        if (i2 != -1) {
            i = i2;
        }
        if (((long) i) < jVar.nzu.nzj / 1000) {
            i = (int) (jVar.nzu.nzj / 1000);
        }
        w.i("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", jVar.nzu.aKs(), Integer.valueOf(i), Long.valueOf(jVar.nzu.nzi), Long.valueOf(jVar.nzu.nzj));
        return i;
    }

    public final boolean isPlaying() {
        return d.pn(this.nzQ.state);
    }

    public final String aKs() {
        return this.nzQ != null ? this.nzQ.nzu.aKs() : "has no player!";
    }
}
