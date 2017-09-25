package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MallTransactionObject implements Parcelable {
    public static final Creator<MallTransactionObject> CREATOR = new Creator<MallTransactionObject>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallTransactionObject(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallTransactionObject[i];
        }
    };
    public String desc;
    public int fEC;
    public String fTA;
    public int fyT;
    public int hFf;
    public String iEP;
    public double kBc = 0.0d;
    public List<HelpCenter> ofA = new LinkedList();
    public int ofB = -1;
    public String ofD;
    public int ofL;
    public String ofM;
    public String ofN;
    public String ofO;
    public String ofP;
    public String ofQ;
    public String ofR;
    public String ofS;
    public String ofT;
    public String ofU;
    public String ofV;
    public int ofW;
    public String ofX;
    public String ofY;
    public String ofZ;
    public String ogA;
    public double ogB;
    public String ogC;
    public String oga;
    public String ogb;
    public String ogc;
    public String ogd;
    public String oge;
    public String ogf;
    public double ogg;
    public String ogh;
    public String ogi;
    public String ogj;
    public String ogk;
    public String ogl;
    public int ogm;
    public int ogn;
    public double ogo;
    public String ogp;
    public int ogq;
    public String ogr;
    public int ogs;
    public int ogt;
    public int ogu;
    public String ogv;
    public String ogw;
    public String ogx;
    public String ogy;
    public String ogz;
    public int type;

    public int describeContents() {
        return 0;
    }

    public MallTransactionObject(Parcel parcel) {
        this.fEC = parcel.readInt();
        this.ofL = parcel.readInt();
        this.fyT = parcel.readInt();
        this.ofM = parcel.readString();
        this.ofN = parcel.readString();
        this.ofO = parcel.readString();
        this.ofP = parcel.readString();
        this.desc = parcel.readString();
        this.ofQ = parcel.readString();
        this.ofR = parcel.readString();
        this.kBc = parcel.readDouble();
        this.ofS = parcel.readString();
        this.ofT = parcel.readString();
        this.ofU = parcel.readString();
        this.ofV = parcel.readString();
        this.hFf = parcel.readInt();
        this.ofW = parcel.readInt();
        this.fTA = parcel.readString();
        this.ofX = parcel.readString();
        this.ofY = parcel.readString();
        this.oga = parcel.readString();
        this.ogb = parcel.readString();
        this.ofD = parcel.readString();
        this.ogc = parcel.readString();
        this.iEP = parcel.readString();
        this.ogd = parcel.readString();
        this.oge = parcel.readString();
        this.ogf = parcel.readString();
        this.ogg = parcel.readDouble();
        this.ogh = parcel.readString();
        this.ogi = parcel.readString();
        this.ogj = parcel.readString();
        this.ogk = parcel.readString();
        this.ogm = parcel.readInt();
        this.ogs = parcel.readInt();
        this.ogo = parcel.readDouble();
        this.ogp = parcel.readString();
        this.ogq = parcel.readInt();
        this.ogr = parcel.readString();
        this.ogs = parcel.readInt();
        this.ogt = parcel.readInt();
        this.ogu = parcel.readInt();
        this.ogv = parcel.readString();
        this.ogw = parcel.readString();
        this.ogx = parcel.readString();
        this.ogy = parcel.readString();
        this.ogz = parcel.readString();
        this.ogA = parcel.readString();
        this.ogB = parcel.readDouble();
        this.ogC = parcel.readString();
        this.ogl = parcel.readString();
        this.ofB = parcel.readInt();
        int readInt = parcel.readInt();
        this.ofA = new LinkedList();
        for (int i = 0; i < readInt; i++) {
            this.ofA.add((HelpCenter) parcel.readParcelable(HelpCenter.class.getClassLoader()));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fEC);
        parcel.writeInt(this.ofL);
        parcel.writeInt(this.fyT);
        parcel.writeString(this.ofM);
        parcel.writeString(this.ofN);
        parcel.writeString(this.ofO);
        parcel.writeString(this.ofP);
        parcel.writeString(this.desc);
        parcel.writeString(this.ofQ);
        parcel.writeString(this.ofR);
        parcel.writeDouble(this.kBc);
        parcel.writeString(this.ofS);
        parcel.writeString(this.ofT);
        parcel.writeString(this.ofU);
        parcel.writeString(this.ofV);
        parcel.writeInt(this.hFf);
        parcel.writeInt(this.ofW);
        parcel.writeString(this.fTA);
        parcel.writeString(this.ofX);
        parcel.writeString(this.ofY);
        parcel.writeString(this.oga);
        parcel.writeString(this.ogb);
        parcel.writeString(this.ofD);
        parcel.writeString(this.ogc);
        parcel.writeString(this.iEP);
        parcel.writeString(this.ogd);
        parcel.writeString(this.oge);
        parcel.writeString(this.ogf);
        parcel.writeDouble(this.ogg);
        parcel.writeString(this.ogh);
        parcel.writeString(this.ogi);
        parcel.writeString(this.ogj);
        parcel.writeString(this.ogk);
        parcel.writeInt(this.ogm);
        parcel.writeInt(this.ogs);
        parcel.writeDouble(this.ogo);
        parcel.writeString(this.ogp);
        parcel.writeInt(this.ogq);
        parcel.writeString(this.ogr);
        parcel.writeInt(this.ogs);
        parcel.writeInt(this.ogt);
        parcel.writeInt(this.ogu);
        parcel.writeString(this.ogv);
        parcel.writeString(this.ogw);
        parcel.writeString(this.ogx);
        parcel.writeString(this.ogy);
        parcel.writeString(this.ogz);
        parcel.writeString(this.ogA);
        parcel.writeDouble(this.ogB);
        parcel.writeString(this.ogC);
        parcel.writeString(this.ogl);
        parcel.writeInt(this.ofB);
        parcel.writeInt(this.ofA.size());
        for (HelpCenter writeParcelable : this.ofA) {
            parcel.writeParcelable(writeParcelable, i);
        }
    }

    public static MallTransactionObject G(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        MallTransactionObject mallTransactionObject = new MallTransactionObject();
        mallTransactionObject.type = jSONObject.optInt("rec_type", 1);
        mallTransactionObject.fEC = jSONObject.optInt("sub_pay_type", 0);
        mallTransactionObject.ofL = jSONObject.optInt("pay_scene");
        mallTransactionObject.fyT = jSONObject.optInt("user_type");
        mallTransactionObject.ofM = jSONObject.optString("buy_uin");
        mallTransactionObject.ofN = jSONObject.optString("buy_name");
        mallTransactionObject.ofO = jSONObject.optString("sale_uin");
        mallTransactionObject.ofP = jSONObject.optString("sale_name");
        mallTransactionObject.fTA = jSONObject.optString("trans_id");
        mallTransactionObject.ofX = jSONObject.optString("sp_billno");
        mallTransactionObject.desc = jSONObject.optString("goods_name");
        mallTransactionObject.ofQ = jSONObject.optString("goods_detail");
        mallTransactionObject.kBc = jSONObject.optDouble("fee") / 100.0d;
        mallTransactionObject.ofS = jSONObject.optString("fee_color");
        mallTransactionObject.ofT = jSONObject.optString("trade_state");
        mallTransactionObject.ofU = jSONObject.optString("trade_state_name");
        mallTransactionObject.ofV = jSONObject.optString("trade_state_color");
        mallTransactionObject.ofY = jSONObject.optString("buy_bank_name");
        mallTransactionObject.ofZ = jSONObject.optString("card_tail");
        mallTransactionObject.hFf = jSONObject.optInt("create_timestamp");
        mallTransactionObject.ofW = jSONObject.optInt("modify_timestamp");
        mallTransactionObject.oga = jSONObject.optString("fee_type");
        JSONObject optJSONObject = jSONObject.optJSONObject("appinfo");
        if (optJSONObject != null) {
            mallTransactionObject.ogb = optJSONObject.optString("app_username");
            mallTransactionObject.ofD = optJSONObject.optString("app_telephone");
            mallTransactionObject.ogc = optJSONObject.optString("app_nickname");
            mallTransactionObject.iEP = optJSONObject.optString("app_icon_url");
            mallTransactionObject.ogk = optJSONObject.optString("safeguard_url");
            mallTransactionObject.ogl = optJSONObject.optString(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
        }
        mallTransactionObject.ogd = jSONObject.optString("deliver_price");
        mallTransactionObject.oge = jSONObject.optString("preferential_price");
        mallTransactionObject.ogf = jSONObject.optString("discount");
        mallTransactionObject.ogg = jSONObject.optDouble("original_total_fee") / 100.0d;
        mallTransactionObject.ogh = jSONObject.optString("total_price");
        mallTransactionObject.ogi = jSONObject.optString("receipt_company");
        mallTransactionObject.ogj = jSONObject.optString("biz_pledge");
        mallTransactionObject.ogm = jSONObject.optInt("pre_fetch_timestamp");
        mallTransactionObject.ogn = jSONObject.optInt("arrived_timestamp");
        mallTransactionObject.ogo = jSONObject.optDouble("transfer_fee") / 100.0d;
        mallTransactionObject.ogp = jSONObject.optString("receiver_name");
        mallTransactionObject.ogq = jSONObject.optInt("allow_resend_msg");
        mallTransactionObject.ogr = jSONObject.optString("charge_fee");
        mallTransactionObject.ogs = jSONObject.optInt("receive_timestamp");
        mallTransactionObject.ogt = jSONObject.optInt("refund_timestamp");
        mallTransactionObject.ogu = jSONObject.optInt("create_timestamp");
        mallTransactionObject.ogv = jSONObject.optString("buy_bank_type");
        mallTransactionObject.ogw = jSONObject.optString("payer_name");
        mallTransactionObject.ogx = jSONObject.optString("true_name");
        mallTransactionObject.ogy = jSONObject.optString("refund_bank_type");
        mallTransactionObject.ogz = jSONObject.optString("rateinfo");
        mallTransactionObject.ogA = jSONObject.optString("original_feeinfo");
        mallTransactionObject.ogB = jSONObject.optDouble("fetch_total_fee") / 100.0d;
        mallTransactionObject.ogC = jSONObject.optString("fetch_total_fee_color");
        mallTransactionObject.ofB = jSONObject.optInt("userroll_type");
        mallTransactionObject.ofA = H(jSONObject);
        return mallTransactionObject;
    }

    private static List<HelpCenter> H(JSONObject jSONObject) {
        List<HelpCenter> linkedList = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("help_center");
            for (int i = 0; i < jSONArray.length(); i++) {
                HelpCenter helpCenter = new HelpCenter();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                helpCenter.fEq = jSONObject2.optBoolean("is_show_button");
                helpCenter.name = jSONObject2.optString("name");
                helpCenter.url = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                linkedList.add(helpCenter);
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MallTransactionObject", e, "", new Object[0]);
            w.e("MicroMsg.MallTransactionObject", "parseHelpCenter error %s", new Object[]{e.getMessage()});
        }
        return linkedList;
    }
}
