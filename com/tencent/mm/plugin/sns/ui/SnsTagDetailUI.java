package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI extends MMPreference implements b, e {
    protected String fFW = "";
    protected p irJ = null;
    protected f isJ;
    protected ContactListExpandPreference ktf;
    protected long pUF;
    protected List<String> qGU = new ArrayList();
    protected String qGV = "";
    private boolean qGW = false;
    protected a qGX = new a(this) {
        final /* synthetic */ SnsTagDetailUI qGY;

        {
            this.qGY = r1;
        }

        public final void kK(int i) {
            String xu = this.qGY.ktf.xu(i);
            w.d("MicroMsg.SnsTagDetailUI", "roomPref del " + i + " userName : " + xu);
            h.vJ();
            if (bg.ap((String) h.vI().vr().get(2, null), "").equals(xu)) {
                g.h(this.qGY.uSU.uTo, j.eMt, j.dIO);
                return;
            }
            this.qGY.tq(xu);
            if (!(this.qGY.qGV + " " + bg.c(this.qGY.qGU, ",")).equals(this.qGY.fFW) || this.qGY.pUF == 0) {
                this.qGY.kr(true);
            } else {
                this.qGY.kr(false);
            }
        }

        public final void kM(int i) {
            w.d("MicroMsg.SnsTagDetailUI", "roomPref add " + i);
            SnsTagDetailUI.a(this.qGY);
        }

        public final void kL(int i) {
            String xu = this.qGY.ktf.xu(i);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", xu);
            com.tencent.mm.plugin.sns.c.a.imv.d(intent, this.qGY);
        }

        public final void ajs() {
            if (this.qGY.ktf != null) {
                this.qGY.ktf.bFb();
            }
        }
    };
    protected int scene = 0;

    static /* synthetic */ void a(SnsTagDetailUI snsTagDetailUI) {
        String c = bg.c(snsTagDetailUI.qGU, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", snsTagDetailUI.getString(j.dCT));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", s.q(new int[]{s.vYO, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
        intent.putExtra("always_select_contact", c);
        d.a(snsTagDetailUI, ".ui.contact.SelectContactUI", intent, 1);
    }

    protected void bjM() {
        w.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
        h.vJ();
        h.vH().gXC.a(290, this);
        h.vJ();
        h.vH().gXC.a(291, this);
        h.vJ();
        h.vH().gXC.a(292, this);
        h.vJ();
        h.vH().gXC.a(293, this);
        h.vJ();
        ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().a(this);
        if (ae.beQ().bhZ().size() == 0) {
            h.vJ();
            h.vH().gXC.a(new u(1), 0);
            this.qGW = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bjM();
        this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
        this.pUF = getIntent().getLongExtra("k_sns_tag_id", 0);
        if (this.pUF == 4) {
            this.qGV = getString(j.pMw);
        } else if (this.pUF == 5) {
            this.qGV = getString(j.pME);
        } else {
            this.qGV = ae.beQ().dI(this.pUF).field_tagName;
        }
        if (this.pUF == 0) {
            String stringExtra = getIntent().getStringExtra("k_sns_tag_list");
            this.qGV = bg.ap(getIntent().getStringExtra("k_sns_tag_name"), "");
            ar bez = ae.bez();
            String xL = m.xL();
            List<String> f = bg.f(stringExtra.split(","));
            if (f != null) {
                for (String stringExtra2 : f) {
                    if (!(this.qGU.contains(stringExtra2) || !com.tencent.mm.j.a.ez(bez.Rc(stringExtra2).field_type) || xL.equals(stringExtra2))) {
                        this.qGU.add(stringExtra2);
                    }
                }
            }
        } else {
            this.qGU = bjP();
        }
        if (this.qGV == null || this.qGV.equals("")) {
            this.qGV = getString(j.pMv);
            this.qGV = ai.Fm(getString(j.pMv));
        }
        KC();
        bkN();
        ajj();
        if (this.pUF < 6) {
            this.isJ.Te("delete_tag_name");
            this.isJ.Te("delete_tag_name_category");
            if (this.pUF > 0) {
                this.isJ.Te("settings_tag_name");
                this.isJ.Te("settings_tag_name_category");
            }
        }
        if (this.pUF == 4) {
            this.isJ.Te("black");
            this.isJ.Te("group");
        } else if (this.pUF == 5) {
            this.isJ.Te("outside");
            this.isJ.Te("group");
        } else {
            this.isJ.Te("black");
            this.isJ.Te("outside");
        }
        if (this.pUF == 0) {
            kr(true);
        } else {
            kr(false);
        }
        this.fFW = this.qGV + " " + bg.c(this.qGU, ",");
    }

    protected void bjN() {
        w.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
        h.vJ();
        h.vH().gXC.b(290, this);
        h.vJ();
        h.vH().gXC.b(291, this);
        h.vJ();
        h.vH().gXC.b(292, this);
        h.vJ();
        h.vH().gXC.b(293, this);
        h.vJ();
        if (h.vG().uV()) {
            h.vJ();
            ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().b(this);
        }
    }

    public void onDestroy() {
        if (this.irJ != null) {
            this.irJ.dismiss();
        }
        bjN();
        super.onDestroy();
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
    }

    public final int ON() {
        return i.m.pNz;
    }

    public void onResume() {
        super.onResume();
        bkN();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if (str.equals("settings_tag_name") && (this.pUF >= 6 || this.pUF == 0)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_mode_name_type", 3);
            intent.putExtra("Contact_Nick", bg.ap(this.qGV, " "));
            com.tencent.mm.plugin.sns.c.a.imv.a(intent, this);
        }
        if (str.equals("delete_tag_name")) {
            g.a(this, j.pJW, j.dIO, new OnClickListener(this) {
                final /* synthetic */ SnsTagDetailUI qGY;

                {
                    this.qGY = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.qGY.bjO();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ SnsTagDetailUI qGY;

                {
                    this.qGY = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        return false;
    }

    protected final void ajj() {
        qP(this.qGV + "(" + this.qGU.size() + ")");
    }

    private void bkN() {
        Preference Td = this.isJ.Td("settings_tag_name");
        if (Td != null) {
            if (this.qGV.length() > 20) {
                this.qGV = this.qGV.substring(0, 20);
            }
            Td.setSummary(this.qGV);
            this.isJ.notifyDataSetChanged();
        }
    }

    protected void bjO() {
        if (this.pUF != 0) {
            h.vJ();
            h.vH().gXC.a(new com.tencent.mm.plugin.sns.model.w(this.pUF, this.qGV), 0);
        }
        getString(j.dIO);
        this.irJ = g.a(this, getString(j.pMB), true, new OnCancelListener(this) {
            final /* synthetic */ SnsTagDetailUI qGY;

            {
                this.qGY = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    protected final void KC() {
        this.isJ = this.vrv;
        this.ktf = (ContactListExpandPreference) this.isJ.Td("roominfo_contact_anchor");
        if (this.ktf != null) {
            this.ktf.a(this.isJ, this.ktf.igL);
            this.ktf.ju(true).jv(true);
            this.ktf.k(null, this.qGU);
            this.ktf.a(new com.tencent.mm.pluginsdk.ui.applet.g.b(this) {
                final /* synthetic */ SnsTagDetailUI qGY;

                {
                    this.qGY = r1;
                }

                public final boolean kJ(int i) {
                    boolean xs;
                    ContactListExpandPreference contactListExpandPreference = this.qGY.ktf;
                    if (contactListExpandPreference.sNk != null) {
                        xs = contactListExpandPreference.sNk.sMx.xs(i);
                    } else {
                        xs = true;
                    }
                    if (!xs) {
                        w.d("MicroMsg.SnsTagDetailUI", "onItemLongClick " + i);
                    }
                    return true;
                }
            });
            this.ktf.a(this.qGX);
        }
        getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagDetailUI qGY;

            {
                this.qGY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!(this.qGY.qGV + " " + bg.c(this.qGY.qGU, ",")).equals(this.qGY.fFW) || this.qGY.pUF == 0) {
                    g.a(this.qGY, j.pMs, j.dIO, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass5 qGZ;

                        {
                            this.qGZ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.qGZ.qGY.finish();
                        }
                    }, null);
                } else {
                    this.qGY.finish();
                }
                return true;
            }
        });
        a(0, getString(j.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagDetailUI qGY;

            {
                this.qGY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qGY.aHd();
                return true;
            }
        }, l.b.uTY);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!(this.qGV + " " + bg.c(this.qGU, ",")).equals(this.fFW) || this.pUF == 0) {
            g.a(this, j.pMs, j.dIO, new OnClickListener(this) {
                final /* synthetic */ SnsTagDetailUI qGY;

                {
                    this.qGY = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.qGY.finish();
                }
            }, null);
        } else {
            finish();
        }
        return true;
    }

    protected void aHd() {
        if ((this.qGV + " " + bg.c(this.qGU, ",")).equals(this.fFW) && this.pUF != 0) {
            finish();
        } else if (ae.beQ().o(this.pUF, this.qGV)) {
            g.b(this, getString(j.pMt, new Object[]{this.qGV}), getString(j.dIO), true);
        } else {
            final k vVar = new v(3, this.pUF, this.qGV, this.qGU.size(), this.qGU, this.scene);
            h.vJ();
            h.vH().gXC.a(vVar, 0);
            getString(j.dIO);
            this.irJ = g.a(this, getString(j.pMB), true, new OnCancelListener(this) {
                final /* synthetic */ SnsTagDetailUI qGY;

                public final void onCancel(DialogInterface dialogInterface) {
                    h.vJ();
                    h.vH().gXC.c(vVar);
                }
            });
        }
    }

    protected List<String> bjP() {
        List<String> linkedList = new LinkedList();
        com.tencent.mm.plugin.sns.storage.s dI = ae.beQ().dI(this.pUF);
        if (dI.field_memberList == null || dI.field_memberList.equals("")) {
            return linkedList;
        }
        return bg.f(dI.field_memberList.split(","));
    }

    protected void tq(String str) {
        if (str != null && !str.equals("")) {
            this.qGU.remove(str);
            if (this.ktf != null) {
                this.ktf.aN(this.qGU);
                this.ktf.notifyChanged();
            }
            if (this.qGU.size() == 0 && this.ktf != null) {
                this.ktf.bFb();
                this.ktf.ju(true).jv(false);
                this.isJ.notifyDataSetChanged();
            } else if (this.ktf != null) {
                this.ktf.ju(true).jv(true);
            }
            ajj();
        }
    }

    protected void bB(List<String> list) {
        ar bez = ae.bez();
        String xL = m.xL();
        for (String str : list) {
            if (!(this.qGU.contains(str) || !com.tencent.mm.j.a.ez(bez.Rc(str).field_type) || xL.equals(str))) {
                this.qGU.add(str);
            }
        }
        if (this.ktf != null) {
            this.ktf.aN(this.qGU);
            this.ktf.notifyChanged();
        }
        if (this.qGU.size() > 0) {
            this.ktf.ju(true).jv(true);
        } else {
            this.ktf.ju(true).jv(false);
        }
        ajj();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            String stringExtra;
            switch (i) {
                case 1:
                    if (intent != null) {
                        boolean z;
                        String stringExtra2 = intent.getStringExtra("Select_Contact");
                        if (bg.mz(m.xL()).equals(stringExtra2)) {
                            z = true;
                        } else if (this.qGU == null) {
                            z = false;
                        } else {
                            z = false;
                            for (String stringExtra3 : this.qGU) {
                                boolean z2;
                                if (stringExtra3.equals(stringExtra2)) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                z = z2;
                            }
                        }
                        if (z) {
                            g.b(this, getString(j.dCc, new Object[]{Integer.valueOf(0), Integer.valueOf(0)}), getString(j.dIO), true);
                            return;
                        }
                        List f = bg.f(stringExtra2.split(","));
                        if (f != null) {
                            bB(f);
                            break;
                        }
                        return;
                    }
                    return;
                case 2:
                    stringExtra3 = intent.getStringExtra("k_sns_tag_name");
                    if (stringExtra3 != null) {
                        this.qGV = stringExtra3;
                    }
                    ajj();
                    w.d("MicroMsg.SnsTagDetailUI", "updateName " + this.qGV);
                    break;
                default:
                    return;
            }
            if (!(this.qGV + " " + bg.c(this.qGU, ",")).equals(this.fFW) || this.pUF == 0) {
                kr(true);
            } else {
                kr(false);
            }
        }
    }

    public void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.irJ != null) {
            this.irJ.dismiss();
        }
        switch (kVar.getType()) {
            case 290:
                finish();
                return;
            case 291:
                finish();
                return;
            case 292:
                if (this.ktf != null && this.qGW && !(this instanceof SnsBlackDetailUI)) {
                    w.d("MicroMsg.SnsTagDetailUI", "update form net");
                    this.fFW = this.qGV + " " + bg.c(((u) kVar).dq(this.pUF), ",");
                    LinkedList linkedList = new LinkedList();
                    List<String> list = this.qGU;
                    this.qGU = bjP();
                    if (list != null) {
                        for (String str2 : list) {
                            if (!this.qGU.contains(str2)) {
                                this.qGU.add(str2);
                            }
                        }
                    }
                    this.ktf.aN(this.qGU);
                    this.ktf.notifyChanged();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
