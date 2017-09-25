package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.ao.o;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class a extends b {
    private View jIM = null;
    public b weD;
    public int weE = 0;
    private d weF;
    public a weG;

    public interface a {
        void Jk(String str);

        void eV(String str, String str2);
    }

    public a(Context context) {
        super(context);
        if (this.view != null) {
            this.jIM = this.view.findViewById(R.h.bnS);
            this.weF = new d();
            this.weF.weK = this.jIM;
            this.weF.weL = (Button) this.view.findViewById(R.h.bnn);
            this.weF.weL.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a weH;

                {
                    this.weH = r1;
                }

                public final void onClick(View view) {
                    if (this.weH.weD != null && this.weH.weG != null) {
                        this.weH.weG.Jk(this.weH.weD.BQ(this.weH.weE).weJ.id);
                    }
                }
            });
            this.jIM.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a weH;

                {
                    this.weH = r1;
                }

                public final void onClick(View view) {
                    if (this.weH.weD != null && this.weH.weG != null) {
                        c BQ = this.weH.weD.BQ(this.weH.weE);
                        this.weH.weG.eV(BQ.weJ.id, BQ.weJ.url);
                    }
                }
            });
        }
    }

    public final int getLayoutId() {
        return R.i.cTI;
    }

    public final void destroy() {
        ap.yY();
        c.vr().b(this.weD);
    }

    public final void setVisibility(int i) {
        if (this.jIM != null) {
            this.jIM.setVisibility(i);
        }
    }

    public final void release() {
        this.weD = null;
    }

    public final boolean Xj() {
        this.weD = new b((Context) this.sNB.get());
        this.weG = new a(this) {
            final /* synthetic */ a weH;

            {
                this.weH = r1;
            }

            public final void eV(String str, String str2) {
                com.tencent.mm.pluginsdk.l.a.a.bDJ();
                ap.yY();
                c.wQ().b(new o(2, str));
                w.d("MicroMsg.ADBanner", "jump to " + str2);
                com.tencent.mm.pluginsdk.l.a.sBA.a((Context) this.weH.sNB.get(), str2, true);
            }

            public final void Jk(String str) {
                com.tencent.mm.pluginsdk.l.a.a.bDJ();
                ap.yY();
                c.wQ().b(new o(3, str));
            }
        };
        com.tencent.mm.pluginsdk.l.a.a dB = com.tencent.mm.pluginsdk.l.a.a.dB(ab.getContext());
        if (this.weD != null) {
            if (dB != null) {
                this.weD.weI = dB;
                this.weD.OK();
                int i = (this.weD == null || this.weD.getCount() <= 0 || this.weD.BQ(0).a(this.weF) != 0) ? 0 : 1;
                if (i != 0) {
                    w.i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
                    setVisibility(0);
                    return true;
                }
            }
            setVisibility(8);
        }
        setVisibility(8);
        return false;
    }
}
