package com.tencent.mm.plugin.webview.d;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class a {
    public static void d(MMActivity mMActivity, String str) {
        if (mMActivity != null && !mMActivity.isFinishing() && !bg.mA(str)) {
            if (!(str.startsWith("http://") || str.startsWith("https://"))) {
                str = "http://" + str;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            try {
                if (bg.Hp()) {
                    mMActivity.startActivity(intent);
                } else {
                    mMActivity.startActivityForResult(a(mMActivity, intent, str), 2);
                }
            } catch (Exception e) {
                w.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[]{e.getMessage()});
            }
        }
    }

    public static Intent a(MMActivity mMActivity, Intent intent, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("targeturl", str);
        bundle.putParcelable("targetintent", intent);
        Intent intent2 = new Intent();
        intent2.setClass(mMActivity, AppChooserUI.class);
        intent2.putExtra("scene", 4);
        intent2.putExtra(Columns.TYPE, 0);
        intent2.putExtra("title", mMActivity.getString(R.l.dWb));
        intent2.putExtra("targetintent", intent);
        intent2.putExtra("transferback", bundle);
        return intent2;
    }

    public static boolean a(MMActivity mMActivity, int i, int i2, Intent intent) {
        if (2 != i) {
            return false;
        }
        if (-1 == i2 && intent != null) {
            String stringExtra = intent.getStringExtra("selectpkg");
            Bundle bundleExtra = intent.getBundleExtra("transferback");
            boolean booleanExtra = intent.getBooleanExtra("isalways", false);
            w.i("MicroMsg.BrowserChooserHelper", "App Chooser Browser is %s", new Object[]{stringExtra});
            u.bCJ();
            q qVar = (q) u.t(0, null);
            Intent intent2;
            if (qVar.LN(stringExtra)) {
                if (qVar.dt(mMActivity)) {
                    q.aP(mMActivity, bundleExtra.getString("targeturl"));
                } else {
                    intent2 = new Intent((Intent) bundleExtra.getParcelable("targetintent"));
                    intent2.setPackage(stringExtra);
                    intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                    mMActivity.startActivity(intent2);
                }
                if (booleanExtra) {
                    g.oUh.i(10998, new Object[]{Integer.valueOf(4), Integer.valueOf(2)});
                } else {
                    g.oUh.i(10998, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
                }
            } else {
                intent2 = new Intent((Intent) bundleExtra.getParcelable("targetintent"));
                intent2.setPackage(stringExtra);
                intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                mMActivity.startActivity(intent2);
                g.oUh.i(10998, new Object[]{Integer.valueOf(5)});
                if (booleanExtra) {
                    g.oUh.i(10998, new Object[]{Integer.valueOf(5), Integer.valueOf(2)});
                } else {
                    g.oUh.i(10998, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                }
            }
        }
        return true;
    }
}
