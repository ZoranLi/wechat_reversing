package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import java.util.List;
import org.json.JSONObject;

public final class l extends b {
    public static final int CTRL_INDEX = 3;
    public static final String NAME = "removeMap";

    protected final int h(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            w.e("MicroMsg.JsApiRemoveMap", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean c(m mVar, int i, View view, JSONObject jSONObject) {
        q.b im = mVar.jdc.im(i);
        if (im == null) {
            w.i("MicroMsg.JsApiRemoveMap", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        }
        try {
            final SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(R.h.bSq);
            List list = (List) im.fS("markers");
            List list2 = (List) im.fS("converters");
            if (list != null && list.size() > 0) {
                list.clear();
            }
            if (list2 != null && list2.size() > 0) {
                list2.clear();
            }
            af.v(new Runnable(this) {
                final /* synthetic */ l iTn;

                public final void run() {
                    if (soSoMapView != null) {
                        soSoMapView.setVisibility(8);
                        soSoMapView.clean();
                    }
                }
            });
            im.recycle();
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.JsApiRemoveMap", "get SoSoMapView(%s) by id failed, exception : %s", new Object[]{Integer.valueOf(i), e});
            return false;
        }
    }
}
