package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.ScrollAlwaysTextView;

public final class a extends b {
    private c iOT;
    private ScrollAlwaysTextView nUL;

    public a(Context context) {
        super(context);
        if (this.view != null) {
            this.nUL = (ScrollAlwaysTextView) this.view.findViewById(R.h.clV);
            this.view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a nUM;

                {
                    this.nUM = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    g.oUh.i(11992, new Object[]{Integer.valueOf(1)});
                    intent.putExtra("key_scene", 1);
                    d.b((Context) this.nUM.sNB.get(), "music", ".ui.MusicMainUI", intent);
                }
            });
        }
        this.iOT = new c<jc>(this) {
            final /* synthetic */ a nUM;

            {
                this.nUM = r2;
                this.usg = jc.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                switch (((jc) bVar).fPc.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        this.nUM.aOp();
                        break;
                }
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.urY.b(this.iOT);
    }

    public final int getLayoutId() {
        return R.i.clW;
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(R.h.clW).setVisibility(i);
        }
    }

    public final boolean Xj() {
        return aOp();
    }

    public final void destroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.iOT);
    }

    public final boolean aOp() {
        int i = 8;
        if (com.tencent.mm.am.b.HJ()) {
            anf HL = com.tencent.mm.am.b.HL();
            CharSequence charSequence = ab.getContext().getString(R.l.eCz) + ab.getContext().getString(R.l.eCA) + HL.tRJ;
            if (this.nUL != null) {
                this.nUL.setText(charSequence);
            }
            if (!HL.tSa) {
                i = 0;
            }
            setVisibility(i);
            if (HL.tSa) {
                return false;
            }
            return true;
        }
        com.tencent.mm.sdk.b.b jbVar = new jb();
        jbVar.fOW.action = 10;
        com.tencent.mm.sdk.b.a.urY.m(jbVar);
        if (jbVar.fOX.fDU) {
            setVisibility(0);
            return true;
        }
        setVisibility(8);
        return false;
    }

    public final int getOrder() {
        return 1;
    }
}
