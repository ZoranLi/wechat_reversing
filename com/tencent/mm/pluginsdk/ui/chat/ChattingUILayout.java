package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

public class ChattingUILayout extends BasePanelKeybordLayout {
    private ChatFooterBottom sQk;

    public ChattingUILayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private ChatFooterBottom i(ViewGroup viewGroup) {
        if (this.sQk != null) {
            return this.sQk;
        }
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return this.sQk;
        }
        int i = 0;
        while (i < viewGroup.getChildCount()) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ChatFooterBottom) {
                this.sQk = (ChatFooterBottom) childAt;
                return this.sQk;
            } else if ((childAt instanceof ViewGroup) && i((ViewGroup) childAt) != null) {
                return this.sQk;
            } else {
                i++;
            }
        }
        return this.sQk;
    }

    protected final List<View> aIM() {
        List<View> arrayList = new ArrayList();
        arrayList.add(i(this));
        return arrayList;
    }
}
