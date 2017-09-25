package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class aj {
    public String fGN;
    public boolean pQJ = false;
    public int position;
    public a pwp;
    public ImageView qjB;
    public TextView qjE;
    public bfc qxB;
    public View qxC;
    public View qxD;
    public MMPinProgressBtn qxE;
    public TextView qxF;

    public final void a(bfc com_tencent_mm_protocal_c_bfc, int i, String str, boolean z) {
        this.qxB = com_tencent_mm_protocal_c_bfc;
        this.position = i;
        this.fGN = str;
        this.pQJ = z;
    }
}
