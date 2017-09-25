package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;

public abstract class bf extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int giB = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int grA = "verifyResult".hashCode();
    private static final int gro = "ssidmd5".hashCode();
    private static final int grp = "ssid".hashCode();
    private static final int grq = "mid".hashCode();
    private static final int grr = "connectState".hashCode();
    private static final int grs = "expiredTime".hashCode();
    private static final int grt = "wifiType".hashCode();
    private static final int gru = "action".hashCode();
    private static final int grv = "showUrl".hashCode();
    private static final int grw = "showWordEn".hashCode();
    private static final int grx = "showWordCn".hashCode();
    private static final int gry = "showWordTw".hashCode();
    private static final int grz = "mac".hashCode();
    public int field_action;
    public int field_connectState;
    public long field_expiredTime;
    public String field_mac;
    public String field_mid;
    public String field_showUrl;
    public String field_showWordCn;
    public String field_showWordEn;
    public String field_showWordTw;
    public String field_ssid;
    public String field_ssidmd5;
    public String field_url;
    public int field_verifyResult;
    public int field_wifiType;
    private boolean gii = true;
    private boolean grb = true;
    private boolean grc = true;
    private boolean grd = true;
    private boolean gre = true;
    private boolean grf = true;
    private boolean grg = true;
    private boolean grh = true;
    private boolean gri = true;
    private boolean grj = true;
    private boolean grk = true;
    private boolean grl = true;
    private boolean grm = true;
    private boolean grn = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gro == hashCode) {
                    this.field_ssidmd5 = cursor.getString(i);
                    this.grb = true;
                } else if (grp == hashCode) {
                    this.field_ssid = cursor.getString(i);
                } else if (grq == hashCode) {
                    this.field_mid = cursor.getString(i);
                } else if (giB == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (grr == hashCode) {
                    this.field_connectState = cursor.getInt(i);
                } else if (grs == hashCode) {
                    this.field_expiredTime = cursor.getLong(i);
                } else if (grt == hashCode) {
                    this.field_wifiType = cursor.getInt(i);
                } else if (gru == hashCode) {
                    this.field_action = cursor.getInt(i);
                } else if (grv == hashCode) {
                    this.field_showUrl = cursor.getString(i);
                } else if (grw == hashCode) {
                    this.field_showWordEn = cursor.getString(i);
                } else if (grx == hashCode) {
                    this.field_showWordCn = cursor.getString(i);
                } else if (gry == hashCode) {
                    this.field_showWordTw = cursor.getString(i);
                } else if (grz == hashCode) {
                    this.field_mac = cursor.getString(i);
                } else if (grA == hashCode) {
                    this.field_verifyResult = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.grb) {
            contentValues.put("ssidmd5", this.field_ssidmd5);
        }
        if (this.grc) {
            contentValues.put("ssid", this.field_ssid);
        }
        if (this.grd) {
            contentValues.put("mid", this.field_mid);
        }
        if (this.gii) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.gre) {
            contentValues.put("connectState", Integer.valueOf(this.field_connectState));
        }
        if (this.grf) {
            contentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
        }
        if (this.grg) {
            contentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
        }
        if (this.grh) {
            contentValues.put("action", Integer.valueOf(this.field_action));
        }
        if (this.gri) {
            contentValues.put("showUrl", this.field_showUrl);
        }
        if (this.grj) {
            contentValues.put("showWordEn", this.field_showWordEn);
        }
        if (this.grk) {
            contentValues.put("showWordCn", this.field_showWordCn);
        }
        if (this.grl) {
            contentValues.put("showWordTw", this.field_showWordTw);
        }
        if (this.grm) {
            contentValues.put("mac", this.field_mac);
        }
        if (this.grn) {
            contentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
