package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h {
    public boolean fGu = true;
    public String naR = "";
    public String pZL = "";
    public String pZM = "";
    public String qaB = "";
    public int[] qaC;
    public int qan = 0;
    public List<a> qao = new ArrayList();

    public final boolean bfE() {
        return this.fGu && this.qao != null && this.qao.size() > 0;
    }

    public final boolean e(String str, String str2, Map<String, String> map) {
        this.pZM = str;
        this.pZL = str2;
        if (map != null) {
            try {
                this.qao.clear();
                this.naR = bg.ap((String) map.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE), "");
                this.qaB = bg.ap((String) map.get("first_step_order"), "");
                String[] split = this.qaB.split("\\|");
                this.qaC = new int[split.length];
                if (this.qaC.length == 0) {
                    this.fGu = false;
                }
                int i = 0;
                while (i < split.length) {
                    this.qaC[i] = bg.PY(split[i]);
                    if (this.qaC[i] <= 0 || this.qaC[i] > 3) {
                        this.fGu = false;
                    }
                    i++;
                }
                int PY = bg.PY((String) map.get("wording_count"));
                int PY2 = bg.PY((String) map.get("expertype"));
                for (int i2 = 0; i2 < PY; i2++) {
                    a aVar = new a();
                    aVar.pZe = bg.PY((String) map.get(String.format("wording_%d_id", new Object[]{Integer.valueOf(i2 + 1)})));
                    aVar.pZf = bg.ap((String) map.get(String.format("wording_%d_zh_CN", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.pZg = bg.ap((String) map.get(String.format("wording_%d_zh_TW", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.pZh = bg.ap((String) map.get(String.format("wording_%d_en", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.pZi = bg.PY((String) map.get(String.format("wording_%d_action_type", new Object[]{Integer.valueOf(i2 + 1)})));
                    this.qao.add(aVar);
                }
                w.i("MicroMsg.SnsAdAbTestInfo", "expertType " + PY2 + " " + str + " " + this.qaB);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SnsAdAbTestInfo", e, "feed xml error ", new Object[0]);
            }
        }
        return false;
    }
}
