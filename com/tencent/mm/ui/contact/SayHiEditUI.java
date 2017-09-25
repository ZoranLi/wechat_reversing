package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l.b;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.LinkedList;
import java.util.List;

public class SayHiEditUI extends MMActivity implements e {
    private ProgressDialog isv = null;
    private MMEditText vZl;

    static /* synthetic */ String a(SayHiEditUI sayHiEditUI) {
        String trim = sayHiEditUI.vZl.getText().toString().trim();
        return trim.length() <= 50 ? trim : trim.substring(0, 50);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(30, this);
        zi(R.l.eCX);
        KC();
    }

    protected final int getLayoutId() {
        return R.i.dmL;
    }

    public void onDestroy() {
        ap.vd().b(30, this);
        super.onDestroy();
    }

    protected final void KC() {
        this.vZl = (MMEditText) findViewById(R.h.czF);
        c.d(this.vZl).Ch(100).a(null);
        final String stringExtra = getIntent().getStringExtra("Contact_User");
        final int intExtra = getIntent().getIntExtra("Contact_Scene", 18);
        a(0, getString(R.l.dIA), new OnMenuItemClickListener(this) {
            final /* synthetic */ SayHiEditUI vZn;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vZn.aHf();
                List linkedList = new LinkedList();
                linkedList.add(stringExtra);
                List linkedList2 = new LinkedList();
                linkedList2.add(Integer.valueOf(intExtra));
                final k nVar = new n(2, linkedList, linkedList2, SayHiEditUI.a(this.vZn), "");
                ap.vd().a(nVar, 0);
                SayHiEditUI sayHiEditUI = this.vZn;
                Context context = this.vZn.uSU.uTo;
                this.vZn.getString(R.l.dIO);
                sayHiEditUI.isv = g.a(context, this.vZn.getString(R.l.eRm), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass1 vZo;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(nVar);
                    }
                });
                return false;
            }
        }, b.uTY);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SayHiEditUI vZn;

            {
                this.vZn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vZn.finish();
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj = 1;
        w.i("MicroMsg.SayHiEditUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
            switch (i2) {
                case -34:
                case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                    Toast.makeText(this, R.l.eDa, 0).show();
                    break;
                case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                    Toast.makeText(this, R.l.eCY, 0).show();
                    break;
                default:
                    obj = null;
                    break;
            }
            if (obj == null) {
                if (i == 0 && i2 == 0) {
                    g.bl(this, getString(R.l.dXl));
                    finish();
                } else if (i == 4 && i2 == -24 && !u.mA(str)) {
                    Toast.makeText(this, str, 1).show();
                } else if (i2 != -101 || u.mA(str)) {
                    Toast.makeText(this, R.l.eCZ, 0).show();
                } else {
                    g.a(this, str, getString(R.l.dIO), getString(R.l.dHT), null);
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.SayHiEditUI", "exception in onSceneEnd : " + e.getMessage());
        }
    }
}
