package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.appbrand.m.h;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "insertContainer";

    protected final View a(m mVar, JSONObject jSONObject) {
        View aVar = new a(mVar.mContext);
        aVar.setBackgroundColor(0);
        boolean optBoolean = jSONObject.optBoolean("visible", true);
        boolean optBoolean2 = jSONObject.optBoolean("canFullScreenByChild", false);
        int a = h.a(jSONObject, "contentOffsetLeft", 0);
        int a2 = h.a(jSONObject, "contentOffsetTop", 0);
        aVar.setVisibility(optBoolean ? 0 : 4);
        aVar.setPadding(-a, -a2, 0, 0);
        aVar.setDuplicateParentStateEnabled(true);
        aVar.iSj = optBoolean2;
        return aVar;
    }

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("containerId");
    }

    protected final void b(m mVar, int i, View view, JSONObject jSONObject) {
        view.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ b iSk;

            {
                this.iSk = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    c.a((ViewGroup) view, motionEvent);
                }
                return false;
            }
        });
    }
}
