package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import java.net.URLDecoder;

final class am extends b {
    private a vCd;

    public am() {
        super(66);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXV);
        view.setTag(new w(this.knu).p(view, true));
        return view;
    }

    protected final boolean a(a aVar) {
        return aVar.vxp;
    }

    private static String To(String str) {
        try {
            f.a ek = f.a.ek(str);
            if (ek != null) {
                return URLDecoder.decode(ek.content, "UTF-8");
            }
        } catch (Exception e) {
            w.e("MicroMsg.ChattingItemTextFrom", "getMsgContent error: %s", e.getMessage());
        }
        return "";
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        String trim;
        CharSequence To;
        TextView textView;
        int i2;
        Object bUg;
        this.vCd = aVar2;
        w wVar = (w) aVar;
        String str2 = auVar.field_content;
        String str3 = aVar2.vBD.fJL;
        wVar.vAe.lj(true);
        if (aVar2.vxp && !aVar2.sMK) {
            int gh = ay.gh(str2);
            if (gh != -1) {
                trim = str2.substring(0, gh).trim();
                if (trim == null || trim.length() <= 0) {
                    trim = str3;
                }
                str3 = trim;
                trim = str2.substring(gh + 1).trim();
                To = To(trim);
                a((ah.a) wVar, aVar2, auVar, str3);
                ah.a((ah.a) wVar, aVar2, str3, auVar);
                wVar.vAd.setText(To);
                textView = wVar.vAd;
                i2 = auVar.field_type;
                bUg = aVar2.bUg();
                if (i2 != 301989937) {
                    h.a(textView, bUg);
                }
                textView.getText();
                wVar.vAd.setTag(dt.a(auVar, aVar2.vxp, i));
                wVar.vAd.setOnClickListener(aVar2.vBD.vEW);
                wVar.vAd.setOnLongClickListener(aVar2.vBD.vEY);
                wVar.vAd.wwK = aVar2.vBD.vFc;
            }
        }
        trim = str2;
        To = To(trim);
        a((ah.a) wVar, aVar2, auVar, str3);
        ah.a((ah.a) wVar, aVar2, str3, auVar);
        wVar.vAd.setText(To);
        textView = wVar.vAd;
        i2 = auVar.field_type;
        bUg = aVar2.bUg();
        if (i2 != 301989937) {
            h.a(textView, bUg);
        }
        textView.getText();
        wVar.vAd.setTag(dt.a(auVar, aVar2.vxp, i));
        wVar.vAd.setOnClickListener(aVar2.vBD.vEW);
        wVar.vAd.setOnLongClickListener(aVar2.vBD.vEY);
        wVar.vAd.wwK = aVar2.vBD.vFc;
    }

    protected final boolean bUp() {
        return false;
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((dt) view.getTag()).position, 100, 0, view.getContext().getString(R.l.dUp));
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        return false;
    }

    public final boolean a(View view, a aVar, au auVar) {
        return false;
    }
}
