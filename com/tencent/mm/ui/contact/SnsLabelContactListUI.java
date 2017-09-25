package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.e.a.hj;
import com.tencent.mm.e.a.nc;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class SnsLabelContactListUI extends MMActivity {
    private ListView mZO;
    private bbk pyI;
    private a vZQ;
    private ArrayList<String> vZR = new ArrayList();
    private int vZS;
    private String vZT;
    private b vZU;

    private static class a extends BaseAdapter {
        private Context context = null;
        private ar qzL = null;
        private Map<Integer, com.tencent.mm.j.a> vZW = new HashMap();
        private ColorStateList vZX;
        private ColorStateList vZY;

        public a(Context context, List<String> list) {
            this.context = context;
            this.vZW.clear();
            ap.yY();
            this.qzL = com.tencent.mm.u.c.wR();
            int i = 0;
            for (String str : list) {
                com.tencent.mm.j.a aVar = new com.tencent.mm.j.a();
                aVar.setUsername(str);
                int i2 = i + 1;
                this.vZW.put(Integer.valueOf(i), aVar);
                i = i2;
            }
            try {
                XmlPullParser xml = context.getResources().getXml(R.e.aVa);
                XmlPullParser xml2 = context.getResources().getXml(R.e.aVb);
                this.vZX = ColorStateList.createFromXml(context.getResources(), xml);
                this.vZY = ColorStateList.createFromXml(context.getResources(), xml2);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e2, "", new Object[0]);
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
            c cVar;
            if (view == null) {
                view = View.inflate(this.context, R.i.cZz, null);
                c cVar2 = new c();
                cVar2.mTs = (TextView) view.findViewById(R.h.bGk);
                cVar2.kwV = (MaskLayout) view.findViewById(R.h.bGi);
                cVar2.jZz = (TextView) view.findViewById(R.h.bGm);
                cVar2.waa = (TextView) view.findViewById(R.h.bGg);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            getItem(i);
            com.tencent.mm.j.a aVar = (com.tencent.mm.j.a) getItem(i);
            cVar.mTs.setVisibility(8);
            cVar.jZz.setTextColor(!o.fE(aVar.field_username) ? this.vZX : this.vZY);
            com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) cVar.kwV.view, aVar.field_username, true);
            cVar.waa.setVisibility(8);
            cVar.kwV.setVisibility(0);
            cVar.jZz.setText(h.b(this.context, aVar.tL(), cVar.jZz.getTextSize()));
            cVar.jZz.setVisibility(0);
            return view;
        }
    }

    private static class c {
        TextView jZz;
        MaskLayout kwV;
        TextView mTs;
        TextView waa;
    }

    private class b extends com.tencent.mm.sdk.b.c<nc> {
        final /* synthetic */ SnsLabelContactListUI vZV;

        private b(SnsLabelContactListUI snsLabelContactListUI) {
            this.vZV = snsLabelContactListUI;
            this.usg = nc.class.getName().hashCode();
        }

        /* synthetic */ b(SnsLabelContactListUI snsLabelContactListUI, byte b) {
            this(snsLabelContactListUI);
            this.usg = nc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            nc ncVar = (nc) bVar;
            if (!(ncVar instanceof nc)) {
                return false;
            }
            this.vZV.pyI = ncVar.fUl.fMP;
            if (this.vZV.pyI != null) {
                this.vZV.bYp();
                this.vZV.KC();
            } else {
                this.vZV.KC();
                g.a(this.vZV, this.vZV.getString(R.l.eWR), "", new OnClickListener(this) {
                    final /* synthetic */ b vZZ;

                    {
                        this.vZZ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.vZZ.vZV.finish();
                    }
                });
            }
            return true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.vZU = new b();
        com.tencent.mm.sdk.b.a.urY.b(this.vZU);
        this.vZS = getIntent().getIntExtra("sns_label_sns_info", -1);
        if (this.vZS == -1) {
            finish();
            return;
        }
        com.tencent.mm.sdk.b.b hjVar = new hj();
        hjVar.fMN.fII = this.vZS;
        com.tencent.mm.sdk.b.a.urY.m(hjVar);
        this.pyI = hjVar.fMO.fMP;
        if (this.pyI == null) {
            return;
        }
        if ((this.pyI.tQZ == 3 && this.pyI.ucy != null && this.pyI.ucy.size() > 0) || (this.pyI.tQZ == 5 && this.pyI.tPQ != null && this.pyI.tPQ.size() > 0)) {
            bYp();
            KC();
        }
    }

    private void bYp() {
        Iterator it;
        if (this.pyI.tQZ == 3) {
            this.vZT = getString(R.l.eWP);
            it = this.pyI.ucy.iterator();
            while (it.hasNext()) {
                this.vZR.add(((avx) it.next()).tZr);
            }
        } else if (this.pyI.tQZ == 5) {
            this.vZT = getString(R.l.eWQ);
            it = this.pyI.tPQ.iterator();
            while (it.hasNext()) {
                this.vZR.add(((avx) it.next()).tZr);
            }
        }
    }

    protected final void KC() {
        qP(this.vZT);
        findViewById(R.h.cbT).setVisibility(8);
        this.mZO = (ListView) findViewById(R.h.bnw);
        ((TextView) findViewById(R.h.bLM)).setVisibility(8);
        findViewById(R.h.bnG).setVisibility(8);
        this.mZO.setBackgroundColor(getResources().getColor(R.e.white));
        ((View) this.mZO.getParent()).setBackgroundColor(getResources().getColor(R.e.white));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsLabelContactListUI vZV;

            {
                this.vZV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vZV.finish();
                return true;
            }
        });
        ks(false);
        if (this.vZR != null && this.vZR.size() != 0) {
            this.vZQ = new a(this, this.vZR);
            this.mZO.setAdapter(this.vZQ);
            this.mZO.setVisibility(0);
            this.mZO.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ SnsLabelContactListUI vZV;

                {
                    this.vZV = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    Intent intent = new Intent();
                    com.tencent.mm.j.a aVar = (com.tencent.mm.j.a) this.vZV.vZQ.getItem(i);
                    com.tencent.mm.plugin.sns.b.g gVar = m.pQF;
                    if (gVar == null) {
                        this.vZV.finish();
                        return;
                    }
                    intent = gVar.f(intent, aVar.field_username);
                    if (intent == null) {
                        this.vZV.finish();
                        return;
                    }
                    intent.putExtra("Contact_User", aVar.field_username);
                    WorkerProfile.oC().fxt.d(intent, this.vZV);
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        if (this.vZQ != null) {
            this.vZQ.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.vZU);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.cTF;
    }
}
