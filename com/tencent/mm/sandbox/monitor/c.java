package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.b.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.b;
import com.tencent.mm.sandbox.updater.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public abstract class c implements b {
    public static final String upU = e.hgu;
    public int upV;
    public int upW;
    public int upX;
    public String upY;
    private boolean upZ = false;

    public c(int i, String str, int i2, boolean z) {
        this.upW = i;
        this.upY = str;
        this.upV = i2;
        this.upZ = z;
        this.upX = com.tencent.mm.a.e.aN(aLB());
        File file = new File(upU);
        if (!file.exists()) {
            file.mkdirs();
        }
        w.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + aLB() + " packOffset = " + this.upX);
    }

    public String aLB() {
        return upU + this.upY + ".temp";
    }

    public String bHM() {
        return upU + this.upY + ".apk";
    }

    public final void deleteTempFile() {
        try {
            w.d("MM.GetUpdatePack", "deleteTempFile");
            File file = new File(aLB());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            w.e("MM.GetUpdatePack", "error in deleteTempFile");
        }
    }

    public static boolean OW(String str) {
        if (com.tencent.mm.a.e.aO(upU + str + ".temp")) {
            return true;
        }
        return false;
    }

    public static String DE(String str) {
        Exception exception;
        g gVar;
        Object[] objArr;
        String str2 = upU + str + ".temp";
        String str3 = upU + str + ".apk";
        if (com.tencent.mm.a.e.aO(str2) && (a.ba(str2) || str.equalsIgnoreCase(com.tencent.mm.a.g.aV(str2)))) {
            com.tencent.mm.a.e.h(upU, str + ".temp", str + ".apk");
            return str3;
        }
        if (com.tencent.mm.a.e.aO(str3)) {
            if (a.ba(str3)) {
                w.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
                return str3;
            }
            try {
                str2 = com.tencent.mm.b.c.h(new File(str3));
                try {
                    if (bg.mA(str2)) {
                        g.oUh.a(322, 10, 1, false);
                        g.oUh.i(11098, Integer.valueOf(4010));
                    }
                } catch (Exception e) {
                    exception = e;
                    w.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + exception.getMessage());
                    g.oUh.a(322, 9, 1, false);
                    g.oUh.i(11098, Integer.valueOf(4009), exception.getMessage());
                    w.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", str2);
                    if (bg.mA(str2)) {
                        w.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", str2, i.bHY());
                        if (str2.equals(i.bHY())) {
                            w.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                            g.oUh.a(322, 11, 1, false);
                            gVar = g.oUh;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(4011);
                            objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                            gVar.i(11098, objArr);
                        } else {
                            w.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                            return str3;
                        }
                    } else if (str.equalsIgnoreCase(com.tencent.mm.a.g.aV(str3))) {
                        w.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                        return str3;
                    }
                    w.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
                    com.tencent.mm.loader.stub.b.deleteFile(str3);
                    return null;
                }
            } catch (Exception e2) {
                exception = e2;
                str2 = null;
                w.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + exception.getMessage());
                g.oUh.a(322, 9, 1, false);
                g.oUh.i(11098, Integer.valueOf(4009), exception.getMessage());
                w.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", str2);
                if (bg.mA(str2)) {
                    w.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", str2, i.bHY());
                    if (str2.equals(i.bHY())) {
                        w.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                        return str3;
                    }
                    w.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                    g.oUh.a(322, 11, 1, false);
                    gVar = g.oUh;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(4011);
                    objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                    gVar.i(11098, objArr);
                } else if (str.equalsIgnoreCase(com.tencent.mm.a.g.aV(str3))) {
                    w.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                    return str3;
                }
                w.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
                com.tencent.mm.loader.stub.b.deleteFile(str3);
                return null;
            }
            w.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", str2);
            if (bg.mA(str2)) {
                w.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", str2, i.bHY());
                if (str2.equals(i.bHY())) {
                    w.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                    return str3;
                }
                w.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                g.oUh.a(322, 11, 1, false);
                gVar = g.oUh;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4011);
                objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                gVar.i(11098, objArr);
            } else if (str.equalsIgnoreCase(com.tencent.mm.a.g.aV(str3))) {
                w.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                return str3;
            }
            w.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
            com.tencent.mm.loader.stub.b.deleteFile(str3);
        }
        return null;
    }

    public final boolean bHN() {
        if (!this.upZ || am.isWifi(ab.getContext())) {
            return false;
        }
        return true;
    }
}
