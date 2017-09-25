package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.ipcall.a.d.f;
import com.tencent.mm.plugin.ipcall.a.e.g;
import com.tencent.mm.plugin.ipcall.a.e.h;
import com.tencent.mm.plugin.ipcall.a.e.j;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.c.add;
import com.tencent.mm.protocal.c.blx;
import com.tencent.mm.protocal.c.bmc;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class IPCallRechargeUI extends MMActivity implements e {
    TextView kBi;
    private int kRE = -1;
    private String[] kRG;
    private com.tencent.mm.pluginsdk.model.h.a kRU = new com.tencent.mm.pluginsdk.model.h.a(this) {
        final /* synthetic */ IPCallRechargeUI mWd;

        {
            this.mWd = r1;
        }

        public final void x(ArrayList<p> arrayList) {
            this.mWd.mVU.mQH = System.currentTimeMillis();
            if (arrayList == null || arrayList.size() <= 0) {
                if (this.mWd.mSZ != null && this.mWd.mSZ.isShowing()) {
                    this.mWd.mSZ.dismiss();
                }
                w.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
                this.mWd.kRE = 10236;
                this.mWd.aFk();
                return;
            }
            this.mWd.mVL = new String[arrayList.size()];
            this.mWd.mVM = new String[arrayList.size()];
            p pVar = (p) arrayList.get(0);
            if (pVar.sCE == 10232) {
                w.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + arrayList.size());
                Iterator it = arrayList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    pVar = (p) it.next();
                    this.mWd.mVL[i] = new BigDecimal(pVar.sCD).divide(new BigDecimal(Constants.MAX_BUFFER_SIZE)).toString();
                    this.mWd.mVM[i] = pVar.sCC;
                    i++;
                }
                if (this.mWd.mVQ > 0 && this.mWd.mVM.length > 0) {
                    String str = this.mWd.mVM[0];
                    if (!(bg.mA(str) || str.equals(this.mWd.mVO))) {
                        w.i("MicroMsg.IPCallRechargeUI", "remote currency:" + this.mWd.mVO + ",google wallet currency:" + str);
                        this.mWd.yJ(str);
                        return;
                    }
                }
                if (this.mWd.mSZ != null && this.mWd.mSZ.isShowing()) {
                    this.mWd.mSZ.dismiss();
                }
                this.mWd.aFk();
                return;
            }
            if (this.mWd.mSZ != null && this.mWd.mSZ.isShowing()) {
                this.mWd.mSZ.dismiss();
            }
            this.mWd.kRE = pVar.sCE;
            w.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + this.mWd.kRE);
            this.mWd.aFk();
        }
    };
    private ae mHandler = new ae(this) {
        final /* synthetic */ IPCallRechargeUI mWd;

        {
            this.mWd = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                    this.mWd.mVZ.setVisibility(0);
                    IPCallRechargeUI.k(this.mWd);
                    return;
                default:
                    w.w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
                    return;
            }
        }
    };
    ProgressDialog mSZ;
    private String[] mVL;
    private String[] mVM;
    private String mVN;
    private String mVO;
    private boolean mVP = false;
    private int mVQ;
    private int mVR = -1;
    private String mVS;
    private String mVT;
    private h mVU = new h();
    private g mVV = new g();
    private j mVW = new j();
    RelativeLayout mVX;
    GridView mVY;
    ListView mVZ;
    a mWa;
    Button mWb;
    f mWc;

    private static class a extends BaseAdapter {
        private IPCallRechargeUI mWf = null;
        add mWg = null;
        List<blx> mzj = null;

        private class a {
            TextView mVk;
            final /* synthetic */ a mWh;
            TextView mWi;
            TextView mWj;
            TextView mWk;
            Button mWl;

            public a(a aVar) {
                this.mWh = aVar;
            }
        }

        public a(IPCallRechargeUI iPCallRechargeUI) {
            Assert.assertTrue(iPCallRechargeUI != null);
            this.mWf = iPCallRechargeUI;
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
                view = ((LayoutInflater) this.mWf.getSystemService("layout_inflater")).inflate(R.i.dgu, viewGroup, false);
                aVar = new a(this);
                aVar.mVk = (TextView) view.findViewById(R.h.cJR);
                aVar.mWi = (TextView) view.findViewById(R.h.cJQ);
                aVar.mWj = (TextView) view.findViewById(R.h.cJP);
                aVar.mWk = (TextView) view.findViewById(R.h.cJO);
                aVar.mWl = (Button) view.findViewById(R.h.buT);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            blx com_tencent_mm_protocal_c_blx = (blx) getItem(i);
            if (com_tencent_mm_protocal_c_blx != null) {
                aVar.mVk.setText(com_tencent_mm_protocal_c_blx.tVE);
                aVar.mWi.setText(com_tencent_mm_protocal_c_blx.ulG);
                aVar.mWj.setText(com_tencent_mm_protocal_c_blx.ulH);
                if (bg.mA(com_tencent_mm_protocal_c_blx.ulH)) {
                    aVar.mWj.setVisibility(8);
                } else {
                    aVar.mWj.setVisibility(0);
                }
                if (this.mWg != null) {
                    aVar.mWk.setText(String.format(this.mWf.getString(R.l.euf), new Object[]{com.tencent.mm.plugin.ipcall.b.a.yR(this.mWg.tIy), String.valueOf(com_tencent_mm_protocal_c_blx.ulE)}));
                }
                aVar.mWl.setTag(Integer.valueOf(i));
                aVar.mWl.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a mWh;

                    {
                        this.mWh = r1;
                    }

                    public final void onClick(View view) {
                        IPCallRechargeUI.b(this.mWh.mWf, ((Integer) view.getTag()).intValue());
                    }
                });
            }
            return view;
        }
    }

    static /* synthetic */ void b(IPCallRechargeUI iPCallRechargeUI, int i) {
        String string;
        boolean z;
        if (iPCallRechargeUI.kRE != -1) {
            CharSequence string2;
            switch (iPCallRechargeUI.kRE) {
                case 10233:
                    string2 = iPCallRechargeUI.getString(R.l.euL);
                    if (!iPCallRechargeUI.yK(string2)) {
                        Toast.makeText(iPCallRechargeUI, string2, 0).show();
                        break;
                    }
                    break;
                case 10234:
                    string = iPCallRechargeUI.getString(R.l.euH);
                    if (!iPCallRechargeUI.yK(string)) {
                        com.tencent.mm.ui.base.g.a(iPCallRechargeUI, string, iPCallRechargeUI.getString(R.l.euN), true, null);
                        break;
                    }
                    break;
                case 10235:
                    string2 = iPCallRechargeUI.getString(R.l.evp);
                    if (!iPCallRechargeUI.yK(string2)) {
                        Toast.makeText(iPCallRechargeUI, string2, 0).show();
                        break;
                    }
                    break;
                default:
                    string2 = iPCallRechargeUI.getString(R.l.etR);
                    if (!iPCallRechargeUI.yK(string2)) {
                        Toast.makeText(iPCallRechargeUI, string2, 0).show();
                        break;
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            iPCallRechargeUI.mVR = i;
            w.i("MicroMsg.IPCallRechargeUI", "ProductId:%s, PackPrice:%s,Currency:%s, index:%d", new Object[]{iPCallRechargeUI.kRG[i], iPCallRechargeUI.mVL[i], iPCallRechargeUI.mVM[i], Integer.valueOf(i)});
            com.tencent.mm.plugin.report.service.g.oUh.a(257, 5, 1, true);
            iPCallRechargeUI.mVV.start();
            if (iPCallRechargeUI.mWa.getItem(i) instanceof blx) {
                iPCallRechargeUI.mVV.mQy = ((blx) iPCallRechargeUI.mWa.getItem(i)).ulF;
            }
            iPCallRechargeUI.mVV.mQz = iPCallRechargeUI.mVM[i];
            iPCallRechargeUI.mVV.mQx = (long) i;
            iPCallRechargeUI.mVV.mQD = iPCallRechargeUI.kRG[i];
            Intent intent = new Intent();
            intent.putExtra("key_product_id", iPCallRechargeUI.kRG[i]);
            intent.putExtra("key_currency_type", iPCallRechargeUI.mVM[i]);
            intent.putExtra("key_price", iPCallRechargeUI.mVM[i] + iPCallRechargeUI.mVL[i]);
            intent.putExtra("key_force_google", true);
            if (iPCallRechargeUI.mWa.getItem(i) instanceof blx) {
                string = ((blx) iPCallRechargeUI.mWa.getItem(i)).ulI;
                if (!bg.mA(string)) {
                    w.i("md5:%s", string);
                    bmc com_tencent_mm_protocal_c_bmc = new bmc();
                    com_tencent_mm_protocal_c_bmc.ulI = string;
                    try {
                        intent.putExtra("key_ext_info", Base64.encodeToString(com_tencent_mm_protocal_c_bmc.toByteArray(), 2));
                    } catch (IOException e) {
                        w.e("MicroMsg.IPCallRechargeUI", e.getMessage());
                    }
                }
            }
            d.b(iPCallRechargeUI, "wallet_index", ".ui.WalletIapUI", intent, MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN);
        }
    }

    static /* synthetic */ void j(IPCallRechargeUI iPCallRechargeUI) {
        if (iPCallRechargeUI.mWa != null) {
            iPCallRechargeUI.mWa.mzj = null;
            iPCallRechargeUI.mWa.notifyDataSetChanged();
        }
        if (iPCallRechargeUI.mVZ != null) {
            iPCallRechargeUI.mVZ.setVisibility(4);
        }
        if (iPCallRechargeUI.mSZ != null) {
            iPCallRechargeUI.mSZ.show();
        }
        iPCallRechargeUI.yJ("");
    }

    static /* synthetic */ void k(IPCallRechargeUI iPCallRechargeUI) {
        if (!bg.mA(iPCallRechargeUI.mVS) && !bg.mA(iPCallRechargeUI.mVT)) {
            w.i("MicroMsg.IPCallRechargeUI", "showGotoExchangeRecordsAlert");
            com.tencent.mm.ui.base.g.a(iPCallRechargeUI, iPCallRechargeUI.mVT, iPCallRechargeUI.mVS, iPCallRechargeUI.getString(R.l.eud), iPCallRechargeUI.getString(R.l.eue), false, null, new DialogInterface.OnClickListener(iPCallRechargeUI) {
                final /* synthetic */ IPCallRechargeUI mWd;

                {
                    this.mWd = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.mWd.finish();
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.mWd.getString(R.l.etK));
                    intent.putExtra("showShare", false);
                    d.b(this.mWd, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
        }
    }

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(929, this);
        zi(R.l.euc);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallRechargeUI mWd;

            {
                this.mWd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mWd.finish();
                return true;
            }
        });
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallRechargeUI mWd;

            {
                this.mWd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.g.a(this.mWd.uSU.uTo, null, null, this.mWd.getResources().getString(R.l.euZ), false, new c(this.mWd) {
                    final /* synthetic */ IPCallRechargeUI mWd;

                    {
                        this.mWd = r1;
                    }

                    public final void hq(int i) {
                        switch (i) {
                            case 0:
                                w.i("MicroMsg.IPCallRechargeUI", "start restore");
                                this.mWd.mVW.start();
                                com.tencent.mm.plugin.report.service.g.oUh.a(257, 14, 1, true);
                                Intent intent = new Intent();
                                intent.putExtra("key_action_type", 200002);
                                intent.putExtra("key_force_google", true);
                                d.b(this.mWd, "wallet_index", ".ui.WalletIapUI", intent, MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK);
                                MMActivity mMActivity = this.mWd;
                                if (mMActivity.isFinishing()) {
                                    w.i("MicroMsg.IPCallRechargeUI", "[showLoadingDialog] acitivity is finished.");
                                    return;
                                }
                                Context context = mMActivity.uSU.uTo;
                                mMActivity.getString(R.l.dIO);
                                mMActivity.mSZ = com.tencent.mm.ui.base.g.a(context, mMActivity.getString(R.l.etS), false, null);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        this.mVX = (RelativeLayout) findViewById(R.h.layout);
        this.mVY = (GridView) findViewById(R.h.cwy);
        this.mVZ = (ListView) findViewById(R.h.cwC);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.uSU.uTo, R.i.dgt, null);
        this.mVZ.addFooterView(viewGroup, null, false);
        this.mWa = new a(this);
        this.mVZ.setAdapter(this.mWa);
        this.kBi = (TextView) viewGroup.findViewById(R.h.cIJ);
        this.mWb = (Button) findViewById(R.h.bvG);
        Object string = getString(R.l.euh);
        CharSequence newSpannable = Factory.getInstance().newSpannable(string);
        newSpannable.setSpan(new ClickableSpan(this) {
            final /* synthetic */ IPCallRechargeUI mWd;

            {
                this.mWd = r1;
            }

            public final void onClick(View view) {
                ((TextView) view).setHighlightColor(this.mWd.getResources().getColor(R.e.transparent));
                Intent intent = new Intent();
                String str = this.mWd.getString(R.l.eug) + "&usedcc=";
                List aDW = com.tencent.mm.plugin.ipcall.a.c.aDT().aDW();
                if (aDW.size() > 0) {
                    int size = aDW.size();
                    if (size > 5) {
                        size = 5;
                    }
                    int i = 0;
                    while (i < size) {
                        String yT = com.tencent.mm.plugin.ipcall.b.a.yT(((Integer) aDW.get(i)).toString());
                        if (bg.mA(yT)) {
                            yT = str;
                        } else {
                            yT = str + yT + "|";
                        }
                        i++;
                        str = yT;
                    }
                    if (str.endsWith("|")) {
                        str = str.substring(0, str.length() - 1);
                    }
                } else {
                    str = str + com.tencent.mm.plugin.ipcall.b.a.yT(com.tencent.mm.plugin.ipcall.b.c.aFy());
                }
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                d.b(this.mWd, "webview", ".ui.tools.WebViewUI", intent);
            }

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(this.mWd.getResources().getColor(R.e.aUA));
                textPaint.setUnderlineText(false);
            }
        }, 0, string.length(), 33);
        this.kBi.setText(newSpannable);
        this.kBi.setMovementMethod(LinkMovementMethod.getInstance());
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.mSZ = com.tencent.mm.ui.base.g.a(context, getString(R.l.etS), true, new OnCancelListener(this) {
            final /* synthetic */ IPCallRechargeUI mWd;

            {
                this.mWd = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                try {
                    if (this.mWd.mWc != null) {
                        ap.vd().c(this.mWd.mWc);
                    }
                    this.mWd.finish();
                } catch (Exception e) {
                    w.e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", new Object[]{e.getMessage()});
                }
            }
        });
        yJ("");
        this.mVU.start();
        com.tencent.mm.plugin.report.service.g.oUh.a(257, 4, 1, true);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mVU.mQj = System.currentTimeMillis();
        this.mVU.finish();
        ap.vd().b(929, this);
    }

    protected final int getLayoutId() {
        return R.i.dgv;
    }

    private void yJ(String str) {
        String yT;
        List aDW = com.tencent.mm.plugin.ipcall.a.c.aDT().aDW();
        if (aDW.size() == 0) {
            yT = com.tencent.mm.plugin.ipcall.b.a.yT(com.tencent.mm.plugin.ipcall.b.c.aFy());
        } else {
            yT = com.tencent.mm.plugin.ipcall.b.a.yT(((Integer) aDW.get(0)).toString());
        }
        this.mWc = new f(yT, str);
        ap.vd().a(this.mWc, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.IPCallRechargeUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        boolean z;
        int i3;
        ArrayList stringArrayListExtra;
        if (i == 2001) {
            int intExtra;
            int i4;
            String str;
            String str2 = "";
            z = false;
            if (intent != null) {
                String string;
                int intExtra2 = intent.getIntExtra("key_err_code", 0);
                String stringExtra = intent.getStringExtra("key_err_msg");
                long longExtra = intent.getLongExtra("key_launch_ts", 0);
                intExtra = intent.getIntExtra("key_gw_error_code", 0);
                int intExtra3 = intent.getIntExtra("key_response_position", 0);
                if (intExtra2 == 100000009) {
                    z = true;
                }
                w.i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[]{Integer.valueOf(intExtra2), stringExtra, Integer.valueOf(intExtra), Integer.valueOf(intExtra3), String.valueOf(z)});
                if (intExtra2 != -1 || intExtra == 0) {
                    this.mVV.mQB = (long) intExtra2;
                } else {
                    this.mVV.mQB = (long) intExtra;
                }
                if (intExtra3 == 3) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(257, 9, 1, true);
                    com.tencent.mm.plugin.report.service.g.oUh.a(257, 11, 1, true);
                    this.mVV.mQB = 0;
                    this.mVV.mQC = 2;
                    string = getString(R.l.evq);
                } else {
                    if (intExtra3 != 1) {
                        if (i2 == -1 && intExtra2 == 0) {
                            com.tencent.mm.plugin.report.service.g.oUh.a(257, 9, 1, true);
                            string = stringExtra;
                        } else if (z) {
                            com.tencent.mm.plugin.report.service.g.oUh.a(257, 9, 1, true);
                            com.tencent.mm.plugin.report.service.g.oUh.a(257, 12, 1, true);
                            this.mVV.mQB = 0;
                            this.mVV.mQC = 1;
                        }
                    }
                    string = stringExtra;
                }
                this.mVV.mQA = longExtra;
                this.mVV.mQj = System.currentTimeMillis();
                this.mVV.finish();
                i4 = intExtra3;
                str = string;
                i3 = intExtra;
                intExtra = intExtra2;
            } else {
                i3 = 0;
                i4 = 0;
                intExtra = 0;
                str = str2;
            }
            if (i2 != -1) {
                return;
            }
            if (intent != null && intExtra == 0) {
                stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                intent.getStringArrayListExtra("key_response_series_ids");
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    w.i("MicroMsg.IPCallRechargeUI", "buy product ok productId:", new Object[]{bg.mz((String) it.next())});
                }
                com.tencent.mm.plugin.report.service.g.oUh.a(257, 6, 1, true);
                com.tencent.mm.plugin.report.service.g.oUh.a(257, 10, 1, true);
                Toast.makeText(this, R.l.euO, 0).show();
                finish();
            } else if (intent != null && intExtra == 103) {
                com.tencent.mm.plugin.report.service.g.oUh.a(257, 6, 1, true);
                uw(str);
            } else if (intent != null && intExtra == 109) {
                uw(str);
            } else if (intent != null && intExtra == 100000000) {
                r2 = getString(R.l.euM);
                com.tencent.mm.plugin.report.service.g.oUh.a(257, 8, 1, true);
                Toast.makeText(this, r2, 0).show();
            } else if (intent == null || intExtra != 113) {
                com.tencent.mm.plugin.report.service.g.oUh.a(257, 7, 1, true);
                if (i4 == 3) {
                    uw(str);
                } else if (intExtra != 100000009 && intExtra != -1) {
                } else {
                    if (i3 == 0) {
                        Toast.makeText(this, getString(R.l.etP), 0).show();
                        return;
                    }
                    r2 = getString(R.l.etR);
                    if (!yK(r2)) {
                        Toast.makeText(this, r2, 0).show();
                    }
                }
            } else {
                com.tencent.mm.ui.base.g.a(this, getString(R.l.euF), getString(R.l.euN), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ IPCallRechargeUI mWd;

                    {
                        this.mWd = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        IPCallRechargeUI.j(this.mWd);
                    }
                });
            }
        } else if (i == 2002) {
            if (this.mSZ != null && this.mSZ.isShowing()) {
                this.mSZ.dismiss();
            }
            String str3 = "";
            int i5 = 0;
            int i6 = 0;
            z = false;
            if (intent != null) {
                i5 = intent.getIntExtra("key_err_code", 0);
                str3 = intent.getStringExtra("key_err_msg");
                i6 = intent.getIntExtra("key_response_position", 0);
                if (i5 == 100000009) {
                    z = true;
                }
                w.i("MicroMsg.IPCallRechargeUI", "onActivityResult restore.errCode:[%d] errMsg:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[]{Integer.valueOf(i5), str3, Integer.valueOf(i6), String.valueOf(z)});
            }
            CharSequence charSequence = str3;
            int i7 = i5;
            boolean z2 = z;
            i3 = i6;
            i6 = i7;
            this.mVW.mQK = (long) i6;
            this.mVW.mQI = 0;
            if (i2 != -1) {
                this.mVW.mQJ = 2;
                w.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
                Toast.makeText(this, R.l.eva, 0).show();
            } else if (intent == null || i6 != 0) {
                if (z2) {
                    this.mVW.mQJ = 1;
                    com.tencent.mm.plugin.report.service.g.oUh.a(257, 17, 1, true);
                    charSequence = getString(R.l.evb);
                } else if (i3 == 3) {
                    this.mVW.mQJ = 2;
                    com.tencent.mm.plugin.report.service.g.oUh.a(257, 16, 1, true);
                } else {
                    this.mVW.mQJ = 2;
                }
                w.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
                Toast.makeText(this, charSequence, 0).show();
            } else {
                stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    this.mVW.mQJ = 3;
                    w.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
                    Toast.makeText(this, R.l.evb, 0).show();
                } else {
                    this.mVW.mQJ = 0;
                    com.tencent.mm.plugin.report.service.g.oUh.a(257, 15, 1, true);
                    w.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.evc), getString(R.l.evd), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ IPCallRechargeUI mWd;

                        {
                            this.mWd = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.mWd.finish();
                        }
                    });
                }
            }
            this.mVW.mQj = System.currentTimeMillis();
            this.mVW.finish();
        }
    }

    private void uw(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.euN);
        }
        com.tencent.mm.ui.base.g.a(this, str, getString(R.l.euN), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ IPCallRechargeUI mWd;

            {
                this.mWd = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private boolean yK(String str) {
        boolean z;
        if (com.tencent.mm.i.g.sV().getInt("WCOSecondPurchaseSwitch", 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.mVR >= 0) {
            Object item = this.mWa.getItem(this.mVR);
            if ((item instanceof blx) && !bg.mA(((blx) item).ulJ)) {
                final String str2 = ((blx) item).ulJ;
                w.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:" + str2);
                com.tencent.mm.ui.base.g.a(this, str, getString(R.l.euN), getString(R.l.euy), getString(R.l.dGs), true, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ IPCallRechargeUI mWd;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(257, 3, 1, true);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str2);
                        intent.putExtra("showShare", false);
                        d.b(this.mWd, "webview", ".ui.tools.WebViewUI", intent);
                    }
                }, null);
                return true;
            }
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        w.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[]{Integer.valueOf(i2), str});
        if (kVar instanceof f) {
            h hVar = this.mVU;
            hVar.mQF = System.currentTimeMillis();
            hVar.mQG = (long) i2;
            if (i == 0 && i2 == 0) {
                add com_tencent_mm_protocal_c_add = ((f) kVar).mPO;
                this.mWa.mzj = com_tencent_mm_protocal_c_add.tEu;
                this.mWa.mWg = com_tencent_mm_protocal_c_add;
                this.mWa.notifyDataSetChanged();
                this.kRG = new String[com_tencent_mm_protocal_c_add.tEu.size()];
                Iterator it = com_tencent_mm_protocal_c_add.tEu.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    this.kRG[i4] = ((blx) it.next()).tgW;
                    i4++;
                }
                this.mVS = com_tencent_mm_protocal_c_add.tID;
                this.mVT = com_tencent_mm_protocal_c_add.tIE;
                this.mVN = com_tencent_mm_protocal_c_add.tIy;
                this.mVO = com_tencent_mm_protocal_c_add.tIC;
                this.mVQ = com_tencent_mm_protocal_c_add.tIB;
                if (this.mVP) {
                    this.mVM = new String[com_tencent_mm_protocal_c_add.tEu.size()];
                    for (int i5 = 0; i5 < this.mVM.length; i5++) {
                        this.mVM[i5] = com_tencent_mm_protocal_c_add.tIC;
                    }
                    this.mVL = new String[com_tencent_mm_protocal_c_add.tEu.size()];
                    while (i3 < this.mVL.length) {
                        this.mVL[i3] = IPCallDynamicTextView.yI(((blx) com_tencent_mm_protocal_c_add.tEu.get(i3)).tVE);
                        i3++;
                    }
                }
                if (((f) kVar).mPP) {
                    w.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
                    if (this.kRG != null && this.kRG.length > 0) {
                        w.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
                        com.tencent.mm.pluginsdk.model.h.a(this, this.kRG, this.kRU);
                        return;
                    }
                    return;
                }
                if (this.mSZ != null && this.mSZ.isShowing()) {
                    this.mSZ.dismiss();
                }
                aFk();
                return;
            }
            if (this.mSZ != null && this.mSZ.isShowing()) {
                this.mSZ.dismiss();
            }
            Toast.makeText(this.uSU.uTo, getString(R.l.etP), 0).show();
            finish();
        }
    }

    public final void aFk() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
        }
    }
}
