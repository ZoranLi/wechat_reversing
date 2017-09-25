package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI extends WalletBaseUI implements OnClickListener {
    private List<l> sAa;
    private List<l> sAb = new ArrayList();
    private l sAc;
    private l sAd;
    private int sAe = -1;
    private boolean sAf;
    private boolean sAg;
    private TextView sAh;
    private TextView sAi;
    private TextView sAj;
    private TextView sAk;
    private TextView sAl;
    private TextView sAm;
    private EditText sAn;
    private EditText sAo;
    private EditText sAp;
    private EditText sAq;
    private BaseAdapter sAr = new BaseAdapter(this) {
        final /* synthetic */ WalletWXCreditChangeAmountUI sAt;

        {
            this.sAt = r1;
        }

        public final /* synthetic */ Object getItem(int i) {
            return wT(i);
        }

        public final int getCount() {
            return this.sAt.sAb != null ? this.sAt.sAb.size() : 0;
        }

        private l wT(int i) {
            return (l) this.sAt.sAb.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.sAt, R.i.dqI, null);
            l wT = wT(i);
            checkedTextView.setText(wT.desc);
            checkedTextView.setChecked(wT.szQ != 0);
            return checkedTextView;
        }
    };
    private BaseAdapter sAs = new BaseAdapter(this) {
        final /* synthetic */ WalletWXCreditChangeAmountUI sAt;

        {
            this.sAt = r1;
        }

        public final /* synthetic */ Object getItem(int i) {
            return (l) this.sAt.sAb.get(i);
        }

        public final int getCount() {
            return 2;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.sAt, R.i.dqI, null);
            if (i == 0) {
                checkedTextView.setText(R.l.dJe);
            } else {
                checkedTextView.setText(R.l.dHQ);
            }
            if (this.sAt.sAg) {
                if (this.sAt.sAc.szT == null || !"Y".equals(this.sAt.sAc.nmZ)) {
                    if (i == 0) {
                        z = false;
                    }
                    checkedTextView.setChecked(z);
                } else {
                    if (i != 0) {
                        z = false;
                    }
                    checkedTextView.setChecked(z);
                }
            } else if (this.sAt.sAd.szT == null || !"Y".equals(this.sAt.sAd.nmZ)) {
                if (i == 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            } else {
                if (i != 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            }
            return checkedTextView;
        }
    };

    static /* synthetic */ void a(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        walletWXCreditChangeAmountUI.sAb.clear();
        if (walletWXCreditChangeAmountUI.sAf) {
            for (l lVar : walletWXCreditChangeAmountUI.sAa) {
                if (lVar.szQ != 2) {
                    walletWXCreditChangeAmountUI.sAb.add(lVar);
                }
            }
            return;
        }
        for (l lVar2 : walletWXCreditChangeAmountUI.sAa) {
            if (lVar2.szQ != 1) {
                walletWXCreditChangeAmountUI.sAb.add(lVar2);
            }
        }
    }

    static /* synthetic */ boolean b(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        if (walletWXCreditChangeAmountUI.sAc == null || walletWXCreditChangeAmountUI.sAd == null) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.sAn.getVisibility() == 0 && bg.mA(walletWXCreditChangeAmountUI.sAn.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.sAo.getVisibility() == 0 && bg.mA(walletWXCreditChangeAmountUI.sAo.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.sAl.getVisibility() == 0 && bg.mA(walletWXCreditChangeAmountUI.sAl.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.sAp.getVisibility() == 0 && bg.mA(walletWXCreditChangeAmountUI.sAp.getText().toString())) {
            return false;
        }
        if (walletWXCreditChangeAmountUI.sAq.getVisibility() == 0 && bg.mA(walletWXCreditChangeAmountUI.sAq.getText().toString())) {
            return false;
        }
        return (walletWXCreditChangeAmountUI.sAm.getVisibility() == 0 && bg.mA(walletWXCreditChangeAmountUI.sAm.getText().toString())) ? false : true;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        View inflate;
        ListView listView;
        a aVar;
        switch (i) {
            case 1:
                inflate = getLayoutInflater().inflate(R.i.dqH, null);
                listView = (ListView) inflate.findViewById(R.h.bnw);
                listView.setAdapter(this.sAr);
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ WalletWXCreditChangeAmountUI sAt;

                    {
                        this.sAt = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.sAt.dismissDialog(1);
                        if (this.sAt.sAf) {
                            this.sAt.sAc.szQ = 0;
                            this.sAt.sAc = (l) this.sAt.sAb.get(i);
                            this.sAt.sAc.szQ = 1;
                        } else {
                            this.sAt.sAd.szQ = 0;
                            this.sAt.sAd = (l) this.sAt.sAb.get(i);
                            this.sAt.sAd.szQ = 2;
                        }
                        this.sAt.ar();
                    }
                });
                aVar = new a(this);
                aVar.zW(R.l.flF);
                aVar.dd(inflate);
                aVar.d(null);
                return aVar.WJ();
            case 2:
                inflate = getLayoutInflater().inflate(R.i.dqH, null);
                listView = (ListView) inflate.findViewById(R.h.bnw);
                listView.setAdapter(this.sAs);
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ WalletWXCreditChangeAmountUI sAt;

                    {
                        this.sAt = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.sAt.dismissDialog(2);
                        if (this.sAt.sAg) {
                            if (i == 0) {
                                this.sAt.sAc.nmZ = "Y";
                            } else {
                                this.sAt.sAc.nmZ = "N";
                            }
                        } else if (i == 0) {
                            this.sAt.sAd.nmZ = "Y";
                        } else {
                            this.sAt.sAd.nmZ = "N";
                        }
                        this.sAt.ar();
                    }
                });
                aVar = new a(this);
                aVar.zW(R.l.flB);
                aVar.dd(inflate);
                aVar.d(null);
                return aVar.WJ();
            case 3:
                String string = getString(R.l.flE);
                if (this.sAe > 0) {
                    string = getString(R.l.flC, new Object[]{Integer.valueOf(this.sAe)});
                }
                return g.a(this, string, null, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletWXCreditChangeAmountUI sAt;

                    {
                        this.sAt = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b ai = com.tencent.mm.wallet_core.a.ai(this.sAt);
                        if (ai != null) {
                            ai.d(this.sAt, this.sAt.uT);
                        } else {
                            this.sAt.finish();
                        }
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletWXCreditChangeAmountUI sAt;

                    {
                        this.sAt = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.sAt.aHj();
                    }
                });
            default:
                return g.b(this, "", "", true);
        }
    }

    public final int getLayoutId() {
        return R.i.drB;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        ar();
    }

    protected final void KC() {
        zi(R.l.flG);
        this.sAh = (TextView) findViewById(R.h.cSa);
        this.sAj = (TextView) findViewById(R.h.cSb);
        this.sAi = (TextView) findViewById(R.h.cSc);
        this.sAk = (TextView) findViewById(R.h.cSd);
        this.sAn = (EditText) findViewById(R.h.cRQ);
        this.sAo = (EditText) findViewById(R.h.cRR);
        this.sAp = (EditText) findViewById(R.h.cRS);
        this.sAq = (EditText) findViewById(R.h.cRT);
        this.sAl = (TextView) findViewById(R.h.cRU);
        this.sAm = (TextView) findViewById(R.h.cRV);
        this.sAl.setOnClickListener(this);
        this.sAm.setOnClickListener(this);
        this.sAh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditChangeAmountUI sAt;

            {
                this.sAt = r1;
            }

            public final void onClick(View view) {
                this.sAt.sAf = true;
                WalletWXCreditChangeAmountUI.a(this.sAt);
                this.sAt.showDialog(1);
            }
        });
        this.sAi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditChangeAmountUI sAt;

            {
                this.sAt = r1;
            }

            public final void onClick(View view) {
                this.sAt.sAf = false;
                WalletWXCreditChangeAmountUI.a(this.sAt);
                this.sAt.showDialog(1);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletWXCreditChangeAmountUI sAt;

            {
                this.sAt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sAt.aHf();
                this.sAt.showDialog(3);
                return true;
            }
        });
        findViewById(R.h.cnY).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditChangeAmountUI sAt;

            {
                this.sAt = r1;
            }

            public final void onClick(View view) {
                if (WalletWXCreditChangeAmountUI.b(this.sAt)) {
                    if (this.sAt.sAc.szT == null) {
                        this.sAt.sAc.nmZ = this.sAt.sAn.getText().toString();
                    } else if (this.sAt.sAo.getVisibility() == 0) {
                        this.sAt.sAc.szT.nmZ = this.sAt.sAo.getText().toString();
                    }
                    if (this.sAt.sAd.szT == null) {
                        this.sAt.sAd.nmZ = this.sAt.sAp.getText().toString();
                    } else if (this.sAt.sAq.getVisibility() == 0) {
                        this.sAt.sAd.szT.nmZ = this.sAt.sAq.getText().toString();
                    }
                    List arrayList = new ArrayList();
                    arrayList.add(this.sAt.sAc);
                    arrayList.add(this.sAt.sAd);
                    String string = this.sAt.uT.getString("kreq_token");
                    this.sAt.uT.getString("key_bank_type");
                    this.sAt.q(new c(arrayList, string));
                    return;
                }
                s.makeText(this.sAt.uSU.uTo, R.l.flD, 0).show();
            }
        });
    }

    private void ar() {
        if (this.sAc != null) {
            this.sAh.setText(this.sAc.desc);
            if (this.sAc.szT != null) {
                this.sAl.setVisibility(0);
                this.sAn.setVisibility(8);
                this.sAj.setText(this.sAc.szT.desc);
                this.sAo.setHint(this.sAc.szT.khk);
                if ("Y".equals(this.sAc.nmZ)) {
                    this.sAj.setVisibility(0);
                    this.sAo.setVisibility(0);
                    this.sAl.setText(R.l.dJe);
                } else {
                    this.sAj.setVisibility(8);
                    this.sAo.setVisibility(8);
                    if ("N".equals(this.sAc.nmZ)) {
                        this.sAl.setText(R.l.dHQ);
                    }
                }
            } else {
                this.sAl.setVisibility(8);
                this.sAn.setVisibility(0);
                this.sAn.setHint(this.sAc.khk);
                this.sAj.setVisibility(8);
                this.sAo.setVisibility(8);
            }
        }
        if (this.sAd != null) {
            this.sAi.setText(this.sAd.desc);
            if (this.sAd.szT != null) {
                this.sAm.setVisibility(0);
                this.sAp.setVisibility(8);
                this.sAk.setText(this.sAd.szT.desc);
                this.sAq.setHint(this.sAd.szT.khk);
                if ("Y".equals(this.sAd.nmZ)) {
                    this.sAk.setVisibility(0);
                    this.sAq.setVisibility(0);
                    this.sAm.setText(R.l.dJe);
                    return;
                }
                this.sAk.setVisibility(8);
                this.sAq.setVisibility(8);
                if ("N".equals(this.sAd.nmZ)) {
                    this.sAm.setText(R.l.dHQ);
                    return;
                }
                return;
            }
            this.sAm.setVisibility(8);
            this.sAp.setVisibility(0);
            this.sAp.setHint(this.sAd.khk);
            this.sAk.setVisibility(8);
            this.sAq.setVisibility(8);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof e) {
                this.sAa = ((e) kVar).szx;
                this.sAe = ((e) kVar).szy;
                if (this.sAa != null && this.sAa.size() >= 2) {
                    this.sAc = (l) this.sAa.get(0);
                    this.sAd = (l) this.sAa.get(1);
                    this.sAc.szQ = 1;
                    this.sAd.szQ = 2;
                }
                ar();
                return true;
            }
        } else if (kVar instanceof c) {
            g.a(this, str, null, false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletWXCreditChangeAmountUI sAt;

                {
                    this.sAt = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    b ai = com.tencent.mm.wallet_core.a.ai(this.sAt);
                    if (ai != null) {
                        ai.d(this.sAt, this.sAt.uT);
                    } else {
                        this.sAt.finish();
                    }
                }
            });
            return true;
        }
        return false;
    }

    public void onClick(View view) {
        if (view.getId() == R.h.cRU) {
            this.sAg = true;
            showDialog(2);
        } else if (view.getId() == R.h.cRV) {
            this.sAg = false;
            showDialog(2);
        }
    }
}
