package com.tencent.mm.c.b;

import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class j {
    public static int fBC = 100;
    public b fBA = new b(com.tencent.mm.compatible.b.b.a.gNj);
    public a fBB = null;
    public b fBz = new b(ab.getContext());
    String fyF = "";
    public int status = 0;

    public interface a {
        void onError();
    }

    public final boolean by(String str) {
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        if (this.fyF.length() > 0) {
            w.e("MicroMsg.SimpleVoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            return false;
        }
        this.fyF = str;
        try {
            this.fBz.requestFocus();
            this.fBA.a(new com.tencent.mm.c.b.b.a(this) {
                final /* synthetic */ j fBD;

                {
                    this.fBD = r1;
                }

                public final void onError() {
                    this.fBD.fBz.rY();
                    if (this.fBD.fBB != null) {
                        this.fBD.fBB.onError();
                    }
                    try {
                        this.fBD.fBA.release();
                        this.fBD.status = -1;
                    } catch (Exception e) {
                        w.e("MicroMsg.SimpleVoiceRecorder", "setErrorListener File[" + this.fBD.fyF + "] ErrMsg[" + e.getStackTrace() + "]");
                    }
                }
            });
            this.fBA.pa();
            this.fBA.pb();
            this.fBA.oZ();
            this.fBA.setOutputFile(this.fyF);
            this.fBA.setMaxDuration(3600010);
            this.fBA.prepare();
            this.fBA.start();
            w.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fyF + "] start time:" + aVar.se());
            this.status = 1;
            return true;
        } catch (Exception e) {
            this.fBz.rY();
            w.e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fyF + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final boolean oX() {
        this.fBz.rY();
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
            w.e("MicroMsg.SimpleVoiceRecorder", "StopRecord File[" + this.fyF + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }
}
