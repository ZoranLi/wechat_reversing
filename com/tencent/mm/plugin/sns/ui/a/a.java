package com.tencent.mm.plugin.sns.ui.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.AsyncTextView;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsTranslateResultView;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.TranslateCommentTextView;
import com.tencent.mm.plugin.sns.ui.aa;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.tools.MaskImageButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a {
    public boolean DEBUG = false;
    protected int knu;
    protected au pZQ;
    public ArrayList<com.tencent.mm.plugin.sns.model.ao.b> qLN = new ArrayList();
    protected Activity qb;
    protected boolean qze = false;

    public static class c {
        public String fGN;
        public String fVJ;
        public String iHN;
        public TextView ioX;
        public ImageView ipv;
        public int knu;
        public TextView lle;
        public View mil;
        public boolean moR;
        public bbk pOp;
        public boolean pQJ;
        public be pQK;
        public TextView pSj;
        public int position;
        public TextView qFk;
        public View qFp;
        public long qLP;
        public int qLQ;
        public AsyncTextView qLR;
        public ImageView qLS;
        public ViewGroup qLT;
        public AsyncNormalTextView qLU;
        public TextView qLV;
        public TextView qLW;
        public SnsTranslateResultView qLX;
        public LinearLayout qLY;
        public ViewStub qLZ;
        public ViewStub qMA;
        public boolean qMB = false;
        public View qMC;
        public LinearLayout qMD;
        public TextView qME;
        public ViewStub qMF;
        public boolean qMG = false;
        public View qMH;
        public LinearLayout qMI;
        public ViewStub qMJ;
        public boolean qMK = false;
        public View qML;
        public ImageView qMM;
        public boolean qMN = false;
        ViewStub qMO;
        boolean qMP = false;
        public aj qMQ = new aj();
        public bfc qMR;
        public com.tencent.mm.j.a qMS;
        public View qMT;
        public a qMU;
        public ViewStub qMV;
        public View qMW;
        public MaskTextView qMX;
        public View qMY;
        public TextView qMZ;
        public boolean qMa = false;
        public TextView qMb;
        public TagImageView qMc;
        public TextView qMd;
        public int qMe = 0;
        public TextView qMf;
        public AsyncTextView qMg;
        public AsyncTextView qMh;
        public TextView qMi;
        public View qMj;
        public ImageView qMk;
        public View qMl;
        public MaskTextView qMm;
        public LinearLayout qMn;
        public LinearLayout qMo;
        public View qMp;
        public LinearLayout qMq;
        public PhotosContent qMr;
        public View qMs;
        public ViewStub qMt;
        public boolean qMu = false;
        public ViewStub qMv;
        public ViewStub qMw;
        public View qMx = null;
        public boolean qMy = false;
        public boolean qMz = false;
        public String qNa;
        public View qNb;
        public Button qNc;
        public Button qNd;
        public TextView qjE;
        public ali qnv;
        public ImageView qpP;
        public LinearLayout qpm;
        public TextView qtP;
        public int qzW = h.CTRL_INDEX;
    }

    class a extends m {
        final /* synthetic */ a qLO;

        a(a aVar) {
            this.qLO = aVar;
        }

        public final void onClick(View view) {
            this.qLO.pZQ.qzR.qKQ.onClick(view);
        }

        public final void updateDrawState(TextPaint textPaint) {
            int color = this.qLO.qb.getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVR);
            if (this.nII) {
                textPaint.bgColor = color;
            } else {
                textPaint.bgColor = 0;
            }
        }
    }

    class b extends m {
        final /* synthetic */ a qLO;

        b(a aVar) {
            this.qLO = aVar;
        }

        public final void onClick(View view) {
            this.qLO.pZQ.qzR.qKG.onClick(view);
        }

        public final void updateDrawState(TextPaint textPaint) {
            int color = this.qLO.qb.getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVR);
            if (this.nII) {
                textPaint.bgColor = color;
            } else {
                textPaint.bgColor = 0;
            }
        }
    }

    class d extends m {
        final /* synthetic */ a qLO;

        d(a aVar) {
            this.qLO = aVar;
        }

        public final void onClick(View view) {
            this.qLO.pZQ.qzR.qKH.onClick(view);
        }

        public final void updateDrawState(TextPaint textPaint) {
            int color = this.qLO.qb.getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVR);
            if (this.nII) {
                textPaint.bgColor = color;
            } else {
                textPaint.bgColor = 0;
            }
        }
    }

    public abstract void a(c cVar, int i, ax axVar, bfc com_tencent_mm_protocal_c_bfc, int i2, au auVar);

    public abstract void d(c cVar);

    public final void hO(boolean z) {
        this.qze = z;
    }

    private void a(c cVar, com.tencent.mm.plugin.sns.storage.m mVar) {
        LayoutParams layoutParams;
        if (!mVar.tE(32)) {
            if (cVar.qLU != null) {
                cVar.qLU.setVisibility(0);
            }
            cVar.qLY.setLongClickable(false);
            cVar.qLY.setOnClickListener(null);
            if (cVar.qMr != null) {
                layoutParams = (LayoutParams) cVar.qMr.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                cVar.qMr.setLayoutParams(layoutParams);
            }
            if (cVar.qMP) {
                layoutParams = (LayoutParams) cVar.qMQ.qxC.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                cVar.qMQ.qxC.setLayoutParams(layoutParams);
            }
            cVar.qLY.setLayoutParams(new LayoutParams(-1, -2));
            cVar.qLY.setBackgroundColor(Color.parseColor("#00ffffff"));
            if (cVar.qLW != null) {
                cVar.qLW.setVisibility(8);
            }
            if (cVar.qLV != null) {
                cVar.qLV.setVisibility(8);
            }
        } else if (mVar.bha() == null || mVar.bha().qeJ != 1) {
            if (cVar.qLU != null) {
                cVar.qLU.setVisibility(0);
            }
            cVar.qLY.setLongClickable(false);
            cVar.qLY.setOnClickListener(null);
            cVar.qLY.setLayoutParams(new LayoutParams(-1, -2));
            cVar.qLY.setBackgroundColor(Color.parseColor("#00ffffff"));
            if (cVar.qMr != null) {
                layoutParams = (LayoutParams) cVar.qMr.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                cVar.qMr.setLayoutParams(layoutParams);
            }
            if (cVar.qMP) {
                layoutParams = (LayoutParams) cVar.qMQ.qxC.getLayoutParams();
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                cVar.qMQ.qxC.setLayoutParams(layoutParams);
            }
            if (cVar.qLW != null) {
                cVar.qLW.setVisibility(8);
            }
            if (cVar.qLV != null) {
                cVar.qLV.setVisibility(8);
            }
        } else {
            if (cVar.qLU != null) {
                cVar.qLU.setVisibility(8);
            }
            cVar.qLY.setTag(cVar);
            cVar.qLY.setOnClickListener(this.pZQ.pZk.qNT);
            cVar.qLY.setLongClickable(true);
            this.pZQ.kaU.c(cVar.qLY, this.pZQ.pZk.qNG, this.pZQ.pZk.qNp);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams((((((WindowManager) this.qb.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 8), -2);
            layoutParams2.setMargins(0, com.tencent.mm.bg.a.fromDPToPix(this.qb, 5), 0, 0);
            cVar.qLY.setLayoutParams(layoutParams2);
            cVar.qLY.setBackgroundResource(e.pAi);
            if (cVar.qMr != null) {
                layoutParams = (LayoutParams) cVar.qMr.getLayoutParams();
                layoutParams.leftMargin = com.tencent.mm.bg.a.fromDPToPix(this.qb, 10);
                layoutParams.rightMargin = com.tencent.mm.bg.a.fromDPToPix(this.qb, 10);
                cVar.qMr.setLayoutParams(layoutParams);
            }
            if (cVar.qMP) {
                layoutParams = (LayoutParams) cVar.qMQ.qxC.getLayoutParams();
                layoutParams.leftMargin = com.tencent.mm.bg.a.fromDPToPix(this.qb, 10);
                layoutParams.rightMargin = com.tencent.mm.bg.a.fromDPToPix(this.qb, 10);
                cVar.qMQ.qxC.setLayoutParams(layoutParams);
            }
            if (cVar.qLW != null) {
                cVar.qLW.setVisibility(0);
            }
            if (cVar.qLV == null) {
                return;
            }
            if (bg.mA(mVar.bha().qeK)) {
                cVar.qLV.setVisibility(8);
            } else {
                cVar.qLV.setVisibility(0);
            }
        }
    }

    public final View a(Activity activity, c cVar, int i, au auVar, com.tencent.mm.plugin.sns.storage.m mVar) {
        String str;
        this.qb = activity;
        this.knu = i;
        this.pZQ = auVar;
        cVar.fVJ = mVar.bhe();
        switch (i) {
            case 0:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 1:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 2:
                str = "R.layout.sns_timeline_imagesline_one";
                break;
            case 3:
                str = "R.layout.sns_timeline_imagesline1";
                break;
            case 4:
                str = "R.layout.sns_timeline_imagesline2";
                break;
            case 5:
                str = "R.layout.sns_timeline_imagesline3";
                break;
            case 6:
                str = "R.layout.sns_timeline_item_photo_one3";
                break;
            case 7:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 8:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 9:
                str = "R.layout.sns_media_sight_item";
                break;
            case 10:
                str = "R.layout.sns_media_sub_item2";
                break;
            case 11:
                str = "R.layout.sns_hb_reward_item";
                break;
            default:
                str = "R.layout.sns_media_sub_item2";
                break;
        }
        View a = com.tencent.mm.kiss.a.b.vS().a(this.qb, str, g.pIq);
        cVar.qNa = str;
        View findViewById = a.findViewById(f.pCK);
        if (findViewById instanceof ViewStub) {
            cVar.qLZ = (ViewStub) findViewById;
        } else {
            cVar.qLZ = null;
        }
        w.i("MicroMsg.BaseTimeLineItem", "create new item  " + i + "  " + a.hashCode());
        cVar.qMT = a.findViewById(f.pFU);
        cVar.knu = i;
        cVar.ipv = (MaskImageButton) a.findViewById(f.pAU);
        cVar.ipv.setOnClickListener(auVar.pZk.qNq);
        cVar.ipv.setOnLongClickListener(auVar.pZk.qNr);
        cVar.ipv.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ a qLO;

            {
                this.qLO = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.setTag(f.cJw, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
                }
                return false;
            }
        });
        cVar.qLR = (AsyncTextView) a.findViewById(f.cof);
        cVar.qLS = (ImageView) a.findViewById(f.pGn);
        cVar.qLR.setOnTouchListener(new aa());
        cVar.qLT = (ViewGroup) a.findViewById(f.pDo);
        cVar.qLU = (AsyncNormalTextView) a.findViewById(f.pCm);
        cVar.qLU.e(auVar.qHH);
        cVar.qLW = (TextView) a.findViewById(f.pCl);
        cVar.qLW.setClickable(false);
        cVar.qLW.setLongClickable(false);
        cVar.qLV = (TextView) a.findViewById(f.pCk);
        cVar.qLV.setClickable(false);
        cVar.qLV.setLongClickable(false);
        cVar.qNb = a.findViewById(f.pBT);
        cVar.qNc = (Button) a.findViewById(f.pBU);
        cVar.qNd = (Button) a.findViewById(f.pBV);
        cVar.qNc.setOnClickListener(auVar.pZk.qNR);
        cVar.qNd.setOnClickListener(auVar.pZk.qNS);
        cVar.qLY = (LinearLayout) a.findViewById(f.pCL);
        if (mVar.tE(32)) {
            com.tencent.mm.plugin.sns.storage.b bha = mVar.bha();
            if (bha != null && bha.qey == 1) {
                cVar.qLU.setContentWidth((((((WindowManager) this.qb.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12));
                cVar.qLU.bie();
            } else if (bha != null && bha.qey == 2) {
                cVar.qLU.setContentWidth(((((WindowManager) this.qb.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bg.a.fromDPToPix(this.qb, 50)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12)) - com.tencent.mm.bg.a.fromDPToPix(this.qb, 12));
                cVar.qLU.bie();
            }
        }
        cVar.qLY.setTag(cVar);
        cVar.qLY.setOnClickListener(auVar.pZk.qNT);
        auVar.kaU.c(a.findViewById(f.bIb), auVar.pZk.qNs, auVar.pZk.qNp);
        auVar.kaU.c((TextView) a.findViewById(f.pCp), auVar.pZk.qNs, auVar.pZk.qNp);
        cVar.qLX = (SnsTranslateResultView) a.findViewById(f.pFZ);
        cVar.qLX.setVisibility(8);
        cVar.qLX.qJp.setPadding(0, 0, (int) this.qb.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.aXR), 0);
        cVar.qLX.pby.setBackgroundResource(e.pAk);
        auVar.kaU.c(cVar.qLX.pby, auVar.pZk.qNs, auVar.pZk.qNp);
        cVar.qMq = (LinearLayout) a.findViewById(f.pBZ);
        cVar.qMf = (TextView) a.findViewById(f.pGx);
        cVar.lle = (TextView) a.findViewById(f.pBI);
        cVar.qMg = (AsyncTextView) a.findViewById(f.pAS);
        cVar.qMh = (AsyncTextView) a.findViewById(f.pAR);
        cVar.qFk = (TextView) a.findViewById(f.pAT);
        cVar.pQK = new be(a);
        cVar.pQK.a(auVar.pZk.qNz, auVar.pZk.qNO);
        cVar.qtP = (TextView) a.findViewById(f.pBk);
        cVar.qtP.setText(activity.getString(j.dGB));
        cVar.qtP.setOnClickListener(auVar.pZk.qNt);
        cVar.qMg.setOnClickListener(auVar.pZk.qNP);
        cVar.qMh.setOnClickListener(auVar.pZk.qNQ);
        cVar.qFk.setOnClickListener(auVar.pZk.qNL);
        cVar.qMj = a.findViewById(f.pBm);
        cVar.qMj.setOnClickListener(auVar.pZk.qNy);
        cVar.qMi = (TextView) a.findViewById(f.pBl);
        cVar.qMk = (ImageView) a.findViewById(f.pBJ);
        cVar.qMt = (ViewStub) a.findViewById(f.pBg);
        cVar.qpm = (LinearLayout) a.findViewById(f.pBE);
        cVar.qMV = (ViewStub) a.findViewById(f.pBn);
        cVar.qMv = (ViewStub) a.findViewById(f.pFC);
        cVar.qMb = (TextView) a.findViewById(f.pCD);
        cVar.qMb.setOnClickListener(auVar.pZk.qNu);
        cVar.qMZ = (TextView) a.findViewById(f.pCH);
        cVar.mil = a;
        if (this.qze) {
            com.tencent.mm.plugin.sns.abtest.c.b(a, cVar);
            com.tencent.mm.plugin.sns.abtest.a.a(a, cVar);
            ae.beC();
            com.tencent.mm.plugin.sns.f.c.c(a, cVar);
        }
        d(cVar);
        a.setTag(cVar);
        a(cVar, mVar);
        return a;
    }

    public final void a(c cVar, int i, com.tencent.mm.plugin.sns.storage.m mVar, bfc com_tencent_mm_protocal_c_bfc, int i2, au auVar) {
        String bhy;
        String str;
        CharSequence charSequence;
        com.tencent.mm.ui.a.a aVar;
        View view;
        TextView textView;
        TextView textView2;
        String str2;
        TextView textView3;
        boolean z;
        ax axVar = (ax) auVar.bkX().biX().get(Integer.valueOf(i));
        a(cVar, mVar);
        this.knu = i2;
        this.pZQ = auVar;
        if (this.qze) {
            aw.B(mVar);
        }
        if (mVar.tE(32)) {
            w.i("MicroMsg.BaseTimeLineItem", "the ad sns id is " + i.dg(mVar.field_snsId) + " for susan");
        }
        cVar.qLP = axVar.qIn;
        cVar.moR = false;
        cVar.position = i;
        cVar.fVJ = axVar.qIm;
        cVar.fGN = axVar.qtl;
        cVar.qLQ = axVar.qIr;
        cVar.qMk.setOnClickListener(auVar.qHG);
        cVar.qMR = com_tencent_mm_protocal_c_bfc;
        bbk com_tencent_mm_protocal_c_bbk = axVar.pyI;
        cVar.pOp = com_tencent_mm_protocal_c_bbk;
        com.tencent.mm.plugin.sns.h.b bVar = auVar.qHw.qpZ.pWR;
        if (mVar != null) {
            bhy = mVar.bhy();
            bVar.qda.add(bhy);
            if (mVar.tE(32)) {
                bVar.qdf.add(bhy);
            }
            bVar.qdg.add(mVar.field_userName);
            switch (mVar.field_type) {
                case 1:
                    bVar.qdc.add(bhy);
                    break;
                case 2:
                    bVar.qdb.add(bhy);
                    break;
                case 3:
                    if (!bg.mA(com_tencent_mm_protocal_c_bfc.ufC)) {
                        bVar.qdh.add(bhy);
                        break;
                    } else {
                        bVar.qdi.add(bhy);
                        break;
                    }
                case 4:
                    bVar.qde.add(bhy);
                    break;
                case 5:
                    bVar.qdj.add(bhy);
                    break;
                case 15:
                    bVar.qdd.add(bhy);
                    break;
                case 18:
                    bVar.qdk.add(bhy);
                    break;
                default:
                    bVar.qdl.add(bhy);
                    break;
            }
            if (i < bVar.qcY) {
                bVar.qcY = i;
                bVar.qbE = i.g(mVar);
            }
            if (i > bVar.qcZ) {
                bVar.qcZ = i;
                bVar.qbF = i.g(mVar);
            }
            bVar.qbK = bVar.qdb.size();
            bVar.qbL = bVar.qdc.size();
            bVar.qbM = bVar.qdd.size();
            bVar.qbO = bVar.qde.size();
            bVar.qbN = bVar.qdf.size();
            bVar.qbP = bVar.qdj.size();
            bVar.qbX = bVar.qdk.size();
            bVar.kaN = bVar.qdg.size();
            bVar.qbI = bVar.qdh.size();
            bVar.qbJ = bVar.qdi.size();
            bVar.qbW = bVar.qdl.size();
            bVar.qbs = bVar.qda.size();
        }
        bhy = axVar.jia;
        if (bhy != null) {
            cVar.qMS = axVar.qIl;
            if (axVar.qIC) {
                w.i("MicroMsg.BaseTimeLineItem", "getContact %s", new Object[]{bhy});
                if (com.tencent.mm.pluginsdk.ui.a.b.bEa().nZ() != null) {
                    cVar.ipv.setImageBitmap(com.tencent.mm.pluginsdk.ui.a.b.bEa().nZ());
                }
                com.tencent.mm.u.ag.a.hlS.a(bhy, "", new com.tencent.mm.plugin.sns.ui.au.b(auVar.bkX(), i));
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(cVar.ipv, bhy);
            }
            cVar.ipv.setTag(bhy);
            ((MaskImageButton) cVar.ipv).wnt = axVar.qtl;
            AsyncTextView asyncTextView = cVar.qLR;
            String str3 = axVar.qIB;
            com.tencent.mm.pluginsdk.ui.d.m.a aVar2 = auVar.qzO;
            boolean z2 = axVar.qpL;
            String str4 = axVar.qtl;
            boolean z3 = axVar.qpL;
            asyncTextView.userName = bhy;
            asyncTextView.qpK = str3;
            asyncTextView.knu = i2;
            asyncTextView.qpL = z2;
            asyncTextView.qpM = str4;
            asyncTextView.qpN = aVar2;
            asyncTextView.qpO = z3;
            asyncTextView.run();
        }
        cVar.qLS.setVisibility(8);
        if (axVar.qpL) {
            cVar.pQJ = true;
            cVar.moR = axVar.qIs;
            cVar.iHN = axVar.qIt;
        } else {
            cVar.pQJ = false;
            cVar.iHN = "";
        }
        cVar.qNb.setVisibility(8);
        if (cVar == null || !mVar.tE(32) || mVar.bha() == null || mVar.bha().qeJ != 1) {
            AsyncNormalTextView asyncNormalTextView = cVar.qLU;
            bhy = axVar.qIo;
            asyncNormalTextView.qpI = axVar.qIp;
            asyncNormalTextView.content = bhy;
            asyncNormalTextView.pZQ = auVar;
            asyncNormalTextView.qpJ = axVar;
            if (bg.mA(bhy)) {
                asyncNormalTextView.setVisibility(8);
            }
            cVar.qLU.c(cVar);
        } else {
            str = bg.mA(mVar.bha().qeL) ? com_tencent_mm_protocal_c_bfc.ufy : mVar.bha().qeL;
            if (bg.mA(str)) {
                cVar.qLW.setVisibility(8);
            } else {
                cVar.qLW.setText(str + " ");
                com.tencent.mm.pluginsdk.ui.d.h.d(cVar.qLW, 2);
                cVar.qLW.setVisibility(0);
            }
            str = mVar.bha().qeK;
            if (bg.mA(str)) {
                cVar.qLV.setVisibility(8);
            } else {
                cVar.qLV.setText(str + " ");
                com.tencent.mm.pluginsdk.ui.d.h.d(cVar.qLV, 2);
                cVar.qLV.setVisibility(0);
            }
            if (mVar.bha().bfK()) {
                cVar.qNb.setVisibility(0);
                cVar.qNc.setText(mVar.bha().bfG());
                cVar.qNd.setText(mVar.bha().bfH());
            }
        }
        cVar.qMi.setOnTouchListener(new aa());
        a(cVar, i, axVar, com_tencent_mm_protocal_c_bfc, i2, auVar);
        auVar.qHy.put(Integer.valueOf(i), new WeakReference(cVar.mil));
        if (cVar.mil.getBackground() == null) {
            cVar.mil.setBackgroundResource(e.beo);
            int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.qb, 12);
            cVar.mil.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, com.tencent.mm.bg.a.fromDPToPix(this.qb, 8));
        }
        cVar.lle.setText(axVar.qIu);
        cVar.qMg.setVisibility(8);
        cVar.qMh.setVisibility(8);
        if (axVar.qpL) {
            com.tencent.mm.plugin.sns.storage.a aVar3 = axVar.qIv;
            cVar.qMg.setTag(axVar.qtl);
            if (axVar.qIv.qdR == com.tencent.mm.plugin.sns.storage.a.qdD) {
                if (bg.mA(axVar.qIy)) {
                    cVar.qMg.setVisibility(8);
                } else {
                    cVar.qMg.setText(axVar.qIy);
                    cVar.qMg.setVisibility(0);
                }
            } else if (aVar3.qdR == com.tencent.mm.plugin.sns.storage.a.qdE) {
                if (bg.mA(axVar.qIz)) {
                    cVar.qMg.setVisibility(8);
                } else {
                    str = axVar.qIA;
                    CharSequence charSequence2 = axVar.qIz;
                    Context context = this.qb;
                    cVar.qMg.getTextSize();
                    CharSequence iVar = new com.tencent.mm.pluginsdk.ui.d.i(com.tencent.mm.pluginsdk.ui.d.h.d(context, charSequence2, 1));
                    iVar.f(null, charSequence2);
                    TextPaint paint = cVar.qMg.getPaint();
                    if (com.tencent.mm.bg.a.W(this.qb, (int) Layout.getDesiredWidth(iVar, 0, iVar.length(), paint)) > cVar.qzW) {
                        while (str.length() > 1) {
                            str = str.substring(0, str.length() - 2);
                            iVar = String.format(aVar3.qdS, new Object[]{str + "..."});
                            Context context2 = this.qb;
                            cVar.qMg.getTextSize();
                            CharSequence iVar2 = new com.tencent.mm.pluginsdk.ui.d.i(com.tencent.mm.pluginsdk.ui.d.h.d(context2, iVar, 1));
                            iVar2.f(null, iVar);
                            int W = com.tencent.mm.bg.a.W(this.qb, (int) Layout.getDesiredWidth(iVar2, 0, iVar2.length(), paint));
                            cVar.qMg.setText(iVar2, BufferType.SPANNABLE);
                            cVar.qMg.setVisibility(0);
                            if (W <= cVar.qzW) {
                            }
                        }
                    } else {
                        cVar.qMg.setText(iVar, BufferType.SPANNABLE);
                        cVar.qMg.setVisibility(0);
                    }
                }
            }
            if (cVar.qMg.getVisibility() != 8 && bg.mA(aVar3.qdT)) {
                cVar.qMg.setTextColor(this.qb.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzi));
                cVar.qMg.setOnClickListener(null);
            }
            if (mVar.bhd().ufB.tsP == 4) {
                cVar.qMh.setTag(cVar);
                cVar.qMh.setVisibility(0);
                cVar.qMh.setText(String.format("%s%s%s", new Object[]{this.qb.getResources().getString(j.pKj), axVar.qIB, this.qb.getResources().getString(j.pKk)}));
            } else {
                cVar.qMh.setVisibility(8);
            }
        }
        if (axVar.qIE) {
            cVar.qMZ.setText(auVar.fCi.getString(j.pJN, new Object[]{Integer.valueOf(axVar.qIF)}));
            cVar.qMZ.setVisibility(0);
        } else {
            cVar.qMZ.setVisibility(8);
        }
        cVar.qFk.setTag(axVar.qtl);
        if (bg.mA(axVar.qIH)) {
            cVar.qFk.setVisibility(8);
        } else {
            cVar.qFk.setVisibility(0);
            cVar.qFk.setText(axVar.qIH);
            cVar.qFk.setClickable(axVar.qII);
            cVar.qFk.setTextColor(axVar.qII ? -11048043 : -9211021);
        }
        cVar.qMi.setTextColor(this.qb.getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVS));
        if (axVar.qIJ) {
            cVar.qMi.setVisibility(0);
            charSequence = this.qb.getString(j.pKA) + axVar.iQO;
            if (charSequence.length() > 10) {
                charSequence = charSequence.substring(0, 10) + "...";
            }
            CharSequence spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new b(this), 0, spannableString.length(), 33);
            cVar.qMi.setText(spannableString, BufferType.SPANNABLE);
            if (!(axVar.qIL || "wx7fa037cc7dfabad5".equals(com_tencent_mm_protocal_c_bfc.ufA.mQY))) {
                cVar.qMi.setTextColor(this.qb.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzi));
                cVar.qMi.setOnTouchListener(null);
            }
            cVar.qMi.setTag(com_tencent_mm_protocal_c_bfc);
        } else if (axVar.qIK) {
            cVar.qMi.setVisibility(0);
            charSequence = new SpannableString(axVar.qIN);
            charSequence.setSpan(new d(this), 0, charSequence.length(), 33);
            cVar.qMi.setText(charSequence, BufferType.SPANNABLE);
            cVar.qMi.setTag(new bc(axVar.qIM, axVar.qIN));
        } else if (axVar.qIO) {
            cVar.qMi.setVisibility(0);
            str = this.qb.getString(j.pJC);
            Object obj = str + axVar.iQO;
            charSequence2 = new SpannableString(obj);
            charSequence2.setSpan(new ForegroundColorSpan(this.qb.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzi)), 0, str.length(), 33);
            charSequence2.setSpan(new a(this), str.length(), obj.length(), 33);
            cVar.qMi.setText(charSequence2, BufferType.SPANNABLE);
            if (!(axVar.qIL || "wx7fa037cc7dfabad5".equals(com_tencent_mm_protocal_c_bfc.ufA.mQY))) {
                cVar.qMi.setTextColor(this.qb.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pzi));
                cVar.qMi.setOnTouchListener(null);
            }
            cVar.qMi.setTag(com_tencent_mm_protocal_c_bfc);
        } else {
            cVar.qMi.setVisibility(8);
        }
        if (axVar.qID) {
            cVar.qtP.setVisibility(0);
            cVar.qtP.setTag(axVar.qtl);
        } else {
            cVar.qtP.setVisibility(8);
        }
        cVar.qMk.setTag(cVar);
        if (axVar.qIP) {
            if (!cVar.qMz) {
                cVar.qMo = (LinearLayout) cVar.qMv.inflate();
                cVar.qMp = cVar.mil.findViewById(f.pDt);
                cVar.qMz = true;
                cVar.qMp.setTag(axVar.qtl);
                cVar.qjE = (TextView) cVar.qMo.findViewById(f.pDt);
            }
            cVar.qMv.setVisibility(0);
            cVar.qMp.setOnClickListener(auVar.pZk.qNx);
            switch (axVar.qIQ) {
                case bh.CTRL_INDEX /*201*/:
                    cVar.qjE.setText(j.pMc);
                    cVar.qMp.setClickable(false);
                    cVar.qMp.setEnabled(false);
                    break;
                case h.CTRL_INDEX /*210*/:
                    cVar.qjE.setText(j.pMe);
                    cVar.qMp.setClickable(false);
                    cVar.qMp.setEnabled(false);
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX /*211*/:
                    cVar.qjE.setText(j.pMd);
                    cVar.qMp.setClickable(true);
                    cVar.qMp.setEnabled(true);
                    break;
                default:
                    cVar.qjE.setText(j.pMf);
                    cVar.qMp.setClickable(true);
                    cVar.qMp.setEnabled(true);
                    break;
            }
            ali bhq = mVar.bhq();
            if (!(bhq == null || bg.mA(bhq.tPV))) {
                cVar.qjE.setText(bhq.tPV);
            }
        } else if (cVar.qMz) {
            cVar.qMv.setVisibility(8);
        }
        if (axVar.qIR) {
            cVar.qMj.setVisibility(0);
            cVar.qMj.setTag(axVar.qtl);
        } else {
            cVar.qMj.setVisibility(8);
        }
        if (axVar.qIS) {
            if (!bg.mA(axVar.qIT)) {
                cVar.qMf.setVisibility(0);
                if (i2 == 7) {
                    charSequence = String.format(this.qb.getString(j.pMK), new Object[]{axVar.qIT});
                } else {
                    charSequence = String.format(this.qb.getString(j.pML), new Object[]{axVar.qIT});
                }
                cVar.qMf.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.qb, charSequence, cVar.qMf.getTextSize()));
            } else if (axVar.qIU) {
                cVar.qMf.setVisibility(0);
                cVar.qMf.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.qb, this.qb.getString(j.pMM).toString(), cVar.qMf.getTextSize()));
            }
            if (axVar.qIV) {
                if (cVar.qMW == null) {
                    cVar.qMW = cVar.qMV.inflate();
                    cVar.pSj = (TextView) cVar.qMW.findViewById(f.pBo);
                    cVar.qMX = (MaskTextView) cVar.qMW.findViewById(f.pBp);
                    cVar.qMX.setOnTouchListener(new aa());
                }
                cVar.qMW.setVisibility(0);
                b(cVar.qMX, axVar.qIY, i2);
                cVar.pSj.setText(this.qb.getString(j.pLM, new Object[]{Integer.valueOf(axVar.qIW), bg.n(axVar.qIX / 100.0d)}));
                cVar.qMW.setTag(mVar);
                cVar.qMW.setOnClickListener(auVar.pZk.qNB);
            } else if (cVar.qMW != null) {
                cVar.qMW.setVisibility(8);
            }
            if ((axVar.qIZ == null && axVar.qIZ.size() != 0) || (axVar.qJa != null && axVar.qJa.size() != 0)) {
                if (!cVar.qMu) {
                    if (cVar.qpm == null) {
                        cVar.qpm = (LinearLayout) cVar.qMt.inflate();
                    }
                    cVar.qMm = (MaskTextView) cVar.qpm.findViewById(f.pBC);
                    cVar.qMm.setOnTouchListener(new aa());
                    cVar.qMn = (LinearLayout) cVar.mil.findViewById(f.pBd);
                    cVar.qpm.setTag(axVar.qIm);
                    cVar.qMm.setTag(axVar.qIm);
                    cVar.qMs = cVar.qpm.findViewById(f.pBG);
                    cVar.qMY = cVar.qpm.findViewById(f.pBE);
                    cVar.qMu = true;
                }
                cVar.qpm.setVisibility(0);
                if (axVar.qIZ == null || axVar.qIZ.size() <= 0) {
                    cVar.qMm.setVisibility(8);
                } else {
                    cVar.qMm.setVisibility(0);
                    a(cVar.qMm, axVar.qIZ, i2);
                }
                if (axVar.qJa != null) {
                    a(com_tencent_mm_protocal_c_bbk.ucq, axVar.qJa, cVar);
                } else {
                    cVar.qMn.setVisibility(8);
                }
                if (axVar.qIZ == null || axVar.qIZ.size() == 0 || axVar.qJa == null || axVar.qJa.size() == 0) {
                    cVar.qMs.setVisibility(8);
                } else {
                    cVar.qMs.setVisibility(0);
                }
            } else if (cVar.qpm != null) {
                cVar.qpm.setVisibility(8);
            } else if (cVar.qMu) {
                cVar.qMt.setVisibility(8);
            }
            if (axVar.qJb) {
                cVar.qMb.setVisibility(8);
            } else {
                cVar.qMb.setTag(axVar.qtl);
                cVar.qMb.setText(axVar.qJc);
                cVar.qMb.setVisibility(0);
            }
            if (axVar.qpL) {
                cVar.pQK.setVisibility(8);
            } else {
                w.i("MicroMsg.BaseTimeLineItem", "adatag " + axVar.qIx);
                cVar.pQK.p(Long.valueOf(axVar.qIn), new com.tencent.mm.plugin.sns.data.b(cVar.pQK, cVar.position, axVar.qtl, axVar.qIn));
                cVar.pQK.a(axVar.qIw, axVar.qIv);
                cVar.pQK.setVisibility(0);
                if (cVar.qFk != null && cVar.qFk.getVisibility() == 0) {
                    if ((cVar.pQK.qKw.getVisibility() != 0 ? 1 : null) != null) {
                        LayoutParams layoutParams = (LayoutParams) cVar.qFk.getLayoutParams();
                        layoutParams.setMargins(layoutParams.leftMargin, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.qb, 0.0f), layoutParams.rightMargin, layoutParams.bottomMargin);
                        cVar.qFk.setLayoutParams(layoutParams);
                    }
                }
            }
            if (this.qze) {
                ae.beC().a(this.qb, com_tencent_mm_protocal_c_bbk, cVar);
            }
            cVar.qLX.pby.setTag(new ar(axVar.qIm, axVar.qtl, false, true, 1));
            aVar = com.tencent.mm.ui.a.a.a.uWW;
            view = cVar.mil;
            textView = cVar.qLR;
            textView2 = cVar.lle;
            str2 = cVar.qLU.content;
            textView3 = cVar.qMd;
            z = cVar.qMP;
            if (aVar.bQH() && aVar.ty != null && view != null && textView != null && !bg.mA(str2) && textView2 != null) {
                com.tencent.mm.ui.a.b bVar2 = new com.tencent.mm.ui.a.b();
                bVar2.SK(textView.getText().toString());
                bVar2.SK(str2);
                if (textView3 != null) {
                    bVar2.SK(textView3.getText().toString());
                }
                if (z) {
                    bVar2.SK(aVar.ty.getString(k.hfg));
                }
                bVar2.cZ(view);
                return;
            }
            return;
        }
        cVar.qMf.setVisibility(8);
        if (axVar.qIV) {
            if (cVar.qMW == null) {
                cVar.qMW = cVar.qMV.inflate();
                cVar.pSj = (TextView) cVar.qMW.findViewById(f.pBo);
                cVar.qMX = (MaskTextView) cVar.qMW.findViewById(f.pBp);
                cVar.qMX.setOnTouchListener(new aa());
            }
            cVar.qMW.setVisibility(0);
            b(cVar.qMX, axVar.qIY, i2);
            cVar.pSj.setText(this.qb.getString(j.pLM, new Object[]{Integer.valueOf(axVar.qIW), bg.n(axVar.qIX / 100.0d)}));
            cVar.qMW.setTag(mVar);
            cVar.qMW.setOnClickListener(auVar.pZk.qNB);
        } else if (cVar.qMW != null) {
            cVar.qMW.setVisibility(8);
        }
        if (axVar.qIZ == null) {
        }
        if (cVar.qpm != null) {
            cVar.qpm.setVisibility(8);
        } else if (cVar.qMu) {
            cVar.qMt.setVisibility(8);
        }
        if (axVar.qJb) {
            cVar.qMb.setVisibility(8);
        } else {
            cVar.qMb.setTag(axVar.qtl);
            cVar.qMb.setText(axVar.qJc);
            cVar.qMb.setVisibility(0);
        }
        if (axVar.qpL) {
            cVar.pQK.setVisibility(8);
        } else {
            w.i("MicroMsg.BaseTimeLineItem", "adatag " + axVar.qIx);
            cVar.pQK.p(Long.valueOf(axVar.qIn), new com.tencent.mm.plugin.sns.data.b(cVar.pQK, cVar.position, axVar.qtl, axVar.qIn));
            cVar.pQK.a(axVar.qIw, axVar.qIv);
            cVar.pQK.setVisibility(0);
            if (cVar.pQK.qKw.getVisibility() != 0) {
            }
            if ((cVar.pQK.qKw.getVisibility() != 0 ? 1 : null) != null) {
                LayoutParams layoutParams2 = (LayoutParams) cVar.qFk.getLayoutParams();
                layoutParams2.setMargins(layoutParams2.leftMargin, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.qb, 0.0f), layoutParams2.rightMargin, layoutParams2.bottomMargin);
                cVar.qFk.setLayoutParams(layoutParams2);
            }
        }
        if (this.qze) {
            ae.beC().a(this.qb, com_tencent_mm_protocal_c_bbk, cVar);
        }
        cVar.qLX.pby.setTag(new ar(axVar.qIm, axVar.qtl, false, true, 1));
        aVar = com.tencent.mm.ui.a.a.a.uWW;
        view = cVar.mil;
        textView = cVar.qLR;
        textView2 = cVar.lle;
        str2 = cVar.qLU.content;
        textView3 = cVar.qMd;
        z = cVar.qMP;
        if (aVar.bQH()) {
        }
    }

    public static void e(c cVar) {
        if (cVar != null && cVar.qLX != null) {
            cVar.qLX.setVisibility(8);
        }
    }

    private boolean a(MaskTextView maskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, int i) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(" ");
        int length = spannableStringBuilder.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[bVar.size()];
        int[] iArr2 = new int[bVar.size()];
        Object obj = 1;
        int i2 = 0;
        while (i2 < bVar.size()) {
            try {
                String str = (String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(1);
                if (obj != null) {
                    spannableStringBuilder.append(" ");
                    stringBuffer.append(" ");
                    obj = null;
                } else {
                    spannableStringBuilder.append(", ");
                    stringBuffer.append(", ");
                }
                iArr[i2] = spannableStringBuilder.length();
                iArr2[i2] = iArr[i2] + str.length();
                stringBuffer.append(str);
                spannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.d.h.b(this.qb, str, maskTextView.getTextSize()));
                i2++;
            } catch (Throwable e) {
                w.e("MicroMsg.BaseTimeLineItem", "setLikedList  e:%s", new Object[]{bg.g(e)});
            }
        }
        Drawable drawable = this.qb.getResources().getDrawable(i == 11 ? e.pzG : e.pzR);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        com.tencent.mm.ui.widget.d dVar = new com.tencent.mm.ui.widget.d(drawable);
        dVar.wuA = (int) (((((float) drawable.getIntrinsicHeight()) - maskTextView.getTextSize()) + ((float) com.tencent.mm.bg.a.fromDPToPix(this.qb, 2))) / 2.0f);
        spannableStringBuilder.setSpan(dVar, length, length + 1, 33);
        int i3 = i == 11 ? 3 : 2;
        for (i2 = 0; i2 < iArr.length; i2++) {
            spannableStringBuilder.setSpan(new m((String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(0), this.pZQ.qzO, i3), iArr[i2], iArr2[i2], 33);
        }
        maskTextView.setText(spannableStringBuilder, BufferType.SPANNABLE);
        maskTextView.neH = stringBuffer.toString();
        return true;
    }

    private void b(MaskTextView maskTextView, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, int i) {
        if (bVar.size() == 0) {
            maskTextView.setVisibility(8);
            return;
        }
        maskTextView.setVisibility(0);
        CharSequence spannableStringBuilder = new SpannableStringBuilder(" ");
        int length = spannableStringBuilder.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int[] iArr = new int[bVar.size()];
        int[] iArr2 = new int[bVar.size()];
        Object obj = 1;
        int i2 = 0;
        while (i2 < bVar.size()) {
            try {
                String str = (String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(1);
                if (obj != null) {
                    spannableStringBuilder.append(" ");
                    stringBuffer.append(" ");
                    obj = null;
                } else {
                    spannableStringBuilder.append(", ");
                    stringBuffer.append(", ");
                }
                iArr[i2] = spannableStringBuilder.length();
                iArr2[i2] = iArr[i2] + str.length();
                stringBuffer.append(str);
                spannableStringBuilder.append(com.tencent.mm.pluginsdk.ui.d.h.b(this.qb, str, maskTextView.getTextSize()));
                i2++;
            } catch (Throwable e) {
                w.e("MicroMsg.BaseTimeLineItem", "setReward error  e:%s", new Object[]{bg.g(e)});
                return;
            }
        }
        Drawable drawable = this.qb.getResources().getDrawable(com.tencent.mm.plugin.sns.i.i.pIY);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        com.tencent.mm.ui.widget.d dVar = new com.tencent.mm.ui.widget.d(drawable);
        dVar.wuA = (int) (((((float) drawable.getIntrinsicHeight()) - maskTextView.getTextSize()) + ((float) com.tencent.mm.bg.a.fromDPToPix(this.qb, 2))) / 2.0f);
        spannableStringBuilder.setSpan(dVar, length, length + 1, 33);
        int i3 = i == 11 ? 3 : 2;
        for (i2 = 0; i2 < iArr.length; i2++) {
            spannableStringBuilder.setSpan(new m((String) ((com.tencent.mm.vending.j.a) bVar.get(i2)).get(0), this.pZQ.qzO, i3), iArr[i2], iArr2[i2], 33);
        }
        maskTextView.setText(spannableStringBuilder, BufferType.SPANNABLE);
        maskTextView.neH = stringBuffer.toString();
    }

    public final void a(c cVar, int i, com.tencent.mm.plugin.sns.storage.m mVar) {
        c cVar2 = cVar;
        int i2 = i;
        a(cVar2, i2, (ax) this.pZQ.bkX().biX().get(Integer.valueOf(i)), mVar.bhd(), cVar.knu, this.pZQ);
    }

    private boolean a(List<bba> list, com.tencent.mm.vending.d.b<com.tencent.mm.vending.j.a> bVar, c cVar) {
        int i;
        LinearLayout linearLayout = cVar.qMn;
        int childCount = linearLayout.getChildCount();
        int size = bVar.size();
        if (childCount > size) {
            for (i = size; i < childCount; i++) {
                View childAt = linearLayout.getChildAt(size);
                linearLayout.removeViewAt(size);
                if (childAt instanceof SnsCommentPreloadTextView) {
                    this.pZQ.a((SnsCommentPreloadTextView) childAt);
                }
            }
        }
        if (bVar.size() == 0) {
            linearLayout.setVisibility(8);
            return false;
        }
        ax axVar;
        linearLayout.setVisibility(0);
        com.tencent.mm.plugin.sns.ui.w bkX = this.pZQ.bkX();
        if (bkX instanceof aw) {
            axVar = (ax) ((aw) bkX).qHY.get(cVar.position);
        } else {
            axVar = null;
        }
        if (this.DEBUG) {
            w.d("MicroMsg.BaseTimeLineItem", "debug:setCommentList position " + cVar.position + " commentCount: " + size);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < bVar.size(); i3++) {
            View bkT;
            View view;
            Object obj;
            View view2;
            Object obj2;
            com.tencent.mm.vending.j.a aVar = (com.tencent.mm.vending.j.a) bVar.get(i3);
            long longValue = ((Long) aVar.get(0)).longValue();
            String str = (String) aVar.get(1);
            String str2 = (String) aVar.get(2);
            String str3 = (String) aVar.get(3);
            CharSequence charSequence = (CharSequence) aVar.get(4);
            bba com_tencent_mm_protocal_c_bba = (bba) list.get(i3);
            com.tencent.mm.plugin.sns.model.ao.b U = U(cVar.fVJ, longValue);
            if (U != null && U.hrm) {
                ao.bI(U.id, 2);
            }
            if (i2 >= childCount) {
                if (U == null || U.hrm) {
                    bkT = this.pZQ.bkT();
                    ((SnsCommentPreloadTextView) bkT).H(14.0f * com.tencent.mm.bg.a.dI(bkT.getContext()));
                    if (this.pZQ.qHA == -1) {
                        this.pZQ.qHA = this.qb.getResources().getColor(com.tencent.mm.plugin.sns.i.c.pyZ);
                    }
                    ((SnsCommentPreloadTextView) bkT).setTextColor(this.pZQ.qHA);
                    ((SnsCommentPreloadTextView) bkT).wa();
                } else {
                    bkT = new TranslateCommentTextView(this.qb);
                    ((TranslateCommentTextView) bkT).qAT.ao(14.0f * com.tencent.mm.bg.a.dI(bkT.getContext()));
                    ((TranslateCommentTextView) bkT).qLm.setTextSize(1, 14.0f * com.tencent.mm.bg.a.dI(bkT.getContext()));
                }
                view = bkT;
                obj = 1;
            } else {
                view = linearLayout.getChildAt(i2);
                obj = null;
            }
            if (U != null) {
                if (!(view instanceof TranslateCommentTextView)) {
                    linearLayout.removeView(view);
                    bkT = new TranslateCommentTextView(this.qb);
                    linearLayout.addView(bkT, i2);
                    ((TranslateCommentTextView) bkT).qAT.ao(14.0f * com.tencent.mm.bg.a.dI(bkT.getContext()));
                    ((TranslateCommentTextView) bkT).qLm.setTextSize(1, 14.0f * com.tencent.mm.bg.a.dI(bkT.getContext()));
                    view = bkT;
                }
                TranslateCommentTextView translateCommentTextView = (TranslateCommentTextView) view;
                view.setOnTouchListener(null);
                a(translateCommentTextView.qLm, charSequence);
                if (!U.hoD) {
                    translateCommentTextView.qLm.setTextSize(1, 14.0f * com.tencent.mm.bg.a.dI(translateCommentTextView.getContext()));
                    translateCommentTextView.qAT.uh(2);
                    translateCommentTextView.qAT.setVisibility(0);
                    view2 = view;
                    obj2 = 1;
                } else if (U.hrm) {
                    translateCommentTextView.qAT.setVisibility(8);
                    view2 = view;
                    r2 = 1;
                } else {
                    String str4 = U.result;
                    String str5 = U.hwe;
                    String charSequence2 = translateCommentTextView.qLm.getText().toString();
                    if (!bg.mA(charSequence2)) {
                        String[] strArr;
                        String[] split = charSequence2.split(":");
                        if (split.length > 2) {
                            strArr = new String[]{split[0], charSequence2.substring(r2[0].length() + 1)};
                        } else {
                            strArr = split;
                        }
                        if (strArr.length == 2) {
                            if (bg.mA(str4)) {
                                translateCommentTextView.qAT.a(U, 2, null, str5, U.pXy);
                            } else {
                                translateCommentTextView.qAT.a(U, 2, strArr[0] + ": " + str4, str5, U.pXy);
                            }
                            translateCommentTextView.qAT.setVisibility(0);
                        }
                        translateCommentTextView.qLm.setTextSize(1, 14.0f * com.tencent.mm.bg.a.dI(translateCommentTextView.getContext()));
                    }
                    view2 = view;
                    r2 = 1;
                }
            } else {
                if (obj == null && (view instanceof TranslateCommentTextView)) {
                    linearLayout.removeView(view);
                    View bkT2 = this.pZQ.bkT();
                    linearLayout.addView(bkT2, i2);
                    ((SnsCommentPreloadTextView) bkT2).H(14.0f * com.tencent.mm.bg.a.dI(bkT2.getContext()));
                    view = bkT2;
                }
                view.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k(this.qb));
                a(view, charSequence);
                view2 = view;
                obj2 = null;
            }
            view2.setBackgroundResource(e.pAs);
            if (i2 > 0) {
                if (obj2 != null) {
                    view2.setPadding(0, com.tencent.mm.bg.a.fromDPToPix(this.qb, 2), 0, com.tencent.mm.bg.a.fromDPToPix(this.qb, 7));
                } else {
                    view2.setPadding(0, com.tencent.mm.bg.a.fromDPToPix(this.qb, 2), 0, com.tencent.mm.bg.a.fromDPToPix(this.qb, 3));
                }
            } else if (obj2 != null) {
                view2.setPadding(0, 1, 0, com.tencent.mm.bg.a.fromDPToPix(this.qb, 7));
            } else {
                view2.setPadding(0, 1, 0, com.tencent.mm.bg.a.fromDPToPix(this.qb, 3));
            }
            if (obj2 != null) {
                i = (int) this.qb.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.aXR);
                ((TranslateCommentTextView) view2).qAT.qJp.setPadding(0, 0, i, 0);
            }
            view2.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ a qLO;

                public final boolean onLongClick(View view) {
                    int[] iArr;
                    int[] iArr2 = new int[2];
                    if (view.getTag(f.cJw) instanceof int[]) {
                        iArr = (int[]) view.getTag(f.cJw);
                    } else {
                        iArr = iArr2;
                    }
                    this.qLO.pZQ.kaU.a(view2, this.qLO.pZQ.pZk.qNC, this.qLO.pZQ.pZk.qNp, iArr[0], iArr[1]);
                    return true;
                }
            });
            view2.setOnClickListener(new com.tencent.mm.plugin.sns.ui.i.a(this.pZQ.qHw, com_tencent_mm_protocal_c_bba, str2, str3, cVar));
            view2.setTag(new l(axVar.qIm, com_tencent_mm_protocal_c_bba, str, str3, view2, 1));
            if (obj != null) {
                linearLayout.addView(view2);
            }
            i2++;
        }
        return true;
    }

    private static void a(View view, CharSequence charSequence) {
        if (view instanceof SnsCommentPreloadTextView) {
            ((SnsCommentPreloadTextView) view).setText(charSequence);
        } else if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
    }

    private com.tencent.mm.plugin.sns.model.ao.b U(String str, long j) {
        if (this.qLN.size() <= 0) {
            return null;
        }
        Iterator it = this.qLN.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.sns.model.ao.b bVar = (com.tencent.mm.plugin.sns.model.ao.b) it.next();
            if (bVar.id != null && bVar.id.equals(ao.dv(str, String.valueOf(j)))) {
                return bVar;
            }
        }
        return null;
    }
}
