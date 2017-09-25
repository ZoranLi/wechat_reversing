package com.tencent.mm.plugin.address.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.acd;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends k implements j {
    private com.tencent.mm.y.b gUA;
    private e gUD;

    public b() {
        a aVar = new a();
        aVar.hsm = new acd();
        aVar.hsn = new ace();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
        aVar.hsl = 1191;
        this.gUA = aVar.BE();
        acd com_tencent_mm_protocal_c_acd = (acd) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_acd.cGa = 2;
        LinkedList linkedList = new LinkedList();
        linkedList.add("invoice_info.title");
        linkedList.add("invoice_info.tax_number");
        linkedList.add("invoice_info.bank_number");
        linkedList.add("invoice_info.bank_name");
        linkedList.add("invoice_info.type");
        linkedList.add("invoice_info.email");
        linkedList.add("invoice_info.company_address");
        linkedList.add("invoice_info.company_address_detail");
        linkedList.add("invoice_info.company_address_postcode");
        linkedList.add("invoice_info.phone");
        com_tencent_mm_protocal_c_acd.tHL = linkedList;
        com_tencent_mm_protocal_c_acd.tHK = false;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.address.a.a.OS().isX = new com.tencent.mm.plugin.o.a.a();
            w.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we resetList and parse the json ..");
            ace com_tencent_mm_protocal_c_ace = (ace) ((com.tencent.mm.y.b) pVar).hsk.hsr;
            w.i("MicroMsg.NetSceneGetUserAutoFillInfo", "resp json is.." + com_tencent_mm_protocal_c_ace.tHM);
            if (com_tencent_mm_protocal_c_ace.tHM != null) {
                try {
                    JSONArray jSONArray = new JSONObject(com_tencent_mm_protocal_c_ace.tHM).getJSONArray("user_data_list").getJSONObject(0).getJSONArray("group_info_list");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                                com.tencent.mm.plugin.o.a.b bVar = new com.tencent.mm.plugin.o.a.b();
                                bVar.mLW = jSONObject.getInt("group_id");
                                bVar.mMf = jSONObject.getString("invoice_url");
                                w.i("MicroMsg.NetSceneGetUserAutoFillInfo", "get groupid:" + jSONObject.getInt("group_id") + "get invoiceUrl:" + jSONObject.getString("invoice_url"));
                                JSONArray jSONArray2 = jSONObject.getJSONArray("field_list");
                                if (jSONArray2 != null && jSONArray2.length() > 0) {
                                    for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i5);
                                        String string = jSONObject2.getString("key");
                                        Object obj = -1;
                                        switch (string.hashCode()) {
                                            case -1787383122:
                                                if (string.equals("bank_name")) {
                                                    obj = 2;
                                                    break;
                                                }
                                                break;
                                            case -192204195:
                                                if (string.equals("tax_number")) {
                                                    obj = 1;
                                                    break;
                                                }
                                                break;
                                            case 3575610:
                                                if (string.equals(Columns.TYPE)) {
                                                    obj = 4;
                                                    break;
                                                }
                                                break;
                                            case 96619420:
                                                if (string.equals("email")) {
                                                    obj = 5;
                                                    break;
                                                }
                                                break;
                                            case 106642798:
                                                if (string.equals("phone")) {
                                                    obj = 6;
                                                    break;
                                                }
                                                break;
                                            case 110371416:
                                                if (string.equals("title")) {
                                                    obj = null;
                                                    break;
                                                }
                                                break;
                                            case 330208940:
                                                if (string.equals("bank_number")) {
                                                    obj = 3;
                                                    break;
                                                }
                                                break;
                                            case 944498430:
                                                if (string.equals("company_address_detail")) {
                                                    obj = 7;
                                                    break;
                                                }
                                                break;
                                        }
                                        switch (obj) {
                                            case null:
                                                bVar.title = jSONObject2.getString(Columns.VALUE);
                                                break;
                                            case 1:
                                                bVar.mLY = jSONObject2.getString(Columns.VALUE);
                                                break;
                                            case 2:
                                                bVar.mMa = jSONObject2.getString(Columns.VALUE);
                                                break;
                                            case 3:
                                                bVar.mLZ = jSONObject2.getString(Columns.VALUE);
                                                break;
                                            case 4:
                                                bVar.type = jSONObject2.getString(Columns.VALUE);
                                                break;
                                            case 5:
                                                bVar.gku = jSONObject2.getString(Columns.VALUE);
                                                break;
                                            case 6:
                                                bVar.mMc = jSONObject2.getString(Columns.VALUE);
                                                bVar.mMd = jSONObject2.getString(Columns.VALUE);
                                                break;
                                            case 7:
                                                bVar.mMe = jSONObject2.getString(Columns.VALUE);
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                }
                                com.tencent.mm.plugin.address.b.a.a OS = com.tencent.mm.plugin.address.a.a.OS();
                                if (bVar.type != null && bVar.type.equals("0")) {
                                    bVar.mLX = "";
                                    bVar.mMd = "";
                                    bVar.gku = "";
                                    OS.isX.mLV.add(bVar);
                                } else if (bVar.type != null && bVar.type.equals("1")) {
                                    bVar.mLX = bVar.title;
                                    bVar.title = "";
                                    bVar.mMc = "";
                                    bVar.mLY = "";
                                    bVar.mLZ = "";
                                    bVar.mMa = "";
                                    bVar.mMe = "";
                                    OS.isX.mLV.add(bVar);
                                }
                                w.i("MicroMsg.InvoiceMgr", "type is error..");
                            } catch (JSONException e) {
                                w.e("MicroMsg.NetSceneGetUserAutoFillInfo", "parse error for no." + i4);
                            }
                        }
                    }
                } catch (JSONException e2) {
                    w.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
                }
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1191;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
