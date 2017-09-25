package com.tencent.mm.plugin.clean.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.b.d;
import com.tencent.mm.plugin.clean.b.e;
import com.tencent.mm.plugin.clean.b.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class CleanChattingUI extends MMActivity implements g {
    private ProgressDialog isv;
    private View jEV;
    private CheckBox jEX;
    private TextView jEY;
    private Button kzq;
    private e kzr;
    private a kzu;
    private ListView kzv;
    private TextView kzw;

    static /* synthetic */ void a(CleanChattingUI cleanChattingUI) {
        if (d.ajK() != null) {
            Object arrayList = new ArrayList();
            arrayList.addAll(cleanChattingUI.kzu.jEP);
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                if (intValue < d.abX().size()) {
                    arrayList2.addAll(((b) d.abX().get(intValue)).kyt);
                    d.abX().remove(intValue);
                }
            }
            cleanChattingUI.kzu.ajS();
            cleanChattingUI.kzu.notifyDataSetChanged();
            if (cleanChattingUI.kzr != null) {
                cleanChattingUI.kzr.ajR();
            }
            cleanChattingUI.kzr = new e(d.ajK(), cleanChattingUI, arrayList2);
            cleanChattingUI.kzr.start();
            cleanChattingUI.isv.show();
            cleanChattingUI.isv.setMessage(cleanChattingUI.getString(R.l.dWi, new Object[]{"0%"}));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.ajP();
        w.i("MicroMsg.CleanChattingUI", "Create!!");
        zi(R.l.dWk);
        this.kzv = (ListView) findViewById(R.h.bCq);
        this.kzu = new a(this);
        this.kzv.setAdapter(this.kzu);
        this.kzv.setEmptyView(findViewById(R.h.bMc));
        this.jEV = findViewById(R.h.box);
        this.kzw = (TextView) findViewById(R.h.bHX);
        this.jEX = (CheckBox) findViewById(R.h.bow);
        this.jEY = (TextView) findViewById(R.h.bov);
        if (!v.bIJ()) {
            this.kzw.setTextSize(1, 14.0f);
            this.jEY.setTextSize(1, 14.0f);
        }
        this.kzq = (Button) findViewById(R.h.bev);
        this.kzq.setEnabled(false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CleanChattingUI kzx;

            {
                this.kzx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kzx.finish();
                return false;
            }
        });
        this.kzv.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CleanChattingUI kzx;

            {
                this.kzx = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent(this.kzx, CleanChattingDetailUI.class);
                intent.putExtra("key_position", i);
                this.kzx.startActivityForResult(intent, 0);
            }
        });
        this.kzq.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CleanChattingUI kzx;

            {
                this.kzx = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.ui.base.g.a(this.kzx, this.kzx.getString(R.l.dXe), "", this.kzx.getString(R.l.bHU), this.kzx.getString(R.l.cancel), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 kzy;

                    {
                        this.kzy = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        CleanChattingUI.a(this.kzy.kzx);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 kzy;

                    {
                        this.kzy = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
        this.jEV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CleanChattingUI kzx;

            {
                this.kzx = r1;
            }

            public final void onClick(View view) {
                a b = this.kzx.kzu;
                if (b.jEP.size() == b.getCount()) {
                    b.jEP.clear();
                } else {
                    for (int i = 0; i < b.getCount(); i++) {
                        b.jEP.add(Integer.valueOf(i));
                    }
                }
                b.notifyDataSetChanged();
                b.kyV.a(b.jEP);
            }
        });
        getString(R.l.dIO);
        this.isv = com.tencent.mm.ui.base.g.a(this, getString(R.l.dWc), false, new OnCancelListener(this) {
            final /* synthetic */ CleanChattingUI kzx;

            {
                this.kzx = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.isv.dismiss();
    }

    public final void a(HashSet<Integer> hashSet) {
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < d.abX().size()) {
                i = (int) (((b) d.abX().get(intValue)).fLh + ((long) i));
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || i > 0) {
            this.kzw.setText(getString(R.l.ebu, new Object[]{bg.ay((long) i)}));
            this.kzq.setEnabled(true);
            if (hashSet.size() == this.kzu.getCount()) {
                this.jEX.setChecked(true);
                return;
            } else {
                this.jEX.setChecked(false);
                return;
            }
        }
        this.kzw.setText("");
        this.kzq.setEnabled(false);
        this.jEX.setChecked(false);
    }

    protected void onDestroy() {
        if (this.isv.isShowing()) {
            this.isv.dismiss();
        }
        if (this.kzr != null) {
            this.kzr.ajR();
        }
        d.ajQ();
        d.ajO();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.cYU;
    }

    public final void bM(int i, int i2) {
        this.isv.setMessage(getString(R.l.dWi, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void aR(long j) {
        this.isv.dismiss();
        d.aQ(d.ajM() + j);
        d.aP(d.ajL() - j);
        com.tencent.mm.ui.base.g.a(this, getString(R.l.dWd, new Object[]{bg.ay(j)}), "", new DialogInterface.OnClickListener(this) {
            final /* synthetic */ CleanChattingUI kzx;

            {
                this.kzx = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (d.abX() != null && d.abX().size() == 0) {
                    this.kzx.finish();
                }
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.kzu.notifyDataSetChanged();
        super.onActivityResult(i, i2, intent);
    }
}
