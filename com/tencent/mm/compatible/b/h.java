package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.NoiseSuppressor;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.sdk.platformtools.w;

public final class h implements a {
    private NoiseSuppressor gNM = null;

    @TargetApi(16)
    public h(AudioRecord audioRecord) {
        boolean isAvailable = NoiseSuppressor.isAvailable();
        w.d("MicroMsg.MMNoiseSuppressor", "available  " + isAvailable);
        if (isAvailable) {
            this.gNM = NoiseSuppressor.create(audioRecord.getAudioSessionId());
        }
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        return NoiseSuppressor.isAvailable();
    }

    @TargetApi(16)
    public final boolean qD() {
        if (this.gNM != null) {
            try {
                int enabled = this.gNM.setEnabled(true);
                if (enabled == 0) {
                    return true;
                }
                w.d("MicroMsg.MMNoiseSuppressor", "setEnabled failed " + enabled);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MMNoiseSuppressor", e, "", new Object[0]);
            }
        }
        return false;
    }
}
