package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsUserUI extends MMActivity implements com.tencent.mm.plugin.sns.b.g.a {
    private c iOT = new c<jc>(this) {
        final /* synthetic */ SnsUserUI qKo;

        {
            this.qKo = r2;
            this.usg = jc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jc jcVar = (jc) bVar;
            if (jcVar instanceof jc) {
                switch (jcVar.fPc.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        this.qKo.qKj.notifyDataSetChanged();
                        break;
                }
            }
            return false;
        }
    };
    private String jia;
    private as qKj;
    private ba qKk;
    private com.tencent.mm.plugin.sns.model.al.a qKl;
    private com.tencent.mm.plugin.sns.ui.ba.a qKm;
    private Runnable qKn = new Runnable(this) {
        final /* synthetic */ SnsUserUI qKo;

        {
            this.qKo = r1;
        }

        public final void run() {
            this.qKo.qKj.bkI();
            this.qKo.qKj.biW();
        }
    };
    private OnMenuItemClickListener qrR = new OnMenuItemClickListener(this) {
        final /* synthetic */ SnsUserUI qKo;

        {
            this.qKo = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.qKo.finish();
            return true;
        }
    };
    private boolean qrf = false;
    private String qrl;
    private boolean qrm;
    private boolean qrn;
    private int qro;

    class a extends f {
        final /* synthetic */ SnsUserUI qKo;
        private az qrW = null;

        a(SnsUserUI snsUserUI) {
            this.qKo = snsUserUI;
        }

        public void dc(int i, int i2) {
            w.d("MicroMsg.SnsUserUI", "showImg snsinfo snslocalId " + i);
            if (this.qKo.qrn && i2 == -1) {
                this.qrW = new az(this.qKo);
                this.qrW.qJf = new n.c(this) {
                    final /* synthetic */ a qKp;

                    {
                        this.qKp = r1;
                    }

                    public final void a(l lVar) {
                        lVar.e(0, this.qKp.qKo.getString(j.dHa));
                        lVar.e(1, this.qKp.qKo.getString(j.dHe));
                    }
                };
                this.qrW.c(0, this.qKo.uSU.uTo.getString(j.pJE));
                this.qrW.qJg = new d(this) {
                    final /* synthetic */ a qKp;

                    {
                        this.qKp = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                g.oUh.i(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                                this.qKp.qKo.blk();
                                return;
                            case 1:
                                g.oUh.i(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
                                this.qKp.qKo.qKk.ui(1);
                                return;
                            default:
                                return;
                        }
                    }
                };
                this.qrW.blb();
                return;
            }
            Intent intent = new Intent(this.qKo, SnsGalleryUI.class);
            intent.putExtra("sns_gallery_userName", this.qKo.jia);
            intent.putExtra("sns_gallery_is_self", this.qKo.qrn);
            intent.putExtra("sns_gallery_localId", i);
            intent.putExtra("sns_source", this.qKo.qro);
            intent.putExtra("sns_gallery_st_time", this.qKo.qKj.qEX);
            intent.putExtra("sns_gallery_ed_time", this.qKo.qKj.qEY);
            if (this.qKo.qKj != null) {
                intent.putExtra("sns_gallery_limit_seq", this.qKo.qKj.lri);
                this.qKo.qKl.f(this.qKo.jia, this.qKo.qKj.db(i, i2));
                intent.putExtra("sns_gallery_position", this.qKo.qKj.qFb);
            }
            this.qKo.startActivityForResult(intent, 8);
        }

        public final void dd(int i, int i2) {
            m tH = ae.beL().tH(i);
            if (tH != null) {
                if (tH.field_type == 15) {
                    Intent intent = new Intent(this.qKo, SnsGalleryUI.class);
                    intent.putExtra("sns_gallery_userName", this.qKo.jia);
                    intent.putExtra("sns_gallery_is_self", this.qKo.qrn);
                    intent.putExtra("sns_gallery_localId", i);
                    intent.putExtra("sns_source", this.qKo.qro);
                    intent.putExtra("sns_gallery_st_time", this.qKo.qKj.qEX);
                    intent.putExtra("sns_gallery_ed_time", this.qKo.qKj.qEY);
                    if (this.qKo.qKj != null) {
                        intent.putExtra("sns_gallery_limit_seq", this.qKo.qKj.lri);
                        this.qKo.qKl.f(this.qKo.jia, this.qKo.qKj.db(i, i2));
                        intent.putExtra("sns_gallery_position", this.qKo.qKj.qFb);
                    }
                    this.qKo.startActivityForResult(intent, 8);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.setClass(this.qKo, SnsCommentDetailUI.class);
                intent2.putExtra("INTENT_TALKER", tH.field_userName);
                intent2.putExtra("INTENT_SNS_LOCAL_ID", u.T("sns_table_", (long) i));
                this.qKo.startActivityForResult(intent2, 12);
            }
        }

        public final void ub(int i) {
            m tH = ae.beL().tH(i);
            if (tH != null) {
                Intent intent = new Intent();
                intent.setClass(this.qKo, SnsCommentDetailUI.class);
                intent.putExtra("INTENT_TALKER", tH.field_userName);
                intent.putExtra("INTENT_SNS_LOCAL_ID", u.T("sns_table_", (long) i));
                this.qKo.startActivityForResult(intent, 12);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        af Rc;
        if (this.uSU != null) {
            this.uSU.ag(2, false);
        }
        super.onCreate(bundle);
        this.qKl = ae.beB();
        this.qro = getIntent().getIntExtra("sns_source", 0);
        this.jia = getIntent().getStringExtra("sns_userName");
        if (this.jia == null) {
            this.jia = "";
        }
        h.vJ();
        this.qrm = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().QY(this.jia);
        this.qrl = com.tencent.mm.u.m.xL();
        this.qrn = this.qrl.equals(this.jia);
        ar bez = ae.bez();
        String ap = bg.ap(getIntent().getStringExtra("sns_signature"), "");
        String ap2 = bg.ap(getIntent().getStringExtra("sns_nickName"), "");
        if (this.jia == null || this.jia.equals("")) {
            Rc = bez.Rc(this.qrl);
        } else {
            Rc = bez.Rc(this.jia);
        }
        if (Rc != null && ((int) Rc.gTQ) > 0) {
            ap = Rc.signature;
            ap2 = Rc.tK();
            w.i("MicroMsg.SnsUserUI", "contact:user[%s] id[%d] nickname[%s]", new Object[]{Rc.field_username, Integer.valueOf((int) Rc.gTQ), ap2});
        }
        this.qKk = new ba(this);
        this.qKk.a(this.qrl, this.jia, ap2, ap, this.qrm, this.qrn, this.qro);
        ba baVar = this.qKk;
        com.tencent.mm.plugin.sns.ui.ba.a anonymousClass4 = new com.tencent.mm.plugin.sns.ui.ba.a(this) {
            final /* synthetic */ SnsUserUI qKo;

            {
                this.qKo = r1;
            }

            public final void biA() {
                if (this.qKo.qKl == null) {
                    this.qKo.qKl = ae.beB();
                }
                this.qKo.qKl.b(2, this.qKo.jia, this.qKo.qrn, this.qKo.qro);
                ae.ayz().postDelayed(this.qKo.qKn, 3000);
            }

            public final ListView biB() {
                return (ListView) this.qKo.findViewById(f.pFz);
            }

            public final MMPullDownView biC() {
                return (MMPullDownView) this.qKo.findViewById(f.pFG);
            }

            public final int getType() {
                return 2;
            }

            public final void a(int i, List<Integer> list, List<Integer> list2) {
                as a;
                if (!(i == -1 || this.qKo.qKj == null)) {
                    a = this.qKo.qKj;
                    if (a.qEV != null) {
                        at atVar = a.qEV;
                        m tH = ae.beL().tH(i);
                        if (!(tH == null || tH.bhd().ufB == null || atVar.fRK.size() <= 0)) {
                            atVar.fRK.add(1, tH);
                            atVar.bkK();
                            atVar.bkL();
                        }
                    }
                }
                if (this.qKo.qKj != null && list != null && list2 != null) {
                    a = this.qKo.qKj;
                    if (a.qEV != null && list != null && list2 != null && list.size() + list2.size() != 0) {
                        int i2;
                        m mVar;
                        at atVar2 = a.qEV;
                        if (!(list == null || list.size() == 0)) {
                            w.d("MicroMsg.SnsSelfHelper", "remove Items");
                            for (Integer intValue : list) {
                                int intValue2 = intValue.intValue();
                                int size = atVar2.fRK.size();
                                for (i2 = 1; i2 < size; i2++) {
                                    mVar = (m) atVar2.fRK.get(i2);
                                    if (mVar != null && mVar.qnk == intValue2) {
                                        atVar2.fRK.remove(i2);
                                        break;
                                    }
                                }
                            }
                        }
                        if (!(list2 == null || list2.size() == 0)) {
                            w.d("MicroMsg.SnsSelfHelper", "change Items");
                            LinkedList linkedList = new LinkedList();
                            i2 = 1;
                            while (i2 < atVar2.fRK.size()) {
                                mVar = (m) atVar2.fRK.get(i2);
                                if (mVar != null) {
                                    for (Integer intValue3 : list2) {
                                        int intValue4 = intValue3.intValue();
                                        if (mVar.qnk == intValue4) {
                                            w.d("MicroMsg.SnsSelfHelper", "update list localId " + intValue4);
                                            atVar2.fRK.remove(i2);
                                            linkedList.add(ae.beL().tH(intValue4));
                                            i2--;
                                            break;
                                        }
                                    }
                                }
                                i2++;
                            }
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                atVar2.fRK.add((m) it.next());
                            }
                        }
                        atVar2.bkK();
                        atVar2.bkL();
                    }
                }
            }

            public final boolean biD() {
                return false;
            }

            public final void biE() {
                this.qKo.qKl.a(2, this.qKo.jia, this.qKo.qrn, this.qKo.qro);
            }

            public final void biF() {
            }

            public final void biG() {
            }

            public final void Q(int i, boolean z) {
                Object obj = null;
                if (this.qKo.qKj != null) {
                    as a = this.qKo.qKj;
                    if (a.qEV != null) {
                        at atVar = a.qEV;
                        m tH = ae.beL().tH(i);
                        if (tH != null && tH.bhd().ufB != null && atVar.fRK.size() > 0) {
                            for (int i2 = 0; i2 < atVar.fRK.size(); i2++) {
                                if (((m) atVar.fRK.get(i2)).bhy() == tH.bhy()) {
                                    obj = 1;
                                    atVar.fRK.remove(i2);
                                    break;
                                }
                            }
                            if (obj != null) {
                                atVar.fRK.add(tH);
                                atVar.bkK();
                                atVar.bkL();
                            }
                        }
                    }
                }
            }

            public final void hF(boolean z) {
            }
        };
        this.qKm = anonymousClass4;
        baVar.qJL = anonymousClass4;
        this.qKk.onCreate();
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        KC();
        com.tencent.mm.sdk.b.a.urY.b(this.iOT);
    }

    public void onDestroy() {
        this.qrf = true;
        com.tencent.mm.sdk.b.a.urY.c(this.iOT);
        com.tencent.mm.modelsns.b o = com.tencent.mm.modelsns.b.o(getIntent());
        if (o != null) {
            o.update();
            o.JE();
        }
        if (this.qKk.irJ != null) {
            this.qKk.irJ.dismiss();
            this.qKk.irJ = null;
        }
        h.vJ();
        if (h.vG().uV() && this.qKl != null) {
            this.qKl.a(this, this.qKm.getType());
        }
        this.qKk.onDestroy();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return i.g.pHX;
    }

    public void onResume() {
        if (this.qKj != null) {
            this.qKj.notifyDataSetChanged();
        }
        bPZ();
        setRequestedOrientation(-1);
        if (this.qrn) {
            String string = getString(j.pLN);
            this.uSU.a(0, i.i.pIJ, string, new OnMenuItemClickListener(this) {
                final /* synthetic */ SnsUserUI qKo;

                {
                    this.qKo = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.setClass(this.qKo, SnsMsgUI.class);
                    intent.putExtra("sns_msg_force_show_all", true);
                    this.qKo.startActivityForResult(intent, 8);
                    return true;
                }
            }, null, com.tencent.mm.ui.l.b.uTX);
        } else {
            kr(false);
        }
        a(this.qrR, e.bbC);
        if (this.qrn) {
            zi(j.pLZ);
        } else {
            CharSequence tL;
            w.d("MicroMsg.SnsUserUI", "SnsUserUI, userName:%s, title:%s", new Object[]{this.jia, this.qKk.title});
            com.tencent.mm.j.a Rc = ae.bez().Rc(this.jia);
            if (Rc != null) {
                w.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is not null");
                tL = Rc.tL();
            } else {
                w.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is null, title:%s", new Object[]{this.qKk.title});
                tL = this.qKk.title;
            }
            qP(com.tencent.mm.plugin.sns.data.i.w(tL));
        }
        ba.onResume();
        super.onResume();
    }

    public void onPause() {
        ba.onPause();
        super.onPause();
    }

    protected final void KC() {
        this.qKj = new as(this, new a(this) {
            final /* synthetic */ SnsUserUI qKo;

            {
                this.qKo = r1;
            }

            public final void dc(int i, int i2) {
                super.dc(i, i2);
            }
        }, this.jia, new as.c(this) {
            final /* synthetic */ SnsUserUI qKo;

            {
                this.qKo = r1;
            }
        });
        this.qKk.mUX.setAdapter(this.qKj);
        this.qKk.mUX.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SnsUserUI qKo;

            {
                this.qKo = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.qKk.mUX.postDelayed(new Runnable(this) {
            final /* synthetic */ SnsUserUI qKo;

            {
                this.qKo = r1;
            }

            public final void run() {
                if (this.qKo.qrf) {
                    w.w("MicroMsg.SnsUserUI", "too fast that it finish");
                    return;
                }
                this.qKo.qKl.a(this.qKo.qKm.getType(), this.qKo.jia, this.qKo);
                if (this.qKo.qKm.getType() == 1 && this.qKo.qKm.biD()) {
                    ae.beB().w(ae.beR().pXf, -1);
                }
                if (!this.qKo.qKm.biD()) {
                    this.qKo.qKl.a(this.qKo.qKm.getType(), this.qKo.jia, this.qKo.qrn, this.qKo.qro);
                }
            }
        }, 500);
        a(this.qrR, e.bbC);
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
        if (this.qKj != null) {
            this.qKj.qxe = str;
            if (str.compareTo(this.qKj.lri) < 0) {
                w.i("MicroMsg.SnsUserUI", "onFpSetSize addsize %s %s isNeedNP %s", new Object[]{str, this.qKj.lri, Boolean.valueOf(z)});
                this.qKj.bkI();
            } else {
                w.i("MicroMsg.SnsUserUI", "onFpSetSize addsize passed %s %s isNeedNP %s", new Object[]{str, this.qKj.lri, Boolean.valueOf(z)});
            }
            this.qKj.biW();
        }
        if (!z4 || this.qrl.equals(this.jia)) {
            if (this.qrl.equals(this.jia) && j != 0) {
                h.vJ();
                h.vI().vr().a(com.tencent.mm.storage.w.a.uGa, Long.valueOf(j));
                this.qKj.dL(j);
            }
            this.qKk.qJJ = z2;
            if (z2) {
                this.qKk.hG(false);
            } else if (z) {
                this.qKl.b(this.qKm.getType(), this.jia, this.qrn, this.qro);
            }
        } else {
            this.qKk.qJJ = true;
            this.qKk.tO(i);
        }
        if (z3) {
            this.qKk.qaU.bkk();
        }
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
        ae.ayz().removeCallbacks(this.qKn);
        if (this.qKj != null) {
            this.qKj.qEU = z2;
            this.qKj.qxe = str;
            if (str.compareTo(this.qKj.lri) < 0) {
                w.i("MicroMsg.SnsUserUI", "onNpAddSize addsize %s %s", new Object[]{str, this.qKj.lri});
                this.qKj.bkI();
            } else {
                w.i("MicroMsg.SnsUserUI", "onNpAddSize addsize passed %s %s", new Object[]{str, this.qKj.lri});
            }
            this.qKj.biW();
        }
        if (!z3 || this.qrl.equals(this.jia)) {
            if (this.qrl.equals(this.jia) && j != 0) {
                h.vJ();
                h.vI().vr().a(com.tencent.mm.storage.w.a.uGa, Long.valueOf(j));
                this.qKj.dL(j);
            }
            this.qKk.qJJ = z;
            if (z) {
                this.qKk.hG(z2);
                return;
            }
            return;
        }
        this.qKk.qJJ = true;
        this.qKk.tO(i);
    }

    private void blk() {
        if (!com.tencent.mm.n.a.aH(this)) {
            w.d("MicroMsg.SnsUserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 18, "", "")), bg.bJZ(), this});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 18, "", "")) {
                w.d("MicroMsg.SnsUserUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")), bg.bJZ(), this});
                if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                    k.w(this.uSU.uTo, new Intent());
                }
            }
        }
    }

    public void onBackPressed() {
        finish();
    }

    public final boolean biv() {
        return super.biv();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.SnsUserUI", "on activity result, %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (5985 == i && i2 == -1) {
            finish();
            return;
        }
        super.onActivityResult(i, i2, intent);
        this.qKk.onActivityResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.SnsUserUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 18:
                if (iArr[0] == 0) {
                    blk();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? j.eFG : j.eFJ;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(i2), getString(j.eFM), getString(j.evw), getString(j.dGs), false, new OnClickListener(this) {
                        final /* synthetic */ SnsUserUI qKo;

                        {
                            this.qKo = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.qKo.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ SnsUserUI qKo;

                        {
                            this.qKo = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
