package com.allen.kotlinapp

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.allen.kotlinapp.adapter.ExpandableItemAdapter
import com.allen.kotlinapp.base.BaseActivity
import com.allen.kotlinapp.entity.Level0Item
import com.allen.kotlinapp.entity.Level1Item
import com.allen.kotlinapp.entity.Person
import com.anpxd.ewalker.adapter.ConfAdapter
import com.anpxd.ewalker.bean.ChildCarConf
import com.anpxd.ewalker.bean.Conf
import com.chad.library.adapter.base.entity.MultiItemEntity
import java.util.*
import kotlin.collections.ArrayList

/**
 * 文 件 名: ExpandableUseActivity
 * 创 建 人: Allen
 * 创建日期: 2017/6/20 11:10
 * 修改时间：
 * 修改备注：
 */
class ExpandableUseActivity : BaseActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var adapter: ExpandableItemAdapter
    private lateinit var list: ArrayList<MultiItemEntity>

    private lateinit var mAdapter: ConfAdapter

    private val data: ArrayList<MultiItemEntity> by lazy {
        arrayListOf(Conf().apply {
            confName = "车窗配置"
        }, ChildCarConf().apply {
            confName = "电动车窗"
        }, ChildCarConf().apply {
            confName = "电动车窗"
        }, ChildCarConf().apply {
            confName = "电动车窗"
        }, ChildCarConf().apply {
            confName = "电动车窗"
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("ExpandableItem Activity")
        setContentView(R.layout.activity_expandable_item_use)

        mRecyclerView = findViewById(R.id.rv) as RecyclerView

        list = generateData()
        adapter = ExpandableItemAdapter(list)

        mAdapter = ConfAdapter(data)

        val manager = GridLayoutManager(this, 3)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (adapter.getItemViewType(position) == ExpandableItemAdapter.TYPE_PERSON) 1 else manager.spanCount
            }
        }

        mRecyclerView.adapter = mAdapter
//        mRecyclerView.adapter = adapter
        // important! setLayoutManager should be called after setAdapter
        mRecyclerView.layoutManager = manager
//        adapter.expandAll()
        mAdapter.expandAll()
    }

    private fun generateData(): ArrayList<MultiItemEntity> {
        val lv0Count = 9
        val lv1Count = 3
        val personCount = 5

        val nameList = arrayOf("Bob", "Andy", "Lily", "Brown", "Bruce")
        val random = Random()

        val res = ArrayList<MultiItemEntity>()
        for (i in 0..lv0Count - 1) {
            val lv0 = Level0Item("This is " + i + "th item in Level 0", "subtitle of " + i)
            for (j in 0..lv1Count - 1) {
                val lv1 = Level1Item("Level 1 item: " + j, "(no animation)")
                for (k in 0..personCount - 1) {
                    lv1.addSubItem(Person(nameList[k], random.nextInt(40)))
                }
                lv0.addSubItem(lv1)
            }
            res.add(lv0)
        }
        return res
    }
}
