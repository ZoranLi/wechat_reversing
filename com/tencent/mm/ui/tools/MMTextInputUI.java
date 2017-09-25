package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.s.a;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l.b;

public class MMTextInputUI extends MMActivity {
    private int gMU;
    private int jYc;
    private EditText vqz;
    private TextView wnn;
    private int wno;
    private boolean wnp;

    public int getLayoutId() {
        return h.hdV;
    }

    private void goBack() {
        if (getIntent().getBooleanExtra("key_show_confirm", false)) {
            g.a(this.uSU.uTo, getString(k.hfn), "", new OnClickListener(this) {
                final /* synthetic */ MMTextInputUI wnq;

                {
                    this.wnq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.wnq.aHf();
                    this.wnq.setResult(0);
                    this.wnq.finish();
                }
            }, null);
            return;
        }
        aHf();
        setResult(0);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != i) {
            return super.onKeyDown(i, keyEvent);
        }
        w.i("MicroMsg.MMTextInputUI", "on back key down");
        goBack();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.vqz = (EditText) findViewById(a.g.cHE);
        this.wnn = (TextView) findViewById(a.g.hdf);
        this.vqz.setHint(bg.ap(getIntent().getStringExtra("key_hint"), ""));
        this.vqz.append(bg.ap(getIntent().getStringExtra("key_value"), ""));
        this.gMU = getIntent().getIntExtra("key_max_count", -1) << 1;
        this.jYc = 0;
        this.wno = Math.max(this.gMU - 120, (this.gMU * 9) / 10);
        this.wnp = getIntent().getBooleanExtra("key_nullable", false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MMTextInputUI wnq;

            {
                this.wnq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.wnq.goBack();
                return false;
            }
        });
        a(0, getString(k.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ MMTextInputUI wnq;

            {
                this.wnq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.wnq.v(this.wnq.vqz.getText());
                Intent intent = new Intent();
                intent.putExtra("key_result", this.wnq.vqz.getText());
                this.wnq.setResult(-1, intent);
                this.wnq.finish();
                return true;
            }
        }, b.uTY);
        kr(this.wnp);
        if (!this.wnp || this.gMU > 0) {
            this.vqz.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ MMTextInputUI wnq;

                {
                    this.wnq = r1;
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    boolean z = false;
                    String obj = editable.toString();
                    if (!this.wnq.wnp) {
                        if (obj.trim().length() > 0) {
                            this.wnq.kr(true);
                        } else {
                            this.wnq.kr(false);
                        }
                    }
                    if (this.wnq.gMU > 0) {
                        this.wnq.jYc = 0;
                        for (int i = 0; i < obj.length(); i++) {
                            if (bg.f(obj.charAt(i))) {
                                this.wnq.jYc = this.wnq.jYc + 2;
                            } else {
                                this.wnq.jYc = this.wnq.jYc + 1;
                            }
                        }
                        if (this.wnq.jYc >= this.wnq.wno && this.wnq.jYc <= this.wnq.gMU) {
                            this.wnq.kr(true);
                            this.wnq.wnn.setVisibility(0);
                            this.wnq.wnn.setTextColor(this.wnq.getResources().getColor(d.hbC));
                            this.wnq.wnn.setText(this.wnq.getString(k.hbC, new Object[]{Integer.valueOf((this.wnq.gMU - this.wnq.jYc) >> 1)}));
                        } else if (this.wnq.jYc > this.wnq.gMU) {
                            this.wnq.kr(false);
                            this.wnq.wnn.setVisibility(0);
                            this.wnq.wnn.setTextColor(this.wnq.getResources().getColor(d.hbD));
                            this.wnq.wnn.setText(this.wnq.getString(k.hfq, new Object[]{Integer.valueOf(((this.wnq.jYc - this.wnq.gMU) >> 1) + 1)}));
                        } else {
                            MMTextInputUI mMTextInputUI = this.wnq;
                            if (this.wnq.wnp) {
                                z = true;
                            } else if (this.wnq.jYc > 0) {
                                z = true;
                            }
                            mMTextInputUI.kr(z);
                            this.wnq.wnn.setVisibility(8);
                        }
                    }
                }
            });
        }
    }

    public void v(CharSequence charSequence) {
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
}
