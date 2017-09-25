package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMGridPaper;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    private Context mContext = null;
    private i ncG = null;
    private MMGridPaper ncH = null;
    private a ncI = null;
    private ViewGroup ncJ = null;
    private RelativeLayout ncK = null;
    private ArrayList<String> ncL = null;
    private int ncM = 0;

    private b(Context context) {
        this.mContext = context;
        this.ncG = new i(this.mContext, R.m.foQ);
        this.ncJ = (ViewGroup) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.cVb, null);
        this.ncH = (MMGridPaper) this.ncJ.findViewById(R.h.bJq);
        this.ncH.bRZ();
        this.ncH.bRX();
        this.ncH.bRY();
        this.ncH.bRW();
        this.ncH.Ai(3);
        this.ncH.bSa();
        this.ncH.bRZ();
        this.ncH.bRU();
        this.ncH.bRV();
        this.ncG.setCanceledOnTouchOutside(true);
        this.ncG.setContentView(this.ncJ);
        this.ncI = new a();
        this.ncH.a(this.ncI);
    }

    public static void b(Context context, ArrayList<String> arrayList) {
        w.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", new Object[]{Integer.valueOf(arrayList.size())});
        b bVar = new b(context);
        bVar.ncL = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bVar.ncL.add((String) it.next());
        }
        if (bVar.ncL.size() < 3) {
            bVar.ncH.Ai(bVar.ncL.size());
        } else {
            bVar.ncH.Ai(3);
        }
        LayoutParams layoutParams = bVar.ncH.getLayoutParams();
        bVar.ncM = a.fromDPToPix(bVar.mContext, 70);
        int fromDPToPix = a.fromDPToPix(bVar.mContext, 8);
        if (bVar.ncL.size() <= 0) {
            fromDPToPix = 0;
        } else if (bVar.ncL.size() < 3) {
            fromDPToPix = (fromDPToPix * (bVar.ncL.size() - 1)) + (bVar.ncM * bVar.ncL.size());
        } else {
            fromDPToPix = (fromDPToPix * 2) + (bVar.ncM * 3);
        }
        String dV = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.dV(bVar.mContext);
        w.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", new Object[]{Integer.valueOf(fromDPToPix), Integer.valueOf(bVar.ncL.size()), Integer.valueOf(bVar.ncM), dV});
        layoutParams.width = fromDPToPix;
        bVar.ncM = a.fromDPToPix(bVar.mContext, 70);
        fromDPToPix = a.fromDPToPix(bVar.mContext, 15);
        if (bVar.ncL.size() > 0) {
            if (bVar.ncL.size() <= 3) {
                fromDPToPix += bVar.ncM;
            } else if (bVar.ncL.size() <= 6) {
                fromDPToPix += bVar.ncM * 2;
            } else {
                fromDPToPix = ((fromDPToPix * 2) + (bVar.ncM * 3)) + a.fromDPToPix(bVar.mContext, 10);
            }
            w.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", new Object[]{Integer.valueOf(fromDPToPix)});
        } else {
            fromDPToPix = 0;
        }
        layoutParams.height = fromDPToPix;
        bVar.ncH.setLayoutParams(layoutParams);
        bVar.ncH.requestLayout();
        bVar.ncI.G(bVar.ncL);
        bVar.ncG.show();
    }
}
