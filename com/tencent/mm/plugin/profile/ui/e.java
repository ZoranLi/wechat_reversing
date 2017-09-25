package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ao.g;
import com.tencent.mm.bb.d;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class e implements a {
    Context context;
    public p irJ = null;
    private f isJ;
    public boolean jWp = false;
    private x jiL;
    private boolean osM;
    private HelperHeaderPreference.a oul;
    private int status;

    public e(Context context) {
        this.context = context;
        this.oul = new o(context);
        this.status = -1;
    }

    public final boolean sa(String str) {
        boolean z = false;
        w.d("MicroMsg.ContactWidgetFMessage", "handlerEvent : key = " + str);
        if (bg.mz(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_recommend_qqfriends_to_me")) {
            boolean z2;
            if (((CheckBoxPreference) this.isJ.Td("contact_info_recommend_qqfriends_to_me")).isChecked()) {
                z2 = false;
            } else {
                z2 = true;
            }
            a(z2, FileUtils.S_IWUSR, 6);
            return true;
        } else if (str.equals("contact_info_recommend_mobilefriends_to_me")) {
            if (!((CheckBoxPreference) this.isJ.Td("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
                z = true;
            }
            a(z, 256, 7);
            return true;
        } else if (str.equals("contact_info_recommend_fbfriends_to_me")) {
            z = ((CheckBoxPreference) this.isJ.Td("contact_info_recommend_fbfriends_to_me")).isChecked();
            w.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + z + " item value = 4 functionId = 18");
            int xR = m.xR();
            xR = z ? xR | 4 : xR & -5;
            ap.yY();
            c.vr().set(40, Integer.valueOf(xR));
            xR = z ? 1 : 2;
            ap.yY();
            c.wQ().b(new g(18, xR));
            return true;
        } else if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent();
            if (this.osM) {
                intent.putExtra("Chat_User", this.jiL.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
                ((Activity) this.context).finish();
                return true;
            }
            intent.putExtra("Chat_User", this.jiL.field_username);
            intent.putExtra("Chat_Mode", 1);
            intent.addFlags(67108864);
            com.tencent.mm.plugin.profile.a.imv.e(intent, this.context);
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_bind_mobile_entry")) {
            com.tencent.mm.plugin.profile.a.imv.g(new Intent(), this.context);
            return true;
        } else if (str.equals("contact_info_bind_qq_entry")) {
            com.tencent.mm.plugin.profile.a.imv.h(new Intent(), this.context);
            return true;
        } else if (str.equals("contact_info_bind_fb_entry")) {
            d.a(this.context, ".ui.account.FacebookAuthUI", new Intent());
            return true;
        } else if (str.equals("contact_info_fmessage_clear_data")) {
            com.tencent.mm.ui.base.g.a(this.context, this.context.getString(R.l.dXP), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ e oum;

                {
                    this.oum = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    e eVar = this.oum;
                    eVar.jWp = false;
                    Context context = eVar.context;
                    eVar.context.getString(R.l.dIO);
                    eVar.irJ = com.tencent.mm.ui.base.g.a(context, eVar.context.getString(R.l.dJd), true, new OnCancelListener(eVar) {
                        final /* synthetic */ e oum;

                        {
                            this.oum = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.oum.jWp = true;
                        }
                    });
                    ay.a("fmessage", new ay.a(eVar) {
                        final /* synthetic */ e oum;

                        {
                            this.oum = r1;
                        }

                        public final boolean zs() {
                            return this.oum.jWp;
                        }

                        public final void zr() {
                            if (this.oum.irJ != null) {
                                this.oum.irJ.dismiss();
                                this.oum.irJ = null;
                            }
                        }
                    });
                    ap.yY();
                    c.wW().Rl("fmessage");
                }
            }, null);
            return true;
        } else {
            w.e("MicroMsg.ContactWidgetFMessage", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    private void a(boolean z, int i, int i2) {
        w.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        ap.yY();
        c.vr().set(7, Integer.valueOf(this.status));
        int i3 = z ? 1 : 2;
        ap.yY();
        c.wQ().b(new g(i2, i3));
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(o.eZ(xVar.field_username));
        this.isJ = fVar;
        this.osM = z;
        this.jiL = xVar;
        if (this.status == -1) {
            this.status = m.xP();
        }
        fVar.addPreferencesFromResource(R.o.ftr);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.Td("contact_info_recommend_qqfriends_to_me");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) fVar.Td("contact_info_recommend_mobilefriends_to_me");
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) fVar.Td("contact_info_recommend_fbfriends_to_me");
        checkBoxPreference2.vqm = !rt(256);
        if (rt(FileUtils.S_IWUSR)) {
            z3 = false;
        } else {
            z3 = true;
        }
        checkBoxPreference.vqm = z3;
        if ((m.xR() & 4) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        checkBoxPreference3.vqm = z3;
        ((HelperHeaderPreference) fVar.Td("contact_info_header_helper")).a(xVar, this.oul);
        ap.yY();
        if (bg.f((Integer) c.vr().get(9, null)) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            fVar.c(fVar.Td("contact_info_bind_qq_entry"));
            fVar.c(fVar.Td("contact_info_bind_qq_entry_tip"));
        } else {
            fVar.c(checkBoxPreference);
            if (!b.Hn()) {
                fVar.c(fVar.Td("contact_info_bind_qq_entry"));
                fVar.c(fVar.Td("contact_info_bind_qq_entry_tip"));
            }
        }
        if (com.tencent.mm.modelfriend.m.Fl() == com.tencent.mm.modelfriend.m.a.hBs) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            fVar.c(fVar.Td("contact_info_bind_mobile_entry"));
            fVar.c(fVar.Td("contact_info_bind_mobile_entry_tip"));
        } else {
            fVar.c(checkBoxPreference2);
            fVar.Td("contact_info_bind_mobile_entry").setSummary(R.l.eSg);
        }
        if ((m.xW() & 8192) == 0) {
            z4 = true;
        }
        if (z4) {
            z2 = m.ym();
            fVar.c(checkBoxPreference3);
            if (z2) {
                fVar.Td("contact_info_bind_fb_entry").setSummary(R.l.dYc);
            } else {
                fVar.Td("contact_info_bind_fb_entry").setSummary(R.l.eSg);
            }
        } else {
            fVar.c(fVar.Td("contact_info_bind_fb_entry"));
            fVar.c(fVar.Td("contact_info_bind_fb_entry_tip"));
            fVar.c(checkBoxPreference3);
        }
        return true;
    }

    private boolean rt(int i) {
        return (this.status & i) != 0;
    }

    public final boolean adI() {
        com.tencent.mm.plugin.profile.a.imw.ou();
        this.isJ.Td("contact_info_header_helper");
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
