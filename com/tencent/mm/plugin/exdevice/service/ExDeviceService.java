package com.tencent.mm.plugin.exdevice.service;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.service.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public class ExDeviceService extends Service {
    private a lgC = null;

    public void onCreate() {
        w.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onCreate");
        super.onCreate();
    }

    public void onDestroy() {
        w.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onDestroy");
        Java2CExDevice.closeBluetoothAccessoryLib();
        super.onDestroy();
        if (!apK()) {
            w.i("MicroMsg.exdevice.ExDeviceService", "kill exdevice process now");
            Process.killProcess(Process.myPid());
        }
    }

    private static boolean apK() {
        boolean z;
        PackageManager packageManager = ab.getContext().getPackageManager();
        try {
            packageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
            packageManager.getPackageInfo("com.google.android.wearable.app", 1);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        w.i("MicroMsg.exdevice.ExDeviceService", "isInstallWearApp %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public IBinder onBind(Intent intent) {
        w.i("MicroMsg.exdevice.ExDeviceService", "ExDeviceService onBind");
        if (this.lgC == null) {
            this.lgC = new y();
        }
        return this.lgC;
    }
}
