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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.d.j;
import com.tencent.mm.plugin.ipcall.a.e.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.adb;
import com.tencent.mm.protocal.c.bmb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;

public class IPCallPackageUI extends MMActivity implements e {
    private ListView mVq = null;
    private TextView mVr = null;
    private ProgressDialog mVs = null;
    private ProgressDialog mVt = null;
    private a mVu = null;
    private com.tencent.mm.plugin.ipcall.a.d.e mVv = null;
    private j mVw = null;
    private f mVx = new f();

    private static class a extends BaseAdapter {
        private IPCallPackageUI mVz = null;
        List<bmb> mzj = null;

        private class a {
            TextView iuF;
            final /* synthetic */ a mVA;
            CdnImageView mVD;
            TextView mVE;
            TextView mVF;
            TextView mVG;
            Button mVH;

            public a(a aVar) {
                this.mVA = aVar;
            }
        }

        public a(IPCallPackageUI iPCallPackageUI) {
            this.mVz = iPCallPackageUI;
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

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.mVz.getSystemService("layout_inflater")).inflate(R.i.dgr, viewGroup, false);
                aVar = new a(this);
                aVar.mVD = (CdnImageView) view.findViewById(R.h.cqy);
                aVar.iuF = (TextView) view.findViewById(R.h.cqB);
                aVar.mVE = (TextView) view.findViewById(R.h.cqC);
                aVar.mVF = (TextView) view.findViewById(R.h.cqv);
                aVar.mVG = (TextView) view.findViewById(R.h.cqw);
                aVar.mVH = (Button) view.findViewById(R.h.cqu);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            bmb com_tencent_mm_protocal_c_bmb = (bmb) getItem(i);
            if (com_tencent_mm_protocal_c_bmb != null) {
                aVar.iuF.setText(com_tencent_mm_protocal_c_bmb.fDC);
                aVar.mVE.setText(com_tencent_mm_protocal_c_bmb.tVE);
                aVar.mVG.setText(com_tencent_mm_protocal_c_bmb.msk);
                aVar.mVF.setText(com_tencent_mm_protocal_c_bmb.mQZ);
                aVar.mVD.setVisibility(0);
                aVar.mVD.L(com_tencent_mm_protocal_c_bmb.ulO, 0, 0);
                if (com_tencent_mm_protocal_c_bmb.teT == 0) {
                    aVar.mVH.setEnabled(true);
                } else {
                    aVar.mVH.setEnabled(false);
                }
                aVar.mVH.setTag(Integer.valueOf(i));
                aVar.mVH.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a mVA;

                    {
                        this.mVA = r1;
                    }

                    public final void onClick(View view) {
                        final bmb com_tencent_mm_protocal_c_bmb = (bmb) this.mVA.getItem(((Integer) view.getTag()).intValue());
                        if (com_tencent_mm_protocal_c_bmb == null || bg.mA(com_tencent_mm_protocal_c_bmb.tgW)) {
                            w.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
                            return;
                        }
                        this.mVA.mVz.mVx.start();
                        f b = this.mVA.mVz.mVx;
                        b.mQq++;
                        this.mVA.mVz.mVx.mQu = com_tencent_mm_protocal_c_bmb.tgW;
                        g.a(this.mVA.mVz, this.mVA.mVz.getString(R.l.euR, new Object[]{com_tencent_mm_protocal_c_bmb.tVE, com_tencent_mm_protocal_c_bmb.fDC}), this.mVA.mVz.getString(R.l.euS), this.mVA.mVz.getString(R.l.euP), this.mVA.mVz.getString(R.l.euQ), false, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 mVC;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                f b = this.mVC.mVA.mVz.mVx;
                                b.mQr++;
                                IPCallPackageUI.a(this.mVC.mVA.mVz, com_tencent_mm_protocal_c_bmb.tgW);
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 mVC;

                            {
                                this.mVC = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                f b = this.mVC.mVA.mVz.mVx;
                                b.mQs++;
                                this.mVC.mVA.mVz.mVx.finish();
                            }
                        });
                    }
                });
            }
            return view;
        }
    }

    static /* synthetic */ void a(IPCallPackageUI iPCallPackageUI, String str) {
        w.i("MicroMsg.IPCallPackageUI", "startPurchasePackage productID:%s", new Object[]{str});
        if (iPCallPackageUI.mVt == null) {
            Context context = iPCallPackageUI.uSU.uTo;
            iPCallPackageUI.getString(R.l.dIO);
            iPCallPackageUI.mVt = g.a(context, iPCallPackageUI.getString(R.l.euX), false, new OnCancelListener(iPCallPackageUI) {
                final /* synthetic */ IPCallPackageUI mVy;

                {
                    this.mVy = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        } else {
            iPCallPackageUI.mVt.show();
        }
        iPCallPackageUI.mVw = new j(str);
        ap.vd().a(iPCallPackageUI.mVw, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(831, this);
        ap.vd().a(277, this);
        this.mVx.start();
        f fVar = this.mVx;
        fVar.mQp++;
        this.mVx.finish();
        zi(R.l.euW);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallPackageUI mVy;

            {
                this.mVy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mVy.finish();
                return true;
            }
        });
        this.mVq = (ListView) findViewById(R.h.cqA);
        this.mVu = new a(this);
        this.mVq.setAdapter(this.mVu);
        this.mVr = (TextView) findViewById(R.h.con);
        aFj();
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(831, this);
        ap.vd().b(277, this);
    }

    protected final int getLayoutId() {
        return R.i.dgs;
    }

    protected final int Ol() {
        return 1;
    }

    private void aFj() {
        w.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
        if (this.mVu != null) {
            this.mVu.mzj = null;
            this.mVu.notifyDataSetChanged();
        }
        if (this.mVq != null) {
            this.mVq.setVisibility(8);
        }
        if (this.mVr != null) {
            this.mVr.setVisibility(8);
        }
        if (this.mVs == null) {
            Context context = this.uSU.uTo;
            getString(R.l.dIO);
            this.mVs = g.a(context, getString(R.l.etS), true, new OnCancelListener(this) {
                final /* synthetic */ IPCallPackageUI mVy;

                {
                    this.mVy = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    try {
                        if (this.mVy.mVv != null) {
                            ap.vd().c(this.mVy.mVv);
                        }
                        this.mVy.finish();
                    } catch (Exception e) {
                        w.e("MicroMsg.IPCallPackageUI", "cancel getPackageProductListNetScene error: %s", new Object[]{e.getMessage()});
                    }
                }
            });
        } else {
            this.mVs.show();
        }
        this.mVv = new com.tencent.mm.plugin.ipcall.a.d.e();
        ap.vd().a(this.mVv, 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.mVs != null && this.mVs.isShowing()) {
            this.mVs.dismiss();
        }
        if (this.mVt != null && this.mVt.isShowing()) {
            this.mVt.dismiss();
        }
        if (kVar instanceof com.tencent.mm.plugin.ipcall.a.d.e) {
            w.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                adb com_tencent_mm_protocal_c_adb = ((com.tencent.mm.plugin.ipcall.a.d.e) kVar).mPM;
                if (com_tencent_mm_protocal_c_adb == null || com_tencent_mm_protocal_c_adb.tIv == null || com_tencent_mm_protocal_c_adb.tIv.size() <= 0) {
                    this.mVu.mzj = null;
                    this.mVu.notifyDataSetChanged();
                    this.mVr.setVisibility(0);
                    return;
                }
                this.mVu.mzj = com_tencent_mm_protocal_c_adb.tIv;
                this.mVu.notifyDataSetChanged();
                this.mVq.setVisibility(0);
                return;
            }
            Toast.makeText(this.uSU.uTo, getString(R.l.etP), 0).show();
            finish();
        } else if (kVar instanceof j) {
            w.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), str});
            this.mVx.mQt = i2;
            if (i == 0 && i2 == 0) {
                this.mVx.finish();
                Toast.makeText(this.uSU.uTo, getString(R.l.euY), 0).show();
                aFj();
            } else if (i2 == 101) {
                bmb com_tencent_mm_protocal_c_bmb;
                a aVar = this.mVu;
                j jVar = (j) kVar;
                String str2 = jVar.mPW != null ? jVar.mPW.tgW : "";
                if (!(bg.mA(str2) || aVar.mzj == null)) {
                    for (bmb com_tencent_mm_protocal_c_bmb2 : aVar.mzj) {
                        if (com_tencent_mm_protocal_c_bmb2 != null && com_tencent_mm_protocal_c_bmb2.tgW.equals(str2)) {
                            com_tencent_mm_protocal_c_bmb = com_tencent_mm_protocal_c_bmb2;
                            break;
                        }
                    }
                }
                com_tencent_mm_protocal_c_bmb = null;
                if (com_tencent_mm_protocal_c_bmb == null) {
                    w.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
                    this.mVx.finish();
                    Toast.makeText(this.uSU.uTo, getString(R.l.euT), 0).show();
                    return;
                }
                g.a(this.uSU.uTo, this.uSU.uTo.getString(R.l.euU, new Object[]{com_tencent_mm_protocal_c_bmb.tVE, com_tencent_mm_protocal_c_bmb.fDC}), this.uSU.uTo.getString(R.l.euV), this.uSU.uTo.getString(R.l.euc), this.uSU.uTo.getString(R.l.euQ), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ IPCallPackageUI mVy;

                    {
                        this.mVy = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        f b = this.mVy.mVx;
                        b.mQv++;
                        this.mVy.mVx.finish();
                        Intent intent = new Intent();
                        intent.setClass(this.mVy.uSU.uTo, IPCallRechargeUI.class);
                        this.mVy.startActivity(intent);
                        this.mVy.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ IPCallPackageUI mVy;

                    {
                        this.mVy = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        f b = this.mVy.mVx;
                        b.mQw++;
                        this.mVy.mVx.finish();
                    }
                });
            } else {
                this.mVx.finish();
                Toast.makeText(this.uSU.uTo, getString(R.l.euT), 0).show();
                aFj();
            }
        } else {
            w.i("MicroMsg.IPCallPackageUI", "onSceneEnd errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), str});
        }
    }
}
