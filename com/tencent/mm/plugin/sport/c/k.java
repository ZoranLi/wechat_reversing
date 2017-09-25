package com.tencent.mm.plugin.sport.c;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public final class k {
    public static final String aq(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }

    public static boolean s(long j, long j2) {
        long j3 = 3600000;
        try {
            JSONObject optJSONObject = f.bmv().optJSONObject("stepCountUploadConfig");
            if (optJSONObject != null) {
                j3 = (long) ((optJSONObject.optInt("backgroundTimeInterval", 60) * 60) * 1000);
            }
        } catch (Exception e) {
        }
        return j2 - j >= j3;
    }

    public static boolean t(long j, long j2) {
        int i = 500;
        if (j == 0 && j2 > 0) {
            return true;
        }
        try {
            JSONObject optJSONObject = f.bmv().optJSONObject("stepCountUploadConfig");
            if (optJSONObject != null) {
                i = optJSONObject.optInt("backgroundStepCountInterval", 500);
            }
        } catch (Exception e) {
        }
        return j2 - j >= ((long) i);
    }

    public static boolean cR(Context context) {
        if (d.ep(19)) {
            w.i("MicroMsg.Sport.SportUtil", "Not Support SDK VERSION");
            return false;
        } else if (!context.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
            w.i("MicroMsg.Sport.SportUtil", "Not Support FEATURE_SENSOR_STEP_COUNTER");
            return false;
        } else if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(19) == null) {
            w.i("MicroMsg.Sport.SportUtil", "Not Support can not get sensor");
            return false;
        } else if (f.bmv().optInt("deviceStepSwitch") == 1) {
            return true;
        } else {
            w.i("MicroMsg.Sport.SportUtil", "Not Support deviceStepSwitch is off");
            return false;
        }
    }

    public static boolean bmA() {
        if (f.bmv().optInt("extStepApiSwitch") == 1) {
            return true;
        }
        w.i("MicroMsg.Sport.SportUtil", "Not Support extStepApiSwitch is off");
        return false;
    }

    public static boolean bmm() {
        boolean ez;
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc("gh_43f2581f6fd6");
        if (Rc != null) {
            ez = a.ez(Rc.field_type);
        } else {
            ez = false;
        }
        if (!ez) {
            w.i("MicroMsg.Sport.SportUtil", "checkUserInstallWeSportPlugin %b", new Object[]{Boolean.valueOf(ez)});
        }
        return ez;
    }
}
