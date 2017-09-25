package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.FileInputStream;

public final class j implements d {
    public b fBz;
    private int fRr;
    public String fyF;
    public String ibA;
    public OnCompletionListener ibJ;
    public OnErrorListener ibK;
    public AudioTrack ibN;
    public a ibO;
    public d.b ibP;
    private int ibQ;
    private int ibR;
    private int ibS;
    private Runnable ibT;
    public com.tencent.qqpinyin.voicerecoapi.a ibU;
    private int ibV;
    int ibW;
    public boolean ibX;
    public byte[] ibY;
    public int ibZ;
    public String ibz;
    public FileInputStream ica;
    public int icb;
    public int status;

    public final int getStatus() {
        return this.status;
    }

    public j() {
        int i = 0;
        this.fyF = "";
        this.ibO = null;
        this.ibP = null;
        this.status = 0;
        this.ibQ = 2;
        this.ibR = 16000;
        this.fRr = 1;
        this.ibS = 20;
        this.ibU = null;
        this.ibW = 0;
        this.ibX = false;
        this.ibz = "";
        this.ibA = "";
        this.ibY = new byte[com.tencent.qqpinyin.voicerecoapi.a.wPA];
        this.ibZ = 0;
        this.ica = null;
        this.icb = 314;
        this.ibJ = new OnCompletionListener(this) {
            final /* synthetic */ j icc;

            {
                this.icc = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (this.icc.fBz != null) {
                    this.icc.fBz.rY();
                }
                try {
                    this.icc.status = 0;
                    if (this.icc.ibN != null) {
                        this.icc.ibN.stop();
                        this.icc.ibN.release();
                        this.icc.ibN = null;
                    }
                    try {
                        this.icc.join();
                    } catch (Throwable e) {
                        w.e("MicroMsg.SpeexPlayer", "exception:%s", bg.g(e));
                    }
                } catch (Throwable e2) {
                    w.e("MicroMsg.SpeexPlayer", "exception:%s", bg.g(e2));
                    w.e("MicroMsg.SpeexPlayer", "setCompletion File[" + this.icc.fyF + "] ErrMsg[" + e2.getStackTrace() + "]");
                }
            }
        };
        this.ibK = new OnErrorListener(this) {
            final /* synthetic */ j icc;

            {
                this.icc = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                w.d("MicroMsg.SpeexPlayer", "onError");
                if (this.icc.fBz != null) {
                    this.icc.fBz.rY();
                }
                if (this.icc.ibP != null) {
                    this.icc.ibP.onError();
                }
                try {
                    this.icc.status = -1;
                    if (this.icc.ibN != null) {
                        this.icc.ibN.stop();
                        this.icc.ibN.release();
                        this.icc.ibN = null;
                    }
                    try {
                        this.icc.join();
                    } catch (Throwable e) {
                        w.e("MicroMsg.SpeexPlayer", "exception:%s", bg.g(e));
                    }
                } catch (Exception e2) {
                    w.e("MicroMsg.SpeexPlayer", "setErrorListener File[" + this.icc.fyF + "] ErrMsg[" + e2.getStackTrace() + "]");
                }
                return false;
            }
        };
        this.ibU = new com.tencent.qqpinyin.voicerecoapi.a();
        com.tencent.qqpinyin.voicerecoapi.a aVar = this.ibU;
        if (aVar.wPE != 0) {
            i = -103;
        } else {
            int nativeTRSpeexDecodeInit = aVar.wPF.nativeTRSpeexDecodeInit();
            if (nativeTRSpeexDecodeInit == -1 || nativeTRSpeexDecodeInit == -100 || nativeTRSpeexDecodeInit == -101 || nativeTRSpeexDecodeInit == -102) {
                i = nativeTRSpeexDecodeInit;
            } else {
                aVar.wPE = nativeTRSpeexDecodeInit;
                aVar.wPC = new byte[(com.tencent.qqpinyin.voicerecoapi.a.wPA * 15)];
            }
        }
        if (i != 0) {
            w.e("speex", "res: " + i);
        }
    }

    public j(Context context) {
        this();
        this.fBz = new b(context);
    }

    public final void a(a aVar) {
        this.ibO = aVar;
    }

