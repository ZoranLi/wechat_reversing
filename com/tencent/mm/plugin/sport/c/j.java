package com.tencent.mm.plugin.sport.c;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class j implements SensorEventListener {
    private static long qRA = 0;
    private static long qRB = 0;
    private static long qRC = 0;
    private static long qRD = 0;
    private static long qRE = 0;
    private static long qRF = 0;
    private static long qRG = 0;
    private static long qRH = 0;
    public c qRI;

    public static long bmy() {
        return qRC;
    }

    public static long bmz() {
        return qRE;
    }

    public j() {
        qRE = 0;
        qRF = 0;
        qRG = 0;
        qRH = 0;
        qRA = 0;
        qRB = 0;
        qRC = 0;
        qRD = 0;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        JSONObject bmv = f.bmv();
        if (bmv.optInt("deviceStepSwitch") != 1) {
            if (this.qRI != null) {
                this.qRI.bmt();
            }
            w.i("MicroMsg.Sport.SportStepDetector", "device step switch off");
            return;
        }
        int optInt = bmv.optInt("stepCounterMaxStep5m", 3000);
        String str;
        String str2;
        if (sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length > 0) {
            w.i("MicroMsg.Sport.SportStepDetector", "Step change %f, accuracy %s, %s", new Object[]{Float.valueOf(sensorEvent.values[0]), Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp)});
            long bJU = bg.bJU() / 10000;
            if (qRE == 0) {
                qRE = h.uu(f.CTRL_INDEX);
            }
            if (qRB == 0) {
                qRB = h.uu(aq.CTRL_INDEX);
            }
            if (qRC == 0) {
                qRC = h.uu(bh.CTRL_INDEX);
            }
            if (qRD == 0) {
                qRD = qRC;
            }
            if (qRF == 0) {
                qRF = h.uu(ao.CTRL_INDEX);
            }
            if (qRG == 0) {
                qRG = qRF;
            }
            if (qRH == 0) {
                qRH = h.uu(ag.CTRL_INDEX);
            }
            w.i("MicroMsg.Sport.SportStepDetector", "currentVar: beginOfToday %d saveTodayTime %d preSensorStep %d currentTodayStep %d lastSaveSensorStep %d lastSaveStepTime %d preSysStepTime %d preSensorNanoTime %d", new Object[]{Long.valueOf(bJU), Long.valueOf(qRE), Long.valueOf(qRB), Long.valueOf(qRC), Long.valueOf(qRD), Long.valueOf(qRF), Long.valueOf(qRG), Long.valueOf(qRH)});
            long j = (long) sensorEvent.values[0];
            qRA = j;
            if (j >= 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = sensorEvent.timestamp;
                if (qRE != bJU) {
                    w.i("MicroMsg.Sport.SportStepDetector", "new day beginOfToday: %s saveTodayTime: %s, ", new Object[]{k.aq(10000 * bJU), k.aq(qRE * 10000)});
                    h.H(f.CTRL_INDEX, bJU);
                    h.H(bh.CTRL_INDEX, 0);
                    h.H(ao.CTRL_INDEX, currentTimeMillis);
                    h.H(ag.CTRL_INDEX, sensorEvent.timestamp);
                    h.H(aq.CTRL_INDEX, (long) ((int) qRA));
                    qRB = qRA;
                    qRC = 0;
                    qRD = 0;
                    qRE = bJU;
                    qRF = currentTimeMillis;
                    qRG = currentTimeMillis;
                    qRH = j2;
                    return;
                }
                boolean z;
                long j3 = ((currentTimeMillis - qRG) / 300000) + ((long) ((currentTimeMillis - qRG) % 300000 > 0 ? 1 : 0));
                long j4 = (((j2 / 1000000) - (qRH / 1000000)) / 300000) + ((long) (((j2 / 1000000) - (qRH / 1000000)) % 300000 > 0 ? 1 : 0));
                w.i("MicroMsg.Sport.SportStepDetector", "timesOf5Minute(%d, %d). rebootTime: %d %s", new Object[]{Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(h.uu(cf.CTRL_INDEX)), k.aq(h.uu(cf.CTRL_INDEX))});
                boolean z2 = false;
                str = "";
                long j5;
                if (h.uu(cf.CTRL_INDEX) > qRF) {
                    j5 = qRA - qRD;
                    if (j5 <= 0 || (j5 >= ((long) optInt) * j4 && j5 >= ((long) optInt) * j3)) {
                        str2 = str;
                        bJU = 0;
                    } else {
                        str2 = "rebootIncrease Valid Step diffStep > 0";
                        bJU = j5;
                    }
                    if (j5 < 0 && (qRA < j4 * ((long) optInt) || qRA < j3 * ((long) optInt))) {
                        bJU = qRA;
                        str2 = "rebootIncrease Valid Step diffStep < 0";
                    }
                    h.H(cf.CTRL_INDEX, 0);
                    z = true;
                } else {
                    if (qRA < qRB) {
                        w.i("MicroMsg.Sport.SportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", new Object[]{Long.valueOf(qRA), Long.valueOf(qRB), Long.valueOf(qRD)});
                        j5 = qRA;
                        qRB = j5;
                        qRD = j5;
                        z2 = true;
                    }
                    if (qRA - qRB < j4 * ((long) optInt) || qRA - qRB < j3 * ((long) optInt)) {
                        str2 = "normalIncrease Valid Step";
                        z = z2;
                        bJU = qRA - qRB;
                    } else {
                        str2 = str;
                        z = z2;
                        bJU = 0;
                    }
                }
                w.i("MicroMsg.Sport.SportStepDetector", "increase step %s %d %b", new Object[]{str2, Long.valueOf(bJU), Boolean.valueOf(z)});
                qRC = bJU + qRC;
                if (currentTimeMillis - qRF > ((long) bmv.optInt("stepCounterSaveInterval", 60000)) || qRA - qRD > ((long) bmv.optInt("stepCounterSaveStep")) || z) {
                    h.H(bh.CTRL_INDEX, qRC);
                    h.H(aq.CTRL_INDEX, qRA);
                    h.H(ao.CTRL_INDEX, currentTimeMillis);
                    h.H(ag.CTRL_INDEX, j2);
                    w.i("MicroMsg.Sport.SportStepDetector", "save to [file] currentTodayStep %d lastSaveSensorStep %d preSysStepTime %d lastSaveStepTime %d preSensorNanoTime %d", new Object[]{Long.valueOf(qRC), Long.valueOf(qRD), Long.valueOf(qRG), Long.valueOf(qRF), Long.valueOf(qRH)});
                    qRF = currentTimeMillis;
                    qRD = qRA;
                } else {
                    w.i("MicroMsg.Sport.SportStepDetector", "save to cache currentTodayStep %d preSysStepTime %d lastSaveStepTime %d preSensorNanoTime %d", new Object[]{Long.valueOf(qRC), Long.valueOf(qRG), Long.valueOf(qRF), Long.valueOf(qRH)});
                }
                qRB = qRA;
                qRG = currentTimeMillis;
                qRH = j2;
            }
        } else if (sensorEvent == null || sensorEvent.values == null) {
            str = "MicroMsg.Sport.SportStepDetector";
            str2 = "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(sensorEvent == null);
            objArr[1] = Boolean.valueOf(sensorEvent != null);
            w.e(str, str2, objArr);
        } else {
            w.e("MicroMsg.Sport.SportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", new Object[]{Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp)});
            int i = 0;
            float[] fArr = sensorEvent.values;
            int length = fArr.length;
            int i2 = 0;
            while (i2 < length) {
                float f = fArr[i2];
                r10 = new Object[2];
                int i3 = i + 1;
                r10[0] = Integer.valueOf(i);
                r10[1] = Float.valueOf(f);
                w.e("MicroMsg.Sport.SportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", r10);
                i2++;
                i = i3;
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
