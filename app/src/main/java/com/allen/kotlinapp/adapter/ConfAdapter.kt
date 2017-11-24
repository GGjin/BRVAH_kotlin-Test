package com.anpxd.ewalker.adapter

import android.util.Log
import com.allen.kotlinapp.R
import com.anpxd.ewalker.bean.ChildCarConf
import com.anpxd.ewalker.bean.Conf
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 *  Creator : GG
 *  Time    : 2017/11/24
 *  Mail    : gg.jin.yu@gmail.com
 *  Explain :
 */
class ConfAdapter(data: ArrayList<MultiItemEntity>) : BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder>(data) {

    init {
        addItemType(TYPE_LEVEL_0, R.layout.item_conf_type1)
        addItemType(TYPE_LEVEL_1, R.layout.item_conf_type2)
    }

    override fun convert(helper: BaseViewHolder, item: MultiItemEntity) {
        when (helper.itemViewType) {
            TYPE_LEVEL_0 -> {
                val conf = item as Conf
                helper.setText(R.id.title, conf.confName)
                helper.itemView.setOnClickListener {
                    val pos = helper.adapterPosition
                    Log.w("adapter","--->"+pos+"----->"+conf.isExpanded)
                    if (conf.isExpanded) {
                        collapse(pos)
                    } else {
                        expand(pos)
                    }
                }
            }
            TYPE_LEVEL_1 -> {
                val childCarConf = item as ChildCarConf
                helper.setText(R.id.subtitle, childCarConf.confName)

                if (childCarConf.selectedState!!) {
                    helper.setImageResource(R.id.status, R.drawable.ic_select)
                } else {
                    helper.setImageResource(R.id.status, R.drawable.ic_unselect)
                }

            }
        }

    }

    companion object {

        val TYPE_LEVEL_0 = 0
        val TYPE_LEVEL_1 = 1
    }

}