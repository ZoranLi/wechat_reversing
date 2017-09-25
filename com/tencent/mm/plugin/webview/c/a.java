package com.tencent.mm.plugin.webview.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.o;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass24;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private Context context;
    private MMWebView oET;
    private HashMap<String, Object> rVh = new HashMap();
    private HashMap<String, Object> rVi = new HashMap();
    private HashMap<String, Object> rVj = new HashMap();
    public int rVk = -1;
    public e rVl;
    public d rVm;
    Map<String, c> rVn = new HashMap();
    private Map<String, b> rVo = new HashMap();

    private static class a implements k {
        private a() {
        }

        public final Bundle l(Bundle bundle) {
            int i;
            com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100266");
            if (dX.isValid()) {
                i = u.getInt((String) dX.bKK().get("search_wa_widget_init_out_time"), 8000);
            } else {
                i = 8000;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("search_wa_widget_init_out_time", i);
            return bundle2;
        }
    }

    private class b {
        int fKL;
        String fTO;
        int izW;
        String rVA;
        final /* synthetic */ a rVr;

        public b(a aVar) {
            this.rVr = aVar;
        }
    }

    private class c {
        int rVB;
        int rVC;
        final /* synthetic */ a rVr;

        public c(a aVar) {
            this.rVr = aVar;
        }

        public final String toString() {
            return String.format("minH %d, maxH %d", new Object[]{Integer.valueOf(this.rVB), Integer.valueOf(this.rVC)});
        }
    }

    public a(Context context, MMWebView mMWebView) {
        this.context = context;
        this.oET = mMWebView;
        this.rVl = (e) h.h(e.class);
    }

    public final void J(Bundle bundle) {
        b bVar = (b) this.rVo.get((String) bundle.get("widgetId"));
        if (bVar != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("app_id", bVar.fTO);
            bundle2.putString("msg_id", bVar.rVA);
            bundle2.putInt("pkg_type", bVar.fKL);
            bundle2.putInt("pkg_version", bVar.izW);
            ((e) h.h(e.class)).AN().b(this.context, bundle2);
        }
    }

    public final void a(Bundle bundle, int i) {
        String string = bundle.getString("fts_key_json_data");
        final String string2 = bundle.getString("fts_key_widget_view_cache_key");
        final String aM = com.tencent.mm.plugin.appbrand.l.b.aM(this);
        w.i("FTSSearchWidetMgr", "inserting widget: widgetId %s, sessionId %s, jsonData %s ", new Object[]{string2, aM, string});
        if (string == null || string.length() == 0) {
            w.i("FTSSearchWidetMgr", "insert args invalid");
            return;
        }
        try {
            b bVar;
            int optInt;
            b bVar2 = (b) this.rVo.get(string2);
            if (bVar2 == null) {
                bVar2 = new b(this);
                this.rVo.put(string2, bVar2);
                bVar = bVar2;
            } else {
                bVar = bVar2;
            }
            final JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("maxHeight") && jSONObject.has("minHeight")) {
                c cVar = (c) this.rVn.get(string2);
                if (cVar == null) {
                    cVar = new c(this);
                    this.rVn.put(string2, cVar);
                }
                cVar.rVB = jSONObject.optInt("minHeight");
                cVar.rVC = jSONObject.optInt("maxHeight");
                w.i("FTSSearchWidetMgr", "update widgetSize %s", new Object[]{cVar.toString()});
            } else {
                try {
                    w.i("FTSSearchWidetMgr", "removew widgetSize " + ((c) this.rVn.remove(string2)));
                } catch (Exception e) {
                    w.e("FTSSearchWidetMgr", "this is has a error" + e.toString());
                    return;
                }
            }
            final String optString = jSONObject.optString("appid");
            String optString2 = jSONObject.optString("pagePath");
            String optString3 = jSONObject.optString("nickName");
            int i2 = jSONObject.getInt("version");
            if (jSONObject.has("debugMode")) {
                optInt = jSONObject.optInt("debugMode");
            } else {
                optInt = 0;
            }
            g.oUh.i(14452, new Object[]{jSONObject.optString("searchId") + "-" + optString, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis())});
            final View aR = this.rVl.aR(this.context);
            g.oUh.i(14452, new Object[]{jSONObject.optString("searchId") + "-" + optString, Integer.valueOf(2), Long.valueOf(System.currentTimeMillis())});
            final AbsoluteLayout absoluteLayout = (AbsoluteLayout) r.eC(this.context).inflate(R.i.ddZ, null);
            absoluteLayout.setLayoutParams(new LayoutParams(-1, -2, com.tencent.mm.bg.a.fromDPToPix(this.context, jSONObject.getInt("offsetX")), com.tencent.mm.bg.a.fromDPToPix(this.context, jSONObject.getInt("offsetY"))));
            ViewGroup.LayoutParams layoutParams = new LayoutParams(com.tencent.mm.bg.a.fromDPToPix(this.context, jSONObject.getInt("width")), com.tencent.mm.bg.a.fromDPToPix(this.context, jSONObject.getInt("height")), 0, 0);
            aR.setLayoutParams(layoutParams);
            absoluteLayout.addView(aR);
            FrameLayout frameLayout = (FrameLayout) absoluteLayout.findViewById(R.h.cbV);
            frameLayout.setLayoutParams(layoutParams);
            absoluteLayout.removeView(frameLayout);
            absoluteLayout.addView(frameLayout);
            try {
                aR.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
            } catch (Exception e2) {
                w.e("FTSSearchWidetMgr", "the color is error : ");
            }
            aR.setTag(aM);
            this.rVh.put(string2, aR);
            this.rVi.put(string2, absoluteLayout);
            this.rVj.put(string2, frameLayout);
            final ThreeDotsLoadingView threeDotsLoadingView = (ThreeDotsLoadingView) absoluteLayout.findViewById(R.h.cbU);
            final ImageView imageView = (ImageView) absoluteLayout.findViewById(R.h.bHc);
            String optString4 = jSONObject.optString("wxaData");
            String str = optString + "_" + optString4.hashCode();
            Bundle bundle2 = new Bundle();
            bundle2.putString("app_id", optString);
            bundle2.putString("msg_id", str);
            bundle2.putString("search_id", optString + optString4);
            bundle2.putString("cache_key", optString4);
            bundle2.putString("msg_title", optString3);
            bundle2.putString("msg_path", optString2);
            bundle2.putInt("pkg_version", i2);
            bundle2.putInt("msg_pkg_type", optInt);
            bundle2.putString("init_data", jSONObject.optString("inputData"));
            bundle2.putInt("widget_type", 1);
            bundle2.putInt("scene", com.tencent.mm.as.d.gn(i));
            bundle2.putInt("view_init_width", com.tencent.mm.bg.a.fromDPToPix(this.context, jSONObject.getInt("width")));
            bundle2.putInt("view_init_height", com.tencent.mm.bg.a.fromDPToPix(this.context, jSONObject.getInt("height")));
            bundle2.putString("query", jSONObject.optString("wxaData"));
            threeDotsLoadingView.setVisibility(0);
            imageView.setVisibility(4);
            threeDotsLoadingView.caQ();
            bVar.fTO = optString;
            bVar.fKL = optInt;
            bVar.izW = i2;
            bVar.rVA = str;
            this.rVl.a(aM, aR, bundle2, new com.tencent.mm.modelappbrand.r(new f(this) {
                final /* synthetic */ a rVr;

                public final void q(View view, int i) {
                    w.i("FTSSearchWidetMgr", "onWidgetStateChanged sessionId %s, state %d", new Object[]{aM, Integer.valueOf(i)});
                    this.rVr.rVk = i;
                    switch (i) {
                        case 0:
                            threeDotsLoadingView.setVisibility(0);
                            imageView.setVisibility(4);
                            return;
                        case 1:
                            threeDotsLoadingView.Wd();
                            threeDotsLoadingView.setVisibility(4);
                            imageView.setVisibility(0);
                            imageView.setImageResource(R.k.dwD);
                            return;
                        case 4:
                            threeDotsLoadingView.setVisibility(4);
                            imageView.setVisibility(4);
                            threeDotsLoadingView.Wd();
                            return;
                        default:
                            threeDotsLoadingView.Wd();
                            threeDotsLoadingView.setVisibility(4);
                            imageView.setVisibility(0);
                            imageView.setImageResource(R.k.dtG);
                            return;
                    }
                }
            }, new o(this) {
                final /* synthetic */ a rVr;

                public final void a(int i, p pVar) {
                    a aVar = this.rVr;
                    String str = string2;
                    w.i("FTSSearchWidetMgr", "onSetWidgetSize widgetId %s, height %d", new Object[]{str, Integer.valueOf(i)});
                    c cVar = (c) aVar.rVn.get(str);
                    Bundle bundle = new Bundle();
                    if (cVar != null && (i > cVar.rVC || i < cVar.rVB)) {
                        w.w("FTSSearchWidetMgr", "invalid widget size, should in range %s", new Object[]{cVar.toString()});
                        if (pVar != null) {
                            bundle.putInt("errCode", -2);
                            pVar.a(false, "invalid widget size, should in range " + cVar.toString(), bundle);
                        }
                    } else if (aVar.rVm != null) {
                        d dVar = aVar.rVm;
                        if (dVar.sjS) {
                            w.i("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged success, ready");
                            Map hashMap = new HashMap();
                            hashMap.put("widgetId", str);
                            hashMap.put("height", Integer.valueOf(i));
                            af.v(new AnonymousClass24(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchWAWidgetAttrChanged", hashMap, dVar.sjU, dVar.sjV)));
                        } else {
                            w.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, not ready");
                        }
                        if (pVar != null) {
                            bundle.putInt("errCode", 0);
                            pVar.a(true, "", bundle);
                        }
                    } else if (pVar != null) {
                        bundle.putInt("errCode", -1);
                        pVar.a(false, "jsapi is null", bundle);
                    }
                }
            }));
            com.tencent.mm.bk.a.post(new Runnable(this) {
                final /* synthetic */ a rVr;

                public final void run() {
                    int i = com.tencent.mm.ipcinvoker.e.a("com.tencent.mm", new Bundle(), a.class).getInt("search_wa_widget_init_out_time");
                    if (i == 0) {
                        i = 8000;
                    }
                    w.i("FTSSearchWidetMgr", "widget loading timeout is %d ms", new Object[]{Integer.valueOf(i)});
                    if (i > 0) {
                        af.f(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 rVv;

                            {
                                this.rVv = r1;
                            }

                            public final void run() {
                                if (this.rVv.rVr.rVk != 4 && this.rVv.rVr.rVk != 2 && this.rVv.rVr.rVk != 3) {
                                    w.e("FTSSearchWidetMgr", "widget load timeout, unbind now");
                                    threeDotsLoadingView.Wd();
                                    threeDotsLoadingView.setVisibility(4);
                                    imageView.setVisibility(0);
                                    imageView.setImageResource(R.k.dwD);
                                    this.rVv.rVr.rVl.a(aM, aR);
                                    absoluteLayout.removeView(aR);
                                    g.oUh.i(14452, new Object[]{jSONObject.optString("searchId") + "-" + optString, Integer.valueOf(12), Long.valueOf(System.currentTimeMillis())});
                                    g.oUh.a(646, 0, 1, false);
                                }
                            }
                        }, (long) i);
                    }
                }
            });
            ViewGroup viewGroup = (ViewGroup) this.oET.getView();
            if (viewGroup == null || !(viewGroup instanceof AbsoluteLayout)) {
                w.e("FTSSearchWidetMgr", "webview invalid viewgroup " + viewGroup);
            } else {
                viewGroup.addView(absoluteLayout);
            }
        } catch (JSONException e3) {
            w.e("FTSSearchWidetMgr", "parse json and init dynamicPageService is error!");
        }
    }

    public final void K(Bundle bundle) {
        String string = bundle.getString("fts_key_widget_view_cache_key");
        if (string != null && string.length() > 0) {
            View view = (View) this.rVh.get(string);
            w.i("FTSSearchWidetMgr", "removing widget sessionId %s", new Object[]{view.getTag().toString()});
            if (this.rVl != null) {
                this.rVl.a((String) view.getTag(), view);
            }
            if (view != null) {
                this.rVh.remove(string);
                this.rVj.remove(string);
            }
            view = (View) this.rVi.get(string);
            if (view != null) {
                this.oET.removeView(view);
                this.rVi.remove(string);
            }
        }
    }

    public final void L(Bundle bundle) {
        String string = bundle.getString("fts_key_json_data");
        String string2 = bundle.getString("fts_key_widget_view_cache_key");
        w.i("FTSSearchWidetMgr", "updating widget: widgetId %s, jsonData %s", new Object[]{string2, string});
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (string2 != null && string2.length() > 0) {
                final View view = (View) this.rVh.get(string2);
                View view2 = (View) this.rVi.get(string2);
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    ViewGroup.LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    if (jSONObject.has("width") || jSONObject.has("height")) {
                        final View view3 = (View) this.rVj.get(string2);
                        w.i("FTSSearchWidetMgr", "animating  size beginH %d, endH %d, beginW %d, endW %d", new Object[]{Integer.valueOf(layoutParams.height), Integer.valueOf(com.tencent.mm.bg.a.fromDPToPix(this.context, jSONObject.optInt("height"))), Integer.valueOf(layoutParams.width), Integer.valueOf(com.tencent.mm.bg.a.fromDPToPix(this.context, jSONObject.optInt("width")))});
                        if (!(layoutParams.height == com.tencent.mm.bg.a.fromDPToPix(this.context, jSONObject.optInt("height")) && r2 == r6)) {
                            final ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                            final ViewGroup.LayoutParams layoutParams4 = view3.getLayoutParams();
                            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{r3, r11});
                            ofInt.setDuration(300);
                            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
                            ofInt.addUpdateListener(new AnimatorUpdateListener(this) {
                                final /* synthetic */ a rVr;

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    layoutParams3.height = intValue;
                                    view.setLayoutParams(layoutParams3);
                                    layoutParams4.height = intValue;
                                    view3.setLayoutParams(layoutParams4);
                                }
                            });
                            ofInt.start();
                        }
                    }
                    if (jSONObject.has("offsetX")) {
                        layoutParams2.x = com.tencent.mm.bg.a.fromDPToPix(this.context, jSONObject.optInt("offsetX"));
                    }
                    if (jSONObject.has("offsetY")) {
                        layoutParams2.y = com.tencent.mm.bg.a.fromDPToPix(this.context, jSONObject.optInt("offsetY"));
                    }
                    view2.setLayoutParams(layoutParams2);
                    if (jSONObject.has("backgroundColor")) {
                        try {
                            view.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                        } catch (Throwable e) {
                            w.e("FTSSearchWidetMgr", bg.g(e));
                        }
                    }
                    if (jSONObject.has("show")) {
                        if (jSONObject.has("show") ? jSONObject.optBoolean("show") : false) {
                            view.setVisibility(0);
                            view2.setVisibility(0);
                            return;
                        }
                        view.setVisibility(8);
                        view2.setVisibility(8);
                    }
                }
            }
        } catch (Exception e2) {
            w.e("FTSSearchWidetMgr", "the error is e");
        }
    }

    public final void onResume() {
        if (this.rVl != null) {
            for (String str : this.rVh.keySet()) {
                if (str != null && str.length() > 0) {
                    ((e) h.h(e.class)).AM().gK((String) ((View) this.rVh.get(str)).getTag());
                }
            }
        }
    }

    public final void onPause() {
        if (this.rVl != null) {
            for (String str : this.rVh.keySet()) {
                if (str != null && str.length() > 0) {
                    ((e) h.h(e.class)).AM().gJ((String) ((View) this.rVh.get(str)).getTag());
                }
            }
        }
    }

    public final void onDestroy() {
        try {
            if (this.rVl != null) {
                for (String str : this.rVh.keySet()) {
                    if (str != null && str.length() > 0) {
                        this.rVl.gL((String) ((View) this.rVh.get(str)).getTag());
                        View view = (View) this.rVi.get(str);
                        if (view != null) {
                            this.oET.removeView(view);
                            this.rVi.remove(str);
                        }
                    }
                }
                this.rVh.clear();
                this.rVj.clear();
            }
        } catch (Throwable e) {
            w.e("FTSSearchWidetMgr", bg.g(e));
        }
    }
}
