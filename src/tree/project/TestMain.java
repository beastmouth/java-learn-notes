package tree.project;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/4/24 21:35
 */
public class TestMain {
    public static void main(String[] args) {
        // 开始时间戳
        long begin = System.currentTimeMillis();
        // 构建一个list
        List<Category> categories = buildListSample2();
        // 需要删除的CategoryList
        List<Category> needDelete;
        // 删除2及其他的子节点(获取他们的ID)
        needDelete = queryKids(categories, new ArrayList<>(), 2, 2);
        if (!needDelete.isEmpty()) {
            needDelete.forEach(System.out::println);
        }
        // 结束时间戳
        long end = System.currentTimeMillis();
        System.out.println((end - begin) / 1000f);
    }

    public static List<Category> queryKids(List<Category> sourceList, List<Category> resultList, Integer id, Integer level) {
        // 此次查询的临时列表
        List<Category> tempQuery = new ArrayList<>();
        // 没有源列表 直接返回结果
        if (sourceList.isEmpty()) {
            return resultList;
        }
        sourceList.forEach(category -> {
            // 当前查询节点的子节点
            if (category.getLevel() == level + 1 && id.equals(category.getpId())) {
                resultList.add(category);
                tempQuery.add(category);
            }
        });
        // 将当前查询节点的子节点从查询列表中删除
        sourceList.removeIf(category -> level.equals(category.getLevel()) && id.equals(category.getpId()));
        // 如果当前查询节点有子节点的话
        if (!tempQuery.isEmpty()) {
            // 递归查询
            tempQuery.forEach(kidCategory -> {
                System.out.println("This time query is " + kidCategory.getId());
                queryKids(sourceList, resultList, kidCategory.getId(), kidCategory.getLevel());
            });
        }
        // 返回结果
        return resultList;
    }


    public static List<Category> buildListSample1() {
        // 根节点 0
        Category category5 = new Category(5, 2, 0, 3);
        Category category6 = new Category(6, 2, 0, 3);
        Category category7 = new Category(7, 6, 0, 4);
        Category category8 = new Category(8, 6, 0, 4);
        Category category9 = new Category(9, 3, 0, 3);
        Category category10 = new Category(10, 3, 0, 3);
        List<Category> categories = new ArrayList<>();
        categories.add(category5);
        categories.add(category6);
        categories.add(category7);
        categories.add(category8);
        categories.add(category9);
        categories.add(category10);
        return categories;
    }

    public static List<Category> buildListSample2() {
        // 根节点 0
        Category category5 = new Category(5, 2, 0, 3);
        Category category6 = new Category(6, 2, 0, 3);
        Category category7 = new Category(7, 2, 0, 3);
        Category category8 = new Category(8, 3, 0, 3);
        Category category9 = new Category(9, 3, 0, 3);
        Category category10 = new Category(10, 4, 0, 3);
        Category category11 = new Category(11, 6, 0, 4);
        Category category12 = new Category(12, 6, 0, 4);
        Category category13 = new Category(13, 7, 0, 4);
        Category category14 = new Category(14, 7, 0, 4);
        Category category15 = new Category(14, 9, 0, 4);
        Category category16 = new Category(15, 9, 0, 4);
        Category category17 = new Category(16, 12, 0, 5);
        Category category18 = new Category(17, 12, 0, 5);
        List<Category> categories = new ArrayList<>();
        categories.add(category5);
        categories.add(category6);
        categories.add(category7);
        categories.add(category8);
        categories.add(category9);
        categories.add(category10);
        categories.add(category11);
        categories.add(category12);
        categories.add(category13);
        categories.add(category14);
        categories.add(category15);
        categories.add(category16);
        categories.add(category17);
        categories.add(category18);
        return categories;
    }

}
