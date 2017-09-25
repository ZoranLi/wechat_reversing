package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.widget.input.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.a.d;
import com.tencent.mm.plugin.appbrand.widget.input.a.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

abstract class a<P extends f> extends com.tencent.mm.plugin.appbrand.jsapi.a {
    a() {
    }

    protected boolean a(P p, JSONObject jSONObject, m mVar, int i) {
        JSONObject jSONObject2;
        Throwable e;
        JSONObject jSONObject3;
        try {
            jSONObject2 = new JSONObject(jSONObject.getString("style"));
            try {
                p.jwY = Integer.valueOf(h.iD(jSONObject2.getInt("width")));
                try {
                    p.jwZ = Integer.valueOf(h.iD(jSONObject2.getInt("height")));
                } catch (Exception e2) {
                }
                p.jxa = Integer.valueOf(h.iD(jSONObject2.getInt("top")));
                p.jxb = Integer.valueOf(h.iD(jSONObject2.getInt("left")));
            } catch (Exception e3) {
                e = e3;
                if (!TF()) {
                    w.e("MicroMsg.AppBrandJsApiInputBase", "get position info from style, exp = %s", new Object[]{bg.g(e)});
                    mVar.x(i, d("fail:invalid data", null));
                    return false;
                }
                if (jSONObject2 == null) {
                    p.jxj = jSONObject2.optString("fontWeight", null);
                    try {
                        p.jxc = Integer.valueOf(h.iD(jSONObject2.getInt("minHeight")));
                    } catch (Exception e4) {
                    }
                    try {
                        p.jxd = Integer.valueOf(h.iD(jSONObject2.getInt("maxHeight")));
                    } catch (Exception e5) {
                    }
                    p.jxe = jSONObject2.optString("textAlign", null);
                    try {
                        p.jxg = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
                    } catch (Exception e6) {
                    }
                    try {
                        p.jxf = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
                    } catch (Exception e7) {
                    }
                    try {
                        p.jxh = Integer.valueOf(h.iD(jSONObject2.getInt("fontSize")));
                    } catch (Exception e8) {
                    }
                    try {
                        p.jxv = Integer.valueOf(h.iD(jSONObject2.getInt("marginBottom")));
                    } catch (Exception e9) {
                        p.jxv = null;
                    }
                    p.jxy = d.aP(jSONObject2.opt("lineSpace"));
                    if (p.jxy != null) {
                        p.jxy = Integer.valueOf(h.iD(p.jxy.intValue()));
                    }
                    p.jxz = d.aP(jSONObject2.opt("lineHeight"));
                    if (p.jxz != null) {
                        p.jxz = Integer.valueOf(h.iD(p.jxz.intValue()));
                    }
                } else if (!TF()) {
                    w.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
                    mVar.x(i, d("fail:invalid data", null));
                    return false;
                }
                p.jxt = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
                p.jwX = jSONObject.optString("defaultValue", jSONObject.optString(Columns.VALUE, null));
                p.jxk = Integer.valueOf(jSONObject.getInt("maxLength"));
                p.jxl = jSONObject.optString("placeholder");
                jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
                p.jxo = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
                p.jxn = Integer.valueOf(h.iD(jSONObject3.getInt("fontSize")));
                p.jxm = jSONObject3.optString("fontWeight", "normal");
                p.jxq = Boolean.valueOf(jSONObject.optBoolean("hidden", false));
                p.jxp = Boolean.valueOf(jSONObject.getBoolean("disabled"));
                p.jxu = Boolean.valueOf(jSONObject.getBoolean("fixed"));
                p.jxw = b.rq(jSONObject.optString("confirmType"));
                p.jxx = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
                return true;
            }
        } catch (Exception e10) {
            e = e10;
            jSONObject2 = null;
            if (TF()) {
                w.e("MicroMsg.AppBrandJsApiInputBase", "get position info from style, exp = %s", new Object[]{bg.g(e)});
                mVar.x(i, d("fail:invalid data", null));
                return false;
            }
            if (jSONObject2 == null) {
                p.jxj = jSONObject2.optString("fontWeight", null);
                p.jxc = Integer.valueOf(h.iD(jSONObject2.getInt("minHeight")));
                p.jxd = Integer.valueOf(h.iD(jSONObject2.getInt("maxHeight")));
                p.jxe = jSONObject2.optString("textAlign", null);
                p.jxg = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
                p.jxf = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
                p.jxh = Integer.valueOf(h.iD(jSONObject2.getInt("fontSize")));
                p.jxv = Integer.valueOf(h.iD(jSONObject2.getInt("marginBottom")));
                p.jxy = d.aP(jSONObject2.opt("lineSpace"));
                if (p.jxy != null) {
                    p.jxy = Integer.valueOf(h.iD(p.jxy.intValue()));
                }
                p.jxz = d.aP(jSONObject2.opt("lineHeight"));
                if (p.jxz != null) {
                    p.jxz = Integer.valueOf(h.iD(p.jxz.intValue()));
                }
            } else if (TF()) {
                w.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
                mVar.x(i, d("fail:invalid data", null));
                return false;
            }
            p.jxt = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
            p.jwX = jSONObject.optString("defaultValue", jSONObject.optString(Columns.VALUE, null));
            p.jxk = Integer.valueOf(jSONObject.getInt("maxLength"));
            p.jxl = jSONObject.optString("placeholder");
            jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
            p.jxo = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
            p.jxn = Integer.valueOf(h.iD(jSONObject3.getInt("fontSize")));
            p.jxm = jSONObject3.optString("fontWeight", "normal");
            p.jxq = Boolean.valueOf(jSONObject.optBoolean("hidden", false));
            p.jxp = Boolean.valueOf(jSONObject.getBoolean("disabled"));
            p.jxu = Boolean.valueOf(jSONObject.getBoolean("fixed"));
            p.jxw = b.rq(jSONObject.optString("confirmType"));
            p.jxx = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
            return true;
        }
        if (jSONObject2 == null) {
            p.jxj = jSONObject2.optString("fontWeight", null);
            p.jxc = Integer.valueOf(h.iD(jSONObject2.getInt("minHeight")));
            p.jxd = Integer.valueOf(h.iD(jSONObject2.getInt("maxHeight")));
            p.jxe = jSONObject2.optString("textAlign", null);
            p.jxg = Integer.valueOf(Color.parseColor(jSONObject2.getString("color")));
            p.jxf = Integer.valueOf(Color.parseColor(jSONObject2.getString("backgroundColor")));
            p.jxh = Integer.valueOf(h.iD(jSONObject2.getInt("fontSize")));
            p.jxv = Integer.valueOf(h.iD(jSONObject2.getInt("marginBottom")));
            p.jxy = d.aP(jSONObject2.opt("lineSpace"));
            if (p.jxy != null) {
                p.jxy = Integer.valueOf(h.iD(p.jxy.intValue()));
            }
            p.jxz = d.aP(jSONObject2.opt("lineHeight"));
            if (p.jxz != null) {
                p.jxz = Integer.valueOf(h.iD(p.jxz.intValue()));
            }
        } else if (TF()) {
            w.e("MicroMsg.AppBrandJsApiInputBase", "null style obj");
            mVar.x(i, d("fail:invalid data", null));
            return false;
        }
        try {
            p.jxt = Boolean.valueOf(jSONObject.getBoolean("autoSize"));
        } catch (Exception e11) {
        }
        p.jwX = jSONObject.optString("defaultValue", jSONObject.optString(Columns.VALUE, null));
        try {
            p.jxk = Integer.valueOf(jSONObject.getInt("maxLength"));
        } catch (Exception e12) {
        }
        p.jxl = jSONObject.optString("placeholder");
        try {
            jSONObject3 = new JSONObject(jSONObject.getString("placeholderStyle"));
            p.jxo = Integer.valueOf(Color.parseColor(jSONObject3.getString("color")));
            p.jxn = Integer.valueOf(h.iD(jSONObject3.getInt("fontSize")));
            p.jxm = jSONObject3.optString("fontWeight", "normal");
        } catch (Exception e13) {
        }
        p.jxq = Boolean.valueOf(jSONObject.optBoolean("hidden", false));
        try {
            p.jxp = Boolean.valueOf(jSONObject.getBoolean("disabled"));
        } catch (Exception e14) {
            p.jxp = null;
        }
        try {
            p.jxu = Boolean.valueOf(jSONObject.getBoolean("fixed"));
        } catch (Exception e15) {
            p.jxu = null;
        }
        p.jxw = b.rq(jSONObject.optString("confirmType"));
        try {
            p.jxx = Boolean.valueOf(jSONObject.getBoolean("confirmHold"));
        } catch (Exception e16) {
            p.jxx = null;
        }
        return true;
    }

    protected boolean TF() {
        return false;
    }

    protected static void aW(String str, String str2) {
        q.yC().n("AppBrandJsInput@" + str, true).H("passing_data", str2);
    }

    protected static m pr(String str) {
        WeakReference weakReference = (WeakReference) q.yC().fO("AppBrandJsInput@" + str).fS("webview_reference");
        return weakReference == null ? null : (m) weakReference.get();
    }
}
