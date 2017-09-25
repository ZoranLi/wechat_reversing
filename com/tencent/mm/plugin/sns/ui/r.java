package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;

public final class r extends LinearLayout implements u {
    private Context context;
    private boolean fJm = false;
    int fJn;
    private String fJz = "";
    private String gKJ = "";
    private int knu = 0;
    b qtt = new b(this);
    private m qtu = null;
    a qtv;
    private OnTouchListener qtw = bg.bJY();
    private boolean qtx = true;

    public interface a {
        void bid();
    }

    class b {
        ImageView ioV;
        TextView mVG;
        LinearLayout qtA;
        TextView qtB;
        LinearLayout qtC;
        LinearLayout qtD;
        ImageView qtE;
        LinearLayout qtF;
        LinearLayout qtG;
        TextView qtH;
        TextView qtI;
        TextView qtJ;
        LinearLayout qtK;
        ImageView qtL;
        ImageView qtM;
        LinearLayout qtN;
        LinearLayout qtO;
        TextView qtP;
        final /* synthetic */ r qty;

        b(r rVar) {
            this.qty = rVar;
        }
    }

    public final void setVisibility(int i) {
        boolean z = false;
        if (this.knu == 2 || this.knu == 3) {
            super.setVisibility(i);
            if (i != 8) {
                z = true;
            }
            this.qtx = z;
        } else if (this.qtu != null && !this.qtu.bhx()) {
        } else {
            if (i == 8) {
                this.qtt.qtA.setVisibility(8);
                this.qtx = false;
            } else if (i == 0) {
                this.qtt.qtA.setVisibility(0);
                this.qtx = true;
            }
        }
    }

