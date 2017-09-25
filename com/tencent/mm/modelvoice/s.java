package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.modelvoice.d.b;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class s implements d {
    public String fyF;
    public a ibO;
    public b ibP;
    public MediaPlayer ics;
    public com.tencent.mm.compatible.util.b ict;
    public int status;

    public final boolean ao(boolean r6) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r1 = 1;
        r0 = 0;
        r2 = r5.status;
        if (r2 == r1) goto L_0x001f;
    L_0x0006:
        r1 = "MicroMsg.VoicePlayer";
        r2 = new java.lang.StringBuilder;
        r3 = "pause not STATUS_PLAYING error status:";
        r2.<init>(r3);
        r3 = r5.status;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.e(r1, r2);
    L_0x001e:
        return r0;
    L_0x001f:
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r3 = "pause mediaPlayer.pause()";	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        com.tencent.mm.sdk.platformtools.w.d(r2, r3);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r2 = r5.ics;	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r2.pause();	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r0 = r5.ict;
        if (r0 == 0) goto L_0x0041;
    L_0x0031:
        if (r6 == 0) goto L_0x0041;
    L_0x0033:
        r0 = "MicroMsg.VoicePlayer";
        r2 = "pause audioFocusHelper.abandonFocus()";
        com.tencent.mm.sdk.platformtools.w.d(r0, r2);
        r0 = r5.ict;
        r0.rY();
    L_0x0041:
        r0 = 2;
        r5.status = r0;
        r0 = r1;
        goto L_0x001e;
    L_0x0046:
        r1 = move-exception;
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r4 = "pause File[";	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r4 = r5.fyF;	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r4 = "] ErrMsg[";	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r1 = r1.getStackTrace();	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r3 = "]";	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        com.tencent.mm.sdk.platformtools.w.e(r2, r1);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r1 = -1;	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r5.status = r1;	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r1 = r5.ict;
        if (r1 == 0) goto L_0x001e;
    L_0x007c:
        if (r6 == 0) goto L_0x001e;
    L_0x007e:
        r1 = "MicroMsg.VoicePlayer";
        r2 = "pause audioFocusHelper.abandonFocus()";
        com.tencent.mm.sdk.platformtools.w.d(r1, r2);
        r1 = r5.ict;
        r1.rY();
        goto L_0x001e;
    L_0x008d:
        r0 = move-exception;
        r1 = r5.ict;
        if (r1 == 0) goto L_0x00a2;
    L_0x0092:
        if (r6 == 0) goto L_0x00a2;
    L_0x0094:
        r1 = "MicroMsg.VoicePlayer";
        r2 = "pause audioFocusHelper.abandonFocus()";
        com.tencent.mm.sdk.platformtools.w.d(r1, r2);
        r1 = r5.ict;
        r1.rY();
    L_0x00a2:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.s.ao(boolean):boolean");
    }

    public final boolean oR() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r1 = 1;
        r0 = 0;
        r2 = r5.status;
        r3 = 2;
        if (r2 == r3) goto L_0x0020;
    L_0x0007:
        r1 = "MicroMsg.VoicePlayer";
        r2 = new java.lang.StringBuilder;
        r3 = "resume not STATUS_PAUSE error status:";
        r2.<init>(r3);
        r3 = r5.status;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.e(r1, r2);
    L_0x001f:
        return r0;
    L_0x0020:
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r3 = "resume mediaPlayer.start()";	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        com.tencent.mm.sdk.platformtools.w.d(r2, r3);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r2 = r5.ics;	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r2.start();	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r0 = r5.ict;
        if (r0 == 0) goto L_0x0040;
    L_0x0032:
        r0 = "MicroMsg.VoicePlayer";
        r2 = "resume audioFocusHelper.requestFocus()";
        com.tencent.mm.sdk.platformtools.w.d(r0, r2);
        r0 = r5.ict;
        r0.requestFocus();
    L_0x0040:
        r5.status = r1;
        r0 = r1;
        goto L_0x001f;
    L_0x0044:
        r1 = move-exception;
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r4 = "resume File[";	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r4 = r5.fyF;	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r4 = "] ErrMsg[";	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r1 = r1.getStackTrace();	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r3 = "]";	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r1);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r1 = -1;	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r5.status = r1;	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r1 = r5.ict;
        if (r1 == 0) goto L_0x001f;
    L_0x007a:
        r1 = "MicroMsg.VoicePlayer";
        r2 = "resume audioFocusHelper.requestFocus()";
        com.tencent.mm.sdk.platformtools.w.d(r1, r2);
        r1 = r5.ict;
        r1.requestFocus();
        goto L_0x001f;
    L_0x0089:
        r0 = move-exception;
        r1 = r5.ict;
        if (r1 == 0) goto L_0x009c;
    L_0x008e:
        r1 = "MicroMsg.VoicePlayer";
        r2 = "resume audioFocusHelper.requestFocus()";
        com.tencent.mm.sdk.platformtools.w.d(r1, r2);
        r1 = r5.ict;
        r1.requestFocus();
    L_0x009c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.s.oR():boolean");
    }

    public final boolean pd() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r1 = 1;
        r0 = 0;
        r2 = r5.status;
        if (r2 == r1) goto L_0x0024;
    L_0x0006:
        r2 = r5.status;
        r3 = 2;
        if (r2 == r3) goto L_0x0024;
    L_0x000b:
        r1 = "MicroMsg.VoicePlayer";
        r2 = new java.lang.StringBuilder;
        r3 = "stop not STATUS_PLAYING or STATUS_PAUSE error status:";
        r2.<init>(r3);
        r3 = r5.status;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.e(r1, r2);
    L_0x0023:
        return r0;
    L_0x0024:
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r3 = "stop mediaPlayer.stop()";	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        com.tencent.mm.sdk.platformtools.w.d(r2, r3);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r2 = r5.ics;	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r2.stop();	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r2 = r5.ics;	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r2.release();	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r2 = r5.ict;
        if (r2 == 0) goto L_0x0049;
    L_0x003b:
        r2 = "MicroMsg.VoicePlayer";
        r3 = "stop audioFocusHelper.abandonFocus()";
        com.tencent.mm.sdk.platformtools.w.d(r2, r3);
        r2 = r5.ict;
        r2.rY();
    L_0x0049:
        r5.status = r0;
        r0 = r1;
        goto L_0x0023;
    L_0x004d:
        r1 = move-exception;
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r4 = "stop File[";	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r4 = r5.fyF;	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r4 = "] ErrMsg[";	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r1 = r1.getStackTrace();	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r3 = "]";	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r1);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r1 = -1;	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r5.status = r1;	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r1 = r5.ict;
        if (r1 == 0) goto L_0x0023;
    L_0x0083:
        r1 = "MicroMsg.VoicePlayer";
        r2 = "stop audioFocusHelper.abandonFocus()";
        com.tencent.mm.sdk.platformtools.w.d(r1, r2);
        r1 = r5.ict;
        r1.rY();
        goto L_0x0023;
    L_0x0092:
        r0 = move-exception;
        r1 = r5.ict;
        if (r1 == 0) goto L_0x00a5;
    L_0x0097:
        r1 = "MicroMsg.VoicePlayer";
        r2 = "stop audioFocusHelper.abandonFocus()";
        com.tencent.mm.sdk.platformtools.w.d(r1, r2);
        r1 = r5.ict;
        r1.rY();
    L_0x00a5:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.s.pd():boolean");
    }

    public final int getStatus() {
        return this.status;
    }

    public s() {
        this.fyF = "";
        this.ibO = null;
        this.ibP = null;
        this.status = 0;
        this.ics = new i();
        LE();
        LF();
        w.d("MicroMsg.VoicePlayer", "VoicePlayer");
    }

    public s(Context context) {
        this();
        this.ict = new com.tencent.mm.compatible.util.b(context);
        w.d("MicroMsg.VoicePlayer", "VoicePlayer context");
    }

    public final void a(a aVar) {
        this.ibO = aVar;
    }

    public final void a(b bVar) {
        this.ibP = bVar;
    }

    private void LE() {
        this.ics.setOnCompletionListener(new OnCompletionListener(this) {
            final /* synthetic */ s icu;

            {
                this.icu = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                w.d("MicroMsg.VoicePlayer", "OnCompletionListener");
                if (this.icu.ict != null) {
                    w.d("MicroMsg.VoicePlayer", "OnCompletionListener abandonFocus");
                    this.icu.ict.rY();
                }
                if (this.icu.ibO != null) {
                    w.d("MicroMsg.VoicePlayer", "OnCompletionListener onCompletion");
                    this.icu.ibO.oW();
                }
                try {
                    w.d("MicroMsg.VoicePlayer", "OnCompletionListener release");
                    this.icu.ics.release();
                    this.icu.status = 0;
                } catch (Exception e) {
                    w.e("MicroMsg.VoicePlayer", "setCompletion File[" + this.icu.fyF + "] ErrMsg[" + e.getStackTrace() + "]");
                }
            }
        });
    }

    private void LF() {
        this.ics.setOnErrorListener(new OnErrorListener(this) {
            final /* synthetic */ s icu;

            {
                this.icu = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                w.d("MicroMsg.VoicePlayer", "OnErrorListener");
                if (this.icu.ict != null) {
                    w.d("MicroMsg.VoicePlayer", "OnErrorListener abandonFocus");
                    this.icu.ict.rY();
                }
                if (this.icu.ibP != null) {
                    w.d("MicroMsg.VoicePlayer", "OnErrorListener onError");
                    this.icu.ibP.onError();
                }
                try {
                    w.d("MicroMsg.VoicePlayer", "OnErrorListener release");
                    this.icu.ics.release();
                    this.icu.status = -1;
                } catch (Exception e) {
                    w.e("MicroMsg.VoicePlayer", "setErrorListener File[" + this.icu.fyF + "] ErrMsg[" + e.getStackTrace() + "]");
                }
                return false;
            }
        });
    }

    public final void aq(boolean z) {
        w.d("MicroMsg.VoicePlayer", "setSpeakerOn=" + z);
        if (this.ics != null) {
            if (ap.oS()) {
                w.v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
                return;
            }
            int currentPosition = this.ics.getCurrentPosition();
            pd();
            this.ics = new i();
            LE();
            LF();
            d(this.fyF, z, currentPosition);
        }
    }

    public final boolean C(String str, boolean z) {
        return d(str, z, 0);
    }

    public final boolean c(String str, boolean z, int i) {
        return d(str, z, i);
    }

    private boolean d(String str, boolean z, int i) {
        if (this.status != 0) {
            w.e("MicroMsg.VoicePlayer", "startPlay error status:" + this.status);
            return false;
        }
        w.i("MicroMsg.VoicePlayer", "startPlay speakerOn:%s,seekTo:%s,", Boolean.valueOf(z), Integer.valueOf(i));
        this.fyF = str;
        try {
            b(z, i);
        } catch (Throwable e) {
            try {
                b(true, i);
            } catch (Exception e2) {
                w.e("MicroMsg.VoicePlayer", "startPlay File[" + this.fyF + "] failed");
                w.e("MicroMsg.VoicePlayer", "exception:%s", bg.g(e));
                this.status = -1;
                return false;
            }
        }
        this.status = 1;
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(boolean r10, int r11) {
        /*
        r9 = this;
        r0 = 3;
        r8 = 1;
        r2 = 0;
        r1 = r9.fyF;
        r1 = com.tencent.mm.a.e.aO(r1);
        if (r1 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        if (r10 == 0) goto L_0x00a8;
    L_0x000e:
        r1 = r0;
    L_0x000f:
        r3 = "MicroMsg.VoicePlayer";
        r4 = "playImp speakerOn:%s,seekTo:%s,type:%s";
        r5 = 3;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0071 }
        r6 = 0;
        r7 = java.lang.Boolean.valueOf(r10);	 Catch:{ Exception -> 0x0071 }
        r5[r6] = r7;	 Catch:{ Exception -> 0x0071 }
        r6 = 1;
        r7 = java.lang.Integer.valueOf(r11);	 Catch:{ Exception -> 0x0071 }
        r5[r6] = r7;	 Catch:{ Exception -> 0x0071 }
        r6 = 2;
        r7 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0071 }
        r5[r6] = r7;	 Catch:{ Exception -> 0x0071 }
        com.tencent.mm.sdk.platformtools.w.d(r3, r4, r5);	 Catch:{ Exception -> 0x0071 }
        r3 = com.tencent.mm.compatible.d.p.gRd;	 Catch:{ Exception -> 0x0071 }
        r3 = r3.gNN;	 Catch:{ Exception -> 0x0071 }
        if (r3 == 0) goto L_0x00ab;
    L_0x0036:
        r3 = com.tencent.mm.compatible.d.p.gRd;	 Catch:{ Exception -> 0x0071 }
        r3.dump();	 Catch:{ Exception -> 0x0071 }
        r3 = com.tencent.mm.compatible.d.p.gRd;	 Catch:{ Exception -> 0x0071 }
        r3 = r3.gNU;	 Catch:{ Exception -> 0x0071 }
        if (r3 != r8) goto L_0x00ab;
    L_0x0041:
        r1 = r9.ict;	 Catch:{ Exception -> 0x0071 }
        if (r1 == 0) goto L_0x0053;
    L_0x0045:
        r1 = "MicroMsg.VoicePlayer";
        r3 = "playImp audioFocusHelper.requestFocus";
        com.tencent.mm.sdk.platformtools.w.d(r1, r3);	 Catch:{ Exception -> 0x0071 }
        r1 = r9.ict;	 Catch:{ Exception -> 0x0071 }
        r1.requestFocus();	 Catch:{ Exception -> 0x0071 }
    L_0x0053:
        r1 = r9.ics;	 Catch:{ Exception -> 0x0071 }
        r1.setAudioStreamType(r0);	 Catch:{ Exception -> 0x0071 }
        r0 = r9.ics;	 Catch:{ Exception -> 0x0071 }
        r1 = r9.fyF;	 Catch:{ Exception -> 0x0071 }
        r0.setDataSource(r1);	 Catch:{ Exception -> 0x0071 }
        r0 = r9.ics;	 Catch:{ Exception -> 0x0071 }
        r0.prepare();	 Catch:{ Exception -> 0x0071 }
        if (r11 <= 0) goto L_0x006b;
    L_0x0066:
        r0 = r9.ics;	 Catch:{ Exception -> 0x0071 }
        r0.seekTo(r11);	 Catch:{ Exception -> 0x0071 }
    L_0x006b:
        r0 = r9.ics;	 Catch:{ Exception -> 0x0071 }
        r0.start();	 Catch:{ Exception -> 0x0071 }
        goto L_0x000b;
    L_0x0071:
        r0 = move-exception;
        r1 = "MicroMsg.VoicePlayer";
        r3 = new java.lang.StringBuilder;
        r4 = "playImp : fail, exception = ";
        r3.<init>(r4);
        r4 = r0.getMessage();
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.w.e(r1, r3);
        r1 = "MicroMsg.VoicePlayer";
        r3 = "exception:%s";
        r4 = new java.lang.Object[r8];
        r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);
        r4[r2] = r0;
        com.tencent.mm.sdk.platformtools.w.e(r1, r3, r4);
        r0 = r9.ict;
        if (r0 == 0) goto L_0x000b;
    L_0x00a1:
        r0 = r9.ict;
        r0.rY();
        goto L_0x000b;
    L_0x00a8:
        r1 = r2;
        goto L_0x000f;
    L_0x00ab:
        r0 = r1;
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.s.b(boolean, int):void");
    }

    public final boolean isPlaying() {
        return this.status == 1;
    }

    public final double oU() {
        if (this.status != 1 && this.status != 2) {
            return 0.0d;
        }
        try {
            int currentPosition = this.ics.getCurrentPosition();
            int duration = this.ics.getDuration();
            if (duration != 0) {
                return ((double) currentPosition) / ((double) duration);
            }
            w.e("MicroMsg.VoicePlayer", "getDuration File[" + this.fyF + "] Failed");
            return 0.0d;
        } catch (Exception e) {
            w.e("MicroMsg.VoicePlayer", "getNowProgress File[" + this.fyF + "] ErrMsg[" + e.getStackTrace() + "]");
            pd();
            return 0.0d;
        }
    }

    public final void b(com.tencent.mm.compatible.util.b.a aVar) {
        if (this.ict != null && aVar != null) {
            this.ict.a(aVar);
        }
    }
}
