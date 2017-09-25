package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.k;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;
import junit.framework.Assert;

public class ProfileMobilePhoneView extends ProfileItemView {
    public TextView jhl;
    private Context mContext;
    public String sJG;
    public String sJH;
    public String[] sJI;
    public LinearLayout sJP;
    public boolean sJQ;

    private static class a extends BaseAdapter {
        private Context mContext = null;
        private List<String> mzj = null;

        private class a {
            TextView iUO;
            final /* synthetic */ a sJT;

            public a(a aVar) {
                this.sJT = aVar;
            }
        }

        public a(Context context, List<String> list) {
            Assert.assertTrue(context != null);
            this.mContext = context;
            this.mzj = list;
        }

        public final int getCount() {
            return this.mzj == null ? 0 : this.mzj.size();
        }

        public final Object getItem(int i) {
            return this.mzj.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Object obj;
            String str = (String) getItem(i);
            if (view == null) {
                view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.cYg, viewGroup, false);
                a aVar = new a(this);
                aVar.iUO = (TextView) view.findViewById(R.h.title);
                view.setTag(aVar);
                obj = aVar;
            } else {
                obj = view.getTag();
            }
            ((a) obj).iUO.setText(str);
            return view;
        }
    }

    static /* synthetic */ void a(ProfileMobilePhoneView profileMobilePhoneView, final String str) {
        final k kVar = new k(profileMobilePhoneView.mContext);
        kVar.kjh = new a(profileMobilePhoneView.mContext, bg.f(!profileMobilePhoneView.sJQ ? new String[]{profileMobilePhoneView.mContext.getResources().getString(R.l.dVb)} : new String[]{profileMobilePhoneView.mContext.getResources().getString(R.l.dVb), profileMobilePhoneView.mContext.getResources().getString(R.l.dVc)}));
        kVar.sVj = new OnItemClickListener(profileMobilePhoneView) {
            final /* synthetic */ ProfileMobilePhoneView sJR;

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (kVar != null) {
                    kVar.dismiss();
                }
                Intent intent;
                if (i == 0) {
                    Integer[] numArr;
                    g gVar;
                    Object[] objArr;
                    g gVar2;
                    Integer[] numArr2;
                    int i2;
                    if (bg.mA(this.sJR.sJG)) {
                        numArr = new Object[1];
                        gVar = g.oUh;
                        objArr = numArr;
                    } else {
                        g gVar3 = g.oUh;
                        numArr = new Object[1];
                        if (this.sJR.sJG.equals(str.trim())) {
                            gVar2 = gVar3;
                            numArr2 = numArr;
                            Integer[] numArr3 = numArr;
                            i2 = 1;
                            Integer[] numArr4 = numArr3;
                            numArr2[0] = Integer.valueOf(i2);
                            gVar2.i(12043, r2);
                            intent = new Intent("android.intent.action.DIAL");
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                            this.sJR.getContext().startActivity(intent);
                        }
                        gVar = gVar3;
                        numArr2 = numArr;
                    }
                    gVar2 = gVar;
                    Object[] objArr2 = objArr;
                    numArr2 = numArr;
                    i2 = 0;
                    numArr2[0] = Integer.valueOf(i2);
                    gVar2.i(12043, objArr2);
                    intent = new Intent("android.intent.action.DIAL");
                    intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                    try {
                        this.sJR.getContext().startActivity(intent);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.ProfileMobilePhoneView", e, "Activity not found!", new Object[0]);
                    }
                } else if (1 == i) {
                    g.oUh.i(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                    intent = new Intent();
                    intent.putExtra("IPCallTalkUI_phoneNumber", str);
                    d.b(this.sJR.mContext, "ipcall", ".ui.IPCallDialUI", intent);
                }
            }
        };
        kVar.setCancelable(true);
        kVar.show();
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sJQ = false;
        this.mContext = context;
    }

    public final int aTQ() {
        return R.i.dlq;
    }

    public final void init() {
        this.jhl = (TextView) findViewById(R.h.crw);
        this.sJP = (LinearLayout) findViewById(R.h.crv);
        for (int i = 0; i < 5; i++) {
            this.sJP.getChildAt(i).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ProfileMobilePhoneView sJR;

                {
                    this.sJR = r1;
                }

                public final void onClick(View view) {
                    ProfileMobilePhoneView.a(this.sJR, ((TextView) view).getText().toString());
                }
            });
        }
    }

    @Deprecated
    public final boolean L(x xVar) {
        return false;
    }

    public final boolean aTR() {
        if (this.jhl != null) {
            LayoutParams layoutParams = this.jhl.getLayoutParams();
            layoutParams.width = com.tencent.mm.bg.a.T(getContext(), R.f.aXk);
            this.jhl.setLayoutParams(layoutParams);
        }
        if (this.sJP != null) {
            int i;
            View childAt;
            int i2;
            int i3;
            if (bg.mA(this.sJG) || !bg.Qh(this.sJG).booleanValue()) {
                if (!(this.sJG == null || bg.Qh(this.sJG).booleanValue())) {
                    w.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", new Object[]{this.sJG});
                }
                i = 0;
                boolean z = false;
            } else {
                childAt = this.sJP.getChildAt(0);
                if (childAt != null) {
                    childAt.setVisibility(0);
                    ((TextView) childAt).setText(this.sJG);
                }
                i = 1;
                i2 = 1;
            }
            if (bg.mA(this.sJH)) {
                i3 = i2;
            } else {
                this.sJI = this.sJH.split(",");
                setVisibility(0);
                i3 = i2;
                while (i3 < this.sJI.length + i) {
                    childAt = this.sJP.getChildAt(i3);
                    if (childAt != null) {
                        childAt.setVisibility(0);
                        ((TextView) childAt).setText(this.sJI[i3 - i]);
                    }
                    i3++;
                }
            }
            while (i3 < 5) {
                this.sJP.getChildAt(i3).setVisibility(8);
                i3++;
            }
            if (i != 1 && bg.mA(this.sJH)) {
                setVisibility(8);
            }
        }
        return false;
    }
}