    public r(final Context context, int i, boolean z) {
        super(context);
        this.knu = i;
        this.fJm = z;
        this.context = context;
        if (this.knu != -1) {
            this.gKJ = com.tencent.mm.u.m.xL();
            View inflate = LayoutInflater.from(context).inflate(g.pHy, this, true);
            this.qtt.qtA = (LinearLayout) inflate.findViewById(f.pGa);
            this.qtt.qtK = (LinearLayout) inflate.findViewById(f.pGr);
            this.qtt.qtD = (LinearLayout) inflate.findViewById(f.pDa);
            this.qtt.qtD.setOnTouchListener(this.qtw);
            this.qtt.qtE = (ImageView) inflate.findViewById(f.pCP);
            this.qtt.qtF = (LinearLayout) inflate.findViewById(f.pBZ);
            this.qtt.qtF.setOnTouchListener(this.qtw);
            this.qtt.qtG = (LinearLayout) inflate.findViewById(f.pCe);
            this.qtt.qtI = (TextView) inflate.findViewById(f.pEy);
            this.qtt.qtJ = (TextView) inflate.findViewById(f.pEz);
            this.qtt.qtH = (TextView) inflate.findViewById(f.pCF);
            this.qtt.qtB = (TextView) inflate.findViewById(f.pDM);
            this.qtt.qtC = (LinearLayout) inflate.findViewById(f.pDN);
            this.qtt.mVG = (TextView) inflate.findViewById(f.pEJ);
            this.qtt.mVG.setTextSize(1, (this.qtt.mVG.getTextSize() * v.dI(context)) / com.tencent.mm.bg.a.getDensity(this.qtt.mVG.getContext()));
            this.qtt.qtO = (LinearLayout) inflate.findViewById(f.pCS);
            ((LinearLayout) inflate.findViewById(f.pCS)).getBackground().setAlpha(50);
            this.qtt.ioV = (ImageView) inflate.findViewById(f.pBQ);
            this.qtt.qtL = (ImageView) inflate.findViewById(f.pDj);
            this.qtt.qtM = (ImageView) inflate.findViewById(f.pCw);
            this.qtt.qtN = (LinearLayout) inflate.findViewById(f.pCi);
            this.qtt.qtP = (TextView) inflate.findViewById(f.pCj);
            if (this.knu == 2) {
                this.qtt.qtK.setVisibility(8);
                this.qtt.qtN.setVisibility(8);
                this.qtt.qtC.setVisibility(0);
            } else if (this.knu == 3) {
                this.qtt.qtK.setVisibility(8);
                this.qtt.qtC.setVisibility(8);
                this.qtt.qtN.setVisibility(0);
            } else {
                this.qtt.qtK.setVisibility(0);
                this.qtt.qtC.setVisibility(8);
                this.qtt.qtN.setVisibility(8);
            }
            this.qtt.qtD.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ r qty;

                {
                    this.qty = r1;
                }

                public final void onClick(View view) {
                    if (this.qty.qtu != null) {
                        if (this.qty.qtu.field_likeFlag == 0) {
                            if (this.qty.qtu.bhx()) {
                                com.tencent.mm.plugin.sns.model.al.a.a(this.qty.qtu, 1, "", "", this.qty.fJn);
                            } else {
                                com.tencent.mm.plugin.sns.model.al.a.a(this.qty.qtu.field_userName, 5, "", this.qty.qtu, this.qty.fJn);
                            }
                            this.qty.qtu.field_likeFlag = 1;
                            ae.beL().z(this.qty.qtu);
                        } else {
                            this.qty.qtu.field_likeFlag = 0;
                            ae.beL().z(this.qty.qtu);
                            com.tencent.mm.plugin.sns.model.al.a.Fp(this.qty.qtu.bhe());
                            this.qty.qtu = ae.beL().dG(this.qty.qtu.field_snsId);
                        }
                        String df = this.qty.qtu.field_snsId == 0 ? "" : i.df(this.qty.qtu.field_snsId);
                        com.tencent.mm.plugin.report.service.g.oUh.i(11989, new Object[]{Integer.valueOf(1), df, Integer.valueOf(0)});
                        new com.tencent.mm.sdk.platformtools.ae().postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 qtz;

                            {
                                this.qtz = r1;
                            }

                            public final void run() {
                                this.qtz.qty.refresh();
                            }
                        }, 500);
                    }
                }
            });
            this.qtt.qtF.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ r qty;

                public final void onClick(View view) {
                    w.d("MicroMsg.GalleryFooter", "comment cmd");
                    if (this.qty.qtu != null) {
                        int i = this.qty.qtu.qnk;
                        Intent intent = new Intent();
                        intent.putExtra("sns_comment_localId", i);
                        intent.putExtra("sns_source", this.qty.fJn);
                        intent.setClass(context, SnsCommentUI.class);
                        String df = this.qty.qtu.field_snsId == 0 ? "" : i.df(this.qty.qtu.field_snsId);
                        com.tencent.mm.plugin.report.service.g.oUh.i(11989, new Object[]{Integer.valueOf(2), df, Integer.valueOf(0)});
                        context.startActivity(intent);
                    }
                }
            });
            this.qtt.qtG.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ r qty;

                public final void onClick(View view) {
                    if (this.qty.qtu != null) {
                        String df = this.qty.qtu.field_snsId == 0 ? "" : i.df(this.qty.qtu.field_snsId);
                        com.tencent.mm.plugin.report.service.g.oUh.i(11989, new Object[]{Integer.valueOf(3), df, Integer.valueOf(0)});
                        int i = this.qty.qtu.qnk;
                        Intent intent = new Intent();
                        intent.setClass(context, SnsCommentDetailUI.class);
                        intent.putExtra("INTENT_TALKER", this.qty.qtu.field_userName);
                        intent.putExtra("INTENT_SNS_LOCAL_ID", u.T("sns_table_", (long) i));
                        intent.putExtra("INTENT_FROMGALLERY", true);
                        ((MMActivity) context).startActivityForResult(intent, 1);
                    }
                }
            });
            this.qtt.qtB.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ r qty;

                {
                    this.qty = r1;
                }

                public final void onClick(View view) {
                    if (this.qty.qtv != null) {
                        this.qty.qtv.bid();
                    }
                }
            });
            this.qtt.qtP.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ r qty;

                {
                    this.qty = r1;
                }

                public final void onClick(View view) {
                }
            });
        }
    }

    public final void refresh() {
        if (this.knu != -1) {
            this.qtu = ae.beL().Gg(this.fJz);
            if (!bg.mA(this.fJz) && this.qtu != null) {
                this.qtt.qtM.setVisibility(8);
                if (ai.O(this.qtu.field_localPrivate, this.fJm)) {
                    this.qtt.qtF.setVisibility(8);
                    this.qtt.qtD.setVisibility(8);
                } else if (this.qtu.bhx()) {
                    if (this.qtx) {
                        this.qtt.qtA.setVisibility(0);
                    }
                    this.qtt.qtG.setVisibility(0);
                    this.qtt.qtF.setVisibility(0);
                    this.qtt.qtD.setVisibility(0);
                    this.qtt.qtK.setVisibility(0);
                } else {
                    this.qtt.qtO.setVisibility(0);
                    this.qtt.qtK.setVisibility(0);
                    this.qtt.qtA.setVisibility(8);
                    this.qtt.qtG.setVisibility(8);
                    this.qtt.qtF.setVisibility(8);
                    this.qtt.qtD.setVisibility(8);
                }
                bbk n = ai.n(this.qtu);
                if (n != null) {
                    if (this.qtu.bhx()) {
                        int i = n.uco;
                        if (i > 0) {
                            this.qtt.qtJ.setText(String.valueOf(i));
                            this.qtt.qtJ.setVisibility(0);
                        } else {
                            this.qtt.qtJ.setVisibility(8);
                        }
                        int i2 = n.ucl;
                        if (i2 > 0) {
                            this.qtt.qtI.setText(String.valueOf(i2));
                            this.qtt.qtI.setVisibility(0);
                        } else {
                            this.qtt.qtI.setVisibility(8);
                        }
                        w.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + i2);
                        if (this.qtu.field_likeFlag == 1) {
                            this.qtt.qtH.setText(getResources().getString(j.pLg));
                            this.qtt.qtE.setImageResource(com.tencent.mm.plugin.sns.i.i.pIS);
                        } else {
                            this.qtt.qtH.setText(getResources().getString(j.pLh));
                            this.qtt.qtE.setImageResource(com.tencent.mm.plugin.sns.i.i.pIT);
                        }
                    }
                    if (this.gKJ.equals(this.qtu.field_userName) || !this.fJm) {
                        this.qtt.ioV.setVisibility(8);
                    } else {
                        this.qtt.ioV.setVisibility(0);
                        com.tencent.mm.pluginsdk.ui.a.b.a(this.qtt.ioV, this.qtu.field_userName);
                    }
                }
                if (this.qtu.bhd() == null) {
                    this.qtt.mVG.setVisibility(8);
                    return;
                }
                String str = this.qtu.bhd().ufy;
                if (str == null || str.equals("")) {
                    this.qtt.mVG.setText("");
                    this.qtt.mVG.setVisibility(8);
                } else {
                    this.qtt.mVG.setText(h.b(getContext(), str + " ", this.qtt.mVG.getTextSize()));
                    this.qtt.mVG.setVisibility(0);
                }
                if (ai.O(this.qtu.field_localPrivate, this.fJm)) {
                    this.qtt.qtL.setVisibility(0);
                    this.qtt.mVG.setVisibility(0);
                } else {
                    this.qtt.qtL.setVisibility(8);
                }
                if (this.fJm && this.qtu.bhA()) {
                    this.qtt.qtG.setVisibility(0);
                    this.qtt.mVG.setVisibility(0);
                    this.qtt.qtM.setVisibility(0);
                }
            }
        }
    }

    public final void GJ(String str) {
        this.fJz = str;
        refresh();
    }
}
