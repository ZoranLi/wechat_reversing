package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public class ShakeMsgListUI extends MMActivity {
    private int aIo = 0;
    private int fFr;
    private long jFH;
    private d jWo = new d(this) {
        final /* synthetic */ ShakeMsgListUI prs;

        {
            this.prs = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            g a = this.prs.prp;
            w.i("MicroMsg.ShakeMessageStorage", "delBySvrId = " + a.gUz.delete(a.getTableName(), "svrid = '" + String.valueOf(this.prs.jFH) + "'", null));
            this.prs.prq.a(null, null);
        }
    };
    private TextView kBo;
    private int mType;
    private int nWO = 0;
    private int nWP = 0;
    private g prp = null;
    private d prq;
    private ListView prr;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("shake_msg_type", 0);
        this.prp = m.baT();
        this.nWP = this.prp.Kr();
        this.aIo = this.nWP == 0 ? 8 : this.nWP;
        this.nWO = this.prp.getCount();
        this.fFr = getIntent().getIntExtra("shake_msg_from", 1);
        if (this.fFr == 1) {
            com.tencent.mm.plugin.report.service.g.oUh.i(11313, new Object[]{Integer.valueOf(this.nWP), e.bbN()});
        } else {
            com.tencent.mm.plugin.report.service.g.oUh.i(11315, new Object[]{Integer.valueOf(this.nWP), e.bbN()});
        }
        g gVar = this.prp;
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(1));
        gVar.gUz.update(gVar.getTableName(), contentValues, "status!=? ", new String[]{"1"});
        KC();
    }

    protected void onResume() {
        super.onResume();
        if (this.nWO != this.prp.getCount()) {
            this.nWO = this.prp.getCount();
            if (this.nWO == 0) {
                bby();
            }
            this.prq.OK();
        }
        this.prq.notifyDataSetChanged();
    }

    public void onDestroy() {
        this.prq.aEW();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dop;
    }

    protected final void KC() {
        qP(getIntent().getStringExtra("shake_msg_list_title"));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeMsgListUI prs;

            {
                this.prs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.prs.aHf();
                this.prs.finish();
                return true;
            }
        });
        a(0, getString(R.l.dGt), new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeMsgListUI prs;

            {
                this.prs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.g.a(this.prs.uSU.uTo, true, this.prs.getString(R.l.eVC), "", this.prs.getString(R.l.eOo), this.prs.getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 prt;

                    {
                        this.prt = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        g a = this.prt.prs.prp;
                        a.gUz.delete(a.getTableName(), null, null);
                        this.prt.prs.prq.OK();
                        this.prt.prs.bby();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 prt;

                    {
                        this.prt = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        });
        this.kBo = (TextView) findViewById(R.h.bLU);
        if (this.nWO == 0) {
            bby();
        }
        this.prr = (ListView) findViewById(R.h.cDS);
        final View inflate = getLayoutInflater().inflate(R.i.dmN, null);
        inflate.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ShakeMsgListUI prs;

            public final void onClick(View view) {
                this.prs.aIo = this.prs.aIo + 8;
                this.prs.prq.sB(this.prs.aIo);
                if (this.prs.nWO <= this.prs.aIo) {
                    this.prs.prr.removeFooterView(inflate);
                }
            }
        });
        if (this.nWO > 0 && this.aIo < this.nWO) {
            this.prr.addFooterView(inflate);
        }
        this.prq = new d(this);
        this.prq.prm = this.aIo;
        this.prr.setAdapter(this.prq);
        this.prr.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ShakeMsgListUI prs;

            {
                this.prs = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                f fVar = (f) this.prs.prq.getItem(i);
                if (!bg.mA(fVar.field_tag)) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(11316, this.prs.fFr + "," + fVar.field_tag);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", fVar.field_tag);
                    com.tencent.mm.bb.d.b(this.prs.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
        final l lVar = new l(this);
        this.prr.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ ShakeMsgListUI prs;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.prs.prr.getHeaderViewsCount()) {
                    w.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, this.prs.uSU.uTo, this.prs.jWo);
                }
                return true;
            }
        });
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.jFH = ((f) this.prq.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dGB);
    }

    private void bby() {
        this.kBo.setText(R.l.eVD);
        this.kBo.setVisibility(0);
        kr(false);
    }
}
