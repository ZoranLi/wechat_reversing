package com.tencent.mm.plugin.report.service;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.a.c;
import com.tencent.mm.a.q;
import com.tencent.mm.bd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum g implements b {
    ;
    
    private long oUi;
    private int oUj;
    private HashMap<String, Long> oUk;
    private int oUl;
    private int oUm;
    private int uin;

    class AnonymousClass5 implements Runnable {
        SharedPreferences hgx;
        String host;
        final /* synthetic */ String hvV;
        final /* synthetic */ List iYk;
        final /* synthetic */ String lEC;
        final /* synthetic */ g oUo;
        final /* synthetic */ long oUr;
        final JSONArray oUs;

        public AnonymousClass5(g gVar, List list, String str, long j, String str2) {
            this.oUo = gVar;
            this.iYk = list;
            this.lEC = str;
            this.oUr = j;
            this.hvV = str2;
            this.oUs = new JSONArray();
            this.hgx = ab.getContext().getSharedPreferences("system_config_prefs", 0);
            this.host = this.hgx.getString("support.weixin.qq.com", "support.weixin.qq.com");
        }

        public final void run() {
            for (Map entrySet : this.iYk) {
                for (Entry entry : entrySet.entrySet()) {
                    w.i("MicroMsg.cLog", "[%s] %s", this.lEC, entry.getKey());
                    try {
                        JSONObject jSONObject;
                        Map map = (Map) entry.getValue();
                        if (map == null) {
                            jSONObject = new JSONObject();
                        } else {
                            jSONObject = new JSONObject(map);
                        }
                        jSONObject.put("tag", this.lEC).put("info", entry.getKey());
                        this.oUs.put(jSONObject);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "Failed to upload cLog.", new Object[0]);
                    }
                }
            }
            try {
                byte[] bytes = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", d.sYL).put("os_ver", d.DEVICE_TYPE).put("report_time", this.oUr).put("revision", bg.mz(e.REV))).put("items", this.oUs).toString().getBytes();
                String toLowerCase = com.tencent.mm.a.g.n(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.sYN), Integer.valueOf(bytes.length)}).getBytes()).toLowerCase();
                bytes = q.l(bytes);
                PByteArray pByteArray = new PByteArray();
                c.a(pByteArray, bytes, toLowerCase.getBytes());
                StringBuilder append = new StringBuilder(256).append("http://").append(this.host).append("/cgi-bin/mmsupport-bin/stackreport?version=0x26050D40&devicetype=").append(d.DEVICE_TYPE).append("&filelength=").append(r1).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=110");
                if (!(this.hvV == null || this.hvV.length() == 0)) {
                    append.append("&username=").append(this.hvV);
                }
                String stringBuilder = append.toString();
                HttpClient defaultHttpClient = new DefaultHttpClient();
                HttpUriRequest httpPost = new HttpPost(stringBuilder);
                HttpEntity byteArrayEntity = new ByteArrayEntity(pByteArray.value);
                byteArrayEntity.setContentType("binary/octet-stream");
                httpPost.setEntity(byteArrayEntity);
                w.i("MicroMsg.cLog", "POST returned: " + bg.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()));
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e2, "Failed to upload cLog.", new Object[0]);
            }
        }
    }

    private g(String str) {
        this.oUi = 0;
        if (ab.bJb()) {
            h.vL().D(new Runnable(this) {
                final /* synthetic */ g oUo;

                {
                    this.oUo = r1;
                }

                public final void run() {
                    g.a(this.oUo);
                }
            });
            h.vd().a(701, new com.tencent.mm.y.e(this) {
                final /* synthetic */ g oUo;

                {
                    this.oUo = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    if (i == 0) {
                        h.vL().e(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 oUp;

                            {
                                this.oUp = r1;
                            }

                            public final void run() {
                                new com.tencent.mm.plugin.report.b.g(this.oUp.oUo.oUl, this.oUp.oUo.oUm).a(h.vd().hsZ, new com.tencent.mm.y.e(this.oUp.oUo) {
                                    final /* synthetic */ g oUo;

                                    {
                                        this.oUo = r1;
                                    }

                                    public final void a(int i, int i2, String str, k kVar) {
                                        kVar.hsJ = true;
                                        if (i != 0) {
                                            w.e("MicroMsg.cLog", "NetScene failed, code=" + i2 + ", msg=" + str);
                                            return;
                                        }
                                        try {
                                            FileOp.k(ab.getContext().getFileStreamPath("clog-settings").getPath(), ((com.tencent.mm.plugin.report.b.g) kVar).oTv.toByteArray());
                                            h.vL().D(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass6 oUt;

                                                {
                                                    this.oUt = r1;
                                                }

                                                public final void run() {
                                                    g.a(this.oUt.oUo);
                                                }
                                            });
                                        } catch (Throwable e) {
                                            w.printErrStackTrace("MicroMsg.cLog", e, "Failed to parse response.", new Object[0]);
                                        }
                                    }
                                });
                            }
                        }, 5000);
                    }
                }
            });
        }
    }

    public static Object a(int i, int[] iArr, int i2, int i3) {
        return com.tencent.mm.plugin.report.c.a(i, iArr, i2, i3);
    }

    private static void h(int i, String str, boolean z) {
        KVReportDataInfo kVReportDataInfo = new KVReportDataInfo();
        kVReportDataInfo.oTT = (long) i;
        kVReportDataInfo.value = str;
        kVReportDataInfo.oTB = false;
        kVReportDataInfo.oTU = z;
        KVCommCrossProcessReceiver.a(kVReportDataInfo);
    }

    public final void A(int i, String str) {
        if (com.tencent.mm.plugin.report.a.c.oTe) {
            a(i, str, com.tencent.mm.plugin.report.a.c.oTf, com.tencent.mm.plugin.report.a.c.oTf);
        } else {
            a(i, str, false, false);
        }
    }

    public final void a(int i, String str, boolean z, boolean z2) {
        if (!ab.bJb()) {
            h(i, str, z);
        } else if (com.tencent.mm.plugin.report.a.c.oTe) {
            d.a((long) i, str, com.tencent.mm.plugin.report.a.c.oTf, com.tencent.mm.plugin.report.a.c.oTf);
        } else {
            d.a((long) i, str, z, false);
        }
    }

    public final void i(int i, Object... objArr) {
        if (com.tencent.mm.plugin.report.a.c.oTe) {
            a(i, com.tencent.mm.plugin.report.a.c.oTf, com.tencent.mm.plugin.report.a.c.oTf, objArr);
        } else {
            a(i, false, false, objArr);
        }
    }

    public final void a(int i, boolean z, boolean z2, Object... objArr) {
        String str;
        if (objArr == null || objArr.length <= 0) {
            w.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int length = objArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                stringBuilder.append(String.valueOf(objArr[i2]).replace(',', ' ')).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[length]));
            str = stringBuilder.toString();
        }
        if (com.tencent.mm.sdk.a.b.bIu()) {
            w.v("MicroMsg.ReportManagerKvCheck", "kvTypedStat id:%d [%b,%b] val:%s", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(false), str);
        }
        if (ab.bJb()) {
            d.a((long) i, str, z, false);
        } else {
            h(i, str, z);
        }
    }

    public final boolean b(int i, a aVar) {
        try {
            aVar.getClass().getField("import_ds_").setInt(aVar, Integer.MAX_VALUE);
            long Nz = bg.Nz();
            if (Nz / 86400 != this.oUi) {
                try {
                    this.oUj = bg.getInt(new SimpleDateFormat("yyyyMMdd").format(new Date()), 0);
                } catch (Exception e) {
                }
            }
            aVar.getClass().getField("ds_").setInt(aVar, this.oUj);
            aVar.getClass().getField("uin_").setLong(aVar, ((long) this.uin) & 4294967295L);
            aVar.getClass().getField("device_").setInt(aVar, 2);
            aVar.getClass().getField("clientVersion_").setInt(aVar, d.sYN);
            aVar.getClass().getField("time_stamp_").setLong(aVar, Nz);
            try {
                byte[] toByteArray = aVar.toByteArray();
                if (!ab.bJb()) {
                    w.f("MicroMsg.ReportManagerKvCheck", "not in MM Process");
                    return true;
                } else if (com.tencent.mm.plugin.report.a.c.oTe) {
                    d.a((long) i, toByteArray, com.tencent.mm.plugin.report.a.c.oTf, com.tencent.mm.plugin.report.a.c.oTf);
                    return true;
                } else {
                    d.a((long) i, toByteArray, false, false);
                    return true;
                }
            } catch (IOException e2) {
                w.e("MicroMsg.ReportManagerKvCheck", "pbKVStat LocalReportPb error, %d, %s", Integer.valueOf(i), e2.toString());
                return false;
            }
        } catch (Exception e3) {
            w.e("MicroMsg.ReportManagerKvCheck", "pbKVStat  set values error, %d, %s", Integer.valueOf(i), e3.toString());
            return false;
        }
    }

    public final void d(int i, List<String> list) {
        if (com.tencent.mm.plugin.report.a.c.oTe) {
            b(i, list, com.tencent.mm.plugin.report.a.c.oTf);
        } else {
            b(i, list, false);
        }
    }

    private static void b(int i, List<String> list, boolean z) {
        String str;
        if (list == null || list.isEmpty()) {
            w.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int size = list.size() - 1;
            for (int i2 = 0; i2 < size; i2++) {
                stringBuilder.append((String) list.get(i2)).append(',');
            }
            stringBuilder.append((String) list.get(size));
            str = stringBuilder.toString();
        }
        if (ab.bJb()) {
            d.a((long) i, str, z, false);
        } else {
            h(i, str, z);
        }
    }

    public final void a(long j, long j2, long j3, boolean z) {
        if (j < 0 || j2 < 0 || j3 <= 0) {
            w.e("MicroMsg.ReportManagerKvCheck", "ID %d, key %d, value %d <0", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
        } else if (ab.bJb()) {
            d.b(j, j2, j3, false);
        } else {
            StIDKeyDataInfo stIDKeyDataInfo = new StIDKeyDataInfo();
            stIDKeyDataInfo.oUv = j;
            stIDKeyDataInfo.key = j2;
            stIDKeyDataInfo.value = j3;
            stIDKeyDataInfo.oTB = false;
            KVCommCrossProcessReceiver.a(stIDKeyDataInfo);
        }
    }

    public final void b(ArrayList<IDKey> arrayList, boolean z) {
        if (arrayList == null) {
            w.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat lstIdKeyDataInfos == null return");
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey iDKey = (IDKey) it.next();
            if (iDKey == null) {
                w.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat info == null return");
                return;
            } else if (iDKey.GetID() < 0 || iDKey.GetKey() < 0) {
                w.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", Long.valueOf(iDKey.GetID()), Long.valueOf(iDKey.GetKey()), Long.valueOf(iDKey.GetValue()));
                return;
            } else if (iDKey.GetValue() <= 0) {
                w.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", Long.valueOf(iDKey.GetID()), Long.valueOf(iDKey.GetKey()), Long.valueOf(iDKey.GetValue()));
                return;
            }
        }
        if (ab.bJb()) {
            d.c(arrayList, false);
        } else {
            KVCommCrossProcessReceiver.O(arrayList);
        }
    }

    public final void n(int i, int i2, int i3, int i4) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i3);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i2);
        iDKey2.SetKey(i4);
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        b(arrayList, false);
    }

    public final void c(int i, int i2, int i3, int i4, boolean z) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i2);
        iDKey.SetValue(i4);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i);
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        b(arrayList, false);
    }

    public final void L(int i, int i2, int i3) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i2);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i);
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        b(arrayList, false);
    }

    public static void aXK() {
        if (ab.bJb()) {
            BaseEvent.onSingalCrash(0);
        } else {
            KVCommCrossProcessReceiver.aXD();
        }
    }

    public final void dk(String str, String str2) {
        d(str, str2, null);
    }

    public final void d(String str, String str2, Map<String, Object> map) {
        int uH;
        String str3;
        Long l;
        if (ab.bJb() && h.vG().uV()) {
            String str4;
            h.vG();
            uH = com.tencent.mm.kernel.a.uH();
            if (h.vI().vr() == null) {
                str4 = null;
            } else {
                str4 = m.xL();
            }
            str3 = str4;
        } else {
            str3 = null;
            uH = 0;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (this.oUk != null) {
            l = (Long) this.oUk.get(str);
        } else {
            l = null;
        }
        if (l != null) {
            byte[] o = com.tencent.mm.a.g.o((str + uH + SystemClock.uptimeMillis()).getBytes());
            if (o != null && o.length == 16) {
                if (((long) ((((o[15] + ((o[3] + o[7]) + o[11])) & 255) << 12) | ((((((o[0] + o[4]) + o[8]) + o[12]) & 255) | (((((o[1] + o[5]) + o[9]) + o[13]) & 255) << 4)) | (((((o[2] + o[6]) + o[10]) + o[14]) & 255) << 8)))) > l.longValue()) {
                    return;
                }
            }
        }
        final String str5 = str;
        final String str6 = str2;
        final Map<String, Object> map2 = map;
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ g oUo;

            public final void run() {
                w.e("MicroMsg.cLog", "[%s] %s", str5, str6);
                try {
                    JSONObject jSONObject;
                    String string = ab.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
                    if (map2 == null) {
                        jSONObject = new JSONObject();
                    } else {
                        jSONObject = new JSONObject(map2);
                    }
                    jSONObject.put("tag", str5).put("info", str6);
                    if (uH != 0) {
                        jSONObject.put(OpenSDKTool4Assistant.EXTRA_UIN, uH);
                    }
                    byte[] bytes = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", d.sYL).put("os_ver", d.DEVICE_TYPE).put("report_time", currentTimeMillis).put("revision", bg.mz(e.REV))).put("items", new JSONArray().put(jSONObject)).toString().getBytes();
                    String toLowerCase = com.tencent.mm.a.g.n(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.sYN), Integer.valueOf(bytes.length)}).getBytes()).toLowerCase();
                    bytes = q.l(bytes);
                    PByteArray pByteArray = new PByteArray();
                    c.a(pByteArray, bytes, toLowerCase.getBytes());
                    StringBuilder append = new StringBuilder(256).append("http://").append(string).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.sYN)).append("&devicetype=").append(d.DEVICE_TYPE).append("&filelength=").append(r2).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=110");
                    if (!(str3 == null || str3.length() == 0)) {
                        append.append("&username=").append(str3);
                    }
                    if (uH != 0) {
                        append.append("&uin=").append(uH);
                    }
                    String stringBuilder = append.toString();
                    HttpClient defaultHttpClient = new DefaultHttpClient();
                    HttpUriRequest httpPost = new HttpPost(stringBuilder);
                    HttpEntity byteArrayEntity = new ByteArrayEntity(pByteArray.value);
                    byteArrayEntity.setContentType("binary/octet-stream");
                    httpPost.setEntity(byteArrayEntity);
                    w.i("MicroMsg.cLog", "POST returned: " + bg.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "Failed to upload cLog.", new Object[0]);
                }
            }
        }, "ReportManager_cLog");
    }

    public static void i(String str, List<String> list) {
        w.i("MicroMsg.ReportManagerKvCheck", "cLogList %d", Integer.valueOf(list.size()));
        if (list.size() > 0) {
            final String xL = (ab.bJb() && h.vG().uV()) ? m.xL() : null;
            final long currentTimeMillis = System.currentTimeMillis();
            final List<String> list2 = list;
            final String str2 = str;
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                SharedPreferences hgx;
                String host;
                final JSONArray oUs;

                public final void run() {
                    for (String str : list2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            String str2;
                            jSONObject.put("tag", str2).put("info", str2);
                        } catch (JSONException e) {
                        }
                        this.oUs.put(jSONObject);
                    }
                    try {
                        byte[] bytes = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", d.sYL).put("os_ver", d.DEVICE_TYPE).put("report_time", currentTimeMillis).put("revision", bg.mz(e.REV))).put("items", this.oUs).toString().getBytes();
                        String toLowerCase = com.tencent.mm.a.g.n(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.sYN), Integer.valueOf(bytes.length)}).getBytes()).toLowerCase();
                        bytes = q.l(bytes);
                        PByteArray pByteArray = new PByteArray();
                        c.a(pByteArray, bytes, toLowerCase.getBytes());
                        StringBuilder append = new StringBuilder(256).append("http://").append(this.host).append("/cgi-bin/mmsupport-bin/stackreport?version=0x26050D40&devicetype=").append(d.DEVICE_TYPE).append("&filelength=").append(r1).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=110");
                        if (!(xL == null || xL.length() == 0)) {
                            append.append("&username=").append(xL);
                        }
                        str2 = append.toString();
                        HttpClient defaultHttpClient = new DefaultHttpClient();
                        HttpUriRequest httpPost = new HttpPost(str2);
                        HttpEntity byteArrayEntity = new ByteArrayEntity(pByteArray.value);
                        byteArrayEntity.setContentType("binary/octet-stream");
                        httpPost.setEntity(byteArrayEntity);
                        HttpResponse execute = defaultHttpClient.execute(httpPost);
                        HttpEntity entity = execute.getEntity();
                        int statusCode = execute.getStatusLine().getStatusCode();
                        String convertStreamToString = bg.convertStreamToString(entity.getContent());
                        w.i("MicroMsg.cLog", "POST code %d returned: %s", Integer.valueOf(statusCode), convertStreamToString);
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e2, "Failed to upload cLog.", new Object[0]);
                    }
                }
            }, "ReportManager_cLog");
        }
    }

    public final void dj(int i) {
        this.uin = i;
        SmcLogic.setUin((long) i);
    }
}
