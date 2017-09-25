package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.tools.p.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryCodeUI extends MMActivity {
    private String countryCode;
    private List<c> fRK;
    private String hJF;
    private String isw = "";
    private p kww;
    private ListView mTI;
    private boolean mTq = false;
    private a vVJ;
    private d wkU;
    private VerticalScrollBar wkV;

    static /* synthetic */ void a(CountryCodeUI countryCodeUI) {
        if (countryCodeUI.wkU != null) {
            countryCodeUI.wkU.yD(countryCodeUI.isw);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fRK = new ArrayList();
        this.hJF = u.ap(getIntent().getStringExtra("country_name"), "");
        this.countryCode = u.ap(getIntent().getStringExtra("couttry_code"), "");
        this.mTq = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", true);
        KC();
    }

    protected final int getLayoutId() {
        if (v.bIL()) {
            return R.i.cZV;
        }
        return R.i.cZU;
    }

    protected void onPause() {
        super.onPause();
        if (this.kww != null) {
            this.kww.bZQ();
        }
    }

    protected final void KC() {
        zi(R.l.dCU);
        w.d("MicroMsg.CountryCodeUI", "CHT:initCountryCode start:" + System.currentTimeMillis());
        String[] split = getString(R.l.bGO).trim().split(",");
        String[] split2;
        if (v.bIL()) {
            w.d("MicroMsg.CountryCodeUI", "CHT:initCountryCode t1:" + System.currentTimeMillis());
            for (String trim : split) {
                split2 = trim.trim().split(":");
                this.fRK.add(new c(split2[1], split2[0], com.tencent.mm.ai.a.jM(split2[1]), split2[1]));
            }
            w.d("MicroMsg.CountryCodeUI", "CHT:initCountryCode t2:" + System.currentTimeMillis());
            Collections.sort(this.fRK, new Comparator<c>(this) {
                final /* synthetic */ CountryCodeUI wkW;

                {
                    this.wkW = r1;
                }

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return new Integer(((c) obj).mRg).intValue() - new Integer(((c) obj2).mRg).intValue();
                }
            });
            w.d("MicroMsg.CountryCodeUI", "CHT2:initCountryCode t3:" + System.currentTimeMillis());
        } else {
            for (String trim2 : split) {
                split2 = trim2.trim().split(":");
                if (split2.length < 3) {
                    w.e("MicroMsg.CountryCodeUI", "this country item has problem %s", split[r0]);
                } else {
                    this.fRK.add(new c(split2[1], split2[0], split2[2].charAt(0), split2[2]));
                }
            }
            Collections.sort(this.fRK, new Comparator<c>(this) {
                final /* synthetic */ CountryCodeUI wkW;

                {
                    this.wkW = r1;
                }

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((c) obj).mRh.compareTo(((c) obj2).mRh);
                }
            });
        }
        this.kww = new p(true, true);
        this.kww.woe = new b(this) {
            final /* synthetic */ CountryCodeUI wkW;

            {
                this.wkW = r1;
            }

            public final void mR(String str) {
                this.wkW.isw = str;
                CountryCodeUI.a(this.wkW);
            }

            public final void OD() {
            }

            public final void OE() {
            }

            public final boolean mQ(String str) {
                return false;
            }

            public final void OF() {
            }

            public final void OG() {
            }
        };
        a(this.kww);
        this.mTI = (ListView) findViewById(R.h.bnw);
        this.wkU = new d(this, this.fRK);
        this.wkU.mTq = this.mTq;
        this.mTI.setAdapter(this.wkU);
        this.mTI.setVisibility(0);
        this.wkV = (VerticalScrollBar) findViewById(R.h.bnG);
        if (v.bIL()) {
            this.vVJ = new a(this) {
                final /* synthetic */ CountryCodeUI wkW;

                {
                    this.wkW = r1;
                }

                public final void sd(String str) {
                    int i = 0;
                    if (this.wkW.getString(R.l.ePv).equals(str)) {
                        this.wkW.mTI.setSelection(0);
                        return;
                    }
                    int intValue = Integer.decode(str.substring(0, str.length() - 1)).intValue();
                    int[] iArr = this.wkW.wkU.mTp;
                    if (iArr != null) {
                        while (i < iArr.length) {
                            if (iArr[i] == intValue) {
                                this.wkW.mTI.setSelection(i + this.wkW.mTI.getHeaderViewsCount());
                                return;
                            }
                            i++;
                        }
                    }
                }
            };
        } else {
            this.vVJ = new a(this) {
                final /* synthetic */ CountryCodeUI wkW;

                {
                    this.wkW = r1;
                }

                public final void sd(String str) {
                    int i = 0;
                    char charAt = str.charAt(0);
                    if (this.wkW.getString(R.l.ePv).equals(str)) {
                        this.wkW.mTI.setSelection(0);
                        return;
                    }
                    int[] iArr = this.wkW.wkU.mTp;
                    if (iArr != null) {
                        while (i < iArr.length) {
                            if (iArr[i] == charAt) {
                                this.wkW.mTI.setSelection(i + this.wkW.mTI.getHeaderViewsCount());
                                return;
                            }
                            i++;
                        }
                    }
                }
            };
        }
        this.wkV.vpW = this.vVJ;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CountryCodeUI wkW;

            {
                this.wkW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.wkW.aHf();
                Intent intent = new Intent();
                intent.putExtra("country_name", this.wkW.hJF);
                intent.putExtra("couttry_code", this.wkW.countryCode);
                this.wkW.setResult(100, intent);
                this.wkW.finish();
                return true;
            }
        });
        this.mTI.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CountryCodeUI wkW;

            {
                this.wkW = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                if (i >= this.wkW.mTI.getHeaderViewsCount()) {
                    c cVar = (c) this.wkW.wkU.getItem(i - this.wkW.mTI.getHeaderViewsCount());
                    intent.putExtra("country_name", cVar.hJF);
                    intent.putExtra("couttry_code", cVar.countryCode);
                    this.wkW.setResult(100, intent);
                }
                this.wkW.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        Intent intent = new Intent();
        intent.putExtra("country_name", this.hJF);
        intent.putExtra("couttry_code", this.countryCode);
        setResult(100, intent);
        finish();
        return true;
    }
}
