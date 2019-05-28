package com.lq.ren.base.ui.reg;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Author lqren on 17/9/14.
 */

public class RegisterHub {

    private final List<Register> registerHub = new ArrayList<>();

    public void add(@NonNull Register register) {
        registerHub.add(register);
    }

    public void clear() {
        for (Register register : registerHub) {
            if (!register.isClear()) {
                register.clear();
            }
        }
        registerHub.clear();
    }
}
