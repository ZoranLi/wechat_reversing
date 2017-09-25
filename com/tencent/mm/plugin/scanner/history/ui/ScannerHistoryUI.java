package com.tencent.mm.plugin.scanner.history.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.k;

public class ScannerHistoryUI extends MMActivity {
    private ListView Fg;
    private View jAA;
    private LinearLayout koV;
    private View koW;
    private TextView koX;
    private a oVF;

    class a extends k<com.tencent.mm.plugin.scanner.history.a.a> {
        final /* synthetic */ ScannerHistoryUI oVG;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (com.tencent.mm.plugin.scanner.history.a.a) obj;
            if (obj == null) {
                obj = new com.tencent.mm.plugin.scanner.history.a.a();
            }
            obj.b(cursor);
            return obj;
        }

        public a(ScannerHistoryUI scannerHistoryUI) {
            this.oVG = scannerHistoryUI;
            super(scannerHistoryUI, new com.tencent.mm.plugin.scanner.history.a.a());
            ko(true);
        }

        public final void OK() {
            setCursor(c.aXX().Kk());
            notifyDataSetChanged();
        }

        protected final void OL() {
            aEW();
            OK();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            com.tencent.mm.plugin.scanner.history.a.a aVar = (com.tencent.mm.plugin.scanner.history.a.a) getItem(i);
            if (view == null) {
                view = View.inflate(this.oVG.uSU.uTo, R.i.dmT, null);
                b bVar2 = new b(this.oVG);
                bVar2.jki = (ImageView) view.findViewById(R.h.bZl);
                bVar2.koz = (TextView) view.findViewById(R.h.bZN);
                bVar2.koA = (TextView) view.findViewById(R.h.bZL);
                bVar2.koB = (TextView) view.findViewById(R.h.bZh);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            com.tencent.mm.plugin.scanner.util.n.a bA = i.bA(aVar.field_xmlContent, aVar.field_funcType);
            bVar.koz.setText(bA.field_title);
            bVar.koA.setText(o.c(this.oVG, aVar.field_ScanTime, true));
            bVar.koB.setText(bA.field_subtitle);
            int dimensionPixelSize = this.oVG.getResources().getDimensionPixelSize(R.f.baT);
            bVar.jki.setImageResource(R.g.bir);
            w.d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + i + " logo_url :  " + bA.field_thumburl);
            if (TextUtils.isEmpty(bA.field_thumburl)) {
                bVar.jki.setImageResource(R.g.bir);
            } else {
                String format;
                com.tencent.mm.ah.a.a.c.a aVar2 = new com.tencent.mm.ah.a.a.c.a();
                aVar2.hIO = e.hgu;
                n.GX();
                aVar2.hJg = null;
                c aXW = c.aXW();
                String str = bA.field_thumburl;
                if (ap.zb()) {
                    format = String.format("%s/scanbook_%s", new Object[]{aXW.gYf + "image/scan/img", g.n(str.getBytes())});
                } else {
                    format = "";
                }
                aVar2.hIN = format;
                aVar2.hIL = true;
                aVar2.hJi = false;
                aVar2.hIJ = true;
                aVar2.hIS = dimensionPixelSize;
                aVar2.hIR = dimensionPixelSize;
                aVar2.hJa = R.g.bir;
                n.GW().a(bA.field_thumburl, bVar.jki, aVar2.Hg());
            }
            return view;
        }
    }

    private class b {
        ImageView jki;
        TextView koA;
        TextView koB;
        TextView koz;
        final /* synthetic */ ScannerHistoryUI oVG;

        public b(ScannerHistoryUI scannerHistoryUI) {
            this.oVG = scannerHistoryUI;
        }
    }

    static /* synthetic */ void a(ScannerHistoryUI scannerHistoryUI, int i) {
        com.tencent.mm.plugin.scanner.history.a.a aVar = (com.tencent.mm.plugin.scanner.history.a.a) scannerHistoryUI.oVF.getItem(i);
        if (aVar != null) {
            Intent intent = new Intent();
            intent.setClass(scannerHistoryUI, ProductUI.class);
            intent.setFlags(65536);
            intent.putExtra("key_Product_xml", aVar.field_xmlContent);
            intent.putExtra("key_Product_funcType", aVar.field_funcType);
            intent.putExtra("key_Qrcode_Url", aVar.field_qrcodeUrl);
            intent.putExtra("key_need_add_to_history", false);
            scannerHistoryUI.startActivity(intent);
            com.tencent.mm.plugin.report.service.g.oUh.i(12684, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
        }
    }

    protected final int getLayoutId() {
        return R.i.dmW;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eOK);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ScannerHistoryUI oVG;

            {
                this.oVG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oVG.finish();
                return true;
            }
        });
        this.Fg = (ListView) findViewById(R.h.czS);
        this.koV = (LinearLayout) View.inflate(getBaseContext(), R.i.dmV, null);
        this.Fg.addHeaderView(this.koV);
        this.oVF = new a(this);
        this.Fg.setAdapter(this.oVF);
        this.Fg.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ScannerHistoryUI oVG;

            {
                this.oVG = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    w.v("MicroMsg.ScannerHistoryUI", "onItemClick pos is 0, click headerview");
                    return;
                }
                if (i > 0) {
                    i--;
                }
                ScannerHistoryUI.a(this.oVG, i);
            }
        });
        this.Fg.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ ScannerHistoryUI oVG;

            {
                this.oVG = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    w.i("MicroMsg.ScannerHistoryUI", "onItemLongClick pos is 0");
                } else {
                    if (i > 0) {
                        i--;
                    }
                    if (i < this.oVG.oVF.getCount()) {
                        com.tencent.mm.ui.base.g.a(this.oVG, this.oVG.getResources().getString(R.l.dRu), null, this.oVG.getResources().getString(R.l.dGB), new com.tencent.mm.ui.base.g.c(this.oVG, i) {
                            final /* synthetic */ ScannerHistoryUI oVG;

                            public final void hq(int i) {
                                switch (i) {
                                    case 0:
                                        com.tencent.mm.plugin.scanner.history.a.a aVar = (com.tencent.mm.plugin.scanner.history.a.a) this.oVG.oVF.getItem(r5);
                                        if (aVar != null) {
                                            c.aXX().a(aVar, new String[0]);
                                            this.oVG.agB();
                                            this.oVG.oVF.a(null, null);
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                    }
                }
                return true;
            }
        });
        a(0, getString(R.l.dQu), new OnMenuItemClickListener(this) {
            final /* synthetic */ ScannerHistoryUI oVG;

            {
                this.oVG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.g.a(this.oVG, true, this.oVG.getString(R.l.eOJ), "", this.oVG.getString(R.l.dHT), this.oVG.getString(R.l.dGs), new OnClickListener(this.oVG) {
                    final /* synthetic */ ScannerHistoryUI oVG;

                    {
                        this.oVG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        c.aXX().gUz.eE("ScanHistoryItem", "delete from ScanHistoryItem");
                        this.oVG.agB();
                        this.oVG.oVF.a(null, null);
                    }
                }, new OnClickListener(this.oVG) {
                    final /* synthetic */ ScannerHistoryUI oVG;

                    {
                        this.oVG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return true;
            }
        });
        this.jAA = findViewById(R.h.bGB);
        this.koW = View.inflate(this, R.i.dmU, null);
        if (this.koV != null) {
            this.koV.addView(this.koW);
        }
        this.koX = (TextView) this.koW.findViewById(R.h.bWm);
        this.koX.setText(R.l.esp);
        agB();
    }

    private void agB() {
        if (c.aXX().getCount() > 0) {
            this.Fg.setVisibility(0);
            this.jAA.setVisibility(8);
            this.koW.setVisibility(0);
            kr(true);
        } else {
            this.Fg.setVisibility(8);
            this.jAA.setVisibility(0);
            this.koW.setVisibility(8);
            kr(false);
        }
        this.oVF.notifyDataSetChanged();
    }
}
