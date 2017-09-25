package com.tencent.mm.plugin.webwx.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webwx.a.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMBaseActivity;

public class WebWXPopupUnlockUI extends MMBaseActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            CharSequence stringExtra = getIntent().getStringExtra("deviceName");
            if (stringExtra != null) {
                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(1);
                View inflate = View.inflate(this, R.i.dca, null);
                TextView textView = (TextView) inflate.findViewById(R.h.bIT);
                ((TextView) inflate.findViewById(R.h.cKH)).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WebWXPopupUnlockUI ssi;

                    public final void onClick(View view) {
                        ap.vd().a(new a(2), 0);
                        w.d("MicroMsg.WebWxPopUnlockUI", "doScene netSceneExtDeviceControl : UNLOCK");
                        com.tencent.mm.plugin.webwx.a.imw.cT(1);
                        w.d("MicroMsg.WebWxPopUnlockUI", "trigger netSceneSync notify");
                        dialog.dismiss();
                    }
                });
                dialog.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ WebWXPopupUnlockUI ssi;

                    {
                        this.ssi = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.ssi.finish();
                    }
                });
                textView.setText(stringExtra);
                dialog.setContentView(inflate);
                dialog.show();
                return;
            }
            w.w("MicroMsg.WebWxPopUnlockUI", "Mac WeChat request to unlock,the deviceName is null");
        }
    }
}
