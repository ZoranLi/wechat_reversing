package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoView extends LinearLayout {
    private static int jrN = a.fromDPToPix(ab.getContext(), 15);
    private static int jrO = a.fromDPToPix(ab.getContext(), 30);
    private TextView jhl;
    public List<WxaEntryInfo> jrG;
    private View jrH;
    private ImageView jrI;
    private TextView jrJ;
    private LinearLayout jrK;
    private ViewGroup jrL;
    private View jrM;

    public WxaBindBizInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public WxaBindBizInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.jrG = new LinkedList();
        View inflate = View.inflate(getContext(), R.i.cUk, this);
        this.jrH = inflate.findViewById(R.h.bQd);
        this.jrI = (ImageView) inflate.findViewById(R.h.bWw);
        this.jhl = (TextView) inflate.findViewById(R.h.cIV);
        this.jrJ = (TextView) inflate.findViewById(R.h.bGL);
        this.jrM = inflate.findViewById(R.h.cle);
        this.jrK = (LinearLayout) inflate.findViewById(R.h.bGs);
        this.jrL = (ViewGroup) inflate.findViewById(R.h.bZc);
    }

    public final void cq(boolean z) {
        if (this.jrL.getMeasuredWidth() != 0) {
            WxaEntryInfo wxaEntryInfo;
            if (this.jrG.isEmpty()) {
                setVisibility(8);
                wxaEntryInfo = null;
            } else {
                setVisibility(0);
                wxaEntryInfo = (WxaEntryInfo) this.jrG.get(0);
            }
            if (wxaEntryInfo != null) {
                a(wxaEntryInfo, this.jrI, this.jhl);
            }
            this.jrJ.setText(getContext().getString(R.l.dXB, new Object[]{Integer.valueOf(this.jrG.size())}));
            List list = this.jrG;
            this.jrK.removeAllViews();
            if (!list.isEmpty()) {
                int size = list.size();
                int measuredWidth = (this.jrL.getMeasuredWidth() - this.jrL.getPaddingLeft()) - this.jrL.getPaddingRight();
                int i = measuredWidth / (jrO + jrN);
                if (i > size) {
                    this.jrM.setVisibility(8);
                } else {
                    this.jrM.setVisibility(0);
                    i = (measuredWidth - this.jrM.getMeasuredWidth()) / (jrO + jrN);
                }
                measuredWidth = Math.min(i, size);
                if (measuredWidth > 1) {
                    for (size = 0; size < measuredWidth; size++) {
                        wxaEntryInfo = (WxaEntryInfo) list.get(size);
                        View imageView = new ImageView(getContext());
                        imageView.setLayoutParams(new LayoutParams(jrO + jrN, jrO));
                        imageView.setPadding(0, 0, jrN, 0);
                        this.jrK.addView(imageView);
                        a(wxaEntryInfo, imageView, null);
                    }
                }
                w.i("MicroMsg.WxaBindBizInfoView", "attachItemToContainer(size : %s)", new Object[]{Integer.valueOf(list.size())});
            }
            if (this.jrG.size() == 1) {
                this.jrH.setVisibility(0);
                this.jrL.setTag(((WxaEntryInfo) this.jrG.get(0)).username);
                return;
            }
            this.jrH.setVisibility(8);
            this.jrL.setTag(null);
        } else if (z) {
            getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ WxaBindBizInfoView jrP;

                {
                    this.jrP = r1;
                }

                public final boolean onPreDraw() {
                    this.jrP.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.jrP.cq(false);
                    return true;
                }
            });
        }
    }

    private static void a(WxaEntryInfo wxaEntryInfo, ImageView imageView, TextView textView) {
        if (wxaEntryInfo != null) {
            String str = wxaEntryInfo.username;
            if (imageView != null) {
                imageView.setTag(str);
                Bitmap il = l.il(wxaEntryInfo.username);
                if (il == null || il.isRecycled()) {
                    b.AY().a(imageView, wxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.AX(), e.hqF);
                } else {
                    imageView.setImageBitmap(il);
                }
            }
            if (textView != null) {
                textView.setText(bg.mz(wxaEntryInfo.title));
            }
        }
    }
}
