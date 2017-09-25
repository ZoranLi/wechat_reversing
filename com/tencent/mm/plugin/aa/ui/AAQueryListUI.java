package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.aa.a.c.b;
import com.tencent.mm.plugin.aa.ui.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.e;
import java.util.List;

public class AAQueryListUI extends BaseAAPresenterActivity {
    private b ipd = ((b) m(b.class));
    private ListView ipe;
    private b ipf;
    private Dialog ipg;
    private boolean iph = false;
    private boolean ipi = false;
    private View ipj;
    private AAQueryListH5UrlFooterView ipk;
    private String ipl;
    private int mode = 1;

    static /* synthetic */ void k(AAQueryListUI aAQueryListUI) {
        if (bg.mA(aAQueryListUI.ipl)) {
            w.i("MicroMsg.AAQueryListUI", "empty h5 url!");
            aAQueryListUI.ipk.setVisibility(8);
            return;
        }
        TextView textView = aAQueryListUI.ipk.ipc;
        textView.setClickable(true);
        textView.setOnTouchListener(new k(aAQueryListUI));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(aAQueryListUI.getString(R.l.dBc));
        spannableStringBuilder.setSpan(new a(new a(aAQueryListUI) {
            final /* synthetic */ AAQueryListUI ipm;

            {
                this.ipm = r1;
            }

            public final void NZ() {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.ipm.ipl);
                d.b(this.ipm, "webview", ".ui.tools.WebViewUI", intent);
            }
        }), 0, spannableStringBuilder.length(), 18);
        textView.setText(spannableStringBuilder);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AAQueryListUI ipm;

