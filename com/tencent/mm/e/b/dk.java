package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dk extends c {
    private static final int gFA = "bankcardTypeName".hashCode();
    private static final int gFB = "bankcardTag".hashCode();
    private static final int gFC = "bankcardTail".hashCode();
    private static final int gFD = "supportTag".hashCode();
    private static final int gFE = "mobile".hashCode();
    private static final int gFF = "trueName".hashCode();
    private static final int gFG = "bankPhone".hashCode();
    private static final int gFH = "bizUsername".hashCode();
    private static final int gFI = "onceQuotaKind".hashCode();
    private static final int gFJ = "onceQuotaVirtual".hashCode();
    private static final int gFK = "dayQuotaKind".hashCode();
    private static final int gFL = "dayQuotaVirtual".hashCode();
    private static final int gFM = "fetchArriveTime".hashCode();
    private static final int gFN = "fetchArriveTimeWording".hashCode();
    private static final int gFO = "repay_url".hashCode();
    private static final int gFP = "wxcreditState".hashCode();
    private static final int gFQ = "bankcardClientType".hashCode();
    private static final int gFR = "ext_msg".hashCode();
    private static final int gFS = "support_micropay".hashCode();
    private static final int gFT = "arrive_type".hashCode();
    private static final int gFU = "avail_save_wording".hashCode();
    private static final int gFV = "fetch_charge_rate".hashCode();
    private static final int gFW = "full_fetch_charge_fee".hashCode();
    private static final int gFX = "fetch_charge_info".hashCode();
    private static final int gFY = "forbid_title".hashCode();
    private static final int gFZ = "forbid_url".hashCode();
    private static final int gFu = "bindSerial".hashCode();
    private static final int gFv = "cardType".hashCode();
    private static final int gFw = "bankcardState".hashCode();
    private static final int gFx = "forbidWord".hashCode();
    private static final int gFy = "bankName".hashCode();
    private static final int gFz = "bankcardType".hashCode();
    private static final int gGa = "no_micro_word".hashCode();
    private static final int gGb = "card_bottom_wording".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gnU = "desc".hashCode();
    private static final int gxi = "tips".hashCode();
    public String field_arrive_type;
    public String field_avail_save_wording;
    public String field_bankName;
    public String field_bankPhone;
    public int field_bankcardClientType;
    public int field_bankcardState;
    public int field_bankcardTag;
    public String field_bankcardTail;
    public String field_bankcardType;
    public String field_bankcardTypeName;
    public String field_bindSerial;
    public String field_bizUsername;
    public int field_cardType;
    public String field_card_bottom_wording;
    public double field_dayQuotaKind;
    public double field_dayQuotaVirtual;
    public String field_desc;
    public String field_ext_msg;
    public long field_fetchArriveTime;
    public String field_fetchArriveTimeWording;
    public String field_fetch_charge_info;
    public double field_fetch_charge_rate;
    public String field_forbidWord;
    public String field_forbid_title;
    public String field_forbid_url;
    public double field_full_fetch_charge_fee;
    public String field_mobile;
    public String field_no_micro_word;
    public double field_onceQuotaKind;
    public double field_onceQuotaVirtual;
    public String field_repay_url;
    public int field_supportTag;
    public boolean field_support_micropay;
    public String field_tips;
    public String field_trueName;
    public int field_wxcreditState;
    private boolean gEM = true;
    private boolean gEN = true;
    private boolean gEO = true;
    private boolean gEP = true;
    private boolean gEQ = true;
    private boolean gER = true;
    private boolean gES = true;
    private boolean gET = true;
    private boolean gEU = true;
    private boolean gEV = true;
    private boolean gEW = true;
    private boolean gEX = true;
    private boolean gEY = true;
    private boolean gEZ = true;
    private boolean gFa = true;
    private boolean gFb = true;
    private boolean gFc = true;
    private boolean gFd = true;
    private boolean gFe = true;
    private boolean gFf = true;
    private boolean gFg = true;
    private boolean gFh = true;
    private boolean gFi = true;
    private boolean gFj = true;
    private boolean gFk = true;
    private boolean gFl = true;
    private boolean gFm = true;
    private boolean gFn = true;
    private boolean gFo = true;
    private boolean gFp = true;
    private boolean gFq = true;
    private boolean gFr = true;
    private boolean gFs = true;
    private boolean gFt = true;
    private boolean gnQ = true;
    private boolean gxc = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gFu == hashCode) {
                    this.field_bindSerial = cursor.getString(i);
                    this.gEM = true;
                } else if (gFv == hashCode) {
                    this.field_cardType = cursor.getInt(i);
                } else if (gFw == hashCode) {
                    this.field_bankcardState = cursor.getInt(i);
                } else if (gFx == hashCode) {
                    this.field_forbidWord = cursor.getString(i);
                } else if (gFy == hashCode) {
                    this.field_bankName = cursor.getString(i);
                } else if (gFz == hashCode) {
                    this.field_bankcardType = cursor.getString(i);
                } else if (gFA == hashCode) {
                    this.field_bankcardTypeName = cursor.getString(i);
                } else if (gFB == hashCode) {
                    this.field_bankcardTag = cursor.getInt(i);
                } else if (gFC == hashCode) {
                    this.field_bankcardTail = cursor.getString(i);
                } else if (gFD == hashCode) {
                    this.field_supportTag = cursor.getInt(i);
                } else if (gFE == hashCode) {
                    this.field_mobile = cursor.getString(i);
                } else if (gFF == hashCode) {
                    this.field_trueName = cursor.getString(i);
                } else if (gnU == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (gFG == hashCode) {
                    this.field_bankPhone = cursor.getString(i);
                } else if (gFH == hashCode) {
                    this.field_bizUsername = cursor.getString(i);
                } else if (gFI == hashCode) {
                    this.field_onceQuotaKind = cursor.getDouble(i);
                } else if (gFJ == hashCode) {
                    this.field_onceQuotaVirtual = cursor.getDouble(i);
                } else if (gFK == hashCode) {
                    this.field_dayQuotaKind = cursor.getDouble(i);
                } else if (gFL == hashCode) {
                    this.field_dayQuotaVirtual = cursor.getDouble(i);
                } else if (gFM == hashCode) {
                    this.field_fetchArriveTime = cursor.getLong(i);
                } else if (gFN == hashCode) {
                    this.field_fetchArriveTimeWording = cursor.getString(i);
                } else if (gFO == hashCode) {
                    this.field_repay_url = cursor.getString(i);
                } else if (gFP == hashCode) {
                    this.field_wxcreditState = cursor.getInt(i);
                } else if (gFQ == hashCode) {
                    this.field_bankcardClientType = cursor.getInt(i);
                } else if (gFR == hashCode) {
                    this.field_ext_msg = cursor.getString(i);
                } else if (gFS == hashCode) {
                    this.field_support_micropay = cursor.getInt(i) != 0;
                } else if (gFT == hashCode) {
                    this.field_arrive_type = cursor.getString(i);
                } else if (gFU == hashCode) {
                    this.field_avail_save_wording = cursor.getString(i);
                } else if (gFV == hashCode) {
                    this.field_fetch_charge_rate = cursor.getDouble(i);
                } else if (gFW == hashCode) {
                    this.field_full_fetch_charge_fee = cursor.getDouble(i);
                } else if (gFX == hashCode) {
                    this.field_fetch_charge_info = cursor.getString(i);
                } else if (gxi == hashCode) {
                    this.field_tips = cursor.getString(i);
                } else if (gFY == hashCode) {
                    this.field_forbid_title = cursor.getString(i);
                } else if (gFZ == hashCode) {
                    this.field_forbid_url = cursor.getString(i);
                } else if (gGa == hashCode) {
                    this.field_no_micro_word = cursor.getString(i);
                } else if (gGb == hashCode) {
                    this.field_card_bottom_wording = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gEM) {
            contentValues.put("bindSerial", this.field_bindSerial);
        }
        if (this.gEN) {
            contentValues.put("cardType", Integer.valueOf(this.field_cardType));
        }
        if (this.gEO) {
            contentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
        }
        if (this.gEP) {
            contentValues.put("forbidWord", this.field_forbidWord);
        }
        if (this.gEQ) {
            contentValues.put("bankName", this.field_bankName);
        }
        if (this.gER) {
            contentValues.put("bankcardType", this.field_bankcardType);
        }
        if (this.gES) {
            contentValues.put("bankcardTypeName", this.field_bankcardTypeName);
        }
        if (this.gET) {
            contentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
        }
        if (this.gEU) {
            contentValues.put("bankcardTail", this.field_bankcardTail);
        }
        if (this.gEV) {
            contentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
        }
        if (this.gEW) {
            contentValues.put("mobile", this.field_mobile);
        }
        if (this.gEX) {
            contentValues.put("trueName", this.field_trueName);
        }
        if (this.gnQ) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.gEY) {
            contentValues.put("bankPhone", this.field_bankPhone);
        }
        if (this.gEZ) {
            contentValues.put("bizUsername", this.field_bizUsername);
        }
        if (this.gFa) {
            contentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
        }
        if (this.gFb) {
            contentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
        }
        if (this.gFc) {
            contentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
        }
        if (this.gFd) {
            contentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
        }
        if (this.gFe) {
            contentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
        }
        if (this.gFf) {
            contentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
        }
        if (this.gFg) {
            contentValues.put("repay_url", this.field_repay_url);
        }
        if (this.gFh) {
            contentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
        }
        if (this.gFi) {
            contentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
        }
        if (this.gFj) {
            contentValues.put("ext_msg", this.field_ext_msg);
        }
        if (this.gFk) {
            contentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
        }
        if (this.gFl) {
            contentValues.put("arrive_type", this.field_arrive_type);
        }
        if (this.gFm) {
            contentValues.put("avail_save_wording", this.field_avail_save_wording);
        }
        if (this.gFn) {
            contentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
        }
        if (this.gFo) {
            contentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
        }
        if (this.gFp) {
            contentValues.put("fetch_charge_info", this.field_fetch_charge_info);
        }
        if (this.gxc) {
            contentValues.put("tips", this.field_tips);
        }
        if (this.gFq) {
            contentValues.put("forbid_title", this.field_forbid_title);
        }
        if (this.gFr) {
            contentValues.put("forbid_url", this.field_forbid_url);
        }
        if (this.gFs) {
            contentValues.put("no_micro_word", this.field_no_micro_word);
        }
        if (this.gFt) {
            contentValues.put("card_bottom_wording", this.field_card_bottom_wording);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
