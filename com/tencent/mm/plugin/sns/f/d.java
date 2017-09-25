package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d {
    public boolean fGu = true;
    public String naR = "";
    public String pZL = "";
    public String pZM = "";
    public int qan = 0;
    public List<b> qao = new ArrayList();

    static class a {
        public int actionType;
        public int index;
        public String jumpUrl;
        public String qap;
        public String qaq;
        public int qar;

        a() {
        }
    }

    static class b {
        public int qas;
        public List<a> qat = new ArrayList();
        public int showType;
        public String title;

        b() {
        }
    }

    public final boolean e(String str, String str2, Map<String, String> map) {
        this.pZM = str;
        this.pZL = str2;
        if (map != null) {
            try {
                this.qao.clear();
                this.naR = bg.ap((String) map.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE), "");
                if (!this.naR.equals("zh_cn")) {
                    this.fGu = false;
                }
                int PY = bg.PY((String) map.get("tipcount"));
                int PY2 = bg.PY((String) map.get("expertype"));
                for (int i = 0; i < PY; i++) {
                    b bVar = new b();
                    bVar.title = bg.ap((String) map.get(String.format("tip_%d_basetextformat", new Object[]{Integer.valueOf(i)})), "");
                    bVar.qas = bg.PY((String) map.get(String.format("tip_%d_id", new Object[]{Integer.valueOf(i)})));
                    bVar.showType = bg.PY((String) map.get(String.format("tip_%d_showtype", new Object[]{Integer.valueOf(i)})));
                    int PY3 = bg.PY((String) map.get(String.format("tip_%d_button_count", new Object[]{Integer.valueOf(i)})));
                    if (bVar.showType >= 6) {
                        this.fGu = false;
                    }
                    for (int i2 = 0; i2 < PY3; i2++) {
                        a aVar = new a();
                        aVar.index = bg.PY((String) map.get(String.format("tip_%d_button_%d_index", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        aVar.actionType = bg.PY((String) map.get(String.format("tip_%d_button_%d_actiontype", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        aVar.qap = bg.ap((String) map.get(String.format("tip_%d_button_%d_basetextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.jumpUrl = bg.ap((String) map.get(String.format("tip_%d_button_%d_jumpurl", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.qaq = bg.ap((String) map.get(String.format("tip_%d_button_%d_priortextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.qar = bg.PY((String) map.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        if (aVar.actionType >= 9) {
                            this.fGu = false;
                        }
                        bVar.qat.add(aVar);
                    }
                    this.qao.add(bVar);
                }
                w.i("Micromsg.SnsABTestInfo", "expertType " + PY2 + " " + str);
            } catch (Throwable e) {
                w.printErrStackTrace("Micromsg.SnsABTestInfo", e, "feed xml error ", new Object[0]);
            }
        }
        return false;
    }
}
