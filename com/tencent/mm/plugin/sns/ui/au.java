package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.e.a.pk;
import com.tencent.mm.e.a.pl;
import com.tencent.mm.e.a.pm;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.a.e;
import com.tencent.mm.plugin.sns.ui.a.f;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public final class au implements x {
    public MMActivity fCi;
    protected ae handler = new ae();
    com.tencent.mm.sdk.b.c iOT;
    private ListView iuu;
    public g kaU;
    public l kmS;
    public com.tencent.mm.plugin.sns.ui.b.b pZk;
    com.tencent.mm.sdk.b.c qAc = new com.tencent.mm.sdk.b.c<pk>(this) {
        final /* synthetic */ au qHK;

        {
            this.qHK = r2;
            this.usg = pk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            pk pkVar = (pk) bVar;
            if (pkVar instanceof pk) {
                String str = pkVar.fWn.id;
                if (pkVar.fWn.type == 1) {
                    this.qHK.GY(str);
                } else if (pkVar.fWn.type == 2) {
                    this.qHK.Hb(pkVar.fWn.id);
                }
            }
            return false;
        }
    };
    com.tencent.mm.sdk.b.c qAd = new com.tencent.mm.sdk.b.c<pl>(this) {
        final /* synthetic */ au qHK;

        {
            this.qHK = r2;
            this.usg = pl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            pl plVar = (pl) bVar;
            if (plVar instanceof pl) {
                if (plVar.fWp.type == 1) {
                    this.qHK.GX(plVar.fWp.id);
                } else if (plVar.fWp.type == 2) {
                    this.qHK.Ha(plVar.fWp.id);
                }
            }
            return false;
        }
    };
    com.tencent.mm.sdk.b.c qAe = new com.tencent.mm.sdk.b.c<pm>(this) {
        final /* synthetic */ au qHK;

        {
            this.qHK = r2;
            this.usg = pm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            pm pmVar = (pm) bVar;
            if (pmVar instanceof pm) {
                String str = pmVar.fWq.id;
                if (pmVar.fWq.type == 1) {
                    this.qHK.GZ(str);
                } else if (pmVar.fWq.type == 2) {
                    this.qHK.Hc(str);
                }
            }
            return false;
        }
    };
    public int qHA = -1;
    int qHB = 0;
    protected HashMap<Integer, View> qHC = new HashMap();
    public HashMap<String, String> qHD = new HashMap();
    private HashMap<Integer, com.tencent.mm.plugin.sns.ui.a.a> qHE = new HashMap();
    private HashMap<Integer, com.tencent.mm.plugin.sns.ui.a.a.c> qHF;
    public OnClickListener qHG;
    public OnClickListener qHH;
    public HashMap<String, Boolean> qHI;
    private c qHJ;
    protected w qHv;
    public i qHw;
    protected LinkedList<SnsCommentPreloadTextView> qHx = new LinkedList();
    public HashMap<Integer, WeakReference<View>> qHy = new HashMap();
    public View qHz;
    protected HashMap<String, Integer> qqD = new HashMap();
    public OnTouchListener qtw;
    protected ScaleAnimation qzC;
    protected ScaleAnimation qzD;
    public aq qzJ;
    private int qzM = 0;
    public j qzO;
    public bf qzR;
    boolean qze = false;
    protected int requestType = 0;

    class AnonymousClass7 implements AnimationListener {
        boolean qAJ = false;
        final /* synthetic */ LinearLayout qAK;
        final /* synthetic */ au qHK;

        AnonymousClass7(au auVar, LinearLayout linearLayout) {
            this.qHK = auVar;
            this.qAK = linearLayout;
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.qAK != null) {
                this.qAK.setPressed(false);
            }
            if (!this.qAJ) {
                this.qAJ = true;
                if ((this.qHK.fCi instanceof t) && ((t) this.qHK.fCi).biz()) {
                    this.qHK.qHv.notifyDataSetChanged();
                }
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }
    }

    public interface a {
        boolean biH();
    }

    public static class b implements com.tencent.mm.u.ag.b.a {
        public int kC;
        public w qHM = null;

        public b(w wVar, int i) {
            this.qHM = wVar;
            this.kC = i;
        }

        public final void p(String str, boolean z) {
            h.vJ();
            if (h.vG().uV()) {
                com.tencent.mm.plugin.sns.model.ae.ayz().post(new Runnable(this) {
                    final /* synthetic */ b qHN;

                    {
                        this.qHN = r1;
                    }

                    public final void run() {
                        if (this.qHN.qHM.biX() != null) {
                            ((av) this.qHN.qHM.biX()).CG(this.qHN.kC);
                        }
                        this.qHN.qHM.notifyDataSetChanged();
                    }
                });
            }
        }
    }

    static class c implements OnCreateContextMenuListener {
        private String fJz;
        private alh pTY;
        private bfc qsY;
        private m qyq;
        private View targetView;
        private String url;

        c() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            Object tag = view.getTag();
            if (tag instanceof q) {
                q qVar = (q) tag;
                bfc com_tencent_mm_protocal_c_bfc = qVar.qsY;
                view.getContext();
                String str = com_tencent_mm_protocal_c_bfc.ufB.msN;
                String str2 = com_tencent_mm_protocal_c_bfc.ufA.mQY;
                str = au.He(str);
                if (str != null && str.length() != 0) {
                    this.url = str;
                    this.fJz = qVar.fGN;
                    this.targetView = view;
                    this.pTY = com_tencent_mm_protocal_c_bfc.ufB.tsO.size() > 0 ? (alh) com_tencent_mm_protocal_c_bfc.ufB.tsO.get(0) : null;
                    this.qyq = com.tencent.mm.plugin.sns.model.ae.beL().Gg(this.fJz);
                    this.qsY = com_tencent_mm_protocal_c_bfc;
                    if (com_tencent_mm_protocal_c_bfc.ufB.tsN != 10 && com_tencent_mm_protocal_c_bfc.ufB.tsN != 13) {
                        if (d.Jt("favorite")) {
                            switch (com_tencent_mm_protocal_c_bfc.ufB.tsN) {
                                case 4:
                                    contextMenu.add(0, 4, 0, view.getContext().getString(j.eGa));
                                    break;
                                case 9:
                                    contextMenu.add(0, 5, 0, view.getContext().getString(j.eGa));
                                    break;
                                case 14:
                                    contextMenu.add(0, 9, 0, view.getContext().getString(j.eGa));
                                    break;
                                default:
                                    contextMenu.add(0, 3, 0, view.getContext().getString(j.eGa));
                                    break;
                            }
                        }
                        if (this.qyq != null && !this.qyq.field_userName.equals(com.tencent.mm.plugin.sns.model.ae.ber())) {
                            contextMenu.add(0, 8, 0, view.getContext().getString(j.dYX));
                        }
                    }
                }
            }
        }
    }

    public final void bkR() {
        this.qqD.clear();
    }

    public final t bkS() {
        if (this.fCi instanceof t) {
            return (t) this.fCi;
        }
        return null;
    }

    public final SnsCommentPreloadTextView bkT() {
        if (this.qHx.size() == 0) {
            return new SnsCommentPreloadTextView(this.fCi);
        }
        return (SnsCommentPreloadTextView) this.qHx.removeFirst();
    }

    public final void a(SnsCommentPreloadTextView snsCommentPreloadTextView) {
        this.qHx.add(snsCommentPreloadTextView);
    }

    public final boolean bkU() {
        if (this.qHx != null) {
            this.qHx.clear();
        }
        if (this.qHF != null) {
            this.qHF.clear();
        }
        if (this.qHE != null) {
            this.qHE.clear();
        }
        com.tencent.mm.pluginsdk.ui.d.h.clearCache();
        com.tencent.mm.kiss.widget.textview.c.hag.vV();
        return true;
    }

    public final void notifyDataSetChanged() {
        this.qHv.notifyDataSetChanged();
    }

    public final void bkV() {
        this.qHv.biW();
    }

    public au(MMActivity mMActivity, ListView listView, com.tencent.mm.plugin.sns.ui.b.b bVar, i iVar, int i, final w wVar) {
        this.qHE.put(Integer.valueOf(6), new f());
        this.qHE.put(Integer.valueOf(2), new e());
        this.qHE.put(Integer.valueOf(3), new e());
        this.qHE.put(Integer.valueOf(4), new e());
        this.qHE.put(Integer.valueOf(5), new e());
        this.qHE.put(Integer.valueOf(0), new com.tencent.mm.plugin.sns.ui.a.c());
        this.qHE.put(Integer.valueOf(1), new com.tencent.mm.plugin.sns.ui.a.d());
        this.qHE.put(Integer.valueOf(7), new com.tencent.mm.plugin.sns.ui.a.d());
        this.qHE.put(Integer.valueOf(8), new com.tencent.mm.plugin.sns.ui.a.d());
        this.qHE.put(Integer.valueOf(9), new com.tencent.mm.plugin.sns.ui.a.g());
        this.qHE.put(Integer.valueOf(11), new com.tencent.mm.plugin.sns.ui.a.b());
        this.qHE.put(Integer.valueOf(10), new com.tencent.mm.plugin.sns.ui.a.d());
        this.qHF = new HashMap();
        this.qHF.put(Integer.valueOf(6), new com.tencent.mm.plugin.sns.ui.a.f.a());
        this.qHF.put(Integer.valueOf(2), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.qHF.put(Integer.valueOf(3), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.qHF.put(Integer.valueOf(4), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.qHF.put(Integer.valueOf(5), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.qHF.put(Integer.valueOf(0), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.qHF.put(Integer.valueOf(1), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.qHF.put(Integer.valueOf(7), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.qHF.put(Integer.valueOf(8), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.qHF.put(Integer.valueOf(9), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.qHF.put(Integer.valueOf(10), new com.tencent.mm.plugin.sns.ui.a.e.a());
        this.qHG = new OnClickListener(this) {
            final /* synthetic */ au qHK;

            {
                this.qHK = r1;
            }

            public final void onClick(View view) {
                w.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
                com.tencent.mm.plugin.sns.abtest.a.bdf();
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
                    com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                    if (cVar.qMR != null && cVar.qMR.ufB.tsN == 21) {
                        ali com_tencent_mm_protocal_c_ali = cVar.qnv;
                        if (!com.tencent.mm.u.m.xL().equals(cVar.qMR.jNj) && (com_tencent_mm_protocal_c_ali == null || com_tencent_mm_protocal_c_ali.fZG == 0)) {
                            com.tencent.mm.plugin.sns.lucky.ui.a.e(this.qHK.fCi, cVar.qMr.tR(0));
                            return;
                        }
                    }
                    if (this.qHK.fCi instanceof t) {
                        ((t) this.qHK.fCi).cz(view);
                        return;
                    }
                    return;
                }
                w.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
            }
        };
        this.qHH = new OnClickListener(this) {
            final /* synthetic */ au qHK;

            {
                this.qHK = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
                    com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                    if (cVar == null) {
                        return;
                    }
                    if (this.qHK.qqD.containsKey(cVar.fGN) && ((Integer) this.qHK.qqD.get(cVar.fGN)).equals(Integer.valueOf(1))) {
                        this.qHK.qqD.put(cVar.fGN, Integer.valueOf(2));
                        this.qHK.qHv.notifyDataSetChanged();
                        return;
                    }
                    this.qHK.qqD.put(cVar.fGN, Integer.valueOf(1));
                    if (cVar.mil.getTop() < 0) {
                        this.qHK.pZk.b(cVar.mil, cVar.position, cVar.mil.getTop(), cVar.qLU.bip());
                    } else {
                        this.qHK.qHv.notifyDataSetChanged();
                    }
                }
            }
        };
        this.qtw = bg.bJY();
        this.qHI = new HashMap();
        this.qHJ = new c();
        this.iOT = new com.tencent.mm.sdk.b.c<jc>(this) {
            final /* synthetic */ au qHK;

            {
                this.qHK = r2;
                this.usg = jc.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                jc jcVar = (jc) bVar;
                if (jcVar instanceof jc) {
                    switch (jcVar.fPc.action) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            this.qHK.qHv.notifyDataSetChanged();
                            break;
                    }
                }
                return false;
            }
        };
        this.qHv = wVar;
        this.qHw = iVar;
        w.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
        this.iuu = listView;
        com.tencent.mm.plugin.sns.model.ae.beI();
        this.fCi = mMActivity;
        this.pZk = bVar;
        this.kmS = new l(mMActivity);
        this.kaU = new g(mMActivity);
        this.qzJ = new aq(mMActivity, (byte) 0);
        this.qzC = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.qzC.setDuration(150);
        this.qzD = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.qzD.setDuration(150);
        this.qzO = new j(mMActivity, 0, iVar.qpZ);
        this.requestType = 10;
        this.qzR = new bf(mMActivity, new com.tencent.mm.plugin.sns.ui.bf.a(this) {
            final /* synthetic */ au qHK;

            public final void bjX() {
                wVar.notifyDataSetChanged();
            }
        }, 0, iVar.qpZ);
        com.tencent.mm.sdk.b.a.urY.b(this.iOT);
    }

    public final void GX(String str) {
        w.d("MicroMsg.SnsTimeLineBaseAdapter", "postDescTranslateStart, id: %s", new Object[]{str});
        m Gf = com.tencent.mm.plugin.sns.model.ae.beL().Gf(str);
        if (Gf != null) {
            String bhy = Gf.bhy();
            if (this.qqD.containsKey(bhy) && ((Integer) this.qqD.get(bhy)).equals(Integer.valueOf(1))) {
                this.qqD.put(bhy, Integer.valueOf(2));
            }
            ao.bH(str, 2);
            notifyDataSetChanged();
        }
    }

    public final void GY(String str) {
        w.d("MicroMsg.SnsTimeLineBaseAdapter", "postDescTranslateFinish, id: %s", new Object[]{str});
        ao.bH(str, 2);
        notifyDataSetChanged();
    }

    public final void GZ(String str) {
        w.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslatePostDesc, id: %s", new Object[]{str});
        ao.bI(str, 2);
        notifyDataSetChanged();
    }

    public final void Ha(String str) {
        w.d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateStart, id: %s", new Object[]{str});
        ao.bH(str, 2);
        notifyDataSetChanged();
    }

    public final void Hb(String str) {
        w.d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateFinish, id: %s", new Object[]{str});
        ao.bH(str, 2);
        notifyDataSetChanged();
    }

    public final void Hc(String str) {
        w.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslateComment, id: %s", new Object[]{str});
        ao.bI(str, 2);
        notifyDataSetChanged();
    }

    public final void bkW() {
        int firstVisiblePosition = this.iuu.getFirstVisiblePosition() - this.iuu.getHeaderViewsCount();
        int lastVisiblePosition = this.iuu.getLastVisiblePosition() - this.iuu.getHeaderViewsCount();
        w.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + firstVisiblePosition + " " + lastVisiblePosition);
        int count = this.qHv.getCount();
        int i = firstVisiblePosition;
        while (i <= lastVisiblePosition && i < count) {
            m tM = tM(i);
            View view = (View) this.qHC.get(Integer.valueOf(i));
            if (view == null || tM == null || view.getTag() == null) {
                w.e("MicroMsg.SnsTimeLineBaseAdapter", " passe " + i);
            } else {
                com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                w.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + cVar.position);
                cVar.qMU.a(cVar, i, tM);
            }
            i++;
        }
    }

    public final View g(int i, View view) {
        com.tencent.mm.plugin.sns.ui.a.a.c cVar;
        com.tencent.mm.plugin.sns.ui.a.a aVar;
        m tM = this.qHv.tM(i);
        bfc bhd = tM.bhd();
        int c = c(bhd);
        if (view == null) {
            com.tencent.mm.plugin.sns.ui.a.a cVar2;
            switch (c) {
                case 0:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.c();
                    break;
                case 1:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.d();
                    break;
                case 2:
                    cVar2 = new e();
                    break;
                case 3:
                    cVar2 = new e();
                    break;
                case 4:
                    cVar2 = new e();
                    break;
                case 5:
                    cVar2 = new e();
                    break;
                case 6:
                    cVar2 = new f();
                    break;
                case 7:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.d();
                    break;
                case 8:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.d();
                    break;
                case 9:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.g();
                    break;
                case 10:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.d();
                    break;
                case 11:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.b();
                    break;
                default:
                    cVar2 = new com.tencent.mm.plugin.sns.ui.a.d();
                    break;
            }
            com.tencent.mm.plugin.sns.ui.a.a.c aVar2 = new com.tencent.mm.plugin.sns.ui.a.e.a();
            aVar2.qMU = cVar2;
            aVar2.qMR = bhd;
            view = cVar2.a(this.fCi, aVar2, c, this, tM);
            cVar = aVar2;
            aVar = cVar2;
        } else {
            com.tencent.mm.plugin.sns.ui.a.a.c cVar3 = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
            aVar = cVar3.qMU;
            cVar = cVar3;
        }
        aVar.hO(this.qze);
        String bhe = tM.bhe();
        ArrayList arrayList = new ArrayList();
        if (ao.bfn().size() > 0) {
            for (String str : ao.bfn().keySet()) {
                if (str.startsWith(bhe)) {
                    com.tencent.mm.plugin.sns.model.ao.b bVar = (com.tencent.mm.plugin.sns.model.ao.b) ao.bfn().get(str);
                    if (ao.c(bVar)) {
                        arrayList.add(bVar);
                    }
                }
            }
        }
        aVar.qLN = arrayList;
        aVar.a(cVar, i, tM, bhd, c, this);
        if (ao.bJ(tM.bhe(), 2)) {
            com.tencent.mm.plugin.sns.model.ao.b Fq = ao.Fq(tM.bhe());
            if (tM.field_snsId == 0) {
                Fq = new com.tencent.mm.plugin.sns.model.ao.b();
            }
            if (Fq.hoD) {
                if (Fq.hrm) {
                    com.tencent.mm.plugin.sns.ui.a.a.e(cVar);
                    ao.bI(Fq.id, 2);
                } else {
                    String str2 = Fq.result;
                    String str3 = Fq.hwe;
                    if (!(cVar == null || cVar.qLX == null)) {
                        cVar.qLX.a(Fq, 1, str2, str3, Fq.pXy);
                        cVar.qLX.setVisibility(0);
                    }
                }
            } else if (!(cVar == null || cVar.qLX == null)) {
                cVar.qLX.uh(1);
                cVar.qLX.setVisibility(0);
            }
        } else {
            com.tencent.mm.plugin.sns.ui.a.a.e(cVar);
        }
        this.qHC.put(Integer.valueOf(i), view);
        return view;
    }

    public final int getItemViewType(int i) {
        return c(this.qHv.tM(i).bhd());
    }

    public final w bkX() {
        return this.qHv;
    }

    protected static int c(bfc com_tencent_mm_protocal_c_bfc) {
        if (com_tencent_mm_protocal_c_bfc.ufB.tsN == 1) {
            int size = com_tencent_mm_protocal_c_bfc.ufB.tsO.size();
            if (size <= 1) {
                return 2;
            }
            if (size <= 3) {
                return 3;
            }
            if (size <= 6) {
                return 4;
            }
            return 5;
        }
        switch (com_tencent_mm_protocal_c_bfc.ufB.tsN) {
            case 1:
            case 8:
                return 3;
            case 2:
                return 6;
            case 4:
                return 0;
            case 5:
                return 1;
            case 7:
                return 2;
            case 14:
                return 7;
            case 15:
                if (com_tencent_mm_protocal_c_bfc.ufI == 1) {
                    return 1;
                }
                return 9;
            case 21:
                return 11;
            default:
                return 1;
        }
    }

    public static String Hd(String str) {
        if (bg.mA(str)) {
            return str;
        }
        int indexOf = str.indexOf("://");
        if (indexOf != -1) {
            str = str.substring(indexOf + 3);
        }
        indexOf = str.indexOf("/");
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    protected static String d(bfc com_tencent_mm_protocal_c_bfc) {
        return com.tencent.mm.plugin.sns.c.a.imw.s(com_tencent_mm_protocal_c_bfc.ufB.msN, "timeline");
    }

    public static String a(bfc com_tencent_mm_protocal_c_bfc, Context context) {
        return com.tencent.mm.plugin.sns.c.a.imw.e(context, com_tencent_mm_protocal_c_bfc.ufA.mQY, "timeline");
    }

    public static String He(String str) {
        w.d("MicroMsg.SnsTimeLineBaseAdapter", "url:" + str);
        return com.tencent.mm.plugin.sns.c.a.imw.s(str, "timeline");
    }

    public final void C(Runnable runnable) {
        this.qHv.biW();
        runnable.run();
    }

    public final void cA(View view) {
        if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
            w.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
            if (this.qHz != null && this.qHz.getVisibility() == 0) {
                this.qHz.startAnimation(this.qzD);
                this.qzD.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ au qHK;

                    {
                        this.qHK = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        if (this.qHK.qHz != null) {
                            this.qHK.qHz.clearAnimation();
                            this.qHK.qHz.setVisibility(8);
                        }
                        this.qHK.qHz = null;
                    }
                });
            }
        }
    }

    public final m tM(int i) {
        return this.qHv.tM(i);
    }

    public final int getCount() {
        return this.qHv.getCount();
    }

    public final boolean tN(int i) {
        if (i < this.iuu.getFirstVisiblePosition() - 1 || i > this.iuu.getLastVisiblePosition() - 1) {
            return false;
        }
        return true;
    }
}
