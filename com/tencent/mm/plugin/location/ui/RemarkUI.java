package com.tencent.mm.plugin.location.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.tools.MMTextInputUI;

public class RemarkUI extends MMTextInputUI {
    protected final int getLayoutId() {
        return R.i.dmC;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.ewv);
        CharSequence stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (bg.mA(stringExtra)) {
            findViewById(R.h.cce).setVisibility(8);
        } else {
            ((TextView) findViewById(R.h.ccq)).setText(stringExtra);
        }
    }

    protected final void v(CharSequence charSequence) {
        long longExtra = getIntent().getLongExtra("kFavInfoLocalId", -1);
        if (longExtra > 0) {
            String charSequence2 = charSequence == null ? "" : charSequence.toString();
            w.i("MicroMsg.MMTextInputUI", "same remark[%s]", new Object[]{charSequence2});
            if (!charSequence2.equals(getIntent().getStringExtra("kRemark"))) {
                b cbVar = new cb();
                cbVar.fFA.type = -2;
                cbVar.fFA.fFs = Long.toString(longExtra);
                cbVar.fFA.desc = charSequence2;
                w.d("MicroMsg.MMTextInputUI", "update location remark, favlocalid is %s, remark is %s", new Object[]{cbVar.fFA.fFs, cbVar.fFA.desc});
                a.urY.m(cbVar);
            }
        }
    }
}
