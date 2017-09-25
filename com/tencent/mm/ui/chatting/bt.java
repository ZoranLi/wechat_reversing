package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;
import com.tencent.wcdb.FileUtils;

final class bt extends c {
    private a vCd;

    public bt() {
        super(3);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYx);
        view.setTag(new ds(this.knu).p(view, false));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        boolean z;
        View view;
        this.vCd = aVar2;
        aVar = (ds) aVar;
        boolean containsKey = m.GJ().hHi.containsKey(Long.valueOf(auVar.field_msgId));
        d n = n.GS().n(auVar);
        if (n == null || containsKey) {
            z = false;
        } else {
            boolean z2;
            if (m.GJ().am(n.hEY)) {
                m.d an = m.GJ().an(n.hEY);
                int i2 = (int) an.hHw;
                z2 = i2 == 0 ? true : ((int) an.hHx) == i2 && i2 != 0;
            } else {
                z2 = e.b(n);
            }
            z = z2;
        }
        f GS = n.GS();
        ImageView imageView = aVar.vyx;
        String str2 = auVar.field_imgPath;
        float density = com.tencent.mm.bg.a.getDensity(aVar2.uSU.uTo);
        int i3 = auVar.gxG;
        int i4 = auVar.gxH;
        int i5 = R.g.bdJ;
        ImageView imageView2 = aVar.vMV;
        int i6 = R.g.bdK;
        if (z) {
            view = null;
        } else {
            view = aVar.vMW;
        }
        if (!(GS.a(imageView, str2, density, i3, i4, i5, imageView2, i6, 0, view) || this.sXW)) {
            aVar.vyx.setImageDrawable(com.tencent.mm.bg.a.a(aVar2.uSU.uTo, R.g.bhS));
        }
        if (n != null || containsKey) {
            Object obj = (z || auVar.field_status == 5) ? 1 : null;
            if (containsKey) {
                aVar.vMU.setText("0%");
            } else {
                int i7;
                TextView textView = aVar.vMU;
                StringBuilder stringBuilder = new StringBuilder();
                if (n != null) {
                    i2 = n.hrs;
                    i7 = n.offset;
                    if (m.GJ().am(n.hEY)) {
                        an = m.GJ().an(n.hEY);
                        i2 = (int) an.hHw;
                        i7 = (int) an.hHx;
                    }
                    if (n.GB()) {
                        d fT = n.GS().fT(n.hFi);
                        if (m.GJ().am((long) n.hFi)) {
                            an = m.GJ().an((long) n.hFi);
                            i2 = (int) an.hHw;
                            i7 = (int) an.hHx;
                        } else {
                            i2 = fT.hrs;
                            i7 = fT.offset;
                        }
                    }
                    if (i2 > 0) {
                        i7 = i7 >= i2 ? 100 : (i7 * 100) / i2;
                        textView.setText(stringBuilder.append(i7).append("%").toString());
                    }
                }
                i7 = 0;
                textView.setText(stringBuilder.append(i7).append("%").toString());
            }
            aVar.oDJ.setVisibility(obj != null ? 8 : 0);
            aVar.vMU.setVisibility(obj != null ? 8 : 0);
            aVar.vMW.setVisibility(obj != null ? 8 : 0);
        } else {
            aVar.vMW.setVisibility(8);
            aVar.oDJ.setVisibility(8);
            aVar.vMU.setVisibility(8);
        }
        aVar.vBZ.setTag(new dt(auVar, aVar2.vxp, i, auVar.field_talker, 0, (byte) 0));
        aVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
        aVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
        aVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
        aVar.vyx.setContentDescription(aVar2.getString(R.l.dTO));
        if (ah.bUq()) {
            aVar.oDJ.setVisibility(8);
            w.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.field_status));
            if (ah.bUq()) {
                if (auVar.field_status == 2 && ah.a(aVar2.vBD, auVar.field_msgId)) {
                    if (aVar.vyy != null) {
                        aVar.vyy.setVisibility(0);
                    }
                } else if (aVar.vyy != null) {
                    aVar.vyy.setVisibility(8);
                }
            }
        }
        ah.a(i, aVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
            int i = ((dt) view.getTag()).position;
            d dVar = null;
            if (auVar.field_msgId > 0) {
                dVar = n.GS().aj(auVar.field_msgId);
            }
            if ((dVar == null || dVar.hEY <= 0) && auVar.field_msgSvrId > 0) {
                dVar = n.GS().ai(auVar.field_msgSvrId);
            }
            if (dVar.GB() && dVar.hrs == 0) {
                dVar = n.GS().fT(dVar.hFi);
            }
            contextMenu.add(i, MMGIFException.D_GIF_ERR_CLOSE_FAILED, 0, view.getContext().getString(R.l.eLH));
            if (auVar.field_status == 5) {
                contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dVm));
            }
            if (com.tencent.mm.modelbiz.e.Dp() && !this.vCd.bVJ()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dUl));
            }
            if (com.tencent.mm.bb.d.Jt("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
            }
            b ddVar = new dd();
            ddVar.fGW.fGM = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.urY.m(ddVar);
            if (ddVar.fGX.fGu || g.L(this.vCd.uSU.uTo, auVar.field_type)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dUu));
            }
            if (com.tencent.mm.bb.d.Jt("photoedit") && r0.status != -1) {
                int width;
                int height;
                MenuItem add = contextMenu.add(i, 130, 0, view.getContext().getString(R.l.dTN));
                int[] iArr = new int[2];
                if (view != null) {
                    width = view.getWidth();
                    height = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    height = 0;
                    width = 0;
                }
                Intent intent = new Intent();
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                add.setIntent(intent);
            }
            if (!auVar.bLX() && auVar.bMh() && ((auVar.field_status == 2 || auVar.gxJ == 1) && ah.ao(auVar) && ah.Tn(auVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dUx));
            }
            if (!this.vCd.bVJ()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUo));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        return false;
    }

    public final boolean a(View view, a aVar, au auVar) {
        return false;
    }

    public static void a(ah.a aVar, int i, int i2) {
        int i3 = i2 > 0 ? i >= i2 ? 100 : (int) ((((long) i) * 100) / ((long) i2)) : 0;
        ds dsVar = (ds) aVar;
        if (i3 < 100 || dsVar.vMU.getVisibility() == 0) {
            dsVar.vMU.setText(i3 + "%");
            if (ah.bUq()) {
                dsVar.oDJ.setVisibility(8);
            } else {
                dsVar.oDJ.setVisibility(0);
            }
            dsVar.vMU.setVisibility(0);
            dsVar.vMW.setVisibility(0);
        }
    }
}
