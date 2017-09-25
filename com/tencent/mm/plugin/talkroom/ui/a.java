package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.o;

public final class a {
    private static final int[] jYx = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private static final int[] jYy = new int[]{R.g.bbG, R.g.bbH, R.g.bbI, R.g.bbJ, R.g.bbK, R.g.bbL, R.g.bbM};
    private Context context;
    private ImageView jYG;
    private final ae jYX = new ae(this) {
        final /* synthetic */ a qZg;

        {
            this.qZg = r1;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.qZg.qZb.dismiss();
        }
    };
    private View lNG;
    private View lNH;
    private View lNJ;
    public o qZb;
    private TextView qZc;
    private ImageView qZd;
    private View qZe;
    private int qZf;

    public a(Context context) {
        this.context = context;
        this.qZf = b.a(context, 180.0f);
        this.qZb = new o(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.i.dpH, null), -1, -2);
        this.jYG = (ImageView) this.qZb.getContentView().findViewById(R.h.cNm);
        this.lNJ = this.qZb.getContentView().findViewById(R.h.cNp);
        this.qZc = (TextView) this.qZb.getContentView().findViewById(R.h.cNr);
        this.qZd = (ImageView) this.qZb.getContentView().findViewById(R.h.cNq);
        this.qZe = this.qZb.getContentView().findViewById(R.h.cNs);
        this.lNG = this.qZb.getContentView().findViewById(R.h.cNt);
        this.lNH = this.qZb.getContentView().findViewById(R.h.cNu);
    }
}
