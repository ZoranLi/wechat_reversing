package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.bi.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.MMEditText;

public final class n {
    private Context mContext;
    private StringBuilder sKO;
    private SpannableStringBuilder sKP = new SpannableStringBuilder();
    private SpannableString sKQ;
    private SpannableStringBuilder sKR = new SpannableStringBuilder();
    private CharacterStyle sKS = new ForegroundColorSpan(-5066062);
    private int sKT;
    private int sKU;
    public int sKV = 3;

    public n(Context context) {
        this.mContext = context;
    }

    public final void a(MMEditText mMEditText, String str, boolean z) {
        if (mMEditText != null) {
            if (this.sKO == null) {
                throw new IllegalStateException("You should saveHistory before setText");
            }
            int length = this.sKT + str.length();
            this.sKP.clear();
            this.sKR.clear();
            if (z) {
                CharSequence charSequence;
                this.sKQ = g.bKH().d(this.mContext, this.sKO.subSequence(0, this.sKT), mMEditText.getTextSize());
                SpannableStringBuilder append = this.sKP.append(this.sKQ);
                SpannableStringBuilder spannableStringBuilder = this.sKR;
                if (spannableStringBuilder == null || str == null || str.length() == 0) {
                    charSequence = spannableStringBuilder;
                } else {
                    int length2;
                    int i;
                    if (str.length() < this.sKV) {
                        length2 = str.length();
                        i = 0;
                    } else {
                        length2 = str.length();
                        i = length2 - this.sKV;
                    }
                    spannableStringBuilder.append(str).setSpan(this.sKS, i, length2, 33);
                    Object obj = spannableStringBuilder;
                }
                append.append(charSequence).append(this.sKO.subSequence(this.sKU, this.sKO.length()));
            } else {
                this.sKQ = g.bKH().d(this.mContext, str, mMEditText.getTextSize());
                this.sKP.append(this.sKQ);
            }
            w.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", Integer.valueOf(this.sKT), Integer.valueOf(this.sKU), Integer.valueOf(length), Integer.valueOf(this.sKP.length()), str, this.sKP);
            mMEditText.setText(this.sKP);
            if (length > this.sKP.length()) {
                return;
            }
            if (length == 0) {
                mMEditText.setSelection(this.sKP.length());
            } else {
                mMEditText.setSelection(length);
            }
        }
    }

    public final void a(MMEditText mMEditText) {
        if (mMEditText != null) {
            this.sKV = 0;
            this.sKQ = g.bKH().d(this.mContext, mMEditText.getText().toString(), mMEditText.getTextSize());
            w.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", this.sKQ);
            mMEditText.setText(this.sKQ);
            mMEditText.setSelection(this.sKQ.length());
        }
    }

    public final void b(MMEditText mMEditText) {
        if (mMEditText != null) {
            this.sKT = mMEditText.getSelectionStart();
            this.sKU = mMEditText.getSelectionEnd();
            this.sKO = new StringBuilder(mMEditText.getText());
            w.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", Integer.valueOf(this.sKT), Integer.valueOf(this.sKU), this.sKO);
            if (mMEditText.getText().toString().equalsIgnoreCase("")) {
                this.sKP.clear();
            }
        }
    }
}
