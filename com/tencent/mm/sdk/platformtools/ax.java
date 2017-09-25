package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import java.util.List;

public final class ax {
    private SensorManager sHs;
    private a uvJ;

    static class a implements SensorListener {
        private Runnable nFq;
        private float[] sHv = new float[]{0.0f, 0.0f, 0.0f};

        public a(Runnable runnable) {
            this.nFq = runnable;
        }

        public final void onAccuracyChanged(int i, int i2) {
        }

        public final void onSensorChanged(int i, float[] fArr) {
            Object obj = null;
            float[] fArr2 = new float[3];
            int i2 = 0;
            while (i2 < 3) {
                fArr2[i2] = Math.abs(fArr[i2] - this.sHv[i2]);
                if (this.sHv[i2] != 0.0f && fArr2[i2] > 1.0f) {
                    obj = 1;
                    w.d("MicroMsg.ShakeManager", "isONShake:" + fArr2[i2]);
                }
                this.sHv[i2] = fArr[i2];
                i2++;
            }
            if (obj != null) {
                this.nFq.run();
            }
        }
    }

    public ax(Context context) {
        this.sHs = (SensorManager) context.getSystemService("sensor");
    }

    public final boolean M(Runnable runnable) {
        if (this.sHs == null) {
            return false;
        }
        List sensorList = this.sHs.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            return false;
        }
        this.uvJ = new a(runnable);
        this.sHs.registerListener(this.uvJ, 2, 3);
        return true;
    }

    public final void bJH() {
        if (this.sHs != null && this.uvJ != null) {
            this.sHs.unregisterListener(this.uvJ, 2);
        }
    }
}
