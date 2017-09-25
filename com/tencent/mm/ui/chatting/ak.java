package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;

final class ak extends c {
    private a vCd;

    public ak() {
        super(64);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof f) && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYm);
        view.setTag(new f(this.knu).dh(view));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        f.a B;
        this.vCd = aVar2;
        String str2 = auVar.field_content;
        if (str2 != null) {
            B = f.a.B(str2, auVar.field_reserved);
        } else {
            B = null;
        }
        f fVar = (f) aVar;
        if (B != null) {
            fVar.vyo.setText(auVar.field_isSend == 1 ? B.hiR : B.hiS);
        }
        aVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
        aVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
        aVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
        aVar.vBZ.setTag(new dt(auVar, this.vCd.vxp, i, null, 0, (byte) 0));
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((dt) view.getTag()).position, 100, 0, this.vCd.getString(R.l.dUp));
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                ay.L(auVar.field_msgId);
                return true;
            default:
                return false;
        }
    }

    public final boolean a(View view, a aVar, au auVar) {
        String str = auVar.field_content;
        if (str != null) {
            f.a B = f.a.B(str, auVar.field_reserved);
            if (!bg.mA(B.hiW)) {
                Intent intent = new Intent();
                intent.putExtra("key_native_url", B.hiW);
                intent.putExtra("key_image_id", B.hiZ);
                intent.putExtra("key_image_aes_key", B.hja);
                intent.putExtra("key_image_length", B.hjb);
                intent.putExtra("key_username", aVar.bUg());
                d.b(aVar.uSU.uTo, "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
            }
        }
        return true;
    }
}
