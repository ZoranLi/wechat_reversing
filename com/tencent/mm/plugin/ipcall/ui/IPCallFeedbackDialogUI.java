package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class IPCallFeedbackDialogUI extends MMActivity {
    private g mUM;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.IPCallFeedbackDialogUI", "onCreate");
        this.mUM = new g(this, this.uSU.uTo, getIntent().getIntExtra("IPCallFeedbackDialogUI_KRoomId", 0), getIntent().getLongExtra("IPCallFeedbackDialogUI_KCallseq", 0));
        this.mUM.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ IPCallFeedbackDialogUI mUN;

            {
                this.mUN = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.mUN.finish();
            }
        });
        this.mUM.getWindow().setSoftInputMode(16);
        this.mUM.show();
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        w.d("MicroMsg.IPCallFeedbackDialogUI", "onResume");
        super.onResume();
    }

    protected void onNewIntent(Intent intent) {
        w.d("MicroMsg.IPCallFeedbackDialogUI", "onNewIntent");
        super.onNewIntent(intent);
    }

    public void onDestroy() {
        w.d("MicroMsg.IPCallFeedbackDialogUI", "onDestroy");
        super.onDestroy();
    }

    public void finish() {
        w.i("MicroMsg.IPCallFeedbackDialogUI", "finish");
        if (this.mUM != null && this.mUM.isShowing()) {
            this.mUM.dismiss();
            this.mUM = null;
        }
        super.finish();
    }
}
