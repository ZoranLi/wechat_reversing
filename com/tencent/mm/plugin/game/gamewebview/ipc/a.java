package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.gamewebview.b.a.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.Map.Entry;

public final class a {
    private static HashMap<Integer, GameMMToClientEvent> iKw = new HashMap();
    private static m lTJ;

    static {
        m anonymousClass1 = new com.tencent.mm.network.m.a() {
            private final byte[] gJW = new byte[0];

            public final void cU(int i) {
                synchronized (this.gJW) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("mm_to_client_notify_type", 1);
                    bundle.putString("js_event_name", d.NAME);
                    bundle.putString(DownloadInfo.NETTYPE, s.bwv());
                    a.x(bundle);
                }
            }
        };
        lTJ = anonymousClass1;
        ap.a(anonymousClass1);
    }

    public static void a(int i, GameMMToClientEvent gameMMToClientEvent) {
        iKw.put(Integer.valueOf(i), gameMMToClientEvent);
    }

    public static void nr(int i) {
        iKw.remove(Integer.valueOf(i));
    }

    public static synchronized void x(Bundle bundle) {
        synchronized (a.class) {
            w.d("MicroMsg.GameMMToClientEventCenter", "notifyToAllClint");
            for (Entry entry : iKw.entrySet()) {
                GameMMToClientEvent gameMMToClientEvent = (GameMMToClientEvent) entry.getValue();
                if (gameMMToClientEvent != null) {
                    gameMMToClientEvent.mjs = ((Integer) entry.getKey()).intValue();
                    gameMMToClientEvent.lHw = bundle;
                    gameMMToClientEvent.SL();
                }
            }
        }
    }
}
