package com.tencent.mm.plugin.emoji.ui.widget;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class MMCopiableTextView extends EditText implements OnLongClickListener {
    private final String TAG = "MicroMsg.MMCopiableTextView";
    private int kTH;
    private int kZM;

    public MMCopiableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMCopiableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOnLongClickListener(this);
        setLongClickable(true);
    }

    protected void onCreateContextMenu(ContextMenu contextMenu) {
    }

    protected boolean getDefaultEditable() {
        return false;
    }

    public boolean onLongClick(View view) {
        String obj = getEditableText().toString();
        if (!bg.mA(obj) && this.kTH > 0 && this.kZM > 0 && this.kZM > this.kTH) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setText(obj.substring(this.kTH, this.kZM).trim());
                w.i("MicroMsg.MMCopiableTextView", "copy text :%s", new Object[]{clipboardManager.getText()});
            }
            Toast.makeText(getContext(), R.l.dGy, 0).show();
        }
        return false;
    }
}
