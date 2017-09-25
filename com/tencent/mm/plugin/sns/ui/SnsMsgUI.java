package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.aex;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.bbj;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SnsMsgUI extends MMActivity implements b, e {
    private ae handler = com.tencent.mm.plugin.sns.model.ae.ayz();
    private String hrM;
    private d jWo = new d(this) {
        final /* synthetic */ SnsMsgUI qDA;

        {
            this.qDA = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 0:
                    SnsMsgUI.a(this.qDA, this.qDA.qno);
                    return;
                case 1:
                    g.a(this.qDA, this.qDA.getString(j.pJQ), "", this.qDA.getString(j.pJP), this.qDA.getString(j.dGs), new OnClickListener(this.qDA) {
                        final /* synthetic */ SnsMsgUI qDA;

                        {
                            this.qDA = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SnsMsgUI.a(this.qDA, true);
                        }
                    }, null);
                    return;
                case 2:
                    SnsMsgUI.a(this.qDA, false);
                    return;
                default:
                    return;
            }
        }
    };
    private View jjN;
    private View koo = null;
    private boolean kop = false;
    private ListView mUX;
    private View mUZ;
    private a qDr;
    private boolean qDs = false;
    private boolean qDt = false;
    private boolean qDu = false;
    private p qDv;
    private int[] qDw = new int[2];
    private View.OnClickListener qDx = new View.OnClickListener(this) {
        final /* synthetic */ SnsMsgUI qDA;

        {
            this.qDA = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof ao) {
                this.qDA.qqd.a(view, -1, null);
            } else if (view.getTag() instanceof i) {
                SnsMsgUI.a(this.qDA, (i) view.getTag());
            } else {
                w.w("MicroMsg.SnsMsgUI", "v.getTag():" + view.getTag());
            }
        }
    };
    private com.tencent.mm.sdk.e.j.a qDy = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ SnsMsgUI qDA;

        {
            this.qDA = r1;
        }

        public final void a(String str, l lVar) {
            com.tencent.mm.plugin.sns.model.ae.ayz().post(new Runnable(this) {
                final /* synthetic */ AnonymousClass7 qDC;

                {
                    this.qDC = r1;
                }

                public final void run() {
                    synchronized (this.qDC.qDA.qDr) {
                        w.v("MicroMsg.SnsMsgUI", "comment notify");
                        this.qDC.qDA.qDt = true;
                        this.qDC.qDA.qDr.a(null, null);
                    }
                }
            });
        }
    };
    Runnable qDz = new Runnable(this) {
        final /* synthetic */ SnsMsgUI qDA;

        {
            this.qDA = r1;
        }

        public final void run() {
            if (this.qDA.qDr != null) {
                synchronized (this.qDA.qDr) {
                    this.qDA.qDr.a(null, null);
                    this.qDA.qDs = false;
                }
            }
        }
    };
    long qaP;
    int qno;
    private an qqd;
    private SnsCmdList qtQ = new SnsCmdList();
    private ar qzL;

    class a extends k<i> {
        int hOI = this.kor;
        protected f jVY;
        protected c jVZ;
        protected MMSlideDelView.d jWb = new MMSlideDelView.d(this) {
            final /* synthetic */ a qDF;

            {
                this.qDF = r1;
            }

            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                if (z) {
                    mVd.add(mMSlideDelView);
                } else {
                    mVd.remove(mMSlideDelView);
                }
            }

            public final boolean aFg() {
                return mVd.size() > 0;
            }

            public final void aFh() {
                for (MMSlideDelView mMSlideDelView : mVd) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.bSs();
                    }
                }
                mVd.clear();
            }

            public final void aFi() {
                for (MMSlideDelView mMSlideDelView : mVd) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.bSr();
                    }
                }
                mVd.clear();
            }
        };
        int kor = 10;
        private Set<MMSlideDelView> mVd = new HashSet();
        final /* synthetic */ SnsMsgUI qDA;
        protected MMSlideDelView.e qDE;

        class a {
            View jWi;
            TextView jWj;
            TextView lle;
            TextView ovh;
            long pQL;
            final /* synthetic */ a qDF;
            ImageView qDG;
            TextView qDH;
            ImageView qDI;
            TextView qDJ;
            MMImageView qDK;
            ImageView qDL;

            a(a aVar) {
                this.qDF = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (i) obj;
            if (obj == null) {
                obj = new i();
                w.d("MicroMsg.SnsMsgUI", "new SnsComment");
            }
            obj.b(cursor);
            return obj;
        }

        public a(SnsMsgUI snsMsgUI, Context context, i iVar) {
            this.qDA = snsMsgUI;
            super(context, iVar);
        }

        public final long getItemId(int i) {
            return ((i) getItem(i)).field_snsID;
        }

        protected final void OL() {
            aEW();
            OK();
        }

        public final void a(f fVar) {
            this.jVY = fVar;
        }

        public final void b(MMSlideDelView.e eVar) {
            this.qDE = eVar;
        }

        public final void a(c cVar) {
            this.jVZ = cVar;
        }

        public final synchronized void a(String str, l lVar) {
            super.a(str, lVar);
        }

        public final void OK() {
            if (com.tencent.mm.plugin.sns.model.ae.beP().Kr() <= 0 || this.qDA.qDt) {
                this.hOI = com.tencent.mm.plugin.sns.model.ae.beP().bhk();
                com.tencent.mm.plugin.sns.storage.j beP = com.tencent.mm.plugin.sns.model.ae.beP();
                String str = com.tencent.mm.plugin.sns.storage.j.bhi() + " where isSend = 0 order by createTime desc LIMIT " + this.kor;
                w.v("MicroMsg.SnsCommentStorage", "getCursor sql:" + str);
                setCursor(beP.hnH.a(str, null, 0));
            } else {
                setCursor(com.tencent.mm.plugin.sns.model.ae.beP().bhj());
            }
            notifyDataSetChanged();
        }

        public final boolean ahI() {
            return this.kor >= this.hOI;
        }

        public final int ahJ() {
            if (ahI()) {
                if (this.qDA.koo.getParent() != null) {
                    this.qDA.mUX.removeFooterView(this.qDA.koo);
                }
                return 0;
            }
            this.kor += 10;
            if (this.kor <= this.hOI) {
                return 10;
            }
            this.kor = this.hOI;
            return this.hOI % 10;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            String str;
            CharSequence tL;
            m dG;
            String str2;
            TextView textView;
            Object obj;
            TextView textView2;
            long j;
            Drawable a;
            String str3;
            com.tencent.mm.plugin.sns.storage.e dz;
            Object obj2;
            int i2;
            MMImageView mMImageView;
            ao aoVar;
            MMImageView mMImageView2;
            i iVar = (i) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                View view2 = (MMSlideDelView) r.eC(this.context).inflate(com.tencent.mm.plugin.sns.i.g.cVu, null);
                View inflate = r.eC(this.context).inflate(com.tencent.mm.plugin.sns.i.g.pHN, null);
                a aVar2 = new a(this);
                aVar2.qDG = (ImageView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.pFg);
                aVar2.ovh = (TextView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.pFn);
                aVar2.qDJ = (TextView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.pFh);
                aVar2.qDI = (ImageView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.pFl);
                aVar2.lle = (TextView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.pFo);
                aVar2.qDK = (MMImageView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.pFj);
                aVar2.qDH = (TextView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.pFp);
                aVar2.qDK.setOnClickListener(this.qDA.qDx);
                aVar2.jWi = view2.findViewById(com.tencent.mm.plugin.sns.i.f.cFy);
                aVar2.jWj = (TextView) view2.findViewById(com.tencent.mm.plugin.sns.i.f.cFz);
                aVar2.qDL = (ImageView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.pFI);
                view2.setView(inflate);
                view2.jVY = this.jVY;
                view2.jVZ = this.jVZ;
                view2.jWb = this.jWb;
                view2.lPM = false;
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.qDK.setTag(null);
            aVar.pQL = iVar.field_snsID;
            aVar.jWi.setTag(Integer.valueOf(iVar.qno));
            aVar.jWi.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ a qDF;

                {
                    this.qDF = r1;
                }

                public final void onClick(View view) {
                    w.v("MicroMsg.SnsMsgUI", "on delView clicked");
                    this.qDF.jWb.aFi();
                    if (this.qDF.qDE != null) {
                        this.qDF.qDE.aQ(view.getTag());
                    }
                }
            });
            String str4 = "";
            bau com_tencent_mm_protocal_c_bau = (bau) new bau().aD(iVar.field_curActionBuf);
            com.tencent.mm.j.a Rc;
            int i3;
            com.tencent.mm.plugin.sns.storage.e dz2;
            x Ra;
            aex com_tencent_mm_protocal_c_aex;
            com.tencent.mm.ui.widget.d dVar;
            aex com_tencent_mm_protocal_c_aex2;
            m mVar;
            List list;
            int i4;
            com.tencent.mm.sdk.e.c iVar2;
            try {
                str = ((bau) new bau().aD(iVar.field_refActionBuf)).tWt;
                try {
                    if (bg.mA(str) || str.equals(com.tencent.mm.plugin.sns.model.ae.ber())) {
                        str4 = "";
                        try {
                            if (bg.mA(com_tencent_mm_protocal_c_bau.tWt)) {
                                com.tencent.mm.pluginsdk.ui.a.b.a(aVar.qDG, com_tencent_mm_protocal_c_bau.tWt);
                                str = com_tencent_mm_protocal_c_bau.tWt;
                                aVar.qDG.setOnClickListener(new View.OnClickListener(this) {
                                    final /* synthetic */ a qDF;

                                    public final void onClick(View view) {
                                        Intent intent = new Intent();
                                        intent.putExtra("Contact_User", str);
                                        com.tencent.mm.plugin.sns.c.a.imv.d(intent, this.qDF.qDA);
                                    }
                                });
                            } else {
                                w.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                            }
                            Rc = this.qDA.qzL.Rc(com_tencent_mm_protocal_c_bau.tWt);
                            if (Rc == null) {
                                tL = Rc.tL();
                            } else if (bg.mA(com_tencent_mm_protocal_c_bau.ubH)) {
                                tL = com_tencent_mm_protocal_c_bau.ubH;
                            } else {
                                tL = com_tencent_mm_protocal_c_bau.tWt;
                            }
                            aVar.ovh.setText(h.b(this.qDA, tL, aVar.ovh.getTextSize()));
                            dG = com.tencent.mm.plugin.sns.model.ae.beL().dG(iVar.field_snsID);
                            if (dG == null && dG.field_type == 21) {
                                aVar.ovh.setTextColor(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.kDy));
                            } else {
                                aVar.ovh.setTextColor(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVS));
                            }
                            str2 = com_tencent_mm_protocal_c_bau.tWt;
                            textView = aVar.ovh;
                            i3 = com_tencent_mm_protocal_c_bau.tfW;
                            switch (iVar.field_type) {
                                case 1:
                                case 2:
                                    obj = null;
                                    break;
                                case 3:
                                case 5:
                                    obj = 1;
                                    break;
                                case 4:
                                    obj = null;
                                    break;
                                case 7:
                                case 8:
                                case 13:
                                case 14:
                                    obj = null;
                                    break;
                                default:
                                    obj = 1;
                                    break;
                            }
                            if (obj != null || this.qDA.hrM.equals(str2)) {
                                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                            } else {
                                Drawable a2;
                                switch (i3) {
                                    case 18:
                                        a2 = com.tencent.mm.bg.a.a(this.context, com.tencent.mm.plugin.sns.i.e.pAc);
                                        break;
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 26:
                                    case 27:
                                    case 28:
                                    case JsApiChooseImage.CTRL_INDEX /*29*/:
                                        a2 = com.tencent.mm.bg.a.a(this.context, com.tencent.mm.plugin.sns.i.e.pAe);
                                        break;
                                    case 25:
                                        a2 = com.tencent.mm.bg.a.a(this.context, com.tencent.mm.plugin.sns.i.e.pAa);
                                        break;
                                    case 30:
                                        a2 = com.tencent.mm.bg.a.a(this.context, com.tencent.mm.plugin.sns.i.e.pAb);
                                        break;
                                    default:
                                        a2 = com.tencent.mm.bg.a.a(this.context, com.tencent.mm.plugin.sns.i.e.pAd);
                                        break;
                                }
                                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, a2, null);
                            }
                            textView2 = aVar.qDJ;
                            j = iVar.field_snsID;
                            if (((iVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                                textView2.setTextColor(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                                textView2.setBackgroundDrawable(null);
                                textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                                textView2.setText("");
                                textView2.setCompoundDrawablePadding(0);
                                switch (com_tencent_mm_protocal_c_bau.jOc) {
                                    case 1:
                                    case 5:
                                        dG = com.tencent.mm.plugin.sns.model.ae.beL().dG(iVar.field_snsID);
                                        if (dG != null || dG.field_type != 7) {
                                            a = com.tencent.mm.bg.a.a(this.context, com.tencent.mm.plugin.sns.i.i.pIW);
                                            if (dG == null && dG.field_type == 21) {
                                                a.setColorFilter(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzc), Mode.SRC_ATOP);
                                            } else {
                                                a.clearColorFilter();
                                            }
                                            a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
                                            tL = new SpannableString(" ");
                                            tL.setSpan(new ImageSpan(a), 0, 1, 18);
                                            textView2.setText(tL);
                                            textView2.setContentDescription(this.qDA.uSU.uTo.getString(j.pKZ));
                                            break;
                                        }
                                        textView2.setText(this.qDA.getString(j.pLJ));
                                        break;
                                        break;
                                    case 2:
                                    case 3:
                                        str3 = com_tencent_mm_protocal_c_bau.opI;
                                        str = "";
                                        dz2 = com.tencent.mm.plugin.sns.model.ae.beN().dz(iVar.field_snsID);
                                        if (com_tencent_mm_protocal_c_bau.ubP != 1) {
                                            if (dz2 != null) {
                                                com.tencent.mm.kernel.h.vJ();
                                                Ra = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(dz2.field_userName);
                                                str = this.context.getString(j.pLS, new Object[]{Ra.tL()});
                                            }
                                        } else if (!bg.mA(str4)) {
                                            str = this.context.getString(j.pLT, new Object[]{str4});
                                        }
                                        textView2.setText(h.b(this.qDA, str + str3 + " ", textView2.getTextSize()));
                                        break;
                                    case 4:
                                        textView2.setText(this.qDA.getString(j.pMM));
                                        break;
                                    case 7:
                                        textView2.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bg.a.a(this.context, com.tencent.mm.plugin.sns.i.i.pIW), null, null, null);
                                        textView2.setContentDescription(this.qDA.uSU.uTo.getString(j.pKZ));
                                        break;
                                    case 8:
                                        str = "";
                                        str3 = com_tencent_mm_protocal_c_bau.opI;
                                        dz2 = com.tencent.mm.plugin.sns.model.ae.beN().dz(iVar.field_snsID);
                                        if (com_tencent_mm_protocal_c_bau.ubP != 1) {
                                            if (dz2 != null) {
                                                com.tencent.mm.kernel.h.vJ();
                                                Ra = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(dz2.field_userName);
                                                str = this.context.getString(j.pLS, new Object[]{Ra.tL()});
                                            }
                                        } else if (!bg.mA(str4)) {
                                            str = this.context.getString(j.pLT, new Object[]{str4});
                                        }
                                        textView2.setText(h.b(this.qDA, str + str3 + " ", textView2.getTextSize()));
                                        break;
                                    case 13:
                                        com_tencent_mm_protocal_c_aex = new aex();
                                        w.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bau.ubO);
                                        try {
                                            com_tencent_mm_protocal_c_aex.aD(n.a(com_tencent_mm_protocal_c_bau.ubO));
                                            w.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_aex.fZT);
                                        } catch (Exception e) {
                                            w.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e.getMessage());
                                        }
                                        this.qDA.qzL.Rc(com_tencent_mm_protocal_c_bau.tWt);
                                        a = null;
                                        if (com_tencent_mm_protocal_c_aex.fZT != 0) {
                                            this.qDA.qDu = true;
                                            tL = new SpannableString(this.qDA.getString(j.pJM));
                                        } else {
                                            this.qDA.qDu = false;
                                            tL = new SpannableString(" " + this.qDA.getString(j.pJL, new Object[]{bg.n(((double) com_tencent_mm_protocal_c_aex.fZT) / 100.0d)}));
                                            a = this.qDA.getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.pzu);
                                        }
                                        if (a != null) {
                                            a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
                                            dVar = new com.tencent.mm.ui.widget.d(a);
                                            dVar.wuA = (int) (((((float) a.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) com.tencent.mm.bg.a.fromDPToPix(this.qDA, 2))) / 2.0f);
                                            tL.setSpan(dVar, 0, 1, 33);
                                        }
                                        textView2.setText(tL);
                                        break;
                                    case 14:
                                        com_tencent_mm_protocal_c_aex2 = new aex();
                                        w.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bau.ubO);
                                        try {
                                            com_tencent_mm_protocal_c_aex2.aD(n.a(com_tencent_mm_protocal_c_bau.ubO));
                                            w.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_aex2.fZT);
                                        } catch (Exception e2) {
                                            w.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e2.getMessage());
                                        }
                                        Rc = this.qDA.qzL.Rc(com_tencent_mm_protocal_c_bau.tWt);
                                        textView2.setText(this.qDA.getString(j.pJK, new Object[]{Rc.tL(), bg.n(((double) com_tencent_mm_protocal_c_aex2.fZT) / 100.0d)}));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            textView2.setText(j.pLP);
                            textView2.setBackgroundColor(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pyW));
                            textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                            aVar.lle.setText(ay.k(this.qDA, ((long) com_tencent_mm_protocal_c_bau.ogM) * 1000));
                            dG = null;
                            if (com_tencent_mm_protocal_c_bau.jOc != 7 || com_tencent_mm_protocal_c_bau.jOc == 8) {
                                dz = com.tencent.mm.plugin.sns.model.ae.beN().dz(iVar.field_snsID);
                                if (dz != null) {
                                    dG = dz.bhf();
                                }
                                mVar = dG;
                            } else {
                                mVar = com.tencent.mm.plugin.sns.model.ae.beL().dG(iVar.field_snsID);
                            }
                            aVar.qDK.setVisibility(8);
                            aVar.qDH.setVisibility(8);
                            aVar.qDL.setVisibility(8);
                            aVar.qDK.setImageBitmap(null);
                            com.tencent.mm.plugin.sns.model.ae.beI().cp(aVar.qDK);
                            if (mVar == null) {
                                list = mVar.bhd().ufB.tsO;
                                if (mVar.field_type != 2) {
                                    aVar.qDK.setTag(null);
                                    aVar.qDH.setVisibility(0);
                                    aVar.qDH.setText(h.b(this.qDA, mVar.bhd().ufy, aVar.qDH.getTextSize()));
                                } else {
                                    obj2 = null;
                                    if (list.size() > 0) {
                                        i2 = mVar.field_type;
                                        mMImageView = aVar.qDK;
                                        i4 = -1;
                                        switch (i2) {
                                            case 1:
                                                i4 = com.tencent.mm.plugin.sns.i.e.bbY;
                                                break;
                                            case 2:
                                                mMImageView.setImageDrawable(null);
                                                break;
                                            case 3:
                                                i4 = com.tencent.mm.plugin.sns.i.i.dtu;
                                                break;
                                            case 4:
                                                i4 = com.tencent.mm.plugin.sns.i.i.dtg;
                                                break;
                                            case 5:
                                                i4 = com.tencent.mm.plugin.sns.i.i.dtr;
                                                break;
                                            case 6:
                                                i4 = com.tencent.mm.plugin.sns.i.i.dtf;
                                                break;
                                            case 7:
                                                i4 = com.tencent.mm.plugin.sns.i.e.bbY;
                                                break;
                                            case 8:
                                                mMImageView.setImageDrawable(null);
                                                break;
                                            default:
                                                i4 = com.tencent.mm.plugin.sns.i.i.dtu;
                                                break;
                                        }
                                        com.tencent.mm.plugin.sns.model.ae.beI().b((alh) list.get(0), aVar.qDK, i4, this.qDA.hashCode(), an.uJK);
                                        if (mVar.field_type != 15) {
                                            aVar.qDL.setVisibility(0);
                                            iVar2 = new i();
                                            com.tencent.mm.plugin.sns.model.ae.beP().b(iVar.uxb, iVar2);
                                            aVar.qDK.setTag(iVar2);
                                            obj2 = 1;
                                        } else {
                                            aoVar = new ao();
                                            aoVar.fJz = mVar.bhy();
                                            aoVar.index = 0;
                                            list = new ArrayList();
                                            list.add(aVar.qDK);
                                            aoVar.qBO = list;
                                            aoVar.position = i;
                                            aVar.qDK.setTag(aoVar);
                                            i2 = 1;
                                        }
                                    }
                                    mMImageView2 = aVar.qDK;
                                    if (obj2 == null) {
                                        i2 = 0;
                                    } else {
                                        i2 = 8;
                                    }
                                    mMImageView2.setVisibility(i2);
                                }
                            } else if (!(com_tencent_mm_protocal_c_bau.jOc == 7 || com_tencent_mm_protocal_c_bau.jOc == 8 || !com.tencent.mm.plugin.sns.model.p.dk(iVar.field_snsID))) {
                                com.tencent.mm.kernel.h.vJ();
                                com.tencent.mm.kernel.h.vH().gXC.a(new com.tencent.mm.plugin.sns.model.p(iVar.field_snsID), 0);
                            }
                        } catch (Throwable e3) {
                            w.printErrStackTrace("MicroMsg.SnsMsgUI", e3, "", new Object[0]);
                        }
                        obj2 = (aVar.qDK.getVisibility() != 0 || aVar.qDL.getVisibility() == 0) ? 1 : null;
                        view.findViewById(com.tencent.mm.plugin.sns.i.f.pFm).setVisibility(obj2 == null ? 0 : 8);
                        view.findViewById(com.tencent.mm.plugin.sns.i.f.pFJ).setVisibility(iVar.field_isSilence != 1 ? 0 : 8);
                        return view;
                    }
                    com.tencent.mm.j.a Rc2 = this.qDA.qzL.Rc(str);
                    if (!(Rc2 == null || bg.mA(Rc2.tL()))) {
                        str = Rc2.tL();
                    }
                    str4 = str;
                    if (bg.mA(com_tencent_mm_protocal_c_bau.tWt)) {
                        w.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.qDG, com_tencent_mm_protocal_c_bau.tWt);
                        str = com_tencent_mm_protocal_c_bau.tWt;
                        aVar.qDG.setOnClickListener(/* anonymous class already generated */);
                    }
                    Rc = this.qDA.qzL.Rc(com_tencent_mm_protocal_c_bau.tWt);
                    if (Rc == null) {
                        tL = Rc.tL();
                    } else if (bg.mA(com_tencent_mm_protocal_c_bau.ubH)) {
                        tL = com_tencent_mm_protocal_c_bau.tWt;
                    } else {
                        tL = com_tencent_mm_protocal_c_bau.ubH;
                    }
                    aVar.ovh.setText(h.b(this.qDA, tL, aVar.ovh.getTextSize()));
                    dG = com.tencent.mm.plugin.sns.model.ae.beL().dG(iVar.field_snsID);
                    if (dG == null) {
                    }
                    aVar.ovh.setTextColor(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVS));
                    str2 = com_tencent_mm_protocal_c_bau.tWt;
                    textView = aVar.ovh;
                    i3 = com_tencent_mm_protocal_c_bau.tfW;
                    switch (iVar.field_type) {
                        case 1:
                        case 2:
                            obj = null;
                            break;
                        case 3:
                        case 5:
                            obj = 1;
                            break;
                        case 4:
                            obj = null;
                            break;
                        case 7:
                        case 8:
                        case 13:
                        case 14:
                            obj = null;
                            break;
                        default:
                            obj = 1;
                            break;
                    }
                    if (obj != null) {
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2 = aVar.qDJ;
                    j = iVar.field_snsID;
                    if ((iVar.field_commentflag & 1) <= 0) {
                    }
                    if (((iVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                        textView2.setTextColor(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                        textView2.setBackgroundDrawable(null);
                        textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        textView2.setText("");
                        textView2.setCompoundDrawablePadding(0);
                        switch (com_tencent_mm_protocal_c_bau.jOc) {
                            case 1:
                            case 5:
                                dG = com.tencent.mm.plugin.sns.model.ae.beL().dG(iVar.field_snsID);
                                if (dG != null) {
                                    break;
                                }
                                a = com.tencent.mm.bg.a.a(this.context, com.tencent.mm.plugin.sns.i.i.pIW);
                                if (dG == null) {
                                    break;
                                }
                                a.clearColorFilter();
                                a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
                                tL = new SpannableString(" ");
                                tL.setSpan(new ImageSpan(a), 0, 1, 18);
                                textView2.setText(tL);
                                textView2.setContentDescription(this.qDA.uSU.uTo.getString(j.pKZ));
                                break;
                            case 2:
                            case 3:
                                str3 = com_tencent_mm_protocal_c_bau.opI;
                                str = "";
                                dz2 = com.tencent.mm.plugin.sns.model.ae.beN().dz(iVar.field_snsID);
                                if (com_tencent_mm_protocal_c_bau.ubP != 1) {
                                    if (bg.mA(str4)) {
                                        str = this.context.getString(j.pLT, new Object[]{str4});
                                    }
                                } else if (dz2 != null) {
                                    com.tencent.mm.kernel.h.vJ();
                                    Ra = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(dz2.field_userName);
                                    str = this.context.getString(j.pLS, new Object[]{Ra.tL()});
                                }
                                textView2.setText(h.b(this.qDA, str + str3 + " ", textView2.getTextSize()));
                                break;
                            case 4:
                                textView2.setText(this.qDA.getString(j.pMM));
                                break;
                            case 7:
                                textView2.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bg.a.a(this.context, com.tencent.mm.plugin.sns.i.i.pIW), null, null, null);
                                textView2.setContentDescription(this.qDA.uSU.uTo.getString(j.pKZ));
                                break;
                            case 8:
                                str = "";
                                str3 = com_tencent_mm_protocal_c_bau.opI;
                                dz2 = com.tencent.mm.plugin.sns.model.ae.beN().dz(iVar.field_snsID);
                                if (com_tencent_mm_protocal_c_bau.ubP != 1) {
                                    if (bg.mA(str4)) {
                                        str = this.context.getString(j.pLT, new Object[]{str4});
                                    }
                                } else if (dz2 != null) {
                                    com.tencent.mm.kernel.h.vJ();
                                    Ra = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(dz2.field_userName);
                                    str = this.context.getString(j.pLS, new Object[]{Ra.tL()});
                                }
                                textView2.setText(h.b(this.qDA, str + str3 + " ", textView2.getTextSize()));
                                break;
                            case 13:
                                com_tencent_mm_protocal_c_aex = new aex();
                                w.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bau.ubO);
                                com_tencent_mm_protocal_c_aex.aD(n.a(com_tencent_mm_protocal_c_bau.ubO));
                                w.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_aex.fZT);
                                this.qDA.qzL.Rc(com_tencent_mm_protocal_c_bau.tWt);
                                a = null;
                                if (com_tencent_mm_protocal_c_aex.fZT != 0) {
                                    this.qDA.qDu = false;
                                    tL = new SpannableString(" " + this.qDA.getString(j.pJL, new Object[]{bg.n(((double) com_tencent_mm_protocal_c_aex.fZT) / 100.0d)}));
                                    a = this.qDA.getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.pzu);
                                } else {
                                    this.qDA.qDu = true;
                                    tL = new SpannableString(this.qDA.getString(j.pJM));
                                }
                                if (a != null) {
                                    a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
                                    dVar = new com.tencent.mm.ui.widget.d(a);
                                    dVar.wuA = (int) (((((float) a.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) com.tencent.mm.bg.a.fromDPToPix(this.qDA, 2))) / 2.0f);
                                    tL.setSpan(dVar, 0, 1, 33);
                                }
                                textView2.setText(tL);
                                break;
                            case 14:
                                com_tencent_mm_protocal_c_aex2 = new aex();
                                w.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bau.ubO);
                                com_tencent_mm_protocal_c_aex2.aD(n.a(com_tencent_mm_protocal_c_bau.ubO));
                                w.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_aex2.fZT);
                                Rc = this.qDA.qzL.Rc(com_tencent_mm_protocal_c_bau.tWt);
                                textView2.setText(this.qDA.getString(j.pJK, new Object[]{Rc.tL(), bg.n(((double) com_tencent_mm_protocal_c_aex2.fZT) / 100.0d)}));
                                break;
                            default:
                                break;
                        }
                    }
                    textView2.setText(j.pLP);
                    textView2.setBackgroundColor(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pyW));
                    textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    aVar.lle.setText(ay.k(this.qDA, ((long) com_tencent_mm_protocal_c_bau.ogM) * 1000));
                    dG = null;
                    if (com_tencent_mm_protocal_c_bau.jOc != 7) {
                    }
                    dz = com.tencent.mm.plugin.sns.model.ae.beN().dz(iVar.field_snsID);
                    if (dz != null) {
                        dG = dz.bhf();
                    }
                    mVar = dG;
                    aVar.qDK.setVisibility(8);
                    aVar.qDH.setVisibility(8);
                    aVar.qDL.setVisibility(8);
                    aVar.qDK.setImageBitmap(null);
                    com.tencent.mm.plugin.sns.model.ae.beI().cp(aVar.qDK);
                    if (mVar == null) {
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(new com.tencent.mm.plugin.sns.model.p(iVar.field_snsID), 0);
                    } else {
                        list = mVar.bhd().ufB.tsO;
                        if (mVar.field_type != 2) {
                            obj2 = null;
                            if (list.size() > 0) {
                                i2 = mVar.field_type;
                                mMImageView = aVar.qDK;
                                i4 = -1;
                                switch (i2) {
                                    case 1:
                                        i4 = com.tencent.mm.plugin.sns.i.e.bbY;
                                        break;
                                    case 2:
                                        mMImageView.setImageDrawable(null);
                                        break;
                                    case 3:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dtu;
                                        break;
                                    case 4:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dtg;
                                        break;
                                    case 5:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dtr;
                                        break;
                                    case 6:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dtf;
                                        break;
                                    case 7:
                                        i4 = com.tencent.mm.plugin.sns.i.e.bbY;
                                        break;
                                    case 8:
                                        mMImageView.setImageDrawable(null);
                                        break;
                                    default:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dtu;
                                        break;
                                }
                                com.tencent.mm.plugin.sns.model.ae.beI().b((alh) list.get(0), aVar.qDK, i4, this.qDA.hashCode(), an.uJK);
                                if (mVar.field_type != 15) {
                                    aoVar = new ao();
                                    aoVar.fJz = mVar.bhy();
                                    aoVar.index = 0;
                                    list = new ArrayList();
                                    list.add(aVar.qDK);
                                    aoVar.qBO = list;
                                    aoVar.position = i;
                                    aVar.qDK.setTag(aoVar);
                                    i2 = 1;
                                } else {
                                    aVar.qDL.setVisibility(0);
                                    iVar2 = new i();
                                    com.tencent.mm.plugin.sns.model.ae.beP().b(iVar.uxb, iVar2);
                                    aVar.qDK.setTag(iVar2);
                                    obj2 = 1;
                                }
                            }
                            mMImageView2 = aVar.qDK;
                            if (obj2 == null) {
                                i2 = 8;
                            } else {
                                i2 = 0;
                            }
                            mMImageView2.setVisibility(i2);
                        } else {
                            aVar.qDK.setTag(null);
                            aVar.qDH.setVisibility(0);
                            aVar.qDH.setText(h.b(this.qDA, mVar.bhd().ufy, aVar.qDH.getTextSize()));
                        }
                    }
                    if (aVar.qDK.getVisibility() != 0) {
                    }
                    if (obj2 == null) {
                    }
                    view.findViewById(com.tencent.mm.plugin.sns.i.f.pFm).setVisibility(obj2 == null ? 0 : 8);
                    if (iVar.field_isSilence != 1) {
                    }
                    view.findViewById(com.tencent.mm.plugin.sns.i.f.pFJ).setVisibility(iVar.field_isSilence != 1 ? 0 : 8);
                    return view;
                } catch (Exception e4) {
                    str4 = str;
                    if (bg.mA(com_tencent_mm_protocal_c_bau.tWt)) {
                        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.qDG, com_tencent_mm_protocal_c_bau.tWt);
                        str = com_tencent_mm_protocal_c_bau.tWt;
                        aVar.qDG.setOnClickListener(/* anonymous class already generated */);
                    } else {
                        w.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                    }
                    Rc = this.qDA.qzL.Rc(com_tencent_mm_protocal_c_bau.tWt);
                    if (Rc == null) {
                        tL = Rc.tL();
                    } else if (bg.mA(com_tencent_mm_protocal_c_bau.ubH)) {
                        tL = com_tencent_mm_protocal_c_bau.ubH;
                    } else {
                        tL = com_tencent_mm_protocal_c_bau.tWt;
                    }
                    aVar.ovh.setText(h.b(this.qDA, tL, aVar.ovh.getTextSize()));
                    dG = com.tencent.mm.plugin.sns.model.ae.beL().dG(iVar.field_snsID);
                    if (dG == null) {
                    }
                    aVar.ovh.setTextColor(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVS));
                    str2 = com_tencent_mm_protocal_c_bau.tWt;
                    textView = aVar.ovh;
                    i3 = com_tencent_mm_protocal_c_bau.tfW;
                    switch (iVar.field_type) {
                        case 1:
                        case 2:
                            obj = null;
                            break;
                        case 3:
                        case 5:
                            obj = 1;
                            break;
                        case 4:
                            obj = null;
                            break;
                        case 7:
                        case 8:
                        case 13:
                        case 14:
                            obj = null;
                            break;
                        default:
                            obj = 1;
                            break;
                    }
                    if (obj != null) {
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2 = aVar.qDJ;
                    j = iVar.field_snsID;
                    if ((iVar.field_commentflag & 1) <= 0) {
                    }
                    if (((iVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                        textView2.setTextColor(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                        textView2.setBackgroundDrawable(null);
                        textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        textView2.setText("");
                        textView2.setCompoundDrawablePadding(0);
                        switch (com_tencent_mm_protocal_c_bau.jOc) {
                            case 1:
                            case 5:
                                dG = com.tencent.mm.plugin.sns.model.ae.beL().dG(iVar.field_snsID);
                                if (dG != null) {
                                    break;
                                }
                                a = com.tencent.mm.bg.a.a(this.context, com.tencent.mm.plugin.sns.i.i.pIW);
                                if (dG == null) {
                                    break;
                                }
                                a.clearColorFilter();
                                a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
                                tL = new SpannableString(" ");
                                tL.setSpan(new ImageSpan(a), 0, 1, 18);
                                textView2.setText(tL);
                                textView2.setContentDescription(this.qDA.uSU.uTo.getString(j.pKZ));
                                break;
                            case 2:
                            case 3:
                                str3 = com_tencent_mm_protocal_c_bau.opI;
                                str = "";
                                dz2 = com.tencent.mm.plugin.sns.model.ae.beN().dz(iVar.field_snsID);
                                if (com_tencent_mm_protocal_c_bau.ubP != 1) {
                                    if (dz2 != null) {
                                        com.tencent.mm.kernel.h.vJ();
                                        Ra = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(dz2.field_userName);
                                        str = this.context.getString(j.pLS, new Object[]{Ra.tL()});
                                    }
                                } else if (bg.mA(str4)) {
                                    str = this.context.getString(j.pLT, new Object[]{str4});
                                }
                                textView2.setText(h.b(this.qDA, str + str3 + " ", textView2.getTextSize()));
                                break;
                            case 4:
                                textView2.setText(this.qDA.getString(j.pMM));
                                break;
                            case 7:
                                textView2.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bg.a.a(this.context, com.tencent.mm.plugin.sns.i.i.pIW), null, null, null);
                                textView2.setContentDescription(this.qDA.uSU.uTo.getString(j.pKZ));
                                break;
                            case 8:
                                str = "";
                                str3 = com_tencent_mm_protocal_c_bau.opI;
                                dz2 = com.tencent.mm.plugin.sns.model.ae.beN().dz(iVar.field_snsID);
                                if (com_tencent_mm_protocal_c_bau.ubP != 1) {
                                    if (dz2 != null) {
                                        com.tencent.mm.kernel.h.vJ();
                                        Ra = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(dz2.field_userName);
                                        str = this.context.getString(j.pLS, new Object[]{Ra.tL()});
                                    }
                                } else if (bg.mA(str4)) {
                                    str = this.context.getString(j.pLT, new Object[]{str4});
                                }
                                textView2.setText(h.b(this.qDA, str + str3 + " ", textView2.getTextSize()));
                                break;
                            case 13:
                                com_tencent_mm_protocal_c_aex = new aex();
                                w.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bau.ubO);
                                com_tencent_mm_protocal_c_aex.aD(n.a(com_tencent_mm_protocal_c_bau.ubO));
                                w.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_aex.fZT);
                                this.qDA.qzL.Rc(com_tencent_mm_protocal_c_bau.tWt);
                                a = null;
                                if (com_tencent_mm_protocal_c_aex.fZT != 0) {
                                    this.qDA.qDu = true;
                                    tL = new SpannableString(this.qDA.getString(j.pJM));
                                } else {
                                    this.qDA.qDu = false;
                                    tL = new SpannableString(" " + this.qDA.getString(j.pJL, new Object[]{bg.n(((double) com_tencent_mm_protocal_c_aex.fZT) / 100.0d)}));
                                    a = this.qDA.getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.pzu);
                                }
                                if (a != null) {
                                    a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
                                    dVar = new com.tencent.mm.ui.widget.d(a);
                                    dVar.wuA = (int) (((((float) a.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) com.tencent.mm.bg.a.fromDPToPix(this.qDA, 2))) / 2.0f);
                                    tL.setSpan(dVar, 0, 1, 33);
                                }
                                textView2.setText(tL);
                                break;
                            case 14:
                                com_tencent_mm_protocal_c_aex2 = new aex();
                                w.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bau.ubO);
                                com_tencent_mm_protocal_c_aex2.aD(n.a(com_tencent_mm_protocal_c_bau.ubO));
                                w.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_aex2.fZT);
                                Rc = this.qDA.qzL.Rc(com_tencent_mm_protocal_c_bau.tWt);
                                textView2.setText(this.qDA.getString(j.pJK, new Object[]{Rc.tL(), bg.n(((double) com_tencent_mm_protocal_c_aex2.fZT) / 100.0d)}));
                                break;
                            default:
                                break;
                        }
                    }
                    textView2.setText(j.pLP);
                    textView2.setBackgroundColor(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pyW));
                    textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    aVar.lle.setText(ay.k(this.qDA, ((long) com_tencent_mm_protocal_c_bau.ogM) * 1000));
                    dG = null;
                    if (com_tencent_mm_protocal_c_bau.jOc != 7) {
                    }
                    dz = com.tencent.mm.plugin.sns.model.ae.beN().dz(iVar.field_snsID);
                    if (dz != null) {
                        dG = dz.bhf();
                    }
                    mVar = dG;
                    aVar.qDK.setVisibility(8);
                    aVar.qDH.setVisibility(8);
                    aVar.qDL.setVisibility(8);
                    aVar.qDK.setImageBitmap(null);
                    com.tencent.mm.plugin.sns.model.ae.beI().cp(aVar.qDK);
                    if (mVar == null) {
                        list = mVar.bhd().ufB.tsO;
                        if (mVar.field_type != 2) {
                            aVar.qDK.setTag(null);
                            aVar.qDH.setVisibility(0);
                            aVar.qDH.setText(h.b(this.qDA, mVar.bhd().ufy, aVar.qDH.getTextSize()));
                        } else {
                            obj2 = null;
                            if (list.size() > 0) {
                                i2 = mVar.field_type;
                                mMImageView = aVar.qDK;
                                i4 = -1;
                                switch (i2) {
                                    case 1:
                                        i4 = com.tencent.mm.plugin.sns.i.e.bbY;
                                        break;
                                    case 2:
                                        mMImageView.setImageDrawable(null);
                                        break;
                                    case 3:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dtu;
                                        break;
                                    case 4:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dtg;
                                        break;
                                    case 5:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dtr;
                                        break;
                                    case 6:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dtf;
                                        break;
                                    case 7:
                                        i4 = com.tencent.mm.plugin.sns.i.e.bbY;
                                        break;
                                    case 8:
                                        mMImageView.setImageDrawable(null);
                                        break;
                                    default:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dtu;
                                        break;
                                }
                                com.tencent.mm.plugin.sns.model.ae.beI().b((alh) list.get(0), aVar.qDK, i4, this.qDA.hashCode(), an.uJK);
                                if (mVar.field_type != 15) {
                                    aVar.qDL.setVisibility(0);
                                    iVar2 = new i();
                                    com.tencent.mm.plugin.sns.model.ae.beP().b(iVar.uxb, iVar2);
                                    aVar.qDK.setTag(iVar2);
                                    obj2 = 1;
                                } else {
                                    aoVar = new ao();
                                    aoVar.fJz = mVar.bhy();
                                    aoVar.index = 0;
                                    list = new ArrayList();
                                    list.add(aVar.qDK);
                                    aoVar.qBO = list;
                                    aoVar.position = i;
                                    aVar.qDK.setTag(aoVar);
                                    i2 = 1;
                                }
                            }
                            mMImageView2 = aVar.qDK;
                            if (obj2 == null) {
                                i2 = 0;
                            } else {
                                i2 = 8;
                            }
                            mMImageView2.setVisibility(i2);
                        }
                    } else {
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vH().gXC.a(new com.tencent.mm.plugin.sns.model.p(iVar.field_snsID), 0);
                    }
                    if (aVar.qDK.getVisibility() != 0) {
                    }
                    if (obj2 == null) {
                    }
                    view.findViewById(com.tencent.mm.plugin.sns.i.f.pFm).setVisibility(obj2 == null ? 0 : 8);
                    if (iVar.field_isSilence != 1) {
                    }
                    view.findViewById(com.tencent.mm.plugin.sns.i.f.pFJ).setVisibility(iVar.field_isSilence != 1 ? 0 : 8);
                    return view;
                }
            } catch (Exception e5) {
                str = str4;
                str4 = str;
                if (bg.mA(com_tencent_mm_protocal_c_bau.tWt)) {
                    w.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                } else {
                    com.tencent.mm.pluginsdk.ui.a.b.a(aVar.qDG, com_tencent_mm_protocal_c_bau.tWt);
                    str = com_tencent_mm_protocal_c_bau.tWt;
                    aVar.qDG.setOnClickListener(/* anonymous class already generated */);
                }
                Rc = this.qDA.qzL.Rc(com_tencent_mm_protocal_c_bau.tWt);
                if (Rc == null) {
                    tL = Rc.tL();
                } else if (bg.mA(com_tencent_mm_protocal_c_bau.ubH)) {
                    tL = com_tencent_mm_protocal_c_bau.tWt;
                } else {
                    tL = com_tencent_mm_protocal_c_bau.ubH;
                }
                aVar.ovh.setText(h.b(this.qDA, tL, aVar.ovh.getTextSize()));
                dG = com.tencent.mm.plugin.sns.model.ae.beL().dG(iVar.field_snsID);
                if (dG == null) {
                }
                aVar.ovh.setTextColor(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVS));
                str2 = com_tencent_mm_protocal_c_bau.tWt;
                textView = aVar.ovh;
                i3 = com_tencent_mm_protocal_c_bau.tfW;
                switch (iVar.field_type) {
                    case 1:
                    case 2:
                        obj = null;
                        break;
                    case 3:
                    case 5:
                        obj = 1;
                        break;
                    case 4:
                        obj = null;
                        break;
                    case 7:
                    case 8:
                    case 13:
                    case 14:
                        obj = null;
                        break;
                    default:
                        obj = 1;
                        break;
                }
                if (obj != null) {
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                textView2 = aVar.qDJ;
                j = iVar.field_snsID;
                if ((iVar.field_commentflag & 1) <= 0) {
                }
                if (((iVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                    textView2.setTextColor(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                    textView2.setBackgroundDrawable(null);
                    textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2.setText("");
                    textView2.setCompoundDrawablePadding(0);
                    switch (com_tencent_mm_protocal_c_bau.jOc) {
                        case 1:
                        case 5:
                            dG = com.tencent.mm.plugin.sns.model.ae.beL().dG(iVar.field_snsID);
                            if (dG != null) {
                                break;
                            }
                            a = com.tencent.mm.bg.a.a(this.context, com.tencent.mm.plugin.sns.i.i.pIW);
                            if (dG == null) {
                                break;
                            }
                            a.clearColorFilter();
                            a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
                            tL = new SpannableString(" ");
                            tL.setSpan(new ImageSpan(a), 0, 1, 18);
                            textView2.setText(tL);
                            textView2.setContentDescription(this.qDA.uSU.uTo.getString(j.pKZ));
                            break;
                        case 2:
                        case 3:
                            str3 = com_tencent_mm_protocal_c_bau.opI;
                            str = "";
                            dz2 = com.tencent.mm.plugin.sns.model.ae.beN().dz(iVar.field_snsID);
                            if (com_tencent_mm_protocal_c_bau.ubP != 1) {
                                if (bg.mA(str4)) {
                                    str = this.context.getString(j.pLT, new Object[]{str4});
                                }
                            } else if (dz2 != null) {
                                com.tencent.mm.kernel.h.vJ();
                                Ra = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(dz2.field_userName);
                                str = this.context.getString(j.pLS, new Object[]{Ra.tL()});
                            }
                            textView2.setText(h.b(this.qDA, str + str3 + " ", textView2.getTextSize()));
                            break;
                        case 4:
                            textView2.setText(this.qDA.getString(j.pMM));
                            break;
                        case 7:
                            textView2.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bg.a.a(this.context, com.tencent.mm.plugin.sns.i.i.pIW), null, null, null);
                            textView2.setContentDescription(this.qDA.uSU.uTo.getString(j.pKZ));
                            break;
                        case 8:
                            str = "";
                            str3 = com_tencent_mm_protocal_c_bau.opI;
                            dz2 = com.tencent.mm.plugin.sns.model.ae.beN().dz(iVar.field_snsID);
                            if (com_tencent_mm_protocal_c_bau.ubP != 1) {
                                if (bg.mA(str4)) {
                                    str = this.context.getString(j.pLT, new Object[]{str4});
                                }
                            } else if (dz2 != null) {
                                com.tencent.mm.kernel.h.vJ();
                                Ra = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(dz2.field_userName);
                                str = this.context.getString(j.pLS, new Object[]{Ra.tL()});
                            }
                            textView2.setText(h.b(this.qDA, str + str3 + " ", textView2.getTextSize()));
                            break;
                        case 13:
                            com_tencent_mm_protocal_c_aex = new aex();
                            w.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bau.ubO);
                            com_tencent_mm_protocal_c_aex.aD(n.a(com_tencent_mm_protocal_c_bau.ubO));
                            w.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_aex.fZT);
                            this.qDA.qzL.Rc(com_tencent_mm_protocal_c_bau.tWt);
                            a = null;
                            if (com_tencent_mm_protocal_c_aex.fZT != 0) {
                                this.qDA.qDu = false;
                                tL = new SpannableString(" " + this.qDA.getString(j.pJL, new Object[]{bg.n(((double) com_tencent_mm_protocal_c_aex.fZT) / 100.0d)}));
                                a = this.qDA.getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.pzu);
                            } else {
                                this.qDA.qDu = true;
                                tL = new SpannableString(this.qDA.getString(j.pJM));
                            }
                            if (a != null) {
                                a.setBounds(0, 0, a.getIntrinsicWidth(), a.getIntrinsicHeight());
                                dVar = new com.tencent.mm.ui.widget.d(a);
                                dVar.wuA = (int) (((((float) a.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) com.tencent.mm.bg.a.fromDPToPix(this.qDA, 2))) / 2.0f);
                                tL.setSpan(dVar, 0, 1, 33);
                            }
                            textView2.setText(tL);
                            break;
                        case 14:
                            com_tencent_mm_protocal_c_aex2 = new aex();
                            w.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bau.ubO);
                            com_tencent_mm_protocal_c_aex2.aD(n.a(com_tencent_mm_protocal_c_bau.ubO));
                            w.i("MicroMsg.SnsMsgUI", "hbbuffer  " + com_tencent_mm_protocal_c_aex2.fZT);
                            Rc = this.qDA.qzL.Rc(com_tencent_mm_protocal_c_bau.tWt);
                            textView2.setText(this.qDA.getString(j.pJK, new Object[]{Rc.tL(), bg.n(((double) com_tencent_mm_protocal_c_aex2.fZT) / 100.0d)}));
                            break;
                        default:
                            break;
                    }
                }
                textView2.setText(j.pLP);
                textView2.setBackgroundColor(this.qDA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pyW));
                textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                aVar.lle.setText(ay.k(this.qDA, ((long) com_tencent_mm_protocal_c_bau.ogM) * 1000));
                dG = null;
                if (com_tencent_mm_protocal_c_bau.jOc != 7) {
                }
                dz = com.tencent.mm.plugin.sns.model.ae.beN().dz(iVar.field_snsID);
                if (dz != null) {
                    dG = dz.bhf();
                }
                mVar = dG;
                aVar.qDK.setVisibility(8);
                aVar.qDH.setVisibility(8);
                aVar.qDL.setVisibility(8);
                aVar.qDK.setImageBitmap(null);
                com.tencent.mm.plugin.sns.model.ae.beI().cp(aVar.qDK);
                if (mVar == null) {
                    com.tencent.mm.kernel.h.vJ();
                    com.tencent.mm.kernel.h.vH().gXC.a(new com.tencent.mm.plugin.sns.model.p(iVar.field_snsID), 0);
                } else {
                    list = mVar.bhd().ufB.tsO;
                    if (mVar.field_type != 2) {
                        obj2 = null;
                        if (list.size() > 0) {
                            i2 = mVar.field_type;
                            mMImageView = aVar.qDK;
                            i4 = -1;
                            switch (i2) {
                                case 1:
                                    i4 = com.tencent.mm.plugin.sns.i.e.bbY;
                                    break;
                                case 2:
                                    mMImageView.setImageDrawable(null);
                                    break;
                                case 3:
                                    i4 = com.tencent.mm.plugin.sns.i.i.dtu;
                                    break;
                                case 4:
                                    i4 = com.tencent.mm.plugin.sns.i.i.dtg;
                                    break;
                                case 5:
                                    i4 = com.tencent.mm.plugin.sns.i.i.dtr;
                                    break;
                                case 6:
                                    i4 = com.tencent.mm.plugin.sns.i.i.dtf;
                                    break;
                                case 7:
                                    i4 = com.tencent.mm.plugin.sns.i.e.bbY;
                                    break;
                                case 8:
                                    mMImageView.setImageDrawable(null);
                                    break;
                                default:
                                    i4 = com.tencent.mm.plugin.sns.i.i.dtu;
                                    break;
                            }
                            com.tencent.mm.plugin.sns.model.ae.beI().b((alh) list.get(0), aVar.qDK, i4, this.qDA.hashCode(), an.uJK);
                            if (mVar.field_type != 15) {
                                aoVar = new ao();
                                aoVar.fJz = mVar.bhy();
                                aoVar.index = 0;
                                list = new ArrayList();
                                list.add(aVar.qDK);
                                aoVar.qBO = list;
                                aoVar.position = i;
                                aVar.qDK.setTag(aoVar);
                                i2 = 1;
                            } else {
                                aVar.qDL.setVisibility(0);
                                iVar2 = new i();
                                com.tencent.mm.plugin.sns.model.ae.beP().b(iVar.uxb, iVar2);
                                aVar.qDK.setTag(iVar2);
                                obj2 = 1;
                            }
                        }
                        mMImageView2 = aVar.qDK;
                        if (obj2 == null) {
                            i2 = 8;
                        } else {
                            i2 = 0;
                        }
                        mMImageView2.setVisibility(i2);
                    } else {
                        aVar.qDK.setTag(null);
                        aVar.qDH.setVisibility(0);
                        aVar.qDH.setText(h.b(this.qDA, mVar.bhd().ufy, aVar.qDH.getTextSize()));
                    }
                }
                if (aVar.qDK.getVisibility() != 0) {
                }
                if (obj2 == null) {
                }
                view.findViewById(com.tencent.mm.plugin.sns.i.f.pFm).setVisibility(obj2 == null ? 0 : 8);
                if (iVar.field_isSilence != 1) {
                }
                view.findViewById(com.tencent.mm.plugin.sns.i.f.pFJ).setVisibility(iVar.field_isSilence != 1 ? 0 : 8);
                return view;
            }
        }
    }

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, int i) {
        com.tencent.mm.plugin.sns.model.ae.beP().delete((long) i);
        snsMsgUI.qDr.a(null, null);
    }

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, i iVar) {
        long j = iVar.field_snsID;
        if ((iVar.field_commentflag & 2) > 0) {
            g.h(snsMsgUI, j.pLR, j.dIO);
            return;
        }
        Intent intent = new Intent();
        if (iVar.field_type == 3 || iVar.field_type == 5) {
            intent.setClass(snsMsgUI, SnsStrangerCommentDetailUI.class);
            intent.putExtra("INTENT_TALKER", iVar.field_talker);
            try {
                intent.putExtra("INTENT_SOURCE", ((bau) new bau().aD(iVar.field_curActionBuf)).tfW);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
            }
        } else {
            intent.setClass(snsMsgUI, SnsCommentDetailUI.class);
        }
        if (iVar.field_type == 7 || iVar.field_type == 8) {
            intent.putExtra("INTENT_SNSID", u.S("ad_table_", j));
            if (com.tencent.mm.plugin.sns.model.ae.beL().Gf(u.S("ad_table_", j)) == null) {
                w.i("MicroMsg.SnsMsgUI", "id " + j + " has delete");
                return;
            }
        }
        intent.putExtra("INTENT_SNSID", u.S("sns_table_", j));
        if (iVar.field_type == 2) {
            intent.putExtra("INTENT_FROMSUI", true);
            intent.putExtra("INTENT_FROMSUI_COMMENTID", iVar.field_commentSvrID);
        } else if (iVar.field_type == 8) {
            intent.putExtra("INTENT_FROMSUI", true);
            intent.putExtra("INTENT_FROMSUI_COMMENTID", iVar.field_commentSvrID);
        }
        snsMsgUI.startActivityForResult(intent, 1);
    }

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, boolean z) {
        Object com_tencent_mm_protocal_c_bbj = new bbj();
        com_tencent_mm_protocal_c_bbj.uci = z ? 1 : 0;
        final com.tencent.mm.y.k qVar = new q(snsMsgUI.qaP, com_tencent_mm_protocal_c_bbj);
        com.tencent.mm.kernel.h.vJ();
        if (com.tencent.mm.kernel.h.vH().gXC.a(qVar, 0)) {
            if (snsMsgUI.qDv != null) {
                snsMsgUI.qDv.dismiss();
            }
            snsMsgUI.getString(j.dIO);
            snsMsgUI.qDv = g.a(snsMsgUI, snsMsgUI.getString(j.pJT), true, new OnCancelListener(snsMsgUI) {
                final /* synthetic */ SnsMsgUI qDA;

                public final void onCancel(DialogInterface dialogInterface) {
                    com.tencent.mm.kernel.h.vJ();
                    com.tencent.mm.kernel.h.vH().gXC.c(qVar);
                }
            });
            snsMsgUI.qDv.show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.a(com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, this);
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.a(683, this);
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.a(218, this);
        this.hrM = com.tencent.mm.u.m.xL();
        this.qzL = com.tencent.mm.plugin.sns.model.ae.bez();
        this.qDt = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
        if (this.qDt) {
            this.kop = true;
        }
        com.tencent.mm.plugin.sns.model.ae.beP().c(this.qDy);
        KC();
    }

    public void onDestroy() {
        w.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
        com.tencent.mm.plugin.sns.model.ae.beP().afV();
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.b(com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, this);
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.b(683, this);
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.b(218, this);
        com.tencent.mm.plugin.sns.model.ae.beP().f(this.qDy);
        this.qDr.aEW();
        com.tencent.mm.plugin.sns.model.ae.beI().Q(this);
        if (this.qDv != null) {
            this.qDv.dismiss();
            this.qDv = null;
        }
        super.onDestroy();
    }

    public void onResume() {
        com.tencent.mm.plugin.sns.model.ae.beG().a(this);
        super.onResume();
    }

    public void onPause() {
        com.tencent.mm.plugin.sns.model.ae.beG().b(this);
        super.onPause();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.pHO;
    }

    protected final void KC() {
        zi(j.pLU);
        a(0, getString(j.dGt), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsMsgUI qDA;

            {
                this.qDA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.a(this.qDA.uSU.uTo, this.qDA.getString(j.pLO), "", new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass9 qDD;

                    {
                        this.qDD = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.qDD.qDA.mUX.setVisibility(8);
                        this.qDD.qDA.mUZ.setVisibility(0);
                        com.tencent.mm.plugin.sns.model.ae.beP().hnH.eE("SnsComment", "delete from SnsComment");
                        this.qDD.qDA.kr(false);
                    }
                }, null);
                return true;
            }
        });
        this.qqd = new an(this);
        this.mUZ = findViewById(com.tencent.mm.plugin.sns.i.f.pFi);
        this.mUX = (ListView) findViewById(com.tencent.mm.plugin.sns.i.f.pFk);
        this.jjN = r.eC(this).inflate(com.tencent.mm.plugin.sns.i.g.pHM, null);
        this.koo = r.eC(this).inflate(com.tencent.mm.plugin.sns.i.g.diz, null);
        w.d("MicroMsg.SnsMsgUI", "autoLoad " + this.kop);
        if (this.kop) {
            this.mUX.addFooterView(this.koo);
        } else {
            this.mUX.addFooterView(this.jjN);
        }
        this.qDr = new a(this, this, new i());
        this.qDr.a(new c(this) {
            final /* synthetic */ SnsMsgUI qDA;

            {
                this.qDA = r1;
            }

            public final int cb(View view) {
                return this.qDA.mUX.getPositionForView(view);
            }
        });
        this.qDr.a(new f(this) {
            final /* synthetic */ SnsMsgUI qDA;

            {
                this.qDA = r1;
            }

            public final void s(View view, int i) {
                this.qDA.mUX.performItemClick(view, i, 0);
            }
        });
        this.qDr.b(new MMSlideDelView.e(this) {
            final /* synthetic */ SnsMsgUI qDA;

            {
                this.qDA = r1;
            }

            public final void aQ(Object obj) {
                if (obj == null) {
                    w.e("MicroMsg.SnsMsgUI", "onItemDel object null");
                    return;
                }
                try {
                    SnsMsgUI.a(this.qDA, bg.PY(obj.toString()));
                } catch (Throwable e) {
                    w.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
                    w.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
                }
            }
        });
        this.qDr.uSN = new com.tencent.mm.ui.k.a(this) {
            final /* synthetic */ SnsMsgUI qDA;

            {
                this.qDA = r1;
            }

            public final void OI() {
            }

            public final void OH() {
                w.v("MicroMsg.SnsMsgUI", "total count:" + this.qDA.qDr.hOI + " unread:" + com.tencent.mm.plugin.sns.model.ae.beP().Kr() + "  showcount:" + this.qDA.qDr.kor);
                if (this.qDA.qDr.getCount() == 0) {
                    this.qDA.mUX.setVisibility(8);
                    this.qDA.mUZ.setVisibility(0);
                    this.qDA.kr(false);
                } else {
                    this.qDA.mUX.setVisibility(0);
                    this.qDA.mUZ.setVisibility(8);
                    this.qDA.kr(true);
                }
                if ((this.qDA.qDr.ahI() && com.tencent.mm.plugin.sns.model.ae.beP().Kr() == 0) || com.tencent.mm.plugin.sns.model.ae.beP().Kr() == com.tencent.mm.plugin.sns.model.ae.beP().bhk()) {
                    this.qDA.jjN.setVisibility(8);
                }
            }
        };
        this.mUX.setAdapter(this.qDr);
        this.mUX.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SnsMsgUI qDA;

            {
                this.qDA = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == this.qDA.qDr.getCount()) {
                    int i2 = 1;
                    if (com.tencent.mm.plugin.sns.model.ae.beP().Kr() > 0) {
                        com.tencent.mm.plugin.sns.model.ae.beP().afV();
                    } else {
                        i2 = this.qDA.qDr.ahJ();
                    }
                    this.qDA.qDr.a(null, null);
                    if (!this.qDA.kop) {
                        if (this.qDA.jjN.getParent() != null) {
                            w.d("MicroMsg.SnsMsgUI", "remove footer");
                            this.qDA.mUX.removeFooterView(this.qDA.jjN);
                        }
                        if (this.qDA.koo.getParent() == null && r0 > 0) {
                            this.qDA.mUX.addFooterView(this.qDA.koo);
                            w.i("MicroMsg.SnsMsgUI", "add mLoadingFooterView");
                        }
                    }
                    this.qDA.kop = true;
                    this.qDA.jjN.setVisibility(8);
                    return;
                }
                SnsMsgUI.a(this.qDA, (i) this.qDA.qDr.getItem(i));
            }
        });
        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.mUX.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsMsgUI qDA;

            {
                this.qDA = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.qDA.aHf();
                        this.qDA.qDw[0] = (int) motionEvent.getRawX();
                        this.qDA.qDw[1] = (int) motionEvent.getRawY();
                        break;
                }
                return false;
            }
        });
        this.mUX.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ SnsMsgUI qDA;

            {
                this.qDA = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.qDA.mUX.getHeaderViewsCount()) {
                    w.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
                    return true;
                }
                new com.tencent.mm.ui.widget.g(this.qDA).a(view, i, j, this.qDA, this.qDA.jWo, this.qDA.qDw[0], this.qDA.qDw[1]);
                return true;
            }
        });
        this.mUX.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ SnsMsgUI qDA;

            {
                this.qDA = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (this.qDA.kop && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (com.tencent.mm.plugin.sns.model.ae.beP().Kr() > 0) {
                        com.tencent.mm.plugin.sns.model.ae.beP().afV();
                    } else {
                        this.qDA.qDr.ahJ();
                    }
                    this.qDA.qDr.a(null, null);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        if (this.qDr.getCount() == 0) {
            this.mUX.setVisibility(8);
            this.mUZ.setVisibility(0);
            kr(false);
        } else {
            this.mUX.setVisibility(0);
            this.mUZ.setVisibility(8);
            kr(true);
        }
        if ((this.qDr.ahI() && com.tencent.mm.plugin.sns.model.ae.beP().Kr() == 0) || com.tencent.mm.plugin.sns.model.ae.beP().Kr() == com.tencent.mm.plugin.sns.model.ae.beP().bhk()) {
            this.jjN.setVisibility(8);
        }
        if (this.qDr.ahI() && this.kop) {
            this.mUX.removeFooterView(this.koo);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsMsgUI qDA;

            {
                this.qDA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("sns_cmd_list", this.qDA.qtQ);
                this.qDA.setResult(-1, intent);
                this.qDA.finish();
                return true;
            }
        });
        if (this.qDr.ahI() && this.kop) {
            this.mUX.removeFooterView(this.koo);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        i iVar = (i) this.qDr.getItem(adapterContextMenuInfo.position);
        if (iVar != null) {
            this.qno = iVar.qno;
            this.qaP = iVar.field_snsID;
            try {
                bau com_tencent_mm_protocal_c_bau = (bau) new bau().aD(iVar.field_curActionBuf);
                if (com_tencent_mm_protocal_c_bau != null) {
                    String tL;
                    com.tencent.mm.j.a Rc = this.qzL.Rc(com_tencent_mm_protocal_c_bau.tWt);
                    if (Rc != null) {
                        tL = Rc.tL();
                    } else if (bg.mA(com_tencent_mm_protocal_c_bau.ubH)) {
                        tL = com_tencent_mm_protocal_c_bau.tWt;
                    } else {
                        tL = com_tencent_mm_protocal_c_bau.ubH;
                    }
                    contextMenu.setHeaderTitle(bg.mz(tL));
                    if (iVar.field_isSilence == 0) {
                        contextMenu.add(adapterContextMenuInfo.position, 1, 1, getString(j.pJP));
                    } else {
                        contextMenu.add(adapterContextMenuInfo.position, 2, 1, getString(j.pJO));
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 0, getString(j.dGB));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.SnsMsgUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            if (intent != null && intent.getBooleanExtra("result_finish", false)) {
                finish();
            } else if (intent != null) {
                this.qtQ.sO(intent.getIntExtra("sns_gallery_op_id", 0));
            }
        }
    }

    public final void ES(String str) {
        this.qDr.notifyDataSetChanged();
    }

    public final void ao(String str, boolean z) {
    }

    public final void bdD() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        w.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.qtQ);
        setResult(-1, intent);
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.sns.model.p)) {
            w.d("MicroMsg.SnsMsgUI", "onSceneEnd errtype errcode");
            if (!this.qDs) {
                this.qDs = true;
                this.handler.postDelayed(this.qDz, 500);
            } else {
                return;
            }
        }
        if (kVar.getType() == 218 && ((q) kVar).type == 12) {
            if (i == 0 && i2 == 0) {
                this.qDr.a(null, null);
                Toast.makeText(this, getString(j.pJS), 0).show();
            } else {
                Toast.makeText(this, getString(j.pJR), 0).show();
            }
            if (this.qDv != null) {
                this.qDv.dismiss();
                this.qDv = null;
            }
        }
    }

    public final void ap(String str, boolean z) {
    }
}
