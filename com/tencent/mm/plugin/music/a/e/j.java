package com.tencent.mm.plugin.music.a.e;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.am.d;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.plugin.music.a.g;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.ILog;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;
import java.util.ArrayList;

public class j extends a {
    public AudioType audioType = AudioType.UNSUPPORT;
    protected com.tencent.mm.am.a fPd;
    public int iMR = 0;
    private boolean nSC;
    public boolean nSM;
    public boolean nSO = false;
    public CommonPlayer nUj;
    private d nUk;
    public a nUl;
    private IMediaHTTPService nUm;
    public String nUn = "";
    public int nUo = 0;
    private long nUp = 0;
    private boolean nUq = false;
    private PlayerListenerCallback nUr = new PlayerListenerCallback(this) {
        final /* synthetic */ j nUs;
        com.tencent.mm.am.a nUt = null;

        {
            this.nUs = r2;
        }

        public final void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i) {
        }

        public final void onCompletion(BaseMediaPlayer baseMediaPlayer) {
            w.i("MicroMsg.QQMusicPlayer", "onCompletion");
        }

        public final void onSeekComplete(BaseMediaPlayer baseMediaPlayer) {
            w.i("MicroMsg.QQMusicPlayer", "onSeekComplete");
            if (this.nUs.iMR != 0) {
                w.i("MicroMsg.QQMusicPlayer", "seek complete to startTime :%d", new Object[]{Integer.valueOf(this.nUs.iMR)});
                this.nUs.iMR = 0;
                aOo();
                return;
            }
            w.i("MicroMsg.QQMusicPlayer", "_onSeekComplete");
            if (this.nUt == null) {
                w.e("MicroMsg.QQMusicPlayer", "cbMusic is null");
                return;
            }
            anf HG = this.nUt.HG();
            this.nUs.p(HG);
            if (this.nUs.HJ()) {
                w.i("MicroMsg.QQMusicPlayer", "seek end, send play event!");
                this.nUs.m(HG);
            }
        }

