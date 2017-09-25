package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;

final class dt extends c {
    String chatroomName;
    String desc;
    String designerName;
    String designerRediretctUrl;
    int designerUIN;
    String fGa;
    a fSU;
    String fUR;
    String fUS;
    String fZF;
    String gxD;
    String hjB;
    String iconUrl;
    int knu;
    int pageType;
    int position;
    long rXI;
    int rXJ;
    String secondUrl;
    int tid;
    String title;
    String userName;
    boolean vMX;
    String vMY;
    boolean vMZ;
    boolean vNa;
    String vNb;
    boolean vNc;
    String vNd;
    Bundle vNe;
    boolean vxp;

    public dt(au auVar, int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8) {
        this.fTk = auVar;
        this.vxp = false;
        this.position = i;
        this.userName = str;
        this.knu = 10;
        this.vMX = false;
        this.title = str2;
        this.fUR = str3;
        this.fUS = str4;
        this.vMY = str5;
        this.designerUIN = i2;
        this.designerName = str6;
        this.designerRediretctUrl = str7;
        this.gxD = str8;
    }

    public dt(au auVar, boolean z, int i, String str, int i2, boolean z2, String str2, String str3, String str4, String str5, String str6, String str7, boolean z3, boolean z4) {
        this.fTk = auVar;
        this.vxp = z;
        this.position = i;
        this.userName = str;
        this.knu = i2;
        this.vMX = z2;
        this.title = str2;
        this.fUR = str3;
        this.fUS = str4;
        this.vMY = str5;
        this.fGa = str6;
        this.gxD = str7;
        this.vMZ = z3;
        this.vNa = z4;
    }

    public dt(au auVar, boolean z, int i, String str, int i2, boolean z2, String str2, String str3, String str4, String str5) {
        this(auVar, z, i, str, i2, z2, str2, str3, str4, str5, null, null, false, false);
    }

    public dt(au auVar, boolean z, int i, String str, int i2, boolean z2, String str2, String str3, String str4) {
        this(auVar, z, i, str, i2, z2, str2, str3, str4, null);
    }

    private dt(au auVar, boolean z, int i, String str, int i2, boolean z2) {
        this(auVar, z, i, str, i2, false, null, null, null);
    }

    private dt(au auVar, boolean z, int i, String str, int i2) {
        this(auVar, z, i, str, i2, false);
    }

    public dt(au auVar, boolean z, int i, String str, int i2, byte b) {
        this(auVar, z, i, str, i2);
    }

    public dt(au auVar, boolean z, int i, String str, String str2) {
        this(auVar, z, i, str, 0);
        this.chatroomName = str2;
    }

    public dt(au auVar, String str, int i) {
        this(str, i);
        this.fTk = auVar;
    }

    private dt(String str, int i) {
        this.userName = str;
        this.knu = i;
    }

    public dt(String str, int i, String str2) {
        this.userName = str;
        this.knu = i;
        this.chatroomName = str2;
    }

    public dt(au auVar, String str, String str2) {
        this.fTk = auVar;
        this.userName = str;
        this.fTk = auVar;
        this.vNd = str2;
        this.knu = 6;
    }

    public static dt TF(String str) {
        dt dtVar = new dt();
        dtVar.knu = 7;
        dtVar.gxD = str;
        return dtVar;
    }

    public static dt a(a aVar, au auVar) {
        dt dtVar = new dt();
        dtVar.fSU = aVar;
        dtVar.fTk = auVar;
        return dtVar;
    }

    public static dt a(au auVar, boolean z, int i) {
        dt dtVar = new dt();
        dtVar.fTk = auVar;
        dtVar.vxp = z;
        dtVar.position = i;
        dtVar.knu = 0;
        dtVar.vNc = false;
        return dtVar;
    }
}
