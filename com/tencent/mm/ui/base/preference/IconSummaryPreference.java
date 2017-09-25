package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class IconSummaryPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int height;
    private ImageView nvU;
    private String piN;
    private int piO;
    public int piP;
    private int vqD;
    private int vqE;
    private ViewGroup vqG;
    private Bitmap vqO;
    private int vqP;
    private int vqQ;
    private View vqS;
    LayoutParams vqU;
    public int vrb;
    public TextView vrc;
    private int vrd;

    public IconSummaryPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconSummaryPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.piN = "";
        this.piO = -1;
        this.piP = 8;
        this.vqO = null;
        this.vqP = -1;
        this.vqQ = 8;
        this.vqD = 0;
        this.vqE = 8;
        this.vrb = 8;
        this.nvU = null;
        this.vqG = null;
        this.vqS = null;
        this.vrc = null;
        this.vrd = -1;
        this.height = -1;
        this.context = context;
        setLayoutResource(h.diC);
    }

    protected View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.hep, viewGroup2);
        return onCreateView;
    }

    public final void cM(String str, int i) {
        this.piN = str;
        this.piO = i;
    }

    public final void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (this.vrc != null && getSummary() != null && getSummary().length() > 0) {
            this.vrc.setText(getSummary());
        }
    }

    public final void setSummary(int i) {
        super.setSummary(i);
        if (this.vrc != null && getSummary() != null && getSummary().length() > 0) {
            this.vrc.setText(getSummary());
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(g.bWV);
        if (imageView != null) {
            imageView.setVisibility(8);
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.jQ != null) {
                imageView.setImageDrawable(this.jQ);
                imageView.setVisibility(0);
            } else if (this.PG != 0) {
                imageView.setImageResource(this.PG);
                imageView.setVisibility(0);
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
        if (this.nvU == null) {
            this.nvU = (ImageView) view.findViewById(g.hct);
        }
        if (this.vqG == null) {
            this.vqG = (ViewGroup) view.findViewById(g.hcX);
        }
        if (this.vqS == null) {
            this.vqS = view.findViewById(g.cyV);
        }
        this.vqS.setVisibility(this.vqE);
        if (this.vqO != null) {
            this.nvU.setImageBitmap(this.vqO);
        } else if (this.vqP != -1) {
            this.nvU.setImageResource(this.vqP);
        }
        this.nvU.setVisibility(this.vqQ);
        this.vqG.setVisibility(this.vqD);
        if (this.vqU != null) {
            this.nvU.setLayoutParams(this.vqU);
        }
        this.vrc = (TextView) view.findViewById(g.hcY);
        if (!(this.vrc == null || getSummary() == null || getSummary().length() <= 0)) {
            this.vrc.setText(getSummary());
            this.vrc.setVisibility(this.vrb);
        }
        if (this.vrc != null && this.vrd != -1) {
            this.vrc.setCompoundDrawablesWithIntrinsicBounds(this.vrd, 0, 0, 0);
            this.vrc.setCompoundDrawablePadding(b.a(this.mContext, 2.0f));
            this.vrc.setVisibility(this.vrb);
        }
    }
}
