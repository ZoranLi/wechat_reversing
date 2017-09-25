package com.tencent.mm.plugin.product.b;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.c;
import com.tencent.mm.plugin.product.c.e;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.n;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m {
    public n opA;
    public LinkedList<l> opB = new LinkedList();
    public f opC;
    public String opD;
    public String opE;
    public String opF;
    public String opv;
    public int opw;
    public int opx = Integer.MAX_VALUE;
    public int opy = Integer.MAX_VALUE;
    public c opz;
    public int status = 6;

    public static m a(m mVar, String str) {
        m mVar2;
        if (mVar == null) {
            mVar2 = new m();
        } else {
            mVar2 = mVar;
        }
        try {
            int length;
            int i;
            int i2;
            JSONArray optJSONArray;
            JSONObject jSONObject = new JSONObject(str);
            mVar2.opv = jSONObject.getString("product_id");
            mVar2.opw = jSONObject.getInt("product_type");
            mVar2.opx = jSONObject.optInt("quantity", Integer.MAX_VALUE);
            mVar2.opy = jSONObject.optInt("left_buy_quantity", Integer.MAX_VALUE);
            mVar2.status = jSONObject.optInt(DownloadInfo.STATUS, 6);
            JSONObject optJSONObject = jSONObject.optJSONObject("ext_attr");
            if (optJSONObject != null) {
                mVar2.opC = new f();
                optJSONObject = optJSONObject.optJSONObject("product_ext");
                if (optJSONObject != null) {
                    f fVar = mVar2.opC;
                    j jVar = new j();
                    jVar.fRW = optJSONObject.getInt("flag");
                    fVar.opZ = jVar;
                } else {
                    mVar2.opC.oqa = jSONObject.optString("ext_attr");
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("base_attr");
            if (optJSONObject2 != null) {
                JSONObject jSONObject2;
                mVar2.opz = new c();
                mVar2.opz.name = optJSONObject2.getString("name");
                mVar2.opz.opL = optJSONObject2.getInt("ori_price");
                mVar2.opz.opM = optJSONObject2.getInt("up_price");
                mVar2.opz.opN = optJSONObject2.getInt("low_price");
                mVar2.opz.opO = new LinkedList();
                JSONArray jSONArray = optJSONObject2.getJSONArray("img_info");
                length = jSONArray.length();
                for (i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    if (!bg.mA(string)) {
                        mVar2.opz.opO.add(string);
                    }
                }
                mVar2.opz.hku = optJSONObject2.getString("digest");
                mVar2.opz.oga = optJSONObject2.getString("fee_type");
                mVar2.opz.opP = optJSONObject2.getString("detail");
                optJSONObject = optJSONObject2.optJSONObject("share_info");
                if (optJSONObject != null) {
                    mVar2.opz.opX = new k();
                    mVar2.opz.opX.ofg = optJSONObject.optString("icon_url");
                    mVar2.opz.opX.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                }
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("sku_table");
                if (optJSONArray2 != null) {
                    mVar2.opz.opV = new LinkedList();
                    int length2 = optJSONArray2.length();
                    for (i = 0; i < length2; i++) {
                        jSONObject2 = optJSONArray2.getJSONObject(i);
                        com.tencent.mm.plugin.product.c.m mVar3 = new com.tencent.mm.plugin.product.c.m();
                        mVar3.oqh = jSONObject2.getString(SlookAirButtonFrequentContactAdapter.ID);
                        mVar3.oqi = jSONObject2.getString("name");
                        mVar3.oqj = new LinkedList();
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("value_list");
                        int length3 = jSONArray2.length();
                        for (i2 = 0; i2 < length3; i2++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                            h hVar = new h();
                            hVar.id = jSONObject3.getString(SlookAirButtonFrequentContactAdapter.ID);
                            hVar.name = jSONObject3.getString("name");
                            hVar.oqb = true;
                            mVar3.oqj.add(hVar);
                        }
                        mVar2.opz.opV.add(mVar3);
                    }
                }
                optJSONArray = optJSONObject2.optJSONArray("actiongroup_attr");
                if (optJSONArray != null) {
                    mVar2.opz.opW = new LinkedList();
                    length = optJSONArray.length();
                    for (i = 0; i < length; i++) {
                        jSONObject2 = optJSONArray.getJSONObject(i);
                        a aVar = new a();
                        aVar.msj = jSONObject2.getString("name");
                        aVar.jOc = 0;
                        if (!bg.mA(aVar.msj)) {
                            mVar2.opz.opW.add(aVar);
                        }
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("action_list");
                        int length4 = jSONArray3.length();
                        for (i2 = 0; i2 < length4; i2++) {
                            JSONObject jSONObject4 = jSONArray3.getJSONObject(i2);
                            a aVar2 = new a();
                            aVar2.msj = jSONObject4.getString("name");
                            aVar2.opH = jSONObject4.getString("tips");
                            aVar2.jOc = jSONObject4.getInt(Columns.TYPE);
                            aVar2.opI = jSONObject4.getString("content");
                            aVar2.muU = jSONObject4.getString("icon_url");
                            mVar2.opz.opW.add(aVar2);
                        }
                    }
                }
            }
            optJSONArray = jSONObject.optJSONArray("available_sku_list");
            if (optJSONArray != null) {
                length = optJSONArray.length();
                mVar2.opB = new LinkedList();
                for (i2 = 0; i2 < length; i2++) {
                    optJSONObject = optJSONArray.getJSONObject(i2);
                    l lVar = new l();
                    lVar.oqe = optJSONObject.getString("id_info");
                    lVar.oqf = optJSONObject.getInt("price");
                    lVar.opx = optJSONObject.getInt("quantity");
                    lVar.url = optJSONObject.getString("icon_url");
                    JSONArray jSONArray4 = optJSONObject.getJSONArray("express_fee");
                    int length5 = jSONArray4.length();
                    lVar.oqg = new LinkedList();
                    for (i = 0; i < length5; i++) {
                        JSONObject jSONObject5 = jSONArray4.getJSONObject(i);
                        e eVar = new e();
                        eVar.id = jSONObject5.getInt(SlookAirButtonFrequentContactAdapter.ID);
                        eVar.name = jSONObject5.getString("name");
                        eVar.value = jSONObject5.getInt("price");
                        lVar.oqg.add(eVar);
                    }
                    mVar2.opB.add(lVar);
                }
            }
            optJSONObject = jSONObject.optJSONObject("seller_attr");
            if (optJSONObject != null) {
                mVar2.opA = new n();
                mVar2.opA.fTO = optJSONObject.getString("appid");
                mVar2.opA.name = optJSONObject.getString("name");
                mVar2.opA.username = optJSONObject.getString("username");
                mVar2.opA.oqk = optJSONObject.optString("logo");
                mVar2.opA.fRW = optJSONObject.optInt("flag", 0);
            }
            optJSONObject = jSONObject.optJSONObject("oss_info");
            if (optJSONObject != null) {
                mVar2.opE = optJSONObject.optString("self_buy_button_word");
                mVar2.opF = optJSONObject.optString("product_mixed_h5_html");
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ProductInfo", e, "", new Object[0]);
        }
        return mVar2;
    }

    public static m b(m mVar, String str) {
        int i = 0;
        if (mVar == null) {
            mVar = new m();
        }
        Map q = bh.q(str, "mallProductInfo");
        if (q == null) {
            return null;
        }
        mVar.opv = bg.mz((String) q.get(".mallProductInfo.id"));
        mVar.opw = bg.getInt((String) q.get(".mallProductInfo.type"), 0);
        mVar.opz = new c();
        mVar.opz.name = bg.mz((String) q.get(".mallProductInfo.name"));
        mVar.opz.hku = bg.mz((String) q.get(".mallProductInfo.digest"));
        mVar.opz.opM = bg.getInt((String) q.get(".mallProductInfo.highPrice"), 0);
        mVar.opz.opN = bg.getInt((String) q.get(".mallProductInfo.lowPrice"), 0);
        mVar.opz.opL = bg.getInt((String) q.get(".mallProductInfo.originPrice"), 0);
        mVar.opD = bg.mz((String) q.get(".mallProductInfo.sourceUrl"));
        int i2 = bg.getInt((String) q.get(".mallProductInfo.imgCount"), 0);
        if (i2 > 0) {
            mVar.opz.opO = new LinkedList();
            while (i < i2) {
                String mz;
                if (i == 0) {
                    mz = bg.mz((String) q.get(".mallProductInfo.imgList.imgUrl"));
                } else {
                    mz = bg.mz((String) q.get(".mallProductInfo.imgList.imgUrl" + i));
                }
                if (!bg.mA(mz)) {
                    mVar.opz.opO.add(mz);
                }
                i++;
            }
        }
        mVar.opz.opX = new k();
        mVar.opz.opX.url = bg.mz((String) q.get(".mallProductInfo.shareInfo.shareUrl"));
        mVar.opz.opX.ofg = bg.mz((String) q.get(".mallProductInfo.shareInfo.shareThumbUrl"));
        mVar.opA = new n();
        mVar.opA.fTO = bg.mz((String) q.get(".mallProductInfo.sellerInfo.appID"));
        mVar.opA.name = bg.mz((String) q.get(".mallProductInfo.sellerInfo.appName"));
        mVar.opA.username = bg.mz((String) q.get(".mallProductInfo.sellerInfo.usrName"));
        return mVar;
    }

    public final String aTm() {
        if (this.opz != null && this.opz.opX != null && !bg.mA(this.opz.opX.ofg)) {
            return this.opz.opX.ofg;
        }
        if (this.opz == null || this.opz.opO == null || this.opz.opO.size() <= 0) {
            return null;
        }
        return (String) this.opz.opO.get(0);
    }
}
