package com.tencent.mm.compatible.b;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;

public final class i extends MediaPlayer {
    public i() {
        e.eg(hashCode());
    }

    public static i a(Context context, Uri uri) {
        try {
            i iVar = new i();
            iVar.setDataSource(context, uri);
            iVar.prepare();
            return iVar;
        } catch (IOException e) {
            w.d("MicroMsg.MediaPlayerWrapper", "create failed:", e);
        } catch (IllegalArgumentException e2) {
            w.d("MicroMsg.MediaPlayerWrapper", "create failed:", e2);
        } catch (SecurityException e3) {
            w.d("MicroMsg.MediaPlayerWrapper", "create failed:", e3);
        }
        return null;
    }

    public final void release() {
        super.release();
        e.eh(hashCode());
    }
}
