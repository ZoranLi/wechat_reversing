package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.md;
import com.tencent.mm.e.a.ri;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.c.abc;
import com.tencent.mm.protocal.c.ayn;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.y.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI extends MMActivity implements e {
    private DataSetObserver Br;
    private ListView Fg;
    private String jmd;
    private int mMode;
    private MMSwitchBtn rzv;
    private a uWb;
    private p uWc;

    private static class a extends BaseAdapter {
        private LayoutInflater dZ;
        private String jmd;
        private Context mContext;
        private int mMode;
        private OnClickListener mOnClickListener;
        LinkedList<a> uWj = new LinkedList();
        LinkedList<a> uWk = new LinkedList();
        private c uWl;

        private static class a {
            String title;
            String url;
            String username;
        }

        private static class b {
            ImageView ioV;
            TextView ioX;
            TextView uWp;
        }

        public final /* synthetic */ Object getItem(int i) {
            return zx(i);
        }

        public a(Context context, LayoutInflater layoutInflater, final int i, String str) {
            this.mContext = context;
            this.mMode = i;
            this.jmd = str;
            this.dZ = layoutInflater;
            this.mOnClickListener = new OnClickListener(this) {
                final /* synthetic */ a uWn;

                public final void onClick(View view) {
                    final String str = (String) view.getTag();
                    if (!TextUtils.isEmpty(str)) {
                        g.a(view.getContext(), i == 1 ? R.l.eEX : R.l.eFa, 0, i == 1 ? R.l.eEY : R.l.dHT, R.l.cancel, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 uWo;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                int i2 = 0;
                                while (i2 < this.uWo.uWn.uWj.size()) {
                                    a aVar = (a) this.uWo.uWn.uWj.get(i2);
                                    if (aVar == null || !str.equals(aVar.username)) {
                                        i2++;
                                    } else {
                                        this.uWo.uWn.uWk.add(this.uWo.uWn.uWj.remove(i2));
                                        this.uWo.uWn.notifyDataSetChanged();
                                        WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(str);
                                        String str = og == null ? "" : og.field_appId;
                                        if (i == 1) {
                                            w.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", Integer.valueOf(13798), Integer.valueOf(4), str, this.uWo.uWn.jmd);
                                            com.tencent.mm.plugin.report.service.g.oUh.i(13798, Integer.valueOf(4), str, Integer.valueOf(0), this.uWo.uWn.jmd, Long.valueOf(bg.Ny()));
                                            return;
                                        }
                                        com.tencent.mm.plugin.report.service.g.oUh.i(13796, Integer.valueOf(12), str, "", Integer.valueOf(0), Long.valueOf(bg.Ny()));
                                        return;
                                    }
                                }
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 uWo;

                            {
                                this.uWo = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }, R.e.aUd);
                    }
                }
            };
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hJi = true;
            aVar.hJf = com.tencent.mm.modelappbrand.a.a.AX();
            this.uWl = aVar.Hg();
        }

        public final int getCount() {
            return this.uWj.size();
        }

        private a zx(int i) {
            return (a) this.uWj.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            a zx = zx(i);
            if (view == null) {
                view = this.dZ.inflate(R.i.dnS, viewGroup, false);
                b bVar2 = new b();
                bVar2.ioV = (ImageView) view.findViewById(R.h.bqI);
                bVar2.ioX = (TextView) view.findViewById(R.h.cIV);
                bVar2.uWp = (TextView) view.findViewById(R.h.cyI);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            n.GW().a(zx.url, bVar.ioV, this.uWl);
            bVar.ioX.setText(zx.title);
            if (this.mMode == 1) {
                bVar.uWp.setText(this.mContext.getString(R.l.eEU));
            } else {
                bVar.uWp.setText(this.mContext.getString(R.l.eEV));
            }
            bVar.uWp.setTag(zx.username);
            bVar.uWp.setOnClickListener(this.mOnClickListener);
            return view;
        }
    }

    static /* synthetic */ void a(ServiceNotifySettingsUI serviceNotifySettingsUI, LinkedList linkedList) {
        Collection linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ayn com_tencent_mm_protocal_c_ayn = (ayn) it.next();
            a aVar = new a();
            aVar.username = com_tencent_mm_protocal_c_ayn.username;
            aVar.title = com_tencent_mm_protocal_c_ayn.fFa;
            aVar.url = com_tencent_mm_protocal_c_ayn.uay;
            linkedList2.add(aVar);
        }
        a aVar2 = serviceNotifySettingsUI.uWb;
        aVar2.uWj.clear();
        if (!linkedList2.isEmpty()) {
            aVar2.uWj.addAll(linkedList2);
        }
        serviceNotifySettingsUI.uWb.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return R.i.dnT;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mMode = intent.getIntExtra("mode", 0);
        this.jmd = intent.getStringExtra("scene_id");
        intent.putExtra("scene_id", this.jmd);
        Object stringExtra = intent.getStringExtra("title");
        if (TextUtils.isEmpty(stringExtra)) {
            zi(R.l.eFc);
        } else {
            qP(stringExtra);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ServiceNotifySettingsUI uWd;

            {
                this.uWd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.uWd.finish();
                return false;
            }
        });
        this.rzv = (MMSwitchBtn) findViewById(R.h.checkbox);
        this.Fg = (ListView) findViewById(R.h.cbx);
        ((TextView) findViewById(R.h.cbp)).setText(this.mMode == 1 ? R.l.eEO : R.l.eEL);
        ((TextView) findViewById(R.h.cIT)).setText(this.mMode == 1 ? R.l.eEP : R.l.eEQ);
        this.uWb = new a(this, getLayoutInflater(), this.mMode, this.jmd);
        this.Fg.setAdapter(this.uWb);
        getString(R.l.dIO);
        this.uWc = g.a((Context) this, getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ ServiceNotifySettingsUI uWd;

            {
                this.uWd = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.uWd.finish();
            }
        });
        this.Br = new DataSetObserver(this) {
            final /* synthetic */ ServiceNotifySettingsUI uWd;

            {
                this.uWd = r1;
            }

            public final void onChanged() {
                this.uWd.findViewById(R.h.cbp).setVisibility(this.uWd.uWb.isEmpty() ? 4 : 0);
            }
        };
        this.uWb.registerDataSetObserver(this.Br);
        int i = 3;
        if (this.mMode == 1) {
            i = 12;
        }
        ap.vd().a(1145, (e) this);
        ap.vd().a(new k(i), 0);
        this.rzv.lS(bQA());
    }

    protected void onDestroy() {
        int i;
        int i2 = 3;
        ap.vd().b(1145, (e) this);
        final boolean bQA = bQA();
        final boolean z = this.rzv.wwz != bQA;
        final LinkedList linkedList = new LinkedList();
        if (z) {
            int i3;
            boolean z2;
            bek com_tencent_mm_protocal_c_bek = new bek();
            if (this.rzv.wwz) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            com_tencent_mm_protocal_c_bek.ufk = i3;
            if (this.mMode == 1) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            com_tencent_mm_protocal_c_bek.jOc = i3;
            linkedList.add(com_tencent_mm_protocal_c_bek);
            if (bQA) {
                z2 = false;
            } else {
                z2 = true;
            }
            com.tencent.mm.storage.w.a aVar = com.tencent.mm.storage.w.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
            if (this.mMode == 1) {
                aVar = com.tencent.mm.storage.w.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
            }
            ap.yY();
            com.tencent.mm.u.c.vr().a(aVar, Boolean.valueOf(z2));
            com.tencent.mm.sdk.b.a.urY.m(new md());
            if (this.mMode == 1) {
                if (com_tencent_mm_protocal_c_bek.ufk == 1) {
                    i3 = 3;
                } else {
                    i3 = 2;
                }
                w.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", Integer.valueOf(13798), Integer.valueOf(i3), this.jmd);
                com.tencent.mm.plugin.report.service.g.oUh.i(13798, Integer.valueOf(i3), "", Integer.valueOf(0), this.jmd, Long.valueOf(bg.Ny()));
            } else {
                i3 = com_tencent_mm_protocal_c_bek.ufk == 1 ? 11 : 10;
                com.tencent.mm.plugin.report.service.g.oUh.i(13796, Integer.valueOf(i3), "", "", Integer.valueOf(0), Long.valueOf(bg.Ny()));
            }
        }
        if (this.mMode == 1) {
            i = 2;
        } else {
            i = 1;
        }
        LinkedList linkedList2 = this.uWb.uWk;
        if (!(linkedList2 == null || linkedList2.isEmpty())) {
            if (this.mMode != 1) {
                i2 = 1;
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                bek com_tencent_mm_protocal_c_bek2 = new bek();
                com_tencent_mm_protocal_c_bek2.ufl = aVar2.username;
                com_tencent_mm_protocal_c_bek2.jOc = i2;
                com_tencent_mm_protocal_c_bek2.ufk = 1;
                linkedList.add(com_tencent_mm_protocal_c_bek2);
                b riVar = new ri();
                riVar.fYq.fCJ = aVar2.username;
                riVar.fYq.action = 2;
                riVar.fYq.fYs = i;
                com.tencent.mm.sdk.b.a.urY.m(riVar);
            }
        }
        if (!linkedList.isEmpty()) {
            ap.vd().a(1176, new e(this) {
                final /* synthetic */ ServiceNotifySettingsUI uWd;

                public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                    ap.vd().b(1176, (e) this);
                    w.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i != 0 || i2 != 0) {
                        s.makeText(this.uWd, R.l.eFb, 0).show();
                        if (z) {
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, Boolean.valueOf(bQA));
                            com.tencent.mm.sdk.b.a.urY.m(new md());
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            bek com_tencent_mm_protocal_c_bek = (bek) it.next();
                            b riVar = new ri();
                            riVar.fYq.fCJ = com_tencent_mm_protocal_c_bek.ufl;
                            riVar.fYq.action = 1;
                            riVar.fYq.fYs = i;
                            com.tencent.mm.sdk.b.a.urY.m(riVar);
                        }
                    }
                }
            });
            ap.vd().a(new j(linkedList), 0);
        }
        if (this.uWb != null) {
            this.uWb.unregisterDataSetObserver(this.Br);
        }
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (this.uWc != null) {
            this.uWc.dismiss();
        }
        w.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            final abc AR = ((k) kVar).AR();
            if (this.mMode == 1) {
                this.rzv.lS(AR.tHb);
            } else {
                this.rzv.lS(AR.tjd);
            }
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ServiceNotifySettingsUI uWd;

                public final void run() {
                    if (this.uWd.mMode == 1) {
                        ServiceNotifySettingsUI.a(this.uWd, AR.tHc);
                    } else {
                        ServiceNotifySettingsUI.a(this.uWd, AR.tje);
                    }
                }
            });
            return;
        }
        s.makeText(this, R.l.eET, 0).show();
    }

    private boolean bQA() {
        com.tencent.mm.storage.w.a aVar = com.tencent.mm.storage.w.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
        if (this.mMode == 1) {
            aVar = com.tencent.mm.storage.w.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
        }
        ap.yY();
        return com.tencent.mm.u.c.vr().c(aVar, true);
    }
}
