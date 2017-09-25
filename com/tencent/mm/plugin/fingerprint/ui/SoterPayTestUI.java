package com.tencent.mm.plugin.fingerprint.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fingerprint.b.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class SoterPayTestUI extends MMActivity implements e {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        findViewById(R.h.cFZ).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterPayTestUI lPi;

            {
                this.lPi = r1;
            }

            public final void onClick(View view) {
                w.i("MicroMsg.SoterPayTestUI", "hy: start get challenge");
                ap.vd().a(1586, this.lPi);
                ap.vd().a(new a(), 0);
            }
        });
        findViewById(R.h.cxG).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterPayTestUI lPi;

            {
                this.lPi = r1;
            }

            public final void onClick(View view) {
                w.i("MicroMsg.SoterPayTestUI", "hy: regen and upload ask");
                com.tencent.d.b.a.a(new b<c>(this) {
                    final /* synthetic */ AnonymousClass2 lPj;

                    {
                        this.lPj = r1;
                    }

                    public final /* bridge */ /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                    }
                }, false, null);
            }
        });
        findViewById(R.h.cxH).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SoterPayTestUI lPi;

            {
                this.lPi = r1;
            }

            public final void onClick(View view) {
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.ddg;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.SoterPayTestUI", "hy: on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        s.makeText(this, String.format("on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}), 1).show();
        ap.vd().b(kVar.getType(), this);
    }
}
