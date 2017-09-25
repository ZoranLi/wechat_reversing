package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class WepkgCrossProcessTask extends BaseWepkgProcessTask {
    public static final Creator<WepkgCrossProcessTask> CREATOR = new Creator<WepkgCrossProcessTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WepkgCrossProcessTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgCrossProcessTask[i];
        }
    };
    public Runnable iMD;
    public int ou;
    public WepkgVersion sqr;
    public List<WepkgVersion> sqs;
    public WepkgPreloadFile sqt;
    public List<WepkgPreloadFile> squ;
    public String sqv;

    public WepkgCrossProcessTask() {
        this.ou = -1;
        this.sqr = new WepkgVersion();
        this.sqs = new ArrayList();
        this.sqt = new WepkgPreloadFile();
        this.squ = new ArrayList();
    }

    public WepkgCrossProcessTask(Parcel parcel) {
        f(parcel);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void PM() {
        /*
        r12 = this;
        r0 = 0;
        r11 = 3;
        r10 = 2;
        r2 = 0;
        r3 = 1;
        r1 = r12.ou;
        switch(r1) {
            case 1001: goto L_0x000e;
            case 2001: goto L_0x008e;
            case 2002: goto L_0x0116;
            case 2003: goto L_0x037c;
            case 2004: goto L_0x05ef;
            case 2005: goto L_0x0620;
            case 2006: goto L_0x0640;
            case 3001: goto L_0x0012;
            case 3002: goto L_0x0602;
            case 3003: goto L_0x002e;
            case 3004: goto L_0x0040;
            case 3005: goto L_0x005e;
            case 3006: goto L_0x0078;
            case 3007: goto L_0x062d;
            case 3008: goto L_0x0695;
            case 3009: goto L_0x06ea;
            case 4001: goto L_0x02b4;
            case 4002: goto L_0x035d;
            case 4003: goto L_0x05b8;
            case 4004: goto L_0x05cd;
            case 4005: goto L_0x0739;
            case 4006: goto L_0x07a1;
            default: goto L_0x000a;
        };
    L_0x000a:
        r12.vM();
        return;
    L_0x000e:
        r0 = r12;
    L_0x000f:
        r0.fDU = r3;
        goto L_0x000a;
    L_0x0012:
        r1 = r12.sqr;
        if (r1 == 0) goto L_0x000a;
    L_0x0016:
        r1 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r2 = r12.sqr;
        r2 = r2.sqL;
        r1 = r1.Kr(r2);
        if (r1 == 0) goto L_0x002b;
    L_0x0024:
        r0 = r12.sqr;
        r0.a(r1);
        r0 = r12;
        goto L_0x000f;
    L_0x002b:
        r12.sqr = r0;
        goto L_0x000a;
    L_0x002e:
        r0 = r12.sqr;
        if (r0 == 0) goto L_0x000a;
    L_0x0032:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r1 = r12.sqr;
        r1 = r1.sqL;
        r3 = r0.Kt(r1);
        r0 = r12;
        goto L_0x000f;
    L_0x0040:
        r0 = r12.sqr;
        if (r0 == 0) goto L_0x000a;
    L_0x0044:
        r1 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r0 = r12.sqr;
        r2 = r0.sqL;
        r0 = r12.sqr;
        r3 = r0.srb;
        r0 = r12.sqr;
        r4 = r0.srd;
        r0 = r12.sqr;
        r6 = r0.sre;
        r3 = r1.a(r2, r3, r4, r6);
        r0 = r12;
        goto L_0x000f;
    L_0x005e:
        r0 = r12.sqr;
        if (r0 == 0) goto L_0x000a;
    L_0x0062:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r1 = r12.sqr;
        r1 = r1.sqL;
        r2 = r12.sqr;
        r2 = r2.iAe;
        r3 = r12.sqr;
        r3 = r3.sri;
        r3 = r0.o(r1, r2, r3);
        r0 = r12;
        goto L_0x000f;
    L_0x0078:
        r0 = r12.sqr;
        if (r0 == 0) goto L_0x000a;
    L_0x007c:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r1 = r12.sqr;
        r1 = r1.sqL;
        r2 = r12.sqr;
        r2 = r2.srj;
        r3 = r0.aC(r1, r2);
        r0 = r12;
        goto L_0x000f;
    L_0x008e:
        r0 = r12.sqr;
        if (r0 == 0) goto L_0x00b4;
    L_0x0092:
        r0 = r12.sqr;
        r0 = r0.sqL;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x00b4;
    L_0x009c:
        r0 = r12.sqr;
        r0 = r0.sqL;
        r1 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r1.Kq(r0);
        r1 = com.tencent.mm.plugin.webview.wepkg.a.b.bAo();
        r1.Kq(r0);
        com.tencent.mm.plugin.webview.wepkg.model.g.KE(r0);
        r0 = r12;
        goto L_0x000f;
    L_0x00b4:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r1 = r0.rXW;
        if (r1 == 0) goto L_0x0108;
    L_0x00bc:
        r1 = "delete from %s";
        r4 = new java.lang.Object[r3];
        r5 = "WepkgVersion";
        r4[r2] = r5;
        r1 = java.lang.String.format(r1, r4);
        r4 = "WepkgVersion";
        r1 = r0.eE(r4, r1);
        r4 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r5 = "WepkgVersionRecord clearWepkg ret:%s";
        r6 = new java.lang.Object[r3];
        r1 = java.lang.Boolean.valueOf(r1);
        r6[r2] = r1;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        r1 = "delete from %s";
        r4 = new java.lang.Object[r3];
        r5 = "WepkgPreloadFiles";
        r4[r2] = r5;
        r1 = java.lang.String.format(r1, r4);
        r4 = "WepkgPreloadFiles";
        r0 = r0.eE(r4, r1);
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r4 = "WepkgPreloadFilesRecord clearWepkg ret:%s";
        r3 = new java.lang.Object[r3];
        r0 = java.lang.Boolean.valueOf(r0);
        r3[r2] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r4, r3);
    L_0x0108:
        r0 = com.tencent.mm.plugin.webview.wepkg.utils.d.vL();
        r1 = new com.tencent.mm.plugin.webview.wepkg.model.g$2;
        r1.<init>();
        r0.D(r1);
        goto L_0x000a;
    L_0x0116:
        r0 = r12.sqr;
        if (r0 == 0) goto L_0x000a;
    L_0x011a:
        r0 = r12.sqr;
        r0 = r0.sqL;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x000a;
    L_0x0124:
        r0 = r12.sqr;
        r0 = r0.sqL;
        r1 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r1.Kq(r0);
        r1 = com.tencent.mm.plugin.webview.wepkg.a.b.bAo();
        r1.Kq(r0);
        r0 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r1 = r12.sqr;
        r4 = new com.tencent.mm.plugin.webview.wepkg.a.c;
        r4.<init>();
        r5 = r1.sqL;
        r4.field_pkgId = r5;
        r5 = r1.appId;
        r4.field_appId = r5;
        r5 = r1.version;
        r4.field_version = r5;
        r5 = r1.iAe;
        r4.field_pkgPath = r5;
        r5 = r1.srb;
        r4.field_disableWvCache = r5;
        r6 = r1.srd;
        r4.field_clearPkgTime = r6;
        r6 = r1.sre;
        r4.field_checkIntervalTime = r6;
        r5 = r1.srf;
        r4.field_packMethod = r5;
        r5 = r1.gaj;
        r4.field_domain = r5;
        r5 = r1.fFW;
        r4.field_md5 = r5;
        r5 = r1.downloadUrl;
        r4.field_downloadUrl = r5;
        r5 = r1.srg;
        r4.field_pkgSize = r5;
        r5 = r1.sqy;
        r4.field_downloadNetType = r5;
        r6 = r1.srh;
        r4.field_nextCheckTime = r6;
        r6 = r1.iam;
        r4.field_createTime = r6;
        r5 = r1.charset;
        r4.field_charset = r5;
        r5 = r1.sri;
        r4.field_bigPackageReady = r5;
        r5 = r1.srj;
        r4.field_preloadFilesReady = r5;
        r5 = r1.srk;
        r4.field_preloadFilesAtomic = r5;
        r1 = r1.srl;
        r4.field_totalDownloadCount = r1;
        r1 = r0.rXW;
        if (r1 == 0) goto L_0x019d;
    L_0x0195:
        r1 = r4.field_pkgId;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x0229;
    L_0x019d:
        r0 = r12.squ;
        r0 = com.tencent.mm.sdk.platformtools.bg.bV(r0);
        if (r0 != 0) goto L_0x02b1;
    L_0x01a5:
        r0 = r12.squ;
        r1 = r0.iterator();
    L_0x01ab:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x02b1;
    L_0x01b1:
        r0 = r1.next();
        r0 = (com.tencent.mm.plugin.webview.wepkg.model.WepkgPreloadFile) r0;
        if (r0 == 0) goto L_0x01ab;
    L_0x01b9:
        r4 = com.tencent.mm.plugin.webview.wepkg.a.b.bAo();
        r5 = new com.tencent.mm.plugin.webview.wepkg.a.a;
        r5.<init>();
        r6 = r0.arH;
        r5.field_key = r6;
        r6 = r0.sqL;
        r5.field_pkgId = r6;
        r6 = r0.version;
        r5.field_version = r6;
        r6 = r0.filePath;
        r5.field_filePath = r6;
        r6 = r0.sqw;
        r5.field_rid = r6;
        r6 = r0.mimeType;
        r5.field_mimeType = r6;
        r6 = r0.fFW;
        r5.field_md5 = r6;
        r6 = r0.downloadUrl;
        r5.field_downloadUrl = r6;
        r6 = r0.size;
        r5.field_size = r6;
        r6 = r0.sqy;
        r5.field_downloadNetType = r6;
        r6 = r0.sqM;
        r5.field_completeDownload = r6;
        r6 = r0.iam;
        r5.field_createTime = r6;
        r0 = r4.rXW;
        if (r0 == 0) goto L_0x01ab;
    L_0x01f6:
        r0 = r5.field_pkgId;
        r6 = r5.field_rid;
        r0 = r4.dZ(r0, r6);
        if (r0 != 0) goto L_0x028d;
    L_0x0200:
        r6 = com.tencent.mm.plugin.webview.wepkg.utils.d.XH();
        r5.field_createTime = r6;
        r0 = r4.b(r5);
        r4 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r6 = "insertPreloadFile pkgid:%s, version:%s, rid:%s, ret:%s";
        r7 = 4;
        r7 = new java.lang.Object[r7];
        r8 = r5.field_pkgId;
        r7[r2] = r8;
        r8 = r5.field_version;
        r7[r3] = r8;
        r5 = r5.field_rid;
        r7[r10] = r5;
        r0 = java.lang.Boolean.valueOf(r0);
        r7[r11] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r4, r6, r7);
        goto L_0x01ab;
    L_0x0229:
        r1 = r4.field_pkgId;
        r1 = r0.Kr(r1);
        if (r1 != 0) goto L_0x0265;
    L_0x0231:
        r6 = com.tencent.mm.plugin.webview.wepkg.utils.d.XH();
        r8 = r4.field_checkIntervalTime;
        r6 = r6 + r8;
        r4.field_nextCheckTime = r6;
        r6 = com.tencent.mm.plugin.webview.wepkg.utils.d.XH();
        r4.field_createTime = r6;
        r6 = com.tencent.mm.plugin.webview.wepkg.utils.d.XH();
        r4.field_accessTime = r6;
        r0 = r0.b(r4);
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r5 = "insertPkgVersion pkgid:%s, version:%s, ret:%s";
        r6 = new java.lang.Object[r11];
        r7 = r4.field_pkgId;
        r6[r2] = r7;
        r4 = r4.field_version;
        r6[r3] = r4;
        r0 = java.lang.Boolean.valueOf(r0);
        r6[r10] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r5, r6);
        goto L_0x019d;
    L_0x0265:
        r6 = com.tencent.mm.plugin.webview.wepkg.utils.d.XH();
        r8 = r4.field_checkIntervalTime;
        r6 = r6 + r8;
        r4.field_nextCheckTime = r6;
        r0 = r0.a(r4);
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r5 = "replacePkgVersion pkgid:%s, version:%s, ret:%s";
        r6 = new java.lang.Object[r11];
        r7 = r4.field_pkgId;
        r6[r2] = r7;
        r4 = r4.field_version;
        r6[r3] = r4;
        r0 = java.lang.Boolean.valueOf(r0);
        r6[r10] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r5, r6);
        goto L_0x019d;
    L_0x028d:
        r0 = r4.a(r5);
        r4 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r6 = "relacePreloadFile pkgid:%s, version:%s, rid:%s, ret:%s";
        r7 = 4;
        r7 = new java.lang.Object[r7];
        r8 = r5.field_pkgId;
        r7[r2] = r8;
        r8 = r5.field_version;
        r7[r3] = r8;
        r5 = r5.field_rid;
        r7[r10] = r5;
        r0 = java.lang.Boolean.valueOf(r0);
        r7[r11] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r4, r6, r7);
        goto L_0x01ab;
    L_0x02b1:
        r0 = r12;
        goto L_0x000f;
    L_0x02b4:
        r1 = r12.sqr;
        if (r1 == 0) goto L_0x000a;
    L_0x02b8:
        r1 = r12.sqr;
        r1 = r1.sqL;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 != 0) goto L_0x000a;
    L_0x02c2:
        r1 = com.tencent.mm.plugin.webview.wepkg.a.b.bAo();
        r4 = r12.sqr;
        r4 = r4.sqL;
        r5 = r1.rXW;
        if (r5 != 0) goto L_0x02d9;
    L_0x02ce:
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r5 == 0) goto L_0x02d9;
    L_0x02d4:
        r12.squ = r0;
        r0 = r12;
        goto L_0x000f;
    L_0x02d9:
        r5 = "select * from %s where %s=? and %s=0";
        r6 = new java.lang.Object[r11];
        r7 = "WepkgPreloadFiles";
        r6[r2] = r7;
        r7 = "pkgId";
        r6[r3] = r7;
        r7 = "completeDownload";
        r6[r10] = r7;
        r5 = java.lang.String.format(r5, r6);
        r6 = new java.lang.String[r3];
        r6[r2] = r4;
        r1 = r1.rawQuery(r5, r6);
        r4 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r6 = "getNeedDownloadPreLoadFileList queryStr:%s";
        r7 = new java.lang.Object[r3];
        r7[r2] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r4, r6, r7);
        if (r1 != 0) goto L_0x0312;
    L_0x0308:
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r2 = "cursor is null";
        com.tencent.mm.sdk.platformtools.w.i(r1, r2);
        goto L_0x02d4;
    L_0x0312:
        r4 = r1.moveToFirst();
        if (r4 == 0) goto L_0x034f;
    L_0x0318:
        r0 = new java.util.ArrayList;
        r0.<init>();
    L_0x031d:
        r4 = new com.tencent.mm.plugin.webview.wepkg.model.WepkgPreloadFile;
        r4.<init>();
        r5 = new com.tencent.mm.plugin.webview.wepkg.a.a;
        r5.<init>();
        r5.b(r1);
        r4.a(r5);
        r0.add(r4);
        r4 = r1.moveToNext();
        if (r4 != 0) goto L_0x031d;
    L_0x0336:
        r1.close();
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r4 = "record list size:%s";
        r5 = new java.lang.Object[r3];
        r6 = r0.size();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r1, r4, r5);
        goto L_0x02d4;
    L_0x034f:
        r1.close();
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r2 = "no record";
        com.tencent.mm.sdk.platformtools.w.i(r1, r2);
        goto L_0x02d4;
    L_0x035d:
        r0 = r12.sqt;
        if (r0 == 0) goto L_0x000a;
    L_0x0361:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.b.bAo();
        r1 = r12.sqt;
        r1 = r1.sqL;
        r2 = r12.sqt;
        r2 = r2.sqw;
        r3 = r12.sqt;
        r3 = r3.filePath;
        r4 = r12.sqt;
        r4 = r4.sqM;
        r3 = r0.g(r1, r2, r3, r4);
        r0 = r12;
        goto L_0x000f;
    L_0x037c:
        r1 = r12.sqr;
        if (r1 == 0) goto L_0x000a;
    L_0x0380:
        r4 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r1 = r4.rXW;
        if (r1 != 0) goto L_0x0401;
    L_0x0388:
        r1 = r0;
    L_0x0389:
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r4 == 0) goto L_0x07f4;
    L_0x038f:
        r1 = com.tencent.mm.plugin.webview.wepkg.a.b.bAo();
        r4 = r1.rXW;
        if (r4 != 0) goto L_0x04ed;
    L_0x0397:
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r1 == 0) goto L_0x03fb;
    L_0x039d:
        r1 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r4 = r1.rXW;
        if (r4 == 0) goto L_0x03fb;
    L_0x03a5:
        r4 = "update %s set %s=0";
        r5 = new java.lang.Object[r10];
        r6 = "WepkgVersion";
        r5[r2] = r6;
        r6 = "autoDownloadCount";
        r5[r3] = r6;
        r4 = java.lang.String.format(r4, r5);
        r5 = "WepkgVersion";
        r4 = r1.eE(r5, r4);
        r5 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r6 = "WepkgVersionRecord resetAutoDownloadCount ret:%s";
        r7 = new java.lang.Object[r3];
        r4 = java.lang.Boolean.valueOf(r4);
        r7[r2] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r5, r6, r7);
        r4 = "update %s set %s=0";
        r5 = new java.lang.Object[r10];
        r6 = "WepkgPreloadFiles";
        r5[r2] = r6;
        r6 = "autoDownloadCount";
        r5[r3] = r6;
        r4 = java.lang.String.format(r4, r5);
        r5 = "WepkgPreloadFiles";
        r1 = r1.eE(r5, r4);
        r4 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r5 = "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s";
        r3 = new java.lang.Object[r3];
        r1 = java.lang.Boolean.valueOf(r1);
        r3[r2] = r1;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r3);
    L_0x03fb:
        r1 = r12.sqr;
        r1.sqL = r0;
        goto L_0x000a;
    L_0x0401:
        r1 = "select * from %s where %s=0 and %s=1 and %s<1 and %s<?";
        r5 = 5;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgVersion";
        r5[r2] = r6;
        r6 = "bigPackageReady";
        r5[r3] = r6;
        r6 = "preloadFilesAtomic";
        r5[r10] = r6;
        r6 = "autoDownloadCount";
        r5[r11] = r6;
        r6 = 4;
        r7 = "packageDownloadCount";
        r5[r6] = r7;
        r1 = java.lang.String.format(r1, r5);
        r5 = new java.lang.String[r3];
        r6 = "3";
        r5[r2] = r6;
        r5 = r4.rawQuery(r1, r5);
        if (r5 != 0) goto L_0x0435;
    L_0x0432:
        r1 = r0;
        goto L_0x0389;
    L_0x0435:
        r1 = r5.moveToFirst();
        if (r1 == 0) goto L_0x0471;
    L_0x043b:
        r1 = r5.getCount();
        if (r1 <= r3) goto L_0x07fa;
    L_0x0441:
        r1 = r1 + -1;
        r1 = com.tencent.mm.sdk.platformtools.bg.dM(r1, r2);
    L_0x0447:
        r5.move(r1);
        r1 = new com.tencent.mm.plugin.webview.wepkg.a.c;
        r1.<init>();
        r1.b(r5);
        r5.close();
        r5 = r1.field_pkgId;
        r4.Ku(r5);
        r4 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r5 = "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:true";
        r6 = new java.lang.Object[r10];
        r7 = r1.field_pkgId;
        r6[r2] = r7;
        r7 = r1.field_version;
        r6[r3] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        r1 = r1.field_pkgId;
        goto L_0x0389;
    L_0x0471:
        r5.close();
        r1 = "select * from %s where %s=0 and %s<1 and %s<?";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgVersion";
        r5[r2] = r6;
        r6 = "bigPackageReady";
        r5[r3] = r6;
        r6 = "autoDownloadCount";
        r5[r10] = r6;
        r6 = "packageDownloadCount";
        r5[r11] = r6;
        r1 = java.lang.String.format(r1, r5);
        r5 = new java.lang.String[r3];
        r6 = "3";
        r5[r2] = r6;
        r5 = r4.rawQuery(r1, r5);
        if (r5 != 0) goto L_0x04a2;
    L_0x049f:
        r1 = r0;
        goto L_0x0389;
    L_0x04a2:
        r1 = r5.moveToFirst();
        if (r1 == 0) goto L_0x04de;
    L_0x04a8:
        r1 = r5.getCount();
        if (r1 <= r3) goto L_0x07f7;
    L_0x04ae:
        r1 = r1 + -1;
        r1 = com.tencent.mm.sdk.platformtools.bg.dM(r1, r2);
    L_0x04b4:
        r5.move(r1);
        r1 = new com.tencent.mm.plugin.webview.wepkg.a.c;
        r1.<init>();
        r1.b(r5);
        r5.close();
        r5 = r1.field_pkgId;
        r4.Ku(r5);
        r4 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r5 = "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:false";
        r6 = new java.lang.Object[r10];
        r7 = r1.field_pkgId;
        r6[r2] = r7;
        r7 = r1.field_version;
        r6[r3] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        r1 = r1.field_pkgId;
        goto L_0x0389;
    L_0x04de:
        r5.close();
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r4 = "randomNeedDownloadPkgid no download record in DB";
        com.tencent.mm.sdk.platformtools.w.i(r1, r4);
        r1 = r0;
        goto L_0x0389;
    L_0x04ed:
        r4 = "select * from %s where %s=0 and %s<1 and %s<?";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgPreloadFiles";
        r5[r2] = r6;
        r6 = "completeDownload";
        r5[r3] = r6;
        r6 = "autoDownloadCount";
        r5[r10] = r6;
        r6 = "fileDownloadCount";
        r5[r11] = r6;
        r4 = java.lang.String.format(r4, r5);
        r5 = new java.lang.String[r3];
        r6 = "3";
        r5[r2] = r6;
        r4 = r1.rawQuery(r4, r5);
        if (r4 == 0) goto L_0x0397;
    L_0x0518:
        r5 = r4.moveToFirst();
        if (r5 == 0) goto L_0x05aa;
    L_0x051e:
        r0 = r4.getCount();
        if (r0 <= r3) goto L_0x07f1;
    L_0x0524:
        r0 = r0 + -1;
        r0 = com.tencent.mm.sdk.platformtools.bg.dM(r0, r2);
    L_0x052a:
        r4.move(r0);
        r0 = new com.tencent.mm.plugin.webview.wepkg.a.a;
        r0.<init>();
        r0.b(r4);
        r4.close();
        r4 = r0.field_pkgId;
        r5 = r0.field_rid;
        r6 = r1.rXW;
        if (r6 == 0) goto L_0x054c;
    L_0x0540:
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r6 != 0) goto L_0x054c;
    L_0x0546:
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
        if (r6 == 0) goto L_0x0567;
    L_0x054c:
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r4 = "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, rid:%s";
        r5 = new java.lang.Object[r11];
        r6 = r0.field_pkgId;
        r5[r2] = r6;
        r6 = r0.field_version;
        r5[r3] = r6;
        r6 = r0.field_rid;
        r5[r10] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r1, r4, r5);
        r0 = r0.field_pkgId;
        goto L_0x0397;
    L_0x0567:
        r6 = "update %s set %s=%s+1 where %s='%s' and %s='%s'";
        r7 = 7;
        r7 = new java.lang.Object[r7];
        r8 = "WepkgPreloadFiles";
        r7[r2] = r8;
        r8 = "autoDownloadCount";
        r7[r3] = r8;
        r8 = "autoDownloadCount";
        r7[r10] = r8;
        r8 = "pkgId";
        r7[r11] = r8;
        r8 = 4;
        r7[r8] = r4;
        r4 = 5;
        r8 = "rid";
        r7[r4] = r8;
        r4 = 6;
        r7[r4] = r5;
        r4 = java.lang.String.format(r6, r7);
        r5 = "WepkgPreloadFiles";
        r1 = r1.eE(r5, r4);
        r4 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r5 = "WepkgPreloadFilesRecord addAutoDownloadCount ret:%s";
        r6 = new java.lang.Object[r3];
        r1 = java.lang.Boolean.valueOf(r1);
        r6[r2] = r1;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        goto L_0x054c;
    L_0x05aa:
        r4.close();
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r4 = "randomNeedDownloadPkgid no download record in DB";
        com.tencent.mm.sdk.platformtools.w.i(r1, r4);
        goto L_0x0397;
    L_0x05b8:
        r0 = r12.sqr;
        if (r0 == 0) goto L_0x000a;
    L_0x05bc:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.b.bAo();
        r1 = r12.sqr;
        r1 = r1.sqL;
        r0 = r0.Kp(r1);
        r12.squ = r0;
        r0 = r12;
        goto L_0x000f;
    L_0x05cd:
        r1 = r12.sqt;
        if (r1 == 0) goto L_0x000a;
    L_0x05d1:
        r1 = com.tencent.mm.plugin.webview.wepkg.a.b.bAo();
        r2 = r12.sqt;
        r2 = r2.sqL;
        r4 = r12.sqt;
        r4 = r4.sqw;
        r1 = r1.dZ(r2, r4);
        if (r1 == 0) goto L_0x05eb;
    L_0x05e3:
        r0 = r12.sqt;
        r0.a(r1);
        r0 = r12;
        goto L_0x000f;
    L_0x05eb:
        r12.sqt = r0;
        goto L_0x000a;
    L_0x05ef:
        r0 = r12.sqr;
        if (r0 == 0) goto L_0x000a;
    L_0x05f3:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r1 = r12.sqr;
        r1 = r1.sqL;
        r3 = r0.Kv(r1);
        r0 = r12;
        goto L_0x000f;
    L_0x0602:
        r1 = r12.sqr;
        if (r1 == 0) goto L_0x000a;
    L_0x0606:
        r1 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r2 = r12.sqr;
        r2 = r2.sqL;
        r1 = r1.Ks(r2);
        if (r1 == 0) goto L_0x061c;
    L_0x0614:
        r0 = r12.sqr;
        r0.a(r1);
        r0 = r12;
        goto L_0x000f;
    L_0x061c:
        r12.sqr = r0;
        goto L_0x000a;
    L_0x0620:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r0 = r0.bAq();
        r12.sqs = r0;
        r0 = r12;
        goto L_0x000f;
    L_0x062d:
        r0 = r12.sqr;
        if (r0 == 0) goto L_0x000a;
    L_0x0631:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r1 = r12.sqr;
        r1 = r1.sqL;
        r3 = r0.Kw(r1);
        r0 = r12;
        goto L_0x000f;
    L_0x0640:
        r0 = r12.sqr;
        if (r0 == 0) goto L_0x000a;
    L_0x0644:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r1 = r12.sqr;
        r1 = r1.sqL;
        r4 = r0.rXW;
        if (r4 == 0) goto L_0x0656;
    L_0x0650:
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r4 == 0) goto L_0x065a;
    L_0x0656:
        r12.fDU = r2;
        goto L_0x000a;
    L_0x065a:
        r4 = "update %s set %s=%s+1 where %s='%s'";
        r5 = 5;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgVersion";
        r5[r2] = r6;
        r6 = "totalDownloadCount";
        r5[r3] = r6;
        r6 = "totalDownloadCount";
        r5[r10] = r6;
        r6 = "pkgId";
        r5[r11] = r6;
        r6 = 4;
        r5[r6] = r1;
        r1 = java.lang.String.format(r4, r5);
        r4 = "WepkgVersion";
        r0 = r0.eE(r4, r1);
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r4 = "WepkgVersionRecord addTotalDownloadCount ret:%s";
        r5 = new java.lang.Object[r3];
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r2] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r4, r5);
        r2 = r3;
        goto L_0x0656;
    L_0x0695:
        r0 = r12.sqr;
        if (r0 == 0) goto L_0x000a;
    L_0x0699:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r1 = r12.sqr;
        r1 = r1.sqL;
        r4 = r0.rXW;
        if (r4 == 0) goto L_0x06ab;
    L_0x06a5:
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r4 == 0) goto L_0x06b0;
    L_0x06ab:
        r3 = r2;
    L_0x06ac:
        r12.fDU = r3;
        goto L_0x000a;
    L_0x06b0:
        r4 = "update %s set %s=%s+1 where %s='%s'";
        r5 = 5;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgVersion";
        r5[r2] = r6;
        r6 = "packageDownloadCount";
        r5[r3] = r6;
        r6 = "packageDownloadCount";
        r5[r10] = r6;
        r6 = "pkgId";
        r5[r11] = r6;
        r6 = 4;
        r5[r6] = r1;
        r1 = java.lang.String.format(r4, r5);
        r4 = "WepkgVersion";
        r0 = r0.eE(r4, r1);
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r4 = "WepkgVersionRecord addPackageDownloadCount ret:%s";
        r5 = new java.lang.Object[r3];
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r2] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r4, r5);
        goto L_0x06ac;
    L_0x06ea:
        r0 = r12.sqr;
        if (r0 == 0) goto L_0x000a;
    L_0x06ee:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.d.bAp();
        r1 = r12.sqr;
        r1 = r1.sqL;
        r4 = r0.rXW;
        if (r4 == 0) goto L_0x0700;
    L_0x06fa:
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r4 == 0) goto L_0x0705;
    L_0x0700:
        r3 = r2;
    L_0x0701:
        r12.fDU = r3;
        goto L_0x000a;
    L_0x0705:
        r4 = "update %s set %s=0 where %s='%s'";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgVersion";
        r5[r2] = r6;
        r6 = "packageDownloadCount";
        r5[r3] = r6;
        r6 = "pkgId";
        r5[r10] = r6;
        r5[r11] = r1;
        r1 = java.lang.String.format(r4, r5);
        r4 = "WepkgVersion";
        r0 = r0.eE(r4, r1);
        r1 = "MicroMsg.Wepkg.WepkgVersionStorage";
        r4 = "WepkgVersionRecord resetPackageDownloadCount ret:%s";
        r5 = new java.lang.Object[r3];
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r2] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r4, r5);
        goto L_0x0701;
    L_0x0739:
        r0 = r12.sqt;
        if (r0 == 0) goto L_0x000a;
    L_0x073d:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.b.bAo();
        r1 = r12.sqt;
        r1 = r1.sqL;
        r4 = r12.sqt;
        r4 = r4.sqw;
        r5 = r0.rXW;
        if (r5 == 0) goto L_0x0759;
    L_0x074d:
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r5 != 0) goto L_0x0759;
    L_0x0753:
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r5 == 0) goto L_0x075e;
    L_0x0759:
        r3 = r2;
    L_0x075a:
        r12.fDU = r3;
        goto L_0x000a;
    L_0x075e:
        r5 = "update %s set %s=%s+1 where %s='%s' and %s='%s'";
        r6 = 7;
        r6 = new java.lang.Object[r6];
        r7 = "WepkgPreloadFiles";
        r6[r2] = r7;
        r7 = "fileDownloadCount";
        r6[r3] = r7;
        r7 = "fileDownloadCount";
        r6[r10] = r7;
        r7 = "pkgId";
        r6[r11] = r7;
        r7 = 4;
        r6[r7] = r1;
        r1 = 5;
        r7 = "rid";
        r6[r1] = r7;
        r1 = 6;
        r6[r1] = r4;
        r1 = java.lang.String.format(r5, r6);
        r4 = "WepkgPreloadFiles";
        r0 = r0.eE(r4, r1);
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r4 = "WepkgPreloadFilesRecord addFileDownloadCount ret:%s";
        r5 = new java.lang.Object[r3];
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r2] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r4, r5);
        goto L_0x075a;
    L_0x07a1:
        r0 = r12.sqt;
        if (r0 == 0) goto L_0x000a;
    L_0x07a5:
        r0 = com.tencent.mm.plugin.webview.wepkg.a.b.bAo();
        r1 = r12.sqt;
        r1 = r1.sqL;
        r4 = r0.rXW;
        if (r4 == 0) goto L_0x07b7;
    L_0x07b1:
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r4 == 0) goto L_0x07bb;
    L_0x07b7:
        r3 = r2;
        r0 = r12;
        goto L_0x000f;
    L_0x07bb:
        r4 = "update %s set %s=0 where %s='%s'";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r6 = "WepkgPreloadFiles";
        r5[r2] = r6;
        r6 = "fileDownloadCount";
        r5[r3] = r6;
        r6 = "pkgId";
        r5[r10] = r6;
        r5[r11] = r1;
        r1 = java.lang.String.format(r4, r5);
        r4 = "WepkgPreloadFiles";
        r0 = r0.eE(r4, r1);
        r1 = "MicroMsg.Wepkg.WepkgPreloadFilesStorage";
        r4 = "WepkgPreloadFilesRecord resetFileDownloadCount ret:%s";
        r5 = new java.lang.Object[r3];
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r2] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r4, r5);
        r0 = r12;
        goto L_0x000f;
    L_0x07f1:
        r0 = r2;
        goto L_0x052a;
    L_0x07f4:
        r0 = r1;
        goto L_0x0397;
    L_0x07f7:
        r1 = r2;
        goto L_0x04b4;
    L_0x07fa:
        r1 = r2;
        goto L_0x0447;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask.PM():void");
    }

    public final void SK() {
        if (this.iMD != null) {
            this.iMD.run();
        }
    }

    public final void k(Parcel parcel) {
        this.ou = parcel.readInt();
        this.sqr = (WepkgVersion) parcel.readParcelable(WepkgVersion.class.getClassLoader());
        if (this.sqs == null) {
            this.sqs = new ArrayList();
        }
        parcel.readList(this.sqs, WepkgVersion.class.getClassLoader());
        this.sqt = (WepkgPreloadFile) parcel.readParcelable(WepkgPreloadFile.class.getClassLoader());
        if (this.squ == null) {
            this.squ = new ArrayList();
        }
        parcel.readList(this.squ, WepkgPreloadFile.class.getClassLoader());
        this.sqv = parcel.readString();
    }

    public final void v(Parcel parcel, int i) {
        parcel.writeInt(this.ou);
        parcel.writeParcelable(this.sqr, i);
        parcel.writeList(this.sqs);
        parcel.writeParcelable(this.sqt, i);
        parcel.writeList(this.squ);
        parcel.writeString(this.sqv);
    }
}
