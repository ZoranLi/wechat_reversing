package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.hv;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.a.d;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.e;

public class IPCallAddressUI extends MMActivity implements e {
    private ListView mSK;
    private e mSL = null;
    private int mSM = 0;
    private boolean mSN = false;
    private boolean mSO = true;
    private boolean mSP = false;
    private c mSQ = new c<hv>(this) {
        final /* synthetic */ IPCallAddressUI mSS;

        {
            this.mSS = r2;
            this.usg = hv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (this.mSS.mSL != null) {
                this.mSS.mSL.aEX();
            }
            return true;
        }
    };
    private Runnable mSR = new Runnable(this) {
        final /* synthetic */ IPCallAddressUI mSS;

        {
            this.mSS = r1;
        }

        public final void run() {
            a.aDR().a(null, true);
        }
    };
    private View mSy;

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.yY();
        if (((Boolean) com.tencent.mm.u.c.vr().get(w.a.uCd, Boolean.valueOf(false))).booleanValue()) {
            ap.yY();
            com.tencent.mm.u.c.vr().a(w.a.uCd, Boolean.valueOf(false));
            Intent intent = new Intent();
            intent.setClass(this.uSU.uTo, IPCallAcitivityUI.class);
            this.uSU.uTo.startActivity(intent);
            overridePendingTransition(R.a.aRN, R.a.aRM);
            this.mSO = false;
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallAddressUI mSS;

            {
                this.mSS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.mSS.mSM == 1) {
                    com.tencent.mm.plugin.ipcall.b.imv.t(new Intent(), this.mSS);
                } else {
                    this.mSS.finish();
                }
                return true;
            }
        });
        if (this.mSO) {
            this.mSP = true;
            aFa();
        }
        ap.yY();
        this.mSN = ((Boolean) com.tencent.mm.u.c.vr().get(w.a.uBz, Boolean.valueOf(true))).booleanValue();
        zi(R.l.etM);
        this.mSK = (ListView) findViewById(R.h.bnv);
        this.mSy = findViewById(R.h.bnI);
        this.mSL = new e(this, this.mSK, this.mSy);
        e eVar = this.mSL;
        eVar.mSx = new h(eVar.mSz);
        ViewGroup viewGroup = (ViewGroup) View.inflate(eVar.mSz, R.i.dgj, null);
        eVar.mSw.addHeaderView(viewGroup, null, false);
        eVar.mSw.setAdapter(eVar.mSx);
        eVar.mSB = (TextView) viewGroup.findViewById(R.h.bmM);
        eVar.mSC = (TextView) viewGroup.findViewById(R.h.bmP);
        eVar.mSD = (LinearLayout) viewGroup.findViewById(R.h.bmK);
        eVar.mSE = (TextView) viewGroup.findViewById(R.h.bmL);
        eVar.mSF = (ImageView) viewGroup.findViewById(R.h.cKJ);
        viewGroup.findViewById(R.h.bmQ).setOnClickListener(new OnClickListener(eVar) {
            final /* synthetic */ e mSG;

            {
                this.mSG = r1;
            }

            public final void onClick(View view) {
                Object obj;
                boolean z;
                ap.yY();
                boolean booleanValue = ((Boolean) com.tencent.mm.u.c.vr().get(w.a.uBD, Boolean.valueOf(false))).booleanValue();
                if (booleanValue) {
                    ap.yY();
                    i.D(2, ((Integer) com.tencent.mm.u.c.vr().get(w.a.uBE, Integer.valueOf(-1))).intValue(), -1);
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(w.a.uBE, Integer.valueOf(-1));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.IPCallAddressController", "set red dot type from %d to -1", new Object[]{Integer.valueOf(r0)});
                }
                if (booleanValue) {
                    obj = "true";
                } else {
                    String str = "false";
                }
                ap.yY();
                String str2 = (String) com.tencent.mm.u.c.vr().get(w.a.uBF, "");
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.IPCallAddressController", "set show red dot from %s to false, set account string from %s to null", new Object[]{obj, str2});
                ap.yY();
                com.tencent.mm.u.c.vr().a(w.a.uBD, Boolean.valueOf(false));
                ap.yY();
                com.tencent.mm.u.c.vr().a(w.a.uBF, "");
                ap.yY();
                if (((Integer) com.tencent.mm.u.c.vr().get(w.a.uBH, Integer.valueOf(0))).intValue() == 1) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    ap.yY();
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.IPCallAddressController", "set account activity string from %s to null", new Object[]{(String) com.tencent.mm.u.c.vr().get(w.a.uBG, "")});
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(w.a.uBG, "");
                }
                g.oUh.i(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                this.mSG.aEX();
                Intent intent = new Intent();
                intent.setClass(this.mSG.mSz, IPCallShareCouponUI.class);
                this.mSG.mSz.startActivity(intent);
            }
        });
        viewGroup.findViewById(R.h.bGb).setOnClickListener(new OnClickListener(eVar) {
            final /* synthetic */ e mSG;

            {
                this.mSG = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.mSG.mSz, IPCallContactUI.class);
                this.mSG.mSz.startActivity(intent);
            }
        });
        viewGroup.findViewById(R.h.bJm).setOnClickListener(new OnClickListener(eVar) {
            final /* synthetic */ e mSG;

            {
                this.mSG = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.mSG.mSz, IPCallDialUI.class);
                intent.putExtra("IPCallTalkUI_dialScene", 1);
                this.mSG.mSz.startActivityForResult(intent, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
            }
        });
        eVar.mSw.setOnItemClickListener(new OnItemClickListener(eVar) {
            final /* synthetic */ e mSG;

            {
                this.mSG = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!this.mSG.mSx.nJ(i) && (adapterView instanceof ListView)) {
                    k ou = this.mSG.mSx.ou(i - ((ListView) adapterView).getHeaderViewsCount());
                    if (ou != null) {
                        com.tencent.mm.plugin.ipcall.a.g.c cVar = null;
                        if (ou.field_addressId > 0) {
                            cVar = com.tencent.mm.plugin.ipcall.a.i.aEn().cr(ou.field_addressId);
                        }
                        Intent intent = new Intent(this.mSG.mSz, IPCallUserProfileUI.class);
                        if (cVar != null) {
                            intent.putExtra("IPCallProfileUI_contactid", cVar.field_contactId);
                            intent.putExtra("IPCallProfileUI_systemUsername", cVar.field_systemAddressBookUsername);
                            intent.putExtra("IPCallProfileUI_wechatUsername", cVar.field_wechatUsername);
                        } else {
                            intent.putExtra("IPCallProfileUI_phonenumber", ou.field_phonenumber);
                        }
                        intent.putExtra("IPCallProfileUI_isNeedShowRecord", true);
                        this.mSG.mSz.startActivity(intent);
                    }
                }
            }
        });
        eVar.mSw.setOnItemLongClickListener(new OnItemLongClickListener(eVar) {
            final /* synthetic */ e mSG;

            {
                this.mSG = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                h hVar = this.mSG.mSx;
                if (hVar.mVI == null) {
                    hVar.mVI = m.aEQ();
                }
                k ou = this.mSG.mSx.ou(i - ((ListView) adapterView).getHeaderViewsCount());
                e eVar = this.mSG;
                int headerViewsCount = i - ((ListView) adapterView).getHeaderViewsCount();
                if (ou != null) {
                    l lVar = new l(eVar.mSz);
                    lVar.qJf = new n.c(eVar) {
                        final /* synthetic */ e mSG;

                        {
                            this.mSG = r1;
                        }

                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            lVar.add(R.l.dGB);
                        }
                    };
                    lVar.qJg = new AnonymousClass9(eVar, ou, headerViewsCount);
                    lVar.blb();
                }
                return true;
            }
        });
        ap.yY();
        if (((Boolean) com.tencent.mm.u.c.vr().get(w.a.uBz, Boolean.valueOf(true))).booleanValue()) {
            d.aDX().eQ(true);
            ap.yY();
            com.tencent.mm.u.c.vr().a(w.a.uBz, Boolean.valueOf(false));
        } else {
            d.aDX().eQ(false);
        }
        if (eVar.mSx.getCount() > 0) {
            eVar.mSy.setVisibility(8);
        } else {
            eVar.mSy.setVisibility(0);
        }
        eVar.aEY();
        eVar.aEX();
        eVar.mSA = true;
        ap.vd().a(257, this);
        com.tencent.mm.sdk.b.a.urY.b(this.mSQ);
        this.mSM = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
        g.oUh.a(257, 0, 1, true);
    }

    protected final int getLayoutId() {
        return R.i.dfX;
    }

    private void aFa() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bg.bJZ()});
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            com.tencent.mm.sdk.f.e.post(this.mSR, "IPCallAddressUI_LoadSystemAddressBook");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mSL != null) {
            e eVar = this.mSL;
            eVar.mSw.setOnItemClickListener(null);
            eVar.mSw.setOnItemLongClickListener(null);
            com.tencent.mm.x.n.Bl().b(eVar.mSx);
        }
        ap.vd().b(257, this);
        com.tencent.mm.sdk.b.a.urY.c(this.mSQ);
    }

    protected void onResume() {
        super.onResume();
        if (this.mSL != null) {
            e eVar = this.mSL;
            if (!(eVar.mSx == null || eVar.mSA)) {
                eVar.mSx.notifyDataSetChanged();
                if (eVar.mSx.getCount() > 0) {
                    eVar.mSy.setVisibility(8);
                } else {
                    eVar.mSy.setVisibility(0);
                }
            }
            eVar.mSA = false;
        }
        aQ();
        com.tencent.mm.plugin.ipcall.a.f.b.aEL().fb(true);
        if (!this.mSP) {
            this.mSP = true;
            aFa();
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.ipcall.a.d.g) && i == 0 && i2 == 0 && this.mSL != null) {
            this.mSL.aEY();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    public void onBackPressed() {
        if (this.mSM == 1) {
            com.tencent.mm.plugin.ipcall.b.imv.t(new Intent(), this);
        } else {
            super.onBackPressed();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.IPCallAddressUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bg.bJZ();
            com.tencent.mm.sdk.platformtools.w.w(str, str2, objArr);
            return;
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.IPCallAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 48:
                if (iArr[0] != 0 && this.mSN) {
                    this.mSN = false;
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.eFH), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ IPCallAddressUI mSS;

                        {
                            this.mSS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.mSS.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ IPCallAddressUI mSS;

                        {
                            this.mSS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
