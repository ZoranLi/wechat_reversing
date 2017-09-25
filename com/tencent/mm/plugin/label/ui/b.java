package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    private Context mContext;
    String mZT;
    ArrayList<String> mZU = new ArrayList();
    SparseArray<SpannableString> mZV = new SparseArray();

    public final /* synthetic */ Object getItem(int i) {
        return hO(i);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.mZU == null ? 0 : this.mZU.size();
    }

    public final String hO(int i) {
        return (this.mZU == null || i >= getCount()) ? null : (String) this.mZU.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.cZA, viewGroup, false);
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        MMTextView mMTextView = cVar.nav;
        Object ap = bg.ap(hO(i), "");
        int textSize = (int) cVar.nav.getTextSize();
        int hashCode = ap.hashCode();
        CharSequence charSequence = (SpannableString) this.mZV.get(hashCode);
        if (charSequence == null) {
            charSequence = new SpannableString(h.c(this.mContext, ap, textSize));
            textSize = ap.indexOf(this.mZT);
            if (textSize == -1) {
                w.w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", new Object[]{ap});
            } else {
                int length = this.mZT.length() + textSize;
                charSequence.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.e.aWu)), textSize, length, 33);
                charSequence.setSpan(new StyleSpan(1), textSize, length, 33);
                this.mZV.put(hashCode, charSequence);
            }
        }
        mMTextView.setText(charSequence);
        return view;
    }
}
