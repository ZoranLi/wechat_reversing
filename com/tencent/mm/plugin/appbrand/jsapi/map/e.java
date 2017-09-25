package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.g.l;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tencentmap.mapsdk.map.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends com.tencent.mm.plugin.appbrand.jsapi.base.c {
    public static final int CTRL_INDEX = 133;
    public static final String NAME = "addMapMarkers";
    private SoSoMapView iSW;
    private a iSX;
    public m iSY;
    public Map<String, String> iSZ = new HashMap();
    private g tencentMap;

    class a implements com.tencent.tencentmap.mapsdk.map.g.a {
        final /* synthetic */ e iTb;

        a(e eVar) {
            this.iTb = eVar;
        }

        public final View d(Marker marker) {
            String str = (String) this.iTb.iSZ.get(marker.getId());
            if (!bg.mA(str)) {
                try {
                    int a;
                    JSONObject jSONObject = new JSONObject(str);
                    h.at(jSONObject.optString("shadowColor", ""), Color.parseColor("#000000"));
                    jSONObject.optInt("shadowOpacity");
                    jSONObject.optInt("shadowOffsetX");
                    jSONObject.optInt("shadowOffsetY");
                    View linearLayout = new LinearLayout(this.iTb.iSY.mContext);
                    linearLayout.setLayoutParams(new LayoutParams(-2, -2));
                    linearLayout.setOrientation(1);
                    linearLayout.setGravity(17);
                    if (jSONObject.has("padding")) {
                        a = h.a(jSONObject, "padding", 0);
                        linearLayout.setPadding(a, a, a, a);
                    }
                    View textView = new TextView(this.iTb.iSY.mContext);
                    Object optString = jSONObject.optString("color");
                    a = Color.parseColor("#000000");
                    if (!TextUtils.isEmpty(optString)) {
                        a = h.at(optString, Color.parseColor("#000000"));
                    }
                    textView.setTextColor(a);
                    if (jSONObject.has("fontSize")) {
                        textView.setTextSize((float) jSONObject.optInt("fontSize"));
                    }
                    if (jSONObject.has("content")) {
                        textView.setText(jSONObject.optString("content"));
                    }
                    textView.setLayoutParams(new LayoutParams(-2, -2));
                    linearLayout.addView(textView);
                    Drawable bVar = new com.tencent.mm.plugin.appbrand.widget.d.b();
                    if (jSONObject.has("borderRadius")) {
                        bVar.abw = (float) jSONObject.optInt("borderRadius");
                    }
                    bVar.fu.setColor(h.at(jSONObject.optString("bgColor", ""), Color.parseColor("#000000")));
                    linearLayout.setBackgroundDrawable(bVar);
                    return linearLayout;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", e, "getInfoWindow", new Object[0]);
                }
            }
            return null;
        }
    }

    private static class b extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = 199;
        private static final String NAME = "onMapCalloutClick";
    }

    private static class c extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = 142;
        private static final String NAME = "onMapMarkerClick";
    }

    protected final int h(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            w.e("MicroMsg.JsApiAddMapMarkers", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean a(m mVar, int i, View view, JSONObject jSONObject) {
        com.tencent.mm.u.q.b B = mVar.jdc.B(i, true);
        if (B == null) {
            w.e("MicroMsg.JsApiAddMapMarkers", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            return false;
        } else if (jSONObject == null) {
            w.e("MicroMsg.JsApiAddMapMarkers", "data is null");
            return false;
        } else {
            w.i("MicroMsg.JsApiAddMapMarkers", "onUpdateView, data:%s", new Object[]{jSONObject.toString()});
            this.iSY = mVar;
            this.iSW = (SoSoMapView) view.findViewById(R.h.bSq);
            this.tencentMap = this.iSW.getMap();
            Map hashMap = new HashMap();
            try {
                if (jSONObject.has("markers")) {
                    List list;
                    int i2;
                    List list2 = (List) B.fS("map_markers");
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        B.l("map_markers", arrayList);
                        list = arrayList;
                    } else {
                        list = list2;
                    }
                    if (list.size() > 0) {
                        for (i2 = 0; i2 < list.size(); i2++) {
                            ((Marker) list.get(i2)).remove();
                        }
                        list.clear();
                    }
                    HashMap hashMap2 = new HashMap();
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("markers"));
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        int iD;
                        float height;
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                        float f = bg.getFloat(jSONObject2.optString("latitude"), 0.0f);
                        float f2 = bg.getFloat(jSONObject2.optString("longitude"), 0.0f);
                        String optString = jSONObject2.optString("iconPath");
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(new LatLng((double) f, (double) f2));
                        View view2 = (FrameLayout) ((LayoutInflater) mVar.mContext.getSystemService("layout_inflater")).inflate(R.i.cUd, null);
                        ImageView imageView = (ImageView) view2.findViewById(R.h.ciO);
                        TextView textView = (TextView) view2.findViewById(R.h.ciP);
                        view2.setVisibility(8);
                        Bitmap bitmap = null;
                        if (optString == null || !optString.startsWith("wxfile://")) {
                            bitmap = l.g(mVar.ixr, optString);
                        } else {
                            AppBrandLocalMediaObject aH = com.tencent.mm.plugin.appbrand.appstorage.c.aH(mVar.ivH, optString);
                            if (aH != null) {
                                bitmap = d.decodeFile(aH.hos, null);
                            }
                        }
                        if (bitmap != null) {
                            int i4;
                            int a = h.a(jSONObject2, "width", 0);
                            i2 = h.a(jSONObject2, "height", 0);
                            if (a == 0 && i2 == 0) {
                                a = h.iD(bitmap.getWidth());
                                iD = h.iD(bitmap.getHeight());
                                i4 = a;
                            } else {
                                iD = i2;
                                i4 = a;
                            }
                            if (i4 <= 0 || iD <= 0 || (i4 == bitmap.getWidth() && iD == bitmap.getHeight())) {
                                imageView.setImageBitmap(bitmap);
                                imageView.setScaleType(ScaleType.CENTER);
                            } else {
                                f2 = ((float) i4) / ((float) bitmap.getWidth());
                                height = ((float) iD) / ((float) bitmap.getHeight());
                                Matrix matrix = new Matrix();
                                matrix.postScale(f2, height);
                                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                                if (!(i4 == bitmap.getWidth() && iD == bitmap.getHeight())) {
                                    bitmap.recycle();
                                }
                                imageView.setImageBitmap(createBitmap);
                            }
                        }
                        imageView.measure(0, 0);
                        i2 = imageView.getMeasuredWidth();
                        int measuredHeight = imageView.getMeasuredHeight();
                        float f3 = 0.5f;
                        height = 1.0f;
                        if (jSONObject2.has("anchor")) {
                            JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("anchor"));
                            f3 = (float) jSONObject3.optDouble("x");
                            height = (float) jSONObject3.optDouble("y");
                            w.i("MicroMsg.JsApiAddMapMarkers", "anchorObj:%s", new Object[]{jSONObject3.toString()});
                        }
                        int i5 = (int) (((float) i2) * f3);
                        measuredHeight = (int) (((float) measuredHeight) * height);
                        String optString2 = jSONObject2.optString("label");
                        if (!bg.mA(optString2)) {
                            JSONObject jSONObject4 = new JSONObject(optString2);
                            Object optString3 = jSONObject4.optString("color");
                            i2 = Color.parseColor("#000000");
                            if (!TextUtils.isEmpty(optString3)) {
                                i2 = h.at(optString3, Color.parseColor("#000000"));
                            }
                            iD = jSONObject4.optInt("fontSize", 0);
                            String optString4 = jSONObject4.optString("content");
                            int a2 = h.a(jSONObject4, "x", 0);
                            int a3 = h.a(jSONObject4, "y", 0);
                            textView.setText(optString4);
                            textView.setTextColor(i2);
                            if (iD > 0) {
                                textView.setTextSize((float) iD);
                            }
                            ((MarginLayoutParams) textView.getLayoutParams()).setMargins(i5 + a2, a3 + measuredHeight, 0, 0);
                            textView.requestLayout();
                        }
                        if (bitmap != null) {
                            view2.setVisibility(0);
                            markerOptions.markerView(view2);
                        } else if (bg.mA(optString2)) {
                            w.e("MicroMsg.JsApiAddMapMarkers", "bitmap is null");
                        } else {
                            view2.setVisibility(0);
                            markerOptions.markerView(view2);
                        }
                        f = (float) jSONObject2.optDouble("alpha", 1.0d);
                        markerOptions.rotation((float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d));
                        markerOptions.alpha(f);
                        if (bg.mA(optString2)) {
                            markerOptions.anchor(f3, height);
                        } else {
                            view2.measure(0, 0);
                            int measuredWidth = view2.getMeasuredWidth();
                            int measuredHeight2 = view2.getMeasuredHeight();
                            if (measuredWidth <= 0 || measuredHeight2 <= 0) {
                                f = height;
                                f2 = f3;
                            } else {
                                f2 = ((float) i5) / ((float) measuredWidth);
                                f = ((float) measuredHeight) / ((float) measuredHeight2);
                            }
                            markerOptions.anchor(f2, f);
                        }
                        String optString5 = jSONObject2.optString("title");
                        if (!bg.mA(optString5)) {
                            markerOptions.title(optString5);
                        }
                        Marker addMarker = this.iSW.addMarker(markerOptions);
                        if (jSONObject2.has(SlookAirButtonFrequentContactAdapter.ID)) {
                            hashMap.put(Integer.valueOf(jSONObject2.optInt(SlookAirButtonFrequentContactAdapter.ID)), addMarker);
                        }
                        String optString6 = jSONObject2.optString("callout");
                        if (!bg.mA(optString6)) {
                            this.iSZ.put(addMarker.getId(), optString6);
                            this.iSX = new a(this);
                            g gVar = this.tencentMap;
                            gVar.mapContext.h().a(this.iSX);
                            if (a(addMarker)) {
                                addMarker.showInfoWindow();
                            }
                        }
                        list.add(addMarker);
                        HashMap hashMap3 = hashMap2;
                        hashMap3.put(addMarker.getId(), jSONObject2.optString(SlookAirButtonFrequentContactAdapter.DATA));
                    }
                    if (hashMap.size() > 0) {
                        B.l("marker", hashMap);
                    }
                    g gVar2 = this.tencentMap;
                    final HashMap hashMap4 = hashMap2;
                    final int i6 = i;
                    final m mVar2 = mVar;
                    gVar2.mapContext.h().a(new com.tencent.tencentmap.mapsdk.map.g.c(this) {
                        final /* synthetic */ e iTb;

                        public final void b(Marker marker) {
                            b bVar = new b();
                            String mz = bg.mz((String) hashMap4.get(marker.getId()));
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("mapId", i6);
                                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, mz);
                            } catch (JSONException e) {
                                w.e("MicroMsg.JsApiAddMapMarkers", "put JSON data error : %s", new Object[]{e});
                            }
                            com.tencent.mm.plugin.appbrand.jsapi.e ad = bVar.ad(mVar2.ivH, mVar2.hashCode());
                            ad.mData = jSONObject.toString();
                            ad.SR();
                        }
                    });
                    gVar2 = this.tencentMap;
                    hashMap4 = hashMap2;
                    i6 = i;
                    mVar2 = mVar;
                    gVar2.mapContext.h().a(new g.h(this) {
                        final /* synthetic */ e iTb;

                        public final boolean c(Marker marker) {
                            c cVar = new c();
                            String mz = bg.mz((String) hashMap4.get(marker.getId()));
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("mapId", i6);
                                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, mz);
                            } catch (JSONException e) {
                                w.e("MicroMsg.JsApiAddMapMarkers", "put JSON data error : %s", new Object[]{e});
                            }
                            com.tencent.mm.plugin.appbrand.jsapi.e ad = cVar.ad(mVar2.ivH, mVar2.hashCode());
                            ad.mData = jSONObject.toString();
                            ad.SR();
                            mz = (String) this.iTb.iSZ.get(marker.getId());
                            if (bg.mA(mz) && bg.mA(marker.getTitle()) && bg.mA(marker.getSnippet())) {
                                w.e("MicroMsg.JsApiAddMapMarkers", "callout and title and snippet is empty, don't show info window");
                                return true;
                            }
                            if (bg.mA(mz)) {
                                if (marker.isInfoWindowShown()) {
                                    marker.hideInfoWindow();
                                } else {
                                    marker.showInfoWindow();
                                }
                            } else if (!this.iTb.a(marker)) {
                                if (marker.isInfoWindowShown()) {
                                    marker.hideInfoWindow();
                                } else {
                                    marker.showInfoWindow();
                                }
                            }
                            return false;
                        }
                    });
                } else {
                    w.e("MicroMsg.JsApiAddMapMarkers", "data has not markers");
                }
                return true;
            } catch (Exception e) {
                w.e("MicroMsg.JsApiAddMapMarkers", "parse markers error, exception : %s", new Object[]{e});
                return false;
            }
        }
    }

    public final boolean a(Marker marker) {
        String str = (String) this.iSZ.get(marker.getId());
        try {
            if (TextUtils.isEmpty(str)) {
                w.e("MicroMsg.JsApiAddMapMarkers", "isShowInfoWindow, callout is empty");
                return false;
            }
            if (new JSONObject(str).optInt("display") == 1) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", e, "isShowInfoWindow", new Object[0]);
        }
    }
}
