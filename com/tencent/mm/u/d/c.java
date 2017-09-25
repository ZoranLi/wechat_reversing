package com.tencent.mm.u.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ap.j;
import com.tencent.mm.ap.n;
import com.tencent.mm.ap.t;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.m;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class c implements e {
    private static c hpM;
    private ArrayList<a> gUN = new ArrayList();
    public SharedPreferences hgx = ab.bIY();
    private final int hpI = 21;
    private final String hpJ = "trace_config_last_update_time";
    private final long hpK = 86400000;
    public volatile boolean hpL = false;

    interface a {
        void AE();
    }

    private c() {
    }

    public static c AI() {
        if (hpM == null) {
            synchronized (c.class) {
                if (hpM == null) {
                    hpM = new c();
                }
            }
        }
        return hpM;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        w.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(type));
        if (!(kVar instanceof m) || ((m) kVar).BQ() != 21) {
            w.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
        } else if (type == JsApiGetBackgroundAudioState.CTRL_INDEX) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ap.m[] gl = t.Ic().gl(21);
                if (gl == null || gl.length == 0) {
                    w.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
                    release();
                    return;
                }
                com.tencent.mm.ap.m mVar = gl[0];
                w.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + mVar.id + " version:" + mVar.version + " status:" + mVar.status + " type:" + mVar.fKL);
                if (5 == mVar.status) {
                    ap.vd().a(new j(mVar.id, 21), 0);
                    return;
                }
                w.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
                this.hgx.edit().putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
                release();
                return;
            }
            release();
        } else if (type == JsApiSetBackgroundAudioState.CTRL_INDEX) {
            if (i == 0 && i2 == 0) {
                fo(((j) kVar).hOj);
            }
            release();
        }
    }

    private void fo(int i) {
        t.Ic();
        try {
            Map q = bh.q(com.tencent.mm.a.e.aT(new File(new File(n.HY()), t.Ic().aS(i, 21)).getPath()), "TraceConfig");
            if (q == null) {
                w.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
                return;
            }
            int i2;
            String str = ".TraceConfig.Item";
            Map hashMap = new HashMap();
            int i3 = 0;
            while (true) {
                String str2 = str + (i3 == 0 ? "" : Integer.valueOf(i3));
                String str3 = (String) q.get(str2 + ".$key");
                if (str3 == null) {
                    break;
                }
                i2 = i3 + 1;
                long j = bg.getLong((String) q.get(str2), -1);
                if (j >= 0) {
                    w.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i2 + " key: " + str3 + "|value: " + j);
                    hashMap.put(str3, Long.valueOf(j));
                    i3 = i2;
                } else {
                    i3 = i2;
                }
            }
            Editor edit = this.hgx.edit();
            for (Entry entry : hashMap.entrySet()) {
                edit.putLong((String) entry.getKey(), ((Long) entry.getValue()).longValue());
            }
            edit.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
            w.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + hashMap.size());
            i2 = this.gUN.size();
            for (i3 = 0; i3 < i2; i3++) {
                ((a) this.gUN.get(i3)).AE();
            }
            com.tencent.mm.ap.m aQ = t.Ic().aQ(i, 21);
            aQ.status = 2;
            t.Ic().b(aQ);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TraceConfigUpdater", e, "", new Object[0]);
        }
    }

    public final void release() {
        w.i("MicroMsg.TraceConfigUpdater", "summer release");
        this.hpL = false;
        ap.vd().b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
        ap.vd().b((int) JsApiSetBackgroundAudioState.CTRL_INDEX, (e) this);
    }

    public final boolean a(a aVar) {
        if (aVar == null || this.gUN.contains(aVar)) {
            return false;
        }
        return this.gUN.add(aVar);
    }
}
