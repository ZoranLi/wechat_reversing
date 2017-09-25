package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.wallet.a.b;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class e extends BaseAdapter {
    private Context mContext;
    private Orders oSJ = null;
    private int rKF = -1;
    public String rKG = "";
    public boolean rKH = true;
    private boolean rKI = false;
    public ArrayList<Bankcard> ruj;
    private com.tencent.mm.plugin.wallet_core.d.a rwv;
    private int rzc;

    class a {
        public TextView ioX;
        public TextView ouW;
        final /* synthetic */ e rKJ;
        public FavourLayout rKK;
        public CheckedTextView rKL;
        public ImageView rKM;

        a(e eVar) {
            this.rKJ = eVar;
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return vs(i);
    }

    public e(Context context, ArrayList<Bankcard> arrayList, int i, Orders orders) {
        this.mContext = context;
        this.ruj = arrayList;
        this.rzc = i;
        this.oSJ = orders;
        this.rwv = new com.tencent.mm.plugin.wallet_core.d.a();
        this.rwv.b(this.mContext, this.ruj);
        if (orders != null && orders.rGm == 1) {
            this.rKI = true;
        }
    }

    public int getCount() {
        int i = 0;
        if (!this.rKI) {
            if (this.oSJ == null || !this.oSJ.rGa.equals("CFT")) {
                i = 1;
            }
            return this.ruj != null ? i + this.ruj.size() : i;
        } else if (this.ruj == null) {
            return 0;
        } else {
            return this.ruj.size();
        }
    }

    public Bankcard vs(int i) {
        if (this.rKI) {
            return (Bankcard) this.ruj.get(i);
        }
        int count = getCount();
        if (this.oSJ == null || !this.oSJ.rGa.equals("CFT")) {
            count--;
        }
        if (i < count) {
            return (Bankcard) this.ruj.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean isEnabled(int i) {
        Bankcard vs = vs(i);
        if (vs == null || vs.a(this.rzc, this.oSJ) == 0) {
            return true;
        }
        return false;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.dqs, null);
            aVar = new a(this);
            aVar.ioX = (TextView) view.findViewById(R.h.title);
            aVar.ouW = (TextView) view.findViewById(R.h.summary);
            aVar.rKL = (CheckedTextView) view.findViewById(R.h.bCd);
            aVar.rKM = (ImageView) view.findViewById(R.h.brY);
            aVar.rKK = (FavourLayout) view.findViewById(R.h.bPl);
            aVar.ouW.setText("");
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.ouW.setTextColor(ab.getResources().getColor(R.e.aUo));
        aVar.rKK.setVisibility(8);
        Bankcard vs = vs(i);
        LinkedList linkedList;
        if (vs == null) {
            aVar.rKL.setVisibility(4);
            aVar.ouW.setVisibility(8);
            aVar.ioX.setText(R.l.fie);
            aVar.rKM.setVisibility(8);
            LinkedList linkedList2 = new LinkedList();
            if (!(this.oSJ == null || this.oSJ.rGf == null || this.oSJ.rGf.rya == null)) {
                j jVar = this.oSJ.rGf.rya.rxF;
                if (jVar != null) {
                    Iterator it = jVar.ryg.iterator();
                    while (it.hasNext()) {
                        linkedList2.add(((k) it.next()).rxH);
                    }
                    linkedList = linkedList2;
                    if (this.rKH && linkedList.size() > 0) {
                        aVar.rKK.setVisibility(0);
                        aVar.ouW.setVisibility(8);
                        aVar.rKK.ao(linkedList);
                    }
                }
            }
            linkedList = linkedList2;
            aVar.rKK.setVisibility(0);
            aVar.ouW.setVisibility(8);
            aVar.rKK.ao(linkedList);
        } else {
            aVar.rKM.setVisibility(0);
            aVar.rKL.setVisibility(0);
            aVar.ouW.setVisibility(0);
            aVar.ouW.setText("");
            aVar.ioX.setText(vs.field_desc);
            if (vs.btA()) {
                Bankcard bankcard = m.btS().ruN;
                if (!bg.mA(bankcard.rEi)) {
                    aVar.ioX.setText(bankcard.rEi);
                } else if (bankcard.rEh >= 0.0d) {
                    aVar.ioX.setText(this.mContext.getString(com.tencent.mm.u.m.xY() ? R.l.feS : R.l.feR, new Object[]{com.tencent.mm.wallet_core.ui.e.o(bankcard.rEh)}));
                } else {
                    aVar.ioX.setText(this.mContext.getText(R.l.ffS));
                }
            } else if (vs.btB()) {
                Bankcard bankcard2 = m.btS().rIq;
                if (!bg.mA(bankcard2.rEi)) {
                    aVar.ioX.setText(bankcard2.rEi);
                } else if (bankcard2.rEh >= 0.0d) {
                    aVar.ioX.setText(this.mContext.getString(R.l.fgo, new Object[]{com.tencent.mm.wallet_core.ui.e.o(bankcard2.rEh)}));
                } else {
                    aVar.ioX.setText(this.mContext.getText(R.l.ffS));
                }
            }
            aVar.ouW.setVisibility(0);
            switch (vs.a(this.rzc, this.oSJ)) {
                case 1:
                    aVar.ouW.setText(R.l.fih);
                    break;
                case 2:
                    aVar.ouW.setText(R.l.fin);
                    break;
                case 3:
                    aVar.ouW.setText(R.l.fis);
                    break;
                case 4:
                    aVar.ouW.setText(R.l.fij);
                    break;
                case 5:
                    aVar.ouW.setText(R.l.fif);
                    break;
                case 6:
                    aVar.ouW.setText(R.l.fil);
                    break;
                case 7:
                    aVar.ouW.setText(R.l.fiq);
                    break;
                case 8:
                    aVar.ouW.setText(vs.field_forbidWord);
                    break;
                default:
                    if (!bg.mA(vs.field_tips)) {
                        aVar.ouW.setText(vs.field_tips);
                        break;
                    }
                    aVar.ouW.setVisibility(8);
                    break;
            }
            String charSequence = aVar.ouW.getText().toString();
            aVar.ioX.setTextColor(this.mContext.getResources().getColor(R.e.aVo));
            if (this.rKG.equalsIgnoreCase(vs.field_bindSerial)) {
                aVar.rKL.setChecked(true);
                aVar.rKL.setEnabled(true);
            } else if (isEnabled(i)) {
                aVar.rKL.setChecked(false);
                aVar.rKL.setEnabled(true);
            } else {
                aVar.rKL.setEnabled(false);
                aVar.rKL.setChecked(false);
                aVar.ioX.setTextColor(this.mContext.getResources().getColor(R.e.aUo));
            }
            aVar.rKM.setTag(R.h.cQi, null);
            aVar.rKM.setTag(null);
            aVar.rKM.setImageDrawable(null);
            aVar.ouW.setOnClickListener(null);
            if (vs.btA()) {
                ImageView imageView = aVar.rKM;
                if (imageView != null) {
                    imageView.setTag(R.h.cQi, null);
                    imageView.setImageResource(R.g.blG);
                }
            } else if (vs.btB()) {
                this.rwv.a(vs, aVar.rKM);
            } else {
                this.rwv.a(this.mContext, vs, aVar.rKM);
            }
            if (!bg.mA(vs.field_forbid_title) && !bg.mA(vs.field_forbid_url)) {
                charSequence = charSequence + "  ";
                CharSequence spannableString = new SpannableString(charSequence + vs.field_forbid_title);
                aVar.ouW.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ e rKJ;

                    {
                        this.rKJ = r1;
                    }

                    public final void onClick(View view) {
                        if (view.getTag() instanceof String) {
                            Intent intent = new Intent();
                            w.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", new Object[]{(String) view.getTag()});
                            intent.putExtra("rawUrl", r0);
                            intent.putExtra("geta8key_username", com.tencent.mm.u.m.xL());
                            intent.putExtra("pay_channel", 1);
                            d.b(this.rKJ.mContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, WalletChangeBankcardUI.ryZ);
                        }
                    }
                });
                spannableString.setSpan(new ForegroundColorSpan(ab.getResources().getColor(R.e.aWi)), charSequence.length(), charSequence.length() + vs.field_forbid_title.length(), 34);
                aVar.ouW.setText(spannableString);
                aVar.ouW.setTag(vs.field_forbid_url);
            } else if (this.rKH && bg.mA(vs.field_forbidWord) && bg.mA(charSequence)) {
                linkedList = e(vs);
                if (linkedList.size() > 0) {
                    aVar.rKK.setVisibility(0);
                    aVar.ouW.setVisibility(8);
                    aVar.rKK.ao(linkedList);
                }
            }
        }
        return view;
    }

    private LinkedList<String> e(Bankcard bankcard) {
        LinkedList<String> linkedList = new LinkedList();
        if (!(this.oSJ == null || this.oSJ.rGf == null || this.oSJ.rGf.rya == null)) {
            Iterator it = this.oSJ.rGf.rya.rxE.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.ofe.equals(bankcard.field_bindSerial)) {
                    it = bVar.rxG.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((c) it.next()).rxH);
                    }
                    return linkedList;
                }
            }
        }
        return linkedList;
    }

    public final void e(ArrayList<Bankcard> arrayList, boolean z) {
        if (arrayList == null) {
            this.ruj = new ArrayList();
        } else {
            this.ruj = arrayList;
        }
        this.rKH = z;
        if (this.ruj.size() > 0) {
            this.rwv.b(this.mContext, this.ruj);
        }
        notifyDataSetChanged();
    }
}
