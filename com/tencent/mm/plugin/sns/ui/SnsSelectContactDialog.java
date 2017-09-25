package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.v;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog extends MMBaseActivity {
    private List<String> hoO = new LinkedList();
    private GridView qEN = null;
    private a qEO = null;

    class a extends BaseAdapter {
        private Context context;
        private List<String> hoO;
        final /* synthetic */ SnsSelectContactDialog qEP;
        private int qoX = 0;
        private int type;

        public a(SnsSelectContactDialog snsSelectContactDialog, Context context, int i) {
            this.qEP = snsSelectContactDialog;
            this.hoO = i;
            this.context = context;
            this.type = 0;
            refresh();
        }

        public final void refresh() {
            if (this.hoO == null) {
                this.qoX = 0;
            } else {
                this.qoX = this.hoO.size();
            }
            this.qoX++;
            notifyDataSetChanged();
        }

        public final int getCount() {
            return this.qoX;
        }

        public final Object getItem(int i) {
            return this.hoO.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                View inflate;
                b bVar2 = new b();
                if (this.type == 0) {
                    inflate = View.inflate(this.context, g.pIt, null);
                } else {
                    inflate = View.inflate(this.context, g.pHl, null);
                }
                bVar2.kQu = (ImageView) inflate.findViewById(f.Kd);
                bVar2.qEQ = (ImageView) inflate.findViewById(f.pCU);
                inflate.setTag(bVar2);
                view = inflate;
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            view.setVisibility(0);
            if (i == this.qoX - 1) {
                bVar.kQu.setBackgroundDrawable(null);
                bVar.kQu.setImageResource(e.pAj);
                bVar.qEQ.setVisibility(8);
                if (this.hoO.size() >= v.uzf) {
                    view.setVisibility(8);
                }
            } else {
                bVar.kQu.setBackgroundDrawable(null);
                bVar.qEQ.setVisibility(0);
                if (this.type == 0) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(bVar.kQu, (String) this.hoO.get(i));
                } else {
                    bVar.kQu.setImageBitmap(d.d((String) this.hoO.get(i), ae.beS(), ae.beS(), true));
                }
            }
            bVar.kQu.setScaleType(ScaleType.CENTER_CROP);
            return view;
        }
    }

    static class b {
        ImageView kQu;
        ImageView qEQ;

        b() {
        }
    }

    static /* synthetic */ void b(SnsSelectContactDialog snsSelectContactDialog) {
        Intent intent = new Intent();
        String str = bg.c(snsSelectContactDialog.hoO, ",") + ", " + m.xL();
        intent.putExtra("Contact_Compose", true);
        intent.putExtra("Add_get_from_sns", snsSelectContactDialog.bkH());
        intent.putExtra("List_Type", 1);
        intent.putExtra("Add_address_titile", snsSelectContactDialog.getString(j.dCT));
        intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
        intent.putExtra("Block_list", str);
        intent.putExtra("sns_address_count", snsSelectContactDialog.hoO.size());
        com.tencent.mm.plugin.sns.c.a.imv.a(intent, snsSelectContactDialog, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.pHq);
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (stringExtra == null || stringExtra.equals("")) {
            this.hoO.clear();
        } else {
            this.hoO = bg.f(stringExtra.split(","));
        }
        this.qEN = (GridView) findViewById(f.pCd);
        this.qEO = new a(this, this, this.hoO);
        this.qEN.setAdapter(this.qEO);
        this.qEN.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SnsSelectContactDialog qEP;

            {
                this.qEP = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == this.qEP.qEO.getCount() - 1) {
                    SnsSelectContactDialog.b(this.qEP);
                } else {
                    this.qEP.hoO.remove(i);
                }
                this.qEP.qEO.refresh();
            }
        });
        this.qEN.setSelection(this.qEO.getCount() - 1);
        ((ImageButton) findViewById(f.bCA)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsSelectContactDialog qEP;

            {
                this.qEP = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", bg.c(this.qEP.hoO, ","));
                this.qEP.setResult(-1, intent);
                this.qEP.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", bg.c(this.hoO, ","));
            setResult(-1, intent);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean GV(String str) {
        for (Object equals : o.hly) {
            if (str.equals(equals)) {
                return false;
            }
        }
        if (o.dH(str) || o.eV(str)) {
            return false;
        }
        if (this.hoO == null || !this.hoO.contains(str)) {
            return true;
        }
        return false;
    }

    private String bkH() {
        as wW = ((h) com.tencent.mm.kernel.h.h(h.class)).wW();
        String str = o.hlr;
        List linkedList = new LinkedList();
        for (Object add : o.hly) {
            linkedList.add(add);
        }
        linkedList.add("weixin");
        linkedList.add("officialaccounts");
        linkedList.add("helper_entry");
        linkedList.add("filehelper");
        Cursor c = wW.c(str, linkedList, "*");
        if (c.getCount() == 0) {
            c.close();
            return "";
        }
        List linkedList2 = new LinkedList();
        c.moveToFirst();
        do {
            aj aeVar = new com.tencent.mm.storage.ae();
            aeVar.b(c);
            if (GV(aeVar.field_username)) {
                linkedList2.add(aeVar.field_username);
                if (linkedList2.size() >= 10) {
                    break;
                }
            }
        } while (c.moveToNext());
        c.close();
        return bg.c(linkedList2, ";");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        List<String> f = bg.f(intent.getStringExtra("Select_Contact").split(","));
                        if (f != null) {
                            if (this.hoO == null) {
                                this.hoO = new LinkedList();
                            }
                            for (String str : f) {
                                if (!this.hoO.contains(str)) {
                                    this.hoO.add(str);
                                }
                            }
                            w.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.hoO.size());
                            if (this.qEO != null) {
                                w.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
                                this.qEO.refresh();
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("Select_Contact", bg.c(this.hoO, ","));
                            setResult(-1, intent2);
                            finish();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
