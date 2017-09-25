package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
import com.tencent.mm.e.a.cx;
import com.tencent.mm.e.b.bp;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceManageDeviceUI extends MMActivity {
    private ListView Fg;
    private a lln;

    private static final class a extends BaseAdapter implements e {
        private p irJ = null;
        private d kcc;
        private List<b> lid;
        private c lir;
        boolean llp;
        private WeakReference<Context> llq;
        private OnClickListener llr;
        private l lls;
        private volatile int llt = -1;

        private static class a {
            ImageView jbU;
            TextView kzl;
            View llw;
            View llx;
        }

        static /* synthetic */ void a(Context context, b bVar) {
            Intent intent = new Intent();
            intent.putExtra("device_type", bVar.field_deviceType);
            intent.putExtra("device_id", bVar.field_deviceID);
            intent.putExtra("device_mac", bVar.field_mac);
            intent.putExtra("device_brand_name", bVar.field_brandName);
            intent.putExtra("device_desc", bVar.gtT);
            intent.putExtra("device_title", bVar.gtS);
            intent.putExtra("device_icon_url", bVar.iconUrl);
            intent.putExtra("device_alias", bVar.gtR);
            intent.putExtra("device_jump_url", bVar.jumpUrl);
            intent.putExtra("subscribe_flag", 1);
            com.tencent.mm.bb.d.b(context, "exdevice", ".ui.ExdeviceDeviceProfileUI", intent, 1000);
        }

        static /* synthetic */ void a(a aVar, final b bVar) {
            if (bVar != null && aVar.llq != null) {
                Context context = (Context) aVar.llq.get();
                if (context == null) {
                    w.e("MicroMsg.ExdeviceManageDeviceUI", "context is null.");
                    return;
                }
                context.getString(R.l.dIO);
                aVar.irJ = g.a(context, context.getString(R.l.dJd), true, new OnCancelListener(aVar) {
                    final /* synthetic */ a llu;

                    {
                        this.llu = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                ap.vL().D(new Runnable(aVar) {
                    final /* synthetic */ a llu;

                    public final void run() {
                        aen com_tencent_mm_protocal_c_aen = new aen();
                        com_tencent_mm_protocal_c_aen.jNm = bVar.field_deviceID;
                        com_tencent_mm_protocal_c_aen.thD = bVar.field_deviceType;
                        ap.vd().a(new x(com_tencent_mm_protocal_c_aen, 2), 0);
                    }
                });
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return ma(i);
        }

        public a(Context context) {
            this.llq = new WeakReference(context);
            this.lid = new LinkedList();
            this.lls = new l(context);
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hJa = R.g.beX;
            this.lir = aVar.Hg();
            this.kcc = new d(this) {
                final /* synthetic */ a llu;

                {
                    this.llu = r1;
                }

                public final void c(MenuItem menuItem, int i) {
                    int itemId = menuItem.getItemId();
                    w.d("MicroMsg.ExdeviceManageDeviceUI", "onMenuItemSelected, itemId(%d), count(%d).", new Object[]{Integer.valueOf(itemId), Integer.valueOf(this.llu.getCount())});
                    if (itemId >= 0 && itemId < r1) {
                        this.llu.llt = itemId;
                        a.a(this.llu, (b) this.llu.lid.get(itemId));
                        this.llu.notifyDataSetChanged();
                    }
                }
            };
            this.llr = new OnClickListener(this) {
                final /* synthetic */ a llu;

                {
                    this.llu = r1;
                }

                public final void onClick(View view) {
                    if (!this.llu.llp) {
                        Object tag = view.getTag();
                        if (tag != null && (tag instanceof Integer)) {
                            int intValue = ((Integer) tag).intValue();
                            if (intValue >= 0 && intValue < this.llu.getCount()) {
                                b ma = this.llu.ma(intValue);
                                Context context = (Context) this.llu.llq.get();
                                if (context == null) {
                                    w.e("MicroMsg.ExdeviceManageDeviceUI", "Start activity failed, context is null.");
                                } else {
                                    a.a(context, ma);
                                }
                            }
                        }
                    }
                }
            };
            ao(ad.apt().apY());
        }

        public final void ao(List<b> list) {
            this.lid.clear();
            if (list != null && list.size() != 0) {
                this.lid.addAll(list);
            }
        }

        public final int getCount() {
            return this.lid.size();
        }

        public final b ma(int i) {
            return (b) this.lid.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            bp ma = ma(i);
            if (view == null) {
                aVar = new a();
                view = View.inflate(viewGroup.getContext(), R.i.dbE, null);
                aVar.llw = view.findViewById(R.h.bGr);
                aVar.kzl = (TextView) view.findViewById(R.h.cml);
                aVar.llx = view.findViewById(R.h.bHV);
                aVar.jbU = (ImageView) view.findViewById(R.h.bWv);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (ma == null) {
                charSequence = "";
            } else {
                String bG = !bg.mA(ma.gtR) ? ma.gtR : !bg.mA(ma.gtS) ? ma.gtS : ma.field_mac != 0 ? com.tencent.mm.plugin.exdevice.j.b.bG(ma.field_mac) : !bg.mA(ma.field_deviceID) ? ma.field_deviceID : null;
                charSequence = bg.mz(bG);
            }
            w.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", new Object[]{Integer.valueOf(i), charSequence, Long.valueOf(ma.field_mac)});
            aVar.kzl.setText(charSequence);
            n.GW().a(ma.iconUrl, aVar.jbU, this.lir);
            aVar.llx.setTag(Integer.valueOf(i));
            if (this.llp) {
                aVar.llx.setVisibility(0);
            } else {
                aVar.llx.setVisibility(8);
            }
            aVar.llw.setTag(Integer.valueOf(i));
            aVar.llw.setOnClickListener(this.llr);
            return view;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar == null) {
                w.e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
            } else if (kVar instanceof x) {
                if (this.irJ != null && this.irJ.isShowing()) {
                    this.irJ.dismiss();
                }
                if (i == 0 && i2 == 0 && this.llt >= 0 && this.llt < this.lid.size()) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ a llu;

                        {
                            this.llu = r1;
                        }

                        public final void run() {
                            this.llu.lid.remove(this.llu.llt);
                            this.llu.notifyDataSetChanged();
                            this.llu.llt = -1;
                        }
                    });
                }
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dbF;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceManageDeviceUI llo;

            {
                this.llo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.llo.finish();
                return true;
            }
        });
        zi(R.l.ege);
        com.tencent.mm.sdk.b.b cxVar = new cx();
        cxVar.fGA.fGB = true;
        com.tencent.mm.sdk.b.a.urY.m(cxVar);
        KC();
        ap.vd().a(537, this.lln);
    }

    protected final void KC() {
        this.Fg = (ListView) findViewById(R.h.cbx);
        this.lln = new a(this);
        View.inflate(this, R.i.dbv, null);
        this.Fg.setAdapter(this.lln);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.lln.ao(ad.apt().apY());
        this.lln.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(537, this.lln);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0 || !this.lln.llp) {
            return super.onKeyDown(i, keyEvent);
        }
        aB(0, getString(R.l.dGK));
        a aVar = this.lln;
        if (aVar.llp) {
            aVar.llp = false;
            af.v(new Runnable(aVar) {
                final /* synthetic */ a llu;

                {
                    this.llu = r1;
                }

                public final void run() {
                    this.llu.notifyDataSetChanged();
                }
            });
        }
        return true;
    }
}
