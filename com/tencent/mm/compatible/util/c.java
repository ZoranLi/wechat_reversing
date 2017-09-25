package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.compatible.util.b.b;
import com.tencent.mm.sdk.platformtools.w;

@TargetApi(8)
public final class c implements b {
    private Context context;
    private AudioManager gSs;
    public a gSt;
    private OnAudioFocusChangeListener gSu = new OnAudioFocusChangeListener(this) {
        final /* synthetic */ c gSv;

        {
            this.gSv = r1;
        }

        public final void onAudioFocusChange(int i) {
            if (this.gSv.gSt != null) {
                w.d("MicroMsg.AudioFocusHelper", "jacks change: %d", Integer.valueOf(i));
                this.gSv.gSt.cX(i);
            }
        }
    };

    public final void a(a aVar) {
        this.gSt = aVar;
    }

    public c(Context context) {
        this.context = context;
    }

    public final boolean requestFocus() {
        if (this.gSs == null && this.context != null) {
            this.gSs = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        boolean z = this.gSs != null ? 1 == this.gSs.requestAudioFocus(this.gSu, 3, 2) : false;
        w.j("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", Boolean.valueOf(z), Integer.valueOf(this.gSu.hashCode()));
        return z;
    }

    public final boolean rY() {
        if (this.gSs == null && this.context != null) {
            this.gSs = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        boolean z = this.gSs != null ? 1 == this.gSs.abandonAudioFocus(this.gSu) : false;
        w.j("MicroMsg.AudioFocusHelper", "jacks abandonFocus: %B, %x", Boolean.valueOf(z), Integer.valueOf(this.gSu.hashCode()));
        return z;
    }
}
