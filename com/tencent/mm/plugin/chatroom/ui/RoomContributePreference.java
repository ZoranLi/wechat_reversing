package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomContributePreference extends Preference {
    private ImageView ioV;
    private MaskLayout kvn;
    private String kvo;

    public RoomContributePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public RoomContributePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.diC);
        setWidgetLayoutResource(R.i.dje);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        this.kvn = (MaskLayout) onCreateView.findViewById(R.h.bXb);
        this.ioV = (ImageView) onCreateView.findViewById(R.h.Kd);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.ioV != null && !bg.mA(this.kvo)) {
            b.a(this.ioV, this.kvo);
        }
    }
}
