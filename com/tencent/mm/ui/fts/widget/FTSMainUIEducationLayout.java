package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.as.d;
import com.tencent.mm.as.j;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.i.e;
import com.tencent.mm.plugin.appbrand.i.e.b;
import com.tencent.mm.plugin.appbrand.i.e.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIEducationLayout extends LinearLayout {
    protected TextView ipw;
    protected OnClickListener pgk;
    protected List<LinearLayout> wis;
    protected Map<Integer, TextView> wit = new HashMap();
    protected boolean wiu = true;
    public boolean wiv;
    public OnClickListener wiw;
    public OnClickListener wix;

    public FTSMainUIEducationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    public FTSMainUIEducationLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KC();
    }

    private void KC() {
        setOrientation(1);
        this.wis = new ArrayList();
    }

    public final void bZd() {
        this.wiu = false;
    }

    public final void ar() {
        bZe();
        try {
            if (!V(j.kb("educationTab"))) {
                bZf();
            }
        } catch (Exception e) {
            bZf();
        }
        try {
            if (this.wiu) {
                CharSequence optString = j.kb("educationHotword").optJSONArray("items").optJSONObject(0).optString("hotword");
                if (!bg.mA(optString)) {
                    LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.i.ddR, null);
                    ((TextView) linearLayout.findViewById(R.h.bWs)).setText(optString);
                    linearLayout.setOnClickListener(this.wiw);
                    linearLayout.setTag(optString);
                    addView(linearLayout);
                    this.wis.add(linearLayout);
                }
            }
        } catch (Exception e2) {
        }
        if (this.wiv) {
            b Ro = ((e) h.h(e.class)).Ro();
            if (Ro.hoO.size() != 0) {
                linearLayout = (LinearLayout) inflate(getContext(), R.i.ddS, null);
                ((TextView) linearLayout.findViewById(R.h.cJh)).setText(Ro.fNG);
                ImageView[] imageViewArr = new ImageView[]{(ImageView) linearLayout.findViewById(R.h.boI), (ImageView) linearLayout.findViewById(R.h.boJ), (ImageView) linearLayout.findViewById(R.h.boK), (ImageView) linearLayout.findViewById(R.h.boL)};
                ImageView imageView = (ImageView) linearLayout.findViewById(R.h.clm);
                int i = 0;
                while (i < Ro.hoO.size() && i < 4) {
                    c cVar = (c) Ro.hoO.get(i);
                    a aVar = new a();
                    aVar.hJa = R.k.bes;
                    aVar.hJi = true;
                    n.GW().a(cVar.jhe, imageViewArr[i], aVar.Hg());
                    imageViewArr[i].setVisibility(0);
                    imageViewArr[i].setTag(cVar);
                    if (this.wix != null) {
                        imageViewArr[i].setOnClickListener(this.wix);
                    }
                    i++;
                }
                if (Ro.hoO.size() > 0) {
                    imageView.setVisibility(0);
                    imageView.setTag("more-click");
                    imageView.setOnClickListener(this.wix);
                }
                addView(linearLayout);
                this.wis.add(linearLayout);
            }
            String str = "";
            for (c cVar2 : Ro.hoO) {
                str = str + cVar2.username + ";";
            }
            g.oUh.i(14630, new Object[]{com.tencent.mm.as.g.hPK, Ro.fNG, str, Integer.valueOf(Ro.jhd), Long.valueOf(System.currentTimeMillis() / 1000)});
        }
    }

    public final void U(JSONObject jSONObject) {
        bZe();
        try {
            if (!V(jSONObject)) {
                bZf();
            }
        } catch (Exception e) {
            bZf();
        }
    }

    private void bZe() {
        for (LinearLayout removeView : this.wis) {
            removeView(removeView);
        }
        this.wis.clear();
        this.wit.clear();
    }

    protected boolean V(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        if (this.ipw == null) {
            this.ipw = (TextView) findViewById(R.h.bKQ);
        }
        CharSequence optString = jSONObject.optString("title");
        if (bg.mA(optString)) {
            this.ipw.setText(R.l.ePR);
        } else {
            this.ipw.setText(optString);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray == null) {
            return false;
        }
        int T;
        if (v.ea(ab.getContext()).equalsIgnoreCase("en")) {
            T = com.tencent.mm.bg.a.T(getContext(), R.f.aWF);
        } else {
            T = com.tencent.mm.bg.a.T(getContext(), R.f.aXI);
        }
        int i = 0;
        Object obj = null;
        JSONObject jSONObject2 = null;
        String str = null;
        String str2 = null;
        while (i < optJSONArray.length()) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (i % 3 == 0) {
                str2 = optJSONObject.optString("hotword");
            } else if (i % 3 == 1) {
                str = optJSONObject.optString("hotword");
                JSONObject jSONObject3 = optJSONObject;
                optJSONObject = jSONObject2;
            } else {
                a(str2, jSONObject2, str, obj, optJSONObject.optString("hotword"), optJSONObject, T);
                obj = null;
                optJSONObject = null;
                str = null;
                str2 = null;
            }
            i++;
            jSONObject2 = optJSONObject;
        }
        if (!(str2 == null || jSONObject2 == null)) {
            a(str2, jSONObject2, str, obj, null, null, T);
        }
        return true;
    }

    private void bZf() {
        a(getContext().getString(R.l.ePS), null, getContext().getString(R.l.ePP), null, getContext().getString(R.l.ePQ), null, com.tencent.mm.bg.a.T(getContext(), R.f.aXI));
        bZg();
    }

    protected void bZg() {
    }

    protected final void a(String str, Object obj, String str2, Object obj2, String str3, Object obj3, int i) {
        w.i("MicroMsg.FTS.FTSMainUIEducationLayout", "addCellLayout %s %s %s", new Object[]{str, str2, str3});
        if (!bg.mA(str)) {
            LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.i.ddP, null);
            TextView textView = (TextView) linearLayout.findViewById(R.h.cHN);
            textView.setText(str);
            textView.setTag(obj);
            textView.setVisibility(0);
            textView.setOnClickListener(this.pgk);
            this.wit.put(Integer.valueOf(d.a((JSONObject) obj, str, getContext())), textView);
            if (!bg.mA(str2)) {
                textView = (TextView) linearLayout.findViewById(R.h.cHO);
                textView.setText(str2);
                textView.setTag(obj2);
                textView.setVisibility(0);
                textView.setOnClickListener(this.pgk);
                View findViewById = linearLayout.findViewById(R.h.bJF);
                findViewById.getLayoutParams().height = i;
                findViewById.setVisibility(0);
                this.wit.put(Integer.valueOf(d.a((JSONObject) obj2, str2, getContext())), textView);
                if (!bg.mA(str3)) {
                    textView = (TextView) linearLayout.findViewById(R.h.cHP);
                    textView.setText(str3);
                    textView.setTag(obj3);
                    textView.setVisibility(0);
                    textView.setOnClickListener(this.pgk);
                    findViewById = linearLayout.findViewById(R.h.bJG);
                    findViewById.getLayoutParams().height = i;
                    findViewById.setVisibility(0);
                    this.wit.put(Integer.valueOf(d.a((JSONObject) obj3, str3, getContext())), textView);
                }
            }
            this.wis.add(linearLayout);
            addView(linearLayout);
        }
    }

    public final void i(OnClickListener onClickListener) {
        this.pgk = onClickListener;
    }

    public final void BS(int i) {
        for (Entry entry : this.wit.entrySet()) {
            if (((Integer) entry.getKey()).intValue() == i) {
                ((TextView) entry.getValue()).setTextColor(Color.parseColor("#B5B5B5"));
            } else {
                ((TextView) entry.getValue()).setTextColor(Color.parseColor("#45C01A"));
            }
        }
    }

    public final String BT(int i) {
        TextView textView = (TextView) this.wit.get(Integer.valueOf(i));
        return textView == null ? "" : textView.getText().toString();
    }
}
