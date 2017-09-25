package com.tencent.mm.plugin.ipcall.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.tools.p;

public class IPCallContactUI extends MMActivity {
    private ae hgN = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ IPCallContactUI mTl;

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                if (this.mTl.mSZ != null) {
                    this.mTl.mSZ.dismiss();
                }
                this.mTl.mTb.setVisibility(0);
                c.mQV = b.aEN();
                this.mTl.mTa.OK();
                this.mTl.mTa.notifyDataSetChanged();
                this.mTl.mSK.invalidateViews();
                this.mTl.mTd.oo(this.mTl.mTa.getCount());
                a.aDw().Ni();
            } else if (message.what == 2) {
                if (this.mTl.mTa.getCount() == 0) {
                    this.mTl.mTf.setVisibility(0);
                } else {
                    this.mTl.mTf.setVisibility(8);
                }
                if (this.mTl.mTa.getCount() != 0 && this.mTl.mTk) {
                    this.mTl.mTa.notifyDataSetChanged();
                }
            }
        }
    };
    private String isw;
    private p kww = new p(true, true);
    private ListView mSK;
    private Runnable mSR = new Runnable(this) {
        final /* synthetic */ IPCallContactUI mTl;

        {
            this.mTl = r1;
        }

        public final void run() {
            com.tencent.mm.plugin.ipcall.a.a.aDR().a(this.mTl.mTi, false);
        }
    };
    private ProgressDialog mSZ = null;
    private c mTa;
    private RelativeLayout mTb;
    private LinearLayout mTc;
    private IPCallAddressCountView mTd = null;
    private VerticalScrollBar mTe;
    private LinearLayout mTf;
    private int mTg = -1;
    private int mTh = -1;
    private com.tencent.mm.plugin.ipcall.a.a.a mTi = new com.tencent.mm.plugin.ipcall.a.a.a(this) {
        final /* synthetic */ IPCallContactUI mTl;

        {
            this.mTl = r1;
        }

        public final void azD() {
            this.mTl.hgN.sendEmptyMessage(1);
        }
    };
    private Runnable mTj = new Runnable(this) {
        final /* synthetic */ IPCallContactUI mTl;

        {
            this.mTl = r1;
        }

        public final void run() {
            if (this.mTl.mTa != null && this.mTl.mSK != null && !this.mTl.mTa.kau) {
                this.mTl.mTa.yD(this.mTl.isw);
                this.mTl.hgN.sendEmptyMessage(2);
                this.mTl.mSK.invalidateViews();
            }
        }
    };
    private boolean mTk = true;

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.etx);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallContactUI mTl;

            {
                this.mTl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mTl.finish();
                return true;
            }
        });
        w.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bg.bJZ()});
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            this.mTb = (RelativeLayout) findViewById(R.h.layout);
            this.mTc = (LinearLayout) findViewById(R.h.bnJ);
            this.mSK = (ListView) findViewById(R.h.bnv);
            this.mTe = (VerticalScrollBar) findViewById(R.h.bnG);
            this.mTf = (LinearLayout) findViewById(R.h.bnI);
            this.kww.woe = new p.b(this) {
                final /* synthetic */ IPCallContactUI mTl;

                {
                    this.mTl = r1;
                }

                public final void OE() {
                    w.d("MicroMsg.IPCallContactUI", "onEnterSearch");
                    g.oUh.i(12767, new Object[]{Integer.valueOf(1)});
                    this.mTl.mTc.setVisibility(0);
                    this.mTl.mSK.setVisibility(8);
                    this.mTl.mTd.setVisibility(8);
                    this.mTl.fd(false);
                }

                public final void OD() {
                    w.d("MicroMsg.IPCallContactUI", "onQuitSearch");
                    this.mTl.yD("");
                    this.mTl.fd(true);
                    this.mTl.mTc.setVisibility(8);
                    this.mTl.mSK.setVisibility(0);
                    this.mTl.mTd.setVisibility(0);
                }

                public final void mR(String str) {
                    w.d("MicroMsg.IPCallContactUI", "onSearchChange");
                    this.mTl.yD(str);
                    if (!bg.mA(str)) {
                        this.mTl.mTc.setVisibility(8);
                        this.mTl.mSK.setVisibility(0);
                        this.mTl.mTd.setVisibility(8);
                    }
                }

                public final boolean mQ(String str) {
                    w.d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
                    return false;
                }

                public final void OF() {
                    this.mTl.mTc.setVisibility(0);
                    this.mTl.mSK.setVisibility(8);
                    this.mTl.mTd.setVisibility(8);
                }

                public final void OG() {
                }
            };
            this.kww.woj = R.l.dIz;
            a(this.kww);
            this.mTa = new c(this.uSU.uTo);
            c.mQV = b.aEN();
            this.mTd = new IPCallAddressCountView(this.uSU.uTo, this.mTa.aEV());
            this.mSK.addFooterView(this.mTd, null, false);
            this.mSK.setAdapter(this.mTa);
            this.mSK.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ IPCallContactUI mTl;

                {
                    this.mTl = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (!this.mTl.mTa.nJ(i)) {
                        c on = this.mTl.mTa.on(i);
                        if (on != null) {
                            if (!this.mTl.mTk) {
                                g.oUh.i(12767, new Object[]{Integer.valueOf(2)});
                            }
                            Intent intent = new Intent(this.mTl.uSU.uTo, IPCallUserProfileUI.class);
                            intent.putExtra("IPCallProfileUI_contactid", on.field_contactId);
                            intent.putExtra("IPCallProfileUI_systemUsername", on.field_systemAddressBookUsername);
                            intent.putExtra("IPCallProfileUI_wechatUsername", on.field_wechatUsername);
                            this.mTl.uSU.uTo.startActivity(intent);
                        }
                    }
                }
            });
            this.mTe.setVisibility(0);
            this.mSK.setOnScrollListener(new OnScrollListener(this) {
                final /* synthetic */ IPCallContactUI mTl;
                private int mTm = 0;

                {
                    this.mTl = r2;
                }

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    this.mTm = i;
                    this.mTl.aHf();
                }

                @TargetApi(11)
                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (this.mTl.mTg == -1) {
                        this.mTl.mTg = i;
                    } else if (this.mTl.mTh == -1) {
                        this.mTl.mTh = i;
                    }
                }
            });
            this.mTe.vpW = new VerticalScrollBar.a(this) {
                final /* synthetic */ IPCallContactUI mTl;

                {
                    this.mTl = r1;
                }

                public final void sd(String str) {
                    if ("↑".equals(str)) {
                        this.mTl.mSK.setSelection(0);
                        return;
                    }
                    int intValue;
                    c d = this.mTl.mTa;
                    if (d.kxs.containsKey(str)) {
                        intValue = ((Integer) d.kxs.get(str)).intValue();
                    } else {
                        intValue = -1;
                    }
                    if (intValue != -1) {
                        this.mTl.mSK.setSelection(intValue);
                    }
                }
            };
            if (this.mTa.aEV() <= 0) {
                this.mTb.setVisibility(8);
                Context context = this.uSU.uTo;
                this.uSU.uTo.getString(R.l.dIO);
                this.mSZ = com.tencent.mm.ui.base.g.a(context, this.uSU.uTo.getString(R.l.etL), true, new OnCancelListener(this) {
                    final /* synthetic */ IPCallContactUI mTl;

                    {
                        this.mTl = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.mTl.finish();
                    }
                });
                e.post(this.mSR, "IPCall_LoadSystemAddressBook");
                return;
            }
            a.aDw().Ni();
        }
    }

    public final void yD(String str) {
        this.isw = str;
        this.hgN.removeCallbacks(this.mTj);
        this.hgN.postDelayed(this.mTj, 200);
    }

    public final void fd(boolean z) {
        this.mTk = z;
        if (this.mTk) {
            this.mTa.notifyDataSetChanged();
        }
    }

    protected final int getLayoutId() {
        return R.i.dfZ;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.ipcall.a.a aDR = com.tencent.mm.plugin.ipcall.a.a.aDR();
        com.tencent.mm.plugin.ipcall.a.a.a aVar = this.mTi;
        if (aDR.mMz.contains(aVar)) {
            aDR.mMz.remove(aVar);
        }
        this.hgN.removeMessages(1);
    }

    protected void onResume() {
        super.onResume();
        aQ();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        w.d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.IPCallContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.eFH), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ IPCallContactUI mTl;

                        {
                            this.mTl = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.mTl.finish();
                            this.mTl.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ IPCallContactUI mTl;

                        {
                            this.mTl = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.mTl.finish();
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
