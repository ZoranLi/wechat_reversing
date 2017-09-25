package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.widget.d.c;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q.b;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m extends com.tencent.mm.plugin.appbrand.widget.d.a {
    public static final int CTRL_INDEX = 200;
    public static final String NAME = "translateMapMarker";
    public static final LinkedList<JSONObject> iTo = new LinkedList();
    SoSoMapView iSW;
    private com.tencent.mm.plugin.appbrand.g.m iSY;
    public com.tencent.mm.plugin.appbrand.widget.d.a.a iTp;
    Marker iTq;
    double iTr;
    double iTs;
    private int iTt;
    public a iTu;
    public a iTv = new a(this) {
        final /* synthetic */ m iTw;

        {
            this.iTw = r1;
        }

        public final void TP() {
            d.vL().D(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 iTx;

                {
                    this.iTx = r1;
                }

                public final void run() {
                    synchronized (this) {
                        final JSONObject jSONObject = (JSONObject) m.iTo.pollFirst();
                        if (jSONObject != null) {
                            w.d("MicroMsg.JsApiTranslateMapMarker", "run, start post next animator!");
                            d.runOnUiThread(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 iTz;

                                public final void run() {
                                    m mVar = this.iTz.iTx.iTw;
                                    JSONObject jSONObject = jSONObject;
                                    int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                                    boolean z = false;
                                    if (jSONObject.has(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)) {
                                        z = true;
                                        float optDouble = (float) jSONObject.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
                                        float rotation = mVar.iTq.getRotation();
                                        c cVar = new c(mVar.iTq, (long) optInt, rotation, optDouble + rotation);
                                        cVar.a(new AnimatorListener(mVar) {
                                            final /* synthetic */ m iTw;

                                            {
                                                this.iTw = r1;
                                            }

                                            public final void onAnimationStart(Animator animator) {
                                                w.d("MicroMsg.JsApiTranslateMapMarker", "MarkerRotateAnimator start");
                                            }

                                            public final void onAnimationEnd(Animator animator) {
                                                w.d("MicroMsg.JsApiTranslateMapMarker", "MarkerRotateAnimator end");
                                                this.iTw.iTv.TP();
                                            }

                                            public final void onAnimationCancel(Animator animator) {
                                            }

                                            public final void onAnimationRepeat(Animator animator) {
                                            }
                                        });
                                        cVar.ZB();
                                    }
                                    LatLng[] latLngArr = new LatLng[2];
                                    if (jSONObject.has("latitude") && jSONObject.has("longitude")) {
                                        float f = bg.getFloat(jSONObject.optString("latitude"), 0.0f);
                                        float f2 = bg.getFloat(jSONObject.optString("longitude"), 0.0f);
                                        latLngArr[0] = new LatLng(mVar.iTr, mVar.iTs);
                                        latLngArr[1] = new LatLng((double) f, (double) f2);
                                        mVar.iTr = (double) f;
                                        mVar.iTs = (double) f2;
                                        com.tencent.mm.plugin.appbrand.widget.d.d dVar = new com.tencent.mm.plugin.appbrand.widget.d.d(mVar.iTq, mVar.iSW, (long) optInt, latLngArr, z);
                                        dVar.a(new AnimatorListener(mVar) {
                                            final /* synthetic */ m iTw;

                                            {
                                                this.iTw = r1;
                                            }

                                            public final void onAnimationStart(Animator animator) {
                                                w.d("MicroMsg.JsApiTranslateMapMarker", "MarkerTranslateAnimator start");
                                            }

                                            public final void onAnimationEnd(Animator animator) {
                                                w.d("MicroMsg.JsApiTranslateMapMarker", "MarkerTranslateAnimator end");
                                                this.iTw.iTv.TP();
                                            }

                                            public final void onAnimationCancel(Animator animator) {
                                            }

                                            public final void onAnimationRepeat(Animator animator) {
                                            }
                                        });
                                        dVar.ZB();
                                    }
                                }
                            });
                        } else {
                            w.d("MicroMsg.JsApiTranslateMapMarker", "run, animator end!");
                            this.iTx.iTw.iTu.pq(this.iTx.iTw.d("ok", null));
                            this.iTx.iTw.iTp.Zz();
                        }
                    }
                }
            });
        }
    };

    public interface a {
        void TP();
    }

    protected final int h(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            w.e("MicroMsg.JsApiTranslateMapMarker", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    protected final boolean a(com.tencent.mm.plugin.appbrand.g.m mVar, int i, View view, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.widget.d.a.a aVar, a aVar2) {
        this.iTp = aVar;
        this.iSY = mVar;
        this.iTt = i;
        this.iTu = aVar2;
        b B = mVar.jdc.B(i, true);
        if (B == null) {
            w.e("MicroMsg.JsApiTranslateMapMarker", "KeyValueSet(%s) is null.", new Object[]{Integer.valueOf(i)});
            aVar2.pq(d("fail", null));
            return false;
        }
        int optInt = jSONObject.optInt("markerId");
        Map map = (Map) B.fS("marker");
        if (map == null || map.size() < 0) {
            w.e("MicroMsg.JsApiTranslateMapMarker", "markerMap is empty!");
            aVar2.pq(d("fail", null));
            return false;
        }
        this.iTq = (Marker) map.get(Integer.valueOf(optInt));
        if (this.iTq == null) {
            w.e("MicroMsg.JsApiTranslateMapMarker", "get marker failed!");
            aVar2.pq(d("fail", null));
            return false;
        }
        this.iSW = (SoSoMapView) view.findViewById(R.h.bSq);
        try {
            this.iTr = this.iTq.getPosition().getLatitude();
            this.iTs = this.iTq.getPosition().getLongitude();
            JSONArray jSONArray = new JSONArray(jSONObject.optString("keyFrames"));
            w.d("MicroMsg.JsApiTranslateMapMarker", "keyFramesArray size :%d", new Object[]{Integer.valueOf(jSONArray.length())});
            for (optInt = 0; optInt < jSONArray.length(); optInt++) {
                iTo.add((JSONObject) jSONArray.get(optInt));
            }
            this.iTv.TP();
            return true;
        } catch (JSONException e) {
            w.e("MicroMsg.JsApiTranslateMapMarker", "parse keyFrames error, exception : %s", new Object[]{e});
            aVar2.pq(d("fail", null));
            return false;
        }
    }

    protected final boolean Ts() {
        return true;
    }
}
