package com.tencent.mm.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.x;

public class PermissionWarningDialog extends MMBaseActivity {
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
        if (getIntent() == null) {
            w.e("MicroMsg.PermissionWarningDialog", "Intent is null");
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            w.e("MicroMsg.PermissionWarningDialog", "invalid params");
            return;
        }
        int i = extras.getInt("warning_type", 0);
        a aVar;
        if (1 == i) {
            aVar = new a(this);
            aVar.SW(extras.getString("warning_title"));
            aVar.SX(extras.getString("warning_content"));
            aVar.zZ(R.l.dHw).a(new OnClickListener(this) {
                final /* synthetic */ PermissionWarningDialog ihx;

                {
                    this.ihx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.ihx.finish();
                }
            });
            this.ihw = aVar.WJ();
            this.ihw.setCanceledOnTouchOutside(false);
            this.ihw.show();
        } else if (2 == i) {
            aVar = new a(this);
            final boolean z = extras.getBoolean("warning_filter", false);
            final boolean z2 = extras.getBoolean("warning_due2Exception", false);
            aVar.zW(R.l.dIh);
            aVar.SX(getString(R.l.dIc));
            aVar.Aa(R.l.dGs).b(new OnClickListener(this) {
                final /* synthetic */ PermissionWarningDialog ihx;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.bB(z2);
                    this.ihx.finish();
                }
            });
            aVar.zZ(R.l.dHW).a(new OnClickListener(this) {
                final /* synthetic */ PermissionWarningDialog ihx;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.e(z, z2);
                    this.ihx.finish();
                }
            });
            this.ihw = aVar.WJ();
            this.ihw.setCanceledOnTouchOutside(false);
            this.ihw.show();
        }
    }

    public static void i(Context context, String str, String str2) {
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 1);
        intent.putExtra("warning_title", str);
        intent.putExtra("warning_content", str2);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }

    public static void a(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 2);
        intent.putExtra("warning_filter", z);
        intent.putExtra("warning_due2Exception", z2);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
