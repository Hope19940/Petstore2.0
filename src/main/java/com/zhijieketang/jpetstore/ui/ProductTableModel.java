//ProductTableModel.java文件
package com.zhijieketang.jpetstore.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import com.zhijieketang.jpetstore.domain.Product;

//商品列表表格模型
public class ProductTableModel extends AbstractTableModel {

    // 表格列名columnNames
    private String[] columnNames = {"商品编号", "商品类别", "商品中文名", "商品英文名"};

    // 表格中的数据内容保存在List集合中
    private List<Product> data = null;

    public ProductTableModel(List<Product> data) {
        this.data = data;
    }

    // 返回列数
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    // 返回行数
    @Override
    public int getRowCount() {
        return data.size();
    }

    // 获得某行某列的数据，而数据保存在对象数组data中
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        // 每一行就是一个Product商品对象
        Product p = data.get(rowIndex);

        // 第一列商品编号
        // 第二列商品类别
        // 第三列商品中文名
        // 第四列商品英文名
        switch (columnIndex) {
            case 0:
                return p.getProductid();
            case 1:
                return p.getCategory();
            case 2:
                return p.getCname();
            default:
                return p.getEname();
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}
