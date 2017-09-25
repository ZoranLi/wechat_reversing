package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.protocal.c.ob;
import java.util.LinkedList;

public final class l extends i {
    public View kqg;
    public LinearLayout kqh;
    public boolean kqi = false;

    public final void KC() {
    }

    public final void update() {
        if (this.kqg == null) {
            this.kqg = ((ViewStub) findViewById(R.h.bwQ)).inflate();
        }
        final ob obVar = this.kqe.ahj().afj().tnQ;
        ((TextView) this.kqg.findViewById(R.h.bIJ)).setText(obVar.title);
        if (obVar.ttJ != null && obVar.ttJ.size() > 0) {
            this.kqh = (LinearLayout) this.kqg.findViewById(R.h.bII);
            this.kqh.removeAllViews();
            final LinkedList linkedList = obVar.ttJ;
            final LayoutInflater layoutInflater = (LayoutInflater) this.kqe.ahm().getSystemService("layout_inflater");
            int i;
            TextView textView;
            if (obVar.ttI >= linkedList.size() || this.kqi) {
                this.kqg.findViewById(R.h.bIH).setVisibility(8);
                for (i = 0; i < linkedList.size(); i++) {
                    textView = (TextView) layoutInflater.inflate(R.i.cXe, null, false);
                    textView.setText(((lz) linkedList.get(i)).title);
                    this.kqh.addView(textView);
                }
                this.kqh.invalidate();
                return;
            }
            for (i = 0; i < obVar.ttI; i++) {
                textView = (TextView) layoutInflater.inflate(R.i.cXe, null, false);
                textView.setText(((lz) linkedList.get(i)).title);
                this.kqh.addView(textView);
            }
            this.kqh.invalidate();
            this.kqg.findViewById(R.h.bIH).setVisibility(0);
            this.kqg.findViewById(R.h.bIH).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ l kqm;

                public final void onClick(View view) {
                    this.kqm.kqi = true;
                    this.kqm.kqg.findViewById(R.h.bIH).setVisibility(8);
                    for (int i = obVar.ttI; i < linkedList.size(); i++) {
                        TextView textView = (TextView) layoutInflater.inflate(R.i.cXe, null, false);
                        textView.setText(((lz) linkedList.get(i)).title);
                        this.kqm.kqh.addView(textView);
                    }
                    this.kqm.kqh.invalidate();
                }
            });
        }
    }

    public final void aiz() {
        if (this.kqg != null) {
            this.kqg.setVisibility(8);
        }
    }
}
