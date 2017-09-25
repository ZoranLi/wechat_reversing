package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.balance.a.a.i;
import com.tencent.mm.plugin.wallet.balance.a.a.j;
import com.tencent.mm.plugin.wallet.balance.a.a.k;
import com.tencent.mm.plugin.wallet.balance.a.a.l;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletLqtSaveFetchUI extends WalletLqtBasePresenterUI {
    private Dialog ipg;
    private int mode;
    private i rtS = ((i) p(i.class));
    private j rtT = ((j) m(j.class));
    private k rvL = new k(this.rtS, this.rtT, this);
    private l rvM = new l(this.rvL);
    private ViewGroup rvN;
    private WalletFormView rvO;
    private TextView rvP;
    private TextView rvQ;
    private Button rvR;
    private TextView rvS;
    private ViewGroup rvT;
    private TextView rvU;
    private CheckBox rvV;
    private CharSequence rvW;
    private Bankcard rvX;
    private int rvY;
    private String rvZ;
    private String rwa;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rvO = (WalletFormView) findViewById(R.h.cdj);
        this.rvR = (Button) findViewById(R.h.cnY);
        this.rvS = (TextView) findViewById(R.h.cdi);
        this.rvP = (TextView) findViewById(R.h.cdk);
        this.rvQ = (TextView) findViewById(R.h.cdl);
        this.rvT = (ViewGroup) findViewById(R.h.cdm);
        this.rvU = (TextView) findViewById(R.h.cdo);
        this.rvV = (CheckBox) findViewById(R.h.cdn);
        this.rvN = (ViewGroup) findViewById(R.h.cgO);
        a(this.rvO, 2, false, false);
        this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
        this.rvY = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
        this.rvZ = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
        this.rwa = getIntent().getStringExtra("lqt_profile_wording");
        if (this.mode == 1) {
            this.rvP.setText(getString(R.l.fgE));
            this.rvR.setText(R.l.fgI);
            this.rvQ.setText(getString(R.l.fgG));
        } else if (this.mode == 2) {
            this.rvP.setText(getString(R.l.fgs));
            this.rvR.setText(R.l.fgz);
            this.rvQ.setText(getString(R.l.fgu));
        }
        this.rvO.a(new TextWatcher(this) {
            final /* synthetic */ WalletLqtSaveFetchUI rwb;

            {
                this.rwb = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, "0");
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                } else if (indexOf > 12) {
                    editable.delete(12, indexOf);
                } else if (indexOf == -1 && length > 12) {
                    editable.delete(12, length);
                }
                double d = bg.getDouble(editable.toString(), 0.0d);
                if (d <= 0.0d) {
                    this.rwb.rvS.setText(this.rwb.rvW);
                    this.rwb.rvS.setTextColor(Color.parseColor("#888888"));
                    this.rwb.rvR.setEnabled(false);
                } else if (this.rwb.mode == 1) {
                    if (this.rwb.rvX == null || d <= this.rwb.rvX.rEh) {
                        this.rwb.rvS.setText(this.rwb.rvW);
                        this.rwb.rvS.setTextColor(Color.parseColor("#888888"));
                        this.rwb.rvR.setEnabled(true);
                        return;
                    }
                    this.rwb.rvS.setText(this.rwb.getString(R.l.fgF));
                    this.rwb.rvS.setTextColor(-65536);
                    this.rwb.rvR.setEnabled(false);
                } else if (this.rwb.mode != 2) {
                } else {
                    if (d > ((double) this.rwb.getIntent().getIntExtra("lqt_balance", 0)) / 100.0d) {
                        this.rwb.rvS.setText(this.rwb.getString(R.l.fgt));
                        this.rwb.rvS.setTextColor(-65536);
                        this.rwb.rvR.setEnabled(false);
                    } else if (this.rwb.rvY <= 0 || d * 100.0d <= ((double) this.rwb.rvY)) {
                        this.rwb.rvS.setText(this.rwb.rvW);
                        this.rwb.rvS.setTextColor(Color.parseColor("#888888"));
                        this.rwb.rvR.setEnabled(true);
                    } else {
                        this.rwb.rvS.setText(this.rwb.rvZ);
                        this.rwb.rvS.setTextColor(-65536);
                        this.rwb.rvR.setEnabled(false);
                    }
                }
            }
        });
        this.rvR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletLqtSaveFetchUI rwb;

            {
                this.rwb = r1;
            }

            public final void onClick(View view) {
                final int i = (int) (bg.getDouble(this.rwb.rvO.getText(), 0.0d) * 100.0d);
                if (i <= 0) {
                    return;
                }
                if (this.rwb.mode == 1) {
                    g.bN(Integer.valueOf(i)).a(this.rwb.rvM.ruc).d(new a<Void, aso>(this) {
                        final /* synthetic */ AnonymousClass7 rwg;

                        public final /* synthetic */ Object call(Object obj) {
                            aso com_tencent_mm_protocal_c_aso = (aso) obj;
                            w.i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aso.tWU)});
                            Intent intent = new Intent(this.rwg.rwb, WalletLqtSaveFetchFinishUI.class);
                            intent.putExtra("key_amount", ((double) i) / 100.0d);
                            intent.putExtra("key_mode", 1);
                            intent.putExtra("profile_date_wording", com_tencent_mm_protocal_c_aso.tWW);
                            intent.putExtra("profile_upgrade_wording", com_tencent_mm_protocal_c_aso.tWV);
                            this.rwg.rwb.startActivity(intent);
                            this.rwg.rwb.finish();
                            return wCE;
                        }
                    }).a(new d.a(this) {
                        final /* synthetic */ AnonymousClass7 rwg;

                        {
                            this.rwg = r1;
                        }

                        public final void aD(Object obj) {
                            w.i("MicroMsg.WalletLqtSaveFetchUI", "save failed: %s", new Object[]{obj});
                            this.rwg.rwb.aCP();
                            if (obj != null) {
                                String obj2;
                                if (obj instanceof String) {
                                    obj2 = obj.toString();
                                } else {
                                    obj2 = this.rwg.rwb.getString(R.l.fgB);
                                }
                                this.rwg.rwb.Dg(obj2);
                            }
                        }
                    });
                } else if (this.rwb.mode == 2) {
                    g.bN(Integer.valueOf(i)).a(this.rwb.rvM.rud).d(new a<Void, aui>(this) {
                        final /* synthetic */ AnonymousClass7 rwg;

                        public final /* synthetic */ Object call(Object obj) {
                            w.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s", new Object[]{(aui) obj});
                            Intent intent = new Intent(this.rwg.rwb, WalletLqtSaveFetchFinishUI.class);
                            intent.putExtra("key_amount", ((double) i) / 100.0d);
                            intent.putExtra("key_mode", 2);
                            this.rwg.rwb.startActivity(intent);
                            this.rwg.rwb.finish();
                            return wCE;
                        }
                    }).a(new d.a(this) {
                        final /* synthetic */ AnonymousClass7 rwg;

                        {
                            this.rwg = r1;
                        }

                        public final void aD(Object obj) {
                            this.rwg.rwb.aCP();
                            if (obj != null) {
                                String obj2;
                                if (obj instanceof String) {
                                    obj2 = obj.toString();
                                } else {
                                    obj2 = this.rwg.rwb.getString(R.l.fgB);
                                }
                                this.rwg.rwb.Dg(obj2);
                            }
                        }
                    });
                }
            }
        });
        if (!bg.mA(this.rwa)) {
            TextView textView = (TextView) findViewById(R.h.cdg);
            textView.setText(this.rwa);
            textView.setVisibility(0);
        }
        this.rvS.setText("");
        this.rvS.setClickable(true);
        this.rvS.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k(this));
        this.rvR.setEnabled(false);
        String string;
        int length;
        CharSequence spannableString;
        if (this.mode == 1) {
            this.rvN.setVisibility(4);
            qP(getString(R.l.fgI));
            final ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("lqt_protocol_list");
            boolean booleanExtra = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0 || !booleanExtra) {
                this.rvT.setVisibility(8);
            } else {
                this.rvT.setVisibility(0);
                this.rvV.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
                this.rvT.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WalletLqtSaveFetchUI rwb;

                    {
                        this.rwb = r1;
                    }

                    public final void onClick(View view) {
                        this.rwb.rvV.setChecked(!this.rwb.rvV.isChecked());
                    }
                });
                this.rvV.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
                    final /* synthetic */ WalletLqtSaveFetchUI rwb;

                    {
                        this.rwb = r1;
                    }

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        if (z) {
                            this.rwb.rvR.setEnabled(true);
                        } else {
                            this.rwb.rvR.setEnabled(false);
                        }
                    }
                });
                string = getString(R.l.fgC);
                length = string.length();
                spannableString = new SpannableString(string + getString(R.l.fgD));
                spannableString.setSpan(new a(new a.a(this) {
                    final /* synthetic */ WalletLqtSaveFetchUI rwb;

                    public final void NZ() {
                        e eVar = new e(this.rwb, e.wuP, false);
                        eVar.qJf = new c(this) {
                            final /* synthetic */ AnonymousClass5 rwf;

                            {
                                this.rwf = r1;
                            }

                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                Iterator it = stringArrayListExtra.iterator();
                                int i = 0;
                                while (it.hasNext()) {
                                    lVar.add(0, i, 0, ((String) it.next()).split("\\|\\|")[0]);
                                    i++;
                                }
                            }
                        };
                        eVar.qJg = new n.d(this) {
                            final /* synthetic */ AnonymousClass5 rwf;

                            {
                                this.rwf = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                int itemId = menuItem.getItemId();
                                if (itemId < stringArrayListExtra.size()) {
                                    com.tencent.mm.wallet_core.ui.e.m(this.rwf.rwb, ((String) stringArrayListExtra.get(itemId)).split("\\|\\|")[1], false);
                                }
                            }
                        };
                        eVar.bzh();
                    }
                }), length, spannableString.length(), 17);
                this.rvU.setText(spannableString);
                this.rvU.setClickable(true);
                this.rvU.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
            }
            g.cbJ().a(this.rvM.rue).d(new a<Void, Void>(this) {
                final /* synthetic */ WalletLqtSaveFetchUI rwb;

                {
                    this.rwb = r1;
                }

                public final /* synthetic */ Object call(Object obj) {
                    o.bsC();
                    this.rwb.rvX = o.bsD().ruN;
                    if (this.rwb.rvX != null) {
                        String string = this.rwb.getString(R.l.fgm, new Object[]{Double.valueOf(this.rwb.rvX.rEh)});
                        int length = string.length();
                        CharSequence spannableString = new SpannableString(string + this.rwb.getString(R.l.fgn));
                        spannableString.setSpan(new a(new a.a(this) {
                            final /* synthetic */ AnonymousClass1 rwc;

                            {
                                this.rwc = r1;
                            }

                            public final void NZ() {
                                this.rwc.rwb.rvO.setText(com.tencent.mm.wallet_core.ui.e.n(this.rwc.rwb.rvX.rEh));
                            }
                        }), length, spannableString.length(), 18);
                        this.rwb.rvW = spannableString;
                        this.rwb.rvS.setText(spannableString);
                    }
                    this.rwb.rvN.setVisibility(0);
                    return wCE;
                }
            });
        } else if (this.mode == 2) {
            this.rvT.setVisibility(8);
            qP(getString(R.l.fgA));
            final int intExtra = getIntent().getIntExtra("lqt_balance", 0);
            if (intExtra > 0) {
                string = getString(R.l.fgw, new Object[]{Double.valueOf(((double) intExtra) / 100.0d)});
                length = string.length();
                spannableString = new SpannableString(string + getString(R.l.fgx));
                spannableString.setSpan(new a(new a.a(this) {
                    final /* synthetic */ WalletLqtSaveFetchUI rwb;

                    public final void NZ() {
                        this.rwb.rvO.setText(com.tencent.mm.wallet_core.ui.e.n(((double) intExtra) / 100.0d));
                    }
                }), length, spannableString.length(), 18);
                this.rvW = spannableString;
                this.rvS.setText(spannableString);
            }
        }
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.dqL;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        k kVar = this.rvL;
        if (i == k.rtQ && i2 == -1) {
            Orders orders = (Orders) intent.getParcelableExtra("key_orders");
            if (orders != null && orders.rGe != null && orders.rGe.size() > 0) {
                kVar.fTA = ((Commodity) orders.rGe.get(0)).fTA;
                kVar.rtU.SU();
                g.a(kVar.rtV, kVar.fTA, Integer.valueOf(kVar.rtW)).a(kVar.rtT.rtM).d(new a<Void, aso>(kVar) {
                    final /* synthetic */ k rua;

                    {
                        this.rua = r1;
                    }

                    public final /* synthetic */ Object call(Object obj) {
                        aso com_tencent_mm_protocal_c_aso = (aso) obj;
                        this.rua.rtU.aCP();
                        if (this.rua.ink != null) {
                            this.rua.ink.s(new Object[]{com_tencent_mm_protocal_c_aso});
                        }
                        return wCE;
                    }
                }).a(new d.a(kVar) {
                    final /* synthetic */ k rua;

                    {
                        this.rua = r1;
                    }

                    public final void aD(Object obj) {
                        this.rua.rtU.aCP();
                        if (this.rua.ink != null) {
                            this.rua.ink.bJ(obj);
                        }
                    }
                });
            }
        } else if (i == k.rtR && i2 == -1) {
            String stringExtra = intent.getStringExtra("lqt_fetch_enc_pwd");
            kVar.rtU.SU();
            a aVar = kVar.rtT.rtN;
            int i3 = kVar.rtX;
            g.a(Integer.valueOf(i3), stringExtra, kVar.rtY).a(aVar).d(new a<Void, aui>(kVar) {
                final /* synthetic */ k rua;

                {
                    this.rua = r1;
                }

                public final /* synthetic */ Object call(Object obj) {
                    aui com_tencent_mm_protocal_c_aui = (aui) obj;
                    this.rua.rtU.aCP();
                    if (this.rua.ink != null) {
                        this.rua.ink.s(new Object[]{com_tencent_mm_protocal_c_aui});
                    }
                    return wCE;
                }
            }).a(new d.a(kVar) {
                final /* synthetic */ k rua;

                {
                    this.rua = r1;
                }

                public final void aD(Object obj) {
                    this.rua.rtU.aCP();
                    if (this.rua.ink != null) {
                        this.rua.ink.bJ(obj);
                    }
                }
            });
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        k kVar2 = this.rvL;
        if (kVar instanceof m) {
            o.bsC();
            kVar2.rtZ = o.bsD().ruN;
            if (kVar2.ink != null) {
                kVar2.ink.resume();
            }
        }
        return super.d(i, i2, str, kVar);
    }

    public final void SU() {
        if (this.ipg == null) {
            this.ipg = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        } else {
            this.ipg.show();
        }
    }

    public final void aCP() {
        if (this.ipg != null) {
            this.ipg.dismiss();
        }
    }

    public final void Dg(String str) {
        Toast.makeText(this, str, 1).show();
    }

    public void onDestroy() {
        super.onDestroy();
        this.rvL = null;
        this.rvM = null;
    }
}
