package com.tencent.mm.modelvoice;

import com.tencent.mm.c.b.a;
import com.tencent.mm.c.b.b;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.h;

public final class t implements a {
    private static int fBC = 100;
    public b fBA;
    String fyF = "";
    public h.a icv = null;
    public int status = 0;

    public final int getStatus() {
        return this.status;
    }

    public final int oY() {
        b bVar = this.fBA;
        return ((bVar.fzw == com.tencent.mm.compatible.b.b.a.PCM || bVar.fzw == com.tencent.mm.compatible.b.b.a.SILK) && bVar.fzv != null) ? bVar.fzv.fAj : 1;
    }

    public final void a(h.a aVar) {
        this.icv = aVar;
    }

    public t(com.tencent.mm.compatible.b.b.a aVar) {
        this.fBA = new b(aVar);
    }

    public final boolean bw(String str) {
        g.a aVar = new g.a();
        if (this.fyF.length() > 0) {
            w.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            return false;
        }
        this.fyF = str;
        try {
            this.fBA.a(new b.a(this) {
                final /* synthetic */ t icw;

                {
                    this.icw = r1;
                }

                public final void onError() {
                    if (this.icw.icv != null) {
                        this.icw.icv.onError();
                    }
                    try {
                        this.icw.fBA.release();
                        this.icw.status = -1;
                    } catch (Exception e) {
                        w.e("VoiceRecorder", "setErrorListener File[" + this.icw.fyF + "] ErrMsg[" + e.getStackTrace() + "]");
                    }
                }
            });
            this.fBA.pa();
            this.fBA.pb();
            this.fBA.oZ();
            this.fBA.setOutputFile(this.fyF);
            this.fBA.setMaxDuration(70000);
            this.fBA.prepare();
            this.fBA.start();
            w.d("VoiceRecorder", "StartRecord File[" + this.fyF + "] start time:" + aVar.se());
            this.status = 1;
            return true;
        } catch (Exception e) {
            w.e("VoiceRecorder", "StartRecord File[" + this.fyF + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final boolean oX() {
        if (this.fBA == null) {
            return true;
        }
        try {
            this.fBA.pd();
            this.fBA.release();
            this.fyF = "";
            this.status = 0;
            return true;
        } catch (Exception e) {
            w.e("VoiceRecorder", "StopRecord File[" + this.fyF + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final int getMaxAmplitude() {
        if (this.status != 1) {
            return 0;
        }
        int maxAmplitude = this.fBA.getMaxAmplitude();
        if (maxAmplitude > fBC) {
            fBC = maxAmplitude;
        }
        return (maxAmplitude * 100) / fBC;
    }
}
