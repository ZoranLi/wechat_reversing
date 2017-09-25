package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.a.c.d;
import com.tencent.mm.plugin.aa.a.c.e;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.protocal.c.y;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LaunchAAUI extends BaseAAPresenterActivity {
    private String chatroomName = null;
    private TextView ioZ;
    private Dialog ipg;
    private e iqC = ((e) m(e.class));
    private d iqD = this.iqC.NY();
    private boolean iqE = false;
    private MMEditText iqF;
    private TextView iqG;
    private TextView iqH;
    private TextView iqI;
    private TextView iqJ;
    private WalletFormView iqK;
    private TextView iqL;
    private TextView iqM;
    private ViewGroup iqN;
    private ViewGroup iqO;
    private List<String> iqP = new ArrayList();
    private ViewGroup iqQ;
    private ViewGroup iqR;
    private TextView iqS;
    private ViewGroup iqT;
    private Map<String, Double> iqU = new HashMap();
    private Map<String, LaunchAAByPersonNameAmountRow> iqV = new HashMap();
    private Button iqW;
    private TextView iqX;
    private TextView iqY;
    private com.tencent.mm.plugin.aa.a.d iqZ = new com.tencent.mm.plugin.aa.a.d();
    private boolean iqm = false;
    private int ira = 0;
    private int irb = 0;
    private boolean irc = false;
    private int mode = a.imL;
    private long timestamp = 0;

    static /* synthetic */ void a(LaunchAAUI launchAAUI) {
        com.tencent.mm.pluginsdk.ui.applet.d.a aVar = new com.tencent.mm.pluginsdk.ui.applet.d.a(launchAAUI.uSU.uTo);
        String obj = launchAAUI.iqF.getText().toString();
        if (bg.mA(obj)) {
            obj = launchAAUI.getString(R.l.evY);
        }
        com.tencent.mm.pluginsdk.ui.applet.d.a c = aVar.bs(launchAAUI.chatroomName).MP(launchAAUI.getString(R.l.dBb) + obj).c(Boolean.valueOf(false));
        c.sMr = launchAAUI.getString(R.l.dBa);
        c.a(new k.a(launchAAUI) {
            final /* synthetic */ LaunchAAUI ird;

            {
                this.ird = r1;
            }

            public final void a(boolean z, String str, int i) {
                if (z) {
                    LaunchAAUI.j(this.ird);
                }
            }
        }).oHT.show();
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, String str, final String str2) {
        launchAAUI.iqY.setVisibility(0);
        launchAAUI.iqY.startAnimation(AnimationUtils.loadAnimation(launchAAUI, R.a.aRf));
        launchAAUI.iqY.setText(str);
        launchAAUI.iqY.setOnClickListener(new OnClickListener(launchAAUI) {
            final /* synthetic */ LaunchAAUI ird;

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                com.tencent.mm.bb.d.b(this.ird.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, List list) {
        Intent intent = new Intent(launchAAUI, AASelectContactUI.class);
        intent.putExtra("titile", launchAAUI.getString(R.l.ewb));
        intent.putExtra("list_type", 12);
        intent.putExtra("chatroomName", launchAAUI.chatroomName);
        if (list != null) {
            intent.putExtra("already_select_contact", bg.c(list, ","));
        }
        intent.putExtra("max_select_num", o.dH(launchAAUI.chatroomName) ? (long) Math.min(com.tencent.mm.plugin.aa.a.d.NP(), j.eC(launchAAUI.chatroomName)) : (long) Math.min(com.tencent.mm.plugin.aa.a.d.NP(), 2));
        intent.putExtra("select_type", 1);
        launchAAUI.startActivityForResult(intent, 233);
        g.oUh.i(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
    }

    static /* synthetic */ void e(LaunchAAUI launchAAUI) {
        w.i("MicroMsg.LaunchAAUI", "switchMode");
        launchAAUI.iqE = false;
        if (launchAAUI.mode == a.imL) {
            launchAAUI.mode = a.imM;
            launchAAUI.iqN.setVisibility(8);
            launchAAUI.iqO.setVisibility(8);
            launchAAUI.iqQ.setVisibility(0);
            launchAAUI.iqG.setText(launchAAUI.getString(R.l.evV, new Object[]{Integer.valueOf(0)}));
            if (launchAAUI.iqU != null && launchAAUI.iqU.size() > com.tencent.mm.plugin.aa.a.d.NO()) {
                g.oUh.i(13722, new Object[]{Integer.valueOf(8)});
                launchAAUI.iqE = true;
            }
            if (launchAAUI.iqE) {
                launchAAUI.mL(launchAAUI.getString(R.l.evS, new Object[]{Integer.valueOf(com.tencent.mm.plugin.aa.a.d.NO())}));
            } else {
                launchAAUI.Or();
            }
            g.oUh.i(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
        } else {
            launchAAUI.mode = a.imL;
            launchAAUI.iqN.setVisibility(0);
            launchAAUI.iqO.setVisibility(0);
            launchAAUI.iqQ.setVisibility(8);
            launchAAUI.iqG.setText(R.l.evO);
            launchAAUI.iqE = false;
            if (launchAAUI.iqP.size() > com.tencent.mm.plugin.aa.a.d.NP()) {
                g.oUh.i(13722, new Object[]{Integer.valueOf(8)});
                launchAAUI.iqE = true;
            }
            launchAAUI.Ov();
            g.oUh.i(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
        }
        launchAAUI.Om();
        launchAAUI.aHf();
        launchAAUI.Oq();
        launchAAUI.Ot();
        launchAAUI.Os();
        launchAAUI.iqJ.post(new Runnable(launchAAUI) {
            final /* synthetic */ LaunchAAUI ird;

            {
                this.ird = r1;
            }

            public final void run() {
            }
        });
    }

    static /* synthetic */ void i(LaunchAAUI launchAAUI) {
        Intent intent = new Intent(launchAAUI, LaunchAAByPersonAmountSelectUI.class);
        intent.putExtra("chatroom", launchAAUI.chatroomName);
        intent.putExtra("maxPerAmount", com.tencent.mm.plugin.aa.a.d.NQ());
        if (launchAAUI.iqU != null && launchAAUI.iqU.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAUI.iqU.keySet()) {
                arrayList.add(str + "," + ((Double) launchAAUI.iqU.get(str)).doubleValue());
            }
            intent.putStringArrayListExtra("oldAmountData", arrayList);
        }
        intent.putExtra("maxUserNumber", com.tencent.mm.plugin.aa.a.d.NO());
        launchAAUI.startActivityForResult(intent, JsApiGetSetting.CTRL_INDEX);
        g.oUh.i(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(2)});
    }

    static /* synthetic */ void j(LaunchAAUI launchAAUI) {
        if (launchAAUI.mode != a.imL) {
            launchAAUI.Or();
            launchAAUI.Ou();
        } else if (!bg.mA(launchAAUI.iqK.getText()) && launchAAUI.iqP != null && launchAAUI.iqP.size() != 0) {
            launchAAUI.Or();
            g.oUh.i(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(3)});
            Map hashMap = new HashMap();
            try {
                Object string;
                String obj = launchAAUI.iqF.getText().toString();
                if (bg.mA(obj)) {
                    string = launchAAUI.getString(R.l.evY);
                } else {
                    String str = obj;
                }
                double d = bg.getDouble(launchAAUI.iqK.getText(), 0.0d);
                hashMap.put(com.tencent.mm.plugin.aa.a.k.inG, string);
                hashMap.put(com.tencent.mm.plugin.aa.a.k.inH, Double.valueOf(100.0d * d));
                hashMap.put(com.tencent.mm.plugin.aa.a.k.inK, launchAAUI.chatroomName);
                hashMap.put(com.tencent.mm.plugin.aa.a.k.inN, Long.valueOf(launchAAUI.timestamp));
                if ((launchAAUI.iqP != null ? launchAAUI.iqP.size() : 0) > 0) {
                    long au = h.au(launchAAUI.ioZ.getText(), "100");
                    w.d("MicroMsg.LaunchAAUI", "perAmount: %s", new Object[]{Long.valueOf(au)});
                    if (au <= 0 || au > com.tencent.mm.plugin.aa.a.d.NQ()) {
                        w.i("MicroMsg.LaunchAAUI", "illegal avgAmount: %s", new Object[]{Long.valueOf(au)});
                        return;
                    }
                    hashMap.put(com.tencent.mm.plugin.aa.a.k.inJ, Long.valueOf(au));
                    hashMap.put(com.tencent.mm.plugin.aa.a.k.inM, launchAAUI.iqP);
                    launchAAUI.ipg = com.tencent.mm.wallet_core.ui.g.a(launchAAUI, false, null);
                    com.tencent.mm.vending.g.g.s(Integer.valueOf(launchAAUI.mode), hashMap).a(launchAAUI.iqC.ioB).d(new com.tencent.mm.vending.c.a<Void, Boolean>(launchAAUI) {
                        final /* synthetic */ LaunchAAUI ird;

                        {
                            this.ird = r1;
                        }

                        public final /* synthetic */ Object call(Object obj) {
                            w.d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", new Object[]{(Boolean) obj});
                            if (this.ird.ipg != null) {
                                this.ird.ipg.dismiss();
                            }
                            if (r7.booleanValue()) {
                                LaunchAAUI.l(this.ird);
                                Toast.makeText(this.ird, R.l.ewc, 1).show();
                                g.oUh.i(13722, new Object[]{Integer.valueOf(4)});
                            } else {
                                Toast.makeText(this.ird, R.l.evZ, 1).show();
                                g.oUh.i(13722, new Object[]{Integer.valueOf(5)});
                            }
                            return wCE;
                        }
                    }).a(new com.tencent.mm.vending.g.d.a(launchAAUI) {
                        final /* synthetic */ LaunchAAUI ird;

                        {
                            this.ird = r1;
                        }

                        public final void aD(Object obj) {
                            w.i("MicroMsg.LaunchAAUI", "onInterrupt: %s", new Object[]{obj});
                            if (this.ird.ipg != null) {
                                this.ird.ipg.dismiss();
                            }
                            if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                                Toast.makeText(this.ird, obj.toString(), 1).show();
                            } else if (obj == null || !(obj instanceof y)) {
                                Toast.makeText(this.ird, R.l.evZ, 1).show();
                            } else {
                                h.a(this.ird.uSU.uTo, (y) obj);
                            }
                            g.oUh.i(13722, new Object[]{Integer.valueOf(5)});
                        }
                    });
                }
                g.oUh.i(13723, new Object[]{Integer.valueOf(1), h.mG(launchAAUI.chatroomName), Integer.valueOf(r0), Double.valueOf(d * 100.0d), string});
            } catch (Exception e) {
                w.e("MicroMsg.LaunchAAUI", "launchAAByMoney mode: %s error: %s", new Object[]{Integer.valueOf(launchAAUI.mode), e.getMessage()});
            }
        }
    }

    static /* synthetic */ void l(LaunchAAUI launchAAUI) {
        if (launchAAUI.getIntent().getIntExtra("enter_scene", 1) == 3) {
            launchAAUI.setResult(-1);
            launchAAUI.finish();
            return;
        }
        Intent intent = new Intent();
        intent.setFlags(67108864);
        intent.putExtra("key_should_finish", true);
        com.tencent.mm.bb.d.b(launchAAUI.uSU.uTo, "offline", ".ui.WalletOfflineCoinPurseUI", intent);
    }

    public void onCreate(Bundle bundle) {
        List f;
        CharSequence spannableString;
        super.onCreate(bundle);
        w.i("MicroMsg.LaunchAAUI", "LaunchAAUI onCreate");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LaunchAAUI ird;

            {
                this.ird = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ird.finish();
                return false;
            }
        });
        this.timestamp = System.currentTimeMillis() / 1000;
        zi(R.l.ewd);
        com.tencent.mm.vending.g.g.cbJ().a(this.iqC.ioD).d(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.plugin.aa.a.d>(this) {
            final /* synthetic */ LaunchAAUI ird;

            {
                this.ird = r1;
            }

            public final /* synthetic */ Object call(Object obj) {
                com.tencent.mm.plugin.aa.a.d dVar = (com.tencent.mm.plugin.aa.a.d) obj;
                w.i("MicroMsg.LaunchAAUI", "fetch operation data finish");
                if (dVar != null) {
                    this.ird.iqZ = dVar;
                    if (!(bg.mA(this.ird.iqZ.inu) || bg.mA(this.ird.iqZ.int))) {
                        LaunchAAUI.a(this.ird, this.ird.iqZ.inu, this.ird.iqZ.int);
                    }
                }
                return wCE;
            }
        }).a(new com.tencent.mm.vending.g.d.a(this) {
            final /* synthetic */ LaunchAAUI ird;

            {
                this.ird = r1;
            }

            public final void aD(Object obj) {
                w.i("MicroMsg.LaunchAAUI", "fetch operation data failed");
            }
        });
        this.chatroomName = getIntent().getStringExtra("chatroom_name");
        if (bg.mA(this.chatroomName)) {
            w.e("MicroMsg.LaunchAAUI", "chatroomName is null!!!");
            this.chatroomName = "";
        }
        String str = this.chatroomName;
        if (!bg.mA(str)) {
            if (!o.dH(str)) {
                f = bg.f(str.split(","));
                if (f != null) {
                    f.remove(m.xL());
                    if (f.size() > 0) {
                        str = (String) f.get(0);
                    }
                }
            }
            this.chatroomName = str;
            this.ipN = findViewById(R.h.czp);
            this.ipN.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ LaunchAAUI ird;

                {
                    this.ird = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    this.ird.Om();
                    this.ird.aHf();
                    return false;
                }
            });
            this.iqI = (TextView) findViewById(R.h.caG);
            this.iqI.setClickable(true);
            this.iqI.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k(this));
            Oq();
            this.iqW = (Button) findViewById(R.h.caz);
            this.iqW.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LaunchAAUI ird;

                {
                    this.ird = r1;
                }

                public final void onClick(View view) {
                    LaunchAAUI.a(this.ird);
                }
            });
            this.iqX = (TextView) findViewById(R.h.caw);
            this.iqY = (TextView) findViewById(R.h.caK);
            this.iqF = (MMEditText) findViewById(R.h.caH);
            this.iqG = (TextView) findViewById(R.h.caJ);
            this.ioZ = (TextView) findViewById(R.h.cax);
            this.iqH = (TextView) findViewById(R.h.cay);
            this.iqG.setText(R.l.evO);
            this.mode = a.imL;
            this.iqJ = (TextView) findViewById(R.h.bmk);
            this.iqJ.setClickable(true);
            this.iqJ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
            spannableString = new SpannableString(getString(R.l.dVT));
            spannableString.setSpan(new a(new a.a(this) {
                final /* synthetic */ LaunchAAUI ird;

                {
                    this.ird = r1;
                }

                public final void NZ() {
                    this.ird.startActivity(new Intent(this.ird, AAQueryListUI.class));
                    if (this.ird.mode == a.imL) {
                        g.oUh.i(13721, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                        return;
                    }
                    g.oUh.i(13721, new Object[]{Integer.valueOf(5), Integer.valueOf(2)});
                }
            }), 0, spannableString.length(), 18);
            this.iqJ.setText(spannableString);
            this.iqJ.setVisibility(8);
            this.iqF.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ LaunchAAUI ird;

                {
                    this.ird = r1;
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    this.ird.Os();
                }
            });
            this.iqK = (WalletFormView) findViewById(R.h.caI);
            this.iqK.a(new TextWatcher(this) {
                final /* synthetic */ LaunchAAUI ird;

                {
                    this.ird = r1;
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
                    } else if (indexOf > 6) {
                        editable.delete(6, indexOf);
                    } else if (indexOf == -1 && length > 6) {
                        editable.delete(6, length);
                    }
                    double d = bg.getDouble(editable.toString(), 0.0d);
                    if (this.ird.iqP != null && this.ird.iqP.size() > 0) {
                        d = (d * 100.0d) / ((double) this.ird.iqP.size());
                        this.ird.iqZ;
                        if (d > ((double) com.tencent.mm.plugin.aa.a.d.NQ())) {
                            this.ird.iqm = true;
                            g.oUh.i(13722, new Object[]{Integer.valueOf(2)});
                            this.ird.Os();
                            this.ird.Ot();
                            this.ird.Ov();
                        }
                    }
                    this.ird.iqm = false;
                    this.ird.Os();
                    this.ird.Ot();
                    this.ird.Ov();
                }
            });
            a(this.iqK, 2, false, false);
            this.iqM = (TextView) findViewById(R.h.caA);
            this.iqL = (TextView) findViewById(R.h.caB);
            if (o.dH(this.chatroomName)) {
                w.i("MicroMsg.LaunchAAUI", "is single chat: %s", new Object[]{this.chatroomName});
                f = new ArrayList();
                f.add(m.xL());
                f.add(this.chatroomName);
            } else {
                f = h.mG(this.chatroomName);
            }
            this.iqP = f;
            if (this.iqP.size() > com.tencent.mm.plugin.aa.a.d.NP()) {
                this.iqP.clear();
                this.iqM.setText(getString(R.l.eFt));
                Os();
            } else if (o.dH(this.chatroomName)) {
                this.iqM.setText(getString(R.l.evP, new Object[]{Integer.valueOf(f.size())}));
            } else {
                this.iqM.setText(getString(R.l.evL, new Object[]{Integer.valueOf(f.size())}));
            }
            this.iqM.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LaunchAAUI ird;

                public final void onClick(View view) {
                    this.ird.Om();
                    this.ird.aHf();
                    LaunchAAUI.a(this.ird, f);
                }
            });
            this.iqN = (ViewGroup) findViewById(R.h.caN);
            this.iqO = (ViewGroup) findViewById(R.h.caM);
            this.iqK.requestFocus();
            this.iqE = false;
            this.iqS = (TextView) findViewById(R.h.caF);
            this.iqS.setText(R.l.evW);
            this.iqS.setTextColor(getResources().getColor(R.e.aSx));
            this.iqQ = (ViewGroup) findViewById(R.h.caO);
            this.iqR = (ViewGroup) findViewById(R.h.caP);
            this.iqT = (ViewGroup) findViewById(R.h.caE);
            this.iqT.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LaunchAAUI ird;

                {
                    this.ird = r1;
                }

                public final void onClick(View view) {
                    LaunchAAUI.i(this.ird);
                }
            });
            bC(false);
            g.oUh.i(13721, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
            this.iqJ.post(new Runnable(this) {
                final /* synthetic */ LaunchAAUI ird;

                {
                    this.ird = r1;
                }

                public final void run() {
                }
            });
        }
        str = "";
        this.chatroomName = str;
        this.ipN = findViewById(R.h.czp);
        this.ipN.setOnTouchListener(/* anonymous class already generated */);
        this.iqI = (TextView) findViewById(R.h.caG);
        this.iqI.setClickable(true);
        this.iqI.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k(this));
        Oq();
        this.iqW = (Button) findViewById(R.h.caz);
        this.iqW.setOnClickListener(/* anonymous class already generated */);
        this.iqX = (TextView) findViewById(R.h.caw);
        this.iqY = (TextView) findViewById(R.h.caK);
        this.iqF = (MMEditText) findViewById(R.h.caH);
        this.iqG = (TextView) findViewById(R.h.caJ);
        this.ioZ = (TextView) findViewById(R.h.cax);
        this.iqH = (TextView) findViewById(R.h.cay);
        this.iqG.setText(R.l.evO);
        this.mode = a.imL;
        this.iqJ = (TextView) findViewById(R.h.bmk);
        this.iqJ.setClickable(true);
        this.iqJ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
        spannableString = new SpannableString(getString(R.l.dVT));
        spannableString.setSpan(new a(/* anonymous class already generated */), 0, spannableString.length(), 18);
        this.iqJ.setText(spannableString);
        this.iqJ.setVisibility(8);
        this.iqF.addTextChangedListener(/* anonymous class already generated */);
        this.iqK = (WalletFormView) findViewById(R.h.caI);
        this.iqK.a(/* anonymous class already generated */);
        a(this.iqK, 2, false, false);
        this.iqM = (TextView) findViewById(R.h.caA);
        this.iqL = (TextView) findViewById(R.h.caB);
        if (o.dH(this.chatroomName)) {
            w.i("MicroMsg.LaunchAAUI", "is single chat: %s", new Object[]{this.chatroomName});
            f = new ArrayList();
            f.add(m.xL());
            f.add(this.chatroomName);
        } else {
            f = h.mG(this.chatroomName);
        }
        this.iqP = f;
        if (this.iqP.size() > com.tencent.mm.plugin.aa.a.d.NP()) {
            this.iqP.clear();
            this.iqM.setText(getString(R.l.eFt));
            Os();
        } else if (o.dH(this.chatroomName)) {
            this.iqM.setText(getString(R.l.evP, new Object[]{Integer.valueOf(f.size())}));
        } else {
            this.iqM.setText(getString(R.l.evL, new Object[]{Integer.valueOf(f.size())}));
        }
        this.iqM.setOnClickListener(/* anonymous class already generated */);
        this.iqN = (ViewGroup) findViewById(R.h.caN);
        this.iqO = (ViewGroup) findViewById(R.h.caM);
        this.iqK.requestFocus();
        this.iqE = false;
        this.iqS = (TextView) findViewById(R.h.caF);
        this.iqS.setText(R.l.evW);
        this.iqS.setTextColor(getResources().getColor(R.e.aSx));
        this.iqQ = (ViewGroup) findViewById(R.h.caO);
        this.iqR = (ViewGroup) findViewById(R.h.caP);
        this.iqT = (ViewGroup) findViewById(R.h.caE);
        this.iqT.setOnClickListener(/* anonymous class already generated */);
        bC(false);
        g.oUh.i(13721, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        this.iqJ.post(/* anonymous class already generated */);
    }

    protected final boolean Op() {
        return false;
    }

    private void Oq() {
        Object string;
        CharSequence string2;
        CharSequence spannableStringBuilder;
        if (this.mode == a.imL) {
            string = getString(R.l.evM);
            string2 = getString(R.l.evN);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new a(new a.a(this) {
                final /* synthetic */ LaunchAAUI ird;

                {
                    this.ird = r1;
                }

                public final void NZ() {
                    LaunchAAUI.e(this.ird);
                }
            }), string.length(), spannableStringBuilder.length(), 18);
            this.iqI.setText(spannableStringBuilder);
        } else if (this.mode == a.imM) {
            string = getString(R.l.evT);
            string2 = getString(R.l.evU);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new a(new a.a(this) {
                final /* synthetic */ LaunchAAUI ird;

                {
                    this.ird = r1;
                }

                public final void NZ() {
                    LaunchAAUI.e(this.ird);
                }
            }), string.length(), spannableStringBuilder.length(), 18);
            this.iqI.setText(spannableStringBuilder);
        }
    }

    private void mL(String str) {
        this.irc = true;
        this.iqX.setVisibility(0);
        this.iqX.startAnimation(AnimationUtils.loadAnimation(this, R.a.aRf));
        this.iqX.setText(str);
    }

    private void Or() {
        this.irc = false;
        if (this.iqX.getVisibility() != 8) {
            this.iqX.startAnimation(AnimationUtils.loadAnimation(this, R.a.aRj));
            this.iqX.setVisibility(8);
        }
    }

    private void Os() {
        if (this.mode == a.imL) {
            if (bg.mA(this.iqK.getText())) {
                bC(false);
                return;
            } else if (this.iqm) {
                bC(false);
                return;
            } else if (this.iqP == null || this.iqP.size() == 0) {
                bC(false);
                return;
            } else if (this.iqP.size() > com.tencent.mm.plugin.aa.a.d.NP() || this.iqE) {
                bC(false);
                return;
            } else {
                w.d("MicroMsg.LaunchAAUI", "b1: %s, b2: %s, avg: %s", new Object[]{this.iqK.getText(), Integer.valueOf(this.iqP.size()), Double.valueOf(h.b(this.iqK.getText(), this.iqP.size(), 5, 4))});
                if (h.b(this.iqK.getText(), this.iqP.size(), 5, 4) < 0.01d) {
                    w.i("MicroMsg.LaunchAAUI", "less than 0.01");
                    bC(false);
                    return;
                }
            }
        } else if (this.iqU == null || this.iqU.size() == 0) {
            bC(false);
            return;
        } else if (this.iqU.size() > com.tencent.mm.plugin.aa.a.d.NP() || this.iqE) {
            bC(false);
            return;
        }
        bC(true);
    }

    private void bC(boolean z) {
        this.iqW.setEnabled(z);
        if (z) {
            this.iqG.setTextColor(getResources().getColor(R.e.black));
            this.ioZ.setTextColor(getResources().getColor(R.e.black));
            this.iqH.setTextColor(getResources().getColor(R.e.black));
            return;
        }
        this.iqG.setTextColor(getResources().getColor(R.e.aSy));
        this.ioZ.setTextColor(getResources().getColor(R.e.aSy));
        this.iqH.setTextColor(getResources().getColor(R.e.aSy));
    }

    private void Ot() {
        if (this.mode == a.imL) {
            if (this.iqP == null || this.iqP.size() <= 0) {
                this.ioZ.setText(getString(R.l.dAR));
            } else {
                double b = h.b(this.iqK.getText(), this.iqP.size(), 2, 2);
                this.ioZ.setText(getString(R.l.dAP, new Object[]{Double.valueOf(b)}));
            }
            this.iqG.setText(R.l.evO);
        } else if (this.iqU == null || this.iqU.size() == 0) {
            this.iqG.setText(getString(R.l.evV, new Object[]{Integer.valueOf(0)}));
            this.ioZ.setText(getString(R.l.dAR));
        } else {
            double d = 0.0d;
            for (Double doubleValue : this.iqU.values()) {
                d = doubleValue.doubleValue() + d;
            }
            this.ioZ.setText(getString(R.l.dAP, new Object[]{Double.valueOf(d)}));
            this.iqG.setText(getString(R.l.evV, new Object[]{Integer.valueOf(this.iqU.size())}));
        }
    }

    private void Ou() {
        g.oUh.i(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
        Map hashMap = new HashMap();
        try {
            Object string;
            String obj = this.iqF.getText().toString();
            if (bg.mA(obj)) {
                string = getString(R.l.evY);
            } else {
                String str = obj;
            }
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            long j = 0;
            for (String obj2 : this.iqU.keySet()) {
                double doubleValue = ((Double) this.iqU.get(obj2)).doubleValue();
                com.tencent.mm.protocal.c.j jVar = new com.tencent.mm.protocal.c.j();
                jVar.fZT = (long) (doubleValue * 100.0d);
                jVar.username = obj2;
                arrayList.add(jVar);
                long j2 = jVar.fZT + j;
                arrayList2.add(jVar.fZT);
                j = j2;
            }
            com.tencent.mm.protocal.c.j jVar2 = new com.tencent.mm.protocal.c.j();
            jVar2.username = m.xL();
            jVar2.fZT = j;
            hashMap.put(com.tencent.mm.plugin.aa.a.k.inG, string);
            hashMap.put(com.tencent.mm.plugin.aa.a.k.inH, Long.valueOf(j));
            hashMap.put(com.tencent.mm.plugin.aa.a.k.inM, arrayList);
            hashMap.put(com.tencent.mm.plugin.aa.a.k.inK, this.chatroomName);
            hashMap.put(com.tencent.mm.plugin.aa.a.k.inN, Long.valueOf(this.timestamp));
            if (this.ipg != null) {
                this.ipg.dismiss();
            }
            this.ipg = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
            com.tencent.mm.vending.g.g.bN(hashMap).a(this.iqC.ioC).d(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.vending.j.d<Boolean, String, Long>>(this) {
                final /* synthetic */ LaunchAAUI ird;

                {
                    this.ird = r1;
                }

                public final /* synthetic */ Object call(Object obj) {
                    w.d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", new Object[]{((com.tencent.mm.vending.j.d) obj).get(0)});
                    if (this.ird.ipg != null) {
                        this.ird.ipg.dismiss();
                    }
                    if (((Boolean) r8.get(0)).booleanValue()) {
                        LaunchAAUI.l(this.ird);
                        Toast.makeText(this.ird, R.l.ewc, 1).show();
                        g.oUh.i(13722, new Object[]{Integer.valueOf(9)});
                    } else {
                        Toast.makeText(this.ird, R.l.evZ, 1).show();
                        g.oUh.i(13722, new Object[]{Integer.valueOf(10)});
                    }
                    return wCE;
                }
            }).a(new com.tencent.mm.vending.g.d.a(this) {
                final /* synthetic */ LaunchAAUI ird;

                {
                    this.ird = r1;
                }

                public final void aD(Object obj) {
                    w.i("MicroMsg.LaunchAAUI", "onInterrupt: %s", new Object[]{obj});
                    if (this.ird.ipg != null) {
                        this.ird.ipg.dismiss();
                    }
                    if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                        Toast.makeText(this.ird, obj.toString(), 1).show();
                    } else if (obj == null || !(obj instanceof y)) {
                        Toast.makeText(this.ird, R.l.evZ, 1).show();
                    } else {
                        h.a(this.ird.uSU.uTo, (y) obj);
                    }
                    g.oUh.i(13722, new Object[]{Integer.valueOf(10)});
                }
            });
            g.oUh.i(13723, new Object[]{Integer.valueOf(2), Integer.valueOf(h.mG(this.chatroomName).size()), Integer.valueOf(arrayList.size() + 1), Long.valueOf(j), string, bg.c(arrayList2, ",")});
        } catch (Exception e) {
            w.e("MicroMsg.LaunchAAUI", "launchAAByPerson error: %s", new Object[]{e.getMessage()});
        }
    }

    protected final int Ol() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.dgF;
    }

    protected void onStop() {
        super.onStop();
        if (this.iqV != null) {
            this.iqV.clear();
        }
    }

    private void Ov() {
        if (!this.iqE || this.irc) {
            if (this.iqm && !this.irc) {
                mL(getString(R.l.ewa, new Object[]{Float.valueOf(((float) com.tencent.mm.plugin.aa.a.d.NQ()) / 100.0f)}));
            } else if (!this.iqE && !this.iqm) {
                Or();
            }
        } else if (this.mode == a.imL) {
            mL(getString(R.l.evS, new Object[]{Integer.valueOf(com.tencent.mm.plugin.aa.a.d.NP())}));
        } else {
            mL(getString(R.l.evS, new Object[]{Integer.valueOf(com.tencent.mm.plugin.aa.a.d.NO())}));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        String[] split;
        int i3;
        if (i == 233) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("Select_Contact");
                if (this.mode == a.imL) {
                    if (!bg.mA(stringExtra)) {
                        split = stringExtra.split(",");
                        this.iqP.clear();
                        this.iqP.addAll(Arrays.asList(split));
                    }
                    List mG = h.mG(this.chatroomName);
                    TextView textView;
                    Object[] objArr;
                    if (mG == null || this.iqP == null || this.iqP.size() != mG.size() || !o.dH(this.chatroomName)) {
                        textView = this.iqM;
                        i3 = R.l.evP;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.iqP != null ? this.iqP.size() : 0);
                        textView.setText(getString(i3, objArr));
                    } else {
                        textView = this.iqM;
                        i3 = R.l.evL;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.iqP != null ? this.iqP.size() : 0);
                        textView.setText(getString(i3, objArr));
                    }
                }
                Or();
                if (this.iqP == null || this.iqP.size() <= com.tencent.mm.plugin.aa.a.d.NP()) {
                    this.iqE = false;
                } else {
                    this.iqE = true;
                }
                double d = bg.getDouble(this.iqK.getText(), 0.0d);
                if (this.iqP == null || (d * 100.0d) / ((double) this.iqP.size()) <= ((double) com.tencent.mm.plugin.aa.a.d.NQ())) {
                    this.iqm = false;
                } else {
                    this.iqm = true;
                    g.oUh.i(13722, new Object[]{Integer.valueOf(2)});
                }
                Os();
                Ot();
                Ov();
            }
        } else if (i == JsApiGetSetting.CTRL_INDEX && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selectUI");
            this.iqU.clear();
            if (stringArrayListExtra != null) {
                try {
                    if (stringArrayListExtra.size() > 0) {
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            split = ((String) it.next()).split(",");
                            this.iqU.put(split[0], Double.valueOf(bg.getDouble(split[1], 0.0d)));
                        }
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", new Object[]{e.getMessage()});
                    return;
                }
            }
            int dimension;
            if (this.iqU == null || this.iqU.size() <= 0) {
                this.iqS.setText(R.l.evW);
                this.iqS.setTextColor(getResources().getColor(R.e.aSx));
                dimension = (int) getResources().getDimension(R.f.aYa);
                this.iqT.setPadding(dimension, dimension, dimension, dimension);
                this.iqT.setBackgroundResource(R.g.bgf);
                this.iqR.setVisibility(8);
            } else {
                this.iqS.setText(getString(R.l.evX, new Object[]{Integer.valueOf(this.iqU.size())}));
                this.iqS.setTextColor(getResources().getColor(R.e.black));
                dimension = (int) getResources().getDimension(R.f.aYa);
                this.iqT.setPadding(dimension, (int) getResources().getDimension(R.f.aXY), dimension, (int) getResources().getDimension(R.f.aXZ));
                this.iqT.setBackgroundResource(R.g.bge);
                this.iqR.setVisibility(0);
            }
            this.iqR.removeAllViews();
            this.iqV.clear();
            if (this.iqU != null && this.iqU.size() > 0) {
                i3 = 0;
                for (String stringExtra2 : this.iqU.keySet()) {
                    double doubleValue = ((Double) this.iqU.get(stringExtra2)).doubleValue();
                    View launchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
                    if (i3 >= this.iqU.size() - 1) {
                        launchAAByPersonNameAmountRow.ipY.setVisibility(8);
                    }
                    launchAAByPersonNameAmountRow.ipW.setText(com.tencent.mm.pluginsdk.ui.d.h.b(launchAAByPersonNameAmountRow.getContext(), n.E(stringExtra2, this.chatroomName), launchAAByPersonNameAmountRow.ipW.getTextSize()));
                    launchAAByPersonNameAmountRow.ioZ.setText(launchAAByPersonNameAmountRow.getContext().getString(R.l.dAP, new Object[]{Double.valueOf(doubleValue)}));
                    this.iqR.addView(launchAAByPersonNameAmountRow);
                    this.iqV.put(stringExtra2, launchAAByPersonNameAmountRow);
                    i3++;
                }
            }
            if (this.ipN != null) {
                this.ipN.requestLayout();
            }
            this.irb = 0;
            this.iqJ.post(new Runnable(this) {
                final /* synthetic */ LaunchAAUI ird;

                {
                    this.ird = r1;
                }

                public final void run() {
                }
            });
            Ot();
            Os();
        }
    }
}
