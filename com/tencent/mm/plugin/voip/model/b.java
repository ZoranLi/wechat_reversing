package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.Timer;
import java.util.TimerTask;

public final class b {
    private static float reI = 0.0f;
    Context context;
    private boolean fAA = false;
    private Timer fAz = null;
    private int gOm = 3;
    AudioTrack ibN = null;
    int ibQ = 2;
    public int ibR = 0;
    private int ibS = 0;
    private Runnable ibT;
    public int ibV = 0;
    int ibW = 20;
    public boolean ibX = false;
    public byte[] reA = null;
    public byte[] reB = null;
    public byte[] reC = null;
    private int reD = 0;
    public a reE = null;
    private int reF = 1;
    private int reG = 1;
    public int reH = 0;
    public int reJ = 0;
    public int reK = 0;
    public int reL = 0;
    public int reM = 0;
    public int reN = 0;
    public int reO = 1;
    public int reP = 0;
    public long reQ = 0;
    public long reR = 0;
    private int reS = 1;
    public int reT = 0;
    public int reU = -1;
    public int reV = 0;
    public long reW = 0;
    private int reX = 1;
    public int reY = 0;
    public final Object reZ = new Object();
    public boolean res = false;
    boolean reu = false;
    boolean rev = true;
    e rew = null;
    public int rex = 0;
    public byte[] rey = null;
    public byte[] rez = null;
    public int rfa = 0;
    private int rfb = 0;
    private int rfc = 0;
    public int rfd = 0;
    public int rfe = 0;

    class a extends TimerTask {
        final /* synthetic */ b rff;

        a(b bVar) {
            this.rff = bVar;
        }

        public final void run() {
            System.currentTimeMillis();
            if (this.rff.reH == 1 && this.rff.res) {
                System.currentTimeMillis();
                if (this.rff.reL + this.rff.ibW < this.rff.rex && this.rff.rfe == 0) {
                    this.rff.rfd = 1;
                    int x = this.rff.reE.x(this.rff.reC, this.rff.ibW);
                    this.rff.rfd = 0;
                    if (x < 0) {
                        w.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :" + x);
                        return;
                    }
                    synchronized (this.rff.reZ) {
                        System.arraycopy(this.rff.reC, 0, this.rff.rez, this.rff.reL, this.rff.ibW);
                        this.rff.reL += this.rff.ibW;
                        this.rff.reK += this.rff.ibW >> 1;
                    }
                }
            }
        }
    }

    public final int boV() {
        return (this.reY / this.ibW) * this.ibS;
    }

