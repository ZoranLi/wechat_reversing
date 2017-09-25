package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.b;
import android.support.design.widget.c;
import android.support.v4.view.z;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.collect.b.f;
import com.tencent.mm.plugin.collect.b.n;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.r;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CollectBillListUI extends WalletBaseUI {
    private int aIo = 20;
    private Dialog ita;
    private int kAV = 0;
    private long kBA = 0;
    private Calendar kBB;
    private List<f> kBC = new ArrayList();
    private ListView kBk;
    private b kBl;
    private LinearLayout kBm;
    private CollectPullDownView kBn;
    private TextView kBo;
    private Dialog kBp;
    private boolean kBq = false;
    private boolean kBr = false;
    private boolean kBs = false;
    private boolean kBt = false;
    private boolean kBu = false;
    private boolean kBv = false;
    private boolean kBw = true;
    private boolean kBx = false;
    private boolean kBy = false;
    private long kBz = 0;
    private View koo;
    private int retryCount = 0;
    private int type = 0;

    static /* synthetic */ void a(CollectBillListUI collectBillListUI) {
        if (collectBillListUI.kBp == null) {
            collectBillListUI.kBp = new c(collectBillListUI);
            final View datePickerDialogView = new DatePickerDialogView(collectBillListUI);
            datePickerDialogView.kDv = collectBillListUI.type;
            datePickerDialogView.akG();
            collectBillListUI.kBp.setContentView(datePickerDialogView);
            datePickerDialogView.kDt.setOnClickListener(new OnClickListener(collectBillListUI) {
                final /* synthetic */ CollectBillListUI kBD;

                public final void onClick(View view) {
                    long timeInMillis;
                    if (this.kBD.kBB == null) {
                        this.kBD.kBB = Calendar.getInstance();
                    }
                    this.kBD.kBB.clear();
                    int year = datePickerDialogView.kDs.getYear();
                    int month = datePickerDialogView.kDs.getMonth();
                    int dayOfMonth = datePickerDialogView.kDs.getDayOfMonth();
                    this.kBD.type = datePickerDialogView.kDs.wwk;
                    if (this.kBD.type == 2) {
                        this.kBD.kBB.set(1, year);
                        timeInMillis = this.kBD.kBB.getTimeInMillis() / 1000;
                    } else if (this.kBD.type == 1) {
                        this.kBD.kBB.set(1, year);
                        this.kBD.kBB.set(2, month);
                        timeInMillis = this.kBD.kBB.getTimeInMillis() / 1000;
                    } else {
                        this.kBD.kBB.set(year, month, dayOfMonth);
                        timeInMillis = this.kBD.kBB.getTimeInMillis() / 1000;
                    }
                    w.i("MicroMsg.CollectBillListUI", "year: %d, month: %d, day: %d, type: %d, timestamp: %s", new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth), Integer.valueOf(this.kBD.type), Long.valueOf(timeInMillis)});
                    CollectBillListUI.a(this.kBD, timeInMillis);
                    this.kBD.kBp.dismiss();
                }
            });
            datePickerDialogView.kDu.setOnClickListener(new OnClickListener(collectBillListUI) {
                final /* synthetic */ CollectBillListUI kBD;

                {
                    this.kBD = r1;
                }

                public final void onClick(View view) {
                    this.kBD.kBp.dismiss();
                }
            });
            if (VERSION.SDK_INT >= 21) {
                collectBillListUI.kBp.getWindow().addFlags(Integer.MIN_VALUE);
            }
            final BottomSheetBehavior i = BottomSheetBehavior.i((View) datePickerDialogView.getParent());
            i.fb = false;
            if (3 != i.mState) {
                if (i.fh == null) {
                    i.mState = 3;
                } else {
                    View view = (View) i.fh.get();
                    if (view != null) {
                        int i2 = i.eZ;
                        i.h(2);
                        if (i.fc.e(view, view.getLeft(), i2)) {
                            z.a(view, new b(i, view, 3));
                        }
                    }
                }
            }
            af.f(new Runnable(collectBillListUI) {
                final /* synthetic */ CollectBillListUI kBD;

                public final void run() {
                    w.d("MicroMsg.CollectBillListUI", "view height: %d", new Object[]{Integer.valueOf(datePickerDialogView.getHeight())});
                    i.g(datePickerDialogView.getHeight());
                }
            }, 300);
        }
        collectBillListUI.kBp.show();
    }

    static /* synthetic */ void a(CollectBillListUI collectBillListUI, long j) {
        w.i("MicroMsg.CollectBillListUI", "get filter page, type: %d, timestamp: %s", new Object[]{Integer.valueOf(collectBillListUI.type), Long.valueOf(j)});
        collectBillListUI.kBr = false;
        collectBillListUI.akj();
        collectBillListUI.wFr.aHT();
        collectBillListUI.kBs = false;
        collectBillListUI.kBt = false;
        collectBillListUI.q(new n(collectBillListUI.type, j, collectBillListUI.aIo, 1));
        collectBillListUI.kBu = true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        zi(R.l.dWw);
        if (this.kBy) {
            a(0, R.k.dvR, new OnMenuItemClickListener(this) {
                final /* synthetic */ CollectBillListUI kBD;

                {
                    this.kBD = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    CollectBillListUI.a(this.kBD);
                    return false;
                }
            });
        }
        this.ita = g.a(this, false, new OnCancelListener(this) {
            final /* synthetic */ CollectBillListUI kBD;

            {
                this.kBD = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        akl();
        com.tencent.mm.plugin.report.service.g.oUh.i(13944, new Object[]{Integer.valueOf(4)});
    }

    protected final void KC() {
        this.kBk = (ListView) findViewById(R.h.bDt);
        this.kBm = (LinearLayout) findViewById(R.h.bDr);
        this.kBo = (TextView) findViewById(R.h.bDs);
        this.koo = r.eC(this).inflate(R.i.cZc, this.kBk, false);
        View view = new View(this);
        view.setLayoutParams(new LayoutParams(-1, a.fromDPToPix(this, 5)));
        this.kBk.addHeaderView(view, null, true);
        new View(this).setLayoutParams(new LayoutParams(-1, a.fromDPToPix(this, 10)));
        this.kBk.addFooterView(view, null, true);
        this.kBk.setOverScrollMode(2);
        this.kBl = new b(this);
        this.kBk.setAdapter(this.kBl);
        this.kBk.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CollectBillListUI kBD;

            {
                this.kBD = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                w.d("MicroMsg.CollectBillListUI", "click item: %d", new Object[]{Integer.valueOf(i)});
                if (i >= 0 && i < adapterView.getAdapter().getCount()) {
                    Intent intent = new Intent(this.kBD.uSU.uTo, CollectBillUI.class);
                    f fVar = (f) adapterView.getItemAtPosition(i);
                    if (fVar == null) {
                        w.w("MicroMsg.CollectBillListUI", "invaild record: %d", new Object[]{Integer.valueOf(i)});
                        return;
                    }
                    intent.putExtra("key_type", fVar.type);
                    intent.putExtra("key_timestamp", fVar.kAw);
                    intent.putExtra("key_from_scene", 2);
                    this.kBD.startActivity(intent);
                    com.tencent.mm.plugin.report.service.g.oUh.i(13944, new Object[]{Integer.valueOf(3)});
                }
            }
        });
        this.kBk.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ CollectBillListUI kBD;

            {
                this.kBD = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.kBn = (CollectPullDownView) findViewById(R.h.bDv);
        this.kBn.kR(false);
        this.kBn.kO(false);
        this.kBn.kQ(true);
        this.kBn.kP(false);
        this.kBn.vlI = true;
        this.kBn.vlA = new d(this) {
            final /* synthetic */ CollectBillListUI kBD;

            {
                this.kBD = r1;
            }

            public final boolean akn() {
                int firstVisiblePosition = this.kBD.kBk.getFirstVisiblePosition();
                if (firstVisiblePosition == 0) {
                    View childAt = this.kBD.kBk.getChildAt(firstVisiblePosition);
                    if (childAt != null && childAt.getX() == 0.0f) {
                        return true;
                    }
                }
                return false;
            }
        };
        this.kBn.vlz = new MMPullDownView.c(this) {
            final /* synthetic */ CollectBillListUI kBD;

            {
                this.kBD = r1;
            }

            public final boolean ako() {
                if (this.kBD.kBm.getVisibility() == 0) {
                    w.d("MicroMsg.CollectBillListUI", "empty view");
                    return true;
                }
                View childAt = this.kBD.kBk.getChildAt(this.kBD.kBk.getChildCount() - 1);
                if (childAt == null || childAt.getBottom() > this.kBD.kBk.getHeight() || this.kBD.kBk.getLastVisiblePosition() != this.kBD.kBk.getAdapter().getCount() - 1) {
                    return false;
                }
                return true;
            }
        };
        this.kBn.vln = new MMPullDownView.g(this) {
            final /* synthetic */ CollectBillListUI kBD;

            {
                this.kBD = r1;
            }

            public final boolean akp() {
                w.d("MicroMsg.CollectBillListUI", "top load");
                return true;
            }
        };
        this.kBn.vlo = new e(this) {
            final /* synthetic */ CollectBillListUI kBD;

            {
                this.kBD = r1;
            }

            public final boolean akm() {
                w.d("MicroMsg.CollectBillListUI", "bottomLoad, isLoading: %s, isFinish: %s", new Object[]{Boolean.valueOf(this.kBD.kBs), Boolean.valueOf(this.kBD.kBv)});
                if (this.kBD.kBs || this.kBD.kBv) {
                    return true;
                }
                this.kBD.kBn.kQ(true);
                this.kBD.akl();
                return false;
            }
        };
    }

    protected final int getLayoutId() {
        return R.i.cZa;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof n)) {
            return false;
        }
        n nVar = (n) kVar;
        if (this.ita.isShowing()) {
            this.ita.dismiss();
        }
        this.kBn.vlv = true;
        if (i == 0 && i2 == 0) {
            b bVar;
            if (nVar.kAV != 0) {
                this.kBv = nVar.hoD;
                if (nVar.kAU) {
                    if (!nVar.kBa.isEmpty()) {
                        this.kBC.addAll(nVar.kBa);
                    }
                    if (nVar.kAX != 0 || nVar.kAY <= 0) {
                        this.retryCount = 0;
                        this.kBw = true;
                        this.kBA = nVar.kAw;
                        if (nVar.kAX == 0) {
                            this.kBv = false;
                        } else {
                            this.kBv = true;
                        }
                        if (this.kBC.size() > 0) {
                            this.kBl.ai(this.kBC);
                        } else {
                            w.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
                            akk();
                            if (!bg.mA(nVar.kAZ)) {
                                this.kBo.setText(nVar.kAZ);
                                this.kBo.setVisibility(0);
                            }
                            bVar = this.kBl;
                            bVar.kBf.clear();
                            bVar.notifyDataSetChanged();
                        }
                    } else {
                        w.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[]{Integer.valueOf(this.retryCount)});
                        a(nVar.kAY, nVar.kAw, nVar.kAW, nVar.kAV);
                    }
                    return true;
                }
                if (!nVar.kBa.isEmpty()) {
                    this.kBl.ai(nVar.kBa);
                    this.kBz = ((f) nVar.kBa.get(0)).kAw;
                    this.kBA = ((f) nVar.kBa.get(nVar.kBa.size() - 1)).kAw;
                } else if (nVar.kAX != 0 || nVar.kAY <= 0) {
                    akk();
                } else {
                    w.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[]{Integer.valueOf(nVar.kAY), Long.valueOf(nVar.kAw)});
                    a(nVar.kAY, nVar.kAw, nVar.kAW, nVar.kAV);
                    this.kBC.clear();
                }
                this.kBu = false;
                this.kBw = false;
            } else if (this.kBu) {
                w.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
                return true;
            } else if (nVar.kAW == 1) {
                this.kBw = nVar.hoD;
                if (nVar.kBa.isEmpty()) {
                    this.kBw = true;
                } else {
                    bVar = this.kBl;
                    bVar.kBf.addAll(0, nVar.kBa);
                    bVar.notifyDataSetChanged();
                    this.kBz = ((f) nVar.kBa.get(0)).kAw;
                }
                this.kBt = false;
                this.kBr = false;
            } else {
                this.kBv = nVar.hoD;
                this.kBk.setVisibility(0);
                this.kBm.setVisibility(8);
                if (nVar.kAU) {
                    if (!nVar.kBa.isEmpty()) {
                        this.kBC.addAll(nVar.kBa);
                    }
                    if (nVar.kAX == 0 && nVar.kAY > 0 && nVar.kBa.isEmpty()) {
                        w.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[]{Integer.valueOf(this.retryCount)});
                        a(nVar.kAY, nVar.kAw, nVar.kAW, nVar.kAV);
                    } else {
                        this.retryCount = 0;
                        if (this.kBC.size() > 0) {
                            this.kBl.aj(this.kBC);
                        } else {
                            w.i("MicroMsg.CollectBillListUI", "retry data is empty");
                            tB(nVar.kAZ);
                        }
                        this.kBs = false;
                        this.kBA = nVar.kAw;
                        akj();
                        dm(this.kBv);
                    }
                    return true;
                } else if (!nVar.kBa.isEmpty()) {
                    this.kBl.aj(nVar.kBa);
                    this.kBA = ((f) nVar.kBa.get(nVar.kBa.size() - 1)).kAw;
                    if (this.kBA > nVar.kAw) {
                        w.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                        this.kBA = nVar.kAw;
                    } else {
                        w.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", new Object[]{Long.valueOf(this.kBA), Long.valueOf(nVar.kAw)});
                    }
                    this.kBs = false;
                    akj();
                    dm(this.kBv);
                } else if (nVar.kAX != 0 || nVar.kAY <= 0) {
                    this.kBs = false;
                    akj();
                    w.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
                    tB(nVar.kAZ);
                    dm(this.kBv);
                } else {
                    w.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[]{Integer.valueOf(nVar.kAY), Long.valueOf(nVar.kAw)});
                    a(nVar.kAY, nVar.kAw, nVar.kAW, nVar.kAV);
                    this.kBC.clear();
                }
            }
            return true;
        }
        w.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(nVar.kAV), Integer.valueOf(nVar.kAW)});
        if (nVar.kAV != 0) {
            this.kBu = false;
        } else if (nVar.kAW == 0) {
            this.kBs = false;
            akj();
        } else {
            this.kBt = false;
        }
        if (this.kBl.isEmpty()) {
            akk();
        }
        Toast.makeText(this, R.l.dWt, 1).show();
        return true;
    }

    private void akj() {
        this.kBn.scrollTo(0, this.kBn.vlp);
    }

    private void akk() {
        this.kBk.setVisibility(8);
        this.kBm.setVisibility(0);
        this.kBo.setVisibility(0);
    }

    private void tB(String str) {
        if (this.kBl.getCount() == 0) {
            w.i("MicroMsg.CollectBillListUI", "show empty view");
            if (!bg.mA(str)) {
                this.kBo.setText(str);
            } else if (this.kBv) {
                this.kBo.setText(getString(R.l.dWu));
            } else {
                this.kBo.setText(getString(R.l.dWu) + getString(R.l.dWv));
            }
            akk();
        } else if (!bg.mA(str)) {
            Toast.makeText(this.uSU.uTo, str, 1).show();
        }
    }

    private void dm(boolean z) {
        this.kBn.kQ(!z);
    }

    private void akl() {
        int count = this.kBl.getCount();
        if (count > 0) {
            long j = this.kBl.kW(count - 1).kAw;
            if (j < this.kBA) {
                w.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", new Object[]{Long.valueOf(j), Long.valueOf(this.kBA)});
                this.kBA = j;
            }
        }
        w.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", new Object[]{Integer.valueOf(this.type), Long.valueOf(this.kBA)});
        b(new n(this.type, this.kBA, this.aIo, 0), false);
        this.kBs = true;
    }

    private void a(int i, long j, int i2, int i3) {
        w.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", new Object[]{Integer.valueOf(this.type), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        b(new n(this.type, j, i2, this.aIo, i3, i), false);
        this.retryCount++;
    }
}
