package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.j;
import com.tencent.mm.modelfriend.j.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.c.ajm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAddUI extends MMWizardActivity {
    private e hUh = null;
    private int iQX;
    private ListView iss;
    private ProgressDialog isv = null;
    private TextView jWk = null;
    private String kwg = null;
    private View nsQ;
    private boolean oIa = true;
    private String oVk;
    private String vdU = "";
    private int vdV = 2;
    private TextView wgA = null;
    private TextView wgB = null;
    private Button wgC = null;
    private List<String[]> wgD;
    private a wgE = new a(this) {
        final /* synthetic */ FindMContactAddUI wgF;

        {
            this.wgF = r1;
        }

        public final void notifyDataSetChanged() {
            if (this.wgF.vdV == 2 || this.wgF.vdV != 1) {
                this.wgF.wgC.setText(this.wgF.getString(R.l.ekp, new Object[]{Integer.valueOf(this.wgF.wgx.getCount())}));
            } else {
                this.wgF.wgC.setText(this.wgF.getString(R.l.ekq));
            }
            if (this.wgF.wgx.Fg()) {
                if (!(this.wgF.vdV == 1 || this.wgF.wgC.getVisibility() != 0 || this.wgF.wgB == null)) {
                    this.wgF.wgC.setVisibility(8);
                    this.wgF.wgB.setVisibility(0);
                }
            } else if (!(this.wgF.vdV == 1 || this.wgF.wgC.getVisibility() != 8 || this.wgF.wgB == null)) {
                this.wgF.wgC.setVisibility(0);
                this.wgF.wgB.setVisibility(8);
            }
            if (this.wgF.wgx.Ff() <= 0 || this.wgF.vdV == 1) {
                this.wgF.wgy.setText(this.wgF.getResources().getQuantityString(R.j.dsl, this.wgF.wgx.getCount(), new Object[]{Integer.valueOf(this.wgF.wgx.getCount())}));
                return;
            }
            this.wgF.wgy.setText(this.wgF.getResources().getQuantityString(R.j.dsi, this.wgF.wgx.Ff(), new Object[]{Integer.valueOf(this.wgF.wgx.Ff())}));
        }
    };
    private j wgx;
    private TextView wgy = null;
    private TextView wgz = null;

    static /* synthetic */ void i(FindMContactAddUI findMContactAddUI) {
        findMContactAddUI.aHf();
        if (findMContactAddUI.wgx.Ff() == 0) {
            g.a((Context) findMContactAddUI, findMContactAddUI.getString(R.l.ekH), "", findMContactAddUI.getString(R.l.ekn), findMContactAddUI.getString(R.l.eko), new OnClickListener(findMContactAddUI) {
                final /* synthetic */ FindMContactAddUI wgF;

                {
                    this.wgF = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, new OnClickListener(findMContactAddUI) {
                final /* synthetic */ FindMContactAddUI wgF;

                {
                    this.wgF = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.wgF.vdU == null || !this.wgF.vdU.contains("2")) {
                        this.wgF.aXS();
                        return;
                    }
                    Intent intent = new Intent(this.wgF, FindMContactInviteUI.class);
                    intent.putExtra("regsetinfo_ticket", this.wgF.kwg);
                    intent.putExtra("login_type", this.wgF.iQX);
                    intent.putExtra("regsetinfo_NextStyle", this.wgF.vdV);
                    MMWizardActivity.z(this.wgF, intent);
                }
            });
            return;
        }
        n vd = ap.vd();
        e anonymousClass2 = new e(findMContactAddUI) {
            final /* synthetic */ FindMContactAddUI wgF;

            {
                this.wgF = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                if (this.wgF.isv != null) {
                    this.wgF.isv.dismiss();
                    this.wgF.isv = null;
                }
                if (this.wgF.hUh != null) {
                    ap.vd().b(30, this.wgF.hUh);
                    this.wgF.hUh = null;
                }
                if (i == 4 && i2 == -24 && !bg.mA(str)) {
                    Toast.makeText(this.wgF.uSU.uTo, str, 1).show();
                } else if (this.wgF.vdU == null || !this.wgF.vdU.contains("2")) {
                    this.wgF.aXS();
                } else {
                    Intent intent = new Intent(this.wgF, FindMContactInviteUI.class);
                    intent.putExtra("regsetinfo_ticket", this.wgF.kwg);
                    intent.putExtra("login_type", this.wgF.iQX);
                    intent.putExtra("regsetinfo_NextStyle", this.wgF.vdV);
                    MMWizardActivity.z(this.wgF, intent);
                }
            }
        };
        findMContactAddUI.hUh = anonymousClass2;
        vd.a(30, anonymousClass2);
        Context context = findMContactAddUI.uSU.uTo;
        findMContactAddUI.getString(R.l.dIO);
        findMContactAddUI.isv = g.a(context, findMContactAddUI.getString(R.l.ekB), true, new OnCancelListener(findMContactAddUI) {
            final /* synthetic */ FindMContactAddUI wgF;

            {
                this.wgF = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        j jVar = findMContactAddUI.wgx;
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (int i = 0; i < jVar.hAY.size(); i++) {
            if (jVar.hBc[i] == 1) {
                linkedList.add(((ajm) jVar.hAY.get(i)).jNj);
                linkedList2.add(Integer.valueOf(52));
            }
        }
        ap.vd().a(new com.tencent.mm.pluginsdk.model.n(2, linkedList, linkedList2, "", ""), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eku);
        com.tencent.mm.plugin.c.a.imw.ox();
        this.kwg = getIntent().getStringExtra("regsetinfo_ticket");
        this.vdU = getIntent().getStringExtra("regsetinfo_NextStep");
        this.vdV = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.iQX = getIntent().getIntExtra("login_type", 0);
        this.oVk = b.Oz();
        KC();
    }

    private void bYS() {
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.isv = g.a(context, getString(R.l.eBb), true, new OnCancelListener(this) {
            final /* synthetic */ FindMContactAddUI wgF;

            {
                this.wgF = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        ap.vL().a(new af.a(this) {
            final /* synthetic */ FindMContactAddUI wgF;

            {
                this.wgF = r1;
            }

            public final boolean Bo() {
                if (this.wgF.isv != null) {
                    this.wgF.isv.dismiss();
                    this.wgF.isv = null;
                }
                this.wgF.wgx.notifyDataSetChanged();
                return false;
            }

            public final boolean Bn() {
                try {
                    this.wgF.wgD = com.tencent.mm.pluginsdk.a.dn(this.wgF);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.FindMContactAddUI", e, "", new Object[0]);
                }
                this.wgF.wgx.hBa = this.wgF.wgD;
                this.wgF.wgx.e(com.tencent.mm.modelfriend.af.Ge());
                return true;
            }

            public final String toString() {
                return super.toString() + "|listMFriendData";
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aXS();
        return true;
    }

    private void aXS() {
        b.mN(this.oVk);
        aHf();
        zu(1);
    }

    protected void onResume() {
        super.onResume();
        this.wgx.notifyDataSetChanged();
        if (this.iQX == 1) {
            b.b(true, ap.uY() + "," + getClass().getName() + ",R300_300_QQ," + ap.ec("R300_300_QQ") + ",1");
            b.mM("R300_300_QQ");
        } else {
            b.b(true, ap.uY() + "," + getClass().getName() + ",R300_300_phone," + ap.ec("R300_300_phone") + ",1");
            b.mM("R300_300_phone");
        }
        if (this.oIa) {
            w.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bg.bJZ());
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                bYS();
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (this.iQX == 1) {
            b.b(false, ap.uY() + "," + getClass().getName() + ",R300_300_QQ," + ap.ec("R300_300_QQ") + ",2");
        } else {
            b.b(false, ap.uY() + "," + getClass().getName() + ",R300_300_phone," + ap.ec("R300_300_phone") + ",2");
        }
    }

    public void onDestroy() {
        if (this.hUh != null) {
            ap.vd().b(30, this.hUh);
            this.hUh = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dcV;
    }

    protected final void KC() {
        this.jWk = (TextView) findViewById(R.h.cku);
        this.jWk.setText(R.l.eAZ);
        this.iss = (ListView) findViewById(R.h.ckw);
        if (this.vdV == 2 || this.vdV != 1) {
            this.nsQ = LayoutInflater.from(this).inflate(R.i.dcW, null);
            this.wgy = (TextView) this.nsQ.findViewById(R.h.bPN);
            this.wgz = (TextView) this.nsQ.findViewById(R.h.bPQ);
            this.wgA = (TextView) this.nsQ.findViewById(R.h.bPL);
            this.wgC = (Button) this.nsQ.findViewById(R.h.bPK);
            this.wgz.setText(getString(R.l.ekL));
            this.wgA.setText(getString(R.l.ekM));
            this.wgC.setText(getString(R.l.ekp, new Object[]{Integer.valueOf(0)}));
            this.wgB = (TextView) this.nsQ.findViewById(R.h.ckp);
        } else {
            this.nsQ = LayoutInflater.from(this).inflate(R.i.dcX, null);
            this.wgy = (TextView) this.nsQ.findViewById(R.h.bPN);
            this.wgz = (TextView) this.nsQ.findViewById(R.h.bPQ);
            this.wgA = (TextView) this.nsQ.findViewById(R.h.bPL);
            this.wgC = (Button) this.nsQ.findViewById(R.h.bPK);
            this.wgz.setText(getString(R.l.ekL));
            this.wgA.setText(getString(R.l.ekM));
            this.wgC.setText(getString(R.l.ekq));
        }
        this.wgx = new j(this, this.wgE, 1);
        this.wgC.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ FindMContactAddUI wgF;

            {
                this.wgF = r1;
            }

            public final void onClick(View view) {
                b.mO(ap.uY() + "," + this.wgF.getClass().getName() + ",R300_300_AddAllButton," + ap.ec("R300_300_AddAllButton") + ",3");
                if (this.wgF.vdV == 2) {
                    this.wgF.wgx.bh(true);
                    this.wgF.wgx.notifyDataSetChanged();
                    this.wgF.wgC.setVisibility(8);
                    if (this.wgF.wgB != null) {
                        this.wgF.wgB.setVisibility(0);
                    }
                } else if (this.wgF.vdV == 1) {
                    this.wgF.wgx.bh(true);
                    this.wgF.wgx.notifyDataSetChanged();
                    FindMContactAddUI.i(this.wgF);
                } else {
                    this.wgF.wgx.bh(true);
                    this.wgF.wgx.notifyDataSetChanged();
                    this.wgF.wgC.setVisibility(8);
                    if (this.wgF.wgB != null) {
                        this.wgF.wgB.setVisibility(0);
                    }
                }
            }
        });
        if (this.wgB != null) {
            this.wgB.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ FindMContactAddUI wgF;

                {
                    this.wgF = r1;
                }

                public final void onClick(View view) {
                    this.wgF.wgC.setVisibility(0);
                    this.wgF.wgB.setVisibility(8);
                    this.wgF.wgx.bh(false);
                    this.wgF.wgx.notifyDataSetChanged();
                }
            });
            this.wgB.setVisibility(8);
        }
        this.iss.addHeaderView(this.nsQ);
        this.iss.setAdapter(this.wgx);
        a(0, getString(R.l.dHP), new OnMenuItemClickListener(this) {
            final /* synthetic */ FindMContactAddUI wgF;

            {
                this.wgF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                FindMContactAddUI.i(this.wgF);
                return true;
            }
        });
        AnonymousClass11 anonymousClass11 = new View.OnClickListener(this) {
            final /* synthetic */ FindMContactAddUI wgF;

            {
                this.wgF = r1;
            }

            public final void onClick(View view) {
                c.a(this.wgF.iss);
            }
        };
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.FindMContactAddUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    bYS();
                    return;
                }
                this.oIa = false;
                g.a((Context) this, getString(R.l.eFH), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                    final /* synthetic */ FindMContactAddUI wgF;

                    {
                        this.wgF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.wgF.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        this.wgF.oIa = true;
                        this.wgF.finish();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ FindMContactAddUI wgF;

                    {
                        this.wgF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.wgF.oIa = true;
                        this.wgF.finish();
                    }
                });
                return;
            default:
                return;
        }
    }
}
