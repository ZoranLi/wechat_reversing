package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.sdk.platformtools.w;

public final class d implements a {
    private AcousticEchoCanceler gNo = null;

    @TargetApi(16)
    public d(AudioRecord audioRecord) {
        boolean isAvailable = AcousticEchoCanceler.isAvailable();
        w.d("MicroMsg.MMAcousticEchoCanceler", "available  " + isAvailable);
        if (isAvailable) {
            this.gNo = AcousticEchoCanceler.create(audioRecord.getAudioSessionId());
        }
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        return AcousticEchoCanceler.isAvailable();
    }

    @TargetApi(16)
    public final boolean qD() {
        if (this.gNo != null) {
            try {
                int enabled = this.gNo.setEnabled(true);
                if (enabled == 0) {
                    return true;
                }
                w.d("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed " + enabled);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MMAcousticEchoCanceler", e, "", new Object[0]);
            }
        }
        return false;
    }
}
