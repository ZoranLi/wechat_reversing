package com.tencent.mm.plugin.order.model;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.f.a.h;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends h {
    public int kAx;
    private int nne;
    public List<i> ogE = null;
    public List<d> ogF = null;
    public String ogG;

    public e(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("Limit", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT);
        hashMap.put("Offset", String.valueOf(i));
        hashMap.put("Extbuf", str);
        x(hashMap);
    }

    public final int aki() {
        return MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        int i2 = 0;
        w.d("MicroMsg.NetScenePatchQueryUserRoll", "errCode " + i + " errMsg: " + str);
        this.ogE = new LinkedList();
        try {
            this.kAx = jSONObject.getInt("TotalNum");
            this.nne = jSONObject.getInt("RecNum");
            this.ogG = jSONObject.optString("Extbuf");
            JSONArray jSONArray = jSONObject.getJSONArray("UserRollList");
            if (jSONArray != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    i iVar = new i();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    iVar.ogR = jSONObject2.optInt("PayType");
                    iVar.ogJ = jSONObject2.optString("Transid");
                    iVar.ogK = jSONObject2.optDouble("TotalFee");
                    iVar.ogL = jSONObject2.optString("GoodsName");
                    iVar.ogM = jSONObject2.optInt("CreateTime");
                    iVar.ogO = jSONObject2.optInt("ModifyTime");
                    iVar.ogP = jSONObject2.optString("FeeType");
                    iVar.ogU = jSONObject2.optString("AppThumbUrl");
                    iVar.ogN = jSONObject2.optString("TradeStateName");
                    iVar.ogZ = jSONObject2.optString("StatusColor");
                    iVar.oha = jSONObject2.optString("FeeColor");
                    iVar.ohb = jSONObject2.optDouble("ActualPayFee");
                    iVar.ohc = jSONObject2.optString("BillId");
                    this.ogE.add(iVar);
                }
            }
            this.ogF = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("month_info");
            if (optJSONArray != null) {
                while (i2 < optJSONArray.length()) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                    d dVar = new d();
                    dVar.year = jSONObject3.optInt("year");
                    dVar.month = jSONObject3.optInt("month");
                    dVar.ogD = jSONObject3.optString("feetext");
                    this.ogF.add(dVar);
                    i2++;
                }
            }
        } catch (JSONException e) {
            w.e("MicroMsg.NetScenePatchQueryUserRoll", "Parse Json exp:" + e.getLocalizedMessage());
        }
    }
}
