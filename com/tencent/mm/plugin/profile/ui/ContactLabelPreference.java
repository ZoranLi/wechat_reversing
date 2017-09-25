package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.MMSingelLinePanel;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class ContactLabelPreference extends Preference {
    private TextView ioX;
    private MMSingelLinePanel osX;
    private ArrayList<String> osY;
    private String title;

    public ContactLabelPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactLabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.osY = new ArrayList();
        setLayoutResource(R.i.diC);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.diL, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.ioX = (TextView) view.findViewById(R.h.title);
        this.osX = (MMSingelLinePanel) view.findViewById(R.h.bFU);
        this.osX.bSn();
        this.osX.vmy = false;
        this.osX.kU(false);
        if (this.ioX != null) {
            this.ioX.setText(this.title);
        }
        if (!(this.osX == null || this.osY == null || this.osY.size() <= 0)) {
            this.osX.a(this.osY, this.osY);
        }
        super.onBindView(view);
    }
}
