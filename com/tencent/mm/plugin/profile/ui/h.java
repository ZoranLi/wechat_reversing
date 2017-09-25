package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.j;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;
import junit.framework.Assert;

public final class h implements a {
    public Context context;
    private f isJ;
    private x jiL;
    private String ktm;
    public q ktr;
    private boolean osM;
    private boolean osN;
    private int osO;
    private int ouq;
    public ContactListExpandPreference our;

    public h(Context context) {
        this.context = context;
        this.our = new ContactListExpandPreference(context, 0);
    }

    public final boolean sa(String str) {
        w.d("MicroMsg.ContactWidgetGroupCard", "handleEvent " + str);
        ap.yY();
        af Rc = c.wR().Rc(str);
        if (Rc != null && ((int) Rc.gTQ) > 0) {
            Intent intent = new Intent();
            intent.setClass(this.context, ContactInfoUI.class);
            intent.putExtra("Contact_User", Rc.field_username);
            this.context.startActivity(intent);
        }
        return true;
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        Assert.assertTrue(xVar != null);
        Assert.assertTrue(bg.mz(xVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        this.isJ = fVar;
        this.jiL = xVar;
        this.osM = z;
        this.osO = i;
        this.osN = ((Activity) this.context).getIntent().getBooleanExtra("User_Verify", false);
        this.ouq = ((Activity) this.context).getIntent().getIntExtra("Kdel_from", -1);
        this.ktm = xVar.field_username;
        ap.yY();
        this.ktr = c.xa().fW(this.ktm);
        this.isJ.removeAll();
        this.isJ.a(new PreferenceSmallCategory(this.context));
        this.our.setKey("roominfo_contact_anchor");
        this.isJ.a(this.our);
        this.isJ.a(new PreferenceCategory(this.context));
        Preference normalUserFooterPreference = new NormalUserFooterPreference(this.context);
        normalUserFooterPreference.setLayoutResource(R.i.cZw);
        normalUserFooterPreference.setKey("contact_info_footer_normal");
        if (normalUserFooterPreference.a(this.jiL, "", this.osM, this.osN, false, this.osO, this.ouq, false, false, 0, "")) {
            this.isJ.a(normalUserFooterPreference);
        }
        this.our.a(this.isJ, this.our.igL);
        List eA = j.eA(this.ktm);
        this.our.ju(false).jv(false);
        this.our.k(this.ktm, eA);
        this.our.a(new ContactListExpandPreference.a(this) {
            final /* synthetic */ h ous;

            {
                this.ous = r1;
            }

            public final void kK(int i) {
            }

            public final void kL(int i) {
                if (this.ous.our.xt(i)) {
                    String xu = this.ous.our.xu(i);
                    if (!bg.mA(xu)) {
                        Intent intent = new Intent();
                        intent.setClass(this.ous.context, ContactInfoUI.class);
                        intent.putExtra("Contact_User", xu);
                        intent.putExtra("Contact_RoomNickname", this.ous.ktr.eK(xu));
                        this.ous.context.startActivity(intent);
                    }
                }
            }

            public final void ajs() {
            }

            public final void kM(int i) {
            }
        });
        return true;
    }

    public final boolean adI() {
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.isJ.Td("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.adI();
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
