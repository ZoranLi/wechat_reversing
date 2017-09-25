package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.c;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ShakeTvHistoryListUI extends MMActivity {
    private d jWo = new d(this) {
        final /* synthetic */ ShakeTvHistoryListUI psX;

        {
            this.psX = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 0:
                    int i2;
                    g.oUh.i(12662, new Object[]{Integer.valueOf(1), bg.mz(this.psX.username)});
                    o baU = m.baU();
                    String d = this.psX.username;
                    if (bg.mA(d)) {
                        i2 = -1;
                    } else {
                        i2 = baU.gUz.delete(baU.getTableName(), "username = '" + d + "'", null);
                        w.d("MicroMsg.ShakeTvHistoryStorage", "delMsgByUserName = " + i2);
                    }
                    if (i2 < 0) {
                        w.i("MicroMsg.ShakeTvHistoryListUI", "delete tv history fail, ret[%d]", new Object[]{Integer.valueOf(i2)});
                    } else {
                        ap.vd().a(new c(1, this.psX.username), 0);
                    }
                    this.psX.psV.a(null, null);
                    return;
                default:
                    return;
            }
        }
    };
    private a psV;
    private ListView psW;
    private String username;

    class a extends k<n> {
        private LayoutInflater Du;
        final /* synthetic */ ShakeTvHistoryListUI psX;

        class a {
            TextView jhl;
            TextView nsH;
            MMImageView psZ;
            final /* synthetic */ a pta;

            a(a aVar) {
                this.pta = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (n) obj;
            if (obj == null) {
                obj = new n();
            }
            obj.b(cursor);
            return obj;
        }

        public a(ShakeTvHistoryListUI shakeTvHistoryListUI, Context context) {
            this.psX = shakeTvHistoryListUI;
            super(context, new n());
            this.Du = LayoutInflater.from(context);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            if (view == null) {
                view = this.Du.inflate(R.i.dor, viewGroup, false);
                aVar = new a(this);
                aVar.psZ = (MMImageView) view.findViewById(R.h.cEz);
                aVar.jhl = (TextView) view.findViewById(R.h.cEB);
                aVar.nsH = (TextView) view.findViewById(R.h.cEA);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            n nVar = (n) getItem(i);
            e.a(aVar.psZ, nVar.field_iconurl, 0, true);
            aVar.jhl.setText(nVar.field_title);
            TextView textView = aVar.nsH;
            Context context = this.psX.uSU.uTo;
            long j = nVar.field_createtime * 1000;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                charSequence = "";
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis <= 0 || timeInMillis > 86400000) {
                    timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    charSequence = (timeInMillis <= 0 || timeInMillis > 86400000) ? com.tencent.mm.pluginsdk.j.o.Z(context.getString(R.l.elz), j / 1000) : context.getString(R.l.elH);
                } else {
                    charSequence = com.tencent.mm.pluginsdk.j.o.Z(context.getString(R.l.elE), j / 1000);
                }
            }
            textView.setText(charSequence);
            return view;
        }

        public final void OK() {
            setCursor(m.baU().bbw());
            super.notifyDataSetChanged();
        }

        protected final void OL() {
            OK();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onDestroy() {
        this.psV.aEW();
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eVZ);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeTvHistoryListUI psX;

            {
                this.psX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.psX.aHf();
                this.psX.finish();
                return true;
            }
        });
        a(0, getString(R.l.dGt), new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeTvHistoryListUI psX;

            {
                this.psX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.g.a(this.psX.uSU.uTo, true, this.psX.getString(R.l.eVY), "", this.psX.getString(R.l.eOo), this.psX.getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 psY;

                    {
                        this.psY = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        g gVar = g.oUh;
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(2);
                        o baU = m.baU();
                        List<n> arrayList = new ArrayList();
                        Cursor bbw = baU.bbw();
                        if (bbw != null) {
                            while (bbw.moveToNext()) {
                                n nVar = new n();
                                nVar.b(bbw);
                                arrayList.add(nVar);
                            }
                            bbw.close();
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        for (n nVar2 : arrayList) {
                            stringBuilder.append(nVar2.field_username);
                            stringBuilder.append("|");
                        }
                        objArr[1] = stringBuilder.toString();
                        gVar.i(12662, objArr);
                        m.baU().gUz.delete("shaketvhistory", null, null);
                        ap.vd().a(new c(2, null), 0);
                        this.psY.psX.psV.OK();
                        this.psY.psX.kr(false);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 psY;

                    {
                        this.psY = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        });
        this.psW = (ListView) findViewById(R.h.cEC);
        this.psV = new a(this, this);
        this.psW.setAdapter(this.psV);
        this.psW.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ShakeTvHistoryListUI psX;

            {
                this.psX = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.plugin.shake.d.a.k.a((n) this.psX.psV.getItem(i), this.psX.uSU.uTo, 2);
            }
        });
        final l lVar = new l(this);
        this.psW.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ ShakeTvHistoryListUI psX;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.psX.psW.getHeaderViewsCount()) {
                    lVar.a(view, i, j, this.psX.uSU.uTo, this.psX.jWo);
                }
                return true;
            }
        });
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.username = ((n) this.psV.getItem(adapterContextMenuInfo.position)).field_username;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dGB);
    }

    protected final int getLayoutId() {
        return R.i.dos;
    }
}
