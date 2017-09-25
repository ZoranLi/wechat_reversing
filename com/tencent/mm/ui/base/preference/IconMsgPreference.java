package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.bg;

public class IconMsgPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int height;
    private String piN;
    private int piO;
    private int piP;
    private int vqC;
    private int vqD;
    private int vqE;
    private ImageView vqF;
    private ViewGroup vqG;
    private TextView vqH;
    private String vqI;

    public IconMsgPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconMsgPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.piN = "";
        this.piO = -1;
        this.piP = 8;
        this.vqC = 8;
        this.vqD = 0;
        this.vqE = 8;
        this.vqF = null;
        this.vqG = null;
        this.height = -1;
        this.vqI = "";
        this.context = context;
        setLayoutResource(h.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.heu, viewGroup2);
        onCreateView.setMinimumHeight(onCreateView.getResources().getDimensionPixelSize(e.aXQ));
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(g.bWV);
        if (imageView != null) {
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.PG != 0) {
                imageView.setImageResource(this.PG);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(g.ckj);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(g.cHL);
        if (textView != null) {
            textView.setVisibility(this.piP);
            textView.setText(this.piN);
            if (this.piO != -1) {
                textView.setBackgroundDrawable(a.a(this.context, this.piO));
            }
        }
        this.vqF = (ImageView) view.findViewById(g.hdm);
        this.vqF.setVisibility(this.vqC);
        this.vqG = (ViewGroup) view.findViewById(g.hcX);
        this.vqG.setVisibility(this.vqD);
        this.vqH = (TextView) view.findViewById(16908310);
        textView = (TextView) view.findViewById(g.hdn);
        if (bg.mA(this.vqI)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(this.vqI);
    }
}
