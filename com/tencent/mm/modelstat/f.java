package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public final class f {
    private final String fTq;
    private a hWe = null;

    public static class a {
        public String extraInfo = "";
        public int fEC = 0;
        public int hWf = 0;
        boolean hWg = false;
        public String ispName = "";
    }

    public f(String str) {
        this.fTq = str;
    }

    public final a JZ() {
        a aVar = null;
        if (this.hWe != null) {
            return this.hWe;
        }
        a aVar2;
        String str = this.fTq + "mobileinfo.ini";
        File file = new File(str);
        if (file.exists()) {
            com.tencent.mm.sdk.e.a aVar3 = new com.tencent.mm.sdk.e.a(str);
            aVar2 = new a();
            aVar2.hWf = bg.f(aVar3.Qq("ispCode"));
            aVar2.ispName = aVar3.getValue("ispName");
            aVar2.fEC = bg.f(aVar3.Qq("subType"));
            aVar2.extraInfo = aVar3.getValue("extraInfo");
            long lastModified = file.lastModified();
            if (10011 == r.iiW && r.iiX > 0) {
                lastModified = bg.Nz() - ((long) r.iiX);
                w.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", Integer.valueOf(r.iiX), Long.valueOf(lastModified));
                r.iiX = 0;
            }
            if (lastModified > 0 && bg.aA(lastModified) > 259200000) {
                w.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", Long.valueOf(bg.aA(lastModified)), str);
                aVar2.hWg = true;
            }
            w.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", Integer.valueOf(aVar2.fEC), Integer.valueOf(aVar2.hWf), aVar2.ispName, aVar2.extraInfo, Boolean.valueOf(aVar2.hWg));
        } else {
            w.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", str);
            aVar2 = null;
        }
        this.hWe = aVar2;
        if (this.hWe == null || this.hWe.hWg) {
            Context context = ab.getContext();
            if (context == null) {
                w.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
            } else {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    w.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        w.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
                    } else if (activeNetworkInfo.getType() == 1) {
                        w.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
                    } else {
                        aVar = new a();
                        aVar.fEC = activeNetworkInfo.getSubtype();
                        aVar.hWf = am.getISPCode(context);
                        aVar.ispName = am.getISPName(context);
                        aVar.extraInfo = activeNetworkInfo.getExtraInfo();
                        w.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", Integer.valueOf(aVar.fEC), Integer.valueOf(aVar.hWf), aVar.ispName, aVar.extraInfo);
                    }
                }
            }
            if (aVar == null) {
                w.v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
                return this.hWe;
            }
            this.hWe = aVar;
            aVar2 = this.hWe;
            if (aVar2 == null) {
                w.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
            } else if (bg.mA(str)) {
                w.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
            } else {
                com.tencent.mm.sdk.e.a aVar4 = new com.tencent.mm.sdk.e.a(str);
                aVar4.cC("ispCode", aVar2.hWf);
                aVar4.eC("ispName", aVar2.ispName);
                aVar4.cC("subType", aVar2.fEC);
                aVar4.eC("extraInfo", aVar2.extraInfo);
            }
            return this.hWe;
        }
        w.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
        return this.hWe;
    }
}
