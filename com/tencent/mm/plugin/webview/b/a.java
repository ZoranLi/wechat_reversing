package com.tencent.mm.plugin.webview.b;

import com.tencent.mm.a.g;
import com.tencent.mm.e.a.ld;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.Map;

public final class a implements e {
    public a rUZ = new a(this);
    private c rVa = new c<ld>(this) {
        final /* synthetic */ a rVb;

        {
            this.rVb = r2;
            this.usg = ld.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            ld ldVar = (ld) bVar;
            if (!(ldVar instanceof ld)) {
                return false;
            }
            this.rVb.rUZ.a(ldVar.fRL.type, ldVar.fRL.fRM, ldVar.fRL.fRN, ldVar.fRL.fRO, ldVar.fRL.fRP);
            return true;
        }
    };

    private class a {
        public boolean aJi;
        public boolean fHO;
        final /* synthetic */ a rVb;
        private b rVc;
        private String rVd;
        private long rVe;

        public a(a aVar) {
            this.rVb = aVar;
        }

        public final void a(int i, String str, String str2, int i2, long j) {
            String str3;
            if (bg.mA(str)) {
                String str4 = "MicroMsg.emoji.EmojiStoreWebViewLogic";
                String str5 = "error query:%s type:%d pagebuf:%s ";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i);
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = str2.toString();
                }
                objArr[2] = str3;
                w.i(str4, str5, objArr);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(i);
            str3 = g.n(stringBuffer.toString().getBytes());
            if (!bg.mA(this.rVd) && this.rVd.equals(str3) && System.currentTimeMillis() - this.rVe <= 8000 && bg.mA(str2)) {
                if (this.fHO) {
                    w.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", new Object[]{str});
                    h.wH(i2).a(this.rVc.bwb().tZM, true, n.b(this.rVc.bwb().tDW), this.rVc.bwb().tDZ);
                    return;
                } else if (this.aJi) {
                    if (this.rVc != null) {
                        this.rVc.rVf = i2;
                    }
                    w.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
                    return;
                } else {
                    w.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
                }
            }
            w.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", new Object[]{str, str3, Integer.valueOf(i2)});
            if (this.rVc != null) {
                ap.vd().c(this.rVc);
            }
            this.rVd = str3;
            this.rVe = System.currentTimeMillis();
            this.aJi = true;
            this.fHO = false;
            ap.vd().a(234, this.rVb);
            this.rVc = new b(i, str, str2.getBytes(), i2, j);
            ap.vd().a(this.rVc, 0);
        }
    }

    public a() {
        com.tencent.mm.sdk.b.a.urY.b(this.rVa);
    }

    public final boolean K(Map<String, Object> map) {
        w.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", new Object[]{map.toString()});
        String o = o(map, "keyword");
        String o2 = o(map, "nextPageBuffer");
        int p = p(map, Columns.TYPE);
        int p2 = p(map, "webview_instance_id");
        String o3 = o(map, "searchID");
        this.rUZ.a(p, o, o2, p2, bg.mA(o3) ? 0 : Long.valueOf(o3).longValue());
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof b) {
            ap.vd().b(234, this);
            this.rUZ.aJi = false;
            b bVar = (b) kVar;
            if (i == 0 && i2 == 0) {
                this.rUZ.fHO = true;
            } else {
                this.rUZ.fHO = false;
                h.wH(bVar.rVf).a("{}", bVar.rVg, "", 0);
            }
            h.wH(bVar.rVf).a(bVar.bwb().tZM, bVar.rVg, n.b(bVar.bwb().tDW), bVar.bwb().tDZ);
        }
    }

    public static String o(Map<String, Object> map, String str) {
        if (map.containsKey(str)) {
            return map.get(str) != null ? map.get(str).toString() : "";
        } else {
            return "";
        }
    }

    public static int p(Map<String, Object> map, String str) {
        String o = o(map, str);
        if (bg.mA(o)) {
            return 0;
        }
        return Integer.valueOf(o).intValue();
    }
}
