package test.OtherTest;

public class JavaBean {

    /**
     * categoryId : 1
     * categoryName : 饮品
     * categoryImage : /upload/yinpin.jpg
     */

    private int categoryId;
    private String categoryName;
    private String categoryImage;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }
}
