package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.as.d;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIEducationLayoutWithAll extends FTSMainUIEducationLayout {
    public FTSMainUIEducationLayoutWithAll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSMainUIEducationLayoutWithAll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void bZg() {
        cV(getContext().getResources().getString(R.l.eQg), d.a(null, getContext().getString(R.l.eQg), getContext()));
    }

    private void cV(String str, int i) {
        LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.i.ddQ, null);
        linearLayout.findViewById(R.h.cHQ).setOnClickListener(this.pgk);
        ((TextView) linearLayout.findViewById(R.h.cHQ)).setText(str);
        this.wis.add(linearLayout);
        this.wit.put(Integer.valueOf(i), (TextView) linearLayout.findViewById(R.h.cHQ));
        addView(linearLayout);
    }

    protected final boolean V(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray == null) {
            return false;
        }
        int T;
        if (v.ea(ab.getContext()).equalsIgnoreCase("en")) {
            T = a.T(getContext(), R.f.aWF);
        } else {
            T = a.T(getContext(), R.f.aXI);
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
        JSONArray optJSONArray2 = jSONObject.optJSONArray("all");
        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
            bZg();
        } else {
            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(0);
            cV(optJSONObject2.optString("hotword"), optJSONObject2.optInt("businessType"));
        }
        return true;
    }
}
