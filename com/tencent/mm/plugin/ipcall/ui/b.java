package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bma;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    public MMActivity fCi;
    public String hmV;
    public TextView ipW;
    private an mRA;
    public String mRB;
    public String mRC;
    public String mRD = "";
    public String mRE;
    public LinkedList<bma> mRF;
    public long mRG = 0;
    public boolean mRH = false;
    private Runnable mRI = new Runnable(this) {
        final /* synthetic */ b mRN;

        {
            this.mRN = r1;
        }

        public final void run() {
            if (System.currentTimeMillis() - this.mRN.mRG >= 500) {
                this.mRN.mRE = com.tencent.mm.plugin.ipcall.b.a.ai(this.mRN.fCi, this.mRN.mRC + this.mRN.mRD);
                final c yt = i.aEn().yt(this.mRN.mRE);
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 mRP;

                    public final void run() {
                        if (yt == null || yt.uxb == -1) {
                            this.mRP.mRN.ipW.setText("");
                        } else {
                            this.mRP.mRN.ipW.setText(yt.field_systemAddressBookUsername);
                        }
                    }
                });
                return;
            }
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 mRP;

                {
                    this.mRP = r1;
                }

                public final void run() {
                    this.mRP.mRN.ipW.setText("");
                    this.mRP.mRN.mRE = null;
                    this.mRP.mRN.hmV = null;
                }
            });
        }
    };
    private af mRJ = new af("IPCallDialQueryPhoneNumber");
    public boolean mRK = false;
    private TextWatcher mRL = new TextWatcher(this) {
        final /* synthetic */ b mRN;

        {
            this.mRN = r1;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int measureText;
            if (this.mRN.mRx.getLayoutParams() != null) {
                int i4;
                Paint paint = this.mRN.mRt.getPaint();
                if ("+".equals(this.mRN.mRt.getText().toString())) {
                    measureText = (int) paint.measureText(this.mRN.mRt.getText().toString());
                    this.mRN.mRv.setVisibility(8);
                    this.mRN.mRy.setVisibility(8);
                    i4 = measureText;
                } else {
                    measureText = (int) paint.measureText(this.mRN.mRt.getText() + "+");
                    this.mRN.mRv.setVisibility(0);
                    this.mRN.mRy.setVisibility(0);
                    i4 = measureText;
                }
                LayoutParams layoutParams = (LayoutParams) this.mRN.mRx.getLayoutParams();
                layoutParams.width = i4;
                this.mRN.mRx.setLayoutParams(layoutParams);
            }
            String replace = this.mRN.mRt.getText().toString().replace("+", "");
            if (com.tencent.mm.plugin.ipcall.b.a.yV(replace)) {
                this.mRN.mRy.setText(com.tencent.mm.plugin.ipcall.b.a.yS(replace));
                if (this.mRN.mRF != null && this.mRN.mRF.size() > 0) {
                    String yT = com.tencent.mm.plugin.ipcall.b.a.yT(replace);
                    Iterator it = this.mRN.mRF.iterator();
                    while (it.hasNext()) {
                        bma com_tencent_mm_protocal_c_bma = (bma) it.next();
                        if (com_tencent_mm_protocal_c_bma != null && com_tencent_mm_protocal_c_bma.hAM.equals(yT)) {
                            measureText = 1;
                            break;
                        }
                    }
                    measureText = 0;
                }
                measureText = 0;
            } else {
                this.mRN.mRy.setText(this.mRN.fCi.getString(R.l.etE));
                measureText = 0;
            }
            if (measureText != 0) {
                this.mRN.mRz.setVisibility(0);
            } else {
                this.mRN.mRz.setVisibility(8);
            }
            if (this.mRN.mRr != null) {
                this.mRN.mRr.yB(replace);
            }
        }

        public final void afterTextChanged(Editable editable) {
            String replace = this.mRN.mRt.getText().toString().replace("+", "");
            if (replace.startsWith("0") || replace.startsWith("*") || replace.startsWith("#")) {
                this.mRN.mRt.setText("+");
                this.mRN.mRC = "+";
            }
        }
    };
    public String mRM = "";
    public a mRr;
    private DialPad mRs;
    public TextView mRt;
    public EditText mRu;
    public View mRv;
    private ImageButton mRw;
    public View mRx;
    public TextView mRy;
    public TextView mRz;

    public interface a {
        void g(String str, String str2, String str3, String str4);

        void yB(String str);

        void yC(String str);
    }

    public b(MMActivity mMActivity, EditText editText, TextView textView, View view, DialPad dialPad, ImageButton imageButton, TextView textView2, View view2, TextView textView3, TextView textView4) {
        this.fCi = mMActivity;
        this.mRu = editText;
        this.mRt = textView;
        this.mRv = view;
        this.mRs = dialPad;
        this.mRw = imageButton;
        this.ipW = textView2;
        this.mRx = view2;
        this.mRy = textView3;
        this.mRz = textView4;
        this.mRA = new an();
        this.mRC = com.tencent.mm.plugin.ipcall.b.c.aFy();
        String string = ab.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
        if (bg.mA(string)) {
            string = com.tencent.mm.plugin.ipcall.b.a.yS(com.tencent.mm.plugin.ipcall.b.a.aFv());
        }
        this.mRB = string;
        this.mRt.addTextChangedListener(this.mRL);
        this.mRt.setText("+" + this.mRC);
        this.mRs.mRq = new com.tencent.mm.plugin.ipcall.ui.DialPad.a(this) {
            final /* synthetic */ b mRN;

            {
                this.mRN = r1;
            }

            public final void yy(String str) {
                this.mRN.mRD = this.mRN.mRu.getText().toString();
                if (this.mRN.mRH) {
                    this.mRN.mRC += str;
                    this.mRN.mRt.setText(this.mRN.mRC);
                    if (com.tencent.mm.plugin.ipcall.b.a.yV(this.mRN.mRC.replace("+", "")) || this.mRN.mRC.replace("+", "").length() >= 4) {
                        g.oUh.i(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
                        this.mRN.mRH = false;
                        this.mRN.mRB = com.tencent.mm.plugin.ipcall.b.a.yS(this.mRN.mRC.replace("+", ""));
                        this.mRN.mRD = this.mRN.cy(this.mRN.mRC.replace("+", ""), this.mRN.mRD);
                        this.mRN.bc(this.mRN.mRD, -1);
                        return;
                    }
                    return;
                }
                String replace = this.mRN.mRt.getText().toString().replace("+", "");
                if (this.mRN.mRK) {
                    StringBuffer stringBuffer = new StringBuffer(this.mRN.mRD);
                    stringBuffer.insert(this.mRN.mRu.getSelectionStart(), str);
                    this.mRN.mRD = stringBuffer.toString();
                } else {
                    this.mRN.mRD += str;
                }
                if (this.mRN.mRD.equals("00")) {
                    this.mRN.mRt.setText("+");
                    this.mRN.mRH = true;
                    this.mRN.mRC = "+";
                    this.mRN.mRD = "";
                }
                if (com.tencent.mm.plugin.ipcall.b.a.yV(this.mRN.mRC.replace("+", "") + this.mRN.mRD)) {
                    this.mRN.mRt.setText("+" + this.mRN.mRC.replace("+", "") + this.mRN.mRD);
                    this.mRN.mRB = com.tencent.mm.plugin.ipcall.b.a.yS(this.mRN.mRC.replace("+", ""));
                    this.mRN.mRH = false;
                    this.mRN.mRC = this.mRN.mRC.replace("+", "") + this.mRN.mRD;
                    this.mRN.mRD = "";
                }
                String str2 = this.mRN.mRD;
                this.mRN.mRD = this.mRN.cy(replace, this.mRN.mRD);
                if (!this.mRN.mRK) {
                    this.mRN.bc(this.mRN.mRD, -1);
                } else if (str2.length() < this.mRN.mRD.length()) {
                    this.mRN.bc(this.mRN.mRD, this.mRN.mRu.getSelectionEnd() + 2);
                } else if (str2.length() == this.mRN.mRD.length()) {
                    this.mRN.bc(this.mRN.mRD, this.mRN.mRu.getSelectionEnd() + 1);
                } else if (str2.length() > this.mRN.mRD.length()) {
                    this.mRN.bc(this.mRN.mRD, (this.mRN.mRu.getSelectionEnd() + 1) - (str2.length() - this.mRN.mRD.length()));
                }
                this.mRN.mRG = System.currentTimeMillis();
                if (this.mRN.mRD.length() > com.tencent.mm.plugin.ipcall.b.a.mYA && !bg.mA(this.mRN.mRC + this.mRN.mRD)) {
                    this.mRN.aEU();
                }
            }

            public final void yz(String str) {
                if (str.equals("0")) {
                    this.mRN.mRt.setText("+");
                    this.mRN.mRH = true;
                    this.mRN.mRC = "+";
                }
            }
        };
        this.mRv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b mRN;

            {
                this.mRN = r1;
            }

            public final void onClick(View view) {
                String obj = this.mRN.mRu.getText().toString();
                if (bg.mA(obj)) {
                    obj = this.mRN.mRt.getText().toString();
                    if (!bg.mA(obj)) {
                        Object substring = obj.substring(0, obj.length() - 1);
                        if (bg.mA(substring) || substring.equals("+")) {
                            this.mRN.mRt.setText("+");
                            this.mRN.mRC = "+";
                            this.mRN.mRH = true;
                            return;
                        }
                        this.mRN.mRt.setText(substring);
                        this.mRN.mRC = substring;
                        return;
                    }
                    return;
                }
                int selectionStart = this.mRN.mRu.getSelectionStart();
                if (!this.mRN.mRK || selectionStart - 1 < 0) {
                    obj = obj.substring(0, obj.length() - 1);
                } else {
                    Editable text = this.mRN.mRu.getText();
                    text.delete(selectionStart - 1, selectionStart);
                    obj = text.toString();
                }
                if (bg.mA(obj)) {
                    this.mRN.mRD = "";
                    this.mRN.bc("", -1);
                } else {
                    String replace = this.mRN.mRt.getText().toString().replace("+", "");
                    if (this.mRN.mRK) {
                        this.mRN.mRD = this.mRN.cy(replace, obj);
                        this.mRN.bc(this.mRN.mRD, (this.mRN.mRD.length() - obj.length()) + (selectionStart - 1));
                    } else {
                        this.mRN.mRD = this.mRN.cy(replace, obj);
                        this.mRN.bc(this.mRN.mRD, -1);
                    }
                    this.mRN.aEU();
                }
                this.mRN.mRE = "";
                this.mRN.ipW.setText("");
            }
        });
        this.mRv.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ b mRN;

            {
                this.mRN = r1;
            }

            public final boolean onLongClick(View view) {
                if (this.mRN.mRH) {
                    this.mRN.mRC = "+";
                    this.mRN.mRt.setText(this.mRN.mRC);
                } else {
                    this.mRN.ipW.setText("");
                    this.mRN.mRD = "";
                    this.mRN.bc("", -1);
                }
                return true;
            }
        });
        this.mRt.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b mRN;

            {
                this.mRN = r1;
            }

            public final void onClick(View view) {
                g.oUh.i(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
                String replace = this.mRN.mRt.getText().toString().replace("+", "");
                Intent intent = new Intent(this.mRN.fCi, IPCallCountryCodeSelectUI.class);
                intent.putExtra("couttry_code", replace);
                intent.putExtra("CountryCodeUI_isShowCountryCode", true);
                this.mRN.fCi.startActivityForResult(intent, 100);
                this.mRN.fCi.overridePendingTransition(R.a.aRq, -1);
            }
        });
        this.mRw.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b mRN;

            {
                this.mRN = r1;
            }

            public final void onClick(View view) {
                b bVar = this.mRN;
                bVar.mRC = bVar.mRt.getText().toString();
                bVar.mRD = bVar.mRu.getText().toString();
                String string;
                if (bg.mA(bVar.mRC) || bg.mA(bVar.mRD)) {
                    string = ab.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
                    if (!bg.mA(string)) {
                        bVar.mRD = bVar.cy(bVar.mRt.getText().toString().replace("+", ""), com.tencent.mm.plugin.ipcall.b.c.zc(string));
                        bVar.bc(bVar.mRD, -1);
                        bVar.aEU();
                        return;
                    }
                    return;
                }
                bVar.mRC = bVar.mRt.getText().toString().replace("+", "");
                bVar.mRE = com.tencent.mm.plugin.ipcall.b.a.ai(bVar.fCi, bVar.mRC + bVar.mRD);
                bVar.hmV = com.tencent.mm.plugin.ipcall.b.a.ak(bVar.fCi, bVar.mRE);
                string = com.tencent.mm.plugin.ipcall.b.c.zc(bVar.mRD);
                Editor edit = ab.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
                edit.putString("IPCall_LastInputPhoneNumber", string);
                edit.apply();
                String charSequence = bVar.mRt.getText().toString();
                string = bVar.mRB;
                if (!bg.mA(charSequence)) {
                    if (bg.mA(string)) {
                        string = "";
                    }
                    Editor edit2 = ab.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
                    edit2.putString("IPCall_LastInputCountryCode", charSequence.replace("+", ""));
                    edit2.putString("IPCall_LastInputCountryName", string);
                    edit2.apply();
                }
                if (bVar.mRr != null) {
                    bVar.mRr.g(bVar.mRC, com.tencent.mm.plugin.ipcall.b.c.zc(bVar.mRD), bVar.mRE, bVar.hmV);
                }
            }
        });
        this.mRu.setHorizontallyScrolling(true);
        this.mRu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b mRN;

            {
                this.mRN = r1;
            }

            public final void onClick(View view) {
                this.mRN.mRu.setCursorVisible(true);
                this.mRN.fCi.aHf();
                this.mRN.mRK = true;
            }
        });
        this.mRu.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ b mRN;

            {
                this.mRN = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CharSequence zc = bg.zc(charSequence.toString());
                if (zc.contains(" ")) {
                    zc = zc.replace(" ", "");
                    this.mRN.mRu.setText(bg.K(zc));
                } else if ((!this.mRN.mRM.equals(zc) || i3 > 0) && bg.mA(zc)) {
                    this.mRN.mRM = zc;
                    this.mRN.mRu.setText("");
                }
                if (com.tencent.mm.plugin.ipcall.b.a.yW(zc)) {
                    String yU = com.tencent.mm.plugin.ipcall.b.a.yU(zc);
                    if (!bg.mA(yU)) {
                        this.mRN.mRt.setText("+" + yU);
                        this.mRN.mRu.setText(com.tencent.mm.plugin.ipcall.b.a.yZ(zc));
                    }
                } else if (!zc.equals(this.mRN.mRM)) {
                    this.mRN.mRM = zc;
                    this.mRN.mRu.setText(zc);
                    if (bg.mA(this.mRN.mRt.getText().toString())) {
                        this.mRN.mRt.setText("+" + com.tencent.mm.plugin.ipcall.b.a.aFv());
                    }
                }
                if (this.mRN.mRr != null) {
                    this.mRN.mRr.yC(this.mRN.mRu.getText().toString());
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        if (d.eo(16)) {
            this.mRt.setTypeface(Typeface.create("sans-serif-light", 0));
            this.mRu.setTypeface(Typeface.create("sans-serif-light", 0));
            this.ipW.setTypeface(Typeface.create("sans-serif-light", 0));
        }
    }

    public final void yA(String str) {
        this.mRC = str;
        if (this.mRt != null) {
            this.mRt.setText("+" + str);
        }
    }

    public final void W(LinkedList<bma> linkedList) {
        int i;
        this.mRF = linkedList;
        String replace = this.mRt.getText().toString().replace("+", "");
        if (com.tencent.mm.plugin.ipcall.b.a.yV(replace) && this.mRF != null && this.mRF.size() > 0) {
            String yT = com.tencent.mm.plugin.ipcall.b.a.yT(replace);
            Iterator it = this.mRF.iterator();
            while (it.hasNext()) {
                bma com_tencent_mm_protocal_c_bma = (bma) it.next();
                if (com_tencent_mm_protocal_c_bma != null && com_tencent_mm_protocal_c_bma.hAM.equals(yT)) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        if (i != 0) {
            this.mRz.setVisibility(0);
        } else {
            this.mRz.setVisibility(8);
        }
    }

    public final String cy(String str, String str2) {
        String formatNumber = an.formatNumber(str, com.tencent.mm.plugin.ipcall.b.c.zc(str2));
        return bg.mA(formatNumber) ? str2 : formatNumber;
    }

    public final void bc(String str, int i) {
        this.mRu.setText(str);
        if (!bg.mA(str)) {
            if (i != -1) {
                if (this.mRK) {
                    if (i > 0 && i <= this.mRu.getText().length()) {
                        this.mRu.setSelection(i);
                    }
                }
            }
            this.mRu.setSelection(this.mRu.getText().length());
        }
        this.mRD = str;
    }

    public final void aEU() {
        this.mRJ.bJl().removeCallbacks(this.mRI);
        this.mRJ.e(this.mRI, 500);
    }
}
