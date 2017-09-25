package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;
import java.net.URLDecoder;

final class an extends c {
    private a vCd;

    public an() {
        super(67);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYy);
        view.setTag(new w(this.knu).p(view, false));
        return view;
    }

    private static String To(String str) {
        try {
            f.a ek = f.a.ek(str);
            if (ek != null) {
                return URLDecoder.decode(ek.content, "UTF-8");
            }
        } catch (Exception e) {
            w.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", e.getMessage());
        }
        return "";
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        int i2 = 8;
        this.vCd = aVar2;
        w wVar = (w) aVar;
        if (ah.bUq()) {
            if (wVar.oDJ != null) {
                wVar.oDJ.setVisibility(8);
            }
            if (auVar.field_status == 1 || auVar.field_status == 5) {
                if (wVar.vyy != null) {
                    wVar.vyy.setVisibility(8);
                }
                wVar.vAd.setBackgroundResource(R.g.bek);
                auVar.uJS = true;
            } else {
                wVar.vAd.setBackgroundResource(R.g.bej);
                if (wVar.vyy != null) {
                    if (ah.a(aVar2.vBD, auVar.field_msgId)) {
                        if (auVar.uJS) {
                            Animation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                            alphaAnimation.setDuration(300);
                            wVar.vAd.startAnimation(alphaAnimation);
                            auVar.uJS = false;
                        }
                        wVar.vyy.setVisibility(0);
                    } else {
                        wVar.vyy.setVisibility(8);
                    }
                }
            }
        } else if (wVar.oDJ != null) {
            ProgressBar progressBar = wVar.oDJ;
            if (auVar.field_status < 2) {
                i2 = 0;
            }
            progressBar.setVisibility(i2);
        }
        CharSequence To = To(auVar.field_content);
        if (bg.mA(To)) {
            w.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId));
        }
        wVar.vAe.lj(true);
        wVar.vAd.setMinWidth(0);
        wVar.vAd.setText(To);
        TextView textView = wVar.vAd;
        int i3 = auVar.field_type;
        Object bUg = aVar2.bUg();
        if (i3 != 301989937) {
            h.a(textView, bUg);
        }
        textView.getText();
        wVar.vAd.setTag(dt.a(auVar, aVar2.vxp, i));
        wVar.vAd.setOnClickListener(aVar2.vBD.vEW);
        wVar.vAd.setOnLongClickListener(aVar2.vBD.vEY);
        wVar.vAd.wwK = aVar2.vBD.vFc;
        ah.a(i, (ah.a) wVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
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
