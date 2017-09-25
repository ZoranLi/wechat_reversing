package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.k;
import com.tencent.mm.y.e;

public class SnsTagPartlyUI extends MMActivity implements e {
    protected p irJ = null;
    private ListView kaM;
    private a qHa;
    private OnClickListener qHb = new OnClickListener(this) {
        final /* synthetic */ SnsTagPartlyUI qHc;

        {
            this.qHc = r1;
        }

        public final void onClick(View view) {
            if (this.qHc.qHa == null) {
                w.e("MicroMsg.SnsTagPartlyUI", "The adapter is null..");
                return;
            }
            Object tag = view.getTag();
            if (tag == null) {
                w.e("MicroMsg.SnsTagPartlyUI", "The tag is null..");
            } else if (tag instanceof Integer) {
                s sVar = (s) this.qHc.qHa.getItem(((Integer) tag).intValue());
                this.qHc.irJ = g.a(this.qHc, null, true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass5 qHd;

                    {
                        this.qHd = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                h.vJ();
                h.vH().gXC.a(new com.tencent.mm.plugin.sns.model.w(sVar.field_tagId, sVar.field_tagName), 0);
            } else {
                w.e("MicroMsg.SnsTagPartlyUI", "The tag is not a instance of Integer.");
            }
        }
    };

    class a extends k<s> {
        private Context context;
        final /* synthetic */ SnsTagPartlyUI qHc;
        public boolean qHe = false;

        class a {
            Button kzq;
            TextView qHf;
            TextView qHg;
            final /* synthetic */ a qHh;

            a(a aVar) {
                this.qHh = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (s) obj;
            if (obj == null) {
                obj = new s();
                w.d("MicroMsg.SnsTagPartlyUI", "new SnsInfo");
            }
            obj.b(cursor);
            return obj;
        }

        public a(SnsTagPartlyUI snsTagPartlyUI, Context context) {
            this.qHc = snsTagPartlyUI;
            super(context, new s());
            this.context = context;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                aVar = new a(this);
                view = View.inflate(this.context, i.g.pGQ, null);
                aVar.qHf = (TextView) view.findViewById(f.pGd);
                aVar.qHg = (TextView) view.findViewById(f.pFN);
                aVar.kzq = (Button) view.findViewById(f.bev);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (nJ(i)) {
                aVar.qHf.setText(j.pNd);
                aVar.qHg.setVisibility(8);
                aVar.kzq.setVisibility(8);
            } else {
                int i2;
                s sVar = (s) getItem(i);
                aVar.qHf.setText(sVar.field_tagName);
                aVar.qHg.setVisibility(0);
                aVar.qHg.setText(" (" + sVar.field_count + ") ");
                Button button = aVar.kzq;
                if (this.qHe) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                button.setVisibility(i2);
                aVar.kzq.setOnClickListener(this.qHc.qHb);
                aVar.kzq.setTag(Integer.valueOf(i));
            }
            return view;
        }

        public final void OK() {
            setCursor(ae.beQ().getCursor());
            notifyDataSetChanged();
        }

        protected final void OL() {
            aEW();
            OK();
        }

        protected final int aBV() {
            return 1;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.vJ();
        h.vH().gXC.a(292, this);
        h.vJ();
        h.vH().gXC.a(290, this);
        KC();
    }

    public void onDestroy() {
        h.vJ();
        h.vH().gXC.b(292, this);
        h.vJ();
        h.vH().gXC.b(290, this);
        if (this.qHa != null) {
            this.qHa.aEW();
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.qHa != null) {
            this.qHa.a("", null);
        }
    }

    protected final void KC() {
        zi(j.pJX);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagPartlyUI qHc;

            {
                this.qHc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qHc.finish();
                return true;
            }
        });
        this.kaM = (ListView) findViewById(f.pFQ);
        this.kaM.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SnsTagPartlyUI qHc;

            {
                this.qHc = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.qHc.qHa.getCount() - 1) {
                    Intent intent = new Intent();
                    s sVar = (s) this.qHc.qHa.getItem(i);
                    if (sVar != null) {
                        intent.putExtra("k_sns_tag_id", sVar.field_tagId);
                        intent.setClass(this.qHc, SnsTagDetailUI.class);
                        this.qHc.startActivity(intent);
                        return;
                    }
                    return;
                }
                Intent intent2 = new Intent();
                String xL = m.xL();
                intent2.putExtra("titile", this.qHc.getString(j.pJB));
                intent2.putExtra("list_type", 1);
                intent2.putExtra("list_attr", com.tencent.mm.ui.contact.s.q(new int[]{com.tencent.mm.ui.contact.s.vYO, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
                intent2.putExtra("block_contact", xL);
                d.a(this.qHc, ".ui.contact.SelectContactUI", intent2, 1);
            }
        });
        this.qHa = new a(this, this);
        this.kaM.addFooterView(View.inflate(this, i.g.pIj, null));
        this.kaM.setAdapter(this.qHa);
        a(0, getString(j.pMx), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagPartlyUI qHc;

            {
                this.qHc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean z;
                a a = this.qHc.qHa;
                if (this.qHc.qHa.qHe) {
                    z = false;
                } else {
                    z = true;
                }
                a.qHe = z;
                this.qHc.aB(0, this.qHc.qHa.qHe ? this.qHc.getString(j.dHp) : this.qHc.getString(j.pMx));
                this.qHc.qHa.notifyDataSetChanged();
                return true;
            }
        });
        this.qHa.uSN = new com.tencent.mm.ui.k.a(this) {
            final /* synthetic */ SnsTagPartlyUI qHc;

            {
                this.qHc = r1;
            }

            public final void OI() {
            }

            public final void OH() {
                boolean z = true;
                SnsTagPartlyUI snsTagPartlyUI = this.qHc;
                if (this.qHc.qHa.getCount() <= 1) {
                    z = false;
                }
                snsTagPartlyUI.kr(z);
            }
        };
    }

    protected final int getLayoutId() {
        return i.g.pIk;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        String stringExtra2 = intent.getStringExtra("Select_room_name");
                        if (stringExtra != null) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("k_sns_tag_id", 0);
                            intent2.putExtra("k_sns_tag_name", bg.ap(stringExtra2, ""));
                            intent2.putExtra("k_sns_tag_list", stringExtra);
                            intent2.setClass(this, SnsTagDetailUI.class);
                            startActivity(intent2);
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

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.SnsTagPartlyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.irJ != null) {
            this.irJ.dismiss();
            this.irJ = null;
        }
        if (this.qHa != null) {
            this.qHa.a("", null);
        }
    }
}
