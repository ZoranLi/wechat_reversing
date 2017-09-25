package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g;
import com.tencent.mm.y.g.b;
import java.util.LinkedList;

public final class i {
    private com.tencent.mm.y.g.a fJd = new com.tencent.mm.y.g.a(this) {
        final /* synthetic */ i rUh;

        {
            this.rUh = r1;
        }

        public final void oW() {
            this.rUh.rUf.lEZ.a(null);
            this.rUh.rUf.lEZ.a(null);
            this.rUh.b(this.rUh.rUf);
        }
    };
    private b fJe = new b(this) {
        final /* synthetic */ i rUh;

        {
            this.rUh = r1;
        }

        public final void onError() {
            this.rUh.rUf.lEZ.a(null);
            this.rUh.rUf.lEZ.a(null);
            this.rUh.b(this.rUh.rUf);
        }
    };
    AudioManager gNq = ((AudioManager) ab.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));
    public a rUf;
    BroadcastReceiver rUg = new BroadcastReceiver(this) {
        final /* synthetic */ i rUh;

        {
            this.rUh = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("state") && intent.getIntExtra("state", 2) == 0) {
                this.rUh.bvQ();
            }
        }
    };

    private class a {
        g lEZ;
        LinkedList<au> rUi;
    }

    public i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        ab.getContext().registerReceiver(this.rUg, intentFilter);
    }

    public final void bvQ() {
        a(this.rUf);
    }

    private static a a(a aVar) {
        if (aVar != null) {
            aVar.lEZ.stop();
            aVar.lEZ.a(null);
            aVar.lEZ.a(null);
            aVar.rUi.clear();
        }
        return null;
    }

    public final void b(a aVar) {
        while (aVar != null) {
            if (aVar.rUi.size() > 0) {
                au auVar = (au) aVar.rUi.getLast();
                aVar.rUi.removeLast();
                q.E(auVar);
                w.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", new Object[]{Long.valueOf(auVar.field_msgId), q.js(auVar.field_imgPath)});
                if (aVar.lEZ.a(q.js(auVar.field_imgPath), true, true, -1)) {
                    aVar.lEZ.a(this.fJd);
                    aVar.lEZ.a(this.fJe);
                    return;
                }
            }
            a(aVar);
            return;
        }
    }
}
