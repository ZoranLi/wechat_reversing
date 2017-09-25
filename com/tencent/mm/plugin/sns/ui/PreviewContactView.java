package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class PreviewContactView extends LinearLayout {
    private final Context context;
    private List<String> fRK = new ArrayList();
    private final int qwA = 5;
    private TableLayout qwx;
    private final Map<Integer, View> qwy = new HashMap();
    @SuppressLint({"UseSparseArrays"})
    private final Map<Integer, TableRow> qwz = new HashMap();

    public PreviewContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.qwx = (TableLayout) LayoutInflater.from(this.context).inflate(g.pHU, this, true).findViewById(f.content);
    }

    public final void bA(List<String> list) {
        if (list != null) {
            this.fRK = list;
            this.qwx.removeAllViews();
            if (list.size() != 0) {
                boolean size = list.size();
                int i = 0;
                boolean z;
                for (boolean z2 = false; z2 < size; z2 = z) {
                    View view;
                    View view2 = (TableRow) this.qwz.get(Integer.valueOf(i));
                    if (view2 == null) {
                        view2 = new TableRow(this.context);
                        this.qwz.put(Integer.valueOf(i), view2);
                        view = view2;
                    } else {
                        view = view2;
                    }
                    view.removeAllViews();
                    int i2 = 0;
                    z = z2;
                    while (i2 < 5 && z < size) {
                        view2 = (View) this.qwy.get(Integer.valueOf(z));
                        if (view2 == null) {
                            view2 = View.inflate(this.context, g.pHT, null);
                            this.qwy.put(Integer.valueOf(z), view2);
                        }
                        View view3 = view2;
                        String str = (String) list.get(z);
                        ImageView imageView = (ImageView) view3.findViewById(f.pCV);
                        imageView.setBackgroundDrawable(null);
                        b.a(imageView, str);
                        view3.setTag(Integer.valueOf(0));
                        view3.setClickable(false);
                        view.addView(view3);
                        i2++;
                        z++;
                    }
                    this.qwx.addView(view);
                    i++;
                }
            }
        }
    }
}
