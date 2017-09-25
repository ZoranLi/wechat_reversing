package com.tencent.mm.plugin.extqlauncher.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.extqlauncher.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public class ExtControlProviderQLauncher extends ExtContentProviderBase {
    private static final UriMatcher lqF;
    private static final String[] lqe = new String[]{"retCode"};
    private static final String[] lsb = new String[]{SlookAirButtonFrequentContactAdapter.ID, "count"};
    private Context context;
    private String[] lqq;
    private int lsc = -1;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        lqF = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.extqlauncher", "openQRCodeScan", 18);
        lqF.addURI("com.tencent.mm.plugin.extqlauncher", "batchAddShortcut", 19);
        lqF.addURI("com.tencent.mm.plugin.extqlauncher", "getUnreadCount", 20);
    }

    public ExtControlProviderQLauncher(String[] strArr, int i, Context context) {
        this.lqq = strArr;
        this.lsc = i;
        this.context = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        w.d("MicroMsg.ExtControlProviderQLauncher", "query()");
        a(uri, this.context, this.lsc, this.lqq);
        if (uri == null) {
            md(3);
            return null;
        } else if (bg.mA(this.lqz) || bg.mA(aqX())) {
            md(3);
            return null;
        } else if (!acK()) {
            md(1);
            return this.jPp;
        } else if (bW(this.context)) {
            Cursor matrixCursor;
            switch (this.lsc) {
                case 18:
                    w.d("MicroMsg.ExtControlProviderQLauncher", "toScanQRCode");
                    if (this.context == null) {
                        md(4);
                        return null;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                    matrixCursor = new MatrixCursor(lqe);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(1)});
                    md(0);
                    return matrixCursor;
                case 19:
                    w.d("MicroMsg.ExtControlProviderQLauncher", "toCreateShortcut");
                    if (this.context == null) {
                        md(4);
                        return null;
                    }
                    d.b(this.context, "extqlauncher", ".ui.QLauncherCreateShortcutUI", new Intent());
                    matrixCursor = new MatrixCursor(lqe);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(1)});
                    md(0);
                    return matrixCursor;
                case 20:
                    return r(strArr2);
                default:
                    md(3);
                    return null;
            }
        } else {
            w.w("MicroMsg.ExtControlProviderQLauncher", "invalid appid ! return null");
            md(2);
            return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor r(String[] strArr) {
        w.d("MicroMsg.ExtControlProviderQLauncher", "getUnreadCount");
        if (this.context == null) {
            md(4);
            return null;
        } else if (strArr == null || strArr.length <= 0) {
            w.e("MicroMsg.ExtControlProviderQLauncher", "wrong args");
            md(3);
            return null;
        } else {
            MatrixCursor matrixCursor = new MatrixCursor(lsb);
            int i = 0;
            while (i < strArr.length && i < 10) {
                try {
                    if (!bg.mA(strArr[i])) {
                        if (strArr[i].equals("0")) {
                            Object[] objArr = new Object[2];
                            objArr[0] = strArr[i];
                            b.arf();
                            objArr[1] = Integer.valueOf(b.arg());
                            matrixCursor.addRow(objArr);
                        } else {
                            String rP = c.rP(strArr[i]);
                            if (bg.mA(rP)) {
                                continue;
                            } else {
                                ap.yY();
                                if (com.tencent.mm.u.c.wW().Rm(rP) != null) {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(com.tencent.mm.u.c.wW().Rm(rP).field_unReadCount)});
                                } else {
                                    matrixCursor.addRow(new Object[]{strArr[i], Integer.valueOf(0)});
                                }
                            }
                        }
                    }
                    i++;
                } catch (Exception e) {
                    w.e("MicroMsg.ExtControlProviderQLauncher", "exception in updateShortcut, %s", new Object[]{e.getMessage()});
                    md(4);
                    matrixCursor.close();
                    return null;
                }
            }
            md(0);
            return matrixCursor;
        }
    }
}
