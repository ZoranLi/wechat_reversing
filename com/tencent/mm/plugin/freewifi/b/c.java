package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.mm.e.a.es;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.protocal.c.akx;
import com.tencent.mm.protocal.c.aky;
import com.tencent.mm.protocal.c.akz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    public static final String[] lSH = new String[]{"ssid", "bssid", "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds"};
    private static final String[] lSI = new String[]{"errcode", "errmsg", "maxApCount", "intervalSeconds"};
    private int lSJ = m.CTRL_INDEX;
    private int lSK = 180;
    private long lSL = 0;

    private static class a {
        public static c lSQ = new c();
    }

    public static c awj() {
        return a.lSQ;
    }

    public final synchronized void a(final es esVar) {
        int i = 0;
        synchronized (this) {
            w.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + awk() + "; reqIntervalSeconds=" + awl());
            String[] strArr = esVar.fIR.fIT;
            if (strArr == null || strArr.length == 0) {
                a(esVar, 1101, "Args is empty.");
            } else {
                int i2;
                StringBuilder stringBuilder = new StringBuilder();
                for (i2 = 0; i2 < strArr.length; i2++) {
                    stringBuilder.append("args[" + i2 + "] = " + strArr[i2]);
                }
                w.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "args: " + stringBuilder.toString());
                try {
                    if (Integer.valueOf(strArr[0]).intValue() != 1) {
                        a(esVar, 1103, "Wechant installed currently only supports version 1.");
                    } else if (strArr.length != 3) {
                        a(esVar, 1104, "Args.length should be 3, but now it is " + strArr.length + ".");
                    } else {
                        try {
                            i2 = Integer.valueOf(strArr[2]).intValue();
                            if (i2 != 1 && i2 != 2) {
                                a(esVar, 1106, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
                            } else if (awm() != 0 && System.currentTimeMillis() - awm() < ((long) awl()) && i2 == 2) {
                                a(esVar, 1109, "Request frequence is out of limit. The time btween two background request should be more than  " + this.lSK + " seconds.");
                            } else if (com.tencent.mm.plugin.freewifi.m.wx(strArr[1])) {
                                a(esVar, 1105, "Args[1] should be an ap list json string, but now it is empty.");
                            } else {
                                final LinkedList linkedList = new LinkedList();
                                try {
                                    JSONArray jSONArray = new JSONArray(strArr[1]);
                                    if (jSONArray.length() > awk()) {
                                        a(esVar, 1110, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + awk() + ".");
                                    } else if (jSONArray.length() == 0) {
                                        a(esVar, 1110, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + awk() + ".");
                                    } else {
                                        while (i < jSONArray.length()) {
                                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                                            aky com_tencent_mm_protocal_c_aky = new aky();
                                            com_tencent_mm_protocal_c_aky.ssid = com.tencent.mm.plugin.freewifi.m.wy(jSONObject.getString("ssid"));
                                            com_tencent_mm_protocal_c_aky.bssid = jSONObject.getString("bssid");
                                            com_tencent_mm_protocal_c_aky.fIx = jSONObject.getInt("rssi");
                                            linkedList.add(com_tencent_mm_protocal_c_aky);
                                            i++;
                                        }
                                        new j(linkedList, i2).b(new e(this) {
                                            final /* synthetic */ c lSP;

                                            public final void a(int i, int i2, String str, k kVar) {
                                                Exception e;
                                                synchronized (this.lSP) {
                                                    akx awW = ((j) kVar).awW();
                                                    this.lSP.cm(System.currentTimeMillis());
                                                    this.lSP.mK(awW.lSK <= 0 ? 180 : awW.lSK);
                                                    w.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "resp.reqMaxApCount=" + awW.lSJ);
                                                    int i3 = awW.lSJ <= 0 ? m.CTRL_INDEX : awW.lSJ;
                                                    w.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "_reqMaxApCount = " + i3);
                                                    this.lSP.mJ(i3);
                                                    if (i == 0 && i2 == 0) {
                                                        LinkedList linkedList = awW.tOG;
                                                        MatrixCursor matrixCursor = null;
                                                        try {
                                                            MatrixCursor matrixCursor2 = new MatrixCursor(c.lSH);
                                                            try {
                                                                Map hashMap = new HashMap();
                                                                for (int i4 = 0; i4 < linkedList.size(); i4++) {
                                                                    akz com_tencent_mm_protocal_c_akz = (akz) linkedList.get(i4);
                                                                    hashMap.put(com_tencent_mm_protocal_c_akz.ssid + "-" + com_tencent_mm_protocal_c_akz.bssid, Integer.valueOf(i4));
                                                                }
                                                                for (int i5 = 0; i5 < linkedList.size(); i5++) {
                                                                    aky com_tencent_mm_protocal_c_aky = (aky) linkedList.get(i5);
                                                                    akz com_tencent_mm_protocal_c_akz2 = new akz();
                                                                    com_tencent_mm_protocal_c_akz2.ssid = com_tencent_mm_protocal_c_aky.ssid;
                                                                    com_tencent_mm_protocal_c_akz2.bssid = com_tencent_mm_protocal_c_aky.bssid;
                                                                    com_tencent_mm_protocal_c_akz2.fIx = com_tencent_mm_protocal_c_aky.fIx;
                                                                    com_tencent_mm_protocal_c_akz2.tOH = 0;
                                                                    com_tencent_mm_protocal_c_akz2.tOI = null;
                                                                    com_tencent_mm_protocal_c_akz2.lRB = 0;
                                                                    com_tencent_mm_protocal_c_akz2.fEN = null;
                                                                    if (hashMap.get(com_tencent_mm_protocal_c_akz2.ssid + "-" + com_tencent_mm_protocal_c_akz2.bssid) != null) {
                                                                        Integer num = (Integer) hashMap.get(com_tencent_mm_protocal_c_akz2.ssid + "-" + com_tencent_mm_protocal_c_akz2.bssid);
                                                                        if (linkedList.get(num.intValue()) != null) {
                                                                            com_tencent_mm_protocal_c_akz2.tOH = ((akz) linkedList.get(num.intValue())).tOH;
                                                                            com_tencent_mm_protocal_c_akz2.tOI = ((akz) linkedList.get(num.intValue())).tOI;
                                                                            com_tencent_mm_protocal_c_akz2.lRB = ((akz) linkedList.get(num.intValue())).lRB;
                                                                            com_tencent_mm_protocal_c_akz2.fEN = ((akz) linkedList.get(num.intValue())).fEN;
                                                                        }
                                                                    }
                                                                    if (com_tencent_mm_protocal_c_akz2.lRB == 4 || com_tencent_mm_protocal_c_akz2.lRB == 31) {
                                                                        matrixCursor2.addRow(new Object[]{com_tencent_mm_protocal_c_akz2.ssid, com_tencent_mm_protocal_c_akz2.bssid, Integer.valueOf(com_tencent_mm_protocal_c_akz2.fIx), Integer.valueOf(com_tencent_mm_protocal_c_akz2.tOH), com_tencent_mm_protocal_c_akz2.tOI, Integer.valueOf(this.lSP.awk()), Integer.valueOf(this.lSP.awl())});
                                                                        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[]{com_tencent_mm_protocal_c_akz2.ssid, com_tencent_mm_protocal_c_akz2.bssid, Integer.valueOf(com_tencent_mm_protocal_c_akz2.fIx), Integer.valueOf(com_tencent_mm_protocal_c_akz2.tOH), com_tencent_mm_protocal_c_akz2.tOI, Integer.valueOf(this.lSP.awk()), Integer.valueOf(this.lSP.awl())});
                                                                        if (com_tencent_mm_protocal_c_akz2.tOH == 1 && i2 == 1) {
                                                                            a.lSC.c(com_tencent_mm_protocal_c_akz2.ssid, com_tencent_mm_protocal_c_akz2.bssid, com_tencent_mm_protocal_c_akz2.fEN, com_tencent_mm_protocal_c_akz2.lRB);
                                                                            w.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cached : ssid=%s, bssid=%s, apKey=%s, protocolType=%d. ", new Object[]{com_tencent_mm_protocal_c_akz2.ssid, com_tencent_mm_protocal_c_akz2.bssid, com_tencent_mm_protocal_c_akz2.fEN, Integer.valueOf(com_tencent_mm_protocal_c_akz2.lRB)});
                                                                        }
                                                                    } else {
                                                                        matrixCursor2.addRow(new Object[]{com_tencent_mm_protocal_c_akz2.ssid, com_tencent_mm_protocal_c_akz2.bssid, Integer.valueOf(com_tencent_mm_protocal_c_akz2.fIx), Integer.valueOf(0), null, Integer.valueOf(this.lSP.awk()), Integer.valueOf(this.lSP.awl())});
                                                                        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", new Object[]{com_tencent_mm_protocal_c_akz2.ssid, com_tencent_mm_protocal_c_akz2.bssid, Integer.valueOf(com_tencent_mm_protocal_c_akz2.fIx), Integer.valueOf(0), null, Integer.valueOf(this.lSP.awk()), Integer.valueOf(this.lSP.awl())});
                                                                    }
                                                                }
                                                                c.a(esVar, matrixCursor2);
                                                            } catch (Exception e2) {
                                                                e = e2;
                                                                matrixCursor = matrixCursor2;
                                                            }
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            if (matrixCursor != null) {
                                                                matrixCursor.close();
                                                            }
                                                            w.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[]{e});
                                                            this.lSP.a(esVar, 1108, "cursor exception.");
                                                        }
                                                    } else if (i2 == -30035) {
                                                        this.lSP.a(esVar, 1110, "Too many ap. The number of ap requested per time should be between 1 and " + this.lSP.awk() + ".");
                                                    } else {
                                                        this.lSP.a(esVar, 1121, "Server returns errtype= " + i + ", errcode=" + i2 + ", errMsg=" + com.tencent.mm.plugin.freewifi.m.wz(str) + ".");
                                                    }
                                                }
                                            }
                                        });
                                    }
                                } catch (Exception e) {
                                    a(esVar, 1105, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
                                }
                            }
                        } catch (Exception e2) {
                            a(esVar, 1107, "Args[2] is not a valid int value.");
                        }
                    }
                } catch (Exception e3) {
                    a(esVar, 1102, "Args[0] is not an integer.");
                }
            }
        }
    }

    public final void a(es esVar, int i, String str) {
        Exception e;
        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setErrorResult. errorcode=%d, errmsg=%s", new Object[]{Integer.valueOf(i), str});
        MatrixCursor matrixCursor;
        try {
            matrixCursor = new MatrixCursor(lSI);
            try {
                matrixCursor.addRow(new Object[]{Integer.valueOf(i), str, Integer.valueOf(awk()), Integer.valueOf(awl())});
                esVar.fIS.fIU = matrixCursor;
                esVar.fIS.fIy = 1;
                if (esVar.nFq != null) {
                    esVar.nFq.run();
                }
            } catch (Exception e2) {
                e = e2;
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                w.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[]{e});
                esVar.fIS.fIU = null;
                esVar.fIS.fIy = 1;
                if (esVar.nFq != null) {
                    esVar.nFq.run();
                }
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            w.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[]{e});
            esVar.fIS.fIU = null;
            esVar.fIS.fIy = 1;
            if (esVar.nFq != null) {
                esVar.nFq.run();
            }
        }
    }

    public static void a(es esVar, MatrixCursor matrixCursor) {
        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setResult. errorcode=%d, errmsg=%s", new Object[]{Integer.valueOf(1), null});
        esVar.fIS.fIU = matrixCursor;
        esVar.fIS.fIy = 1;
        if (esVar.nFq != null) {
            esVar.nFq.run();
        }
    }

    public final synchronized int awk() {
        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.lSJ);
        return this.lSJ;
    }

    public final synchronized void mJ(int i) {
        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = " + i);
        this.lSJ = i;
        w.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.lSJ);
    }

    public final synchronized int awl() {
        return this.lSK;
    }

    public final synchronized void mK(int i) {
        this.lSK = i;
    }

    private synchronized long awm() {
        return this.lSL;
    }

    public final synchronized void cm(long j) {
        this.lSL = j;
    }
}
