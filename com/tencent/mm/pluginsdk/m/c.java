package com.tencent.mm.pluginsdk.m;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class c {
    private SensorManager sHs;
    private a sHt;

    public static abstract class a implements SensorEventListener {
        private static int sHw;
        private final float[] sHu = new float[]{2.0f, 2.5f, 0.5f};
        private float[] sHv = new float[3];

        public abstract void aOz();

        public abstract void onRelease();

        public static void reset() {
            w.d("MicroMsg.ShakeSensorListener", "reset threadHold");
            sHw = 5;
            if (Build.MODEL.equals("LG-E510")) {
                sHw = 4;
            }
        }

        static {
            sHw = 5;
            if (Build.MODEL.equals("LG-E510")) {
                sHw = 4;
            }
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = new float[3];
            float[] fArr2 = sensorEvent.values;
            int i = 0;
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[i2] = (float) Math.round((this.sHu[i2] * (fArr2[i2] - this.sHv[i2])) * 0.45f);
                float abs = Math.abs(fArr[i2]);
                if (abs >= 4.0f) {
                    w.v("MicroMsg.ShakeSensorListener", "result:" + abs + " THREAHOLD:" + sHw);
                }
                if (sHw < 9) {
                    if (abs >= 14.0f) {
                        sHw = 9;
                    } else {
                        int i3 = (int) abs;
                        if (sHw < i3 - 4) {
                            sHw = i3 - 4;
                        }
                    }
                }
                if (abs > ((float) sHw)) {
                    i = 1;
                }
                this.sHv[i2] = fArr2[i2];
            }
            if (i != 0) {
                w.d("MicroMsg.ShakeSensorListener", "sensorChanged " + sensorEvent.sensor.getName() + " (" + fArr2[0] + ", " + fArr2[1] + ", " + fArr2[2] + ") diff(" + fArr[0] + " " + fArr[1] + " " + fArr[2] + ")");
                aOz();
                float[] fArr3 = sensorEvent.values;
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public c(Context context) {
        this.sHs = (SensorManager) context.getSystemService("sensor");
    }

    public final boolean bDN() {
        return this.sHt != null;
    }

    public final void bDO() {
        if (this.sHt != null) {
            a.reset();
        }
    }

    public final void a(a aVar) {
        aAA();
        if (bDQ()) {
            this.sHt = aVar;
            this.sHs.registerListener(this.sHt, this.sHs.getDefaultSensor(1), 1);
            return;
        }
        w.e("MicroMsg.ShakeSensorService", "no sensor found for shake detection");
    }

    public final void aAA() {
        if (this.sHt != null) {
            this.sHt.onRelease();
            this.sHs.unregisterListener(this.sHt, this.sHs.getDefaultSensor(1));
            this.sHt = null;
        }
    }

    public final boolean bDP() {
        return bDQ();
    }

    private boolean bDQ() {
        if (this.sHs == null) {
            w.e("MicroMsg.ShakeSensorService", "cannot init sensor manager");
            return false;
        }
        List sensorList = this.sHs.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            return false;
        }
        return true;
    }
}
