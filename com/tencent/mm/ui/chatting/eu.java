package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ah.a;

final class eu extends a {
    TextView suV;

    public eu(int i) {
        super(i);
    }

    public final a du(View view) {
        super.dn(view);
        if (this.type == 39) {
            this.kxi = (TextView) view.findViewById(R.h.bBA);
            this.suV = (TextView) view.findViewById(R.h.bCb);
            this.vBZ = view.findViewById(R.h.bAe);
        } else {
            this.kxi = (TextView) view.findViewById(R.h.bBA);
        }
        if (this.type == 39) {
            this.vyK = (ImageView) view.findViewById(R.h.bBw);
        }
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        return this;
    }

    public static void a(eu euVar, au auVar, int i, En_5b8fbb1e.a aVar) {
        if (euVar != null) {
            euVar.vBZ.setTag(new dt(auVar, aVar.vxp, i, null, 0, (byte) 0));
            euVar.vBZ.setOnClickListener(aVar.vBD.vEW);
            euVar.vBZ.setOnLongClickListener(aVar.vBD.vEY);
            euVar.vBZ.setOnTouchListener(aVar.vBD.vFa);
        }
    }
}