            {
                this.ipm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ipm.finish();
                return false;
            }
        });
        zi(R.l.dBv);
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ AAQueryListUI ipm;

            {
                this.ipm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                e eVar = new e(this.ipm, e.wuP, false);
                eVar.qJf = new c(this) {
                    final /* synthetic */ AnonymousClass4 ipn;

                    {
                        this.ipn = r1;
                    }

                    public final void a(l lVar) {
                        lVar.add(0, 1, 1, R.l.dBw);
                        lVar.add(1, 2, 1, R.l.dBx);
                    }
                };
                eVar.qJg = new n.d(this) {
                    final /* synthetic */ AnonymousClass4 ipn;

                    {
                        this.ipn = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                w.i("MicroMsg.AAQueryListUI", "go to launch list: %d", new Object[]{Integer.valueOf(this.ipn.ipm.mode)});
                                if (this.ipn.ipm.mode != 1) {
                                    this.ipn.ipm.mode = 1;
                                    this.ipn.ipm.zi(R.l.dBv);
                                    this.ipn.ipm.ipf.mode = this.ipn.ipm.mode;
                                    this.ipn.ipm.ipf.Oa();
                                    this.ipn.ipm.ipf.notifyDataSetChanged();
                                    this.ipn.ipm.c(true, this.ipn.ipm.mode);
                                    return;
                                }
                                return;
                            case 2:
                                w.i("MicroMsg.AAQueryListUI", "go to pay query list: %d", new Object[]{Integer.valueOf(this.ipn.ipm.mode)});
                                if (this.ipn.ipm.mode != 2) {
                                    this.ipn.ipm.zi(R.l.dBy);
                                    this.ipn.ipm.ipf.mode = this.ipn.ipm.mode;
                                    this.ipn.ipm.ipf.Oa();
                                    this.ipn.ipm.ipf.notifyDataSetChanged();
                                    this.ipn.ipm.mode = 2;
                                    this.ipn.ipm.c(true, this.ipn.ipm.mode);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                };
                eVar.bzh();
                return true;
            }
        });
        this.ipe = (ListView) findViewById(R.h.bms);
        this.ipe.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ AAQueryListUI ipm;

            {
                this.ipm = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (this.ipm.ipe.getLastVisiblePosition() == this.ipm.ipe.getCount() - 1 && this.ipm.ipe.getCount() > 0 && !this.ipm.ipi && !this.ipm.iph) {
                    this.ipm.ipe.addFooterView(this.ipm.ipj);
                    this.ipm.c(false, this.ipm.mode);
                }
            }
        });
        this.ipe.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ AAQueryListUI ipm;

            {
                this.ipm = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.ipm.ipf != null) {
                    if (i < 0 || i >= this.ipm.ipf.getCount()) {
                        w.i("MicroMsg.AAQueryListUI", "click out of bound! %s", new Object[]{Integer.valueOf(i)});
                        return;
                    }
                    int top = view.getTop();
                    com.tencent.mm.protocal.c.k kVar = (com.tencent.mm.protocal.c.k) this.ipm.ipf.getItem(i);
                    if (kVar != null) {
                        if (!bg.mA(kVar.tbt)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", kVar.tbt);
                            d.b(this.ipm, "webview", ".ui.tools.WebViewUI", intent);
                        } else if (!bg.mA(kVar.tbh)) {
                            String str = null;
                            if (kVar.tbs == 2) {
                                str = m.xL();
                            }
                            Intent intent2 = new Intent(this.ipm, PaylistAAUI.class);
                            intent2.putExtra("bill_no", kVar.tbh);
                            intent2.putExtra("launcher_user_name", str);
                            intent2.putExtra("enter_scene", 4);
                            intent2.putExtra("chatroom", kVar.tbi);
                            intent2.putExtra("item_position", i);
                            intent2.putExtra("item_offset", top);
                            this.ipm.startActivityForResult(intent2, 1);
                        }
                    }
                }
                g.oUh.i(13721, new Object[]{Integer.valueOf(5), Integer.valueOf(3)});
            }
        });
        this.ipj = new AAQueryListLoadingMoreView(this);
        this.ipk = new AAQueryListH5UrlFooterView(this);
        this.ipg = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        this.ipf = new b(this, this.mode);
        this.ipe.setAdapter(this.ipf);
        this.ipe.setVisibility(4);
        c(false, this.mode);
    }

    private void c(final boolean z, int i) {
        if (this.iph) {
            w.i("MicroMsg.AAQueryListUI", "getNextPage, loading");
            return;
        }
        if (z) {
            this.ipi = false;
            this.ipe.removeFooterView(this.ipk);
        }
        this.iph = true;
        com.tencent.mm.vending.g.g.s(Boolean.valueOf(z), Integer.valueOf(i)).a(this.ipd.iou).d(new com.tencent.mm.vending.c.a<Object, com.tencent.mm.vending.j.d<List, String, Boolean>>(this) {
            final /* synthetic */ AAQueryListUI ipm;

            public final /* synthetic */ Object call(Object obj) {
                com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
                List list = (List) dVar.get(0);
                w.i("MicroMsg.AAQueryListUI", "record list size: %s, h5Url: %s, lastFlag: %s", new Object[]{Integer.valueOf(list.size()), dVar.get(1), dVar.get(2)});
                if (!bg.mA((String) dVar.get(1))) {
                    this.ipm.ipl = (String) dVar.get(1);
                }
                if (z) {
                    this.ipm.ipf.Oa();
                }
                b f = this.ipm.ipf;
                com.tencent.pb.common.c.d.j("MicroMsg.AAQueryListAdapter", new Object[]{"addNewRecord: %s", list});
                if (list != null && list.size() > 0) {
                    com.tencent.pb.common.c.d.j("MicroMsg.AAQueryListAdapter", new Object[]{"addNewRecord size: %s", Integer.valueOf(list.size())});
                    f.dataList.addAll(list);
                    f.notifyDataSetChanged();
                }
                if (this.ipm.ipg != null) {
                    this.ipm.ipg.dismiss();
                    this.ipm.ipg = null;
                }
                if (this.ipm.ipe.getVisibility() != 0) {
                    this.ipm.ipe.setVisibility(0);
                }
                this.ipm.iph = false;
                if (!((Boolean) dVar.get(2)).booleanValue()) {
                    this.ipm.ipi = true;
                }
                if (this.ipm.ipe.getFooterViewsCount() > 0) {
                    this.ipm.ipe.removeFooterView(this.ipm.ipj);
                }
                if (this.ipm.ipi) {
                    AAQueryListUI.k(this.ipm);
                    if (this.ipm.ipk.getVisibility() == 0) {
                        this.ipm.ipe.addFooterView(this.ipm.ipk, null, false);
                    }
                }
                return wCE;
            }
        }).a(new com.tencent.mm.vending.g.d.a(this) {
            final /* synthetic */ AAQueryListUI ipm;

            {
                this.ipm = r1;
            }

            public final void aD(Object obj) {
                w.i("MicroMsg.AAQueryListUI", "getNexPage failed: %s", new Object[]{obj});
                if (this.ipm.ipg != null) {
                    this.ipm.ipg.dismiss();
                    this.ipm.ipg = null;
                }
                this.ipm.iph = false;
                if (this.ipm.ipe.getFooterViewsCount() > 0) {
                    this.ipm.ipe.removeFooterView(this.ipm.ipj);
                }
                if (obj instanceof String) {
                    Toast.makeText(this.ipm, obj.toString(), 1).show();
                } else {
                    Toast.makeText(this.ipm, R.l.eqy, 1).show();
                }
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.cTv;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("close_aa", false);
            int intExtra = intent.getIntExtra("item_position", 0);
            int intExtra2 = intent.getIntExtra("item_offset", 0);
            if (booleanExtra) {
                this.ipe.setSelectionFromTop(intExtra, intExtra2);
                c(true, this.mode);
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
