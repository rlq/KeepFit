package com.lq.ren.base.ui.reg

import java.util.ArrayList

/**
 * Author lqren on 17/9/14.
 */

class RegisterHub {

    private val registerHub = ArrayList<Register>()

    fun add(register: Register) {
        registerHub.add(register)
    }

    fun clear() {
        for (register in registerHub) {
            if (!register.isClear) {
                register.clear()
            }
        }
        registerHub.clear()
    }
}
