package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.a.h;
import com.tencent.mm.plugin.brandservice.a.i;
import com.tencent.mm.protocal.c.hv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;

public class BizSearchResultItemContainer extends LinearLayout implements e {
    private int hPi = 0;
    int jZN;
    private ListView kae;
    c kaf;
    private TextView kag;
    c kah;
    private a kai;
    i kaj;
    b kak;
    private long[] kal;
    int kam;
    private boolean kan;
    int kao;

    private static class a {
        View kar;
        View kas;
        View kat;

        public final void kg(int i) {
            switch (i) {
                case 1:
                    h(true, false);
                    return;
                case 2:
                    h(false, true);
                    return;
                case 3:
                    h(false, false);
                    return;
                default:
                    h(false, false);
                    return;
            }
        }

        private void h(boolean z, boolean z2) {
            int i;
            int i2 = 0;
            View view = this.kar;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
            this.kas.setVisibility(8);
            View view2 = this.kat;
            if (!z2) {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public interface b {
        void aeh();

        void aei();
    }

    private static class c {
        public String fDs;
        public int jZY = 1;
        public long jZm;
        public boolean kau;
        public boolean kav;
        public int offset;
    }

    static /* synthetic */ boolean a(BizSearchResultItemContainer bizSearchResultItemContainer) {
        return (!bizSearchResultItemContainer.kah.kav || bizSearchResultItemContainer.kah.jZY == 0 || bizSearchResultItemContainer.kah.kau) ? false : true;
    }

    public BizSearchResultItemContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = View.inflate(getContext(), R.i.cBb, this);
        this.kah = new c();
        this.kai = new a();
        this.kag = (TextView) inflate.findViewById(R.h.bLK);
        this.kae = (ListView) inflate.findViewById(R.h.cyE);
    }

    public final void a(c cVar) {
        this.kaf = cVar;
        if (this.kaf != null) {
            this.kaf.kc(this.hPi);
            ListView listView = this.kae;
            a aVar = this.kai;
            View inflate = View.inflate(getContext(), R.i.dgN, null);
            aVar.kar = inflate.findViewById(R.h.cbQ);
            aVar.kas = inflate.findViewById(R.h.cbL);
            aVar.kat = inflate.findViewById(R.h.cbR);
            aVar.kar.setVisibility(8);
            aVar.kas.setVisibility(8);
            aVar.kat.setVisibility(8);
            listView.addFooterView(inflate, null, false);
            this.kae.setAdapter(this.kaf);
            this.kae.setOnScrollListener(new OnScrollListener(this) {
                boolean kap = false;
                final /* synthetic */ BizSearchResultItemContainer kaq;

                {
                    this.kaq = r2;
                }

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i == 0 && this.kap && BizSearchResultItemContainer.a(this.kaq)) {
                        this.kaq.c(this.kaq.kah.fDs, this.kaq.kah.offset, this.kaq.kal[this.kaq.kal.length - 1]);
                    }
                }

                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (i + i2 == i3) {
                        this.kap = true;
                    } else {
                        this.kap = false;
                    }
                }
            });
            this.kae.setOnItemClickListener(this.kaf);
            if (this.kah.jZm == 0) {
                d(1);
                return;
            }
            return;
        }
        this.kae.setAdapter(this.kaf);
    }

    private void c(String str, int i, long j) {
        hv hvVar = null;
        this.kah.kau = true;
        ap.vd().a(1071, this);
        a aM = this.kaf.aM(this.kal[this.kal.length - 1]);
        List list = aM != null ? aM.kad : null;
        if (list == null || list.size() == 0) {
            w.i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", new Object[]{str, Integer.valueOf(i), Long.valueOf(j)});
        } else {
            hvVar = (hv) list.get(list.size() - 1);
        }
        w.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", new Object[]{str, Integer.valueOf(i), Long.valueOf(j), hvVar != null ? hvVar.tmb : ""});
        ap.vd().a(new h(str, j, i, this.hPi, r6), 0);
        this.kai.kg(1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 3;
        w.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.kak != null) {
            this.kak.aei();
        }
        if (i == 0 && i2 == 0) {
            this.kan = false;
            if (kVar == null) {
                w.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
                return;
            }
            int i4;
            int i5;
            if (kVar.getType() == 1070) {
                w.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
                ap.vd().b(1070, this);
                i iVar = (i) kVar;
                List list = iVar.jZn == null ? null : iVar.jZn.tZR;
                this.kaf.c(this.kah.fDs, list);
                a aM = this.kaf.aM(this.kal[this.kal.length - 1]);
                i5 = (aM == null || aM.kac) ? 0 : aM.jZY;
                if (i5 != 0) {
                    i3 = 2;
                }
                if (list != null && list.size() > 0) {
                    hv hvVar = (hv) list.get(list.size() - 1);
                    if (hvVar != null) {
                        this.kah.offset = hvVar.tll + this.kam;
                    }
                }
                i4 = i3;
                i3 = i5;
            } else if (kVar.getType() == 1071) {
                ap.vd().b(1071, this);
                w.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
                hv aec = ((h) kVar).aec();
                if (aec == null || aec.muY == null) {
                    w.e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
                }
                i5 = aec == null ? 0 : aec.tlZ;
                if (i5 == 0) {
                    i4 = 3;
                } else {
                    i4 = 2;
                }
                this.kaf.a(aec, true);
                if (aec != null) {
                    w.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", new Object[]{aec.tmb});
                    this.kah.offset = aec.tll + this.kam;
                }
                i3 = i5;
            } else {
                w.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", new Object[]{Integer.valueOf(kVar.getType())});
                return;
            }
            if (this.kaf.isEmpty()) {
                new ae(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ BizSearchResultItemContainer kaq;

                    {
                        this.kaq = r1;
                    }

                    public final void run() {
                        this.kaq.kag.setVisibility(this.kaq.kaf.isEmpty() ? 0 : 8);
                    }
                });
            } else {
                this.kah.kav = true;
            }
            this.kah.jZY = i3;
            this.kai.kg(i4);
            this.kah.kau = false;
            w.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", new Object[]{Integer.valueOf(this.kah.offset)});
            return;
        }
        this.kah.kau = false;
        this.kan = true;
        Toast.makeText(getContext(), getContext().getString(R.l.elQ, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
    }

    final void reset() {
        this.kaf.aeg();
        this.kai.kg(0);
        this.kah.kav = false;
        this.kah.kau = false;
        this.kah.offset = 0;
        this.kah.fDs = null;
        this.kah.jZY = 1;
    }

    public final void d(long... jArr) {
        this.kal = jArr;
        this.kah.jZm = 0;
        for (int i = 0; i <= 0; i++) {
            c cVar = this.kah;
            cVar.jZm |= jArr[0];
        }
        this.kaf.c(jArr);
    }

    public final void az(String str, int i) {
        if (this.kaf.isEmpty()) {
            this.kag.setVisibility(8);
        }
        if (str != null) {
            String trim = str.trim();
            if (!"".equals(trim)) {
                if ((!trim.equals(this.kah.fDs) || this.kan) && !this.kah.kau) {
                    reset();
                    this.kah.kau = true;
                    this.kah.fDs = trim;
                    this.kam = i;
                    if (this.kao != 1) {
                        ap.vd().a(1070, this);
                        this.kaj = new i(this.kah.fDs, this.kah.jZm, this.hPi);
                        ap.vd().a(this.kaj, 0);
                    } else if (this.kal.length == 0) {
                        w.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
                        return;
                    } else {
                        c(trim, i, this.kal[0]);
                        this.kai.kg(0);
                    }
                    if (this.kak != null) {
                        this.kak.aeh();
                    }
                }
            }
        }
    }

    public final void kc(int i) {
        this.hPi = i;
        this.kaf.kc(this.hPi);
    }

    public final void cY(boolean z) {
        this.kaf.g(z, false);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.kae.setOnTouchListener(onTouchListener);
    }
}
