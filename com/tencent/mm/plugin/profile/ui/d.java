package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class d implements a {
    private final Context context;
    private f isJ;

    public d(Context context) {
        this.context = context;
    }

    public final boolean sa(String str) {
        return true;
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        Assert.assertTrue(xVar != null);
        Assert.assertTrue(bg.mz(xVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        adI();
        this.isJ = fVar;
        fVar.removeAll();
        fVar.addPreferencesFromResource(R.o.ftn);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) fVar.Td("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.sSR = "ContactWidgetBottleContact";
            normalUserHeaderPreference.a(xVar, 0, null);
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) fVar.Td("contact_info_footer_normal");
        boolean booleanExtra = ((Activity) this.context).getIntent().getBooleanExtra("Contact_FMessageCard", false);
        if (normalUserFooterPreference != null) {
            if (!normalUserFooterPreference.a(xVar, "", z, false, true, 25, 0, booleanExtra, false, 0, "")) {
                fVar.c(normalUserFooterPreference);
            }
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) fVar.Td("contact_info_signature");
        if (xVar.signature == null || xVar.signature.trim().equals("")) {
            fVar.c(keyValuePreference);
        } else if (keyValuePreference != null) {
            keyValuePreference.vrl = false;
            keyValuePreference.setTitle(this.context.getString(R.l.dZF));
            keyValuePreference.setSummary(h.a(this.context, xVar.signature));
            keyValuePreference.kZ(false);
        }
        return true;
    }

    public final boolean adI() {
        if (this.isJ != null) {
            FriendPreference friendPreference = (FriendPreference) this.isJ.Td("contact_info_friend");
            if (friendPreference != null) {
                friendPreference.adI();
            }
            NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.isJ.Td("contact_info_header_normal");
            if (normalUserHeaderPreference != null) {
                normalUserHeaderPreference.onDetach();
            }
            NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.isJ.Td("contact_info_footer_normal");
            if (normalUserFooterPreference != null) {
                normalUserFooterPreference.adI();
            }
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
