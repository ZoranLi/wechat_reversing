package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.IOException;

public abstract class bh extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int geb = "version".hashCode();
    private static final int grR = "cgi".hashCode();
    private static final int grS = "cmdid".hashCode();
    private static final int grT = "functionmsgid".hashCode();
    private static final int grU = "preVersion".hashCode();
    private static final int grV = "retryinterval".hashCode();
    private static final int grW = "reportid".hashCode();
    private static final int grX = "successkey".hashCode();
    private static final int grY = "failkey".hashCode();
    private static final int grZ = "finalfailkey".hashCode();
    private static final int gsa = "custombuff".hashCode();
    private static final int gsb = "addMsg".hashCode();
    private static final int gsc = "needShow".hashCode();
    public bu field_addMsg;
    public String field_cgi;
    public int field_cmdid;
    public String field_custombuff;
    public int field_failkey;
    public int field_finalfailkey;
    public String field_functionmsgid;
    public boolean field_needShow;
    public long field_preVersion;
    public int field_reportid;
    public int field_retryinterval;
    public int field_status;
    public int field_successkey;
    public long field_version;
    private boolean gaW = true;
    private boolean gdU = true;
    private boolean grF = true;
    private boolean grG = true;
    private boolean grH = true;
    private boolean grI = true;
    private boolean grJ = true;
    private boolean grK = true;
    private boolean grL = true;
    private boolean grM = true;
    private boolean grN = true;
    private boolean grO = true;
    private boolean grP = true;
    private boolean grQ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (grR == hashCode) {
                    this.field_cgi = cursor.getString(i);
                } else if (grS == hashCode) {
                    this.field_cmdid = cursor.getInt(i);
                } else if (grT == hashCode) {
                    this.field_functionmsgid = cursor.getString(i);
                    this.grH = true;
                } else if (geb == hashCode) {
                    this.field_version = cursor.getLong(i);
                } else if (grU == hashCode) {
                    this.field_preVersion = cursor.getLong(i);
                } else if (grV == hashCode) {
                    this.field_retryinterval = cursor.getInt(i);
                } else if (grW == hashCode) {
                    this.field_reportid = cursor.getInt(i);
                } else if (grX == hashCode) {
                    this.field_successkey = cursor.getInt(i);
                } else if (grY == hashCode) {
                    this.field_failkey = cursor.getInt(i);
                } else if (grZ == hashCode) {
                    this.field_finalfailkey = cursor.getInt(i);
                } else if (gsa == hashCode) {
                    this.field_custombuff = cursor.getString(i);
                } else if (gsb == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_addMsg = (bu) new bu().aD(blob);
                        }
                    } catch (IOException e) {
                        w.e("MicroMsg.SDK.BaseFunctionMsgItem", e.getMessage());
                    }
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gsc == hashCode) {
                    this.field_needShow = cursor.getInt(i) != 0;
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.grF) {
            contentValues.put("cgi", this.field_cgi);
        }
        if (this.grG) {
            contentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
        }
        if (this.grH) {
            contentValues.put("functionmsgid", this.field_functionmsgid);
        }
        if (this.gdU) {
            contentValues.put("version", Long.valueOf(this.field_version));
        }
        if (this.grI) {
            contentValues.put("preVersion", Long.valueOf(this.field_preVersion));
        }
        if (this.grJ) {
            contentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
        }
        if (this.grK) {
            contentValues.put("reportid", Integer.valueOf(this.field_reportid));
        }
        if (this.grL) {
            contentValues.put("successkey", Integer.valueOf(this.field_successkey));
        }
        if (this.grM) {
            contentValues.put("failkey", Integer.valueOf(this.field_failkey));
        }
        if (this.grN) {
            contentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
        }
        if (this.grO) {
            contentValues.put("custombuff", this.field_custombuff);
        }
        if (this.grP && this.field_addMsg != null) {
            try {
                contentValues.put("addMsg", this.field_addMsg.toByteArray());
            } catch (IOException e) {
                w.e("MicroMsg.SDK.BaseFunctionMsgItem", e.getMessage());
            }
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.grQ) {
            contentValues.put("needShow", Boolean.valueOf(this.field_needShow));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
