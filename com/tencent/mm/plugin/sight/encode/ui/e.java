package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.List;

final class e implements SensorEventListener {
    private static int nBL = Integer.MAX_VALUE;
    Camera gPJ = null;
    private Context mContext = null;
    boolean nBH = false;
    boolean nBJ = false;
    private int nBK = 0;
    private float nBO = 0.0f;
    private float nBP = 0.0f;
    private float nBQ = 0.0f;
    private boolean nCj = false;
    com.tencent.mm.pluginsdk.m.a pxW = com.tencent.mm.pluginsdk.m.a.bDL();
    public PreviewCallback pxX = null;
    a pxY = new a(Looper.getMainLooper());

    private static class a extends ae {
        static boolean nCk = true;
        static AutoFocusCallback nCl = new AutoFocusCallback() {
            public final void onAutoFocus(boolean z, Camera camera) {
                w.v("MicroMsg.SightCamera", "auto focus callback");
                a.nCk = true;
            }
        };
        float mTA;
        boolean nBH = false;
        int nCt = 0;
        boolean nCu = false;
        boolean nCv = false;
        float nCw;
        int nCx;
        int nCy;

        private static Rect a(float f, float f2, float f3, int i, int i2) {
            int intValue = Float.valueOf(((float) com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 72)) * f3).intValue();
            RectF rectF = new RectF();
            rectF.set((((f - ((float) (intValue / 2))) * 2000.0f) / ((float) i)) - 1000.0f, (((f2 - ((float) (intValue / 2))) * 2000.0f) / ((float) i2)) - 1000.0f, (((((float) (intValue / 2)) + f) * 2000.0f) / ((float) i)) - 1000.0f, (((((float) (intValue / 2)) + f2) * 2000.0f) / ((float) i2)) - 1000.0f);
            return new Rect(pD(Math.round(rectF.left)), pD(Math.round(rectF.top)), pD(Math.round(rectF.right)), pD(Math.round(rectF.bottom)));
        }

        private static int pD(int i) {
            if (i > 1000) {
                return 1000;
            }
            return i < DownloadResult.CODE_UNDEFINED ? DownloadResult.CODE_UNDEFINED : i;
        }

        static void e(Camera camera) {
            if (camera == null) {
                w.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
            }
            if (nCk) {
                nCk = false;
                try {
                    camera.autoFocus(nCl);
                    return;
                } catch (Exception e) {
                    w.w("MicroMsg.SightCamera", "autofocus fail, exception %s", new Object[]{e.getMessage()});
                    nCk = true;
                    return;
                }
            }
            w.w("MicroMsg.SightCamera", "auto focus not back");
        }

        public a(Looper looper) {
            super(looper);
        }

        private static int b(Parameters parameters) {
            if (parameters == null) {
                return 0;
            }
            int maxZoom;
            try {
                maxZoom = parameters.getMaxZoom() / 2;
                if (maxZoom <= 0) {
                    maxZoom = parameters.getMaxZoom();
                }
            } catch (Exception e) {
                w.e("MicroMsg.SightCamera", "get target zoom value error: %s", new Object[]{e.getMessage()});
                maxZoom = 0;
            }
            return maxZoom;
        }

        static int c(Parameters parameters) {
            int b = b(parameters) / 6;
            if (b <= 0) {
                return 1;
            }
            return b;
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            Camera camera;
            switch (message.what) {
                case 4353:
                    if (!this.nCv) {
                        int b;
                        camera = (Camera) message.obj;
                        Parameters parameters = camera.getParameters();
                        w.i("MicroMsg.SightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[]{Boolean.valueOf(this.nBH), Integer.valueOf(this.nCt), Integer.valueOf(parameters.getZoom())});
                        int zoom = parameters.getZoom() + this.nCt;
                        if (this.nBH) {
                            b = b(parameters);
                            if (zoom < b) {
                                long j;
                                Message obtainMessage = obtainMessage(4353, message.obj);
                                if (this.nCu) {
                                    j = 10;
                                } else {
                                    j = 20;
                                }
                                sendMessageDelayed(obtainMessage, j);
                                z = false;
                                b = zoom;
                            }
                        } else if (zoom <= 0) {
                            b = 0;
                        } else {
                            sendMessageDelayed(obtainMessage(4353, message.obj), this.nCu ? 10 : 20);
                            z = false;
                            b = zoom;
                        }
                        parameters.setZoom(b);
                        try {
                            camera.setParameters(parameters);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.SightCamera", e, "", new Object[0]);
                        }
                        if (z) {
                            this.nCx = 0;
                            this.nCy = 0;
                            sendMessageDelayed(obtainMessage(4354, message.obj), 20);
                            return;
                        }
                        return;
                    }
                    return;
                case 4354:
                    camera = (Camera) message.obj;
                    if (this.nCx == 0 || this.nCx == 0 || d.ep(14)) {
                        e(camera);
                        return;
                    }
                    float f = this.nCw;
                    float f2 = this.mTA;
                    int i = this.nCx;
                    int i2 = this.nCy;
                    if (camera == null) {
                        w.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
                    }
                    if (nCk) {
                        nCk = false;
                        try {
                            w.i("MicroMsg.SightCamera", "ashutest:: touch %f %f, display %d %d", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)});
                            w.i("MicroMsg.SightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[]{a(f, f2, 1.0f, i, i2), a(f, f2, DownloadHelper.SAVE_FATOR, i, i2)});
                            Parameters parameters2 = camera.getParameters();
                            List supportedFocusModes = parameters2.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                                parameters2.setFocusMode("auto");
                            }
                            if (parameters2.getMaxNumFocusAreas() > 0) {
                                supportedFocusModes = new ArrayList(1);
                                supportedFocusModes.add(new Area(r7, 1000));
                                parameters2.setFocusAreas(supportedFocusModes);
                            }
                            if (parameters2.getMaxNumMeteringAreas() > 0) {
                                supportedFocusModes = new ArrayList(1);
                                supportedFocusModes.add(new Area(r2, 1000));
                                parameters2.setMeteringAreas(supportedFocusModes);
                            }
                            camera.setParameters(parameters2);
                            camera.autoFocus(nCl);
                            return;
                        } catch (Exception e2) {
                            w.w("MicroMsg.SightCamera", "autofocus with area fail, exception %s", new Object[]{e2.getMessage()});
                            nCk = true;
                            return;
                        }
                    }
                    w.w("MicroMsg.SightCamera", "auto focus not back");
                    return;
                default:
                    return;
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.nBO - f) > 3.0f || Math.abs(this.nBP - f2) > 3.0f || Math.abs(this.nBQ - f3) > 3.0f) {
            w.i("MicroMsg.SightCamera", "match accel limit %f, try auto focus", new Object[]{Float.valueOf(3.0f)});
            a.e(this.gPJ);
            this.nBO = f;
            this.nBP = f2;
            this.nBQ = f3;
        }
    }
}
