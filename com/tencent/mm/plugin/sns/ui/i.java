package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.StrictMode;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.bo;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.a.a.g;
import com.tencent.mm.plugin.sns.f.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.au.AnonymousClass7;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class i {
    public static List<k> qqh = new LinkedList();
    public Context context;
    String gKJ;
    ClipboardManager lMa;
    protected ListView mUX;
    public au pZQ;
    FrameLayout pZl;
    public g qpY;
    public at qpZ;
    boolean qqa;
    SnsCommentFooter qqb;
    bh qqc;
    an qqd;
    private boolean qqe = false;
    public String qqf = "";
    private boolean qqg = false;
    bg qqi;
    c qqj;
    b qqk;
    public com.tencent.mm.plugin.sns.ui.b.b qql;
    p qqm = null;
    c qqn = new c<bo>(this) {
        final /* synthetic */ i qqp;

        {
            this.qqp = r2;
            this.usg = bo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (this.qqp.qqi != null) {
                this.qqp.qqi.biz();
            }
            return false;
        }
    };
    OnLongClickListener qqo = new OnLongClickListener(this) {
        final /* synthetic */ i qqp;

        {
            this.qqp = r1;
        }

        public final boolean onLongClick(View view) {
            h.vJ();
            if (((Boolean) h.vI().vr().get(7490, Boolean.valueOf(true))).booleanValue()) {
                this.qqp.context.startActivity(new Intent().setClass(this.qqp.context, SnsLongMsgUI.class));
                h.vJ();
                h.vI().vr().set(7490, Boolean.valueOf(false));
            } else {
                Intent intent = new Intent();
                intent.setClass(this.qqp.context, SnsCommentUI.class);
                intent.putExtra("sns_comment_type", 1);
                ((MMActivity) this.qqp.context).startActivityForResult(intent, 9);
            }
            return true;
        }
    };

    public class a implements OnClickListener {
        private String gMX;
        public bba pUa;
        public com.tencent.mm.plugin.sns.ui.a.a.c qpH;
        final /* synthetic */ i qqp;
        public CharSequence qqt = "";

        public a(i iVar, bba com_tencent_mm_protocal_c_bba, String str, CharSequence charSequence, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
            this.qqp = iVar;
            this.gMX = str;
            this.pUa = com_tencent_mm_protocal_c_bba;
            this.qpH = cVar;
            this.qqt = charSequence;
        }

        public final void onClick(View view) {
            int i = 0;
            if (u.GC(this.qpH.fVJ)) {
                this.qpH.qMl = view;
                if (this.pUa == null || this.pUa.tgG == null || !this.pUa.tgG.equals(this.qqp.gKJ)) {
                    m mVar = new m();
                    m tM = this.qqp.pZQ.tM(this.qpH.position);
                    if (!tM.beu()) {
                        if (com.tencent.mm.plugin.sns.lucky.a.m.h(tM)) {
                            com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(742);
                            bbk n = ai.n(tM);
                            com.tencent.mm.modelsns.b gC = gz.kG(com.tencent.mm.plugin.sns.data.i.g(tM)).gC(tM.field_type).bp(tM.tE(32)).kG(tM.bhI()).kG(this.pUa.ubK == 0 ? this.pUa.ubN : this.pUa.ubK).kG(this.pUa.tgG).gC(n == null ? 0 : n.ucl);
                            if (n != null) {
                                i = n.uco;
                            }
                            gC.gC(i);
                            gz.JE();
                            this.qqp.a(this.qpH, tM, this.qqp.context.getString(j.pMj) + this.gMX, this.pUa);
                            return;
                        }
                        com.tencent.mm.plugin.sns.lucky.ui.a.e(this.qpH.qMr.getContext(), this.qpH.qMr.tR(0));
                        return;
                    }
                    return;
                }
                if (this.qqp.qqc.qLc) {
                    this.qqp.bil();
                    this.qqp.qqc.qLc = false;
                }
                com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(this.qqp.context);
                OnCreateContextMenuListener anonymousClass1 = new OnCreateContextMenuListener(this) {
                    final /* synthetic */ a qqu;

                    {
                        this.qqu = r1;
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 0, 0, this.qqu.qqp.context.getString(j.dGx));
                        contextMenu.add(1, 1, 0, this.qqu.qqp.context.getString(j.dGB));
                    }
                };
                d anonymousClass2 = new d(this) {
                    final /* synthetic */ a qqu;

                    {
                        this.qqu = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                this.qqu.qqp.lMa.setText(this.qqu.qqt);
                                com.tencent.mm.ui.base.g.bl(this.qqu.qqp.context, this.qqu.qqp.context.getString(j.dGy));
                                return;
                            case 1:
                                w.e("MicroMsg.BaseTimeLine", "del snsId:" + this.qqu.qpH.fVJ + " commentId:" + this.qqu.pUa);
                                final k qVar = new q(u.GA(this.qqu.qpH.fVJ), u.Gz(this.qqu.qpH.fVJ) ? 6 : 4, this.qqu.pUa);
                                h.vJ();
                                h.vH().gXC.a(qVar, 0);
                                i iVar = this.qqu.qqp;
                                Context context = this.qqu.qqp.context;
                                this.qqu.qqp.context.getString(j.dIO);
                                iVar.qqm = com.tencent.mm.ui.base.g.a(context, this.qqu.qqp.context.getString(j.pKE), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass2 qqw;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        h.vJ();
                                        h.vH().gXC.c(qVar);
                                    }
                                });
                                return;
                            default:
                                return;
                        }
                    }
                };
                int[] iArr = new int[2];
                if (view.getTag(f.cJw) instanceof int[]) {
                    iArr = (int[]) view.getTag(f.cJw);
                }
                gVar.a(view, anonymousClass1, anonymousClass2, iArr[0], iArr[1]);
            }
        }
    }

    public i(Context context, int i, String str, int i2) {
        this.context = context;
        this.gKJ = com.tencent.mm.u.m.xL();
        this.qpZ = new at();
        this.qpZ.pWR = new com.tencent.mm.plugin.sns.h.b(i, str, i2);
        this.qql = new com.tencent.mm.plugin.sns.ui.b.b(this, (Activity) context, this.qpZ) {
            final /* synthetic */ i qqp;

            public final void b(View view, int i, int i2, int i3) {
                if (i2 < 0) {
                    final int i4 = i;
                    final int i5 = i2;
                    final int i6 = i3;
                    final View view2 = view;
                    new Runnable(this) {
                        int count = 20;
                        final /* synthetic */ AnonymousClass1 qqs;

                        public final void run() {
                            this.qqs.qqp.mUX.setSelectionFromTop(i4 + this.qqs.qqp.mUX.getHeaderViewsCount(), i5 + i6);
                            this.count--;
                            w.d("MicroMsg.TimelineClickListener", "count: %s, delt: %s", new Object[]{Integer.valueOf(this.count), Integer.valueOf(Math.abs(view2.getTop() - (i5 + i6)))});
                            if (this.count <= 0 || Math.abs(view2.getTop() - (i5 + i6)) < 5) {
                                w.d("MicroMsg.TimelineClickListener", "count: %s", new Object[]{Integer.valueOf(this.count)});
                                this.qqs.qqp.pZQ.notifyDataSetChanged();
                                return;
                            }
                            new ae().postDelayed(this, 5);
                        }
                    }.run();
                }
            }

            public final void bm(Object obj) {
                this.qqp.qqd.a((View) obj, 1, this.qqp.qpZ);
            }

            public final void bin() {
                if (this.qqp.pZQ != null) {
                    this.qqp.pZQ.bkV();
                }
            }

            public final void cu(View view) {
                int i = 0;
                com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                if (this.qqp.pZQ.bkS() != null) {
                    this.qqp.pZQ.bkS().biz();
                    m mVar = new m();
                    m tM = this.qqp.pZQ.tM(cVar.position);
                    if (tM.isValid()) {
                        com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(741);
                        bbk n = ai.n(tM);
                        com.tencent.mm.modelsns.b gC = gz.kG(com.tencent.mm.plugin.sns.data.i.g(tM)).gC(tM.field_type).bp(tM.tE(32)).kG(tM.bhI()).kG(tM.field_userName).gC(n == null ? 0 : n.ucl);
                        if (n != null) {
                            i = n.uco;
                        }
                        gC.gC(i);
                        gz.JE();
                        this.qqp.a(cVar, tM, "", new bba());
                        bba com_tencent_mm_protocal_c_bba = new bba();
                    }
                }
            }

            public final void cv(View view) {
                int i = 0;
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
                    com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                    if (this.qqp.pZQ.bkS() != null) {
                        this.qqp.pZQ.bkS().biz();
                        m mVar = new m();
                        m tM = this.qqp.pZQ.tM(cVar.position);
                        if (tM.isValid()) {
                            com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(741);
                            bbk n = ai.n(tM);
                            com.tencent.mm.modelsns.b gC = gz.kG(com.tencent.mm.plugin.sns.data.i.g(tM)).gC(tM.field_type).bp(tM.tE(32)).kG(tM.bhI()).kG(tM.field_userName).gC(n == null ? 0 : n.ucl);
                            if (n != null) {
                                i = n.uco;
                            }
                            gC.gC(i);
                            gz.JE();
                            this.qqp.a(cVar, tM, new bba());
                        }
                    }
                }
            }

            public final void cw(View view) {
                if (this.qqp.pZQ != null) {
                    this.qqp.pZQ.cA(view);
                }
            }

            public final void cx(View view) {
                com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                m mVar = new m();
                mVar = com.tencent.mm.plugin.sns.model.ae.beL().Gg(cVar.fGN);
                if (!mVar.beu()) {
                    if (this.qqp.qpZ != null) {
                        this.qqp.qpZ.pWR.u(mVar);
                    }
                    if (cVar.qLQ == 0) {
                        bbk n = ai.n(mVar);
                        com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(707);
                        gz.kG(com.tencent.mm.plugin.sns.data.i.g(mVar)).gC(mVar.field_type).bp(mVar.tE(32)).kG(mVar.bhI()).kG(mVar.field_userName).gC(n.ucl).gC(n.uco);
                        gz.JE();
                        StrictMode.allowThreadDiskReads();
                        cVar.qLQ = 1;
                        mVar.field_likeFlag = cVar.qLQ;
                        com.tencent.mm.plugin.sns.storage.h.a(mVar.bhe(), mVar);
                        ((TextView) view.findViewById(f.pBB)).setText(j.pLi);
                        com.tencent.mm.plugin.sns.model.al.a.a(mVar, mVar.tE(32) ? 7 : 1, "");
                    } else {
                        cVar.qLQ = 0;
                        mVar.field_likeFlag = cVar.qLQ;
                        com.tencent.mm.plugin.sns.storage.h.a(mVar.bhe(), mVar);
                        ((TextView) view.findViewById(f.pBB)).setText(j.pLI);
                        com.tencent.mm.plugin.sns.model.al.a.Fp(mVar.bhe());
                    }
                    au auVar = this.qqp.pZQ;
                    LinearLayout linearLayout = (LinearLayout) view;
                    ImageView imageView = (ImageView) linearLayout.findViewById(f.pBz);
                    Animation scaleAnimation = new ScaleAnimation(0.9f, 1.2f, 0.9f, 1.2f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setDuration(400);
                    scaleAnimation.setStartOffset(100);
                    scaleAnimation.setRepeatCount(0);
                    imageView.clearAnimation();
                    imageView.startAnimation(scaleAnimation);
                    scaleAnimation.setAnimationListener(new AnonymousClass7(auVar, linearLayout));
                }
            }

            public final void cy(View view) {
                this.qqp.qqi.biz();
                this.qqp.qqj.ct(view);
            }

            public final void bio() {
                this.qqp.qqj.bfB();
            }
        };
        this.qql.aFp();
        com.tencent.mm.sdk.b.a.urY.b(this.qqn);
    }

    private void bik() {
        if (!this.qqe) {
            this.qqe = true;
            this.qqb.bkb();
            this.qqb.a(new c(this) {
                final /* synthetic */ i qqp;

                {
                    this.qqp = r1;
                }

                public final void GF(String str) {
                    m mVar = (m) this.qqp.qqb.getTag();
                    w.d("MicroMsg.BaseTimeLine", "onCommentSend click");
                    if (str == null || str.trim().equals("")) {
                        w.e("MicroMsg.BaseTimeLine", "onCommentSend tosendText is null or empty");
                        return;
                    }
                    bba bkh = this.qqp.qqb.bkh();
                    bbk n = ai.n(mVar);
                    int i = (bkh.ubK == 0 && bkh.ubN == 0) ? 708 : 709;
                    com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(i);
                    if (gz.opType == 708) {
                        gz.kG(com.tencent.mm.plugin.sns.data.i.g(mVar)).gC(mVar.field_type).bp(mVar.tE(32)).kG(mVar.bhI()).kG(mVar.field_userName).gC(n.ucl).gC(n.uco);
                    } else {
                        String str2;
                        com.tencent.mm.modelsns.b kG = gz.kG(com.tencent.mm.plugin.sns.data.i.g(mVar)).gC(mVar.field_type).bp(mVar.tE(32)).kG(mVar.bhI()).kG(bkh.tgG);
                        if (bkh.ubK == 0) {
                            str2 = bkh.ubN;
                        } else {
                            str2 = bkh.ubK;
                        }
                        kG.kG(str2).gC(n.ucl).gC(n.uco);
                    }
                    gz.JE();
                    if (this.qqp.qpZ != null) {
                        this.qqp.qpZ.pWR.u(mVar);
                    }
                    if (mVar.tE(32) && this.qqp.qqb.qBa == 1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    com.tencent.mm.plugin.sns.model.al.a.a(mVar, mVar.tE(32) ? 8 : 2, str, this.qqp.qqb.bkh(), i);
                    this.qqp.pZQ.C(this.qqp.qqc.qLf);
                    this.qqp.bil();
                    if (bg.mA(this.qqp.qqf)) {
                        for (k kVar : i.qqh) {
                            if (this.qqp.qqf.equals(kVar.arH)) {
                                w.d("MicroMsg.BaseTimeLine", "remove ct");
                                i.qqh.remove(kVar);
                                return;
                            }
                        }
                    }
                }
            });
            SnsCommentFooter snsCommentFooter = this.qqb;
            com.tencent.mm.ui.widget.MMEditText.a anonymousClass4 = new com.tencent.mm.ui.widget.MMEditText.a(this) {
                final /* synthetic */ i qqp;

                {
                    this.qqp = r1;
                }

                public final void aIv() {
                    if (this.qqp.qqb.getVisibility() == 0) {
                        this.qqp.qqb.setVisibility(8);
                    } else {
                        ((Activity) this.qqp.context).finish();
                    }
                }
            };
            if (snsCommentFooter.nuP != null) {
                snsCommentFooter.nuP.wvo = anonymousClass4;
            }
        }
    }

    final void bil() {
        if (this.qqe) {
            if (this.qqb.getVisibility() != 8) {
                this.qqb.setVisibility(8);
            }
            au auVar = this.pZQ;
            if (auVar.qHz != null) {
                auVar.qHz.setVisibility(8);
            }
            auVar.qHz = null;
        }
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, m mVar, bba com_tencent_mm_protocal_c_bba) {
        String str = cVar.fVJ + "@";
        this.qqf = str;
        w.d("MicroMsg.BaseTimeLine", "onCommentClick:  commentkey " + this.qqf + " " + cVar.fVJ + " position:" + cVar.position);
        bik();
        h.vJ();
        String tL = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(mVar.field_userName).tL();
        this.qqb.setTag(mVar);
        this.qqb.setVisibility(0);
        this.qqb.b(tL, com_tencent_mm_protocal_c_bba);
        this.qqb.h(qqh, str);
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.context, 8);
        if (cVar.qMl != null) {
            fromDPToPix += cVar.qMn.getHeight() - cVar.qMl.getBottom();
            w.i("MicroMsg.BaseTimeLine", "comment item bottom = " + cVar.qMl.getBottom());
        } else {
            fromDPToPix = 0;
        }
        this.qqc.position = cVar.position;
        this.qqc.qKZ = cVar.mil.getHeight() - fromDPToPix;
        cVar.qMl = null;
        this.qqc.qLa = cVar.mil.getTop();
        this.qqc.qzH = this.mUX.getBottom();
        w.e("MicroMsg.BaseTimeLine", "originalTop:" + this.qqc.qLa);
        bim();
    }

    private void bim() {
        if (!(this.context instanceof MMActivity) || ((MMActivity) this.context).uSU.uTG == 1) {
            this.qqc.blo();
        } else {
            this.qqa = true;
        }
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, m mVar, String str, bba com_tencent_mm_protocal_c_bba) {
        int i = 0;
        String str2 = cVar.fVJ + str;
        this.qqf = str2;
        w.d("MicroMsg.BaseTimeLine", "onCommentClick:  commentkey " + this.qqf + " " + cVar.fVJ + " position:" + cVar.position);
        bik();
        this.qqb.setTag(mVar);
        this.qqb.setVisibility(0);
        this.qqb.a(str, com_tencent_mm_protocal_c_bba);
        this.qqb.h(qqh, str2);
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.context, 8);
        if (cVar.qMl != null) {
            i = (cVar.qMn.getHeight() - cVar.qMl.getBottom()) + fromDPToPix;
            w.i("MicroMsg.BaseTimeLine", "comment item bottom = " + cVar.qMl.getBottom());
        }
        this.qqc.position = cVar.position;
        this.qqc.qKZ = cVar.mil.getHeight() - i;
        cVar.qMl = null;
        this.qqc.qLa = cVar.mil.getTop();
        this.qqc.qzH = this.mUX.getBottom();
        w.e("MicroMsg.BaseTimeLine", "originalTop:" + this.qqc.qLa);
        bim();
    }
}
