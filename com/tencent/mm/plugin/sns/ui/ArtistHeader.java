package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.dl;
import com.tencent.mm.ui.base.i;

public class ArtistHeader extends LinearLayout implements b {
    Context context = null;
    private i lON = null;
    private View nRW;
    dl qpo = null;
    a qpt;
    private ImageView qpu;
    private ProgressBar qpv;

    class a {
        ImageView ioV;
        TextView ioX;
        TextView mVG;
        final /* synthetic */ ArtistHeader qpw;
        TextView qpy;
        TextView qpz;

        a(ArtistHeader artistHeader) {
            this.qpw = artistHeader;
        }
    }

    public ArtistHeader(Context context) {
        super(context);
        init(context);
    }

    public ArtistHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(g.pHm, this, true);
        this.context = context;
        this.qpt = new a(this);
        this.qpt.ioV = (ImageView) inflate.findViewById(f.pBK);
        this.qpt.mVG = (TextView) inflate.findViewById(f.pAx);
        this.qpt.qpy = (TextView) inflate.findViewById(f.pAA);
        this.qpt.qpz = (TextView) inflate.findViewById(f.pAy);
        this.qpt.ioX = (TextView) inflate.findViewById(f.pAz);
        this.qpt.ioV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ArtistHeader qpw;

            {
                this.qpw = r1;
            }

            public final void onClick(View view) {
                if ((this.qpw.lON == null || !this.qpw.lON.isShowing()) && this.qpw.qpo != null) {
                    View inflate = LayoutInflater.from(this.qpw.getContext()).inflate(g.dpx, null);
                    this.qpw.lON = new i(this.qpw.getContext(), k.pNf);
                    inflate.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 qpx;

                        {
                            this.qpx = r1;
                        }

                        public final void onClick(View view) {
                            this.qpx.qpw.lON.dismiss();
                        }
                    });
                    this.qpw.lON.setCanceledOnTouchOutside(true);
                    this.qpw.lON.setContentView(inflate);
                    this.qpw.lON.show();
                    this.qpw.qpu = (ImageView) inflate.findViewById(f.bVP);
                    this.qpw.qpv = (ProgressBar) inflate.findViewById(f.bVQ);
                    this.qpw.nRW = inflate.findViewById(f.bVR);
                }
            }
        });
    }

    public final void ES(String str) {
    }

    public final void ao(String str, boolean z) {
        if (this.qpo != null && this.lON != null && this.lON.isShowing() && !z) {
            alh com_tencent_mm_protocal_c_alh = this.qpo.tgU.tgV;
            if (com_tencent_mm_protocal_c_alh.mQY != null && com_tencent_mm_protocal_c_alh.mQY.equals(str)) {
                Toast.makeText(this.context, this.context.getString(j.pKI), 0).show();
            }
        }
    }

    public final void ap(String str, boolean z) {
    }

    public final void bdD() {
    }
}
