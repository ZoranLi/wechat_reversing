package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.w;

public class AutoMatchKeywordEditText extends MMEditText {
    public a wsl;
    private int wsm;
    private int wsn;

    public interface a {
        void a(EditText editText, int i, int i2);
    }

    public AutoMatchKeywordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public AutoMatchKeywordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.wsm = getSelectionStart();
        this.wsn = getSelectionEnd();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (this.wsm != selectionStart || this.wsn != selectionEnd) {
            this.wsm = selectionStart;
            this.wsn = selectionEnd;
            if (this.wsl != null) {
                this.wsl.a(this, getSelectionStart(), getSelectionEnd());
            }
        }
    }

    public void setSelection(int i) {
        w.d("MicroMsg.AutoMatchKeywordEditText", "setSelection");
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setSelection(i);
        this.wsm = getSelectionStart();
        this.wsn = getSelectionEnd();
        if ((selectionStart != getSelectionStart() || selectionEnd != getSelectionEnd()) && this.wsl != null) {
            this.wsl.a(this, getSelectionStart(), getSelectionEnd());
        }
    }

    public void setSelection(int i, int i2) {
        w.d("MicroMsg.AutoMatchKeywordEditText", "setSelection.");
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setSelection(i, i2);
        this.wsm = getSelectionStart();
        this.wsn = getSelectionEnd();
        if ((selectionStart != getSelectionStart() || selectionEnd != getSelectionEnd()) && this.wsl != null) {
            this.wsl.a(this, getSelectionStart(), getSelectionEnd());
        }
    }

    public void extendSelection(int i) {
        w.d("MicroMsg.AutoMatchKeywordEditText", "extendSelection");
        super.extendSelection(i);
        this.wsm = getSelectionStart();
        this.wsn = getSelectionEnd();
    }

    public boolean moveCursorToVisibleOffset() {
        w.d("MicroMsg.AutoMatchKeywordEditText", "moveCursorToVisibleOffset");
        return super.moveCursorToVisibleOffset();
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        w.d("MicroMsg.AutoMatchKeywordEditText", "performAccessibilityAction");
        return super.performAccessibilityAction(i, bundle);
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        w.d("MicroMsg.AutoMatchKeywordEditText", "onDragEvent");
        return super.onDragEvent(dragEvent);
    }
}
