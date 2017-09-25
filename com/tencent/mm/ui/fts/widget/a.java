package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;

public final class a extends LinearLayout {
    private View ngD = findViewById(g.bmv);
    public FTSEditTextView wiF;
    public a wiG;

    public interface a {
        void aZv();
    }

    public interface b extends Comparable {
        String getTagName();
    }

    public a(Context context) {
        super(context);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(h.hdT, this, true);
        this.ngD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a wiH;

            {
                this.wiH = r1;
            }

            public final void onClick(View view) {
                if (this.wiH.wiG != null) {
                    this.wiH.wiG.aZv();
                }
            }
        });
        this.wiF = (FTSEditTextView) findViewById(g.hcn);
    }
}
