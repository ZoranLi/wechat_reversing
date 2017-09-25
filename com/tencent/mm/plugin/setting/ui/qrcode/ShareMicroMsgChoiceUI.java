package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ShareMicroMsgChoiceUI extends MMPreference {
    private f isJ;

    protected final boolean OM() {
        return false;
    }

    public final int getLayoutId() {
        return R.i.dov;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public final int ON() {
        return R.o.fux;
    }

    protected final void KC() {
        zi(R.l.eRg);
        this.isJ = this.vrv;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareMicroMsgChoiceUI pim;

            {
                this.pim = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pim.aHf();
                this.pim.finish();
                return true;
            }
        });
        ((IconPreference) this.isJ.Td("share_micromsg_to_sina")).drawable = a.a(this, R.g.bjP);
        ap.yY();
        c.wZ().AH("@t.qq.com");
        ap.yY();
        IconPreference iconPreference = (IconPreference) this.isJ.Td("share_micromsg_qzone");
        if ((bg.f((Integer) c.vr().get(9, null)) != 0 ? 1 : null) == null) {
            this.isJ.c(iconPreference);
        } else {
            iconPreference.drawable = a.a(this, R.g.bjt);
        }
        iconPreference = (IconPreference) this.isJ.Td("share_micromsg_to_fuckbook");
        if (m.yk()) {
            iconPreference.drawable = a.a(this, R.g.bjO);
        } else {
            this.isJ.c(iconPreference);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        Intent intent;
        if (str.equals("share_micromsg_qzone")) {
            ap.yY();
            if (bg.f((Integer) c.vr().get(9, null)) != 0) {
                intent = new Intent(this, ShowQRCodeStep1UI.class);
                intent.putExtra("show_to", 2);
                startActivity(intent);
            } else {
                g.h(this, R.l.eQQ, R.l.dIO);
            }
        } else if (str.equals("share_micromsg_to_sina")) {
            intent = new Intent(this, ShowQRCodeStep1UI.class);
            intent.putExtra("show_to", 3);
            startActivity(intent);
        } else if (str.equals("share_micromsg_to_fuckbook")) {
            intent = new Intent(this, ShowQRCodeStep1UI.class);
            intent.putExtra("show_to", 4);
            startActivity(intent);
        }
        return false;
    }
}
