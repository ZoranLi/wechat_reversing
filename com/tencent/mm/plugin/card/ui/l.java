package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.g;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class l extends BaseAdapter {
    List<b> kdc = new ArrayList();
    OnClickListener kpr;
    boolean kps = false;
    private Context mContext;

    private class a {
        View jIM;
        TextView koz;
        CheckBox kpA;
        final /* synthetic */ l kpt;
        TextView kpx;
        TextView kpy;
        ImageView kpz;

        public a(l lVar) {
            this.kpt = lVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return kE(i);
    }

    public l(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.kdc.size();
    }

    private b kE(int i) {
        return (b) this.kdc.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        final b kE = kE(i);
        switch (kE.kdS) {
            case 2:
                view = View.inflate(this.mContext, R.i.cWg, null);
                TextView textView = (TextView) view.findViewById(R.h.bwu);
                TextView textView2 = (TextView) view.findViewById(R.h.bwt);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.cEY);
                if (TextUtils.isEmpty(kE.kdW)) {
                    linearLayout.setVisibility(8);
                } else {
                    linearLayout.setTag(kE.kdW);
                    linearLayout.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ l kpt;

                        {
                            this.kpt = r1;
                        }

                        public final void onClick(View view) {
                            String str = (String) view.getTag();
                            if (!TextUtils.isEmpty(str)) {
                                String substring;
                                if (str.contains(";")) {
                                    substring = str.substring(0, str.indexOf(";"));
                                } else {
                                    substring = str;
                                }
                                g.a(this.kpt.mContext, true, substring, "", this.kpt.mContext.getString(R.l.dXX), this.kpt.mContext.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 kpv;

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent("android.intent.action.DIAL");
                                        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(substring).toString()));
                                        this.kpv.kpt.mContext.startActivity(intent);
                                    }
                                }, null);
                            }
                        }
                    });
                    ((ImageView) view.findViewById(R.h.bws)).setBackgroundColor(com.tencent.mm.plugin.card.b.l.ta(kE.hib));
                    linearLayout.setVisibility(0);
                }
                textView.setText(kE.title);
                textView2.setText(kE.kdH);
                break;
            default:
                a aVar;
                boolean z;
                if (view != null) {
                    aVar = (a) view.getTag();
                } else {
                    aVar = null;
                }
                if (view == null || r0 == null) {
                    view = View.inflate(this.mContext, R.i.cWh, null);
                    a aVar2 = new a(this);
                    aVar2.koz = (TextView) view.findViewById(R.h.bwr);
                    aVar2.kpx = (TextView) view.findViewById(R.h.bwq);
                    aVar2.kpy = (TextView) view.findViewById(R.h.bwn);
                    aVar2.kpz = (ImageView) view.findViewById(R.h.bwp);
                    aVar2.jIM = view.findViewById(R.h.bwm);
                    aVar2.kpA = (CheckBox) view.findViewById(R.h.bwo);
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
                aVar.koz.setText(kE.title);
                if (kE.kdU) {
                    aVar.kpA.setVisibility(0);
                    aVar.kpA.setChecked(kE.kdV);
                    aVar.kpA.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ l kpt;

                        public final void onClick(View view) {
                            if (((CheckBox) view).isChecked()) {
                                kE.kdV = true;
                            } else {
                                kE.kdV = false;
                            }
                        }
                    });
                } else {
                    aVar.kpA.setVisibility(8);
                }
                if (TextUtils.isEmpty(kE.kdH)) {
                    aVar.kpx.setVisibility(4);
                } else {
                    aVar.kpx.setVisibility(0);
                    aVar.kpx.setText(kE.kdH);
                }
                if ((kE.tpl & 1) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    aVar.koz.setGravity(17);
                    aVar.koz.setTextColor(this.mContext.getResources().getColor(R.e.aUA));
                    aVar.kpx.setVisibility(8);
                } else {
                    aVar.koz.setGravity(3);
                    aVar.koz.setTextColor(this.mContext.getResources().getColor(R.e.aUt));
                }
                if (kE.kdT) {
                    aVar.kpy.setVisibility(0);
                } else {
                    aVar.kpy.setVisibility(8);
                }
                aVar.kpx.setTextColor(this.mContext.getResources().getColor(R.e.aUs));
                if (bg.mA(kE.ofg)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    aVar.kpz.setVisibility(0);
                    m.a(aVar.kpz, kE.ofg, com.tencent.mm.bg.a.fromDPToPix(this.mContext, 20), R.g.bhq, false);
                } else {
                    aVar.kpz.setVisibility(8);
                }
                if (i + 1 >= getCount()) {
                    if (i + 1 == getCount()) {
                        if (!this.kps) {
                            j(aVar.jIM, false);
                            break;
                        }
                        j(aVar.jIM, true);
                        break;
                    }
                }
                a(aVar.jIM, kE(i));
                a(aVar.jIM, kE(i + 1));
                break;
                break;
        }
        return view;
    }

    private static void a(View view, b bVar) {
        if (bVar != null) {
            j(view, bVar.kdT);
        }
    }

    private static void j(View view, boolean z) {
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z) {
            view.setBackgroundResource(R.g.bhc);
        } else {
            view.setBackgroundResource(R.g.bgh);
        }
        view.setLayoutParams(layoutParams);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
