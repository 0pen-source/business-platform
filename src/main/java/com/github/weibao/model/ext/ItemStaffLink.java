package com.github.weibao.model.ext;

/**
 * @Create 16/1/27,下午3:49
 * @Author dongzhukai
 */
public class ItemStaffLink {
    private int itemId;
    private int staffId;

    public ItemStaffLink(int itemId, int staffId) {
        this.itemId = itemId;
        this.staffId = staffId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
}
