package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class m implements e {
    private int audioSampleRate;
    private int bitrate;
    private int lMh;
    private int nDX;
    private float nFj;
    private String nFt;

    public m(int i, String str, float f, int i2, int i3, int i4) {
        this.nDX = i;
        this.nFt = str;
        this.nFj = f;
        this.bitrate = i2;
        this.lMh = i3;
        this.audioSampleRate = i4;
        w.d("MicroMsg.MMSightMP4Muxer", "create MMSightMP4Muxer, bufId: %s, recordPath: %s, fps: %s, bitrate: %s, videoDuration: %s, audioSampleRate%s", new Object[]{Integer.valueOf(i), str, Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public final boolean aLo() {
        String str;
        long NA = bg.NA();
        String Ep = d.Ep(this.nFt);
        try {
            if (!FileOp.aO(Ep)) {
                Ep = null;
            }
            str = Ep;
        } catch (Exception e) {
            str = null;
        }
        w.i("MicroMsg.MMSightMP4Muxer", "start mux, bufId: %s, aacFile: %s", new Object[]{Integer.valueOf(this.nDX), str});
        w.i("MicroMsg.MMSightMP4Muxer", "mux sight end, duration %ds, used %sms", new Object[]{Integer.valueOf(SightVideoJNI.muxing(this.nDX, str, this.audioSampleRate, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, 1, 0, this.nFt, this.nFj, Math.max(1000, this.lMh), this.bitrate, b.ptx, 8, 2, 23.0f, null, 0, b.pty)), Long.valueOf(bg.aB(NA))});
        if (!bg.mA(str)) {
            try {
                FileOp.deleteFile(str);
            } catch (Exception e2) {
            }
        }
        if (r2 >= 0) {
            return true;
        }
        return false;
    }
}
