package com.tencent.mm.plugin.order.model;

import android.text.TextUtils;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends com.tencent.mm.wallet_core.f.a.h {
    public MallOrderDetailObject ogH;
    private int ogI;

    public h(String str) {
        this(str, null, -1);
    }

    public h(String str, String str2) {
        this(str, str2, -1);
    }

    public h(String str, String str2, int i) {
        this.ogH = null;
        this.ogI = -1;
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        if (!bg.mA(str2)) {
            hashMap.put("bill_id", str2);
        }
        if (this.ogI >= 0) {
            this.ogI = i;
        }
        x(hashMap);
    }

    public final int aki() {
        return 108;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ogH = new MallOrderDetailObject();
            MallOrderDetailObject mallOrderDetailObject = this.ogH;
            if (jSONObject != null) {
                try {
                    mallOrderDetailObject.ofw = MallTransactionObject.G(jSONObject);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MallOrderDetailObject", e, "", new Object[0]);
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2, "", new Object[0]);
                }
                try {
                    b bVar;
                    JSONObject jSONObject2 = jSONObject.getJSONObject("status_section");
                    if (jSONObject2 != null) {
                        bVar = new b();
                        bVar.ofF = jSONObject2.optString("last_status_name");
                        bVar.cIm = jSONObject2.optInt("time");
                        bVar.thumbUrl = jSONObject2.optString("thumb_url");
                        bVar.msF = jSONObject2.optString("jump_url");
                        bVar.ofG = jSONObject2.optString("last_status_desc");
                    } else {
                        bVar = null;
                    }
                    mallOrderDetailObject.ofx = bVar;
                } catch (Throwable e22) {
                    w.printErrStackTrace("MicroMsg.MallOrderDetailObject", e22, "", new Object[0]);
                } catch (Throwable e222) {
                    w.printErrStackTrace("MicroMsg.MallOrderDetailObject", e222, "", new Object[0]);
                }
                try {
                    mallOrderDetailObject.ofy = MallOrderDetailObject.E(jSONObject);
                } catch (Throwable e2222) {
                    w.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2222, "", new Object[0]);
                } catch (Throwable e22222) {
                    w.printErrStackTrace("MicroMsg.MallOrderDetailObject", e22222, "", new Object[0]);
                }
                try {
                    List list;
                    int i2;
                    JSONArray jSONArray = jSONObject.getJSONArray("normal_sections");
                    if (jSONArray == null || jSONArray.length() == 0) {
                        list = null;
                    } else {
                        List arrayList = new ArrayList();
                        i2 = 0;
                        boolean z = false;
                        while (i2 < jSONArray.length()) {
                            boolean z2;
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                            a aVar = new a();
                            aVar.kdT = jSONObject3.optInt("is_bar") != 0;
                            aVar.name = jSONObject3.optString("name");
                            if (TextUtils.isEmpty(aVar.name)) {
                                z2 = aVar.kdT;
                            } else {
                                if (z) {
                                    aVar.kdT = z;
                                }
                                z2 = aVar.kdT;
                                aVar.value = jSONObject3.optString(Columns.VALUE);
                                aVar.jumpUrl = jSONObject3.optString("jump_url");
                                aVar.jumpType = jSONObject3.optInt("jump_type");
                                arrayList.add(aVar);
                            }
                            i2++;
                            z = z2;
                        }
                        list = arrayList;
                    }
                    mallOrderDetailObject.ofz = list;
                    list = mallOrderDetailObject.ofz;
                    JSONObject optJSONObject = jSONObject.optJSONObject("evaluate_section");
                    if (optJSONObject != null) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        a aVar2 = new a();
                        if (optJSONObject.has(Columns.VALUE)) {
                            aVar2.value = optJSONObject.optString(Columns.VALUE);
                            aVar2.type = 2;
                        } else {
                            aVar2.type = 1;
                        }
                        i2 = optJSONObject.optInt("order", 0);
                        if (i2 >= 0 && i2 <= optJSONObject.length() + 1) {
                            list.add(i2, aVar2);
                        }
                    }
                } catch (Throwable e222222) {
                    w.printErrStackTrace("MicroMsg.MallOrderDetailObject", e222222, "", new Object[0]);
                } catch (Throwable e2222222) {
                    w.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2222222, "", new Object[0]);
                }
                mallOrderDetailObject.ofC = jSONObject.optString("safeguard_url");
                mallOrderDetailObject.lmf = jSONObject.optString("share_url");
                mallOrderDetailObject.ofE = jSONObject.optInt("modifyTimeStamp");
                if (mallOrderDetailObject.ofx != null && mallOrderDetailObject.ofE <= 0) {
                    mallOrderDetailObject.ofE = mallOrderDetailObject.ofx.cIm;
                }
                if (mallOrderDetailObject.ofw != null) {
                    mallOrderDetailObject.ofD = mallOrderDetailObject.ofw.ofD;
                    mallOrderDetailObject.fKK = mallOrderDetailObject.ofw.ogb;
                    mallOrderDetailObject.ofB = mallOrderDetailObject.ofw.ofB;
                    mallOrderDetailObject.ofA = mallOrderDetailObject.ofw.ofA;
                }
            }
        }
    }
}
