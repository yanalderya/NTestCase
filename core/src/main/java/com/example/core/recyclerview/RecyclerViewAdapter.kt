package com.example.core.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter constructor(
    val items: MutableList<DisplayItem> = ArrayList(),
    private val selectedItems: MutableList<DisplayItem> = ArrayList(),
    private val itemComperator: DisplayItemComperator,
    private val viewHolderFactoryMap: Map<Int, ViewHolderFactory>,
    private val viewBinderFactoryMap: Map<Int, ViewHolderBinder>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), DiffAdapter, SelectionAdapter {

    var itemClickListener: ((item: DisplayItem, position: Int) -> Unit)? = null

    var itemLongClickListener: ((item: DisplayItem, position: Int) -> Boolean)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return viewHolderFactoryMap[viewType]?.createViewHolder(parent)!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        viewBinderFactoryMap[items[position].type]?.bind(holder, items[position])
        (holder as ViewHolder<*>).itemClickListener = itemClickListener
        (holder).itemLongClickListener = itemLongClickListener
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].type

    override fun update(newItems: List<DisplayItem>) {
        if (items.isEmpty()) {
            updateAllItems(newItems)
        }
    }

    override fun updateAllItems(newItems: List<DisplayItem>) {
        updateItems(newItems)
        notifyDataSetChanged()
    }

    override fun updateItems(newItems: List<DisplayItem>) {
        items.run {
            clear()
            addAll(newItems)
            notifyDataSetChanged()
        }
    }

    override fun calculateDiff(newItems: List<DisplayItem>): DiffUtil.DiffResult =
        DiffUtil.calculateDiff(
            DiffUtilImpl(
                items,
                newItems,
                itemComperator
            )
        )

    override fun updateWithOnlyDiffResult(result: DiffUtil.DiffResult) {
        result.dispatchUpdatesTo(this)
    }

    override fun select(pos: Int) {
        val item = items[pos]
        if (selectedItems.contains(item)) {
            selectedItems.remove(item)
            if (item is SelectableItem) {
                item.isSelected = false
            }
        } else {
            selectedItems.add(item)
            if (item is SelectableItem) {
                item.isSelected = true
            }
        }
        notifyItemChanged(pos)
    }

    override fun clear() {
        for (item in items) {
            if (item is SelectableItem) {
                item.isSelected = false
            }
        }
        selectedItems.clear()
        notifyDataSetChanged()
    }

    override fun getSelectedItemCount(): Int = selectedItems.size

    override fun getSelectedItems(): List<DisplayItem> = selectedItems

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        (holder as ViewHolder<*>).onAttachAdapter()
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        (holder as ViewHolder<*>).onDetachAdapter()
    }
}
