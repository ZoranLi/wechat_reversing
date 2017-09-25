package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a extends c {
    public Bundle mjH;

    public void a(d dVar, JSONObject jSONObject, int i) {
    }

    public void a(Context context, String str, com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask.a aVar) {
    }

    public static String d(String str, Map<String, ? extends Object> map) {
        Map hashMap = new HashMap();
        hashMap.put("err_msg", str);
        if (map != null) {
            hashMap.putAll(map);
        }
        com.tencent.mm.plugin.game.gamewebview.a.d.r(hashMap);
        return new JSONObject(hashMap).toString();
    }
}
