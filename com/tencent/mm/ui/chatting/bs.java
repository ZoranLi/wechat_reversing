package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.wcdb.FileUtils;

final class bs extends b {
    a vCd;

    public bs() {
        super(1);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXU);
        view.setTag(new ds(this.knu).p(view, true));
        return view;
    }

    protected final String a(a aVar, au auVar) {
        return super.a(aVar, auVar);
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        aVar2.aH(auVar);
        ds dsVar = (ds) aVar;
        boolean a = n.GS().a(dsVar.vyx, auVar.field_imgPath, com.tencent.mm.bg.a.getDensity(aVar2.uSU.uTo), auVar.gxG, auVar.gxH, R.g.bdH, dsVar.vMV, R.g.bdI, 1, null);
        dsVar.vMW.setVisibility(0);
        dsVar.oDJ.setVisibility(8);
        if (!(a || this.sXW)) {
            dsVar.vyx.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), R.g.bhS));
        }
        String str2 = null;
        if (aVar2.vxp) {
            str2 = auVar.field_talker;
        }
        dsVar.vBZ.setTag(new dt(auVar, aVar2.vxp, i, str, str2));
        dsVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
        dsVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
        dsVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
        if (auVar.field_content == null || auVar.field_content.length() == 0) {
            dsVar.vyE.setVisibility(8);
        } else {
            dsVar.vyE.setVisibility(8);
        }
    }

    protected final boolean a(a aVar) {
        return aVar.vxp;
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ap.yY();
        if (!(!c.isSDCardAvailable() || view == null || auVar == null)) {
            int i = ((dt) view.getTag()).position;
            d dVar = null;
            if (auVar.field_msgId > 0) {
                dVar = n.GS().aj(auVar.field_msgId);
            }
            if ((dVar == null || dVar.hEY <= 0) && auVar.field_msgSvrId > 0) {
                dVar = n.GS().ai(auVar.field_msgSvrId);
            }
            contextMenu.add(i, MMGIFException.D_GIF_ERR_CLOSE_FAILED, 0, view.getContext().getString(R.l.eLH));
            if (e.Dp() && !this.vCd.bVJ()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dUl));
            }
            if (com.tencent.mm.bb.d.Jt("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
            }
            com.tencent.mm.sdk.b.b ddVar = new dd();
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
}
