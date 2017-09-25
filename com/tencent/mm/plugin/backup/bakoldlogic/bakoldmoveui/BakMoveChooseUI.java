package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmoveui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.e.1;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class BakMoveChooseUI extends MMActivity implements c {
    public static boolean jEQ = false;
    public static boolean jKW = false;
    private ListView jEU;
    private View jEV;
    private CheckBox jEX;
    private TextView jEY;
    private TextView jEZ;
    private ProgressBar jFc;
    private a jKR;
    private TextView jKS;
    private Button jKT;
    private TextView jKU;
    private View jKV;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.dLL);
        this.jEU = (ListView) findViewById(R.h.brr);
        this.jKV = r.eC(this).inflate(R.i.cVi, null);
        this.jEU.addFooterView(this.jKV);
        this.jKR = new a(this);
        this.jEU.setAdapter(this.jKR);
        this.jEU.setEmptyView(findViewById(R.h.bMc));
        this.jEV = findViewById(R.h.box);
        this.jKS = (TextView) findViewById(R.h.bCl);
        this.jEX = (CheckBox) findViewById(R.h.bow);
        this.jEY = (TextView) findViewById(R.h.bov);
        this.jEZ = (TextView) findViewById(R.h.bMb);
        this.jFc = (ProgressBar) findViewById(R.h.cbP);
        this.jKT = (Button) findViewById(R.h.bCk);
        this.jKU = (TextView) findViewById(R.h.cbO);
        ((TextView) findViewById(R.h.bCm)).setVisibility(8);
        e abT = a.abR().abT();
        if (abT.jKd != null) {
            abT.jKd.KH();
        }
        a.abR().abT();
        if (!e.aca()) {
            abT = a.abR().abT();
            com.tencent.mm.plugin.backup.g.a.abC().abF();
            com.tencent.mm.sdk.f.e.post(new 1(abT), "BakMoveChooseServer.calculateToChoose");
        }
        if (!v.bIJ()) {
            this.jKS.setTextSize(1, 14.0f);
            this.jEY.setTextSize(1, 14.0f);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakMoveChooseUI jKX;

            {
                this.jKX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!BakMoveChooseUI.jKW) {
                    this.jKX.finish();
                }
                return false;
            }
        });
        this.jKT.setEnabled(false);
        this.jKT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakMoveChooseUI jKX;

            {
                this.jKX = r1;
            }

            public final void onClick(View view) {
                ArrayList arrayList;
                PLong pLong = new PLong();
                PInt pInt = new PInt();
                a a = this.jKX.jKR;
                if (a.jEP.size() <= 0) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    pLong.value = 0;
                    pInt.value = 0;
                    ArrayList abX = e.abX();
                    if (abX != null) {
                        for (int i = 0; i < a.getCount(); i++) {
                            if (a.jEP.contains(Integer.valueOf(i))) {
                                arrayList2.add(((com.tencent.mm.plugin.backup.bakoldlogic.a.a) abX.get(i)).jBh);
                                pLong.value += ((com.tencent.mm.plugin.backup.bakoldlogic.a.a) abX.get(i)).jBk;
                                pInt.value = (int) (((long) pInt.value) + ((com.tencent.mm.plugin.backup.bakoldlogic.a.a) abX.get(i)).jBl);
                            }
                        }
                    }
                    w.i("MicroMsg.BakMoveChooseAdapter", "finishSelected usernameSize:%d, addupSize:%d, convMsgCount:%d", new Object[]{Integer.valueOf(arrayList2.size()), Long.valueOf(pLong.value), Integer.valueOf(pInt.value)});
                    arrayList = arrayList2;
                }
                Intent intent = new Intent(this.jKX, BakMoveWaitUI.class);
                intent.putStringArrayListExtra("selected_records_username", arrayList);
                intent.putExtra("selected_records_addupsize", pLong.value);
                intent.putExtra("selected_records_count", pInt.value);
                if (BakMoveChooseUI.jEQ) {
                    g.oUh.a(103, 13, 1, false);
                }
                g.oUh.a(103, 12, 1, false);
                this.jKX.startActivity(intent);
            }
        });
        this.jEV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakMoveChooseUI jKX;

            {
                this.jKX = r1;
            }

            public final void onClick(View view) {
                int i = 0;
                if (e.aca()) {
                    a a = this.jKX.jKR;
                    if (a.jEP.size() == a.getCount()) {
                        a.jEP.clear();
                        BakMoveChooseUI.jEQ = false;
                    } else {
                        while (i < a.getCount()) {
                            a.jEP.add(Integer.valueOf(i));
                            i++;
                        }
                        BakMoveChooseUI.jEQ = true;
                    }
                    a.notifyDataSetChanged();
                    a.jKP.a(a.jEP);
                }
            }
        });
        a.abR().abT().jKa = this;
        if (e.aca()) {
            if (e.abX().size() == 0) {
                this.jEZ.setVisibility(0);
            }
            this.jEU.removeFooterView(this.jKV);
            this.jKU.setVisibility(8);
            this.jKS.setVisibility(0);
            return;
        }
        this.jEX.setClickable(false);
        this.jKS.setVisibility(8);
        if (e.abX().size() == 0) {
            this.jFc.setVisibility(0);
            this.jKU.setVisibility(8);
            return;
        }
        this.jFc.setVisibility(4);
        this.jKU.setVisibility(0);
    }

    public final void a(HashSet<Integer> hashSet) {
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < e.abX().size()) {
                j = ((com.tencent.mm.plugin.backup.bakoldlogic.a.a) e.abX().get(intValue)).jBk + j;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j > 0) {
            this.jKS.setVisibility(0);
            this.jKS.setText(getString(R.l.dLV, new Object[]{bg.ay(j)}));
            this.jKT.setEnabled(true);
            if (e.aca() && hashSet.size() == this.jKR.getCount()) {
                this.jEX.setChecked(true);
                return;
            } else {
                this.jEX.setChecked(false);
                return;
            }
        }
        this.jKS.setVisibility(8);
        this.jKS.setText("");
        this.jKT.setEnabled(false);
        this.jEX.setChecked(false);
    }

    protected final int getLayoutId() {
        return R.i.cVk;
    }

    public final void a(long j, long j2, ArrayList<com.tencent.mm.plugin.backup.bakoldlogic.a.a> arrayList, boolean z) {
        this.jKU.setVisibility(0);
        this.jKU.setText("加载中...(" + j + "/" + j2 + ")");
        if (z) {
            this.jFc.setVisibility(4);
            this.jKR.notifyDataSetChanged();
        }
    }

    public final void a(ArrayList<com.tencent.mm.plugin.backup.bakoldlogic.a.a> arrayList, PLong pLong, PInt pInt) {
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                this.jFc.setVisibility(8);
                this.jEZ.setVisibility(0);
                return;
            }
            this.jKR.notifyDataSetChanged();
            this.jEX.setClickable(true);
            this.jFc.setVisibility(4);
            this.jEZ.setVisibility(0);
            this.jKU.setVisibility(8);
            this.jEU.removeFooterView(this.jKV);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (!jKW) {
            finish();
        }
        return true;
    }
}
