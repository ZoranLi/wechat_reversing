package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class FaceHeaderPreference extends Preference {
    private MMActivity fCi;
    private TextView ioX;
    private ImageView jla;
    private int lAi;
    private Button lAj;
    private View lAk;
    private OnClickListener lAl;
    private String lAm;
    private String lAn;
    private String mTitle;

    public FaceHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.fCi = (MMActivity) context;
    }

    public FaceHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitle = "";
        this.lAi = 255;
        this.lAl = null;
        this.lAm = "";
        this.lAn = "";
        this.fCi = (MMActivity) context;
        setLayoutResource(g.ltz);
    }

    public final void ca(String str, String str2) {
        this.lAm = str;
        this.lAn = str2;
        if (this.ioX == null) {
            return;
        }
        if (bg.mA(this.lAm)) {
            this.ioX.setVisibility(8);
            return;
        }
        this.ioX.setText(this.lAm);
        this.ioX.setVisibility(0);
    }

    public final void a(OnClickListener onClickListener) {
        this.lAl = onClickListener;
        if (this.lAj != null && this.lAk != null) {
            if (this.lAj == null || this.lAl == null) {
                this.lAj.setVisibility(8);
                this.lAk.setVisibility(8);
                return;
            }
            this.lAj.setOnClickListener(onClickListener);
            this.lAj.setVisibility(0);
            this.lAk.setVisibility(0);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.jla = (ImageView) view.findViewById(e.lsS);
        this.ioX = (TextView) view.findViewById(e.lsT);
        this.lAj = (Button) view.findViewById(e.cyU);
        this.lAk = view.findViewById(e.bvE);
        if (bg.mA(this.lAm)) {
            this.ioX.setVisibility(8);
        } else {
            this.ioX.setText(this.lAm);
            this.ioX.setVisibility(0);
        }
        if (this.lAj == null || this.lAl == null) {
            this.lAj.setVisibility(8);
            this.lAk.setVisibility(8);
            return;
        }
        this.lAj.setOnClickListener(this.lAl);
        this.lAj.setVisibility(0);
        this.lAk.setVisibility(0);
    }
}
