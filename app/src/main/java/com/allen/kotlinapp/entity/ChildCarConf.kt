package com.anpxd.ewalker.bean

import com.anpxd.ewalker.adapter.ConfAdapter
import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 *  Creator : GG
 *  Time    : 2017/11/24
 *  Mail    : gg.jin.yu@gmail.com
 *  Explain :
 */
data class ChildCarConf(
        var confId: Int? = 0, //1001
        var confName: String? = "", //手动车窗
        var confSeq: Int? = 0, //1
        var confKey: String? = "",
        var confParentId: Int? = 0, //1
        var selectedState: Boolean? = false //false
) : MultiItemEntity {

    override fun getItemType(): Int = ConfAdapter.TYPE_LEVEL_1

}