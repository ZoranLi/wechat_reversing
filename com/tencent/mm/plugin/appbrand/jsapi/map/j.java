package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.l;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tencentmap.mapsdk.map.g;
import com.tencent.tencentmap.mapsdk.map.g.d;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    public static final int CTRL_INDEX = 2;
    public static final String NAME = "insertMap";

    private class b implements SensorEventListener {
        int fOp;
        com.tencent.mm.u.q.b iHR;
        final /* synthetic */ j iTe;
        private float iTm = 0.0f;
        private long timestamp = 200;

        public b(j jVar, int i, com.tencent.mm.u.q.b bVar) {
            this.iTe = jVar;
            this.fOp = i;
            this.iHR = bVar;
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
                float aq = m.aq(sensorEvent.values[0]);
                if (currentTimeMillis > 200 && Math.abs(aq - this.iTm) > 3.0f) {
                    AppbrandMapLocationPoint appbrandMapLocationPoint = (AppbrandMapLocationPoint) this.iHR.fS(this.fOp);
                    if (appbrandMapLocationPoint != null) {
                        float f = this.iTm;
                        float f2 = (f < 0.0f || f > 45.0f || aq < 315.0f || aq >= 360.0f) ? aq : aq - 360.0f;
                        if ((f < 0.0f || f > 45.0f || aq < 315.0f || aq >= 360.0f) && f >= 315.0f && f < 360.0f && aq >= 0.0f && aq <= 45.0f) {
                            f -= 360.0f;
                        }
                        Animation rotateAnimation = new RotateAnimation(f, f2, 1, 0.5f, 1, 0.7f);
                        rotateAnimation.setDuration(200);
                        rotateAnimation.setFillAfter(true);
                        appbrandMapLocationPoint.iSO.startAnimation(rotateAnimation);
                    }
                    this.iTm = aq;
                    this.timestamp = System.currentTimeMillis();
                }
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    private static class a extends e {
        private static final int CTRL_INDEX = 147;
        private static final String NAME = "onMapRegionChange";
    }

    private static class c extends e {
        private static final int CTRL_INDEX = 151;
        private static final String NAME = "onMapClick";
    }

    protected final View a(com.tencent.mm.plugin.appbrand.g.m mVar, JSONObject jSONObject) {
        float f = bg.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
        float f2 = bg.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
        if (Math.abs(f) > 90.0f || Math.abs(f2) > 180.0f) {
            w.d("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
            return null;
        }
        int optInt = jSONObject.optInt("scale", 16);
        View inflate = LayoutInflater.from(mVar.mContext).inflate(R.i.cUe, null);
        SoSoMapView soSoMapView = (SoSoMapView) inflate.findViewById(R.h.bSq);
        soSoMapView.getIController().setCenter((double) f, (double) f2);
        soSoMapView.getIController().setZoom(optInt);
        soSoMapView.setVisibility(0);
        return inflate;
    }

    protected final int h(JSONObject jSONObject) {
        return jSONObject.getInt("mapId");
    }

    protected final void b(com.tencent.mm.plugin.appbrand.g.m mVar, int i, View view, JSONObject jSONObject) {
        final SoSoMapView soSoMapView = (SoSoMapView) view.findViewById(R.h.bSq);
        com.tencent.mm.u.q.b B = mVar.jdc.B(i, true);
        if (jSONObject.optBoolean("showLocation")) {
            final com.tencent.mm.u.q.b B2 = mVar.jdc.B(i, true);
            final int i2 = i;
            final com.tencent.mm.plugin.appbrand.g.m mVar2 = mVar;
            AnonymousClass4 anonymousClass4 = new com.tencent.mm.plugin.appbrand.jsapi.map.a.a(this) {
                final /* synthetic */ j iTe;

                public final void d(double d, double d2) {
                    View appbrandMapLocationPoint;
                    w.d("MicroMsg.JsApiInsertMap", "refresh location latitude = %f, longtitude = %f", new Object[]{Double.valueOf(d), Double.valueOf(d2)});
                    View view = (View) B2.fS(i2);
                    if (view == null) {
                        appbrandMapLocationPoint = new AppbrandMapLocationPoint(mVar2.mContext);
                        soSoMapView.addView(appbrandMapLocationPoint, d, d2);
                        B2.l(i2, appbrandMapLocationPoint);
                    } else {
                        appbrandMapLocationPoint = view;
                    }
                    if (appbrandMapLocationPoint instanceof AppbrandMapLocationPoint) {
                        AppbrandMapLocationPoint appbrandMapLocationPoint2 = (AppbrandMapLocationPoint) appbrandMapLocationPoint;
                        soSoMapView.updateViewLayout(appbrandMapLocationPoint, d, d2);
                        appbrandMapLocationPoint2.iSO.setImageResource(R.g.bgo);
                        if (appbrandMapLocationPoint2.iSR == -1.0d && appbrandMapLocationPoint2.iSS == -1.0d) {
                            appbrandMapLocationPoint2.iSR = d;
                            appbrandMapLocationPoint2.iSP = d;
                            appbrandMapLocationPoint2.iSS = d2;
                            appbrandMapLocationPoint2.iSQ = d2;
                            return;
                        }
                        appbrandMapLocationPoint2.iSR = appbrandMapLocationPoint2.iSP;
                        appbrandMapLocationPoint2.iSS = appbrandMapLocationPoint2.iSQ;
                        appbrandMapLocationPoint2.iSQ = d2;
                        appbrandMapLocationPoint2.iSP = d;
                    }
                }
            };
            a Qa = com.tencent.mm.plugin.appbrand.app.c.Qa();
            Iterator it = Qa.iSM.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.appbrand.jsapi.map.a.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.map.a.a) it.next();
                if (aVar != null && aVar.equals(anonymousClass4)) {
                    break;
                }
            }
            Qa.iSM.add(anonymousClass4);
            w.i("MicroMsg.AppbrandMapLocationMgr", "registerLocationListener %d", new Object[]{Integer.valueOf(Qa.iSM.size())});
            if (Qa.iSM.size() == 1) {
                w.i("MicroMsg.AppbrandMapLocationMgr", "registerLocation ");
                Qa.iSK.requestLocationUpdates(TencentLocationRequest.create(), Qa.iSL);
            }
            final Object bVar = new b(this, i, B2);
            final SensorManager sensorManager = (SensorManager) ab.getContext().getSystemService("sensor");
            sensorManager.registerListener(bVar, sensorManager.getDefaultSensor(3), 1);
            if (((com.tencent.mm.plugin.appbrand.g.m.c) B2.fS("mapDestroyListener")) == null) {
                final com.tencent.mm.plugin.appbrand.g.m mVar3 = mVar;
                final SoSoMapView soSoMapView2 = soSoMapView;
                final AnonymousClass4 anonymousClass42 = anonymousClass4;
                final com.tencent.mm.u.q.b bVar2 = B2;
                com.tencent.mm.plugin.appbrand.g.m.c anonymousClass5 = new com.tencent.mm.plugin.appbrand.g.m.c(this) {
                    final /* synthetic */ j iTe;

                    public final void onDestroy() {
                        mVar3.b((com.tencent.mm.plugin.appbrand.g.m.c) this);
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 iTl;

                            {
                                this.iTl = r1;
                            }

                            public final void run() {
                                if (soSoMapView2 != null) {
                                    soSoMapView2.setVisibility(8);
                                    soSoMapView2.clean();
                                }
                            }
                        });
                        if (sensorManager != null) {
                            sensorManager.unregisterListener(bVar);
                        }
                        a Qa = com.tencent.mm.plugin.appbrand.app.c.Qa();
                        com.tencent.mm.plugin.appbrand.jsapi.map.a.a aVar = anonymousClass42;
                        if (!(Qa.iSM == null || aVar == null)) {
                            Iterator it = Qa.iSM.iterator();
                            while (it.hasNext()) {
                                com.tencent.mm.plugin.appbrand.jsapi.map.a.a aVar2 = (com.tencent.mm.plugin.appbrand.jsapi.map.a.a) it.next();
                                if (aVar2 != null && aVar2.equals(aVar)) {
                                    Qa.iSM.remove(aVar2);
                                    break;
                                }
                            }
                            w.i("MicroMsg.AppbrandMapLocationMgr", "unregisterLocationListener %d", new Object[]{Integer.valueOf(Qa.iSM.size())});
                            if (Qa.iSM.size() == 0) {
                                w.i("MicroMsg.AppbrandMapLocationMgr", "unregisterLocation ");
                                Qa.iSK.removeUpdates(Qa.iSL);
                            }
                        }
                        bVar2.recycle();
                    }
                };
                B2.l("mapDestroyListener", anonymousClass5);
                mVar.a(anonymousClass5);
            }
        } else {
            if (((com.tencent.mm.plugin.appbrand.g.m.c) B.fS("mapDestroyListener")) == null) {
                final com.tencent.mm.plugin.appbrand.g.m mVar4 = mVar;
                final com.tencent.mm.u.q.b bVar3 = B;
                com.tencent.mm.plugin.appbrand.g.m.c anonymousClass1 = new com.tencent.mm.plugin.appbrand.g.m.c(this) {
                    final /* synthetic */ j iTe;

                    public final void onDestroy() {
                        mVar4.b((com.tencent.mm.plugin.appbrand.g.m.c) this);
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 iTf;

                            {
                                this.iTf = r1;
                            }

                            public final void run() {
                                if (soSoMapView != null) {
                                    soSoMapView.setVisibility(8);
                                    soSoMapView.clean();
                                }
                            }
                        });
                        bVar3.recycle();
                    }
                };
                B.l("mapDestroyListener", anonymousClass1);
                mVar.a(anonymousClass1);
            }
        }
        g map = soSoMapView.getMap();
        final int i3 = i;
        final com.tencent.mm.plugin.appbrand.g.m mVar5 = mVar;
        map.mapContext.h().a(new g.e(this) {
            final /* synthetic */ j iTe;

            public final void TM() {
                c cVar = new c();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i3);
                } catch (JSONException e) {
                    w.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
                }
                e a = cVar.a(mVar5);
                a.mData = jSONObject.toString();
                a.SR();
            }
        });
        i3 = i;
        mVar5 = mVar;
        map.mapContext.h().a(new d(this) {
            final /* synthetic */ j iTe;
            boolean iTg = false;
            JSONObject iTh = new JSONObject();
            a iTi = new a();

            public final void TN() {
                try {
                    this.iTh.put("mapId", i3);
                    this.iTh.put(Columns.TYPE, "begin");
                } catch (JSONException e) {
                    w.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
                }
                if (!this.iTg) {
                    this.iTg = true;
                    e a = this.iTi.a(mVar5);
                    a.mData = this.iTh.toString();
                    a.SR();
                }
            }

            public final void TO() {
                try {
                    this.iTh.put("mapId", i3);
                    this.iTh.put(Columns.TYPE, "end");
                } catch (JSONException e) {
                    w.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
                }
                if (this.iTg) {
                    this.iTg = false;
                    e a = this.iTi.a(mVar5);
                    a.mData = this.iTh.toString();
                    a.SR();
                }
            }
        });
        try {
            List arrayList;
            JSONArray jSONArray;
            int i4;
            JSONObject jSONObject2;
            float f;
            float f2;
            String qU;
            MarkerOptions markerOptions;
            if (jSONObject.has("markers")) {
                arrayList = new ArrayList();
                jSONArray = new JSONArray(jSONObject.optString("markers"));
                for (i4 = 0; i4 < jSONArray.length(); i4++) {
                    jSONObject2 = (JSONObject) jSONArray.get(i4);
                    f = bg.getFloat(jSONObject2.optString("latitude"), 0.0f);
                    f2 = bg.getFloat(jSONObject2.optString("longitude"), 0.0f);
                    qU = com.tencent.mm.plugin.appbrand.m.d.qU(jSONObject2.optString("name"));
                    String qU2 = com.tencent.mm.plugin.appbrand.m.d.qU(jSONObject2.optString("desc"));
                    markerOptions = new MarkerOptions();
                    markerOptions.position(new LatLng((double) f, (double) f2));
                    markerOptions.title(qU);
                    if (!bg.mA(qU2)) {
                        markerOptions.snippet(qU2);
                    }
                    arrayList.add(soSoMapView.addMarker(markerOptions));
                }
                B.l("markers", arrayList);
            }
            try {
                if (jSONObject.has("covers")) {
                    arrayList = new ArrayList();
                    jSONArray = new JSONArray(jSONObject.optString("covers"));
                    for (i4 = 0; i4 < jSONArray.length(); i4++) {
                        jSONObject2 = (JSONObject) jSONArray.get(i4);
                        f = bg.getFloat(jSONObject2.optString("latitude"), 0.0f);
                        f2 = bg.getFloat(jSONObject2.optString("longitude"), 0.0f);
                        qU = jSONObject2.optString("iconPath");
                        float optDouble = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                        markerOptions = new MarkerOptions();
                        markerOptions.position(new LatLng((double) f, (double) f2));
                        Bitmap g = l.g(mVar.ixr, qU);
                        if (!(g == null || g.isRecycled())) {
                            markerOptions.icon(new BitmapDescriptor(g));
                        }
                        markerOptions.rotation(optDouble);
                        Marker addMarker = soSoMapView.addMarker(markerOptions);
                        addMarker.setTag("cover");
                        arrayList.add(addMarker);
                    }
                    B.l("converters", arrayList);
                }
            } catch (Exception e) {
                w.e("MicroMsg.JsApiInsertMap", "parse covers error, exception : %s", new Object[]{e});
            }
        } catch (Exception e2) {
            w.e("MicroMsg.JsApiInsertMap", "parse markers error, exception : %s", new Object[]{e2});
        }
    }
}
