package com.tencent.c.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.c.c.b.d;
import com.tencent.c.d.a.b;
import com.tencent.c.d.a.c;
import com.tencent.c.d.a.e;
import com.tencent.c.d.a.f;
import com.tencent.c.d.a.g;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public Context mContext = null;
    public b wQL;

    public a(Context context) {
        this.mContext = context;
        this.wQL = new b(context);
    }

    public static d cdE() {
        d dVar = new d();
        try {
            int i;
            dVar.wSc = Build.FINGERPRINT;
            dVar.wSd = com.tencent.c.e.d.cdM();
            dVar.hwe = Build.BRAND;
            dVar.model = Build.MODEL;
            dVar.wSe = VERSION.SDK_INT;
            dVar.wSf = Build.CPU_ABI;
            dVar.platform = com.tencent.c.e.d.Vh("ro.board.platform");
            if (f.cdI()) {
                i = 2;
            } else {
                Object obj;
                Object<com.tencent.c.d.b.d.a> cdJ = com.tencent.c.d.b.d.cdJ();
                if ((cdJ.isEmpty() ? 1 : null) == null) {
                    List<b> arrayList = new ArrayList(3);
                    arrayList.add(new g());
                    arrayList.add(new com.tencent.c.d.a.d());
                    if (com.tencent.c.d.b.f.cdK()) {
                        arrayList.add(new c());
                    }
                    for (com.tencent.c.d.b.d.a aVar : cdJ) {
                        if (aVar != null) {
                            for (b a : arrayList) {
                                a.a(aVar);
                            }
                        }
                    }
                    for (b cdG : arrayList) {
                        if (cdG.cdG()) {
                            obj = 1;
                            break;
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                    i = 2;
                } else if (e.cdH()) {
                    i = 1;
                } else {
                    if (!com.tencent.c.d.a.a.Vc("/system/bin/debuggerd")) {
                        obj = 1;
                    } else if (!com.tencent.c.d.a.a.Vc("/system/bin/debuggerd64")) {
                        i = 1;
                    } else if (!com.tencent.c.d.a.a.Vc("/system/bin/ddexe")) {
                        i = 1;
                    } else if (!com.tencent.c.d.a.a.Vd("/system/etc/install-recovery.sh")) {
                        i = 1;
                    } else if (com.tencent.c.d.a.a.Vd("/system/bin/install-recovery.sh")) {
                        com.tencent.c.e.g.Vi("BootScriptChecker : everything seems ok");
                        obj = null;
                    } else {
                        i = 1;
                    }
                    i = obj != null ? 1 : 0;
                }
            }
            dVar.czn = i;
        } catch (Exception e) {
        }
        return dVar;
    }

    public static com.tencent.c.c.b.b a(Context context, com.tencent.c.a.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        byte[] bArr;
        com.tencent.c.c.b.b bVar = new com.tencent.c.c.b.b();
        bVar.wRu = i;
        bVar.wRv = null;
        bVar.wRw = aVar.fwP;
        String str = aVar.wQI;
        if (str == null) {
            bArr = null;
        } else {
            int length = str.length() / 2;
            bArr = new byte[length];
            char[] toCharArray = str.toCharArray();
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) (((byte) "0123456789ABCDEF".indexOf(toCharArray[i3 + 1])) | (((byte) "0123456789ABCDEF".indexOf(toCharArray[i3])) << 4));
            }
        }
        bVar.wRx = bArr;
        List<byte[]> bt = com.tencent.c.e.a.bt(context, aVar.fwP);
        if (bt.size() > 1) {
            bVar.wRM = new ArrayList();
            for (byte[] bArr2 : bt) {
                bVar.wRM.add(bArr2);
            }
        }
        bVar.wRy = aVar.fileSize;
        bVar.wRz = aVar.wQH;
        bVar.wRA = aVar.versionCode;
        bVar.wRB = aVar.versionName;
        bVar.wRC = 0;
        if (aVar.moU == 1) {
            bVar.wRC |= 1;
        }
        bVar.wRC |= 2;
        if (!(aVar.wQJ.startsWith("/data") || aVar.wQJ.startsWith("/system"))) {
            bVar.wRC |= 4;
        }
        bVar.wRD = com.tencent.c.e.a.Vg(aVar.wQJ);
        bVar.wRE = 0;
        bVar.wRF = 0;
        bVar.wRG = 0;
        bVar.wRH = null;
        bVar.wRI = 0;
        bVar.wRJ = false;
        bVar.wRK = 0;
        bVar.wRL = 0;
        return bVar;
    }
}
