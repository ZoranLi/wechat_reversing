package com.tencent.mm.plugin.card.ui;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.card.a.m;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.b.d.AnonymousClass7;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public class CardShopUI extends MMActivity implements com.tencent.mm.plugin.card.a.m.a {
    private ListView Fg;
    BroadcastReceiver iRM = new BroadcastReceiver(this) {
        final /* synthetic */ CardShopUI koY;

        {
            this.koY = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.LOCALE_CHANGED") && CardShopUI.ahO()) {
                this.koY.ahP();
            }
        }
    };
    private OnClickListener iuW = new OnClickListener(this) {
        final /* synthetic */ CardShopUI koY;

        {
            this.koY = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == R.h.cFa) {
                iw iwVar = (iw) view.getTag();
                if (iwVar != null) {
                    b.a(this.koY, iwVar.fOb, iwVar.fPF, iwVar.hCE);
                    g.oUh.i(11941, new Object[]{Integer.valueOf(5), this.koY.kcX.afm(), this.koY.kcX.afn(), "", iwVar.name});
                }
            }
        }
    };
    private String kcJ;
    private com.tencent.mm.plugin.card.base.b kcX;
    private ArrayList<iw> kde = new ArrayList();
    private boolean kiV = false;
    private ProgressDialog koS;
    private String koT = "";
    private a koU;
    private LinearLayout koV;
    private View koW;
    private TextView koX;

    class a extends BaseAdapter {
        final /* synthetic */ CardShopUI koY;

        class a {
            public TextView koZ;
            public TextView kpa;
            public TextView kpb;
            public ImageView kpc;
            public View kpd;
            final /* synthetic */ a kpe;

            a(a aVar) {
                this.kpe = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return kD(i);
        }

        private a(CardShopUI cardShopUI) {
            this.koY = cardShopUI;
        }

        public final int getCount() {
            return this.koY.kde.size();
        }

        private iw kD(int i) {
            return (iw) this.koY.kde.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(this.koY.uSU.uTo, R.i.cWX, null);
                a aVar2 = new a(this);
                aVar2.koZ = (TextView) view.findViewById(R.h.cEX);
                aVar2.kpa = (TextView) view.findViewById(R.h.cEW);
                aVar2.kpb = (TextView) view.findViewById(R.h.cEV);
                aVar2.kpc = (ImageView) view.findViewById(R.h.cEZ);
                aVar2.kpd = view.findViewById(R.h.cFa);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            iw kD = kD(i);
            if (kD == null) {
                aVar.koZ.setText("");
                aVar.kpa.setText("");
                aVar.kpb.setText("");
            } else {
                aVar.koZ.setText(kD.name);
                if (kD.tnX <= 0.0f) {
                    aVar.kpa.setVisibility(8);
                } else {
                    aVar.kpa.setText(l.d(this.koY.getBaseContext(), kD.tnX));
                    aVar.kpa.setVisibility(0);
                }
                aVar.kpb.setText(kD.gkB + kD.gkC + kD.hCE);
                aVar.kpd.setOnClickListener(this.koY.iuW);
                aVar.kpd.setTag(kD);
            }
            return view;
        }
    }

    public void onCreate(Bundle bundle) {
        CardShopUI cardShopUI;
        super.onCreate(bundle);
        this.kcX = (com.tencent.mm.plugin.card.base.b) getIntent().getParcelableExtra("key_card_info_data");
        Object stringExtra = getIntent().getStringExtra("KEY_CARD_TP_ID");
        String stringExtra2 = getIntent().getStringExtra("KEY_CARD_ID");
        if (this.kcX != null) {
            w.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
            this.koT = this.kcX.afn();
            stringExtra2 = this.kcX.afm();
            cardShopUI = this;
        } else {
            if (!TextUtils.isEmpty(stringExtra)) {
                this.koT = stringExtra;
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = "";
                    cardShopUI = this;
                } else {
                    cardShopUI = this;
                }
            }
            if (TextUtils.isEmpty(this.koT)) {
                w.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
                finish();
            }
            w.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
            this.kiV = r0;
            if (this.kiV) {
                ahN();
            }
            KC();
        }
        cardShopUI.kcJ = stringExtra2;
        if (TextUtils.isEmpty(this.koT)) {
            w.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
            finish();
        }
        w.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.kiV = r0;
        if (this.kiV) {
            ahN();
        }
        KC();
    }

    protected final void KC() {
        if (TextUtils.isEmpty(this.kcX.afi().toN)) {
            zi(R.l.dQn);
        } else {
            qP(this.kcX.afi().toN);
        }
        this.Fg = (ListView) findViewById(R.h.bys);
        this.koV = (LinearLayout) View.inflate(getBaseContext(), R.i.cWJ, null);
        this.Fg.addHeaderView(this.koV);
        this.koU = new a();
        this.Fg.setAdapter(this.koU);
        final Intent intent = getIntent();
        this.Fg.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CardShopUI koY;

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    w.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
                    return;
                }
                if (i > 0) {
                    i--;
                }
                iw iwVar = (iw) this.koY.kde.get(i);
                if (!TextUtils.isEmpty(iwVar.tnY) && !TextUtils.isEmpty(iwVar.tnZ)) {
                    b.d(this.koY.kcJ, iwVar.tnY, iwVar.tnZ, 1052, intent.getIntExtra("key_from_appbrand_type", 0));
                } else if (!TextUtils.isEmpty(iwVar.kfu)) {
                    b.a(this.koY, iwVar.kfu, 1);
                    g.oUh.i(11941, new Object[]{Integer.valueOf(4), this.koY.kcX.afm(), this.koY.kcX.afn(), "", iwVar.name});
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardShopUI koY;

            {
                this.koY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.koY.finish();
                return true;
            }
        });
        this.koW = View.inflate(this, R.i.cWI, null);
        if (this.koV != null) {
            this.koV.addView(this.koW);
        }
        this.koX = (TextView) this.koW.findViewById(R.h.bxB);
        this.koX.setText(R.l.dRZ);
        this.koW.setVisibility(8);
    }

    protected void onDestroy() {
        if (this.kiV) {
            unregisterReceiver(this.iRM);
        }
        al.agd().a(this.koT, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.cWY;
    }

    public final void a(boolean z, ArrayList<iw> arrayList) {
        if (this.koS != null) {
            this.koS.dismiss();
            this.koS = null;
        }
        String str = "MicroMsg.CardShopUI";
        String str2 = "onGotCardShop, isOk = %b, shop list size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        w.d(str, str2, objArr);
        if (!z) {
            w.e("MicroMsg.CardShopUI", "onGotCardShop fail");
        } else if (arrayList == null || arrayList.size() == 0) {
            w.e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
        } else {
            if (this.kde != null) {
                this.kde.clear();
                this.kde.addAll(arrayList);
                this.koW.setVisibility(0);
            } else {
                this.koW.setVisibility(8);
            }
            this.koU.notifyDataSetChanged();
        }
    }

    private void ahN() {
        w.i("MicroMsg.CardShopUI", bf.NAME);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        registerReceiver(this.iRM, intentFilter);
        if (ahO()) {
            ahP();
            return;
        }
        com.tencent.mm.ui.base.g.a(this, getString(R.l.dTi, new Object[]{getString(R.l.dQn)}), getString(R.l.dIO), new AnonymousClass7(this), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private static boolean ahO() {
        boolean z;
        if (l.Gl() || l.Gm()) {
            z = false;
        } else {
            z = true;
        }
        return !z;
    }

    private void ahP() {
        if (al.agd().a(this.koT, this.kcJ, (com.tencent.mm.plugin.card.a.m.a) this)) {
            Context context = this.uSU.uTo;
            getString(R.l.dIO);
            this.koS = com.tencent.mm.ui.base.g.a(context, getString(R.l.dQO), true, new OnCancelListener(this) {
                final /* synthetic */ CardShopUI koY;

                {
                    this.koY = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    m agd = al.agd();
                    agd.a(this.koY.koT, this.koY);
                    if (agd.kdB != null) {
                        ap.vd().c(agd.kdB);
                    }
                }
            });
            return;
        }
        com.tencent.mm.ui.base.g.bl(this, getString(R.l.dQN));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.CardShopUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 69:
                if (iArr[0] == 0) {
                    w.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.kiV);
                    if (!this.kiV) {
                        this.kiV = true;
                        ahN();
                        return;
                    }
                    return;
                }
                com.tencent.mm.ui.base.g.a(this, getString(R.l.eFI), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ CardShopUI koY;

                    {
                        this.koY = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.koY.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, null);
                return;
            default:
                return;
        }
    }
}
