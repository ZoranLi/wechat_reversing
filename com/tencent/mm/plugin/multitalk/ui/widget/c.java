package com.tencent.mm.plugin.multitalk.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.List;

public final class c implements OnClickListener {
    private TextView jZB;
    private MultiTalkMainUI nRi;
    private View nRj;
    private TextView nRk;
    private ImageView nRl;
    private LinearLayout nRm;
    private ImageButton nRn;
    private ImageButton nRo;

    public c(MultiTalkMainUI multiTalkMainUI) {
        this.nRi = multiTalkMainUI;
        this.nRj = multiTalkMainUI.findViewById(R.h.bYk);
        this.nRk = (TextView) multiTalkMainUI.findViewById(R.h.bYm);
        this.nRl = (ImageView) multiTalkMainUI.findViewById(R.h.bYl);
        this.nRm = (LinearLayout) multiTalkMainUI.findViewById(R.h.cFA);
        this.jZB = (TextView) multiTalkMainUI.findViewById(R.h.bXV);
        this.nRn = (ImageButton) multiTalkMainUI.findViewById(R.h.bYn);
        this.nRo = (ImageButton) multiTalkMainUI.findViewById(R.h.bYj);
        this.nRn.setOnClickListener(this);
        this.nRo.setOnClickListener(this);
    }

    public final void n(MultiTalkGroup multiTalkGroup) {
        int i;
        this.nRj.setVisibility(0);
        String aNe = i.aNe();
        List arrayList = new ArrayList();
        if (!bg.mA(aNe)) {
            for (i = 0; i < multiTalkGroup.wPj.size(); i++) {
                if (!((MultiTalkGroupMember) multiTalkGroup.wPj.get(i)).wPk.equals(aNe)) {
                    arrayList.add(((MultiTalkGroupMember) multiTalkGroup.wPj.get(i)).wPk);
                }
            }
            this.nRk.setText(h.a(this.nRi, n.eK(aNe)));
            b.a(this.nRl, aNe, 0.1f, true);
        }
        if (arrayList.size() > 0) {
            this.jZB.setVisibility(0);
            this.jZB.setText(R.l.eCe);
            this.nRm.setVisibility(0);
            this.nRm.removeAllViews();
            for (i = 0; i < arrayList.size(); i++) {
                View imageView = new ImageView(this.nRi.uSU.uTo);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(b.nRb, b.nRb);
                if (i != 0) {
                    layoutParams.leftMargin = b.nQZ;
                }
                imageView.setLayoutParams(layoutParams);
                this.nRm.addView(imageView);
                b.a(imageView, (String) arrayList.get(i), 0.1f, false);
            }
            return;
        }
        this.jZB.setVisibility(8);
        this.nRm.setVisibility(8);
    }

    public final void aNs() {
        this.nRj.setVisibility(8);
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.bYj) {
            o.aNn().c(true, false, false);
        } else if (view.getId() == R.h.bYn) {
            e aNn = o.aNn();
            if (aNn.aMM()) {
                w.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s", new Object[]{i.h(aNn.nPl)});
                o.aNm().nOT.dg(aNn.nPl.wPf, aNn.nPl.wLa);
                return;
            }
            w.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
        }
    }
}
