package com.tencent.mm.as;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetLocation;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.fts.d.a.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class g {
    public static String hPK = "";

    public static void j(int i, long j) {
        w.v("MicroMsg.FTS.FTSReportLogic", "reportIDKey: type=%d time=%d", Integer.valueOf(i), Long.valueOf(j));
        switch (i) {
            case 0:
            case 3:
            case 6:
            case 9:
            case 12:
                IDKey iDKey = new IDKey();
                iDKey.SetID(79);
                iDKey.SetKey(i + 1);
                iDKey.SetValue((int) j);
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(79);
                iDKey2.SetKey(i + 2);
                iDKey2.SetValue(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                com.tencent.mm.plugin.report.service.g.oUh.b(arrayList, false);
                return;
            default:
                return;
        }
    }

    public static void a(String str, boolean z, int i, int i2, boolean z2) {
        int i3;
        String format;
        switch (i2) {
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                i3 = 2;
                break;
            case 0:
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        String str2;
        Object[] objArr;
        if (z) {
            str2 = "%s,%s,%s,%s";
            objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(3);
            objArr[2] = Integer.valueOf(i3);
            if (z2) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            objArr[3] = Integer.valueOf(i3);
            format = String.format(str2, objArr);
        } else if (i > 0) {
            str2 = "%s,%s,%s,%s";
            objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(2);
            objArr[2] = Integer.valueOf(i3);
            if (z2) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            objArr[3] = Integer.valueOf(i3);
            format = String.format(str2, objArr);
        } else {
            str2 = "%s,%s,%s,%s";
            objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(1);
            objArr[2] = Integer.valueOf(i3);
            if (z2) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            objArr[3] = Integer.valueOf(i3);
            format = String.format(str2, objArr);
        }
        w.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", Integer.valueOf(11062), format);
        com.tencent.mm.plugin.report.service.g.oUh.A(11062, format);
    }

    public static void a(a aVar, h hVar) {
        int i;
        int i2;
        String str;
        int i3 = aVar.mdf;
        int i4 = aVar.mdg;
        String str2 = aVar.mdh;
        long j = aVar.mdi;
        int f = f(aVar.mdk, aVar.mdl, aVar.ayg());
        if (aVar.mde == -8) {
            i = 2;
            i2 = 1;
        } else {
            switch (aVar.knu) {
                case 1:
                    i = 3;
                    i2 = 1;
                    break;
                case 2:
                    i = 4;
                    i2 = 1;
                    break;
                case 3:
                    i = 10;
                    i2 = 1;
                    break;
                case 4:
                    i = 5;
                    i2 = 1;
                    break;
                case 5:
                    i = 16;
                    i2 = 1;
                    break;
                case 6:
                    i = 11;
                    i2 = 1;
                    break;
                case 7:
                    i = 12;
                    i2 = 1;
                    break;
                case 8:
                    i = 13;
                    i2 = 1;
                    break;
                case 9:
                    i = 14;
                    i2 = 1;
                    break;
                case 10:
                    if (!aVar.mdj) {
                        i = 9;
                        i2 = 1;
                        break;
                    }
                    i = 8;
                    i2 = 1;
                    break;
                case 12:
                    i2 = 2;
                    if (aVar.mde == -5) {
                        i = 16;
                        break;
                    } else if (aVar.mde == -3) {
                        i = 4;
                        break;
                    } else if (aVar.mde == -4) {
                        i = 3;
                        break;
                    } else if (aVar.mde == -1) {
                        i = 12;
                        break;
                    } else if (aVar.mde == -2) {
                        i = 11;
                        break;
                    } else {
                        return;
                    }
                case 13:
                    i = 17;
                    i2 = 1;
                    break;
                case 14:
                    i = 15;
                    i2 = 1;
                    break;
                case 16:
                    d dVar = new d();
                    str = aVar.fRM;
                    if (str != null) {
                        str = str.replaceAll(",", " ");
                    }
                    dVar.n("20KeyWordId", str + ",");
                    dVar.n("21ViewType", "1,");
                    dVar.n("22OpType", "2,");
                    dVar.n("23ResultCount", ",");
                    dVar.n("24ClickPos", aVar.mdg + ",");
                    dVar.n("25ClickAppUserName", aVar.info + ",");
                    w.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", dVar.JG());
                    com.tencent.mm.plugin.report.service.g.oUh.i(13963, dVar);
                    i2 = 1;
                    i = 19;
                    break;
                case 17:
                    i = 20;
                    i2 = 1;
                    break;
                default:
                    return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis() - hVar.hPk;
        if (currentTimeMillis < 0 || hVar.hPk == 0) {
            currentTimeMillis = 0;
        }
        w.v("MicroMsg.FTS.FTSReportLogic", "report home page click: %d, %s", Integer.valueOf(10991), String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(aVar.mcx), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4), bg.ap(str2, ""), Long.valueOf(j), Integer.valueOf(f), Integer.valueOf(0), Integer.valueOf(aVar.Su()), Integer.valueOf(go(aVar.ayf())), aVar.St(), Long.valueOf(currentTimeMillis), Integer.valueOf(hVar.hPM), Integer.valueOf(hVar.hPN), Integer.valueOf(hVar.hPO), Integer.valueOf(hVar.hPP), Integer.valueOf(hVar.hPQ), Integer.valueOf(hVar.hPR), Integer.valueOf(hVar.hPS), Integer.valueOf(hVar.hPT), Integer.valueOf(hVar.hPU), hPK}));
        com.tencent.mm.plugin.report.service.g.oUh.A(10991, str);
    }

    public static final int f(int i, int i2, boolean z) {
        if (z) {
            return 15;
        }
        if (i == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            switch (i2) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 11:
                    return 8;
                case 15:
                    return 16;
                case 16:
                    return 10;
                case 17:
                case 18:
                    return 9;
                default:
                    return 0;
            }
        } else if (i == 131075) {
            switch (i2) {
                case 1:
                case 5:
                    return 12;
                case 2:
                case 6:
                    return 13;
                case 3:
                case 7:
                    return 14;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                case 30:
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                case 32:
                case 34:
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                case 36:
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                case 38:
                    return 11;
                default:
                    return 0;
            }
        } else if (i == 65536) {
            return 17;
        } else {
            return 0;
        }
    }

    private static int go(int i) {
        switch (i) {
            case JsApiChooseImage.CTRL_INDEX /*29*/:
                return 1;
            case 30:
                return 2;
            case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                return 3;
            case 32:
                return 4;
            case 34:
                return 5;
            case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
            case 36:
                return 6;
            case JsApiGetLocation.CTRL_INDEX /*37*/:
                return 16;
            default:
                return 0;
        }
    }

    public static void a(a aVar, c cVar) {
        int i;
        String str;
        int i2 = aVar.mdf;
        String str2 = aVar.mdh;
        long j = aVar.mdi;
        int f = f(aVar.mdk, aVar.mdl, aVar.ayg());
        switch (aVar.knu) {
            case 1:
                i = 3;
                break;
            case 2:
                i = 4;
                break;
            case 3:
                i = 10;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 16;
                break;
            case 6:
                i = 11;
                break;
            case 7:
                i = 12;
                break;
            case 8:
                i = 13;
                break;
            case 9:
                i = 14;
                break;
            case 13:
                i = 17;
                break;
            case 14:
                i = 15;
                break;
            case 16:
                d dVar = new d();
                str = aVar.fRM;
                if (str != null) {
                    str = str.replaceAll(",", " ");
                }
                dVar.n("20KeyWordId", str + ",");
                dVar.n("21ViewType", "2,");
                dVar.n("22OpType", "2,");
                dVar.n("23ResultCount", ",");
                dVar.n("24ClickPos", aVar.mdg + ",");
                dVar.n("25ClickAppUserName", aVar.info + ",");
                w.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", dVar.JG());
                com.tencent.mm.plugin.report.service.g.oUh.i(13963, dVar);
                i = 19;
                break;
            case 17:
                i = 20;
                break;
            default:
                return;
        }
        long currentTimeMillis = System.currentTimeMillis() - cVar.hPk;
        if (currentTimeMillis < 0 || cVar.hPk == 0) {
            currentTimeMillis = 0;
        }
        w.v("MicroMsg.FTS.FTSReportLogic", "report detail page click: %s", String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(aVar.mcx), Integer.valueOf(i), Integer.valueOf(i2), bg.ap(str2, ""), Long.valueOf(j), Integer.valueOf(f), Integer.valueOf(aVar.Su()), Integer.valueOf(go(aVar.ayf())), aVar.St(), Long.valueOf(currentTimeMillis), Integer.valueOf(cVar.hPl)}));
        com.tencent.mm.plugin.report.service.g.oUh.A(11310, str);
    }

    public static final void gp(int i) {
        w.v("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick:%d %s", Integer.valueOf(10991), String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)}));
        com.tencent.mm.plugin.report.service.g.oUh.A(10991, r0);
    }

    public static final void bm(boolean z) {
        int i;
        int i2 = 1;
        String str = "MicroMsg.FTS.FTSReportLogic";
        String str2 = "reportFTSCreateChatroom: %d %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(13970);
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        w.v(str, str2, objArr);
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
        Object[] objArr2 = new Object[1];
        if (!z) {
            i2 = 0;
        }
        objArr2[0] = Integer.valueOf(i2);
        gVar.i(13970, objArr2);
    }
}
