package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.game.gamewebview.a.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

public class GameJsApiInterface {
    public Handler iHc;
    private Map<String, c> iKG;
    protected d mjP;
    public JSONObject mjQ;
    public HashSet<String> mjR = new HashSet();

    public GameJsApiInterface(d dVar) {
        this.mjP = dVar;
        this.iKG = d.azm();
        HandlerThread handlerThread = new HandlerThread("GameWebviewAsyncJSThread");
        handlerThread.start();
        this.iHc = new Handler(handlerThread.getLooper());
    }

    @JavascriptInterface
    public String invokeHandler(final String str, final String str2, final int i, long j) {
        w.i("MicroMsg.GameJsApiInterface", "api: %s, time: %d", new Object[]{str, Long.valueOf(System.currentTimeMillis() - j)});
        int xs = b.xs(str);
        if (xs > 0) {
            g.oUh.a(157, (long) xs, 1, false);
        }
        String str3 = "";
        try {
            String t;
            boolean z = this.iKG.get(str) instanceof e;
            if (z) {
                t = t(str, str2, i);
            } else {
                this.iHc.post(new Runnable(this) {
                    final /* synthetic */ GameJsApiInterface mjS;

                    public final void run() {
                        this.mjS.t(str, str2, i);
                    }
                });
                t = str3;
            }
            String str4 = "MicroMsg.GameJsApiInterface";
            String str5 = "invokeHandler, api: %s, data size: %d, sync: %b, time: %d";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            if (str2 == null) {
                xs = 0;
            } else {
                xs = str2.length();
            }
            objArr[1] = Integer.valueOf(xs);
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Long.valueOf(System.currentTimeMillis() - r10);
            w.i(str4, str5, objArr);
            return t;
        } catch (Exception e) {
            w.e("MicroMsg.GameJsApiInterface", "Invoke Error: %s, %s\n%s", new Object[]{str, e.getMessage(), e.getStackTrace()});
            throw e;
        }
    }

    public final String t(String str, String str2, int i) {
        if (this.mjP == null || this.mjP.azK() == null) {
            w.e("MicroMsg.GameJsApiInterface", "activity is null");
            return "";
        }
        String xy;
        c cVar = (c) this.iKG.get(str);
        boolean z = cVar instanceof e;
        JSONObject pb = pb(str2);
        if (cVar == null) {
            xy = xy("system:function_not_exist");
        } else {
            boolean z2;
            if (this.mjR.contains(cVar.getName())) {
                this.mjR.remove(cVar.getName());
                z2 = true;
            } else {
                z2 = this.mjP.aY(cVar.getName(), cVar.azi());
            }
            if (z2) {
                try {
                    if (this.mjQ != null) {
                        if (!bg.mA(this.mjQ.optString("srcUsername"))) {
                            pb.put("src_username", this.mjQ.optString("srcUsername"));
                        }
                        if (!bg.mA(this.mjQ.optString("srcDisplayname"))) {
                            pb.put("src_displayname", this.mjQ.optString("srcDisplayname"));
                        }
                        if (!bg.mA(this.mjQ.optString("KTemplateId"))) {
                            pb.put("tempalate_id", this.mjQ.optString("KTemplateId"));
                        }
                        pb.put("message_id", this.mjQ.optLong("message_id"));
                        pb.put("message_index", this.mjQ.optInt("message_index"));
                        pb.put("webview_scene", this.mjQ.optInt("scene"));
                        pb.put("stastic_scene", this.mjQ.optInt("stastic_scene"));
                    }
                    pb.put("current_url", this.mjP.azN());
                    pb.put("current_appid", this.mjP.azO());
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.GameJsApiInterface", e, "", new Object[0]);
                }
                if (z) {
                    xy = "";
                } else {
                    a aVar = (a) cVar;
                    if (aVar.azk() == 2) {
                        GameJsApiActivityTask gameJsApiActivityTask = new GameJsApiActivityTask(this.mjP.azK());
                        gameJsApiActivityTask.mjK = this.mjP;
                        gameJsApiActivityTask.iMH = i;
                        gameJsApiActivityTask.mjM = aVar.getName();
                        gameJsApiActivityTask.mjL = pb.toString();
                        gameJsApiActivityTask.avz();
                        xy = null;
                    } else if (aVar.azk() == 1) {
                        GWMainProcessTask gameJsApiMMTask = new GameJsApiMMTask();
                        gameJsApiMMTask.mjK = this.mjP;
                        gameJsApiMMTask.iMH = i;
                        gameJsApiMMTask.mjM = aVar.getName();
                        gameJsApiMMTask.mjL = pb.toString();
                        gameJsApiMMTask.SM();
                        GameWebViewMainProcessService.a(gameJsApiMMTask);
                        xy = null;
                    } else {
                        aVar.a(this.mjP, pb, i);
                        xy = null;
                    }
                }
            } else {
                xy = xy("system:access_denied");
            }
        }
        if (z) {
            return xy;
        }
        if (xy != null) {
            this.mjP.x(i, xy);
        }
        return "";
    }

    private static String xy(String str) {
        Map hashMap = new HashMap();
        hashMap.put("err_msg", str);
        return new JSONObject(hashMap).toString();
    }

    private static JSONObject pb(String str) {
        try {
            if (bg.mA(str)) {
                str = "{}";
            }
            return new JSONObject(str);
        } catch (Exception e) {
            w.e("MicroMsg.GameJsApiInterface", e.getMessage());
            return new JSONObject();
        }
    }
}
