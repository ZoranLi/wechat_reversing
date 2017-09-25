package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.scanner.a.n;
import com.tencent.mm.plugin.scanner.a.n.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class VcardContactUI extends MMPreference {
    private static ArrayList<String> pcG = new ArrayList();
    private static int pcI = 1;
    private static int pcJ = 1;
    private f isJ;
    private n pcF;
    private r pcH;

    static /* synthetic */ void a(VcardContactUI vcardContactUI, Intent intent) {
        int i = 2;
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        String Ix = vcardContactUI.pcF.oWI.Ix();
        if (bg.mA(Ix)) {
            w.e("MicroMsg.scanner.VardContactUI", "no contact user name");
        } else {
            intent.putExtra("name", Ix);
        }
        List list = vcardContactUI.pcF.oWR;
        if (list == null || list.size() <= 0) {
            i = 1;
        } else {
            a(list, intent, 2, 1);
        }
        List list2 = vcardContactUI.pcF.oWS;
        if (list2 != null && list2.size() > 0) {
            int i2 = i + 1;
            a(list2, intent, 1, i);
            i = i2;
        }
        list = vcardContactUI.pcF.oWT;
        if (list != null && list.size() > 0) {
            int i3 = i + 1;
            a(list, intent, 3, i);
            i = i3;
        }
        list = vcardContactUI.pcF.oWV;
        if (list != null && list.size() > 0) {
            i3 = i + 1;
            a(list, intent, 7, i);
            i = i3;
        }
        List list3 = vcardContactUI.pcF.oWU;
        if (list3 != null && list3.size() > 0) {
            a(list3, intent, 0, i);
        }
        if (!bg.mA(vcardContactUI.pcF.iBj)) {
            intent.putExtra("company", vcardContactUI.pcF.iBj);
        }
        if (!bg.mA(vcardContactUI.pcF.oWY)) {
            intent.putExtra("notes", vcardContactUI.pcF.oWY);
        }
        if (!bg.mA(vcardContactUI.pcF.gku)) {
            intent.putExtra("email", vcardContactUI.pcF.gku);
        }
        if (!bg.mA(vcardContactUI.pcF.title)) {
            intent.putExtra("job_title", vcardContactUI.pcF.title);
        }
        n nVar = vcardContactUI.pcF;
        a aVar = (nVar.oWO == null || nVar.oWO.Ix().length() <= 0) ? (nVar.oWP == null || nVar.oWP.Ix().length() <= 0) ? (nVar.oWQ == null || nVar.oWQ.Ix().length() <= 0) ? (nVar.oWN == null || nVar.oWN.Ix().length() <= 0) ? null : nVar.oWN : nVar.oWQ : nVar.oWP : nVar.oWO;
        if (aVar != null && aVar.Ix().length() > 0) {
            intent.putExtra("postal", aVar.Ix());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public final int ON() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.igL.equals("add_vcard_contact")) {
            g.a(this, "", new String[]{getString(R.l.eZB), getString(R.l.eZA)}, "", new c(this) {
                final /* synthetic */ VcardContactUI pcK;

                {
                    this.pcK = r1;
                }

                public final void hq(int i) {
                    Intent intent;
                    switch (i) {
                        case 0:
                            bm.zN().c(10238, new Object[]{Integer.valueOf(1)});
                            intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
                            VcardContactUI.a(this.pcK, intent);
                            this.pcK.startActivity(intent);
                            return;
                        case 1:
                            bm.zN().c(10239, new Object[]{Integer.valueOf(1)});
                            intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
                            intent.setType("vnd.android.cursor.item/person");
                            VcardContactUI.a(this.pcK, intent);
                            this.pcK.startActivity(intent);
                            return;
                        default:
                            return;
                    }
                }
            });
            return true;
        }
        String str;
        if (preference.igL.equals("v_contact_info_photo_uri") || preference.igL.equals("v_contact_info_home_page") || preference.igL.equals("v_contact_info_logo")) {
            String charSequence = preference.getSummary().toString();
            if (charSequence != null && charSequence.length() > 0) {
                r rVar = this.pcH;
                if (!rVar.owy.bJq()) {
                    w.e("MicroMsg.scanner.ViewMMURL", "already running, skipped");
                } else if (charSequence == null || charSequence.length() == 0) {
                    w.e("MicroMsg.scanner.ViewMMURL", "go fail, qqNum is null");
                } else {
                    rVar.url = charSequence;
                    ap.yY();
                    str = (String) com.tencent.mm.u.c.vr().get(46, null);
                    if (str == null || str.length() == 0) {
                        rVar.bB(charSequence, (int) System.currentTimeMillis());
                    } else {
                        ap.vd().a(233, rVar);
                        rVar.pcR = new l(charSequence, null, 4, (int) System.currentTimeMillis());
                        ap.vd().a(rVar.pcR, 0);
                        rVar.owy.v(3000, 3000);
                    }
                }
                return true;
            }
        } else if (pcG.contains(preference.igL) && !preference.igL.toLowerCase().contains("fax")) {
            str = preference.getSummary().toString().trim();
            if (str != null && str.length() > 0) {
                g.a(this, "", new String[]{getString(R.l.dVb)}, "", new c(this) {
                    final /* synthetic */ VcardContactUI pcK;

                    public final void hq(int i) {
                        switch (i) {
                            case 0:
                                Intent intent = new Intent("android.intent.action.DIAL");
                                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                                this.pcK.startActivity(intent);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        } else if (preference.igL.equals("v_contact_info_email")) {
            str = preference.getSummary().toString();
            g.a(this, "", new String[]{this.uSU.uTo.getString(R.l.eQX), this.uSU.uTo.getString(R.l.eQW)}, "", new c(this) {
                final /* synthetic */ VcardContactUI pcK;

                public final void hq(int i) {
                    Intent intent;
                    switch (i) {
                        case 0:
                            intent = new Intent();
                            String[] strArr = new String[]{str + " " + str};
                            intent.putExtra("composeType", 4);
                            intent.putExtra("toList", strArr);
                            d.b(this.pcK, "qqmail", ".ui.ComposeUI", intent);
                            return;
                        case 1:
                            intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
                            this.pcK.startActivity(intent);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
        return false;
    }

    protected final void KC() {
        VcardContactLinkPreference vcardContactLinkPreference;
        KeyValuePreference keyValuePreference;
        this.pcH = new r(this);
        this.isJ = this.vrv;
        this.pcF = n.oWZ;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VcardContactUI pcK;

            {
                this.pcK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pcK.finish();
                return true;
            }
        });
        qP("");
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(R.o.fuB);
        VcardContactUserHeaderPreference vcardContactUserHeaderPreference = (VcardContactUserHeaderPreference) this.isJ.Td("v_contact_info_header");
        if (vcardContactUserHeaderPreference != null) {
            n nVar = this.pcF;
            if (nVar != null) {
                if (!bg.mA(nVar.oWI.Ix())) {
                    vcardContactUserHeaderPreference.pcQ = nVar.oWI.Ix();
                }
                if (!bg.mA(nVar.aIO)) {
                    vcardContactUserHeaderPreference.aIO = nVar.aIO;
                }
                if (!bg.mA(nVar.oWW)) {
                    vcardContactUserHeaderPreference.oWW = nVar.oWW;
                }
                if (!bg.mA(nVar.title)) {
                    vcardContactUserHeaderPreference.title = nVar.title;
                }
            }
        }
        this.isJ.Te("c_contact_info_wx_id");
        if (bg.mA(this.pcF.iBa)) {
            this.isJ.Te("v_contact_info_photo_uri");
            this.isJ.Te("v_category_photo_uri");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.isJ.Td("v_contact_info_photo_uri");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.pcF.iBa);
                vcardContactLinkPreference.kZ(false);
                vcardContactLinkPreference.vrl = false;
                pcI += 2;
                pcJ += 2;
            }
        }
        a aVar = this.pcF.oWP;
        if (aVar != null && aVar.Ix().length() > 0) {
            dn(aVar.Ix(), this.uSU.uTo.getString(R.l.eZE));
        }
        aVar = this.pcF.oWQ;
        if (aVar != null && aVar.Ix().length() > 0) {
            dn(aVar.Ix(), this.uSU.uTo.getString(R.l.eZL));
        }
        aVar = this.pcF.oWN;
        if (aVar != null && aVar.Ix().length() > 0) {
            dn(aVar.Ix(), this.uSU.uTo.getString(R.l.eZC));
        }
        aVar = this.pcF.oWO;
        if (aVar != null && aVar.Ix().length() > 0) {
            dn(aVar.Ix(), this.uSU.uTo.getString(R.l.eZC));
        }
        List list = this.pcF.oWT;
        if (list != null && list.size() > 0) {
            b(list, "WorkTel", this.uSU.uTo.getString(R.l.eZM));
        }
        list = this.pcF.oWS;
        if (list != null && list.size() > 0) {
            b(list, "HomeTel", this.uSU.uTo.getString(R.l.eZF));
        }
        list = this.pcF.oWU;
        if (list != null && list.size() > 0) {
            b(list, "VideoTEL", this.uSU.uTo.getString(R.l.eZK));
        }
        list = this.pcF.oWV;
        if (list != null && list.size() > 0) {
            b(list, "NormalTel", this.uSU.uTo.getString(R.l.eZH));
        }
        list = this.pcF.oWR;
        if (list != null && list.size() > 0) {
            b(list, "CellTel", this.uSU.uTo.getString(R.l.eZD));
        }
        if (bg.mA(this.pcF.iBj)) {
            this.isJ.Te("v_contact_info_org");
        } else {
            keyValuePreference = (KeyValuePreference) this.isJ.Td("v_contact_info_org");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.pcF.iBj);
                keyValuePreference.kZ(false);
                keyValuePreference.vrl = true;
            }
        }
        if (bg.mA(this.pcF.oWX)) {
            this.isJ.Te("v_contact_info_agent");
        } else {
            keyValuePreference = (KeyValuePreference) this.isJ.Td("v_contact_info_agent");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.pcF.oWX);
                keyValuePreference.kZ(false);
                keyValuePreference.vrl = true;
            }
        }
        if (bg.mA(this.pcF.url)) {
            this.isJ.Te("v_contact_info_home_page");
            this.isJ.Te("v_category_home_page");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.isJ.Td("v_contact_info_home_page");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.pcF.url);
                vcardContactLinkPreference.kZ(false);
                vcardContactLinkPreference.vrl = true;
            }
        }
        if (bg.mA(this.pcF.gku)) {
            this.isJ.Te("v_contact_info_email");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.isJ.Td("v_contact_info_email");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary(this.pcF.gku);
                vcardContactLinkPreference.kZ(false);
                vcardContactLinkPreference.vrl = true;
            }
        }
        if (bg.mA(this.pcF.oWM)) {
            this.isJ.Te("v_contact_info_birthday");
            this.isJ.Te("v_category_birthday");
        } else {
            keyValuePreference = (KeyValuePreference) this.isJ.Td("v_contact_info_birthday");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.pcF.oWM);
                keyValuePreference.kZ(false);
                keyValuePreference.vrl = true;
            }
        }
        if (bg.mA(this.pcF.oWY)) {
            this.isJ.Te("v_contact_info_remark");
            this.isJ.Te("v_category_remark");
        } else {
            keyValuePreference = (KeyValuePreference) this.isJ.Td("v_contact_info_remark");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary(this.pcF.oWY);
                keyValuePreference.kZ(false);
                keyValuePreference.vrl = true;
            }
        }
        if (this.pcF.oWK == null || !this.pcF.oWK.oXc.contains("uri")) {
            this.isJ.Te("v_contact_info_logo");
            this.isJ.Te("v_category_logo");
            return;
        }
        vcardContactLinkPreference = (VcardContactLinkPreference) this.isJ.Td("v_contact_info_logo");
        vcardContactLinkPreference.setSummary(this.pcF.oWK.oXd);
        vcardContactLinkPreference.vrl = false;
        vcardContactLinkPreference.kZ(false);
    }

    private void b(List<String> list, String str, String str2) {
        if (list != null && list.size() > 0) {
            for (String str3 : list) {
                Preference vcardContactLinkPreference = new VcardContactLinkPreference(this);
                vcardContactLinkPreference.setKey(str + String.valueOf(str3));
                if (!pcG.contains(str + String.valueOf(str3))) {
                    pcG.add(str + String.valueOf(str3));
                }
                vcardContactLinkPreference.setTitle(str2);
                vcardContactLinkPreference.setLayoutResource(R.i.diC);
                vcardContactLinkPreference.setSummary(str3);
                vcardContactLinkPreference.kZ(false);
                vcardContactLinkPreference.vrl = true;
                vcardContactLinkPreference.bSX();
                this.isJ.a(vcardContactLinkPreference, pcI);
            }
        }
    }

    private void dn(String str, String str2) {
        Preference keyValuePreference = new KeyValuePreference(this);
        keyValuePreference.setTitle(str2);
        keyValuePreference.setLayoutResource(R.i.diC);
        keyValuePreference.kZ(false);
        keyValuePreference.setSummary(str);
        keyValuePreference.vrl = false;
        keyValuePreference.bSX();
        this.isJ.a(keyValuePreference, pcJ);
    }

    private static void a(List<String> list, Intent intent, int i, int i2) {
        for (String str : list) {
            if (i2 == 1) {
                intent.putExtra("phone", str);
                intent.putExtra("phone_type", i);
            } else if (i2 == 2) {
                intent.putExtra("secondary_phone", str);
                intent.putExtra("phone_type", i);
            } else if (i2 == 3) {
                intent.putExtra("tertiary_phone", str);
                intent.putExtra("phone_type", i);
            }
        }
    }
}
