package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference extends Preference {
    private TextView ouW;
    public String uTf;
    private Drawable vrk;
    public boolean vrl;
    private boolean vrm;
    private boolean vrn;
    public boolean vro;
    private int vrp;
    public int vrq;
    public int vrr;
    private ImageView vrs;
    public Drawable vrt;
    public List<View> vru;

    public KeyValuePreference(Context context) {
        this(context, null);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vrk = null;
        this.vrl = true;
        this.vrm = false;
        this.uTf = null;
        this.vrn = false;
        this.vro = false;
        this.vrp = 17;
        this.vrq = 17;
        this.vrr = 0;
        this.vrs = null;
        this.vrt = null;
        this.vru = new LinkedList();
        setLayoutResource(h.diC);
    }

    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(h.heq, viewGroup2);
        return onCreateView;
    }

    public void onBindView(View view) {
        super.onBindView(view);
        this.ouW = (TextView) view.findViewById(16908304);
        this.ouW.setSingleLine(this.vrl);
        if (this.vrm) {
            setWidgetLayoutResource(h.djm);
        }
        if (this.vro) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(g.bGr);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = -1;
            linearLayout.setLayoutParams(layoutParams);
            linearLayout = (LinearLayout) view.findViewById(g.hdh);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.getChildAt(0).setLayoutParams(layoutParams);
            this.ouW.setGravity(this.vrq);
        }
        TextView textView = (TextView) view.findViewById(16908310);
        if (!bg.mA(this.uTf)) {
            textView.setText(this.uTf);
        }
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            layoutParams2.width = a.T(this.mContext, e.aXk);
            textView.setLayoutParams(layoutParams2);
        }
        if (this.vrk != null) {
            ((ImageView) view.findViewById(g.hcs)).setImageDrawable(this.vrk);
        }
        this.vrs = (ImageView) view.findViewById(g.bWV);
        if (this.vrt != null) {
            this.vrs.setVisibility(this.vrr);
            this.vrs.setImageDrawable(this.vrt);
        } else {
            this.vrs.setVisibility(8);
        }
        if (this.vrn) {
            linearLayout = (LinearLayout) view.findViewById(g.bGr);
            if (linearLayout != null) {
                linearLayout.setGravity(this.vrp);
            }
        }
        if (this.vru.size() > 0) {
            linearLayout = (LinearLayout) view.findViewById(g.hdh);
            linearLayout.removeAllViews();
            for (View view2 : this.vru) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view2);
                }
                linearLayout.addView(view2);
            }
        }
    }

    public final void kZ(boolean z) {
        this.vrm = z;
        if (this.vrm) {
            setWidgetLayoutResource(h.djm);
        }
    }

    public final void bSX() {
        this.vrn = true;
        this.vrp = 49;
    }
}
