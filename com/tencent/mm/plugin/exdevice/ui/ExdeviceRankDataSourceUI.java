package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.bp;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.q;
import com.tencent.mm.protocal.c.abk;
import com.tencent.mm.protocal.c.bir;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceRankDataSourceUI extends MMActivity implements e {
    private ListView Fg;
    private b lnc;

    private static class a {
        bir lnf;
        com.tencent.mm.plugin.exdevice.h.b lnh;
        String mac;
    }

    private static final class b extends BaseAdapter {
        private c lir;
        List<a> lni = new LinkedList();

        private static class a {
            ImageView jbU;
            TextView kzl;
        }

        public final /* synthetic */ Object getItem(int i) {
            return mc(i);
        }

        public b() {
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hJa = R.g.beY;
            this.lir = aVar.Hg();
        }

        public final synchronized a vu(String str) {
            a aVar;
            if (!bg.mA(str)) {
                for (a aVar2 : this.lni) {
                    if (str.equals(aVar2.mac)) {
                        break;
                    }
                }
            }
            aVar2 = null;
            return aVar2;
        }

        public final synchronized a bX(String str, String str2) {
            a aVar;
            for (a aVar2 : this.lni) {
                if (aVar2 != null && ExdeviceRankDataSourceUI.a(str, str2, aVar2.lnf)) {
                    break;
                }
            }
            aVar2 = null;
            return aVar2;
        }

        public final int getCount() {
            return this.lni.size();
        }

        private a mc(int i) {
            return (a) this.lni.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            a mc = mc(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.i.dbO, null);
                aVar2.kzl = (TextView) view.findViewById(R.h.cml);
                aVar2.jbU = (ImageView) view.findViewById(R.h.bWv);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            w.d("MicroMsg.ExdeviceRankDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[]{Integer.valueOf(i), ExdeviceRankDataSourceUI.a(mc), mc.mac});
            aVar.kzl.setText(r1);
            n.GW().a(mc.lnf.muU, aVar.jbU, this.lir);
            return view;
        }
    }

    static /* synthetic */ a a(bir com_tencent_mm_protocal_c_bir) {
        a aVar = new a();
        aVar.lnh = null;
        if (com_tencent_mm_protocal_c_bir == null) {
            aVar.lnf = null;
        } else {
            aVar.lnf = com_tencent_mm_protocal_c_bir;
        }
        return aVar;
    }

    static /* synthetic */ String a(a aVar) {
        if (aVar == null || aVar.lnf == null) {
            return "";
        }
        if (!bg.mA(aVar.lnf.jNn)) {
            return aVar.lnf.jNn;
        }
        bp bpVar = aVar.lnh;
        String str = null;
        if (bpVar == null) {
            return "";
        }
        if (!bg.mA(bpVar.gtR)) {
            str = bpVar.gtR;
        } else if (!bg.mA(bpVar.gtS)) {
            str = bpVar.gtS;
        } else if (bpVar.field_mac != 0) {
            str = com.tencent.mm.plugin.exdevice.j.b.bG(bpVar.field_mac);
        } else if (!bg.mA(bpVar.field_deviceID)) {
            str = bpVar.field_deviceID;
        }
        return bg.mz(str);
    }

    static /* synthetic */ boolean a(String str, String str2, bir com_tencent_mm_protocal_c_bir) {
        return (com_tencent_mm_protocal_c_bir == null || str == null || str2 == null || !str.equals(com_tencent_mm_protocal_c_bir.tst) || !str2.equals(com_tencent_mm_protocal_c_bir.thD)) ? false : true;
    }

    protected final int getLayoutId() {
        return R.i.dbP;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceRankDataSourceUI lnd;

            {
                this.lnd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lnd.finish();
                return true;
            }
        });
        zi(R.l.dZm);
        ap.vd().a(1267, this);
        KC();
        ap.vd().a(new q(), 0);
    }

    protected final void KC() {
        this.Fg = (ListView) findViewById(R.h.cbx);
        View inflate = View.inflate(this, R.i.dbR, null);
        View inflate2 = View.inflate(this, R.i.dbQ, null);
        this.Fg.addHeaderView(inflate, null, false);
        this.Fg.addFooterView(inflate2, null, false);
        this.lnc = new b();
        this.Fg.setAdapter(this.lnc);
        ((ScrollView) findViewById(R.h.cAf)).scrollTo(0, 0);
        inflate2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceRankDataSourceUI lnd;

            {
                this.lnd = r1;
            }

            public final void onClick(View view) {
                this.lnd.startActivityForResult(new Intent(this.lnd.uSU.uTo, ExdeviceAddDataSourceUI.class), 1);
            }
        });
    }

    public void onBackPressed() {
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(1267, this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.d("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, reqCode(%s), resultCode(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1 && i2 == -1 && intent != null) {
            long longExtra = intent.getLongExtra("device_mac", 0);
            intent.getIntExtra("step", 0);
            if (longExtra == 0) {
                w.e("MicroMsg.ExdeviceRankDataSourceUI", "onActivityResult, mac is nil.");
                return;
            }
            String bG = com.tencent.mm.plugin.exdevice.j.b.bG(longExtra);
            if (bG == null) {
                w.e("MicroMsg.ExdeviceRankDataSourceUI", "invalid mac(%s).", new Object[]{bG});
            } else if (this.lnc.vu(bG) != null) {
                w.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
            } else {
                com.tencent.mm.plugin.exdevice.h.b bF = ad.apt().bF(longExtra);
                if (bF == null) {
                    w.w("MicroMsg.ExdeviceRankDataSourceUI", "hard device info is null.(mac : %s)", new Object[]{Long.valueOf(longExtra)});
                } else if (this.lnc.bX(bF.field_deviceID, bF.field_deviceType) != null) {
                    w.i("MicroMsg.ExdeviceRankDataSourceUI", "The device has been added, now switch it to be the main device.");
                } else {
                    ap.vd().a(1267, this);
                    ap.vd().a(new q(), 0);
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar == null) {
            w.e("MicroMsg.ExdeviceRankDataSourceUI", "onSceneEnd, scene is null.");
        } else if (kVar instanceof q) {
            ap.vd().b(1267, this);
            if (i == 0 && i2 == 0) {
                int size;
                abk com_tencent_mm_protocal_c_abk = (abk) ((q) kVar).gUA.hsk.hsr;
                String str2 = "MicroMsg.ExdeviceRankDataSourceUI";
                String str3 = "onSceneEnd, get sport device list succ.(size : %d)";
                Object[] objArr = new Object[1];
                if (com_tencent_mm_protocal_c_abk.tCW != null) {
                    size = com_tencent_mm_protocal_c_abk.tCW.size();
                } else {
                    size = 0;
                }
                objArr[0] = Integer.valueOf(size);
                w.d(str2, str3, objArr);
                final List list = com_tencent_mm_protocal_c_abk.tCW;
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceRankDataSourceUI lnd;

                    public final void run() {
                        b b = this.lnd.lnc;
                        List<bir> list = list;
                        b.lni.clear();
                        if (!(list == null || list.size() == 0)) {
                            for (bir com_tencent_mm_protocal_c_bir : list) {
                                if (com_tencent_mm_protocal_c_bir != null) {
                                    b.lni.add(ExdeviceRankDataSourceUI.a(com_tencent_mm_protocal_c_bir));
                                }
                            }
                        }
                        this.lnd.lnc.notifyDataSetChanged();
                    }
                });
            }
        }
    }
}
