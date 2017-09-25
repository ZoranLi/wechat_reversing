package com.tencent.mm.performance.wxperformancetool;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.bl.b;
import com.tencent.mm.performance.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

@TargetApi(17)
public class MemoryLeakActivity extends Activity {
    private String igL;
    private AlertDialog igT;
    private ae mHandler = new ae(this) {
        final /* synthetic */ MemoryLeakActivity igU;

        {
            this.igU = r1;
        }

        public final void handleMessage(Message message) {
            if (((WeakReference) d.ihc.get(this.igU.igL)).get() == null) {
                this.igU.finish();
            } else {
                this.igU.igT.show();
            }
        }
    };

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.cVc);
        Builder builder = new Builder(this);
        builder.setTitle("memory leak");
        this.igL = getIntent().getStringExtra("key");
        String stringExtra = getIntent().getStringExtra("tag");
        String stringExtra2 = getIntent().getStringExtra("class");
        if (stringExtra2.contains(" ")) {
            stringExtra2 = stringExtra2.substring(stringExtra2.indexOf(" "));
        }
        final String replace = stringExtra2.replace(".", "_");
        builder.setMessage(stringExtra + stringExtra2 + "\n\npath:" + b.uNA + replace + ".zip");
        builder.setCancelable(true);
        builder.setPositiveButton("dumphprof", new OnClickListener(this) {
            final /* synthetic */ MemoryLeakActivity igU;

            public final void onClick(DialogInterface dialogInterface, int i) {
                b.Sy(replace);
                if (this.igU.igT != null && this.igU.igT.isShowing()) {
                    this.igU.igT.dismiss();
                }
                this.igU.finish();
            }
        });
        builder.setNegativeButton("cancel", new OnClickListener(this) {
            final /* synthetic */ MemoryLeakActivity igU;

            {
                this.igU = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.igU.igT != null && this.igU.igT.isShowing()) {
                    this.igU.igT.dismiss();
                }
                this.igU.finish();
            }
        });
        builder.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ MemoryLeakActivity igU;

            {
                this.igU = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.igU.finish();
            }
        });
        this.igT = builder.create();
        b.bOf();
        this.mHandler.sendEmptyMessageDelayed(0, 200);
    }

    protected void onDestroy() {
        super.onDestroy();
        d.ihc.remove(this.igL);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.igT != null && this.igT.isShowing()) {
            this.igT.dismiss();
            this.igT = null;
        }
    }
}
