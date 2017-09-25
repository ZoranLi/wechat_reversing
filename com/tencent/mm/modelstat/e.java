package com.tencent.mm.modelstat;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.mm.a.o;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import junit.framework.Assert;

public class e {
    private static e hVs;
    private int hVt = -1;
    public int hVu = 20000;
    public int hVv = 3000;
    public int hVw = 1000;
    public int hVx = 20;
    public ArrayList<Pair<Float, Float>> hVy = new ArrayList();
    public ArrayList<Pair<Float, Float>> hVz = new ArrayList();
    public long startTime = 0;

    static class a {
        public int accuracy = 0;
        public float[] values;

        public a(SensorEvent sensorEvent) {
            if (sensorEvent != null) {
                this.accuracy = sensorEvent.accuracy;
                this.values = new float[sensorEvent.values.length];
                System.arraycopy(sensorEvent.values, 0, this.values, 0, sensorEvent.values.length);
            }
        }
    }

    class b {
        final /* synthetic */ e hVF;
        private SensorManager hVM;
        public long hVN = 0;
        a hVO = null;
        a hVP = null;
        a hVQ = null;
        private Long hVR = null;
        ArrayList<Long> hVS = new ArrayList();
        ArrayList<a> hVT = new ArrayList();
        ArrayList<a> hVU = new ArrayList();
        ArrayList<a> hVV = new ArrayList();
        ArrayList<float[]> hVW = new ArrayList();
        private SensorEventListener hVX = new SensorEventListener(this) {
            final /* synthetic */ b hVY;

            {
                this.hVY = r1;
            }

            public final void onAccuracyChanged(Sensor sensor, int i) {
            }

            public final void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null) {
                    long Nz = bg.Nz();
                    if (sensorEvent.sensor.getType() == 1) {
                        this.hVY.hVO = new a(sensorEvent);
                    } else if (sensorEvent.sensor.getType() == 2) {
                        this.hVY.hVP = new a(sensorEvent);
                    } else if (sensorEvent.sensor.getType() == 4) {
                        this.hVY.hVQ = new a(sensorEvent);
                    }
                    long j = Nz - this.hVY.hnT;
                    if (this.hVY.hVO != null && this.hVY.hVP != null && this.hVY.hVQ != null) {
                        if (j > this.hVY.hVN || j < 0) {
                            float[] fArr = new float[9];
                            SensorManager.getRotationMatrix(fArr, null, this.hVY.hVO.values, this.hVY.hVP.values);
                            Object obj = new float[3];
                            SensorManager.getOrientation(fArr, obj);
                            this.hVY.hnT = Nz;
                            this.hVY.hVS.add(Long.valueOf(Nz));
                            this.hVY.hVT.add(this.hVY.hVO);
                            this.hVY.hVU.add(this.hVY.hVP);
                            this.hVY.hVV.add(this.hVY.hVQ);
                            this.hVY.hVW.add(obj);
                            int size = this.hVY.hVT.size() - 1;
                            w.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", Integer.valueOf(this.hVY.hVT.size()), Integer.valueOf(((a) this.hVY.hVT.get(size)).accuracy), Float.valueOf(((a) this.hVY.hVT.get(size)).values[0]), Float.valueOf(((a) this.hVY.hVT.get(size)).values[1]), Float.valueOf(((a) this.hVY.hVT.get(size)).values[2]));
                            w.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", Long.valueOf(j), Integer.valueOf(this.hVY.hVO.accuracy), Float.valueOf(this.hVY.hVO.values[0]), Float.valueOf(this.hVY.hVO.values[1]), Float.valueOf(this.hVY.hVO.values[2]), Integer.valueOf(this.hVY.hVP.accuracy), Float.valueOf(this.hVY.hVP.values[0]), Float.valueOf(this.hVY.hVP.values[1]), Float.valueOf(this.hVY.hVP.values[2]), Integer.valueOf(this.hVY.hVQ.accuracy), Float.valueOf(this.hVY.hVQ.values[0]), Float.valueOf(this.hVY.hVQ.values[1]), Float.valueOf(this.hVY.hVQ.values[2]), Float.valueOf(obj[0]), Float.valueOf(obj[1]), Float.valueOf(obj[2]));
                        }
                    }
                }
            }
        };
        private HandlerThread handlerThread = null;
        long hnT = 0;

        b(e eVar) {
            this.hVF = eVar;
        }

        public final boolean r(Context context, int i) {
            boolean z;
            try {
                if (this.hVM == null) {
                    this.hVM = (SensorManager) context.getSystemService("sensor");
                }
                if (this.handlerThread == null) {
                    this.handlerThread = com.tencent.mm.sdk.f.e.cE("MicroMsg.IndoorReporter", 1);
                    this.handlerThread.start();
                }
                Handler handler = new Handler(this.handlerThread.getLooper());
                z = this.hVM.registerListener(this.hVX, this.hVM.getDefaultSensor(1), 3, handler) && this.hVM.registerListener(this.hVX, this.hVM.getDefaultSensor(4), 3, handler) && this.hVM.registerListener(this.hVX, this.hVM.getDefaultSensor(2), 3, handler);
            } catch (Exception e) {
                w.e("MicroMsg.IndoorReporter", "start except:%s", e.getMessage());
                z = false;
            }
            if (!z) {
                try {
                    if (this.hVM != null) {
                        this.hVM.unregisterListener(this.hVX);
                        this.hVM = null;
                    }
                } catch (Exception e2) {
                }
                try {
                    if (this.handlerThread != null) {
                        this.handlerThread.quit();
                        this.handlerThread = null;
                    }
                } catch (Exception e3) {
                }
            }
            this.hVN = (long) i;
            this.hVR = Long.valueOf(bg.Nz());
            return z;
        }

        public final String JY() {
            try {
                if (this.hVM != null) {
                    this.hVM.unregisterListener(this.hVX);
                    this.hVM = null;
                }
            } catch (Exception e) {
            }
            try {
                if (this.handlerThread != null) {
                    this.handlerThread.quit();
                    this.handlerThread = null;
                }
            } catch (Exception e2) {
            }
            w.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", Integer.valueOf(this.hVS.size()));
            String str = this.hVR + ";" + this.hVS.size() + ";#";
            int i = 0;
            while (i < this.hVS.size()) {
                String str2 = (str + (((Long) this.hVS.get(i)).longValue() - this.hVR.longValue()) + ";") + a((a) this.hVT.get(i));
                w.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", Integer.valueOf(i), Integer.valueOf(((a) this.hVT.get(i)).accuracy), Float.valueOf(((a) this.hVT.get(i)).values[0]), Float.valueOf(((a) this.hVT.get(i)).values[1]), Float.valueOf(((a) this.hVT.get(i)).values[2]), a((a) this.hVT.get(i)));
                i++;
                str = ((str2 + a((a) this.hVV.get(i))) + a((a) this.hVU.get(i))) + String.format("%.3f;%.3f;%.3f;#", new Object[]{Float.valueOf(((float[]) this.hVW.get(i))[0]), Float.valueOf(((float[]) this.hVW.get(i))[1]), Float.valueOf(((float[]) this.hVW.get(i))[2])});
            }
            w.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", Integer.valueOf(str.length()), str);
            return str;
        }

        private static String a(a aVar) {
            try {
                String str = new String();
                return String.format("%d;%.3f;%.3f;%.3f;", new Object[]{Integer.valueOf(aVar.accuracy), Float.valueOf(aVar.values[0]), Float.valueOf(aVar.values[1]), Float.valueOf(aVar.values[2])});
            } catch (Exception e) {
                return "0;0;0;0;";
            }
        }
    }

    class c {
        public WifiManager aPM;
        final /* synthetic */ e hVF;
        public int hVZ = 0;
        public int hVx = 0;
        public boolean hWa = false;
        public List<String> hWb = new ArrayList();
        public long startTime = 0;
        Thread thread = com.tencent.mm.sdk.f.e.b(new Runnable(this) {
            final /* synthetic */ c hWc;

            {
                this.hWc = r1;
            }

            public final void run() {
                w.i("MicroMsg.IndoorReporter", "start wifi");
                while (this.hWc.hWa) {
                    try {
                        int i;
                        long Nz = bg.Nz();
                        List scanResults = this.hWc.aPM.getScanResults();
                        String str = "";
                        if (scanResults == null || scanResults.size() <= 0) {
                            i = 0;
                        } else {
                            Collections.sort(scanResults, new Comparator<ScanResult>(this) {
                                final /* synthetic */ AnonymousClass1 hWd;

                                {
                                    this.hWd = r1;
                                }

                                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                    return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                                }
                            });
                            int i2 = 0;
                            i = 0;
                            while (i2 < scanResults.size()) {
                                int i3;
                                String str2;
                                ScanResult scanResult = (ScanResult) scanResults.get(i2);
                                if (scanResult != null && !bg.mA(scanResult.BSSID) && !bg.mA(scanResult.SSID)) {
                                    str = str + scanResult.SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "") + ";" + scanResult.BSSID + ";" + scanResult.level + ";";
                                    i3 = i + 1;
                                    if (i3 >= this.hWc.hVx) {
                                        i = i3;
                                        break;
                                    }
                                    str2 = str;
                                } else {
                                    i3 = i;
                                    str2 = str;
                                }
                                i2++;
                                str = str2;
                                i = i3;
                            }
                        }
                        w.i("MicroMsg.IndoorReporter", "%d %s", Integer.valueOf(((Nz - this.hWc.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str).length()), (Nz - this.hWc.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str);
                        this.hWc.hWb.add(r0);
                        this.hWc.aPM.startScan();
                        Thread.sleep((long) this.hWc.hVZ);
                    } catch (Exception e) {
                        w.e("MicroMsg.IndoorReporter", "Except:%s", e.getMessage());
                        return;
                    }
                }
            }
        }, "MicroMsg.IndoorReporter_WIFI_Scan");

        c(e eVar) {
            this.hVF = eVar;
        }

        public final String JY() {
            this.hWa = false;
            try {
                if (this.thread != null && this.thread.isAlive()) {
                    this.thread.join(500);
                }
            } catch (Exception e) {
                w.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", e.getMessage());
            }
            String str = this.hWb.size() + ";#";
            int i = false;
            while (i < this.hWb.size()) {
                String str2 = str + ((String) this.hWb.get(i)) + "#";
                i++;
                str = str2;
            }
            return str;
        }
    }

    public static e JX() {
        if (hVs == null) {
            synchronized (e.class) {
                if (hVs == null) {
                    hVs = new e();
                }
            }
        }
        return hVs;
    }

    public final void a(int i, boolean z, boolean z2, float f, float f2, int i2) {
        w.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
        if (h.vG().uV()) {
            h.vG();
            if (!com.tencent.mm.kernel.a.uP()) {
                com.tencent.mm.at.b IA = com.tencent.mm.at.b.IA();
                String str = "";
                String str2 = "";
                int i3 = z2 ? 1 : 0;
                if (h.vG().uV()) {
                    h.vG();
                    if (!com.tencent.mm.kernel.a.uP()) {
                        h.vJ();
                        h.vL().D(new com.tencent.mm.at.b.AnonymousClass1(IA, i3, f, f2, i, i2, 0, str, str2));
                    }
                }
                if (this.hVz.size() != 0 || this.hVy.size() != 0 || kQ(g.sV().getValue("AndroidIndoorSensorReport"))) {
                    if (!com.tencent.mm.sdk.a.b.bIu()) {
                        h.vG();
                        int aw = com.tencent.mm.a.h.aw(com.tencent.mm.kernel.a.uH() + 5, 100);
                        if (aw > this.hVt) {
                            r3 = new Object[3];
                            h.vG();
                            r3[0] = Long.valueOf(new o(com.tencent.mm.kernel.a.uH()).longValue());
                            r3[1] = Integer.valueOf(aw);
                            r3[2] = Integer.valueOf(this.hVt);
                            w.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", r3);
                            return;
                        }
                    }
                    h.vJ();
                    final boolean z3 = z2;
                    final float f3 = f;
                    final float f4 = f2;
                    final int i4 = i;
                    final boolean z4 = z;
                    final int i5 = i2;
                    h.vL().D(new Runnable(this) {
                        final /* synthetic */ e hVF;

                        public final void run() {
                            try {
                                if (h.vG().uV()) {
                                    h.vG();
                                    if (!com.tencent.mm.kernel.a.uP()) {
                                        long Nz = bg.Nz();
                                        if (this.hVF.startTime == 0 || Nz - this.hVF.startTime >= 1800000) {
                                            List list;
                                            Pair pair;
                                            if (z3) {
                                                list = this.hVF.hVy;
                                            } else {
                                                Object obj = this.hVF.hVz;
                                            }
                                            int i = 0;
                                            while (i < list.size()) {
                                                if (e.k(f3, ((Float) ((Pair) list.get(i)).first).floatValue()) && e.k(f4, ((Float) ((Pair) list.get(i)).second).floatValue())) {
                                                    pair = (Pair) list.get(i);
                                                    break;
                                                }
                                                i++;
                                            }
                                            pair = null;
                                            if (pair == null) {
                                                w.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
                                                return;
                                            }
                                            int i2;
                                            this.hVF.startTime = Nz;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            h.vG();
                                            final String stringBuilder2 = stringBuilder.append(new o(com.tencent.mm.kernel.a.uH()).toString()).append("_").append(this.hVF.startTime).toString();
                                            StringBuilder append = new StringBuilder().append(pair.first).append(",").append(pair.second).append(",").append(i4).append(",");
                                            int i3 = z4 ? 1 : 2;
                                            if (z3) {
                                                i2 = 10;
                                            } else {
                                                i2 = 20;
                                            }
                                            final String stringBuilder3 = append.append(i2 + i3).append(",").append(f3).append(",").append(f4).append(",0,").append(i5).append(",").append(this.hVF.startTime).append(",").toString();
                                            final c cVar = new c(this.hVF);
                                            Context context = ab.getContext();
                                            i3 = this.hVF.hVv;
                                            int i4 = this.hVF.hVx;
                                            if (cVar.aPM == null) {
                                                cVar.aPM = (WifiManager) context.getSystemService("wifi");
                                            }
                                            cVar.hVZ = i3;
                                            cVar.hVx = i4;
                                            cVar.startTime = bg.Nz();
                                            cVar.hWa = true;
                                            cVar.thread.start();
                                            final b bVar = new b(this.hVF);
                                            if (bVar.r(ab.getContext(), this.hVF.hVw)) {
                                                h.vJ();
                                                new aj(h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
                                                    boolean hVG = false;
                                                    final /* synthetic */ AnonymousClass1 hVL;

                                                    public final boolean oQ() {
                                                        boolean cB = l.cB(ab.getContext());
                                                        long Nz = bg.Nz();
                                                        long j = Nz - this.hVL.hVF.startTime;
                                                        if (j <= ((long) this.hVL.hVF.hVu)) {
                                                            if (cB) {
                                                                this.hVG = false;
                                                                return true;
                                                            } else if (!this.hVG) {
                                                                this.hVG = true;
                                                                return true;
                                                            }
                                                        }
                                                        w.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", Boolean.valueOf(this.hVG), Boolean.valueOf(cB), Long.valueOf(j));
                                                        this.hVL.hVF.startTime = 0;
                                                        String JY = bVar.JY();
                                                        String JY2 = cVar.JY();
                                                        try {
                                                            if (bg.mA(JY) || bg.mA(JY2)) {
                                                                w.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", JY, JY2);
                                                                com.tencent.mm.plugin.report.service.g.oUh.A(13381, stringBuilder3 + stringBuilder2 + (!bg.mA(JY) ? ",-10011,ERROR:StopFailed." : ",-10012,ERROR:StopFailed."));
                                                                return false;
                                                            }
                                                            String str = JY + JY2;
                                                            int ceil = (int) Math.ceil(((double) str.length()) / 5400.0d);
                                                            for (int i = 0; i < ceil; i++) {
                                                                w.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", Integer.valueOf(i), Integer.valueOf(ceil), Integer.valueOf(str.length()), Integer.valueOf((stringBuilder3 + stringBuilder2 + "_" + Nz + "_" + ceil + "_" + (j > ((long) this.hVL.hVF.hVu) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length()))).length()), stringBuilder3 + stringBuilder2 + "_" + Nz + "_" + ceil + "_" + (j > ((long) this.hVL.hVF.hVu) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length())));
                                                                com.tencent.mm.plugin.report.service.g.oUh.A(13381, JY);
                                                            }
                                                            return false;
                                                        } catch (Exception e) {
                                                            w.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", e.getMessage());
                                                        }
                                                    }
                                                }, true).v(3000, 3000);
                                                return;
                                            }
                                            w.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", Boolean.valueOf(true), Boolean.valueOf(bVar.r(ab.getContext(), this.hVF.hVw)));
                                            bVar.JY();
                                            cVar.JY();
                                            com.tencent.mm.plugin.report.service.g.oUh.A(13381, stringBuilder3 + stringBuilder2 + ",-10002,ERROR:StartFailed.");
                                            return;
                                        }
                                        w.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", Long.valueOf(Nz - this.hVF.startTime));
                                    }
                                }
                            } catch (Exception e) {
                                w.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", e.getMessage());
                            }
                        }
                    });
                }
            }
        }
    }

    public static boolean k(float f, float f2) {
        return ((double) Math.abs(f - f2)) < Math.pow(0.1d, 2.0d);
    }

    public final boolean kQ(String str) {
        if (bg.mA(str)) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.hVt = bg.getInt(split[0], -1);
            if (this.hVt > 101) {
                Assert.assertTrue(false);
            }
            this.hVu = bg.getInt(split[1], 20000);
            this.hVv = bg.getInt(split[2], 3000);
            this.hVw = bg.getInt(split[3], 1000);
            this.hVx = bg.getInt(split[4], 20);
            int i = bg.getInt(split[5], 0);
            for (int i2 = 0; i2 < i; i2++) {
                String[] split2 = split[i2 + 6].split(";");
                if ("1".equals(split2[0])) {
                    this.hVy.add(new Pair(Float.valueOf(bg.Qb(split2[1])), Float.valueOf(bg.Qb(split2[2]))));
                } else {
                    this.hVz.add(new Pair(Float.valueOf(bg.Qb(split2[1])), Float.valueOf(bg.Qb(split2[2]))));
                }
            }
            w.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", Integer.valueOf(this.hVu), Integer.valueOf(this.hVv), Integer.valueOf(this.hVw), Integer.valueOf(this.hVx), Integer.valueOf(i), Integer.valueOf(this.hVy.size()), Integer.valueOf(this.hVz.size()));
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", e.getMessage(), str);
            return false;
        }
    }
}
