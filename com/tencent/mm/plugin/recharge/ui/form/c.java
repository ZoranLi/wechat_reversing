package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.List;

public final class c {
    public static String TAG = "MicroMsg.CommonHintViewConfig";

    public static class b {
        public List<String[]> oLF;
        public com.tencent.mm.plugin.recharge.model.a oLG = null;
        public MallFormView oNm = null;
        public d oNn;
        public boolean oNo = false;

        class AnonymousClass3 implements OnItemClickListener {
            final /* synthetic */ b oNp;
            final /* synthetic */ InstantAutoCompleteTextView oNq;

            public AnonymousClass3(b bVar, InstantAutoCompleteTextView instantAutoCompleteTextView) {
                this.oNp = bVar;
                this.oNq = instantAutoCompleteTextView;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.oNp.oLG = this.oNp.oNn.rN(i);
                if (this.oNp.oLG != null) {
                    w.i(c.TAG, "onItemClick record.record " + this.oNp.oLG.oKT + ", record.name " + this.oNp.oLG.name);
                    this.oNp.oNo = true;
                    this.oNp.b(this.oNp.oLG);
                } else {
                    w.w(c.TAG, "record is null");
                }
                this.oNq.dismissDropDown();
            }
        }

        class AnonymousClass4 implements OnFocusChangeListener {
            final /* synthetic */ b oNp;
            final /* synthetic */ InstantAutoCompleteTextView oNq;

            public AnonymousClass4(b bVar, InstantAutoCompleteTextView instantAutoCompleteTextView) {
                this.oNp = bVar;
                this.oNq = instantAutoCompleteTextView;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.oNq.setHintTextColor(view.getContext().getResources().getColor(R.e.aTr));
                    if (this.oNp.oLG != null && this.oNp.oLG.fFq == 2 && !this.oNp.oNo) {
                        w.d(c.TAG, "clear input");
                        this.oNp.oNm.aWw();
                        this.oNp.oLG = null;
                    } else if (this.oNp.oNo) {
                        this.oNp.oNo = false;
                    }
                    if (bg.mA(this.oNq.getText().toString())) {
                        this.oNq.showDropDown();
                    }
                }
            }
        }

        class AnonymousClass5 implements OnClickListener {
            final /* synthetic */ b oNp;
            final /* synthetic */ InstantAutoCompleteTextView oNq;

            public AnonymousClass5(b bVar, InstantAutoCompleteTextView instantAutoCompleteTextView) {
                this.oNp = bVar;
                this.oNq = instantAutoCompleteTextView;
            }

            public final void onClick(View view) {
                this.oNq.requestFocus();
            }
        }

        public b(MallFormView mallFormView) {
            this.oNm = mallFormView;
        }

        public final void b(com.tencent.mm.plugin.recharge.model.a aVar) {
            this.oLG = aVar;
            if (aVar != null) {
                if (bg.mA(this.oNm.getText()) || !this.oNm.getText().equals(aVar.oKT)) {
                    this.oNm.oNs.setText(com.tencent.mm.plugin.recharge.model.b.Dj(aVar.oKT));
                }
                this.oNm.oNs.setSelection(this.oNm.oNs.getText().length());
                w.d(c.TAG, "editTv.setText %s, name: %s, location: %s, type: %s", new Object[]{aVar.oKT, aVar.name, aVar.oKU, Integer.valueOf(aVar.fFq)});
                Context context = this.oNm.getContext();
                if (this.oLG.fFq == 3) {
                    this.oNm.oNu.setText(this.oLG.name);
                    this.oNm.oNu.setTextColor(context.getResources().getColor(R.e.aVA));
                    return;
                } else if (this.oLG.fFq == 1) {
                    CharSequence string;
                    if (bg.mA(this.oLG.name)) {
                        string = context.getString(R.l.fjH);
                        if (!bg.mA(this.oLG.oKU)) {
                            string = string + context.getString(R.l.fjz, new Object[]{this.oLG.oKU});
                        }
                        this.oNm.oNu.setText(string);
                        this.oNm.oNu.setTextColor(context.getResources().getColor(R.e.aVw));
                        return;
                    }
                    string = this.oLG.name;
                    if (!bg.mA(this.oLG.oKU)) {
                        string = string + context.getString(R.l.fjz, new Object[]{this.oLG.oKU});
                    }
                    this.oNm.oNu.setText(string);
                    this.oNm.oNu.setTextColor(context.getResources().getColor(R.e.aVo));
                    return;
                } else if (this.oLG.fFq == 2) {
                    if (bg.mA(this.oLG.oKU)) {
                        this.oNm.oNu.setText("");
                        this.oNm.oNu.setTextColor(context.getResources().getColor(R.e.aVw));
                        return;
                    }
                    this.oNm.oNu.setText(this.oLG.oKU);
                    this.oNm.oNu.setTextColor(context.getResources().getColor(R.e.aVo));
                    return;
                } else if (this.oLG.fFq != 0) {
                    return;
                } else {
                    if (bg.mA(this.oLG.oKU)) {
                        if (bg.mA(this.oLG.name)) {
                            this.oNm.oNu.setText("");
                            this.oNm.oNu.setTextColor(context.getResources().getColor(R.e.aVo));
                            return;
                        }
                        this.oNm.oNu.setText(this.oLG.name);
                        this.oNm.oNu.setTextColor(context.getResources().getColor(R.e.aVw));
                        return;
                    } else if (bg.mA(this.oLG.name)) {
                        this.oNm.oNu.setText(this.oLG.oKU);
                        this.oNm.oNu.setTextColor(context.getResources().getColor(R.e.aVo));
                        return;
                    } else {
                        this.oNm.oNu.setText(this.oLG.name + context.getString(R.l.fjz, new Object[]{this.oLG.oKU}));
                        this.oNm.oNu.setTextColor(context.getResources().getColor(R.e.aVw));
                        return;
                    }
                }
            }
            this.oNm.oNs.setText("");
            w.d(c.TAG, "editTv.setText null");
            this.oNm.oNu.setText("");
        }

