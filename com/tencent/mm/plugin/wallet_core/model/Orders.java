package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.g;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class Orders implements Parcelable {
    public static final Creator<Orders> CREATOR = new Creator<Orders>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Orders(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Orders[i];
        }
    };
    public static int rGq = 0;
    public static int rGr = 1;
    public String fFa;
    public String fJH = "";
    public String kvq = "0";
    public String lfx = "";
    public String nXm;
    public double oQs;
    public String oga;
    public int rBY;
    public String rDD;
    public long rFL;
    public double rFM = 0.0d;
    public double rFN = 0.0d;
    public int rFO;
    public String rFP;
    public int rFQ;
    public String rFR;
    public String rFS;
    public String rFT;
    public String rFU;
    public int rFV;
    public boolean rFW = false;
    public String rFX = "";
    public long rFY = 0;
    public String rFZ = "";
    public String rGa;
    public Set<String> rGb = new HashSet();
    public int rGc = 0;
    public String rGd = "";
    public List<Commodity> rGe = new ArrayList();
    public f rGf = new f();
    public int rGg = 0;
    public String rGh = "";
    public String rGi = "";
    public DeductInfo rGj;
    public long rGk;
    public long rGl;
    public int rGm = 0;
    public int rGn = 0;
    public int rGo = 0;
    public String rGp = "";
    public String token = "";
    public String username;

    public static class Commodity implements Parcelable {
        public static final Creator<Commodity> CREATOR = new Creator<Commodity>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new Commodity(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Commodity[i];
            }
        };
        public String desc;
        public String fTA;
        public double kBc = 0.0d;
        public String ofD;
        public String ofM;
        public String ofN;
        public String ofO;
        public String ofP;
        public String ofR;
        public String ofT;
        public String ofU;
        public int ofW;
        public String ofY;
        public String oga;
        public String ogb;
        public String ogf;
        public int rFV;
        public boolean rGA = false;
        public a rGB = new a();
        public double rGs = 0.0d;
        public String rGt;
        public String rGu;
        public List<DiscountInfo> rGv = new ArrayList();
        public String rGw;
        public String rGx;
        public RecommendTinyAppInfo rGy = null;
        public List<b> rGz = new ArrayList();

        public int describeContents() {
            return 0;
        }

        public Commodity(Parcel parcel) {
            this.ofM = parcel.readString();
            this.ofN = parcel.readString();
            this.ofO = parcel.readString();
            this.ofP = parcel.readString();
            this.desc = parcel.readString();
            this.ofR = parcel.readString();
            this.kBc = parcel.readDouble();
            this.ofT = parcel.readString();
            this.ofU = parcel.readString();
            this.ofW = parcel.readInt();
            this.fTA = parcel.readString();
            this.ofY = parcel.readString();
            this.oga = parcel.readString();
            this.ogb = parcel.readString();
            this.ofD = parcel.readString();
            this.rGu = parcel.readString();
            this.ogf = parcel.readString();
            parcel.readTypedList(this.rGv, DiscountInfo.CREATOR);
            this.rGw = parcel.readString();
            this.rGx = parcel.readString();
            this.rGy = (RecommendTinyAppInfo) parcel.readParcelable(RecommendTinyAppInfo.class.getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.ofM);
            parcel.writeString(this.ofN);
            parcel.writeString(this.ofO);
            parcel.writeString(this.ofP);
            parcel.writeString(this.desc);
            parcel.writeString(this.ofR);
            parcel.writeDouble(this.kBc);
            parcel.writeString(this.ofT);
            parcel.writeString(this.ofU);
            parcel.writeInt(this.ofW);
            parcel.writeString(this.fTA);
            parcel.writeString(this.ofY);
            parcel.writeString(this.oga);
            parcel.writeString(this.ogb);
            parcel.writeString(this.ofD);
            parcel.writeString(this.rGu);
            parcel.writeString(this.ogf);
            parcel.writeTypedList(this.rGv);
            parcel.writeString(this.rGw);
            parcel.writeString(this.rGx);
            parcel.writeParcelable(this.rGy, 0);
        }
    }

    public static class DeductInfo implements Parcelable {
        public static final Creator<DeductInfo> CREATOR = new Creator<DeductInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DeductInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DeductInfo[i];
            }
        };
        public String desc;
        public int rAl;
        public String rGC;
        public List<DeductShowInfo> rGD = new ArrayList();
        public int rGE;
        public String title;

        public DeductInfo(Parcel parcel) {
            this.title = parcel.readString();
            this.desc = parcel.readString();
            this.rAl = parcel.readInt();
            this.rGC = parcel.readString();
            this.rGE = parcel.readInt();
            parcel.readTypedList(this.rGD, DeductShowInfo.CREATOR);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.title);
            parcel.writeString(this.desc);
            parcel.writeInt(this.rAl);
            parcel.writeString(this.rGC);
            parcel.writeInt(this.rGE);
            parcel.writeTypedList(this.rGD);
        }
    }

    public static class DeductShowInfo implements Parcelable {
        public static final Creator<DeductShowInfo> CREATOR = new Creator<DeductShowInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DeductShowInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DeductShowInfo[i];
            }
        };
        public String name;
        public String url;
        public String value;

        protected DeductShowInfo(Parcel parcel) {
            this.name = parcel.readString();
            this.value = parcel.readString();
            this.url = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeString(this.value);
            parcel.writeString(this.url);
        }
    }

    public static class DiscountInfo implements Parcelable {
        public static final Creator<DiscountInfo> CREATOR = new Creator<DiscountInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DiscountInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DiscountInfo[i];
            }
        };
        public double rGF;
        public String rxH;

        public DiscountInfo(Parcel parcel) {
            this.rGF = parcel.readDouble();
            this.rxH = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeDouble(this.rGF);
            parcel.writeString(this.rxH);
        }
    }

    public static class RecommendTinyAppInfo implements Parcelable {
        public static final Creator<RecommendTinyAppInfo> CREATOR = new Creator<RecommendTinyAppInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new RecommendTinyAppInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RecommendTinyAppInfo[i];
            }
        };
        public String rGR;
        public String rGS;
        public String rGT;
        public String rGU;
        public String rGV;
        public String rGW;
        public long rGX;
        public long rGY;
        public long rGZ;
        public int rHa;
        public int rHb;
        public long rHc;

        public RecommendTinyAppInfo(Parcel parcel) {
            this.rGR = parcel.readString();
            this.rGS = parcel.readString();
            this.rGT = parcel.readString();
            this.rGU = parcel.readString();
            this.rGV = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.rGR);
            parcel.writeString(this.rGS);
            parcel.writeString(this.rGT);
            parcel.writeString(this.rGU);
            parcel.writeString(this.rGV);
        }
    }

    public static class a {
        public String text = "";
        public String url = "";
    }

    public static class b {
        public String name;
        public String ogb;
        public String oqk;
        public String rGG;
        public int rGH;
        public long rGI;
        public int rGJ;
        public int rGK;
        public int rGL;
        public int rGM;
        public String rGN;
        public String rGO;
        public String rGP;
        public long rGQ;
        public String title;
        public int type;
        public String url;
    }

    public static Orders L(JSONObject jSONObject) {
        boolean z = true;
        Orders orders = null;
        if (jSONObject != null) {
            orders = new Orders();
            try {
                orders.rFL = bg.Nz();
                orders.rFM = jSONObject.getDouble("total_fee") / 100.0d;
                orders.kvq = jSONObject.getString("num");
                orders.rBY = jSONObject.optInt("bank_card_tag", 1);
                orders.oga = jSONObject.optString("fee_type", "");
                orders.oQs = jSONObject.optDouble("charge_fee", 0.0d) / 100.0d;
                orders.rFN = jSONObject.optDouble("fetch_fee", 0.0d) / 100.0d;
                orders.rFO = jSONObject.optInt("is_assign_userinfo_pay");
                orders.rDD = jSONObject.optString("true_name");
                orders.rFP = jSONObject.optString("cre_id");
                orders.rFQ = jSONObject.optInt("ce_type");
                orders.rFR = jSONObject.optString("assign_pay_info");
                JSONArray jSONArray = jSONObject.getJSONArray("Array");
                orders.rGk = jSONObject.optLong("free_fee");
                orders.rGl = jSONObject.optLong("remain_fee");
                orders.rGm = jSONObject.optInt("not_support_bind_card", 0);
                orders.rGn = jSONObject.optInt("not_support_retry", 0);
                boolean z2 = jSONObject.optInt("support_all_bank", 0) == 1;
                if (z2) {
                    orders.rGb = new HashSet();
                }
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    Commodity commodity = new Commodity();
                    commodity.desc = jSONObject2.getString("desc");
                    commodity.kBc = ((double) jSONObject2.getInt("fee")) / 100.0d;
                    commodity.ofR = jSONObject2.optInt("count", 1);
                    commodity.ofT = jSONObject2.getString("pay_status");
                    commodity.ofY = jSONObject2.optString("buy_bank_name");
                    commodity.ofU = jSONObject2.getString("pay_status_name");
                    commodity.ofO = jSONObject2.optString("spid");
                    commodity.ofP = jSONObject2.optString("sp_name");
                    commodity.ofW = jSONObject2.optInt("modify_timestamp");
                    commodity.fTA = jSONObject2.getString("transaction_id");
                    commodity.oga = jSONObject2.optString("fee_type");
                    if (bg.mA(orders.oga)) {
                        orders.oga = commodity.oga;
                    }
                    commodity.ogb = jSONObject2.optString("appusername");
                    commodity.ofD = jSONObject2.optString("app_telephone");
                    orders.rGe.add(commodity);
                    if (!z2) {
                        orders.rGa = jSONObject2.optString("support_bank");
                        orders.rGb = HS(orders.rGa);
                    }
                }
                if (jSONObject.has("is_open_fee_protocal")) {
                    orders.rFW = e.f(jSONObject, "is_open_fee_protocal");
                } else {
                    orders.rFW = Bankcard.ds(orders.rBY, 2);
                }
                orders.rGf = M(jSONObject);
                JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
                if (optJSONObject == null) {
                    w.e("MicroMsg.Orders", "bindqueryresp is null ");
                } else {
                    optJSONObject = optJSONObject.optJSONObject("user_info");
                    if (optJSONObject == null) {
                        w.e("MicroMsg.Orders", "user_info is null ");
                    } else {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("touch_info");
                        if (optJSONObject2 == null) {
                            w.e("MicroMsg.Orders", "touch_info is null ");
                        } else {
                            orders.rGc = com.tencent.mm.pluginsdk.l.a.sBC.ava() ? optJSONObject2.optInt("use_touch_pay", 0) : 0;
                            orders.rGd = optJSONObject2.optString("touch_forbidword");
                            String optString = optJSONObject2.optString("touch_challenge");
                            if (1 != optJSONObject2.optInt("need_change_auth_key")) {
                                z = false;
                            }
                            q.rHB.lOH = optString;
                            q.rHB.lOI = z;
                            w.i("MicroMsg.Orders", "hy: use_touch_pay is %s, challenge is: %s, is need change: %b", new Object[]{Integer.valueOf(orders.rGc), optString, Boolean.valueOf(z)});
                        }
                    }
                }
                orders.rGg = jSONObject.optInt("needbindcardtoshowfavinfo");
                orders.rGh = jSONObject.optString("discount_wording");
                orders.rGi = jSONObject.optString("favor_rule_wording");
                a(orders, jSONObject.optJSONObject("entrustpayinfo"));
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Orders", e, "", new Object[0]);
            }
        }
        return orders;
    }

    private static f M(JSONObject jSONObject) {
        f fVar = new f();
        JSONObject optJSONObject = jSONObject.optJSONObject("favinfo");
        if (optJSONObject == null) {
            w.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
            return fVar;
        }
        int i;
        int i2;
        fVar.rxM = ((double) optJSONObject.optLong("tradeAmount")) / 100.0d;
        fVar.rxN = ((double) optJSONObject.optLong("totalFavAmount")) / 100.0d;
        fVar.rxO = ((double) optJSONObject.optLong("afterFavorTradeAmount")) / 100.0d;
        fVar.rxP = optJSONObject.optString("favorComposeId");
        fVar.rxS = optJSONObject.optInt("useNaturalDefense");
        fVar.rxT = optJSONObject.optString("discountWording");
        fVar.rxU = optJSONObject.optString("favorRuleWording");
        fVar.rxV = optJSONObject.optDouble("showFavorAmount", 0.0d) / 100.0d;
        fVar.rxW = optJSONObject.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
        fVar.rxX = optJSONObject.optInt("isVariableFavor");
        fVar.rxY = optJSONObject.optString("invariableFavorDesc");
        fVar.rxZ = optJSONObject.optString("variableFavorDesc");
        JSONArray optJSONArray = optJSONObject.optJSONArray("tradeFavList");
        for (i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            p pVar = new p();
            pVar.rys = jSONObject2.optInt("favType");
            pVar.ryt = jSONObject2.optInt("favSubType");
            pVar.ryu = jSONObject2.optLong("favProperty");
            pVar.ryv = jSONObject2.optString("favorTypeDesc");
            pVar.rxJ = jSONObject2.optString("favId");
            pVar.ryw = jSONObject2.optString("favName");
            pVar.ryx = jSONObject2.optString("favDesc");
            pVar.rxK = jSONObject2.optString("favorUseManual");
            pVar.rxL = jSONObject2.optString("favorRemarks");
            pVar.ryy = ((double) jSONObject2.optLong("favPrice")) / 100.0d;
            pVar.ryz = ((double) jSONObject2.optLong("realFavFee")) / 100.0d;
            pVar.ryA = jSONObject2.optInt("needBankPay");
            pVar.ryB = jSONObject2.optString("bankNo");
            pVar.ofY = jSONObject2.optString("bankName");
            pVar.ryC = jSONObject2.optString("bankLogoUrl");
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("bind_serial_list");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    pVar.ryD.add(com.tencent.mm.bd.b.aU(optJSONArray2.optString(i2).getBytes()));
                }
            }
            fVar.rxQ.add(pVar);
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("favorComposeList");
        if (optJSONObject2 != null) {
            fVar.rxR = new g();
            optJSONArray = optJSONObject2.optJSONArray("favorComposeInfo");
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                optJSONObject2 = optJSONArray.getJSONObject(i2);
                h hVar = new h();
                hVar.ryd = optJSONObject2.optString("faovrComposeId");
                hVar.rye = ((double) optJSONObject2.optLong("totalFavorAmount")) / 100.0d;
                hVar.rxO = ((double) optJSONObject2.optLong("afterFavorTradeAmount")) / 100.0d;
                hVar.rxV = optJSONObject2.optDouble("showFavorAmount", 0.0d) / 100.0d;
                hVar.rxW = optJSONObject2.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
                hVar.rxX = optJSONObject2.optInt("isVariableFavor");
                hVar.rxY = optJSONObject2.optString("invariableFavorDesc");
                hVar.rxZ = optJSONObject2.optString("variableFavorDesc");
                optJSONArray2 = optJSONObject2.optJSONArray("composeArray");
                for (i = 0; i < optJSONArray2.length(); i++) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i);
                    com.tencent.mm.plugin.wallet.a.e eVar = new com.tencent.mm.plugin.wallet.a.e();
                    eVar.rxJ = jSONObject3.optString("favId");
                    eVar.rxK = jSONObject3.optString("favorUseManual");
                    eVar.rxL = jSONObject3.optString("favorRemarks");
                    hVar.ryf.add(eVar);
                }
                fVar.rxR.ryb.add(hVar);
            }
        }
        com.tencent.mm.plugin.wallet.a.a aVar = new com.tencent.mm.plugin.wallet.a.a();
        optJSONObject = optJSONObject.optJSONObject("bank_card_info");
        if (optJSONObject != null) {
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("bind_serial_favor_info_list");
            if (optJSONArray3 != null) {
                for (i2 = 0; i2 < optJSONArray3.length(); i2++) {
                    com.tencent.mm.plugin.wallet.a.b bVar = new com.tencent.mm.plugin.wallet.a.b();
                    optJSONObject2 = optJSONArray3.getJSONObject(i2);
                    bVar.ofe = optJSONObject2.optString("bind_serial");
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("bind_serial_favor_list");
                    if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                        for (i = 0; i < optJSONArray4.length(); i++) {
                            c cVar = new c();
                            JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i);
                            cVar.rxH = optJSONObject3.optString("favor_desc");
                            cVar.rxI = optJSONObject3.optInt("is_default_show", 0);
                            bVar.rxG.add(cVar);
                        }
                    }
                    aVar.rxE.add(bVar);
                }
            }
            JSONArray optJSONArray5 = optJSONObject.optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
            if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                aVar.rxF = new j();
                for (i = 0; i < optJSONArray5.length(); i++) {
                    k kVar = new k();
                    kVar.rxH = optJSONArray5.optJSONObject(i).optString("favor_desc");
                    aVar.rxF.ryg.add(kVar);
                }
            }
        }
        fVar.rya = aVar;
        return fVar;
    }

    public static Orders a(JSONObject jSONObject, Orders orders) {
        if (jSONObject == null || orders == null) {
            w.w("MicroMsg.Orders", "oldOrders is null");
        } else {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("appservice");
                if (optJSONObject != null) {
                    orders.rFT = optJSONObject.optString("app_recommend_desc");
                    orders.rFU = optJSONObject.optString("app_telephone");
                    orders.rFV = optJSONObject.optInt("recommend_level", 2);
                    orders.lfx = optJSONObject.optString("share_to_friends_url");
                }
                int i = orders.rFV;
                List<Commodity> list = orders.rGe;
                orders.rFX = jSONObject.optString("pay_result_tips");
                JSONArray jSONArray = jSONObject.getJSONArray("payresult");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Commodity commodity;
                    if (list != null && list.size() == 1) {
                        commodity = (Commodity) list.get(0);
                        commodity.rGz = new ArrayList();
                        commodity.rGv = new ArrayList();
                        commodity.fTA = jSONObject2.getString("transaction_id");
                        a(commodity, jSONObject2, i);
                    } else if (list != null) {
                        String string = jSONObject2.getString("transaction_id");
                        for (Commodity commodity2 : list) {
                            if (string != null && string.equals(commodity2.fTA)) {
                                a(commodity2, jSONObject2, i);
                                break;
                            }
                        }
                    }
                }
                optJSONObject = jSONObject.optJSONObject("extinfo");
                if (optJSONObject != null) {
                    orders.rFY = optJSONObject.optLong("fetch_pre_arrive_time") * 1000;
                    orders.rFZ = optJSONObject.optString("fetch_pre_arrive_time_wording");
                }
                orders.rGo = jSONObject.optInt("is_use_new_paid_succ_page", 0);
                orders.rGp = jSONObject.optString("pay_succ_btn_wording");
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Orders", e, "", new Object[0]);
            }
        }
        return orders;
    }

    private static void a(Commodity commodity, JSONObject jSONObject, int i) {
        int i2 = 0;
        commodity.ogf = jSONObject.optString("discount");
        commodity.ofT = jSONObject.getString("pay_status");
        commodity.ofU = jSONObject.getString("pay_status_name");
        commodity.ofY = jSONObject.optString("buy_bank_name");
        commodity.ofW = jSONObject.optInt("pay_timestamp");
        commodity.rGu = jSONObject.optString("card_tail");
        commodity.rFV = i;
        commodity.rGw = jSONObject.optString("rateinfo");
        commodity.rGx = jSONObject.optString("original_feeinfo");
        if (jSONObject.has("total_fee")) {
            commodity.kBc = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
        }
        commodity.rGs = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
        commodity.oga = jSONObject.optString("fee_type", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
        if (optJSONObject != null) {
            b bVar = new b();
            bVar.type = rGq;
            bVar.name = optJSONObject.optString("nickname");
            bVar.ogb = optJSONObject.optString("username");
            commodity.rGt = bVar.ogb;
            bVar.oqk = optJSONObject.optString("logo_round_url");
            bVar.url = optJSONObject.optString("subscribe_biz_url");
            if (!(bg.mA(bVar.name) || bg.mA(bVar.url))) {
                commodity.rGz.add(bVar);
                commodity.rGA = true;
            }
        }
        JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            b bVar2 = new b();
            bVar2.type = rGr;
            bVar2.oqk = jSONObject2.optString("icon");
            bVar2.name = jSONObject2.optString("wording");
            bVar2.url = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            bVar2.rGG = jSONObject2.optString("btn_text");
            bVar2.rGH = jSONObject2.optInt(Columns.TYPE);
            bVar2.title = jSONObject2.optString("title");
            bVar2.rGI = jSONObject2.optLong("activity_id");
            bVar2.rGJ = jSONObject2.optInt("activity_type", 0);
            bVar2.rGN = jSONObject2.optString("small_title");
            bVar2.rGK = jSONObject2.optInt("award_id");
            bVar2.rGL = jSONObject2.optInt("send_record_id");
            bVar2.rGM = jSONObject2.optInt("user_record_id");
            bVar2.rGO = jSONObject2.optString("activity_tinyapp_username");
            bVar2.rGP = jSONObject2.optString("activity_tinyapp_path");
            bVar2.rGQ = jSONObject2.optLong("activity_mch_id");
            commodity.rGz.add(bVar2);
        }
        optJSONObject = jSONObject.optJSONObject("link_ativity_info");
        if (optJSONObject != null) {
            commodity.rGB.text = optJSONObject.optString("text");
            commodity.rGB.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("discount_array");
        if (optJSONArray != null) {
            int length2 = optJSONArray.length();
            while (i2 < length2) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                DiscountInfo discountInfo = new DiscountInfo();
                if (optJSONObject2 != null) {
                    discountInfo.rGF = optJSONObject2.optDouble("payment_amount");
                    discountInfo.rxH = optJSONObject2.optString("favor_desc");
                    commodity.rGv.add(discountInfo);
                }
                i2++;
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("tinyapp_info");
        if (optJSONObject3 != null) {
            if (commodity.rGy == null) {
                commodity.rGy = new RecommendTinyAppInfo();
            }
            commodity.rGy.rGR = optJSONObject3.optString("tinyapp_name");
            commodity.rGy.rGS = optJSONObject3.optString("tinyapp_logo");
            commodity.rGy.rGT = optJSONObject3.optString("tinyapp_desc");
            commodity.rGy.rGU = optJSONObject3.optString("tinyapp_username");
            commodity.rGy.rGV = optJSONObject3.optString("tinyapp_path");
            commodity.rGy.rGW = optJSONObject3.optString("activity_tinyapp_btn_text");
            commodity.rGy.rGX = optJSONObject3.optLong("activity_id");
            commodity.rGy.rGY = optJSONObject3.optLong("activity_type");
            commodity.rGy.rGZ = optJSONObject3.optLong("award_id");
            commodity.rGy.rHa = optJSONObject3.optInt("send_record_id");
            commodity.rGy.rHb = optJSONObject3.optInt("user_record_id");
            commodity.rGy.rHc = optJSONObject3.optLong("activity_mch_id");
        }
    }

    private static void a(Orders orders, JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            w.i("MicroMsg.Orders", "parseDeductInfo json is not null");
            orders.rGj = new DeductInfo();
            orders.rGj.title = jSONObject.optString("contract_title");
            orders.rGj.desc = jSONObject.optString("contract_desc");
            orders.rGj.rAl = jSONObject.optInt("auto_deduct_flag", 0);
            orders.rGj.rGC = jSONObject.optString("contract_url");
            orders.rGj.rGE = jSONObject.optInt("is_select_pay_way", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("show_info");
            int length = optJSONArray.length();
            if (length > 0) {
                orders.rGj.rGD = new ArrayList();
                while (i < length) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        DeductShowInfo deductShowInfo = new DeductShowInfo();
                        deductShowInfo.name = optJSONObject.optString("name");
                        deductShowInfo.value = optJSONObject.optString(Columns.VALUE);
                        deductShowInfo.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                        orders.rGj.rGD.add(deductShowInfo);
                    } else {
                        w.e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=" + i);
                    }
                    i++;
                }
                return;
            }
            w.e("MicroMsg.Orders", "parseDeductInfo's showInfo len is " + length);
            return;
        }
        w.i("MicroMsg.Orders", "parseDeductInfo json is null");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reqKey:").append(this.fJH).append("\n");
        stringBuilder.append("token").append(this.token).append("\n");
        stringBuilder.append("num").append(this.kvq).append("\n");
        stringBuilder.append("totalFee").append(this.rFM).append("\n");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    private static HashSet<String> HS(String str) {
        HashSet<String> hashSet = new HashSet();
        if (!bg.mA(str)) {
            for (Object add : str.split("\\|")) {
                hashSet.add(add);
            }
            if (hashSet.size() > 0) {
                hashSet.retainAll(hashSet);
            } else {
                hashSet.clear();
            }
        }
        return hashSet;
    }

    public Orders(Parcel parcel) {
        boolean z = true;
        this.rFL = parcel.readLong();
        this.fJH = parcel.readString();
        this.token = parcel.readString();
        this.kvq = parcel.readString();
        this.rFM = parcel.readDouble();
        this.rBY = parcel.readInt();
        this.oga = parcel.readString();
        this.oQs = parcel.readDouble();
        this.rFN = parcel.readDouble();
        this.rFO = parcel.readInt();
        this.rDD = parcel.readString();
        this.rFP = parcel.readString();
        this.rFQ = parcel.readInt();
        this.rFR = parcel.readString();
        this.username = parcel.readString();
        this.fFa = parcel.readString();
        this.nXm = parcel.readString();
        this.rFS = parcel.readString();
        this.rFT = parcel.readString();
        this.rFU = parcel.readString();
        this.rFV = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.rFW = z;
        this.rFX = parcel.readString();
        this.lfx = parcel.readString();
        this.rFY = parcel.readLong();
        this.rFZ = parcel.readString();
        parcel.readTypedList(this.rGe, Commodity.CREATOR);
        this.rGa = parcel.readString();
        this.rGb = HS(this.rGa);
        this.rGc = parcel.readInt();
        this.rGd = parcel.readString();
        this.rGj = (DeductInfo) parcel.readParcelable(DeductInfo.class.getClassLoader());
        this.rGm = parcel.readInt();
        this.rGn = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.rFL);
        parcel.writeString(this.fJH);
        parcel.writeString(this.token);
        parcel.writeString(this.kvq);
        parcel.writeDouble(this.rFM);
        parcel.writeInt(this.rBY);
        parcel.writeString(this.oga);
        parcel.writeDouble(this.oQs);
        parcel.writeDouble(this.rFN);
        parcel.writeInt(this.rFO);
        parcel.writeString(this.rDD);
        parcel.writeString(this.rFP);
        parcel.writeInt(this.rFQ);
        parcel.writeString(this.rFR);
        parcel.writeString(this.username);
        parcel.writeString(this.fFa);
        parcel.writeString(this.nXm);
        parcel.writeString(this.rFS);
        parcel.writeString(this.rFT);
        parcel.writeString(this.rFU);
        parcel.writeInt(this.rFV);
        parcel.writeInt(this.rFW ? 1 : 0);
        parcel.writeString(this.rFX);
        parcel.writeString(this.lfx);
        parcel.writeLong(this.rFY);
        parcel.writeString(this.rFZ);
        parcel.writeTypedList(this.rGe);
        parcel.writeString(this.rGa);
        parcel.writeInt(this.rGc);
        parcel.writeString(this.rGd);
        parcel.writeParcelable(this.rGj, 1);
        parcel.writeInt(this.rGm);
        parcel.writeInt(this.rGn);
    }
}
