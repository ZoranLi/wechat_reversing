package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.z;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.l.b;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelUI extends ContactLabelBaseUI implements e {
    private String gLD;
    private MMTagPanelScrollView mZW;
    private MMLabelPanel mZX;
    private TextView mZY;
    private View mZZ;
    private boolean mZw = true;
    private View naa;
    private TextView nab;
    private MMLabelPanel nac;
    private ListView nad;
    private ScrollView nae;
    private b naf;
    private String nag;
    private ArrayList<String> nah;
    private HashSet<String> nai = new HashSet();
    private HashSet<String> naj = new HashSet();
    private ArrayList<String> nak = new ArrayList();
    private int nal = a.naq;
    private boolean nam = false;
    private ArrayList<String> nan;

    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] nap = new int[a.aFT().length];

        static {
            try {
                nap[a.naq - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nap[a.nar - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nap[a.nas - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                nap[a.nat - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private enum a {
        ;

        public static int[] aFT() {
            return (int[]) nau.clone();
        }

        static {
            naq = 1;
            nar = 2;
            nas = 3;
            nat = 4;
            nau = new int[]{naq, nar, nas, nat};
        }
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI) {
        w.i("MicroMsg.Label.ContactLabelUI", "cpan[save]");
        if (contactLabelUI.mZX == null) {
            w.w("MicroMsg.Label.ContactLabelUI", "save fail. input view is null.");
            return;
        }
        contactLabelUI.zi(contactLabelUI.getString(R.l.evH));
        String bSt;
        if (contactLabelUI.nam) {
            w.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger]");
            if (contactLabelUI.mZX != null) {
                bSt = contactLabelUI.mZX.bSt();
                if (!bg.mA(bSt)) {
                    contactLabelUI.mZX.aT(bSt, true);
                    contactLabelUI.mZX.bSu();
                    contactLabelUI.Z(bSt, contactLabelUI.nam);
                }
            }
            if (contactLabelUI.naj != null && contactLabelUI.naj.size() > 0) {
                w.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger] save local");
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(contactLabelUI.naj);
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    List arrayList2 = new ArrayList();
                    for (int i = 0; i < size; i++) {
                        z zVar = new z();
                        bSt = (String) arrayList.get(i);
                        zVar.field_isTemporary = true;
                        zVar.field_labelName = bSt;
                        zVar.field_labelPYFull = c.mp(bSt);
                        zVar.field_labelPYShort = c.mq(bSt);
                        zVar.field_labelID = -((int) System.nanoTime());
                        w.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger]field_labelID:%s field_labelName:%s", new Object[]{Integer.valueOf(zVar.field_labelID), zVar.field_labelName});
                        arrayList2.add(zVar);
                    }
                    com.tencent.mm.plugin.label.e.aFF().bZ(arrayList2);
                }
            }
            w.i("MicroMsg.Label.ContactLabelUI", "cpan[saveStranger]");
            ap.yY();
            com.tencent.mm.sdk.e.c AI = com.tencent.mm.u.c.wS().AI(contactLabelUI.gLD);
            if (contactLabelUI.mZX != null) {
                String aI = com.tencent.mm.plugin.label.a.a.aFG().aI(contactLabelUI.mZX.bSy());
                if (bg.mA(aI)) {
                    AI.field_contactLabels = "";
                    ap.yY();
                    com.tencent.mm.u.c.wS().a(AI);
                } else {
                    AI.field_contactLabels = aI;
                    if (bg.mA(AI.field_encryptUsername)) {
                        AI.field_encryptUsername = contactLabelUI.gLD;
                    }
                    ap.yY();
                    com.tencent.mm.u.c.wS().a(AI);
                }
            }
            contactLabelUI.aFR();
            return;
        }
        w.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabel]");
        if (contactLabelUI.mZX != null) {
            bSt = contactLabelUI.mZX.bSt();
            if (!bg.mA(bSt)) {
                bSt = bSt.trim();
                contactLabelUI.mZX.aT(bSt, true);
                contactLabelUI.mZX.bSu();
                contactLabelUI.Z(bSt, contactLabelUI.nam);
            }
        }
        if (contactLabelUI.naj == null || contactLabelUI.naj.size() <= 0) {
            w.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doSaveContact");
            contactLabelUI.aFQ();
            return;
        }
        w.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doScene");
        List arrayList3 = new ArrayList();
        arrayList3.addAll(contactLabelUI.naj);
        ap.vd().a(new com.tencent.mm.plugin.label.b.a(arrayList3), 0);
        if (contactLabelUI.nak == null || contactLabelUI.naj.isEmpty()) {
            g.oUh.i(11347, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
            return;
        }
        g.oUh.i(11347, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI, String str) {
        if (contactLabelUI.nah != null && contactLabelUI.nah.contains(str)) {
            contactLabelUI.nai.add(str);
        }
        if (contactLabelUI.naj != null && contactLabelUI.naj.contains(str)) {
            contactLabelUI.naj.remove(str);
        }
        if (contactLabelUI.aFS()) {
            contactLabelUI.kr(true);
        }
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI, ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            af.f(new Runnable(contactLabelUI) {
                final /* synthetic */ ContactLabelUI nao;

                {
                    this.nao = r1;
                }

                public final void run() {
                    this.nao.mZX.bSw();
                    this.nao.aHj();
                }
            }, 50);
        } else {
            af.f(new Runnable(contactLabelUI) {
                final /* synthetic */ ContactLabelUI nao;

                {
                    this.nao = r1;
                }

                public final void run() {
                    this.nao.mZX.bSx();
                    this.nao.aHf();
                }
            }, 50);
        }
    }

    static /* synthetic */ void b(ContactLabelUI contactLabelUI, String str) {
        if (bg.mA(str)) {
            contactLabelUI.oC(a.naq);
            return;
        }
        contactLabelUI.oC(a.nar);
        if (contactLabelUI.mZX != null) {
            b bVar = contactLabelUI.naf;
            List bSy = contactLabelUI.mZX.bSy();
            if (bVar.mZU != null) {
                bVar.mZU.clear();
            }
            if (bVar.mZV != null) {
                bVar.mZV.clear();
            }
            bVar.mZT = bg.ap(str, "");
            bVar.mZU = com.tencent.mm.plugin.label.e.aFF().l(str, bSy);
            bVar.notifyDataSetChanged();
        }
    }

    protected final int getLayoutId() {
        return R.i.cZE;
    }

    protected final void KC() {
        qP(getString(R.l.dBX));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelUI nao;

            {
                this.nao = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nao.onBackPressed();
                return false;
            }
        });
        a(0, getString(R.l.dIx), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelUI nao;

            {
                this.nao = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactLabelUI.a(this.nao);
                return false;
            }
        }, b.uTY);
        this.mZW = (MMTagPanelScrollView) findViewById(R.h.can);
        this.mZW.vnd = 3;
        this.mZX = (MMLabelPanel) findViewById(R.h.cam);
        this.mZY = (TextView) findViewById(R.h.cap);
        this.mZZ = findViewById(R.h.cal);
        this.naa = findViewById(R.h.cak);
        this.naa.setBackgroundDrawable(null);
        this.nab = (TextView) this.naa.findViewById(16908310);
        this.nab.setText(R.l.caj);
        this.nac = (MMLabelPanel) findViewById(R.h.caj);
        this.nad = (ListView) findViewById(R.h.cao);
        this.nae = (ScrollView) findViewById(R.h.caq);
        if (this.nae != null) {
            this.nae.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ ContactLabelUI nao;

                {
                    this.nao = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 2) {
                        this.nao.aHf();
                    }
                    return false;
                }
            });
        }
        this.mZX.vmC = true;
        this.mZX.kU(true);
        this.mZX.Ak(R.g.bkq);
        this.mZX.vmJ = new com.tencent.mm.ui.base.MMTagPanel.a(this) {
            final /* synthetic */ ContactLabelUI nao;

            {
                this.nao = r1;
            }

            public final void uM(String str) {
                w.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", new Object[]{str});
                this.nao.mZX.removeTag(str);
                if (this.nao.nac != null) {
                    this.nao.nac.aU(str, false);
                }
                ContactLabelUI.a(this.nao, str);
            }

            public final void uN(String str) {
                w.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", new Object[]{str});
            }

            public final void uO(String str) {
                w.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", new Object[]{str});
                if (this.nao.nac != null) {
                    this.nao.nac.aU(str, false);
                }
                ContactLabelUI.a(this.nao, str);
            }

            public final void aoI() {
                w.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
            }

            public final void uP(String str) {
                w.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", new Object[]{str});
                ContactLabelUI.b(this.nao, str);
            }

            public final void uQ(String str) {
                w.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", new Object[]{str});
                if (bg.mA(str)) {
                    w.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
                    return;
                }
                this.nao.mZX.aT(str, true);
                if (this.nao.nac != null) {
                    this.nao.nac.aU(str, true);
                }
                this.nao.Z(str, this.nao.nam);
            }

            public final void h(boolean z, int i) {
                w.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", new Object[]{String.valueOf(z), Integer.valueOf(i)});
                if (z) {
                    this.nao.kr(false);
                    this.nao.mZY.setVisibility(0);
                    this.nao.mZY.setText(R.l.evF);
                    this.nao.mZY.setText(String.format(this.nao.getString(R.l.evF), new Object[]{Integer.valueOf(h.aI(36, "")), Integer.valueOf(i)}));
                    return;
                }
                this.nao.kr(true);
                this.nao.mZY.setVisibility(8);
            }
        };
        this.nac.kU(false);
        this.nac.vmJ = new com.tencent.mm.ui.base.MMTagPanel.a(this) {
            final /* synthetic */ ContactLabelUI nao;

            {
                this.nao = r1;
            }

            public final void uM(String str) {
                w.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", new Object[]{str});
                if (this.nao.mZX != null) {
                    this.nao.mZX.removeTag(str);
                }
                ContactLabelUI.a(this.nao, str);
            }

            public final void uN(String str) {
                w.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", new Object[]{str});
                if (this.nao.mZX != null) {
                    this.nao.mZX.aT(str, true);
                }
                this.nao.Z(str, this.nao.nam);
            }

            public final void uO(String str) {
            }

            public final void h(boolean z, int i) {
            }

            public final void aoI() {
            }

            public final void uP(String str) {
            }

            public final void uQ(String str) {
            }
        };
        this.nad.setAdapter(this.naf);
        this.nad.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ContactLabelUI nao;

            {
                this.nao = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.nao.naf != null) {
                    String hO = this.nao.naf.hO(i);
                    if (!bg.mA(hO) && this.nao.mZX != null) {
                        this.nao.mZX.bSu();
                        this.nao.mZX.aT(hO, true);
                        this.nao.nac.aU(hO, true);
                    }
                }
            }
        });
        kr(false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nag = getIntent().getStringExtra("label_id_list");
        this.nah = getIntent().getStringArrayListExtra("label_str_list");
        this.gLD = getIntent().getStringExtra("label_username");
        this.nam = getIntent().getBooleanExtra("is_stranger", false);
        this.naf = new b(this);
        KC();
        if (!(bg.mA(this.nag) || this.nah == null || this.nah.size() <= 0)) {
            this.mZX.a(this.nah, this.nah);
        }
        if (this.nam) {
            this.nan = getIntent().getStringArrayListExtra("label_str_list");
            this.mZX.a(this.nan, this.nan);
        }
    }

    protected void onResume() {
        ap.vd().a(635, this);
        ap.vd().a(638, this);
        af.v(new Runnable(this) {
            final /* synthetic */ ContactLabelUI nao;

            {
                this.nao = r1;
            }

            public final void run() {
                Collection collection = null;
                this.nao.nai.clear();
                this.nao.naj.clear();
                if (this.nao.mZX != null) {
                    com.tencent.mm.e.b.af Rc;
                    String str;
                    if (this.nao.nam) {
                        String str2;
                        ap.yY();
                        bb AI = com.tencent.mm.u.c.wS().AI(this.nao.gLD);
                        if (AI != null) {
                            str2 = AI.field_contactLabels;
                        }
                        if (bg.mA(str2)) {
                            ap.yY();
                            Rc = com.tencent.mm.u.c.wR().Rc(this.nao.gLD);
                            String str3 = Rc.field_encryptUsername;
                            if (!bg.mA(str3)) {
                                ap.yY();
                                bb AI2 = com.tencent.mm.u.c.wS().AI(str3);
                                if (AI2 != null) {
                                    str2 = AI2.field_contactLabels;
                                }
                            }
                            if (bg.mA(str2)) {
                                str = Rc.field_username;
                                ap.yY();
                                AI = com.tencent.mm.u.c.wS().AI(str);
                                if (AI != null) {
                                    str2 = AI.field_contactLabels;
                                }
                            }
                        }
                        collection = (ArrayList) com.tencent.mm.plugin.label.a.a.aFG().zf(str2);
                    } else {
                        ap.yY();
                        Rc = com.tencent.mm.u.c.wR().Rc(this.nao.gLD);
                        if (Rc != null) {
                            str = Rc.field_contactLabelIds;
                            if (!bg.mA(str)) {
                                ArrayList arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.aFG().zg(str);
                            }
                        }
                    }
                    this.nao.mZX.a(collection, collection);
                    ContactLabelUI.a(this.nao, (ArrayList) collection);
                }
                if (this.nao.nac != null) {
                    this.nao.nak = com.tencent.mm.plugin.label.e.aFF().bLl();
                    if (this.nao.nak != null && this.nao.nak.size() > 0) {
                        this.nao.nac.a(collection, this.nao.nak);
                        if (this.nao.mZw) {
                            g.oUh.i(11346, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
                            this.nao.mZw = false;
                        }
                    } else if (this.nao.mZw) {
                        g.oUh.i(11346, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
                        this.nao.mZw = false;
                    }
                }
                this.nao.oC(a.naq);
            }
        });
        super.onResume();
    }

    protected void onPause() {
        ap.vd().b(635, this);
        ap.vd().b(638, this);
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 635:
                if (i == 0 && i2 == 0) {
                    aFQ();
                    return;
                } else {
                    aFL();
                    return;
                }
            case 638:
                if (i == 0 && i2 == 0) {
                    w.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
                    aFR();
                    return;
                }
                aFL();
                return;
            default:
                w.w("MicroMsg.Label.ContactLabelUI", "unknow type.");
                return;
        }
    }

    public void onBackPressed() {
        if (aFS()) {
            com.tencent.mm.ui.base.g.a(this, getString(R.l.eOl), "", getString(R.l.dPP), getString(R.l.dPQ), new OnClickListener(this) {
                final /* synthetic */ ContactLabelUI nao;

                {
                    this.nao = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ContactLabelUI.a(this.nao);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ ContactLabelUI nao;

                {
                    this.nao = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.nao.finish();
                }
            });
        } else {
            super.onBackPressed();
        }
    }

    private void oC(int i) {
        this.nal = i;
        switch (AnonymousClass4.nap[this.nal - 1]) {
            case 1:
                this.nad.setVisibility(8);
                if (this.nak == null || this.nak.size() <= 0) {
                    this.nae.setVisibility(8);
                    this.mZZ.setVisibility(8);
                } else {
                    this.mZZ.setVisibility(0);
                    this.nae.setVisibility(0);
                }
                this.mZY.setVisibility(8);
                return;
            case 2:
                this.nae.setVisibility(8);
                this.nad.setVisibility(0);
                this.mZZ.setVisibility(8);
                this.mZY.setVisibility(8);
                return;
            case 3:
                this.nad.setVisibility(8);
                this.nae.setVisibility(8);
                this.mZZ.setVisibility(8);
                this.mZY.setVisibility(0);
                this.mZY.setText(R.l.evF);
                return;
            case 4:
                this.nad.setVisibility(8);
                this.nae.setVisibility(8);
                this.mZZ.setVisibility(8);
                this.mZY.setVisibility(0);
                this.mZY.setText(R.l.evF);
                return;
            default:
                return;
        }
    }

    private void Z(String str, boolean z) {
        if (bg.mA(str)) {
            w.w("MicroMsg.Label.ContactLabelUI", "tag is empty");
            return;
        }
        String trim = str.trim();
        if (bg.mA(trim)) {
            w.w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
            return;
        }
        z QT = com.tencent.mm.plugin.label.e.aFF().QT(trim);
        if (z) {
            if (this.nak == null || !this.nak.contains(trim) || QT == null) {
                this.naj.add(trim);
            }
        } else if (this.nak == null || !this.nak.contains(trim) || (QT != null && QT.field_isTemporary)) {
            this.naj.add(trim);
        }
        if (this.nai != null && this.nai.contains(trim)) {
            this.nai.remove(trim);
        }
        if (aFS()) {
            kr(true);
        }
    }

    private void aFQ() {
        w.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
        if (this.mZX != null) {
            int size;
            int size2;
            int size3;
            w.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
            String str = "";
            ArrayList bSy = this.mZX.bSy();
            if (bSy.size() > 0) {
                str = com.tencent.mm.plugin.label.c.aK(com.tencent.mm.plugin.label.e.aFF().af(bSy));
            }
            LinkedList linkedList = new LinkedList();
            bio com_tencent_mm_protocal_c_bio = new bio();
            com_tencent_mm_protocal_c_bio.tts = str;
            com_tencent_mm_protocal_c_bio.jNj = this.gLD;
            linkedList.add(com_tencent_mm_protocal_c_bio);
            ap.vd().a(new d(linkedList), 0);
            if (this.naj != null) {
                size = this.naj.size();
            } else {
                size = 0;
            }
            if (this.nah != null) {
                size2 = this.nah.size();
            } else {
                size2 = 0;
            }
            if (this.nai != null) {
                size3 = this.nai.size();
            } else {
                size3 = 0;
            }
            size2 = ((size3 + this.mZX.bSy().size()) - size2) - size;
            if (size > 0 || size2 > 0) {
                w.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[]{Integer.valueOf(size), Integer.valueOf(size2)});
                g.oUh.i(11220, new Object[]{m.xL(), Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(0)});
            }
        }
    }

    private void aFR() {
        aFI();
        this.naj.clear();
        this.nai.clear();
        finish();
    }

    private void aFL() {
        aFI();
        uC(getString(R.l.dBU));
    }

    private boolean aFS() {
        if (this.mZX != null) {
            if (this.nah == null || this.nah.size() <= 0) {
                this.mZX.bSy();
                if (this.mZX.bSy().size() > 0) {
                    return true;
                }
            }
            this.mZX.bSy();
            List bSy = this.mZX.bSy();
            Collections.sort(this.nah);
            Collections.sort(bSy);
            if (this.nah.equals(bSy)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void finish() {
        if (this.mZX != null) {
            this.mZX.bSx();
        }
        Intent intent = new Intent();
        if (aFS()) {
            intent.putExtra("hasLableChange", true);
        } else {
            intent.putExtra("hasLableChange", false);
        }
        setResult(-1, intent);
        super.finish();
    }
}
