package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelbiz.i;
import com.tencent.mm.modelbiz.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.List;

public class ChattingItemFooter extends LinearLayout implements OnClickListener {
    private static final int[] vDG = new int[]{R.g.bdV, R.g.bdV, R.g.bdX, R.g.bdW};
    private static final int[] vDH = new int[]{R.g.biM, R.g.biN, R.g.biP, R.g.biO};
    private LayoutInflater Du;
    private String jia;
    private Context mContext;

    public ChattingItemFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.Du = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public final boolean b(List<i> list, String str, boolean z) {
        if (list == null || list.size() <= 0) {
            w.d("ChattingItemFooter", "no menulist!");
            setVisibility(8);
            return false;
        }
        int[] iArr;
        i iVar;
        TextView a;
        TextView a2;
        this.jia = str;
        int childCount = getChildCount();
        if (z) {
            iArr = vDH;
        } else {
            iArr = vDG;
        }
        LayoutParams layoutParams = new LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        int size = list.size();
        switch (size) {
            case 1:
                iVar = (i) list.get(0);
                a = a(0, childCount, layoutParams);
                a.setText(iVar.name);
                a.setTag(iVar);
                a.setBackgroundResource(iArr[3]);
                break;
            case 2:
                break;
            case 3:
                iVar = (i) list.get(1);
                a2 = a(1, childCount, layoutParams);
                a2.setText(iVar.name);
                a2.setTag(iVar);
                a2.setBackgroundResource(iArr[1]);
                break;
        }
        iVar = (i) list.get(0);
        a2 = a(0, childCount, layoutParams);
        a2.setText(iVar.name);
        a2.setTag(iVar);
        a2.setBackgroundResource(iArr[0]);
        iVar = (i) list.get(size - 1);
        a = a(size - 1, childCount, layoutParams);
        a.setText(iVar.name);
        a.setTag(iVar);
        a.setBackgroundResource(iArr[2]);
        if (childCount > size && childCount - 1 > 0) {
            removeViews(size, childCount - 1);
        }
        setLongClickable(true);
        setVisibility(0);
        return true;
    }

    private TextView a(int i, int i2, LayoutParams layoutParams) {
        if (i < i2) {
            return (TextView) getChildAt(i);
        }
        TextView textView = (TextView) this.Du.inflate(R.i.cXD, null);
        textView.setLongClickable(false);
        textView.setOnClickListener(this);
        textView.setLayoutParams(layoutParams);
        addView(textView);
        return textView;
    }

    private void d(i iVar) {
        ap.vd().a(new p(this.jia, 1, iVar.getInfo(), null), 0);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof i) {
            i iVar = (i) tag;
            switch (iVar.type) {
                case 1:
                    w.d("ChattingItemFooter", "get latest message");
                    iVar.state = i.hvJ;
                    d(iVar);
                    return;
                case 2:
                    w.d("ChattingItemFooter", "start webview url");
                    iVar.state = i.hvJ;
                    d(iVar);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", iVar.value);
                    intent.putExtra("showShare", false);
                    intent.putExtra("geta8key_username", this.jia);
                    d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                default:
                    return;
            }
        }
    }
}
