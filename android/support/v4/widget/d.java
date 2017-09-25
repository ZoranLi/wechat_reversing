package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

final class d {
    private static Field Bf;
    private static boolean Bg;

    static Drawable a(CompoundButton compoundButton) {
        if (!Bg) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                Bf = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            Bg = true;
        }
        if (Bf != null) {
            try {
                return (Drawable) Bf.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Bf = null;
            }
        }
        return null;
    }
}
