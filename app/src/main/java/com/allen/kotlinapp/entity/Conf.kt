package com.anpxd.ewalker.bean

import com.anpxd.ewalker.adapter.ConfAdapter
import com.chad.library.adapter.base.entity.AbstractExpandableItem
import com.chad.library.adapter.base.entity.MultiItemEntity


/**
 *  Creator : GG
 *  Time    : 2017/11/24
 *  Mail    : gg.jin.yu@gmail.com
 *  Explain :
 */

data class Conf(
        var confId: Int? = 0, //1
        var confName: String? = "", //车窗配置
        var childCarConf: List<ChildCarConf?>? = listOf(),
        var confSeq: Int? = 0, //1
       var confParentId: Int? = 0, //0
       var selectedState: Boolean? = false //false
) : AbstractExpandableItem<ChildCarConf>(), MultiItemEntity {

    override fun getLevel(): Int = ConfAdapter.TYPE_LEVEL_0

    override fun getItemType(): Int = 0
}

