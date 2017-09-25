package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.sdk.platformtools.w;

public final class g implements a {
    private AutomaticGainControl gNL = null;

    @TargetApi(16)
    public g(AudioRecord audioRecord) {
        boolean isAvailable = AutomaticGainControl.isAvailable();
        w.d("MicroMsg.MMAutomaticGainControl", "available  " + isAvailable);
        if (isAvailable) {
            this.gNL = AutomaticGainControl.create(audioRecord.getAudioSessionId());
        }
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        return AutomaticGainControl.isAvailable();
    }

    @TargetApi(16)
    public final boolean qD() {
        if (this.gNL != null) {
            try {
                int enabled = this.gNL.setEnabled(true);
                if (enabled == 0) {
                    return true;
                }
                w.d("MicroMsg.MMAutomaticGainControl", "setEnabled failed " + enabled);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MMAutomaticGainControl", e, "", new Object[0]);
            }
        }
        return false;
    }
}
