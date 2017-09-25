package com.tencent.mm.plugin.exdevice.h;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    private static void b(SharedPreferences sharedPreferences) {
        int i = 0;
        w.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "tryToClearDirtyData");
        if (VERSION.SDK_INT >= 11) {
            if (sharedPreferences == null) {
                w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == aSP");
                return;
            }
            String[] strArr = new String[]{"conneted_device", "shut_down_device"};
            while (i < 2) {
                String str = strArr[i];
                try {
                    if (sharedPreferences.getStringSet(str, null) != null) {
                        w.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "find dirty data, remove it, key = %s", new Object[]{str});
                        if (!sharedPreferences.edit().remove(str).commit()) {
                            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove dirty data failed!!!");
                        }
                    }
                } catch (Exception e) {
                }
                i++;
            }
        }
    }

    public static boolean q(String str, long j) {
        w.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "isItemInSharedPreferences, key = %s, device id = %d", new Object[]{str, Long.valueOf(j)});
        if (bg.mA(str)) {
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            return false;
        }
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            return false;
        }
        b(sharedPreferences);
        if (b.bY(String.valueOf(j), sharedPreferences.getString(str, new String()))) {
            return true;
        }
        return false;
    }

    public static boolean r(String str, long j) {
        w.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addToSharedPreferences, key = %s, deviceId = %d", new Object[]{str, Long.valueOf(j)});
        if (bg.mA(str)) {
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            return false;
        }
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            return false;
        }
        b(sharedPreferences);
        String valueOf = String.valueOf(j);
        String string = sharedPreferences.getString(str, new String());
        w.i("MicroMsg.exdevice.Util", "addDeviceToDeviceList, device = %s, device list = %s", new Object[]{valueOf, string});
        if (bg.mA(valueOf) || string == null) {
            w.e("MicroMsg.exdevice.Util", "Error parameters!!!");
            valueOf = null;
        } else {
            valueOf = ((new String() + string) + valueOf) + "|";
            w.i("MicroMsg.exdevice.Util", "add device to device list successful, new device list = %s", new Object[]{valueOf});
        }
        if (valueOf == null) {
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addDeviceToDeviceList failed!!!");
            return false;
        } else if (sharedPreferences.edit().putString(str, valueOf).commit()) {
            w.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "add to sharepreference successful, new device list is %s", new Object[]{valueOf});
            return true;
        } else {
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit() Failed!!!");
            return false;
        }
    }

    public static boolean s(String str, long j) {
        w.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "removeFromSharedPreferences, key = %s, deviceId = %d", new Object[]{str, Long.valueOf(j)});
        if (bg.mA(str)) {
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            return false;
        }
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            return false;
        }
        b(sharedPreferences);
        String bZ = b.bZ(String.valueOf(j), sharedPreferences.getString(str, new String()));
        if (bZ == null) {
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove device from device list failed!!!");
            return false;
        }
        boolean commit;
        if (bZ.length() == 0) {
            commit = sharedPreferences.edit().remove(str).commit();
        } else {
            commit = sharedPreferences.edit().putString(str, bZ).commit();
        }
        if (commit) {
            w.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove from sharepreference successful, new device list is %s", new Object[]{bZ});
            return true;
        }
        w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit()");
        return false;
    }

    public static long[] vh(String str) {
        Exception exception;
        int i = 1;
        Object[] objArr = new Object[i];
        objArr[0] = str;
        w.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "getListFromSharedPreferences, key = %s", objArr);
        if (bg.mA(str)) {
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            return null;
        }
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            return null;
        }
        b(sharedPreferences);
        try {
            String[] split = sharedPreferences.getString(str, new String()).split("\\|");
            if (split == null || split.length == 0) {
                w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == strDeviceList || 0 == strDeviceList.length");
                return null;
            }
            long[] jArr = new long[split.length];
            int i2 = 0;
            for (String str2 : split) {
                try {
                    w.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "parse %s to long", new Object[]{str2});
                    if (str2.length() != 0) {
                        int i3 = i2 + 1;
                        try {
                            jArr[i2] = bg.getLong(str2, 0);
                            i2 = i3;
                        } catch (Exception e) {
                            Exception exception2 = e;
                            i2 = i3;
                            exception = exception2;
                            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "try pase string device id to long failed : " + exception.getMessage());
                        }
                    }
                } catch (Exception e2) {
                    exception = e2;
                    w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "try pase string device id to long failed : " + exception.getMessage());
                }
            }
            if (i2 == 0) {
                return null;
            }
            return jArr;
        } catch (Exception e3) {
            Object[] objArr2 = new Object[i];
            objArr2[0] = e3.getMessage();
            w.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "split failed!!!, %s", objArr2);
            return null;
        }
    }
}
