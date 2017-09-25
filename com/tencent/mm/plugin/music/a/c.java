package com.tencent.mm.plugin.music.a;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    public OnAudioFocusChangeListener nSs = new OnAudioFocusChangeListener(this) {
        final /* synthetic */ c nSt;

        {
            this.nSt = r1;
        }

        public final void onAudioFocusChange(int i) {
            w.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", new Object[]{Integer.valueOf(i)});
            if (i == -2 || i == -3) {
                w.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
                if (i.aNS().aNK().HK()) {
                    i.aNS().aNK().aNE();
                }
            } else if (i == 1 || i == 2 || i == 3) {
                w.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
                if (i.aNS().aNK().HK()) {
                    i.aNS().aNK().resume();
                }
            } else if (i == -1) {
                w.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
                if (i.aNS().aNK().HK()) {
                    i.aNS().aNK().aNE();
                    i.aNS();
                    f.aNN();
                    i.aNS().aNO();
                }
                i.aNU().abandonAudioFocus(this.nSt.nSs);
            }
        }
    };

    public final boolean requestFocus() {
        boolean z;
        int requestAudioFocus = i.aNU().requestAudioFocus(this.nSs, 3, 2);
        String str = "MicroMsg.Music.MusicAudioFocusHelper";
        String str2 = "request audio focus %b";
        Object[] objArr = new Object[1];
        if (requestAudioFocus == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        if (requestAudioFocus == 1) {
            return true;
        }
        return false;
    }

    public final void aNB() {
        w.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
        i.aNU().abandonAudioFocus(this.nSs);
    }
}
