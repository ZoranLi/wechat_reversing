package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.w;

public class VoiceResetUI extends VoiceUnLockUI {
    protected final void boO() {
        w.d("MicroMsg.VoiceResetUI", "unlock success");
        startActivity(new Intent(this, VoiceCreateUI.class));
        finish();
    }
}
