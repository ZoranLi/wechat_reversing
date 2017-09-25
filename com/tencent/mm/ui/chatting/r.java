package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ah.a;
import java.util.ArrayList;
import java.util.List;

final class r extends a {
    List<q> oKE = new ArrayList();
    TextView vyE;
    ChattingItemFooter vyU;
    LinearLayout vzQ;
    t vzR = new t();

    public r(int i) {
        super(i);
    }

    public final a dm(View view) {
        ViewGroup viewGroup = (ViewGroup) this.vzR.oKs.getParent();
        q qVar = new q();
        qVar.oKs = view;
        qVar.iUO = (TextView) view.findViewById(R.h.title);
        qVar.vzP = (TextView) view.findViewById(R.h.summary);
        qVar.oKt = view.findViewById(R.h.bGZ);
        qVar.oKu = (ImageView) view.findViewById(R.h.bGY);
        qVar.lKt = (ProgressBar) view.findViewById(R.h.cbS);
        qVar.oKw = view.findViewById(R.h.cbJ);
        viewGroup.addView(view, viewGroup.getChildCount() - 1);
        this.oKE.add(qVar);
        return this;
    }
}
