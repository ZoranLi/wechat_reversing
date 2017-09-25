package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendItemPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int height;
    private String piN;
    private int piO;
    int piP;

    public AddFriendItemPreference(Context context) {
        this(context, null);
    }

    public AddFriendItemPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddFriendItemPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.piN = "";
        this.piO = -1;
        this.piP = 8;
        this.height = -1;
        this.context = context;
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.diE, viewGroup2);
        viewGroup2.setPadding(0, viewGroup2.getPaddingTop(), viewGroup2.getPaddingRight(), viewGroup2.getPaddingBottom());
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.h.bWV);
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
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.ckj);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(R.h.cHL);
        if (textView != null) {
            textView.setVisibility(this.piP);
            textView.setText(this.piN);
            if (this.piO != -1) {
                textView.setBackgroundDrawable(a.a(this.context, this.piO));
            }
        }
    }
}
