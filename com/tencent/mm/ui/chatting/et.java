package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ah.a;

final class et extends a {
    TextView suV;
    View vPm = null;

    public et(int i) {
        super(i);
    }

    public final a du(View view) {
        super.dn(view);
        if (this.type == 24 || this.type == 43 || this.type == 27 || this.type == 28) {
            this.kxi = (TextView) view.findViewById(R.h.bBA);
            this.suV = (TextView) view.findViewById(R.h.bCb);
            this.vBZ = view.findViewById(R.h.bAe);
            this.vPm = view.findViewById(R.h.bCa);
        }
        if (this.type == 24) {
            this.vyK = (ImageView) view.findViewById(R.h.bBw);
        }
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        return this;
    }

    public static void a(et etVar, au auVar, boolean z, int i, En_5b8fbb1e.a aVar) {
        int i2 = 0;
        if (etVar != null) {
            if (etVar.vyK != null) {
                etVar.vyK.setVisibility(auVar.field_status == 6 ? 8 : 0);
            }
            etVar.vBZ.setTag(new dt(auVar, aVar.vxp, i, null, 0, (byte) 0));
            etVar.vBZ.setOnClickListener(aVar.vBD.vEW);
            etVar.vBZ.setOnLongClickListener(aVar.vBD.vEY);
            etVar.vBZ.setOnTouchListener(aVar.vBD.vFa);
            CharSequence charSequence = auVar.gxF;
            if (!bg.mA(charSequence)) {
                etVar.suV.setText(charSequence);
            } else if (z) {
                etVar.suV.setText(R.l.fbg);
            } else {
                etVar.suV.setText(R.l.fbh);
            }
            if (etVar.vPm != null) {
                if (!auVar.field_content.equals(au.uJQ)) {
                    int i3;
                    String str = auVar.field_content;
                    b rrVar = new rr();
                    rrVar.fYI.fJK = 1;
                    rrVar.fYI.content = str;
                    com.tencent.mm.sdk.b.a.urY.m(rrVar);
                    if (rrVar.fYJ.type == 3) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (i3 == 0) {
                        if (!auVar.field_content.equals(au.uJR)) {
                            str = auVar.field_content;
                            rrVar = new rr();
                            rrVar.fYI.fJK = 1;
                            rrVar.fYI.content = str;
                            com.tencent.mm.sdk.b.a.urY.m(rrVar);
                            if (rrVar.fYJ.type == 2) {
                                i2 = 1;
                            }
                            if (i2 == 0) {
                                return;
                            }
                        }
                        if (z) {
                            etVar.vPm.setBackgroundResource(R.k.dAw);
                            return;
                        } else {
                            etVar.vPm.setBackgroundResource(R.k.dAx);
                            return;
                        }
                    }
                }
                if (z) {
                    etVar.vPm.setBackgroundResource(R.k.dAy);
                } else {
                    etVar.vPm.setBackgroundResource(R.k.dAz);
                }
            }
        }
    }
}
