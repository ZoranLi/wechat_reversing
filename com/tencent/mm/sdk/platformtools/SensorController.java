package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.jg.EType;
import com.jg.JgMethodChecked;

public class SensorController extends BroadcastReceiver implements SensorEventListener {
    private static float uvA = 0.5f;
    public static boolean uvH = false;
    public static double uvI = -1.0d;
    private static float uvy = 4.2949673E9f;
    private Context context;
    private SensorManager hVM;
    private float qhh = -1.0f;
    private a uvB;
    private Sensor uvC;
    private final boolean uvD;
    private boolean uvE = false;
    public boolean uvF = false;
    private float uvG = -1.0f;
    private float uvz;

    public interface a {
        void cU(boolean z);
    }

    public SensorController(Context context) {
        if (context == null) {
            this.uvD = false;
            return;
        }
        boolean z;
        this.context = context;
        this.hVM = (SensorManager) context.getSystemService("sensor");
        this.uvC = this.hVM.getDefaultSensor(8);
        if (this.uvC != null) {
            this.qhh = Math.min(10.0f, this.uvC.getMaximumRange());
        }
        if (this.qhh < 0.0f) {
            w.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", Float.valueOf(this.qhh));
            this.qhh = 1.0f;
        }
        if (this.uvC != null) {
            z = true;
        } else {
            z = false;
        }
        this.uvD = z;
        this.uvz = uvA + 1.0f;
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public final void a(a aVar) {
        w.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.uvF + ", proximitySensor: " + this.uvC + ", maxValue: " + this.qhh);
        if (!this.uvF) {
            this.uvG = -1.0f;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            this.context.registerReceiver(this, intentFilter);
            this.hVM.registerListener(this, this.uvC, 2);
            this.uvF = true;
        }
        this.uvB = aVar;
    }

    public final void bJG() {
        w.i("MicroMsg.SensorController", "sensor callback removed");
        try {
            this.context.unregisterReceiver(this);
        } catch (Exception e) {
            w.v("MicroMsg.SensorController", "sensor receiver has already unregistered");
        }
        this.hVM.unregisterListener(this, this.uvC);
        this.hVM.unregisterListener(this);
        this.uvF = false;
        this.uvB = null;
        this.uvG = -1.0f;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null && sensorEvent.sensor != null && this.uvC != null && !this.uvE) {
            float f = sensorEvent.values[0];
            double d = 3.0d;
            w.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", Float.valueOf(f), Float.valueOf(this.qhh), Double.valueOf(3.0d), Double.valueOf(uvI), Float.valueOf(this.uvG), Float.valueOf(this.uvC.getMaximumRange()));
            if (uvI > 0.0d) {
                d = uvI;
            }
            float maximumRange = (uvI > 0.0d || this.qhh < 0.0f) ? this.uvC.getMaximumRange() : this.qhh;
            w.i("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", Float.valueOf(Math.max(0.1f, (float) (((double) maximumRange) / d))), Float.valueOf(maximumRange));
            switch (sensorEvent.sensor.getType()) {
                case 8:
                    if (this.uvB != null && f != this.uvG) {
                        if (f < r0) {
                            w.i("MicroMsg.SensorController", "sensor near-far event near false");
                            this.uvB.cU(false);
                        } else {
                            w.i("MicroMsg.SensorController", "sensor near-far event far true");
                            this.uvB.cU(true);
                        }
                        this.uvG = f;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.HEADSET_PLUG")) {
                int intExtra = intent.getIntExtra("state", 0);
                if (intExtra == 1) {
                    this.uvE = true;
                }
                if (intExtra == 0) {
                    this.uvE = false;
                }
            }
        }
    }
}
