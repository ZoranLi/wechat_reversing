package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

public abstract class dr extends c {
    private static final int gHA = "cre_name".hashCode();
    private static final int gHB = "lqt_state".hashCode();
    private static final int gHm = OpenSDKTool4Assistant.EXTRA_UIN.hashCode();
    private static final int gHn = "is_reg".hashCode();
    private static final int gHo = "true_name".hashCode();
    private static final int gHp = "card_num".hashCode();
    private static final int gHq = "isDomesticUser".hashCode();
    private static final int gHr = "cre_type".hashCode();
    private static final int gHs = "main_card_bind_serialno".hashCode();
    private static final int gHt = "ftf_pay_url".hashCode();
    private static final int gHu = "switchConfig".hashCode();
    private static final int gHv = "reset_passwd_flag".hashCode();
    private static final int gHw = "find_passwd_url".hashCode();
    private static final int gHx = "is_open_touch".hashCode();
    private static final int gHy = "lct_wording".hashCode();
    private static final int gHz = "lct_url".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    public int field_card_num;
    public String field_cre_name;
    public int field_cre_type;
    public String field_find_passwd_url;
    public String field_ftf_pay_url;
    public boolean field_isDomesticUser;
    public int field_is_open_touch;
    public int field_is_reg;
    public String field_lct_url;
    public String field_lct_wording;
    public int field_lqt_state;
    public String field_main_card_bind_serialno;
    public String field_reset_passwd_flag;
    public int field_switchConfig;
    public String field_true_name;
    public String field_uin;
    private boolean gGW = true;
    private boolean gGX = true;
    private boolean gGY = true;
    private boolean gGZ = true;
    private boolean gHa = true;
    private boolean gHb = true;
    private boolean gHc = true;
    private boolean gHd = true;
    private boolean gHe = true;
    private boolean gHf = true;
    private boolean gHg = true;
    private boolean gHh = true;
    private boolean gHi = true;
    private boolean gHj = true;
    private boolean gHk = true;
    private boolean gHl = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gHm == hashCode) {
                    this.field_uin = cursor.getString(i);
                    this.gGW = true;
                } else if (gHn == hashCode) {
                    this.field_is_reg = cursor.getInt(i);
                } else if (gHo == hashCode) {
                    this.field_true_name = cursor.getString(i);
                } else if (gHp == hashCode) {
                    this.field_card_num = cursor.getInt(i);
                } else if (gHq == hashCode) {
                    this.field_isDomesticUser = cursor.getInt(i) != 0;
                } else if (gHr == hashCode) {
                    this.field_cre_type = cursor.getInt(i);
                } else if (gHs == hashCode) {
                    this.field_main_card_bind_serialno = cursor.getString(i);
                } else if (gHt == hashCode) {
                    this.field_ftf_pay_url = cursor.getString(i);
                } else if (gHu == hashCode) {
                    this.field_switchConfig = cursor.getInt(i);
                } else if (gHv == hashCode) {
                    this.field_reset_passwd_flag = cursor.getString(i);
                } else if (gHw == hashCode) {
                    this.field_find_passwd_url = cursor.getString(i);
                } else if (gHx == hashCode) {
                    this.field_is_open_touch = cursor.getInt(i);
                } else if (gHy == hashCode) {
                    this.field_lct_wording = cursor.getString(i);
                } else if (gHz == hashCode) {
                    this.field_lct_url = cursor.getString(i);
                } else if (gHA == hashCode) {
                    this.field_cre_name = cursor.getString(i);
                } else if (gHB == hashCode) {
                    this.field_lqt_state = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gGW) {
            contentValues.put(OpenSDKTool4Assistant.EXTRA_UIN, this.field_uin);
        }
        if (this.gGX) {
            contentValues.put("is_reg", Integer.valueOf(this.field_is_reg));
        }
        if (this.gGY) {
            contentValues.put("true_name", this.field_true_name);
        }
        if (this.gGZ) {
            contentValues.put("card_num", Integer.valueOf(this.field_card_num));
        }
        if (this.gHa) {
            contentValues.put("isDomesticUser", Boolean.valueOf(this.field_isDomesticUser));
        }
        if (this.gHb) {
            contentValues.put("cre_type", Integer.valueOf(this.field_cre_type));
        }
        if (this.gHc) {
            contentValues.put("main_card_bind_serialno", this.field_main_card_bind_serialno);
        }
        if (this.gHd) {
            contentValues.put("ftf_pay_url", this.field_ftf_pay_url);
        }
        if (this.gHe) {
            contentValues.put("switchConfig", Integer.valueOf(this.field_switchConfig));
        }
        if (this.gHf) {
            contentValues.put("reset_passwd_flag", this.field_reset_passwd_flag);
        }
        if (this.gHg) {
            contentValues.put("find_passwd_url", this.field_find_passwd_url);
        }
        if (this.gHh) {
            contentValues.put("is_open_touch", Integer.valueOf(this.field_is_open_touch));
        }
        if (this.gHi) {
            contentValues.put("lct_wording", this.field_lct_wording);
        }
        if (this.gHj) {
            contentValues.put("lct_url", this.field_lct_url);
        }
        if (this.gHk) {
            contentValues.put("cre_name", this.field_cre_name);
        }
        if (this.gHl) {
            contentValues.put("lqt_state", Integer.valueOf(this.field_lqt_state));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
