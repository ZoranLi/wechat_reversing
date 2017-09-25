package com.tencent.mm.ui.tools;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.ActionBarSearchView.b;
import com.tencent.mm.ui.tools.a.c;
import java.util.ArrayList;

public class SearchViewNotRealTimeHelper extends LinearLayout implements f {
    public EditText vqz;
    public View wkh;
    private ImageButton wkj;
    private com.tencent.mm.ui.tools.ActionBarSearchView.a wko;
    public Button woq;
    public a wor;

    public interface a {
        void aes();

        boolean mQ(String str);

        void sb(String str);
    }

    public SearchViewNotRealTimeHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SearchViewNotRealTimeHelper(Context context) {
        super(context);
        init();
    }

    private void init() {
        r.eC(getContext()).inflate(h.hdH, this, true);
        this.vqz = (EditText) findViewById(g.bKP);
        this.wkj = (ImageButton) findViewById(g.cGq);
        this.wkh = findViewById(g.bmv);
        this.woq = (Button) findViewById(g.button);
        this.woq.setEnabled(false);
        this.vqz.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper wos;

            {
                this.wos = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable == null || editable.length() <= 0) {
                    this.wos.wkj.setVisibility(8);
                    this.wos.woq.setEnabled(false);
                    return;
                }
                this.wos.wkj.setVisibility(0);
                this.wos.woq.setEnabled(true);
            }
        });
        this.vqz.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper wos;

            {
                this.wos = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || this.wos.wor == null) {
                    return false;
                }
                return this.wos.wor.mQ(this.wos.bzZ());
            }
        });
        c.d(this.vqz).Ch(100).a(null);
        this.wkj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper wos;

            {
                this.wos = r1;
            }

            public final void onClick(View view) {
                this.wos.vqz.setText("");
                if (this.wos.wor != null) {
                    this.wos.wor.aes();
                }
            }
        });
        this.wkh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper wos;

            {
                this.wos = r1;
            }

            public final void onClick(View view) {
                w.v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
                if (this.wos.wko != null) {
                    this.wos.wko.aHp();
                }
            }
        });
        this.woq.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper wos;

            {
                this.wos = r1;
            }

            public final void onClick(View view) {
                if (this.wos.wor != null) {
                    this.wos.wor.sb(this.wos.bzZ());
                }
            }
        });
    }

    public final void Q(CharSequence charSequence) {
        this.vqz.setHint(charSequence);
    }

    public final void lH(boolean z) {
        this.vqz.setText("");
    }

    public final void bZt() {
        this.vqz.clearFocus();
    }

    public final String bzZ() {
        Editable editableText = this.vqz.getEditableText();
        return editableText == null ? "" : editableText.toString();
    }

    public final void Ug(String str) {
        this.vqz.setText("");
        this.vqz.append(str);
    }

    public final void setHint(CharSequence charSequence) {
        Q(charSequence);
    }

    public final void a(b bVar) {
    }

    public final void lE(boolean z) {
    }

    public final void lF(boolean z) {
    }

    public final void lG(boolean z) {
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
    }

    public final void a(a aVar) {
        this.wor = aVar;
    }

    public boolean hasFocus() {
        return false;
    }

    public final boolean bZv() {
        return false;
    }

    public final boolean bZu() {
        return false;
    }

    public final void a(com.tencent.mm.ui.tools.ActionBarSearchView.a aVar) {
        this.wko = aVar;
    }

    public final void ak(ArrayList<String> arrayList) {
    }

    public final void lI(boolean z) {
    }

    public final void Cd(int i) {
    }

    public final void Uh(String str) {
    }
}
