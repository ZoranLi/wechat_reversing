package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.plugin.label.b.b;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.protocal.c.aim;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.z;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelEditUI extends MMPreference implements e {
    private ProgressDialog kIa;
    private ae mHandler = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ ContactLabelEditUI mZp;

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 6001:
                    this.mZp.aFJ();
                    return;
                case 6002:
                    a.imw.ou();
                    return;
                default:
                    w.w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", new Object[]{Integer.valueOf(message.what)});
                    return;
            }
        }
    };
    private boolean mSN = true;
    private String mYZ;
    private String mZa;
    private String mZb;
    private z mZc;
    private String mZd;
    private f mZe;
    private ContactListExpandPreference mZf;
    private InputClearablePreference mZg;
    private Preference mZh;
    private PreferenceTitleCategory mZi;
    private boolean mZj = true;
    private ArrayList<String> mZk = new ArrayList();
    private ArrayList<String> mZl = new ArrayList();
    private HashSet<String> mZm = new HashSet();
    private HashSet<String> mZn = new HashSet();
    private String mZo;

    static /* synthetic */ void a(ContactLabelEditUI contactLabelEditUI, String str) {
        w.i("MicroMsg.Label.ContactLabelEditUI", "cpan[dealRemoveContact]");
        if (contactLabelEditUI.mZk != null && contactLabelEditUI.mZk.contains(str)) {
            contactLabelEditUI.mZk.remove(str);
        }
        if (contactLabelEditUI.mZl != null && contactLabelEditUI.mZl.contains(str)) {
            contactLabelEditUI.mZn.add(str);
        }
        if (contactLabelEditUI.mZm != null && contactLabelEditUI.mZm.contains(str)) {
            contactLabelEditUI.mZm.remove(str);
        }
        if (contactLabelEditUI.mHandler != null) {
            contactLabelEditUI.mHandler.sendEmptyMessage(6001);
        }
    }

    static /* synthetic */ void b(ContactLabelEditUI contactLabelEditUI) {
        w.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveLabelChange]");
        contactLabelEditUI.zi(contactLabelEditUI.getString(R.l.evH));
        contactLabelEditUI.mZa = bg.ap(contactLabelEditUI.mZa, "");
        contactLabelEditUI.mZa = contactLabelEditUI.mZa.trim();
        if (bg.mA(contactLabelEditUI.mZa)) {
            contactLabelEditUI.aFI();
            contactLabelEditUI.uC(contactLabelEditUI.getString(R.l.evD));
        } else if (h.Un(contactLabelEditUI.mZa) > 36) {
            contactLabelEditUI.aFI();
            contactLabelEditUI.uC(String.format(contactLabelEditUI.getString(R.l.dBW), new Object[]{Integer.valueOf(h.aI(36, ""))}));
        } else if (!(zk(contactLabelEditUI.mZa) && contactLabelEditUI.mZj) && (!zk(contactLabelEditUI.mZa) || bg.mA(contactLabelEditUI.mYZ) || contactLabelEditUI.mYZ.equals(contactLabelEditUI.mZa))) {
            z QU = com.tencent.mm.plugin.label.e.aFF().QU(contactLabelEditUI.mZb);
            if (contactLabelEditUI.mZj || QU.field_isTemporary) {
                ap.vd().a(new com.tencent.mm.plugin.label.b.a(contactLabelEditUI.mZa), 0);
                return;
            }
            ap.vd().a(new com.tencent.mm.plugin.label.b.e(Integer.valueOf(contactLabelEditUI.mZb).intValue(), contactLabelEditUI.mZa), 0);
        } else {
            contactLabelEditUI.aFI();
            contactLabelEditUI.uC(contactLabelEditUI.getString(R.l.dBT));
        }
    }

    static /* synthetic */ void d(ContactLabelEditUI contactLabelEditUI) {
        w.i("MicroMsg.Label.ContactLabelEditUI", "cpan[dealAddContact]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", s.q(new int[]{s.vYO, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelEditUI.getString(R.l.evx));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 6);
        if (contactLabelEditUI.mZk != null) {
            intent.putExtra("always_select_contact", bg.c(contactLabelEditUI.mZk, ","));
        }
        d.a(contactLabelEditUI, ".ui.contact.SelectContactUI", intent, 7001);
    }

    static /* synthetic */ void l(ContactLabelEditUI contactLabelEditUI) {
        if (contactLabelEditUI.mZc.field_isTemporary) {
            contactLabelEditUI.a(contactLabelEditUI.mZc);
            return;
        }
        z zVar = contactLabelEditUI.mZc;
        if (zVar == null) {
            w.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteScene] can not do scene. lable is null");
            return;
        }
        contactLabelEditUI.zi(contactLabelEditUI.getString(R.l.evA));
        ap.vd().a(new b(zVar.field_labelID), 0);
    }

    public final int ON() {
        return R.o.ftO;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mZo = m.xL();
        this.mZb = getIntent().getStringExtra("label_id");
        this.mYZ = getIntent().getStringExtra("label_name");
        this.mZa = getIntent().getStringExtra("label_name");
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (!bg.mA(stringExtra)) {
            List f = bg.f(stringExtra.split(","));
            this.mZk = new ArrayList();
            if (f != null && f.size() > 0) {
                int size = f.size();
                for (int i = 0; i < size; i++) {
                    stringExtra = (String) f.get(i);
                    if (!bg.mA(stringExtra)) {
                        if (!o.eU(stringExtra) || this.mZk.contains(stringExtra) || stringExtra.equals(this.mZo)) {
                            w.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[]{stringExtra});
                        } else {
                            this.mZk.add(stringExtra);
                            this.mZm.add(stringExtra);
                        }
                    }
                }
            }
        }
        ap.vd().a(635, this);
        ap.vd().a(637, this);
        ap.vd().a(638, this);
        KC();
    }

    protected void onResume() {
        com.tencent.mm.modelstat.d.a(3, "ContactLabelEditUI" + aFO(), hashCode());
        ap.vd().a(636, this);
        zj(this.mZa);
        aFJ();
        super.onResume();
    }

    protected void onPause() {
        com.tencent.mm.modelstat.d.a(4, "ContactLabelEditUI" + aFO(), hashCode());
        ap.vd().b(636, this);
        super.onPause();
    }

    protected void onDestroy() {
        ap.vd().b(635, this);
        ap.vd().b(637, this);
        ap.vd().b(638, this);
        super.onDestroy();
    }

    protected final void KC() {
        if (bg.mA(this.mZb)) {
            this.mZj = true;
            this.mZd = getString(R.l.eGQ);
        } else {
            this.mZj = false;
            this.mZc = com.tencent.mm.plugin.label.e.aFF().QU(this.mZb);
            this.mZd = getString(R.l.eGP);
        }
        qP(this.mZd);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelEditUI mZp;

            {
                this.mZp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mZp.onBackPressed();
                return true;
            }
        });
        a(0, getString(R.l.dIx), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelEditUI mZp;

            {
                this.mZp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactLabelEditUI.b(this.mZp);
                return true;
            }
        }, l.b.uTY);
        this.mZe = this.vrv;
        this.mZf = (ContactListExpandPreference) this.mZe.Td("contact_label_contact_list");
        this.mZf.a(this.mZe, this.mZf.igL);
        this.mZf.ju(true);
        this.mZf.jv(true);
        this.mZf.bFa();
        this.mZf.bFd();
        this.mZf.a(new g.b(this) {
            final /* synthetic */ ContactLabelEditUI mZp;

            {
                this.mZp = r1;
            }

            public final boolean kJ(int i) {
                return false;
            }
        });
        this.mZf.a(new ContactListExpandPreference.a(this) {
            final /* synthetic */ ContactLabelEditUI mZp;

            {
                this.mZp = r1;
            }

            public final void kL(int i) {
                if (this.mZp.mZf.xt(i)) {
                    String xu = this.mZp.mZf.xu(i);
                    String xv = this.mZp.mZf.xv(i);
                    if (!bg.mA(xu)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", xu);
                        intent.putExtra("Contact_RoomNickname", xv);
                        a.imv.d(intent, this.mZp);
                    }
                }
            }

            public final void ajs() {
                if (this.mZp.mZf != null) {
                    this.mZp.mZf.bFb();
                }
            }

            public final void kM(int i) {
                ContactLabelEditUI.d(this.mZp);
            }

            public final void kK(int i) {
                w.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", new Object[]{Integer.valueOf(i), this.mZp.mZf.xu(i)});
                ContactLabelEditUI.a(this.mZp, r0);
            }
        });
        this.mZg = (InputClearablePreference) this.mZe.Td("contact_label_name");
        InputClearablePreference inputClearablePreference = this.mZg;
        inputClearablePreference.nay = getString(R.l.evB);
        if (inputClearablePreference.naD != null) {
            inputClearablePreference.naD.setHint(inputClearablePreference.nay);
        }
        this.mZg.iMT = getString(R.l.evF);
        inputClearablePreference = this.mZg;
        inputClearablePreference.naz = getString(R.l.dBV);
        if (inputClearablePreference.naF != null) {
            inputClearablePreference.naF.setText(inputClearablePreference.naz);
        }
        this.mZg.naA = 36;
        this.mZg.naC = this.mZj;
        this.mZg.naH = new InputClearablePreference.a(this) {
            final /* synthetic */ ContactLabelEditUI mZp;

            {
                this.mZp = r1;
            }

            public final void zl(String str) {
                this.mZp.mZa = str;
                this.mZp.zj(str);
                this.mZp.mZg.fk(false);
            }

            public final void fi(boolean z) {
                if (this.mZp.mZj || !this.mZp.mSN) {
                    this.mZp.kr(z);
                    return;
                }
                this.mZp.kr(false);
                this.mZp.mSN = false;
            }
        };
        this.mZg.setText(this.mZa);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(6001);
        }
        if (!this.mZj) {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ ContactLabelEditUI mZp;

                {
                    this.mZp = r1;
                }

                public final void run() {
                    ArrayList QS = com.tencent.mm.plugin.label.e.aFF().QS(this.mZp.mZb);
                    if (QS == null) {
                        w.w("MicroMsg.Label.ContactLabelEditUI", "result is null");
                        return;
                    }
                    if (QS != null) {
                        this.mZp.mZk = QS;
                        if (this.mZp.mZl == null) {
                            this.mZp.mZl = new ArrayList();
                        } else {
                            this.mZp.mZl.clear();
                        }
                        this.mZp.mZl.addAll(QS);
                    }
                    if (this.mZp.mHandler != null) {
                        this.mZp.mHandler.sendEmptyMessage(6001);
                    }
                }

                public final String toString() {
                    return super.toString() + "|initView";
                }
            });
        } else if (this.mZk == null || this.mZk.size() <= 0) {
            this.mZf.ae(new ArrayList());
        } else {
            this.mZf.k(null, this.mZk);
        }
        if (this.mUX != null) {
            this.mUX.setOnScrollListener(new OnScrollListener(this) {
                final /* synthetic */ ContactLabelEditUI mZp;

                {
                    this.mZp = r1;
                }

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i == 2 || i == 1) {
                        this.mZp.aHf();
                    }
                }

                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                }
            });
        }
        this.mZh = this.mZe.Td("contact_label_delete");
        this.mZi = (PreferenceTitleCategory) this.mZe.Td("contact_label_empty_category");
        if (this.mZj) {
            this.mZe.c(this.mZh);
            this.mZe.c(this.mZi);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 7001:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    w.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", new Object[]{stringExtra});
                    if (!bg.mA(stringExtra)) {
                        List f = bg.f(stringExtra.split(","));
                        if (f != null && f.size() > 0) {
                            int size = f.size();
                            int i3 = 0;
                            while (i3 < size) {
                                stringExtra = (String) f.get(i3);
                                if (!bg.mA(stringExtra)) {
                                    if (!o.eU(stringExtra) || this.mZk.contains(stringExtra) || stringExtra.equals(this.mZo)) {
                                        w.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[]{stringExtra});
                                    } else {
                                        this.mZk.add(stringExtra);
                                        if (!(this.mZl == null || this.mZl.contains(f.get(i3)))) {
                                            this.mZm.add(stringExtra);
                                        }
                                        if (this.mZn != null && this.mZn.contains(stringExtra)) {
                                            this.mZn.remove(stringExtra);
                                        }
                                    }
                                }
                                i3++;
                            }
                        }
                        if (this.mHandler != null) {
                            this.mHandler.sendEmptyMessage(6001);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if (bg.mA(str)) {
            w.w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
        } else {
            if (str.equals("contact_label_delete")) {
                com.tencent.mm.ui.base.g.a(this, getString(R.l.evz), "", getString(R.l.dGB), getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ ContactLabelEditUI mZp;

                    {
                        this.mZp = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ContactLabelEditUI.l(this.mZp);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ ContactLabelEditUI mZp;

                    {
                        this.mZp = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
            w.d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", new Object[]{str});
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 635:
                if (i == 0 && i2 == 0) {
                    LinkedList linkedList = ((com.tencent.mm.plugin.label.b.a) kVar).aFH().teP;
                    if (linkedList == null || linkedList.size() <= 0) {
                        aFL();
                        return;
                    }
                    w.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[]{r0.tMv, ((aim) linkedList.get(0)).tMu});
                    this.mZb = r0.tMv;
                    aFM();
                    return;
                }
                aFL();
                return;
            case 636:
                if (i == 0 && i2 == 0) {
                    a(this.mZc);
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(6002, 300);
                        return;
                    }
                    return;
                }
                w.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
                aFN();
                return;
            case 637:
                if (i == 0 && i2 == 0) {
                    int intValue;
                    String str2 = this.mZb;
                    String str3 = this.mZa;
                    w.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
                    try {
                        intValue = Integer.valueOf(str2).intValue();
                    } catch (Exception e) {
                        w.e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", new Object[]{str2});
                        intValue = -1;
                    }
                    if (intValue != -1) {
                        z QU = com.tencent.mm.plugin.label.e.aFF().QU(str2);
                        if (QU == null) {
                            QU = new z();
                        }
                        QU.field_labelID = intValue;
                        QU.field_labelName = str3;
                        QU.field_labelPYFull = c.mp(str3);
                        QU.field_labelPYShort = c.mp(str3);
                        com.tencent.mm.plugin.label.e.aFF().b(true, QU, "labelID");
                    } else {
                        aFL();
                    }
                    aFM();
                    return;
                }
                aFL();
                return;
            case 638:
                if (i == 0 && i2 == 0) {
                    aFK();
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(6002, 300);
                        return;
                    }
                    return;
                }
                aFL();
                return;
            default:
                return;
        }
    }

    private void aFJ() {
        if (this.mZf != null) {
            this.mZf.k(null, this.mZk);
            if (this.mZk == null || this.mZk.size() <= 0) {
                this.mZf.bFb();
            }
        }
        if (this.mZg != null) {
            this.mZg.setText(this.mZa);
        }
    }

    private void zj(String str) {
        kr(!bg.mA(str));
    }

    private void aFK() {
        int size;
        w.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
        aFI();
        if (this.mZm != null) {
            size = this.mZm.size();
        } else {
            size = 0;
        }
        w.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", new Object[]{Integer.valueOf(size)});
        com.tencent.mm.plugin.report.service.g.oUh.i(11220, new Object[]{m.xL(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(size)});
        if (this.mZj) {
            Intent intent = getIntent();
            intent.putExtra("k_sns_label_add_label", this.mZa);
            setResult(0, intent);
        } else {
            setResult(0);
        }
        finish();
    }

    private void aFL() {
        w.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
        aFI();
        uC(getString(R.l.dBU));
    }

    private static boolean zk(String str) {
        if (bg.mA(com.tencent.mm.plugin.label.e.aFF().ze(str))) {
            return false;
        }
        return true;
    }

    private void aFM() {
        int i;
        Iterator it;
        String str = "MicroMsg.Label.ContactLabelEditUI";
        String str2 = "cpan[doUpdateContactList] addcount:%d,delcount:%d";
        Object[] objArr = new Object[2];
        if (this.mZm == null) {
            i = 0;
        } else {
            i = this.mZm.size();
        }
        objArr[0] = Integer.valueOf(i);
        if (this.mZn == null) {
            i = 0;
        } else {
            i = this.mZn.size();
        }
        objArr[1] = Integer.valueOf(i);
        w.i(str, str2, objArr);
        LinkedList linkedList = new LinkedList();
        if (this.mZm != null && this.mZm.size() > 0) {
            this.mZm.size();
            it = this.mZm.iterator();
            while (it.hasNext()) {
                String str3;
                String cF;
                String str4 = (String) it.next();
                ap.yY();
                af Rc = com.tencent.mm.u.c.wR().Rc(str4);
                str3 = Rc.field_contactLabelIds;
                cF = com.tencent.mm.plugin.label.c.cF(str3, this.mZb);
                w.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", new Object[]{str3, cF});
                if (!cF.equalsIgnoreCase(str3)) {
                    bio com_tencent_mm_protocal_c_bio = new bio();
                    com_tencent_mm_protocal_c_bio.jNj = Rc.field_username;
                    com_tencent_mm_protocal_c_bio.tts = cF;
                    linkedList.add(com_tencent_mm_protocal_c_bio);
                }
            }
        }
        if (this.mZn != null && this.mZn.size() > 0) {
            this.mZn.size();
            it = this.mZn.iterator();
            while (it.hasNext()) {
                str4 = (String) it.next();
                ap.yY();
                str3 = com.tencent.mm.u.c.wR().Rc(str4).field_contactLabelIds;
                cF = com.tencent.mm.plugin.label.c.cG(str3, this.mZb);
                w.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", new Object[]{str4, str3, cF});
                if (!cF.equalsIgnoreCase(str3)) {
                    com_tencent_mm_protocal_c_bio = new bio();
                    com_tencent_mm_protocal_c_bio.jNj = str4;
                    com_tencent_mm_protocal_c_bio.tts = cF;
                    linkedList.add(com_tencent_mm_protocal_c_bio);
                }
            }
        }
        if (linkedList.size() > 0) {
            ap.vd().a(new com.tencent.mm.plugin.label.b.d(linkedList), 0);
            return;
        }
        aFK();
    }

    private void zi(String str) {
        getString(R.l.dIO);
        this.kIa = com.tencent.mm.ui.base.g.a(this, str, true, new OnCancelListener(this) {
            final /* synthetic */ ContactLabelEditUI mZp;

            {
                this.mZp = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().cancel(635);
                ap.vd().cancel(637);
            }
        });
    }

    private void aFI() {
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
    }

    private void uC(String str) {
        com.tencent.mm.ui.base.g.a(this, str, "", new OnClickListener(this) {
            final /* synthetic */ ContactLabelEditUI mZp;

            {
                this.mZp = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public void onBackPressed() {
        if ((bg.mA(this.mZa) || this.mZa.equals(this.mYZ)) && ((this.mZm == null || this.mZm.size() <= 0) && (this.mZn == null || this.mZn.size() <= 0))) {
            setResult(0);
            finish();
            return;
        }
        com.tencent.mm.ui.base.g.a(this, getString(R.l.eOl), "", getString(R.l.dPP), getString(R.l.dPQ), new OnClickListener(this) {
            final /* synthetic */ ContactLabelEditUI mZp;

            {
                this.mZp = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                ContactLabelEditUI.b(this.mZp);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ ContactLabelEditUI mZp;

            {
                this.mZp = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.mZp.setResult(0);
                this.mZp.finish();
            }
        });
    }

    private void a(z zVar) {
        if (com.tencent.mm.plugin.label.e.aFF().a(true, zVar, "labelID")) {
            setResult(-1);
            finish();
            return;
        }
        w.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
        aFN();
    }

    private void aFN() {
        uC(getString(R.l.ebp));
    }

    protected final String aFO() {
        if (this.mZj) {
            return "_New";
        }
        return "_Edit";
    }
}
