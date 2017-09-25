package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public class VoiceSearchEditText extends EditText {
    private Context context;
    public String jwX = "";
    private OnClickListener sAw;
    final Drawable vpY = getResources().getDrawable(f.hbY);
    final Drawable vpZ = null;
    final Drawable vqa = getResources().getDrawable(f.hbQ);
    private boolean vqb = true;
    private boolean vqc = false;
    private boolean vqd = false;

    static /* synthetic */ void e(VoiceSearchEditText voiceSearchEditText) {
        w.d("MicroMsg.VoiceSearchEditText", "checkView");
        if (voiceSearchEditText.getText().toString().equals("") && voiceSearchEditText.vqc) {
            voiceSearchEditText.vqb = true;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.vpZ, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.vpY, voiceSearchEditText.getCompoundDrawables()[3]);
        } else if (voiceSearchEditText.getText().toString().length() > 0) {
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.vpZ, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.vqa, voiceSearchEditText.getCompoundDrawables()[3]);
        } else {
            voiceSearchEditText.vqb = false;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.vpZ, voiceSearchEditText.getCompoundDrawables()[1], null, voiceSearchEditText.getCompoundDrawables()[3]);
        }
    }

    public VoiceSearchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoiceSearchEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        this.vqc = false;
        this.vpY.setBounds(0, 0, this.vpY.getIntrinsicWidth(), this.vpY.getIntrinsicHeight());
        this.vqa.setBounds(0, 0, this.vqa.getIntrinsicWidth(), this.vqa.getIntrinsicHeight());
        this.vqb = true;
        if (this.vqc) {
            setCompoundDrawables(this.vpZ, getCompoundDrawables()[1], this.vpY, getCompoundDrawables()[3]);
        } else if (getText().toString().length() > 0) {
            setCompoundDrawables(this.vpZ, getCompoundDrawables()[1], this.vqa, getCompoundDrawables()[3]);
        } else {
            setCompoundDrawables(this.vpZ, getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        }
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ VoiceSearchEditText vqe;

            {
                this.vqe = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                View view2 = this.vqe;
                if (view2.getCompoundDrawables()[2] == null) {
                    return false;
                }
                if (motionEvent.getAction() != 1) {
                    return true;
                }
                this.vqe.vqd = true;
                if (this.vqe.vqb && this.vqe.vqc && view2.getText().toString().equals("")) {
                    if (motionEvent.getX() <= ((float) (((view2.getWidth() - view2.getPaddingRight()) - this.vqe.vpY.getIntrinsicWidth()) - a.fromDPToPix(view2.context, 25)))) {
                        view2.requestFocus();
                        if (this.vqe.getContext() instanceof Activity) {
                            MMActivity.O((Activity) this.vqe.getContext());
                        }
                        if (this.vqe.sAw != null) {
                            this.vqe.sAw.onClick(null);
                        }
                    } else if (this.vqe.sAw != null) {
                        w.i("MicroMsg.VoiceSearchEditText", "user clicked voice button");
                        if (this.vqe.getContext() instanceof MMActivity) {
                            ((MMActivity) this.vqe.getContext()).cY(view2);
                        }
                        this.vqe.sAw.onClick(this.vqe);
                        return true;
                    }
                } else if (view2.getText().toString().length() > 0) {
                    if (motionEvent.getX() > ((float) (((view2.getWidth() - view2.getPaddingRight()) - this.vqe.vqa.getIntrinsicWidth()) - a.fromDPToPix(view2.context, 25)))) {
                        view2.setText("");
                        VoiceSearchEditText.e(this.vqe);
                    } else if (!view2.isFocused()) {
                        view2.requestFocus();
                        if (this.vqe.getContext() instanceof Activity) {
                            MMActivity.O((Activity) this.vqe.getContext());
                        }
                    }
                } else if (this.vqe.sAw != null) {
                    this.vqe.sAw.onClick(null);
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ VoiceSearchEditText vqe;

            {
                this.vqe = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.vqe.vqd = true;
                VoiceSearchEditText.e(this.vqe);
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ VoiceSearchEditText vqe;

            {
                this.vqe = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                w.d("MicroMsg.VoiceSearchEditText", "onFocusChange hasFocus = [%s], currentFocusState = [%s]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.vqe.vqd)});
                if (!z && this.vqe.vqd) {
                    VoiceSearchEditText.e(this.vqe);
                    this.vqe.vqd = false;
                }
            }
        });
        if (context instanceof Activity) {
            View currentFocus = ((Activity) context).getCurrentFocus();
            if (currentFocus == null || currentFocus != this) {
                this.vqd = false;
            } else {
                this.vqd = true;
            }
        }
        requestFocus();
    }
}
