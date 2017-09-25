package com.tencent.mm.plugin.downloader.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mm.plugin.downloader.b.b;
import com.tencent.mm.plugin.downloader.b.c;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;

public class FileDownloadConfirmUI extends MMBaseActivity {
    private h ihw = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b.empty);
        final long longExtra = getIntent().getLongExtra("extra_download_id", -1);
        OnClickListener anonymousClass1 = new OnClickListener(this) {
            final /* synthetic */ FileDownloadConfirmUI kHo;

            public final void onClick(DialogInterface dialogInterface, int i) {
                e.akM().aT(longExtra);
                w.i("MicroMsg.FileDownloadConfirmUI", "Remove task: %d", Long.valueOf(longExtra));
            }
        };
        OnClickListener anonymousClass2 = new OnClickListener(this) {
            final /* synthetic */ FileDownloadConfirmUI kHo;

            {
                this.kHo = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        };
        OnDismissListener anonymousClass3 = new OnDismissListener(this) {
            final /* synthetic */ FileDownloadConfirmUI kHo;

            {
                this.kHo = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.kHo.finish();
            }
        };
        a aVar = new a(this);
        aVar.SW("");
        aVar.zX(c.kGb);
        aVar.zZ(c.dJe).a(anonymousClass1);
        aVar.Aa(c.dHQ).b(anonymousClass2);
        aVar.a(anonymousClass3);
        this.ihw = aVar.WJ();
        this.ihw.show();
        w.i("MicroMsg.FileDownloadConfirmUI", "Confirm Dialog");
    }

    protected void onStop() {
        super.onStop();
        this.ihw.dismiss();
    }
}
