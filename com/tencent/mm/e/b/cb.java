package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.aiq;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.bpx;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;

public abstract class cb extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gwO = "appIdHash".hashCode();
    private static final int gwP = "launchAction".hashCode();
    private static final int gwQ = "jsapiInfo".hashCode();
    private static final int gwR = "hostInfo".hashCode();
    private static final int gwS = "actionsheetInfo".hashCode();
    public av field_actionsheetInfo;
    public String field_appId;
    public int field_appIdHash;
    public bpx field_hostInfo;
    public kp field_jsapiInfo;
    public aiq field_launchAction;
    private boolean gcu = true;
    private boolean gwJ = true;
    private boolean gwK = true;
    private boolean gwL = true;
    private boolean gwM = true;
    private boolean gwN = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gwO == hashCode) {
                    this.field_appIdHash = cursor.getInt(i);
                    this.gwJ = true;
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gwP == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_launchAction = (aiq) new aiq().aD(r0);
                        }
                    } catch (IOException e) {
                        w.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e.getMessage());
                    }
                } else if (gwQ == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_jsapiInfo = (kp) new kp().aD(r0);
                        }
                    } catch (IOException e2) {
                        w.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e2.getMessage());
                    }
                } else if (gwR == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_hostInfo = (bpx) new bpx().aD(r0);
                        }
                    } catch (IOException e22) {
                        w.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e22.getMessage());
                    }
                } else if (gwS == hashCode) {
                    try {
                        r0 = cursor.getBlob(i);
                        if (r0 != null && r0.length > 0) {
                            this.field_actionsheetInfo = (av) new av().aD(r0);
                        }
                    } catch (IOException e222) {
                        w.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e222.getMessage());
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
        if (this.gwK && this.field_launchAction != null) {
            try {
                contentValues.put("launchAction", this.field_launchAction.toByteArray());
            } catch (IOException e) {
                w.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e.getMessage());
            }
        }
        if (this.gwL && this.field_jsapiInfo != null) {
            try {
                contentValues.put("jsapiInfo", this.field_jsapiInfo.toByteArray());
            } catch (IOException e2) {
                w.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e2.getMessage());
            }
        }
        if (this.gwM && this.field_hostInfo != null) {
            try {
                contentValues.put("hostInfo", this.field_hostInfo.toByteArray());
            } catch (IOException e22) {
                w.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e22.getMessage());
            }
        }
        if (this.gwN && this.field_actionsheetInfo != null) {
            try {
                contentValues.put("actionsheetInfo", this.field_actionsheetInfo.toByteArray());
            } catch (IOException e222) {
                w.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e222.getMessage());
            }
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
