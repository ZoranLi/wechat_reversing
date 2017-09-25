package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;

@a(19)
public class DataTransferUI extends MMBaseActivity {
    private p jiM;
    private long startTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.d("MicroMsg.DataTransferUI", "onCreate, timestamp = " + System.currentTimeMillis());
        this.startTime = System.currentTimeMillis();
        getString(R.l.dIO);
        this.jiM = g.a(this, getString(R.l.dGA), false, null);
        new ae(this) {
            final /* synthetic */ DataTransferUI uPh;

            {
                this.uPh = r1;
            }

            public final void handleMessage(Message message) {
                if (this.uPh.jiM != null && this.uPh.jiM.isShowing()) {
                    w.e("MicroMsg.DataTransferUI", "dialog has shown for a long time, auto dismiss it...");
                    this.uPh.jiM.dismiss();
                    this.uPh.finish();
                }
            }
        }.sendEmptyMessageDelayed(0, 60000);
        ae(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        w.d("MicroMsg.DataTransferUI", "onNewIntent, timestamp = " + System.currentTimeMillis());
        ae(intent);
    }

    private void ae(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("finish_data_transfer", false);
        w.d("MicroMsg.DataTransferUI", "tryFinish, timestamp = " + System.currentTimeMillis() + ", finish = " + booleanExtra);
        if (booleanExtra) {
            finish();
        }
    }

    protected void onPause() {
        w.d("MicroMsg.DataTransferUI", "edw DataTransferUI duration time = " + (System.currentTimeMillis() - this.startTime));
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        w.d("MicroMsg.DataTransferUI", "onDestroy");
        if (this.jiM != null && this.jiM.isShowing()) {
            this.jiM.dismiss();
        }
    }
}
