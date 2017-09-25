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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.j;
import com.tencent.mm.modelfriend.j.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;

public class FindMContactInviteUI extends MMWizardActivity {
    private e hUh = null;
    private int iQX;
    private ListView iss;
    private ProgressDialog isv = null;
    private TextView jWk = null;
    private View nsQ;
    private boolean oIa = true;
    private String oVk;
    private int vdV = 2;
    private TextView wgA = null;
    private TextView wgB = null;
    private Button wgC = null;
    private List<String[]> wgD;
    private a wgE = new a(this) {
        final /* synthetic */ FindMContactInviteUI wgH;

        {
            this.wgH = r1;
        }

        public final void notifyDataSetChanged() {
            if (this.wgH.vdV == 2 || this.wgH.vdV != 1) {
                this.wgH.wgC.setText(this.wgH.getString(R.l.eky, new Object[]{Integer.valueOf(this.wgH.wgx.getCount())}));
            } else {
                this.wgH.wgC.setText(this.wgH.getString(R.l.ekz));
            }
            if (this.wgH.wgx.Fg()) {
                if (!(this.wgH.vdV == 1 || this.wgH.wgC.getVisibility() != 0 || this.wgH.wgB == null)) {
                    this.wgH.wgC.setVisibility(8);
                    this.wgH.wgB.setVisibility(0);
                }
            } else if (!(this.wgH.vdV == 1 || this.wgH.wgC.getVisibility() != 8 || this.wgH.wgB == null)) {
                this.wgH.wgC.setVisibility(0);
                this.wgH.wgB.setVisibility(8);
            }
            if (this.wgH.wgx.Ff() <= 0 || this.wgH.vdV == 1) {
                this.wgH.wgy.setText(this.wgH.getResources().getQuantityString(R.j.dsk, this.wgH.wgx.getCount(), new Object[]{Integer.valueOf(this.wgH.wgx.getCount())}));
                return;
            }
            this.wgH.wgy.setText(this.wgH.getResources().getQuantityString(R.j.dsj, this.wgH.wgx.Ff(), new Object[]{Integer.valueOf(this.wgH.wgx.Ff())}));
        }
    };
    private String wgG = null;
    private j wgx;
    private TextView wgy = null;
    private TextView wgz = null;

