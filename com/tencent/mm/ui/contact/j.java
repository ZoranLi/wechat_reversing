package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class j extends LinearLayout {
    private Context context;
    private String huj;

    public j(Context context, String str) {
        super(context);
        this.context = context;
        this.huj = str;
        View inflate = View.inflate(getContext(), R.i.dba, this);
        View findViewById = findViewById(R.h.bMj);
        inflate.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ j vXF;

            {
                this.vXF = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("enterprise_from_scene", 2);
                intent.putExtra("enterprise_biz_name", this.vXF.huj);
                d.b(view.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", intent);
            }
        });
        findViewById.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ j vXF;

            {
                this.vXF = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.vXF.context instanceof MMActivity) {
                    ((MMActivity) this.vXF.context).aHf();
                }
                return false;
            }
        });
        ap.yY();
        af Ra = c.wR().Ra(this.huj);
        if (Ra == null || ((int) Ra.gTQ) <= 0) {
            w.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", this.huj);
            return;
        }
        MaskLayout maskLayout = (MaskLayout) findViewById.findViewById(R.h.btI);
        b.a((ImageView) maskLayout.view, this.huj);
        if (Ra.field_verifyFlag == 0) {
            maskLayout.bSG();
        } else if (a.hlU != null) {
            String eZ = a.hlU.eZ(Ra.field_verifyFlag);
            if (eZ != null) {
                maskLayout.d(l.ik(eZ), MaskLayout.a.vnV);
            } else {
                maskLayout.bSG();
            }
        } else {
            maskLayout.bSG();
        }
        ((TextView) findViewById(R.h.bMk)).setText(Ra.tK());
    }
}
