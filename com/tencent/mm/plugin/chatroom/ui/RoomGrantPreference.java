package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomGrantPreference extends Preference {
    TextView kvp = null;
    String kvq = "";

    public RoomGrantPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomGrantPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.diC);
        setWidgetLayoutResource(R.i.djm);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.diV, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        if (this.kvp == null) {
            this.kvp = (TextView) view.findViewById(R.h.bGD);
        }
        this.kvp.setText(this.kvq);
        super.onBindView(view);
    }
}
