package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.graphics.Color;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.y;
import org.json.JSONObject;

public final class k extends a {
    public static final int CTRL_BYTE = 189;
    public static final String NAME = "clearBounceBackground";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiClearBounceBackground", "invoke");
        if (dVar.mmy != null) {
            dVar.mHandler.post(new Runnable(dVar) {
                final /* synthetic */ d mnm;

                {
                    this.mnm = r1;
                }

                public final void run() {
                    this.mnm.mmy.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new y<String>(this) {
                        final /* synthetic */ AnonymousClass24 mns;

                        {
                            this.mns = r1;
                        }

                        public final /* synthetic */ void onReceiveValue(Object obj) {
                            String str = (String) obj;
                            w.d("MicroMsg.GameWebPageView", "get background color s = %s", new Object[]{str});
                            if (!bg.mA(str)) {
                                int color = this.mns.mnm.mmc.getResources().getColor(R.e.aWs);
                                String[] split;
                                if (d.mnk.matcher(str).matches()) {
                                    split = str.replaceAll("\"", "").replaceFirst("rgba", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                                    if (split.length == 4) {
                                        try {
                                            color = Color.argb(bg.getInt(bg.mz(split[3]).trim(), 0), bg.getInt(bg.mz(split[0]).trim(), 0), bg.getInt(bg.mz(split[1]).trim(), 0), bg.getInt(bg.mz(split[2]).trim(), 0));
                                        } catch (Exception e) {
                                            w.e("MicroMsg.GameWebPageView", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e});
                                            return;
                                        }
                                    }
                                    return;
                                } else if (d.mnl.matcher(str).matches()) {
                                    split = str.replaceAll("\"", "").replaceFirst("rgb", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                                    if (split.length == 3) {
                                        try {
                                            color = Color.argb(255, bg.getInt(bg.mz(split[0]).trim(), 0), bg.getInt(bg.mz(split[1]).trim(), 0), bg.getInt(bg.mz(split[2]).trim(), 0));
                                        } catch (Exception e2) {
                                            w.e("MicroMsg.GameWebPageView", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e2});
                                            return;
                                        }
                                    }
                                    return;
                                } else {
                                    w.d("MicroMsg.GameWebPageView", "handle bgColor from html, bgColor = %s, can not match", new Object[]{str});
                                }
                                this.mns.mnm.mmw.wm(color);
                                this.mns.mnm.mmw.bxT();
                            }
                        }
                    });
                }
            });
        }
        dVar.x(i, a.d("clearBounceBackground:ok", null));
    }
}
