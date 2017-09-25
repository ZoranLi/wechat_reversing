package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mm.pluginsdk.ui.tools.r.a;
import com.tencent.mm.sdk.platformtools.w;

public final class e implements a {
    public static e sVN = null;
    public boolean hasInit = false;
    public float[] sVJ = new float[3];
    int sVK = -10000;
    int sVL = -10000;
    private SensorManager sVM;
    private SensorEventListener skU;

    public final int bGz() {
        w.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.sVK);
        return this.sVK;
    }

    public final int getPitch() {
        w.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.sVL);
        return this.sVL;
    }

    public final void dE(Context context) {
        w.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
        if (context == null) {
            w.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
            return;
        }
        if (this.sVM == null) {
            this.sVM = (SensorManager) context.getSystemService("sensor");
        }
        if (this.skU == null) {
            this.skU = new SensorEventListener(this) {
                final /* synthetic */ e sVO;

                {
                    this.sVO = r1;
                }

                public final void onSensorChanged(SensorEvent sensorEvent) {
                    if (sensorEvent.sensor.getType() == 3) {
                        this.sVO.sVJ[0] = sensorEvent.values[0];
                        this.sVO.sVJ[1] = sensorEvent.values[1];
                        this.sVO.sVJ[2] = sensorEvent.values[2];
                        if (this.sVO.sVK == -10000) {
                            this.sVO.sVK = (int) this.sVO.sVJ[0];
                        } else if (this.sVO.sVJ[0] - ((float) this.sVO.sVK) > 300.0f || this.sVO.sVJ[0] - ((float) this.sVO.sVK) < -300.0f) {
                            this.sVO.sVK = (int) this.sVO.sVJ[0];
                        } else {
                            this.sVO.sVK = (int) ((((double) this.sVO.sVK) * 0.6d) + (((double) this.sVO.sVJ[0]) * 0.4d));
                        }
                        if (this.sVO.sVK == 0) {
                            this.sVO.sVK = 1;
                        }
                        if (this.sVO.sVK == 365) {
                            this.sVO.sVK = 364;
                        }
                        if (this.sVO.sVL == -10000) {
                            this.sVO.sVL = (int) this.sVO.sVJ[1];
                        } else if (this.sVO.sVJ[1] < -68.0f) {
                            int i = (int) (-68.0d + (((double) (this.sVO.sVJ[1] + 68.0f)) / 1.5d));
                            if (i < -89) {
                                i = -89;
                            }
                            this.sVO.sVL = i;
                        } else if (this.sVO.sVJ[1] > 89.0f) {
                            this.sVO.sVL = 89;
                        } else {
                            this.sVO.sVL = (int) ((((double) this.sVO.sVL) * 0.6d) + (((double) this.sVO.sVJ[1]) * 0.4d));
                        }
                    }
                }

                public final void onAccuracyChanged(Sensor sensor, int i) {
                    w.i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
                }
            };
        }
        boolean registerListener = this.sVM.registerListener(this.skU, this.sVM.getDefaultSensor(3), 3);
        this.hasInit = true;
        w.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", new Object[]{Boolean.valueOf(registerListener)});
    }

    private void bGA() {
        w.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
        if (!(this.sVM == null || this.skU == null)) {
            w.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
            this.sVM.unregisterListener(this.skU);
            this.sVM = null;
            this.skU = null;
        }
        this.hasInit = false;
    }

    public final String getName() {
        return "HeadingPitchSensorMgr";
    }

    public final void byK() {
        sVN = null;
        bGA();
    }

    public final void dd(Context context) {
        dE(context);
    }

    public final void byL() {
        bGA();
    }
}
