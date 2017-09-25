package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public final class e {
    public int sIq = -7829368;
    public boolean sIr = false;
    public int sIs = -1593835521;
    public boolean sIt = false;
    public int sIu = WebView.NIGHT_MODE_COLOR;
    public boolean sIv = false;
    public int sIw = 0;
    public boolean sIx = false;
    private int version = 0;

    public e(String str) {
        String str2 = "chatbg";
        Map q = bh.q(str, str2);
        String str3 = "." + str2;
        try {
            this.version = bg.f(Integer.valueOf((String) q.get(str3 + ".$version")));
            this.sIq = (int) bg.a(Long.valueOf(Long.parseLong((String) q.get(str3 + ".$time_color"), 16)), -7829368);
            this.sIr = bg.f(Boolean.valueOf((String) q.get(str3 + ".$time_show_shadow_color")));
            this.sIs = (int) bg.a(Long.valueOf(Long.parseLong((String) q.get(str3 + ".$time_shadow_color"), 16)), 0);
            this.sIt = bg.f(Boolean.valueOf((String) q.get(str3 + ".$time_show_background")));
            this.sIu = (int) bg.a(Long.valueOf(Long.parseLong((String) q.get(str3 + ".$voice_second_color"), 16)), -16777216);
            this.sIv = bg.f(Boolean.valueOf((String) q.get(str3 + ".$voice_second_show_shadow_color")));
            this.sIw = (int) bg.a(Long.valueOf(Long.parseLong((String) q.get(str3 + ".$voice_second_shadow_color"), 16)), 0);
            this.sIx = bg.f(Boolean.valueOf((String) q.get(str3 + ".$voice_second_show_background")));
        } catch (Throwable e) {
            w.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
            w.printErrStackTrace("MicroMsg.ChatBgAttr", e, "", new Object[0]);
        }
    }
}
