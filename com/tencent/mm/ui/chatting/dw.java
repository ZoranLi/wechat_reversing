package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.hn;
import com.tencent.mm.e.a.ik;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ah.a;

final class dw extends a {
    LinearLayout suS;
    TextView suU;
    TextView suV;
    ProgressBar suW;
    ImageView suX;
    ProgressBar suY;
    ImageView suZ;
    ImageView vyy;

    public dw(int i) {
        super(i);
    }

    public final a p(View view, boolean z) {
        super.dn(view);
        this.kxi = (TextView) view.findViewById(R.h.bBA);
        this.suV = (TextView) view.findViewById(R.h.bAT);
        this.suU = (TextView) view.findViewById(R.h.bAV);
        this.suS = (LinearLayout) view.findViewById(R.h.bAU);
        this.suW = (ProgressBar) view.findViewById(R.h.bAQ);
        this.vBZ = view.findViewById(R.h.bAe);
        this.piH = (TextView) view.findViewById(R.h.bBG);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        this.suX = (ImageView) view.findViewById(R.h.bAS);
        this.suY = (ProgressBar) view.findViewById(R.h.bAR);
        this.suZ = (ImageView) view.findViewById(R.h.bAm);
        this.type = z ? 16 : 17;
        if (!z) {
            this.vyK = (ImageView) view.findViewById(R.h.bBw);
            this.vyy = (ImageView) view.findViewById(R.h.bBy);
        }
        this.suU.setTextSize(1, 16.0f);
        this.suV.setTextSize(1, 12.0f);
        return this;
    }

    public static void a(dw dwVar, au auVar, boolean z, int i, En_5b8fbb1e.a aVar) {
        if (dwVar != null) {
            b ikVar;
            Object obj;
            dwVar.suS.setVisibility(8);
            int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(aVar.uSU.uTo, JsApiGetSetting.CTRL_INDEX);
            int fromDPToPix2 = com.tencent.mm.bg.a.fromDPToPix(aVar.uSU.uTo, 90);
            dwVar.suU.setMaxLines(1);
            dwVar.suV.setMaxLines(1);
            dwVar.suV.setText("");
            if (d.Jt("location")) {
                w.d("MicroMsg.LocationItemHolder", "plugin found!");
                ikVar = new ik();
                ikVar.fOe.fNZ = 1;
                ikVar.fOe.fCZ = auVar;
                com.tencent.mm.sdk.b.a.urY.m(ikVar);
                CharSequence charSequence = ikVar.fOf.fOh;
                CharSequence charSequence2 = ikVar.fOf.fOi;
                if ((charSequence != null || a(charSequence2, aVar)) && ((charSequence == null || !charSequence.equals("") || a(charSequence2, aVar)) && (charSequence == null || !charSequence.equals("err_not_started")))) {
                    dwVar.suY.setVisibility(8);
                    dwVar.suS.setVisibility(0);
                    w.d("MicroMsg.LocationItemHolder", "location info : " + charSequence);
                    if (a(charSequence2, aVar)) {
                        dwVar.suU.setVisibility(0);
                        dwVar.suU.setText(charSequence2);
                        if (charSequence == null || charSequence.equals("")) {
                            dwVar.suV.setVisibility(8);
                        } else {
                            dwVar.suV.setVisibility(0);
                            dwVar.suV.setText(charSequence);
                        }
                    } else {
                        dwVar.suU.setMaxLines(2);
                        dwVar.suU.setText(charSequence);
                        dwVar.suV.setVisibility(8);
                    }
                } else {
                    w.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
                    dwVar.suY.setVisibility(0);
                    dwVar.suS.setVisibility(0);
                    dwVar.suU.setText("");
                    dwVar.suV.setText("");
                }
            } else {
                dwVar.suW.setVisibility(0);
                dwVar.suS.setVisibility(8);
            }
            ImageView imageView = dwVar.suX;
            f GS = n.GS();
            int i2 = R.g.bgl;
            int i3 = R.g.bgU;
            if (z) {
                obj = "location_backgroup_key_from";
            } else {
                String str = "location_backgroup_key_tor";
            }
            Bitmap bitmap = (Bitmap) GS.hFF.get(obj);
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = com.tencent.mm.sdk.platformtools.d.s(i2, i3, fromDPToPix, fromDPToPix2);
                GS.hFF.k(obj, bitmap);
            }
            imageView.setImageBitmap(bitmap);
            ikVar = new hn();
            ikVar.fMW.fCZ = auVar;
            ikVar.fMW.w = fromDPToPix;
            ikVar.fMW.h = fromDPToPix2;
            ikVar.fMW.fNb = R.g.bgU;
            ikVar.fMW.fMY = dwVar.suX;
            ikVar.fMW.fNa = dwVar.suW;
            ikVar.fMW.fMZ = dwVar.suZ;
            com.tencent.mm.sdk.b.a.urY.m(ikVar);
            dwVar.vBZ.setTag(new dt(auVar, aVar.vxp, i, null, 0, (byte) 0));
            dwVar.vBZ.setOnClickListener(aVar.vBD.vEW);
            dwVar.vBZ.setOnLongClickListener(aVar.vBD.vEY);
            dwVar.vBZ.setOnTouchListener(aVar.vBD.vFa);
        }
    }

    private static boolean a(String str, En_5b8fbb1e.a aVar) {
        return (str == null || str.equals("") || str.equals(aVar.getString(R.l.ewy))) ? false : true;
    }
}
