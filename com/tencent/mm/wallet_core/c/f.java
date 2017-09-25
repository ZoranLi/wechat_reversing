package com.tencent.mm.wallet_core.c;

import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.f.a.h;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends h {
    public boolean fVM = true;
    private int wDW = 0;
    private a wDX = null;

    public interface a {
        void bvr();
    }

    private static void ak(Map<String, String> map) {
        ap.yY();
        String string = o.getString(c.uH());
        String deviceID = p.getDeviceID(ab.getContext());
        byte[] bArr = new byte[16];
        byte[] bytes = m.ccb().getBytes();
        if (bytes == null || bytes.length <= 0) {
            bytes = (System.currentTimeMillis()).getBytes();
        }
        int i = 0;
        int i2 = 0;
        do {
            bArr[i2] = bytes[i];
            i2++;
            i++;
            if (i >= bytes.length) {
                i = 0;
                continue;
            }
        } while (i2 < 16);
        String str = new String(bArr);
        String Pq = aa.Pq(string + deviceID);
        String Pq2 = aa.Pq(string + Pq + new String(bArr));
        w.i("MicroMsg.NetSceneGendigitalcert", "salt " + new String(bArr));
        w.i("MicroMsg.NetSceneGendigitalcert", "crt_csr uin: %s: devideid: %s crt: %s", new Object[]{string, deviceID, Pq2});
        String certApplyCSR = a.cbV().getCertApplyCSR(Pq2);
        try {
            map.put("sn_salt", com.tencent.mm.compatible.util.p.encode(str));
            map.put("crt_csr", com.tencent.mm.compatible.util.p.encode(certApplyCSR));
            map.put("crt_device_id", Pq);
            map.put("device_os", d.DEVICE_TYPE);
            map.put("device_name", d.sYJ);
        } catch (Exception e) {
        }
    }

    public f(String str, int i, String str2) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.wDW = 1;
        ak(hashMap);
        hashMap.put(Columns.TYPE, com.tencent.mm.compatible.util.p.encode("1"));
        hashMap.put("true_name", com.tencent.mm.compatible.util.p.encode(str2));
        hashMap.put("id_no", com.tencent.mm.compatible.util.p.encode(str));
        hashMap.put("id_type", com.tencent.mm.compatible.util.p.encode(String.valueOf(i)));
        x(hashMap);
        am(hashMap2);
    }

    public f(String str, String str2, a aVar, boolean z) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.fVM = z;
        this.wDW = 2;
        ak(hashMap);
        hashMap.put(Columns.TYPE, com.tencent.mm.compatible.util.p.encode("2"));
        hashMap.put("crt_sms", com.tencent.mm.compatible.util.p.encode(str));
        hashMap.put("reqkey", com.tencent.mm.compatible.util.p.encode(str2));
        this.wDX = aVar;
        x(hashMap);
        am(hashMap2);
    }

    public final int aki() {
        return 1580;
    }

    public final int zi() {
        return 1580;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/gendigitalcert";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        w.i("MicroMsg.NetSceneGendigitalcert", "errCode %d errMsg %s", new Object[]{Integer.valueOf(i), str});
        try {
            String optString = jSONObject.optString("crt_crt");
            String optString2 = jSONObject.optString("crt_no");
            g.oUh.a(414, 0, 1, true);
            boolean importCert = a.cbV().importCert(optString2, optString);
            q.UE(optString2);
            if (importCert) {
                g.oUh.a(414, 1, 1, true);
                w.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
            } else {
                g.oUh.a(414, 2, 1, true);
                w.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
            }
            if (this.wDW == 1) {
                g.oUh.i(13731, new Object[]{Integer.valueOf(3)});
            } else if (this.wDW == 2) {
                g.oUh.i(13731, new Object[]{Integer.valueOf(7)});
            }
            w.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", new Object[]{aa.Pq(optString), optString2});
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneGendigitalcert", e, "", new Object[0]);
        }
    }

    public final void a(c cVar, JSONObject jSONObject) {
        a.cbV().cbW();
        if (cVar.errCode != 0) {
            if (this.wDW == 1) {
                g.oUh.i(13731, new Object[]{Integer.valueOf(4)});
            } else if (this.wDW == 2) {
                g.oUh.i(13731, new Object[]{Integer.valueOf(8)});
            }
        }
        if (this.wDX == null) {
            return;
        }
        if (!this.fVM || cVar.errCode == 0) {
            this.wDX.bvr();
        }
    }

    public final boolean aQj() {
        return this.fVM;
    }
}
