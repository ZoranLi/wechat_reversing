package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Looper;
import android.os.Vibrator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class h {
    public boolean fEt = false;
    private AudioManager gSs;
    public ae hgN = new ae(Looper.getMainLooper());
    private b ict;
    private Vibrator kCe;
    public Context mContext;
    public MediaPlayer rqf;
    public int rqg = 65536;
    public long rqh;
    public long rqi;
    public a rqj;

    private class a implements Runnable {
        final /* synthetic */ h rqk;
        private int rqp;
        private long rqq;
        private boolean rqr;
        private int streamType;

        public a(h hVar, int i, long j, boolean z, int i2) {
            this.rqk = hVar;
            this.rqp = i;
            this.rqq = j;
            this.rqr = z;
            this.streamType = i2;
        }

        public final void run() {
            this.rqk.a(this.rqp, this.rqq, this.rqr, this.streamType);
        }
    }

    public h(Context context) {
        this.mContext = context;
        if (this.mContext != null) {
            this.gSs = ap.yZ().gNq;
            if (this.gSs == null) {
                this.gSs = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            }
            this.kCe = (Vibrator) this.mContext.getSystemService("vibrator");
        }
        this.ict = new b(ab.getContext());
    }

    public final void io(boolean z) {
        int i = 0;
        w.i("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            if (d.eo(21)) {
                i = 3;
            } else {
                i = 2;
            }
        }
        if (z && p.gRd.gOv >= 0) {
            i = p.gRd.gOv;
        } else if (!z && p.gRd.gOt >= 0) {
            i = p.gRd.gOt;
        }
        if (i != this.gSs.getMode()) {
            this.gSs.setMode(i);
        }
        if (z != this.gSs.isSpeakerphoneOn()) {
            this.gSs.setSpeakerphoneOn(z);
        }
    }

    public final void ip(boolean z) {
        if (!this.fEt) {
            try {
                this.rqf = i.a(this.mContext, RingtoneManager.getActualDefaultRingtoneUri(this.mContext, 1));
                if (this.rqf != null) {
                    this.rqf.stop();
                    this.rqf.prepare();
                    this.rqf.setLooping(true);
                    io(true);
                    if (z) {
                        this.rqf.setVolume(0.6f, 0.6f);
                    } else {
                        brB();
                    }
                    switch (this.gSs.getRingerMode()) {
                        case 2:
                            if (this.rqf != null) {
                                this.rqf.start();
                                break;
                            }
                            break;
                    }
                    this.fEt = true;
                }
            } catch (Exception e) {
                w.e("ex", e.toString());
            }
        }
    }

    public final void stop() {
        w.d("MicroMsg.RingPlayer", "stop, isStarted: %b", new Object[]{Boolean.valueOf(this.fEt)});
        if (this.kCe != null) {
            this.kCe.cancel();
            this.kCe = null;
        }
        if (this.rqf != null && this.fEt) {
            try {
                this.rqf.stop();
                this.rqf.release();
                if (this.rqj != null) {
                    this.hgN.removeCallbacks(this.rqj);
                }
                this.fEt = false;
                ap.yZ().setMode(0);
            } catch (Exception e) {
                w.e("MicroMsg.RingPlayer", e.toString());
            }
        }
    }

    public final boolean brA() {
        return !this.fEt;
    }

    public final void n(int i, int i2, boolean z) {
        boolean booleanValue;
        if (i2 == 0) {
            try {
                ap.yY();
                booleanValue = ((Boolean) c.vr().get(73217, Boolean.valueOf(true))).booleanValue();
            } catch (Exception e) {
                w.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
            }
        } else {
            if (i2 == 1 || i2 == 2) {
                ap.yY();
                booleanValue = ((Boolean) c.vr().get(73218, Boolean.valueOf(true))).booleanValue();
            }
            booleanValue = true;
        }
        if (booleanValue && !this.fEt) {
            try {
                this.rqh = System.currentTimeMillis();
                this.rqf = new i();
                try {
                    int qU;
                    int i3;
                    this.rqf.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                    this.rqf.setOnCompletionListener(new OnCompletionListener(this) {
                        final /* synthetic */ h rqk;

                        {
                            this.rqk = r1;
                        }

                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            if (System.currentTimeMillis() - this.rqk.rqh > 70000) {
                                this.rqk.rqg = 4;
                            }
                        }
                    });
                    this.rqf.setOnErrorListener(new OnErrorListener(this) {
                        final /* synthetic */ h rqk;

                        {
                            this.rqk = r1;
                        }

                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            this.rqk.rqg = 1;
                            w.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + i + ":extra:" + i2);
                            return false;
                        }
                    });
                    boolean qI = ap.yZ().qI();
                    boolean qO = ap.yZ().qO();
                    w.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[]{Boolean.valueOf(qI), Boolean.valueOf(qO)});
                    if (qI) {
                        qU = ap.yZ().qU();
                        io(false);
                        i3 = qU;
                    } else if (z || qO) {
                        if (p.gRd.gOs >= 0) {
                            qU = p.gRd.gOs;
                        } else {
                            qU = 0;
                        }
                        io(false);
                        i3 = qU;
                    } else {
                        if (ap.yZ().qI() || p.gRd.gOu < 0) {
                            qU = 2;
                        } else {
                            qU = p.gRd.gOu;
                        }
                        io(true);
                        i3 = qU;
                    }
                    this.rqf.setAudioStreamType(i3);
                    if (qO || qI) {
                        int streamMaxVolume = this.gSs.getStreamMaxVolume(i3);
                        qU = this.gSs.getStreamVolume(i3);
                        if (qU > streamMaxVolume / 2) {
                            qU = streamMaxVolume / 2;
                        }
                        this.gSs.setStreamVolume(i3, qU, 0);
                    } else if (z) {
                        this.rqf.setVolume(0.6f, 0.6f);
                    } else {
                        brB();
                    }
                    this.rqf.setLooping(true);
                    this.rqf.prepare();
                    this.rqf.start();
                    if (System.currentTimeMillis() - this.rqh > 2000) {
                        this.rqg = 3;
                    }
                } catch (Throwable th) {
                    w.e("MicroMsg.RingPlayer", "startPlayCustomRing failed, " + th.getMessage());
                    this.rqg = 2;
                }
                this.fEt = true;
            } catch (Exception e2) {
                w.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e2.toString());
            }
        }
    }

    public final void a(int i, long j, boolean z, int i2) {
        this.rqh = System.currentTimeMillis();
        this.rqf = new i();
        try {
            this.rqf.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
            final int i3 = i;
            final long j2 = j;
            final boolean z2 = z;
            final int i4 = i2;
            this.rqf.setOnCompletionListener(new OnCompletionListener(this) {
                final /* synthetic */ h rqk;

                public final void onCompletion(MediaPlayer mediaPlayer) {
                    if (System.currentTimeMillis() - this.rqk.rqh > 70000) {
                        this.rqk.rqg = 4;
                    }
                    if (this.rqk.fEt) {
                        this.rqk.rqj = new a(this.rqk, i3, j2, z2, i4);
                        this.rqk.hgN.postDelayed(this.rqk.rqj, j2);
                    }
                }
            });
            this.rqf.setOnErrorListener(new OnErrorListener(this) {
                final /* synthetic */ h rqk;

                {
                    this.rqk = r1;
                }

                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    this.rqk.rqg = 1;
                    w.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + i + ":extra:" + i2);
                    return false;
                }
            });
            this.rqf.setAudioStreamType(i2);
            if (z) {
                this.rqf.setVolume(0.6f, 0.6f);
            } else {
                brB();
            }
            this.rqf.setLooping(false);
            this.rqf.prepare();
            this.rqf.start();
            if (System.currentTimeMillis() - this.rqh > 2000) {
                this.rqg = 3;
            }
        } catch (Exception e) {
            w.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e.toString());
        }
    }

    private void brB() {
        if (this.mContext.getSharedPreferences(ab.bIX(), 0).getBoolean("settings_shake", true)) {
            int ringerMode = this.gSs.getRingerMode();
            if (ringerMode == 1 || ringerMode == 2) {
                this.kCe = (Vibrator) this.mContext.getSystemService("vibrator");
                if (this.kCe != null) {
                    this.kCe.vibrate(new long[]{1000, 1000, 1000, 1000}, 0);
                }
            }
        }
    }

    public final void o(int i, int i2, boolean z) {
        this.rqg = 0;
        if (i == 0) {
            ip(z);
        } else {
            n(i, i2, z);
        }
    }

    public final void b(int i, boolean z, int i2, boolean z2) {
        if (i != R.k.dyR || ap.yZ().qI() || ap.yZ().qO() || !(this.gSs.getRingerMode() == 0 || this.gSs.getRingerMode() == 1)) {
            boolean z3 = this.mContext.getSharedPreferences(ab.bIX(), 0).getBoolean("settings_shake", true);
            if (z) {
                bg.k(this.mContext, z3);
            }
            if (i2 == 0) {
                try {
                    ap.yY();
                    z3 = ((Boolean) c.vr().get(73217, Boolean.valueOf(true))).booleanValue();
                } catch (Exception e) {
                    w.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
                }
            } else {
                if (i2 == 1) {
                    ap.yY();
                    z3 = ((Boolean) c.vr().get(73218, Boolean.valueOf(true))).booleanValue();
                }
                z3 = true;
            }
            if (z3) {
                this.rqi = System.currentTimeMillis();
                MediaPlayer iVar = new i();
                try {
                    iVar.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                    iVar.setOnCompletionListener(new OnCompletionListener(this) {
                        final /* synthetic */ h rqk;

                        {
                            this.rqk = r1;
                        }

                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                            if (System.currentTimeMillis() - this.rqk.rqi > 5000) {
                                this.rqk.rqg = 8;
                            }
                        }
                    });
                    iVar.setOnErrorListener(new OnErrorListener(this) {
                        final /* synthetic */ h rqk;

                        {
                            this.rqk = r1;
                        }

                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                                this.rqk.rqg = 5;
                                w.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", new Object[]{mediaPlayer, Integer.valueOf(i), Integer.valueOf(i2)});
                            }
                            return false;
                        }
                    });
                    if (z2) {
                        iVar.setAudioStreamType(ap.yZ().qI() ? ap.yZ().qU() : 0);
                    }
                    if (i == R.k.dyR && (ap.yZ().qI() || ap.yZ().qO())) {
                        iVar.setVolume(0.5f, 0.5f);
                    }
                    iVar.prepare();
                    iVar.setLooping(false);
                    iVar.start();
                    if (System.currentTimeMillis() - this.rqi > 2000) {
                        this.rqg = 7;
                    }
                } catch (Throwable th) {
                    w.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[]{th});
                    this.rqg = 6;
                }
            }
        }
    }

    public final void d(int i, boolean z, int i2) {
        b(i, false, i2, true);
    }

    public final int brC() {
        w.d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.rqg);
        return this.rqg;
    }
}
