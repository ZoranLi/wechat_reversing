package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.bpj;
import com.tencent.mm.protocal.c.bpk;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;

public abstract class cc extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gdM = "versionInfo".hashCode();
    private static final int gwO = "appIdHash".hashCode();
    private static final int gwP = "launchAction".hashCode();
    private static final int gwW = "pkgType".hashCode();
    private static final int gwX = "widgetType".hashCode();
    private static final int gwY = "jsApiInfo".hashCode();
    public String field_appId;
    public int field_appIdHash;
    public kp field_jsApiInfo;
    public bpj field_launchAction;
    public int field_pkgType;
    public bpk field_versionInfo;
    public int field_widgetType;
    private boolean gcu = true;
    private boolean gdz = true;
    private boolean gwJ = true;
    private boolean gwK = true;
    private boolean gwT = true;
    private boolean gwU = true;
    private boolean gwV = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gwO == hashCode) {
                    this.field_appIdHash = cursor.getInt(i);
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gwW == hashCode) {
                    this.field_pkgType = cursor.getInt(i);
                } else if (gwX == hashCode) {
                    this.field_widgetType = cursor.getInt(i);
                } else if (gwP == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_launchAction = (bpj) new bpj().aD(r0);
                        }
                    } catch (IOException e) {
                        w.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e.getMessage());
                    }
                } else if (gwY == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_jsApiInfo = (kp) new kp().aD(r0);
                        }
                    } catch (IOException e2) {
                        w.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e2.getMessage());
                    }
                } else if (gdM == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_versionInfo = (bpk) new bpk().aD(r0);
                        }
                    } catch (IOException e22) {
                        w.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e22.getMessage());
                    }
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gwJ) {
            contentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gwT) {
            contentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
        }
        if (this.gwU) {
            contentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
        }
        if (this.gwK && this.field_launchAction != null) {
            try {
                contentValues.put("launchAction", this.field_launchAction.toByteArray());
            } catch (IOException e) {
                w.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e.getMessage());
            }
        }
        if (this.gwV && this.field_jsApiInfo != null) {
            try {
                contentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
            } catch (IOException e2) {
                w.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e2.getMessage());
            }
        }
        if (this.gdz && this.field_versionInfo != null) {
            try {
                contentValues.put("versionInfo", this.field_versionInfo.toByteArray());
            } catch (IOException e22) {
                w.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e22.getMessage());
            }
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
