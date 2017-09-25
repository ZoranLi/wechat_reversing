package com.tencent.mm.plugin.qqmail.stub;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.qqmail.ui.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;

@a(7)
public class QQMailStubProxyUI extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.d("MicroMsg.QQMail.QQMailStubProxyUI", "onCreate");
        final c cVar = new c(this);
        cVar.a(new c.a(this) {
            final /* synthetic */ QQMailStubProxyUI oBj;

            public final void aUC() {
                w.d("MicroMsg.QQMail.QQMailStubProxyUI", "onAfterVerify");
                cVar.release();
                this.oBj.setResult(-1);
                this.oBj.finish();
            }

            public final void aUD() {
                w.e("MicroMsg.QQMail.QQMailStubProxyUI", "onVerifyFail, finish self");
                cVar.release();
                this.oBj.setResult(0);
                this.oBj.finish();
            }
        });
    }
}
