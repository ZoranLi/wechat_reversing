package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneSelectOtherCountryPreference extends Preference {
    String text;
    public a wpj;

    public interface a {
        void onClick();
    }

    public ZoneSelectOtherCountryPreference(Context context) {
        this(context, null);
    }

    public ZoneSelectOtherCountryPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoneSelectOtherCountryPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.diY, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.h.cTr);
        if (!bg.mA(this.text)) {
            textView.setText(this.text);
        }
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ZoneSelectOtherCountryPreference wpk;

            {
                this.wpk = r1;
            }

            public final void onClick(View view) {
                if (this.wpk.wpj != null) {
                    this.wpk.wpj.onClick();
                }
            }
        });
    }
}