        public final void gB(boolean z) {
            List list;
            w.d(c.TAG, "needSetInput: %s", new Object[]{Boolean.valueOf(z)});
            List aWe = com.tencent.mm.plugin.recharge.a.a.aWd().aWe();
            String str;
            if (aWe == null) {
                List arrayList = new ArrayList();
                Context context = this.oNm.getContext();
                ap.yY();
                str = (String) com.tencent.mm.u.c.vr().get(6, null);
                com.tencent.mm.plugin.recharge.model.a aVar = !bg.mA(str) ? new com.tencent.mm.plugin.recharge.model.a(str, context.getString(R.l.fjF), 1) : null;
                if (aVar != null) {
                    arrayList.add(aVar);
                    com.tencent.mm.plugin.recharge.a.a.aWd().a(aVar);
                }
                list = arrayList;
            } else {
                ap.yY();
                str = (String) com.tencent.mm.u.c.vr().get(6, null);
                for (int i = 0; i < aWe.size(); i++) {
                    com.tencent.mm.plugin.recharge.model.a aVar2 = (com.tencent.mm.plugin.recharge.model.a) aWe.get(i);
                    if (bg.mA(aVar2.oKT) || !aVar2.oKT.equals(str)) {
                        if (!(bg.mA(aVar2.oKT) || !bg.mA(aVar2.name) || this.oLF == null)) {
                            for (String[] strArr : this.oLF) {
                                if (aVar2.oKT.equals(com.tencent.mm.plugin.recharge.model.b.Di(strArr[2]))) {
                                    aVar2.name = strArr[1];
                                    w.i(c.TAG, "add name: %s", new Object[]{strArr[1]});
                                    break;
                                }
                            }
                        }
                    } else if (bg.mA(aVar2.name) || !aVar2.name.equals(this.oNm.getContext().getString(R.l.fjF))) {
                        aVar2.name = this.oNm.getContext().getString(R.l.fjF);
                    } else {
                    }
                    com.tencent.mm.plugin.recharge.a.a.aWd().bf(aWe);
                }
                list = aWe;
            }
            this.oNn.bf(list);
            if (list != null && list.size() > 0 && z) {
                this.oLG = (com.tencent.mm.plugin.recharge.model.a) list.get(0);
                b(this.oLG);
            }
        }
    }

    private static class a implements b {
        public boolean a(MallFormView mallFormView) {
            return true;
        }

        public boolean aWt() {
            return false;
        }

        public String Dn(String str) {
            return null;
        }
    }

    public static void b(MallFormView mallFormView) {
        if (mallFormView == null) {
            w.e(TAG, "hy: param error");
        } else {
            mallFormView.oNz = new a() {
                public final boolean a(MallFormView mallFormView) {
                    return PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.Di(mallFormView.getText().toString()));
                }

                public final boolean aWt() {
                    return true;
                }

                public final String Dn(String str) {
                    return str == null ? "" : str.replaceAll(" ", "");
                }
            };
        }
    }
}
