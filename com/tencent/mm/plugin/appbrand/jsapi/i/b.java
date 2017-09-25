package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 107;
    private static final String NAME = "showActionSheet";

    private static final class a extends BaseAdapter {
        private final ArrayList<String> iUM;
        private final int iUN;

        private static final class a {
            TextView iUO;
        }

        public final /* synthetic */ Object getItem(int i) {
            return hO(i);
        }

        public a(ArrayList<String> arrayList, int i) {
            this.iUM = arrayList;
            this.iUN = i;
        }

        public final int getCount() {
            return this.iUM.size();
        }

        private String hO(int i) {
            return (String) this.iUM.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(viewGroup.getContext(), R.i.cUs, null);
                a aVar2 = new a();
                aVar2.iUO = (TextView) view.findViewById(R.h.title);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.iUO.setText(hO(i));
            aVar.iUO.setTextColor(this.iUN);
            return view;
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b == null) {
            w.w("MicroMsg.JsApiShowActionSheet", "invoke JsApi JsApiShowActionSheet failed, current page view is null.");
            mVar.x(i, d("fail", null));
            return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.m.j(b);
        String optString = jSONObject.optString("itemList");
        final ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add((String) jSONArray.get(i2));
            }
            final m mVar2 = mVar;
            final JSONObject jSONObject2 = jSONObject;
            final int i3 = i;
            af.v(new Runnable(this) {
                final /* synthetic */ b iUJ;

                public final void run() {
                    if (mVar2.aaI) {
                        Context a = this.iUJ.a(mVar2);
                        final com.tencent.mm.plugin.appbrand.widget.b.a aVar = new com.tencent.mm.plugin.appbrand.widget.b.a(a);
                        int at = h.at(jSONObject2.optString("itemColor", ""), Color.parseColor("#000000"));
                        View view = (ViewGroup) View.inflate(a, R.i.diB, null);
                        aVar.setContentView(view);
                        ListView listView = (ListView) view.findViewById(R.h.list);
                        listView.setAdapter(new a(arrayList, at));
                        listView.setOnItemClickListener(new OnItemClickListener(this) {
                            final /* synthetic */ AnonymousClass1 iUL;

                            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                Map hashMap = new HashMap();
                                hashMap.put("tapIndex", Integer.valueOf(i));
                                mVar2.x(i3, this.iUL.iUJ.d("ok", hashMap));
                                aVar.dismiss();
                            }
                        });
                        aVar.setOnCancelListener(new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass1 iUL;

                            {
                                this.iUL = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                mVar2.x(i3, this.iUL.iUJ.d("cancel", null));
                            }
                        });
                        mVar2.ixr.a(aVar);
                    }
                }
            });
        } catch (Exception e) {
            w.e("MicroMsg.JsApiShowActionSheet", e.getMessage());
            mVar.x(i, d("fail", null));
        }
    }
}