    public final void a(d.b bVar) {
        this.ibP = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aq(boolean r9) {
        /*
        r8 = this;
        r1 = 3;
        r7 = 1;
        r6 = 0;
        r4 = 2;
        r8.ibX = r7;
        r0 = r8.fRr;
        if (r0 != r4) goto L_0x0052;
    L_0x000a:
        r8.ibQ = r1;
    L_0x000c:
        r0 = r8.ibR;
        r2 = r8.ibQ;
        r0 = android.media.AudioTrack.getMinBufferSize(r0, r2, r4);
        r8.ibV = r0;
        r0 = r8.ibN;
        if (r0 == 0) goto L_0x0027;
    L_0x001a:
        r0 = r8.ibN;
        r0.stop();
        r0 = r8.ibN;
        r0.release();
        r0 = 0;
        r8.ibN = r0;
    L_0x0027:
        if (r9 == 0) goto L_0x0055;
    L_0x0029:
        r0 = r1;
    L_0x002a:
        r2 = com.tencent.mm.compatible.d.p.gRd;
        r2 = r2.gNN;
        if (r2 == 0) goto L_0x006a;
    L_0x0030:
        r2 = com.tencent.mm.compatible.d.p.gRd;
        r2.dump();
        r2 = com.tencent.mm.compatible.d.p.gRd;
        r2 = r2.gNU;
        if (r2 != r7) goto L_0x006a;
    L_0x003b:
        r0 = new com.tencent.mm.compatible.b.c;
        r2 = r8.ibR;
        r3 = r8.ibQ;
        r5 = r8.ibV;
        r5 = r5 * 8;
        r0.<init>(r1, r2, r3, r4, r5);
        r8.ibN = r0;
        r0 = r8.ibN;	 Catch:{ Exception -> 0x0057 }
        r0.play();	 Catch:{ Exception -> 0x0057 }
    L_0x004f:
        r8.ibX = r6;
        return;
    L_0x0052:
        r8.ibQ = r4;
        goto L_0x000c;
    L_0x0055:
        r0 = r6;
        goto L_0x002a;
    L_0x0057:
        r0 = move-exception;
        r1 = "MicroMsg.SpeexPlayer";
        r2 = "audioTrack error:%s";
        r3 = new java.lang.Object[r7];
        r0 = r0.getMessage();
        r3[r6] = r0;
        com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);
        goto L_0x004f;
    L_0x006a:
        r1 = r0;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.j.aq(boolean):void");
    }

    public final boolean C(String str, boolean z) {
        return D(str, z);
    }

    public final boolean c(String str, boolean z, int i) {
        return D(str, z);
    }

    private boolean D(String str, boolean z) {
        if (this.status != 0) {
            w.e("MicroMsg.SpeexPlayer", "startPlay error status:" + this.status);
            return false;
        }
        w.i("MicroMsg.SpeexPlayer", "startPlay");
        this.status = 1;
        this.fyF = str;
        try {
            bw(z);
        } catch (Throwable e) {
            try {
                bw(true);
            } catch (Exception e2) {
                w.e("MicroMsg.SpeexPlayer", "startPlay File[" + this.fyF + "] failed");
                w.e("MicroMsg.SpeexPlayer", "exception:%s", bg.g(e));
                this.status = -1;
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bw(boolean r9) {
        /*
        r8 = this;
        r1 = 3;
        r7 = 1;
        r6 = 0;
        r0 = r8.fyF;
        r0 = com.tencent.mm.a.e.aO(r0);
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        if (r9 == 0) goto L_0x00b3;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r2 = com.tencent.mm.compatible.d.p.gRd;	 Catch:{ Exception -> 0x007c }
        r2 = r2.gNN;	 Catch:{ Exception -> 0x007c }
        if (r2 == 0) goto L_0x00cc;
    L_0x0015:
        r2 = com.tencent.mm.compatible.d.p.gRd;	 Catch:{ Exception -> 0x007c }
        r2.dump();	 Catch:{ Exception -> 0x007c }
        r2 = com.tencent.mm.compatible.d.p.gRd;	 Catch:{ Exception -> 0x007c }
        r2 = r2.gNU;	 Catch:{ Exception -> 0x007c }
        if (r2 != r7) goto L_0x00cc;
    L_0x0020:
        r0 = r8.ibR;	 Catch:{ Exception -> 0x007c }
        r2 = r8.ibQ;	 Catch:{ Exception -> 0x007c }
        r3 = 2;
        r0 = android.media.AudioTrack.getMinBufferSize(r0, r2, r3);	 Catch:{ Exception -> 0x007c }
        r8.ibV = r0;	 Catch:{ Exception -> 0x007c }
        r0 = r8.ibN;	 Catch:{ Exception -> 0x007c }
        if (r0 == 0) goto L_0x003c;
    L_0x002f:
        r0 = r8.ibN;	 Catch:{ Exception -> 0x007c }
        r0.stop();	 Catch:{ Exception -> 0x007c }
        r0 = r8.ibN;	 Catch:{ Exception -> 0x007c }
        r0.release();	 Catch:{ Exception -> 0x007c }
        r0 = 0;
        r8.ibN = r0;	 Catch:{ Exception -> 0x007c }
    L_0x003c:
        r0 = new com.tencent.mm.compatible.b.c;	 Catch:{ Exception -> 0x007c }
        r2 = r8.ibR;	 Catch:{ Exception -> 0x007c }
        r3 = r8.ibQ;	 Catch:{ Exception -> 0x007c }
        r4 = 2;
        r5 = r8.ibV;	 Catch:{ Exception -> 0x007c }
        r5 = r5 * 8;
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x007c }
        r8.ibN = r0;	 Catch:{ Exception -> 0x007c }
        r0 = r8.ibR;	 Catch:{ Exception -> 0x007c }
        r0 = r0 / 1000;
        r1 = r8.fRr;	 Catch:{ Exception -> 0x007c }
        r0 = r0 * r1;
        r1 = r8.ibS;	 Catch:{ Exception -> 0x007c }
        r0 = r0 * r1;
        r0 = r0 * 2;
        r8.icb = r0;	 Catch:{ Exception -> 0x007c }
        r0 = r8.fBz;	 Catch:{ Exception -> 0x007c }
        if (r0 == 0) goto L_0x0063;
    L_0x005e:
        r0 = r8.fBz;	 Catch:{ Exception -> 0x007c }
        r0.requestFocus();	 Catch:{ Exception -> 0x007c }
    L_0x0063:
        r0 = r8.ibN;	 Catch:{ Exception -> 0x007c }
        if (r0 == 0) goto L_0x000b;
    L_0x0067:
        r0 = r8.ibN;	 Catch:{ Exception -> 0x00b6 }
        r0.play();	 Catch:{ Exception -> 0x00b6 }
        r0 = new com.tencent.mm.modelvoice.j$3;	 Catch:{ Exception -> 0x007c }
        r0.<init>(r8);	 Catch:{ Exception -> 0x007c }
        r8.ibT = r0;	 Catch:{ Exception -> 0x007c }
        r0 = r8.ibT;	 Catch:{ Exception -> 0x007c }
        r1 = "SpeexPlayer_play";
        com.tencent.mm.sdk.f.e.post(r0, r1);	 Catch:{ Exception -> 0x007c }
        goto L_0x000b;
    L_0x007c:
        r0 = move-exception;
        r1 = r8.fBz;
        if (r1 == 0) goto L_0x0086;
    L_0x0081:
        r1 = r8.fBz;
        r1.rY();
    L_0x0086:
        r1 = "MicroMsg.SpeexPlayer";
        r2 = new java.lang.StringBuilder;
        r3 = "playImp : fail, exception = ";
        r2.<init>(r3);
        r3 = r0.getMessage();
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.e(r1, r2);
        r1 = "MicroMsg.SpeexPlayer";
        r2 = "exception:%s";
        r3 = new java.lang.Object[r7];
        r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);
        r3[r6] = r0;
        com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);
        goto L_0x000b;
    L_0x00b3:
        r0 = r6;
        goto L_0x000f;
    L_0x00b6:
        r0 = move-exception;
        r1 = "MicroMsg.SpeexPlayer";
        r2 = "audioTrack error:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x007c }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x007c }
        r3[r4] = r0;	 Catch:{ Exception -> 0x007c }
        com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);	 Catch:{ Exception -> 0x007c }
        goto L_0x000b;
    L_0x00cc:
        r1 = r0;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.j.bw(boolean):void");
    }

    public final boolean ao(boolean z) {
        if (this.status != 1) {
            return false;
        }
        this.status = 2;
        synchronized (this.ibA) {
            try {
                w.v("MicroMsg.SpeexPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.ibA.wait();
                w.v("MicroMsg.SpeexPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
                if (this.fBz != null && z) {
                    this.fBz.rY();
                }
            } catch (Throwable e) {
                w.e("MicroMsg.SpeexPlayer", "exception:%s", bg.g(e));
                if (this.fBz != null && z) {
                    this.fBz.rY();
                }
                return false;
            } catch (Throwable th) {
                if (this.fBz != null && z) {
                    this.fBz.rY();
                }
            }
        }
        return true;
    }

    public final boolean oR() {
        if (this.status != 2) {
            return false;
        }
        this.status = 1;
        synchronized (this.ibz) {
            try {
                w.v("MicroMsg.SpeexPlayer", "before mpause.notify");
                this.ibz.notify();
                w.v("MicroMsg.SpeexPlayer", "after mpause.notify");
                if (this.fBz != null) {
                    this.fBz.requestFocus();
                }
            } catch (Throwable e) {
                w.e("MicroMsg.SpeexPlayer", "exception:%s", bg.g(e));
                if (this.fBz != null) {
                    this.fBz.requestFocus();
                }
                return false;
            } catch (Throwable th) {
                if (this.fBz != null) {
                    this.fBz.requestFocus();
                }
            }
        }
        return true;
    }

    public final boolean isPlaying() {
        return this.status == 1;
    }

    public final boolean pd() {
        w.e("MicroMsg.SpeexPlayer", "stop  status:" + this.status);
        if (this.status == 1 || this.status == 2) {
            this.status = 3;
            synchronized (this.ibz) {
                try {
                    this.ibz.notify();
                    if (this.fBz != null) {
                        this.fBz.rY();
                    }
                } catch (Throwable e) {
                    w.e("MicroMsg.SpeexPlayer", "exception:%s", bg.g(e));
                    if (this.fBz != null) {
                        this.fBz.rY();
                    }
                    return false;
                } catch (Throwable th) {
                    if (this.fBz != null) {
                        this.fBz.rY();
                    }
                }
            }
            return true;
        }
        w.e("MicroMsg.SpeexPlayer", "stop  error status:" + this.status);
        return false;
    }

    public final void join() {
        if (this.ibT != null) {
            e.Q(this.ibT);
            this.ibT = null;
        }
    }

    public final double oU() {
        return 0.0d;
    }

    public final void b(b.a aVar) {
        if (aVar != null && this.fBz != null) {
            this.fBz.a(aVar);
        }
    }
}
