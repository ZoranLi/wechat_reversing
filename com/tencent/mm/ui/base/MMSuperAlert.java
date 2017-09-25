package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;

@a(3)
public class MMSuperAlert extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.heG);
        final int intExtra = getIntent().getIntExtra("MMSuperAlert_msg", 0);
        final int intExtra2 = getIntent().getIntExtra("MMSuperAlert_title", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("MMSuperAlert_cancelable", true);
        new ae().postDelayed(new Runnable(this) {
            final /* synthetic */ MMSuperAlert vmw;

            public final void run() {
                g.a(this.vmw, intExtra == 0 ? "" : this.vmw.getString(intExtra), intExtra2 == 0 ? "" : this.vmw.getString(intExtra2), booleanExtra, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 vmx;

                    {
                        this.vmx = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.vmx.vmw.finish();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 vmx;

                    {
                        this.vmx = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.vmx.vmw.finish();
                    }
                });
            }
        }, 50);
    }

    public static void i(Context context, int i, int i2) {
        Intent intent = new Intent(context, MMSuperAlert.class);
        intent.putExtra("MMSuperAlert_title", i);
        intent.putExtra("MMSuperAlert_msg", i2);
        intent.putExtra("MMSuperAlert_cancelable", false);
        context.startActivity(intent);
    }

    public Resources getResources() {
        if (getAssets() == null || ab.getResources() == null) {
            return super.getResources();
        }
        return ab.getResources();
    }
}
