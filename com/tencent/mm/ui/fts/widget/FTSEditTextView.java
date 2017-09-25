package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.tools.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSEditTextView extends LinearLayout {
    public ImageView jbU;
    public List<com.tencent.mm.ui.fts.widget.a.b> qGU;
    private String sSn;
    protected OnFocusChangeListener vjo = new OnFocusChangeListener(this) {
        final /* synthetic */ FTSEditTextView wij;

        {
            this.wij = r1;
        }

        public final void onFocusChange(View view, boolean z) {
            if (this.wij.wih != null) {
                this.wij.wih.gM(z);
            }
        }
    };
    public EditText vqz;
    public View wia;
    private TextView wib;
    private TextView wic;
    private TextView wid;
    private View wie;
    public boolean wif = true;
    private OnClickListener wig = new OnClickListener(this) {
        final /* synthetic */ FTSEditTextView wij;

        {
            this.wij = r1;
        }

        public final void onClick(View view) {
            int i = -1;
            if (view.getId() == g.hdi) {
                i = 0;
            } else if (view.getId() == g.hdj) {
                i = 1;
            } else if (view.getId() == g.hdk) {
                i = 2;
            }
            if (this.wij.wih != null && i >= 0) {
                a g = this.wij.wih;
                this.wij.qGU.get(i);
                g.aZw();
            }
        }
    };
    public a wih;
    private b wii = b.UserInput;

    public interface a {
        boolean WV();

        void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, b bVar);

        void aZs();

        void aZw();

        void gM(boolean z);
    }

    public enum b {
        UserInput,
        ClearText,
        SetText
    }

    static /* synthetic */ void e(FTSEditTextView fTSEditTextView) {
        String byY = fTSEditTextView.byY();
        if (fTSEditTextView.wih != null) {
            fTSEditTextView.wih.a(fTSEditTextView.byX(), byY, fTSEditTextView.qGU, fTSEditTextView.wii);
        }
        if (byY.length() == 0) {
            fTSEditTextView.vqz.setHint(fTSEditTextView.sSn);
        }
        if (byY.length() > 0 || fTSEditTextView.qGU.size() > 0) {
            fTSEditTextView.wia.setVisibility(0);
        } else {
            fTSEditTextView.wia.setVisibility(8);
        }
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    protected void bYX() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(h.hdU, this, true);
    }

    protected void init() {
        bYX();
        this.wie = findViewById(g.hdl);
        this.jbU = (ImageView) findViewById(g.icon);
        this.vqz = (EditText) findViewById(g.bKP);
        this.wia = findViewById(g.bCu);
        this.wib = (TextView) findViewById(g.hdi);
        this.wic = (TextView) findViewById(g.hdj);
        this.wid = (TextView) findViewById(g.hdk);
        this.qGU = new ArrayList();
        this.vqz.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ FTSEditTextView wij;

            {
                this.wij = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && 67 == i) {
                    int selectionStart = this.wij.vqz.getSelectionStart();
                    int selectionEnd = this.wij.vqz.getSelectionEnd();
                    if (selectionStart == 0 && selectionEnd == 0 && this.wij.qGU.size() > 0 && this.wij.wif) {
                        this.wij.qGU.remove(this.wij.qGU.size() - 1);
                        this.wij.bZa();
                        FTSEditTextView.e(this.wij);
                    }
                }
                return false;
            }
        });
        this.vqz.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ FTSEditTextView wij;

            {
                this.wij = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (this.wij.byX().length() > 0) {
                    this.wij.wia.setVisibility(0);
                } else {
                    this.wij.wia.setVisibility(8);
                }
                FTSEditTextView.e(this.wij);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.vqz.setOnFocusChangeListener(this.vjo);
        this.vqz.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ FTSEditTextView wij;

            {
                this.wij = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || this.wij.wih == null) {
                    return false;
                }
                return this.wij.wih.WV();
            }
        });
        this.wib.setOnClickListener(this.wig);
        this.wic.setOnClickListener(this.wig);
        this.wid.setOnClickListener(this.wig);
        this.wia.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FTSEditTextView wij;

            {
                this.wij = r1;
            }

            public final void onClick(View view) {
                this.wij.clearText();
                if (this.wij.wih != null) {
                    this.wij.wih.aZs();
                }
            }
        });
        c.d(this.vqz).Ch(100).a(null);
    }

    public final void clearText() {
        this.wii = b.ClearText;
        if (this.wif) {
            this.qGU.clear();
        }
        this.vqz.setText("");
        this.vqz.setHint(this.sSn);
        this.wia.setVisibility(8);
        bZa();
        this.wii = b.UserInput;
    }

    public final void bYY() {
        postDelayed(new Runnable(this) {
            final /* synthetic */ FTSEditTextView wij;

            {
                this.wij = r1;
            }

            public final void run() {
                ((InputMethodManager) this.wij.getContext().getSystemService("input_method")).showSoftInput(this.wij.vqz, 0);
            }
        }, 128);
    }

    public final void q(String str, List<com.tencent.mm.ui.fts.widget.a.b> list) {
        a(str, list, b.UserInput);
    }

    public final void a(String str, List<com.tencent.mm.ui.fts.widget.a.b> list, b bVar) {
        this.qGU.clear();
        if (list != null) {
            this.qGU.addAll(list);
        }
        w.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", new Object[]{str, Integer.valueOf(this.qGU.size())});
        this.wii = b.SetText;
        this.vqz.setText(str);
        Selection.setSelection(this.vqz.getText(), this.vqz.getText().length());
        bZa();
        this.wii = bVar;
    }

    public final void bYZ() {
        this.vqz.requestFocus();
    }

    public final void GR(String str) {
        this.vqz.setHint(str);
        this.sSn = str;
    }

    private void bZa() {
        w.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", new Object[]{Integer.valueOf(this.qGU.size())});
        float T = (float) com.tencent.mm.bg.a.T(getContext(), e.aXI);
        if (this.qGU.size() > 0) {
            this.wib.setVisibility(0);
            this.wib.setText(com.tencent.mm.ui.f.c.b.a(getContext(), ((com.tencent.mm.ui.fts.widget.a.b) this.qGU.get(0)).getTagName(), T));
        } else {
            this.wib.setVisibility(8);
        }
        if (this.qGU.size() >= 2) {
            this.wic.setVisibility(0);
            this.wic.setText(com.tencent.mm.ui.f.c.b.a(getContext(), ((com.tencent.mm.ui.fts.widget.a.b) this.qGU.get(1)).getTagName(), T));
        } else {
            this.wic.setVisibility(8);
        }
        if (this.qGU.size() >= 3) {
            this.wid.setVisibility(0);
            this.wid.setText(com.tencent.mm.ui.f.c.b.a(getContext(), ((com.tencent.mm.ui.fts.widget.a.b) this.qGU.get(2)).getTagName(), T));
            return;
        }
        this.wid.setVisibility(8);
    }

    public final String byY() {
        return this.vqz.getText().toString().trim();
    }

    public final String byX() {
        StringBuffer stringBuffer = new StringBuffer();
        for (com.tencent.mm.ui.fts.widget.a.b tagName : this.qGU) {
            stringBuffer.append(tagName.getTagName());
            stringBuffer.append(" ");
        }
        stringBuffer.append(this.vqz.getText().toString());
        return stringBuffer.toString().trim();
    }

    public final void bZb() {
        this.jbU.setVisibility(0);
    }

    public final void bZc() {
        this.wia.setVisibility(8);
    }
}
