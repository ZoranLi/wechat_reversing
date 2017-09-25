package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

@a(3)
public class IPCallCountryCodeSelectUI extends MMActivity {
    private String countryCode;
    private List<a> fRK;
    private String hJF;
    private String isw = "";
    private p kww;
    private ListView mTI;
    private f mTJ;
    private IPCallCountryCodeScrollbar mTK;
    private IPCallCountryCodeScrollbar.a mTL;
    private boolean mTM = false;
    public LinearLayout mTf;
    private boolean mTq = false;

    static /* synthetic */ void a(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI) {
        if (iPCallCountryCodeSelectUI.mTJ != null) {
            iPCallCountryCodeSelectUI.mTJ.yD(iPCallCountryCodeSelectUI.isw);
        }
    }

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fRK = new ArrayList();
        this.hJF = bg.ap(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bg.ap(getIntent().getStringExtra("couttry_code"), "");
        this.mTq = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI mTN;

            {
                this.mTN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mTN.finish();
                return false;
            }
        });
        KC();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(-1, R.a.aRo);
    }

    protected final int getLayoutId() {
        return R.i.dgb;
    }

    protected void onPause() {
        super.onPause();
        if (this.kww != null) {
            this.kww.bZQ();
        }
    }

    protected final void KC() {
        zi(R.l.dCU);
        this.kww = new p(true, true);
        this.kww.woe = new b(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI mTN;

            {
                this.mTN = r1;
            }

            public final void mR(String str) {
                this.mTN.isw = str;
                IPCallCountryCodeSelectUI.a(this.mTN);
            }

            public final void OD() {
                this.mTN.isw = "";
                IPCallCountryCodeSelectUI.a(this.mTN);
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
        this.mTK = (IPCallCountryCodeScrollbar) findViewById(R.h.bnG);
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        for (Integer intValue : c.aDT().aDW()) {
            int intValue2 = intValue.intValue();
            if (i >= 5) {
                break;
            }
            String yS = com.tencent.mm.plugin.ipcall.b.a.yS(String.valueOf(intValue2));
            if (bg.mA(yS) || c.aDT().og(intValue2)) {
                intValue2 = i;
            } else {
                this.fRK.add(new a(yS, String.valueOf(intValue2), 0, "0"));
                intValue2 = i + 1;
            }
            i = intValue2;
        }
        if (i > 0) {
            this.mTM = true;
        }
        aFd();
        w.d("MicroMsg.IPCallCountryCodeSelectUI", "initCountryCode used: %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        this.mTf = (LinearLayout) findViewById(R.h.bnI);
        this.mTI = (ListView) findViewById(R.h.bnw);
        this.mTJ = new f(this, this.fRK);
        this.mTJ.mTq = this.mTq;
        this.mTJ.mTr = this.mTM;
        this.mTI.setAdapter(this.mTJ);
        this.mTI.setVisibility(0);
        this.mTL = new IPCallCountryCodeScrollbar.a(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI mTN;

            {
                this.mTN = r1;
            }

            public final void sd(String str) {
                int i = 0;
                char charAt = str.charAt(0);
                if ("↑".equals(str)) {
                    this.mTN.mTI.setSelection(0);
                    return;
                }
                int[] iArr = this.mTN.mTJ.mTp;
                if (iArr != null) {
                    while (i < iArr.length) {
                        if (iArr[i] == charAt) {
                            this.mTN.mTI.setSelection(i + this.mTN.mTI.getHeaderViewsCount());
                            return;
                        }
                        i++;
                    }
                }
            }
        };
        this.mTK.mTE = this.mTL;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI mTN;

            {
                this.mTN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mTN.aHf();
                Intent intent = new Intent();
                intent.putExtra("country_name", this.mTN.hJF);
                intent.putExtra("couttry_code", this.mTN.countryCode);
                this.mTN.setResult(100, intent);
                this.mTN.finish();
                return true;
            }
        });
        this.mTI.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI mTN;

            {
                this.mTN = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                if (i >= this.mTN.mTI.getHeaderViewsCount()) {
                    a aVar = (a) this.mTN.mTJ.getItem(i - this.mTN.mTI.getHeaderViewsCount());
                    intent.putExtra("country_name", aVar.hJF);
                    intent.putExtra("couttry_code", aVar.countryCode);
                    this.mTN.setResult(100, intent);
                }
                this.mTN.finish();
            }
        });
    }

    private void aFd() {
        com.tencent.mm.plugin.ipcall.b.b bVar;
        String str;
        if (v.bIJ()) {
            for (Entry entry : com.tencent.mm.plugin.ipcall.b.a.aFu().entrySet()) {
                entry.getKey();
                bVar = (com.tencent.mm.plugin.ipcall.b.b) entry.getValue();
                str = bVar.mYM;
                if (!(str == null || "".equals(str.trim()))) {
                    char[] toCharArray = str.toCharArray();
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = toCharArray.length;
                    for (int i = 0; i < length; i++) {
                        String d = SpellMap.d(toCharArray[i]);
                        if (bg.mA(d)) {
                            stringBuffer.append(toCharArray[i]);
                        } else {
                            stringBuffer.append(d);
                        }
                    }
                    str = stringBuffer.toString();
                }
                str = str.toUpperCase();
                if (bg.mA(str)) {
                    str = " ";
                }
                if (!c.aDT().og(bg.getInt(bVar.mYL, 0))) {
                    this.fRK.add(new a(bVar.mYM, bVar.mYL, str.charAt(0), str));
                }
            }
        } else {
            for (Entry entry2 : com.tencent.mm.plugin.ipcall.b.a.aFu().entrySet()) {
                entry2.getKey();
                bVar = (com.tencent.mm.plugin.ipcall.b.b) entry2.getValue();
                str = bVar.mYM.toUpperCase();
                if (bg.mA(str)) {
                    str = " ";
                }
                if (!c.aDT().og(bg.getInt(bVar.mYL, 0))) {
                    this.fRK.add(new a(bVar.mYM, bVar.mYL, str.charAt(0), str));
                }
            }
        }
        Collections.sort(this.fRK, new Comparator<a>(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI mTN;

            {
                this.mTN = r1;
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((a) obj).mRh.compareTo(((a) obj2).mRh);
            }
        });
        for (a aER : this.fRK) {
            int aER2 = aER.aER();
            if (aER2 != 0) {
                this.mTK.yH(String.valueOf((char) aER2));
            }
        }
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
