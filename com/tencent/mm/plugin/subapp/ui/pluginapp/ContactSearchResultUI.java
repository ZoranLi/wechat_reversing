package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
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
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.x.n;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI extends MMActivity {
    private static ae hgZ = new ae(Looper.getMainLooper());
    private LinkedList<awp> hkm = new LinkedList();
    private ListView qUZ;
    private b qVa;
    private Map<String, c> qVb;

    private static abstract class a implements Runnable {
        public String iconUrl;
        public String username;

        public final void dH(String str, String str2) {
            this.username = str;
            this.iconUrl = str2;
        }
    }

    private class b extends BaseAdapter {
        private Context mContext;
        final /* synthetic */ ContactSearchResultUI qVc;

        public final /* synthetic */ Object getItem(int i) {
            return ux(i);
        }

        public b(ContactSearchResultUI contactSearchResultUI, Context context) {
            this.qVc = contactSearchResultUI;
            this.mContext = context;
        }

        public final int getCount() {
            return this.qVc.hkm == null ? 0 : this.qVc.hkm.size();
        }

        private awp ux(int i) {
            return this.qVc.hkm == null ? null : (awp) this.qVc.hkm.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            int i2 = 8;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.dnl, null);
                dVar = new d();
                dVar.ipv = (ImageView) view.findViewById(R.h.bqH);
                dVar.jZz = (TextView) view.findViewById(R.h.coe);
                dVar.jZA = view.findViewById(R.h.cLv);
                dVar.jZB = (TextView) view.findViewById(R.h.bXU);
                dVar.jZE = view.findViewById(R.h.btH);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            awp ux = ux(i);
            if (ux == null) {
                w.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
            } else {
                dVar.username = ux.ttp.tZr;
                dVar.iconUrl = ux.tqc;
                dVar.ipv.setTag(dVar.username);
                dVar.aey();
                String str = ux.ttp.tZr;
                c cVar = (c) this.qVc.qVb.get(str);
                if (cVar == null) {
                    c cVar2 = new c();
                    this.qVc.qVb.put(str, cVar2);
                    my myVar = ux.tMW;
                    if (myVar != null) {
                        com.tencent.mm.modelbiz.BizInfo.ExtInfo.c Db;
                        BizInfo bizInfo = new BizInfo();
                        bizInfo.field_username = str;
                        bizInfo.field_brandFlag = myVar.hAR;
                        bizInfo.field_brandIconURL = myVar.hAU;
                        bizInfo.field_brandInfo = myVar.hAT;
                        bizInfo.field_extInfo = myVar.hAS;
                        if (bizInfo.bd(false) != null) {
                            Db = bizInfo.bd(false).Db();
                        } else {
                            Db = null;
                        }
                        if (Db != null) {
                            boolean z = bizInfo.bd(false).Dd() && !bg.mA(Db.hvm);
                            cVar2.jZx = z;
                            cVar2.jZw = ux.tMP != 0;
                        }
                    }
                    cVar = cVar2;
                }
                dVar.jZA.setVisibility(cVar.jZw ? 0 : 8);
                View view2 = dVar.jZE;
                if (cVar.jZx) {
                    i2 = 0;
                }
                view2.setVisibility(i2);
                w.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", new Object[]{Integer.valueOf(ux.tMP)});
                try {
                    dVar.jZB.setText(h.b(this.mContext, bg.mz(ux.hAG), dVar.jZB.getTextSize()));
                } catch (Exception e) {
                    dVar.jZB.setText("");
                }
                try {
                    TextView textView = dVar.jZz;
                    Context context = this.mContext;
                    CharSequence mz = !bg.mA(ux.tLj.tZr) ? ux.tLj.tZr : !bg.mA(ux.hAI) ? ux.hAI : bg.mz(ux.ttp.tZr);
                    textView.setText(h.b(context, mz, dVar.jZz.getTextSize()));
                } catch (Exception e2) {
                    dVar.jZz.setText("");
                }
            }
            return view;
        }
    }

    private static class c {
        protected boolean jZw;
        protected boolean jZx;
    }

    private static class d implements com.tencent.mm.modelbiz.l.a.a, Runnable {
        public String iconUrl;
        public ImageView ipv;
        public View jZA;
        public TextView jZB;
        public View jZE;
        public TextView jZz;
        public a qVe = new a(this) {
            final /* synthetic */ d qVf;

            {
                this.qVf = r1;
            }

            public final void run() {
                if (!bg.mA(this.username) && !bg.mA(this.qVf.username) && this.username.equals(this.qVf.username)) {
                    Bitmap b = l.b(this.username, this.iconUrl, 0);
                    if (b != null && !b.isRecycled()) {
                        this.qVf.aey();
                    }
                }
            }
        };
        public String username;

        public d() {
            com.tencent.mm.modelbiz.w.DP().a(this);
        }

        public final void aey() {
            if (this.ipv != null) {
                ap.vL().D(this);
            }
        }

        public final void run() {
            final Bitmap il = l.il(this.username);
            if (il != null) {
                ContactSearchResultUI.hgZ.post(new Runnable(this) {
                    final /* synthetic */ d qVf;

                    public final void run() {
                        if (this.qVf.ipv != null && this.qVf.ipv.getTag() != null && this.qVf.username != null && this.qVf.username.equals(this.qVf.ipv.getTag())) {
                            this.qVf.ipv.setImageBitmap(il);
                        }
                    }
                });
            } else {
                ContactSearchResultUI.hgZ.post(new Runnable(this) {
                    final /* synthetic */ d qVf;

                    {
                        this.qVf = r1;
                    }

                    public final void run() {
                        if (this.qVf.ipv != null) {
                            this.qVf.ipv.setImageResource(R.g.bcY);
                            this.qVf.qVe.dH(this.qVf.username, this.qVf.iconUrl);
                            ap.vL().e(this.qVf.qVe, 200);
                        }
                    }
                });
            }
        }

        public final void in(String str) {
            if (str != null && str.equals(this.username)) {
                this.qVe.dH(this.username, this.iconUrl);
                ap.vL().e(this.qVe, 200);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final void KC() {
        zi(R.l.cZL);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactSearchResultUI qVc;

            {
                this.qVc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qVc.finish();
                return true;
            }
        });
        this.qVb = new HashMap();
        this.qUZ = (ListView) findViewById(R.h.cyF);
        this.qUZ.setEmptyView((TextView) findViewById(R.h.empty));
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("result");
        final int intExtra = getIntent().getIntExtra("add_more_friend_search_scene", 0);
        if (byteArrayExtra != null) {
            try {
                awr com_tencent_mm_protocal_c_awr = (awr) new awr().aD(byteArrayExtra);
                if (com_tencent_mm_protocal_c_awr != null) {
                    this.hkm = com_tencent_mm_protocal_c_awr.tDS;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ContactSearchResultUI", e, "", new Object[0]);
            }
        }
        if (this.hkm != null && this.hkm.size() != 0) {
            this.qVa = new b(this, this);
            this.qUZ.setAdapter(this.qVa);
            this.qUZ.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ ContactSearchResultUI qVc;

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    int headerViewsCount = i - this.qVc.qUZ.getHeaderViewsCount();
                    if (headerViewsCount >= 0 && headerViewsCount < this.qVc.qUZ.getCount()) {
                        awp com_tencent_mm_protocal_c_awp = (awp) this.qVc.qUZ.getItemAtPosition(headerViewsCount);
                        String str = com_tencent_mm_protocal_c_awp.ttp.tZr;
                        ap.yY();
                        af Rc = com.tencent.mm.u.c.wR().Rc(str);
                        if (com.tencent.mm.j.a.ez(Rc.field_type)) {
                            Intent intent = new Intent();
                            intent.putExtra("Contact_User", str);
                            intent.putExtra("Contact_Scene", 3);
                            if (str != null && str.length() > 0) {
                                if (Rc.bLe()) {
                                    g.oUh.A(10298, str + ",35");
                                    intent.putExtra("Contact_Scene", 35);
                                }
                                com.tencent.mm.bb.d.b(this.qVc, "profile", ".ui.ContactInfoUI", intent);
                                return;
                            }
                            return;
                        }
                        if ((com_tencent_mm_protocal_c_awp.tMP & 8) > 0) {
                            g.oUh.A(10298, com_tencent_mm_protocal_c_awp.ttp.tZr + ",35");
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", com_tencent_mm_protocal_c_awp.ttp.tZr);
                        intent2.putExtra("Contact_Alias", com_tencent_mm_protocal_c_awp.hAI);
                        intent2.putExtra("Contact_Nick", com_tencent_mm_protocal_c_awp.tLj.tZr);
                        intent2.putExtra("Contact_Signature", com_tencent_mm_protocal_c_awp.hAG);
                        intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(com_tencent_mm_protocal_c_awp.hAM, com_tencent_mm_protocal_c_awp.hAE, com_tencent_mm_protocal_c_awp.hAF));
                        intent2.putExtra("Contact_Sex", com_tencent_mm_protocal_c_awp.hAD);
                        intent2.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_awp.tMQ);
                        intent2.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_awp.tMP);
                        intent2.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_awp.tMT);
                        intent2.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_awp.tMR);
                        intent2.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_awp.tMS);
                        intent2.putExtra("Contact_KSnsIFlag", com_tencent_mm_protocal_c_awp.tMV.hAO);
                        intent2.putExtra("Contact_KSnsBgId", com_tencent_mm_protocal_c_awp.tMV.hAQ);
                        intent2.putExtra("Contact_KSnsBgUrl", com_tencent_mm_protocal_c_awp.tMV.hAP);
                        intent2.putExtra("Contact_Scene", 35);
                        if (intExtra != 0) {
                            intent2.putExtra("add_more_friend_search_scene", intExtra);
                        }
                        if (com_tencent_mm_protocal_c_awp.tMW != null) {
                            try {
                                intent2.putExtra("Contact_customInfo", com_tencent_mm_protocal_c_awp.tMW.toByteArray());
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.ContactSearchResultUI", e, "", new Object[0]);
                            }
                        }
                        if ((com_tencent_mm_protocal_c_awp.tMP & 8) > 0) {
                            g.oUh.A(10298, com_tencent_mm_protocal_c_awp.ttp.tZr + ",35");
                        }
                        com.tencent.mm.bb.d.b(this.qVc, "profile", ".ui.ContactInfoUI", intent2);
                    }
                }
            });
            this.qUZ.setOnScrollListener(new com.tencent.mm.ui.applet.a());
        }
    }

    protected final int getLayoutId() {
        return R.i.cZL;
    }

    protected void onDestroy() {
        n.Bz().cancel();
        if (this.qVb != null) {
            this.qVb.clear();
        }
        super.onDestroy();
    }
}
