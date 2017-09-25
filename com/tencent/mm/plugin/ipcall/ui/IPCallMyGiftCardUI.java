package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.d.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.acz;
import com.tencent.mm.protocal.c.blz;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;
import junit.framework.Assert;

public class IPCallMyGiftCardUI extends MMActivity implements e {
    private ListView Fg;
    private View jAA;
    private ProgressDialog kIa;
    private a mVf;
    private d mVg;

    private static class a extends BaseAdapter {
        private IPCallMyGiftCardUI mVi = null;
        acz mVj = null;
        List<blz> mzj = null;

        private class a {
            TextView mVk;
            TextView mVl;
            TextView mVm;
            CdnImageView mVn;
            ImageView mVo;
            final /* synthetic */ a mVp;

            public a(a aVar) {
                this.mVp = aVar;
            }
        }

        public a(IPCallMyGiftCardUI iPCallMyGiftCardUI) {
            Assert.assertTrue(iPCallMyGiftCardUI != null);
            this.mVi = iPCallMyGiftCardUI;
        }

        public final int getCount() {
            return this.mzj == null ? 0 : this.mzj.size();
        }

        public final Object getItem(int i) {
            if (this.mzj != null) {
                return this.mzj.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.mVi.getSystemService("layout_inflater")).inflate(R.i.dgp, viewGroup, false);
                aVar = new a(this);
                aVar.mVk = (TextView) view.findViewById(R.h.bGV);
                aVar.mVl = (TextView) view.findViewById(R.h.bHH);
                aVar.mVm = (TextView) view.findViewById(R.h.bNo);
                aVar.mVn = (CdnImageView) view.findViewById(R.h.bWa);
                aVar.mVo = (ImageView) view.findViewById(R.h.bHQ);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            blz com_tencent_mm_protocal_c_blz = (blz) getItem(i);
            if (com_tencent_mm_protocal_c_blz != null) {
                if (bg.mA(com_tencent_mm_protocal_c_blz.ulL)) {
                    aVar.mVk.setVisibility(0);
                    aVar.mVl.setVisibility(0);
                    aVar.mVm.setVisibility(8);
                    aVar.mVk.setText(com_tencent_mm_protocal_c_blz.tVE);
                    aVar.mVl.setText(com_tencent_mm_protocal_c_blz.ulK);
                } else {
                    aVar.mVk.setVisibility(8);
                    aVar.mVl.setVisibility(8);
                    aVar.mVm.setVisibility(0);
                    aVar.mVm.setText(com_tencent_mm_protocal_c_blz.ulL);
                }
                b.a(aVar.mVo, "", 0.5f, false);
                if (bg.mA(com_tencent_mm_protocal_c_blz.mtf)) {
                    aVar.mVo.setVisibility(0);
                    aVar.mVn.setVisibility(4);
                } else {
                    aVar.mVn.setVisibility(0);
                    aVar.mVn.L(com_tencent_mm_protocal_c_blz.mtf, 0, 0);
                    aVar.mVo.setVisibility(4);
                }
            }
            return view;
        }
    }

    protected final int Ol() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(288, this);
        zi(R.l.euK);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallMyGiftCardUI mVh;

            {
                this.mVh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mVh.finish();
                return true;
            }
        });
        a(0, this.uSU.uTo.getString(R.l.euJ), new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallMyGiftCardUI mVh;

            {
                this.mVh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.mVh.getString(R.l.etJ));
                intent.putExtra("showShare", false);
                com.tencent.mm.bb.d.b(this.mVh, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            }
        });
        this.jAA = findViewById(R.h.bYW);
        this.Fg = (ListView) findViewById(R.h.bYX);
        this.mVf = new a(this);
        this.Fg.setAdapter(this.mVf);
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.kIa = g.a(context, getString(R.l.etS), true, new OnCancelListener(this) {
            final /* synthetic */ IPCallMyGiftCardUI mVh;

            {
                this.mVh = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                try {
                    if (this.mVh.mVg != null) {
                        ap.vd().c(this.mVh.mVg);
                    }
                    this.mVh.finish();
                } catch (Exception e) {
                    w.e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", new Object[]{e.getMessage()});
                }
            }
        });
        this.mVg = new d();
        ap.vd().a(this.mVg, 0);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(288, this);
    }

    protected final int getLayoutId() {
        return R.i.dgq;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[]{Integer.valueOf(i2), str});
        if (!(kVar instanceof d)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            acz com_tencent_mm_protocal_c_acz = ((d) kVar).mPK;
            if (this.kIa != null && this.kIa.isShowing()) {
                this.kIa.dismiss();
            }
            this.mVf.mzj = com_tencent_mm_protocal_c_acz.tIx;
            this.mVf.mVj = com_tencent_mm_protocal_c_acz;
            this.mVf.notifyDataSetChanged();
            if (com_tencent_mm_protocal_c_acz.tIx.size() == 0) {
                this.jAA.setVisibility(0);
                return;
            }
            return;
        }
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
        this.jAA.setVisibility(0);
        Toast.makeText(this.uSU.uTo, getString(R.l.etP), 0).show();
    }
}
