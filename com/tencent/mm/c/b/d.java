package com.tencent.mm.c.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.mm.c.b.c.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Arrays;

public final class d extends f {
    public AudioRecord fAd;
    public a fAe;
    public byte[] fAm = null;
    private int fAn;
    public int fAo;
    public boolean fAp;
    private OnRecordPositionUpdateListener fAq = new OnRecordPositionUpdateListener(this) {
        final /* synthetic */ d fAr;

        {
            this.fAr = r1;
        }

        public final void onMarkerReached(AudioRecord audioRecord) {
        }

        public final void onPeriodicNotification(AudioRecord audioRecord) {
            if (!this.fAr.fAG && this.fAr.fAd != null) {
                if (this.fAr.fzP || this.fAr.fAm == null) {
                    this.fAr.fAm = new byte[this.fAr.fAo];
                }
                int read = this.fAr.fAd.read(this.fAr.fAm, 0, this.fAr.fAo);
                w.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: " + read);
                if (this.fAr.fAk != null) {
                    this.fAr.fAk.c(read, this.fAr.fAm);
                }
                if (read > this.fAr.fAm.length) {
                    read = this.fAr.fAm.length;
                }
                if (this.fAr.fAp && read > 0) {
                    Arrays.fill(this.fAr.fAm, 0, read, (byte) 0);
                }
                if (this.fAr.fAe != null && read > 0) {
                    this.fAr.fAe.d(this.fAr.fAm, read);
                }
            }
        }
    };
    public boolean fzP;
    private HandlerThread mHandlerThread = null;

    public d(AudioRecord audioRecord, a aVar, boolean z, int i, int i2) {
        this.fAd = audioRecord;
        this.fAe = aVar;
        this.fzP = z;
        this.fAn = i;
        this.fAo = i2;
    }

    public final boolean pf() {
        if (this.mHandlerThread != null) {
            w.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
            return false;
        }
        this.mHandlerThread = e.cE("RecordModeAsyncCallback_handlerThread", 10);
        this.mHandlerThread.start();
        this.fAd.setRecordPositionUpdateListener(this.fAq, ae.fetchFreeHandler(this.mHandlerThread.getLooper()));
        this.fAd.setPositionNotificationPeriod(this.fAn);
        if (this.fzP || this.fAm == null) {
            this.fAm = new byte[this.fAo];
        }
        int read = this.fAd.read(this.fAm, 0, this.fAo);
        w.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: " + read);
        if (this.fAe != null && read > 0) {
            this.fAe.d(this.fAm, read);
        }
        return true;
    }

    public final void oP() {
        this.fAd.setRecordPositionUpdateListener(null);
        this.fAd = null;
        this.mHandlerThread.quit();
        this.mHandlerThread = null;
    }

    public final void au(boolean z) {
        this.fAp = z;
    }
}
