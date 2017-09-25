package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.R;
import com.tencent.mm.e.b.dk;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;

public class Bankcard extends dk implements Parcelable {
    public static final Creator<Bankcard> CREATOR = new Creator<Bankcard>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Bankcard(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Bankcard[i];
        }
    };
    public static a gTP;
    public static int rDW = 1;
    public static int rDX = 2;
    public static int rDY = 4;
    public static int rDZ = 8;
    public static int rEa = 22;
    public static int rEb = 64;
    public int rDF;
    public String rDH;
    public String rEc;
    public String rEd;
    public String rEe;
    public String rEf;
    public String rEg;
    public double rEh;
    public String rEi;
    public double rEj;
    public String rEk;
    public String rEl;
    public String rEm;
    public String rEn;
    public boolean rEo;
    public e rEp;

    static {
        a aVar = new a();
        aVar.hXH = new Field[36];
        aVar.columns = new String[37];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bindSerial";
        aVar.uxd.put("bindSerial", "TEXT PRIMARY KEY ");
        stringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "bindSerial";
        aVar.columns[1] = "cardType";
        aVar.uxd.put("cardType", "INTEGER");
        stringBuilder.append(" cardType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "bankcardState";
        aVar.uxd.put("bankcardState", "INTEGER");
        stringBuilder.append(" bankcardState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "forbidWord";
        aVar.uxd.put("forbidWord", "TEXT");
        stringBuilder.append(" forbidWord TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "bankName";
        aVar.uxd.put("bankName", "TEXT");
        stringBuilder.append(" bankName TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "bankcardType";
        aVar.uxd.put("bankcardType", "TEXT");
        stringBuilder.append(" bankcardType TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "bankcardTypeName";
        aVar.uxd.put("bankcardTypeName", "TEXT");
        stringBuilder.append(" bankcardTypeName TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "bankcardTag";
        aVar.uxd.put("bankcardTag", "INTEGER");
        stringBuilder.append(" bankcardTag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "bankcardTail";
        aVar.uxd.put("bankcardTail", "TEXT");
        stringBuilder.append(" bankcardTail TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "supportTag";
        aVar.uxd.put("supportTag", "INTEGER");
        stringBuilder.append(" supportTag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "mobile";
        aVar.uxd.put("mobile", "TEXT");
        stringBuilder.append(" mobile TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "trueName";
        aVar.uxd.put("trueName", "TEXT");
        stringBuilder.append(" trueName TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "desc";
        aVar.uxd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "bankPhone";
        aVar.uxd.put("bankPhone", "TEXT");
        stringBuilder.append(" bankPhone TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "bizUsername";
        aVar.uxd.put("bizUsername", "TEXT");
        stringBuilder.append(" bizUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "onceQuotaKind";
        aVar.uxd.put("onceQuotaKind", "DOUBLE");
        stringBuilder.append(" onceQuotaKind DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[16] = "onceQuotaVirtual";
        aVar.uxd.put("onceQuotaVirtual", "DOUBLE");
        stringBuilder.append(" onceQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[17] = "dayQuotaKind";
        aVar.uxd.put("dayQuotaKind", "DOUBLE");
        stringBuilder.append(" dayQuotaKind DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[18] = "dayQuotaVirtual";
        aVar.uxd.put("dayQuotaVirtual", "DOUBLE");
        stringBuilder.append(" dayQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[19] = "fetchArriveTime";
        aVar.uxd.put("fetchArriveTime", "LONG");
        stringBuilder.append(" fetchArriveTime LONG");
        stringBuilder.append(", ");
        aVar.columns[20] = "fetchArriveTimeWording";
        aVar.uxd.put("fetchArriveTimeWording", "TEXT");
        stringBuilder.append(" fetchArriveTimeWording TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "repay_url";
        aVar.uxd.put("repay_url", "TEXT");
        stringBuilder.append(" repay_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "wxcreditState";
        aVar.uxd.put("wxcreditState", "INTEGER");
        stringBuilder.append(" wxcreditState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[23] = "bankcardClientType";
        aVar.uxd.put("bankcardClientType", "INTEGER");
        stringBuilder.append(" bankcardClientType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[24] = "ext_msg";
        aVar.uxd.put("ext_msg", "TEXT");
        stringBuilder.append(" ext_msg TEXT");
        stringBuilder.append(", ");
        aVar.columns[25] = "support_micropay";
        aVar.uxd.put("support_micropay", "INTEGER");
        stringBuilder.append(" support_micropay INTEGER");
        stringBuilder.append(", ");
        aVar.columns[26] = "arrive_type";
        aVar.uxd.put("arrive_type", "TEXT");
        stringBuilder.append(" arrive_type TEXT");
        stringBuilder.append(", ");
        aVar.columns[27] = "avail_save_wording";
        aVar.uxd.put("avail_save_wording", "TEXT");
        stringBuilder.append(" avail_save_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[28] = "fetch_charge_rate";
        aVar.uxd.put("fetch_charge_rate", "DOUBLE");
        stringBuilder.append(" fetch_charge_rate DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[29] = "full_fetch_charge_fee";
        aVar.uxd.put("full_fetch_charge_fee", "DOUBLE");
        stringBuilder.append(" full_fetch_charge_fee DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[30] = "fetch_charge_info";
        aVar.uxd.put("fetch_charge_info", "TEXT");
        stringBuilder.append(" fetch_charge_info TEXT");
        stringBuilder.append(", ");
        aVar.columns[31] = "tips";
        aVar.uxd.put("tips", "TEXT");
        stringBuilder.append(" tips TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "forbid_title";
        aVar.uxd.put("forbid_title", "TEXT");
        stringBuilder.append(" forbid_title TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "forbid_url";
        aVar.uxd.put("forbid_url", "TEXT");
        stringBuilder.append(" forbid_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "no_micro_word";
        aVar.uxd.put("no_micro_word", "TEXT");
        stringBuilder.append(" no_micro_word TEXT");
        stringBuilder.append(", ");
        aVar.columns[35] = "card_bottom_wording";
        aVar.uxd.put("card_bottom_wording", "TEXT");
        stringBuilder.append(" card_bottom_wording TEXT");
        aVar.columns[36] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    public Bankcard() {
        this.rEg = null;
        this.rEn = null;
        this.rEo = false;
    }

    public Bankcard(byte b) {
        this.rEg = null;
        this.rEn = null;
        this.rEo = false;
        this.field_bankcardTag = 1;
    }

    public static boolean ds(int i, int i2) {
        w.d("MicroMsg.Bankcard", "supportBankcardTag : " + i + ", bankcardTag : " + i2);
        return (i & i2) > 0;
    }

    public static boolean vw(int i) {
        return (i & 2) > 0;
    }

    public final int a(int i, Orders orders) {
        if (this.field_bankcardState != 0) {
            w.d("MicroMsg.Bankcard", " bankcardState : " + this.field_bankcardState);
            return this.field_bankcardState;
        } else if (orders != null && orders.fJH.equals(this.rEg)) {
            return 4;
        } else {
            int i2;
            if ((this.field_bankcardTag & i) > 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                if (btD()) {
                    return 5;
                }
                return 6;
            } else if (orders == null || orders.rGb.isEmpty() || orders.rGb.contains(this.field_bankcardType)) {
                return 0;
            } else {
                return 7;
            }
        }
    }

    public static String H(Context context, int i) {
        switch (i) {
            case 1:
                return context.getString(R.l.fii);
            case 2:
                return context.getString(R.l.fio);
            case 3:
                return context.getString(R.l.fit);
            case 4:
                return context.getString(R.l.fik);
            case 5:
                return context.getString(R.l.fig);
            case 6:
                return context.getString(R.l.fim);
            case 7:
                return context.getString(R.l.fir);
            default:
                return context.getString(R.l.fip);
        }
    }

    public final boolean btz() {
        boolean z = (this.field_cardType & rDY) > 0;
        w.d("MicroMsg.Bankcard", "isWXCredit, ret = " + z);
        return z;
    }

    public final boolean btA() {
        boolean z = (this.field_cardType & rDZ) > 0;
        w.d("MicroMsg.Bankcard", "isWXCredit, ret = " + z);
        return z;
    }

    public final boolean btB() {
        boolean z = (this.field_cardType & rEb) > 0;
        w.d("MicroMsg.Bankcard", "isLqtCard, ret = " + z);
        return z;
    }

    public final boolean btC() {
        boolean z = (this.field_cardType & rDX) > 0;
        w.d("MicroMsg.Bankcard", "isCredit, ret = " + z);
        return z;
    }

    public final boolean btD() {
        boolean z = (this.field_cardType & rDW) <= 0;
        w.d("MicroMsg.Bankcard", "isDomestic, ret = " + z);
        return z;
    }

    protected final a sY() {
        return gTP;
    }

    public int describeContents() {
        return 0;
    }

    public Bankcard(Parcel parcel) {
        boolean z = true;
        this.rEg = null;
        this.rEn = null;
        this.rEo = false;
        this.field_bankName = parcel.readString();
        this.field_desc = parcel.readString();
        this.field_bankcardType = parcel.readString();
        this.field_bindSerial = parcel.readString();
        this.field_cardType = parcel.readInt();
        this.rEo = parcel.readInt() == 1;
        this.field_mobile = parcel.readString();
        this.field_onceQuotaKind = parcel.readDouble();
        this.field_onceQuotaVirtual = parcel.readDouble();
        this.field_dayQuotaKind = parcel.readDouble();
        this.field_dayQuotaVirtual = parcel.readDouble();
        this.field_bankcardTail = parcel.readString();
        this.field_bankPhone = parcel.readString();
        this.field_bankcardTag = parcel.readInt();
        this.field_bankcardState = parcel.readInt();
        this.rEg = parcel.readString();
        this.rDF = parcel.readInt();
        this.rEn = parcel.readString();
        this.field_bankcardClientType = parcel.readInt();
        this.field_ext_msg = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.field_support_micropay = z;
        this.field_arrive_type = parcel.readString();
        this.field_fetch_charge_rate = parcel.readDouble();
        this.field_full_fetch_charge_fee = parcel.readDouble();
        this.field_no_micro_word = parcel.readString();
        this.field_card_bottom_wording = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.field_bankName);
        parcel.writeString(this.field_desc);
        parcel.writeString(this.field_bankcardType);
        parcel.writeString(this.field_bindSerial);
        parcel.writeInt(this.field_cardType);
        parcel.writeInt(this.rEo ? 1 : 0);
        parcel.writeString(this.field_mobile);
        parcel.writeDouble(this.field_onceQuotaKind);
        parcel.writeDouble(this.field_onceQuotaVirtual);
        parcel.writeDouble(this.field_dayQuotaKind);
        parcel.writeDouble(this.field_dayQuotaVirtual);
        parcel.writeString(this.field_bankcardTail);
        parcel.writeString(this.field_bankPhone);
        parcel.writeInt(this.field_bankcardTag);
        parcel.writeInt(this.field_bankcardState);
        parcel.writeString(this.rEg);
        parcel.writeInt(this.rDF);
        parcel.writeString(this.rEn);
        parcel.writeInt(this.field_bankcardClientType);
        parcel.writeString(this.field_ext_msg);
        if (!this.field_support_micropay) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.field_arrive_type);
        parcel.writeDouble(this.field_fetch_charge_rate);
        parcel.writeDouble(this.field_full_fetch_charge_fee);
        parcel.writeString(this.field_no_micro_word);
        parcel.writeString(this.field_card_bottom_wording);
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
    }
}
