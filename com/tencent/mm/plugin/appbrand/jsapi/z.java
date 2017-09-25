package com.tencent.mm.plugin.appbrand.jsapi;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.m.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class z extends a {
    public static final int CTRL_INDEX = 94;
    public static final String NAME = "enableCompass";
    public SensorManager aJs;
    private Handler mHandler = new Handler(d.vL().nJF.getLooper());

    private static abstract class b extends com.tencent.mm.plugin.appbrand.e.b implements SensorEventListener {
        private f iMs;
        boolean iMw;
        public float[] iMx = new float[3];
        public float[] iMy = new float[3];
        a iMz = new a();

        b(final m mVar) {
            this.iMz.a(mVar);
            this.iMs = new f((long) ct.Tm(), new com.tencent.mm.plugin.appbrand.m.f.a(this) {
                final /* synthetic */ b iMA;

                public final boolean f(Object... objArr) {
                    w.v("MicroMsg.JsApiEnableCompass", "onAction.");
                    float[] fArr = new float[3];
                    float[] fArr2 = new float[9];
                    SensorManager.getRotationMatrix(fArr2, null, this.iMA.iMx, this.iMA.iMy);
                    SensorManager.getOrientation(fArr2, fArr);
                    Map hashMap = new HashMap();
                    float toDegrees = (float) Math.toDegrees((double) fArr[0]);
                    if (toDegrees < 0.0f) {
                        toDegrees += 360.0f;
                    }
                    hashMap.put(TencentLocation.EXTRA_DIRECTION, Float.valueOf(toDegrees));
                    this.iMA.iMz.q(hashMap);
                    return ct.Tl().a(this.iMA.iMz, mVar);
                }
            });
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (!this.iMw) {
                if (sensorEvent.values == null || sensorEvent.values.length < 3) {
                    w.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
                    return;
                }
                if (sensorEvent.sensor.getType() == 2) {
                    this.iMy = sensorEvent.values;
                } else if (sensorEvent.sensor.getType() == 1) {
                    this.iMx = sensorEvent.values;
                } else {
                    return;
                }
                boolean h = this.iMs.h(new Object[0]);
                w.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[]{Boolean.valueOf(h)});
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public static final class a extends e {
        private static final int CTRL_INDEX = 95;
        private static final String NAME = "onCompassChange";
    }

    public final void a(final m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
        try {
            boolean z = jSONObject.getBoolean("enable");
            if (this.aJs == null) {
                this.aJs = (SensorManager) mVar.mContext.getSystemService("sensor");
            }
            if (this.aJs == null) {
                w.i("MicroMsg.JsApiEnableCompass", "getSystemService(SENSOR_SERVICE) failed.");
                mVar.x(i, d("fail", null));
                return;
            }
            Sensor defaultSensor = this.aJs.getDefaultSensor(2);
            Sensor defaultSensor2 = this.aJs.getDefaultSensor(1);
            if (defaultSensor == null || defaultSensor2 == null) {
                w.i("MicroMsg.JsApiEnableCompass", "get compass or accelerometer sensor failed.");
                mVar.x(i, d("fail", null));
                return;
            }
            boolean z2;
            String d;
            String str = "JsApi#SensorMagneticField" + mVar.hashCode();
            com.tencent.mm.u.q.b n;
            if (z) {
                com.tencent.mm.u.q.b fO = q.yC().fO(str);
                if (fO == null) {
                    n = q.yC().n(str, true);
                } else {
                    n = fO;
                }
                if (((b) n.fS("sensor_event_listener")) != null) {
                    w.w("MicroMsg.JsApiEnableCompass", "register failed, sensorEventListener has already registered.");
                    mVar.x(i, d("fail, has enable, should stop pre operation", null));
                    return;
                }
                com.tencent.mm.plugin.appbrand.e.b anonymousClass1 = new b(this, mVar) {
                    final /* synthetic */ z iMv;

                    public final void onDestroy() {
                        e.b(mVar.ivH, this);
                        this.iMv.aJs.unregisterListener(this);
                    }
                };
                e.a(mVar.ivH, anonymousClass1);
                n.l("sensor_event_listener", anonymousClass1);
                z2 = this.aJs.registerListener(anonymousClass1, defaultSensor, 3, this.mHandler) && this.aJs.registerListener(anonymousClass1, defaultSensor2, 3, this.mHandler);
                if (!z2) {
                    this.aJs.unregisterListener(anonymousClass1);
                    anonymousClass1.iMw = true;
                    e.b(mVar.ivH, anonymousClass1);
                    n.recycle();
                    q.yC().fP(str);
                }
                w.i("MicroMsg.JsApiEnableCompass", "register compass sensor finished(s : %s, r : %s).", new Object[]{str, Boolean.valueOf(z2)});
            } else {
                n = q.yC().fP(str);
                if (n == null) {
                    w.i("MicroMsg.JsApiEnableCompass", "unregister sensor event listener failed, keyValueSet do not exist.");
                    mVar.x(i, d("fail", null));
                    return;
                }
                b bVar = (b) n.fS("sensor_event_listener");
                if (bVar == null) {
                    w.i("MicroMsg.JsApiEnableCompass", "unregister sensor event listener failed, listener do not exist.");
                    mVar.x(i, d("fail", null));
                    return;
                }
                this.aJs.unregisterListener(bVar);
                e.b(mVar.ivH, bVar);
                bVar.iMw = true;
                n.recycle();
                w.i("MicroMsg.JsApiEnableCompass", "unregister compass sensor finished(%s).", new Object[]{str});
                z2 = true;
            }
            if (z2) {
                d = d("ok", null);
            } else {
                d = d("fail", null);
            }
            mVar.x(i, d);
        } catch (JSONException e) {
            w.i("MicroMsg.JsApiEnableCompass", "json data do not contains parameter enable.");
            mVar.x(i, d("fail", null));
        }
    }
}
