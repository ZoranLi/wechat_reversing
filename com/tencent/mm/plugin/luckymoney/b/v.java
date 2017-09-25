package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class v extends z {
    public int kAM;
    public String kAO;
    public String nmb;
    public String nmc;
    public String nmh;
    public ag nmx;
    public String nnA;
    public ag nnB;
    public ag nnC;
    public ag nnD;
    public int nnE = 0;
    public LinkedList<k> nnF;
    public String nnx;
    public boolean nny;
    public int nnz;

    public v(String str) {
        Map hashMap = new HashMap();
        hashMap.put("scene", "8");
        hashMap.put("ver", str);
        ap.yY();
        hashMap.put("walletType", String.valueOf(c.vr().get(339975, null)));
        x(hashMap);
    }

    public v(String str, byte b) {
        Map hashMap = new HashMap();
        hashMap.put("ver", str);
        ap.yY();
        hashMap.put("walletType", String.valueOf(c.vr().get(339975, null)));
        x(hashMap);
    }

    public final int getType() {
        return 1554;
    }

    public final String akf() {
        return "/cgi-bin/mmpay-bin/operationwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.nnz = jSONObject.optInt("randomAmount");
            this.nnx = jSONObject.optString("randomWishing");
            this.kAO = jSONObject.optString("notice");
            this.nnA = jSONObject.optString("notice_url");
            this.nny = jSONObject.optInt("hasCanShareHongBao") == 1;
            this.kAM = jSONObject.optInt("currency");
            this.nmb = jSONObject.optString("currencyUint");
            this.nmc = jSONObject.optString("currencyWording");
            w.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.kAM + ";currencyUint=" + this.nmb + ";currencyWording=" + this.nmc);
            c cVar = new c();
            cVar.nlV = jSONObject.optString("groupHint");
            cVar.nlW = jSONObject.optString("personalHint");
            cVar.nlU = ((double) jSONObject.optLong("totalAmount", 200000)) / 100.0d;
            cVar.nlT = jSONObject.optInt("totalNum", 100);
            cVar.nlX = ((double) jSONObject.optLong("perPersonMaxValue", 20000)) / 100.0d;
            cVar.nlY = ((double) jSONObject.optLong("perGroupMaxValue", 20000)) / 100.0d;
            cVar.nlZ = ((double) jSONObject.optLong("perMinValue", 1)) / 100.0d;
            cVar.nma = jSONObject.optInt("payShowBGFlag");
            cVar.kAM = this.kAM;
            cVar.nmb = this.nmb;
            cVar.nmc = this.nmc;
            a.aHG();
            d aHH = a.aHH();
            aHH.nmd = cVar;
            w.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + aHH.nmd.nlU + " maxTotalNum:" + aHH.nmd.nlT + " perGroupMaxValue:" + aHH.nmd.nlY + " perMinValue:" + aHH.nmd.nlZ + " perPersonMaxValue:" + aHH.nmd.nlX);
            try {
                String str2 = new String(aHH.nmd.toByteArray(), "ISO-8859-1");
                ap.yY();
                c.vr().set(356355, str2);
                ap.yY();
                c.vr().jY(true);
            } catch (UnsupportedEncodingException e) {
                w.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e.getLocalizedMessage());
            } catch (IOException e2) {
                w.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e2.getLocalizedMessage());
            }
            this.nnB = l.B(jSONObject.optJSONObject("operationHeader"));
            this.nmx = l.B(jSONObject.optJSONObject("operationTail"));
            this.nnC = l.B(jSONObject.optJSONObject("operationNext"));
            this.nnD = l.B(jSONObject.optJSONObject("operationMiddle"));
            int optInt = jSONObject.optInt("sceneSwitch");
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uAa, Integer.valueOf(optInt));
            w.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:" + optInt);
            this.nnE = jSONObject.optInt("scenePicSwitch");
            w.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.nnE);
            this.nmh = jSONObject.optString("wishing");
            w.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", new Object[]{this.nmh});
            JSONArray optJSONArray = jSONObject.optJSONArray("yearMess");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                w.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
                return;
            }
            w.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + optJSONArray.length());
            this.nnF = new LinkedList();
            for (optInt = 0; optInt < optJSONArray.length(); optInt++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(optInt);
                k kVar = new k();
                kVar.nmV = optJSONObject.optInt("yearAmount", 0);
                kVar.nmW = optJSONObject.optString("yearWish");
                this.nnF.add(kVar);
            }
            return;
        }
        w.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + i + ", errMsg:" + str);
    }
}
