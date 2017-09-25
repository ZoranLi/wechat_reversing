package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIHotWordLayout extends LinearLayout {
    private TextView ipw = null;
    protected OnClickListener pgk;
    public b wiA = null;
    protected List<LinearLayout> wis = null;
    protected int wiy = 2;
    protected boolean wiz = true;

    public static class a {
        public int fTP = 0;
        public String jumpUrl = "";
        public String wiB = "";
        public int wiC = 0;

        public a(JSONObject jSONObject, int i) {
            if (jSONObject != null) {
                this.wiB = jSONObject.optString("hotword");
                this.jumpUrl = jSONObject.optString("jumpUrl");
                this.fTP = jSONObject.optInt("optype");
            }
            this.wiC = i;
        }
    }

    private static class b {
        public String iGy = null;
        public ArrayList<a> kYO = null;
        public int wiD = 0;
        public ArrayList<String> wiE = null;
    }

    public FTSMainUIHotWordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    public FTSMainUIHotWordLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KC();
    }

    private void KC() {
        setOrientation(1);
        this.wis = new ArrayList();
    }

    public final void c(JSONObject jSONObject, int i) {
        this.wiA = new b();
        this.wiA.wiD = i;
        for (LinearLayout removeView : this.wis) {
            removeView(removeView);
        }
        this.wis.clear();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(SlookAirButtonFrequentContactAdapter.DATA).optJSONObject("hotwords");
            this.wiA.iGy = jSONObject.optString("searchID");
            if (this.ipw == null) {
                this.ipw = (TextView) findViewById(R.h.bWr);
            }
            CharSequence optString = optJSONObject.optString("title");
            if (bg.mA(optString)) {
                this.ipw.setText(R.l.eQb);
            } else {
                this.ipw.setText(optString);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("items");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    a aVar = new a(optJSONArray.optJSONObject(i2), i2);
                    String str = aVar.wiB;
                    if (!bg.mA(str)) {
                        arrayList.add(str);
                        arrayList2.add(aVar);
                    }
                }
                if (this.wiA != null) {
                    this.wiA.wiE = arrayList;
                    this.wiA.kYO = arrayList2;
                }
                f(arrayList, arrayList2);
            }
        } catch (Exception e) {
        }
    }

    private void f(ArrayList<String> arrayList, ArrayList<a> arrayList2) {
        w.i("MicroMsg.FTS.FTSMainUIHotWordLayout", "addCellLayout: %s", new Object[]{arrayList.toString()});
        View view = null;
        for (int i = 0; i < Math.min(arrayList.size(), arrayList2.size()); i++) {
            View findViewById;
            View findViewById2;
            TextView textView;
            if (view == null) {
                view = (LinearLayout) inflate(getContext(), R.i.ddT, null);
                ((ImageView) view.findViewById(R.h.bXm)).setImageResource(R.k.dzH);
                ((ImageView) view.findViewById(R.h.bXn)).setImageResource(R.k.dzH);
            }
            TextView textView2;
            switch (i % this.wiy) {
                case 1:
                    textView2 = (TextView) view.findViewById(R.h.cHO);
                    findViewById = view.findViewById(R.h.cHS);
                    findViewById2 = view.findViewById(R.h.cHU);
                    textView = textView2;
                    break;
                default:
                    textView2 = (TextView) view.findViewById(R.h.cHN);
                    findViewById = view.findViewById(R.h.cHR);
                    findViewById2 = view.findViewById(R.h.cHT);
                    textView = textView2;
                    break;
            }
            textView.setText((CharSequence) arrayList.get(i));
            findViewById.setTag(arrayList2.get(i));
            findViewById.setOnClickListener(this.pgk);
            findViewById2.setVisibility(0);
            if (i % this.wiy == this.wiy - 1) {
                this.wis.add(view);
                addView(view);
                view = null;
            }
        }
        if (view != null && this.wiz) {
            this.wis.add(view);
            addView(view);
        }
    }

    public final void i(OnClickListener onClickListener) {
        this.pgk = onClickListener;
    }

    public final String bZh() {
        if (this.wiA == null || this.wiA.iGy == null) {
            return "";
        }
        return this.wiA.iGy;
    }

    public void setVisibility(int i) {
        if ((this.wis.size() > 0 ? 1 : null) == null) {
            i = 8;
        }
        super.setVisibility(i);
    }
}
