package com.tencent.mm.plugin.favorite.ui.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;

public abstract class d extends BaseAdapter implements OnClickListener {
    private Context context;
    public String lJr;
    public List<String> lJs = new LinkedList();
    public SparseArray<SpannableString> lJt = new SparseArray();

    public abstract void vv(String str);

    public /* synthetic */ Object getItem(int i) {
        return hO(i);
    }

    public d(Context context) {
        this.context = context;
    }

    public int getCount() {
        return this.lJs.size();
    }

    private String hO(int i) {
        return (String) this.lJs.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(this.context, R.i.dcF, null);
            view.setOnClickListener(this);
        }
        TextView textView = (TextView) view.findViewById(R.h.cAL);
        Object ap = bg.ap(hO(i), "");
        int textSize = (int) textView.getTextSize();
        int hashCode = ap.hashCode();
        CharSequence charSequence = (SpannableString) this.lJt.get(hashCode);
        if (charSequence == null) {
            charSequence = new SpannableString(h.c(this.context, ap, textSize));
            textSize = ap.indexOf(this.lJr);
            if (-1 == textSize) {
                w.w("MicroMsg.FavoriteTagSearchAdapter", "high light %s error", new Object[]{ap});
            } else {
                int length = this.lJr.length() + textSize;
                charSequence.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.aWu)), textSize, length, 33);
                charSequence.setSpan(new StyleSpan(1), textSize, length, 33);
                this.lJt.put(hashCode, charSequence);
            }
        }
        textView.setText(charSequence);
        return view;
    }

    public void onClick(View view) {
        w.d("MicroMsg.FavoriteTagSearchAdapter", "select search tag %s", new Object[]{((TextView) view.findViewById(R.h.cAL)).getText().toString()});
        vv(r0);
    }
}
