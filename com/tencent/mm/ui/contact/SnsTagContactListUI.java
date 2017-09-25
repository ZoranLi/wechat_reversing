package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class SnsTagContactListUI extends MMActivity {
    private ListView mZO;
    private a wab;
    private List<Long> wac = new ArrayList();

    private static class a extends BaseAdapter {
        private Context context = null;
        private ar qzL = null;
        private Map<Integer, com.tencent.mm.j.a> vZW = new HashMap();
        private ColorStateList vZX;
        private ColorStateList vZY;
        private Map<Integer, String> wae = new HashMap();

        public a(Context context, List<Long> list) {
            this.context = context;
            this.vZW.clear();
            this.wae.clear();
            ap.yY();
            this.qzL = c.wR();
            int i = 0;
            for (Long longValue : list) {
                long longValue2 = longValue.longValue();
                j jVar = m.pQD;
                if (jVar != null) {
                    for (String str : jVar.dd(longValue2)) {
                        com.tencent.mm.j.a aVar = new com.tencent.mm.j.a();
                        aVar.setUsername(str);
                        this.wae.put(Integer.valueOf(this.vZW.size()), jVar.de(longValue2));
                        int i2 = i + 1;
                        this.vZW.put(Integer.valueOf(i), aVar);
                        i = i2;
                    }
                }
                i = i;
            }
            try {
                XmlPullParser xml = context.getResources().getXml(R.e.aVa);
                XmlPullParser xml2 = context.getResources().getXml(R.e.aVb);
                this.vZX = ColorStateList.createFromXml(context.getResources(), xml);
                this.vZY = ColorStateList.createFromXml(context.getResources(), xml2);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SnsTagContactList", e, "", new Object[0]);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.SnsTagContactList", e2, "", new Object[0]);
            }
        }

        public final int getCount() {
            return this.vZW.size();
        }

        public final Object getItem(int i) {
            if (i < 0) {
                return null;
            }
            com.tencent.mm.j.a aVar = (com.tencent.mm.j.a) this.vZW.get(Integer.valueOf(i));
            if (aVar.field_showHead != 0) {
                return aVar;
            }
            x Rc = this.qzL.Rc(aVar.field_username);
            if (Rc == null) {
                return aVar;
            }
            this.vZW.put(Integer.valueOf(i), Rc);
            return Rc;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = View.inflate(this.context, R.i.cZz, null);
                b bVar2 = new b();
                bVar2.mTs = (TextView) view.findViewById(R.h.bGk);
                bVar2.kwV = (MaskLayout) view.findViewById(R.h.bGi);
                bVar2.jZz = (TextView) view.findViewById(R.h.bGm);
                bVar2.waa = (TextView) view.findViewById(R.h.bGg);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (((com.tencent.mm.j.a) getItem(i - 1)) == null) {
                Object obj = "";
            } else {
                String BO = BO(i - 1);
            }
            com.tencent.mm.j.a aVar = (com.tencent.mm.j.a) getItem(i);
            if (i == 0) {
                bVar.mTs.setVisibility(0);
                bVar.mTs.setText(BO(i));
                bVar.mTs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else if (i <= 0 || BO(i).equals(r1)) {
                bVar.mTs.setVisibility(8);
            } else {
                bVar.mTs.setVisibility(0);
                bVar.mTs.setText(BO(i));
                bVar.mTs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            bVar.jZz.setTextColor(!o.fE(aVar.field_username) ? this.vZX : this.vZY);
            com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) bVar.kwV.view, aVar.field_username, true);
            bVar.waa.setVisibility(8);
            bVar.kwV.setVisibility(0);
            bVar.jZz.setText(h.b(this.context, aVar.tL(), bVar.jZz.getTextSize()));
            bVar.jZz.setVisibility(0);
            return view;
        }

        private String BO(int i) {
            if (this.wae.containsKey(Integer.valueOf(i))) {
                return (String) this.wae.get(Integer.valueOf(i));
            }
            return "";
        }
    }

    private static class b {
        TextView jZz;
        MaskLayout kwV;
        TextView mTs;
        TextView waa;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final void KC() {
        zi(R.l.eWW);
        findViewById(R.h.cbT).setVisibility(8);
        this.mZO = (ListView) findViewById(R.h.bnw);
        long[] longArrayExtra = getIntent().getLongArrayExtra("sns_tag_list");
        if (longArrayExtra == null) {
            finish();
            return;
        }
        for (long valueOf : longArrayExtra) {
            this.wac.add(Long.valueOf(valueOf));
        }
        ((TextView) findViewById(R.h.bLM)).setVisibility(8);
        findViewById(R.h.bnG).setVisibility(8);
        this.mZO.setBackgroundColor(getResources().getColor(R.e.white));
        ((View) this.mZO.getParent()).setBackgroundColor(getResources().getColor(R.e.white));
        this.wab = new a(this, this.wac);
        this.mZO.setAdapter(this.wab);
        this.mZO.setVisibility(0);
        this.mZO.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SnsTagContactListUI wad;

            {
                this.wad = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                com.tencent.mm.j.a aVar = (com.tencent.mm.j.a) this.wad.wab.getItem(i);
                g gVar = m.pQF;
                if (gVar == null) {
                    this.wad.finish();
                    return;
                }
                Intent f = gVar.f(intent, aVar.field_username);
                if (f == null) {
                    this.wad.finish();
                } else {
                    d.b(this.wad.uSU.uTo, "sns", ".ui.SnsUserUI", f);
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagContactListUI wad;

            {
                this.wad = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.wad.finish();
                return true;
            }
        });
        ks(false);
    }

    public void onResume() {
        super.onResume();
        if (this.wab != null) {
            this.wab.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.cTF;
    }
}
