package com.tencent.mm.plugin.music.a.e;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.plugin.music.a.f;
import com.tencent.mm.plugin.music.a.g;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public abstract class a implements c {
    private ap nTQ;
    public boolean nTR;
    public com.tencent.mm.plugin.music.a.e.c.a nTS;

    public final void aOb() {
        this.nTQ = new ap();
        this.nTQ.ek(ab.getContext());
        this.nTQ.a(new com.tencent.mm.sdk.platformtools.ap.a(this) {
            final /* synthetic */ a nTT;

            {
                this.nTT = r1;
            }

            public final void dL(int i) {
                switch (i) {
                    case 0:
                        if (this.nTT.nTR) {
                            this.nTT.nTR = false;
                            this.nTT.resume();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        if (this.nTT.HJ()) {
                            this.nTT.nTR = true;
                            this.nTT.pause();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public final void l(anf com_tencent_mm_protocal_c_anf) {
        w.i("MicroMsg.BaseMusicPlayer", "onStartEvent %b", new Object[]{Boolean.valueOf(HJ())});
        b jcVar = new jc();
        jcVar.fPc.action = 0;
        jcVar.fPc.fOY = com_tencent_mm_protocal_c_anf;
        jcVar.fPc.state = "play";
        jcVar.fPc.duration = (long) getDuration();
        jcVar.fPc.fPe = aNH();
        com.tencent.mm.sdk.b.a.urY.a(jcVar, Looper.getMainLooper());
        g.aNP();
        g.nTh = System.currentTimeMillis();
        g.nTi = i.aNS().aNI();
    }

    public final void m(anf com_tencent_mm_protocal_c_anf) {
        w.i("MicroMsg.BaseMusicPlayer", "onResumeEvent");
        b jcVar = new jc();
        jcVar.fPc.action = 1;
        jcVar.fPc.fOY = com_tencent_mm_protocal_c_anf;
        jcVar.fPc.state = "play";
        jcVar.fPc.duration = (long) getDuration();
        jcVar.fPc.fPe = aNH();
        com.tencent.mm.sdk.b.a.urY.a(jcVar, Looper.getMainLooper());
        g.nTh = System.currentTimeMillis();
    }

    public final void n(anf com_tencent_mm_protocal_c_anf) {
        w.i("MicroMsg.BaseMusicPlayer", "onPauseEvent");
        b jcVar = new jc();
        jcVar.fPc.action = 3;
        jcVar.fPc.fOY = com_tencent_mm_protocal_c_anf;
        jcVar.fPc.state = "pause";
        jcVar.fPc.duration = (long) getDuration();
        jcVar.fPc.fPe = aNH();
        com.tencent.mm.sdk.b.a.urY.a(jcVar, Looper.getMainLooper());
        g.qP();
    }

    public final void o(anf com_tencent_mm_protocal_c_anf) {
        w.i("MicroMsg.BaseMusicPlayer", "onStopEvent");
        b jcVar = new jc();
        jcVar.fPc.action = 2;
        jcVar.fPc.fOY = com_tencent_mm_protocal_c_anf;
        jcVar.fPc.state = "stop";
        jcVar.fPc.duration = (long) getDuration();
        jcVar.fPc.fPe = aNH();
        com.tencent.mm.sdk.b.a.urY.a(jcVar, Looper.getMainLooper());
        g.aNP();
    }

    public final void p(anf com_tencent_mm_protocal_c_anf) {
        w.i("MicroMsg.BaseMusicPlayer", "onSeekToEvent");
        b jcVar = new jc();
        jcVar.fPc.action = 8;
        jcVar.fPc.fOY = com_tencent_mm_protocal_c_anf;
        jcVar.fPc.state = "seeked";
        jcVar.fPc.duration = (long) getDuration();
        jcVar.fPc.fPe = aNH();
        com.tencent.mm.sdk.b.a.urY.a(jcVar, Looper.getMainLooper());
        g.aNP();
    }

    public final void q(anf com_tencent_mm_protocal_c_anf) {
        w.i("MicroMsg.BaseMusicPlayer", "onStopEvent");
        b jcVar = new jc();
        jcVar.fPc.action = 7;
        jcVar.fPc.fOY = com_tencent_mm_protocal_c_anf;
        jcVar.fPc.state = "ended";
        jcVar.fPc.duration = (long) getDuration();
        jcVar.fPc.fPe = aNH();
        com.tencent.mm.sdk.b.a.urY.a(jcVar, Looper.getMainLooper());
        g.aNP();
        if (i.aNS().mode == 2) {
            f aNS = i.aNS();
            if (aNS.mode != 1) {
                aNS.nST++;
                aNS.nST %= aNS.nSU.size();
                aNS.e(null);
            }
        }
    }

    public final void a(anf com_tencent_mm_protocal_c_anf, int i) {
        int i2 = CdnLogic.MediaType_FAVORITE_FILE;
        w.i("MicroMsg.BaseMusicPlayer", "onErrorEvent with errCode:%d", new Object[]{Integer.valueOf(i)});
        b jcVar = new jc();
        jcVar.fPc.action = 4;
        jcVar.fPc.fOY = com_tencent_mm_protocal_c_anf;
        jcVar.fPc.state = "error";
        jcVar.fPc.duration = (long) getDuration();
        jcVar.fPc.fPe = aNH();
        com.tencent.mm.e.a.jc.a aVar = jcVar.fPc;
        w.i("MicroMsg.PlayerErrorHandler", "getErrCodeType, errorCode: %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                i2 = 10003;
                break;
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
            case 63:
            case 64:
            case 101:
                i2 = 10004;
                break;
            case 62:
            case 66:
            case 67:
            case 69:
            case 74:
            case 102:
            case 500:
            case 501:
            case 502:
            case 503:
            case 504:
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                i2 = CdnLogic.MediaType_FAVORITE_VIDEO;
                break;
            default:
                i2 = -1;
                break;
        }
        aVar.errCode = i2;
        com.tencent.mm.e.a.jc.a aVar2 = jcVar.fPc;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("errCode:" + i + ", err:");
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                stringBuilder.append("file not found");
                break;
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                stringBuilder.append("file can not read");
                break;
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                stringBuilder.append("unknow format");
                break;
            case 62:
                stringBuilder.append("load or init native decode so fail");
                break;
            case 63:
                stringBuilder.append("get audio info fail");
                break;
            case 64:
                stringBuilder.append("invalid audio info");
                break;
            case 66:
                stringBuilder.append("create AudioTrack fail");
                break;
            case 67:
                stringBuilder.append("decode audio fail");
                break;
            case 69:
                stringBuilder.append("so file not found");
                break;
            case 74:
                stringBuilder.append("invalid seek or seek fail");
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                stringBuilder.append("connect network fail");
                break;
            case 101:
                stringBuilder.append("recognition audio format error");
                break;
            case 102:
                stringBuilder.append("write AudioTrack data fail");
                break;
            case 500:
                stringBuilder.append("error URL format");
                break;
            case 501:
                stringBuilder.append("error player to prepare");
                break;
            case 502:
                stringBuilder.append("error player to start");
                break;
            case 503:
                stringBuilder.append("error player to pause");
                break;
            case 504:
                stringBuilder.append("error player to stop");
                break;
            default:
                stringBuilder.append("unknow exception");
                break;
        }
        aVar2.fPf = stringBuilder.toString();
        com.tencent.mm.sdk.b.a.urY.a(jcVar, Looper.getMainLooper());
        g.aNP();
    }

    public final void r(anf com_tencent_mm_protocal_c_anf) {
        w.i("MicroMsg.BaseMusicPlayer", "onErrorEvent");
        a(com_tencent_mm_protocal_c_anf, -1);
    }

    public final void a(com.tencent.mm.plugin.music.a.e.c.a aVar) {
        this.nTS = aVar;
    }
}