    public final int j(Context context, boolean z) {
        w.d("MicroMsg.Voip.AudioPlayer", "enter to Init...");
        this.context = context;
        if (this.reD == 2) {
            this.ibQ = 3;
        } else {
            this.ibQ = 2;
        }
        this.ibV = AudioTrack.getMinBufferSize(this.ibR, this.ibQ, 2);
        if (this.ibV == -2 || this.ibV == -1) {
            this.rfa = 1;
            return -1;
        }
        this.reN = this.ibV;
        this.reT = this.reN * this.reS;
        this.ibV *= this.reX;
        float f = ((float) (this.reN >> 1)) / ((float) this.ibR);
        int rl = l.rl();
        int i = p.gRd.gOF;
        if ((rl & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            if (i <= 0) {
                i = 0;
            }
            w.i("MicroMsg.Voip.AudioPlayer", "CPU ARMv7, ablePlayTimer: " + i);
        } else {
            i = 0;
        }
        if (1000.0f * f < 60.0f || this.rfc != 0) {
            i = 0;
        }
        this.rev = i != 0;
        w.d("MicroMsg.Voip.AudioPlayer", "playBufSize:" + this.ibV + "  MinBufSizeInMs:" + f + ",bPlayTimer:" + this.rev);
        int ic = ic(z);
        try {
            this.ibN = new c(ic, this.ibR, this.ibQ, 2, this.ibV);
        } catch (Exception e) {
            w.w("MicroMsg.Voip.AudioPlayer", "new AudioTrack:", new Object[]{e});
            this.rfa = 6;
        }
        if (this.ibN == null || this.ibN.getState() == 0) {
            this.rfa = 2;
            w.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer audioTrack.getState() == AudioTrack.STATE_UNINITIALIZED");
            if (this.ibN != null) {
                this.ibN.release();
            }
            if (ic == 0) {
                this.ibN = new c(3, this.ibR, this.ibQ, 2, this.ibV);
            } else {
                this.ibN = new c(0, this.ibR, this.ibQ, 2, this.ibV);
            }
        }
        if (this.ibN == null) {
            this.rfa = 3;
            w.e("MicroMsg.Voip.AudioPlayer", "null == audioTrack return");
            return -1;
        } else if (this.ibN.getState() == 0) {
            this.rfa = 3;
            w.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.ibN.release();
            this.ibN = null;
            return -1;
        } else {
            this.rey = new byte[this.ibV];
            if (this.rey == null) {
                w.e("MicroMsg.Voip.AudioPlayer", "null == playBuffer return");
                return -1;
            }
            this.reB = new byte[this.ibW];
            if (this.reB == null) {
                w.e("MicroMsg.Voip.AudioPlayer", "null == frmBuffer return");
                return -1;
            }
            if (this.rev) {
                this.rex = this.ibV;
                this.rez = new byte[this.rex];
                if (this.rez == null) {
                    w.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBuffer return");
                    return -1;
                }
                this.reA = new byte[this.rex];
                if (this.reA == null) {
                    w.e("MicroMsg.Voip.AudioPlayer", "null == playTaskBufferTmp return");
                    return -1;
                }
                this.reC = new byte[this.ibW];
                if (this.reC == null) {
                    w.e("MicroMsg.Voip.AudioPlayer", "null == frmTaskBuffer return");
                    return -1;
                }
            }
            this.res = false;
            this.reu = false;
            w.i("MicroMsg.Voip.AudioPlayer", "dkbt AudioTrack init ok, mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[]{Integer.valueOf(ap.yZ().gNq.getMode()), Boolean.valueOf(ap.yZ().gNq.isSpeakerphoneOn()), Integer.valueOf(ic), Integer.valueOf(this.ibV), Integer.valueOf(this.ibR)});
            return (this.ibV * 1000) / (this.ibR * 2);
        }
    }

    public final boolean ib(boolean z) {
        w.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter to switchSpeakerPhone...");
        int ic = ic(z);
        if (ap.yZ().qI()) {
            ic = 0;
        }
        w.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:speakerOn:" + z + ":streamtype:" + ic);
        if (this.ibN == null || ic != this.ibN.getStreamType()) {
            boZ();
            this.ibX = true;
            if (this.reD == 2) {
                this.ibQ = 3;
            } else {
                this.ibQ = 2;
            }
            this.ibV = AudioTrack.getMinBufferSize(this.ibR, this.ibQ, 2);
            if (this.ibV == -2 || this.ibV == -1) {
                this.ibX = false;
                return false;
            }
            this.reJ = 0;
            this.reM = 0;
            this.reO = 1;
            this.reP = 0;
            this.reQ = 0;
            this.reR = 0;
            this.reS = 1;
            this.reU = -1;
            this.reV = 0;
            this.reN = this.ibV;
            this.reT = this.reN * this.reS;
            this.ibV *= this.reX;
            w.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone:playBufSize:" + this.ibV + "  MinBufSizeInMs:" + (((float) this.reN) / 16.0f));
            if (this.ibN != null) {
                try {
                    this.ibN.stop();
                } catch (Exception e) {
                    w.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone audioTrack.stop Exception:%s", new Object[]{e.getMessage()});
                }
                this.ibN.release();
                this.ibN = null;
            }
            w.i("MicroMsg.Voip.AudioPlayer", "AudioPlayer dkbt switchSpeakerPhone mode:%d issp:%b m:%d size %d,nSamplerate:%d", new Object[]{Integer.valueOf(ap.yZ().gNq.getMode()), Boolean.valueOf(ap.yZ().gNq.isSpeakerphoneOn()), Integer.valueOf(ic), Integer.valueOf(this.ibV), Integer.valueOf(this.ibR)});
            this.ibN = new c(ic, this.ibR, this.ibQ, 2, this.ibV);
            if (this.ibN == null || this.ibN.getState() != 0) {
                w.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer leave  switchSpeakerPhone...");
                if (this.ibN != null) {
                    this.ibX = false;
                    boX();
                    return true;
                }
                this.ibX = false;
                return false;
            }
            w.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer switchSpeakerPhone STATE_UNINITIALIZED call AudioTrack.release() and return");
            this.ibN.release();
            this.ibN = null;
            return false;
        }
        w.d("MicroMsg.Voip.AudioPlayer", "switchSpeakerPhone:stream type do not need to  change");
        return false;
    }

    private int ic(boolean z) {
        int i = 0;
        if (p.gRd.gNO > 0) {
            i = ap.yZ().aA(z);
        } else if (p.gRd.gOo >= 0) {
            i = p.gRd.gOo;
        }
        if (z && p.gRd.gOp >= 0) {
            i = p.gRd.gOp;
        } else if (!z && p.gRd.gOq >= 0) {
            i = p.gRd.gOq;
        }
        if (1 != this.rfc) {
            return i;
        }
        if (p.gRd.gOP >= 0) {
            i = p.gRd.gOP;
        }
        if (z && p.gRd.gOQ >= 0) {
            return p.gRd.gOQ;
        }
        if (z || p.gRd.gOR < 0) {
            return i;
        }
        return p.gRd.gOR;
    }

    public final int boW() {
        if (this.ibN != null) {
            this.ibN.release();
            this.ibN = null;
        }
        this.res = false;
        this.reu = false;
        return 1;
    }

    public final int O(int i, int i2, int i3) {
        if (true == this.res) {
            return 0;
        }
        this.ibR = i;
        this.reD = 1;
        this.ibS = i2;
        this.rfc = i3;
        this.ibW = (((this.ibR / 1000) * 1) * this.ibS) * 2;
        this.reV = (this.ibR * 60) / 1000;
        return 1;
    }

    public final int boX() {
        if (true == this.res) {
            return 1;
        }
        if (this.ibN == null) {
            w.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: audioTrack is null!!");
            return 0;
        }
        this.res = true;
        try {
            this.ibN.play();
        } catch (Exception e) {
            w.e("MicroMsg.Voip.AudioPlayer", "audioTrack.play Exception:%s", new Object[]{e.getMessage()});
        }
        if (this.ibN.getPlayState() != 3) {
            this.rfa = 4;
            w.e("MicroMsg.Voip.AudioPlayer", "audioTrack play error: AudioTrack.PLAYSTATE_PLAYING, play do not start !");
            return 0;
        } else if (this.ibN.getState() == 0) {
            w.e("MicroMsg.Voip.AudioPlayer", "audioTrack error: AudioTrack.STATE_UNINITIALIZED, no more AudioTrack resource!!");
            return 0;
        } else {
            if (this.rev) {
                int i;
                if (this.fAA || this.fAz != null) {
                    w.w("MicroMsg.Voip.AudioPlayer", "Timer has been created or, timer has been started, " + this.fAA);
                    i = -1;
                } else {
                    this.fAz = new Timer();
                    i = this.fAz == null ? -1 : 0;
                }
                if (i != 0) {
                    w.e("MicroMsg.Voip.AudioPlayer", new StringBuilder("InitAudioRecTimer failed, error code = -1").toString());
                    return 0;
                }
                this.fAz.scheduleAtFixedRate(new a(this), 0, 20);
                this.fAA = true;
            }
            this.ibT = new Runnable(this) {
                final /* synthetic */ b rff;

                {
                    this.rff = r1;
                }

                public final void run() {
                    Process.setThreadPriority(-19);
                    w.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer enter  to start....");
                    int i = 0;
                    while (this.rff.res && this.rff.ibN != null) {
                        int playbackHeadPosition;
                        int i2;
                        try {
                            playbackHeadPosition = this.rff.ibN.getPlaybackHeadPosition();
                        } catch (Exception e) {
                            w.w("MicroMsg.Voip.AudioPlayer", "getPlaybackHeadPosition: ", new Object[]{e});
                            this.rff.rfa = 7;
                            playbackHeadPosition = 0;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        this.rff.reM = this.rff.reJ - playbackHeadPosition;
                        if (this.rff.reO == 1) {
                            this.rff.reP = playbackHeadPosition;
                            this.rff.reQ = currentTimeMillis;
                            this.rff.reR = currentTimeMillis;
                            this.rff.reO = 0;
                            this.rff.reW = currentTimeMillis;
                        } else {
                            i2 = playbackHeadPosition - this.rff.reP;
                            if (i2 > this.rff.reU) {
                                this.rff.reU = i2;
                            } else {
                                this.rff.reU = (int) (((((float) this.rff.reU) * 49999.0f) / 50000.0f) + (((float) i2) / 50000.0f));
                            }
                            this.rff.reW = currentTimeMillis;
                            if (this.rff.reM == 0) {
                                this.rff.reT += this.rff.reN;
                            } else if (currentTimeMillis > this.rff.reR + 5000) {
                                this.rff.reR = currentTimeMillis;
                                if (this.rff.reU < (this.rff.reT >> 1)) {
                                    this.rff.reT -= this.rff.reN >> 2;
                                }
                                if (this.rff.reU > this.rff.reT) {
                                    this.rff.reT = this.rff.reU;
                                }
                            }
                            if (this.rff.reT < this.rff.reV) {
                                this.rff.reT = this.rff.reV;
                            }
                            if (this.rff.reT < this.rff.reN) {
                                this.rff.reT = this.rff.reN;
                            }
                            if (i2 > 0) {
                                this.rff.reP = playbackHeadPosition;
                            }
                        }
                        if (playbackHeadPosition != 0 && this.rff.rev) {
                            this.rff.reH = 1;
                        }
                        if (this.rff.reE != null) {
                            this.rff.reY += this.rff.ibW;
                            if (this.rff.reH == 0) {
                                playbackHeadPosition = this.rff.reE.x(this.rff.reB, this.rff.ibW);
                            } else {
                                System.currentTimeMillis();
                                if (this.rff.reL >= this.rff.ibW) {
                                    synchronized (this.rff.reZ) {
                                        System.arraycopy(this.rff.rez, 0, this.rff.reB, 0, this.rff.ibW);
                                        i2 = this.rff.reL - this.rff.ibW;
                                        System.arraycopy(this.rff.rez, this.rff.ibW, this.rff.reA, 0, i2);
                                        System.arraycopy(this.rff.reA, 0, this.rff.rez, 0, i2);
                                        this.rff.reL -= this.rff.ibW;
                                    }
                                    playbackHeadPosition = 0;
                                } else if (this.rff.reM >= (this.rff.ibR * 5) / 1000 || this.rff.rfd != 0) {
                                    com.tencent.mm.plugin.voip.b.a.vd(2);
                                } else {
                                    this.rff.rfe = 1;
                                    playbackHeadPosition = this.rff.reE.x(this.rff.reB, this.rff.ibW);
                                    this.rff.rfe = 0;
                                }
                            }
                            if (playbackHeadPosition < 0) {
                                com.tencent.mm.plugin.voip.b.a.vd(5);
                                w.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :" + playbackHeadPosition);
                            } else if (this.rff.ibX) {
                                w.d("MicroMsg.Voip.AudioPlayer", "isSwitching " + this.rff.ibX);
                                com.tencent.mm.plugin.voip.b.a.vd(10);
                            } else {
                                this.rff.reQ = currentTimeMillis;
                                if (this.rff.ibV < this.rff.ibW) {
                                    System.arraycopy(this.rff.reB, 0, this.rff.rey, i, this.rff.ibV - i);
                                    playbackHeadPosition = this.rff.ibN.write(this.rff.rey, 0, this.rff.rey.length);
                                    if (playbackHeadPosition < 0) {
                                        this.rff.uJ(playbackHeadPosition);
                                        w.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :" + playbackHeadPosition);
                                    }
                                    this.rff.reJ += this.rff.rey.length >> 1;
                                    playbackHeadPosition = this.rff.ibV - i;
                                    i = this.rff.ibW - playbackHeadPosition;
                                    while (i >= this.rff.ibV) {
                                        this.rff.ibN.write(this.rff.reB, playbackHeadPosition, this.rff.ibV);
                                        playbackHeadPosition += this.rff.ibV;
                                        i -= this.rff.ibV;
                                        this.rff.reJ += this.rff.ibV >> 1;
                                    }
                                    System.arraycopy(this.rff.reB, playbackHeadPosition, this.rff.rey, 0, i);
                                } else if (!this.rff.ibX) {
                                    playbackHeadPosition = this.rff.ibN.write(this.rff.reB, 0, this.rff.ibW);
                                    if (playbackHeadPosition < 0) {
                                        this.rff.uJ(playbackHeadPosition);
                                        w.e("MicroMsg.Voip.AudioPlayer", "AudioPlayer::  audioTrack.write ret :" + playbackHeadPosition);
                                    }
                                    this.rff.reJ += this.rff.ibW >> 1;
                                }
                            }
                        } else {
                            com.tencent.mm.plugin.voip.b.a.vd(10);
                        }
                    }
                }
            };
            e.b(this.ibT, "AudioPlayer_play", 10);
            return 1;
        }
    }

    public final int boY() {
        if (this.ibN == null) {
            w.d("MicroMsg.Voip.AudioPlayer", "  audioTrack==null,m_iPlayBufSizeOrg:" + this.reN + ",nSamplerate:" + this.ibR);
            return (this.reN * 1000) / this.ibR;
        } else if (!this.res || this.ibN.getState() == 0) {
            return (this.reN * 1000) / this.ibR;
        } else {
            try {
                return ((this.reJ - this.ibN.getPlaybackHeadPosition()) * 1000) / this.ibR;
            } catch (Exception e) {
                w.e("MicroMsg.Voip.AudioPlayer", "audioTrack getPlaybackHeadPosition error:%s", new Object[]{e.getMessage()});
                return (this.reN * 1000) / this.ibR;
            }
        }
    }

    public final int boZ() {
        if (this.fAA && this.fAz != null) {
            this.fAz.cancel();
            this.fAA = false;
        }
        if (this.res) {
            this.res = false;
            this.reY = 0;
            try {
                if (this.ibT != null) {
                    e.Q(this.ibT);
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Voip.AudioPlayer", e, "", new Object[0]);
            }
            try {
                if (this.ibN != null) {
                    this.ibN.stop();
                    this.ibN.release();
                    w.i("MicroMsg.Voip.AudioPlayer", "StopPlay stop audioTrack");
                }
            } catch (Exception e2) {
                w.e("MicroMsg.Voip.AudioPlayer", "StopPlay audioTrack.stop Exception:%s", new Object[]{e2.getMessage()});
            }
        }
        return 1;
    }

    public final int bpa() {
        w.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayErrState:" + this.rfa);
        return this.rfa;
    }

    public final void uJ(int i) {
        if (this.rfb != -1 && i < 0) {
            this.rfb++;
            if (this.rfb >= 50) {
                this.rfa = 5;
                this.rfb = -1;
            }
        }
    }

    public final int bpb() {
        if (this.ibN != null) {
            return this.ibN.getStreamType();
        }
        return ic(true);
    }
}
