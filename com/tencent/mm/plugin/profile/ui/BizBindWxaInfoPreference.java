package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.List;

public class BizBindWxaInfoPreference extends Preference {
    private static DisplayMetrics jnY = ab.getContext().getResources().getDisplayMetrics();
    private static int jrN = a.fromDPToPix(ab.getContext(), 15);
    private static int jrO = ab.getResources().getDimensionPixelSize(R.f.aXF);
    private TextView jhl;
    public List<WxaEntryInfo> jrG;
    private View jrH;
    private ImageView jrI;
    private TextView jrJ;
    private LinearLayout jrK;
    private ViewGroup jrL;
    private View jrM;
    private OnClickListener llr;
    private volatile boolean oss;
    volatile boolean ost;
    private OnClickListener osu;

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected final void onBindView(View view) {
        this.jrH = view.findViewById(R.h.bQd);
        this.jrI = (ImageView) view.findViewById(R.h.bWw);
        this.jhl = (TextView) view.findViewById(R.h.cIV);
        this.jrJ = (TextView) view.findViewById(R.h.bGL);
        this.jrM = view.findViewById(R.h.cle);
        this.jrK = (LinearLayout) view.findViewById(R.h.bGs);
        this.jrL = (ViewGroup) view.findViewById(R.h.bZc);
        this.oss = true;
        this.ost = this.jrG != null;
        RO();
        super.onBindView(view);
    }

    private void init() {
        this.llr = new OnClickListener(this) {
            final /* synthetic */ BizBindWxaInfoPreference osv;

            {
                this.osv = r1;
            }

            public final void onClick(View view) {
                Object tag = view.getTag();
                if (tag != null && (tag instanceof String)) {
                    b prVar = new pr();
                    prVar.fWB.userName = (String) tag;
                    prVar.fWB.scene = 1020;
                    prVar.fWB.fCN = (String) tag;
                    prVar.fWB.context = this.osv.mContext;
                    com.tencent.mm.sdk.b.a.urY.m(prVar);
                }
            }
        };
        this.osu = new OnClickListener(this) {
            final /* synthetic */ BizBindWxaInfoPreference osv;

            {
                this.osv = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.osv.mContext, BizBindWxaInfoUI.class);
                intent.putParcelableArrayListExtra("wxa_entry_info_list", new ArrayList(this.osv.jrG));
                this.osv.mContext.startActivity(intent);
            }
        };
    }

    final void RO() {
        if (this.oss && this.jrG != null && this.ost) {
            WxaEntryInfo wxaEntryInfo;
            this.ost = false;
            if (this.jrG.isEmpty()) {
                wxaEntryInfo = null;
            } else {
                wxaEntryInfo = (WxaEntryInfo) this.jrG.get(0);
            }
            if (wxaEntryInfo != null) {
                a(wxaEntryInfo, this.jrI, this.jhl);
            }
            this.jrJ.setText(this.mContext.getString(R.l.dXB, new Object[]{Integer.valueOf(this.jrG.size())}));
            List list = this.jrG;
            this.jrK.removeAllViews();
            if (!list.isEmpty()) {
                int size = list.size();
                int measuredWidth = this.jrL.getMeasuredWidth();
                if (measuredWidth == 0) {
                    measuredWidth = jnY.widthPixels;
                }
                int paddingLeft = (measuredWidth - this.jrL.getPaddingLeft()) - this.jrL.getPaddingRight();
                measuredWidth = paddingLeft / (jrO + jrN);
                if (measuredWidth > size) {
                    this.jrM.setVisibility(8);
                } else {
                    this.jrM.setVisibility(0);
                    measuredWidth = (paddingLeft - this.jrM.getMeasuredWidth()) / (jrO + jrN);
                }
                paddingLeft = Math.min(measuredWidth, size);
                if (paddingLeft > 1) {
                    for (size = 0; size < paddingLeft; size++) {
                        wxaEntryInfo = (WxaEntryInfo) list.get(size);
                        View imageView = new ImageView(this.mContext);
                        imageView.setLayoutParams(new LayoutParams(jrO + jrN, jrO));
                        imageView.setPadding(0, 0, jrN, 0);
                        this.jrK.addView(imageView);
                        a(wxaEntryInfo, imageView, null);
                    }
                }
                w.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", new Object[]{Integer.valueOf(list.size())});
            }
            if (this.jrG.size() == 1) {
                this.jrH.setVisibility(0);
                this.jrL.setTag(((WxaEntryInfo) this.jrG.get(0)).username);
                this.jrL.setOnClickListener(this.llr);
                return;
            }
            this.jrH.setVisibility(8);
            this.jrL.setTag(null);
            this.jrL.setOnClickListener(this.osu);
        }
    }

    private static void a(WxaEntryInfo wxaEntryInfo, ImageView imageView, TextView textView) {
        if (wxaEntryInfo != null) {
            String str = wxaEntryInfo.username;
            if (imageView != null) {
                imageView.setTag(str);
                com.tencent.mm.modelappbrand.a.b.AY().a(imageView, wxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.AX(), e.hqF);
            }
            if (textView != null) {
                textView.setText(bg.mz(wxaEntryInfo.title));
            }
        }
    }
}
