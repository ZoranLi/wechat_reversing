package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s.a.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class ej extends com.tencent.mm.ui.chatting.ah.a {
    private static SparseArray<String> vOy = new SparseArray();
    private static OnClickListener vOz = new OnClickListener() {
        public final void onClick(View view) {
            a aVar = (a) view.getTag(R.h.Kd);
            if (aVar == null || aVar.fTk == null) {
                w.w("MicroMsg.ShortVideoItemHolder", "click error");
                return;
            }
            r lH = t.lH(aVar.fTk.field_imgPath);
            if (lH == null) {
                w.w("MicroMsg.ShortVideoItemHolder", "click %s, msg id %d, but videoinfo is null", aVar.fTk.field_imgPath, Long.valueOf(aVar.fTk.field_msgId));
            } else if (aVar.vys) {
                r2 = lH.status;
                w.i("MicroMsg.ShortVideoItemHolder", "on Click, info recv status: %d", Integer.valueOf(r2));
                int i = (int) aVar.fTk.field_msgId;
                if (r2 == 199) {
                    if (aVar.vOA.AU(i)) {
                        aVar.vOA.vBD.vEW.onClick(view);
                        aVar.pwp.clear();
                        if (aVar.vOA.tD()) {
                            aVar.qZN.setVisibility(0);
                            aVar.qZN.setImageResource(R.k.dzz);
                            ej.a(view.getContext(), aVar.pwp, aVar.fTk.field_imgPath);
                            aVar.pwp.gZ(false);
                            aVar.vOA.AV(i);
                            return;
                        }
                        return;
                    }
                    aVar.qZN.setVisibility(8);
                    ej.a(aVar.pwp.bbU(), aVar.pwp, aVar.fTk.field_imgPath);
                    o.KV();
                    String lv = s.lv(aVar.fTk.field_imgPath);
                    aVar.pwp.gZ(true);
                    aVar.pwp.ak(lv, false);
                    aVar.vOA.AV(i);
                    a.a(com.tencent.mm.ui.chatting.a.a.PlayIcon, aVar.fTk);
                } else if (r2 != MMGIFException.D_GIF_ERR_IMAGE_DEFECT && r2 != 196) {
                    if (r2 == 113) {
                        t.lD(lH.getFileName());
                        aVar.pwp.gZ(true);
                        if (!aVar.vOA.AU(i)) {
                            aVar.vOA.AV(i);
                        }
                    } else if (r2 == 198) {
                        t.lF(lH.getFileName());
                        aVar.pwp.gZ(true);
                        if (!aVar.vOA.AU(i)) {
                            aVar.vOA.AV(i);
                        }
                    } else {
                        t.lD(aVar.fTk.field_imgPath);
                        aVar.pwp.gZ(true);
                        if (!aVar.vOA.AU(i)) {
                            aVar.vOA.AV(i);
                        }
                    }
                }
            } else {
                r2 = lH.status;
                w.i("MicroMsg.ShortVideoItemHolder", "info send status: %d", Integer.valueOf(r2));
                if (r2 == 104 || r2 == 103) {
                    aVar.vOA.vBD.vEW.onClick(view);
                } else if (r2 == MMGIFException.D_GIF_ERR_NO_IMAG_DSCR) {
                    t.lC(lH.getFileName());
                } else if (r2 == 198) {
                    t.lG(lH.getFileName());
                } else if (r2 == MMGIFException.D_GIF_ERR_NO_COLOR_MAP) {
                    aVar.vOA.vBD.vEW.onClick(view);
                } else if (r2 != 196) {
                    int i2 = (int) aVar.fTk.field_msgId;
                    if (aVar.vOA.AU(i2)) {
                        aVar.pwp.clear();
                        aVar.vOA.vBD.vEW.onClick(view);
                        if (aVar.vOA.tD()) {
                            aVar.qZN.setVisibility(0);
                            aVar.qZN.setImageResource(R.k.dzz);
                            ej.a(view.getContext(), aVar.pwp, aVar.fTk.field_imgPath);
                            aVar.pwp.gZ(false);
                            aVar.vOA.AV(i2);
                            return;
                        }
                        return;
                    }
                    aVar.qZN.setVisibility(8);
                    ej.a(aVar.pwp.bbU(), aVar.pwp, aVar.fTk.field_imgPath);
                    o.KV();
                    String lv2 = s.lv(aVar.fTk.field_imgPath);
                    aVar.pwp.gZ(true);
                    aVar.pwp.ak(lv2, false);
                    aVar.vOA.AV(i2);
                    a.a(com.tencent.mm.ui.chatting.a.a.PlayIcon, aVar.fTk);
                }
            }
        }
    };
    public static Map<String, WeakReference<ej>> vyC = new HashMap();
    ImageView qjB;
    MMPinProgressBtn qxE;

    private static class a {
        au fTk;
        com.tencent.mm.plugin.sight.decode.a.a pwp;
        ImageView qZN;
        com.tencent.mm.ui.chatting.En_5b8fbb1e.a vOA;
        boolean vys;
    }

    public static boolean b(com.tencent.mm.modelvideo.s.a.a aVar) {
        if (aVar.iaF != b.iaJ) {
            return false;
        }
        final r lH = t.lH(aVar.fyF);
        if (lH == null) {
            w.w("MicroMsg.ShortVideoItemHolder", "update status, filename %s, videoInfo not found", aVar.fyF);
            return false;
        } else if (lH.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT && lH.status != 104 && lH.status != 103) {
            return false;
        } else {
            af.v(new Runnable() {
                public final void run() {
                    WeakReference weakReference = (WeakReference) ej.vyC.get(lH.getFileName());
                    if (weakReference == null) {
                        w.w("MicroMsg.ShortVideoItemHolder", "update status, filename %s, holder not found", lH.getFileName());
                        return;
                    }
                    ej ejVar = (ej) weakReference.get();
                    if (ejVar == null) {
                        w.w("MicroMsg.ShortVideoItemHolder", "update status, filename %s, holder gc!", lH.getFileName());
                        return;
                    }
                    ejVar.qxE.setVisibility(0);
                    ejVar.qjB.setVisibility(8);
                    if (lH.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                        ejVar.qxE.setProgress(t.f(lH));
                    } else {
                        ejVar.qxE.setProgress(t.g(lH));
                    }
                }
            });
            return true;
        }
    }

    public static void a(Context context, com.tencent.mm.plugin.sight.decode.a.a aVar, String str) {
        ap.yY();
        if (c.isSDCardAvailable()) {
            o.KV();
            Bitmap a = n.GS().a(s.lw(str), com.tencent.mm.bg.a.getDensity(context), context, -1);
            aVar.bbR();
            aVar.y(a);
            return;
        }
        aVar.bbS();
    }
}
