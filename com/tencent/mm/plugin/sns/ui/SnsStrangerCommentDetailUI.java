package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.k;
import java.util.ArrayList;
import java.util.List;

public class SnsStrangerCommentDetailUI extends MMActivity implements b {
    private static int qGP = 4;
    private int cGa;
    private String fJL;
    private ImageView hBi;
    private TextView kmH;
    private long pQL;
    private com.tencent.mm.sdk.e.j.a qDy = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ SnsStrangerCommentDetailUI qGQ;

        {
            this.qGQ = r1;
        }

        public final void a(String str, l lVar) {
            ae.ayz().post(new Runnable(this) {
                final /* synthetic */ AnonymousClass7 qGR;

                {
                    this.qGR = r1;
                }

                public final void run() {
                    w.v("MicroMsg.SnsStrangerCommentDetailUI", "comment notify");
                    this.qGR.qGQ.qGL.a(null, null);
                    if (this.qGR.qGQ.qGN) {
                        this.qGR.qGQ.qGN = false;
                        ae.ayz().postDelayed(new Runnable(this.qGR.qGQ) {
                            final /* synthetic */ SnsStrangerCommentDetailUI qGQ;

                            {
                                this.qGQ = r1;
                            }

                            public final void run() {
                                this.qGQ.qGG.setSelection(this.qGQ.qGL.getCount() - 1);
                            }
                        }, 10);
                    }
                }
            });
        }
    };
    private ListView qGG;
    private SnsCommentFooter qGH;
    private View qGI;
    private LinearLayout qGJ;
    private List<View> qGK;
    private a qGL;
    private boolean qGM = false;
    private boolean qGN = false;
    private x qGO;
    private an qqd;
    private m qyq;
    private int qzH = -1;

    class a extends k<i> {
        private Activity fPi;
        private OnClickListener qAh = new OnClickListener(this) {
            final /* synthetic */ a qGS;

            {
                this.qGS = r1;
            }

            public final void onClick(View view) {
                String str = (String) view.getTag();
                w.d("MicroMsg.SnsStrangerCommentDetailUI", "onCommentClick:" + str);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str);
                com.tencent.mm.plugin.sns.c.a.imv.d(intent, this.qGS.fPi);
            }
        };
        final /* synthetic */ SnsStrangerCommentDetailUI qGQ;

        class a {
            ImageView ipv;
            TextView iuD;
            TextView lle;
            TextView ovh;
            TextView pbx;
            final /* synthetic */ a qGS;
            ImageView qGT;

            a(a aVar) {
                this.qGS = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (i) obj;
            if (obj == null) {
                obj = new i();
            }
            obj.b(cursor);
            return obj;
        }

        public a(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI, Activity activity) {
            this.qGQ = snsStrangerCommentDetailUI;
            super(activity, new i());
            this.fPi = activity;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                a aVar2 = new a(this);
                view = View.inflate(this.fPi, g.pIf, null);
                aVar2.ipv = (ImageView) view.findViewById(f.pEA);
                aVar2.iuD = (TextView) view.findViewById(f.pEB);
                aVar2.ovh = (TextView) view.findViewById(f.pEF);
                aVar2.pbx = (TextView) view.findViewById(f.pEG);
                aVar2.lle = (TextView) view.findViewById(f.pEH);
                aVar2.qGT = (ImageView) view.findViewById(f.pEC);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            i iVar = (i) getItem(i);
            try {
                Object obj;
                bau com_tencent_mm_protocal_c_bau = (bau) new bau().aD(iVar.field_curActionBuf);
                com.tencent.mm.pluginsdk.ui.a.b.b(aVar.ipv, com_tencent_mm_protocal_c_bau.tWt, true);
                aVar.ipv.setTag(com_tencent_mm_protocal_c_bau.tWt);
                aVar.ipv.setOnClickListener(this.qAh);
                if (com_tencent_mm_protocal_c_bau.ubH != null) {
                    obj = com_tencent_mm_protocal_c_bau.ubH;
                } else {
                    obj = ((i) this.uSL).field_talker;
                }
                aVar.ovh.setTag(com_tencent_mm_protocal_c_bau.tWt);
                CharSequence b = h.b(this.fPi, obj, aVar.ovh.getTextSize());
                b.setSpan(new com.tencent.mm.pluginsdk.ui.d.m(this, com_tencent_mm_protocal_c_bau.tWt) {
                    final /* synthetic */ a qGS;

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", view.getTag().toString());
                        com.tencent.mm.plugin.sns.c.a.imv.d(intent, this.qGS.fPi);
                    }
                }, 0, obj.length(), 33);
                aVar.ovh.setText(b, BufferType.SPANNABLE);
                aVar.ovh.setOnTouchListener(new aa());
                if (iVar.field_type == 3) {
                    aVar.iuD.setVisibility(0);
                    aVar.qGT.setVisibility(8);
                    w.v("MicroMsg.SnsStrangerCommentDetailUI", "source:" + com_tencent_mm_protocal_c_bau.tfW + "  time:" + com_tencent_mm_protocal_c_bau.ogM + " timeFormatted:" + ay.k(this.fPi, ((long) com_tencent_mm_protocal_c_bau.ogM) * 1000));
                    aVar.iuD.setText(com_tencent_mm_protocal_c_bau.opI + " ");
                    h.d(aVar.iuD, 2);
                    aVar.iuD.setVisibility(0);
                } else {
                    aVar.iuD.setVisibility(8);
                    aVar.qGT.setVisibility(0);
                }
                if (!com.tencent.mm.u.m.xL().equals(com_tencent_mm_protocal_c_bau.tWt)) {
                    aVar.pbx.setVisibility(0);
                    TextView textView = aVar.pbx;
                    switch (com_tencent_mm_protocal_c_bau.tfW) {
                        case 18:
                            textView.setText(this.qGQ.getString(j.pLb));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bg.a.a(this.fPi, e.pAc), null);
                            break;
                        case 22:
                        case 23:
                        case 24:
                        case 26:
                        case 27:
                        case 28:
                        case JsApiChooseImage.CTRL_INDEX /*29*/:
                            textView.setText(this.qGQ.getString(j.pLd));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bg.a.a(this.fPi, e.pAe), null);
                            break;
                        case 25:
                            textView.setText(this.qGQ.getString(j.pLa));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bg.a.a(this.fPi, e.pAa), null);
                            break;
                        case 30:
                            textView.setText(this.qGQ.getString(j.pLc));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bg.a.a(this.fPi, e.pAb), null);
                            break;
                        default:
                            textView.setText(this.qGQ.getString(j.pLe));
                            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bg.a.a(this.fPi, e.pAd), null);
                            break;
                    }
                }
                aVar.pbx.setVisibility(8);
                aVar.lle.setText(ay.k(this.fPi, ((long) com_tencent_mm_protocal_c_bau.ogM) * 1000));
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SnsStrangerCommentDetailUI", e, "", new Object[0]);
            }
            return view;
        }

        public final void OK() {
            com.tencent.mm.plugin.sns.storage.j beP = ae.beP();
            String l = this.qGQ.fJL;
            l = com.tencent.mm.plugin.sns.storage.j.bhi() + " where talker = " + com.tencent.mm.bj.g.dP(l) + " and  snsID = " + this.qGQ.pQL + " and ( type = 3 or type = 5" + " )";
            w.v("MicroMsg.SnsCommentStorage", "comment sql:" + l);
            setCursor(beP.hnH.a(l, null, 0));
        }

        protected final void OL() {
            OK();
        }
    }

    static /* synthetic */ void a(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI, m mVar, String str) {
        if (str != null && !str.trim().equals("")) {
            com.tencent.mm.plugin.sns.model.al.a.a(snsStrangerCommentDetailUI.fJL, 3, str, mVar, snsStrangerCommentDetailUI.cGa);
        }
    }

    static /* synthetic */ void b(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        String[] strArr = new String[1];
        if (snsStrangerCommentDetailUI.qGO == null) {
            snsStrangerCommentDetailUI.qGO = new x();
            return;
        }
        if (!com.tencent.mm.j.a.ez(snsStrangerCommentDetailUI.qGO.field_type)) {
            o.e(snsStrangerCommentDetailUI.qGO);
        }
        if (snsStrangerCommentDetailUI.qGO.tA()) {
            strArr[0] = snsStrangerCommentDetailUI.getString(j.dYT);
        } else {
            strArr[0] = snsStrangerCommentDetailUI.getString(j.dYQ);
        }
        com.tencent.mm.ui.base.g.a(snsStrangerCommentDetailUI, "", strArr, "", false, new c(snsStrangerCommentDetailUI) {
            final /* synthetic */ SnsStrangerCommentDetailUI qGQ;

            {
                this.qGQ = r1;
            }

            public final void hq(int i) {
                switch (i) {
                    case 0:
                        if (this.qGQ.qGO.tA()) {
                            o.i(this.qGQ.qGO);
                            this.qGQ.qGO.tf();
                            com.tencent.mm.plugin.sns.c.a.imw.ou();
                            return;
                        }
                        o.h(this.qGQ.qGO);
                        this.qGQ.qGO.te();
                        com.tencent.mm.plugin.sns.c.a.imw.ou();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(j.pKB);
        this.pQL = getIntent().getLongExtra("INTENT_SNSID", 0);
        this.fJL = getIntent().getStringExtra("INTENT_TALKER");
        this.qyq = ae.beL().dG(this.pQL);
        this.cGa = getIntent().getIntExtra("INTENT_SOURCE", -1);
        com.tencent.mm.kernel.h.vJ();
        this.qGO = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(this.fJL);
        if (this.qyq == null || this.fJL == null) {
            finish();
            return;
        }
        this.qqd = new an(this);
        ae.beP().c(this.qDy);
        KC();
    }

    public void onResume() {
        ae.beG().a(this);
        super.onResume();
    }

    public void onPause() {
        ae.beG().b(this);
        super.onPause();
    }

    protected void onDestroy() {
        ae.beP().f(this.qDy);
        ae.beI().Q(this);
        if (this.qGL != null) {
            this.qGL.aEW();
        }
        super.onDestroy();
    }

    protected final void KC() {
        this.qGG = (ListView) findViewById(f.pBc);
        this.qGH = (SnsCommentFooter) findViewById(f.pBY);
        this.qGI = View.inflate(this, g.pIe, null);
        this.qGJ = (LinearLayout) this.qGI.findViewById(f.pBD);
        this.hBi = (ImageView) this.qGI.findViewById(f.pAU);
        this.kmH = (TextView) this.qGI.findViewById(f.pBH);
        com.tencent.mm.pluginsdk.ui.a.b.b(this.hBi, this.qyq.field_userName, true);
        this.kmH.setText(h.b(this, ((com.tencent.mm.plugin.messenger.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.a.a.class)).eK(this.qyq.field_userName), this.kmH.getTextSize()));
        bkM();
        for (int i = 0; i < this.qGK.size(); i++) {
            ao aoVar = new ao();
            aoVar.fJz = this.qyq.bhy();
            aoVar.index = i;
            aoVar.qBO = this.qGK;
            ((View) this.qGK.get(i)).setTag(aoVar);
            ((View) this.qGK.get(i)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsStrangerCommentDetailUI qGQ;

                {
                    this.qGQ = r1;
                }

                public final void onClick(View view) {
                    if (view.getTag() instanceof ao) {
                        this.qGQ.qqd.a(view, 2, null);
                    }
                }
            });
        }
        this.qGG.addHeaderView(this.qGI);
        this.qGL = new a(this, this);
        this.qGG.post(new Runnable(this) {
            final /* synthetic */ SnsStrangerCommentDetailUI qGQ;

            {
                this.qGQ = r1;
            }

            public final void run() {
                this.qGQ.qzH = this.qGQ.qGG.getBottom();
                w.d("MicroMsg.SnsStrangerCommentDetailUI", "listOriginalBottom: " + this.qGQ.qzH);
            }
        });
        this.qGG.setAdapter(this.qGL);
        this.qGG.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ SnsStrangerCommentDetailUI qGQ;

            {
                this.qGQ = r1;
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }
        });
        SnsCommentFooter snsCommentFooter = this.qGH;
        AnonymousClass2 anonymousClass2 = new Runnable(this) {
            int qAW = -1;
            int qAX = 10;
            final /* synthetic */ SnsStrangerCommentDetailUI qGQ;

            {
                this.qGQ = r2;
            }

            public final void run() {
                if (!this.qGQ.qGM) {
                    this.qAX = 10;
                }
                this.qGQ.qGM = true;
                w.e("MicroMsg.SnsStrangerCommentDetailUI", "list.bottom:" + this.qGQ.qGG.getBottom() + " footer.top" + this.qGQ.qGG.getTop());
                int top = this.qGQ.qGH.getTop();
                int i = this.qAX;
                this.qAX = i - 1;
                if (i > 0 && (this.qAW != top || this.qGQ.qGG.getBottom() == this.qGQ.qzH)) {
                    new com.tencent.mm.sdk.platformtools.ae().postDelayed(this, 30);
                }
                this.qAW = top;
                BackwardSupportUtil.c.b(this.qGQ.qGG, this.qGQ.qGG.getCount() - 1);
            }
        };
        snsCommentFooter.bkb();
        this.qGH.bkf();
        this.qGH.bki();
        this.qGH.a(new c(this) {
            final /* synthetic */ SnsStrangerCommentDetailUI qGQ;

            {
                this.qGQ = r1;
            }

            public final void GF(String str) {
                w.v("MicroMsg.SnsStrangerCommentDetailUI", "comment send requested");
                this.qGQ.qGN = true;
                SnsStrangerCommentDetailUI.a(this.qGQ, this.qGQ.qyq, str);
            }
        });
        this.qGH.GR(getString(j.pMj) + this.fJL + getString(j.pKr));
        AnonymousClass1 anonymousClass1 = new OnClickListener(this) {
            final /* synthetic */ SnsStrangerCommentDetailUI qGQ;

            {
                this.qGQ = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.qGQ.qGG);
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsStrangerCommentDetailUI qGQ;

            {
                this.qGQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qGQ.finish();
                return true;
            }
        });
        a(0, e.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsStrangerCommentDetailUI qGQ;

            {
                this.qGQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsStrangerCommentDetailUI.b(this.qGQ);
                return true;
            }
        });
    }

    private void bkM() {
        this.qGJ.removeAllViews();
        int a = BackwardSupportUtil.b.a(this, (float) qGP);
        List list = this.qyq.bhd().ufB.tsO;
        this.qGK = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ImageView mMImageView = new MMImageView(this);
            mMImageView.setPadding(a, a, a, a);
            this.qGJ.addView(mMImageView, new LayoutParams(-2, -2));
            Bitmap ww = ae.beI().a((alh) list.get(i), mMImageView, hashCode(), an.uJM).ww();
            if (ww == null) {
                int i2;
                switch (this.qyq.field_type) {
                    case 1:
                        i2 = e.bbY;
                        break;
                    case 2:
                        mMImageView.setImageDrawable(null);
                        i2 = 0;
                        break;
                    case 3:
                        i2 = com.tencent.mm.plugin.sns.i.i.dtu;
                        break;
                    case 4:
                        i2 = com.tencent.mm.plugin.sns.i.i.dtg;
                        break;
                    case 5:
                        i2 = com.tencent.mm.plugin.sns.i.i.dtr;
                        break;
                    case 6:
                        i2 = com.tencent.mm.plugin.sns.i.i.dtf;
                        break;
                    case 7:
                        i2 = e.bbY;
                        break;
                    case 8:
                        mMImageView.setImageDrawable(null);
                        i2 = 0;
                        break;
                    default:
                        i2 = com.tencent.mm.plugin.sns.i.i.dtu;
                        break;
                }
                if (i2 != 0) {
                    mMImageView.setImageResource(i2);
                }
            } else {
                mMImageView.setImageBitmap(ww);
            }
            this.qGK.add(mMImageView);
        }
    }

    protected final int getLayoutId() {
        return g.pHs;
    }

    public final void ES(String str) {
        bkM();
    }

    public final void ao(String str, boolean z) {
    }

    public final void bdD() {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.SnsStrangerCommentDetailUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
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

    public final void ap(String str, boolean z) {
    }
}
