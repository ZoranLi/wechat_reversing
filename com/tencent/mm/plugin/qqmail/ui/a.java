package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.n;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.d.a, b, e {
    private static boolean oDg = false;
    public Context context;
    private boolean fFU;
    private f isJ;
    public ProgressDialog isv;
    private x jiL;
    private ProgressDialog koS;
    private boolean oDf;
    private boolean osM;

    public a(Context context) {
        Assert.assertTrue(context != null);
        this.context = context;
    }

    public final boolean sa(String str) {
        boolean z = false;
        w.d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = " + str);
        if (bg.mz(str).length() <= 0) {
            return false;
        }
        Intent intent;
        if (str.equals("contact_info_qqmailhelper_view")) {
            intent = new Intent();
            if (this.osM) {
                intent.putExtra("Chat_User", this.jiL.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.jiL.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                com.tencent.mm.plugin.qqmail.a.a.imv.e(intent, this.context);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qqmailhelper_compose")) {
            intent = new Intent(this.context, ComposeUI.class);
            if (this.osM) {
                intent.putExtra("Chat_User", this.jiL.field_username);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.jiL.field_username);
                intent.addFlags(67108864);
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qqmailhelper_set_files_view")) {
            ap.yY();
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(bg.mz((String) c.vr().get(29, null))));
            intent2.putExtra("title", this.context.getString(R.l.dZd));
            intent2.putExtra("zoom", false);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("showShare", false);
            intent2.putExtra("vertical_scroll", false);
            com.tencent.mm.plugin.qqmail.a.a.imv.j(intent2, this.context);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_recv_remind")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td(str);
            boolean isChecked = checkBoxPreference.isChecked();
            gs(isChecked);
            if (!isChecked) {
                z = true;
            }
            checkBoxPreference.vqm = z;
            return true;
        } else if (str.equals("contact_info_qqmailhelper_clear_data")) {
            g.a(this.context, this.context.getString(R.l.dXR), "", new OnClickListener(this) {
                final /* synthetic */ a oDh;

                {
                    this.oDh = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.qqmail.b.w.aUB();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_install")) {
            ap.yY();
            if (bg.f((Integer) c.vr().get(9, null)) == 0) {
                g.b(this.context, R.l.eUS, R.l.dIO, new OnClickListener(this) {
                    final /* synthetic */ a oDh;

                    {
                        this.oDh = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.qqmail.a.a.imv.h(null, this.oDh.context);
                    }
                }, null);
                return true;
            }
            gr(true);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_uninstall")) {
            g.a(this.context, this.context.getString(R.l.eTH), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ a oDh;

                {
                    this.oDh = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oDh.gr(false);
                }
            }, null);
            return true;
        } else {
            w.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(o.eY(xVar.field_username));
        ap.yY();
        c.vr().a(this);
        ap.vd().a(24, this);
        this.osM = z;
        this.jiL = xVar;
        this.isJ = fVar;
        fVar.addPreferencesFromResource(R.o.ftz);
        adH();
        return true;
    }

    private void adH() {
        boolean z;
        int i;
        boolean z2 = true;
        this.fFU = (m.xW() & 1) == 0;
        ap.yY();
        if (bg.f((Integer) c.vr().get(17, null)) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.oDf = z;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.isJ.Td("contact_info_header_helper");
        helperHeaderPreference.Y(this.jiL.field_username, this.jiL.tL(), this.context.getString(R.l.dZe));
        if (this.fFU) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.kg(i);
        this.isJ.aV("contact_info_qqmailhelper_install", this.fFU);
        f fVar = this.isJ;
        String str = "contact_info_qqmailhelper_view";
        if (this.fFU) {
            z = false;
        } else {
            z = true;
        }
        fVar.aV(str, z);
        fVar = this.isJ;
        str = "contact_info_qqmailhelper_compose";
        if (this.fFU) {
            z = false;
        } else {
            z = true;
        }
        fVar.aV(str, z);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("contact_info_qqmailhelper_recv_remind");
        if (checkBoxPreference != null) {
            checkBoxPreference.vqm = this.oDf;
        }
        fVar = this.isJ;
        str = "contact_info_qqmailhelper_recv_remind";
        if (this.fFU) {
            z = false;
        } else {
            z = true;
        }
        fVar.aV(str, z);
        fVar = this.isJ;
        str = "contact_info_qqmailhelper_set_files_view";
        if ((this.fFU & this.oDf) == 0) {
            z = true;
        } else {
            z = false;
        }
        fVar.aV(str, z);
        this.isJ.aV("contact_info_qqmailhelper_download_mgr_view", true);
        fVar = this.isJ;
        str = "contact_info_qqmailhelper_clear_data";
        if (this.fFU) {
            z = false;
        } else {
            z = true;
        }
        fVar.aV(str, z);
        f fVar2 = this.isJ;
        String str2 = "contact_info_qqmailhelper_uninstall";
        if (this.fFU) {
            z2 = false;
        }
        fVar2.aV(str2, z2);
    }

    public final void gr(boolean z) {
        String string = z ? this.context.getString(R.l.eTE) : this.context.getString(R.l.eTL);
        Context context = this.context;
        this.context.getString(R.l.dIO);
        this.koS = g.a(context, string, true, null);
        oDg = true;
        gs(z);
    }

    public final boolean adI() {
        ap.yY();
        c.vr().b(this);
        ap.vd().b(24, this);
        if (this.koS != null) {
            this.koS.dismiss();
            this.koS = null;
        }
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int n = bg.n(obj, 0);
        w.d("MicroMsg.ContactWidgetQQMail", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), mVar});
        ap.yY();
        if (mVar != c.vr() || n <= 0) {
            w.e("MicroMsg.ContactWidgetQQMail", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), mVar});
        } else if (n == 17 || n == 34 || n == 7) {
            adH();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    private boolean gs(boolean z) {
        final k nVar = new n(z, "");
        if (!oDg) {
            this.isv = g.a(this.context, this.context.getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ a oDh;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(nVar);
                }
            });
        }
        ap.vd().a(nVar, 0);
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() != 24) {
            w.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd : unExpected type = " + kVar.getType());
            return;
        }
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (this.koS != null) {
            this.koS.dismiss();
            this.koS = null;
        }
        if (i == 0 && i2 == 0) {
            boolean z = ((n) kVar).fYd;
            ap.yY();
            c.vr().set(17, Integer.valueOf(z ? 1 : 2));
            if (oDg && bg.bp(this.context)) {
                if (z) {
                    ap.yY();
                    c.vr().set(17, Integer.valueOf(1));
                }
                int xW = m.xW();
                int i3 = z ? xW & -2 : xW | 1;
                ap.yY();
                c.vr().set(34, Integer.valueOf(i3));
                ap.yY();
                c.wQ().b(new com.tencent.mm.ao.n("", "", "", "", "", "", "", "", i3, "", ""));
                com.tencent.mm.plugin.qqmail.a.a.imw.ou();
                if (!z) {
                    com.tencent.mm.plugin.qqmail.b.w.aUB();
                }
            }
            oDg = false;
            return;
        }
        CharSequence string;
        final boolean z2 = ((n) kVar).fYd;
        w.e("MicroMsg.ContactWidgetQQMail", "NetSceneSwitchPushMail fail : errType = " + i + ", errCode = " + i2);
        if (i == 4) {
            switch (i2) {
                case -31:
                    w.i("MicroMsg.ContactWidgetQQMail", "need second pass");
                    View inflate = View.inflate(this.context, R.i.dno, null);
                    final EditText editText = (EditText) inflate.findViewById(R.h.cBr);
                    g.a(this.context, this.context.getString(R.l.dZc), inflate, new OnClickListener(this) {
                        final /* synthetic */ a oDh;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            final k nVar = new n(z2, com.tencent.mm.a.g.n(editText.getText().toString().trim().getBytes()));
                            ap.vd().a(nVar, 0);
                            a aVar = this.oDh;
                            Context context = this.oDh.context;
                            this.oDh.context.getString(R.l.dZb);
                            aVar.isv = g.a(context, this.oDh.context.getString(R.l.dJd), true, new OnCancelListener(this) {
                                final /* synthetic */ AnonymousClass5 oDk;

                                public final void onCancel(DialogInterface dialogInterface) {
                                    ap.vd().c(nVar);
                                }
                            });
                        }
                    });
                    return;
                case -1:
                    w.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd, sys err");
                    break;
                default:
                    return;
            }
        }
        if (oDg) {
            string = this.context.getString(z2 ? R.l.eTB : R.l.eTG);
        } else {
            string = this.context.getString(R.l.dGT);
        }
        Toast.makeText(this.context, string, 1).show();
        oDg = false;
    }
}
