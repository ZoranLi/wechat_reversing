package com.tencent.mm.plugin.appbrand.jsapi;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
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

public final class y extends a {
    public static final int CTRL_INDEX = 92;
    public static final String NAME = "enableAccelerometer";
    private Handler mHandler = new Handler(d.vL().nJF.getLooper());

    private static abstract class b extends com.tencent.mm.plugin.appbrand.e.b implements SensorEventListener {
        private f iMs;
        a iMt = new a();

        b(final m mVar) {
            this.iMt.a(mVar);
            this.iMs = new f((long) ct.Tm(), new com.tencent.mm.plugin.appbrand.m.f.a(this) {
                final /* synthetic */ b iMu;

                public final boolean f(Object... objArr) {
                    float[] fArr = (float[]) objArr[0];
                    Map hashMap = new HashMap();
                    hashMap.put("x", Float.valueOf((-fArr[0]) / 10.0f));
                    hashMap.put("y", Float.valueOf((-fArr[1]) / 10.0f));
                    hashMap.put("z", Float.valueOf((-fArr[2]) / 10.0f));
                    this.iMu.iMt.q(hashMap);
                    return ct.Tl().a(this.iMu.iMt, mVar);
                }
            });
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                if (fArr == null || fArr.length < 3) {
                    w.w("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
                    return;
                }
                boolean h = this.iMs.h(fArr);
                w.v("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", new Object[]{Boolean.valueOf(h)});
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public static final class a extends e {
        private static final int CTRL_INDEX = 93;
        private static final String NAME = "onAccelerometerChange";
    }

    public final void a(final m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
        try {
            boolean z = jSONObject.getBoolean("enable");
            final SensorManager sensorManager = (SensorManager) mVar.mContext.getSystemService("sensor");
            if (sensorManager == null) {
                w.i("MicroMsg.JsApiEnableAccelerometer", "getSystemService(SENSOR_SERVICE) failed.");
                mVar.x(i, d("fail", null));
                return;
            }
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor == null) {
                w.i("MicroMsg.JsApiEnableAccelerometer", "get Accelerometer sensor failed.");
                mVar.x(i, d("fail", null));
                return;
            }
            boolean z2;
            String d;
            String str = "JsApi#SensorAccelerometer" + mVar.hashCode();
            com.tencent.mm.u.q.b n;
            if (z) {
                com.tencent.mm.u.q.b fO = q.yC().fO(str);
                if (fO == null) {
                    n = q.yC().n(str, true);
                } else {
                    n = fO;
                }
                if (((b) n.fS("sensor_event_listener")) != null) {
                    w.w("MicroMsg.JsApiEnableAccelerometer", "register failed, sensorEventListener has already registered.");
                    mVar.x(i, d("fail, has enable, should stop pre operation", null));
                    return;
                }
                com.tencent.mm.plugin.appbrand.e.b anonymousClass1 = new b(this, mVar) {
                    final /* synthetic */ y iMr;

                    public final void onDestroy() {
                        e.b(mVar.ivH, this);
                        sensorManager.unregisterListener(this);
                    }
                };
                e.a(mVar.ivH, anonymousClass1);
                n.l("sensor_event_listener", anonymousClass1);
                z = sensorManager.registerListener(anonymousClass1, defaultSensor, 3, this.mHandler);
                if (!z) {
                    sensorManager.unregisterListener(anonymousClass1);
                    e.b(mVar.ivH, anonymousClass1);
                    n.recycle();
                    q.yC().fP(str);
                }
                w.i("MicroMsg.JsApiEnableAccelerometer", "register accelerometer sensor finished(s : %s, r : %s).", new Object[]{str, Boolean.valueOf(z)});
                z2 = z;
            } else {
                n = q.yC().fP(str);
                if (n == null) {
                    w.i("MicroMsg.JsApiEnableAccelerometer", "unregister sensor event listener failed, keyValueSet do not exist.");
                    mVar.x(i, d("fail", null));
                    return;
                }
                b bVar = (b) n.fS("sensor_event_listener");
                if (bVar == null) {
                    w.i("MicroMsg.JsApiEnableAccelerometer", "unregister sensor event listener failed, listener do not exist.");
                    mVar.x(i, d("fail", null));
                    return;
                }
                sensorManager.unregisterListener(bVar);
                e.b(mVar.ivH, bVar);
                n.recycle();
                w.i("MicroMsg.JsApiEnableAccelerometer", "unregister accelerometer sensor finished(s : %s).", new Object[]{str});
                z2 = true;
            }
            if (z2) {
                d = d("ok", null);
            } else {
                d = d("fail", null);
            }
            mVar.x(i, d);
        } catch (JSONException e) {
            w.i("MicroMsg.JsApiEnableAccelerometer", "json data do not contains parameter enable.");
            mVar.x(i, d("fail", null));
        }
    }
}
