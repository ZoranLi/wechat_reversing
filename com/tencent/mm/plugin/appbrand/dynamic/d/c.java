package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.appbrand.dynamic.core.a;
import com.tencent.mm.plugin.appbrand.dynamic.core.b;
import com.tencent.mm.plugin.appbrand.dynamic.core.e;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public c() {
        super(an.NAME, 266);
    }

    protected final void b(e eVar, JSONObject jSONObject, b.a aVar) {
        Context context = eVar.getContext();
        q.b RT = eVar.RT();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        Map hashMap = new HashMap();
        hashMap.put("model", p.rF());
        hashMap.put("pixelRatio", Float.valueOf(f));
        hashMap.put("windowWidth", Integer.valueOf(h.iC(RT.getInt("__page_view_width", 0))));
        hashMap.put("windowHeight", Integer.valueOf(h.iC(RT.getInt("__page_view_height", 0))));
        hashMap.put("screenWidth", Integer.valueOf(h.iC(displayMetrics.widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(h.iC(displayMetrics.heightPixels)));
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, v.ea(context));
        hashMap.put("version", f.Z(null, d.sYN));
        hashMap.put("system", "Android " + VERSION.RELEASE);
        aVar.f(a(true, "", hashMap));
    }
}