        public final void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3) {
            w.e("MicroMsg.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            com.tencent.mm.am.a aNI = i.aNS().aNI();
            if (aNI == null) {
                w.e("MicroMsg.QQMusicPlayer", "onError, currentMusic is null");
            } else if (this.nUt == null) {
                w.e("MicroMsg.QQMusicPlayer", "onError, cbMusic is null");
            } else {
                boolean isNetworkConnected = am.isNetworkConnected(ab.getContext());
                if (i2 == 80 && isNetworkConnected) {
                    w.e("MicroMsg.QQMusicPlayer", "connect success, but download is fail!");
                }
                if (this.nUs.nUo > 1) {
                    w.e("MicroMsg.QQMusicPlayer", "errorCount %d", new Object[]{Integer.valueOf(this.nUs.nUo)});
                    return;
                }
                j jVar = this.nUs;
                jVar.nUo++;
                j.b(this.nUt, i2);
                anf HG = this.nUt.HG();
                if (aNI.a(this.nUt)) {
                    this.nUs.adL();
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 nUu;

                        {
                            this.nUu = r1;
                        }

                        public final void run() {
                            Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.eCB), 0).show();
                        }
                    });
                }
                this.nUs.o(HG);
                this.nUs.a(HG, i2);
                if (this.nUs.nUl != null) {
                    this.nUs.nUl.isStop = true;
                    this.nUs.nUl = null;
                }
                if (i == 91 && i2 == 55) {
                    w.i("MicroMsg.QQMusicPlayer", "unknow format ,delete file");
                    com.tencent.mm.plugin.music.a.a.d.tv(this.nUs.nUn);
                }
            }
        }

        public final void onPrepared(BaseMediaPlayer baseMediaPlayer) {
            w.i("MicroMsg.QQMusicPlayer", "onPrepared");
        }

        public final void onStateChanged(int i) {
            w.i("MicroMsg.QQMusicPlayer", "onStateChanged state %d", new Object[]{Integer.valueOf(i)});
            if (i == 3) {
                w.i("MicroMsg.QQMusicPlayer", "onStateChanged PREPARING!");
                w.i("MicroMsg.QQMusicPlayer", "_onPreparing");
                this.nUt = this.nUs.fPd;
                if (this.nUt == null) {
                    w.e("MicroMsg.QQMusicPlayer", "cbMusic is null");
                    return;
                }
                anf HG = this.nUt.HG();
                a aVar = this.nUs;
                w.i("MicroMsg.BaseMusicPlayer", "onPreparintEvent %b", new Object[]{Boolean.valueOf(aVar.HJ())});
                b jcVar = new jc();
                jcVar.fPc.action = 11;
                jcVar.fPc.fOY = HG;
                jcVar.fPc.state = "waiting";
                jcVar.fPc.duration = (long) aVar.getDuration();
                jcVar.fPc.fPe = aVar.aNH();
                com.tencent.mm.sdk.b.a.urY.a(jcVar, Looper.getMainLooper());
            } else if (i == 2) {
                w.i("MicroMsg.QQMusicPlayer", "onStateChanged PREPARED!");
                aOo();
            } else if (i == 4) {
                w.i("MicroMsg.QQMusicPlayer", "onStateChanged STARTED!");
                w.i("MicroMsg.QQMusicPlayer", "_onStart");
                this.nUt = this.nUs.fPd;
                if (this.nUt == null) {
                    w.e("MicroMsg.QQMusicPlayer", "cbMusic is null");
                    return;
                }
                this.nUs.l(this.nUt.HG());
                if (this.nUs.nUl != null) {
                    this.nUs.nUl.isStop = true;
                }
                this.nUs.nUl = new a(this.nUs);
                Runnable runnable = this.nUs.nUl;
                runnable.isStop = false;
                e.post(runnable, "music_play_progress_runnable");
            } else if (i == 5) {
                w.i("MicroMsg.QQMusicPlayer", "onStateChanged PAUSED!");
                w.i("MicroMsg.QQMusicPlayer", "_onPause");
                if (this.nUt == null) {
                    w.e("MicroMsg.QQMusicPlayer", "cbMusic is null");
                    return;
                }
                this.nUs.n(this.nUt.HG());
            } else if (i == 6) {
                w.i("MicroMsg.QQMusicPlayer", "onStateChanged STOPPED!");
                w.i("MicroMsg.QQMusicPlayer", "_onStop");
                if (this.nUt == null) {
                    w.e("MicroMsg.QQMusicPlayer", "cbMusic is null");
                } else if (i.aNS().aNI() == null) {
                    w.e("MicroMsg.QQMusicPlayer", "currentMusic is null");
                } else if (this.nUs.fPd.a(this.nUt)) {
                    this.nUs.o(this.nUs.fPd.HG());
                }
            } else if (i == 7) {
                w.i("MicroMsg.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
                w.i("MicroMsg.QQMusicPlayer", "_onCompletion");
                if (this.nUt == null) {
                    w.e("MicroMsg.QQMusicPlayer", "cbMusic is null");
                    return;
                }
                this.nUs.nSM = false;
                this.nUs.q(this.nUt.HG());
                if (this.nUs.nUl != null) {
                    this.nUs.nUl.isStop = true;
                    this.nUs.nUl = null;
                }
            } else if (i == 8) {
                w.i("MicroMsg.QQMusicPlayer", "onStateChanged END!");
                w.i("MicroMsg.QQMusicPlayer", "_onEnd");
            } else if (i == 9) {
                w.i("MicroMsg.QQMusicPlayer", "onStateChanged ERROR!");
            }
        }

        public final void onStarted(BaseMediaPlayer baseMediaPlayer) {
            w.i("MicroMsg.QQMusicPlayer", "onStarted");
        }

        private void aOo() {
            w.i("MicroMsg.QQMusicPlayer", "_onPrepared");
            if (this.nUs.iMR != 0) {
                w.i("MicroMsg.QQMusicPlayer", "seek to startTime:%d", new Object[]{Integer.valueOf(this.nUs.iMR)});
                this.nUs.gi(this.nUs.iMR);
                return;
            }
            w.i("MicroMsg.QQMusicPlayer", "start to play");
            if (i.aNV().requestFocus()) {
                try {
                    if (this.nUs.nUj != null) {
                        this.nUs.nUj.start();
                        if (!(this.nUs.nUj.getCurrentAudioInformation() == null || this.nUs.nUj.getCurrentAudioInformation().getAudioType() == null)) {
                            w.i("MicroMsg.QQMusicPlayer", "getAudioType:%d", new Object[]{Integer.valueOf(this.nUs.nUj.getCurrentAudioInformation().getAudioType().getValue())});
                            this.nUs.audioType = this.nUs.nUj.getCurrentAudioInformation().getAudioType();
                            this.nUs.aOn();
                        }
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.QQMusicPlayer", e, "_onPrepared", new Object[0]);
                    this.nUs.a(this.nUs.fPd.HG(), 502);
                    j.b(this.nUs.fPd, 502);
                }
                this.nUs.nSM = true;
                if (this.nUt == null) {
                    w.e("MicroMsg.QQMusicPlayer", "cbMusic is null");
                    return;
                }
                anf HG = this.nUt.HG();
                a aVar = this.nUs;
                w.i("MicroMsg.BaseMusicPlayer", "onPrepareEvent %b", new Object[]{Boolean.valueOf(aVar.HJ())});
                b jcVar = new jc();
                jcVar.fPc.action = 9;
                jcVar.fPc.fOY = HG;
                jcVar.fPc.state = "canplay";
                jcVar.fPc.duration = (long) aVar.getDuration();
                jcVar.fPc.fPe = aVar.aNH();
                com.tencent.mm.sdk.b.a.urY.a(jcVar, Looper.getMainLooper());
                return;
            }
            w.e("MicroMsg.QQMusicPlayer", "request focus error");
        }
    };

    private class a implements Runnable {
        boolean isStop = true;
        final /* synthetic */ j nUs;

        public a(j jVar) {
            this.nUs = jVar;
        }

        public final void run() {
            w.i("MicroMsg.QQMusicPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (this.nUs.nUj != null && this.nUs.HJ()) {
                        this.nUs.aOm();
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.QQMusicPlayer", "PlayProgressTask run exception:" + e.getMessage());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    public j() {
        aOb();
        AudioPlayerConfigure.setLog(new ILog(this) {
            final /* synthetic */ j nUs;

            {
                this.nUs = r1;
            }

            public final void d(String str, String str2) {
                w.d(str, str2);
            }

            public final void w(String str, String str2) {
                w.w(str, str2);
            }

            public final void e(String str, String str2) {
                w.e(str, str2);
            }

            public final void i(String str, String str2) {
                w.i(str, str2);
            }

            public final void i(String str, String str2, Throwable th) {
                w.i(str, str2, new Object[]{th});
            }

            public final void e(String str, Throwable th) {
                w.printErrStackTrace(str, th, " throwable", new Object[0]);
            }

            public final void e(String str, String str2, Throwable th) {
                w.printErrStackTrace(str, th, str2, new Object[0]);
            }

            public final void e(String str, String str2, Object... objArr) {
                w.e(str, String.format(str2, objArr));
            }
        });
        AudioPlayerConfigure.setSoLibraryLoader(new ISoLibraryLoader(this) {
            final /* synthetic */ j nUs;

            {
                this.nUs = r1;
            }

            public final boolean load(String str) {
                if (TextUtils.isEmpty(str)) {
                    w.e("MicroMsg.QQMusicPlayer", "LoadLibrary lib_name is null");
                    return false;
                } else if (k.dx(str)) {
                    return true;
                } else {
                    w.i("MicroMsg.QQMusicPlayer", "load library %s", new Object[]{str});
                    ClassLoader classLoader = j.class.getClassLoader();
                    if (TextUtils.isEmpty(k.dy(str))) {
                        w.e("MicroMsg.QQMusicPlayer", "LoadLibrary can't find the lib %s so", new Object[]{str});
                        return false;
                    }
                    w.i("MicroMsg.QQMusicPlayer", "LoadLibrary find and load the lib %s so", new Object[]{k.dy(str)});
                    k.b(str, classLoader);
                    return true;
                }
            }
        });
    }

    public final void b(com.tencent.mm.am.a aVar) {
        int i = 1;
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.nUp;
        if (this.fPd == null || !this.fPd.a(aVar) || j > 3000) {
            URL url;
            g.d(aVar, false);
            this.nUp = currentTimeMillis;
            this.fPd = aVar;
            w.i("MicroMsg.QQMusicPlayer", "startPlay, currentTime:%d", new Object[]{Long.valueOf(currentTimeMillis)});
            if (this.nUj != null && HJ()) {
                this.nUj.stop();
            }
            this.nUo = 0;
            this.iMR = aVar.field_startTime;
            this.audioType = null;
            this.nUq = false;
            w.i("MicroMsg.QQMusicPlayer", "initPlayer");
            boolean isWifi = am.isWifi(ab.getContext());
            PBool pBool = new PBool();
            this.nUn = h.a(bg.mA(this.fPd.field_songWifiUrl) ? this.fPd.field_songWebUrl : this.fPd.field_songWifiUrl, this.fPd.field_songWapLinkUrl, true, pBool);
            String str = "MicroMsg.QQMusicPlayer";
            String str2 = "isWifi:%d, isQQMusic:%d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(isWifi ? 1 : 0);
            objArr[1] = Integer.valueOf(pBool.value ? 1 : 0);
            w.i(str, str2, objArr);
            boolean z = isWifi ? pBool.value : false;
            if (h.Br(this.nUn)) {
                w.i("MicroMsg.QQMusicPlayer", "can match shake music wifi url");
                z = true;
            }
            w.i("MicroMsg.QQMusicPlayer", "mSrc:%s", new Object[]{this.nUn});
            w.i("MicroMsg.QQMusicPlayer", "field_songWifiUrl:%s", new Object[]{this.fPd.field_songWifiUrl});
            String str3 = "MicroMsg.QQMusicPlayer";
            String str4 = "isqqmusic:%d";
            Object[] objArr2 = new Object[1];
            if (!z) {
                i = 0;
            }
            objArr2[0] = Integer.valueOf(i);
            w.i(str3, str4, objArr2);
            com.tencent.mm.plugin.music.a.a.d.Bx(this.nUn);
            com.tencent.mm.plugin.music.a.a.d.ad(this.nUn, z);
            try {
                url = new URL(this.nUn);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.QQMusicPlayer", e, "initPlayer", new Object[0]);
                w.e("MicroMsg.QQMusicPlayer", "new URL exception:" + e.getMessage());
                a(this.fPd.HG(), 500);
                b(this.fPd, 500);
                url = null;
            }
            if (this.nUj == null) {
                this.nUj = new CommonPlayer(this.nUr);
            }
            this.nUj.reset();
            if (this.nUm == null) {
                this.nUm = new com.tencent.mm.plugin.music.a.d.b();
            }
            try {
                this.nUj.setDataSource(this.nUm, Uri.parse(url.toString()));
                this.nUj.prepare();
                return;
            } catch (Throwable e2) {
                w.e("MicroMsg.QQMusicPlayer", "initPlayer exception:" + e2.getMessage());
                w.printErrStackTrace("MicroMsg.QQMusicPlayer", e2, "initPlayer", new Object[0]);
                a(this.fPd.HG(), 501);
                b(this.fPd, 501);
                return;
            }
        }
        this.fPd = aVar;
        w.e("MicroMsg.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 1 minute, interval:%d", new Object[]{this.nUn, Long.valueOf(j)});
    }

    public final void pause() {
        this.nSO = false;
        w.i("MicroMsg.QQMusicPlayer", "pause");
        if (this.nUj != null && HJ()) {
            try {
                this.nUj.pause();
                this.nSC = true;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.QQMusicPlayer", e, "pause", new Object[0]);
                a(this.fPd.HG(), 503);
                b(this.fPd, 503);
            }
        }
    }

    public final void aNC() {
        w.i("MicroMsg.QQMusicPlayer", "pauseAndAbandonFocus");
        pause();
        i.aNV().aNB();
    }

    public final boolean aND() {
        return this.nSM && this.nSO;
    }

    public final void aNE() {
        this.nSO = true;
        w.i("MicroMsg.QQMusicPlayer", "passivePause");
        if (this.nUj != null && HJ()) {
            try {
                this.nUj.pause();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.QQMusicPlayer", e, "passivePause", new Object[0]);
                a(this.fPd.HG(), 503);
                b(this.fPd, 503);
            }
        }
    }

    public final void resume() {
        this.nUo = 0;
        w.i("MicroMsg.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[]{Boolean.valueOf(aOl()), Boolean.valueOf(HJ())});
        if (this.nUj != null && !r0 && !r1) {
            if (i.aNV().requestFocus()) {
                try {
                    this.nUj.start();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.QQMusicPlayer", e, "resume", new Object[0]);
                    a(this.fPd.HG(), 502);
                    b(this.fPd, 502);
                }
                m(i.aNS().aNJ());
            } else {
                w.e("MicroMsg.QQMusicPlayer", "request focus error");
            }
            this.nSM = true;
        }
    }

    public final boolean HJ() {
        if (this.nUj == null || this.nUj.getPlayerState() != 4) {
            return false;
        }
        return true;
    }

    private boolean aOl() {
        if (this.nUj == null || this.nUj.getPlayerState() != 3) {
            return false;
        }
        return true;
    }

    public final boolean HK() {
        return this.nSM && !aOl();
    }

    public final void adL() {
        w.i("MicroMsg.QQMusicPlayer", "stopPlay");
        try {
            if (this.nUj != null) {
                this.nUj.stop();
            }
            if (this.nUl != null) {
                this.nUl.isStop = true;
                this.nUl = null;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.QQMusicPlayer", e, "stopPlay", new Object[0]);
            a(this.fPd.HG(), 504);
            b(this.fPd, 504);
        }
        i.aNV().aNB();
        this.nSM = false;
        this.nSO = false;
    }

    public final int getDuration() {
        if (this.nUj != null) {
            return this.nUj.getDuration();
        }
        return -1;
    }

    public final boolean gi(int i) {
        int duration = getDuration();
        w.i("MicroMsg.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(duration)});
        if (duration < 0 || i > duration) {
            w.e("MicroMsg.QQMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(duration)});
            adL();
            return false;
        } else if (this.nUj == null) {
            return true;
        } else {
            anf HG = this.fPd.HG();
            w.i("MicroMsg.BaseMusicPlayer", "onSeekingEvent");
            b jcVar = new jc();
            jcVar.fPc.action = 12;
            jcVar.fPc.fOY = HG;
            jcVar.fPc.state = "seeking";
            jcVar.fPc.duration = (long) getDuration();
            jcVar.fPc.fPe = aNH();
            com.tencent.mm.sdk.b.a.urY.a(jcVar, Looper.getMainLooper());
            g.aNP();
            this.nUj.seekTo(i);
            return true;
        }
    }

    public final d aNG() {
        int bufferedPercentage;
        int i = 0;
        int duration = getDuration();
        int currentPosition = this.nUj != null ? (int) this.nUj.getCurrentPosition() : -1;
        boolean HJ = HJ();
        if (this.nUj != null) {
            bufferedPercentage = this.nUj.getBufferedPercentage();
        } else {
            bufferedPercentage = 0;
        }
        if (bufferedPercentage < 0 || bufferedPercentage > 100) {
            bufferedPercentage = 0;
        }
        if (bufferedPercentage < 0) {
            bufferedPercentage = 0;
        }
        if (this.nUk != null) {
            d dVar = this.nUk;
            if (HJ) {
                i = 1;
            }
            dVar.f(duration, currentPosition, i, bufferedPercentage);
        } else {
            if (HJ) {
                i = 1;
            }
            this.nUk = new d(duration, currentPosition, i, bufferedPercentage);
        }
        this.nUk.fPe = true;
        return this.nUk;
    }

    public static void b(com.tencent.mm.am.a aVar, int i) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(558);
        iDKey.SetKey(4);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(558);
        int i2 = aVar.field_musicType;
        w.i("MicroMsg.PlayerErrorHandler", "getQQMusicPlayerErrIdKeyByMusicType, musicType:" + i2);
        switch (i2) {
            case 0:
                i2 = 49;
                break;
            case 1:
                i2 = 50;
                break;
            case 4:
                i2 = 51;
                break;
            case 5:
                i2 = 52;
                break;
            case 6:
                i2 = 53;
                break;
            case 7:
                i2 = 54;
                break;
            case 8:
                i2 = 55;
                break;
            case 9:
                i2 = 56;
                break;
            case 10:
                i2 = 7;
                break;
            case 11:
                i2 = 8;
                break;
            default:
                i2 = 9;
                break;
        }
        iDKey2.SetKey(i2);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(558);
        w.i("MicroMsg.PlayerErrorHandler", "getErrIdKey, errCode:" + i);
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                i2 = 17;
                break;
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                i2 = 18;
                break;
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                i2 = 19;
                break;
            case 62:
                i2 = 20;
                break;
            case 63:
                i2 = 21;
                break;
            case 64:
                i2 = 22;
                break;
            case 66:
                i2 = 23;
                break;
            case 67:
                i2 = 24;
                break;
            case 69:
                i2 = 25;
                break;
            case 74:
                i2 = 26;
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                i2 = 27;
                break;
            case 101:
                i2 = 28;
                break;
            case 102:
                i2 = 29;
                break;
            case 500:
                i2 = 31;
                break;
            case 501:
                i2 = 32;
                break;
            case 502:
                i2 = 33;
                break;
            case 503:
                i2 = 34;
                break;
            case 504:
                i2 = 35;
                break;
            default:
                i2 = 30;
                break;
        }
        iDKey3.SetKey(i2);
        iDKey3.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        com.tencent.mm.plugin.report.service.g.oUh.b(arrayList, true);
    }

    public final void aOm() {
        com.tencent.mm.am.a aNI = i.aNS().aNI();
        if (aNI != null && aNI.a(this.fPd) && this.nUj != null && HJ()) {
            int currentPosition = (int) this.nUj.getCurrentPosition();
            int duration = this.nUj.getDuration();
            if (currentPosition > 0 && duration > 0 && this.nTS != null) {
                this.nTS.cx(currentPosition, duration);
            }
        }
    }

    public final boolean aNH() {
        return true;
    }

    public final void aOn() {
        if (this.audioType != null) {
            w.i("MicroMsg.QQMusicPlayer", "idKeyReportMusicMimeType audioType:%d, isStatMineType:%b", new Object[]{Integer.valueOf(this.audioType.getValue()), Boolean.valueOf(this.nUq)});
            if (!this.nUq) {
                w.i("MicroMsg.QQMusicPlayer", "idKeyReportMusicMimeType OK");
                this.nUq = true;
                IDKey iDKey = new IDKey();
                iDKey.SetID(558);
                int value = this.audioType.getValue();
                value = value == 2 ? 92 : value == 3 ? 93 : value == 4 ? 94 : value == 5 ? 95 : value == 6 ? 96 : value == 7 ? 97 : value == 8 ? 98 : value == 9 ? 99 : 100;
                iDKey.SetKey(value);
                iDKey.SetValue(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDKey);
                com.tencent.mm.plugin.report.service.g.oUh.b(arrayList, true);
                Object Bz = com.tencent.mm.plugin.music.a.a.d.Bz(this.nUn);
                w.i("MicroMsg.QQMusicPlayer", "mineTypeStr:%s", new Object[]{Bz});
                if (this.fPd == null || TextUtils.isEmpty(Bz)) {
                    w.e("MicroMsg.QQMusicPlayer", "music is null or mineTypeStr is empty");
                    return;
                }
                int BD = g.BD(Bz);
                com.tencent.mm.plugin.report.service.g.oUh.i(14486, new Object[]{Integer.valueOf(1), Integer.valueOf(this.fPd.field_musicType), Integer.valueOf(BD), Bz});
            }
        }
    }
}
