package com.tencent.mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.e.a.dh;
import com.tencent.mm.e.a.di;
import com.tencent.mm.e.a.dj;
import com.tencent.mm.e.a.dk;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import org.json.JSONObject;

public final class ExdeviceWCLanSDKUtil {
    BroadcastReceiver iRM;
    public HashMap<String, byte[]> lcJ;
    public HashMap<String, Boolean> lcL;
    a lcM;
    a lcO;
    private int ldc;
    private int ldd;
    a lde;
    a ldf;
    public HashMap<String, String> ldg;
    boolean ldh;
    boolean ldi;
    boolean ldj;
    int ldk;
    Context mContext;

    public class LanStateChangeReceiver extends BroadcastReceiver {
        final /* synthetic */ ExdeviceWCLanSDKUtil ldl;

        public LanStateChangeReceiver(ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil) {
            this.ldl = exdeviceWCLanSDKUtil;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null) {
                    boolean z = ((NetworkInfo) parcelableExtra).getState() == State.CONNECTED;
                    w.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "isConnected =" + z);
                    if (this.ldl.ldi || this.ldl.ldh != z) {
                        b dkVar = new dk();
                        dkVar.fHr.fHs = z;
                        com.tencent.mm.sdk.b.a.urY.m(dkVar);
                        this.ldl.ldi = false;
                        this.ldl.ldh = z;
                    }
                }
            }
        }
    }

    public ExdeviceWCLanSDKUtil() {
        this.ldc = 0;
        this.ldd = 0;
        this.lcJ = new HashMap();
        this.lcL = new HashMap();
        this.ldg = new HashMap();
        this.mContext = null;
        this.ldh = false;
        this.ldi = false;
        this.ldj = false;
        this.ldh = true;
        this.ldi = true;
        this.lcJ.clear();
        this.lcL.clear();
        this.ldg.clear();
        this.mContext = ab.getContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        if (this.iRM == null) {
            this.iRM = new LanStateChangeReceiver(this);
        }
        this.mContext.registerReceiver(this.iRM, intentFilter);
        this.lde = new a(this) {
            final /* synthetic */ ExdeviceWCLanSDKUtil ldl;

            {
                this.ldl = r1;
            }

            public final void f(int i, Object... objArr) {
                String string;
                Throwable e;
                String str = null;
                if (i == 10 && objArr != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                        JSONObject jSONObject2 = jSONObject.getJSONObject("deviceInfo");
                        string = jSONObject2.getString("deviceType");
                        try {
                            str = jSONObject2.getString("deviceId");
                            if (!jSONObject.isNull("manufacturerData")) {
                                this.ldl.ldg.put(str, jSONObject.getString("manufacturerData"));
                            }
                        } catch (Exception e2) {
                            e = e2;
                            w.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                            w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "json decode failed in disc package callback!");
                            if (string != null) {
                            }
                            w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                        }
                    } catch (Exception e3) {
                        e = e3;
                        string = null;
                        w.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                        w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "json decode failed in disc package callback!");
                        if (string != null) {
                        }
                        w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                    }
                    if (string != null || r1 == null) {
                        w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                    }
                }
            }
        };
        this.lcM = new a(this) {
            final /* synthetic */ ExdeviceWCLanSDKUtil ldl;

            {
                this.ldl = r1;
            }

            public final void f(int i, Object... objArr) {
                Exception e;
                String str = null;
                if (i == 14 && objArr != null && objArr.length > 0 && (objArr[0] instanceof byte[])) {
                    JSONObject jSONObject;
                    String string;
                    try {
                        jSONObject = new JSONObject(new String((byte[]) objArr[0])).getJSONObject("deviceInfo");
                        try {
                            string = jSONObject.getString("deviceType");
                        } catch (Exception e2) {
                            e = e2;
                            string = str;
                            w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in get device profile callback %s", new Object[]{e});
                            if (string != null) {
                            }
                            w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                            return;
                        }
                        try {
                            str = jSONObject.getString("deviceId");
                        } catch (Exception e3) {
                            e = e3;
                            w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in get device profile callback %s", new Object[]{e});
                            if (string != null) {
                            }
                            w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                            return;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        jSONObject = str;
                        string = str;
                        w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in get device profile callback %s", new Object[]{e});
                        if (string != null) {
                        }
                        w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                        return;
                    }
                    if (string != null || str == null) {
                        w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                        return;
                    }
                    w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get device deviceType =" + string + ",deviceId = " + str);
                    if (ad.apt().vj(str) == null) {
                        w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "hdInfo null, %s", new Object[]{str});
                        return;
                    }
                    this.ldl.lcJ.put(str, jSONObject.toString().getBytes());
                    b djVar = new dj();
                    djVar.fHo.fwJ = str;
                    if (this.ldl.ldg.containsKey(str)) {
                        String str2 = (String) this.ldl.ldg.get(str);
                        if (!bg.mA(str2)) {
                            djVar.fHo.fHp = str2.getBytes();
                        }
                        this.ldl.ldg.remove(str);
                    }
                    djVar.fHo.fHq = false;
                    com.tencent.mm.sdk.b.a.urY.m(djVar);
                }
            }
        };
        this.lcO = new a(this) {
            final /* synthetic */ ExdeviceWCLanSDKUtil ldl;

            {
                this.ldl = r1;
            }

            public final void f(int i, Object... objArr) {
                Throwable e;
                String str = null;
                if (i == 13 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer)) {
                    String string;
                    b dhVar;
                    String str2 = (String) objArr[0];
                    int intValue = ((Integer) objArr[1]).intValue();
                    try {
                        JSONObject jSONObject = new JSONObject(new String(str2));
                        string = jSONObject.getString("deviceId");
                        try {
                            str = jSONObject.getString("deviceType");
                        } catch (Exception e2) {
                            e = e2;
                            w.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                            w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in device ConnState notify callback");
                            switch (intValue) {
                                case 1:
                                    this.ldl.ldk = 2;
                                    this.ldl.lcL.put(string, Boolean.valueOf(true));
                                    w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                                    break;
                                default:
                                    this.ldl.ldk = 0;
                                    this.ldl.lcL.put(string, Boolean.valueOf(false));
                                    w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                                    break;
                            }
                            if (!this.ldl.ldj) {
                                if (this.ldl.ldk == 2) {
                                    this.ldl.d(true, string);
                                }
                                dhVar = new dh();
                                dhVar.fHl.fwJ = string;
                                dhVar.fHl.fHm = this.ldl.ldk;
                                dhVar.fHl.fGs = str;
                                com.tencent.mm.sdk.b.a.urY.m(dhVar);
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        string = str;
                        w.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                        w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in device ConnState notify callback");
                        switch (intValue) {
                            case 1:
                                this.ldl.ldk = 2;
                                this.ldl.lcL.put(string, Boolean.valueOf(true));
                                w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                                break;
                            default:
                                this.ldl.ldk = 0;
                                this.ldl.lcL.put(string, Boolean.valueOf(false));
                                w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                                break;
                        }
                        if (!this.ldl.ldj) {
                            if (this.ldl.ldk == 2) {
                                this.ldl.d(true, string);
                            }
                            dhVar = new dh();
                            dhVar.fHl.fwJ = string;
                            dhVar.fHl.fHm = this.ldl.ldk;
                            dhVar.fHl.fGs = str;
                            com.tencent.mm.sdk.b.a.urY.m(dhVar);
                        }
                    }
                    switch (intValue) {
                        case 1:
                            this.ldl.ldk = 2;
                            this.ldl.lcL.put(string, Boolean.valueOf(true));
                            w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                            break;
                        default:
                            this.ldl.ldk = 0;
                            this.ldl.lcL.put(string, Boolean.valueOf(false));
                            w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                            break;
                    }
                    if (!this.ldl.ldj) {
                        if (this.ldl.ldk == 2) {
                            this.ldl.d(true, string);
                        }
                        dhVar = new dh();
                        dhVar.fHl.fwJ = string;
                        dhVar.fHl.fHm = this.ldl.ldk;
                        dhVar.fHl.fGs = str;
                        com.tencent.mm.sdk.b.a.urY.m(dhVar);
                    }
                }
            }
        };
        this.ldf = new a(this) {
            final /* synthetic */ ExdeviceWCLanSDKUtil ldl;

            {
                this.ldl = r1;
            }

            public final void f(int i, Object... objArr) {
                String string;
                String str;
                Throwable th;
                b diVar;
                if (i == 16 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof byte[])) {
                    byte[] bArr = (byte[]) objArr[1];
                    try {
                        JSONObject jSONObject = new JSONObject(new String((String) objArr[0]));
                        String string2 = jSONObject.getString("deviceType");
                        try {
                            string = jSONObject.getString("deviceId");
                            str = string2;
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            string = string2;
                            th = th2;
                            w.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", th, "", new Object[0]);
                            w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
                            str = string;
                            string = null;
                            w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + new String(bArr));
                            diVar = new di();
                            diVar.fHn.fwJ = string;
                            diVar.fHn.data = bArr;
                            diVar.fHn.fGs = str;
                            com.tencent.mm.sdk.b.a.urY.m(diVar);
                        }
                    } catch (Throwable e2) {
                        th = e2;
                        string = null;
                        w.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", th, "", new Object[0]);
                        w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
                        str = string;
                        string = null;
                        w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + new String(bArr));
                        diVar = new di();
                        diVar.fHn.fwJ = string;
                        diVar.fHn.data = bArr;
                        diVar.fHn.fGs = str;
                        com.tencent.mm.sdk.b.a.urY.m(diVar);
                    }
                    w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + new String(bArr));
                    diVar = new di();
                    diVar.fHn.fwJ = string;
                    diVar.fHn.data = bArr;
                    diVar.fHn.fGs = str;
                    com.tencent.mm.sdk.b.a.urY.m(diVar);
                }
            }
        };
    }

    public final boolean d(boolean z, String str) {
        if (str == null || !this.lcJ.containsKey(str)) {
            w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in openOrCloseDevice");
            return false;
        }
        byte[] bArr = (byte[]) this.lcJ.get(str);
        try {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "open device!");
                jSONObject.put("cmd", "open");
            } else {
                w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "close device!");
                jSONObject.put("cmd", "close");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("wxmsg_jsapi", jSONObject);
            jSONObject = new JSONObject();
            jSONObject.put("services", jSONObject2);
            this.ldd = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject.toString().getBytes());
            if (this.ldd != 0) {
                w.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get openOrCloseDevice mCallBackCmdId =" + this.ldd);
            } else {
                w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "openOrCloseDevice error!");
            }
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
            w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in openOrCloseDevice");
            return false;
        }
    }

    public final boolean R(String str, boolean z) {
        if (str == null || !this.lcJ.containsKey(str)) {
            w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in connectWCLanDevice");
            return false;
        }
        byte[] bArr = (byte[]) this.lcJ.get(str);
        this.ldj = true;
        if (z) {
            try {
                String string = new JSONObject(new String(bArr)).getString("deviceType");
                w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice deviceId: " + str);
                if (Java2CExDevice.connectWCLanDevice(bArr, false) != 0) {
                    w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice error!");
                    return false;
                }
                b dhVar = new dh();
                dhVar.fHl.fwJ = str;
                dhVar.fHl.fHm = 1;
                dhVar.fHl.fGs = string;
                com.tencent.mm.sdk.b.a.urY.m(dhVar);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in connectWCLanDevice!");
                return false;
            }
        }
        d(false, str);
        w.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "disconnectWCLanDevice...");
        Java2CExDevice.disconnectWCLanDevice(bArr);
        return true;
    }

    public final boolean bS(String str, String str2) {
        if (!uW(str)) {
            w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceId " + str + " not connected!");
            return false;
        } else if (str == null || !this.lcJ.containsKey(str)) {
            w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in useWCLanDeviceService");
            return false;
        } else {
            byte[] bArr = (byte[]) this.lcJ.get(str);
            this.ldc = 0;
            try {
                boolean z;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, str2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("wxmsg_jsapi", jSONObject);
                jSONObject = new JSONObject();
                jSONObject.put("services", jSONObject2);
                this.ldc = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject.toString().getBytes());
                if (this.ldc != 0) {
                    z = true;
                    w.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get useWCLanDeviceService mCallBackCmdId =" + this.ldc);
                } else {
                    w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "useWCLanDeviceService error!");
                    z = false;
                }
                return z;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                w.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in useWCLanDeviceService");
                return false;
            }
        }
    }

    public final boolean uW(String str) {
        if (str == null || !this.lcL.containsKey(str)) {
            return false;
        }
        return ((Boolean) this.lcL.get(str)).booleanValue();
    }
}
