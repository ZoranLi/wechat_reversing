package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ka;
import com.tencent.mm.plugin.wenote.model.a;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public abstract class f extends a {
    public static float syS = Resources.getSystem().getDisplayMetrics().density;
    public static int syT = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static int syU = ((int) ((40.0f * syS) + 0.5f));
    public ImageView fKf;
    public OnClickListener mAD = new OnClickListener(this) {
        final /* synthetic */ f syV;

        {
            this.syV = r1;
        }

        public final void onClick(View view) {
            if (!this.syV.sxO.swv) {
                this.syV.sxO.bBT();
            }
            int gf = ((t) view.getTag()).gf();
            ka kaVar = new ka();
            if (c.bBv().wS(gf) == null) {
                w.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", new Object[]{Integer.valueOf(gf), Integer.valueOf(c.bBv().size())});
            } else if (a.bAZ().stz == null) {
                w.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
            } else {
                w.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", new Object[]{Integer.valueOf(c.bBv().wS(gf).getType())});
                kaVar.fQo.fQq = ((k) c.bBv().wS(gf)).suI;
                kaVar.fQo.context = ab.getContext();
                kaVar.fQo.type = 1;
                a.bAZ().stz.b(kaVar);
            }
        }
    };
    public WXRTEditText syK;
    public WXRTEditText syL;
    public LinearLayout syM;
    public TextView syN;
    public TextView syO;
    public ImageView syP;
    public View syQ;
    public LinearLayout syR;

    public f(View view, com.tencent.mm.plugin.wenote.model.nativenote.manager.k kVar) {
        super(view, kVar);
        this.fKf = (ImageView) view.findViewById(R.h.bKK);
        this.syQ = view.findViewById(R.h.cLE);
        this.syM = (LinearLayout) view.findViewById(R.h.coE);
        this.syR = (LinearLayout) view.findViewById(R.h.coI);
        this.syN = (TextView) view.findViewById(R.h.coF);
        this.syO = (TextView) view.findViewById(R.h.coC);
        this.syP = (ImageView) view.findViewById(R.h.coD);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.bKO);
        LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
        layoutParams.width = syT - syU;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
        this.syL = (WXRTEditText) view.findViewById(R.h.buU);
        this.syK = (WXRTEditText) view.findViewById(R.h.buW);
        ((LinearLayout) view.findViewById(R.h.buV)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ f syV;

            {
                this.syV = r1;
            }

            public final void onClick(View view) {
                this.syV.syL.bBN();
                this.syV.syL.requestFocus();
            }
        });
        ((LinearLayout) view.findViewById(R.h.buX)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ f syV;

            {
                this.syV = r1;
            }

            public final void onClick(View view) {
                this.syV.syK.bBN();
                this.syV.syK.requestFocus();
            }
        });
        this.syL.swa = 2;
        this.syK.swa = 1;
        this.syK.swc = this;
        this.syL.swc = this;
        if (kVar.swv) {
            this.syL.setKeyListener(null);
            this.syL.setEnabled(false);
            this.syL.setFocusable(false);
            this.syK.setKeyListener(null);
            this.syK.setEnabled(false);
            this.syK.setFocusable(false);
        }
        this.sxO.i(this.syK);
        this.sxO.i(this.syL);
    }

    public void a(com.tencent.mm.plugin.wenote.model.a.a aVar, int i, int i2) {
        w.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + ge());
        aVar.suw = this.syK;
        aVar.sux = this.syL;
        aVar.suy = null;
        if (!aVar.sut) {
            if (this.syK.hasFocus()) {
                this.syK.clearFocus();
            }
            if (this.syL.hasFocus()) {
                this.syL.clearFocus();
            }
        } else if (aVar.suz) {
            this.syK.requestFocus();
        } else {
            this.syL.requestFocus();
        }
        if (this.syM.getVisibility() != 0) {
            return;
        }
        if (aVar.suA) {
            this.syM.setBackgroundResource(R.g.bmf);
        } else {
            this.syM.setBackgroundResource(R.g.bme);
        }
    }
}
