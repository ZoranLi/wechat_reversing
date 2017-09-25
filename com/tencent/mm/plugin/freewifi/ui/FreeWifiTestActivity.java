package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.g;

public class FreeWifiTestActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.i.ddA);
        findViewById(R.h.bRQ).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiTestActivity lXL;

            {
                this.lXL = r1;
            }

            public final void onClick(View view) {
                Toast.makeText(ab.getContext(), "test message", 0).show();
            }
        });
        findViewById(R.h.bRR).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiTestActivity lXL;

            {
                this.lXL = r1;
            }

            public final void onClick(View view) {
                g.a(this.lXL, "t12345", "t54331", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 lXM;

                    {
                        this.lXM = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, null);
            }
        });
    }
}