    static /* synthetic */ void h(FindMContactInviteUI findMContactInviteUI) {
        findMContactInviteUI.aHf();
        if (findMContactInviteUI.wgx.Ff() == 0) {
            findMContactInviteUI.aXS();
        } else {
            g.a((Context) findMContactInviteUI, findMContactInviteUI.getString(R.l.ekx), "", new OnClickListener(findMContactInviteUI) {
                final /* synthetic */ FindMContactInviteUI wgH;

                {
                    this.wgH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.wgH.iQX == 1) {
                        b.mO(ap.uY() + "," + getClass().getName() + ",R300_500_QQ," + ap.ec("R300_500_QQ") + ",3");
                    } else {
                        b.mO(ap.uY() + "," + getClass().getName() + ",R300_500_phone," + ap.ec("R300_500_phone") + ",3");
                    }
                    ap.vd().a(432, this.wgH.hUh = new e(this) {
                        final /* synthetic */ AnonymousClass12 wgI;

                        {
                            this.wgI = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            if (this.wgI.wgH.isv != null) {
                                this.wgI.wgH.isv.dismiss();
                                this.wgI.wgH.isv = null;
                            }
                            if (this.wgI.wgH.hUh != null) {
                                ap.vd().b(432, this.wgI.wgH.hUh);
                                this.wgI.wgH.hUh = null;
                            }
                            this.wgI.wgH.aXS();
                        }
                    });
                    FindMContactInviteUI findMContactInviteUI = this.wgH;
                    Context context = this.wgH.uSU.uTo;
                    this.wgH.getString(R.l.dIO);
                    findMContactInviteUI.isv = g.a(context, this.wgH.getString(R.l.ekB), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass12 wgI;

                        {
                            this.wgI = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    this.wgH.wgx.je(this.wgH.wgG);
                }
            }, new OnClickListener(findMContactInviteUI) {
                final /* synthetic */ FindMContactInviteUI wgH;

                {
                    this.wgH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.ekC);
        com.tencent.mm.plugin.c.a.imw.ox();
        this.wgG = getIntent().getStringExtra("regsetinfo_ticket");
        this.iQX = getIntent().getIntExtra("login_type", 0);
        this.vdV = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.oVk = b.Oz();
        KC();
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
            b.b(true, ap.uY() + "," + getClass().getName() + ",R300_400_QQ," + ap.ec("R300_400_QQ") + ",1");
        } else {
            b.b(true, ap.uY() + "," + getClass().getName() + ",R300_400_phone," + ap.ec("R300_400_phone") + ",1");
        }
        if (this.oIa) {
            w.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bg.bJZ());
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                bYS();
            }
        }
    }

    private void bYS() {
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.isv = g.a(context, getString(R.l.eBb), true, new OnCancelListener(this) {
            final /* synthetic */ FindMContactInviteUI wgH;

            {
                this.wgH = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        ap.vL().a(new af.a(this) {
            final /* synthetic */ FindMContactInviteUI wgH;

            {
                this.wgH = r1;
            }

            public final boolean Bo() {
                if (this.wgH.isv != null) {
                    this.wgH.isv.dismiss();
                    this.wgH.isv = null;
                }
                this.wgH.wgx.notifyDataSetChanged();
                return false;
            }

            public final boolean Bn() {
                try {
                    this.wgH.wgD = com.tencent.mm.pluginsdk.a.dn(this.wgH);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.FindMContactInviteUI", e, "", new Object[0]);
                }
                this.wgH.wgx.hBa = this.wgH.wgD;
                this.wgH.wgx.e(com.tencent.mm.modelfriend.af.Ge());
                return true;
            }

            public final String toString() {
                return super.toString() + "|listMFriendData";
            }
        });
    }

    public void onPause() {
        super.onPause();
        if (this.iQX == 1) {
            b.b(false, ap.uY() + "," + getClass().getName() + ",R300_400_QQ," + ap.ec("R300_400_QQ") + ",2");
        } else {
            b.b(false, ap.uY() + "," + getClass().getName() + ",R300_400_phone," + ap.ec("R300_400_phone") + ",2");
        }
    }

    public void onDestroy() {
        if (this.hUh != null) {
            ap.vd().b(432, this.hUh);
            this.hUh = null;
        }
        if (this.wgx != null) {
            j jVar = this.wgx;
            if (jVar.hBe != null) {
                jVar.hBe.detach();
                jVar.hBe = null;
            }
        }
        com.tencent.mm.modelfriend.af.Gf();
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
            this.wgz.setText(getString(R.l.ekD));
            this.wgA.setText(getString(R.l.ekA));
            this.wgC.setText(getString(R.l.eky, new Object[]{Integer.valueOf(0)}));
            this.wgB = (TextView) this.nsQ.findViewById(R.h.ckp);
        } else {
            this.nsQ = LayoutInflater.from(this).inflate(R.i.dcX, null);
            this.wgy = (TextView) this.nsQ.findViewById(R.h.bPN);
            this.wgz = (TextView) this.nsQ.findViewById(R.h.bPQ);
            this.wgA = (TextView) this.nsQ.findViewById(R.h.bPL);
            this.wgC = (Button) this.nsQ.findViewById(R.h.bPK);
            this.wgz.setText(getString(R.l.ekA));
            this.wgA.setText(getString(R.l.ekA));
            this.wgC.setText(getString(R.l.ekz));
        }
        this.wgx = new j(this, this.wgE, 2);
        this.wgC.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ FindMContactInviteUI wgH;

            {
                this.wgH = r1;
            }

            public final void onClick(View view) {
                b.mO(ap.uY() + "," + this.wgH.getClass().getName() + ",R300_400_AddAllButton," + ap.ec("R300_300_AddAllButton") + ",3");
                if (this.wgH.vdV == 2) {
                    this.wgH.wgx.bh(true);
                    this.wgH.wgx.notifyDataSetChanged();
                    this.wgH.wgC.setVisibility(8);
                    if (this.wgH.wgB != null) {
                        this.wgH.wgB.setVisibility(0);
                    }
                } else if (this.wgH.vdV == 1) {
                    this.wgH.wgx.bh(true);
                    this.wgH.wgx.notifyDataSetChanged();
                    FindMContactInviteUI.h(this.wgH);
                } else {
                    this.wgH.wgx.bh(true);
                    this.wgH.wgx.notifyDataSetChanged();
                    this.wgH.wgC.setVisibility(8);
                    if (this.wgH.wgB != null) {
                        this.wgH.wgB.setVisibility(0);
                    }
                }
            }
        });
        if (this.wgB != null) {
            this.wgB.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ FindMContactInviteUI wgH;

                {
                    this.wgH = r1;
                }

                public final void onClick(View view) {
                    this.wgH.wgC.setVisibility(0);
                    this.wgH.wgB.setVisibility(8);
                    this.wgH.wgx.bh(false);
                    this.wgH.wgx.notifyDataSetChanged();
                }
            });
            this.wgB.setVisibility(8);
        }
        this.iss.addHeaderView(this.nsQ);
        this.iss.setAdapter(this.wgx);
        this.iss.setOnScrollListener(new com.tencent.mm.ui.applet.a());
        this.iss.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FindMContactInviteUI wgH;

            {
                this.wgH = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.wgH.wgx != null) {
                    j b = this.wgH.wgx;
                    if (b.hBe != null) {
                        b.hBe.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        });
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ FindMContactInviteUI wgH;

            {
                this.wgH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                FindMContactInviteUI.h(this.wgH);
                return true;
            }
        });
        AnonymousClass11 anonymousClass11 = new View.OnClickListener(this) {
            final /* synthetic */ FindMContactInviteUI wgH;

            {
                this.wgH = r1;
            }

            public final void onClick(View view) {
                c.a(this.wgH.iss);
            }
        };
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.FindMContactInviteUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    bYS();
                    return;
                }
                this.oIa = false;
                g.a((Context) this, getString(R.l.eFH), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                    final /* synthetic */ FindMContactInviteUI wgH;

                    {
                        this.wgH = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.wgH.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        this.wgH.oIa = true;
                        this.wgH.finish();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ FindMContactInviteUI wgH;

                    {
                        this.wgH = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.wgH.oIa = true;
                        this.wgH.finish();
                    }
                });
                return;
            default:
                return;
        }
    }
}
