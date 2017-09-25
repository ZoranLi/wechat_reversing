package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI extends MMActivity {
    private OnDismissListener FV = new OnDismissListener(this) {
        final /* synthetic */ AppChooserUI sUZ;

        {
            this.sUZ = r1;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.sUZ.finish();
        }
    };
    private PackageManager aJt;
    private String mimeType = null;
    a sUC;
    private Intent sUD = null;
    private int sUE;
    private String sUF = null;
    private Bundle sUG = null;
    private t sUH = null;
    private ArrayList<String> sUI = null;
    private c sUJ = null;
    private c sUK = new c(this);
    private List<c> sUL;
    private String sUM;
    private int sUN;
    private int sUO;
    private boolean sUP = false;
    private boolean sUQ = false;
    private boolean sUR = false;
    private long sUS;
    private e sUT;
    private OnItemClickListener sUU = new OnItemClickListener(this) {
        final /* synthetic */ AppChooserUI sUZ;

        {
            this.sUZ = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.sUZ.sUC != null) {
                this.sUZ.sUJ = this.sUZ.sUC.xR(i);
                this.sUZ.sUC.notifyDataSetChanged();
                if (this.sUZ.sUT != null && this.sUZ.sUT.ivv.isShowing()) {
                    if (this.sUZ.sUJ == null || !this.sUZ.sUJ.sVg || (this.sUZ.sUJ.mLI && (this.sUZ.sUJ.rcb || this.sUZ.sUN >= this.sUZ.sUO))) {
                        this.sUZ.sUT.jI(true);
                    } else {
                        this.sUZ.sUT.jI(false);
                    }
                }
                if ((this.sUZ.scene == 6 || this.sUZ.sUE == 2) && this.sUZ.sUJ != null && this.sUZ.sUJ.sVd != null) {
                    this.sUZ.i(-1, this.sUZ.sUJ.sVd.activityInfo.packageName, false);
                    g.oUh.i(12809, Integer.valueOf(4), this.sUZ.sUJ.sVd.activityInfo.packageName);
                }
            }
        }
    };
    private OnClickListener sUV = new OnClickListener(this) {
        final /* synthetic */ AppChooserUI sUZ;

        {
            this.sUZ = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.sUZ.sUJ != null && this.sUZ.sUJ.sVd != null) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(this.sUZ.xQ(274528), this.sUZ.sUJ.sVd.activityInfo.packageName);
                this.sUZ.i(-1, this.sUZ.sUJ.sVd.activityInfo.packageName, true);
            }
        }
    };
    private OnClickListener sUW = new OnClickListener(this) {
        final /* synthetic */ AppChooserUI sUZ;

        {
            this.sUZ = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.sUZ.sUJ != null && this.sUZ.sUJ.sVd != null) {
                this.sUZ.i(-1, this.sUZ.sUJ.sVd.activityInfo.packageName, false);
            }
        }
    };
    private View.OnClickListener sUX = new View.OnClickListener(this) {
        final /* synthetic */ AppChooserUI sUZ;

        {
            this.sUZ = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
            if (this.sUZ.sUC != null) {
                int i = this.sUZ.sUC.sVa;
                if (i == f.sVl) {
                    if (this.sUZ.sUT != null && this.sUZ.sUT.ivv.isShowing()) {
                        this.sUZ.sUC.sVa = f.sVm;
                        this.sUZ.sUC.notifyDataSetChanged();
                    }
                    com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
                    if (this.sUZ.scene == 1) {
                        aVar.tL("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10375");
                    } else {
                        aVar.tL(this.sUZ.sUH.Nn());
                    }
                    aVar.tN(this.sUZ.sUH.bCA());
                    aVar.la(1);
                    aVar.dn(true);
                    com.tencent.mm.plugin.downloader.model.e.akM().a(aVar.kHa);
                    u.bCJ();
                    u.xa(this.sUZ.sUE);
                    if (this.sUZ.sUE == 0) {
                        if (this.sUZ.sUQ) {
                            g.oUh.i(11168, Integer.valueOf(4), Integer.valueOf(this.sUZ.scene));
                        } else {
                            g.oUh.i(11168, Integer.valueOf(3), Integer.valueOf(this.sUZ.scene));
                        }
                    }
                    if (this.sUZ.sUE == 1) {
                        g.oUh.i(12809, Integer.valueOf(5), "");
                    }
                } else if (i == f.sVn) {
                    MMActivity mMActivity = this.sUZ;
                    long j = this.sUZ.sUS;
                    w.i("MicroMsg.AppChooserUI", "installRecommendApp");
                    w.d("MicroMsg.AppChooserUI", "filepath:%s", com.tencent.mm.plugin.downloader.model.e.akM().aU(j).path);
                    if (!q.e(mMActivity.uSU.uTo, Uri.fromFile(new File(r1)))) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(mMActivity.xQ(274560), Long.valueOf(0));
                        if (mMActivity.sUC != null) {
                            mMActivity.sUC.sVa = f.sVl;
                            mMActivity.sUC.notifyDataSetChanged();
                        }
                    } else if (mMActivity.sUC != null) {
                        mMActivity.sUC.sVa = f.sVn;
                        mMActivity.sUC.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private m sUY = new m(this) {
        final /* synthetic */ AppChooserUI sUZ;

        {
            this.sUZ = r1;
        }

        public final void onTaskStarted(long j, String str) {
            this.sUZ.sUS = j;
            ap.yY();
            com.tencent.mm.u.c.vr().set(this.sUZ.xQ(274560), Long.valueOf(this.sUZ.sUS));
            w.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", String.valueOf(j), str);
        }

        public final void onTaskRemoved(long j) {
            w.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", Long.valueOf(j));
        }

        public final void c(long j, String str, boolean z) {
            w.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", Long.valueOf(j), str);
            if (!bg.mA(str) && com.tencent.mm.a.e.aO(str)) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(this.sUZ.xQ(274560), Long.valueOf(this.sUZ.sUS));
                if (this.sUZ.sUC != null && this.sUZ.sUS == j) {
                    this.sUZ.sUC.sVa = f.sVn;
                    this.sUZ.sUC.notifyDataSetChanged();
                }
            }
        }

        public final void d(long j, int i, boolean z) {
            w.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", Long.valueOf(j));
            ap.yY();
            com.tencent.mm.u.c.vr().set(this.sUZ.xQ(274560), Long.valueOf(0));
            if (this.sUZ.sUC != null) {
                this.sUZ.sUC.sVa = f.sVl;
                this.sUZ.sUC.notifyDataSetChanged();
            }
        }

        public final void onTaskPaused(long j) {
            w.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", Long.valueOf(j));
            ap.yY();
            com.tencent.mm.u.c.vr().set(this.sUZ.xQ(274560), Long.valueOf(0));
            if (this.sUZ.sUC != null) {
                this.sUZ.sUC.sVa = f.sVl;
                this.sUZ.sUC.notifyDataSetChanged();
            }
        }

        public final void bg(long j) {
        }

        public final void j(long j, String str) {
        }
    };
    private int scene = 0;

    class a extends BaseAdapter {
        List<c> kIf = new ArrayList();
        final /* synthetic */ AppChooserUI sUZ;
        int sVa = f.sVl;

        public final /* synthetic */ Object getItem(int i) {
            return xR(i);
        }

        public a(AppChooserUI appChooserUI) {
            this.sUZ = appChooserUI;
            appChooserUI.aJt = appChooserUI.getPackageManager();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            int i2 = 0;
            c xR = xR(i);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.sUZ.uSU.uTo).inflate(xR.sVg ? R.i.cUD : R.i.cUC, null);
                b bVar2 = new b(this.sUZ, view);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (xR.sVf == null) {
                new d(this.sUZ).execute(new c[]{xR});
            }
            bVar.mEA.setImageDrawable(xR.sVf);
            bVar.mEB.setText(xR.sVe);
            if (xR == null || (!(!xR.sVg || xR.rcb || (xR.sVg && xR.mLI && this.sUZ.sUN >= this.sUZ.sUO)) || xR.sVh)) {
                bVar.sVb.setVisibility(0);
                bVar.sVc.setVisibility(8);
                bVar.sVb.setOnClickListener(this.sUZ.sUX);
                if (this.sVa == f.sVl) {
                    if (xR.sVh) {
                        bVar.sVb.setText(R.l.dHN);
                    } else {
                        bVar.sVb.setText(R.l.dGE);
                    }
                    bVar.sVb.setEnabled(true);
                } else if (this.sVa == f.sVm) {
                    bVar.sVb.setText(R.l.dGJ);
                    bVar.sVb.setEnabled(false);
                } else if (this.sVa == f.sVn) {
                    if (xR.sVh) {
                        bVar.sVb.setText(R.l.dIQ);
                    } else {
                        bVar.sVb.setText(R.l.dIP);
                    }
                    bVar.sVb.setEnabled(true);
                }
            } else {
                boolean z;
                bVar.sVb.setVisibility(8);
                bVar.sVc.setVisibility(0);
                RadioButton radioButton = bVar.sVc;
                c c = this.sUZ.sUJ;
                if (c instanceof c) {
                    c = c;
                    if (!(c.sVd == null || xR.sVd == null || !c.sVd.activityInfo.packageName.equals(xR.sVd.activityInfo.packageName)) || (c.sVg && xR.sVg)) {
                        z = true;
                        radioButton.setChecked(z);
                    }
                }
                z = false;
                radioButton.setChecked(z);
            }
            if (xR.sVg) {
                if (this.sUZ.scene == 4) {
                    bVar.mED.setText(R.l.eHe);
                } else {
                    bVar.mED.setText(bg.mz(this.sUZ.sUF));
                }
                TextView textView = bVar.mED;
                if (bg.mA(this.sUZ.sUF)) {
                    i2 = 8;
                }
                textView.setVisibility(i2);
            } else {
                bVar.mED.setVisibility(8);
            }
            if (!(this.sUZ.scene == 6 || this.sUZ.sUJ == null || !this.sUZ.sUJ.equals(xR))) {
                bVar.sVc.setChecked(true);
            }
            return view;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final c xR(int i) {
            return this.kIf == null ? null : (c) this.kIf.get(i);
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (xR(i).sVg) {
                return 1;
            }
            return 0;
        }

        public final int getCount() {
            return this.kIf == null ? 0 : this.kIf.size();
        }
    }

    class b {
        ImageView mEA;
        TextView mEB;
        TextView mED;
        final /* synthetic */ AppChooserUI sUZ;
        TextView sVb;
        RadioButton sVc;

        public b(AppChooserUI appChooserUI, View view) {
            this.sUZ = appChooserUI;
            this.mEA = (ImageView) view.findViewById(R.h.bpD);
            this.mEB = (TextView) view.findViewById(R.h.bpJ);
            this.mED = (TextView) view.findViewById(R.h.bpx);
            this.sVb = (TextView) view.findViewById(R.h.bpQ);
            this.sVc = (RadioButton) view.findViewById(R.h.bpO);
        }
    }

    class c {
        boolean mLI;
        boolean rcb;
        final /* synthetic */ AppChooserUI sUZ;
        ResolveInfo sVd;
        CharSequence sVe;
        Drawable sVf;
        boolean sVg;
        boolean sVh;

        public c(AppChooserUI appChooserUI) {
            this.sUZ = appChooserUI;
        }

        public c(AppChooserUI appChooserUI, ResolveInfo resolveInfo, CharSequence charSequence) {
            this.sUZ = appChooserUI;
            this.sVd = resolveInfo;
            this.sVe = charSequence;
            this.sVg = false;
            this.rcb = true;
            this.sVh = false;
        }
    }

    class d extends AsyncTask<c, Void, c> {
        final /* synthetic */ AppChooserUI sUZ;

        d(AppChooserUI appChooserUI) {
            this.sUZ = appChooserUI;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            c cVar = ((c[]) objArr)[0];
            if (cVar.sVf == null) {
                cVar.sVf = this.sUZ.c(cVar.sVd);
            }
            return cVar;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            this.sUZ.sUC.notifyDataSetChanged();
        }
    }

    class e {
        OnDismissListener FV;
        public h ivv;
        BaseAdapter kjh;
        Context mContext;
        String mTitle;
        OnClickListener sUW;
        final /* synthetic */ AppChooserUI sUZ;
        ListView sVi = ((ListView) View.inflate(this.mContext, R.i.cUB, null));
        OnItemClickListener sVj;
        OnClickListener sVk;

        public e(AppChooserUI appChooserUI, Context context) {
            this.sUZ = appChooserUI;
            this.mContext = context;
        }

        public final void jI(boolean z) {
            if (this.ivv == null) {
                return;
            }
            if (z) {
                this.ivv.a(R.l.dIW, this.sUW);
                this.ivv.b(R.l.dIV, this.sVk);
                return;
            }
            this.ivv.a(R.l.dIW, null);
            this.ivv.b(R.l.dIV, null);
        }
    }

    public enum f {
        ;

        static {
            sVl = 1;
            sVm = 2;
            sVn = 3;
            sVo = new int[]{sVl, sVm, sVn};
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        u.bCJ();
        u.wX(this.sUE);
        x.a(getWindow());
        Intent intent = getIntent();
        Parcelable parcelableExtra = intent.getParcelableExtra("targetintent");
        if (parcelableExtra instanceof Intent) {
            this.sUD = (Intent) parcelableExtra;
            CharSequence stringExtra = intent.getStringExtra("title");
            this.sUE = intent.getIntExtra(Columns.TYPE, 0);
            this.sUG = intent.getBundleExtra("transferback");
            this.sUI = intent.getStringArrayListExtra("targetwhitelist");
            this.sUQ = intent.getBooleanExtra("needupate", false);
            this.mimeType = intent.getStringExtra("mimetype");
            this.scene = intent.getIntExtra("scene", 0);
            if (ap.zb()) {
                boolean z;
                ap.yY();
                this.sUM = (String) com.tencent.mm.u.c.vr().get(xQ(274528), (Object) "");
                if (!TextUtils.isEmpty(this.sUM) && p.n(this.uSU.uTo, this.sUM) && (this.sUI == null || this.sUI.isEmpty() || this.sUI.contains(this.sUM))) {
                    Intent intent2 = new Intent(this.sUD);
                    intent2.setPackage(this.sUM);
                    if (bg.j((Context) this, intent2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z || this.scene == 6) {
                    boolean z2;
                    this.aJt = getPackageManager();
                    this.sUC = new a(this);
                    u.bCJ();
                    this.sUH = u.t(this.sUE, intent.getBundleExtra("key_recommend_params"));
                    this.sUP = this.sUH.dt(this.uSU.uTo);
                    ap.yY();
                    this.sUN = ((Integer) com.tencent.mm.u.c.vr().get(bGw(), Integer.valueOf(0))).intValue();
                    u.bCJ();
                    this.sUO = u.wW(this.sUE);
                    w.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", String.valueOf(this.sUP), Integer.valueOf(this.sUN));
                    this.sUR = !intent.getBooleanExtra("not_show_recommend_app", false);
                    if (this.sUN >= this.sUO) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.sUL = a(this.sUD, bGx(), this.sUI);
                    if (!(z2 || this.sUP)) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(bGw(), Integer.valueOf(this.sUN + 1));
                    }
                    if (this.sUP) {
                        u.bCJ();
                        u.wZ(this.sUE);
                    } else if (!z2) {
                        u.bCJ();
                        u.wY(this.sUE);
                    }
                    if (this.sUL == null || this.sUL.size() != 1 || (bGx() && !this.sUP)) {
                        zg(8);
                        if (this.sUL == null || this.sUL.isEmpty()) {
                            i(4097, null, false);
                            return;
                        }
                        this.sUC.kIf = this.sUL;
                        ap.yY();
                        this.sUS = ((Long) com.tencent.mm.u.c.vr().get(xQ(274560), Long.valueOf(0))).longValue();
                        FileDownloadTaskInfo aU = com.tencent.mm.plugin.downloader.model.e.akM().aU(this.sUS);
                        w.d("MicroMsg.AppChooserUI", "downloadId:" + this.sUS + ", status:" + aU.status);
                        if (3 == aU.status && com.tencent.mm.a.e.aO(aU.path) && this.sUC != null) {
                            this.sUC.sVa = f.sVn;
                            this.sUC.notifyDataSetChanged();
                        }
                        this.sUT = new e(this, this.uSU.uTo);
                        e eVar = this.sUT;
                        if (stringExtra != null) {
                            eVar.mTitle = stringExtra.toString();
                        } else {
                            eVar.mTitle = null;
                        }
                        this.sUT.sVj = this.sUU;
                        this.sUT.sUW = this.sUW;
                        this.sUT.sVk = this.sUV;
                        this.sUT.kjh = this.sUC;
                        this.sUT.FV = this.FV;
                        e eVar2 = this.sUT;
                        if (eVar2.sVj != null) {
                            eVar2.sVi.setOnItemClickListener(eVar2.sVj);
                        }
                        if (eVar2.kjh != null) {
                            eVar2.sVi.setAdapter(eVar2.kjh);
                        }
                        eVar2.ivv = com.tencent.mm.ui.base.g.a(eVar2.mContext, true, eVar2.mTitle, eVar2.sVi, eVar2.mContext.getString(R.l.dIW), eVar2.mContext.getString(R.l.dIV), eVar2.sUW, eVar2.sVk, R.e.aUd);
                        eVar2.ivv.setOnDismissListener(eVar2.FV);
                        eVar2.ivv.show();
                        if (!(this.sUQ || !this.sUP || z2)) {
                            this.sUJ = this.sUK;
                            this.sUT.jI(true);
                        }
                        com.tencent.mm.plugin.downloader.model.e.akM();
                        com.tencent.mm.plugin.downloader.model.b.a(this.sUY);
                        return;
                    }
                    c cVar = (c) this.sUL.get(0);
                    if (cVar == null) {
                        i(4097, null, false);
                        return;
                    } else if (cVar.sVd != null) {
                        i(-1, cVar.sVd.activityInfo.packageName, false);
                        return;
                    } else {
                        i(4098, null, false);
                        return;
                    }
                }
                i(-1, this.sUM, true);
                return;
            }
            w.e("MicroMsg.AppChooserUI", "acc not ready");
            i(4097, null, false);
            return;
        }
        w.w("ChooseActivity", "Target is not an intent: " + parcelableExtra);
        i(0, null, false);
    }

    protected void onResume() {
        super.onResume();
        if (this.sUQ && this.sUD != null && this.sUH.v(this, this.sUD)) {
            w.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
            this.sUQ = false;
            this.sUK.sVh = false;
        }
        this.sUP = this.sUH.dt(this.uSU.uTo);
        this.sUL = a(this.sUD, bGx(), this.sUI);
        if (this.sUP && this.sUJ == null) {
            this.sUJ = this.sUK;
            this.sUT.jI(true);
        }
        if (this.sUC != null) {
            this.sUC.kIf = this.sUL;
            this.sUC.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.e.akM();
        com.tencent.mm.plugin.downloader.model.b.b(this.sUY);
        if (this.sUT != null) {
            this.sUT.ivv.dismiss();
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onBackPressed() {
        super.onBackPressed();
        i(0, null, false);
    }

    final int xQ(int i) {
        if (this.mimeType != null) {
            return (this.sUE + i) + this.mimeType.hashCode();
        }
        return this.sUE + i;
    }

    private int bGw() {
        return 274496 + this.sUE;
    }

    private void i(int i, String str, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("selectpkg", str);
        intent.putExtra("isalways", z);
        intent.putExtra("transferback", this.sUG);
        setResult(i, intent);
        finish();
    }

    private boolean bGx() {
        w.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", Boolean.valueOf(this.sUR), Integer.valueOf(this.sUN), Integer.valueOf(this.sUO), Boolean.valueOf(bg.Hp()));
        if (!this.sUR || this.sUN >= this.sUO || bg.Hp() || com.tencent.mm.sdk.platformtools.f.fuV == 1) {
            return false;
        }
        return true;
    }

    private List<c> a(Intent intent, boolean z, ArrayList<String> arrayList) {
        List<c> arrayList2 = new ArrayList();
        List queryIntentActivities = this.aJt.queryIntentActivities(intent, 65536);
        com.tencent.mm.pluginsdk.model.u.a bCB = this.sUH.bCB();
        if (!bg.mA(bCB.sCP)) {
            this.sUF = bCB.sCP;
        } else if (bCB.sCO > 0) {
            this.sUF = getResources().getString(bCB.sCO);
        }
        if (bCB.sCN > 0) {
            this.sUK.sVf = getResources().getDrawable(bCB.sCN);
        }
        if (bCB.sCQ > 0) {
            this.sUK.sVe = getResources().getString(bCB.sCQ);
        } else {
            this.sUK.sVe = bCB.sCR;
        }
        this.sUK.sVg = true;
        this.sUK.rcb = this.sUP;
        if (this.sUP) {
            this.sUK.mLI = true;
        }
        if (this.sUQ) {
            this.sUK.sVh = true;
        }
        Object obj = null;
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            int i = 0;
            while (i < size) {
                Object obj2;
                w.d("MicroMsg.AppChooserUI", "cpan name:%s", ((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name);
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                if (resolveInfo != null) {
                    String str = resolveInfo.activityInfo.packageName;
                    if (arrayList == null || arrayList.isEmpty() || arrayList.contains(str)) {
                        if (this.sUH.LN(str)) {
                            this.sUK.sVd = resolveInfo;
                            this.sUK.mLI = true;
                            if ((!z && this.sUP) || (!z && this.sUK.mLI)) {
                                arrayList2.add(0, this.sUK);
                                obj2 = 1;
                                i++;
                                obj = obj2;
                            }
                        } else {
                            arrayList2.add(new c(this, resolveInfo, this.sUH.a(this.uSU.uTo, resolveInfo)));
                        }
                    }
                }
                obj2 = obj;
                i++;
                obj = obj2;
            }
        }
        if (z && r1 == null) {
            if (this.sUE != 0 || this.mimeType == null) {
                arrayList2.add(0, this.sUK);
            } else {
                arrayList2.add(0, this.sUK);
                if (this.sUQ) {
                    g.oUh.i(11168, Integer.valueOf(2), Integer.valueOf(this.scene));
                } else {
                    g.oUh.i(11168, Integer.valueOf(1), Integer.valueOf(this.scene));
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c cVar = (c) arrayList2.get(size2);
            if (cVar.sVd != null) {
                String str2 = cVar.sVd.activityInfo.packageName;
                if (!(bg.mA(str2) || hashSet.add(str2))) {
                    arrayList2.remove(size2);
                }
            }
        }
        return arrayList2;
    }

    private static Drawable a(Resources resources, int i) {
        try {
            return com.tencent.mm.bh.a.b(resources, i);
        } catch (NotFoundException e) {
            return null;
        }
    }

    private Drawable c(ResolveInfo resolveInfo) {
        try {
            Drawable a;
            if (!(resolveInfo.resolvePackageName == null || resolveInfo.icon == 0)) {
                a = a(this.aJt.getResourcesForApplication(resolveInfo.resolvePackageName), resolveInfo.icon);
                if (a != null) {
                    return a;
                }
            }
            int iconResource = resolveInfo.getIconResource();
            if (iconResource != 0) {
                a = a(this.aJt.getResourcesForApplication(resolveInfo.activityInfo.packageName), iconResource);
                if (a != null) {
                    return a;
                }
            }
        } catch (NameNotFoundException e) {
            w.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", e);
        }
        return resolveInfo.loadIcon(this.aJt);
    }
}
