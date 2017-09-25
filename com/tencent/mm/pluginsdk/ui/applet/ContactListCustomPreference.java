package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactListCustomPreference extends Preference {
    int background = -1;
    OnClickListener oPX;
    private final OnTouchListener sNh = new OnTouchListener(this) {
        final /* synthetic */ ContactListCustomPreference sNi;

        {
            this.sNi = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private View sdv;

    public ContactListCustomPreference(Context context) {
        super(context);
        setLayoutResource(e.kDH);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(e.kDH);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(e.kDH);
    }

    public final void setCustomView(View view) {
        if (view != null) {
            this.sdv = view;
        }
    }

    public final void onBindView(View view) {
        ViewGroup viewGroup = (ViewGroup) view;
        if (!(this.sdv == null || this.sdv == null)) {
            viewGroup.removeAllViews();
            if (this.sdv.getParent() != null) {
                ((ViewGroup) this.sdv.getParent()).removeAllViews();
            }
            viewGroup.addView(this.sdv);
            if (this.oPX != null) {
                viewGroup.setOnClickListener(this.oPX);
            } else {
                viewGroup.setOnTouchListener(this.sNh);
            }
        }
        if (this.background >= 0) {
            view.setBackgroundResource(this.background);
        }
    }
}
