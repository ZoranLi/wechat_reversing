package com.tencent.mm.plugin.exdevice.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.e.b.bp;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;

public final class c extends i<b> {
    public static final String[] gUx = new String[]{i.a(b.gTP, "HardDeviceInfo")};
    private e gUz;

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.e.c cVar) {
        b bVar = (b) cVar;
        if (bVar == null || bg.mA(bVar.field_brandName) || bg.mA(bVar.field_deviceID)) {
            w.w("MicroMsg.exdevice.HardDeviceInfoStorage", "wrong argument");
            return false;
        }
        w.i("MicroMsg.exdevice.HardDeviceInfoStorage", "replace: brandName=%s, deviceId=%s, ret=%s ", new Object[]{bVar.field_brandName, bVar.field_deviceID, Boolean.valueOf(this.gUz.replace("HardDeviceInfo", b.gTP.uxc, bVar.pv()) > 0)});
        return this.gUz.replace("HardDeviceInfo", b.gTP.uxc, bVar.pv()) > 0;
    }

    public c(e eVar) {
        super(eVar, b.gTP, "HardDeviceInfo", null);
        this.gUz = eVar;
        eVar.eE("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceUsernameIndex ON HardDeviceInfo ( brandName )");
        eVar.eE("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceMacIndex ON HardDeviceInfo ( mac )");
    }

    public final b vi(String str) {
        if (bg.mA(str)) {
            return null;
        }
        Cursor a = this.gUz.a("HardDeviceInfo", null, "mac=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            b bVar = new b();
            bVar.b(a);
            a.close();
            return bVar;
        }
        w.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:" + str);
        a.close();
        return null;
    }

    public final b bF(long j) {
        b bVar = null;
        Cursor query = this.gUz.query("HardDeviceInfo", null, "mac=?", new String[]{String.valueOf(j)}, null, null, null);
        if (query != null) {
            if (query.moveToFirst()) {
                bVar = new b();
                bVar.b(query);
            } else {
                w.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:" + j);
            }
            query.close();
        }
        return bVar;
    }

    public final b vj(String str) {
        if (bg.mA(str)) {
            return null;
        }
        Cursor a = this.gUz.a("HardDeviceInfo", null, "deviceID=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            b bVar = new b();
            bVar.b(a);
            a.close();
            return bVar;
        }
        w.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceId:" + str);
        a.close();
        return null;
    }

    public final b bT(String str, String str2) {
        if (bg.mA(str2) || bg.mA(str)) {
            w.e("MicroMsg.exdevice.HardDeviceInfoStorage", "deviceType(%s) or deviceId(%s) is null or nil.", new Object[]{str2, str});
            return null;
        }
        Cursor a = this.gUz.a("HardDeviceInfo", null, "deviceType=? and deviceID=?", new String[]{str2, str}, null, null, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            b bVar = new b();
            bVar.b(a);
            a.close();
            return bVar;
        }
        w.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceType:%s and deviceId:%s", new Object[]{str2, str});
        a.close();
        return null;
    }

    public static boolean vk(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.exdevice.HardDeviceInfoStorage", "Ability is null or nil.");
            return false;
        } else if (str.contains("wxmsg_music") || str.contains("wxmsg_poi") || str.contains("wxmsg_image") || str.contains("wxmsg_file") || str.contains("wxmsg_video") || str.contains("wxmsg_url")) {
            return true;
        } else {
            return false;
        }
    }

    public final List<b> apX() {
        List<b> linkedList = new LinkedList();
        Cursor Kk = Kk();
        if (Kk == null || !Kk.moveToFirst()) {
            if (Kk != null) {
                Kk.close();
            }
            return linkedList;
        }
        do {
            bp bVar = new b();
            bVar.b(Kk);
            String str = bVar.gtX;
            if (str != null && vk(str)) {
                linkedList.add(bVar);
            }
        } while (Kk.moveToNext());
        if (Kk != null) {
            Kk.close();
        }
        return linkedList;
    }

    public final List<b> apY() {
        List<b> linkedList = new LinkedList();
        Cursor Kk = Kk();
        if (Kk == null || !Kk.moveToFirst()) {
            if (Kk != null) {
                Kk.close();
            }
            return linkedList;
        }
        do {
            bp bVar = new b();
            bVar.b(Kk);
            String str = bVar.gtT;
            String str2 = bVar.iconUrl;
            String str3 = bVar.category;
            String str4 = bVar.field_brandName;
            if (!(bg.mA(str3) || str3.equals("1") || str3.equals("0") || bg.mA(str4) || bg.mA(str) || bg.mA(str2))) {
                linkedList.add(bVar);
            }
        } while (Kk.moveToNext());
        if (Kk != null) {
            Kk.close();
        }
        return linkedList;
    }

    public final b bU(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            w.e("MicroMsg.exdevice.HardDeviceInfoStorage", "brandName(%s) or deviceId(%s) is null or nil.", new Object[]{str, str2});
            return null;
        }
        Cursor a = this.gUz.a("HardDeviceInfo", null, "brandName=? and deviceID=?", new String[]{str, str2}, null, null, null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            b bVar = new b();
            bVar.b(a);
            a.close();
            return bVar;
        }
        w.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with brandName:" + str);
        a.close();
        return null;
    }

    public final LinkedList<b> vl(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.exdevice.HardDeviceInfoStorage", "The given brandName is null or nil.");
            return null;
        }
        LinkedList<b> linkedList = new LinkedList();
        Cursor a = this.gUz.a("HardDeviceInfo", null, "brandName=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            return linkedList;
        }
        if (a.moveToFirst()) {
            do {
                b bVar = new b();
                bVar.b(a);
                linkedList.add(bVar);
            } while (a.moveToNext());
        }
        a.close();
        return linkedList;
    }

    public final LinkedList<b> apZ() {
        LinkedList<b> linkedList = new LinkedList();
        Cursor rawQuery = rawQuery("select * from HardDeviceInfo where mac > 0 and connProto like '3'", new String[0]);
        if (rawQuery == null) {
            w.e("MicroMsg.exdevice.HardDeviceInfoStorage", "get cursor is null");
        } else {
            if (rawQuery.moveToFirst()) {
                do {
                    b bVar = new b();
                    bVar.b(rawQuery);
                    linkedList.add(bVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        return linkedList;
    }

    public final boolean bV(String str, String str2) {
        if (bg.mA(str)) {
            return false;
        }
        if (this.gUz.delete("HardDeviceInfo", "deviceID=? and deviceType=? ", new String[]{str, str2}) <= 0) {
            w.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo fail, deviceId = %s", new Object[]{str});
            return false;
        }
        w.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo ok, deviceId = %s", new Object[]{str});
        return true;
    }

    public final int e(b bVar) {
        int update;
        ContentValues pv = bVar.pv();
        if (pv.size() > 0) {
            update = this.gUz.update("HardDeviceInfo", pv, "deviceID = ? and deviceType = ? ", new String[]{bVar.field_deviceID, bVar.field_deviceType});
        } else {
            update = 0;
        }
        w.i("MicroMsg.exdevice.HardDeviceInfoStorage", "update: deviceId = %s, deviceType = %s, ret = %s ", new Object[]{bVar.field_deviceID, bVar.field_deviceType, Integer.valueOf(update)});
        return update;
    }
}
