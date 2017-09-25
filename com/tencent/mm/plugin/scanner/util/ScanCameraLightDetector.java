package com.tencent.mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.e.a.no;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class ScanCameraLightDetector implements SensorEventListener {
    public static final ScanCameraLightDetector pdW = new ScanCameraLightDetector();
    public SensorManager hVM;
    public ae handler;
    public long pdX = -1;
    public Sensor pdY;
    public boolean pdZ = false;
    public float pea = -1.0f;
    public HandlerThread peb;

    class AnonymousClass1 extends ae {
        final /* synthetic */ ScanCameraLightDetector pec;

        public AnonymousClass1(ScanCameraLightDetector scanCameraLightDetector, Looper looper) {
            this.pec = scanCameraLightDetector;
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what == 233) {
                a aVar = (a) message.obj;
                if (aVar != null) {
                    long NA = bg.NA();
                    w.i("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", new Object[]{Boolean.valueOf(ScanCameraLightDetector.g(aVar.nDz, aVar.width, aVar.height)), Float.valueOf(this.pec.pea), Long.valueOf(bg.aB(NA))});
                    if (ScanCameraLightDetector.g(aVar.nDz, aVar.width, aVar.height)) {
                        w.i("MicroMsg.ScanCameraLightDetector", "is dark now");
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 ped;

                            {
                                this.ped = r1;
                            }

                            public final void run() {
                                b noVar = new no();
                                noVar.fUI.fUJ = true;
                                com.tencent.mm.sdk.b.a.urY.m(noVar);
                            }
                        });
                        return;
                    }
                    w.i("MicroMsg.ScanCameraLightDetector", "not dark");
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 ped;

                        {
                            this.ped = r1;
                        }

                        public final void run() {
                            b noVar = new no();
                            noVar.fUI.fUJ = false;
                            com.tencent.mm.sdk.b.a.urY.m(noVar);
                        }
                    });
                }
            }
        }
    }

    private class a {
        public int height;
        public byte[] nDz;
        final /* synthetic */ ScanCameraLightDetector pec;
        public int width;

        public a(ScanCameraLightDetector scanCameraLightDetector) {
            this.pec = scanCameraLightDetector;
        }
    }

    private static native int calcLumNative(byte[] bArr, int i, int i2);

    public static boolean g(byte[] bArr, int i, int i2) {
        if (!bg.bm(bArr) && bArr.length > i * i2) {
            w.i("MicroMsg.ScanCameraLightDetector", "lum light: %s", new Object[]{Integer.valueOf(calcLumNative(bArr, i, i2))});
            if (calcLumNative(bArr, i, i2) < 50) {
                return true;
            }
        }
        return false;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length > 0) {
            this.pea = fArr[0];
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        w.d("MicroMsg.ScanCameraLightDetector", "onAccuracyChanged");
    }
}
