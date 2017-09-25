package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.x;

public class JDRemindDialog extends MMBaseActivity {
    private h ihw = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Nj();
    }

    protected void onResume() {
        super.onResume();
        x.a(true, null);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.ihw != null) {
            this.ihw.dismiss();
            this.ihw = null;
        }
        Nj();
    }

    protected void onPause() {
        super.onPause();
        x.a(false, null);
    }

    private void Nj() {
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                a aVar = new a(this);
                aVar.SW("");
                aVar.SX(extras.getString("alertcontent"));
                aVar.SZ(extras.getString("alertconfirm")).a(new OnClickListener(this) {
                    final /* synthetic */ JDRemindDialog qSs;

                    {
                        this.qSs = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String str = null;
                        String str2 = "";
                        if (!(this.qSs.getIntent() == null || this.qSs.getIntent().getExtras() == null)) {
                            str = this.qSs.getIntent().getExtras().getString("alertjumpurl");
                            str2 = this.qSs.getIntent().getExtras().getString("alert_activityid");
                        }
                        if (str2.equals(c.bmM().bmR().qSx) && c.bmM().bmN()) {
                            c.bmM().bmQ();
                            c.bmM().bmP();
                        }
                        if (!bg.mA(str)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("useJs", true);
                            intent.putExtra("vertical_scroll", true);
                            d.b(this.qSs, "webview", ".ui.tools.WebViewUI", intent);
                            g.oUh.i(11179, str, c.bmM().bmR().qSx, Integer.valueOf(5));
                        }
                        this.qSs.finish();
                    }
                });
                aVar.Ta(extras.getString("alert_cancel")).b(new OnClickListener(this) {
                    final /* synthetic */ JDRemindDialog qSs;

                    {
                        this.qSs = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.qSs.finish();
                    }
                });
                this.ihw = aVar.WJ();
                this.ihw.setCanceledOnTouchOutside(false);
                this.ihw.show();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, JDRemindDialog.class);
        intent.putExtra("alertcontent", str);
        intent.putExtra("alertconfirm", str2);
        intent.putExtra("alert_cancel", str3);
        intent.putExtra("alertjumpurl", str4);
        intent.putExtra("alert_activityid", str5);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
