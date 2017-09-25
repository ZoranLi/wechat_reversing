package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class WalletCardSelectUI extends WalletBaseUI {
    private int rBf = 3;
    private a rKA;
    private MaxListView rKB;
    private List<ElementQuery> rKs = new LinkedList();
    private List<ElementQuery> rKt = new LinkedList();
    private CheckedTextView rKu;
    private CheckedTextView rKv;
    private String rKw;
    private int rKx;
    private int rKy = -1;
    private int rKz = -1;
    private int rxm = -1;

    public class a extends BaseAdapter {
        private Context context;
        List<ElementQuery> hoO = new ArrayList();
        final /* synthetic */ WalletCardSelectUI rKC;

        class a {
            CheckedTextView rKD;
            final /* synthetic */ a rKE;

            a(a aVar) {
                this.rKE = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return vC(i);
        }

        public a(WalletCardSelectUI walletCardSelectUI, Context context) {
            this.rKC = walletCardSelectUI;
            this.context = context;
        }

        public final boolean isEnabled(int i) {
            return bg.mA(((ElementQuery) this.hoO.get(i)).rEY);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CharSequence charSequence;
            a aVar = new a(this);
            View inflate = View.inflate(this.context, R.i.dqc, null);
            aVar.rKD = (CheckedTextView) inflate.findViewById(R.h.bCg);
            ElementQuery elementQuery = (ElementQuery) this.hoO.get(i);
            String ap = bg.ap(elementQuery.mMa, "");
            if (bg.mA(elementQuery.rEY)) {
                aVar.rKD.setEnabled(true);
                Object obj = ap;
            } else {
                charSequence = ap + "[" + elementQuery.rEY + "]";
                aVar.rKD.setEnabled(false);
            }
            aVar.rKD.setText(charSequence);
            return inflate;
        }

        public final int getCount() {
            return this.hoO.size();
        }

        public final ElementQuery vC(int i) {
            return (ElementQuery) this.hoO.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.feM);
        KC();
        this.rKt.clear();
        this.rKs.clear();
        if (m.bua().rBV != null) {
            for (ElementQuery elementQuery : m.bua().rBV) {
                if (this.rxm == 5 && !elementQuery.rFl) {
                    elementQuery.rEY = getString(R.l.fll);
                }
                if (2 == elementQuery.rES) {
                    this.rKt.add(elementQuery);
                } else if (elementQuery.btH()) {
                    this.rKs.add(elementQuery);
                }
            }
        }
        if (this.rBf == 3 && !this.rKt.isEmpty()) {
            if (m.btS().bur()) {
                Collections.sort(this.rKt, new Comparator<ElementQuery>(this) {
                    final /* synthetic */ WalletCardSelectUI rKC;

                    {
                        this.rKC = r1;
                    }

                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((ElementQuery) obj).rBY - ((ElementQuery) obj2).rBY;
                    }
                });
            } else {
                Collections.sort(this.rKt, new Comparator<ElementQuery>(this) {
                    final /* synthetic */ WalletCardSelectUI rKC;

                    {
                        this.rKC = r1;
                    }

                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((ElementQuery) obj2).rBY - ((ElementQuery) obj).rBY;
                    }
                });
            }
        }
        int size;
        int i;
        if (this.rKs.isEmpty()) {
            size = this.rKt.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.rKt.get(i)).ofd.equals(this.rKw)) {
                    this.rKz = i;
                    iE(false);
                    kr(true);
                    break;
                }
            }
            if (this.rKz < 0) {
                iE(false);
                kr(false);
            }
            this.rKu.setVisibility(8);
            this.rKv.setBackgroundResource(R.g.beo);
            this.rKv.setCheckMarkDrawable(R.g.bjb);
        } else if (bg.mA(this.rKw)) {
            this.rKu.setChecked(false);
            this.rKv.setChecked(false);
            this.rKB.setVisibility(8);
        } else if (this.rKx == 2) {
            size = this.rKt.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.rKt.get(i)).ofd.equals(this.rKw)) {
                    this.rKz = i;
                    iE(false);
                    kr(true);
                    break;
                }
            }
            if (this.rKz < 0) {
                iE(false);
                kr(false);
            }
        } else {
            size = this.rKs.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.rKs.get(i)).ofd.equals(this.rKw)) {
                    this.rKy = i;
                    iE(true);
                    kr(true);
                    break;
                }
            }
            if (this.rKy < 0) {
                iE(false);
                kr(false);
            }
        }
    }

    public final void KC() {
        this.rKw = this.uT.getString("key_bank_type");
        this.rKx = this.uT.getInt("key_bankcard_type", 1);
        this.rBf = this.uT.getInt("key_support_bankcard", 1);
        this.rxm = this.uT.getInt("key_bind_scene", -1);
        this.rKB = (MaxListView) findViewById(R.h.cDp);
        this.rKu = (CheckedTextView) findViewById(R.h.bCh);
        this.rKv = (CheckedTextView) findViewById(R.h.bCi);
        this.rKA = new a(this, this);
        this.rKB.setAdapter(this.rKA);
        this.rKB.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletCardSelectUI rKC;

            {
                this.rKC = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ElementQuery vC = this.rKC.rKA.vC(i);
                if (bg.mA(vC.rEY)) {
                    if (vC.btH()) {
                        this.rKC.rKy = i;
                    } else {
                        this.rKC.rKz = i;
                    }
                    this.rKC.kr(true);
                    return;
                }
                g.a(this.rKC, vC.rEY, null, true, null);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletCardSelectUI rKC;

            {
                this.rKC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rKC.finish();
                return true;
            }
        });
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletCardSelectUI rKC;

            {
                this.rKC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Parcelable parcelable = null;
                Intent intent = new Intent();
                if (this.rKC.rKu.isChecked() && this.rKC.rKy >= 0) {
                    parcelable = (ElementQuery) this.rKC.rKs.get(this.rKC.rKy);
                } else if (this.rKC.rKv.isChecked() && this.rKC.rKz >= 0) {
                    ElementQuery elementQuery = (ElementQuery) this.rKC.rKt.get(this.rKC.rKz);
                }
                if (parcelable != null) {
                    intent.putExtra("elemt_query", parcelable);
                    this.rKC.setResult(-1, intent);
                } else {
                    this.rKC.setResult(0);
                }
                this.rKC.finish();
                return true;
            }
        }, b.uTY);
        kr(false);
        this.rKu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardSelectUI rKC;

            {
                this.rKC = r1;
            }

            public final void onClick(View view) {
                this.rKC.iE(true);
            }
        });
        this.rKv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardSelectUI rKC;

            {
                this.rKC = r1;
            }

            public final void onClick(View view) {
                this.rKC.iE(false);
            }
        });
    }

    private void iE(boolean z) {
        this.rKB.setVisibility(0);
        if (z) {
            this.rKu.setChecked(true);
            this.rKv.setChecked(false);
            this.rKA.hoO = this.rKs;
            this.rKA.notifyDataSetChanged();
            this.rKB.clearChoices();
            if (this.rKy >= 0) {
                this.rKB.setItemChecked(this.rKy, true);
                kr(true);
                return;
            }
            kr(false);
            return;
        }
        this.rKu.setChecked(false);
        this.rKv.setChecked(true);
        this.rKA.hoO = this.rKt;
        this.rKA.notifyDataSetChanged();
        this.rKB.clearChoices();
        if (this.rKz >= 0) {
            this.rKB.setItemChecked(this.rKz, true);
            kr(true);
            return;
        }
        kr(false);
    }

    protected final int getLayoutId() {
        return R.i.dqp;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    public final boolean aJc() {
        return false;
    }

    protected final int Ol() {
        return 1;
    }
}
