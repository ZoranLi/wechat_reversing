package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s.a.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.chatting.ah.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class en extends a {
    private static SparseArray<String> vOy = new SparseArray();
    public static Map<String, WeakReference<en>> vyC = new HashMap();
    TextView oDc;
    ImageView qjB;
    ImageView vMV;
    TextView vOD;
    MMPinProgressBtn vOE;
    View vOF;
    ProgressBar vOG;
    TextView vyE;
    ImageView vyR;
    ImageView vyS;
    ImageView vyx;
    ImageView vyy;

    public static boolean b(s.a.a aVar) {
        if (aVar.iaF != b.iaJ) {
            return false;
        }
        final r lH = t.lH(aVar.fyF);
        if (lH == null) {
            w.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", aVar.fyF);
            return false;
        } else if (lH.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT && lH.status != 104 && lH.status != 103) {
            return false;
        } else {
            af.v(new Runnable() {
                public final void run() {
                    WeakReference weakReference = (WeakReference) en.vyC.get(lH.getFileName());
                    if (weakReference == null) {
                        w.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", lH.getFileName());
                        return;
                    }
                    en enVar = (en) weakReference.get();
                    if (enVar == null) {
                        w.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", lH.getFileName());
                        return;
                    }
                    enVar.vyR.setVisibility(8);
                    enVar.qjB.setVisibility(8);
                    enVar.vOE.setVisibility(0);
                    int i = lH.status;
                    w.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : " + i);
                    if (i == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || i == 122 || i == 120) {
                        enVar.vOE.setProgress(t.f(lH));
                    } else {
                        enVar.vOE.setProgress(t.g(lH));
                    }
                }
            });
            return true;
        }
    }

    public en(int i) {
        super(i);
    }

    public final a p(View view, boolean z) {
        ImageView imageView;
        ProgressBar progressBar;
        super.dn(view);
        this.kxi = (TextView) view.findViewById(R.h.bBA);
        this.vyx = (ImageView) view.findViewById(R.h.bAj);
        this.piH = (TextView) view.findViewById(R.h.bBG);
        this.oDc = (TextView) view.findViewById(R.h.bBu);
        this.vOD = (TextView) view.findViewById(R.h.bAP);
        this.qjB = (ImageView) view.findViewById(R.h.bBx);
        this.vyR = (ImageView) view.findViewById(R.h.bAn);
        this.vyS = (ImageView) view.findViewById(R.h.bBz);
        this.vOE = (MMPinProgressBtn) view.findViewById(R.h.bAr);
        this.vOF = view.findViewById(R.h.bBI);
        this.vBZ = view.findViewById(R.h.bAe);
        this.type = z ? 10 : 11;
        this.vyE = (TextView) view.findViewById(R.h.bzy);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        this.vMV = (ImageView) view.findViewById(R.h.bAl);
        if (z) {
            imageView = null;
        } else {
            imageView = (ImageView) view.findViewById(R.h.bBy);
        }
        this.vyy = imageView;
        if (z) {
            progressBar = null;
        } else {
            progressBar = (ProgressBar) view.findViewById(R.h.bBJ);
        }
        this.vOG = progressBar;
        return this;
    }

    public static void a(en enVar, au auVar, boolean z, int i, En_5b8fbb1e.a aVar, int i2) {
        int fromDPToPix;
        String str = (String) vOy.get(enVar.hashCode());
        if (str != null) {
            vyC.remove(str);
        }
        vOy.put(enVar.hashCode(), auVar.field_imgPath);
        vyC.put(auVar.field_imgPath, new WeakReference(enVar));
        r lH = t.lH(auVar.field_imgPath);
        if (lH == null) {
            lH = new r();
        }
        o.KV();
        Bitmap a = n.GS().a(s.lw(auVar.field_imgPath), com.tencent.mm.bg.a.getDensity(aVar.uSU.uTo), aVar.uSU.uTo, i2);
        enVar.vMV.setLayoutParams(new LayoutParams(0, 0));
        if (a == null) {
            fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(aVar.uSU.uTo, 85);
            int T = com.tencent.mm.bg.a.T(aVar.uSU.uTo, R.f.aWH);
            Bitmap a2 = d.a(d.U(aVar.uSU.uTo.getResources().getColor(R.e.aUi), fromDPToPix, T), i2, fromDPToPix, T);
            ap.yY();
            if (c.isSDCardAvailable()) {
                enVar.vyx.setImageBitmap(d.a(a2, i2, fromDPToPix, T));
            } else {
                enVar.vyx.setImageDrawable(com.tencent.mm.bg.a.a(aVar.uSU.uTo, R.k.dAr));
                enVar.vyx.setBackground(new BitmapDrawable(a2));
            }
            enVar.vMV.setLayoutParams(new LayoutParams(fromDPToPix, T));
        } else {
            enVar.vyx.setImageBitmap(a);
            enVar.vMV.setLayoutParams(new LayoutParams(a.getWidth(), a.getHeight()));
        }
        if (z) {
            enVar.oDc.setText(u.ay((long) lH.hrs));
            enVar.vOD.setText(u.hb(lH.iap));
            fromDPToPix = lH.status;
            w.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + fromDPToPix + " info : " + lH.getFileName());
            if (fromDPToPix == 199) {
                enVar.qjB.setImageDrawable(com.tencent.mm.bg.a.a(aVar.uSU.uTo, R.k.dzz));
            } else {
                enVar.qjB.setImageDrawable(com.tencent.mm.bg.a.a(aVar.uSU.uTo, R.k.dzz));
                enVar.oDc.setVisibility(8);
            }
            if (fromDPToPix == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || fromDPToPix == 122 || fromDPToPix == 120) {
                enVar.vyR.setVisibility(8);
                enVar.qjB.setVisibility(8);
                enVar.vOE.setVisibility(0);
                enVar.vOE.setProgress(t.f(lH));
                w.v("MicroMsg.VideoItemHoder", "status begin");
                enVar.vOE.invalidate();
            } else if (fromDPToPix == 113 || fromDPToPix == 198 || lH.Li()) {
                enVar.vyR.setVisibility(0);
                enVar.vyS.setVisibility(8);
                enVar.vOE.setVisibility(8);
                enVar.qjB.setVisibility(0);
                w.v("MicroMsg.VideoItemHoder", "status pause");
            } else {
                enVar.vyS.setVisibility(8);
                enVar.vyR.setVisibility(8);
                enVar.vOE.setVisibility(8);
                enVar.qjB.setVisibility(0);
                w.v("MicroMsg.VideoItemHoder", "status gone");
            }
        } else {
            enVar.oDc.setText(u.ay((long) lH.hrs));
            enVar.vOD.setText(u.hb(lH.iap));
            fromDPToPix = lH.status;
            enVar.qjB.setImageDrawable(com.tencent.mm.bg.a.a(aVar.uSU.uTo, R.k.dzz));
            if (enVar.vOG != null) {
                enVar.vOG.setVisibility(8);
            }
            w.v("MicroMsg.VideoItemHoder", "video status %d", Integer.valueOf(fromDPToPix));
            if (fromDPToPix == 104 || fromDPToPix == 103) {
                if (com.tencent.mm.plugin.mmsight.c.pz(lH.iaq)) {
                    if (enVar.vOG != null) {
                        enVar.vOG.setVisibility(0);
                    }
                    enVar.vOD.setText(null);
                    enVar.oDc.setText(null);
                    enVar.qjB.setImageDrawable(null);
                    enVar.vyS.setVisibility(8);
                    enVar.vyR.setVisibility(8);
                    enVar.vOE.setVisibility(8);
                } else {
                    enVar.vOG.setVisibility(8);
                    enVar.vyR.setVisibility(8);
                    enVar.qjB.setVisibility(8);
                    enVar.vOE.setVisibility(0);
                    enVar.vOE.setProgress(t.g(lH));
                }
                w.v("MicroMsg.VideoItemHoder", "status begin");
            } else if (fromDPToPix == MMGIFException.D_GIF_ERR_NO_IMAG_DSCR || fromDPToPix == 198 || lH.Li()) {
                enVar.vyR.setVisibility(0);
                enVar.vyS.setVisibility(8);
                enVar.vOE.setVisibility(8);
                enVar.qjB.setVisibility(0);
                w.v("MicroMsg.VideoItemHoder", "status pause");
            } else if (fromDPToPix != MMGIFException.D_GIF_ERR_NO_COLOR_MAP) {
                enVar.vyS.setVisibility(8);
                enVar.vyR.setVisibility(8);
                enVar.vOE.setVisibility(8);
                enVar.qjB.setVisibility(0);
                w.v("MicroMsg.VideoItemHoder", "status gone");
            } else if (j.LS(auVar.field_imgPath)) {
                if (enVar.vOG != null) {
                    enVar.vOG.setVisibility(0);
                }
                enVar.vOD.setText(null);
                enVar.oDc.setText(null);
                enVar.qjB.setImageDrawable(null);
                enVar.vyS.setVisibility(8);
                enVar.vyR.setVisibility(8);
                enVar.vOE.setVisibility(8);
            } else {
                t.lA(auVar.field_imgPath);
            }
        }
        enVar.vyS.setTag(new dt(auVar, aVar.vxp, i, auVar.field_talker, 4, (byte) 0));
        enVar.vyS.setOnClickListener(aVar.vBD.vEW);
        enVar.vyR.setTag(new dt(auVar, aVar.vxp, i, auVar.field_talker, 3, (byte) 0));
        enVar.vyR.setOnClickListener(aVar.vBD.vEW);
        enVar.vBZ.setTag(new dt(auVar, aVar.vxp, i, auVar.field_talker, 2, (byte) 0));
        enVar.vBZ.setOnClickListener(aVar.vBD.vEW);
        enVar.vBZ.setOnLongClickListener(aVar.vBD.vEY);
        enVar.vBZ.setOnTouchListener(aVar.vBD.vFa);
    }
}
