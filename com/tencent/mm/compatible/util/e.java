package com.tencent.mm.compatible.util;

import com.tencent.mm.loader.stub.a;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class e extends a {
    public static String gSA = (hgu + "vusericon/");
    public static String gSB = (hgu + "Game/");
    public static String gSC = (hgu + "CDNTemp/");
    public static String gSD = (hgu + "Download/VoiceRemind");
    public static String gSE = (hgu + "watchdog/");
    public static String gSF = (hgu + "xlog");
    public static String gSG = (hgu + "avatar/");
    public static String gSH = (hgu + "exdevice/");
    public static String gSI = (hgu + "newyear/");
    public static String gSJ = (hgu + "expose/");
    public static String gSK = (hgu + "f2flucky/");
    public static String gSL = (hgu + "WebviewCache/");
    public static String gSM = (hgu + "pattern_recognition/");
    public static String gSN = (hgu + "sniffer/");
    public static final String gSw = h.getExternalStorageDirectory().getParent();
    public static String gSx = (hgu + "Download/");
    public static String gSy;
    public static String gSz;

    public static void dw(String str) {
        w.i("MicroMsg.CConstants", "initSdCardPath start SDCARD_ROOT: " + hgs);
        if (bg.mA(str)) {
            int i;
            ArrayList bJC = av.bJC();
            int size = bJC.size();
            for (i = 0; i < size; i++) {
                w.i("MicroMsg.CConstants", "initSdCardPath start list i = " + i + " StatMountParse: " + bJC.get(i));
            }
            if (size > 1) {
                Collections.sort(bJC, new Comparator<av.a>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        av.a aVar = (av.a) obj;
                        av.a aVar2 = (av.a) obj2;
                        long j = (aVar.uvv * aVar.uvw) - (aVar2.uvv * aVar2.uvw);
                        if (j < 0) {
                            return 1;
                        }
                        return j > 0 ? -1 : 0;
                    }
                });
            }
            if (!(size <= 0 || bJC.get(0) == null || bg.mA(((av.a) bJC.get(0)).uvr))) {
                hgs = ((av.a) bJC.get(0)).uvr;
                for (i = 0; i < size; i++) {
                    w.i("MicroMsg.CConstants", "initSdCardPath end list i = " + i + " StatMountParse: " + bJC.get(i));
                }
            }
        } else {
            hgs = str;
        }
        hgu = hgs + hgt;
        gSx = hgu + "Download/";
        gSA = hgu + "vusericon/";
        gSB = hgu + "Game/";
        gSC = hgu + "CDNTemp/";
        gSE = hgu + "watchdog/";
        gSF = hgu + "xlog";
        hgv = hgu + "crash/";
        gSG = hgu + "avatar/";
        gSy = hgu + "Cache/";
        String str2 = hgu + "WeChat/";
        String str3 = hgu + "WeiXin/";
        if (com.tencent.mm.a.e.aO(str2) || !(com.tencent.mm.a.e.aO(str3) || v.bIN().equals("zh_CN"))) {
            str3 = str2;
        }
        gSz = str3;
        w.i("MicroMsg.CConstants", "initSdCardPath end SDCARD_ROOT: " + hgs);
    }
}
